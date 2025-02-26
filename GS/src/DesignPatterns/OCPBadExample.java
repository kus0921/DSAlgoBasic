package DesignPatterns;

public class OCPBadExample {
    public double calculateArea(Object shape) {
        if (shape instanceof Rectangle) {
            return ((Rectangle) shape).length * ((Rectangle) shape).breath;
        } else if (shape instanceof Circle) {
            return Math.PI * ((Circle) shape).radius * ((Circle) shape).radius;
        }
        return 0.0;
    }

    static class Rectangle {
        int length;
        int breath;

        public Rectangle(int len, int br) {
            this.length = len;
            this.breath = br;

        }
    }

    static class Circle {
        int radius;

        public Circle(int radius) {
            this.radius = radius;
        }
    }

    public static void main(String[] args) {
        OCPBadExample example = new OCPBadExample();
      //  System.out.println(example.calculateArea(new Rectangle(9, 3)));
        //System.out.println(example.calculateArea(new Circle(9)));

        StringBuffer stringBuilder =  new StringBuffer("string");
        StringBuffer stringBuilder1 =  new StringBuffer("string");
        System.out.println(stringBuilder.equals(stringBuilder1));
    }
}
