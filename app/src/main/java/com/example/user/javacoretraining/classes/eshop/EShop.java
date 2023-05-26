package com.example.user.javacoretraining.classes.eshop;

import java.util.ArrayList;
import java.util.List;

public class EShop implements IAdminSideEShop, IClientSideEShop {
    private final List<ShopClient> blackList = new ArrayList<>();
    private final List<Product> products = ProductsRepo.products;
    private final List<Sale> sales = new ArrayList<>();
    private final List<Sale> waitingForSubmissionSales = new ArrayList<>();
    private final List<Order> unpaidOrders = new ArrayList<>();

    @Override
    public void addProduct(Product product) {
        products.add(product);
    }

    @Override
    public void registerSale(int saleId) {
        for (Sale sale : waitingForSubmissionSales) {
            if (sale.id == saleId) {
                sales.add(sale);
                waitingForSubmissionSales.remove(sale);
                break;
            }
        }
    }

    @Override
    public void addToBlackList(ShopClient client) {
        blackList.add(client);
    }

    @Override
    public List<Order> getUnpaidOrders() {
        return unpaidOrders;
    }

    @Override
    public List<Sale> getWaitingForSubmissionSales() {
        return waitingForSubmissionSales;
    }

    @Override
    public Order getOrderById(int id) throws IllegalArgumentException {
        for (Order unpaidOrder : unpaidOrders) {
            if (unpaidOrder.id == id) {
                return unpaidOrder;
            }
        }
        throw new IllegalArgumentException("No such order");
    }

    @Override
    public void createOrder(List<Product> products, ShopClient client) throws UserInBlackListException, IllegalArgumentException {
        if (products.isEmpty()) {
            throw new IllegalArgumentException();
        }
        if (blackList.contains(client)) {
            throw new UserInBlackListException();
        }
        for (int i = 0; i < unpaidOrders.size(); i++) {
            if (unpaidOrders.get(i).client.id == client.id) {
                blackList.add(client);
                throw new UserInBlackListException();
            }
        }
        Order order = new Order(products, client);
        unpaidOrders.add(order);
    }

    @Override
    public void payOrder(Order order) {
        Sale sale = new Sale(order);
        waitingForSubmissionSales.add(sale);
        unpaidOrders.remove(order);
    }

    @Override
    public List<Product> getProducts() {
        return products;
    }

    @Override
    public List<Order> getClientOrders(int clientId) {
        List<Order> userOrders = new ArrayList<>();
        for (Order unpaidOrder : unpaidOrders) {
            if (unpaidOrder.client.id == clientId) {
                userOrders.add(unpaidOrder);
            }
        }
        return userOrders;
    }

    @Override
    public Product getProductById(int productId) throws IllegalArgumentException {
        for (Product product : products) {
            if (product.id == productId) {
                return product;
            }
        }
        throw new IllegalArgumentException();
    }
}