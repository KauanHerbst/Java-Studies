package br.herbst.project.config;

import br.herbst.project.entities.Order;
import br.herbst.project.entities.User;
import br.herbst.project.repositories.OrderRepository;
import br.herbst.project.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.Instant;
import java.util.Arrays;

@Configuration
public class Config implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void run(String... args) throws Exception {
        User user1 = new User();
        user1.setName("kauan");
        user1.setEmail("Kauangouveias@gmail.com");
        user1.setIdade(20);
        user1.setEstado("Rio de Janeiro");
        User user2 = new User();
        user2.setName("Herbst");
        user2.setEmail("HerbstKauan@gmail.com");
        user2.setIdade(19);
        user2.setEstado("Pará");

        userRepository.saveAll(Arrays.asList(user1,user2));


        Order order1 = new Order();
        order1.setClient(user1);
        order1.setInstant(Instant.now());
        Order order2 = new Order();
        order2.setClient(user2);
        order2.setInstant(Instant.now());
        Order order3 = new Order();
        order3.setClient(user2);
        order3.setInstant(Instant.now());
        orderRepository.saveAll(Arrays.asList(order1, order2, order3));
    }
}
