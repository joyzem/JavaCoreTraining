package com.example.user.javacoretraining.classes.eshop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductsRepo {
    public static List<Product> products = new ArrayList<>(
            Arrays.asList(
                    new Product(
                            1,
                            "Монитор",
                            100
                    ),
                    new Product(
                            2,
                            "Мышь",
                            200
                    ),
                    new Product(
                            3,
                            "Стол",
                            300
                    )
            )
    );
}
