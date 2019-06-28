package orange.poker;

import org.junit.Test;

/**
 * Created 6/24/2019
 *
 * @author sjkumar
 */
public class PokerHandTest {

    @Test
    public void getCards() {
        String hand = "4S 2S 3S 4S 5S";
        PokerHand pokerHand = new PokerHand(hand);
        for (PokerHand.Card card: pokerHand.getCards()
             ) {
            System.out.println(card);
        }
    }

    @Test
    public void checkOrder(){
        String hand = "AS 2S KS 4S 10S";
        PokerHand pokerHand = new PokerHand(hand);
        for (PokerHand.Card card: pokerHand.getCards()
        ) {
            System.out.println(card);
        }
    }


}