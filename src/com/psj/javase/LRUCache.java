package com.psj.javase;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    private Map<Integer, DLinkedNode> cache = new HashMap<Integer, DLinkedNode>();
    private int capacity;
    private int size;
    private DLinkedNode head, tail;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null)
            return -1;
        moveToHead(node);
        return node.val;
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            DLinkedNode newnode = new DLinkedNode(key, value);
            cache.put(key, newnode);
            addToHead(newnode);
            size++;
            if (size > capacity) {
                DLinkedNode remnode = removeTail();
                cache.remove(remnode.key);
                size--;
            }
        } else {
            node.val = value;
            moveToHead(node);
        }
    }

    private void addToHead(DLinkedNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }


    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    private DLinkedNode removeTail() {
        DLinkedNode remnode = tail.prev;
        removeNode(remnode);
        return remnode;
    }
}

class DLinkedNode {
    int key;
    int val;
    DLinkedNode prev;
    DLinkedNode next;

    public DLinkedNode() {
    }

    public DLinkedNode(int _key, int _val) {
        key = _key;
        val = _val;
    }
}