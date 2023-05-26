package com.example.user.javacoretraining.classes.eshop;

import java.util.List;
import java.util.Random;

public class Order {
    final int id;
    final List<Product> products;
    final ShopClient client;

    public Order(List<Product> products, ShopClient client) {
        this.id = new Random().nextInt(10000);
        this.products = products;
        this.client = client;
    }

    public int getCost() {
        int sum = 0;
        for (int i = 0; i < products.size(); i++) {
            sum += products.get(i).price;
        }
        return sum;
    }

    public void displayInfo() {
        System.out.printf("Заказ номер: %d\nКлиент: %s\nТовары: %s\n\n",
                id,
                client.toString(),
                products.toString()
        );
    }
}