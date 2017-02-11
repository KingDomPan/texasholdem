package com.alibaba.game.texasholdem;

import junit.framework.TestCase;
import org.junit.Test;

public class RuleRankingEnumTest extends TestCase {

    @Test
    public void testGetNumber() {

        RuleRankingEnum ruleRanking1 = RuleRankingEnum.FLUSH;

        assertEquals(ruleRanking1.getType(), "同花");
        assertEquals(ruleRanking1.getPriority(), 600);
    }
    
}
