package BattleGame.Attack;

import BattleGame.AttackType;
import BattleGame.Hero;

public class Waterball implements AttackType {
    @Override
    public void attack(Hero attacker, Hero attacked) {
        attacked.damage((int)(attacker.getHp()*0.5));
    }
}
