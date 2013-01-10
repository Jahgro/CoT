package cot.escape;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class CoTApplication extends Canvas implements Runnable {

  private static final int WIDTH = 160;
  private static final int HEIGHT = 120;
  private static final int SCALE = 4;

  private boolean running;
  private Thread thread;

  private Game game;
  //private Screen screen;
  //private BufferedImage img;
  private int[] pixels;
  //private InputHandler inputHandler;
  //private Cursor emptyCursor, defaultCursor;
  private boolean hadFocus = false;
  
  
  public CoTApplication() {
    Dimension size = new Dimension(WIDTH * SCALE, HEIGHT * SCALE);
    setSize(size);
    setPreferredSize(size);
    setMinimumSize(size);
    setMaximumSize(size);

    game = new Game();
    screen = new Screen(WIDTH, HEIGHT);

    img = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
    pixels = ((DataBufferInt) img.getRaster().getDataBuffer()).getData();

    inputHandler = new InputHandler();

    addKeyListener(inputHandler);
    addFocusListener(inputHandler);
    addMouseListener(inputHandler);
    addMouseMotionListener(inputHandler);
    emptyCursor = Toolkit.getDefaultToolkit().createCustomCursor(new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB), new Point(0, 0), "empty");
    defaultCursor = getCursor();
  }

  public static void main(String[] args) {
    CoTApplication game = new CoTApplication();

    JFrame frame = new JFrame("Prelude of the Chambered!");

    JPanel panel = new JPanel(new BorderLayout());
    panel.add(game, BorderLayout.CENTER);

    frame.setContentPane(panel);
    frame.pack();
    frame.setLocationRelativeTo(null);
    frame.setResizable(false);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);

    game.start();
  }

  @Override
  public void run() {
    // TODO Auto-generated method stub
  }
}
