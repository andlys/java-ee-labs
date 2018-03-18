package main.homework;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.googlecode.ehcache.annotations.Cacheable;

import main.homework.vo.SimpleStudent;
import main.homework.vo.StudentVO;

@Repository
@Transactional
public class StudentDaoImpl implements StudentDao {

	@PersistenceContext
	private EntityManager em;

	@Cacheable(cacheName = "studentsCache")
	public SimpleStudent getStudentById(int id) {
		String query = "select s from SimpleStudent s where id = :id";
		return em.createQuery(query, SimpleStudent.class)
				.setParameter("id", id)
				.getSingleResult();
	}

	@Override
	public boolean addStudent(StudentVO s) {
		String query = "insert s into simple_student (full_name, course) values (:name, :course)";
		return 0 == em.createQuery(query)
						.setParameter("name", s.getFio())
						.setParameter("course", s.getFio())
						.executeUpdate();
	}

	@Override
	public List<SimpleStudent> getAllStudents() {
		String query = "select s from SimpleStudent s";
		return em.createQuery(query, SimpleStudent.class)
				.getResultList();
	}

}
