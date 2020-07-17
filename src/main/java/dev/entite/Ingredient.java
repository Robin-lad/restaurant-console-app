/**
 * 
 */
package dev.entite;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * @author robin
 *
 */
@Entity
@Table(name="ingredient")
public class Ingredient {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="nom")
	private String nom;
	
	@ManyToMany(mappedBy = "ingredients")
	private List<Plat> plats;
	
	/**
	 * Getter
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * Setter
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * Getter
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}
	/**
	 * Setter
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	
}
