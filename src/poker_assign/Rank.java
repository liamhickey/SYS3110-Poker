package poker_assign;

public enum Rank {
	TWO  (2,  "2"),
	THREE(3,  "3"),
	FOUR (4,  "4"),
	FIVE (5,  "5"),
	SIX  (6,  "6"),
	SEVEN(7,  "7"),
	EIGHT(8,  "8"),
	NINE  (9,  "9"),
	TEN  (10, "10"),
	JACK (11, "J"),
	QUEEN(12, "Q"),
	KING (13, "K"),
	ACE  (14, "A");
	
	public static final int NUM_RANKS = 14;
	
	private int rank;
	private String id;
	
	private Rank(int rank, String id) {
		this.rank = rank;
		this.id = id;
	}

	public int getRank() {
		return rank;
	}
	
	public String toString() {
		return id;
	}
}
