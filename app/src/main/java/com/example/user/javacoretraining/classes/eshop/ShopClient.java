package com.example.user.javacoretraining.classes.eshop;

import java.util.List;

public class ShopClient {
    final int id;
    private final IClientSideEShop shop;
    private int balance = 0;

    public ShopClient(int id, IClientSideEShop shop) {
        this.id = id;
        this.shop = shop;
    }

    public void createOrder(List<Product> products) throws UserInBlackListException {
        shop.createOrder(products, this);
    }

    public void payOrder(Order order) throws IllegalArgumentException {
        if (minusBalance(order.getCost())) {
            shop.payOrder(order);
        } else {
            throw new IllegalArgumentException("Недостаточно средств");
        }
    }

    public List<Product> getProducts() {
        return shop.getProducts();
    }

    public void fillBalance(int value) {
        balance += value;
    }

    /**
     * @param value
     * @return true if client has enough money, otherwise - false
     */
    public boolean minusBalance(int value) {
        if (value > balance) {
            return false;
        } else {
            balance -= value;
            return true;
        }
    }

    public int getBalance() {
        return balance;
    }

    public Product getProductById(int id) {
        return shop.getProductById(id);
    }

    public List<Order> getClientOrders(int id) {
        return shop.getClientOrders(id);
    }
}