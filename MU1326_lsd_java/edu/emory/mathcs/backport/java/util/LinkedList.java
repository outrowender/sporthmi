/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util;

import edu.emory.mathcs.backport.java.util.Deque;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.AbstractSequentialList;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class LinkedList
extends AbstractSequentialList
implements List,
Deque,
Cloneable,
Serializable {
    private static final long serialVersionUID = 876323262645176354L;
    private transient int size = 0;
    private transient int modCount;
    private transient Entry head;

    public LinkedList() {
        Entry entry;
        entry.next = entry.prev = (entry = new Entry(null));
        this.head = entry;
    }

    public LinkedList(Collection collection) {
        this();
        this.addAll(collection);
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public boolean contains(Object object) {
        return this.findFirst(object) != null;
    }

    private Entry getAt(int n) {
        int n2 = this.size;
        if (n < 0 || n >= n2) {
            throw new ArrayIndexOutOfBoundsException(new StringBuffer().append("Index: ").append(n).append("; Size: ").append(n2).toString());
        }
        if (n < n2 >> 1) {
            Entry entry = this.head.next;
            while (n > 0) {
                entry = entry.next;
                --n;
            }
            return entry;
        }
        Entry entry = this.head.prev;
        for (n = n2 - n - 1; n > 0; --n) {
            entry = entry.prev;
        }
        return entry;
    }

    private Entry findFirst(Object object) {
        if (object == null) {
            Entry entry = this.head.next;
            while (entry != this.head) {
                if (entry.val == null) {
                    return entry;
                }
                entry = entry.next;
            }
        } else {
            Entry entry = this.head.next;
            while (entry != this.head) {
                if (object.equals(entry.val)) {
                    return entry;
                }
                entry = entry.next;
            }
        }
        return null;
    }

    private Entry findLast(Object object) {
        if (object == null) {
            Entry entry = this.head.prev;
            while (entry != this.head) {
                if (entry.val == null) {
                    return entry;
                }
                entry = entry.prev;
            }
        } else {
            Entry entry = this.head.prev;
            while (entry != this.head) {
                if (object.equals(entry.val)) {
                    return entry;
                }
                entry = entry.prev;
            }
        }
        return null;
    }

    public int indexOf(Object object) {
        int n = 0;
        if (object == null) {
            Entry entry = this.head.next;
            while (entry != this.head) {
                if (entry.val == null) {
                    return n;
                }
                entry = entry.next;
                ++n;
            }
        } else {
            Entry entry = this.head.next;
            while (entry != this.head) {
                if (object.equals(entry.val)) {
                    return n;
                }
                entry = entry.next;
                ++n;
            }
        }
        return -1;
    }

    public int lastIndexOf(Object object) {
        int n = this.size - 1;
        if (object == null) {
            Entry entry = this.head.prev;
            while (entry != this.head) {
                if (entry.val == null) {
                    return n;
                }
                entry = entry.prev;
                --n;
            }
        } else {
            Entry entry = this.head.prev;
            while (entry != this.head) {
                if (object.equals(entry.val)) {
                    return n;
                }
                entry = entry.prev;
                --n;
            }
        }
        return -1;
    }

    public Object[] toArray() {
        Object[] objectArray = new Object[this.size];
        int n = 0;
        Entry entry = this.head.next;
        while (entry != this.head) {
            objectArray[n++] = entry.val;
            entry = entry.next;
        }
        return objectArray;
    }

    public Object[] toArray(Object[] objectArray) {
        int n = this.size;
        if (objectArray.length < n) {
            objectArray = (Object[])Array.newInstance(objectArray.getClass().getComponentType(), n);
        }
        int n2 = 0;
        Entry entry = this.head.next;
        while (entry != this.head) {
            objectArray[n2++] = entry.val;
            entry = entry.next;
        }
        if (n2 < objectArray.length) {
            objectArray[n2++] = null;
        }
        return objectArray;
    }

    public boolean add(Object object) {
        this.insertBefore(this.head, object);
        return true;
    }

    private void insertAfter(Entry entry, Object object) {
        ++this.modCount;
        Entry entry2 = entry.next;
        Entry entry3 = new Entry(object);
        entry3.prev = entry;
        entry3.next = entry2;
        entry.next = entry3;
        entry2.prev = entry3;
        ++this.size;
    }

    private void insertBefore(Entry entry, Object object) {
        ++this.modCount;
        Entry entry2 = entry.prev;
        Entry entry3 = new Entry(object);
        entry3.prev = entry2;
        entry3.next = entry;
        entry2.next = entry3;
        entry.prev = entry3;
        ++this.size;
    }

    private Object remove(Entry entry) {
        if (entry == this.head) {
            throw new NoSuchElementException();
        }
        ++this.modCount;
        Entry entry2 = entry.next;
        Entry entry3 = entry.prev;
        entry3.next = entry2;
        entry2.prev = entry3;
        --this.size;
        return entry.val;
    }

    public boolean remove(Object object) {
        Entry entry = this.findFirst(object);
        if (entry == null) {
            return false;
        }
        this.remove(entry);
        return true;
    }

    public boolean addAll(Collection collection) {
        return this.insertAllBefore(this.head, collection);
    }

    public boolean addAll(int n, Collection collection) {
        return this.insertAllBefore(n == this.size ? this.head : this.getAt(n), collection);
    }

    private boolean insertAllBefore(Entry entry, Collection collection) {
        Entry entry2;
        Entry entry3;
        Iterator iterator = collection.iterator();
        if (!iterator.hasNext()) {
            return false;
        }
        ++this.modCount;
        Entry entry4 = entry3 = new Entry(iterator.next());
        Entry entry5 = entry3;
        int n = 1;
        while (iterator.hasNext()) {
            entry4.next = entry5 = new Entry(iterator.next());
            entry5.prev = entry4;
            entry4 = entry5;
            ++n;
        }
        entry3.prev = entry2 = entry.prev;
        entry5.next = entry;
        entry2.next = entry3;
        entry.prev = entry5;
        this.size += n;
        return true;
    }

    public void clear() {
        ++this.modCount;
        this.head.next = this.head.prev = this.head;
        this.size = 0;
    }

    public Object get(int n) {
        return this.getAt((int)n).val;
    }

    public Object set(int n, Object object) {
        Entry entry = this.getAt(n);
        Object object2 = entry.val;
        entry.val = object;
        return object2;
    }

    public void add(int n, Object object) {
        if (n == this.size) {
            this.insertBefore(this.head, object);
        } else {
            this.insertBefore(n == this.size ? this.head : this.getAt(n), object);
        }
    }

    public Object remove(int n) {
        return this.remove(this.getAt(n));
    }

    public ListIterator listIterator() {
        return new Itr();
    }

    public ListIterator listIterator(int n) {
        return new Itr(n == this.size ? this.head : this.getAt(n), n);
    }

    public void addFirst(Object object) {
        this.insertAfter(this.head, object);
    }

    public void addLast(Object object) {
        this.insertBefore(this.head, object);
    }

    public boolean offerFirst(Object object) {
        this.insertAfter(this.head, object);
        return true;
    }

    public boolean offerLast(Object object) {
        this.insertBefore(this.head, object);
        return true;
    }

    public Object removeFirst() {
        return this.remove(this.head.next);
    }

    public Object removeLast() {
        return this.remove(this.head.prev);
    }

    public Object pollFirst() {
        return this.size == 0 ? null : this.remove(this.head.next);
    }

    public Object pollLast() {
        return this.size == 0 ? null : this.remove(this.head.prev);
    }

    public Object getFirst() {
        if (this.size == 0) {
            throw new NoSuchElementException();
        }
        return this.head.next.val;
    }

    public Object getLast() {
        if (this.size == 0) {
            throw new NoSuchElementException();
        }
        return this.head.prev.val;
    }

    public Object peekFirst() {
        return this.size == 0 ? null : this.head.next.val;
    }

    public Object peekLast() {
        return this.size == 0 ? null : this.head.prev.val;
    }

    public boolean removeFirstOccurrence(Object object) {
        Entry entry = this.findFirst(object);
        if (entry == null) {
            return false;
        }
        this.remove(entry);
        return true;
    }

    public boolean removeLastOccurrence(Object object) {
        Entry entry = this.findLast(object);
        if (entry == null) {
            return false;
        }
        this.remove(entry);
        return true;
    }

    public boolean offer(Object object) {
        return this.add(object);
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

    public Iterator descendingIterator() {
        return new DescItr();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(this.size);
        Entry entry = this.head.next;
        while (entry != this.head) {
            objectOutputStream.writeObject(entry.val);
            entry = entry.next;
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        Entry entry;
        objectInputStream.defaultReadObject();
        int n = objectInputStream.readInt();
        entry.next = entry.prev = (entry = new Entry(null));
        for (int i2 = 0; i2 < n; ++i2) {
            this.insertBefore(entry, objectInputStream.readObject());
        }
        this.size = n;
        this.head = entry;
    }

    public Object clone() {
        Entry entry;
        LinkedList linkedList = null;
        try {
            linkedList = (LinkedList)super.clone();
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            throw new InternalError();
        }
        entry.next = entry.prev = (entry = new Entry(null));
        linkedList.head = entry;
        linkedList.addAll(this);
        return linkedList;
    }

    private class Itr
    implements ListIterator {
        int expectedModCount;
        int idx;
        Entry cursor;
        Entry lastRet;

        Itr(Entry entry, int n) {
            this.cursor = entry;
            this.idx = n;
            this.expectedModCount = LinkedList.this.modCount;
        }

        Itr() {
            this(((LinkedList)linkedList).head.next, 0);
        }

        public boolean hasNext() {
            return this.cursor != LinkedList.this.head;
        }

        public int nextIndex() {
            return this.idx;
        }

        public boolean hasPrevious() {
            return this.cursor.prev != LinkedList.this.head;
        }

        public int previousIndex() {
            return this.idx - 1;
        }

        public Object next() {
            if (this.expectedModCount != LinkedList.this.modCount) {
                throw new ConcurrentModificationException();
            }
            if (this.cursor == LinkedList.this.head) {
                throw new NoSuchElementException();
            }
            this.lastRet = this.cursor;
            this.cursor = this.cursor.next;
            ++this.idx;
            return this.lastRet.val;
        }

        public Object previous() {
            if (this.expectedModCount != LinkedList.this.modCount) {
                throw new ConcurrentModificationException();
            }
            if (this.cursor.prev == LinkedList.this.head) {
                throw new NoSuchElementException();
            }
            this.lastRet = this.cursor = this.cursor.prev;
            --this.idx;
            return this.lastRet.val;
        }

        public void add(Object object) {
            if (this.expectedModCount != LinkedList.this.modCount) {
                throw new ConcurrentModificationException();
            }
            LinkedList.this.insertBefore(this.cursor, object);
            this.lastRet = null;
            ++this.idx;
            ++this.expectedModCount;
        }

        public void set(Object object) {
            if (this.lastRet == null) {
                throw new IllegalStateException();
            }
            this.lastRet.val = object;
        }

        public void remove() {
            if (this.expectedModCount != LinkedList.this.modCount) {
                throw new ConcurrentModificationException();
            }
            if (this.lastRet == null) {
                throw new IllegalStateException();
            }
            if (this.lastRet.next == this.cursor) {
                --this.idx;
            } else {
                this.cursor = this.lastRet.next;
            }
            LinkedList.this.remove(this.lastRet);
            this.lastRet = null;
            ++this.expectedModCount;
        }
    }

    private static class Entry {
        Entry prev;
        Entry next;
        Object val;

        Entry(Object object) {
            this.val = object;
        }
    }

    private class DescItr
    implements ListIterator {
        int expectedModCount;
        int idx;
        Entry cursor;
        Entry lastRet;

        DescItr(Entry entry, int n) {
            this.cursor = entry;
            this.idx = n;
            this.expectedModCount = LinkedList.this.modCount;
        }

        DescItr() {
            this(((LinkedList)linkedList).head.prev, 0);
        }

        public boolean hasNext() {
            return this.cursor != LinkedList.this.head;
        }

        public int nextIndex() {
            return this.idx;
        }

        public boolean hasPrevious() {
            return this.cursor.next != LinkedList.this.head;
        }

        public int previousIndex() {
            return this.idx - 1;
        }

        public Object next() {
            if (this.expectedModCount != LinkedList.this.modCount) {
                throw new ConcurrentModificationException();
            }
            if (this.cursor == LinkedList.this.head) {
                throw new NoSuchElementException();
            }
            this.lastRet = this.cursor;
            this.cursor = this.cursor.prev;
            ++this.idx;
            return this.lastRet.val;
        }

        public Object previous() {
            if (this.expectedModCount != LinkedList.this.modCount) {
                throw new ConcurrentModificationException();
            }
            if (this.cursor.next == LinkedList.this.head) {
                throw new NoSuchElementException();
            }
            this.lastRet = this.cursor = this.cursor.next;
            --this.idx;
            return this.lastRet;
        }

        public void add(Object object) {
            if (this.expectedModCount != LinkedList.this.modCount) {
                throw new ConcurrentModificationException();
            }
            LinkedList.this.insertAfter(this.cursor, object);
            this.lastRet = null;
            ++this.idx;
            ++this.expectedModCount;
        }

        public void set(Object object) {
            if (this.lastRet == null) {
                throw new IllegalStateException();
            }
            this.lastRet.val = object;
        }

        public void remove() {
            if (this.expectedModCount != LinkedList.this.modCount) {
                throw new ConcurrentModificationException();
            }
            if (this.lastRet == null) {
                throw new IllegalStateException();
            }
            if (this.lastRet.next == this.cursor) {
                --this.idx;
            } else {
                this.cursor = this.lastRet.next;
            }
            LinkedList.this.remove(this.lastRet);
            this.lastRet = null;
            ++this.expectedModCount;
        }
    }
}

