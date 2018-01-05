package hello;

import java.util.Arrays;
import java.util.ArrayList;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import hello.UserEntity;

@SpringBootApplication
public class Application {

    @Bean
    InitializingBean saveData(UserRepository repo){
        return () -> {
            repo.save(new UserEntity("Jose"));
            repo.save(new UserEntity("Jose 2"));
            repo.save(new UserEntity("Jose 3"));
            repo.save(new UserEntity("Jose 4"));
            repo.save(new UserEntity("Jose 5"));
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}