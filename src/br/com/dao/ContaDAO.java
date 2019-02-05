package br.com.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.transaction.TransactionManager;

import java.util.List;
import br.com.entity.Conta;

public class ContaDAO {
	private static ContaDAO instance;

	protected EntityManager entityManager;

	public static ContaDAO getInstance() {
		if (instance == null) {
			instance = new ContaDAO();
		}

		return instance;
	}

	private ContaDAO() {
		entityManager = getEntityManager();
	}

	private EntityManager getEntityManager() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("provaCast");
		if (entityManager == null) {
			entityManager = factory.createEntityManager();
		}

		return entityManager;
	}

	public Conta persistTestData(Conta conta)

			throws Exception {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("provaCast");
		TransactionManager transactionManager = com.arjuna.ats.jta.TransactionManager.transactionManager();
		transactionManager.begin();
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		entityManager.persist(conta);
		entityManager.close();
		transactionManager.commit();

		return conta;
	}

	public List<Conta> findAll() {
		return entityManager.createQuery("SELECT * FROM Conta" + Conta.class.getName()).getResultList();
	}
	
	public Conta find(Conta conta) {
		return entityManager.find(Conta.class, conta.getId());
	}
}
