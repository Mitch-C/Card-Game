package cards.core;

import java.io.Serializable;

public class Card implements Comparable<Card>, Serializable {
	
	/**
	 * 
	 */
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4334287131005871592L;
	/**
	 * Represents a card suit.
	 * 
	 * @author David J. Pearce
	 *
	 */
	public enum Suit {
		HEARTS,
		CLUBS,
		DIAMONDS,
		SPADES;
	}
	
	/**
	 * Represents the different card "numbers".
	 * 
	 * @author David J. Pearce
	 *
	 */
	public enum Rank {
		TWO,
		THREE,
		FOUR,
		FIVE,
		SIX,
		SEVEN,
		EIGHT,
		NINE,
		TEN,
		JACK,
		QUEEN,
		KING,
		ACE;
	}
	
	// =======================================================
	// Card stuff
	// =======================================================
	
	private Suit suit; // HEARTS, CLUBS, DIAMONDS, SPADES
	private Rank rank; // 2 <= number <= 14 (ACE)
	
	/**
	 * Construct a card in the given suit, with a given number
	 * 
	 * @param suit
	 *            --- between 0 (HEARTS) and 3 (SPADES)
	 * @param number
	 *            --- between 2 and 14 (ACE)
	 */
	public Card(Suit suit, Rank number) {				
		this.suit = suit;
		this.rank = number;
	}

	/**
	 * Get the suit of this card, between 0 (HEARTS) and 3 (SPADES).
	 * 
	 * @return
	 */
	public Suit suit() {
		return suit;
	}

	/**
	 * Get the number of this card, between 2 and 14 (ACE).
	 * 
	 * @return
	 */
	public Rank rank() {
		return rank;
	}	
	public int value(){
		return suit.ordinal()*100+rank.ordinal(); // found on Internet. Makes it possible to compare values;
	}
		
	private static String[] suits = { "Hearts","Clubs","Diamonds","Spades"};
	private static String[] ranks = { "2 of ", "3 of ", "4 of ",
			"5 of ", "6 of ", "7 of ", "8 of ", "9 of ", "10 of ", "Jack of ",
			"Queen of ", "King of ", "Ace of " };
	
	public String toString() {
		return ranks[rank.ordinal()] + suits[suit.ordinal()];		
	}

	@Override
	public int compareTo(Card o) {
		// TODO: you need to implement this!
		if(this.equals(o)){return 0;}
		if(this.value()>o.value()){return 1;}
		if(this.value()<o.value()){return -1;}		
		return 0;
	}
	@Override
	public boolean equals(Object other){
	       if(this == other){ return true;}
	      
	       if(other == null ){
	           return false;
	       }
	       if( (this.getClass() != other.getClass())){return false;}
	       if(this.rank==((Card) other).rank() && this.suit==((Card) other).suit() ){return true;} // needed to compare suit and rank to pass tests
	       return false;
}
	@Override public int hashCode() { 
		final int prime = 31; 
		int result = 1; 
		result = prime * result + ((rank == null) ? 0 : rank.hashCode());
		//result = prime * result + id;
		result = prime * result + ((suit == null) ? 0 : suit.hashCode()); 
		return result; }


}
