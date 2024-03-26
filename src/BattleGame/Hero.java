package BattleGame;

import java.util.Scanner;

public class Hero {
    private String name;
    private int Hp = 500;

    private final AttackType attackType;
    public Hero(String name,AttackType attackType) {
        this.name=name;
        this.attackType = attackType;
    }

    public void attack(Hero hero){
        attackType.attack(this,hero);
    }
    public boolean die(){
        return Hp == 0;
    }
    public void damage(int damage){
        setHp(getHp()-damage);
        System.out.printf("英雄 %s 受到 %d 傷害. 生命值剩餘 %s \n",name,damage,Hp);
    }

    public String getName() {
        return name;
    }
    public int getHp() {
        return Hp;
    }

    public void setHp(int hp) {
        if(hp<0){
            Hp=0;
        }else{
            Hp = hp;
        }
    }
}
