package com.revature.beans;

public class Message {
	
		private int fromID;
		private int toID;
		private int rimID;
		private String message;
		
		
		public Message() {
			super();
			// TODO Auto-generated constructor stub
		}


		public Message(int fromID, int toID, int rimID, String message) {
			super();
			this.fromID = fromID;
			this.toID = toID;
			this.rimID = rimID;
			this.message = message;
		}


		public int getFromID() {
			return fromID;
		}


		public void setFromID(int fromID) {
			this.fromID = fromID;
		}


		public int getToID() {
			return toID;
		}


		public void setToID(int toID) {
			this.toID = toID;
		}


		public int getRimID() {
			return rimID;
		}


		public void setRimID(int rimID) {
			this.rimID = rimID;
		}


		public String getMessage() {
			return message;
		}


		public void setMessage(String message) {
			this.message = message;
		}

		


}
