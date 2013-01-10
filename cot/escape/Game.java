package cot.escape;

import java.awt.event.KeyEvent;
import cot.escape.menu.*;

public class Game {

  public Menu menu;
  public Game() {
    System.out.println("In Game - Before new TitleMenu()");
    setMenu(new TitleMenu());
    System.out.println("In Game - After new TitleMenu()");
  }
  
  public static void main(String[] args) {
    System.out.println("In Main - Before new Game()");
    Game g = new Game();
    System.out.println("In Main - After new Game()");
  }
  
  public void setMenu(Menu menu) {
    this.menu = menu;
  }
}
