/**
 * 
 */
package com.kbyers;

import java.util.*;

/**
 * @author Ken Byers
 * This class represents a deck of cards.  The deck of cards is defined by the enumerations 
 * contained in the ICard interface, which CardDeck implements.
 * 
 */

public class CardDeck implements ICard {
	
	private ArrayList<Card> deck;

	/**
	 * Constructor - Creates a valid deck of cards per ICard interface
	 * description
	 */
	public CardDeck() {
		super();
		deck = new ArrayList<Card>();
		for (Suit suit : Suit.values())
			for (Value val : Value.values())
				deck.add(new Card(val, suit));

	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 * 
	 */
	@Override
	public String toString() {
		return "CardDeck [deck=" + deck + "]";
	}

	/**
	 * @return the deck
	 * This method returns the deck of cards represented as a List (non ordered) collection.
	 */
	public List<Card> getDeck() {
		return deck;
	}

	/**
	 * This method uses the java collections method shuffle to "shuffle" the deck of cards, i.e. randomize
	 * the order of the elements in the list collection.
	 */
	public void shuffle() {
		Collections.shuffle(deck);
	}

	
	/**
	 * @return
	 * This method returns the size of the instance of this deck. 
	 */
	public int getSize() {
		return deck.size();
	}

	/**
	 * @param iNumHands
	 * @return
	 * 
	 * Utility class to return an ArrayList of CardHands containing equal distribution of cards from the deck.
	 * I placed this method on the CardDeck class for convenience in manipulation of the collection representing
	 * the deck.
	 */
	public ArrayList<CardHand> dealHands(int iNumHands){
		ArrayList<CardHand> retHands = new ArrayList<CardHand>();
		int iPlayer = 0;
		
		// Create a CardHand for each player
		for (int iHands = 0; iHands < iNumHands; iHands++){
			retHands.add(iHands, new CardHand());
		}
		//Deal out equal number of cards to each player
		for (Iterator<Card> iDeck = deck.iterator(); iDeck.hasNext();){
			
			retHands.get(iPlayer++).addCard(iDeck.next());
			// iDeck.remove();
			if (iPlayer >= iNumHands)
				iPlayer = 0;

		}
		
		return retHands;
		
	}

}
