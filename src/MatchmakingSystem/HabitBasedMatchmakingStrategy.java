package MatchmakingSystem;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.toList;

public class HabitBasedMatchmakingStrategy implements MatchmakingStrategy{
    @Override
    public List<Individual> matching(Individual individual, List<Individual> individualList) {

        Comparator<Individual> comparator = comparingInt(k -> intersectionSize(k.getHabits(), individual.getHabits()));
        return individualList.stream()
                .sorted(comparator)
                .collect(toList());
    }

    public static <T> int intersectionSize(Set<T> s1, Set<T> s2) {
        return intersection(s1, s2).size();
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    public static <T> Set<T> intersection(Set<T> s1, Set<T> s2) {
        Set temp = new HashSet(s1);
        temp.retainAll(s2);
        return temp;
    }
}
