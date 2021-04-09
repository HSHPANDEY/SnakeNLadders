


public class Snake {
  private int start;
  private int end;

  public Snake(int st, int end) {
    this.start = st;
    this.end = end;
  }

  public int getSnakeTail() {
    return end;
  }

  public boolean checkIfSnakeBites(int pPos) {
    return pPos == start;
  }
}