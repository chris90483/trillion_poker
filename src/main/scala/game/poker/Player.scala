package game.poker

class Player(nameArg: String) {
  val name: String = nameArg
  var money: Double = 0.0
  var cards: Array[Card] = Array()
  var bluffingRate: Double = 0.0
}