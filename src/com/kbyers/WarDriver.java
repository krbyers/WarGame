package com.kbyers;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ken Byers Implementation of the War game logic. See the link below
 *         for description of the logic used to design this class. {@link http
 *         ://en.wikipedia.org/wiki/War_(card_game)}
 * 
 *         This class uses recursion to simplify multi-match war scenarios, i.e.
 *         where two players present cards of equal rank, a simple cache
 *         (ArrayList) is created to retain three cards from each contending
 *         player, then a recursive call is made to re-draw cards. This
 *         continues to recurse, finally returning to the top caller with the
 *         winning player of the war.
 * 
 */
public class WarDriver {

	ArrayList<CardHand> players;
	CardDeck deck;

	/**
	 * @param iNumberofPlayers
	 */
	public void play(int iNumberofPlayers) {
		ArrayList<CardHand> playerHands;
		// Set up a deck of cards
		deck = new CardDeck();
		deck.shuffle();

		// Set up each player
		playerHands = deck.dealHands(iNumberofPlayers);

		for (int i = 0; i < iNumberofPlayers; i++) {
			System.out.println(playerHands.get(i));
		}

		// Begin the war....
		int iHandCount = 0;
		while (warHand(playerHands) != -1) {
			iHandCount++;
		}
		System.out.println("Total hands played: " + iHandCount);

	}

	/**
	 * @param playerHands
	 * @return
	 * 
	 *         This method draws a card for each player in the player hands
	 *         collection, and compares the rank. The player with the highest
	 *         ranked card is marked as winner, and the other players cards are
	 *         inserted into the hand of the winner.
	 * 
	 */
	private int warHand(List<CardHand> playerHands) {
		ArrayList<Card> playerDraws = new ArrayList<Card>();
		int iWinnerIdx = 0;
		// Draw the cards for each player
		for (int i = 0; i < playerHands.size(); i++) {
			Card theCard = playerHands.get(i).drawCard();
			if (theCard != null) {
				playerDraws.add(theCard);
			} else {
				System.out.println("Player " + i + " has run out of cards!");
				return -1; // indicate the game is complete due to player being
							// out of cards.
			}

		}
		for (iWinnerIdx = 0; iWinnerIdx < playerDraws.size(); iWinnerIdx++) {
			if (iWinnerIdx != 0) {

				// compare to previous players card
				// Current card greater to previous
				System.out.println("Compare "
						+ playerDraws.get(iWinnerIdx - 1).getRank() + " to "
						+ playerDraws.get(iWinnerIdx).getRank());
		
				// TODO: Additional logic here to account for more than two players
				int iCompareResult = playerDraws.get(iWinnerIdx).getRank().compareTo(
						playerDraws.get(iWinnerIdx - 1).getRank());

				if (iCompareResult == 0) {
					// Equal - this means war!
					System.out.println("WAR!!!!");

					ArrayList<Card> warPile = new ArrayList<Card>();
					// Draw three cards from each player, and place into warPile
					for (int iPlayer = 0; iPlayer < playerHands.size(); iPlayer++) {
						// move the two cards that match to the war pile....
						warPile.add(playerDraws.get(iPlayer));
						// Draw three additional cards from each players hand
						for (int j = 0; j < 3; j++) {
							Card c = playerHands.get(iPlayer).drawCard();
							if (c != null)
								warPile.add(c);
							else {
								System.out.println("\nPlayer " + iPlayer
										+ " has run out of cards!");
								return -1;
							}
						}

					}

					// ---------------------------------------------------
					// recursive call to play the hand....
					// ---------------------------------------------------
					iWinnerIdx = warHand(playerHands);
					if (iWinnerIdx == -1) {
						return -1;
					}
					playerHands.get(iWinnerIdx).addCards(warPile);
					return iWinnerIdx;

				} else if (iCompareResult > 0) {
					
					System.out.println("Player " + iWinnerIdx + " wins hand.");
					// Now, collect the cards from the looser and insert the
					// into the winners CardHand. The cards in play
					// were already removed from the hand of the looser prior to
					// the above test via the drawCard method on
					// the CardHand class.
					playerHands.get(iWinnerIdx).addCards(playerDraws);
					return iWinnerIdx;
				} else {
					System.out.println("Player " + (iWinnerIdx - 1) + " wins hand.");
					// Now, collect the cards from the looser and insert the
					// into the winners CardHand. The cards in play
					// were already removed from the hand of the looser prior to
					// the above test via the drawCard method on
					// the CardHand class.
					playerHands.get(iWinnerIdx - 1).addCards(playerDraws);
					return iWinnerIdx - 1;
				}

			} else {
				// Skip first player - can't compare without at least two players.
				iWinnerIdx = 0;
			}
		}

		return iWinnerIdx;

	}

	/**
	 *  
	 */
	public static void printUsage() {
		System.out.println("Useage:  " + WarDriver.class.getName()
				+ " <number of matches>");
	}

	/**
	 * @param args
	 */
	public static void main(String args[]) {
		int iNumPlayers = 2;
		int iNumMatches = 1;

		try {
			if (args[0] != null) {
				iNumPlayers = Integer.parseInt(args[0]);
			} 
			
			if (args[1] != null) {
				iNumMatches = Integer.parseInt(args[0]);
			} 
			
		} catch (Exception e) {
			printUsage();
			return;
		}

		WarDriver warGame = new WarDriver();

		// Execute iNumMatches
		if (iNumMatches > 0) {
			for (int i = 0; i < iNumMatches; i++) {
				System.out.println("************ Beginning match #" + i);
				
				// Note:  
				warGame.play(iNumPlayers);
			}

		} else {
			printUsage();
			return;
		}

	}

}
