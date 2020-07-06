package com.keven.springDemo.exception;

public class AccountException extends RuntimeException{
	
	public final static String ACCOUNT_NOT_EXIST_FAIL = "0000";	
	
	public final static String ACCOUNT_FORBIDDEN_FIAL ="0020";
	
	public final static String PASSWORD_VERIFY_FIAL ="0010";
	
	
	
	//错误码
	private String erorcd;
	//错误信息
	private String erortx;
	
	public String getErorcd() {
		return erorcd;
	}
	public void setErorcd(String erorcd) {
		this.erorcd = erorcd;
	}
	public String getErortx() {
		return erortx;
	}
	public void setErortx(String erortx) {
		this.erortx = erortx;
	}
	public AccountException(String erorcd, String erortx) {
		super();
		this.erorcd = erorcd;
		this.erortx = erortx;
	}

}
