package com.JanInc;

/*
Programmerat av Jan-Erik "Janis" Karlsson 2019-09-18
Programmering i Java EMMJUH19, EC-Utbildning
CopyLeft 2019 - JanInc
*/

public abstract class FarmAnimal {
    private String name;
    private String sound;

    public FarmAnimal() {

        name = null;
        sound = null;
    }

    public FarmAnimal(String name, String sound) {
        this.name = name;
        this.sound = sound;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }

    public String noise(){
        return sound;
    }

    @Override
    public String toString() {
        return String.format("FarmAnimal - %s{name=%s, sound=%s}", getClass().getSimpleName(), name, sound);
    }
}
