package com.invexdijin.admin.redis.info.payment.application.adapters;

import com.invexdijin.admin.redis.info.payment.domain.payment.PaymentConfirmation;

import java.util.Optional;

public interface PaymentConfirmationServicePort {

    void saveConfirmation(String keySignature,PaymentConfirmation confirmation);

    Optional<PaymentConfirmation> getConfirmation(String keySignature);
}
