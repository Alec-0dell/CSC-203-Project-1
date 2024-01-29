/**
 * A partial 'Node' class. Modify as necessary.
 *
 * @author Vanessa Rivera
 */
class BigNumberNode {
    private int data;
    private BigNumberNode next;
    private BigNumberNode prev;

    public BigNumberNode(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    public BigNumberNode(int data, BigNumberNode next, BigNumberNode prev) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }

    public int getData() {
        return data;
    }

    public BigNumberNode getNext() {
        return next;
    }

    public BigNumberNode getPrev() {
        return prev;
    }

    public void setPrev(BigNumberNode prev) {
        this.prev = prev;
    }

    public void setNext(BigNumberNode next) {
        this.next = next;
    }

}