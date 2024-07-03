package com.invexdijin.admin.redis.info.payment.domain.ports;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.invexdijin.admin.redis.info.payment.application.adapters.PaymentConfirmationServicePort;
import com.invexdijin.admin.redis.info.payment.domain.payment.PaymentConfirmation;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.time.Duration;
import java.util.Objects;
import java.util.Optional;

@Service
public class PaymentConfirmationRedisAdapter implements PaymentConfirmationServicePort {

    @Value("${payment.time.delete}")
    private int paymentTimeDelete;

    private final JedisPool jedisPool;
    private final ObjectMapper mapper;

    @Autowired
    public PaymentConfirmationRedisAdapter(JedisPool jedisPool,
                                           ObjectMapper mapper) {
        this.jedisPool = jedisPool;
        this.mapper = mapper;
    }

    @SneakyThrows
    @Override
    public void saveConfirmation(String keySignature,PaymentConfirmation confirmation) {
        try (Jedis jedis = jedisPool.getResource()) {
            String key = "payment-confirmation:" + keySignature;
            String value = mapper.writeValueAsString(confirmation);
            jedis.setex(key, Duration.ofMinutes(paymentTimeDelete).toSeconds(), value);
        }
    }

    @SneakyThrows
    @Override
    public Optional<PaymentConfirmation> getConfirmation(String keySignature) {
        try (Jedis jedis = jedisPool.getResource()) {
            String key = "payment-confirmation:" + keySignature;
            String value = jedis.get(key);
            if (Objects.nonNull(value)) {
                return Optional.of(mapper.readValue(value, PaymentConfirmation.class));
            } else {
                return Optional.empty();
            }
        }
    }
}
