package project;

import edu.princeton.cs.introcs.StdDraw;

import java.awt.*;
import java.util.LinkedList;

public class Food {

    private double x;
    private double y;
    private double radius;
    private static LinkedList<Food> foodTracking = new LinkedList<Food>();

    public Food(double x, double y, double radius){
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public double getX(){
        return x;
    }
    public double getY(){
        return y;
    }

    public void draw(){
        StdDraw.setPenColor(Color.red);
        StdDraw.filledSquare(this.x, this.y, this.radius);
    }

    public static void addFood(Food food){
        foodTracking.add(food);
    }

    public static void removeFood(Food food){
        foodTracking.remove(food);
    }

    public static void drawFood(){
        for(Food f : foodTracking){
            f.draw();
        }
    }

    public static Food latestFood(){
        return foodTracking.getLast();
    }

}
