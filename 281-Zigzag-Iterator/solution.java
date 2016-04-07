public class ZigzagIterator {
    Deque<Iterator<Integer>> iterators;

	public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
		iterators = new LinkedList<Iterator<Integer>>();
		if (!v1.isEmpty()) {
			iterators.addLast(v1.iterator());
		}
		if (!v2.isEmpty()) {
			iterators.addLast(v2.iterator());
		}
	}

	public int next() {
		Iterator<Integer> i = iterators.removeFirst();
		int res = i.next();
		if (i.hasNext()) {
			iterators.addLast(i);
		}
		return res;
	}

	public boolean hasNext() {
		return !iterators.isEmpty();
	}
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */