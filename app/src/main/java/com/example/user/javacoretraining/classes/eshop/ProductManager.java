package com.example.user.javacoretraining.classes.eshop;

import java.util.List;

public class ProductManager {
    private final IAdminSideEShop shop;

    public ProductManager(IAdminSideEShop shop) {
        this.shop = shop;
    }

    public void addProduct(Product product) {
        shop.addProduct(product);
    }

    public void registerSale(int saleId) {
        shop.registerSale(saleId);
    }

    public void addToBlackList(ShopClient client) {
        shop.addToBlackList(client);
    }

    public List<Order> getUnpaidOrders() {
        return shop.getUnpaidOrders();
    }

    public List<Sale> getWaitingForSubmissionSales() {
        return shop.getWaitingForSubmissionSales();
    }
}