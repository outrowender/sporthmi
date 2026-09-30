/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util;

import edu.emory.mathcs.backport.java.util.AbstractQueue;
import edu.emory.mathcs.backport.java.util.Arrays;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.SortedSet;

public class PriorityQueue
extends AbstractQueue
implements Serializable {
    private static final long serialVersionUID = -7720805057305804111L;
    private static final int DEFAULT_INIT_CAPACITY = 11;
    private transient Object[] buffer;
    private int size;
    private final Comparator comparator;
    private transient int modCount;
    static /* synthetic */ Class array$Ljava$lang$Object;
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$edu$emory$mathcs$backport$java$util$PriorityQueue;

    public PriorityQueue() {
        this(11, null);
    }

    public PriorityQueue(int n) {
        this(n, null);
    }

    public PriorityQueue(Comparator comparator) {
        this(11, comparator);
    }

    public PriorityQueue(int n, Comparator comparator) {
        if (n < 1) {
            throw new IllegalArgumentException();
        }
        this.buffer = new Object[n];
        this.comparator = comparator;
    }

    public PriorityQueue(PriorityQueue priorityQueue) {
        this((Collection)priorityQueue);
    }

    public PriorityQueue(SortedSet sortedSet) {
        this((Collection)sortedSet);
    }

    public PriorityQueue(Collection collection) {
        int n = collection.size();
        if ((n += this.size / 10) < 0) {
            n = Integer.MAX_VALUE;
        } else if (n == 0) {
            n = 1;
        }
        this.buffer = new Object[n];
        if (collection instanceof PriorityQueue) {
            PriorityQueue priorityQueue = (PriorityQueue)collection;
            this.comparator = priorityQueue.comparator;
            this.size = priorityQueue.size;
            System.arraycopy((Object)priorityQueue.buffer, 0, (Object)this.buffer, 0, this.size);
        } else if (collection instanceof SortedSet) {
            SortedSet sortedSet = (SortedSet)collection;
            this.comparator = sortedSet.comparator();
            Iterator iterator = sortedSet.iterator();
            while (iterator.hasNext()) {
                this.buffer[this.size++] = iterator.next();
            }
        } else {
            this.comparator = null;
            Iterator iterator = collection.iterator();
            while (iterator.hasNext()) {
                this.buffer[this.size++] = iterator.next();
            }
            for (int i2 = this.size / 2; i2 >= 0; --i2) {
                this.percolateDown(i2, this.buffer[i2]);
            }
        }
    }

    public Iterator iterator() {
        return new Itr();
    }

    public Comparator comparator() {
        return this.comparator;
    }

    public boolean offer(Object object) {
        if (object == null) {
            throw new NullPointerException();
        }
        if (this.size == this.buffer.length) {
            int n = this.buffer.length * 2;
            if (n < this.buffer.length) {
                if (this.buffer.length == Integer.MAX_VALUE) {
                    throw new OutOfMemoryError();
                }
                n = Integer.MAX_VALUE;
            }
            Object[] objectArray = new Object[n];
            System.arraycopy((Object)this.buffer, 0, (Object)objectArray, 0, this.size);
            this.buffer = objectArray;
        }
        ++this.modCount;
        this.percolateUp(this.size++, object);
        return true;
    }

    public Object peek() {
        return this.size == 0 ? null : this.buffer[0];
    }

    public Object poll() {
        if (this.size == 0) {
            return null;
        }
        ++this.modCount;
        Object object = this.buffer[0];
        --this.size;
        this.percolateDown(0, this.buffer[this.size]);
        this.buffer[this.size] = null;
        return object;
    }

    public int size() {
        return this.size;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private int percolateDown(int n, Object object) {
        try {
            if (this.comparator != null) {
                int n2;
                while ((n2 = (n << 1) + 1) < this.size) {
                    if (n2 + 1 < this.size && this.comparator.compare(this.buffer[n2], this.buffer[n2 + 1]) > 0) {
                        ++n2;
                    }
                    if (this.comparator.compare(object, this.buffer[n2]) > 0) {
                        this.buffer[n] = this.buffer[n2];
                        n = n2;
                        continue;
                    }
                    break;
                }
            } else {
                int n3;
                Comparable comparable = (Comparable)object;
                while ((n3 = (n << 1) + 1) < this.size) {
                    if (n3 + 1 < this.size && ((Comparable)this.buffer[n3]).compareTo(this.buffer[n3 + 1]) > 0) {
                        ++n3;
                    }
                    if (comparable.compareTo(this.buffer[n3]) > 0) {
                        this.buffer[n] = this.buffer[n3];
                        n = n3;
                        continue;
                    }
                    break;
                }
            }
            int n4 = n;
            return n4;
        }
        finally {
            this.buffer[n] = object;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private int percolateUp(int n, Object object) {
        try {
            int n2;
            if (this.comparator != null) {
                int n3;
                while (n > 0 && this.comparator.compare(object, this.buffer[n3 = n - 1 >>> 1]) < 0) {
                    this.buffer[n] = this.buffer[n3];
                    n = n3;
                }
                n3 = n;
                return n3;
            }
            Comparable comparable = (Comparable)object;
            while (n > 0 && comparable.compareTo(this.buffer[n2 = n - 1 >>> 1]) < 0) {
                this.buffer[n] = this.buffer[n2];
                n = n2;
            }
            n2 = n;
            return n2;
        }
        finally {
            this.buffer[n] = object;
        }
    }

    public boolean add(Object object) {
        return this.offer(object);
    }

    public Object remove() {
        if (this.size == 0) {
            throw new NoSuchElementException();
        }
        Object object = this.buffer[0];
        ++this.modCount;
        --this.size;
        this.percolateDown(0, this.buffer[this.size]);
        this.buffer[this.size] = null;
        return object;
    }

    public Object element() {
        if (this.size == 0) {
            throw new NoSuchElementException();
        }
        return this.buffer[0];
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public boolean contains(Object object) {
        for (int i2 = 0; i2 < this.size; ++i2) {
            if (!object.equals(this.buffer[i2])) continue;
            return true;
        }
        return false;
    }

    public Object[] toArray() {
        return Arrays.copyOf(this.buffer, this.size, array$Ljava$lang$Object == null ? (array$Ljava$lang$Object = PriorityQueue.class$("[Ljava.lang.Object;")) : array$Ljava$lang$Object);
    }

    public Object[] toArray(Object[] objectArray) {
        if (objectArray.length < this.size) {
            return Arrays.copyOf(this.buffer, this.size, objectArray.getClass());
        }
        System.arraycopy((Object)this.buffer, 0, (Object)objectArray, 0, this.size);
        if (objectArray.length > this.size) {
            objectArray[this.size] = null;
        }
        return objectArray;
    }

    public boolean remove(Object object) {
        if (object == null) {
            return false;
        }
        if (this.comparator != null) {
            for (int i2 = 0; i2 < this.size; ++i2) {
                if (this.comparator.compare(this.buffer[i2], object) != 0) continue;
                this.removeAt(i2);
                return true;
            }
        } else {
            for (int i3 = 0; i3 < this.size; ++i3) {
                if (((Comparable)this.buffer[i3]).compareTo(object) != 0) continue;
                this.removeAt(i3);
                return true;
            }
        }
        return false;
    }

    private Object removeAt(int n) {
        if (!$assertionsDisabled && n >= this.size) {
            throw new AssertionError();
        }
        ++this.modCount;
        --this.size;
        Object object = this.buffer[this.size];
        this.buffer[this.size] = null;
        int n2 = this.percolateDown(n, object);
        if (n2 != n) {
            return null;
        }
        n2 = this.percolateUp(n, object);
        return n2 < n ? object : null;
    }

    public void clear() {
        ++this.modCount;
        Arrays.fill(this.buffer, 0, this.size, null);
        this.size = 0;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(this.buffer.length);
        for (int i2 = 0; i2 < this.size; ++i2) {
            objectOutputStream.writeObject(this.buffer[i2]);
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.buffer = new Object[objectInputStream.readInt()];
        for (int i2 = 0; i2 < this.size; ++i2) {
            this.buffer[i2] = objectInputStream.readObject();
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
        $assertionsDisabled = !(class$edu$emory$mathcs$backport$java$util$PriorityQueue == null ? (class$edu$emory$mathcs$backport$java$util$PriorityQueue = PriorityQueue.class$("edu.emory.mathcs.backport.java.util.PriorityQueue")) : class$edu$emory$mathcs$backport$java$util$PriorityQueue).desiredAssertionStatus();
    }

    private class Itr
    implements Iterator {
        int cursor = 0;
        List percolatedElems;
        int cursorPercolated = 0;
        int expectedModCount = PriorityQueue.access$000(PriorityQueue.this);
        int lastRet;
        Object lastRetPercolated;

        Itr() {
        }

        public boolean hasNext() {
            return this.cursor < PriorityQueue.this.size || this.percolatedElems != null;
        }

        public Object next() {
            this.checkForComodification();
            if (this.cursor < PriorityQueue.this.size) {
                this.lastRet = this.cursor++;
                return PriorityQueue.this.buffer[this.lastRet];
            }
            if (this.percolatedElems != null) {
                this.lastRet = -1;
                this.lastRetPercolated = this.percolatedElems.remove(this.percolatedElems.size() - 1);
                if (this.percolatedElems.isEmpty()) {
                    this.percolatedElems = null;
                }
                return this.lastRetPercolated;
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            if (this.lastRet >= 0) {
                Object object = PriorityQueue.this.removeAt(this.lastRet);
                this.lastRet = -1;
                if (object == null) {
                    --this.cursor;
                } else {
                    if (this.percolatedElems == null) {
                        this.percolatedElems = new ArrayList();
                    }
                    this.percolatedElems.add(object);
                }
            } else if (this.lastRetPercolated != null) {
                PriorityQueue.this.remove(this.lastRetPercolated);
                this.lastRetPercolated = null;
            } else {
                throw new IllegalStateException();
            }
            this.expectedModCount = PriorityQueue.this.modCount;
        }

        private void checkForComodification() {
            if (this.expectedModCount != PriorityQueue.this.modCount) {
                throw new ConcurrentModificationException();
            }
        }
    }
}

