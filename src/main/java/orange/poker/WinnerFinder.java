/*
 * Copyright 2006-2019 (c) Care.com, Inc.
 * 1400 Main Street, Waltham, MA, 02451, U.S.A.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Care.com, Inc. ("Confidential Information").  You shall not disclose
 * such Confidential Information and shall use it only in accordance with
 * the terms of an agreement between you and CZen.
 */
package orange.poker;

import orange.poker.RankFinder.Rank;
import orange.poker.RankFinder.RankFinder;
import orange.poker.TieBreaker.TieBreaker;

/**
 * Created 6/24/2019
 *
 * @author sjkumar
 */
public class WinnerFinder {
    private static final RankFinder rankFinder = new RankFinder();
    private static final TieBreaker tieBreaker = new TieBreaker();

    public int findWinner(PokerHand first, PokerHand second){
        Rank rankFirst = rankFinder.getRank(first);
        Rank rankSecond = rankFinder.getRank(second);
        if (rankFirst.getOrder().equals(rankSecond.getOrder())){
            return tieBreaker.getWinner(first, second, rankFirst);
        }
        return rankFirst.getOrder().compareTo(rankSecond.getOrder()) < 0 ? 1 : 0;
    }
}
