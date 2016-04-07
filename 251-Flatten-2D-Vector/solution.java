public class Vector2D {
	private int pointer;
	private int row;
	private List<List<Integer>> vec2d;

	public Vector2D(List<List<Integer>> vec2d) {
		row = 0;
		pointer = 0;
		this.vec2d = vec2d;
	}

	public int next() {
		return vec2d.get(row).get(pointer++);
	}

	public boolean hasNext() {
		while(row < vec2d.size()){
		    if(pointer < vec2d.get(row).size()){
		        return true;
		    }
		    row++;
		    pointer = 0;
		}
		return false;
	}
}
