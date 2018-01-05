package hello;

import java.util.Arrays;
import java.util.ArrayList;
import java.lang.System;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import hello.UserEntity;
import hello.UserService;

@SpringBootApplication
public class Application  implements CommandLineRunner{

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

    @Autowired
    UserService service;

    public static void main(String[] args) {
        //SpringApplication.run(Application.class, args);
        new SpringApplicationBuilder()
        .bannerMode(Banner.Mode.OFF)
        .sources(Application.class)
        .run(args);
    }

    @Override
    public void run(String... arg0) throws Exception{
        try{
            service.insertData();
            service.findAll();
        }
        catch(Exception e){
            
        }
        
    }

}