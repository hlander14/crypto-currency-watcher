package by.myself.crypto.configuration;

import by.myself.crypto.entity.Crypto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class Communication {

    private RestTemplate restTemplate = new RestTemplate();

    private static final String URL = "https://api.coinlore.net/api/ticker/?id=";

    public Crypto findById(int id) {
        ResponseEntity<Crypto[]> response =
                restTemplate.getForEntity(URL + id, Crypto[].class);
        Crypto[] cryptos = response.getBody();
        assert cryptos != null;
        return cryptos[0];
    }
}
