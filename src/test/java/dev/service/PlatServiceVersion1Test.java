/**
 * 
 */
package dev.service;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dev.dao.IPlatDao;
import dev.exception.PlatException;

/**
 * @author robin
 *
 */
public class PlatServiceVersion1Test {

	private PlatServiceVersion1 platServiceV1;
	private IPlatDao platDao;

	@BeforeEach
	void setUp() {
		this.platDao = mock(IPlatDao.class);
		this.platServiceV1 = new PlatServiceVersion1(platDao);
	}

	@Test
	void testAjouterPlatNomInvalide() {
		assertThatThrownBy(() -> platServiceV1.ajouterPlat("123", 700))
			.isInstanceOf(PlatException.class)
			.hasMessage("un plat doit avoir un nom de plus de 3 caractères");
	}

	@Test
	void testAjouterPlatPrixInvalide() {
		assertThatThrownBy(() -> platServiceV1.ajouterPlat("123456", 10))
			.isInstanceOf(PlatException.class)
			.hasMessage("le prix d'un plat doit être supérieur à 5 €");
	}

	@Test
	void testAjouterPlatValide() {
		platServiceV1.ajouterPlat("meilleurPlat", 5550);
		verify(platDao).ajouterPlat("meilleurPlat", 5550);
	}
}
