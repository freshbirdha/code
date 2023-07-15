package javamail;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import com.sun.mail.util.MailSSLSocketFactory;
import javax.mail.internet.MimeMultipart;

import org.junit.Test;

public class sendMailServes {
	
	int i=1;
	
	public  void sendMail(Session session, String model,String imgPath) throws Exception {
		Properties properties = new Properties();
		//设置发送邮件邮箱类型
		properties.setProperty("mailhost", "smtp.qq.com");
		//选择邮件发送协议
		properties.setProperty("mail.transport.protocol","smtp");
		//验证邮箱用户名密码
		properties.setProperty("mail.setp.auth", "true");
		//为邮箱设置SLL加密
		MailSSLSocketFactory  ms = new MailSSLSocketFactory();
		ms.setTrustAllHosts(true);
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.ssl.socketFactory", ms);
		
		//创建session信息
		
		  session = session.getDefaultInstance(properties, new Authenticator(){
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("发送人的邮箱地址", "密码");
            }
        });
		//通过session得到transport对象
		Transport transport = session.getTransport();
		//使用邮箱的用户名和密码连上授权的服务器
		transport.connect("smtp.qq.com","发送人的邮箱地址", "密码");
		//创建邮件
		//传送环境session
		MimeMessage message = new MimeMessage(session);
		//设置邮件发送人
		message.setFrom("发送人邮件地址");
		//设置邮件收件人
        message.setRecipients(Message.RecipientType.TO, "接收人的邮箱地址");
        //设置邮件主题
        message.setSubject("邮件主题");
        //设置图片属性
        
        MimeBodyPart image = new MimeBodyPart();
        DataHandler dh = new DataHandler(new FileDataSource("图片文件路径"));
        image.setDataHandler(dh);
        String imgId = i+".png";
        image.setContentID(imgId);//设置图片id
        
      //设置邮件正文内容
        MimeBodyPart text = new MimeBodyPart();
        //cid调用图片ID
        text.setContent("<h1 style='color: red'>您好！邮箱正文</h1><img src='cid:"+imgId+"'>", "text/html;charset=UTF-8");

        //描述数据关系
        MimeMultipart mm = new MimeMultipart();
        mm.addBodyPart(image);
        mm.addBodyPart(text);
        mm.setSubType("related");
        
        
      //将编辑好的数据关系放入message中
        message.setContent(mm);
      //保存修改
        message.saveChanges();

        //发送邮件
        transport.sendMessage(message, message.getAllRecipients());

        //关闭连接
        transport.close();
		
	}
}