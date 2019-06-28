/*
 * Copyright 2006-2019 (c) Care.com, Inc.
 * 1400 Main Street, Waltham, MA, 02451, U.S.A.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Care.com, Inc. ("Confidential Information").  You shall not disclose
 * such Confidential Information and shall use it only in accordance with
 * the terms of an agreement between you and CZen.
 */
package orange.poker;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Created 6/24/2019
 *
 * @author sjkumar
 */
public class MainController {
    /*
    * Starting point for the score calculator.
    * It's responsibility would be the following.
    * 1) For each entry in the scores file, do the following. #easy, reading a file.
    * 2) Compute the Winner, Player 1 or Player 2,  #many combinations and tie breaker logic.
    * 3) Maintain a Register to count the number of wins of each player. # easy.
    * */

    /*
In the card game poker, a hand consists of five cards and are ranked, from lowest to highest, in the following way:
    1 High Card: Highest value card.
    2 One Pair: Two cards of the same value.
    3 Two Pairs: Two different pairs.
    4 Three of a Kind: Three cards of the same value.
    5 Straight: All cards are consecutive values.
    6 Flush: All cards of the same suit.
    7 Full House: Three of a kind and a pair.
    8 Four of a Kind: Four cards of the same value.
    9 Straight Flush: All cards are consecutive values of same suit.
   10 Royal Flush: Ten, Jack, Queen, King, Ace, in same suit.

    The cards are valued in the order:
    2, 3, 4, 5, 6, 7, 8, 9, 10, Jack, Queen, King, Ace.

    Check for the occurrence of each of the Above ways, for each Player, break the ties if required and tell the winner
    */


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("D:\\Documents\\Documents\\projecteuler\\src\\main\\java\\orange\\poker\\poker.txt"));
        int winsForOne = 0;
        String line = br.readLine();
        WinnerFinder winnerFinder = new WinnerFinder();
        int lineNumber = 1;
        while (line != null){
//            System.out.println(lineNumber++);
            String first = line.substring(0, 14);
            String second = line.substring(15);
            if (winnerFinder.findWinner(new PokerHand(first), new PokerHand(second)) == 0){
                winsForOne++;
            }
            line = br.readLine();
        }
        System.out.println(winsForOne);
    }
}
