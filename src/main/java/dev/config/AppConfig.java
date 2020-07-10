package dev.config;

import java.util.Scanner;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author robin
 *
 */
@Configuration
@PropertySource("app.properties")
@ComponentScan("dev")
public class AppConfig {

	@Bean
	public Scanner scan() {
		return new Scanner(System.in);
	}
}
