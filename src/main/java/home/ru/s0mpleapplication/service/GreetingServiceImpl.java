package home.ru.s0mpleapplication.service;

import home.ru.s0mpleapplication.domain.Greeting;
import org.springframework.stereotype.Service;

@Service
public class GreetingServiceImpl implements GreetingService {

    @Override
    public Greeting getHello() {
        return new Greeting("Hello, Spring!");
    }

    @Override
    public Greeting getGoodbye() {
        return new Greeting("Goodbye");
    }

}
