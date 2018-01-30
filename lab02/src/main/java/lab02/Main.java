package lab02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main{
	public static void main( String[] args ){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("LiteraryBeans.xml");
		Author a = ctx.getBean("leo", Author.class);
		a.speak();
	}
}

