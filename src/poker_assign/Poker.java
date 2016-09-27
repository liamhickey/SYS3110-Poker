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
	private static final String NL = System.lineSeparator();
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
		pile = new Stack<>();
		hands = new ArrayList<>();
		shuffleDeck(new ArrayList<Card>(DECK));
	}

	public List<Hand> getHands() {
		return hands;
	}
	
	public void setHands(List<Hand> hands) {
		this.hands = hands;
	}
	
	private boolean validDeckSize() {
		return NUM_PLAYERS * HAND_SIZE < Suit.NUM_SUITS * Rank.NUM_RANKS;
	}
	
	private void shuffleDeck(List<Card> d) {
		List<Card> deck = d;
		Collections.shuffle(deck);
		pile.addAll(deck);
	}
	
	public List<Card> dealHand() {
		ArrayList<Card> hand = new ArrayList<>();
		for (int i = 0; i < HAND_SIZE; i++) {
			hand.add(pile.pop());
		}
		return hand;
	}
	
	public Hand findBestHand() {
		for (Hand h : hands) {
			h.classifyHand();
		}
		Collections.sort(
				hands,
				(o1, o2) -> o1.getHandType().compareTo(o2.getHandType())
				);
		return hands.get(0);
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
		Hand bestHand = p.findBestHand();
		System.out.println(p.toString());
		System.out.println("Best Hand [" + bestHand.toString() + "]");
	}
	
	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		for (Hand h : getHands()) {
			s.append(h + NL);
		}
		return s.toString();
	}

}
