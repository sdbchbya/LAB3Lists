package com.mycompany.lab3lists;

class DoublyNode<T> {
    T data;
    DoublyNode<T> prev;
    DoublyNode<T> next;
    
    public DoublyNode(T data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

class DoubleLinkedList<T> {
    private DoublyNode<T> head;
    private DoublyNode<T> tail;
    private int size;
    
    public DoubleLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }
    
    public void addFirst(T data) {
        DoublyNode<T> newNode = new DoublyNode<>(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }
    
    public void addLast(T data) {
        DoublyNode<T> newNode = new DoublyNode<>(data);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }
    
    public void removeFirst() {
        if (head == null) return;
        
        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        size--;
    }
    
    public void removeLast() {
        if (tail == null) return;
        
        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
        size--;
    }
    
    public void remove(T data) {
        if (head == null) return;
        
        if (head.data.equals(data)) {
            removeFirst();
            return;
        }
        
        if (tail.data.equals(data)) {
            removeLast();
            return;
        }
        
        DoublyNode<T> current = head;
        while (current != null && !current.data.equals(data)) {
            current = current.next;
        }
        
        if (current != null) {
            current.prev.next = current.next;
            if (current.next != null) {
                current.next.prev = current.prev;
            }
            size--;
        }
    }
    
    public boolean contains(T data) {
        DoublyNode<T> current = head;
        while (current != null) {
            if (current.data.equals(data)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }
    
    public int size() {
        return size;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public void display() {
        DoublyNode<T> current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
    
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }
    
    public void add(int index, T data) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        
        if (index == 0) {
            addFirst(data);
        } else if (index == size) {
            addLast(data);
        } else {
            DoublyNode<T> newNode = new DoublyNode<>(data);
            DoublyNode<T> current = head;
            
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            
            newNode.prev = current.prev;
            newNode.next = current;
            current.prev.next = newNode;
            current.prev = newNode;
            
            size++;
        }
    }
    
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        
        if (index == 0) {
            removeFirst();
        } else if (index == size - 1) {
            removeLast();
        } else {
            DoublyNode<T> current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            
            current.prev.next = current.next;
            current.next.prev = current.prev;
            size--;
        }
    }
    
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        
        DoublyNode<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }
    
    public void displayReverse() {
        DoublyNode<T> current = tail;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.prev;
        }
        System.out.println();
    }
    
    public T getFirst() {
        if (head == null) {
            throw new IllegalStateException("List is empty");
        }
        return head.data;
    }
    
    public T getLast() {
        if (tail == null) {
            throw new IllegalStateException("List is empty");
        }
        return tail.data;
    }
}