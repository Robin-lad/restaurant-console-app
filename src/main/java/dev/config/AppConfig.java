package dev.config;

import java.util.Scanner;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author robin
 *
 */
@Configuration
@ComponentScan("dev")
public class AppConfig {

	@Bean
	public Scanner scan() {
		return new Scanner(System.in);
	}
}
