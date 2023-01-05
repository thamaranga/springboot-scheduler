package com.hasithat.springbootscheduler.controller;

import com.hasithat.springbootscheduler.model.Order;
import com.hasithat.springbootscheduler.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {


    @Autowired
    private OrderService  orderService;

    /*
    * This method is used for inserting order object into db.
    * This method is not related to scheduling implementation.
    * */
    @PostMapping("/")
    public Order addOrder(@RequestBody Order order){
        return orderService.saveOrder(order);

    }


}
