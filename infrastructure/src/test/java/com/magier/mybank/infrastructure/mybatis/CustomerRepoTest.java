package com.magier.mybank.infrastructure.mybatis;

import com.magier.mybank.domain.customer.Customer;
import com.magier.mybank.infrastructure.config.AppConfig;
import liquibase.Liquibase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
public class CustomerRepoTest {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private CustomerMapper customerMapper;

    private Optional<Liquibase> liquibase;



    @Before
    public void _setUp() throws Exception
    {
        liquibase = LiquibaseHelper.loadData(dataSource,
                "db/changelog/db.changelog-master.yaml");
    }

    //@After
    public void resetCustomerTable() {
        customerMapper.deleteAllCustomers();
    }

   // @After
    public void _tearDown() throws Exception
    {
        LiquibaseHelper.rollbackAndClose(liquibase);
    }

    @Test
    public void createUser() {
        Customer customer = new Customer();
        customer.setUuid(UUID.randomUUID());
        customer.setFirstName("Anderson");
        customer.setLastName("SILVA");
        customer.setEmail("anderson.silva@gmail.com");
        customerMapper.createCustomer(customer);

        Customer newCustomer = customerMapper.findByEMail(customer.getEmail());
        assertEquals("SILVA", newCustomer.getLastName());
        assertEquals("anderson.silva@gmail.com", newCustomer.getEmail());
    }

    @Test
    public void findAllCustomers() {
        Customer customer = new Customer();
        customer.setUuid(UUID.randomUUID());
        customer.setFirstName("Anderson");
        customer.setLastName("Mister");
        customer.setEmail("mister.anderson@gmail.com");
        customerMapper.createCustomer(customer);

        List<Customer> customers = customerMapper.findAll();
        assertNotNull(customers);
        assertTrue(!customers.isEmpty());
    }

    @Test
    public void findUserByEmail() {
        Customer customer = new Customer();
        customer.setUuid(UUID.randomUUID());
        customer.setFirstName("Eric");
        customer.setLastName("SILVA");
        customer.setEmail("eric.silva@gmail.com");
        customerMapper.createCustomer(customer);

        Customer expectedCustomer = customerMapper.findByEMail("eric.silva@gmail.com");
        assertNotNull(expectedCustomer);
    }
}
