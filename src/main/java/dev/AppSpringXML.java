/**
 * 
 */
package dev;

import java.util.Scanner;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import dev.ihm.Menu;

/**
 * @author robin
 *
 */
public class AppSpringXML {

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try(ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-config-fichier.xml")){
			
			Menu menu = context.getBean(Menu.class);
			menu.afficher();
			// fermeture du Scanner
			context.getBean(Scanner.class).close();
			// fermeture du contexte Spring
			context.close();
		}
	}
}
