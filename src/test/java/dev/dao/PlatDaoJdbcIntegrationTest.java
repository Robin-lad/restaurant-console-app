/**
 * 
 */
package dev.dao;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import dev.config.DataSourceConfig;
import dev.entite.Plat;

/**
 * @author robin
 *
 */
@SpringJUnitConfig(classes = { PlatDaoJdbc.class, DataSourceConfig.class })
@TestPropertySource("classpath:test2.properties")
public class PlatDaoJdbcIntegrationTest {
	
	@Autowired
	private PlatDaoJdbc jdbc;

	@Test
	void listerPlatsNonVide() {
		assertThat(jdbc.listerPlats().size() >= 1);
	}
	
	@Test
	void ajouterPlatsValide() {
		jdbc.ajouterPlat("platTest", 1000);
		assertThat(jdbc.listerPlats()).extracting(Plat::getNom).contains("platTest");
		assertThat(jdbc.listerPlats()).extracting(Plat::getPrixEnCentimesEuros).contains(1000);
	}
}
