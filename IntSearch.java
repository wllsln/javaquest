public class IntSearch {
  /**
   * Returns a Matches object that represents where and how often the query
   * argument appeared in the values array.
   *
   * @param values A pre-sorted array of integers, possibly containing
   *               duplicates.
   * @param query  The integer to search for.
   */
  public static Matches findMatches(int[] values, int query) {
    return new Matches(-1, 0);
  }

  /**
   *Encapsulates the position of the first match and the number of
   * occurrences of an integer in an array.
   */
  public static class Matches {
    private int firstMatchIndex;
    private int numberOfMatches;

   ￼public Matches(int firstMatchIndex, int numberOfMatches) {
      this.firstMatchIndex = firstMatchIndex;
      this.numberOfMatches = numberOfMatches;
    }

    public int getFirstMatchIndex() {
      return this.firstMatchIndex;
    }

    public int getNumberOfMatches() {
      return this.numberOfMatches;
    }
  }
}
