package com.example.initializers;


import com.example.entities.Product;
import com.example.repositories.ProductRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductBaseInitializer {
    @Autowired
    private ProductRepository productRepository;
    @PostConstruct
    public void init() {
        Product product1 = new Product();
        product1.setId(1);
        product1.setName("Худи из хлопкового футера c карманом-кенгуру");
        product1.setBrand("HUGO");
        product1.setProductPrice("15900");

        Product product2 = new Product();
        product2.setId(2);
        product2.setName("Шорты с карманами");
        product2.setBrand("Blend");
        product2.setProductPrice("4490");

        Product product3 = new Product();
        product3.setId(3);
        product3.setName("Футболка хлопковая с логотипом");
        product3.setBrand("Calvin Klein");
        product3.setProductPrice("4190");

        Product product4 = new Product();
        product4.setId(4);
        product4.setName("Футболка хлопковая с принтом");
        product4.setBrand("Desigual");
        product4.setProductPrice("2900");

        Product product5 = new Product();
        product5.setId(5);
        product5.setName("Бейсболка хлопковая");
        product5.setBrand("Superdry");
        product5.setProductPrice("1900");

        Product product6 = new Product();
        product6.setId(6);
        product6.setName("Футболка хлопковая");
        product6.setBrand("Gloria Jeans");
        product6.setProductPrice("2700");

        Product product7 = new Product();
        product7.setId(7);
        product7.setName("Сумка через плечо");
        product7.setBrand("BOSS");
        product7.setProductPrice("11900");

        Product product8 = new Product();
        product8.setId(8);
        product8.setName("Брюки на кулиске с защипами");
        product8.setBrand("MARCO DI RADI");
        product8.setProductPrice("6700");

        Product product9 = new Product();
        product9.setId(9);
        product9.setName("Худи из смесового хлопка");
        product9.setBrand("Champion");
        product9.setProductPrice("8900");

        Product product10 = new Product();
        product10.setId(10);
        product10.setName("Хлопковая футболка с принтом");
        product10.setBrand("REEBOK");
        product10.setProductPrice("2390");
        productRepository.save(product1);
        productRepository.save(product2);
        productRepository.save(product3);
        productRepository.save(product4);
        productRepository.save(product5);
        productRepository.save(product6);
        productRepository.save(product7);
        productRepository.save(product8);
        productRepository.save(product9);
        productRepository.save(product10);
    }
}
