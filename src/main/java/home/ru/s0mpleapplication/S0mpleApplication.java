package home.ru.s0mpleapplication;

import home.ru.s0mpleapplication.controller.GreetingClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class S0mpleApplication {

    public static void main(String[] args) {
//        SpringApplication.run(S0mpleApplication.class, args);
        ConfigurableApplicationContext context = SpringApplication.run(S0mpleApplication.class, args);
        GreetingClient greetingClient = context.getBean(GreetingClient.class);
        // We need to block for the content here or the JVM might exit before the message is logged
        System.out.println(">> message = " + greetingClient.getMessage().block());
    }

}
