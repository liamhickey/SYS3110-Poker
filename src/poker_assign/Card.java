package poker_assign;

public class Card {
	private final Suit cardSuit;
	private final Rank cardRank;
	
	public Card(Suit cardSuit, Rank cardRank) {
		super();
		this.cardSuit = cardSuit;
		this.cardRank = cardRank;
	}

	@Override
	public String toString() {
		return "[cardSuit + cardRank]";
	}

	public Suit getSuit() {
		return cardSuit;
	}

	public int getRankVal() {
		return cardRank.getRank();
	}
	
	public Rank getRank() {
		return cardRank;	
	}
}
