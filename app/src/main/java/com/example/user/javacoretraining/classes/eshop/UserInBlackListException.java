package com.example.user.javacoretraining.classes.eshop;

class UserInBlackListException extends Exception {
    UserInBlackListException() {
        super("User is in the black list");
    }
}