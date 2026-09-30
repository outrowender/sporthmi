/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util.concurrent;

import edu.emory.mathcs.backport.java.util.AbstractQueue;
import edu.emory.mathcs.backport.java.util.concurrent.BlockingQueue;
import edu.emory.mathcs.backport.java.util.concurrent.TimeUnit;
import edu.emory.mathcs.backport.java.util.concurrent.helpers.Utils;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedBlockingQueue
extends AbstractQueue
implements BlockingQueue,
Serializable {
    private static final long serialVersionUID = -6903933977591709194L;
    private final int capacity;
    private volatile int count = 0;
    private transient Node head;
    private transient Node last;
    private final Object takeLock = new SerializableLock();
    private final Object putLock = new SerializableLock();
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$edu$emory$mathcs$backport$java$util$concurrent$LinkedBlockingQueue;

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void signalNotEmpty() {
        Object object = this.takeLock;
        synchronized (object) {
            this.takeLock.notify();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void signalNotFull() {
        Object object = this.putLock;
        synchronized (object) {
            this.putLock.notify();
        }
    }

    private void insert(Object object) {
        this.last = this.last.next = new Node(object);
    }

    private Object extract() {
        Node node;
        this.head = node = this.head.next;
        Object object = node.item;
        node.item = null;
        return object;
    }

    public LinkedBlockingQueue() {
        this(Integer.MAX_VALUE);
    }

    public LinkedBlockingQueue(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException();
        }
        this.capacity = n;
        this.last = this.head = new Node(null);
    }

    public LinkedBlockingQueue(Collection collection) {
        this(Integer.MAX_VALUE);
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            Object object = iterator.next();
            this.add(object);
        }
    }

    public int size() {
        return this.count;
    }

    public int remainingCapacity() {
        return this.capacity - this.count;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void put(Object object) throws InterruptedException {
        if (object == null) {
            throw new NullPointerException();
        }
        int n = -1;
        Object object2 = this.putLock;
        synchronized (object2) {
            try {
                while (this.count == this.capacity) {
                    this.putLock.wait();
                }
            }
            catch (InterruptedException interruptedException) {
                this.putLock.notify();
                throw interruptedException;
            }
            this.insert(object);
            LinkedBlockingQueue linkedBlockingQueue = this;
            synchronized (linkedBlockingQueue) {
                n = this.count++;
            }
            if (n + 1 < this.capacity) {
                this.putLock.notify();
            }
        }
        if (n == 0) {
            this.signalNotEmpty();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean offer(Object object, long l, TimeUnit timeUnit) throws InterruptedException {
        if (object == null) {
            throw new NullPointerException();
        }
        long l2 = timeUnit.toNanos(l);
        int n = -1;
        Object object2 = this.putLock;
        synchronized (object2) {
            long l3 = Utils.nanoTime() + l2;
            while (true) {
                if (this.count < this.capacity) {
                    this.insert(object);
                    LinkedBlockingQueue linkedBlockingQueue = this;
                    synchronized (linkedBlockingQueue) {
                        n = this.count++;
                    }
                    if (n + 1 >= this.capacity) break;
                    this.putLock.notify();
                    break;
                }
                if (l2 <= 0L) {
                    return false;
                }
                try {
                    TimeUnit.NANOSECONDS.timedWait(this.putLock, l2);
                    l2 = l3 - Utils.nanoTime();
                }
                catch (InterruptedException interruptedException) {
                    this.putLock.notify();
                    throw interruptedException;
                }
            }
        }
        if (n == 0) {
            this.signalNotEmpty();
        }
        return true;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean offer(Object object) {
        if (object == null) {
            throw new NullPointerException();
        }
        if (this.count == this.capacity) {
            return false;
        }
        int n = -1;
        Object object2 = this.putLock;
        synchronized (object2) {
            if (this.count < this.capacity) {
                this.insert(object);
                LinkedBlockingQueue linkedBlockingQueue = this;
                synchronized (linkedBlockingQueue) {
                    n = this.count++;
                }
                if (n + 1 < this.capacity) {
                    this.putLock.notify();
                }
            }
        }
        if (n == 0) {
            this.signalNotEmpty();
        }
        return n >= 0;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public Object take() throws InterruptedException {
        Object object;
        int n = -1;
        Object object2 = this.takeLock;
        synchronized (object2) {
            try {
                while (this.count == 0) {
                    this.takeLock.wait();
                }
            }
            catch (InterruptedException interruptedException) {
                this.takeLock.notify();
                throw interruptedException;
            }
            object = this.extract();
            LinkedBlockingQueue linkedBlockingQueue = this;
            synchronized (linkedBlockingQueue) {
                n = this.count--;
            }
            if (n > 1) {
                this.takeLock.notify();
            }
        }
        if (n == this.capacity) {
            this.signalNotFull();
        }
        return object;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public Object poll(long l, TimeUnit timeUnit) throws InterruptedException {
        Object object = null;
        int n = -1;
        long l2 = timeUnit.toNanos(l);
        Object object2 = this.takeLock;
        synchronized (object2) {
            long l3 = Utils.nanoTime() + l2;
            while (true) {
                if (this.count > 0) {
                    object = this.extract();
                    LinkedBlockingQueue linkedBlockingQueue = this;
                    synchronized (linkedBlockingQueue) {
                        n = this.count--;
                    }
                    if (n <= 1) break;
                    this.takeLock.notify();
                    break;
                }
                if (l2 <= 0L) {
                    return null;
                }
                try {
                    TimeUnit.NANOSECONDS.timedWait(this.takeLock, l2);
                    l2 = l3 - Utils.nanoTime();
                }
                catch (InterruptedException interruptedException) {
                    this.takeLock.notify();
                    throw interruptedException;
                }
            }
        }
        if (n == this.capacity) {
            this.signalNotFull();
        }
        return object;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public Object poll() {
        if (this.count == 0) {
            return null;
        }
        Object object = null;
        int n = -1;
        Object object2 = this.takeLock;
        synchronized (object2) {
            if (this.count > 0) {
                object = this.extract();
                LinkedBlockingQueue linkedBlockingQueue = this;
                synchronized (linkedBlockingQueue) {
                    n = this.count--;
                }
                if (n > 1) {
                    this.takeLock.notify();
                }
            }
        }
        if (n == this.capacity) {
            this.signalNotFull();
        }
        return object;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public Object peek() {
        if (this.count == 0) {
            return null;
        }
        Object object = this.takeLock;
        synchronized (object) {
            Node node = this.head.next;
            if (node == null) {
                return null;
            }
            return node.item;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean remove(Object object) {
        if (object == null) {
            return false;
        }
        boolean bl = false;
        Object object2 = this.putLock;
        synchronized (object2) {
            Object object3 = this.takeLock;
            synchronized (object3) {
                Node node = this.head;
                Node node2 = this.head.next;
                while (node2 != null) {
                    if (object.equals(node2.item)) {
                        bl = true;
                        break;
                    }
                    node = node2;
                    node2 = node2.next;
                }
                if (bl) {
                    node2.item = null;
                    node.next = node2.next;
                    if (this.last == node2) {
                        this.last = node;
                    }
                    LinkedBlockingQueue linkedBlockingQueue = this;
                    synchronized (linkedBlockingQueue) {
                        if (this.count-- == this.capacity) {
                            this.putLock.notifyAll();
                        }
                    }
                }
            }
        }
        return bl;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public Object[] toArray() {
        Object object = this.putLock;
        synchronized (object) {
            Object object2 = this.takeLock;
            synchronized (object2) {
                int n = this.count;
                Object[] objectArray = new Object[n];
                int n2 = 0;
                Node node = this.head.next;
                while (node != null) {
                    objectArray[n2++] = node.item;
                    node = node.next;
                }
                return objectArray;
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public Object[] toArray(Object[] objectArray) {
        Object object = this.putLock;
        synchronized (object) {
            Object object2 = this.takeLock;
            synchronized (object2) {
                int n = this.count;
                if (objectArray.length < n) {
                    objectArray = (Object[])Array.newInstance(objectArray.getClass().getComponentType(), n);
                }
                int n2 = 0;
                Node node = this.head.next;
                while (node != null) {
                    objectArray[n2++] = node.item;
                    node = node.next;
                }
                if (objectArray.length > n2) {
                    objectArray[n2] = null;
                }
                return objectArray;
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public String toString() {
        Object object = this.putLock;
        synchronized (object) {
            Object object2 = this.takeLock;
            synchronized (object2) {
                return super.toString();
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void clear() {
        Object object = this.putLock;
        synchronized (object) {
            Object object2 = this.takeLock;
            synchronized (object2) {
                int n;
                this.head.next = null;
                if (!$assertionsDisabled && this.head.item != null) {
                    throw new AssertionError();
                }
                this.last = this.head;
                LinkedBlockingQueue linkedBlockingQueue = this;
                synchronized (linkedBlockingQueue) {
                    n = this.count;
                    this.count = 0;
                }
                if (n == this.capacity) {
                    this.putLock.notifyAll();
                }
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public int drainTo(Collection collection) {
        Node node;
        Object object;
        if (collection == null) {
            throw new NullPointerException();
        }
        if (collection == this) {
            throw new IllegalArgumentException();
        }
        Object object2 = this.putLock;
        synchronized (object2) {
            object = this.takeLock;
            synchronized (object) {
                int n;
                node = this.head.next;
                this.head.next = null;
                if (!$assertionsDisabled && this.head.item != null) {
                    throw new AssertionError();
                }
                this.last = this.head;
                LinkedBlockingQueue linkedBlockingQueue = this;
                synchronized (linkedBlockingQueue) {
                    n = this.count;
                    this.count = 0;
                }
                if (n == this.capacity) {
                    this.putLock.notifyAll();
                }
            }
        }
        int n = 0;
        object = node;
        while (object != null) {
            collection.add(((Node)object).item);
            ((Node)object).item = null;
            ++n;
            object = ((Node)object).next;
        }
        return n;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public int drainTo(Collection collection, int n) {
        if (collection == null) {
            throw new NullPointerException();
        }
        if (collection == this) {
            throw new IllegalArgumentException();
        }
        Object object = this.putLock;
        synchronized (object) {
            Object object2 = this.takeLock;
            synchronized (object2) {
                int n2;
                Node node = this.head.next;
                for (n2 = 0; node != null && n2 < n; ++n2) {
                    collection.add(node.item);
                    node.item = null;
                    node = node.next;
                }
                if (n2 != 0) {
                    int n3;
                    this.head.next = node;
                    if (!$assertionsDisabled && this.head.item != null) {
                        throw new AssertionError();
                    }
                    if (node == null) {
                        this.last = this.head;
                    }
                    LinkedBlockingQueue linkedBlockingQueue = this;
                    synchronized (linkedBlockingQueue) {
                        n3 = this.count;
                        this.count -= n2;
                    }
                    if (n3 == this.capacity) {
                        this.putLock.notifyAll();
                    }
                }
                return n2;
            }
        }
    }

    public Iterator iterator() {
        return new Itr();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        Object object = this.putLock;
        synchronized (object) {
            Object object2 = this.takeLock;
            synchronized (object2) {
                objectOutputStream.defaultWriteObject();
                Node node = this.head.next;
                while (node != null) {
                    objectOutputStream.writeObject(node.item);
                    node = node.next;
                }
                objectOutputStream.writeObject(null);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        Object object = this;
        synchronized (object) {
            this.count = 0;
        }
        this.last = this.head = new Node(null);
        while ((object = objectInputStream.readObject()) != null) {
            this.add(object);
        }
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static {
        $assertionsDisabled = !(class$edu$emory$mathcs$backport$java$util$concurrent$LinkedBlockingQueue == null ? (class$edu$emory$mathcs$backport$java$util$concurrent$LinkedBlockingQueue = LinkedBlockingQueue.class$("edu.emory.mathcs.backport.java.util.concurrent.LinkedBlockingQueue")) : class$edu$emory$mathcs$backport$java$util$concurrent$LinkedBlockingQueue).desiredAssertionStatus();
    }

    private class Itr
    implements Iterator {
        private Node current;
        private Node lastRet;
        private Object currentElement;

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        Itr() {
            Object object = LinkedBlockingQueue.this.putLock;
            synchronized (object) {
                Object object2 = LinkedBlockingQueue.this.takeLock;
                synchronized (object2) {
                    this.current = ((LinkedBlockingQueue)LinkedBlockingQueue.this).head.next;
                    if (this.current != null) {
                        this.currentElement = this.current.item;
                    }
                }
            }
        }

        public boolean hasNext() {
            return this.current != null;
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public Object next() {
            Object object = LinkedBlockingQueue.this.putLock;
            synchronized (object) {
                Object object2 = LinkedBlockingQueue.this.takeLock;
                synchronized (object2) {
                    if (this.current == null) {
                        throw new NoSuchElementException();
                    }
                    Object object3 = this.currentElement;
                    this.lastRet = this.current;
                    this.current = this.current.next;
                    if (this.current != null) {
                        this.currentElement = this.current.item;
                    }
                    return object3;
                }
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void remove() {
            if (this.lastRet == null) {
                throw new IllegalStateException();
            }
            Object object = LinkedBlockingQueue.this.putLock;
            synchronized (object) {
                Object object2 = LinkedBlockingQueue.this.takeLock;
                synchronized (object2) {
                    Node node = this.lastRet;
                    this.lastRet = null;
                    Node node2 = LinkedBlockingQueue.this.head;
                    Node node3 = ((LinkedBlockingQueue)LinkedBlockingQueue.this).head.next;
                    while (node3 != null && node3 != node) {
                        node2 = node3;
                        node3 = node3.next;
                    }
                    if (node3 == node) {
                        int n;
                        node3.item = null;
                        node2.next = node3.next;
                        if (LinkedBlockingQueue.this.last == node3) {
                            LinkedBlockingQueue.this.last = node2;
                        }
                        Itr itr = this;
                        synchronized (itr) {
                            n = LinkedBlockingQueue.this.count--;
                        }
                        if (n == LinkedBlockingQueue.this.capacity) {
                            LinkedBlockingQueue.this.putLock.notifyAll();
                        }
                    }
                }
            }
        }
    }

    static class Node {
        volatile Object item;
        Node next;

        Node(Object object) {
            this.item = object;
        }
    }

    private static class SerializableLock
    implements Serializable {
        private static final long serialVersionUID = -8856990691138858668L;

        private SerializableLock() {
        }
    }
}

