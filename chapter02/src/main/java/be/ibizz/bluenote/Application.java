package be.ibizz.bluenote;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Application {

    @RequestMapping("/")
    public String index() {
        return "<h1>Hello Bluemix (via Spring boot)</h1>";
    }
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
}
