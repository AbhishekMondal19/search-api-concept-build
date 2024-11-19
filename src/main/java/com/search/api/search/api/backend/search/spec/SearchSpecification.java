package com.search.api.search.api.backend.search.spec;

import com.search.api.search.api.backend.model.PaymentDO;
import com.search.api.search.api.backend.model.PaymentSearchCriteria;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

public class SearchSpecification {
    public static Specification<PaymentDO> bySearchCriteria(PaymentSearchCriteria criteria) {
        return (root, query, cb) -> {
            Predicate predicate = cb.conjunction(); // Start with an empty predicate

            if (criteria.getStatus() != null) {
                predicate = cb.and(predicate, cb.equal(root.get("status"), criteria.getStatus()));
            }
            if (criteria.getCardType() != null) {
                predicate = cb.and(predicate, cb.equal(root.get("cardType"), criteria.getCardType()));
            }
            if (criteria.getFromDate() != null && criteria.getToDate() != null) {
                predicate = cb.and(predicate,
                        cb.between(root.get("paymentDate"), criteria.getFromDate(), criteria.getToDate()));
            }
            if (criteria.getSearchKeyword() != null) {
                predicate = cb.and(predicate, cb.like(root.get("acctType"), "%" + criteria.getSearchKeyword() + "%"));
            }
            // Add more conditions as needed
            return predicate;
        };
    }
}
