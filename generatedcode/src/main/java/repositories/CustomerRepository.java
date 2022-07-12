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

package com.samkaz.heroku.mechanic.repositories;

import com.samkaz.heroku.mechanic.entity.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.stream.Stream;
import java.util.Optional;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {

    /**
     * Find all Customer(s)
     */
    List<Customer> findAll();

    /**
     * Find all Customer(s)
     */
    Page<Customer> findAll(Pageable pageable);

    /**
     * Find one Customer by Id
     */
    Optional<Customer> findById(long id);

    /**
     * Update Customer
     */
    Customer save(Customer customer);

    /**
     * Delete Customer by Id
     */
    void deleteById(long id);

    /**
     * Delete Customer
     */
    void delete(Customer customer);

}
