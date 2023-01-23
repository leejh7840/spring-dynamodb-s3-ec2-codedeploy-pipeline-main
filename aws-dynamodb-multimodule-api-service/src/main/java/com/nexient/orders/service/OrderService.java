package com.nexient.orders.service;

import com.nexient.orders.data.entity.Order;
import com.nexient.orders.data.repository.OrderRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getAllOrder() {
        return orderRepository.findAll();
    }

    public String saveOrder(Order order, String restaurantName) {
        System.out.println("Order placed in " + restaurantName);

        orderRepository.save(order);

        return "SUCCESS!";
    }

    public Optional<Order> getOrder(String id) {
        return orderRepository.findById(id);
    }

    public void deleteOrder(String id) {
        orderRepository.deleteById(id);
    }


    public String updateOrder(Order order, String id) {
        orderRepository.save(order);
        return "SUCCESS!";
    }
}
