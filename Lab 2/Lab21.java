import java.lang.Math.*;

class Point {
    private int x;
    private int y;

    public Point() {
        int x = 0;
        int y = 0;
    }
    public Point(int x, int y) {
        this.y = y;
        this.x = x;
    }
    public void move(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public String toString() {
        String s = "x: " + x + " y: " + y;
        return s;
    }
}

class Circle {
    private int radius;
    private Point center;

    public Circle() {
        radius = 1;
        center = new Point(0, 0);
    }
    public Circle(int radius) {
        this.radius = radius;
        center = new Point(0, 0);
    }
    public Circle(Point center) {
        this.center = center;
        radius = 1;
    }
    public Circle(int radius, Point center) {
        this.radius = radius;
        this.center = center;
    }
    public double area() {
        double a = Math.PI * Math.pow(radius, 2);
        return a;
    }
    public double circumference() {
        double c = Math.PI * radius;
        return c;
    }
    public String toString() {
        String s = center.toString() + "\n" + "radius: " + radius + "\n" + "Circumference: " + circumference() + "\n" + "Area: " + area() + "\n";
        return s;
    }
  
}

public class Lab21 {
    public static void main(String[] args) {
        Point a = new Point();
        Point b = new Point(6, 3);
        Circle c = new Circle();
        Circle d = new Circle(4,b);

        System.out.println("Default Points: " + a);
        System.out.println("New Points: " + b + "\n");
        System.out.println("Default Circle: " + c);
        System.out.println("New Circle: " + d);
    }
}