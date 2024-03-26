package MatchmakingSystem;

import java.util.Comparator;

public class Coords implements Comparator<Coords> {
    private final double X;
    private final double Y;

    public Coords(double x, double y) {
        X = x;
        Y = y;
    }

    public double getX() {
        return X;
    }

    public double getY() {
        return Y;
    }
    public double distance(Coords coord){
        double diffX = Math.abs(X - coord.getX());
        double diffY = Math.abs(Y - coord.getY());
        return Math.sqrt(diffX*diffX + diffY-diffY);
    }

    @Override
    public int compare(Coords o1, Coords o2) {
        return 0;
    }

}
