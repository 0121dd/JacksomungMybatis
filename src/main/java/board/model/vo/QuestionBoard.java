package board.model.vo;

import java.sql.Date;

public class QuestionBoard {
	private String BoardNo;
	private String BoardSubject;
	private String BoardContent;
	private String BoardWriter;
	private Date BoardWriteDate;
	
	public QuestionBoard() {}
	
	
	public QuestionBoard(String boardSubject, String boardContent, String boardWriter) {
		super();
		BoardSubject = boardSubject;
		BoardContent = boardContent;
		BoardWriter = boardWriter;
	}


	public QuestionBoard(String boardNo, String boardSubject, String boardContent, String boardWriter,
			Date boardWriteDate) {
		super();
		BoardNo = boardNo;
		BoardSubject = boardSubject;
		BoardContent = boardContent;
		BoardWriter = boardWriter;
		BoardWriteDate = boardWriteDate;
	}


	public String getBoardNo() {
		return BoardNo;
	}


	public void setBoardNo(String boardNo) {
		BoardNo = boardNo;
	}


	public String getBoardSubject() {
		return BoardSubject;
	}


	public void setBoardSubject(String boardSubject) {
		BoardSubject = boardSubject;
	}


	public String getBoardContent() {
		return BoardContent;
	}


	public void setBoardContent(String boardContent) {
		BoardContent = boardContent;
	}


	public String getBoardWriter() {
		return BoardWriter;
	}


	public void setBoardWriter(String boardWriter) {
		BoardWriter = boardWriter;
	}


	public Date getBoardWriteDate() {
		return BoardWriteDate;
	}


	public void setBoardWriteDate(Date boardWriteDate) {
		BoardWriteDate = boardWriteDate;
	}


	@Override
	public String toString() {
		return "질문게시판 [번호=" + BoardNo + ", 제목=" + BoardSubject + ", 내용="
				+ BoardContent + ", 작성자=" + BoardWriter + ", 작성일=" + BoardWriteDate + "]";
	}
	
	
	
}
