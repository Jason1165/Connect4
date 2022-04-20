import java.util.*;
public class Connect4 {
  private char[][] board;
  private boolean yourTurn;
  private boolean bot;
  private ArrayList<Integer> moves;

  public Connect4() {
    board = new char[6][7];
    moves = new ArrayList<Integer>();
    yourTurn = true;
    bot = false;
    fill();
  }

  public Connect4(int height, int width) {
    board = new char[height][width];
    moves = new ArrayList<Integer>();
    yourTurn = true;
    bot = false;
    fill();
  }

  private void toggleTurn() {
    yourTurn = !yourTurn;
  }

  private void toggleBot() {
    bot = !bot;
  }

  private void fill() {
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        board[i][j] = '0';
      }
    }
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

  public boolean insertChip(int column) {
    if (column >= board[0].length || column < 0) {
      throw new IllegalArgumentException("Column " + column + " is not a valid column");
    }
    int position = -1;
    for (int i = 0; i < board.length; i++) {
      if (board[i][column] == '0') {
        position = i;
      }
    }
    if (position >= 0) {
      if (yourTurn) {
        board[position][column] = 'R';
      }
      else {
        board[position][column] = 'Y';
      }
      toggleTurn();
      return true;
    }
    return false;
  }

}
