package com.coderising.ood.srp;

import java.io.IOException;

/**
 * Created by Universe on 2017/6/20.
 */
class EmailSender {

    private String fromAddress = null;
    private SMTPHostResolver  smtpHostResolver = null;

    EmailSender(SMTPHostResolver smtpHostResolver, String fromAddress) {
        this.smtpHostResolver = smtpHostResolver;
        this.fromAddress = fromAddress;
    }

    void sendEMail(String toAddress, String subject, String message, boolean debug) throws IOException {
        System.out.println("开始发送邮件");
        try {
            if (toAddress.length() > 0)
                MailUtil.sendEmail(toAddress, fromAddress, subject, message, smtpHostResolver.getSmtpHost(), debug);
        } catch (Exception e) {
            try {
                MailUtil.sendEmail(toAddress, fromAddress, subject, message, smtpHostResolver.getAltSmtpHost(), debug);
            } catch (Exception e2) {
                System.out.println("通过备用 SMTP服务器发送邮件失败: " + e2.getMessage());
            }
        }
    }
}
