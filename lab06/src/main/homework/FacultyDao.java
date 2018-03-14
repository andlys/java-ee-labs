package main.homework;

import main.homework.vo.FacultyVO;

public interface FacultyDao {
	void addFaculty(FacultyVO d);
	FacultyVO getFaculty(int id);
	FacultyVO saveFaculty(FacultyVO d);
}
