// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {
    Iterator<Integer> iterator;
    Integer cur = null;
	public PeekingIterator(Iterator<Integer> iterator) {
        this.iterator = iterator;
        if(iterator.hasNext()){
            cur = iterator.next();
        }
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return cur;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    Integer res = cur;
	    cur = iterator.hasNext() ? iterator.next() : null;
	    return res;
	}

	@Override
	public boolean hasNext() {
	    return cur != null;
	}
}