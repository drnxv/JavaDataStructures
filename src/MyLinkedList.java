public class MyLinkedList {

  private Node head;

  MyLinkedList() {
    head = null;
  }

  private class Node {

    private int data;
    private Node next;

    Node(int data) {
      this.data = data;
      next = null;
    }
  }

  public void addNode(int data) {
    Node toAdd = new Node(data);
    if (head == null) {
      head = toAdd;
    } else {
      Node curr = head;
      while (curr.next != null) {
        curr = curr.next;
      }

      curr.next = toAdd;
    }
  }

  // inserts nodes into correct locations based on value
  public void orderedInsert(int data) {
    Node newNode = new Node(data);
    Node curr = head;
    if (head == null) {
      head = newNode;
    } else if (head.data > newNode.data) {
      head = newNode;
      head.next = curr;
    } else {
      while (curr.next != null && curr.next.data <= data) {
        curr = curr.next;
      }

      newNode.next = curr.next;
      curr.next = newNode;
    }
  }

  // removes a node based on argument passed in
  public void removeNode(int data) {
    Node prev = null;
    Node curr = head;

    if (head != null) {
      if (head.data == data) {
        head = head.next;
      } else {
        while (curr != null) {
          if (curr.data == data) {
            prev.next = curr.next;
          }

          prev = curr;
          curr = curr.next;
        }
      }
    }
  }

  // overriding the toString method in order to print the nodes
  public String toString() {
    Node curr = head;
    StringBuilder res = new StringBuilder();
    while (curr != null) {
      res.append(curr.data).append(" ");
      curr = curr.next;
    }

    return res.toString();
  }
}
