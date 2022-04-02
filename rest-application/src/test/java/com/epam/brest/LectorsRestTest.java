package com.epam.brest;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class LectorsRestTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void getAllTest() {
        List <Lector> body = this.restTemplate.getForObject("/lectors/get-all", List.class );
        assertThat(body.getClass()).isEqualTo(ArrayList.class);
    }

    @Test
    public void getLectorByNameTest() {
        Lector body = this.restTemplate.getForObject("/lectors/lector/get-name", Lector.class );
        assertThat(body.getClass()).isEqualTo(Lector.class);
    }

    @Test
    public void getLectorByEmailTest() {
        Lector body = this.restTemplate.getForObject("/lectors/lector/get-email", Lector.class );
        assertThat(body.getClass()).isEqualTo(Lector.class);
    }

    @Test
    public void getLectorByIdTest() {
        Lector body = this.restTemplate.getForObject("/lectors/lector/{id}", Lector.class, Integer.class );
        assertThat(body.getClass()).isEqualTo(Lector.class);
    }
}
