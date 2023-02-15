package com.plaxa.spring_course.rabbitmq;

import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfiguration {

//    Logger logger = LoggerFactory.getLogger(RabbitConfiguration.class);
//
//    @Bean
//    public ConnectionFactory connectionFactory() {
//        return new CachingConnectionFactory("localhost");
//    }
//
//    @Bean
//    public AmqpAdmin amqpAdmin() {
//        return new RabbitAdmin(connectionFactory());
//    }
//
//    @Bean
//    public RabbitTemplate rabbitTemplate() {
//        return new RabbitTemplate(connectionFactory());
//    }
//
//    @Bean
//    public Queue myQueue1() {
//        return new Queue("myQueue1");
//    }
//
//    @Bean
//    public Queue myQueue2() {
//        return new Queue("myQueue2");
//    }
//
//    @Bean
//    public FanoutExchange fanoutExchange() {
//        return new FanoutExchange("common-exchange");
//    }

    /*
     * my own broker
     */
    /*@Bean
    public SimpleMessageListenerContainer messageListenerContainer() {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory());
        container.setQueueNames("myQueue");
        container.setMessageListener(message -> logger.info("Received from myQueue : " + new String(message.getBody())));
        return container;
    }*/

}
