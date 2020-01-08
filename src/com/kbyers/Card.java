package com.kbyers;

/**
 * @author Ken Byers This class represents the concept of a playing card. The
 *         methods contained on this class are agnostic to the details of the
 *         deck used, as the card values and suits are contained as enumerations
 *         in the implemented interface.
 * 
 */
public class Card implements ICard {

	private Value rank;
	private Suit suit;

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Card [suit=" + suit + ", val=" + rank + "]";
	}

	public Card() {
		super();

	}

	/**
	 * @param theValue
	 * @param theSuit
	 * 
	 * Create an instance of card with the given value and suit.
	 */
	public Card(Value theValue, Suit theSuit) {
		super();
		rank = theValue;
		suit = theSuit;
	}

	/**
	 * @return the value of this instance of card
	 */
	public Value getRank() {
		return rank;
	}

	/**
	 * @param theRank
	 * set the rank of this instance of card
	 */
	public void setRank(Value theRank) {
		this.rank = theRank;
	}

	/**
	 * @return the suit
	 */
	public Suit getSuit() {
		return suit;
	}

	/**
	 * @param suit
	 * the suit to set
	 */
	public void setSuit(Suit suit) {
		this.suit = suit;
	}

}
