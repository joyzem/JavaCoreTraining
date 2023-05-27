package com.example.user.javacoretraining.classes.eshop;

import java.util.Random;

class Sale {
    final int id;
    final Order order;

    public Sale(Order order) {
        id = new Random().nextInt(10000);
        this.order = order;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder()
                .append("Номер продажи: ")
                .append(id)
                .append(", заказ: ")
                .append(order.toString());
        return builder.toString();
    }
}