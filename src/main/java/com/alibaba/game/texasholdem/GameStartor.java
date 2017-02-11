package com.alibaba.game.texasholdem;

import java.util.List;

public class GameStartor {

    public static void main(String[] args) {
        Dealer d = new Dealer();

        Player me = new Player();
        Player you = new Player();

        d.join(me);
        d.join(you);

        d.start();

        List<Player> players = d.getRankingPlayers();

        for (Player player : players) {
            System.out.println(player.toString());
        }
    }

}
