package com.company;

import java.util.ArrayList;
import java.util.Collection;

public class Game {
    ArrayList<Player> Players = new ArrayList<Player>();
    ArrayList<adds> Adds = new ArrayList<adds>();

   public Game()
    {
        Players.add(new Hero("Hero1", 300));
        Players.add(new Boss("Boss1", 500));
        addAdds(1);
    }

    private void addAdds(int number) {
        Adds.add(new adds(number));
        Adds.add(new adds(number));
    }


    public void Fight() throws InterruptedException {

        Player p1 = Players.get(0);
        Player boss = Players.get(1);
        var addGroup = 1;
        System.out.println(p1._name + "Entered the battlefield. He has: "+ p1._health +"healt, " + p1._strength + "strength & " + p1._critChance +" crit chance" );
        System.out.println(Adds.size() + " Adds entered the battlefield. They got " + Adds.get(0)._health +"health" + Adds.get(0)._strength +"strength & "+Adds.get(0)._critChance +" crit chance");
        System.out.println(boss._name + "Entered the battlefield. He has: "+ boss._health +"healt, " + boss._strength + "strength.");

        for (var i = 0; i < 10; i++) {
            var counter = 10 - i;
            System.out.println(counter);
            Thread.sleep(500);
        }

        while (p1._isAlive && (boss._isAlive || Adds.get(Adds.size()-1)._isAlive)) {


            while (checkAdds())
            {
                var currentAdd = findAliveAdd();
                p1.fightAdds(currentAdd);
                currentAdd.fight(p1);
                Thread.sleep(750);
            }
            if (boss._isAlive)
            {
                p1.fight(boss);
                boss.fight(p1);
            } if (addGroup != 2 && !boss._isAlive) {
                newAdds(addGroup);
                addGroup++;
            }

            Thread.sleep(750);
        }

    }

    private void newAdds(int addGroup) {
       for (var i = 0; i < 4; i++) {
           Adds.add(new adds(1));
       }
       System.out.println(">>>>>>>>>>>>New adds entered the battleground!<<<<<<<<<<<");
    }

    private adds findAliveAdd() {
        for (var add : Adds)
        {
            if (add._isAlive) return add;
        }return null;
    }

    private boolean checkAdds()
    {
        for (var add : Adds)
        {
            if (add._isAlive) return true;
        } return false;

    }

    public static int getRandomNum(int min, int max) {
        int randomNum = (int)Math.floor(Math.random() * max) +min;
        return randomNum;
    }
}
