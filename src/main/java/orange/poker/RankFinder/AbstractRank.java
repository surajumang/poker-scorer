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
public abstract class AbstractRank  implements Rank{

    public static final int NA = -1;

    @Override
    public Integer getScore(PokerHand pokerHand) {
        return NA;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " " + getOrder().toString();
    }
}
