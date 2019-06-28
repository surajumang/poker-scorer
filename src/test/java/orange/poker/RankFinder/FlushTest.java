package orange.poker.RankFinder;

import orange.poker.PokerHand;
import org.assertj.core.api.Assertions;
import org.junit.Test;

/**
 * Created 6/24/2019
 *
 * @author sjkumar
 */
public class FlushTest {

    @Test
    public void isApplicableTrue() {
        String value = "4S 2S 3S 4S 5S";
        PokerHand pokerHand = new PokerHand(value);

        Assertions.assertThat(new Flush().isApplicable(pokerHand)).isTrue();
    }

    @Test
    public void isApplicableFalse() {
        String value = "4S 2S 3S 4S 5D";
        PokerHand pokerHand = new PokerHand(value);

        Assertions.assertThat(new Flush().isApplicable(pokerHand)).isFalse();
    }
}