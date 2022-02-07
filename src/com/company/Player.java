package com.company;

public class Player
{
    String _name;
    int _health;
    int _strength;
    int _critChance;
    boolean _isAlive;

    public Player(String name, int health)
    {
        _name = name;
        _health = health;
        _isAlive = true;
    }

    public void fight(Player enemy) {

        var critHit = Game.getRandomNum(0, _critChance);
        var crit = critHit > 0 ? critHit : 1;
        enemy._health -= (_strength * crit);
        printInfo(enemy, crit);
        checkStatus(enemy);

    }

    private void checkStatus(Player enemy) {

        enemy._isAlive = enemy._health > 0;
    }

    private void printInfo(Player enemy, Integer crit) {

        var accumulatedDmg = _strength * crit;
        if (crit > 1) System.out.println(_name + " hit " + enemy._name + " for " + accumulatedDmg + "damage with critical hit " +crit +"%");
        else System.out.println(_name + " hit " + enemy._name + " for " + accumulatedDmg +"damage");
        System.out.println(enemy._name +" has " + enemy._health + " left!");

    }

    public void fightAdds(adds add) {
        var critHit = Game.getRandomNum(0, _critChance);
        var crit = critHit > 0 ? critHit : 1;
        add._health -= (_strength * crit);
        if (add._health <= 0) {
            add._isAlive = false;
            System.out.println("******Current add died!******");
        } else System.out.println("Current add has " + add._health + " left!");
    }
}
