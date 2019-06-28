package orange.poker.RankFinder;

import orange.poker.PokerHand;
import org.assertj.core.api.Assertions;
import org.junit.Test;

/**
 * Created 6/24/2019
 *
 * @author sjkumar
 */
public class StraightFlushTest {

    @Test
    public void isApplicableTrue() {
        String value = "8S 9S 10S JS QS";
        PokerHand pokerHand = new PokerHand(value);

        Assertions.assertThat(new StraightFlush().isApplicable(pokerHand)).isTrue();
    }

    @Test
    public void isApplicableFalse() {
        String value = "8S 9S 10D JS QS";
        PokerHand pokerHand = new PokerHand(value);

        Assertions.assertThat(new StraightFlush().isApplicable(pokerHand)).isFalse();
    }
}