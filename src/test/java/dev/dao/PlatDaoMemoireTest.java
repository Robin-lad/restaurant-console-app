/**
 * 
 */
package dev.dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dev.entite.Plat;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
/**
 * @author robin
 *
 */
public class PlatDaoMemoireTest {

	private PlatDaoMemoire platDaoMemoire;

	@BeforeEach
	void setUp() {
		this.platDaoMemoire = new PlatDaoMemoire();
	}

	@Test
	void listerPlatsVideALInitialisation() {
		
		List<Plat> resultat = platDaoMemoire.listerPlats();
		assertThat(resultat).isEmpty();
	}

	@Test
	void ajouterPlatCasPassants() {
		platDaoMemoire.ajouterPlat("test1", 785);
		assertThat(platDaoMemoire.listerPlats()).extracting(Plat::getNom).containsExactly("test1");
		assertThat(platDaoMemoire.listerPlats()).extracting(Plat::getPrixEnCentimesEuros).containsExactly(785);
	}
}
