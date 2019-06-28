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

import java.util.Arrays;

/**
 * Created 6/24/2019
 *
 * @author sjkumar
 */
public class RoyalFlush extends AbstractRank {
    //Ten, Jack, Queen, King, Ace, in same suit.
    private static final Rank flush = new Flush();

    @Override
    public boolean isApplicable(PokerHand pokerHand) {
        return flush.isApplicable(pokerHand) && checkIfAllMoreThanTen(pokerHand);
    }

    private static boolean checkIfAllMoreThanTen(PokerHand pokerHand){
        return Arrays.stream(pokerHand.getCards())
                .map(card -> card.getValue().getActualValue())
                .reduce(0, (a,b) -> a+b) == 60;
    }

    @Override
    public Integer getOrder() {
        return 10;
    }
}
