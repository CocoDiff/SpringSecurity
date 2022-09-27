package kr.co.page.main;

public class PagingVo {
	
	//현재 - 시작 - 끝 - 게시글 총 수 - 페이지당 글 갯수 - 마지막 페이지 - SQL 쿼리에 쓸 start - end
	public int nowPage, startPage, endPage, total, cntPerPage;
	public int limit = 5;
	
	
	public int getNowPage() {
		return nowPage;
	}

	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
	
	public PagingVo (int nowPage, int total) {
		super();
		
		this.nowPage = nowPage;
		this.total = total;
		this.cntPerPage = (int) Math.ceil(total / 10.0);
		this.endPage = (int) Math.ceil(nowPage * 0.2) * limit;
		this.startPage = endPage - 4;
	}

	@Override
	public String toString() {
		return "PagingVo [nowPage=" + nowPage + ", startPage=" + startPage + ", endPage=" + endPage + ", total=" + total
				+ ", cntPerPage=" + cntPerPage + ", limit=" + limit + "]";
	}

}
