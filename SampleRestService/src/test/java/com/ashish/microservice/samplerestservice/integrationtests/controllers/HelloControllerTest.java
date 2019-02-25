package com.ashish.microservice.samplerestservice.integrationtests.controllers;

import com.ashish.microservice.samplerestservice.controllers.HelloController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
// this class uses a random port and start the server at that random port. The testRestTemplate is
// trying to access the resource deployed on that port
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HelloControllerTest {

  @LocalServerPort private int port;

  @Autowired private HelloController helloController;

  @Autowired private TestRestTemplate restTemplate;

  @Test
  public void helloControllerInjection() {
    assertNotNull(helloController);
  }

  @Test
  public void greetingShallReturnDefaultMessage() {
    final String url = "http://localhost:" + port + "/hello";
    final String responseMessage = "Hello World";
    assertTrue(this.restTemplate.getForObject(url, String.class).contains(responseMessage));
  }
}
