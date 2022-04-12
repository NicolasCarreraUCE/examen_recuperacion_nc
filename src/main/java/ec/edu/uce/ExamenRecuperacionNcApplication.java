package ec.edu.uce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class ExamenRecuperacionNcApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExamenRecuperacionNcApplication.class, args);
	}

}
