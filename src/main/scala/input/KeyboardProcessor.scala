package input

import java.util.logging.Level
import java.util.logging.LogManager
import java.util.logging.Logger

import org.jnativehook.GlobalScreen
import org.jnativehook.NativeHookException
import org.jnativehook.keyboard.NativeKeyEvent
import org.jnativehook.keyboard.NativeKeyListener

import game.Application
import game.ApplicationState._

class KeyboardProcessor(gameArg: Application) extends NativeKeyListener {
  val application: Application = gameArg
  val debug: Boolean = false

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
    if (debug) println(key)
    handleInput(key)
  }

  def stop(): Unit = {
    GlobalScreen.unregisterNativeHook()
  }

  def nativeKeyReleased(e: NativeKeyEvent) {}
  def nativeKeyTyped(e: NativeKeyEvent) {}
  GlobalScreen.addNativeKeyListener(this)

  def handleInput(key: String) {
    if (debug) println("current game.state: %s".format(application.applicationState))
    application.applicationState match {
      case MainMenu => handleInputMainMenu(key)
      case StartMenu => handleInputStartMenu(key)
      case JoinMenu => handleInputJoinMenu(key)
      case _ => ()
    }
  }

  def handleInputMainMenu(key: String): Unit = {
    key match {
      case "Q" => stop(); System.exit(0);
      case "1" => application.applicationState = StartMenu; application.gameUI.showStartGameMenu()
      case "2" => application.applicationState = JoinMenu; application.gameUI.showJoinGameMenu()
      case _ => ()
    }
  }

  def handleInputStartMenu(key: String): Unit = {
    key match {
      case "1" => application.applicationState = InGame; application.startOfflineGame();
      case "2" => println("[KeyboardProcessor] dat heb ik nog niet geschreven, jammer joh")
      case "Q" => application.applicationState = MainMenu; application.gameUI.showMainMenu()
      case _ => ()
    }
  }

  def handleInputJoinMenu(key: String): Unit = {
    key match {
      case "Q" => application.applicationState = MainMenu; application.gameUI.showMainMenu()
      case _ => ()
    }
  }
}