package edu.wctc;

import java.io.*;
import java.util.Scanner;

public class Main {
    private static Scanner keyboard = new Scanner(System.in);
    private static PaintCalculator paintCalculator = new PaintCalculator();

    public static void main(String[] args) {
        int userInput = 0;
        while(userInput != 5){
            printMenu();
            userInput = keyboard.nextInt();

            if (userInput == 1) {
                createRoom();
            } else if (userInput == 2) {
                writeFile();
            } else if (userInput == 3) {
                readFile();
            } else if (userInput == 4) {
                System.out.println(paintCalculator.toString());
            }
        }
    }

    private static void printMenu() {
        System.out.println("1. Add room");
        System.out.println("2. Write rooms to file");
        System.out.println("3. Read rooms from file");
        System.out.println("4. View rooms");
        System.out.println("5. Exit");
        System.out.print("Enter selection: ");
    }

    private static double promptForDimension(String dimensionName) {
        System.out.print("Enter the room's " + dimensionName + ": ");
        return keyboard.nextDouble();
    }

    private static void createRoom() {
        double userLength = promptForDimension("length");
        double userWidth = promptForDimension("width");
        double userHeight = promptForDimension("height");

        paintCalculator.addRoom(userLength, userWidth, userHeight);

        System.out.println("Room successfully created.");
    }

    private static void readFile() {
        try (
            FileInputStream fis = new FileInputStream("paintCalc.obj");
            ObjectInputStream ois = new ObjectInputStream(fis);
        ) {
            paintCalculator = (PaintCalculator) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void writeFile() {
        try (
            FileOutputStream fos = new FileOutputStream("paintCalc.obj");
            ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(paintCalculator);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



