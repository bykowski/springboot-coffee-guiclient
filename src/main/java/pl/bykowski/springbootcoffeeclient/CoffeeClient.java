package pl.bykowski.springbootcoffeeclient;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

import java.util.stream.Stream;

@Controller
public class CoffeeClient {
    RestTemplate restTemplate = new RestTemplate();

    @EventListener(ApplicationReadyEvent.class)
    public void start() {
        addCoffee("Amigo", "Black");
        getCoffes();
    }

    public Coffee[] getCoffes() {
        ResponseEntity<Coffee[]> exchange = restTemplate.exchange(
                "https://szczecin-db.herokuapp.com/api",
                HttpMethod.GET,
                HttpEntity.EMPTY,
                Coffee[].class
        );
        return exchange.getBody();
    }

    public void removeCoffee(long id) {
        restTemplate.exchange(
                "https://szczecin-db.herokuapp.com/api?id=" + id,
                HttpMethod.DELETE,
                HttpEntity.EMPTY,
                Void.class
        );
    }

    public void addCoffee(String name, String type) {
        Coffee coffee = new Coffee();
        coffee.setName(name);
        coffee.setType(type);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-Type", "application/json");

        HttpEntity httpEntity = new HttpEntity(coffee, httpHeaders);

        restTemplate.exchange(
                "https://szczecin-db.herokuapp.com/api",
                HttpMethod.POST,
                httpEntity,
                Void.class
        );
    }

}
