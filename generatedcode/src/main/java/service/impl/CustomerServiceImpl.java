/*
 * [nw] Syed Kazmi
 *
 * Copyright (c) 2022.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of The New Waves
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with The New Wave.
 *
 */

package com.samkaz.heroku.mechanic.service.impl;

import com.samkaz.heroku.mechanic.dto.CustomerDto;
import com.samkaz.heroku.mechanic.entity.Customer;
import com.samkaz.heroku.mechanic.repositories.CustomerRepository;
import com.samkaz.heroku.mechanic.service.CustomerService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;


@Service("customerService")
@org.springframework.transaction.annotation.Transactional
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    CustomerRepository customerRepository;

    /**
     * Find all Customer(s)
     */
    @Override
    public List<CustomerDto> findAll(){
        List<Customer> customerList = customerRepository.findAll();
            if (customerList != null && !customerList.isEmpty()){
                return modelMapper.map(customerList, ArrayList.class);
            }
        return Collections.emptyList();
    }

    /**
     * Find all Customer(s)
     */
    @Override
    public Page<CustomerDto> findAll(Pageable pageable){
        return null;
    }

    /**
     * Find one Customer by Id
     */
    @Override
    public Optional<CustomerDto> findOne(long id){
        Optional<Customer> customer = customerRepository.findById(id);
        if (customer != null){
            return modelMapper.map(customer, Optional.class);
        }
        return null;
    }

    /**
     * Update Customer
     */
    @Override
    public void save(CustomerDto customerDto){
        if (customerDto != null){
            Customer customer = modelMapper.map(customerDto, Customer.class);
            customerRepository.save(customer);
        }
    }

    /**
     * Delete Customer by Id
     */
    @Override
    public void deleteById(long id){
        customerRepository.deleteById(id);
    }

    /**
     * Delete Customer
     */
    @Override
    public void delete(CustomerDto customerDto){
        if (customerDto != null){
            Customer customer = modelMapper.map(customerDto, Customer.class);
            customerRepository.delete(customer);
        }
    }

}
