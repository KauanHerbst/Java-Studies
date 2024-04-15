package br.herbst.project.services;

import br.herbst.project.entities.Order;
import br.herbst.project.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public List<Order> findAll(){
        return orderRepository.findAll();
    }

    public Order findById(Long id){
        Optional<Order> order = orderRepository.findById(id);
        return order.get();
    }

    public Order insert(Order order){
        order.setInstant(Instant.now());
        return orderRepository.save(order);
    }

    public void delete(Long id){

    }
}
