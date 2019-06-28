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

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created 6/24/2019
 *
 * @author sjkumar
 */
public class RankFinder {
    //uses all the Ranks in highest to lowest order and finds out the first one which is applicable.
    private static final List<Rank> RANKS = new ArrayList<>();
    static {
        RANKS.add(new HighCard());
        RANKS.add(new NofAKind.Pair());
        RANKS.add(new TwoPairs());
        RANKS.add(new NofAKind.ThreeOfAKind());
        RANKS.add(new Straight());
        RANKS.add(new Flush());
        RANKS.add(new FullHouse());
        RANKS.add(new NofAKind.FourOfAKind());
        RANKS.add(new StraightFlush());
        RANKS.add(new RoyalFlush());

        RANKS.sort(Collections.reverseOrder(Comparator.comparing(Rank::getOrder)));
    }

    public List<Rank> getRanks(){
        return RANKS;
    }

    public Rank getRank(PokerHand pokerHand){
        return RANKS.stream()
                .filter(rank -> rank.isApplicable(pokerHand))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No matching Rank"));
    }
}
