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

  public int pop() {
    int res = top.data;
    top = top.next;
    return res;
  }

  public boolean isEmpty() {
    return top == null;
  }
}
