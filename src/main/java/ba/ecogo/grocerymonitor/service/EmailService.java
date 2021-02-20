package ba.ecogo.grocerymonitor.service;

import ba.ecogo.grocerymonitor.model.EmailMessage;
import ba.ecogo.grocerymonitor.model.base.BaseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class EmailService {
    private static final Logger logger = LoggerFactory.getLogger(EmailService.class);

    private @Autowired
    JavaMailSender sender;
    private @Value("${spring.mail.username}") String sentFrom;

    @Async
    public void sendEmail(EmailMessage emailMessage) {
        logger.info("Send email message: {}", emailMessage);
        if (emailMessage != null) {
            MimeMessage message = this.sender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message);

            try {
                helper.setFrom(sentFrom);
                helper.setTo(emailMessage.getEmail());
                helper.setSubject(emailMessage.getSubject());
                helper.setText(emailMessage.getBody(), true);
            } catch (MessagingException e) {
                throw new BaseException(e.getMessage());
            }

            try {
                this.sender.send(message);
            } catch (MailException e) {
                logger.error("Mail exception: {}", e.getLocalizedMessage());
            } catch (Exception e) {
                logger.error("Mail error: {}", e.getLocalizedMessage());
            }
        }
    }
}

