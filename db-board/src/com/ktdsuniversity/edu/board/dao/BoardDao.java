package com.ktdsuniversity.edu.board.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ktdsuniversity.edu.board.dao.query.BoardQuery;
import com.ktdsuniversity.edu.board.db.helper.DataAccessHelper;
import com.ktdsuniversity.edu.board.db.helper.SQLType;
import com.ktdsuniversity.edu.board.vo.BoardVO;


/* Dao : Data Access Object 
 *  Java에서 DB로 데이터 생성 수정 삭제 조회를 하기위한 클래스*/
public class BoardDao {
		private DataAccessHelper dah;
		public BoardDao(DataAccessHelper dah) {
			this.dah=dah;
		}
	
		
		
		
	public void createNewArticle2(BoardVO newArticle) {
			this.dah.preparedStatement(BoardQuery.makeInsertQuery(), (pstmt) ->{
				pstmt.setString(1, newArticle.getTitle());
				pstmt.setString(2, newArticle.getContent());
			});
			this.dah.executeQuery(SQLType.INSERT, null);
	}

	public int createNewArticle(BoardVO newArticle) {
		//1. ojdbc.jar 파일이 프로젝트에 존재하는지 확인
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("db접속용 라이브러리가없다");
			return 0;
		}
		// 2. oracle DB접속
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/XE", "BOARD", "BOARD");
			connection.setAutoCommit(false);
		} catch (SQLException e) {
			System.out.println("접속할 계정의 정보가 맞지않습니다");
			System.out.println("사유 : "+ e.getMessage());
			return 0;
		}
		// 3. INSERT Query작성
		StringBuffer query = new StringBuffer();
		query.append(" INSERT INTO BOARD                                                            ");
		query.append(" (ID                                                                          ");
		query.append(" , TITLE                                                                      ");
		query.append(" , CONTENT                                                                    ");
		query.append(" , WRITE_DATE)                                                                ");
		query.append(" VALUES                                                                       ");
		query.append(" ('BO-'||TO_CHAR(SYSDATE, 'YYYYMMDD-') || LPAD(SEQ_BOARD_PK.NEXTVAL,6,'0')     ");
		query.append(" , ?                                                                         ");
		query.append(" , ?                                                                         ");
		query.append(" , SYSDATE)                                                                 ");
		
//		3-1 ?에 데이터 할당하기
		PreparedStatement pstmt = null;
		try {
			pstmt = connection.prepareStatement(query.toString());
			pstmt.setString(1, newArticle.getTitle());
			pstmt.setString(2, newArticle.getContent());
		} catch (SQLException e) {
//			pstmt
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e1) {}
			}
			try {
//				연결된 Connection을 닫는다
				connection.close();
			} catch (SQLException e1) {}
			
//			db와 연결이 끊어져있을때
//			작성된 쿼리의 내용이 잘못되었을때
			System.out.println("쿼리나 연결을 재확인하세요");
			System.out.println("사유: "+e.getMessage());
			return 0;
		}
		// 4. INSERT Query 실행
		int insertCount=0;
		try {
//		Commit 수행
			connection.commit();
			insertCount=pstmt.executeUpdate();

			return insertCount;
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {}
			
			System.out.println("쿼리 실행실패");
			System.out.println("사유: "+e.getMessage());
//			INSERT 쿼리에 파라미터 할당이 잘못되었을때
//			?와 ?에 할당한 파라미터 갯수가 일치하지않거나
//			pk가 중복되었습니다.
//			컬럼의 타입보다 값이 클때 char18인데 char19개가 들어갔을경우
			return 0;
			
			
		}
		finally {
			try {
				pstmt.close();
			} catch (SQLException e) {}
			
			try {
				connection.close();
			} catch (SQLException e) {}
		}
	}

	public void modifyArticle(BoardVO modifyArticle) {
			dah.preparedStatement(BoardQuery.makeUpdateQuery(), (pstmt) ->{
				pstmt.setString(1, modifyArticle.getTitle());
				pstmt.setString(2, modifyArticle.getContent());
				pstmt.setString(3, modifyArticle.getId());
			});
			dah.executeQuery(SQLType.UPDATE, null);
	}

	public void deleteArticle(String articleId) {
			dah.preparedStatement(BoardQuery.makeDeleteQuery(), (pstmt) ->{
				pstmt.setString(1, articleId);
			});
			dah.executeQuery(SQLType.DELETE, null);
	}
	
	
//update => 조회수를 1증가
//makeUpdateViewCountQuery
	public void updateView(String articleId) {
		dah.preparedStatement(BoardQuery.makeUpdateViewCountQuery(), (pstmt) ->{
			pstmt.setString(1, articleId);
		});
		dah.executeQuery(SQLType.UPDATE, null);
		
	}
	public BoardVO readArticle(String articleId) {
//select => 게시글의 내용을 조회
//makeSelectOneQuery
			dah.preparedStatement(BoardQuery.makeSelectOneQuery(), (pstmt) ->{
				pstmt.setString(1, articleId);
			});
			BoardVO result = new BoardVO();
			dah.executeQuery(SQLType.SELECT, rs->{
				result.setId(rs.getString("ID"));
				result.setTitle(rs.getString("TITLE"));
				result.setContent(rs.getString("CONTENT"));
				result.setViewCount(rs.getInt("VIEW_COUNT"));
				result.setWriteDate(rs.getString("WRITE_DATE"));
				result.setLatestModifyDate(rs.getString("LATEST_MODIFY_DATE"));
			});
			return result;
	}
	public List<BoardVO> readAllArticles() {
//update => 조회수를 1증가
//makeUpdateViewCountQuery
//select => 게시글의 내용을 조회
//makeSelectOneQuery
			List<BoardVO> result = new ArrayList<>();
			dah.preparedStatement(BoardQuery.makeSelectAllQuery(), null);
			dah.executeQuery(SQLType.SELECT, rs->{
				BoardVO eachArticle = new BoardVO();
				eachArticle.setId(rs.getString("ID"));
				eachArticle.setTitle(rs.getString("TITLE"));
				eachArticle.setContent(rs.getString("CONTENT"));
				eachArticle.setViewCount(rs.getInt("VIEW_COUNT"));
				eachArticle.setWriteDate(rs.getString("WRITE_DATE"));
				eachArticle.setLatestModifyDate(rs.getString("LATEST_MODIFY_DATE"));
				result.add(eachArticle);
			});
			return result;
	}
}
