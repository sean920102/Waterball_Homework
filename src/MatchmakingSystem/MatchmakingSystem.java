package MatchmakingSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.String.join;
import static java.util.stream.Collectors.toList;

public class MatchmakingSystem {
    private final List<Individual> individualList;
    private MatchmakingStrategy matchmakingStrategy;
    private static final Scanner in = new Scanner(System.in);

    public MatchmakingSystem(List<Individual> individualList) {
        this.individualList = individualList;
    }

    public void findBaseMatch(){
        System.out.println("【輸入會員編號】");
        int id = in.nextInt();
        Individual individual;

        if(individualList.stream().anyMatch(value -> value.getId()==id))
        {
            individual = individualList.stream()
                    .filter(value -> value.getId()==id)
                    .findAny().get();

            List<Individual> other = individualList.stream()
                    .filter(i -> i != individual).toList();
            List<Individual> result;
            setMatchmakingStrategy(new DistanceBasedMatchmakingStrategy());
            result = matchmakingStrategy.matching(individual, other);
            System.out.println("【最近距離】");
            result.forEach(val-> System.out.print(val.getId()+" "));

            setMatchmakingStrategy(new HabitBasedMatchmakingStrategy());
            result = matchmakingStrategy.matching(individual, other);
            System.out.println("\n【興趣交集最多】");
            result.forEach(val-> System.out.print(val.getId()+" "));

            setMatchmakingStrategy(new Reverse(new HabitBasedMatchmakingStrategy()));
            result = matchmakingStrategy.matching(individual, other);
            System.out.println("\n【興趣交集最少】");
            result.forEach(val-> System.out.print(val.getId()+" "));
        }
        else{
            System.out.println("查無此編號");
            findBaseMatch();
        }
    }

    public List<Individual> getIndividualList() {
        return individualList;
    }

    public void setMatchmakingStrategy(MatchmakingStrategy matchmakingStrategy) {
        this.matchmakingStrategy = matchmakingStrategy;
    }
}
