package com.mycompany.lab3lists;

class CircularLinkedList {
    private Node tail; 
    private int size;
    
    public CircularLinkedList() {
        tail = null;
        size = 0;
    }
    

    private Node getHead() {
        return tail == null ? null : tail.next;
    }
    
    public void addFirst(int data) {
        Node newNode = new Node(data);
        
        if (tail == null) {
            tail = newNode;
            tail.next = tail;
        } else {
            newNode.next = tail.next;
            tail.next = newNode;
        }
        size++;
    }
    
    public void addLast(int data) {
        addFirst(data);
        tail = tail.next; 
    }
    
    public void removeFirst() {
        if (tail == null) return;
        
        if (tail.next == tail) { 
            tail = null;
        } else {
            tail.next = tail.next.next;
        }
        size--;
    }
    
    public void removeLast() {
        if (tail == null) return;
        
        if (tail.next == tail) { 
            tail = null;
        } else {
            Node current = tail.next; 
            while (current.next != tail) {
                current = current.next;
            }
            current.next = tail.next;
            tail = current;
        }
        size--;
    }
    
    public void remove(int data) {
        if (tail == null) return;
        
        if (tail.next.data == data) {
            removeFirst();
            return;
        }
        
        if (tail.data == data) {
            removeLast();
            return;
        }
        
        Node current = tail.next; 
        Node prev = tail;
        
        do {
            if (current.data == data) {
                prev.next = current.next;
                size--;
                return;
            }
            prev = current;
            current = current.next;
        } while (current != tail.next);
    }
    
    public boolean contains(int data) {
        return find(data) != null;
    }
    
    public int size() {
        return size;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public void display() {
        if (tail == null) {
            System.out.println("List is empty");
            return;
        }
        
        Node current = tail.next;
        do {
            System.out.print(current.data + " ");
            current = current.next;
        } while (current != tail.next);
        System.out.println();
    }
    
    public void clear() {
        tail = null;
        size = 0;
    }
    
    public void rotate() {
        if (tail != null) {
            tail = tail.next; 
        }
    }
    
    public boolean findCycle() {
        return tail != null; 
    }
    
    public Node find(int data) {
        if (tail == null) return null;
        
        Node current = tail.next; 
        do {
            if (current.data == data) {
                return current;
            }
            current = current.next;
        } while (current != tail.next);
        
        return null;
    }
    
    public CircularLinkedList[] splitIntoTwo() {
        CircularLinkedList[] result = new CircularLinkedList[2];
        result[0] = new CircularLinkedList();
        result[1] = new CircularLinkedList();
        
        if (tail == null || size <= 1) {
            if (size == 1) {
                result[0].addLast(tail.data);
            }
            return result;
        }
        
        int mid = size / 2;
        
        Node current = tail.next; 
        for (int i = 0; i < mid; i++) {
            result[0].addLast(current.data);
            current = current.next;
        }
        
        for (int i = mid; i < size; i++) {
            result[1].addLast(current.data);
            current = current.next;
        }
        
        return result;
    }
}