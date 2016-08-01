package cards.util;

import java.awt.List;
import java.util.ArrayList;

import cards.core.Card;
import cards.core.Card.Suit;
import cards.core.Hand;
import cards.core.Player;
import cards.core.Player.Direction;
import cards.core.Trick;

/**
 * Implements a simple computer player who plays the highest card available when
 * the trick can still be won, otherwise discards the lowest card available. In
 * the special case that the player must win the trick (i.e. this is the last
 * card in the trick), then the player conservatively plays the least card
 * needed to win.
 * 
 * @author David J. Pearce
 * 
 */
public class SimpleComputerPlayer extends AbstractComputerPlayer {

	public SimpleComputerPlayer(Player player) {
		super(player);
	}

	@Override
	public Card getNextCard(Trick trick) {		
		// TODO: you need to implement this!
		ArrayList<Card> greaterThan = new ArrayList<Card>();
		ArrayList<Card> lessthan = new ArrayList<Card>();
		Hand hand = player.getHand();
		Suit trumps = trick.getTrumps();
		ArrayList<Card> cardsPlayed = new ArrayList<Card>(trick.getCardsPlayed()); // get list of all cards played 
		Direction nextToPLay = trick.getNextToPlay();
		// if AI can win the trick , then it plays the highest eligible card 
		if(player.getDirection().equals(nextToPLay)){ // is next to play
			for(Card c : hand){
				if(c.suit()==trumps){
					return c; // play highest card
				}
				//if card is greater than last played
				if(c.compareTo(cardsPlayed.get(cardsPlayed.size()-1)) == 1){
				return c;
				}
				//else{return lowest(greaterThan);}
				// play AI card that can beat already played card. NEED TO CHECK THAT IT CANT PLAY A LOWER CARD AND STILL WIN
				return c;
				
				
				
				}
			
			
			//return lowest(greaterThan);
			}
			
		
		return null;
	}	
	/*@param ArrayList<Card>
	 * @return
	 * this method returns the highest value from an array that it is passed 
	 */
	public Card highest(ArrayList<Card> cards){
		Card highest = new Card(null, null);
		for(Card c: cards){
			if(highest == null){
				highest = c;
			}
			else if(c.compareTo(highest)==1){
				highest = c;
			}
		}
		return highest;
	}
	/*@param ArrayList<Card>
	 * @return
	 * this method returns the lowest value from an array that it is passed 
	 */
	public Card lowest (ArrayList<Card> cards){
		Card lowest = new Card(null, null);
		for(Card c: cards){
			if(lowest == null){
				lowest = c;
			}
			else if(c.compareTo(lowest)==-1){
				lowest = c;
			}
		}
		return lowest;
	}
	
}
