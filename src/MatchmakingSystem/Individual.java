package MatchmakingSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public class Individual {
    private static int index=0;
    private int id;
    private Gemder gemder;
    private int age;
    private String intro;
    private Set<String> habits;
    private Coords coords;

    public Individual(Gemder gemder, int age, String intro, Set<String> habits, Coords coords) {
        setId(index++);
        setGemder(gemder);
        setAge(age);
        setIntro(intro);
        setHabits(habits);
        setCoords(coords);
    }

    public enum Gemder{
        MALE,FEMALE
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Gemder getGemder() {
        return gemder;
    }

    public void setGemder(Gemder gemder) {
        this.gemder = gemder;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(age>=18){
            this.age = age;
        }
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public Set<String> getHabits() {
        return habits;
    }

    public void setHabits(Set<String> habits) {
        this.habits = habits;
    }

    public Coords getCoords() {
        return coords;
    }

    public void setCoords(Coords coords) {
        this.coords = coords;
    }
}

