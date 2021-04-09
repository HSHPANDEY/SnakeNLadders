import java.util.*;

public class Game implements DiceService {
  Player[] players;
  Board board;
  int currPlayer;
  int winnerId;
  HashMap<Integer, Integer> playerPos;
  public Game (String players[], int[][] snakes, int [][] ladders) {
    currPlayer = 0;
    winnerId= -1;
    initialisePlayer(players);
    board = new Board(snakes, ladders);
  }

  void initialisePlayer (String player[]) {
    playerPos = new HashMap<>();
    for(int i=0; i<player.length; i++) {
      Player pl = new Player(player[i], i);
      players[i] = pl;
      playerPos.put(i, 1);
    }
  }

  int getNextPlayer() {
    return (currPlayer+1)%players.length;
  }

  void startGame() {
    boolean isGameOver = true;
    while(!isGameOver) {
      int nextPosition = rollADice();
      int currPlayerPos = (int) playerPos.get(currPlayer);
      int newPos = board.makeMove(currPlayerPos, nextPosition);
      if (newPos == 100) {
        isGameOver = true;
        winnerId = currPlayer;
      }
      currPlayer = getNextPlayer();
    }
    
    System.out.println("Winner is " + players[winnerId]);
  }

  public int rollADice() {
    int roll = (int) (Math.floor(Math.random() * 6) + 1);
    return roll;
  };
}