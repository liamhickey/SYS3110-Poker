package poker_assign;

import java.util.List;

public enum HandType {
	STRAIGHT_FLUSH {
		public boolean isValid(Hand h) {
			if (STRAIGHT.isValid(h) && FLUSH.isValid(h)) {
				return true;
			}
			return false;
		}
	},
	FOUR_OF_A_KIND {
		public boolean isValid(Hand h) {
			if (getInterchangeablePairs(h) == 12) {
				return true;
			}
			return false;
		}
	},
	FULL_HOUSE {
		public boolean isValid(Hand h) {
			if (getInterchangeablePairs(h) == 8) {
				return true;
			}
			return false;
		}
	},
	FLUSH {
		public boolean isValid(Hand h) {
			h.sortBySuit();
			List<Card> cards = h.getCards();
			
			Suit firstCard = cards.get(0).getSuit();
			Suit lastCard = cards.get(
					cards.size() - 1).getSuit();
			if (firstCard.equals(lastCard)) {
				return true;
			}
			return false;
		}
	},
	STRAIGHT {
		public boolean isValid(Hand h) {
			h.sortByRank();
			List<Card> cards = h.getCards();
			
			int firstCard = cards.get(0).getRankVal();
			int lastCard = cards.get(
					cards.size() - 1).getRankVal();
			if ((lastCard - firstCard) == 4 &&
					getInterchangeablePairs(h) == 0) {
				return true;
			}
			return false;
		}
	},
	THREE_OF_A_KIND {
		public boolean isValid(Hand h) {
			if (getInterchangeablePairs(h) == 6) {
				return true;
			}
			return false;
		}
	},
	TWO_PAIR {
		public boolean isValid(Hand h) {
			if (getInterchangeablePairs(h) == 4) {
				return true;
			}
			return false;
		}
	},
	PAIR {
		public boolean isValid(Hand h) {
			if (getInterchangeablePairs(h) == 2) {
				return true;
			}
			return false;
		}
	},
	HIGH_CARD {
		public boolean isValid(Hand h) {
			return true;
		}
	};
	
	public abstract boolean isValid(Hand h);
	
	public static int getInterchangeablePairs(Hand h) {
		List<Card> cards = h.getCards();
		int numPairs = 0;
		for (Card c : cards) {
			for (Card o : cards) {
				if (!c.getSuit().equals(o.getSuit()) &&
						c.getRank().equals(o.getRank())) {
					numPairs++;
				}
			}
		}
		return numPairs;
	}
}
