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
      for (int j = 0; j < board[i].length; j++) {
        board[i][j] = '0';
      }
    }
  }

  public String toString() {
    String str = "";
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        str += board[i][j];
      }
      str += "\n";
    }
    return str;
  }

  public boolean insertChip(int column) {
    if (column >= board[0].length || column < 0) {
      return false;
      // throw new IllegalArgumentException("Column " + column + " is not a valid column");
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

  public boolean someoneWon(char c) {
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        if (board[i][j] == c) {
          boolean up = someoneWon(i, j, -1, 0, 4, 0);
          boolean right = someoneWon(i, j, 0, 1, 4, 0);
          boolean diagL = someoneWon(i, j, -1, -1, 4, 0);
          boolean diagR = someoneWon(i, j, -1, 1, 4, 0);
          if (up || right || diagL || diagR) {
            return true;
          }
        }
      }
    }
    return false;
  }

  private boolean someoneWon(int x, int y, int xInc, int yInc, int num, int space) {
    if (x + xInc*num >= board.length || x + xInc*num < 0 || y + yInc*num >= board[x].length || y + yInc*num < 0) {
      return false;
    }
    for (int i = 0; i < num + space; i++) {
      if (i > num) {
        if (board[x + xInc*i][y + yInc*i] != '0') {
          return false;
        }
      }
      else {
        if (!(board[x][y] == board[x + xInc*i][y + yInc*i])) {
          return false;
        }
      }
    }
    return true;
  }

  public int boardScore(char c) {
    int score = 0;
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if (board[i][j] == c) {
          if (someoneWon(i, j, -1, 0, 4, 0)) score += 100;
          else if (someoneWon(i, j, 0, 1, 4, 0)) score += 100;
          else if (someoneWon(i, j, -1, -1, 4, 0)) score += 100;
          else if (someoneWon(i, j, -1, 1, 4, 0)) score += 100;
        }
      }
    }
    return score;
  }

}
