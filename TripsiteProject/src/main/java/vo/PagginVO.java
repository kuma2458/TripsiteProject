package vo;

public class PagginVO {
	
		//전체 게시글 개수,현재 페이지 번호, 한 페이지에 출력할 게시글 개수, 한번에 보여줄 페이지 개수
		private int count;
		private int currentPageNo;
		private int pageOfContentCount;
		private int pageGroupOfCount;
		
		public PagginVO(int count, int currentPageNo, int pageOfContentCount, int pageGroupOfCount) {
			this.count = count;
			this.currentPageNo = currentPageNo;
			this.pageOfContentCount = pageOfContentCount;
			this.pageGroupOfCount = pageGroupOfCount;
		}

		public int getCurrentPageNo() {
			return currentPageNo;
		}

		//전체 페이지 개수
		public int getTotalPage() {
			return count/pageOfContentCount+(count%pageOfContentCount==0?0:1) ;
		}
		//전체 페이지 그룹 개수
		public int getTotalPageGroup() {
			return  getTotalPage()/pageGroupOfCount+(getTotalPage()/pageGroupOfCount==0?0:1);
		}

		// 현재 페이지 그룹 번호
		public int getNowPageGroupNo() {
			return currentPageNo / pageGroupOfCount + (currentPageNo % pageGroupOfCount == 0 ? 0 : 1);
		}

		// 현재 페이지 그룹 시작 페이지 번호 : (현재 페이지 그룹 번호 - 1) * 게시판 하단에 나타낼 페이지 번호 개수 + 1
		public int getStartPageOfPageGroup() {
			return (getNowPageGroupNo() - 1) * pageGroupOfCount + 1;
		}

		// 현재 페이지 그룹 마지막 페이지 번호 : 현재 페이지 그룹번호 * 게시판 하단에 나타낼 페이지 번호 개수
		//단 전체 페이지 개수가 작으면 전체 페이지 개수가 마지막 페이지 번호
		public int getEndPageOfPageGroup() {
			if(getNowPageGroupNo() * pageGroupOfCount > getTotalPage())
				return getTotalPage();
			return getNowPageGroupNo() * pageGroupOfCount;
		}
		// 이전 페이지 그룹이 있냐?
		public boolean isPriviousPageGroup() {
			return getNowPageGroupNo() > 1;
		}
		
		// 다음 페이지 그룹이 있냐?
		public boolean isNextPageGroup() {
			return getNowPageGroupNo() < getTotalPageGroup();
		}


		@Override
		public String toString() {
			return "PagginVO [count=" + count + ", currentPageNo=" + currentPageNo + ", pageOfContentCount="
					+ pageOfContentCount + ", pageGroupOfCount=" + pageGroupOfCount + "]";
		}
		
		
}
