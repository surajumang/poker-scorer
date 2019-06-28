package orange.poker;

import org.assertj.core.api.Assertions;
import org.junit.Test;

/**
 * Created 6/24/2019
 *
 * @author sjkumar
 */
public class WinnerFinderTest {

    @Test
    public void findWinnerFirst() {
        String value1 = "4S 2S QS 4S 5S", value2 = "4S 2S 3S 10S 5S";
        PokerHand pokerHand = new PokerHand(value1);
        PokerHand pokerHand2 = new PokerHand(value2);

        Assertions.assertThat(new WinnerFinder().findWinner(pokerHand, pokerHand2)).isEqualTo(0);
    }

    @Test
    public void findWinnerSecond(){
        String value1 = "4S 2S QS 4S 5S", value2 = "4S 2S 3S AS 5S";
        //first is a Flush with highes value Q, second is a flush with highest Ace, Winner = 1;
        PokerHand pokerHand = new PokerHand(value1);
        PokerHand pokerHand2 = new PokerHand(value2);

        Assertions.assertThat(new WinnerFinder().findWinner(pokerHand, pokerHand2)).isEqualTo(1);
    }

    @Test
    public void checkPlayerNumber(){
        String value1 = "5H 5C 6S 7S KD", value2 = "2C 3S 8S 8D TD";
        //first is a pair of 5, second is a pair of 8, winner is 1;
        PokerHand pokerHand = new PokerHand(value1);
        PokerHand pokerHand2 = new PokerHand(value2);
        Assertions.assertThat(new WinnerFinder().findWinner(pokerHand, pokerHand2)).isEqualTo(1);
    }

    @Test
    public void highestCardTest(){
        String value1 = "5D 8C 9S JS AC", value2 = "2C 5C 7D 8S QH";
        //first is HIGHEST CARD ACE, second is HIGHEST CARD Q, winner is 0;
        PokerHand pokerHand = new PokerHand(value1);
        PokerHand pokerHand2 = new PokerHand(value2);
        Assertions.assertThat(new WinnerFinder().findWinner(pokerHand, pokerHand2)).isEqualTo(0);
    }

    @Test
    public void FlushVsThreeTest(){
        String value1 = "2D 9C AS AH AC", value2 = "3D 6D 7D TD QD";
        //first is HIGHEST CARD ACE, second is HIGHEST CARD Q, winner is 0;
        PokerHand pokerHand = new PokerHand(value1);
        PokerHand pokerHand2 = new PokerHand(value2);
        Assertions.assertThat(new WinnerFinder().findWinner(pokerHand, pokerHand2)).isEqualTo(1);
    }

    @Test
    public void FullhouseVsFullHouse(){
        String value1 = "2H 2D 4C 4D 4S", value2 = "3C 3D 3S 9S 9D";
        //first is HIGHEST CARD ACE, second is HIGHEST CARD Q, winner is 0;
        PokerHand pokerHand = new PokerHand(value1);
        PokerHand pokerHand2 = new PokerHand(value2);
        Assertions.assertThat(new WinnerFinder().findWinner(pokerHand, pokerHand2)).isEqualTo(0);
    }


}