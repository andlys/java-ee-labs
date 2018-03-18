package main.homework;

import java.util.List;

import main.homework.vo.SimpleStudent;
import main.homework.vo.StudentVO;

public interface StudentDao {
	SimpleStudent getStudentById(int id);
	boolean addStudent(StudentVO s);
	List<SimpleStudent> getAllStudents();
}
