package com.search.api.search.api.backend.model;

import lombok.Data;

@Data
public class PaymentDO {
    private Long paymentId;
    private String reference;
    private int status;
}
