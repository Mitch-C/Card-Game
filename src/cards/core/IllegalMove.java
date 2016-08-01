package cards.core;

import java.io.Serializable;

/**
 * Use to signal an illegal move has occurred. This typically happens when a
 * human play attempts to play out of turn and/or with a card that doesn't
 * follow suit, etc.
 * 
 * @author David J. Pearce
 * 
 */
public class IllegalMove extends Exception implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6548044383735609648L;

	public IllegalMove(String e) {
		super(e);
	}
}
