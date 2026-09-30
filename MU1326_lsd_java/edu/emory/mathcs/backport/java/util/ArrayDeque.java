/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util;

import edu.emory.mathcs.backport.java.util.AbstractCollection;
import edu.emory.mathcs.backport.java.util.Arrays;
import edu.emory.mathcs.backport.java.util.Deque;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayDeque
extends AbstractCollection
implements Deque,
Cloneable,
Serializable {
    private transient Object[] elements;
    private transient int head;
    private transient int tail;
    private static final int MIN_INITIAL_CAPACITY = 8;
    private static final long serialVersionUID = 2340985798034038923L;
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$edu$emory$mathcs$backport$java$util$ArrayDeque;

    private void allocateElements(int n) {
        int n2 = 8;
        if (n >= n2) {
            n2 = n;
            n2 |= n2 >>> 1;
            n2 |= n2 >>> 2;
            n2 |= n2 >>> 4;
            n2 |= n2 >>> 8;
            n2 |= n2 >>> 16;
            if (++n2 < 0) {
                n2 >>>= 1;
            }
        }
        this.elements = new Object[n2];
    }

    private void doubleCapacity() {
        if (!$assertionsDisabled && this.head != this.tail) {
            throw new AssertionError();
        }
        int n = this.head;
        int n2 = this.elements.length;
        int n3 = n2 - n;
        int n4 = n2 << 1;
        if (n4 < 0) {
            throw new IllegalStateException("Sorry, deque too big");
        }
        Object[] objectArray = new Object[n4];
        System.arraycopy((Object)this.elements, n, (Object)objectArray, 0, n3);
        System.arraycopy((Object)this.elements, 0, (Object)objectArray, n3, n);
        this.elements = objectArray;
        this.head = 0;
        this.tail = n2;
    }

    private Object[] copyElements(Object[] objectArray) {
        if (this.head < this.tail) {
            System.arraycopy((Object)this.elements, this.head, (Object)objectArray, 0, this.size());
        } else if (this.head > this.tail) {
            int n = this.elements.length - this.head;
            System.arraycopy((Object)this.elements, this.head, (Object)objectArray, 0, n);
            System.arraycopy((Object)this.elements, 0, (Object)objectArray, n, this.tail);
        }
        return objectArray;
    }

    public ArrayDeque() {
        this.elements = new Object[16];
    }

    public ArrayDeque(int n) {
        this.allocateElements(n);
    }

    public ArrayDeque(Collection collection) {
        this.allocateElements(collection.size());
        this.addAll(collection);
    }

    public void addFirst(Object object) {
        if (object == null) {
            throw new NullPointerException();
        }
        this.head = this.head - 1 & this.elements.length - 1;
        this.elements[this.head] = object;
        if (this.head == this.tail) {
            this.doubleCapacity();
        }
    }

    public void addLast(Object object) {
        if (object == null) {
            throw new NullPointerException();
        }
        this.elements[this.tail] = object;
        this.tail = this.tail + 1 & this.elements.length - 1;
        if (this.tail == this.head) {
            this.doubleCapacity();
        }
    }

    public boolean offerFirst(Object object) {
        this.addFirst(object);
        return true;
    }

    public boolean offerLast(Object object) {
        this.addLast(object);
        return true;
    }

    public Object removeFirst() {
        Object object = this.pollFirst();
        if (object == null) {
            throw new NoSuchElementException();
        }
        return object;
    }

    public Object removeLast() {
        Object object = this.pollLast();
        if (object == null) {
            throw new NoSuchElementException();
        }
        return object;
    }

    public Object pollFirst() {
        int n = this.head;
        Object object = this.elements[n];
        if (object == null) {
            return null;
        }
        this.elements[n] = null;
        this.head = n + 1 & this.elements.length - 1;
        return object;
    }

    public Object pollLast() {
        int n = this.tail - 1 & this.elements.length - 1;
        Object object = this.elements[n];
        if (object == null) {
            return null;
        }
        this.elements[n] = null;
        this.tail = n;
        return object;
    }

    public Object getFirst() {
        Object object = this.elements[this.head];
        if (object == null) {
            throw new NoSuchElementException();
        }
        return object;
    }

    public Object getLast() {
        Object object = this.elements[this.tail - 1 & this.elements.length - 1];
        if (object == null) {
            throw new NoSuchElementException();
        }
        return object;
    }

    public Object peekFirst() {
        return this.elements[this.head];
    }

    public Object peekLast() {
        return this.elements[this.tail - 1 & this.elements.length - 1];
    }

    public boolean removeFirstOccurrence(Object object) {
        Object object2;
        if (object == null) {
            return false;
        }
        int n = this.elements.length - 1;
        int n2 = this.head;
        while ((object2 = this.elements[n2]) != null) {
            if (object.equals(object2)) {
                this.delete(n2);
                return true;
            }
            n2 = n2 + 1 & n;
        }
        return false;
    }

    public boolean removeLastOccurrence(Object object) {
        Object object2;
        if (object == null) {
            return false;
        }
        int n = this.elements.length - 1;
        int n2 = this.tail - 1 & n;
        while ((object2 = this.elements[n2]) != null) {
            if (object.equals(object2)) {
                this.delete(n2);
                return true;
            }
            n2 = n2 - 1 & n;
        }
        return false;
    }

    public boolean add(Object object) {
        this.addLast(object);
        return true;
    }

    public boolean offer(Object object) {
        return this.offerLast(object);
    }

    public Object remove() {
        return this.removeFirst();
    }

    public Object poll() {
        return this.pollFirst();
    }

    public Object element() {
        return this.getFirst();
    }

    public Object peek() {
        return this.peekFirst();
    }

    public void push(Object object) {
        this.addFirst(object);
    }

    public Object pop() {
        return this.removeFirst();
    }

    private void checkInvariants() {
        if (!$assertionsDisabled && this.elements[this.tail] != null) {
            throw new AssertionError();
        }
        if (!$assertionsDisabled && !(this.head != this.tail ? this.elements[this.head] != null && this.elements[this.tail - 1 & this.elements.length - 1] != null : this.elements[this.head] == null)) {
            throw new AssertionError();
        }
        if (!$assertionsDisabled && this.elements[this.head - 1 & this.elements.length - 1] != null) {
            throw new AssertionError();
        }
    }

    private boolean delete(int n) {
        this.checkInvariants();
        Object[] objectArray = this.elements;
        int n2 = objectArray.length - 1;
        int n3 = this.head;
        int n4 = this.tail;
        int n5 = n - n3 & n2;
        int n6 = n4 - n & n2;
        if (n5 >= (n4 - n3 & n2)) {
            throw new ConcurrentModificationException();
        }
        if (n5 < n6) {
            if (n3 <= n) {
                System.arraycopy((Object)objectArray, n3, (Object)objectArray, n3 + 1, n5);
            } else {
                System.arraycopy((Object)objectArray, 0, (Object)objectArray, 1, n);
                objectArray[0] = objectArray[n2];
                System.arraycopy((Object)objectArray, n3, (Object)objectArray, n3 + 1, n2 - n3);
            }
            objectArray[n3] = null;
            this.head = n3 + 1 & n2;
            return false;
        }
        if (n < n4) {
            System.arraycopy((Object)objectArray, n + 1, (Object)objectArray, n, n6);
            this.tail = n4 - 1;
        } else {
            System.arraycopy((Object)objectArray, n + 1, (Object)objectArray, n, n2 - n);
            objectArray[n2] = objectArray[0];
            System.arraycopy((Object)objectArray, 1, (Object)objectArray, 0, n4);
            this.tail = n4 - 1 & n2;
        }
        return true;
    }

    public int size() {
        return this.tail - this.head & this.elements.length - 1;
    }

    public boolean isEmpty() {
        return this.head == this.tail;
    }

    public Iterator iterator() {
        return new DeqIterator();
    }

    public Iterator descendingIterator() {
        return new DescendingIterator();
    }

    public boolean contains(Object object) {
        Object object2;
        if (object == null) {
            return false;
        }
        int n = this.elements.length - 1;
        int n2 = this.head;
        while ((object2 = this.elements[n2]) != null) {
            if (object.equals(object2)) {
                return true;
            }
            n2 = n2 + 1 & n;
        }
        return false;
    }

    public boolean remove(Object object) {
        return this.removeFirstOccurrence(object);
    }

    public void clear() {
        int n = this.head;
        int n2 = this.tail;
        if (n != n2) {
            this.tail = 0;
            this.head = 0;
            int n3 = n;
            int n4 = this.elements.length - 1;
            do {
                this.elements[n3] = null;
            } while ((n3 = n3 + 1 & n4) != n2);
        }
    }

    public Object[] toArray() {
        return this.copyElements(new Object[this.size()]);
    }

    public Object[] toArray(Object[] objectArray) {
        int n = this.size();
        if (objectArray.length < n) {
            objectArray = (Object[])Array.newInstance(objectArray.getClass().getComponentType(), n);
        }
        this.copyElements(objectArray);
        if (objectArray.length > n) {
            objectArray[n] = null;
        }
        return objectArray;
    }

    public Object clone() {
        try {
            ArrayDeque arrayDeque = (ArrayDeque)super.clone();
            arrayDeque.elements = Arrays.copyOf(this.elements, this.elements.length);
            return arrayDeque;
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            throw new AssertionError();
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(this.size());
        int n = this.elements.length - 1;
        int n2 = this.head;
        while (n2 != this.tail) {
            objectOutputStream.writeObject(this.elements[n2]);
            n2 = n2 + 1 & n;
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        int n = objectInputStream.readInt();
        this.allocateElements(n);
        this.head = 0;
        this.tail = n;
        for (int i2 = 0; i2 < n; ++i2) {
            this.elements[i2] = objectInputStream.readObject();
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
        $assertionsDisabled = !(class$edu$emory$mathcs$backport$java$util$ArrayDeque == null ? (class$edu$emory$mathcs$backport$java$util$ArrayDeque = ArrayDeque.class$("edu.emory.mathcs.backport.java.util.ArrayDeque")) : class$edu$emory$mathcs$backport$java$util$ArrayDeque).desiredAssertionStatus();
    }

    private class DeqIterator
    implements Iterator {
        private int cursor;
        private int fence;
        private int lastRet;

        private DeqIterator() {
            this.cursor = ArrayDeque.this.head;
            this.fence = ArrayDeque.this.tail;
            this.lastRet = -1;
        }

        public boolean hasNext() {
            return this.cursor != this.fence;
        }

        public Object next() {
            if (this.cursor == this.fence) {
                throw new NoSuchElementException();
            }
            Object object = ArrayDeque.this.elements[this.cursor];
            if (ArrayDeque.this.tail != this.fence || object == null) {
                throw new ConcurrentModificationException();
            }
            this.lastRet = this.cursor;
            this.cursor = this.cursor + 1 & ArrayDeque.this.elements.length - 1;
            return object;
        }

        public void remove() {
            if (this.lastRet < 0) {
                throw new IllegalStateException();
            }
            if (ArrayDeque.this.delete(this.lastRet)) {
                this.cursor = this.cursor - 1 & ArrayDeque.this.elements.length - 1;
                this.fence = ArrayDeque.this.tail;
            }
            this.lastRet = -1;
        }
    }

    private class DescendingIterator
    implements Iterator {
        private int cursor;
        private int fence;
        private int lastRet;

        private DescendingIterator() {
            this.cursor = ArrayDeque.this.tail;
            this.fence = ArrayDeque.this.head;
            this.lastRet = -1;
        }

        public boolean hasNext() {
            return this.cursor != this.fence;
        }

        public Object next() {
            if (this.cursor == this.fence) {
                throw new NoSuchElementException();
            }
            this.cursor = this.cursor - 1 & ArrayDeque.this.elements.length - 1;
            Object object = ArrayDeque.this.elements[this.cursor];
            if (ArrayDeque.this.head != this.fence || object == null) {
                throw new ConcurrentModificationException();
            }
            this.lastRet = this.cursor;
            return object;
        }

        public void remove() {
            if (this.lastRet < 0) {
                throw new IllegalStateException();
            }
            if (!ArrayDeque.this.delete(this.lastRet)) {
                this.cursor = this.cursor + 1 & ArrayDeque.this.elements.length - 1;
                this.fence = ArrayDeque.this.head;
            }
            this.lastRet = -1;
        }
    }
}

