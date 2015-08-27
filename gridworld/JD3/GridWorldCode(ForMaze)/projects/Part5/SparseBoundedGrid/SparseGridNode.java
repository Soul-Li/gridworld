public class SparseGridNode {
        //store the object
	private Object occupant;
	private int col;
        //point to the next SparseGridNode
	private SparseGridNode next;
        //construct a new SparseGridNode
	public SparseGridNode(Object occ, int column, SparseGridNode n) {
		occupant = occ;
		col = column;
		next = n;
	}

	public Object getOccupant() {
		return occupant;
	}

	public int getColumn() {
		return col;
	}

	public SparseGridNode getNext() {
		return next;
	}

	public void setOccupant(Object obj) {
		occupant = obj;
	}

	public void setNext(SparseGridNode n) {
		next = n;
	}
}
