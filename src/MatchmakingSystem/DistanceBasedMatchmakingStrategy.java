package MatchmakingSystem;

import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

public class DistanceBasedMatchmakingStrategy implements MatchmakingStrategy{
    @Override
    public List<Individual>  matching(Individual individual, List<Individual> candidates) {
        Comparator<Individual> comparator = comparing(c -> individual.getCoords().distance(c.getCoords()));
        return candidates.stream()
                .sorted(comparator.thenComparingInt(Individual::getId))
                .toList();
    }
}
