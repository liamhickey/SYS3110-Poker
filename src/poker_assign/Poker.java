/**
 * 
 */
package poker_assign;

import java.util.*;

/**
 * @author Liam Hickey
 *
 */
public class Poker {
	
	private static final int NUM_PLAYERS = 5;
	private static final int HAND_SIZE = 5;
	private static final Set<Card> DECK;
		static {
			DECK = new HashSet<>();
			for (Suit s : Suit.values()) {
				for (Rank r : Rank.values()) {
					DECK.add(new Card(s, r));
				}
			}
		}
		
	private List<Hand> hands;
	private Stack<Card> pile;
	
	public Poker() throws Exception {
		if (!validDeckSize()) {
			throw new Exception(
					"More cards are required for this game than are available"
					+ " in the deck!"
					);
		}
		shuffleDeck(new ArrayList<Card>(DECK));
	}
	
	private boolean validDeckSize() {
		return NUM_PLAYERS * HAND_SIZE < Suit.NUM_SUITS * Rank.NUM_RANKS;
	}
	
	private void shuffleDeck(List<Card> d) {
		List<Card> deck = d;
		Stack<Card> pile = new Stack<>();
		Collections.shuffle(deck);
		pile.addAll(deck);
	}
	
	private List<Card> dealHand() {
		ArrayList<Card> hand = new ArrayList<>();
		for (int i = 0; i < HAND_SIZE; i++) {
			hand.add(pile.pop());
		}
		return hand;
	}
	
	private Hand findBestHand() {
		for (Hand h : hands) {
			h.classifyHand();
		}
		Collections.sort(
				hands,
				(o1, o2) -> o1.getHandType().compareTo(o2.getHandType())
				);
		return hands.get(hands.size() - 1);
	}

	public static void main(String[] args) {
		Poker p = null;
		try {
			p = new Poker();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		for (int i = 0; i < NUM_PLAYERS; i++) {
			p.hands.add(new Hand(i, p.dealHand()));
		}
		System.out.println(p.toString());
		System.out.println("Best Hand [" + p.findBestHand().toString() + "]");
	}
	
	@Override
	public String toString() {
		return "Poker [hands=" + hands + "]";
	}

}
