package com.alibaba.game.texasholdem.ranking;

import com.alibaba.game.texasholdem.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * Class {@code RankingFacade}
 * 牌型校验统一入口
 */
public class RankingFacade implements IRanking {

    private final static List<IRanking> rankings = new ArrayList<IRanking>();
    private static RankingFacade instance = null;
    private final static Object lock = new Object();

    static {
        rankings.add(new RoyalFlushRankingImpl());
        rankings.add(new StraightFlushRankingImpl());
        rankings.add(new FourOfTheKindRankingImpl());
        rankings.add(new FullHouseRankingImpl());
        rankings.add(new FlushRankingImpl());
        rankings.add(new StraightRankingImpl());
        rankings.add(new ThreeOfTheKindRankingImpl());
        rankings.add(new TwoPairsRankingImpl());
        rankings.add(new OnePairRankingImpl());
        rankings.add(new HighCardRankingImpl());
        rankings.add(new DefaultRankingImpl());
    }

    private RankingFacade() {
    }

    public static RankingFacade getInstance() {
        if (instance == null) {
            synchronized (lock) {
                if (instance == null) {
                    instance = new RankingFacade();
                }
            }
        }
        return instance;
    }

    public RankingResult resolve(Player player) {
        RankingResult result = null;
        for (IRanking ranking : RankingFacade.rankings) {
            result = ranking.resolve(player);
            if (result != null) {
                return result;
            }
        }
        return result;
    }

}
