package in.dhananjaygore.expensetrackerapi.entity;

import java.util.Date;

public class ErrorObject {

	private Integer statusCode;
	
	private String message;
	
	private Date timeStamp;

	public Integer getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date l) {
		this.timeStamp = l;
	}

	@Override
	public String toString() {
		return "ErrorObject [statusCode=" + statusCode + ", message=" + message + ", timeStamp=" + timeStamp + "]";
	}

	
	
	public ErrorObject() {
		super();
	}

	public ErrorObject(Integer statusCode, String message, Date timeStamp) {
		super();
		this.statusCode = statusCode;
		this.message = message;
		this.timeStamp = timeStamp;
	}
	
	
}
