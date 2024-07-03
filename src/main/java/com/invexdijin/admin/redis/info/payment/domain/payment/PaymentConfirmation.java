package com.invexdijin.admin.redis.info.payment.domain.payment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PaymentConfirmation {
    private String fullName;
    private String firstName;
    private String lastName;
    private String state;
    private String documentNumber;
    private String documentType;
    private String attorneyOfficeLegend;
    private String policeDetail;
    private String publicSpendingWatchdogMessage;
    private String address;
    private String department;
    private String municipality;
    private Geometry geometry;
    private String transStatus;
}
