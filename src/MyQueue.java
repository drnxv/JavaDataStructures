/* Queue implementation using linked nodes */

public class MyQueue {
  private Node head;

  MyQueue() {
    head = null;
  }

  private class Node {
    private int data;
    private Node next;

    Node(int data) {
      this.data = data;
      this.next = null;
    }
  }

  // add nodes to the front of the queue
  public void enqueue(int data) {
    Node newNode = new Node(data);
    if (head == null) {
      head = newNode;
    } else {
      newNode.next = head;
      head = newNode;
    }
  }

  // removes the end of the queue since that was the first node added
  public int dequeue() {
    int res = -1;
    Node curr;

    if (head != null) {
      curr = head;
      while (curr.next.next != null) {
        curr = curr.next;
      }

      Node last = curr.next;
      res = last.data;
      curr.next = null;
      last = null;
    }

    return res;
  }

  public boolean isEmpty() {
    return head == null;
  }

  public String toString() {
    String res = "";
    Node curr = head;

    if (head != null) {
      while (curr != null) {
        res += curr.data + " ";
        curr = curr.next;
      }
    }

    return res;
  }

  public static void main(String[] args) {
    MyQueue queue = new MyQueue();
    System.out.println(queue.isEmpty());
    queue.enqueue(1);
    queue.enqueue(2);
    queue.enqueue(3);
    queue.enqueue(4);
    queue.enqueue(5);
    queue.dequeue();
    System.out.println(queue.isEmpty());
    System.out.println(queue);
  }
}
