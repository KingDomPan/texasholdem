package com.alibaba.game.texasholdem.comparing;

import com.alibaba.game.texasholdem.Card;
import com.alibaba.game.texasholdem.Player;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public abstract class AbstractComparing implements IComparing {

    protected int pairComparing(Map<Integer, Integer> map1, Map<Integer, Integer> map2, int pair) {

        int p1Number = -1;
        int p2Number = -1;

        Iterator<Map.Entry<Integer, Integer>> it = map1.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, Integer> next = it.next();
            if (next.getValue() == 4) {
                p1Number = next.getKey();
            }
        }

        Iterator<Map.Entry<Integer, Integer>> it2 = map2.entrySet().iterator();
        while (it2.hasNext()) {
            Map.Entry<Integer, Integer> next = it2.next();
            if (next.getValue() == 4) {
                p2Number = next.getKey();
            }
        }

        if (p1Number > p2Number) {
            return -1;
        }
        if (p1Number < p2Number) {
            return 1;
        }

        return 0;
    }

    protected int seqComparing(Player p1, Player p2) {
        List<Card> p1Cards = p1.getCards();
        List<Card> p2Cards = p2.getCards();

        int size = p1.getCardSize();

        for (int i = 0; i < size; i++) {
            if (p1Cards.get(i).getRank().getNumber() < p2Cards.get(i).getRank().getNumber()) {
                return 1;
            }
            if (p1Cards.get(i).getRank().getNumber() > p2Cards.get(i).getRank().getNumber()) {
                return -1;
            }
            if (p1Cards.get(i).getRank().getNumber() == p2Cards.get(i).getRank().getNumber()) {
                continue;
            }
        }
        return 0;
    }

}
