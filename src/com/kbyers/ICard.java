/**
 * 
 */
package com.kbyers;

/**
 * @author Ken Byers
 * This interface exists to define the possible attributes of a playing card.
 * Alternative card decks can be defined here without impact to the rest of the code base simply
 * by altering the enumerations defined below
 *
 */
public interface ICard {
	// Standard card deck.  Rank is positional within the enumerations.
	public enum Suit {HEART,SPADE,DIAMOND,CLUB};
	public enum Value {TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE};

}
