package org.lotte.dotcom.vo;

import java.util.List;

public class ListVO {
	private List<LogVO> logList;
	private PagingBean pagingBean;
	
	public ListVO(List<LogVO> logList, PagingBean pagingBean) {
		super();
		this.logList = logList;
		this.pagingBean = pagingBean;
	}

	public List<LogVO> getLogList() {
		return logList;
	}

	public void setLogList(List<LogVO> logList) {
		this.logList = logList;
	}

	public PagingBean getPagingBean() {
		return pagingBean;
	}

	public void setPagingBean(PagingBean pagingBean) {
		this.pagingBean = pagingBean;
	}

	@Override
	public String toString() {
		return "ListVO [logList=" + logList + ", pagingBean=" + pagingBean + "]";
	}
	
	

	
}
