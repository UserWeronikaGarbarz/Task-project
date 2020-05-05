//package com.crud.tasks.service;
//
//import com.crud.tasks.domain.Mail;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//
//import org.mockito.junit.MockitoJUnitRunner;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.mail.javamail.MimeMessageHelper;
//import org.thymeleaf.TemplateEngine;
//import org.thymeleaf.context.Context;
//
//import javax.mail.MessagingException;
//import javax.mail.internet.MimeMessage;
//
//import static org.mockito.Mockito.*;
//
//@RunWith(MockitoJUnitRunner.class)
//public class SimpleEmailServiceTest {
//
//    @InjectMocks
//    private SimpleEmailService simpleEmailService;
//
//    @Mock
//    private JavaMailSender javaMailSender;
//
//    @Mock
//    private MailCreatorService mailCreatorService;
//
//    @Test
//    public void shouldSendEmail() throws MessagingException {
//        //Given
//        Mail mail = new Mail("Test", "Test", "Test", null);
//        Context context = new Context();
//        context.setVariable("message", "message");
//
//        when(mailCreatorService.buildTrelloCardEmail(mail.getMessage())).thenReturn("mail.getMessage()");
//        MimeMessage mailMessage = javaMailSender.createMimeMessage();
//        MimeMessageHelper helper = new MimeMessageHelper(mailMessage);
//        helper.setTo(mail.getReceiverEmail());
//        helper.setSubject(mail.getSubject());
//        //When
//        simpleEmailService.send(mail);
//        //Then
//        verify(javaMailSender, times(1)).send(mailMessage);
//    }
//}
