package org.lotte.dotcom.vo;

import java.sql.Date;

public class LogVO {
	private String logIdx;
	private String logTime;
	private String logId;
	private String logName;
	private String logPhoneNumber;
	public LogVO(String logId, String logName, String logPhoneNumber) {
		super();
		this.logId = logId;
		this.logName = logName;
		this.logPhoneNumber = logPhoneNumber;
	}
	public LogVO(String logIdx, String logTime, String logId, String logName, String logPhoneNumber) {
		super();
		this.logIdx = logIdx;
		this.logTime = logTime;
		this.logId = logId;
		this.logName = logName;
		this.logPhoneNumber = logPhoneNumber;
	}
	public LogVO() {
		super();
	}
	public String getLogIdx() {
		return logIdx;
	}
	public void setLogIdx(String logIdx) {
		this.logIdx = logIdx;
	}
	public String getLogTime() {
		return logTime;
	}
	public void setLogTime(String logTime) {
		this.logTime = logTime;
	}
	public String getLogId() {
		return logId;
	}
	public void setLogId(String logId) {
		this.logId = logId;
	}
	public String getLogName() {
		return logName;
	}
	public void setLogName(String logName) {
		this.logName = logName;
	}
	public String getLogPhoneNumber() {
		return logPhoneNumber;
	}
	public void setLogPhoneNumber(String logPhoneNumber) {
		this.logPhoneNumber = logPhoneNumber;
	}
	@Override
	public String toString() {
		return "LogVO [logIdx=" + logIdx + ", logTime=" + logTime + ", logId=" + logId + ", logName=" + logName
				+ ", logPhoneNumber=" + logPhoneNumber + "]";
	}
	
	
	
}
