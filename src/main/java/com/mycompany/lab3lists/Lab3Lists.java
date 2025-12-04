package com.mycompany.lab3lists;

public class Lab3Lists {
    public static void main(String[] args) {
        System.out.println("=== Testing SingleLinkedList ===");
        SingleLinkedList sll = new SingleLinkedList();
        sll.addFirst(10);
        sll.addLast(20);
        sll.addFirst(5);
        sll.display(); // 5 10 20
        
        System.out.println("\n=== Testing DoubleLinkedList ===");
        DoubleLinkedList<Integer> dll = new DoubleLinkedList<>();
        dll.addFirst(10);
        dll.addLast(20);
        dll.add(1, 15);
        dll.display(); 
        dll.displayReverse(); 
        
        System.out.println("\n=== Testing CircularLinkedList ===");
        CircularLinkedList cll = new CircularLinkedList();
        cll.addLast(1);
        cll.addLast(2);
        cll.addLast(3);
        cll.addLast(4);
        cll.display(); 
        
        cll.rotate();
        System.out.print("After rotate(): ");
        cll.display(); 
        
        System.out.println("Has a cycle? " + cll.findCycle()); // true
        
        CircularLinkedList[] halves = cll.splitIntoTwo();
        System.out.print("First list after split: ");
        halves[0].display(); 
        System.out.print("Second list after split: ");
        halves[1].display(); 
    }
}
