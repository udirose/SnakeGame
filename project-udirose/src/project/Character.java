package project;

import edu.princeton.cs.introcs.StdDraw;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.LinkedList;

public class Character {

    private static int direction;
    private double x;
    private double y;
    private double radius;
    private static LinkedList<Character> character = new LinkedList<Character>();


    public Character(double x, double y, double radius){
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
    public void setX(double x){
        this.x=x;
    }
    public void setY(double y){
        this.y = y;
    }

    public void draw(){
        StdDraw.setPenColor(Color.green);
        StdDraw.filledSquare(this.x, this.y, this.radius);
    }

    public static LinkedList<Character> getList(){
        return character;
    }


    public static boolean isTouching(Character snake, Food food){

        if(Math.hypot((snake.getX() - food.getX()), (snake.getY() - food.getY())) <= .02){
            return true;
        } else {
            return false;
        }
    }

    public static boolean hitWall(Character head){
        StdDraw.setPenColor(Color.RED);


        for(Character block : character){
            if(block.getX() >= 1 || block.getX() <= 0){
                StdDraw.text(.5,.5, "You lose!");
                return true;
            }
            if(block.getY() >= 1 || block.getY() <= 0){
                StdDraw.text(.5,.5, "You lose!");
                return true;
            }
        }

        return false;
    }

    public static boolean touchingSelf(LinkedList<Character> character){

        for(int i = 2; i < character.size(); i++){
            if(character.getFirst().getX() == character.get(i).getX() && character.getFirst().getY() == character.get(i).getY()){
                StdDraw.setPenColor(Color.RED);
                StdDraw.text(.5,.5, "You lose!");
                return true;
            }
        }

        return false;
    }

    public static void followTheLeader(){

        double x = character.get(0).getX();
        double y = character.get(0).getY();
        double x2 = 0;
        double y2 = 0;

        for(int i = 1; i < character.size(); i++){

            x2=character.get(i).getX();
            y2=character.get(i).getY();

            if(direction == 1){
                    character.get(i).setY(y);
                    character.get(i).setX(x);
            }
            if(direction == 2){
                    character.get(i).setY(y);
                    character.get(i).setX(x);
            }
            if(direction == 3){
                    character.get(i).setY(y);
                    character.get(i).setX(x);
            }
            if(direction == 4){
                    character.get(i).setY(y);
                    character.get(i).setX(x);
            }
            x=x2;
            y=y2;
        }
    }

    public static void addHead(Character snake){
        character.add(snake);
    }


    public static void updateSnake(Character snake, Food food) {

        //draws characters
        for(int i = 0; i < character.size(); i++){
            character.get(i).draw();
        }

        //draws food
        Food.drawFood();

        //changes movement direction when key is pressed
        if (StdDraw.isKeyPressed(KeyEvent.VK_LEFT)) {
            direction = 1;
        } else if (StdDraw.isKeyPressed(KeyEvent.VK_RIGHT)) {
            direction = 2;
        } else if (StdDraw.isKeyPressed(KeyEvent.VK_UP)) {
            direction = 3;
        } else if (StdDraw.isKeyPressed(KeyEvent.VK_DOWN)) {
            direction = 4;
        }


        //movement of the snake
        if (direction == 1) {
            double distanceX = snake.getX() - .02;
            snake.setX(distanceX);
        }
        if (direction == 2) {
            double distanceX = snake.getX() + .02;
            snake.setX(distanceX);
        }
        if (direction == 3) {
            double distanceY = snake.getY() + .02;
            snake.setY(distanceY);
        }
        if (direction == 4) {
            double distanceY = snake.getY() - .02;
            snake.setY(distanceY);
        }

        //when snake eats food
        if (isTouching(snake, food)) {

            Food.removeFood(food);

            Food food1 = new Food(Math.random()*.8, Math.random()*.8, .01);

            Food.addFood(food1);

            Character newBlock = new Character(character.getLast().getX(), character.getLast().getY(), .01);
            character.add(newBlock);

        }

        followTheLeader();

    }


}
