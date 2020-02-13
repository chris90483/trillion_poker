import game.Application
package ui{

  class GameTUI(gameArg: Application) extends GameUI {
    val game: Application = gameArg;

    override def showMainMenu(): Unit = {
      println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n")
      println("Welcome to the poker game(tm)")
      println("(1) Start new game")
      println("(2) Join a network game")
      println("(q) Quit")
    }

    override def showStartGameMenu(): Unit = {
      println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n")
      println("(1) Start an offline game")
      println("(2) Host a game")
      println("(q) Quit")
    }

    override def showJoinGameMenu(): Unit = {
      println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n")
      println("hier komt ook iets")
    }
  }
}