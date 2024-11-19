package com.search.api.search.api.backend.repository;

import com.search.api.search.api.backend.model.PaymentDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<PaymentDO, Long>, JpaSpecificationExecutor<PaymentDO> {
}
