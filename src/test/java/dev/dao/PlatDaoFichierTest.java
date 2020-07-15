/**
 * 
 */
package dev.dao;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import dev.entite.Plat;

/**
 * @author robin
 *
 */
@SpringJUnitConfig(classes = { PlatDaoFichier.class })
@TestPropertySource("classpath:test.properties")
public class PlatDaoFichierTest {
	
	@Autowired
	PlatDaoFichier dao;
	
	@Test
	void ajouterPlatTest() {
		dao.ajouterPlat("saucisses", 15000);
		assertThat(dao.listerPlats()).extracting(Plat::getNom).contains("saucisses");
		assertThat(dao.listerPlats()).extracting(Plat::getPrixEnCentimesEuros).contains(15000);
		
		assertThat(dao.listerPlats()).containsExactly(new Plat("saucisses", 15000));
		
		assertThat(dao.listerPlats()).hasSize(1);
	}
	
	@Test
	void ajouterPlatTestSauvegarde() {
		dao.ajouterPlat("saucisses2", 15000);
		assertThat(dao.listerPlats()).extracting(Plat::getNom).contains("saucisses2");
		assertThat(dao.listerPlats()).extracting(Plat::getPrixEnCentimesEuros).contains(16000);
		
		assertThat(dao.listerPlats()).containsExactly(new Plat("saucisses2", 16000));
		
		assertThat(dao.listerPlats()).hasSize(1);
	}
}
