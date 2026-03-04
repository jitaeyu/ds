package com.ktdsuniversity.edu.board.service;

import java.util.ArrayList;
import java.util.List;

import com.ktdsuniversity.edu.board.dao.ReplyDao;
import com.ktdsuniversity.edu.board.dao.query.ReplyQuery;
import com.ktdsuniversity.edu.board.db.helper.DataAccessHelper;
import com.ktdsuniversity.edu.board.db.helper.SQLType;
import com.ktdsuniversity.edu.board.vo.ReplyVO;

public class ReplyService {
	private DataAccessHelper dah;
	private ReplyDao replyDao;
	public ReplyService(DataAccessHelper dah){
		this.dah=dah;
		this.replyDao= new ReplyDao(dah);
	}
	
	public void insertReply(ReplyVO reply) {
		try {
			this.replyDao.insertReply(reply);
			this.dah.commit();
		} catch (RuntimeException e) {
			this.dah.close();
		}
	}
	
	public void deleteRep(String replyId) {
		try {
			this.replyDao.deleteRep(replyId);
			this.dah.commit();
		} catch (RuntimeException e) {
			this.dah.close();
		}
	}

	public List<ReplyVO> selectAllReply() {
		List<ReplyVO> result = this.replyDao.selectAllReply();
		return result;
	}
	
	public List<ReplyVO> selectAllSubReply(){
		List<ReplyVO> result = this.replyDao.selectAllSubReply();
		return result;
	}

	public void modifyReply(ReplyVO modifyReply) {
		try {
			this.replyDao.modifyReply(modifyReply);
			this.dah.commit();
		} catch (RuntimeException e) {
			this.dah.rollback();
		}
	}

	public List<ReplyVO> replyListId(String BoardId){
		List<ReplyVO> result = this.replyDao.replyListId(BoardId);
				return result;
	}
	public ReplyVO replyOneselect(String ReplyId){
		ReplyVO result = this.replyDao.replyOneselect(ReplyId);
		return result;
	}
	
}
