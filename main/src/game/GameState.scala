package game

object GameState extends Enumeration {
  type GameState = Value
  val MainMenu, StartMenu, JoinMenu, InGame = Value
}
