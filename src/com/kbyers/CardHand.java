/**
 * 
 */
package com.kbyers;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Ken Byers
 *
 */
public class CardHand {

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CardHand [hand=" + hand + "]";
	}

	private Queue<Card> hand = new LinkedList<Card>();
	
	/**
	 * @param hand
	 */
	public CardHand(Queue<Card> hand) {
		super();
		this.hand = hand;
	}
	

	/**
	 *  
	 */
	public CardHand() {
		
	}


	/**
	 * @param hand the hand to set
	 */
	public void setHand(Queue<Card> hand) {
		this.hand = hand;
	}
	/**
	 * @return the hand
	 */
	public Queue<Card> getHand() {
		return hand;
	}
	/**
	 * @param theCard
	 */
	public void addCard(Card theCard){
		hand.add(theCard);
	}
	
	
	/**
	 * @param theCards
	 */
	public void addCards(List<Card> theCards){
		hand.addAll(theCards);
	}
	/**
	 * @return Card
	 * 
	 * Draws a card from the "Top" of the hand.  Returns null if the hand has no more cards
	 */
	public Card drawCard(){
		return hand.poll();
	}
	
	/**
	 * Reset, or "flip" the hand.  Equivalent of the player picking up collected cards from 
	 * the pile, and continuing play
	 */
	public void flip(){
		
	}
	
	

}
