package com.company;

import static org.junit.jupiter.api.Assertions.*;

class addsTest {

    @org.junit.jupiter.api.Test
    void fight() {
        var p1 = new Hero("TestHero", 10);
        var add = new adds(1);
        add._strength = 9;

        var critHit = 2; //getRandomNum(0, add._critChance);
        var crit = critHit > 0 ? critHit : 1;
        var accDmg = add._strength * crit;
        p1._health -= accDmg;
        if (p1._health <= 0) {
            p1._isAlive = false;
        }

        assertEquals(false, p1._isAlive);
        assertEquals(18,accDmg);
        assertEquals(p1._health, -8);

        //assertEquals(true, p1._isAlive);
        //assertEquals(9,accDmg);
        //assertEquals(p1._health, 1);
        }


}