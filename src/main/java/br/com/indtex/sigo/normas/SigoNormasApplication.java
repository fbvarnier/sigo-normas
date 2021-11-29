package br.com.indtex.sigo.normas;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(info = @Info(title = "Sigo Normas API", version = "V3"))
@SpringBootApplication
@EnableAutoConfiguration
public class SigoNormasApplication {

	public static void main(String[] args) {

		SpringApplication.run(SigoNormasApplication.class, args);
	}

}
