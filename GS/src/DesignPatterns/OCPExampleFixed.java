package DesignPatterns;

import java.util.List;

public class OCPExampleFixed {
    public static void main(String[] args) {
        List<Shape> objectList = List.of(new Rectangle(3, 5), new Circle(7));
        for (Shape shape : objectList) {
            System.out.println(shape.calculateArea());
        }
    }
}
