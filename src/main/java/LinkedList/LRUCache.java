package LinkedList;

import java.util.HashMap;
/*
neetcode 150
hashmap, stack,queue, dequeue, linked list
pointers
store max capacity
hashmap <key, linkedlistnode>
cap = 2
map:
LL:
["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
   [[2],   [1, 1], [2, 2],  [1],  [3, 3], [2], [4, 4],  [1],   [3],   [4]]

[dummyhead] ->     <- [dummytail]
*/

class Node{
    int key;
    int value;
    Node next;
    Node prev;
    public Node(int key, int value){
        this.key = key;
        this.value = value;
    }

    public Node(){
        this.next = null;
        this.prev = null;
    }
}

public class LRUCache {
    int cap;
    HashMap<Integer,Node> map;
    Node head = new Node(0,0);
    Node tail = new Node(0,0);

    public LRUCache(int capacity) {
        cap = capacity;
        head.next = tail;
        tail.prev = head;
        map = new HashMap<Integer,Node>();
    }

    public int get(int key) {
        if(map.containsKey(key)){
            Node curr = map.get(key);
            remove(curr);
            insertHead(curr);
            return map.get(key).value;
        }

        return -1;
    }

    public void put(int key, int value) {
        Node newNode = new Node(key,value);
        if(map.containsKey(key)){
            Node temp = map.get(key);
            remove(temp);
            insertHead(newNode);
            map.put(key,newNode);
        }else{
            insertHead(newNode);
            map.put(key,newNode);
        }

        if(map.size() > cap){
            Node end = tail.prev;
            remove(end);
            map.remove(end.key);
        }

    }


    // head -> c ->  a<->b<->c<->tail
    public void insertHead(Node curr){
        Node headNext = head.next;
        head.next = curr;
        curr.next = headNext;
        headNext.prev = curr;
        curr.prev = head;
    }
    // a<->b<->c
    public void remove(Node curr){
        Node prevNode = curr.prev;
        Node nextNode = curr.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }
}
