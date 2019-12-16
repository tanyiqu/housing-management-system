package util;


import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class EmailUtil
{
    public static void sendSimple(String personal, String to, String subject, String msg) {
        //指定发送邮件信息
        String from = "1953649096@qq.com";

        // 指定发送邮件的主机为 smtp.qq.com
        String host = "smtp.qq.com";  //QQ 邮件服务器

        // 获取系统属性
        Properties properties = System.getProperties();

        // 设置邮件服务器
        properties.setProperty("mail.smtp.host", host);

        properties.put("mail.smtp.auth", "true");
        // 获取默认session对象
        Session session = Session.getDefaultInstance(properties,new Authenticator(){
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, "bwsvpzakpgdichhe"); //发件人邮件用户名、授权码
            }
        });

        try{
            // 创建默认的 MimeMessage 对象
            MimeMessage message = new MimeMessage(session);

            // Set From: 头部头字段
            try {
                message.setFrom(new InternetAddress(from,personal));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

            // Set To: 头部头字段
            message.addRecipient(Message.RecipientType.TO,
                    new InternetAddress(to));

            // Set Subject: 头部头字段
            message.setSubject(subject);

            // 设置消息体
            message.setText(msg);

            // 发送消息
            Transport.send(message);

        }catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }


    public static void sendHtml(String personal, String to, String subject, String content) {
        //指定发送邮件信息
        String from = "1953649096@qq.com";

        // 指定发送邮件的主机为 smtp.qq.com
        String host = "smtp.qq.com";  //QQ 邮件服务器

        // 获取系统属性
        Properties properties = System.getProperties();

        // 设置邮件服务器
        properties.setProperty("mail.smtp.host", host);

        properties.put("mail.smtp.auth", "true");
        // 获取默认session对象
        Session session = Session.getDefaultInstance(properties,new Authenticator(){
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, "bwsvpzakpgdichhe"); //发件人邮件用户名、授权码
            }
        });

        try{
            // 创建默认的 MimeMessage 对象
            MimeMessage message = new MimeMessage(session);

            // Set From: 头部头字段
            try {
                message.setFrom(new InternetAddress(from,personal));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

            // Set To: 头部头字段
            message.addRecipient(Message.RecipientType.TO,
                    new InternetAddress(to));

            // Set Subject: 头部头字段
            message.setSubject(subject);

            //获取一下时间

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 hh时mm分ss秒");
            Date date = new Date();
            String time = sdf.format(date);

            String t =
                    "<div style=\"background-color:#ECECEC; padding: 35px;\">\n" +
                    "    <table cellpadding=\"0\" align=\"center\"\n" +
                    "           style=\"width: 600px; margin: 0px auto; text-align: left; position: relative; border-top-left-radius: 5px; border-top-right-radius: 5px; border-bottom-right-radius: 5px; border-bottom-left-radius: 5px; font-size: 14px; font-family:微软雅黑, 黑体; line-height: 1.5; box-shadow: rgb(153, 153, 153) 0px 0px 5px; border-collapse: collapse; background-position: initial initial; background-repeat: initial initial;background:#fff;\">\n" +
                    "        <tbody>\n" +
                    "        <tr>\n" +
                    "            <th valign=\"middle\"\n" +
                    "                style=\"height: 25px; line-height: 25px; padding: 15px 35px; border-bottom-width: 1px; border-bottom-style: solid; border-bottom-color: #42a3d3; background-color: #49bcff; border-top-left-radius: 5px; border-top-right-radius: 5px; border-bottom-right-radius: 0px; border-bottom-left-radius: 0px;\">\n" +
                    "                <font face=\"微软雅黑\" size=\"5\" style=\"color: rgb(255, 255, 255); \">房屋中介</font>\n" +
                    "            </th>\n" +
                    "        </tr>\n" +
                    "        <tr>\n" +
                    "            <td>\n" +
                    "                <div style=\"padding:25px 35px 40px; background-color:#fff;\">\n" +
                    "                    <h2 style=\"margin: 5px 0px; \">\n" +
                    "                        <font color=\"#333333\" style=\"line-height: 20px; \">\n" +
                    "                            <font style=\"line-height: 22px; \" size=\"4\">\n" +
                    "                                亲爱的用户\n" +
                    "\t\t\t\t\t\t\t</font>\n" +
                    "                        </font>\n" +
                    "                    </h2>\n" +
                    "                    <p>感谢您加入房屋中介！<br><br>\n" +
                    "                        您的验证码：<b>" + content + "</b><br><br>\n" +
                    "                        当您在使用本网站时，遵守当地法律法规。<br>\n" +
                    "                        如果您有什么疑问可以联系管理员\n" +
                    "\t\t\t\t\t</p>\n" +
                    "                    <p align=\"right\">" + time + "</p>\n" +
                    "                    <div style=\"width:700px;margin:0 auto;\">\n" +
                    "                        <div style=\"padding:10px 10px 0;border-top:1px solid #ccc;color:#747474;margin-bottom:20px;line-height:1.3em;font-size:12px;\">\n" +
                    "                            <p>\n" +
                    "\t\t\t\t\t\t\t\t此为系统邮件，请勿回复！<br>\n" +
                    "                                请保管好您的验证码信息，避免账号被他人盗用！\n" +
                    "                            </p>\n" +
                    "                            <p>©081417137</p>\n" +
                    "                        </div>\n" +
                    "                    </div>\n" +
                    "                </div>\n" +
                    "            </td>\n" +
                    "        </tr>\n" +
                    "        </tbody>\n" +
                    "    </table>\n" +
                    "</div>\n";


            message.setContent(t, "text/html;charset=UTF-8");

            // 发送消息
            Transport.send(message);

        }catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }

}