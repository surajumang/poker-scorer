package orange.poker.TieBreaker;

import orange.poker.PokerHand;
import orange.poker.RankFinder.RankFinder;
import org.assertj.core.api.Assertions;
import org.junit.Test;

/**
 * Created 6/24/2019
 *
 * @author sjkumar
 */
public class TieBreakerTest {

    @Test
    public void getWinnerFirst() {
        String value1 = "4S 2S QS 4S 5S", value2 = "4S 2S AS 4S 5S";
        PokerHand pokerHand = new PokerHand(value1);
        PokerHand pokerHand2 = new PokerHand(value2);

        Assertions.assertThat(new TieBreaker().getWinner(pokerHand, pokerHand2, new RankFinder().getRank(pokerHand))).isEqualTo(1);
    }

    @Test
    public void getWinnerSecond() {
        String value1 = "8S 9S TS JS QS", value2 = "2S 3S 4S 5S 6S";
        // first is a STRAIGHT eith , second is a FLUSH with 6. WINNER = 0;
        PokerHand pokerHand = new PokerHand(value1);
        PokerHand pokerHand2 = new PokerHand(value2);

        Assertions.assertThat(new TieBreaker().getWinner(pokerHand, pokerHand2, new RankFinder().getRank(pokerHand))).isEqualTo(0);
    }
}