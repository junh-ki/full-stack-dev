package com.jun.flightreservation.util;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class EmailUtil {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(EmailUtil.class);
    
    @Autowired
    private JavaMailSender sender;
    
    public void sendItinerary(String toAddress, String filePath) {
        
        LOGGER.info("Inside sendItinerary()");
        
        MimeMessage message = sender.createMimeMessage();
        
        try {
            MimeMessageHelper messageHelper = new MimeMessageHelper(message, true);
            // boolean: if there are multiple parts in this message
            messageHelper.setTo(toAddress);
            messageHelper.setSubject("Itinerary for your Flight");
            messageHelper.setText("Please find your Itinerary attached.");
            messageHelper.addAttachment("Itinearary", new File(filePath));
            sender.send(message);
        } catch (MessagingException e) {
            LOGGER.error("Exception inside sendItinerary: " + e);
        }
    }

}
