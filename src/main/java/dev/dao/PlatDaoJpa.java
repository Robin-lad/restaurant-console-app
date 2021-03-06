/**
 * 
 */
package dev.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dev.entite.Plat;

/**
 * @author robin
 *
 */
@Repository
@Profile("jpa")
@Transactional
public class PlatDaoJpa implements IPlatDao{
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Plat> listerPlats() {
		return em.createQuery("FROM Plat", Plat.class).getResultList();
	}

	@Override
	public void ajouterPlat(String nomPlat, Integer prixPlat) {
		Plat p = new Plat();
		p.setNom(nomPlat);
		p.setPrixEnCentimesEuros(prixPlat);
		em.persist(p);
	}

}
