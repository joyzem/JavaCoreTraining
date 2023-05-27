package com.example.user.javacoretraining.classes;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

public class ClassesBlockTest {


    private static ClassesBlock.SecondTask secondTask;
    private static ClassesBlock.Time time;

    @BeforeClass
    public static void init() {
        secondTask = new ClassesBlock.SecondTask(10);
        time = new ClassesBlock.Time(10, 20, 20);
    }

    @Test
    public void addNumbers() {
        secondTask.addRandomNumbers(10, 3, 24);
        secondTask.displayArray();
    }

    @Test
    public void shuffleArray() {
        System.out.println("Old array");
        secondTask.displayArray();
        secondTask.shuffleArray();
        System.out.println("New array");
        secondTask.displayArray();
    }

    @Test
    public void uniqueItemsCount() {
        System.out.println("Array items:");
        secondTask.displayArray();
        System.out.printf("Unique items count: %d\n", secondTask.getUniqueItemsCount());
    }

    @Test
    public void displayTime() {
        time.displayTime();
    }

    @Test
    public void addFiftySecondsToTime() {
        time.setTime(10, 20, 20);
        time.plusSeconds(50);
        assertEquals(time.getMinutes(), 21);
    }

    @Test
    public void addMinutes() {
        time.setTime(10, 20, 20);
        time.plusMinutes(60);
        assertEquals(time.getHours(), 11);
    }

    @Test
    public void clients() {
        System.out.println("Displaying clients:");
        ClassesBlock.Client.ClientsRepo.displayClients();
        System.out.println("Displaying clients with city call time is more than 20");
        ClassesBlock.Client.ClientsRepo.displayClientsByCityCallTime(20);
        System.out.println("Displaying clients with intercity calls");
        ClassesBlock.Client.ClientsRepo.displayClientsWithIntercityCalls();
        System.out.println("Displaying clients in alphabetic order");
        ClassesBlock.Client.ClientsRepo.displayClientsInAlphabeticOrder();
    }

    @Test
    public void enrollSystemShowcase() {
        ClassesBlock.EnrollmentSystemTest.run();
    }
}