public class IntSearch {
	/**
	 * Returns a Matches object that represents where and how often the query
	 * argument appeared in the values array.
	 *
	 * @param values
	 *            A pre-sorted array of integers, possibly containing
	 *            duplicates.
	 * @param query
	 *            The integer to search for.
	 */
	public static Matches findMatches(int[] values, int query) {
		// try to find an occurrence of query in values
		int lbound = 0; // lower bound of search
		int ubound = values.length - 1; // upper bound of search
		int find_idx = -1; // index value of one occurrence of query
		while (lbound <= ubound) {
			int middle = (lbound + ubound) / 2;
			int entry = values[middle];
			if (entry == query) {
				find_idx = middle;
				break;
			}
			if (entry > query) {
				ubound = middle - 1; // search lower half
			}
			if (entry < query) {
				lbound = middle + 1; // search upper half
			}
		}

		// condition to halt execution if query not found in values
		if (find_idx == -1) {
			return new Matches(-1, 0);
		}

		// find lower index of query duplicates
		int mbound = find_idx; // values[find_idx] == query
		while (lbound <= mbound) {
			// check if lbound is index to first duplicate of query
			int lower = values[lbound];
			if (lower == query) {
				break; // a match means this is the first duplicate
			}
			// no match, continue searching from the middle
			int middle = (lbound + mbound) / 2;
			int entry = values[middle];
			if (entry == query) {
				mbound = middle - 1; // all entries > middle index are duplicates
			} else {
				lbound = middle + 1; // entry < query since the array is sorted
			}
		} // lbound now contains firstMatchIndex

		// find upper index of query duplicats
		mbound = find_idx;
		while (mbound <= ubound) {
			// check if ubound is index to last duplicate of query
			int upper = values[ubound];
			if (upper == query) {
				break; // a match means this is the last duplicate
			}
			// no match, continue searching from the middle
			int middle = (mbound + ubound) / 2;
			int entry = values[middle];
			if (entry == query) {
				mbound = middle + 1; // all entries < middle index are duplicates
			} else {
				ubound = middle - 1; // entry > query since the array is sorted
			}
		} // ubound is the index to the last duplicate

		int count = ubound - lbound + 1; // total number of duplicates
		return new Matches(lbound, count);
	}

	/**
	 * Encapsulates the position of the first match and the number of
	 * occurrences of an integer in an array.
	 */
	public static class Matches {
		private int firstMatchIndex; // -1 if no matches
		private int numberOfMatches; // 0 if no matches

		public Matches(int firstMatchIndex, int numberOfMatches) {
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

	/**
	 * Including a main() function for testing purposes.
	 */
	private static void printHelper(String name, int query, int[] values, int expectFirst, int expectNumber) {
		Matches result = findMatches(values, query);
		System.out.printf("__%s__\n", name);
		System.out.printf("FirstMatchIndex should be %d: %d\n", expectFirst, result.getFirstMatchIndex());
		System.out.printf("NumberOfMatches should be %d: %d\n", expectNumber, result.getNumberOfMatches());
	}

	public static void main(String[] args) {
		int query = 8;
		int[] example = { 0, 1, 2, 3, 4, 4, 5, 6, 7, 8, 8, 8, 9 };
		printHelper("Example", query, example, 9, 3);

		query = 1;
		int[] test1 = { 1 };
		printHelper("test1", query, test1, 0, 1);

		query = 2;
		int[] test2 = { 1 };
		printHelper("test2", query, test2, -1, 0);

		query = 3;
		int[] test3 = { -3, 3, 3 };
		printHelper("test3", query, test3, 1, 2);

		query = 4;
		int[] test4 = { 4, 4, 4, 4, 4, 4, 4, 4, 4, 4 };
		printHelper("test1", query, test4, 0, 10);

		query = 5;
		int[] test5 = { -5, -5, -5, -5, -5, -5, -5 };
		printHelper("test5", query, test5, -1, 0);

		query = 6;
		int[] test6 = { -7, -5, -3, -1, 1, 3, 5, 7 };
		printHelper("test6", query, test6, -1, 0);

		query = 7;
		int[] test7 = { 6, 7, 7, 8, 9, 10 };
		printHelper("test7", query, test7, 1, 2);
	}
}
