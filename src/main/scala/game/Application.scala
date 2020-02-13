import ui.GameTUI

package game {

  import game.ApplicationState.ApplicationState
  import input.KeyboardProcessor

  class Application {
    val gameUI = new GameTUI(this)
    val keyboardListener = new KeyboardProcessor(this)
    var applicationState:ApplicationState = ApplicationState.MainMenu

    def start(): Unit = {
      gameUI.showMainMenu()
    }

    def startOfflineGame(): Unit = {

    }

  }

  object applicationStarter {
    def main(args: Array[String]): Unit = {
      val application = new Application();
      application.start()
      while (true) {
        // main game loop goes here lol
      }
    }
  }
}