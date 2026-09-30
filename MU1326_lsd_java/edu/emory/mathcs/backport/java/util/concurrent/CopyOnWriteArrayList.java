/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util.concurrent;

import edu.emory.mathcs.backport.java.util.Arrays;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;

public class CopyOnWriteArrayList
implements List,
RandomAccess,
Cloneable,
Serializable {
    private static final long serialVersionUID = 8673264195747942595L;
    private volatile transient Object[] array;
    static /* synthetic */ Class array$Ljava$lang$Object;

    public CopyOnWriteArrayList() {
        this.setArray(new Object[0]);
    }

    public CopyOnWriteArrayList(Collection collection) {
        Object[] objectArray = collection.toArray();
        if (objectArray.getClass() != (array$Ljava$lang$Object == null ? (array$Ljava$lang$Object = CopyOnWriteArrayList.class$("[Ljava.lang.Object;")) : array$Ljava$lang$Object)) {
            objectArray = Arrays.copyOf(objectArray, objectArray.length, array$Ljava$lang$Object == null ? (array$Ljava$lang$Object = CopyOnWriteArrayList.class$("[Ljava.lang.Object;")) : array$Ljava$lang$Object);
        }
        this.setArray(objectArray);
    }

    public CopyOnWriteArrayList(Object[] objectArray) {
        this.setArray(Arrays.copyOf(objectArray, objectArray.length, array$Ljava$lang$Object == null ? (array$Ljava$lang$Object = CopyOnWriteArrayList.class$("[Ljava.lang.Object;")) : array$Ljava$lang$Object));
    }

    final Object[] getArray() {
        return this.array;
    }

    final void setArray(Object[] objectArray) {
        this.array = objectArray;
    }

    public int size() {
        return this.getArray().length;
    }

    public boolean isEmpty() {
        return this.getArray().length == 0;
    }

    private static int search(Object[] objectArray, Object object, int n, int n2) {
        if (object == null) {
            while (n < n2) {
                if (objectArray[n] == null) {
                    return n;
                }
                ++n;
            }
        } else {
            while (n < n2) {
                if (object.equals(objectArray[n])) {
                    return n;
                }
                ++n;
            }
        }
        return -1;
    }

    private static int reverseSearch(Object[] objectArray, Object object, int n, int n2) {
        if (object == null) {
            --n2;
            while (n2 >= n) {
                if (objectArray[n2] == null) {
                    return n2;
                }
                --n2;
            }
        } else {
            --n2;
            while (n2 >= n) {
                if (object.equals(objectArray[n2])) {
                    return n2;
                }
                --n2;
            }
        }
        return -1;
    }

    public boolean contains(Object object) {
        Object[] objectArray = this.getArray();
        return CopyOnWriteArrayList.search(objectArray, object, 0, objectArray.length) >= 0;
    }

    public Iterator iterator() {
        return new COWIterator(this.getArray(), 0);
    }

    public Object[] toArray() {
        Object[] objectArray = this.getArray();
        return Arrays.copyOf(objectArray, objectArray.length, array$Ljava$lang$Object == null ? (array$Ljava$lang$Object = CopyOnWriteArrayList.class$("[Ljava.lang.Object;")) : array$Ljava$lang$Object);
    }

    public Object[] toArray(Object[] objectArray) {
        Object[] objectArray2 = this.getArray();
        int n = objectArray2.length;
        if (objectArray.length < n) {
            return Arrays.copyOf(objectArray2, n, objectArray.getClass());
        }
        System.arraycopy((Object)objectArray2, 0, (Object)objectArray, 0, n);
        if (objectArray.length > n) {
            objectArray[n] = null;
        }
        return objectArray;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean add(Object object) {
        CopyOnWriteArrayList copyOnWriteArrayList = this;
        synchronized (copyOnWriteArrayList) {
            Object[] objectArray = this.getArray();
            int n = objectArray.length;
            Object[] objectArray2 = new Object[n + 1];
            System.arraycopy((Object)objectArray, 0, (Object)objectArray2, 0, n);
            objectArray2[n] = object;
            this.setArray(objectArray2);
            return true;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean addIfAbsent(Object object) {
        CopyOnWriteArrayList copyOnWriteArrayList = this;
        synchronized (copyOnWriteArrayList) {
            Object[] objectArray = this.getArray();
            int n = objectArray.length;
            if (CopyOnWriteArrayList.search(this.array, object, 0, n) >= 0) {
                return false;
            }
            Object[] objectArray2 = new Object[n + 1];
            System.arraycopy((Object)objectArray, 0, (Object)objectArray2, 0, n);
            objectArray2[n] = object;
            this.setArray(objectArray2);
            return true;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public int addAllAbsent(Collection collection) {
        Object[] objectArray = collection.toArray();
        if (objectArray.length == 0) {
            return 0;
        }
        CopyOnWriteArrayList copyOnWriteArrayList = this;
        synchronized (copyOnWriteArrayList) {
            Object[] objectArray2 = this.getArray();
            int n = objectArray2.length;
            Object[] objectArray3 = new Object[objectArray.length];
            int n2 = 0;
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                Object object = objectArray[i2];
                if (CopyOnWriteArrayList.search(objectArray2, object, 0, n) >= 0 || CopyOnWriteArrayList.search(objectArray3, object, 0, n2) >= 0) continue;
                objectArray3[n2++] = object;
            }
            if (n2 == 0) {
                return 0;
            }
            Object[] objectArray4 = new Object[n + n2];
            System.arraycopy((Object)objectArray2, 0, (Object)objectArray4, 0, n);
            System.arraycopy((Object)objectArray3, 0, (Object)objectArray4, n, n2);
            this.setArray(objectArray4);
            return n2;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean remove(Object object) {
        CopyOnWriteArrayList copyOnWriteArrayList = this;
        synchronized (copyOnWriteArrayList) {
            Object[] objectArray = this.getArray();
            int n = objectArray.length;
            int n2 = CopyOnWriteArrayList.search(objectArray, object, 0, n);
            if (n2 < 0) {
                return false;
            }
            Object[] objectArray2 = new Object[n - 1];
            int n3 = n - n2 - 1;
            if (n2 > 0) {
                System.arraycopy((Object)objectArray, 0, (Object)objectArray2, 0, n2);
            }
            if (n3 > 0) {
                System.arraycopy((Object)objectArray, n2 + 1, (Object)objectArray2, n2, n3);
            }
            this.setArray(objectArray2);
            return true;
        }
    }

    public boolean containsAll(Collection collection) {
        Object[] objectArray = this.getArray();
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            if (CopyOnWriteArrayList.search(objectArray, iterator.next(), 0, objectArray.length) >= 0) continue;
            return false;
        }
        return true;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean addAll(Collection collection) {
        Object[] objectArray = collection.toArray();
        if (objectArray.length == 0) {
            return false;
        }
        CopyOnWriteArrayList copyOnWriteArrayList = this;
        synchronized (copyOnWriteArrayList) {
            Object[] objectArray2 = this.getArray();
            int n = objectArray2.length;
            Object[] objectArray3 = new Object[n + objectArray.length];
            System.arraycopy((Object)objectArray2, 0, (Object)objectArray3, 0, n);
            int n2 = n;
            System.arraycopy((Object)objectArray, 0, (Object)objectArray3, n2, objectArray.length);
            this.setArray(objectArray3);
            return true;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean addAll(int n, Collection collection) {
        Object[] objectArray = collection.toArray();
        CopyOnWriteArrayList copyOnWriteArrayList = this;
        synchronized (copyOnWriteArrayList) {
            Object[] objectArray2 = this.getArray();
            int n2 = objectArray2.length;
            if (n < 0 || n > n2) {
                throw new IndexOutOfBoundsException(new StringBuffer().append("Index: ").append(n).append(", Size: ").append(n2).toString());
            }
            if (objectArray.length == 0) {
                return false;
            }
            Object[] objectArray3 = new Object[n2 + objectArray.length];
            int n3 = n2 - n;
            System.arraycopy((Object)objectArray2, 0, (Object)objectArray3, 0, n);
            int n4 = n2;
            System.arraycopy((Object)objectArray, 0, (Object)objectArray3, n, objectArray.length);
            if (n3 > 0) {
                System.arraycopy((Object)objectArray2, n, (Object)objectArray3, n + objectArray.length, n3);
            }
            this.setArray(objectArray3);
            return true;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean removeAll(Collection collection) {
        if (collection.isEmpty()) {
            return false;
        }
        CopyOnWriteArrayList copyOnWriteArrayList = this;
        synchronized (copyOnWriteArrayList) {
            Object[] objectArray = this.getArray();
            int n = objectArray.length;
            Object[] objectArray2 = new Object[n];
            int n2 = 0;
            for (int i2 = 0; i2 < n; ++i2) {
                Object object = objectArray[i2];
                if (collection.contains(object)) continue;
                objectArray2[n2++] = object;
            }
            if (n2 == n) {
                return false;
            }
            Object[] objectArray3 = new Object[n2];
            System.arraycopy((Object)objectArray2, 0, (Object)objectArray3, 0, n2);
            this.setArray(objectArray3);
            return true;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean retainAll(Collection collection) {
        CopyOnWriteArrayList copyOnWriteArrayList = this;
        synchronized (copyOnWriteArrayList) {
            Object[] objectArray = this.getArray();
            int n = objectArray.length;
            Object[] objectArray2 = new Object[n];
            int n2 = 0;
            for (int i2 = 0; i2 < n; ++i2) {
                Object object = objectArray[i2];
                if (!collection.contains(object)) continue;
                objectArray2[n2++] = object;
            }
            if (n2 == n) {
                return false;
            }
            Object[] objectArray3 = new Object[n2];
            System.arraycopy((Object)objectArray2, 0, (Object)objectArray3, 0, n2);
            this.setArray(objectArray3);
            return true;
        }
    }

    public void clear() {
        this.setArray(new Object[0]);
    }

    public Object clone() {
        try {
            return super.clone();
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            throw new InternalError();
        }
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof List)) {
            return false;
        }
        ListIterator listIterator = ((List)object).listIterator();
        Object[] objectArray = this.getArray();
        int n = objectArray.length;
        int n2 = 0;
        while (n2 < n && listIterator.hasNext()) {
            Object object2;
            Object object3 = listIterator.next();
            if (CopyOnWriteArrayList.eq(object2 = objectArray[n2++], object3)) continue;
            return false;
        }
        return n2 == n && !listIterator.hasNext();
    }

    public int hashCode() {
        int n = 1;
        for (Object object : this.getArray()) {
            n = 31 * n + (object == null ? 0 : object.hashCode());
        }
        return n;
    }

    public Object get(int n) {
        return this.getArray()[n];
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public Object set(int n, Object object) {
        CopyOnWriteArrayList copyOnWriteArrayList = this;
        synchronized (copyOnWriteArrayList) {
            Object[] objectArray = this.getArray();
            int n2 = objectArray.length;
            Object object2 = objectArray[n];
            if (object2 == object) {
                this.setArray(objectArray);
            } else {
                Object[] objectArray2 = new Object[n2];
                System.arraycopy((Object)objectArray, 0, (Object)objectArray2, 0, n2);
                objectArray2[n] = object;
                this.setArray(objectArray2);
            }
            return object2;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void add(int n, Object object) {
        CopyOnWriteArrayList copyOnWriteArrayList = this;
        synchronized (copyOnWriteArrayList) {
            Object[] objectArray = this.getArray();
            int n2 = objectArray.length;
            if (n < 0 || n > n2) {
                throw new IndexOutOfBoundsException(new StringBuffer().append("Index: ").append(n).append(", Size: ").append(n2).toString());
            }
            Object[] objectArray2 = new Object[n2 + 1];
            int n3 = n2 - n;
            System.arraycopy((Object)objectArray, 0, (Object)objectArray2, 0, n);
            objectArray2[n] = object;
            if (n3 > 0) {
                System.arraycopy((Object)objectArray, n, (Object)objectArray2, n + 1, n3);
            }
            this.setArray(objectArray2);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public Object remove(int n) {
        CopyOnWriteArrayList copyOnWriteArrayList = this;
        synchronized (copyOnWriteArrayList) {
            Object[] objectArray = this.getArray();
            int n2 = objectArray.length;
            if (n < 0 || n >= n2) {
                throw new IndexOutOfBoundsException(new StringBuffer().append("Index: ").append(n).append(", Size: ").append(n2).toString());
            }
            Object object = objectArray[n];
            Object[] objectArray2 = new Object[n2 - 1];
            int n3 = n2 - n - 1;
            if (n > 0) {
                System.arraycopy((Object)objectArray, 0, (Object)objectArray2, 0, n);
            }
            if (n3 > 0) {
                System.arraycopy((Object)objectArray, n + 1, (Object)objectArray2, n, n3);
            }
            this.setArray(objectArray2);
            return object;
        }
    }

    public int indexOf(Object object) {
        Object[] objectArray = this.getArray();
        return CopyOnWriteArrayList.search(objectArray, object, 0, objectArray.length);
    }

    public int indexOf(Object object, int n) {
        Object[] objectArray = this.getArray();
        return CopyOnWriteArrayList.search(objectArray, object, n, objectArray.length);
    }

    public int lastIndexOf(Object object) {
        Object[] objectArray = this.getArray();
        return CopyOnWriteArrayList.reverseSearch(objectArray, object, 0, objectArray.length);
    }

    public int lastIndexOf(Object object, int n) {
        Object[] objectArray = this.getArray();
        return CopyOnWriteArrayList.reverseSearch(objectArray, object, 0, n);
    }

    public ListIterator listIterator() {
        return new COWIterator(this.getArray(), 0);
    }

    public ListIterator listIterator(int n) {
        Object[] objectArray = this.getArray();
        if (n < 0 || n > objectArray.length) {
            throw new IndexOutOfBoundsException(new StringBuffer().append("Index: ").append(n).append(", Size: ").append(objectArray.length).toString());
        }
        return new COWIterator(objectArray, n);
    }

    public List subList(int n, int n2) {
        Object[] objectArray = this.getArray();
        if (n < 0 || n2 > objectArray.length || n > n2) {
            throw new IndexOutOfBoundsException();
        }
        return new COWSubList(n, n2 - n);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        Object[] objectArray = this.getArray();
        int n = objectArray.length;
        objectOutputStream.writeInt(n);
        for (int i2 = 0; i2 < n; ++i2) {
            objectOutputStream.writeObject(objectArray[i2]);
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        int n = objectInputStream.readInt();
        Object[] objectArray = new Object[n];
        for (int i2 = 0; i2 < n; ++i2) {
            objectArray[i2] = objectInputStream.readObject();
        }
        this.setArray(objectArray);
    }

    public String toString() {
        Object[] objectArray = this.getArray();
        int n = objectArray.length;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append('[');
        for (int i2 = 0; i2 < n; ++i2) {
            if (i2 > 0) {
                stringBuffer.append(", ");
            }
            stringBuffer.append(objectArray[i2]);
        }
        stringBuffer.append(']');
        return stringBuffer.toString();
    }

    private static boolean eq(Object object, Object object2) {
        return object == null ? object2 == null : object.equals(object2);
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    class COWSubList
    implements Serializable,
    List {
        private static final long serialVersionUID = -8660955369431018984L;
        final int offset;
        int length;
        transient Object[] expectedArray;

        COWSubList(int n, int n2) {
            this.offset = n;
            this.length = n2;
            this.expectedArray = CopyOnWriteArrayList.this.getArray();
        }

        public int size() {
            return this.length;
        }

        public boolean isEmpty() {
            return this.length == 0;
        }

        public boolean contains(Object object) {
            return CopyOnWriteArrayList.search(CopyOnWriteArrayList.this.getArray(), object, this.offset, this.offset + this.length) >= 0;
        }

        public Iterator iterator() {
            return this.listIterator();
        }

        public Object[] toArray() {
            Object[] objectArray = CopyOnWriteArrayList.this.getArray();
            Object[] objectArray2 = new Object[this.length];
            System.arraycopy((Object)objectArray, this.offset, (Object)objectArray2, 0, this.length);
            return objectArray2;
        }

        public Object[] toArray(Object[] objectArray) {
            Object[] objectArray2 = CopyOnWriteArrayList.this.getArray();
            if (objectArray.length < this.length) {
                objectArray = (Object[])Array.newInstance(objectArray.getClass().getComponentType(), this.length);
                System.arraycopy((Object)objectArray2, this.offset, (Object)objectArray, 0, this.length);
            } else {
                System.arraycopy((Object)objectArray2, this.offset, (Object)objectArray, 0, this.length);
                if (objectArray.length > this.length) {
                    objectArray[this.length] = null;
                }
            }
            return objectArray;
        }

        public boolean add(Object object) {
            this.add(this.length, object);
            return true;
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public boolean remove(Object object) {
            CopyOnWriteArrayList copyOnWriteArrayList = CopyOnWriteArrayList.this;
            synchronized (copyOnWriteArrayList) {
                Object[] objectArray = CopyOnWriteArrayList.this.getArray();
                if (objectArray != this.expectedArray) {
                    throw new ConcurrentModificationException();
                }
                int n = objectArray.length;
                int n2 = CopyOnWriteArrayList.search(objectArray, object, this.offset, this.length);
                if (n2 < 0) {
                    return false;
                }
                Object[] objectArray2 = new Object[n - 1];
                int n3 = this.length - n2 - 1;
                if (n2 > 0) {
                    System.arraycopy((Object)objectArray, 0, (Object)objectArray2, 0, n2);
                }
                if (n3 > 0) {
                    System.arraycopy((Object)objectArray, n2 + 1, (Object)objectArray2, n2, n3);
                }
                CopyOnWriteArrayList.this.setArray(objectArray2);
                this.expectedArray = objectArray2;
                --this.length;
                return true;
            }
        }

        public boolean containsAll(Collection collection) {
            Object[] objectArray = CopyOnWriteArrayList.this.getArray();
            Iterator iterator = collection.iterator();
            while (iterator.hasNext()) {
                if (CopyOnWriteArrayList.search(objectArray, iterator.next(), this.offset, this.length) >= 0) continue;
                return false;
            }
            return true;
        }

        public boolean addAll(Collection collection) {
            return this.addAll(this.length, collection);
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public boolean addAll(int n, Collection collection) {
            int n2 = collection.size();
            CopyOnWriteArrayList copyOnWriteArrayList = CopyOnWriteArrayList.this;
            synchronized (copyOnWriteArrayList) {
                int n3;
                if (n < 0 || n >= this.length) {
                    throw new IndexOutOfBoundsException(new StringBuffer().append("Index: ").append(n).append(", Size: ").append(this.length).toString());
                }
                Object[] objectArray = CopyOnWriteArrayList.this.getArray();
                if (objectArray != this.expectedArray) {
                    throw new ConcurrentModificationException();
                }
                if (n2 == 0) {
                    return false;
                }
                int n4 = objectArray.length;
                Object[] objectArray2 = new Object[n4 + n2];
                int n5 = n3 = this.offset + n;
                System.arraycopy((Object)objectArray, 0, (Object)objectArray2, 0, n3);
                int n6 = n4 - n3;
                Iterator iterator = collection.iterator();
                while (iterator.hasNext()) {
                    objectArray2[n5++] = iterator.next();
                }
                if (n6 > 0) {
                    System.arraycopy((Object)objectArray, n3, (Object)objectArray2, n5, n6);
                }
                CopyOnWriteArrayList.this.setArray(objectArray2);
                this.expectedArray = objectArray2;
                this.length += n2;
                return true;
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public boolean removeAll(Collection collection) {
            if (collection.isEmpty()) {
                return false;
            }
            CopyOnWriteArrayList copyOnWriteArrayList = CopyOnWriteArrayList.this;
            synchronized (copyOnWriteArrayList) {
                Object[] objectArray = CopyOnWriteArrayList.this.getArray();
                if (objectArray != this.expectedArray) {
                    throw new ConcurrentModificationException();
                }
                int n = objectArray.length;
                Object[] objectArray2 = new Object[this.length];
                int n2 = 0;
                for (int i2 = this.offset; i2 < this.offset + this.length; ++i2) {
                    Object object = objectArray[i2];
                    if (collection.contains(object)) continue;
                    objectArray2[n2++] = object;
                }
                if (n2 == this.length) {
                    return false;
                }
                Object[] objectArray3 = new Object[n + n2 - this.length];
                int n3 = n - this.offset - this.length;
                if (this.offset > 0) {
                    System.arraycopy((Object)objectArray, 0, (Object)objectArray3, 0, this.offset);
                }
                if (n2 > 0) {
                    System.arraycopy((Object)objectArray2, 0, (Object)objectArray3, this.offset, n2);
                }
                if (n3 > 0) {
                    System.arraycopy((Object)objectArray, this.offset + this.length, (Object)objectArray3, this.offset + n2, n3);
                }
                CopyOnWriteArrayList.this.setArray(objectArray3);
                this.expectedArray = objectArray3;
                this.length = n2;
                return true;
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public boolean retainAll(Collection collection) {
            CopyOnWriteArrayList copyOnWriteArrayList = CopyOnWriteArrayList.this;
            synchronized (copyOnWriteArrayList) {
                Object[] objectArray = CopyOnWriteArrayList.this.getArray();
                if (objectArray != this.expectedArray) {
                    throw new ConcurrentModificationException();
                }
                int n = objectArray.length;
                Object[] objectArray2 = new Object[this.length];
                int n2 = 0;
                for (int i2 = this.offset; i2 < this.offset + this.length; ++i2) {
                    Object object = objectArray[i2];
                    if (!collection.contains(object)) continue;
                    objectArray2[n2++] = object;
                }
                if (n2 == this.length) {
                    return false;
                }
                Object[] objectArray3 = new Object[n + n2 - this.length];
                int n3 = n - this.offset - this.length;
                if (this.offset > 0) {
                    System.arraycopy((Object)objectArray, 0, (Object)objectArray3, 0, this.offset);
                }
                if (n2 > 0) {
                    System.arraycopy((Object)objectArray2, 0, (Object)objectArray3, this.offset, n2);
                }
                if (n3 > 0) {
                    System.arraycopy((Object)objectArray, this.offset + this.length, (Object)objectArray3, this.offset + n2, n3);
                }
                CopyOnWriteArrayList.this.setArray(objectArray3);
                this.expectedArray = objectArray3;
                this.length = n2;
                return true;
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void clear() {
            CopyOnWriteArrayList copyOnWriteArrayList = CopyOnWriteArrayList.this;
            synchronized (copyOnWriteArrayList) {
                Object[] objectArray = CopyOnWriteArrayList.this.getArray();
                if (objectArray != this.expectedArray) {
                    throw new ConcurrentModificationException();
                }
                int n = objectArray.length;
                Object[] objectArray2 = new Object[n - this.length];
                int n2 = n - this.offset - this.length;
                if (this.offset > 0) {
                    System.arraycopy((Object)objectArray, 0, (Object)objectArray2, 0, this.offset);
                }
                if (n2 > 0) {
                    System.arraycopy((Object)objectArray, this.offset + this.length, (Object)objectArray2, this.offset, n2);
                }
                CopyOnWriteArrayList.this.setArray(objectArray2);
                this.expectedArray = objectArray2;
                this.length = 0;
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public boolean equals(Object object) {
            int n;
            Object[] objectArray;
            if (object == this) {
                return true;
            }
            if (!(object instanceof List)) {
                return false;
            }
            Object object2 = CopyOnWriteArrayList.this;
            synchronized (object2) {
                objectArray = CopyOnWriteArrayList.this.getArray();
                if (objectArray != this.expectedArray) {
                    throw new ConcurrentModificationException();
                }
                n = this.offset + this.length;
            }
            object2 = ((List)object).listIterator();
            int n2 = this.offset;
            while (n2 < n && object2.hasNext()) {
                Object object3 = objectArray[n2];
                Object object4 = object2.next();
                if (CopyOnWriteArrayList.eq(object3, object4)) continue;
                return false;
            }
            return n2 == n && !object2.hasNext();
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public int hashCode() {
            int n;
            Object[] objectArray;
            int n2 = 1;
            CopyOnWriteArrayList copyOnWriteArrayList = CopyOnWriteArrayList.this;
            synchronized (copyOnWriteArrayList) {
                objectArray = CopyOnWriteArrayList.this.getArray();
                if (objectArray != this.expectedArray) {
                    throw new ConcurrentModificationException();
                }
                n = this.offset + this.length;
            }
            for (int i2 = this.offset; i2 < n; ++i2) {
                Object object = objectArray[i2];
                n2 = 31 * n2 + (object == null ? 0 : object.hashCode());
            }
            return n2;
        }

        public Object get(int n) {
            return CopyOnWriteArrayList.this.getArray()[this.offset + n];
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public Object set(int n, Object object) {
            CopyOnWriteArrayList copyOnWriteArrayList = CopyOnWriteArrayList.this;
            synchronized (copyOnWriteArrayList) {
                if (n < 0 || n >= this.length) {
                    throw new IndexOutOfBoundsException(new StringBuffer().append("Index: ").append(n).append(", Size: ").append(this.length).toString());
                }
                Object[] objectArray = CopyOnWriteArrayList.this.getArray();
                if (objectArray != this.expectedArray) {
                    throw new ConcurrentModificationException();
                }
                int n2 = objectArray.length;
                Object object2 = objectArray[this.offset + n];
                if (object2 == object) {
                    CopyOnWriteArrayList.this.setArray(objectArray);
                } else {
                    Object[] objectArray2 = new Object[n2];
                    System.arraycopy((Object)objectArray, 0, (Object)objectArray2, 0, n2);
                    objectArray2[this.offset + n] = object;
                    CopyOnWriteArrayList.this.setArray(objectArray2);
                    this.expectedArray = objectArray2;
                }
                return object2;
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void add(int n, Object object) {
            CopyOnWriteArrayList copyOnWriteArrayList = CopyOnWriteArrayList.this;
            synchronized (copyOnWriteArrayList) {
                if (n < 0 || n > this.length) {
                    throw new IndexOutOfBoundsException(new StringBuffer().append("Index: ").append(n).append(", Size: ").append(this.length).toString());
                }
                Object[] objectArray = CopyOnWriteArrayList.this.getArray();
                if (objectArray != this.expectedArray) {
                    throw new ConcurrentModificationException();
                }
                int n2 = objectArray.length;
                Object[] objectArray2 = new Object[n2 + 1];
                int n3 = this.offset + n;
                int n4 = n2 - n3;
                System.arraycopy((Object)objectArray, 0, (Object)objectArray2, 0, n3);
                objectArray2[n3] = object;
                if (n4 > 0) {
                    System.arraycopy((Object)objectArray, n3, (Object)objectArray2, n3 + 1, n4);
                }
                CopyOnWriteArrayList.this.setArray(objectArray2);
                this.expectedArray = objectArray2;
                ++this.length;
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public Object remove(int n) {
            CopyOnWriteArrayList copyOnWriteArrayList = CopyOnWriteArrayList.this;
            synchronized (copyOnWriteArrayList) {
                if (n < 0 || n >= this.length) {
                    throw new IndexOutOfBoundsException(new StringBuffer().append("Index: ").append(n).append(", Size: ").append(this.length).toString());
                }
                Object[] objectArray = CopyOnWriteArrayList.this.getArray();
                if (objectArray != this.expectedArray) {
                    throw new ConcurrentModificationException();
                }
                int n2 = objectArray.length;
                int n3 = this.offset + n;
                Object object = objectArray[n3];
                Object[] objectArray2 = new Object[n2 - 1];
                int n4 = n2 - n3 - 1;
                if (n > 0) {
                    System.arraycopy((Object)objectArray, 0, (Object)objectArray2, 0, n3);
                }
                if (n4 > 0) {
                    System.arraycopy((Object)objectArray, n3 + 1, (Object)objectArray2, n3, n4);
                }
                CopyOnWriteArrayList.this.setArray(objectArray2);
                this.expectedArray = objectArray2;
                --this.length;
                return object;
            }
        }

        public int indexOf(Object object) {
            int n = CopyOnWriteArrayList.search(CopyOnWriteArrayList.this.getArray(), object, this.offset, this.offset + this.length);
            return n >= 0 ? n - this.offset : -1;
        }

        public int indexOf(Object object, int n) {
            int n2 = CopyOnWriteArrayList.search(CopyOnWriteArrayList.this.getArray(), object, this.offset + n, this.offset + this.length) - this.offset;
            return n2 >= 0 ? n2 - this.offset : -1;
        }

        public int lastIndexOf(Object object) {
            int n = CopyOnWriteArrayList.reverseSearch(CopyOnWriteArrayList.this.getArray(), object, this.offset, this.offset + this.length) - this.offset;
            return n >= 0 ? n - this.offset : -1;
        }

        public int lastIndexOf(Object object, int n) {
            int n2 = CopyOnWriteArrayList.reverseSearch(CopyOnWriteArrayList.this.getArray(), object, this.offset, this.offset + n) - this.offset;
            return n2 >= 0 ? n2 - this.offset : -1;
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public ListIterator listIterator() {
            CopyOnWriteArrayList copyOnWriteArrayList = CopyOnWriteArrayList.this;
            synchronized (copyOnWriteArrayList) {
                Object[] objectArray = CopyOnWriteArrayList.this.getArray();
                if (objectArray != this.expectedArray) {
                    throw new ConcurrentModificationException();
                }
                return new COWSubIterator(objectArray, this.offset, this.offset + this.length, this.offset);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public ListIterator listIterator(int n) {
            CopyOnWriteArrayList copyOnWriteArrayList = CopyOnWriteArrayList.this;
            synchronized (copyOnWriteArrayList) {
                if (n < 0 || n >= this.length) {
                    throw new IndexOutOfBoundsException(new StringBuffer().append("Index: ").append(n).append(", Size: ").append(this.length).toString());
                }
                Object[] objectArray = CopyOnWriteArrayList.this.getArray();
                if (objectArray != this.expectedArray) {
                    throw new ConcurrentModificationException();
                }
                return new COWSubIterator(objectArray, this.offset, this.offset + this.length, this.offset + n);
            }
        }

        public List subList(int n, int n2) {
            if (n < 0 || n2 > this.length || n > n2) {
                throw new IndexOutOfBoundsException();
            }
            return new COWSubList(this.offset + n, n2 - n);
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public String toString() {
            int n;
            Object[] objectArray;
            Serializable serializable = CopyOnWriteArrayList.this;
            synchronized (serializable) {
                objectArray = CopyOnWriteArrayList.this.getArray();
                if (objectArray != this.expectedArray) {
                    throw new ConcurrentModificationException();
                }
                n = this.offset + this.length;
            }
            serializable = new StringBuffer();
            ((StringBuffer)serializable).append('[');
            for (int i2 = this.offset; i2 < n; ++i2) {
                if (i2 > this.offset) {
                    ((StringBuffer)serializable).append(", ");
                }
                ((StringBuffer)serializable).append(objectArray[i2]);
            }
            ((StringBuffer)serializable).append(']');
            return ((StringBuffer)serializable).toString();
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            CopyOnWriteArrayList copyOnWriteArrayList = CopyOnWriteArrayList.this;
            synchronized (copyOnWriteArrayList) {
                if (CopyOnWriteArrayList.this.getArray() != this.expectedArray) {
                    throw new ConcurrentModificationException();
                }
            }
            objectOutputStream.defaultWriteObject();
            copyOnWriteArrayList = CopyOnWriteArrayList.this;
            synchronized (copyOnWriteArrayList) {
                if (CopyOnWriteArrayList.this.getArray() != this.expectedArray) {
                    throw new ConcurrentModificationException();
                }
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            objectInputStream.defaultReadObject();
            CopyOnWriteArrayList copyOnWriteArrayList = CopyOnWriteArrayList.this;
            synchronized (copyOnWriteArrayList) {
                this.expectedArray = CopyOnWriteArrayList.this.getArray();
            }
        }
    }

    static class COWIterator
    implements ListIterator {
        final Object[] array;
        int cursor;

        COWIterator(Object[] objectArray, int n) {
            this.array = objectArray;
            this.cursor = n;
        }

        public boolean hasNext() {
            return this.cursor < this.array.length;
        }

        public boolean hasPrevious() {
            return this.cursor > 0;
        }

        public int nextIndex() {
            return this.cursor;
        }

        public Object next() {
            try {
                return this.array[this.cursor++];
            }
            catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                --this.cursor;
                throw new NoSuchElementException();
            }
        }

        public int previousIndex() {
            return this.cursor - 1;
        }

        public Object previous() {
            try {
                return this.array[--this.cursor];
            }
            catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                ++this.cursor;
                throw new NoSuchElementException();
            }
        }

        public void add(Object object) {
            throw new UnsupportedOperationException();
        }

        public void set(Object object) {
            throw new UnsupportedOperationException();
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    static class COWSubIterator
    implements ListIterator {
        final Object[] array;
        int cursor;
        int first;
        int last;

        COWSubIterator(Object[] objectArray, int n, int n2, int n3) {
            this.array = objectArray;
            this.first = n;
            this.last = n2;
            this.cursor = n3;
        }

        public boolean hasNext() {
            return this.cursor < this.last;
        }

        public boolean hasPrevious() {
            return this.cursor > this.first;
        }

        public int nextIndex() {
            return this.cursor - this.first;
        }

        public Object next() {
            if (this.cursor == this.last) {
                throw new NoSuchElementException();
            }
            return this.array[this.cursor++];
        }

        public int previousIndex() {
            return this.cursor - this.first - 1;
        }

        public Object previous() {
            if (this.cursor == this.first) {
                throw new NoSuchElementException();
            }
            return this.array[--this.cursor];
        }

        public void add(Object object) {
            throw new UnsupportedOperationException();
        }

        public void set(Object object) {
            throw new UnsupportedOperationException();
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}

