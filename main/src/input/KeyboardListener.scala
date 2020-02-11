package input

import java.util.logging.Level
import java.util.logging.LogManager
import java.util.logging.Logger

import org.jnativehook.GlobalScreen
import org.jnativehook.NativeHookException
import org.jnativehook.keyboard.NativeKeyEvent
import org.jnativehook.keyboard.NativeKeyListener

import game.PokerGame
import game.GameState._

class KeyboardListener(gameArg: PokerGame) extends NativeKeyListener {
  val game: PokerGame = gameArg

  try {
    LogManager.getLogManager.reset()
    val logger: Logger = Logger.getLogger(classOf[GlobalScreen].getPackage.getName)
    logger.setLevel(Level.OFF)
    GlobalScreen.registerNativeHook()
  } catch {
    case e: NativeHookException =>
      System.err.println("There was a problem registering the native hook.")
      System.err.println(e.getMessage)
      System.exit(1)
  }

  def nativeKeyPressed(e: NativeKeyEvent) {
    val key = NativeKeyEvent.getKeyText(e.getKeyCode)
    handleInput(key)
  }

  def stop(): Unit = {
    GlobalScreen.unregisterNativeHook()
  }

  def nativeKeyReleased(e: NativeKeyEvent) {}
  def nativeKeyTyped(e: NativeKeyEvent) {}
  GlobalScreen.addNativeKeyListener(this)

  def handleInput(key: String) {
    game.state match {
      case MainMenu => handleInputMainMenu(key)
      case StartMenu => handleInputStartMenu(key)
      case JoinMenu => handleInputJoinMenu(key)
      case _ => ()
    }
  }

  def handleInputMainMenu(key: String): Unit = {
    key match {
      case "q" => stop(); System.exit(0);
      case "1" => game.state = StartMenu; game.gameUI.showStartGameMenu()
      case "2" => game.state = JoinMenu; game.gameUI.showJoinGameMenu()
      case _ => ()
    }
  }

  def handleInputStartMenu(key: String): Unit = {
    key match {
      case "q" => game.state = MainMenu; game.gameUI.showMainMenu()
      case _ => ()
    }
  }

  def handleInputJoinMenu(key: String): Unit = {
    key match {
      case "q" => game.state = MainMenu; game.gameUI.showMainMenu()
      case _ => ()
    }
  }
}