/**
 * 
 */
package dev.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import dev.config.AppConfig;
import dev.entite.Plat;
import dev.exception.PlatException;

/**
 * @author robin
 *
 */
@SpringJUnitConfig(classes = { AppConfig.class })
@ActiveProfiles({ "service2", "platMem" })
public class PlatServiceVersion2IntegrationTest {

	@Autowired
	PlatServiceVersion2 service2;

	@Test
	void ajouterPlatTestPassant() {
		service2.ajouterPlat("viande", 2000);
		assertThat(service2.listerPlats()).extracting(Plat::getNom).contains("viande");
		assertThat(service2.listerPlats()).extracting(Plat::getPrixEnCentimesEuros).contains(2000);
	}

	@Test
	void ajouterPlatTestNonPassant() {
		assertThatThrownBy(() -> service2.ajouterPlat("pizzas", 500)).isInstanceOf(PlatException.class)
				.hasMessage("le prix d'un plat doit être supérieur à 10 €");
	}

}
