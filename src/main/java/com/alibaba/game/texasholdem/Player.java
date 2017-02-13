package com.alibaba.game.texasholdem;

import com.alibaba.game.texasholdem.comparing.ComparingFacade;
import com.alibaba.game.texasholdem.comparing.IComparing;
import com.alibaba.game.texasholdem.ranking.RankingResult;

import java.util.*;

/**
 * Class {@code Player} 一个玩家, 持有5张牌, 并伴随牌型的属性.
 */
public class Player implements Comparable<Player> {

    private List<Card> cards; // 玩家手上的五张牌
    private RankingResult rankingResult; // 牌型校验结果

    public Player() {
        this.cards = new ArrayList<Card>();
    }

    /**
     * 获得手上的牌的张数
     *
     * @return
     */
    public int getCardSize() {
        return this.cards.size();
    }

    /**
     * 增加手牌
     *
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
            rankingResult =  new RankingResult();
            rankingResult.setRankingEnum(RankingEnum.HIGH_CARD);
            rankingResult.setHighCard(this.cards.get(0));
        }
        return rankingResult;
    }

    public Map<Integer, Integer> getCardsRankCountMap() {
        List<Card> cards = this.getCards();
        Map<Integer, Integer> rankCount = new HashMap<Integer, Integer>();
        for (Card card : cards) {
            Integer number = new Integer(card.getRank().getNumber());
            if (!rankCount.containsKey(number)) {
                rankCount.put(number, 1);
            } else {
                rankCount.put(number, rankCount.get(number) + 1);
            }
        }
        return rankCount;
    }

    public void setRankingResult(RankingResult rankingResult) {
        this.rankingResult = rankingResult;
    }

    public int compareTo(Player o) {
        int selfPriority = this.getRankingResult().getRankingEnum().getPriority();
        int otherPriority = o.getRankingResult().getRankingEnum().getPriority();

        if (selfPriority < otherPriority) {
            return 1;
        }
        if (selfPriority > otherPriority) {
            return -1;
        }

        if (selfPriority == otherPriority) {
            IComparing cmp = ComparingFacade.getComparing(this.getRankingResult().getRankingEnum());
            return cmp.compare(this, o);
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Player{" +
                "cards=" + cards +
                ", rankingResult=" + rankingResult +
                '}';
    }
}
