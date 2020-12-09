package com.hcl1;

public class Stall {
	
		private String name;
		private String detail;
		private String type;
		private String ownerName;

		public Stall() {
		}

		public Stall(String name, String detail, String type, String ownerName) {
			this.name = name;
			this.detail = detail;
			this.type = type;
			this.ownerName = ownerName;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getDetail() {
			return detail;
		}

		public void setDetail(String detail) {
			this.detail = detail;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public String getOwnerName() {
			return ownerName;
		}

		public void setOwnerName(String ownerName) {
			this.ownerName = ownerName;
		}

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return String.format("%-15s %-20s %-15s %s", this.getName(), this.getDetail(), this.getType(),
					this.getOwnerName());
		}
	}

