package com.JanInc;

/*
Programmerat av Jan-Erik "Janis" Karlsson 2019-09-18
Programmering i Java EMMJUH19, EC-Utbildning
CopyLeft 2019 - JanInc
*/

public class Sheep extends FarmAnimal {
    public Sheep() {
        super("Sheep", "Baaaaaaa");
    }

    public Sheep(String name) {
        super(name, "Baaaaaaa");
    }

    @Override
    public String toString() {
        return String.format("Sheep - {%s}", super.toString());
    }
}
