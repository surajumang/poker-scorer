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

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * Created 6/24/2019
 *
 * @author sjkumar
 */
public abstract class NofAKind extends AbstractRank{
    // only the value needs to checked here and not the SUITE.
    //here the score would be the value of highest card which occurs in a Pair.
    private final int n;

    NofAKind(int n) {
        this.n = n;
    }

    @Override
    public boolean isApplicable(PokerHand pokerHand) {
        Map<Integer, Integer> frequency = getFrequencyMap(pokerHand);
        return frequency.values().contains(n);
    }

    @Override
    public Integer getScore(PokerHand pokerHand) {
        // find the key whose value is n, a reverse lookup.
        return getFrequencyMap(pokerHand).entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Comparator.comparing(Map.Entry::getKey)))
                .filter(entry -> entry.getValue().equals(n))
                .map(Map.Entry::getKey)
                .findFirst().orElseThrow(() -> new RuntimeException("Can't find an entry with value: " + n));
    }

    private static Map<Integer, Integer> getFrequencyMap(PokerHand pokerHand){
        PokerHand.Card[] cards = pokerHand.getCards();
        Map<Integer, Integer> frequency = new HashMap<>();

        for (PokerHand.Card card : cards) {
            frequency.merge(card.getValue().getActualValue(), 1, (a, b) -> a + b);
        }
        return frequency;
    }

    //a Pair
    public static class Pair extends NofAKind {

        public Pair() {
            super(2);
        }

        @Override
        public Integer getOrder() {
            return 2;
        }
    }

    public static class ThreeOfAKind extends NofAKind {

        public ThreeOfAKind() {
            super(3);
        }

        @Override
        public Integer getOrder() {
            return 4;
        }
    }

    public static class FourOfAKind extends NofAKind {

        public FourOfAKind() {
            super(4);
        }

        @Override
        public Integer getOrder() {
            return 8;
        }
    }
}
