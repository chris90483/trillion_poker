import ui.GameTUI

package game {

  import game.GameState.GameState
  import input.KeyboardListener

  class PokerGame {
    val gameUI = new GameTUI(this)
    val keyboardListener = new KeyboardListener(this)
    var state:GameState = GameState.MainMenu

    def start(): Unit = {
      gameUI.showMainMenu()
    }
  }

  object applicationStarter {
    def main(args: Array[String]): Unit = {
      val pokerGame = new PokerGame();
      pokerGame.start()
      while (true) {}
    }
  }
}