package home.ru.s0mpleapplication.config;

import home.ru.s0mpleapplication.IntegrationTest;
import home.ru.s0mpleapplication.domain.Greeting;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.assertj.core.api.Assertions.assertThat;

@IntegrationTest
public class GreetingRouterTest {

    /**
     * Spring Boot will create a `WebTestClient` for you, already configure and ready to issue requests against "localhost:RANDOM_PORT"
     */
    @Autowired
    private WebTestClient webTestClient;

    @Test
    public void testHello() {
        String uri = "/hello";
        String expected = "Hello, Spring!";

        webTestClient
                .get()
                .uri(uri)
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus()
                .isOk()
                .expectBody(Greeting.class).value(greeting -> assertThat(greeting.message()).isEqualTo(expected));
    }

}