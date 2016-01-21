package com.github.sebhoss.identifier.api;

import com.github.sebhoss.identifier.IdentifierApplication;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import static com.github.sebhoss.identifier.testsupport.UuidMatcher.isValidUUID;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = IdentifierApplication.class)
@WebAppConfiguration
@IntegrationTest({"server.port=0"})
public class IdentifierControllerIT {

    @Value("${local.server.port}")
    private int port;

    private String base;
    private RestTemplate template;

    @Before
    public void setUp() throws Exception {
        base = "http://localhost:" + port + "/";
        template = new TestRestTemplate();
    }

    @Test
    public void getIndexPage() throws Exception {
        ResponseEntity<String> response = template.getForEntity(base, String.class);
        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
    }

    @Test
    public void getSequence() throws Exception {
        ResponseEntity<String> response = template.getForEntity(base + "sequence", String.class);
        assertThat(response.getBody(), equalTo("0"));
    }

    @Test
    public void getSequenceInBase36() throws Exception {
        ResponseEntity<String> response = template.getForEntity(base + "sequence-in-base36", String.class);
        assertThat(response.getBody(), equalTo("0"));
    }

    @Test
    public void getSequenceInBase64() throws Exception {
        ResponseEntity<String> response = template.getForEntity(base + "sequence-in-base64", String.class);
        assertThat(response.getBody(), equalTo("MA=="));
    }

    @Test
    public void getUuid() throws Exception {
        ResponseEntity<String> response = template.getForEntity(base + "uuid", String.class);
        assertThat(response.getBody(), isValidUUID());
    }

    @Test
    public void getUuidInBase36() throws Exception {
        ResponseEntity<String> response = template.getForEntity(base + "uuid-in-base36", String.class);
        assertNotNull(response.getBody());
    }

    @Test
    public void getUuidInBase64() throws Exception {
        ResponseEntity<String> response = template.getForEntity(base + "uuid-in-base64", String.class);
        assertNotNull(response.getBody());
    }

    @Test
    public void getTimestamp() throws Exception {
        ResponseEntity<String> response = template.getForEntity(base + "timestamp", String.class);
        assertNotNull(response.getBody());
    }

    @Test
    public void getTimestampInBase36() throws Exception {
        ResponseEntity<String> response = template.getForEntity(base + "timestamp-in-base36", String.class);
        assertNotNull(response.getBody());
    }

    @Test
    public void getTimestampInBase64() throws Exception {
        ResponseEntity<String> response = template.getForEntity(base + "timestamp-in-base64", String.class);
        assertNotNull(response.getBody());
    }

}
