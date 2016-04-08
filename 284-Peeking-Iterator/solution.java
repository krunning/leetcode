// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {
    Iterator<Integer> iterator;
    int cur;
    boolean isLast = false;
	public PeekingIterator(Iterator<Integer> iterator) {
        this.iterator = iterator;
        if(iterator.hasNext()){
            cur = iterator.next();
        }else{
            isLast = true;
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
	    if(!isLast){
	        int tmp = cur;
	        cur = iterator.next();
	        return tmp;
	    }else{
	        return cur;
	    }
	}

	@Override
	public boolean hasNext() {
	    if(!iterator.hasNext() && isLast){
	        return false;
	    }
	    if(!iterator.hasNext()){
	        isLast = true;
	    }
	    return true;
	}
}