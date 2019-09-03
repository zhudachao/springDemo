package com.keven.springDemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.TemplateEngine;

import com.keven.springDemo.email.MailService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestMailSend {
	@Autowired
	private MailService MailService;

	
	public void testSimpleMail() throws Exception {
		MailService.sendSimpleMail("1174241958@qq.com", "test simple mail", " this is simple mail");
	}
	
	
	public void testAttachmentMail() throws Exception {
		String filepath="E:\\test\\mail.txt";
		MailService.sendMailWithattachment("1174241958@qq.com", "test attachment mail", " this is attachment mail",filepath);
	}
	
	
	public void testHtmlMail() throws Exception {
		String content="<html>\n"+
	           "<body>\n"+
				"   <h3>htmlMailTest</h3>\n"+
	           "</body>\n"+
				"</html>\n";			
		MailService.sendMailWithHtml("1174241958@qq.com", "test html mail", content);
	}
	
	
	@Test
	public void testTemplateMail() throws Exception {
		String filepath="E:\\test\\test01.jpg";
		String srcId= "test01";
		String content="<html>\n"+
	           "<body>\n"+
				"   <h3>testTemplateMail</h3>\n"+
	            "<img src=\'cid:" + srcId + "\' >"+
	           "</body>\n"+
				"</html>\n";			
//	    String content="<html><body>这是有图片的邮件：<img src=\'cid:" + srcId + "\' ></body></html>";
		MailService.sendMailWithInline("1174241958@qq.com", "test inline mail", content,filepath,srcId);
	}
	
	
}
