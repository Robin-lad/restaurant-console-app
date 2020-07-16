/**
 * 
 */
package dev.dao;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import dev.config.DataSourceH2TestConfig;
import dev.config.JpaConfig;
import dev.entite.Plat;

/**
 * @author robin
 *
 */
@SpringJUnitConfig(classes = { PlatDaoJpa.class, JpaConfig.class, DataSourceH2TestConfig.class })
@ActiveProfiles("jpa")
public class PlatDaoJpaIntegrationTest {

	@Autowired
	// ou IPlatDao
	private PlatDaoJpa jpa;
	
	@Test
	void listerPlatsNonVide() {
		assertThat(jpa.listerPlats().size() >= 1);
	}
	
	@Test
	void ajouterPlatsValide() {
		jpa.ajouterPlat("platTest", 1000);
		assertThat(jpa.listerPlats()).extracting(Plat::getNom).contains("platTest");
		assertThat(jpa.listerPlats()).extracting(Plat::getPrixEnCentimesEuros).contains(1000);
	}
}
