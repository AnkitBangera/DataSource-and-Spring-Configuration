package org.Spring.Demo;

import org.Spring.Dao.DaoImpl;
import org.Spring.Model.Circle;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppDemo {

	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("spring.xml");
		DaoImpl daoImpl=context.getBean("daoImpl",DaoImpl.class);
		Circle circle=daoImpl.getCircle(1);
		System.out.println(circle.getName());
	}

}
