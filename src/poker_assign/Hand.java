package poker_assign;

import java.util.*;

public class Hand {

	private final int id;
	
	private List<Card> cards;
	private HandType handType;
	
	public Hand(int id, List<Card> cards) {
		this.id = id;
		this.cards = cards;
	}

	public int getId() {
		return id;
	}
	
	public List<Card> getCards() {
		return cards;
	}
	
	public HandType getHandType() {
		return handType;
	}

	public Card getHighCard() {
		sortByRank();
		return cards.get(cards.size() - 1);
	}

	public void sortByRank() {
		cards.sort((o1, o2) -> o1.getRankVal() - o2.getRankVal());
	}
	
	public void sortBySuit() {
		Collections.sort(
				cards,
				(o1, o2) -> o1.getSuit().compareTo(o2.getSuit())
				);
	}
	
	public void classifyHand() {
		for (HandType ht : HandType.values()) {
			if (ht.isValid(this)) {
				handType = ht;
				return;
			}
		}
	}

	@Override
	public String toString() {
		return "Hand [id=" + id + ", handType=" + handType + ", cards=" + cards + "]";
	}
	
}
