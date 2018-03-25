package main.homework;

import main.homework.vo.DisciplineVO;

public interface DisciplineDao {
	void addDiscipline(DisciplineVO d);
	DisciplineVO getDiscipline(int id);
	DisciplineVO saveDiscipline(DisciplineVO d);
}
