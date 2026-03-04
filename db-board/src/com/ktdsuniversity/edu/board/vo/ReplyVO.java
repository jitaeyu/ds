package com.ktdsuniversity.edu.board.vo;

public class ReplyVO {
	private String id;
	private String boardId;
	private String topId;
	private String content;
	private String writeDate;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBoardId() {
		return boardId;
	}
	public void setBoardId(String boardId) {
		this.boardId = boardId;
	}
	public String getTopId() {
		return topId;
	}
	public void setTopId(String topId) {
		this.topId = topId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(String writeDate) {
		this.writeDate = writeDate;
	}
	@Override
	public String toString() {
		return "ReplyVO [id=" + id + ", boardId=" + boardId + ", topId=" + topId + ", content=" + content
				+ ", writeDate=" + writeDate + "]";
	}
	
	
	
}
