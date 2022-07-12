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

package com.samkaz.heroku.mechanic.service;

import com.samkaz.heroku.mechanic.dto.CustomerDto;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.Optional;


public interface CustomerService{

    /**
     * Find all Customer(s)
     */
    List<CustomerDto> findAll();

    /**
     * Find all Customer(s)
     */
    Page<CustomerDto> findAll(Pageable pageable);

    /**
     * Find one Customer by Id
     */
    Optional<CustomerDto> findOne(long id);

    /**
     * Update Customer
     */
    void save(CustomerDto customerDto);

    /**
     * Delete Customer by Id
     */
    void deleteById(long id);

    /**
     * Delete Customer
     */
    void delete(CustomerDto customerDto);

}
