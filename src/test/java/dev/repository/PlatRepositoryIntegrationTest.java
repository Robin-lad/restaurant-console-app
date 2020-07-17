/**
 * 
 */
package dev.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import dev.config.DataSourceH2TestConfig;
import dev.config.JpaConfig;
import dev.entite.Ingredient;
import dev.entite.Plat;

/**
 * @author robin
 *
 */
@SpringJUnitConfig(classes = { PlatRepository.class, JpaConfig.class, DataSourceH2TestConfig.class })
@ActiveProfiles("jpa")
public class PlatRepositoryIntegrationTest {

	@Autowired
	private PlatRepository pr;

	@Test
	void testFindAll() {
		assertThat(pr.findAll()).hasSize(6);
	}

	@Test
	void testFindAllSortAsc() {
		List<Plat> plats = pr.findAll(Sort.by(Sort.Direction.ASC, "nom"));
		assertThat(plats).isSortedAccordingTo(Comparator.comparing(Plat::getNom));
	}

	@Test
	void testFindAllSortDesc() {
		List<Plat> plats = pr.findAll(Sort.by(Sort.Direction.DESC, "nom"));
		assertThat(plats).isSortedAccordingTo(Comparator.comparing(Plat::getNom).reversed());
	}

	@Test
	void testFindAllPageable() {
		Page<Plat> plats = pr.findAll(PageRequest.of(0, 2, Sort.by("nom").ascending()));
		assertThat(plats).extracting(Plat::getNom).contains("Blanquette de veau");
		assertThat(plats).extracting(Plat::getNom).contains("Couscous");
	}

	@Test
	void testFindById() {
		Optional<Plat> plats = pr.findById(6);
		assertThat(plats).isNotEmpty();
	}

	@Test
	@Transactional
	void testGetOne() {
		Plat plat = pr.getOne(4);
		assertThat(plat.getNom()).isEqualTo("Blanquette de veau");
	}

	@Test
	void testCount() {
		long l = pr.count();
		assertThat(l).isEqualTo(6);
	}

	@Test
	void testFindByPrix() {
		List<Plat> plats = pr.findByPrix(1300);
		assertThat(plats.get(0).getPrixEnCentimesEuros()).isEqualTo(1300);
	}

	@Test
	void testAvgPrix() {
		double avg = pr.avgPrix(1200);
		assertThat(avg).isEqualTo(1640);
	}

	@Test
	void testFindByNomWithIngredients() {
		List<Ingredient> ingredients = pr.findByNomWithIngredients("Couscous");
		assertThat(ingredients).hasSize(3);
	}

	@Test
	@Transactional
	public void testSave() {
		Plat plat = new Plat("Tarte aux escargots", 1200);
		pr.save(plat);
		assertThat(pr.findAll()).contains(plat);
	}

	@Test
	@Transactional
	public void testChangerNom() {
		pr.ChangerNom("Couscous", "Couscous-merguez");
		List<Plat> plats = pr.findAll();
		assertThat(plats).extracting(Plat::getNom).contains("Couscous-merguez");
		assertThat(plats).extracting(Plat::getNom).doesNotContain("Couscous");
	}
}
