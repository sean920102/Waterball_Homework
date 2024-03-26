package Showdown;

import static java.util.Arrays.asList;

public class Main {
    public static void main(String[] args) {
        Showdown showdown = new Showdown(asList(new Human(),new AI(),new AI(),new AI()));
        showdown.start();
    }
}