import java.io.*;
import java.util.*;

class Board {
  private ArrayList<Snake> snakes;
  private ArrayList<Ladder> ladders;
  private int startIndex, endIndex;
  public Board (int[][] Snakes, int[][] ladders) {
    startIndex=1;
    endIndex= 100;
    initializeSnake(Snakes);
    initializeLadder(ladders);
  }

  void initializeSnake(int[][] snakes) {
    this.snakes = new ArrayList<Snake>();
    for(int[] pair: snakes) {
      Snake s = new Snake(pair[0], pair[1]);
      this.snakes.add(s);
    }
  };

  void initializeLadder(int[][] ladders) {
    this.ladders = new ArrayList<Ladder>();
    for(int[] pair: ladders) {
      Ladder l = new Ladder(pair[0], pair[1]);
      this.ladders.add(l);
    }
  };

  public int makeMove(int currP, int numSteps) {
    int newPosition = currP + numSteps;

    if (newPosition > 100) return currP;

    int snakeBitePos = getPositionOnSnakeBite(newPosition);
    int ladderClimbingPos = getLadderEndPos(newPosition);

    return snakeBitePos != -1 ? snakeBitePos: (ladderClimbingPos != -1 ? ladderClimbingPos: newPosition);
  }

  private int getPositionOnSnakeBite (int pos) {
    for(Snake s: snakes) {
      if (s.checkIfSnakeBites(pos)) return s.getSnakeTail();
    }

    return -1;
  }

  private int getLadderEndPos (int pos) {
    for(Ladder l: ladders) {
      if (l.checkIfLadderComes(pos)) return l.getLadderEnd();
    }

    return -1;
  }
}