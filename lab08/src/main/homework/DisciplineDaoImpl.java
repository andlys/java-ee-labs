package main.homework;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import main.homework.vo.DisciplineVO;

@Repository
@Transactional
public class DisciplineDaoImpl implements DisciplineDao {
	@PersistenceContext
	private EntityManager em;
	@Autowired
	private TransactionTemplate transactionTemplate;

	@Override
	public void addDiscipline(DisciplineVO d) {
		transactionTemplate.execute(new TransactionCallbackWithoutResult() {
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus arg0) {
				em.persist(d);
				System.out.println("Discipline has been added!");
			}
		});
	}

	@Override
	public DisciplineVO getDiscipline(int id) {
		return transactionTemplate.execute(new TransactionCallback<DisciplineVO>() {
			@Override
			public DisciplineVO doInTransaction(TransactionStatus arg0) {
				System.out.println("Discipline is being looked up!");
				return em.find(DisciplineVO.class, id);
		}});
	}

	@Transactional(propagation=Propagation.REQUIRES_NEW, isolation=Isolation.REPEATABLE_READ,
			readOnly=false)
	@Override
	public DisciplineVO saveDiscipline(DisciplineVO d) {
		System.out.println("Discipline is being merged!");
		return em.merge(d);
	}
}
