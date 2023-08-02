package com.rmc.model;

import java.time.LocalDateTime;

public class ClientModel {
	
	public ClientModel() {
		super();
	}

        private String customerID;
		private String customerName;
		private String creater;
		private LocalDateTime createTime;
		private LocalDateTime updateTime;
		private String updater;

		
		public LocalDateTime getCreateTime() {
			return createTime;
		}

		public void setCreateTime(LocalDateTime createTime) {
			this.createTime = createTime;
		}

		public String getCreater() {
			return creater;
		}

		public void setCreater(String creater) {
			this.creater = creater;
		}

		public LocalDateTime getUpdateTime() {
			return updateTime;
		}

		public void setUpdateTime(LocalDateTime updateTime) {
			this.updateTime = updateTime;
		}

		public String getUpdater() {
			return updater;
		}

		public void setUpdater(String updater) {
			this.updater = updater;
		}

		public String getCustomerName() {
			return customerName;
		}

		public void setCustomerName(String customerName) {
			this.customerName = customerName;
		}

		public String getCustomerID() {
			return customerID;
		}

		public void setCustomerID(String customerID) {
			this.customerID = customerID;
		}
}
