package com.gmaslowski.sdp;

import com.gmaslowski.sdp.model.Basket;
import com.gmaslowski.sdp.model.Customer;
import com.gmaslowski.sdp.model.Product;
import com.gmaslowski.sdp.repository.CustomerRepository;
import com.gmaslowski.sdp.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringDataPlayground {

    public static void main(String[] args) {
        SpringApplication.run(SpringDataPlayground.class);
    }

    @Bean
    public CommandLineRunner initSampleData(final CustomerRepository customerRepository,
                                            final ProductRepository productRepository) {
        return (args) -> {

            // create and save some products
            Product cearials = productRepository.save(new Product("Cearials", "Breakfest"));
            Product hamburger = productRepository.save(new Product("Hamburger", "Lunch"));
            Product wine = productRepository.save(new Product("Wine", "Dinner"));

            // create customers
            Customer johnDoe = new Customer("John Doe");
            Customer janeDoe = new Customer("Jane Doe");

            // create customer baskets
            Basket janeBasket = new Basket();
            janeBasket.addProduct(cearials, 3L);
            janeBasket.addProduct(hamburger, 1L);
            janeDoe.setBasket(janeBasket);

            Basket johnBasket = new Basket();
            johnBasket.addProduct(cearials, 1L);
            johnBasket.addProduct(hamburger, 18L);
            johnBasket.addProduct(wine, 101L);
            johnDoe.setBasket(johnBasket);

            // save the customers with baskets
            customerRepository.save(johnDoe);
            customerRepository.save(janeDoe);
        };
    }
}
