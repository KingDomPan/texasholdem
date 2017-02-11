package com.alibaba.game.texasholdem;

import com.alibaba.game.texasholdem.ranking.RankingResult;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Class {@code Player} 一个玩家, 持有5张牌, 并伴随牌型的属性.
 */
public class Player {

    private List<Card> cards; // 玩家手上的五张牌
    private RankingResult rankingResult; // 牌型校验结果

    public Player() {
        this.cards = new ArrayList<Card>();
    }

    /**
     * 获得手上的牌的张数
     * @return
     */
    public int getCardSize() {
        return this.cards.size();
    }

    /**
     * 增加手牌
     * @param card
     */
    public void addCard(Card card) {
        this.cards.add(card);
        Collections.sort(this.cards);
    }

    public List<Card> getCards() {
        return cards;
    }

    public RankingResult getRankingResult() {
        if (rankingResult == null) {
            rankingResult.setRankingEnum(RuleRankingEnum.HIGH_CARD);
            rankingResult.setHighCard(this.cards.get(0));
        }
        return rankingResult;
    }

    public void setRankingResult(RankingResult rankingResult) {
        this.rankingResult = rankingResult;
    }
}
