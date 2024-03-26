package MatchmakingSystem;

import Showdown.Showdown;

import java.util.*;

import static java.util.Arrays.asList;
import static java.util.Collections.shuffle;
public class Main {
    private static Random random = new Random();
    private static  final String[] habits = {"籃球","羽球","遊戲","游泳","跑步","爬山"};
    private static final int addIndividuals = 30;
    public static void main(String[] args) {

        List<Individual> individuals = new ArrayList<>();
        for (int i = 0; i < addIndividuals; i++) {
            individuals.add(
                    new Individual(
                            random.nextBoolean() ? Individual.Gemder.MALE: Individual.Gemder.FEMALE,
                            random.nextInt(50) + 18,
                            "intro",randomHabits(),
                            new Coords(random.nextDouble(2000.000), random.nextDouble(2000.000))
                    )
            );
        }
        MatchmakingSystem matchmakingSystem = new MatchmakingSystem(individuals);
        matchmakingSystem.findBaseMatch();
    }
    public static Set<String> randomHabits(){
        int size = random.nextInt(habits.length)+1;
        List<String> habitlist = asList(habits);
        return new HashSet<>(habitlist.subList(0,size));
    }
}
