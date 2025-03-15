package in.asadit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("in.asadit.entity") // Scan entity classes
@EnableJpaRepositories("in.asadit.repo") // Scan repository interfaces
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}