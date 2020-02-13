package game

object ApplicationState extends Enumeration {
  type ApplicationState = Value
  val MainMenu, StartMenu, JoinMenu, InGame = Value
}
