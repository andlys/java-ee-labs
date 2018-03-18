package main.homework;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import main.homework.vo.SimpleStudent;

public class App {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("app-context.xml");
		StudentDao dao = context.getBean("studentDao", StudentDao.class);
		SimpleStudent student = dao.getStudentById(1);
		System.out.println(student);
		student = dao.getStudentById(1);
		System.out.println(student);
		student = dao.getStudentById(1);
		System.out.println(student);
		System.out.println(dao.getAllStudents());
		dao.addStudent(new SimpleStudent("Jeff Sutherland", 2));
		System.out.println(dao.getAllStudents());
	}
}
