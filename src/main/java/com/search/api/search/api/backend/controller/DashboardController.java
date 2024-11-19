package com.search.api.search.api.backend.controller;

import com.search.api.search.api.backend.model.PaymentDO;
import com.search.api.search.api.backend.model.PaymentSearchCriteria;
import com.search.api.search.api.backend.service.DashboardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class DashboardController {
    @Autowired
    private DashboardService dashboardService;

    @GetMapping("/payments/dashboard")
    public ResponseEntity<Page<PaymentDO>> getPayments(
            PaymentSearchCriteria criteria,
            @PageableDefault(size = 20) Pageable pageable) {
        Page<PaymentDO> payments = dashboardService.searchPayments(criteria, pageable);
        return ResponseEntity.ok(payments);
    }

}
