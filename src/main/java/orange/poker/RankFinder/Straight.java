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
public class Straight extends AbstractRank {
    @Override
    public boolean isApplicable(PokerHand pokerHand) {
        PokerHand.Card[] cards = pokerHand.getCards();
        Integer initialValue = cards[0].getValue().getActualValue();
        for (int i=1; i < cards.length; i++) {
            if (!cards[i].getValue().getActualValue().equals(--initialValue)){
                return false;
            }
        }
        return true;
    }

    @Override
    public Integer getOrder() {
        return 5;
    }
    // all cards of consecutive values.

}
