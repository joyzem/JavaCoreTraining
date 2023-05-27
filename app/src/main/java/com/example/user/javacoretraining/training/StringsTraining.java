package com.example.user.javacoretraining.training;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Набор тренингов по работе со строками в java.
 * <p>
 * Задания определены в комментариях методов.
 * <p>
 * Проверка может быть осуществлена запуском тестов.
 * <p>
 * Доступна проверка тестированием @see StringsTrainingTest.
 */
public class StringsTraining {

    /**
     * Метод по созданию строки,
     * состоящей из нечетных символов
     * входной строки в том же порядке
     * (нумерация символов идет с нуля)
     *
     * @param text строка для выборки
     * @return новая строка из нечетных
     * элементов строки text
     */
    public String getOddCharacterString(String text) {
        StringBuilder newString = new StringBuilder();
        for (int i = 1; i < text.length(); i += 2) {
            newString.append(text.charAt(i));
        }
        return newString.toString();
    }

    /**
     * Метод для определения количества
     * символов, идентичных последнему
     * в данной строке
     *
     * @param text строка для выборки
     * @return массив с номерами символов,
     * идентичных последнему. Если таких нет,
     * вернуть пустой массив
     */
    public int[] getArrayLastSymbol(String text) {
        if (text.length() == 0) {
            return new int[]{};
        }
        char lastSymbol = text.charAt(text.length() - 1);
        List<Integer> tmpArray = new ArrayList<>();
        for (int i = 0; i < text.length() - 1; i++) {
            if (text.charAt(i) == lastSymbol) {
                tmpArray.add(i);
            }
        }
        int[] lastSymbolArray = new int[tmpArray.size()];
        for (int i = 0; i < tmpArray.size(); i++) {
            lastSymbolArray[i] = tmpArray.get(i);
        }
        return lastSymbolArray;
    }

    /**
     * Метод по получению количества
     * цифр в строке
     *
     * @param text строка для выборки
     * @return количество цифр в строке
     */
    public int getNumbersCount(String text) {
        int counter = 0;
        for (int i = 0; i < text.length(); i++) {
            int charCode = (int) text.charAt(i);
            if (charCode >= 48 && charCode <= 57) {
                counter++;
            }
        }
        return counter;
    }

    /**
     * Дан текст. Заменить все цифры
     * соответствующими словами.
     *
     * @param text текст для поиска и замены
     * @return текст, где цифры заменены словами
     */
    public String replaceAllNumbers(String text) {
        List<String> dictionary = Arrays.asList(
                "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"
        );
        for (int i = 0; i < dictionary.size(); i++) {
            text = text.replace(String.valueOf(i), dictionary.get(i));
        }
        return text;
    }

    /**
     * Метод должен заменить заглавные буквы
     * на прописные, а прописные на заглавные
     *
     * @param text строка для изменения
     * @return измененная строка
     */
    public String capitalReverse(String text) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            int charCode = (int) text.charAt(i);
            boolean isUpperCase = charCode >= 65 && charCode <= 90      // Latin
                    || charCode >= 1040 && charCode <= 1071;            // Cyrillic
            if (isUpperCase) {
                result.append(String.valueOf(text.charAt(i)).toLowerCase());
            } else {
                result.append(String.valueOf(text.charAt(i)).toUpperCase());
            }
        }
        return result.toString();
    }

}
