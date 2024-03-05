public class LinkedList {
    private static class Node {
        Pokemon mon; // object in node
        Node next; // next Node in linked list

        // default constructor
        public Node() {
            mon = new Pokemon();
            next = null;
        }
        // constructor
        public Node(Pokemon m, Node n) {
            mon = m;
            next = n;
        }
    }
    private Node head; // first node in linked list

    // default constructor
    LinkedList() {
        head = null;
    }

    public void print() {
        Node runner = head; // start at the head
        while (runner.next != null) { // keep going until the end
            System.out.println(runner.mon); // print Pokémon
            runner = runner.next; // go to next node
        }
    }

    // find a node, return whether found or not
    public boolean find(Pokemon mon) {
        Node current = head; // start off at head
        while (current != null) { // while not at the end
            if (current.mon.equals(mon)) { // check if found
                return true;
            }
            current = current.next; // go to next Pokémon
        }
        return false; // not found
    }

    // Insert a node at the end of the list
    public void insert(Pokemon mon) {
        Node newNode = new Node(); // created new node
        newNode.mon = mon; // set Pokémon inside node

        if (head == null) { // empty list
            head = newNode;
        } else if (head.mon.compareTo(mon) >= 0){ // insert at head
            newNode.next = head; // set new node's next to head
            head = newNode; // set head to new node
        } else {
            Node runner = head.next; // runner start at second node
            Node prev = head; // previous node start at head
            while (runner != null && runner.mon.compareTo(mon) < 0) { // find where to insert
                prev = runner; // set previous to runner
                runner = runner.next; // runner goes to next node
            }
            newNode.next = runner; // set new node's next to runner
            prev.next = newNode; // set previous node's next to new node
        }
    }

    // Delete a node at the beginning of the Linked List and return it
    public Pokemon pop () {
        if (head != null) {
            Node temp = head;
            head = head.next;
            return temp.mon;
        } else {
            return null;
        }
    }
}
