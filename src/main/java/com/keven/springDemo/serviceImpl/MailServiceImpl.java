package com.keven.springDemo.serviceImpl;

import java.io.File;

import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.keven.springDemo.email.MailService;

@Component
public class MailServiceImpl implements MailService {

	private final Logger logger = LoggerFactory.getLogger(MailServiceImpl.class);
	private static boolean isSucc = false;

	@Autowired
	private JavaMailSender mailSender;

	@Value("${mail.fromMail.addr}")
	private String from;

	@Override
	public boolean sendSimpleMail(String to, String subject, String content) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(from);
		message.setTo(to);
		message.setSubject(subject);
		message.setText(content);
		try {
			mailSender.send(message);
			isSucc = true;
			logger.info("简单邮件已经发送。");
		} catch (Exception e) {
			logger.error("发送简单邮件时发生异常！", e);
		}

		return isSucc;
	}

	@Override
	public boolean sendMailWithattachment(String to, String subject, String content, String filePath) {
		MimeMessage message = mailSender.createMimeMessage();

		try {
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			helper.setFrom(from);
			helper.setTo(to);
			helper.setSubject(subject);
			helper.setText(content);

			FileSystemResource file = new FileSystemResource(new File(filePath));
			String filename = filePath.substring(filePath.lastIndexOf(File.separator));
			helper.addAttachment(filename, file);
			

			mailSender.send(message);
			isSucc = true;
			logger.info("带附件的邮件已发送");

		} catch (Exception e) {
			logger.error("带附件的邮件发送失败");
		}

		return isSucc;
	}

	@Override
	public boolean sendMailWithHtml(String to, String subject, String content) {
		MimeMessage message = mailSender.createMimeMessage();
		try {
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			helper.setFrom(from);
			helper.setTo(to);
			helper.setSubject(subject);
			helper.setText(content,true);


			mailSender.send(message);
			isSucc = true;
			logger.info("html邮件发送成功");

		} catch (Exception e) {
			logger.error("html邮件发送失败");
		}

		return isSucc;
	}

	@Override
	public boolean sendMailWithInline(String to, String subject, String content, String srcPath, String srcId) {
		MimeMessage message = mailSender.createMimeMessage();
		try {
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			helper.setFrom(from);
			helper.setTo(to);
			helper.setSubject(subject);
			helper.setText(content,true);

			FileSystemResource file = new FileSystemResource(new File(srcPath));
			helper.addInline(srcId, file);
			
			mailSender.send(message);
			isSucc = true;
			logger.info("嵌入图片邮件发送成功");

		} catch (Exception e) {
			logger.error("嵌入图片邮件发送失败");
		}

		return isSucc;
	}

	@Override
	public boolean sendMailWithTemplate(String to, String subject, String content) {
		// TODO Auto-generated method stub
		return false;
	}

}
