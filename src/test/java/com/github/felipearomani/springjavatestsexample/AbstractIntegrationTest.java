package com.github.felipearomani.springjavatestsexample;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.testcontainers.containers.GenericContainer;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@ActiveProfiles(profiles = "test")
public abstract class AbstractIntegrationTest {

    static {
        GenericContainer mysql = new GenericContainer<>("mysql:5.7")
                .withExposedPorts(3306)
                .withEnv("MYSQL_ROOT_PASSWORD", "123456");

        mysql.start();

        Integer exposedPort = mysql.getMappedPort(3306);

        System.setProperty("spring.datasource.url","jdbc:mysql://localhost:" + exposedPort + "/task_db?createDatabaseIfNotExist=true&useSSL=false");
    }
}
