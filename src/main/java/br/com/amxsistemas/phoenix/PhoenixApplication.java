package br.com.amxsistemas.phoenix;

import br.com.amxsistemas.phoenix.utils.Language;
import br.com.amxsistemas.phoenix.utils.UserLogger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.UUID;

@SpringBootApplication
public class PhoenixApplication {

	public static void main(String[] args) {
		SpringApplication.run(PhoenixApplication.class, args);
		Language.setLanguage("PT-BR");
		UserLogger.setUserLog(UUID.fromString("6c90e522-bbf3-4964-98c8-f7c7c2569e3a"));
	}

}
