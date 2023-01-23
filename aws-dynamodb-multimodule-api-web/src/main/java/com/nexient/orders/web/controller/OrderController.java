package com.nexient.orders.web.controller;

import com.nexient.orders.data.entity.Order;
import com.nexient.orders.service.OrderService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class OrderController {

    @Autowired
    private final OrderService orderService;

    @GetMapping("/all-orders")
    public List<Order> getAllOrder() { return orderService.getAllOrder(); }

    @PostMapping("/make-order/{restaurantName}")
    public String saveOrder(@RequestBody Order order, @PathVariable String restaurantName) {
        return orderService.saveOrder(order, restaurantName);
    }

    @GetMapping("/get-order/{id}")
    public Optional<Order> getOrder(@PathVariable String id) {
        return orderService.getOrder(id);
    }

    @DeleteMapping("/delete-order/{id}")
    public String deleteOrder(@PathVariable String id) {

        orderService.deleteOrder(id);
        return "Deleted Record Successfully";
    }
    @PutMapping("update-order/{id}")
    public String updateOrder(@RequestBody Order order, @PathVariable String id) {
        return orderService.updateOrder(order, id);
    }


}
