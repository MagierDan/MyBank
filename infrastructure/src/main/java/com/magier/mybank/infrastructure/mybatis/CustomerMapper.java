package com.magier.mybank.infrastructure.mybatis;

import com.magier.mybank.domain.customer.Customer;
import com.magier.mybank.domain.customer.CustomerRepository;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface CustomerMapper extends CustomerRepository{

    @Insert("insert into customer(uuid, firstName, lastName, email) values(#{uuid, typeHandler=com.magier.mybank.infrastructure.mybatis.UUIDTypeHandler, javaType=java.util.UUID, jdbcType=OTHER},#{firstName},#{lastName},#{email})")
    void createCustomer(Customer customer);

    @Select("select * from customer")
    List<Customer> findAll();

    @Select("SELECT * FROM CUSTOMER WHERE email = #{email}")
    Customer findByEMail(@Param("email") String email);

    @Delete("TRUNCATE TABLE customer")
    void deleteAllCustomers();
}

