public class Tester {
  public static void main(String[] args) {
    Connect4 boardA = new Connect4();
    System.out.println(boardA);
    boardA.insertChip(0);
    boardA.insertChip(1);
    boardA.insertChip(0);
    boardA.insertChip(1);
    boardA.insertChip(0);
    boardA.insertChip(1);
    boardA.insertChip(0);
    boardA.insertChip(1);
    boardA.insertChip(0);
    boardA.insertChip(1);
    boardA.insertChip(0);
    boardA.insertChip(1);
    boardA.insertChip(0);
    boardA.insertChip(1);
    System.out.println(boardA.insertChip(0));
    System.out.println(boardA);
  }
}
