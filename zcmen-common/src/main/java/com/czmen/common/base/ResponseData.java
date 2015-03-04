package com.czmen.common.base;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * JSON返回对象。
 * @author YANGYONG
 *
 */
public class ResponseData implements Serializable {
	private static final long serialVersionUID = 4477257046774612586L;
	
	private String ec;
	private String em = "";
	private String requestURI = "";
	private String execptionTrace = "";

	private Object cd;
	protected final Logger logger = LoggerFactory.getLogger(getClass());

	public ResponseData() {

	}

	public ResponseData(String ec) {
		this(ec, null, null);
	}

	public ResponseData(String ec, String message) {
		this(ec, message, null);
	}

	public ResponseData(String success, String failMessage, Object message) {
		this.ec = success;
		if (failMessage == null)
			failMessage = "";
		this.em = failMessage;
		if (message == null)
			message = "";
		this.cd = message;
		logger.info("{ec:" + ec + "," + "em:" + em + "}");
	}

	public String getEc() {
		return ec;
	}

	public void setEc(String ec) {
		this.ec = ec;
	}

	public String getEm() {
		return em;
	}

	public void setEm(String em) {
		this.em = em;
	}

	public Object getCd() {
		return cd;
	}

	public void setCd(Object cd) {
		this.cd = cd;
	}

	public String getRequestURI() {
		return requestURI;
	}

	public void setRequestURI(String requestURI) {
		this.requestURI = requestURI;
	}

	public String getExecptionTrace() {
		return execptionTrace;
	}

	public void setExecptionTrace(String execptionTrace) {
		this.execptionTrace = execptionTrace;
	}
}
