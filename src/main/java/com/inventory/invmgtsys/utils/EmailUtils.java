package com.inventory.invmgtsys.utils;

import com.inventory.invmgtsys.dto.EmailDto;
import lombok.SneakyThrows;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.MultiPartEmail;
import org.apache.commons.mail.SimpleEmail;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class EmailUtils {
    @Value("${email.port}")
    private int port;
    @Value("${email.username}")
    private String username;
    @Value("${email.hostname}")
    private String hostName;
    @Value("${email.password}")
    private String password;

    /*
    private final FileStorage fileStorage;

    public EmailUtils(FileStorage fileStorage) {
        this.fileStorage = fileStorage;
    }


     */

    public String sendSimpleEmail(EmailDto emailDto) {
        try {
            Thread emailThread = new Thread() {
                @SneakyThrows
                public void run() {
                    Email email = new SimpleEmail();
                    email.setHostName(hostName);
                    email.setSmtpPort(port);
                    email.setAuthentication(username, password);
                    email.setSSLOnConnect(true);
                    email.setFrom(username);
                    email.setSubject(emailDto.getSubject());
                    email.setMsg(emailDto.getMessage());
                    email.addTo(emailDto.getReceiver());
                    email.send();
                    /**
                     * Handle the log
                     */
                }
            };
            emailThread.start();
            return "Email sent successful";
        } catch (Exception ex) {
            ex.printStackTrace();
            return "Email sending failed";
        }
    }

    /*
    public String sendEmailWithAttachment(EmailDto emailDto) {
        try {

            /**
             * Store the multipart file
             */
    /*
            String fileName = fileStorage.storeFile(emailDto.getImage());
            String storageLocation = fileStorage.getStorageLocation();
            // Create the attachment
            EmailAttachment attachment = new EmailAttachment();
            attachment.setPath(storageLocation + fileName);
            attachment.setDisposition(EmailAttachment.ATTACHMENT);
            attachment.setDescription("This is attached email");
            attachment.setName(emailDto.getAttachmentName());

            // Create the email message
            MultiPartEmail email = new MultiPartEmail();
            email.setHostName(hostName);
            email.setSmtpPort(port);
            email.setAuthentication(username, password);
            email.setSSLOnConnect(true);
            email.setFrom(username);
            String[] receivers = emailDto.getReceiver().split(",");
            for (int i = 0; i < receivers.length; i++) {
                email.addTo(receivers[i], "TEST");
            }
            email.setFrom(username, "SENDER");
            email.setSubject(emailDto.getSubject());
            email.setMsg(emailDto.getMessage());
            // add the attachment
            email.attach(attachment);
            // send the email
            email.send();
            return "Email sent successfully";
        } catch (Exception ex) {
            return "Email sending failed";
        }
    }
    */

}