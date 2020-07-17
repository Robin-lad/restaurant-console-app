/**
 * 
 */
package dev;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import dev.config.AppConfig;
import dev.entite.Plat;
import dev.repository.PlatRepository;

/**
 * @author robin
 *
 */
public class AppDemoSpringData {

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class)) {

			PlatRepository platRepository = context.getBean(PlatRepository.class);

			/*
			 * Usage 1 - CRUD List<Article> articles = articleRepository.findAll();
			 * 
			 * for (Article article: articles) { 
			 * 		System.out.println(article.getReference());
			 * }
			 */

			/* Usage 2 - Requête dynamique */
			List<Plat> plats = platRepository.findAll();

			for (Plat plat : plats) {
				System.out.println(plat.getNom() + " " + plat.getPrixEnCentimesEuros());
			}
		}
	}
}
