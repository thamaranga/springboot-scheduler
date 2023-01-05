package com.hasithat.springbootscheduler.service;

import com.hasithat.springbootscheduler.model.Order;
import com.hasithat.springbootscheduler.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    /*
    * This method is used to insert 20 Order  objects into db while starting the application.
    *
    * */
    @PostConstruct
    public void initDataToDb(){
        List<Order> orderList = IntStream.rangeClosed(1, 20).mapToObj(i -> new Order("order" + i, new Random().nextInt(5), new Random().nextDouble())).collect(Collectors.toList());
        orderRepository.saveAll(orderList);
    }

    public Order saveOrder(Order order){
        return orderRepository.save(order);

    }
}
