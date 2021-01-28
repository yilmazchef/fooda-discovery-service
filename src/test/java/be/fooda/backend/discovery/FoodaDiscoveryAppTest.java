package be.fooda.backend.discovery;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.web.WebAppConfiguration;

@WebAppConfiguration
@SpringBootTest("server.port=0")
class FoodaDiscoveryAppTest {

    @Value("${local.server.port}")
    private final int port = 0;

    @Test
    void catalogLoads() {
        @SuppressWarnings("rawtypes")
        ResponseEntity<Map> entity = new TestRestTemplate("user", "password").getForEntity("http://localhost:" + port + "/eureka/apps", Map.class);
        assertEquals(HttpStatus.OK, entity.getStatusCode());
    }

    @Test
    void adminLoads() {
        @SuppressWarnings("rawtypes")
        ResponseEntity<Map> entity = new TestRestTemplate("user", "password").getForEntity("http://localhost:" + port + "/env", Map.class);
        assertEquals(HttpStatus.OK, entity.getStatusCode());
    }
}