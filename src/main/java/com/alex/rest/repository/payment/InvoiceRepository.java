package com.alex.rest.repository.payment;

import com.alex.rest.domen.Invoice;
import com.alex.rest.repository.RepositoryImpl;
import com.alex.rest.repository.SearchCriteria;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class InvoiceRepository extends RepositoryImpl<Invoice> {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Invoice> searchInvoice(List<SearchCriteria> params) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Invoice> query = builder.createQuery(Invoice.class);
        Root r = query.from(Invoice.class);

        Predicate predicate = builder.conjunction();

        for (SearchCriteria param: params) {
            if (param.getOperation().equalsIgnoreCase(">")) {
                predicate = builder.and(predicate, builder.greaterThanOrEqualTo(r.get(param.getKey()), param.getValue()));
            } else if (param.getOperation().equalsIgnoreCase("<")) {
                predicate = builder.and(predicate, builder.lessThanOrEqualTo(r.get(param.getKey()), param.getValue().toString()));
            } else if (param.getOperation().equalsIgnoreCase(":")) {
                if (r.get(param.getKey()).getJavaType() == String.class) {
                    predicate = builder.and(predicate,
                            builder.like(r.get(param.getKey()),
                                    "%" + param.getValue() + "%"));
                } else {
                    predicate = builder.and(predicate,
                            builder.equal(r.get(param.getKey()), param.getValue()));
                }
            }
        }
        query.where(predicate);
        System.out.println(entityManager.createQuery(query).getResultList());

        return entityManager.createQuery(query).getResultList();
    }
}
