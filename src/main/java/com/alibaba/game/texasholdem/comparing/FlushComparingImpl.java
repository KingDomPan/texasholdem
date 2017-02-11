package com.alibaba.game.texasholdem.comparing;

import com.alibaba.game.texasholdem.Player;

/**
 * Class {@code StraightFlushComparingImpl}
 * 同花顺的大小比较(比较最大牌即可)
 */
public class FlushComparingImpl extends AbstractComparing {

    public int compare(Player o1, Player o2) {
        return this.seqComparing(o1, o2);
    }

}
