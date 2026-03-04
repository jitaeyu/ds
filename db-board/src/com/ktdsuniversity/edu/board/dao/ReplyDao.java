package com.ktdsuniversity.edu.board.dao;

import java.util.ArrayList;
import java.util.List;

import com.ktdsuniversity.edu.board.dao.query.ReplyQuery;
import com.ktdsuniversity.edu.board.db.helper.DataAccessHelper;
import com.ktdsuniversity.edu.board.db.helper.SQLType;
import com.ktdsuniversity.edu.board.vo.ReplyVO;

/* Dao : Data Access Object 
 *  Java에서 DB로 데이터 생성 수정 삭제 조회를 하기위한 클래스
 *  */
//void 댓글 등록(ReplyVO)
public class ReplyDao {
	DataAccessHelper dah;
	public ReplyDao(DataAccessHelper dah) {
		this.dah=dah;
	}

	public void insertReply(ReplyVO reply) {
		DataAccessHelper dah = new DataAccessHelper("localhost", 1521, "XE", "BOARD", "BOARD");
		try {
			dah.preparedStatement(ReplyQuery.insertReply(), (pstmt) ->{
				pstmt.setString(1, reply.getBoardId());
				pstmt.setString(2, reply.getContent());
			});
			dah.executeQuery(SQLType.INSERT, null);
			dah.commit();
		} catch (RuntimeException re) {
			dah.rollback();
			System.out.println(re.getMessage());
		}
		finally {
			dah.close();
		}
	}
	
	//void 댓글 삭제(ReplyVO)
	public void deleteRep(String ReplyId) {
		DataAccessHelper dah = new DataAccessHelper("localhost", 1521, "XE", "BOARD", "BOARD");
		try {
			dah.preparedStatement(ReplyQuery.deleteReply(), (pstmt) ->{
				pstmt.setString(1, ReplyId);
			});
			dah.executeQuery(SQLType.DELETE, null);
			dah.commit();
		} catch (RuntimeException re) {
			dah.rollback();
			System.out.println(re.getMessage());
		}
		finally {
			dah.close();
		}
	}

	// 게시글에 등록된 모든 댓글 조회(대댓글포함) - 계층 조회!!
	public List<ReplyVO> selectAllReply() {
		DataAccessHelper dah = new DataAccessHelper("localhost", 1521, "XE", "BOARD", "BOARD");
		try {
			dah.preparedStatement(ReplyQuery.selectAllReplyByLevel(), (pstmt) ->{
			});
			List<ReplyVO> result = new ArrayList<>();
			dah.executeQuery(SQLType.SELECT, rs->{
				ReplyVO repv = new ReplyVO();
				repv.setId(rs.getString("ID"));
				repv.setBoardId(rs.getString("BOARD_ID"));
				repv.setTopId(rs.getString("TOP_ID"));
				repv.setContent(rs.getString("CONTENT"));
				repv.setWriteDate(rs.getString("WRITE_DATE"));
				result.add(repv);
			});
			dah.commit();
			return result;
		} catch (RuntimeException re) {
			dah.rollback();
			System.out.println(re.getMessage());
		}
		finally {
			dah.close();
		}
		return null;
	}
	// List<ReplyVO> 대댓글 조회(대댓글 포함) - 계층조회!
	public List<ReplyVO> selectAllSubReply(){
			DataAccessHelper dah = new DataAccessHelper("localhost", 1521, "XE", "BOARD", "BOARD");
					try {
						List<ReplyVO> result = new ArrayList<>();
						dah.preparedStatement(ReplyQuery.selectOnlySubReply(),null);
						dah.executeQuery(SQLType.SELECT, rs->{
							ReplyVO repv = new ReplyVO();
							repv.setId(rs.getString("ID"));
							repv.setBoardId(rs.getString("BOARD_ID"));
							repv.setTopId(rs.getString("TOP_ID"));
							repv.setContent(rs.getString("CONTENT"));
							repv.setWriteDate(rs.getString("WRITE_DATE"));
							result.add(repv);
						});
						dah.commit();
						return result;
					} catch (RuntimeException re) {
						dah.rollback();
						System.out.println(re.getMessage());
					}
					finally {
						dah.close();
					}
					return null;
	}


	//void 댓글 수정(ReplyVO)
	public void modifyReply(ReplyVO modifyReply) {
		DataAccessHelper dah = new DataAccessHelper("localhost", 1521, "XE", "BOARD", "BOARD");
		try {
			dah.preparedStatement(ReplyQuery.updateReply(), (pstmt) ->{
				pstmt.setString(1, modifyReply.getContent());
				pstmt.setString(2, modifyReply.getId());
			});
			dah.executeQuery(SQLType.UPDATE, null);
			dah.commit();
			
		} catch (RuntimeException re) {
			dah.rollback();
			System.out.println(re.getMessage());
		}
		finally {
			dah.close();
		}
	}

	//List<ReplyVO> 댓글 목록 조회(게시글 아이디)
	public List<ReplyVO> replyListId(String BoardId){
		DataAccessHelper dah = new DataAccessHelper("localhost", 1521, "XE", "BOARD", "BOARD");
				try {
					dah.preparedStatement(ReplyQuery.selectBoardIdReply(), (pstmt) ->{
						pstmt.setString(1, BoardId);
					});
					List<ReplyVO> result = new ArrayList<>();
					dah.executeQuery(SQLType.SELECT, rs->{
						ReplyVO repv = new ReplyVO();
						repv.setId(rs.getString("ID"));
						repv.setBoardId(rs.getString("BOARD_ID"));
						repv.setTopId(rs.getString("TOP_ID"));
						repv.setContent(rs.getString("CONTENT"));
						repv.setWriteDate(rs.getString("WRITE_DATE"));
						result.add(repv);
					});
					dah.commit();
					return result;
				} catch (RuntimeException re) {
					dah.rollback();
					System.out.println(re.getMessage());
				}
				finally {
					dah.close();
				}
				return null;
	}
	// ReplyVO 댓글 조회(댓글 아이디)
	public ReplyVO replyOneselect(String ReplyId){
		DataAccessHelper dah = new DataAccessHelper("localhost", 1521, "XE", "BOARD", "BOARD");
				try {
					dah.preparedStatement(ReplyQuery.selectOneReply(), (pstmt) ->{
						pstmt.setString(1, ReplyId);
					});
					ReplyVO result = new ReplyVO();
					dah.executeQuery(SQLType.SELECT, rs->{
						result.setId(rs.getString("ID"));
						result.setBoardId(rs.getString("BOARD_ID"));
						result.setTopId(rs.getString("TOP_ID"));
						result.setContent(rs.getString("CONTENT"));
						result.setWriteDate(rs.getString("WRITE_DATE"));
					});
					dah.commit();
					return result;
				} catch (RuntimeException re) {
					dah.rollback();
					System.out.println(re.getMessage());
				}
				finally {
					dah.close();
				}
				return null;
	}
}
