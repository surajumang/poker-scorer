package orange.poker.RankFinder;

import org.junit.Test;

/**
 * Created 6/24/2019
 *
 * @author sjkumar
 */
public class RankFinderTest {

    @Test
    public void getRank() {
        RankFinder rankFinder = new RankFinder();
        for (Rank rank:rankFinder.getRanks()
             ) {
            System.out.println(rank);
        }
    }
}