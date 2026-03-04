package com.ktdsuniversity.edu.board.dao.query;

public class ReplyQuery {

	
	public static String insertReply() {
		StringBuffer query = new StringBuffer(); 
		query.append(" INSERT INTO REPLY                                                            ");
		query.append(" (ID                                                                          ");
		query.append(" , BOARD_ID                                                                   ");
		query.append(" , CONTENT                                                                    ");
		query.append(" , WRITE_DATE)                                                                ");
		query.append(" VALUES                                                                       ");
		query.append(" ('RP-'||TO_CHAR(SYSDATE, 'YYYYMMDD-') || LPAD(SEQ_REPLY_PK.NEXTVAL,6,'0')    ");
		query.append(" , ?                                                                          ");
		query.append(" , ?                                                                          ");
		query.append(" , SYSDATE)                                                                   ");
		return query.toString();
	}
	
	public static String deleteReply() {
		StringBuffer query = new StringBuffer();
		query.append("DELETE                             ");
		query.append("FROM REPLY                         ");
		query.append("WHERE ID=?     ");
		
		return query.toString();
	}
	
	public static String updateReply() {
		StringBuffer query = new StringBuffer();
		query.append("UPDATE REPLY                     ");
		query.append("SET CONTENT = ?      ");
		query.append("WHERE ID=?   ");
		return query.toString();
	}
	
	public static String selectBoardIdReply() {
		StringBuffer query = new StringBuffer();
		query.append(" SELECT ID                              ");
		query.append(" , BOARD_ID                             ");
		query.append(" , TOP_ID                               ");
		query.append(" , CONTENT                              ");
		query.append(" , WRITE_DATE                           ");
		query.append(" FROM REPLY                             ");
		query.append(" WHERE BOARD_ID = ?  ");
		return query.toString();
	}
	
	public static String selectOneReply() {
		StringBuffer query = new StringBuffer();
		query.append(" SELECT ID                              ");
		query.append(" , BOARD_ID                             ");
		query.append(" , TOP_ID                               ");
		query.append(" , CONTENT                              ");
		query.append(" , WRITE_DATE                           ");
		query.append(" FROM REPLY                             ");
		query.append(" WHERE ID = ?  ");
		return query.toString();
	}
	
	public static String selectAllReplyByLevel() {
		StringBuffer query = new StringBuffer();
		query.append("  SELECT LEVEL                         ");
		query.append("  , ID                                 ");
		query.append("  , BOARD_ID                           ");
		query.append("  , TOP_ID                             ");
		query.append("  , CONTENT                            ");
		query.append("  , WRITE_DATE                         ");
		query.append("  FROM REPLY                           ");
		query.append("  CONNECT BY PRIOR ID = TOP_ID         ");
			return query.toString();
	}
	
	
	public static String selectOnlySubReply() {
		StringBuffer query = new StringBuffer();
			query.append("	SELECT                                   ");
			query.append("			   ID                            ");
			query.append("			  , BOARD_ID                      ");
			query.append("			  , TOP_ID                        ");
			query.append("			  , CONTENT                       ");
			query.append("			  , WRITE_DATE                    ");
		    query.append("   FROM (SELECT LEVEL AS L                  ");
			query.append("		 	 , ID                             ");
			query.append("			 , BOARD_ID                       ");
			query.append("			 , TOP_ID                         ");
			query.append("		     , CONTENT                        ");
			query.append("	         , WRITE_DATE                     ");
			query.append("			 FROM REPLY                       ");
			query.append("			 CONNECT BY PRIOR ID = TOP_ID)    ");
			query.append("    WHERE L >= 2                           ");
		return query.toString();
	}
	
}
