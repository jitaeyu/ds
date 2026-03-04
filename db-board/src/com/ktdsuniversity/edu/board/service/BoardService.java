package com.ktdsuniversity.edu.board.service;

import java.util.ArrayList;
import java.util.List;
import com.ktdsuniversity.edu.board.dao.BoardDao;
import com.ktdsuniversity.edu.board.dao.query.BoardQuery;
import com.ktdsuniversity.edu.board.db.helper.DataAccessHelper;
import com.ktdsuniversity.edu.board.db.helper.SQLType;
import com.ktdsuniversity.edu.board.vo.BoardVO;

public class BoardService {
	private DataAccessHelper dah;
	private BoardDao boardDao;
	
	public BoardService(DataAccessHelper dah) {
		this.dah=dah;
		this.boardDao= new BoardDao(this.dah);
	}
	
	public void createNewArticle2(BoardVO newArticle) {
		try {
			this.boardDao.createNewArticle2(newArticle);
			this.dah.commit();
			
		} catch (RuntimeException e) {
			this.dah.rollback();
		}
	}
	
	public void modifyArticle(BoardVO modifyArticle) {
		try {
			this.boardDao.modifyArticle(modifyArticle);
			this.dah.commit();
			
		} catch (RuntimeException e) {
			this.dah.rollback();
		}
	}

	public void deleteArticle(String articleId) {
		try {
			this.boardDao.deleteArticle(articleId);
			this.dah.commit();
		} catch (RuntimeException e) {
			this.dah.rollback();
		}
	}
	
	public void updateView(String articleId) {
		
	}
	public BoardVO readArticle(String articleId) {
		try {
			this.boardDao.updateView(articleId);
			BoardVO result = this.boardDao.readArticle(articleId);
			this.dah.commit();
			return result;
			
		} catch (Exception e) {
			this.dah.rollback();
		}
		return null;
	}
	public List<BoardVO> readAllArticles() {
		List<BoardVO> result =this.boardDao.readAllArticles();
 	return result;
	}

}
