package com.example.user.javacoretraining.training;

/**
 * Набор тренингов по работе с примитивными типами java.
 * <p>
 * Задания определены в комментариях методов.
 * <p>
 * Проверка может быть осуществлена запуском тестов.
 * <p>
 * Доступна проверка тестированием @see ElementaryTrainingTest.
 */
public class ElementaryTraining {

    /**
     * Метод должен возвращать среднее значение
     * для введенных параметров
     *
     * @param firstValue  первый элемент
     * @param secondValue второй элемент
     * @return среднее значение для введенных чисел
     */
    public double averageValue(int firstValue, int secondValue) {
        return (double) (firstValue + secondValue) / 2;
    }

    /**
     * Пользователь вводит три числа.
     * Произвести манипуляции и вернуть сумму новых чисел
     *
     * @param firstValue  увеличить в два раза
     * @param secondValue уменьшить на три
     * @param thirdValue  возвести в квадрат
     * @return сумма новых трех чисел
     */
    public double complicatedAmount(int firstValue, int secondValue, int thirdValue) {
        return firstValue * 2 + secondValue - 3 + thirdValue * thirdValue;
    }

    /**
     * Метод должен поменять значение в соответствии с условием.
     * Если значение больше 3, то увеличить
     * на 10, иначе уменьшить на 10.
     *
     * @param value число для изменения
     * @return новое значение
     */
    public int changeValue(int value) {
        if (value > 3) {
            return value + 10;
        } else {
            return value - 10;
        }
    }

    /**
     * Метод должен менять местами первую
     * и последнюю цифру числа.
     * Обрабатывать максимум пятизначное число.
     * Если число < 10, вернуть
     * то же число
     *
     * @param value число для перестановки
     * @return новое число
     */
    public int swapNumbers(int value) {
        int valueLength = 0;
        int valueCopy = value;
        while (valueCopy > 0) {
            valueLength++;
            valueCopy /= 10;
        }
        if (valueLength > 5 || valueLength < 2) {
            return value;
        }
        int result = 0;
        result += (value % 10) * Math.pow(10, valueLength - 1); // First digit * 10^(valueLength - 1)
        value /= 10;
        int decimal = 1;
        while (decimal < valueLength - 1) {
            result += (value % 10) * Math.pow(10, decimal);
            value /= 10;
            decimal++;
        }
        result += value % 10;
        return result;
    }

    /**
     * Изменить значение четных цифр числа на ноль.
     * Счет начинать с единицы.
     * Обрабатывать максимум пятизначное число.
     * Если число < 10 вернуть
     * то же число.
     *
     * @param value число для изменения
     * @return новое число
     */
    public int zeroEvenNumber(int value) {
        if (value < 10) {
            return value;
        }
        int newValue = 0;
        int decimalCounter = 0;
        while (value != 0) {
            int digit = value % 10;
            if (digit % 2 == 1) {
                newValue += digit * Math.pow(10, decimalCounter);
            }
            decimalCounter++;
            value /= 10;
        }
        return newValue;
    }
}
