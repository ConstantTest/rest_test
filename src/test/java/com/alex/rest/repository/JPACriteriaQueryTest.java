package com.alex.rest.repository;

import com.alex.rest.config.AppConfiguration;
import com.alex.rest.domen.Invoice;
import com.alex.rest.repository.payment.InvoiceRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsIn.isIn;


//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = { AppConfiguration.class })
//@Transactional
public class JPACriteriaQueryTest {

//    @Autowired
//    private InvoiceRepository invoiceRepository;
//
//    private Invoice invoice_A;
//
//    @Before
//    public void init() {
//        invoice_A = new Invoice();
//        invoice_A.setId(2L);
//        invoice_A.setAmount(new BigDecimal(100.00));
//    }
//
//    @Test
//    public void givenAmount_whenGettingListOFInvoices_thenCorrect() {
//        List<SearchCriteria> params = new ArrayList<>();
//        params.add(new SearchCriteria("amount", ":", "100.00"));
//        params.add(new SearchCriteria("id", ":", "2L"));
//        List<Invoice> results = invoiceRepository.searchInvoice(params);
//        assertThat(invoice_A, isIn(results));
//    }
//
//    @Test
//    public void givenId_whenGettingListOfInvoices_thenCorrect() {
//        List<SearchCriteria> params = new ArrayList<>();
//        params.add(new SearchCriteria("amount", ":", "100.00"));
//        params.add(new SearchCriteria("id", ">", "1L"));
//        List<Invoice> results = invoiceRepository.searchInvoice(params);
//
//        assertThat(invoice_A, isIn(results));
//    }
}
