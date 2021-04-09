
public class Ladder {
  private int st;
  private int en;

  public Ladder(int start, int end) {
    st = start;
    en = end;
  }

  public boolean checkIfLadderComes (int pPos) {
    return pPos == st;
  }

  public int getLadderEnd() {
    return en;
  }
}