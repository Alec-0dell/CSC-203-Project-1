import java.util.ArrayList;
import java.util.List;

/**
 * A partial linked list class. Modify as necessary.
 *
 * @author Vanessa Rivera
 */
public class BigNumber {

    private BigNumberNode head;
    private BigNumberNode tail;

    public BigNumber() {
        this.head = null;
    }

    // TODO: Write addition, multiplication, and exponentiation methods here or in
    // another class

    public BigNumber addition(BigNumber addened) {
        String output = recAddition(this.tail, addened.tail, 0);
        return fromString(output);
    }

    private String recAddition(BigNumberNode addened1, BigNumberNode addened2, int carry) {
        int numToAdd = 0;
        if (!(addened1 == null && addened2 == null)) {
            if (addened1 == null) {
                numToAdd = addened2.getData() + carry;
            } else if (addened2 == null) {
                numToAdd = addened1.getData() + carry;
            } else {
                numToAdd = addened1.getData() + addened2.getData() + carry;
            }
        } else {
            if (carry == 0) {
                return "";
            } else {
                return "1";
            }
        }
        int nextCarry = 0;
        String curData = String.valueOf(numToAdd);
        if (numToAdd >= 10) {
            nextCarry = 1;
            curData = String.valueOf(numToAdd - 10);
        }
        return this.recAddition((addened1 == null ? null : addened1.getPrev()),
                (addened2 == null ? null : addened2.getPrev()), nextCarry) + curData;
    }

    public BigNumber multiplication(BigNumber multiplicand) {
        BigNumberNode curNode = multiplicand.tail;
        int i = 0;
        List<BigNumber> lst = new ArrayList<BigNumber>();
        while (curNode != null) {
            lst.add(multiplyDigit(curNode.getData(), i));
            i++;
            curNode = curNode.getPrev();
        }
        BigNumber sum = lst.get(0);
        for (int j = 1; j < lst.size(); j++) {
            sum = sum.addition(lst.get(j));
        }
        return sum;
    }

    public BigNumber multiplyDigit(int multiplicand, int multiplier) {
        BigNumber output = new BigNumber();
        if (this.head == null || this.tail == null) {
            return null;
        }
        BigNumberNode curMultNode = this.tail;
        int carry;
        if (multiplier <= 0) {
            output.tail = new BigNumberNode((this.tail.getData() * multiplicand) % 10);
            curMultNode = curMultNode.getPrev();
            carry = (this.tail.getData() * multiplicand) / 10;
            output.head = output.tail;
        } else {
            output.tail = new BigNumberNode(0);
            multiplier -= 1;
            carry = 0;
            output.head = output.tail;
        }
        BigNumberNode curOutNode = output.tail;
        while (multiplier > 0) {
            curOutNode.setPrev(new BigNumberNode(0, curOutNode, null));
            curOutNode = curOutNode.getPrev();
            multiplier -= 1;
            output.head = curOutNode.getPrev();
        }
        while (curMultNode != null) {
            int curNum = (curMultNode.getData() * multiplicand) + carry;
            carry = curNum / 10;
            BigNumberNode newNode = new BigNumberNode(curNum % 10, curOutNode, null);
            curOutNode.setPrev(newNode);
            curMultNode = curMultNode.getPrev();
            curOutNode = curOutNode.getPrev();
            output.head = newNode;
        }
        if (carry != 0) {
            BigNumberNode newNode = new BigNumberNode(carry, curOutNode, null);
            curOutNode.setPrev(newNode);
            output.head = newNode;
        }
        return output;
    }

    public BigNumber exponentiation(int pow) {
        if (pow == 0) {
            BigNumber out = new BigNumber();
            BigNumberNode zero = new BigNumberNode(1);
            out.head = zero;
            out.tail = zero;
            return out;
        }
        if (pow == 1) {
            return this;
        } else if (pow == 2) {
            return this.multiplication(this);
        } else if (pow % 2 == 0) {
            BigNumber square = this.multiplication(this);
            return square.exponentiation(pow / 2);
        } else {
            BigNumber square = this.multiplication(this);
            return this.multiplication(square.exponentiation((pow - 1) / 2));
        }
    }

    public static BigNumber fromString(String string) {
        if (string.length() == 0) {
            return null;
        }
        BigNumber output = new BigNumber();
        BigNumberNode curNode = new BigNumberNode((int) string.charAt(string.length() - 1) - 48);
        output.tail = curNode;
        for (int i = (string.length() - 2); i >= 0; i--) {
            curNode.setPrev(new BigNumberNode((int) string.charAt(i) - 48));
            BigNumberNode nextNode = curNode;
            curNode = curNode.getPrev();
            curNode.setNext(nextNode);
        }
        output.head = curNode;
        return output;
    }

    @Override
    public String toString() {
        // return recToStringPrev(tail);
        return recToStringNext(head);
    }

    private String recToStringPrev(BigNumberNode node) {
        if (node == null) {
            return "";
        } else {
            String nextDigit = String.valueOf(node.getData());
            return recToStringPrev(node.getPrev()) + nextDigit;
        }

    }

    private String recToStringNext(BigNumberNode node) {
        if (node == null) {
            return "";
        } else {
            String nextDigit = String.valueOf(node.getData());
            return nextDigit + this.recToStringNext(node.getNext());
        }

    }

}
