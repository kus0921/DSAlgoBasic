package DesignPatterns;

public class Rectangle implements Shape {
    int length;
    int breath;

    Rectangle(int l, int b) {
        this.length = l;
        this.breath = b;
    }

    @Override
    public double calculateArea() {
        return length * breath;
    }
}
