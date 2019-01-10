package com.bir.test;

import com.bir.client.BirWSClient;
import com.bir.client.Config;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Config.class)
public class BirClientTest {

    @Autowired
    private  BirWSClient birWSClient;

    @Test
    public void testBir() {
        String sid = birWSClient.login();
        log.info("SessionId: " + sid);
        String result = birWSClient.search("5260250274", sid);
        log.info("Search result: " + result);
        log.info("Logout successfully: " + birWSClient.logout(sid));
    }
}
