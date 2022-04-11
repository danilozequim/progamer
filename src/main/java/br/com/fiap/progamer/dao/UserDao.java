package br.com.fiap.progamer.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.fiap.progamer.model.Setup;
import br.com.fiap.progamer.model.User;

public class UserDao {

	public void create(User user) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("progamer-persistence-unit");
		EntityManager manager = factory.createEntityManager();

		manager.getTransaction().begin();
		manager.persist(user);
		manager.getTransaction().commit();

		manager.clear();
	}

	public List<User> listAll() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("progamer-persistence-unit");
		EntityManager manager = factory.createEntityManager();

		TypedQuery<User> query = manager.createQuery("SELECT s FROM Setup s", User.class);

		return query.getResultList();
	}

}
