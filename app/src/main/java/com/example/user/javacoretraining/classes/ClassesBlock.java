package com.example.user.javacoretraining.classes;

import static java.lang.Math.abs;

import android.support.annotation.NonNull;

import com.example.user.javacoretraining.classes.eshop.EShop;
import com.example.user.javacoretraining.classes.eshop.ProductManager;
import com.example.user.javacoretraining.classes.eshop.ProductManagerUi;
import com.example.user.javacoretraining.classes.eshop.ShopClient;
import com.example.user.javacoretraining.classes.eshop.ShopClientUi;
import com.example.user.javacoretraining.classes.eshop.UI;
import com.example.user.javacoretraining.classes.eshop.UserType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

/**
 * Набор заданий по работе с классами в java.
 * <p>
 * Задания подразумевают создание класса(ов), выполняющих задачу.
 * <p>
 * Проверка осуществляется ментором.
 */
public interface ClassesBlock {

    /*
      I

      Создать класс с двумя переменными. Добавить функцию вывода на экран
      и функцию изменения этих переменных. Добавить функцию, которая находит
      сумму значений этих переменных, и функцию, которая находит наибольшее
      значение из этих двух переменных.
     */
    class FirstTask {
        int firstValue;
        int secondValue;

        FirstTask(int firstValue, int secondValue) {
            this.firstValue = firstValue;
            this.secondValue = secondValue;
        }

        public void displayValues() {
            System.out.printf("First value is: %d\nSecond value is: $d", firstValue, secondValue);
        }

        public void setFirstValue(int newValue) {
            firstValue = newValue;
        }

        public void setSecondValue(int newValue) {
            secondValue = newValue;
        }

        public int sumOfValues() {
            return firstValue + secondValue;
        }

        public int maxValue() {
            return (firstValue > secondValue) ? firstValue : secondValue;
        }
    }

    /*
      II

      Создать класс, содержащий динамический массив и количество элементов в нем.
      Добавить конструктор, который выделяет память под заданное количество элементов.
      Добавить методы, позволяющие заполнять массив случайными числами,
      переставлять в данном массиве элементы в случайном порядке, находить количество
      различных элементов в массиве, выводить массив на экран.
     */
    class SecondTask {
        private List<Integer> arrayList;
        private int arraySize;

        public SecondTask(int size) {
            arrayList = new ArrayList<>(size);
        }

        public void addRandomNumbers(int numbersCount, int min, int max) {
            for (int count = 0; count < numbersCount; count++) {
                Random random = new Random();
                int number = random.nextInt(max - min + 1) + min;
                arrayList.add(number);
            }
            arraySize += numbersCount;
        }

        public void shuffleArray() {
            Random random = new Random();
            ArrayList<Integer> tmpList = new ArrayList<>(arraySize);
            do {
                int itemIndex = random.nextInt(arrayList.size());
                tmpList.add(arrayList.get(itemIndex));
                arrayList.remove(itemIndex);
            } while (arrayList.size() > 0);
            arrayList = tmpList;
        }

        public int getUniqueItemsCount() {
            Set<Integer> itemsSet = new TreeSet<>(arrayList);
            return itemsSet.size();
        }

        public void displayArray() {
            for (int item = 0; item < arrayList.size(); item++) {
                System.out.printf("ArrayList[%d]: %d\n", item, arrayList.get(item));
            }
        }
    }

    /*
      III

      Описать класс, представляющий треугольник. Предусмотреть методы для создания объектов,
      вычисления площади, периметра и точки пересечения медиан.
      Описать свойства для получения состояния объекта.
     */
    abstract class Triangle {
        protected float x1;
        protected float y1;
        protected float x2;
        protected float y2;
        protected float x3;
        protected float y3;

        Triangle(
                float x1,
                float y1,
                float x2,
                float y2,
                float x3,
                float y3
        ) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
            this.x3 = x3;
            this.y3 = y3;
        }

        abstract float area();

        abstract float perimeter();

        abstract float medianOverlapPoint();

