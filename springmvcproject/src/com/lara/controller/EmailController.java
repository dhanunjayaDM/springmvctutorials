package com.lara.controller;

import java.io.IOException;
import java.io.InputStream;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmailController 
{
	 static String emailToRecipient, emailSubject, emailMessage;
	 static final String emailFromRecipient = "dhanamylari225@gmail.com";
	 
	 @Autowired
	 private JavaMailSender mailSenderObj;

	 
	 @RequestMapping(value = "/emailForm", method = RequestMethod.GET)
	 public ModelAndView SendEmailForm()
	 {
		 ModelAndView modelViewObj = new ModelAndView("emailForm"); 
		 return modelViewObj;
	 }
	 
	 @RequestMapping(value ="/sendEmail", method = RequestMethod.POST)
	 public ModelAndView SendEmailToClient(HttpServletRequest req, HttpServletResponse res,@RequestParam CommonsMultipartFile attachFileObj )
	 {
		 emailSubject = req.getParameter("subject");
		 emailMessage = req.getParameter("message");
		 emailToRecipient = req.getParameter("mailTo");
		 System.out.println("\nReceipient?= " + emailToRecipient + ", Subject?= " + emailSubject + ", Message?= " + emailMessage + "\n");
		 mailSenderObj.send(new MimeMessagePreparator() 
		 {
			 public void prepare(MimeMessage mimeMessage) throws Exception 
			 {
				 System.out.println("\nReceipient?= " + emailToRecipient + ", Subject?= " + emailSubject + ", Message?= " + emailMessage + "\n");
				 MimeMessageHelper mimeMsgHelperObj = new MimeMessageHelper(mimeMessage, true, "UTF-8");
                 mimeMsgHelperObj.setTo(emailToRecipient);
                 mimeMsgHelperObj.setFrom(emailFromRecipient);
                 mimeMsgHelperObj.setText(emailMessage);
                 mimeMsgHelperObj.setSubject(emailSubject);
			     if ((attachFileObj != null) && (attachFileObj.getSize() > 0) && (!attachFileObj.equals("")))
			     {
			         System.out.println("\nAttachment Name?= " + attachFileObj.getOriginalFilename() + "\n");
			         mimeMsgHelperObj.addAttachment(attachFileObj.getOriginalFilename(), new InputStreamSource() 
			         {
			             public InputStream getInputStream() throws IOException
			             {
			                  return attachFileObj.getInputStream();
			             }
			         });
			      } else
			      {
			                     System.out.println("\nNo Attachment Is Selected By The User. Sending Text Email!\n");
			      }
			}
		 });
         System.out.println("\nMessage Send Successfully.... Hurrey!\n");
         ModelAndView   modelViewObj = new ModelAndView("success","messageObj","Thank You! Your Email Has Been Sent!");
         return  modelViewObj; 
	 }


}
