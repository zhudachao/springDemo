package com.keven.springDemo.email;

public interface MailService {
	
	//1.发送普通邮件 2. 发送附件 3. 发送网页  4.发送带静态资源文件5. 邮件模板
	public boolean sendSimpleMail(String to, String subject, String content) ;
	
	public boolean sendMailWithattachment(String to, String subject, String content, String filePath);
	
	public boolean sendMailWithHtml(String to, String subject, String content);
	
	public boolean sendMailWithInline(String to, String subject, String content,String srcPath,String srcId);
	
	public boolean sendMailWithTemplate(String to, String subject, String content);

	

}
