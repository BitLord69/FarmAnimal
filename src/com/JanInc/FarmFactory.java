package com.JanInc;

/*
Programmerat av Jan-Erik "Janis" Karlsson 2019-09-19
Programmering i Java EMMJUH19, EC-Utbildning
CopyLeft 2019 - JanInc
*/

import java.util.Scanner;

public class FarmFactory {
    public static Farm createFarm(){
        System.out.print("How many animals should we create space for in your new barn? ");
        Scanner scan = new Scanner(System.in);
        int nAnim = scan.nextInt();
        return new Farm(nAnim);
    } // createFarm
} // FarmFactory
