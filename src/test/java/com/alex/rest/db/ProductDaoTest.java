package com.alex.rest.db;

import com.alex.rest.core.Product;
import io.dropwizard.testing.junit.DAOTestRule;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ProductDaoTest {
    @Rule
    public DAOTestRule daoTestRule = DAOTestRule.newBuilder()
            .addEntityClass(Product.class)
            .build();

    private ProductDao productDao;

    @Before
    public void setUp() throws Exception {
        productDao = new ProductDao(daoTestRule.getSessionFactory());
    }

    @Test
    public void createPerson() {
        final Product cellPhone =
                daoTestRule.inTransaction(() -> productDao.create(new Product("MyCellPhone")));
        assertThat(cellPhone.getId()).isGreaterThan(0);
        assertThat(cellPhone.getProductName()).isEqualTo("MyCellPhone");
    }
}
