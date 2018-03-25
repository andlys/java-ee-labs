package main.homework;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import main.homework.vo.DisciplineVO;
import main.homework.vo.FacultyVO;
import main.homework.vo.StudentContact;
import main.homework.vo.StudentVO;

public class App {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("app-context.xml");
		DisciplineDao dao = context.getBean("discDao", DisciplineDao.class);
		DisciplineVO d = new DisciplineVO("Selenium WebDriver", 4);
		StudentVO s = new StudentVO("Linus Torvalds", 2, "KV", "5346235", new StudentContact("5345345", "ggggg@sdf.sdf"));
		d.addEnrolledStudent(s);
		FacultyVO f = new FacultyVO("Informatics Faculty", "Mykola Mykolayovich Glybovets");
		d.setFaculty(f);
		dao.addDiscipline(d);
		d.addEnrolledStudent(new StudentVO("Denys Melnichenko", 3, "ET", "756344", new StudentContact("1234567", "wfsdf@sdf.sdf")));
		d = dao.saveDiscipline(d);
		System.out.println(d);
		DisciplineVO d2 = new DisciplineVO("Scrum basics", 2);
		StudentVO s2 = new StudentVO("Bjarne Stroustrup", 1, "SL", "2351236", new StudentContact("09808909808", "uuuuuu@sdf.sdf"));
		d2.setFaculty(f);
		d2.addEnrolledStudent(s);
		d2.addEnrolledStudent(s2);
		d2 = dao.saveDiscipline(d2);
		/*
		 * when the line below is uncommented and used instead of the line above, 
		 * an exception is thrown for some unexplainable reason
		 * */
		// dao.saveDiscipline(d2); 
		System.out.println(d2);
	}
}
