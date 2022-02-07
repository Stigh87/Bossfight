package com.company;

public class Hero extends Player {



    public Hero(String name, int health) {
        super(name, health);

        _critChance = getCritChance();
        _strength = getStrength();

    }

    private int getStrength() {
        var randomNr = Game.getRandomNum(10, 20);
        return randomNr;
    }

    private int getCritChance() {
        var randomNr = Game.getRandomNum(2, 5);
        return randomNr;
    }
}
