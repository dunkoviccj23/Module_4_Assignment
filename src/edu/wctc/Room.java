package edu.wctc;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Room implements Serializable {

    private List<Wall> wallList = new ArrayList<>();

    public Room(double length, double width, double height) {
        Wall wallOne = new Wall(width,height);
        Wall wallTwo = new Wall(width,height);
        Wall wallThree = new Wall(length, height);
        Wall wallFour = new Wall(length, height);

        wallList.add(wallOne);
        wallList.add(wallTwo);
        wallList.add(wallThree);
        wallList.add(wallFour);
    }

    public double getArea() {
        double totalArea = 0;
        for (Wall someWall : wallList) {
            totalArea += someWall.getArea();
        }
        return totalArea;
    }

    public String toString() {
        return "edu.wctc.Room area is " + this.getArea();
    }

}
