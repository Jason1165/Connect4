import java.util.*;
public class Connect4 {
  private int[][] board;
  private boolean yourTurn;
  private boolean bot;
  private ArrayList<Integer> moves;

  public Connect4() {
    board = new int[6][7];
    moves = new ArrayList<Integer>();
    yourTurn = true;
    bot = false;
  }

  public Connect4(int height, int width) {
    board = new int[height][width];
    moves = new ArrayList<Integer>();
    yourTurn = true;
    bot = false;
  }

  private void toggleTurn() {
    yourTurn = !yourTurn;
  }

  private void toggleBot() {
    bot = !bot;
  }

  public String toString() {
    String str = "";
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        str += board[i][j];
      }
      str += "\n";
    }
    return str;
  }
}
