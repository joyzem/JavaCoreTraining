package com.example.user.javacoretraining.classes.eshop;

import java.util.List;
import java.util.Scanner;

public class ProductManagerUi implements UI {
    private final ProductManager manager;
    private UiState uiState = UiState.MAIN;

    public ProductManagerUi(ProductManager manager) {
        this.manager = manager;
    }

    public UserType render() {
        switch (uiState) {
            case MAIN: {
                switch (mainMenu()) {
                    case 0: {
                        return UserType.NONE;
                    }
                    case 1: {
                        return UserType.CLIENT;
                    }
                    case 2: {
                        uiState = UiState.ADD_PRODUCT;
                        return UserType.MANAGER;
                    }
                    case 3: {
                        uiState = UiState.REGISTER_SALE;
                        return UserType.MANAGER;
                    }
                    case 4: {
                        uiState = UiState.ADD_TO_BLACK_LIST;
                        return UserType.MANAGER;
                    }
                    default: {
                        return UserType.MANAGER;
                    }
                }
            }
            case ADD_PRODUCT: {
                createProduct();
                uiState = UiState.MAIN;
                return UserType.MANAGER;
            }
            case REGISTER_SALE: {
                registerSale();
                uiState = UiState.MAIN;
                return UserType.MANAGER;
            }
            case ADD_TO_BLACK_LIST: {
                addToBlackList();
                uiState = UiState.MAIN;
                return UserType.MANAGER;
            }
            default: {
                return UserType.MANAGER;
            }
        }
    }

    private int mainMenu() {
        System.out.print(
                "0 – Закончить программу\n"
                        + "1 – Перейти в режим клиента\n"
                        + "2 – Добавить товар\n"
                        + "3 – Зарегистрировать продажу\n"
                        + "4 – Добавить клиента в черный список\n"
                        + "Ввод: "
        );
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        return choice;
    }

    private void createProduct() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите номер товара: ");
        int id = scanner.nextInt();
        System.out.print("Введите наименование товара: ");
        String name = scanner.next();                           // Fixme: nextLine() doesn't work.
        System.out.print("Введите цену товара: ");
        int price = scanner.nextInt();

        manager.addProduct(new Product(id, name, price));
    }

    private void registerSale() {
        System.out.println("Список ожидающих подтверждение продаж:");
        List<Sale> sales = manager.getWaitingForSubmissionSales();
        for (Sale sale : sales) {
            System.out.println(sale.toString());
        }

        System.out.print("Введите номер продажи или 0, чтобы выйти: ");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        if (choice != 0) {
            manager.registerSale(choice);
        }
    }

    private void addToBlackList() {
        System.out.println("Список всех клиентов, не оплативших заказы:");
        List<Order> unpaidOrders = manager.getUnpaidOrders();
        System.out.println(unpaidOrders.toString());

        System.out.print("Выберите идентификатор пользователя или введите 0, чтобы выйти: ");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        if (choice != 0) {
            for (int i = 0; i < unpaidOrders.size(); i++) {
                ShopClient client = unpaidOrders.get(i).client;
                if (client.id == choice) {
                    manager.addToBlackList(client);
                }
            }
        }
    }

    private enum UiState {
        MAIN,
        ADD_PRODUCT,
        REGISTER_SALE,
        ADD_TO_BLACK_LIST
    }
}