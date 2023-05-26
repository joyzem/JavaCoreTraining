package com.example.user.javacoretraining.classes.eshop;

class Product {
    final int id;
    final String name;
    final int price;

    public Product(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder()
                .append("Номер товара: ")
                .append(id)
                .append(", наименование: ")
                .append(name)
                .append(", цена: ")
                .append(price);
        return builder.toString();
    }
}