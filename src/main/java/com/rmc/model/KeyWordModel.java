package com.rmc.model;

import java.time.LocalDateTime;

public class KeyWordModel {
	
	public KeyWordModel() {
	}

    private String automataId;
	private String keywordId;
	private String keyword;
	private LocalDateTime createTime;
	private String creater;
	private LocalDateTime updateTime;
	private String updater;
	
	public String getAutomataId() {
		return automataId;
	}
	
	public void setAutomataId(String id) {
		automataId = id;
	}
	
	public String getKeywordId() {
		return keywordId;
	}
	
	public void setKeywordId(String id) {
		this.keywordId = id;
	}
	
	public String getKeyword() {
		return this.keyword;
	}
	
	public void setKeyword(String keyword) {
		this.keyword = keyword;	
	}

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
}

