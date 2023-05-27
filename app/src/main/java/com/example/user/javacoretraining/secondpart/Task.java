package com.example.user.javacoretraining.secondpart;

public class Task {

    public static void main(String[] args) {

        // Задание 3
        Lambda lambda = new Lambda();
        lambda.repeatTask(10, lambda.myClosure);

        // Задание 4
        new Plane().move();

        // Задание 5
        Shape rectangle = new Rectangle(4, 3);
        rectangle.displayInfo();

        Shape square = new Square(4);
        square.displayInfo();

        Shape circle = new Circle(10);
        circle.displayInfo();
    }


}

/**
 * Задание 3
 */
class Lambda {
    /**
     * Лямбда-выражение, печатающее "I love Java"
     */
    public final Runnable myClosure = () -> System.out.println("I love Java");

    /**
     * Выполняет лямбда-выражение заданное количество раз
     *
     * @param times Количество выполнений
     * @param task  Лямбда выражение
     */
    public void repeatTask(int times, Runnable task) {
        for (int i = 0; i < times; i++) {
            task.run();
        }
    }
}

/**
 * Задание 4
 */
class Plane {

    public void move() {
        Location location = new Location(0, 0);
        Direction[] pass = new Direction[]{
                Direction.UP, Direction.UP, Direction.LEFT,
                Direction.DOWN, Direction.LEFT, Direction.DOWN,
                Direction.DOWN, Direction.RIGHT, Direction.RIGHT, Direction.DOWN, Direction.RIGHT
        };
        for (Direction direction : pass) {
            move(location, direction);
            location.printCoordinates();
        }
    }

    public Location move(Location startLocation, Direction direction) {
        switch (direction) {
            case LEFT: {
                startLocation.setX(startLocation.getX() - 1);
                break;
            }
            case UP: {
                startLocation.setY(startLocation.getY() + 1);
                break;
            }
            case RIGHT: {
                startLocation.setX(startLocation.getX() + 1);
                break;
            }
            case DOWN: {
                startLocation.setY(startLocation.getY() - 1);
                break;
            }
        }
        return startLocation;
    }

    public enum Direction {
        LEFT,
        UP,
        RIGHT,
        DOWN
    }
}

class Location {
    private int x;
    private int y;

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void printCoordinates() {
        System.out.printf("x: %d; y: %d\n", x, y);
    }
}

/**
 * Задание 5
 */
interface Shape {
    float perimeter();
    float area();

    default void displayInfo() {
        System.out.printf("P = %f, S = %f\n", perimeter(), area());
    }
}

class Rectangle implements Shape {
    private final float width;
    private final float height;

    public Rectangle(float width, float height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public float perimeter() {
        return (width + height) * 2;
    }

    @Override
    public float area() {
        return width * height;
    }
}

class Square implements Shape  {
    private final float side;

    public Square(float side) {
        this.side = side;
    }

    @Override
    public float perimeter() {
        return side * 4;
    }

    @Override
    public float area() {
        return side * side;
    }
}

class Circle implements Shape {
    private final float diameter;

    public Circle(float diameter) {
        this.diameter = diameter;
    }

    @Override
    public float perimeter() {
        return (float) (Math.PI * diameter);
    }

    @Override
    public float area() {
        return (float) (Math.PI * (diameter * diameter / 4)); // Pi * R^2
    }
}