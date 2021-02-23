package com.itgorillaz.core.service;

import java.time.LocalDateTime;

public class FileDetails {

	private String acceptRanges;
	private int fileSizeInMB;
	private String contentType;
	private String etag;
	private LocalDateTime lastModified;
	private String versionId;

	public String getAcceptRanges() {
		return acceptRanges;
	}

	public void setAcceptRanges(String acceptRanges) {
		this.acceptRanges = acceptRanges;
	}

	public int getFileSizeInMB() {
		return fileSizeInMB;
	}

	public void setFileSizeInMB(int fileSizeInMB) {
		this.fileSizeInMB = fileSizeInMB;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getEtag() {
		return etag;
	}

	public void setEtag(String etag) {
		this.etag = etag;
	}

	public LocalDateTime getLastModified() {
		return lastModified;
	}

	public void setLastModified(LocalDateTime lastModified) {
		this.lastModified = lastModified;
	}

	public String getVersionId() {
		return versionId;
	}

	public void setVersionId(String versionId) {
		this.versionId = versionId;
	}

}
