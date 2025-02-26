package DesignPatterns;

public class Circle implements Shape {

    int radius;

    Circle(int radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}
