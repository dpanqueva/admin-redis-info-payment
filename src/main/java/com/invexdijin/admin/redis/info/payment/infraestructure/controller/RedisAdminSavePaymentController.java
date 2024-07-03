package com.invexdijin.admin.redis.info.payment.infraestructure.controller;

import com.invexdijin.admin.redis.info.payment.application.adapters.PaymentConfirmationServicePort;
import com.invexdijin.admin.redis.info.payment.domain.payment.PaymentConfirmation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/v1/invexdijin")
public class RedisAdminSavePaymentController {

    private final PaymentConfirmationServicePort servicePort;

    @Autowired
    public RedisAdminSavePaymentController(PaymentConfirmationServicePort servicePort) {
        this.servicePort = servicePort;
    }


    @PostMapping("/save-payment-info/{keySignature}")
    public ResponseEntity<?> savePaymentInfo(@PathVariable String keySignature, @RequestBody PaymentConfirmation paymentConfirmation) {
        servicePort.saveConfirmation(keySignature, paymentConfirmation);
        return ResponseEntity.created(URI.create("/api/v1/invexdijin/save-payment-info"))
                .body(paymentConfirmation);
    }

    @GetMapping("/payment-info/{keySignature}")
    public ResponseEntity<?> paymentInfo(@PathVariable String keySignature) {
        return ResponseEntity.ok(servicePort.getConfirmation(keySignature));

    }
}
