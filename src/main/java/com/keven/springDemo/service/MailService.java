package com.keven.springDemo.service;

public interface MailService {
	
	//1.发送普通邮件 2. 发送附件 3. 发送网页	
	public boolean sendSimpleMail() ;
	
	public boolean sendMailWithattachment();
	
	public boolean sendMailWithHtml();
	

}
