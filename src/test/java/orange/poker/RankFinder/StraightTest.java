package orange.poker.RankFinder;

import orange.poker.PokerHand;
import org.assertj.core.api.Assertions;
import org.junit.Test;

/**
 * Created 6/24/2019
 *
 * @author sjkumar
 */
public class StraightTest {

    @Test
    public void isApplicableTrue() {
        String value = "8S 9S 10S JS QS";
        PokerHand pokerHand = new PokerHand(value);

        Assertions.assertThat(new Straight().isApplicable(pokerHand)).isTrue();
    }

    @Test
    public void isApplicableTrueFaces() {
        String value = "10C JS QS KD AS";
        PokerHand pokerHand = new PokerHand(value);

        Assertions.assertThat(new Straight().isApplicable(pokerHand)).isTrue();
    }

    @Test
    public void isApplicableFalse() {
        String value = "4S 2S 3S 4S 5S";
        PokerHand pokerHand = new PokerHand(value);

        Assertions.assertThat(new Straight().isApplicable(pokerHand)).isFalse();
    }
}