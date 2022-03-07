package com.plaxa.spring_course.config;

import com.plaxa.spring_course.pool.ConnectionPool;
import com.plaxa.web.config.WebConfiguration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Scope;

//@ImportResource("classpath:application.xml")
@Import(WebConfiguration.class)
@Configuration()
//@PropertySource("classpath:application.properties")
/*@ComponentScan(basePackages = "com.plaxa.spring_course",
        useDefaultFilters = false,
        includeFilters = {
                @Filter(value = Component.class),
                @Filter(type = FilterType.ASSIGNABLE_TYPE, value = CrudRepository.class),
                @Filter(type = FilterType.REGEX, pattern = "com\\..+Repository")
        })*/
public class ApplicationConfiguration {

    @Bean
    @Scope(BeanDefinition.SCOPE_SINGLETON)
    public ConnectionPool pool2(@Value("${db.username}") String username) {
        return new ConnectionPool(username, 20);
    }

    @Bean
    @Scope(BeanDefinition.SCOPE_SINGLETON)
    public ConnectionPool pool3() {
        return new ConnectionPool("test", 25);
    }
}
