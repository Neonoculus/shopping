package utils;

import javax.mail.*;
import javax.mail.internet.*;
import javax.swing.*;
import java.util.Properties;
import java.util.Random;

public class SendEmail {
    public SendEmail(String toEmail,String code) {
        String to = toEmail ; // 收件人邮箱地址
        String subject = "验证码"; // 邮件主题
//        String code = generateVerificationCode(); // 生成验证码
        String content = "您的验证码是：" + code; // 邮件内容

        String from = "1754279265@qq.com"; // 发件人邮箱地址
        String password = "tfyiouogfpdobgfi"; // 发件人邮箱密码

        Properties props = new Properties();
        props.setProperty("mail.transport.protocol", "smtp");
        props.setProperty("mail.smtp.host", "smtp.qq.com"); // 发件人邮箱所在的 SMTP 服务器地址
        props.setProperty("mail.smtp.auth", "true");

//        这段代码创建了一个 JavaMail 的 Session 对象，用于连接邮件服务器和发送邮件。
        Session session = Session.getDefaultInstance(props);
        session.setDebug(false);

        try {
            Message message = createMessage(session, from, to, subject, content);
            Transport transport = session.getTransport("smtp");
            transport.connect("smtp.qq.com", from, password);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        } catch (AddressException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    private static Message createMessage(Session session, String from, String to, String subject, String content)
            throws MessagingException {
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(from));
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
        message.setSubject(subject);
        message.setText(content);
        return message;
    }

    public static String generateVerificationCode() {
        Random random = new Random();
        int code = random.nextInt(900000) + 100000;
        return String.valueOf(code);
    }
}
