package brainacad.org.autobase_hw;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication
public class AutoBaseHwApplication {

    public static void main(String[] args) {
        SpringApplication.run(AutoBaseHwApplication.class, args);
    }

}
