package com.example.user.javacoretraining.classes.eshop;

import java.util.List;

public interface IAdminSideEShop {
    void addProduct(Product product);
    void registerSale(int saleId);
    void addToBlackList(ShopClient client);
    List<Order> getUnpaidOrders();
    Order getOrderById(int id);
    List<Sale> getWaitingForSubmissionSales();
}