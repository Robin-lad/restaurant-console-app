package dev.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import dev.dto.IngredientDto;
import dev.entite.Ingredient;

public interface IngredientRepository extends JpaRepository<Ingredient, Integer> {
	
	@Query("select i from Ingredient i where i.nom=?1")
	Optional<IngredientDto> recherche(String nom);
}