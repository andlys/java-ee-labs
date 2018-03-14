package main.homework;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import main.homework.vo.FacultyVO;

@Repository
@Transactional
public class FacultyDaoImpl implements FacultyDao {
	@PersistenceContext
	private EntityManager em;

	@Override
	public void addFaculty(FacultyVO d) {
		em.persist(d);
	}

	@Override
	public FacultyVO getFaculty(int id) {
		// TODO Auto-generated method stub
		return em.find(FacultyVO.class, id);
	}

	@Override
	public FacultyVO saveFaculty(FacultyVO d) {
		return em.merge(d);
	}

}
