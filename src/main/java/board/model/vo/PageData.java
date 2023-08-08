package board.model.vo;

import java.util.List;

public class PageData {
	private List<QuestionBoard> qList;
	private String pageNavi;
	
	public PageData() {}

	public PageData(List<QuestionBoard> qList, String pageNavi) {
		super();
		this.qList = qList;
		this.pageNavi = pageNavi;
	}

	public List<QuestionBoard> getnList() {
		return qList;
	}

	public void setnList(List<QuestionBoard> qList) {
		this.qList = qList;
	}

	public String getPageNavi() {
		return pageNavi;
	}

	public void setPageNavi(String pageNavi) {
		this.pageNavi = pageNavi;
	}

	@Override
	public String toString() {
		return "PageData [nList=" + qList + ", pageNavi=" + pageNavi + "]";
	}
	
	
}
