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

import java.util.HashMap;
import java.util.Map;

/**
 * Created 6/24/2019
 *
 * @author sjkumar
 */
public class TwoPairs extends AbstractRank {
    @Override
    public boolean isApplicable(PokerHand pokerHand) {
        PokerHand.Card[] cards = pokerHand.getCards();
        Map<Integer, Integer> frequency = new HashMap<>();

        for (PokerHand.Card card : cards) {
            frequency.merge(card.getValue().getActualValue(), 1, (a, b) -> a + b);
        }
        int count = 0;
        for (Integer num: frequency.values()) {
            if (num>=2) count++;
        }
        return count == 2;
    }

    @Override
    public Integer getOrder() {
        return 3;
    }
}
