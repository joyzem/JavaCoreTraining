package com.example.user.javacoretraining.classes.eshop;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShopClientUi implements UI {
    final ShopClient client;
    private UiState uiState = UiState.MAIN;

    public ShopClientUi(ShopClient client) {
        this.client = client;
    }

    @Override
    public UserType render() {
        switch (uiState) {
            case MAIN: {
                switch (mainMenu()) {
                    case 0: {
                        return UserType.NONE;
                    }
                    case 1: {
                        return UserType.MANAGER;
                    }
                    case 2: {
                        uiState = UiState.GET_PRODUCTS;
                        return UserType.CLIENT;
                    }
                    case 3: {
                        uiState = UiState.CREATE_ORDER;
                        return UserType.CLIENT;
                    }
                    case 4: {
                        uiState = UiState.PAY_ORDER;
                        return UserType.CLIENT;
                    }
                    case 5: {
                        uiState = UiState.SEE_BALANCE;
                        return UserType.CLIENT;
                    }
                    case 6: {
                        uiState = UiState.FILL_BALANCE;
                        return UserType.CLIENT;
                    }
                }
            }
            case GET_PRODUCTS: {
                printProducts();
                uiState = UiState.MAIN;
                return UserType.CLIENT;
            }
            case CREATE_ORDER: {
                createOrder();
                uiState = UiState.MAIN;
                return UserType.CLIENT;
            }
            case PAY_ORDER: {
                payOrder();
                uiState = UiState.MAIN;
                return UserType.CLIENT;
            }
            case SEE_BALANCE: {
                seeBalance();
                uiState = UiState.MAIN;
                return UserType.CLIENT;
            }
            case FILL_BALANCE: {
                fillBalance();
                seeBalance();
                uiState = UiState.MAIN;
                return UserType.CLIENT;
            }
            default: {
                return UserType.CLIENT;
            }
        }
    }

    private void fillBalance() {
        System.out.print("Введите сумму для пополнения: ");
        Scanner scanner = new Scanner(System.in);
        int value = scanner.nextInt();
        client.fillBalance(value);
    }

    private int mainMenu() {
        System.out.print(
                "0 – Закончить программу\n"
                        + "1 – Перейти в режим продавца\n"
                        + "2 – Получить список товаров\n"
                        + "3 – Создать заказ\n"
                        + "4 – Оплатить заказ\n"
                        + "5 – Посмотреть баланс\n"
                        + "6 – Пополнить баланс\n"
                        + "Ввод: "
        );
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        return choice;
    }

    private void printProducts() {
        List<Product> products = client.getProducts();
        System.out.println(products.toString());
    }

    private void createOrder() {
        System.out.println("Список товаров:");
        printProducts();

        System.out.print("Перечислите номера товаров через пробел: ");
        Scanner scanner = new Scanner(System.in);
        String[] productsIds = scanner.nextLine().split(" ");

        List<Product> orderProducts = new ArrayList<>();
        for (String productId : productsIds) {
            try {
                Product product = client.getProductById(Integer.decode(productId));
                orderProducts.add(product);
            } catch (Exception e) {
                System.out.printf("Товара с номером \"%s\" не существует.\n", productId);
            }
        }

        try {
            client.createOrder(orderProducts);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void payOrder() {
        System.out.println("Ваши заказы: ");
        List<Order> clientOrders = client.getClientOrders(client.id);
        for (Order clientOrder : clientOrders) {
            clientOrder.displayInfo();
        }

        System.out.print("Введите номер заказа, который вы хотите оплатить, или 0, чтобы выйти: ");
        Scanner scanner = new Scanner(System.in);
        int orderId = scanner.nextInt();
        if (orderId == 0) {
            return;
        }

        Order order = null;
        for (Order clientOrder : clientOrders) {
            if (clientOrder.id == orderId) {
                order = clientOrder;
            }
        }
        if (order != null) {
            try {
                client.payOrder(order);
                System.out.println("Ваш заказ оплачен. Подождите, пока его зарегистрирует продавец.");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void seeBalance() {
        System.out.printf("Ваш баланс: %d\n", client.getBalance());
    }

    private enum UiState {
        MAIN,
        GET_PRODUCTS,
        CREATE_ORDER,
        PAY_ORDER,
        SEE_BALANCE,
        FILL_BALANCE
    }
}