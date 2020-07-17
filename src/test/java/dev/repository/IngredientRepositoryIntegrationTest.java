package dev.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import dev.config.DataSourceH2TestConfig;
import dev.config.JpaConfig;
import dev.dto.IngredientDto;

@SpringJUnitConfig(classes = { IngredientRepository.class, JpaConfig.class, DataSourceH2TestConfig.class })
@ActiveProfiles("jpa")
public class IngredientRepositoryIntegrationTest {

	@Autowired
	private IngredientRepository repo;
	
	@Test
	public void testRecherche() {
		Optional<IngredientDto> dto = repo.recherche("Beurre");
		assertThat(dto.get().getNom()).isEqualTo("Beurre");
	}
}