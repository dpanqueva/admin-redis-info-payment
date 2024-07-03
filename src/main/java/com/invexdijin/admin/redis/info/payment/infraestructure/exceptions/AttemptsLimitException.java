package com.invexdijin.admin.redis.info.payment.infraestructure.exceptions;

public class AttemptsLimitException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public AttemptsLimitException() {

    }

    public AttemptsLimitException(String message) {
        super(message);
    }
}
