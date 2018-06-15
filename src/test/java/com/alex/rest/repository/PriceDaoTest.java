package com.alex.rest.repository;

import com.alex.rest.domen.Price;
import com.alex.rest.repository.payment.PriceRepository;
import io.dropwizard.testing.junit.DAOTestRule;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class PriceDaoTest {
//    @Rule
//    public DAOTestRule daoTestRule = DAOTestRule.newBuilder()
//            .addEntityClass(Price.class)
//            .build();
//
//    private PriceRepository priceDao;
//
//    @Before
//    public void setUp() throws Exception {
//        priceDao = new PriceRepository();
//    }
//
//    @Test
//    public void createPerson() {
//        final Price price =
//                daoTestRule.inTransaction(() -> priceDao.create(new Price().setAmount(new BigDecimal(199.00))));
//        assertThat(price.getId()).isGreaterThan(0);
//        assertThat(price.getCurrency()).isEqualTo("USD");
//        assertThat(price.getProductId()).isEqualTo(1);
//    }
}