        public void displayTriangleState() {
            System.out.printf(
                    "x1: %f; y1: %f\nx2: %f; y2: %f\nx3: %f; y3: %f\n",
                    x1, y1, x2, y2, x3, y3);
        }
    }

    /*
      IV

      Составить описание класса для представления времени.
      Предусмотреть возможности установки времени и изменения его отдельных полей
      (час, минута, секунда) с проверкой допустимости вводимых значений.
      В случае недопустимых значений полей выбрасываются исключения.
      Создать методы изменения времени на заданное количество часов, минут и секунд.
     */
    class Time {
        private TimeUnit hours = new Hour(0);
        private TimeUnit minutes = new Minute(0);
        private TimeUnit seconds = new Second(0);

        Time(int hours, int minutes, int seconds) {
            setTime(hours, minutes, seconds);
        }

        void displayTime() {
            System.out.printf("%02d:%02d:%02d\n", hours.time, minutes.time, seconds.time);
        }

        void setTime(int hours, int minutes, int seconds) throws IllegalArgumentException {
            setHours(hours);
            setMinutes(minutes);
            setSeconds(seconds);
        }

        int getHours() {
            return hours.time;
        }

        void setHours(int hours) throws IllegalArgumentException {
            this.hours.setTime(hours);
        }

        void plusHours(int hours) {
            this.hours.plus(hours);
        }

        void minusHours(int hours) {
            this.hours.minus(hours);
        }

        int getMinutes() {
            return minutes.time;
        }

        void setMinutes(int minutes) throws IllegalArgumentException {
            this.minutes.setTime(minutes);
        }

        void plusMinutes(int minutes) {
            plusHours(this.minutes.plus(minutes));
        }

        void minusMinutes(int minutes) {
            minusHours(this.minutes.minus(minutes));
        }

        int getSeconds() {
            return seconds.time;
        }

        void setSeconds(int seconds) throws IllegalArgumentException {
            this.seconds.setTime(seconds);
        }

        void plusSeconds(int seconds) {
            plusMinutes(this.seconds.plus(seconds));
        }

        void minusSeconds(int seconds) {
            minusMinutes(this.seconds.minus(seconds));
        }

        private abstract class TimeUnit {
            private final int upperBound;
            protected int time;

            TimeUnit(int upperBound, int time) throws IllegalArgumentException {
                if (upperBound < 0) {
                    throw new IllegalArgumentException();
                }
                this.upperBound = upperBound;
                if (time < 0 || time > upperBound) {
                    throw new IllegalArgumentException();
                }
                this.time = time;
            }

            /**
             * @param time
             * @return amount of times the TimeUnit reaches upper bound due to adding time
             */
            protected int plus(int time) {
                if (time < 0) {
                    return minus(abs(time));
                }
                int newTime = (this.time + time) % upperBound;
                int countOfOverriding = (this.time + time) / upperBound;
                this.time = newTime;
                return countOfOverriding;
            }

            /**
             * @param time
             * @return amount of times the TimeUnit reaches 0 due to adding time
             */
            protected int minus(int time) {
                if (time < 0) {
                    return plus(abs(time));
                }
                int delta = abs(this.time - time) % upperBound;
                int newTime = (this.time > time) ? delta : upperBound - delta;
                int countOfOverriding = (this.time > time) ? 0 : abs(this.time - time) / upperBound;
                this.time = newTime;
                return countOfOverriding;
            }

            public void setTime(int newTime) throws IllegalArgumentException {
                if (newTime < 0 || newTime > upperBound) {
                    throw new IllegalArgumentException();
                }
                this.time = newTime;
            }
        }

        private class Hour extends TimeUnit {
            private static final int bound = 24;

            Hour(int time) {
                super(bound, time);
            }
        }

        private class Minute extends TimeUnit {
            private static final int bound = 60;

            Minute(int time) {
                super(bound, time);
            }
        }

        private class Second extends TimeUnit {
            private static final int bound = 60;

            Second(int time) {
                super(bound, time);
            }
        }
    }

    /*
      V

      Класс Абонент: Идентификационный номер, Фамилия, Имя, Отчество, Адрес,
      Номер кредитной карточки, Дебет, Кредит, Время междугородных и городских переговоров;
      Конструктор; Методы: установка значений атрибутов, получение значений атрибутов,
      вывод информации. Создать массив объектов данного класса.
      Вывести сведения относительно абонентов, у которых время городских переговоров
      превышает заданное.  Сведения относительно абонентов, которые пользовались
      междугородной связью. Список абонентов в алфавитном порядке.
     */
    class Client implements Comparable<Client> {
        private int id;
        private String firstfame;
        private String lastname;
        private String middlename;
        private String address;
        private String creditCardNumber;
        private int debit;
        private int credit;
        private int intercityCallTimeInMillis;
        private int cityCallTimeInMillis;

        public Client(
                int id,
                String firstfame,
                String lastname,
                String middlename,
                String address,
                String creditCardNumber,
                int debit,
                int credit,
                int intercityCallTimeInMillis,
                int cityCallTimeInMillis) {
            this.id = id;
            this.firstfame = firstfame;
            this.lastname = lastname;
            this.middlename = middlename;
            this.address = address;
            this.creditCardNumber = creditCardNumber;
            this.debit = debit;
            this.credit = credit;
            this.intercityCallTimeInMillis = intercityCallTimeInMillis;
            this.cityCallTimeInMillis = cityCallTimeInMillis;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getLastname() {
            return lastname;
        }

        public void setLastname(String lastname) {
            this.lastname = lastname;
        }

        public String getFirstfame() {
            return firstfame;
        }

        public void setFirstfame(String firstfame) {
            this.firstfame = firstfame;
        }

        public String getMiddlename() {
            return middlename;
        }

        public void setMiddlename(String middlename) {
            this.middlename = middlename;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getCreditCardNumber() {
            return creditCardNumber;
        }

        public void setCreditCardNumber(String creditCardNumber) {
            this.creditCardNumber = creditCardNumber;
        }

        public int getDebit() {
            return debit;
        }

        public void setDebit(int debit) {
            this.debit = debit;
        }

        public int getCredit() {
            return credit;
        }

        public void setCredit(int credit) {
            this.credit = credit;
        }

        public int getIntercityCallTimeInMillis() {
            return intercityCallTimeInMillis;
        }

        public void setIntercityCallTimeInMillis(int intercityCallTimeInMillis) {
            this.intercityCallTimeInMillis = intercityCallTimeInMillis;
        }

        public int getCityCallTimeInMillis() {
            return cityCallTimeInMillis;
        }

        public void setCityCallTimeInMillis(int cityCallTimeInMillis) {
            this.cityCallTimeInMillis = cityCallTimeInMillis;
        }

        public void displayInfo() {
            System.out.printf("Client number %d:\n"
                            + "Firstname: %s\n"
                            + "Lastname: %s\n"
                            + "Middlename: %s\n"
                            + "Address: %s\n"
                            + "Credit card number: %s\n"
                            + "Debit: %d\n"
                            + "Credit: %d\n"
                            + "Intercity call time in millis: %d\n"
                            + "City call time in millis: %d\n",
                    id,
                    firstfame,
                    lastname,
                    middlename,
                    address,
                    creditCardNumber,
                    debit,
                    credit,
                    intercityCallTimeInMillis,
                    cityCallTimeInMillis
            );
        }

        @Override
        public int compareTo(@NonNull Client client) {
            int comparingLastnames = lastname.compareTo(client.lastname);
            if (comparingLastnames == 0) {
                int comparingFirstnames = firstfame.compareTo(client.firstfame);
                if (comparingFirstnames == 0) {
                    return middlename.compareTo(client.middlename);
                } else {
                    return comparingFirstnames;
                }
            } else {
                return comparingLastnames;
            }
        }

        public static class ClientsRepo {
            private static List<Client> clients = Arrays.asList(
                    getMockClient(
                            0,
                            "Кирилл",
                            "Потапов",
                            "Владиславович"
                    ),
                    getMockClient(
                            1,
                            "Денис",
                            "Денисов",
                            "Денисович"
                    ),
                    getMockClient(
                            2,
                            "Тест",
                            "Тестов",
                            "Тестович"
                    )
            );

            static void displayClients() {
                for (int clientIndex = 0; clientIndex < clients.size(); clientIndex++) {
                    clients.get(clientIndex).displayInfo();
                }
            }

            static void displayClientsByCityCallTime(int timeInMillis) {
                for (int clientIndex = 0; clientIndex < clients.size(); clientIndex++) {
                    Client currentClient = clients.get(clientIndex);
                    if (currentClient.cityCallTimeInMillis > timeInMillis) {
                        currentClient.displayInfo();
                    }
                }
            }

            static void displayClientsWithIntercityCalls() {
                for (int clientIndex = 0; clientIndex < clients.size(); clientIndex++) {
                    Client currentClient = clients.get(clientIndex);
                    if (currentClient.intercityCallTimeInMillis > 0) {
                        currentClient.displayInfo();
                    }
                }
            }

            static void displayClientsInAlphabeticOrder() {

                // Bubble sorting
                List<Client> sortedClients = clients;
                for (int i = 0; i < sortedClients.size(); i++) {
                    for (int j = i + 1; j < sortedClients.size(); j++) {
                        if (sortedClients.get(i).compareTo(sortedClients.get(j)) > 0) {
                            Client temp = sortedClients.get(i);
                            sortedClients.set(i, sortedClients.get(j));
                            sortedClients.set(j, temp);
                        }
                    }
                }
                for (int clientIndex = 0; clientIndex < sortedClients.size(); clientIndex++) {
                    sortedClients.get(clientIndex).displayInfo();
                }
            }

            private static Client getMockClient(
                    int id,
                    String firstname,
                    String lastname,
                    String middlename
            ) {
                Random random = new Random();
                return new Client(
                        id,
                        firstname,
                        lastname,
                        middlename,
                        "Krasnodar",
                        "1111222233334444",
                        random.nextInt(10),
                        random.nextInt(10),
                        random.nextInt(5),
                        random.nextInt(30)
                );
            }
        }
    }

    /*
      VI

      Задача на взаимодействие между классами. Разработать систему «Вступительные экзамены».
      Абитуриент регистрируется на Факультет, сдает Экзамены. Преподаватель выставляет Оценку.
      Система подсчитывает средний бал и определяет Абитуриента, зачисленного в учебное заведение.
     */

    /*
    Класс демонстрирует работу системы "Вступительные экзамены"
     */
    class EnrollmentSystemTest {
        private static final EnrollmentSystem system = new MockEnrollmentSystem();
        private static final IEnrollersRepo enrollersRepo = new MockEnrollersRepo();

        public static void run() {
            List<Enroller> enrollers = enrollersRepo.getEnrollers();
            for (int i = 0; i < enrollers.size(); i++) {
                Enroller enroller = enrollers.get(i);
                system.registerEnroller(
                        enroller.facultyId,
                        enroller.getFirstname(),
                        enroller.getLastname(),
                        enroller.getMiddlename()
                );
            }
            List<Enroller> registeredEnrollers = system.getEnrollers();
            for (int i = 0; i < registeredEnrollers.size(); i++) {
                int enrollerId = registeredEnrollers.get(i).id;
                system.takeExam(enrollerId, "Программирование").dispayResult();
                system.takeExam(enrollerId, "Математика").dispayResult();
                system.takeExam(enrollerId, "Английский язык").dispayResult();
                system.takeExam(enrollerId, "Философия").dispayResult();
                float averageMark = system.getAverageMarkOfEnroller(enrollerId);
                System.out.printf(
                        "Average mark of enroller with id = %d is %f\n",
                        enrollerId,
                        averageMark
                );
                System.out.println(
                        system.enrollerHasBeenEnrolled(enrollerId)
                                ? "Enroller has been enrolled"
                                : "Enroller has not been enrolled"
                );
            }
        }
    }
    interface EnrollmentSystem {

        void registerEnroller(int facultyId, String firstname, String lastname, String middlename);

        List<Enroller> getEnrollers();

        ExamResult takeExam(int enrollerId, String disciplineName);

        float getAverageMarkOfEnroller(int enrollerId) throws NullPointerException;

        boolean enrollerHasBeenEnrolled(int enrollerId);

    }

    class MockEnrollmentSystem implements EnrollmentSystem {
        private final List<Faculty> faculties = new MockFacultiesRepo().getFaculties();
        private final List<Enroller> enrollers = new ArrayList<>();
        private final float MINIMUM_ENROLLMENT_SCORE = 3.0f;

        public void registerEnroller(int facultyId, String firstname, String lastname, String middlename) {
            try {
                if (findFaculty(facultyId) == null) {
                    throw new NullPointerException("There is no such faculty");
                }
                int id = new Random().nextInt(10000);
                Enroller enroller = new Enroller(id, facultyId, firstname, lastname, middlename);
                enrollers.add(enroller);
            } catch (NullPointerException e) {
                System.out.println(e.getMessage());
            }
        }

        @Override
        public List<Enroller> getEnrollers() {
            return enrollers;
        }

        public ExamResult takeExam(int enrollerId, String disciplineName) {
            try {
                Enroller enroller = findEnroller(enrollerId);
                int facultyId = enroller.getFacultyId();
                Faculty faculty = findFaculty(facultyId);
                ExamResult result = faculty.conductExam(enrollerId, disciplineName);
                enroller.addExamResult(result);
                return result;
            } catch (NullPointerException e) {
                System.out.println(e.getMessage());
                return null;
            }
        }

        public float getAverageMarkOfEnroller(int enrollerId) throws NullPointerException {
            int sum = 0;
            Enroller enroller = findEnroller(enrollerId);
            List<ExamResult> results = enroller.getExaminesResults();
            for (int i = 0; i < results.size(); i++) {
                sum += results.get(i).mark;
            }
            return (float) sum / results.size();
        }

        @Override
        public boolean enrollerHasBeenEnrolled(int enrollerId) throws NullPointerException {
            float averageMark = getAverageMarkOfEnroller(enrollerId);
            return averageMark >= MINIMUM_ENROLLMENT_SCORE;
        }

        private Enroller findEnroller(int enrollerId) throws NullPointerException {
            for (int i = 0; i < enrollers.size(); i++) {
                if (enrollers.get(i).getId() == enrollerId) {
                    return enrollers.get(i);
                }
            }
            throw new NullPointerException("No such enroller");
        }

        private Faculty findFaculty(int id) throws NullPointerException {
            for (int i = 0; i < faculties.size(); i++) {
                if (faculties.get(i).id == id) {
                    return faculties.get(i);
                }
            }
            throw new NullPointerException("No such faculty");
        }
    }

    class Faculty {
        public final int id;
        private String facultyName;
        private final List<Teacher> availableTeachers = new ArrayList<>();

        public Faculty(int id, String facultyName, List<Teacher> teachers) {
            this.id = id;
            this.facultyName = facultyName;
            addTeachers(teachers);
        }

        public ExamResult conductExam(int enrollerId, String disciplineName) throws NullPointerException {
            if (availableTeachers.size() != 0) {
                Teacher teacher = getTeacherForExam();
                ExamResult result = teacher.conductExam(enrollerId, disciplineName);
                addTeacher(teacher);
                return result;
            }
            throw new NullPointerException("No available teachers");
        }

        private Teacher getTeacherForExam() throws NullPointerException {
            if (availableTeachers.size() != 0) {
                Teacher teacher = availableTeachers.get(0);
                availableTeachers.remove(0);
                return teacher;
            }
            throw new NullPointerException("No available teachers");
        }

        public void addTeacher(Teacher teacher) {
            availableTeachers.add(teacher);
        }

        public void addTeachers(List<Teacher> teachers) {
            availableTeachers.addAll(teachers);
        }

        public String getFacultyName() {
            return facultyName;
        }

        public void setFacultyName(String facultyName) {
            this.facultyName = facultyName;
        }
    }

    class ExamResult {
        private final int enrollerId;
        private final int teacherId;
        private final String discipline;
        private final int mark;

        public ExamResult(int enrollerId, int teacherId, String discipline, int mark) {
            this.enrollerId = enrollerId;
            this.teacherId = teacherId;
            this.discipline = discipline;
            this.mark = mark;
        }

        void dispayResult() {
            System.out.printf(
                    "Enroller id: %d\n"
                            + "Teacher id: %d\n"
                            + "Discipline: %s\n"
                            + "Mark: %d\n", enrollerId, teacherId, discipline, mark);
        }
    }

    class Teacher extends Person {
        public final int id;
        private final int HIGHEST_MARK = 5;
        private final int LOWEST_MARK = 2;

        public Teacher(int id, String firstname, String lastname, String middlename) {
            super(firstname, lastname, middlename);
            this.id = id;
        }

        public ExamResult conductExam(int enrollerId, String disciplineName) {
            return new ExamResult(
                    enrollerId,
                    id,
                    disciplineName,
                    new Random().nextInt(HIGHEST_MARK + 1 - LOWEST_MARK) + LOWEST_MARK
            );
        }
    }

    class Enroller extends Person {
        private int id;
        private int facultyId;
        private List<ExamResult> examinesResults = new ArrayList<>();

        public Enroller(int id, int facultyId, String firstname, String lastname, String middlename) {
            super(firstname, lastname, middlename);
            this.id = id;
            this.facultyId = facultyId;
        }

        public List<ExamResult> getExaminesResults() {
            return examinesResults;
        }

        public void addExamResult(ExamResult examResult) {
            this.examinesResults.add(examResult);
        }

        public int getId() {
            return id;
        }

        public int getFacultyId() {
            return facultyId;
        }

        public void setFacultyId(int facultyId) {
            this.facultyId = facultyId;
        }
    }

    interface IFacultiesRepo {
        List<Faculty> getFaculties();
    }

    class MockFacultiesRepo implements IFacultiesRepo {

        ITeachersRepo teachersRepo = new MockTeachersRepo();

        @Override
        public List<Faculty> getFaculties() {
            return Arrays.asList(
                    new Faculty(
                            0,
                            "Прикладная информатика",
                            teachersRepo.getTeachers()
                    )
            );
        }
    }

    interface ITeachersRepo {
        List<Teacher> getTeachers();
    }

    class MockTeachersRepo implements ITeachersRepo {

        @Override
        public List<Teacher> getTeachers() {
            return Arrays.asList(
                    new Teacher(
                            0,
                            "Тест",
                            "Тестов",
                            "Тестович"
                    ),
                    new Teacher(
                            1,
                            "Поп",
                            "Попов",
                            "Поповович"
                    ),
                    new Teacher(
                            2,
                            "Иван",
                            "Иванов",
                            "Иванович"
                    )
            );
        }
    }

    interface IEnrollersRepo {
        List<Enroller> getEnrollers();
    }

    class MockEnrollersRepo implements IEnrollersRepo {

        /*
        При регистрации в системе абитуриент видит список факультетов
         */
        private List<Faculty> faculties = new MockFacultiesRepo().getFaculties();

        @Override
        public List<Enroller> getEnrollers() {
            return Arrays.asList(
                    new Enroller(
                            0,
                            getRandomFacultyId(),
                            "Григорий",
                            "Григорьев",
                            "Григорьевич"
                    ),
                    new Enroller(
                            1,
                            getRandomFacultyId(),
                            "Станислав",
                            "Денисов",
                            "Андреевич"
                    )
            );
        }

        private int getRandomFacultyId() throws NullPointerException {
            int upperBound = faculties.size();
            if (upperBound == 0) {
                throw new NullPointerException();
            }
            return faculties.get(new Random().nextInt(upperBound)).id;
        }
    }

    class Person {
        private String firstname;
        private String lastname;
        private String middlename;

        public Person(String firstname, String lastname, String middlename) {
            this.firstname = firstname;
            this.lastname = lastname;
            this.middlename = middlename;
        }

        public String getFirstname() {
            return firstname;
        }

        public void setFirstname(String firstname) {
            this.firstname = firstname;
        }

        public String getLastname() {
            return lastname;
        }

        public void setLastname(String lastname) {
            this.lastname = lastname;
        }

        public String getMiddlename() {
            return middlename;
        }

        public void setMiddlename(String middlename) {
            this.middlename = middlename;
        }
    }

    /*
      VII

      Задача на взаимодействие между классами. Разработать систему «Интернет-магазин».
      Товаровед добавляет информацию о Товаре. Клиент делает и оплачивает Заказ на Товары.
      Товаровед регистрирует Продажу и может занести неплательщика в «черный список».
     */
    class SeventhTask {

        /*
          Для запуска программы, возможно, необходимо добавить в .idea/gradle.xml опцию
          <option name="delegatedBuild" value="false" />
        */
        public static void main(String[] args) {
            EShop shop = new EShop();
            ProductManager manager = new ProductManager(shop);
            ShopClient client = new ShopClient(1, shop);
            UserType userType = UserType.MANAGER;
            UI productManagerUi = new ProductManagerUi(manager);
            UI shopClientUi = new ShopClientUi(client);
            do {
                switch (userType) {
                    case MANAGER: {
                        userType = productManagerUi.render();
                        break;
                    }
                    case CLIENT: {
                        userType = shopClientUi.render();
                        break;
                    }
                }
            } while (userType != UserType.NONE);
        }
    }
}
