package com.JanInc;

/*
Programmerat av Jan-Erik "Janis" Karlsson 2019-09-19
Programmering i Java EMMJUH19, EC-Utbildning
CopyLeft 2019 - JanInc
*/

import java.util.InputMismatchException;
import java.util.Scanner;

public class Farm {
    private Barn barn;

    public Farm() {
        barn = null;
    }

    public Farm(int nAntalDjur) {
        barn = new Barn(nAntalDjur);
    }

    public void manageFarm() {
        boolean bQuit = false;
        do {
            printMainMenu();
            switch (getMenuChoice(4, this::printMainMenu)) {
                case 1:
                    addAnimal();
                    break;
                case 2:
                    playSounds();
                    break;
                case 3:
                    slaugtherAnimal();
                    break;
                case 4:
                    bQuit = true;
                    break;
            } // switch
        } while (!bQuit);
    } // manageFarm

    private void slaugtherAnimal() {
        System.out.println("Sorry, we cannot allow you to do that!");
    }

    private void playSounds() {
        FarmAnimal[] animals = barn.getAnimals();

        if (animals.length == 0)
            System.out.println("Sorry, the barn is emtpy!");
        else
            for (FarmAnimal a : animals) {
                System.out.printf("%s%n", a);
            }

        System.out.println();
    } // playSounds

    private void addAnimal() {
        Scanner scan = new Scanner(System.in);
        String name;
        FarmAnimal animal;

        System.out.print("What's the name of your new animal? ");
        name = scan.nextLine();

        printAddMenu();
        switch (getMenuChoice(2, this::printAddMenu)) {
            case 1:
                animal = new Cow(name);
                break;

            case 2:
                animal = new Sheep(name);
                break;

            default:
                animal = null;
                break;
        } // switch

        if (animal != null && !barn.addAnimal(animal))
            System.out.printf("Sorry, the barn is full and %s won't fit in there!%n", animal.getName());
    } // addAnimal

    private void printAddMenu() {
        System.out.println("1. Cow");
        System.out.println("2. Sheep");
        System.out.print("\nPlease choose what kind of animal to add: ");
    } // printAddMenu

    private int getMenuChoice(int max, Runnable menu) {
        boolean bBadInput = true;
        int menuChoice = 0;
        Scanner scan = new Scanner(System.in);

        // Loopa tills vi har ett giltigt menyval, från ett till max nummer . Sollar även bort om man matar in text
        // Variabeln menu är en metodpekare till en print-metod som ska köras för att skriva ut meny på nytt vid felaktig inmatning
        do {
            try {
                menuChoice = scan.nextInt();
                if (menuChoice < 0 || menuChoice > max) {
                    System.out.println("I'm so sorry, but I cannot accommodate that choice! Please try again");
                    menu.run();
                } else if (scan.nextLine().equals(""))
                    bBadInput = false;
            } catch (InputMismatchException ex) {
                System.out.println("Oops, something went wrong - probably not a number, right? Please try again!");
                scan.nextLine();
                menu.run();
            } // catch
        } while (bBadInput);
        return menuChoice;
    } // getMenuChoice

    private void printMainMenu() {
        System.out.println("What kind of operation do you want to do?");
        System.out.println("1. Add an animal");
        System.out.println("2. \"Hear\" the noise from the animals");
        System.out.println("3. Slaughter an animal");
        System.out.println("4. Quit");
        System.out.print("\nPlease enter your choice: ");
    } // printMainMenu
}
