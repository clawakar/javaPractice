package com.chetan.javaPractice;

import java.util.Random;

public class AbstractCLassDemoMyLinkedList {
    public static  void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList(null);
        /*
        String str = "Ram Sham Keshav Pratap Rajiv Akram Avinash Kamal Bhushan Deepak";
        String[] strings = str.split(" ");

        for(String s : strings) {
            myLinkedList.addItem(s);
        }

        //myLinkedList.addItem(new Node("Ram"));
        //myLinkedList.addItem(new Node("Abc"));
        myLinkedList.printAllItems();

        myLinkedList.removeItem("Ram");
        myLinkedList.printAllItems();
        */

        for(int i = 0; i < 10 ; i++) {
            myLinkedList.addItem(i);
        }

        myLinkedList.addItem(5);
        myLinkedList.addItem(7);

        myLinkedList.printAllItems();
        System.out.println("=====================================================");
        myLinkedList.removeItem(5);
        myLinkedList.printAllItems();
        System.out.println("=====================================================");

        myLinkedList.removeItem(8);
        myLinkedList.printAllItems();
        System.out.println("=====================================================");

        myLinkedList.removeItem(3);
        myLinkedList.printAllItems();
        System.out.println("=====================================================");

        myLinkedList.removeItem(7);
        myLinkedList.printAllItems();
        System.out.println("=====================================================");

        /*
        for (int i = 1; i < 10 ; i++) {
            myLinkedList.removeItem(i);
            System.out.println("Printing item in linked list after removal of " + i);
            myLinkedList.printAllItems();
            System.out.println("=====================================================");
        }
        */

    }
}

abstract class MyLinkedListItem {
    protected MyLinkedListItem nextLink = null;
    protected MyLinkedListItem previousLink = null;

    private Object value = null;

    public MyLinkedListItem(Object value) {
        this.value = value;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    abstract MyLinkedListItem next();
    abstract MyLinkedListItem setNext(MyLinkedListItem listItem);
    abstract MyLinkedListItem previous();
    abstract MyLinkedListItem setPrevious(MyLinkedListItem listItem);

    abstract int compareTo(MyLinkedListItem listItem);
}

class Node extends MyLinkedListItem {

    public Node(Object value) {
        super(value);
    }

    @Override
    MyLinkedListItem next() {
        return this.nextLink;
    }

    @Override
    MyLinkedListItem setNext(MyLinkedListItem listItem) {
        return this.nextLink = listItem;
    }

    @Override
    MyLinkedListItem previous() {
        return this.previousLink;
    }

    @Override
    MyLinkedListItem setPrevious(MyLinkedListItem listItem) {
        return this.previousLink = listItem;
    }

    @Override
    int compareTo(MyLinkedListItem listItem) {
        if (listItem != null) {
            return ((String) super.getValue()).compareTo((String) listItem.getValue());
        } else {
            return -1;
        }
    }
}

interface NodeList {
    MyLinkedListItem getRoot();
    boolean addItem(Object item);
    boolean removeItem(Object item);
    void printAllItems();
}

class MyLinkedList implements NodeList {
    private MyLinkedListItem root = null;

    public MyLinkedList(MyLinkedListItem item) {
        this.root = root;
    }

    public MyLinkedListItem getRoot() {
        return this.root;
    }

    public boolean addItem(Object item) {
        MyLinkedListItem newItem= new Node(String.valueOf(item));

        MyLinkedListItem currentNode = root;

        if(newItem.getValue() == null) {
            System.out.println("null item can not be added to linked List");
            return false;
        } else if(root == null) {
            root = newItem;
            return true;
        }

        while(currentNode != null) {
            int comparison = currentNode.compareTo(newItem);
            if (comparison < 0) {
                if(currentNode.next() != null) {
                    currentNode = currentNode.next();
                } else {
                    newItem.setPrevious(currentNode);
                    currentNode.setNext(newItem);
                    return true;
                }
            } else if(comparison > 0) {
                if(currentNode.previous() != null) {
                    currentNode.previous().setNext(newItem);
                    newItem.setPrevious(currentNode.previous());
                    currentNode.setPrevious(newItem);
                    newItem.setNext(currentNode);
                    return true;
                }else {
                    currentNode.setPrevious(newItem);
                    newItem.setNext(currentNode);
                    root = newItem;
                    return true;
                }
            } else {
                System.out.println("Item " + newItem.getValue() +" is already present in the list. So can not add duplicate");
                return false;
            }
        }
        return false;
    }

    public boolean removeItem(Object item) {
        MyLinkedListItem itemToBeRemoved= new Node(String.valueOf(item));
        MyLinkedListItem currentNode = root;
        if (currentNode == null) {
            System.out.println("MyLinkedList is empty. Cant Find the item");
            return false;
        } else if (itemToBeRemoved.getValue() == null) {
            System.out.println("Item to be deleted is null.Cant Find the item");
            return false;
        }
        do{
            if(currentNode.getValue().equals(itemToBeRemoved.getValue())) {
                if (currentNode.previous() == null) {
                    if(currentNode.next() == null) {
                        root = null;
                        return true;
                    }
                    root.next().setPrevious(null);
                    root = root.next();
                    return true;
                } else {
                    currentNode.previous().setNext(currentNode.next());
                    if(currentNode.next() != null) {
                        currentNode.next().setPrevious(currentNode.previous());
                    }
                    return true;
                }
            }
            currentNode = currentNode.next();
        } while (currentNode != null);

        return false;
    }

    public void printAllItems() {
        MyLinkedListItem currentNode = root;
        if(currentNode == null) {
            System.out.println("Linked List list is empty");
        }
        while (currentNode != null) {
            System.out.println(currentNode.getValue());
            currentNode = currentNode.next();
        }
    }
}