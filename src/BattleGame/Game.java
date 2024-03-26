package BattleGame;

import BattleGame.Attack.Fireball;
import BattleGame.Attack.Waterball;

import java.text.Format;
import java.util.List;
import java.util.Scanner;

import static java.util.Arrays.asList;
import static java.util.Collections.swap;

public class Game {
    private final List<Hero> heroes;
    private final static Scanner in = new Scanner(System.in);
    public Game() {
        this.heroes = asList(new Hero("A1",new Fireball()),new Hero("A2",new Waterball()));
    }

    public void start(){
        System.out.println("【遊戲開始】");
        takeTurn();
    }

    public void takeTurn(){
//        System.out.println("【選擇攻擊方式】1.水球攻擊 2.火球攻擊 3.地球攻擊");
//        int attackType = in.nextInt();
//
//        System.out.println("【選擇攻擊玩家】");
//        for(int i=0;i<heroes.size();i++){
//            System.out.printf("%s.%s ",i+1, heroes.get(i).getName());
//        }
//        int attacked = in.nextInt();
//        hero.attack(heroes.get(attacked),hero.getAttackType());

        Hero attacker = heroes.get(0);
        Hero attacked = heroes.get(1);
        attacker.attack(attacked);
        swap(heroes,0,1);
        if(attacked.die()){
            System.out.printf("英雄 %S 死亡",attacked.getName());
        }else{
            takeTurn();
        }
    }
    public List<Hero> getHeroes() {
        return heroes;
    }
}
