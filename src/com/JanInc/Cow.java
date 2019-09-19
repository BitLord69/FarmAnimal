package com.JanInc;

/*
Programmerat av Jan-Erik "Janis" Karlsson 2019-09-18
Programmering i Java EMMJUH19, EC-Utbildning
CopyLeft 2019 - JanInc
*/

public class Cow extends FarmAnimal {
    public Cow(){
        super("Cow", "Mooooooooo");
    }

    public Cow(String name) {
        super(name, "Mooooooooo");
    }

    @Override
    public String toString() {
        return String.format("Cow - {%s}", super.toString());
    }
}
