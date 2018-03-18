package main.homework;

import java.util.List;

import org.springframework.cache.annotation.CachePut;
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
		return em.createNamedQuery("student.findById", SimpleStudent.class)
				.setParameter("id", id)
				.getSingleResult();
	}

	@CachePut("studentsCache")
	@Override
	public boolean addStudent(SimpleStudent s) {
		String query = "insert into simple_student (full_name, course) values (?, ?)";
		return 0 == em.createNativeQuery(query)
						.setParameter(1, s.getFullName())
						.setParameter(2, s.getCourse())
						.executeUpdate();
	}

	@Override
	public List<SimpleStudent> getAllStudents() {
		return em.createNamedQuery("student.findAll", SimpleStudent.class)
				.getResultList();
	}

}
