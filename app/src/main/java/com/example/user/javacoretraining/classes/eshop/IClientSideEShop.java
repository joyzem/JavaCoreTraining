package com.example.user.javacoretraining.classes.eshop;

import java.util.List;

public interface IClientSideEShop {
    void createOrder(List<Product> products, ShopClient client) throws IllegalArgumentException, UserInBlackListException;
    void payOrder(Order order);
    List<Product> getProducts();
    List<Order> getClientOrders(int clientId);
    Product getProductById(int productId);
}