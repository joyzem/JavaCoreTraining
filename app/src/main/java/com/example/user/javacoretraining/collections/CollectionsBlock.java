package com.example.user.javacoretraining.collections;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Набор тренингов по работе со строками в java.
 * <p>
 * Задания определены в комментариях методов.
 * <p>
 * Проверка может быть осуществлена запуском тестов.
 * <p>
 * Доступна проверка тестированием @see CollectionsBlockTest.
 */
public class CollectionsBlock<T extends Comparable> {

    /**
     * Даны два упорядоченных по убыванию списка.
     * Объедините их в новый упорядоченный по убыванию список.
     * Исходные данные не проверяются на упорядоченность в рамках данного задания
     *
     * @param firstList  первый упорядоченный по убыванию список
     * @param secondList второй упорядоченный по убыванию список
     * @return объединенный упорядоченный список
     * @throws NullPointerException если один из параметров null
     */
    public List<T> collectionTask0(@NonNull List<T> firstList, @NonNull List<T> secondList) {
        List<T> newList = new ArrayList<>(firstList.size() + secondList.size());
        int totalSize = firstList.size() + secondList.size();
        int firstListIndex = 0;
        int secondListIndex = 0;
        while (newList.size() != totalSize) {
            T firstListItem;
            try {
                firstListItem = firstList.get(firstListIndex);
            } catch (IndexOutOfBoundsException e) {
                while (newList.size() != totalSize) {
                    newList.add(secondList.get(secondListIndex));
                    secondListIndex++;
                }
                break;
            }
            T secondListItem;
            try {
                secondListItem = secondList.get(secondListIndex);
            } catch (IndexOutOfBoundsException e) {
                while (newList.size() != totalSize) {
                    newList.add(firstList.get(firstListIndex));
                    firstListIndex++;
                }
                break;
            }
            if (firstListItem.compareTo(secondListItem) == 1) {
                newList.add(firstListItem);
                firstListIndex++;
            } else {
                newList.add(secondListItem);
                secondListIndex++;
            }
        }
        return newList;
    }

    /**
     * Дан список. После каждого элемента добавьте предшествующую ему часть списка.
     *
     * @param inputList с исходными данными
     * @return измененный список
     * @throws NullPointerException если один из параметров null
     */
    public List<T> collectionTask1(@NonNull List<T> inputList) {
        if (inputList == null) {
            throw new NullPointerException();
        }
        if (inputList.isEmpty()) {
            return Collections.emptyList();
        }
        int newSize = inputList.size() * (inputList.size() + 1) / 2; // Sum 1 to N
        List<T> newList = new ArrayList<>(newSize);
        newList.add(inputList.get(0));
        for (int i = 1; i < inputList.size(); i++) {
            newList.add(inputList.get(i));
            newList.addAll(inputList.subList(0, i));
        }
        return newList;
    }

    /**
     * Даны два списка. Определите, совпадают ли множества их элементов.
     *
     * @param firstList  первый список элементов
     * @param secondList второй список элементов
     * @return <tt>true</tt> если множества списков совпадают
     * @throws NullPointerException если один из параметров null
     */
    public boolean collectionTask2(@NonNull List<T> firstList, @NonNull List<T> secondList) {
        if (firstList == null || secondList == null) {
            throw new NullPointerException();
        }
        Set<T> firstSet = new HashSet<>(firstList);
        Set<T> secondSet = new HashSet<>(secondList);
        return firstSet.equals(secondSet);
    }

    /**
     * Создать список из заданного количества элементов.
     * Выполнить циклический сдвиг этого списка на N элементов вправо или влево.
     * Если N > 0 циклический сдвиг вправо.
     * Если N < 0 циклический сдвиг влево.
     *
     * @param inputList список, для которого выполняется циклический сдвиг влево
     * @param n         количество шагов циклического сдвига N
     * @return список inputList после циклического сдвига
     * @throws NullPointerException если один из параметров null
     */
    public List<T> collectionTask3(@NonNull List<T> inputList, int n) {
        if (inputList == null) {
            throw new NullPointerException();
        }
        if (inputList.isEmpty()) {
            return Collections.emptyList();
        }
        boolean shiftLeft = n < 0;
        int optimizedShiftCount = Math.abs(n % inputList.size()); // reduce unnecessary shifts
        List<T> newList = new ArrayList<>();
        if (shiftLeft) {
            newList.addAll(inputList.subList(optimizedShiftCount, inputList.size()));
            newList.addAll(inputList.subList(0, optimizedShiftCount));
        } else {
            newList.addAll(inputList.subList(inputList.size() - optimizedShiftCount, inputList.size()));
            newList.addAll(inputList.subList(0, inputList.size() - optimizedShiftCount));
        }
        return newList;
    }

    /**
     * Элементы списка хранят слова предложения.
     * Замените каждое вхождение слова A на B.
     *
     * @param inputList список со словами предложения и пробелами для разделения слов
     * @param a         слово, которое нужно заменить
     * @param b         слово, на которое нужно заменить
     * @return список после замены каждого вхождения слова A на слово В
     * @throws NullPointerException если один из параметров null
     */
    public List<String> collectionTask4(@NonNull List<String> inputList, @NonNull String a,
                                        @NonNull String b) {
        if (inputList == null || a == null || b == null) {
            throw new NullPointerException();
        }
        List<String> linkedList = new ArrayList<>();
        for (String word : inputList) {
            if (word.equals(a)) {
                linkedList.add(b);
            } else {
                linkedList.add(word);
            }
        }
        return linkedList;
    }

    /*
      Задание подразумевает создание класса(ов) для выполнения задачи.

      Дан список студентов. Элемент списка содержит фамилию, имя, отчество, год рождения,
      курс, номер группы, оценки по пяти предметам. Заполните список и выполните задание.
      Упорядочите студентов по курсу, причем студенты одного курса располагались
      в алфавитном порядке. Найдите средний балл каждой группы по каждому предмету.
      Определите самого старшего студента и самого младшего студентов.
      Для каждой группы найдите лучшего с точки зрения успеваемости студента.
     */
}
