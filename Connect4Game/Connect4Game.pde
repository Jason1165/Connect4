Connect4 game;
int ROWS;
int COLS;
float circleSize;
int RO;
int CO;

void setup(){
  size(800, 800);
  ROWS = 6;
  COLS = 7;
  RO = 50;
  CO = 100;
  game = new Connect4();
  circleSize = 100;
}

void draw() {
  background(0, 0, 255);
  String [] lines = game.toString().split("\n");
  stringToCircle(lines);
}

void stringToCircle(String[] lines) {
  noStroke();
  for (int i = 0; i < ROWS; i++) {
    for (int j = 0; j < lines[i].length(); j++) {
      char c = lines[i].charAt(j);
      if (c == 'R') {
        fill(255, 0, 0);
        ellipse(j*circleSize + circleSize/2 + RO, i*circleSize + circleSize/2 + CO, 7*circleSize/8, 7*circleSize/8);
      }
      else if (c == 'Y') {
        fill(255, 255, 0);
        ellipse(j*circleSize + circleSize/2 + RO, i*circleSize + circleSize/2 + CO, 7*circleSize/8, 7*circleSize/8);
      }
      else if (c == '0') {
        fill(255, 255, 255);
        ellipse(j*circleSize + circleSize/2 + RO, i*circleSize + circleSize/2 + CO, 7*circleSize/8, 7*circleSize/8);
      }
    }
  }
}
