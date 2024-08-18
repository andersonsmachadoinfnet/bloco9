package br.anderson.infnet.appPbApiReceitaMedica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AppPbApiReceitaMedicaApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppPbApiReceitaMedicaApplication.class, args);
	}

}
