import game.PokerGame
package ui{

  class GameTUI(gameArg: PokerGame) extends GameUI {
    val game: PokerGame = gameArg;

    override def showMainMenu(): Unit = {
      println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n")
      println("Welcome to the poker game(tm)")
      println("(1) Start new game")
      println("(2) Join a network game")
      println("(q) Quit")
    }

    override def showStartGameMenu(): Unit = {
      println("hier komt iets")
    }

    override def showJoinGameMenu(): Unit = {
      println("hier komt ook iets")
    }
  }
}