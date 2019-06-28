package orange.poker.RankFinder;

import orange.poker.PokerHand;
import org.assertj.core.api.Assertions;
import org.junit.Test;

/**
 * Created 6/24/2019
 *
 * @author sjkumar
 */
public class FullHouseTest {

    @Test
    public void isApplicableTrue() {
        String value = "4D 4S 3S 4S 3H";
        PokerHand pokerHand = new PokerHand(value);

        Assertions.assertThat(new FullHouse().isApplicable(pokerHand)).isTrue();
    }

    @Test
    public void isApplicableFalse() {
        String value = "4D 2S 3S 4S 3H";
        PokerHand pokerHand = new PokerHand(value);

        Assertions.assertThat(new FullHouse().isApplicable(pokerHand)).isFalse();
    }
}