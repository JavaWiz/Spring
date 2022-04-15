package com.javawiz.basic.i18n;

import java.util.Locale;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class I18nTest {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"i18n/messageContext.xml");
		String englishMsg = context.getMessage("name.question",null, Locale.ENGLISH);
		String frenchMsg = context.getMessage("name.question",null, Locale.FRENCH);
		String customMsg = context.getMessage("welcome.user",new Object[]{"Ranjan Sai"}, Locale.FRENCH);
		System.out.println(englishMsg + " "+ frenchMsg );
		System.out.println(customMsg);
	}
}
