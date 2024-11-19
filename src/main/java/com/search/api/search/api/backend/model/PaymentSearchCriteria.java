package com.search.api.search.api.backend.model;

import lombok.Data;

import java.util.Date;

@Data
public class PaymentSearchCriteria {
    private String status;
    private String cardType;
    private Date fromDate;
    private Date toDate;
    private String searchKeyword;
}
