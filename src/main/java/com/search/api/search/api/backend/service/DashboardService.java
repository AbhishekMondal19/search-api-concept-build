package com.search.api.search.api.backend.service;

import com.search.api.search.api.backend.model.PaymentDO;
import com.search.api.search.api.backend.model.PaymentSearchCriteria;
import com.search.api.search.api.backend.repository.PaymentRepository;
import com.search.api.search.api.backend.search.spec.SearchSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class DashboardService {
    @Autowired
    private PaymentRepository paymentRepository;

    public Page<PaymentDO> searchPayments(PaymentSearchCriteria criteria, Pageable pageable) {
        Specification<PaymentDO> specification = SearchSpecification.bySearchCriteria(criteria);
        return paymentRepository.findAll(specification, pageable);
    }

}
