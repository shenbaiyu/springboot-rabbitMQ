package date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"date.*"})
public class RecognitionApplication {
    public static void main(String[] args) {
        SpringApplication.run(RecognitionApplication.class, args);
    }
}
