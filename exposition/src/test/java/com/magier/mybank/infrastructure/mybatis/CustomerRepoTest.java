package com.magier.mybank.infrastructure.mybatis;

import com.magier.mybank.domain.customer.Customer;
import com.magier.mybank.exposition.Application;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.UUID;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class CustomerRepoTest {

    @Autowired
    private CustomerMapper customerMapper;

    @After
    public void resetCustomerTable() {
        customerMapper.deleteAllCustomers();
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
