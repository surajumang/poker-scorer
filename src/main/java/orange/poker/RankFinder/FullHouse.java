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
package orange.poker.RankFinder;

import orange.poker.PokerHand;

/**
 * Created 6/24/2019
 *
 * @author sjkumar
 */
public class FullHouse extends AbstractRank {
    //three of a kind and a pair
    private static final Rank threeOfAKind = new NofAKind.ThreeOfAKind();
    private static final Rank pair = new NofAKind.Pair();


    @Override
    public boolean isApplicable(PokerHand pokerHand) {
        return threeOfAKind.isApplicable(pokerHand) && pair.isApplicable(pokerHand);
    }

    @Override
    public Integer getOrder() {
        return 7;
    }

    @Override
    public Integer getScore(PokerHand pokerHand) {
        System.out.println("FullHouse score computation with hand:" + pokerHand);
        return threeOfAKind.getScore(pokerHand);
    }
}
