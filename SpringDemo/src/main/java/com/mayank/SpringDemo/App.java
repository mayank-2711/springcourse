package com.mayank.SpringDemo;

import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;


public class App 
{
    public static void main( String[] args )
    {
    	BeanFactory factory = new ClassPathXmlApplicationContext("spring.xml");
        Alien obj = (Alien)factory.getBean("alien");
    }
}
