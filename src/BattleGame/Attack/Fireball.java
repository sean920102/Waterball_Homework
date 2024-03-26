package BattleGame.Attack;

import BattleGame.AttackType;
import BattleGame.Hero;

public class Fireball implements AttackType {
    @Override
    public void attack(Hero attacker, Hero attacked) {
        for(int i=0;i<3;i++){
            attacked.damage(50);
        }
    }
}
