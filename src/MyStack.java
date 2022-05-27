/* Stack implementation using linked nodes */

public class MyStack {
  private Node top;

  MyStack() {
    top = null;
  }

  private class Node {
    private int data;
    private Node next;

    Node(int data) {
      this.data = data;
      this.next = null;
    }
  }

  // adds a node to the top of the stack 
  public void push(int data) {
    Node newNode = new Node(data);
    if (top == null) {
      top = newNode;
    } else {
      Node curr = top;
      while (curr.next != null) {
        curr = curr.next;
      }

      curr.next = newNode;
    }
  }

  // removes the most recently added node 
  public int pop() {
    int res = -1;
    Node curr;

    if (top != null) {
      if (top.next != null) {
        curr = top;
        while (curr.next.next != null) {
          curr = curr.next;
        }

        Node last = curr.next;
        res = last.data;
        curr.next = null;
        last = null;
      } else {
        // clear the single element
        top = null;
      }
    }

    return res;
  }

  public boolean isEmpty() {
    return top == null;
  }

  public String toString() {
    String res = "";
    Node curr = top;
    while (curr != null) {
      res += curr.data + " ";
      curr = curr.next;
    }

    return res;
  }

  // showing the functionalities of the stack
  public static void main(String[] args) {
    MyStack stack = new MyStack();
    System.out.println(stack.isEmpty());
    stack.push(12);
    stack.push(13);
    stack.push(14);
    stack.push(15);
    stack.push(16);
    stack.pop();
    System.out.println(stack.isEmpty());
    System.out.println(stack);
  }
}
