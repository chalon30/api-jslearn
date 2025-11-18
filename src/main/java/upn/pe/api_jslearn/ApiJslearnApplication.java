package upn.pe.api_jslearn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import io.github.cdimascio.dotenv.Dotenv;

@SpringBootApplication
@EnableScheduling
public class ApiJslearnApplication {

	public static void main(String[] args) {

		String profile = System.getenv("SPRING_PROFILES_ACTIVE");

		if ("local".equals(profile)) {
			Dotenv dotenv = Dotenv.configure()
					.filename(".env.local")
					.ignoreIfMissing() // <-- evita error si no existe
					.load();

			System.setProperty("DB_HOST", dotenv.get("DB_HOST"));
			System.setProperty("DB_PORT", dotenv.get("DB_PORT"));
			System.setProperty("DB_NAME", dotenv.get("DB_NAME"));
			System.setProperty("DB_USER", dotenv.get("DB_USER"));
			System.setProperty("DB_PASSWORD", dotenv.get("DB_PASSWORD"));
		}

		SpringApplication.run(ApiJslearnApplication.class, args);
	}
}
