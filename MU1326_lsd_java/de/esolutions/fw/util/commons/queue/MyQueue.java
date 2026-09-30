/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.commons.queue;

public class MyQueue {
    private Node first;
    private Node last;
    private int size;
    private static int karpottCounter;

    public void dump() {
        System.out.println("----- MyQueue Dump -----");
        System.out.println("first=" + this.first + ", last=" + this.last + ", size=" + this.size);
        Node node = this.first;
        int n = 0;
        while (node != null) {
            System.out.println("[#" + n + ":data=" + node.data + "," + node.data.getClass().getName() + "]");
            node = node.next;
            ++n;
        }
        System.out.println("----- Done Dump -----");
    }

    public void push(Object object) {
        Node node = new Node(object);
        if (this.last == null) {
            this.first = node;
            this.last = node;
        } else {
            this.last.next = node;
            this.last = node;
        }
        ++this.size;
    }

    public Object pop() {
        if (this.first == null) {
            return null;
        }
        Object object = this.first.data;
        --this.size;
        if (this.first.next == null) {
            this.first = null;
            this.last = null;
            this.sanityCheck(true);
        } else {
            this.first = this.first.next;
        }
        return object;
    }

    public int size() {
        this.sanityCheck(false);
        return this.size;
    }

    public boolean isEmpty() {
        this.sanityCheck(false);
        return this.first == null;
    }

    private void sanityCheck(boolean bl) {
        if (this.size > 0 && this.first == null) {
            if (++karpottCounter <= 3) {
                System.out.println("#### MyQueue is karpott: size=" + this.size + " but first==null. counter=" + karpottCounter);
            } else if (bl) {
                throw new RuntimeException("MyQueue is karpott");
            }
            this.size = 0;
        }
    }

    private static class Node {
        public final Object data;
        public Node next;

        public Node(Object object) {
            this.data = object;
        }
    }
}

