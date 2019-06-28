package orange.poker.RankFinder;

import orange.poker.PokerHand;
import org.assertj.core.api.Assertions;
import org.junit.Test;

/**
 * Created 6/24/2019
 *
 * @author sjkumar
 */
public class TwoPairsTest {

    @Test
    public void isApplicableTrue() {
        String value = "4S 2S 3S 4S 2S";
        PokerHand pokerHand = new PokerHand(value);

        Assertions.assertThat(new TwoPairs().isApplicable(pokerHand)).isTrue();
    }

    @Test
    public void isApplicableFalse() {
        String value = "4S 4S 3S 4S 3S";
        PokerHand pokerHand = new PokerHand(value);

        Assertions.assertThat(new TwoPairs().isApplicable(pokerHand)).isTrue();
    }

    @Test
    public void isApplicableFalse2() {
        String value = "4S 2S 3S 4S 5S";
        PokerHand pokerHand = new PokerHand(value);

        Assertions.assertThat(new TwoPairs().isApplicable(pokerHand)).isFalse();
    }
}