package game.poker

class Suit extends Enumeration {
  val Diamonds, Hearts, Spades, Clubs = Value
}

class Rank extends Enumeration {
  val Ace, Two, Three, Four, Five, Six, Seven, Eight, Nine, Ten, Jack, Queen, King = Value
}

case class Card(suitArg: Suit, rankArg: Rank) {
  val suit: Suit = suitArg
  val rank: Rank = rankArg
}