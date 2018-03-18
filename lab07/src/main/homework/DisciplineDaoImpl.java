package main.homework;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import main.homework.vo.DisciplineVO;

@Repository
@Transactional
public class DisciplineDaoImpl implements DisciplineDao {
	@PersistenceContext
	private EntityManager em;

	@Override
	public void addDiscipline(DisciplineVO d) {
		em.persist(d);
	}

	@Override
	public DisciplineVO getDiscipline(int id) {
		// TODO Auto-generated method stub
		return em.find(DisciplineVO.class, id);
	}

	@Override
	public DisciplineVO saveDiscipline(DisciplineVO d) {
		return em.merge(d);
	}

}
