package MatchmakingSystem;

import java.util.List;

import static java.util.Collections.reverse;

public class Reverse implements MatchmakingStrategy{
    private final MatchmakingStrategy matchingStrategy;

    public static Reverse reversed(MatchmakingStrategy matchingStrategy) {
        return new Reverse(matchingStrategy);
    }

    public Reverse(MatchmakingStrategy matchingStrategy) {
        this.matchingStrategy = matchingStrategy;
    }
    @Override
    public List<Individual> matching(Individual individual, List<Individual> candidates) {
        List<Individual> result = matchingStrategy.matching(individual, candidates);
        reverse(result);
        return result;
    }
}
