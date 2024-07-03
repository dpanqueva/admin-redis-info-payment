package com.invexdijin.admin.redis.info.payment.infraestructure.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
public class ConnectionRedisConfig {

    @Value("${spring.redis.url}")
    private String urlRedis;


    @Bean
    public JedisPool jedisPool() {

        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(10); // Número máximo de conexiones
        config.setMaxIdle(5); // Número máximo de conexiones inactivas

        JedisPool jedisPool = new JedisPool(urlRedis);
        jedisPool.setConfig(config);


        return jedisPool;
    }
}
