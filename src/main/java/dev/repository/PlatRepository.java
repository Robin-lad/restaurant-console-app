/**
 * 
 */
package dev.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import dev.entite.Ingredient;
import dev.entite.Plat;

/**
 * @author robin
 *
 */
public interface PlatRepository extends JpaRepository<Plat, Integer> {
	
	@Query("update Plat set nom=?2 where nom=?1")
	@Modifying
	void ChangerNom(String oldName, String newName);
	
	@Query("select i from Ingredient i join i.plats p where p.nom= ?1")
	List<Ingredient> findByNomWithIngredients(String nom);
	
	@Query("select AVG(p.prixEnCentimesEuros) from Plat p where p.prixEnCentimesEuros > ?1")
	double avgPrix(int min);
	
	@Query("select p from Plat p where p.prixEnCentimesEuros = ?1")
	List<Plat> findByPrix(Integer prix);
}
