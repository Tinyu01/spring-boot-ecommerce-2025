package org.amazon.ecommerce.product.controller;

import org.amazon.ecommerce.product.entity.Product;
import org.amazon.ecommerce.product.service.ProductService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
public class GraphQLController {

    private final ProductService productService;

    public GraphQLController(ProductService productService) {
        this.productService = productService;
    }

    @QueryMapping
    public Flux<Product> products() {
        return Flux.fromIterable(productService.getAllProducts());
    }

    @QueryMapping
    public Mono<Product> productById(@Argument Long id) {
        return Mono.justOrEmpty(productService.getProductById(id));
    }

    @MutationMapping
    public Mono<Product> addProduct(@Argument String name, @Argument double price) {
        return Mono.just(productService.addProduct(new Product(name, price)));
    }
}