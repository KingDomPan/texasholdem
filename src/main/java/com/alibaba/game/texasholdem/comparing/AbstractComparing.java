package com.alibaba.game.texasholdem.comparing;

import java.util.Iterator;
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

}
