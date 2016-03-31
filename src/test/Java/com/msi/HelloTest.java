package com.msi;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import java.net.URL;

/**
 * Created by Administrator on 2016/3/31.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = HelloApplication.class)
@WebAppConfiguration
@IntegrationTest({"server.port=0"})
public class HelloTest {
    @Value("${local.server.port}")
    private int port;
    private URL base;
    private RestTemplate template;

    @Before
    public void setUp() throws Exception{
        this.base = new URL("http://localhost:"+port+"/");
        template = new TestRestTemplate();
    }

    @Test
    public void index() throws Exception {
        ResponseEntity<String> response = template.getForEntity(base.toString(), String.class);
        Assert.assertThat(response.getBody(), Matchers.equalTo("Hello World!"));
    }
}
