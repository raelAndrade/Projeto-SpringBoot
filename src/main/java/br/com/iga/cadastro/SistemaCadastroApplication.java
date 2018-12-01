package br.com.iga.cadastro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages= {"br.*"})
public class SistemaCadastroApplication {

	public static void main(String[] args) {
		SpringApplication.run(SistemaCadastroApplication.class, args);
	}
}
