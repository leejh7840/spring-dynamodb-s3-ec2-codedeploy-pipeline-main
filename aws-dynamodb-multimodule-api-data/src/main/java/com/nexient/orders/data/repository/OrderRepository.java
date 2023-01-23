package com.nexient.orders.data.repository;

import java.util.List;
import java.util.Optional;

import com.nexient.orders.data.entity.Order;
import org.socialsignin.spring.data.dynamodb.repository.DynamoDBCrudRepository;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.stereotype.Repository;

@Repository
@EnableScan
public interface OrderRepository extends DynamoDBCrudRepository<Order, String> {
    Optional<Order> findById(String id);

    List<Order> findAll();



}
