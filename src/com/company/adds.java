package com.company;

import static com.company.Game.getRandomNum;

public class adds {

    String _name;
    int _health;
    int _strength;
    int _critChance;
    boolean _isAlive;

    public adds(int number) {

        _health = getHealth(number);
        _strength = getStrength(number);
        _critChance = getCritChance(number);
        _isAlive = true;
    }

    private int getCritChance(int number) {
        return getRandomNum(1, 3);
    }

    private int getStrength(int number) {
        return getRandomNum(6, 12);
    }

    private int getHealth(int number) {
        return 50;
    }


    public void fight(Player p1) {
        var critHit = getRandomNum(0, _critChance);
        var crit = critHit > 0 ? critHit : 1;
        p1._health -= (_strength * crit);
        if (p1._health <= 0) {
            p1._isAlive = false;
            System.out.println("xxxxxxxxxx------Current player died!------xxxxxxxxxx");
        } else System.out.println("Current player has " + p1._health + " left!");

    }
}
