package com.itgorillaz.core.model;

import java.math.BigInteger;
import java.time.LocalDateTime;

public class ApplicationClient {

	private String id;
	private String description;
	private BigInteger dailyQuota;
	private BigInteger dailyRequestsCount;
	private boolean active;
	private LocalDateTime updatedAt;
	private LocalDateTime createdAt;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigInteger getDailyQuota() {
		return dailyQuota;
	}

	public void setDailyQuota(BigInteger dailyQuota) {
		this.dailyQuota = dailyQuota;
	}

	public BigInteger getDailyRequestsCount() {
		return dailyRequestsCount;
	}

	public void setDailyRequestsCount(BigInteger dailyRequestsCount) {
		this.dailyRequestsCount = dailyRequestsCount;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

}
