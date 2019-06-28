package orange.poker.RankFinder;

import orange.poker.PokerHand;
import org.assertj.core.api.Assertions;
import org.junit.Test;

/**
 * Created 6/24/2019
 *
 * @author sjkumar
 */
public class RoyalFlushTest {

    @Test
    public void isApplicableTrue() {
        String value = "8S 9S 10S JS QS";
        PokerHand pokerHand = new PokerHand(value);

        Assertions.assertThat(new RoyalFlush().isApplicable(pokerHand)).isFalse();
    }

    @Test
    public void isApplicableFalse() {
        String value = "10C JS QS KD AS";
        PokerHand pokerHand = new PokerHand(value);

        Assertions.assertThat(new RoyalFlush().isApplicable(pokerHand)).isFalse();
    }

    @Test
    public void isApplicableTrue2(){
        String value = "10C JC QC KC AC";
        PokerHand pokerHand = new PokerHand(value);

        Assertions.assertThat(new RoyalFlush().isApplicable(pokerHand)).isTrue();
    }
}