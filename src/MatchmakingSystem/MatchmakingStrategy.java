package MatchmakingSystem;

import java.util.List;

public interface MatchmakingStrategy {
    public List<Individual>  matching(Individual individual, List<Individual> individualList);
}
