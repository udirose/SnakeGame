package project;

import edu.princeton.cs.introcs.StdDraw;

import java.awt.*;
import java.util.LinkedList;

public class Snake {


	public static void main(String[] args) {

		StdDraw.enableDoubleBuffering();

		boolean alive = true;

		Character head = new Character(.5,.5, .01);
		Food food = new Food(.5,.5,.01);


        Character.addHead(head);
        Food.addFood(food);

		while(alive) {

			Character.updateSnake(head, Food.latestFood());

            //end conditions
			if(Character.hitWall(head)){
				alive = false;
			}
			if(Character.touchingSelf(Character.getList())){
				alive = false;
			}


			StdDraw.show(50);
			StdDraw.clear();
		}




	}
	
}