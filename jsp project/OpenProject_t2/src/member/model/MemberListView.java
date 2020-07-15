package member.model;

import java.util.List;

public class MemberListView {
	//전체 게시물의 개수
		private int memberTotalCount;
		//현재 페이지 번호
		private int currentPageNumber;
		//메시지 리스트
		private List<Member> memberList;
		//전체 페이지 개수
		private int pageTotalCount;
		//페이지 당 표현 게시물의 개수
		private int memberCountPerpage;
		//게시물의 시작 행
		private int startRow;
		
		
		public MemberListView(int memberTotalCount, int currentPageNumber, List<Member> memberList, 
				int memberCountPerpage, int startRow) {
			this.memberTotalCount = memberTotalCount;
			this.currentPageNumber = currentPageNumber;
			this.memberList = memberList;
			this.memberCountPerpage = memberCountPerpage;
			this.startRow = startRow;
			calTotalPageCount();
		}
		
		
		private void calTotalPageCount() {
			if(memberTotalCount == 0) {
				pageTotalCount = 0;
			}else {
				pageTotalCount = memberTotalCount/memberCountPerpage;
				if(memberTotalCount%memberCountPerpage>0) {
					pageTotalCount++;
				}
			}			
		}


		public int getMemberTotalCount() {
			return memberTotalCount;
		}


		public int getCurrentPageNumber() {
			return currentPageNumber;
		}


		public List<Member> getMemberList() {
			return memberList;
		}


		public int getPageTotalCount() {
			return pageTotalCount;
		}


		public int getMemberCountPerpage() {
			return memberCountPerpage;
		}


		public int getStartRow() {
			return startRow;
		}


		

		@Override
		public String toString() {
			return "MemberListView [memberTotalCount=" + memberTotalCount + ", currentPageNumber=" + currentPageNumber
					+ ", memberList=" + memberList + ", pageTotalCount=" + pageTotalCount + ", memberCountPerpage="
					+ memberCountPerpage + ", startRow=" + startRow + "]";
		}
		
		public boolean isEmpty() {
			return memberTotalCount==0;
		}
		
		
		
		
}
