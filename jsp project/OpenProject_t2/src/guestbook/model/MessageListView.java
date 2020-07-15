package guestbook.model;

import java.util.List;

public class MessageListView {
	//전체 게시물의 개수
		private int messageTotalCount;
		//현재 페이지 번호
		private int currentPageNumber;
		//메시지 리스트
		private List<Message> messageList;
		//전체 페이지 개수
		private int pageTotalCount;
		//페이지 당 표현 게시물의 개수
		private int messageCountPerpage;
		//게시물의 시작 행
		private int startRow;
		
		public MessageListView(int messageTotalCount, int currentPageNumber, List<Message> mesaageList,
				int messageCountPerpage, int startRow) {
			this.messageTotalCount = messageTotalCount;
			this.currentPageNumber = currentPageNumber;
			this.messageList = mesaageList;
			this.messageCountPerpage = messageCountPerpage;
			this.startRow = startRow;
			calTotalPageCount();
			//인스턴스 생성할때 (new MessageListView)이렇게 뉴만들고 만들어서 생성자호출을 하는데 여기는 있는 인스턴스 생성부터하려면 변수를 만들어 주고 메서드로 만들어주고 인스턴스만들어질때 만들어진 인스턴스 메서드도 호출이 가능함

		}
		
		private void calTotalPageCount() {
			if(messageTotalCount == 0) {
				pageTotalCount = 0;
			}else {
				pageTotalCount = messageTotalCount/messageCountPerpage;
				if(messageTotalCount%messageCountPerpage>0) {
					pageTotalCount++;
				}
			}
		}

		public int getMessageTotalCount() {
			return messageTotalCount;
		}

		public int getCurrentPageNumber() {
			return currentPageNumber;
		}

		public List<Message> getMessageList() {
			return messageList;
		}

		public int getPageTotalCount() {
			return pageTotalCount;
		}

		public int getMessageCountPerpage() {
			return messageCountPerpage;
		}

		public int getStartRow() {
			return startRow;
		}


		@Override
		public String toString() {
			return "MessageListView [messageTotalCount=" + messageTotalCount + ", currentPageNumber=" + currentPageNumber
					+ ", messageList=" + messageList + ", pageTotalCount=" + pageTotalCount + ", messageCountPerpage="
					+ messageCountPerpage + ", startRow=" + startRow + "]";
		}
		
		public boolean isEmpty() {
			return messageTotalCount==0;
		}
}
