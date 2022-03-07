package com.plaxa.spring_course.pool;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;
import java.util.Map;

@Slf4j
@Component(value = "pool1")
@RequiredArgsConstructor
public class ConnectionPool {

    @Value(value = "postgres")
    private final String username;
    @Value("12")
    private final Integer poolSize;

    /*public ConnectionPool(@Value("${db.username}") String username,
                          @Value("${db.pool.size}") Integer poolSize) {
        this.username = username;
        this.poolSize = poolSize;
    }*/

    @PostConstruct
    private void init() {
        log.info("init connection pool");
    }

    @PreDestroy
    private void destroy() {
        log.info("clean connection pool");
    }

}
