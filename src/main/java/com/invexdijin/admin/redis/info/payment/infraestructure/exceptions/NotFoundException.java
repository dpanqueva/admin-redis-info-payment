package com.invexdijin.admin.redis.info.payment.infraestructure.exceptions;

public class NotFoundException  extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public NotFoundException() {

    }

    public NotFoundException(String message) {
        super(message);
    }
}
