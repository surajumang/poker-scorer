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

import org.assertj.core.api.Assertions;
import org.junit.Test;

/**
 * Created 6/24/2019
 *
 * @author sjkumar
 */
public class CardTest {

    @Test
    public void testCardCreation1(){
        String value = "10S";
        PokerHand.Card card = PokerHand.Card.createFrom(value);
        PokerHand.Card actual = new PokerHand.Card(PokerHand.Card.Value.create("10"), PokerHand.Card.Suite.create("S"));

        Assertions.assertThat(card).isEqualByComparingTo(actual);
    }

    @Test
    public void testCardCreation2(){
        String value = "AD";
        PokerHand.Card card = PokerHand.Card.createFrom(value);
        PokerHand.Card actual = new PokerHand.Card(PokerHand.Card.Value.create("A"), PokerHand.Card.Suite.create("D"));

        Assertions.assertThat(card).isEqualByComparingTo(actual);
    }

    @Test
    public void testCardCreation(){
        String value = "5D";
        PokerHand.Card card = PokerHand.Card.createFrom(value);
        PokerHand.Card actual = new PokerHand.Card(PokerHand.Card.Value.create("5"), PokerHand.Card.Suite.create("D"));

        Assertions.assertThat(card).isEqualByComparingTo(actual);
    }

    @Test
    public void compareCards(){
        String value = "AS";
        PokerHand.Card card = PokerHand.Card.createFrom(value);
        PokerHand.Card other = new PokerHand.Card(PokerHand.Card.Value.create("J"), PokerHand.Card.Suite.create("D"));
        PokerHand.Card other2 = new PokerHand.Card(PokerHand.Card.Value.create("5"), PokerHand.Card.Suite.create("C"));

        Assertions.assertThat(card).isGreaterThan(other);
        Assertions.assertThat(other2).isLessThan(other);
    }
}
