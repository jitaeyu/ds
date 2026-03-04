package com.ktdsuniversity.edu.board;

import java.util.List;

import com.ktdsuniversity.edu.board.dao.BoardDao;
import com.ktdsuniversity.edu.board.dao.ReplyDao;
import com.ktdsuniversity.edu.board.db.helper.DataAccessHelper;
import com.ktdsuniversity.edu.board.service.BoardService;
import com.ktdsuniversity.edu.board.service.ReplyService;
import com.ktdsuniversity.edu.board.vo.BoardVO;
import com.ktdsuniversity.edu.board.vo.ReplyVO;

public class TestMain {

	public static void main(String[] args) {
		long now = System.currentTimeMillis();
		//게시글 작성(DB게시글 생성)'
		BoardVO newArticle = new BoardVO();
		newArticle.setTitle("새로운 게시글 입니다.");
		newArticle.setContent("새로운 게시글의 내용입니다");
		DataAccessHelper dah = new DataAccessHelper("localhost", 1521, "XE", "BOARD", "BOARD");
		BoardService boardService = new BoardService(dah);
//		int insertCount = 
		boardService.createNewArticle2(newArticle);
//		System.out.println(insertCount+"개의 게시글이 생성되었습니다");
		System.out.println("개의 게시글이 생성되었습니다");
		
		BoardVO modifyArticle = new BoardVO();
		modifyArticle.setId("BO-20260303-000002");
		modifyArticle.setTitle("제목이 수정되었습니다");
		modifyArticle.setContent("내용이 수정되었습니다.");
		
		boardService.modifyArticle(modifyArticle);
		
		boardService.deleteArticle("BO-20260303-000002");
		
		BoardVO article = boardService.readArticle("BO-20260303-000034");
		System.out.println(article);
		
		System.out.println(boardService.readAllArticles());
//		댓글조회
		ReplyService replyService = new ReplyService(dah);
		ReplyVO rep = new ReplyVO();
		rep.setBoardId("BO-20260304-000036");
		rep.setContent("나댓글임");
		replyService.insertReply(rep);
		
		ReplyVO modifyReply = new ReplyVO();
		modifyReply.setId("RP-20260304-000003");
		modifyReply.setContent("바꾼 댓글임");
//		red.modifyReply(modifyReply);
//		red.deleteRep("RP-20260304-000002");

		System.out.println(replyService.replyListId("BO-20260304-000036"));
		System.out.println(replyService.replyOneselect("RP-20260304-000001"));
		
		System.out.println(replyService.selectAllReply());
		System.out.println(replyService.selectAllSubReply());
		dah.close();
		long end = System.currentTimeMillis();
		System.out.println(end-now);
	}


	
}
