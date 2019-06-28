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
package orange.poker.TieBreaker;

import orange.poker.PokerHand;
import orange.poker.RankFinder.Rank;

/**
 * Created 6/24/2019
 *
 * @author sjkumar
 */
public class TieBreaker {

    private int getWinner(PokerHand first, PokerHand second){
        for (int i = 0; i < 5; i++) {
            PokerHand.Card one = first.getCards()[i];
            PokerHand.Card two = second.getCards()[i];
            if (one.compareTo(two) != 0){
                return one.compareTo(two) < 0 ? 1 : 0;
            }
        }
        throw new RuntimeException("Cannot resolve tie between Hands \n" + first + " and \n" + second
                                    + "They are completely identical");
    }

    public int getWinner(PokerHand first, PokerHand second, Rank tiedRank){
        // first the rank tie needs to be broken, like between Pair of Queen and Pair of Eights.
        if (tiedRank.getScore(first).equals(tiedRank.getScore(second))){
            //rank scores are equal then fall back to max valued card test.
            return getWinner(first, second);
        }
        return tiedRank.getScore(first).compareTo(tiedRank.getScore(second)) < 0 ? 1 : 0;
    }
}
