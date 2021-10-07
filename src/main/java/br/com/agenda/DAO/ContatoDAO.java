package br.com.agenda.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.agenda.domain.Contato;
import br.com.agenda.util.JPAUtil;

public class ContatoDAO {
	
	public static void salvar(Contato contato) {
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		em.persist(contato);
		em.getTransaction().commit();
		em.close();
	}
	
	public static void editar(Contato contato) {
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		em.merge(contato);
		em.getTransaction().commit();
		em.close();
	}

	public static List<Contato> listar() {
		EntityManager em = JPAUtil.getEntityManager();
		Query q = em.createQuery("select c from Contato c");
		List<Contato> resultado = q.getResultList();
		em.close();
		return resultado;
	}
		
	public static void excluir(Contato contato) {
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		contato = em.find(Contato.class, contato.getId());
		em.remove(contato);
		em.getTransaction().commit();
		em.close();
	}

}
