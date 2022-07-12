
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
package com.samkaz.heroku.mechanic.controller;

import com.samkaz.heroku.mechanic.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    protected final static String REQ_CUSTOMER_LIST = "customer-list";
    protected final static String REQ_CUSTOMER_ADD = "customer-add";
    protected final static String REQ_CUSTOMER_EDIT = "customer-edit";
    protected final static String REQ_CUSTOMER_REMOVE = "customer-remove";

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = {REQ_CUSTOMER_LIST}, method = RequestMethod.GET)
    public String listCustomerPage(ModelMap model) {
        model.addAttribute("customer", customerService.findAll());
        return REQ_CUSTOMER_LIST;
    }

    @RequestMapping(value = {REQ_CUSTOMER_ADD}, method = RequestMethod.GET)
    public String addCustomerPage(ModelMap model) {
        return REQ_CUSTOMER_ADD;
    }

    @RequestMapping(value = {REQ_CUSTOMER_EDIT}, method = RequestMethod.GET)
    public String editCustomerPage(ModelMap model) {
        return REQ_CUSTOMER_EDIT;
    }

    @RequestMapping(value = {REQ_CUSTOMER_REMOVE}, method = RequestMethod.GET)
    public String removeCustomerPage(ModelMap model) {
        return REQ_CUSTOMER_REMOVE;
    }

}
