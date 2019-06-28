package orange.poker.RankFinder;

import orange.poker.PokerHand;
import org.assertj.core.api.Assertions;
import org.junit.Test;

/**
 * Created 6/24/2019
 *
 * @author sjkumar
 */
public class NofAKindTest {

    @Test
    public void isApplicableTwoTrue() {
        String value = "QS 2S 3S QS 2S";
        PokerHand pokerHand = new PokerHand(value);

        Assertions.assertThat(new NofAKind.Pair().isApplicable(pokerHand)).isTrue();
        Assertions.assertThat(new NofAKind.Pair().getScore(pokerHand)).isEqualTo(PokerHand.Card.Value.QUEEN.getActualValue());
    }

    @Test
    public void isApplicableTwoFalse() {
        String value = "AS 2S 3S 4S 5S";
        PokerHand pokerHand = new PokerHand(value);

        Assertions.assertThat(new NofAKind.Pair().isApplicable(pokerHand)).isFalse();
    }

    @Test
    public void isApplicableThreeTrue() {
        String value = "AS 2S AS AS 5S";
        PokerHand pokerHand = new PokerHand(value);

        Assertions.assertThat(new NofAKind.ThreeOfAKind().isApplicable(pokerHand)).isTrue();
        Assertions.assertThat(new NofAKind.ThreeOfAKind().getScore(pokerHand))
                .isEqualTo(PokerHand.Card.Value.ACE.getActualValue());
    }

    @Test
    public void isApplicableThreeFalse() {
        String value = "AS 2S AS QS 5S";
        PokerHand pokerHand = new PokerHand(value);

        Assertions.assertThat(new NofAKind.ThreeOfAKind().isApplicable(pokerHand)).isFalse();
    }

    @Test
    public void isApplicableFourTrue() {
        String value = "AS JS JS JS JS";
        PokerHand pokerHand = new PokerHand(value);

        Assertions.assertThat(new NofAKind.FourOfAKind().isApplicable(pokerHand)).isTrue();
        Assertions.assertThat(new NofAKind.FourOfAKind().getScore(pokerHand))
                .isEqualTo(PokerHand.Card.Value.JACK.getActualValue());
    }

    @Test
    public void isApplicableFourFalse() {
        String value = "AS 2S AS AS 5S";
        PokerHand pokerHand = new PokerHand(value);

        Assertions.assertThat(new NofAKind.FourOfAKind().isApplicable(pokerHand)).isFalse();
    }
}