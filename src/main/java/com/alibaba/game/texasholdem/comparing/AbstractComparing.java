package com.alibaba.game.texasholdem.comparing;

import com.alibaba.game.texasholdem.Card;
import com.alibaba.game.texasholdem.Player;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public abstract class AbstractComparing implements IComparing {

    /**
     * 按照三条或者或者四条的比较
     *
     * @param map1
     * @param map2
     * @param pair
     * @return
     */
    protected int multiComparing(Map<Integer, Integer> map1, Map<Integer, Integer> map2, int pair) {

        int p1Number = -1;
        int p2Number = -1;

        Iterator<Map.Entry<Integer, Integer>> it = map1.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, Integer> next = it.next();
            if (next.getValue() == pair) {
                p1Number = next.getKey();
            }
        }

        Iterator<Map.Entry<Integer, Integer>> it2 = map2.entrySet().iterator();
        while (it2.hasNext()) {
            Map.Entry<Integer, Integer> next = it2.next();
            if (next.getValue() == pair) {
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

    /**
     * 按照顺序的比较
     *
     * @param p1
     * @param p2
     * @return
     */
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

    /**
     * @param map1
     * @param map2
     * @param pair              对子的数量
     * @param maxPairLoopAddOne 对子最大的循环数量+1
     * @return
     */
    protected int pairComparing(Map<Integer, Integer> map1, Map<Integer, Integer> map2, int pair, int maxPairLoopAddOne) {
        if (maxPairLoopAddOne - 1 == 0) {
            pair = 1;
        }
        int p1MaxNum = this.findMaxNumber(map1, pair);
        int p2MaxNum = this.findMaxNumber(map2, pair);

        if (p1MaxNum < p2MaxNum) {
            return 1;
        }
        if (p1MaxNum > p2MaxNum) {
            return -1;
        }
        if (p1MaxNum == p2MaxNum) {
            map1.remove(p1MaxNum);
            map2.remove(p2MaxNum);
            if (map1.size() == map2.size() && 0 == maxPairLoopAddOne - 1) {
                return this.pairComparing(map1, map2, pair - 1, 1);
            }
            return this.pairComparing(map1, map2, pair, maxPairLoopAddOne - 1);
        }
        return 0;
    }

    private int findMaxNumber(Map<Integer, Integer> map, int pair) {
        int p1Number = -1;

        Iterator<Map.Entry<Integer, Integer>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, Integer> next = it.next();
            if (next.getValue() == pair) {
                int number = next.getKey();
                if (number > p1Number) {
                    p1Number = number;
                }
            }
        }
        return p1Number;

    }

}
