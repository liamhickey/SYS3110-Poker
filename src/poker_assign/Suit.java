package poker_assign;

public enum Suit {
	HEARTS("H"),
	DIAMONDS("D"),
	SPADES("S"),
	CLUBS("C");
	
	public static int NUM_SUITS = 4;
	
	private String id;
	
	private Suit(String id) {
		this.id = id;
	}
	
	public String toString() {
		return id;
	}
}
