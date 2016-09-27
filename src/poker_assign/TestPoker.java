package poker_assign;

import java.util.*;

public class TestPoker {

	public static void main(String[] args) {
		Card[] highCardCards = {
				new Card(Suit.CLUBS, Rank.TWO),
				new Card(Suit.DIAMONDS, Rank.THREE),
				new Card(Suit.DIAMONDS, Rank.FOUR),
				new Card(Suit.DIAMONDS, Rank.FIVE),
				new Card(Suit.DIAMONDS, Rank.TWO),
				};
		Card[] pairCards = {
				new Card(Suit.CLUBS, Rank.TWO),
				new Card(Suit.DIAMONDS, Rank.THREE),
				new Card(Suit.CLUBS, Rank.THREE),
				new Card(Suit.DIAMONDS, Rank.FOUR),
				new Card(Suit.DIAMONDS, Rank.FIVE),
				};
		Card[] twoPairCards = {
				new Card(Suit.CLUBS, Rank.TWO),
				new Card(Suit.DIAMONDS, Rank.THREE),
				new Card(Suit.CLUBS, Rank.THREE),
				new Card(Suit.DIAMONDS, Rank.FOUR),
				new Card(Suit.CLUBS, Rank.FOUR),
				};
		Card[] threeOfAKindCards = {
				new Card(Suit.CLUBS, Rank.TWO),
				new Card(Suit.DIAMONDS, Rank.THREE),
				new Card(Suit.CLUBS, Rank.THREE),
				new Card(Suit.SPADES, Rank.THREE),
				new Card(Suit.DIAMONDS, Rank.FOUR),
				};
		Card[] straightCards = {
				new Card(Suit.CLUBS, Rank.TWO),
				new Card(Suit.DIAMONDS, Rank.THREE),
				new Card(Suit.DIAMONDS, Rank.FOUR),
				new Card(Suit.DIAMONDS, Rank.FIVE),
				new Card(Suit.DIAMONDS, Rank.SIX),
				};
		Card[] flushCards = {
				new Card(Suit.DIAMONDS, Rank.TWO),
				new Card(Suit.DIAMONDS, Rank.THREE),
				new Card(Suit.DIAMONDS, Rank.FIVE),
				new Card(Suit.DIAMONDS, Rank.SIX),
				new Card(Suit.DIAMONDS, Rank.SEVEN),
				};
		Card[] fullHouseCards = {
				new Card(Suit.CLUBS, Rank.TWO),
				new Card(Suit.DIAMONDS, Rank.TWO),
				new Card(Suit.DIAMONDS, Rank.THREE),
				new Card(Suit.CLUBS, Rank.THREE),
				new Card(Suit.SPADES, Rank.THREE),
				};
		Card[] fourOfAKindCards = {
				new Card(Suit.CLUBS, Rank.TWO),
				new Card(Suit.DIAMONDS, Rank.THREE),
				new Card(Suit.CLUBS, Rank.THREE),
				new Card(Suit.SPADES, Rank.THREE),
				new Card(Suit.HEARTS, Rank.THREE),
				};
		Card[] straightFlushCards = {
				new Card(Suit.DIAMONDS, Rank.TWO),
				new Card(Suit.DIAMONDS, Rank.THREE),
				new Card(Suit.DIAMONDS, Rank.FOUR),
				new Card(Suit.DIAMONDS, Rank.FIVE),
				new Card(Suit.DIAMONDS, Rank.SIX),
				};
		
		List<Card> highCardHand = new ArrayList<>(Arrays.asList(highCardCards));
		List<Card> pairHand = new ArrayList<>(Arrays.asList(pairCards));
		List<Card> twoPairHand = new ArrayList<>(Arrays.asList(twoPairCards));
		List<Card> threeOfAKindHand = new ArrayList<>(Arrays.asList(threeOfAKindCards));
		List<Card> straightHand = new ArrayList<>(Arrays.asList(straightCards));
		List<Card> flushHand = new ArrayList<>(Arrays.asList(flushCards));
		List<Card> fullHouseHand = new ArrayList<>(Arrays.asList(fullHouseCards));
		List<Card> fourOfAKindHand = new ArrayList<>(Arrays.asList(fourOfAKindCards));
		List<Card> straightFlushHand = new ArrayList<>(Arrays.asList(straightFlushCards));
		
		Hand highCard = new Hand(0, highCardHand);
		Hand pair = new Hand(1, pairHand);
		Hand twoPair = new Hand(2, twoPairHand);
		Hand threeOfAKind = new Hand(3, threeOfAKindHand);
		Hand straight = new Hand(4, straightHand);
		Hand flush = new Hand(5, flushHand);
		Hand fullHouse = new Hand(6, fullHouseHand);
		Hand fourOfAKind = new Hand(7, fourOfAKindHand);
		Hand straightFlush = new Hand(8, straightFlushHand);
		
		List<Hand> pairHands = new ArrayList<>();
		pairHands.add(pair);
		pairHands.add(highCard);
		
		List<Hand> twoPairHands = new ArrayList<>();
		pairHands.add(twoPair);
		pairHands.add(highCard);
		
		List<Hand> threeOfAKindHands = new ArrayList<>();
		pairHands.add(threeOfAKind);
		pairHands.add(highCard);
		
		List<Hand> straightHands = new ArrayList<>();
		pairHands.add(straight);
		pairHands.add(highCard);
		
		List<Hand> flushHands = new ArrayList<>();
		pairHands.add(flush);
		pairHands.add(highCard);
		
		List<Hand> fullHouseHands = new ArrayList<>();
		pairHands.add(fullHouse);
		pairHands.add(highCard);
		
		List<Hand> fourOfAKindHands = new ArrayList<>();
		pairHands.add(fourOfAKind);
		pairHands.add(highCard);
		
		List<Hand> straightFlushHands = new ArrayList<>();
		pairHands.add(straightFlush);
		pairHands.add(highCard);
		
		List<Hand> allHands = new ArrayList<>();
		pairHands.add(highCard);
		pairHands.add(pair);
		pairHands.add(twoPair);
		pairHands.add(threeOfAKind);
		pairHands.add(straight);
		pairHands.add(flush);
		pairHands.add(fullHouse);
		pairHands.add(fourOfAKind);
		pairHands.add(straightFlush);
		
		testHands(pairHands);
		testHands(twoPairHands);
		testHands(threeOfAKindHands);
		testHands(straightHands);
		testHands(flushHands);
		testHands(fullHouseHands);
		testHands(fourOfAKindHands);
		testHands(straightFlushHands);
		testHands(allHands);
	}
	
	private static void testHands(List<Hand> hands) {
		Poker p = null;
		try {
			p = new Poker();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		for (Hand h : hands) {
			p.getHands().add(h);
		}
		Hand bestHand = p.findBestHand();
		System.out.println(p.toString());
		System.out.println("Best Hand [" + bestHand.toString() + "]");
		System.out.println();
		p.setHands(new ArrayList<Hand>());
	}

}
