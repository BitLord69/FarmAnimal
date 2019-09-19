package com.JanInc;

/*
Programmerat av Jan-Erik "Janis" Karlsson 2019-09-18
Programmering i Java EMMJUH19, EC-Utbildning
CopyLeft 2019 - JanInc
*/

import java.util.ArrayList;

public class Barn {
    private int maxSize;
    private int currentSize;
    private ArrayList<FarmAnimal> space;

    public Barn() {
        this.maxSize = 0;
        this.currentSize = 0;
        space = null;
    } // Barn:Barn

    public Barn(int maxSize) {
        this.maxSize = maxSize;
        this.currentSize = 0;
        space = new ArrayList<>();
        space.ensureCapacity(maxSize);
    } // Barn:Barn

    public boolean addAnimal(FarmAnimal animal) {
        if (currentSize < maxSize) {
            space.add(animal);
            currentSize++;
            return true;
        } else {
            return false;
        } // else
    } // addAnimal

    public boolean slaughterAnimal(FarmAnimal animal) {
        if (space.remove(animal)) {
            currentSize--;
            return true;
        } // if space...

        return false;
    } // // slaughterAnimal

    public FarmAnimal slaughterAnimal(int index) {
        FarmAnimal animal = null;

        if (index < 0 || index >= space.size()) {
            animal = space.remove(index);
            currentSize--;
        } // if space...

        return animal;
    } // // slaughterAnimal

    public FarmAnimal[] getAnimals() {
        FarmAnimal[] fa = new FarmAnimal[space.size()];
        fa = space.toArray(fa);
        return fa;
    } // getAnimals
}
