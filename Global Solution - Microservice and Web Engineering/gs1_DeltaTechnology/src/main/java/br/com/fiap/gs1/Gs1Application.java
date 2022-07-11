package br.com.fiap.gs1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EntityScan(basePackages = "br.com.fiap.gs1.models")
@ComponentScan(basePackages = {"br.com.fiap.gs1.*"})
@EnableJpaRepositories(basePackages = {"br.com.fiap.gs1.repositories"})
@EnableTransactionManagement
public class Gs1Application {

	public static void main(String[] args) {
		SpringApplication.run(Gs1Application.class, args);
	}

}
