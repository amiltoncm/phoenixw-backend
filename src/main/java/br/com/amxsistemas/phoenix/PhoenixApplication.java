package br.com.amxsistemas.phoenix;

import br.com.amxsistemas.phoenix.utils.language.Language;
import br.com.amxsistemas.phoenix.utils.logger.UserLogger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.UUID;

@SpringBootApplication
public class PhoenixApplication {

	public static void main(String[] args) {
		SpringApplication.run(PhoenixApplication.class, args);

		Language.setLanguage("PT-BR");
		UserLogger.setUserLog(UUID.fromString("6caef3e5-a173-4e5f-97aa-da56a413ee0a"));

	}

}
