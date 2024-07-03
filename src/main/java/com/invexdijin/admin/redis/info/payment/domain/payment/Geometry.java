package com.invexdijin.admin.redis.info.payment.domain.payment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Geometry {
    private Object viewport;
    private Location location;
    private String locationType;
}
