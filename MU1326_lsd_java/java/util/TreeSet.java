/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.MapEntry;
import java.util.NoSuchElementException;
import java.util.SortedSet;
import java.util.TreeMap;

public class TreeSet
extends AbstractSet
implements SortedSet,
Cloneable,
Serializable {
    private static final long serialVersionUID = -2479143000061671589L;
    private transient TreeMap backingMap;

    public TreeSet() {
        this.backingMap = new TreeMap();
    }

    public TreeSet(Collection collection) {
        this();
        this.addAll(collection);
    }

    public TreeSet(Comparator comparator) {
        this.backingMap = new TreeMap(comparator);
    }

    public TreeSet(SortedSet sortedSet) {
        this(sortedSet.comparator());
        Iterator iterator = sortedSet.iterator();
        if (iterator.hasNext()) {
            TreeMap.Entry entry;
            Object object = iterator.next();
            this.backingMap.root = entry = new TreeMap.Entry(object, object);
            this.backingMap.size = 1;
            while (iterator.hasNext()) {
                object = iterator.next();
                TreeMap.Entry entry2 = new TreeMap.Entry(object, object);
                entry2.parent = entry;
                entry.right = entry2;
                ++this.backingMap.size;
                this.backingMap.balance(entry2);
                entry = entry2;
            }
        }
    }

    public boolean add(Object object) {
        return this.backingMap.put(object, object) == null;
    }

    public boolean addAll(Collection collection) {
        return super.addAll(collection);
    }

    public void clear() {
        this.backingMap.clear();
    }

    public Object clone() {
        try {
            TreeSet treeSet = (TreeSet)super.clone();
            treeSet.backingMap = (TreeMap)this.backingMap.clone();
            return treeSet;
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            return null;
        }
    }

    public Comparator comparator() {
        return this.backingMap.comparator();
    }

    public boolean contains(Object object) {
        return this.backingMap.containsKey(object);
    }

    public Object first() {
        return this.backingMap.firstKey();
    }

    public SortedSet headSet(Object object) {
        Comparator comparator = this.backingMap.comparator();
        if (comparator == null) {
            ((Comparable)object).compareTo(object);
        } else {
            comparator.compare(object, object);
        }
        return new SubSet(this.backingMap, object);
    }

    public boolean isEmpty() {
        return this.backingMap.isEmpty();
    }

    public Iterator iterator() {
        return this.backingMap.keySet().iterator();
    }

    public Object last() {
        return this.backingMap.lastKey();
    }

    public boolean remove(Object object) {
        return this.backingMap.remove(object) != null;
    }

    public int size() {
        return this.backingMap.size();
    }

    public SortedSet subSet(Object object, Object object2) {
        Comparator comparator = this.backingMap.comparator();
        if (comparator == null ? ((Comparable)object).compareTo(object2) <= 0 : comparator.compare(object, object2) <= 0) {
            return new SubSet(object, this.backingMap, object2);
        }
        throw new IllegalArgumentException();
    }

    public SortedSet tailSet(Object object) {
        Comparator comparator = this.backingMap.comparator();
        if (comparator == null) {
            ((Comparable)object).compareTo(object);
        } else {
            comparator.compare(object, object);
        }
        return new SubSet(object, this.backingMap);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.backingMap.comparator());
        objectOutputStream.writeInt(this.backingMap.size);
        if (this.backingMap.size > 0) {
            TreeMap.Entry entry = TreeMap.minimum(this.backingMap.root);
            while (entry != null) {
                objectOutputStream.writeObject(entry.key);
                entry = TreeMap.successor(entry);
            }
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.backingMap = new TreeMap((Comparator)objectInputStream.readObject());
        this.backingMap.size = objectInputStream.readInt();
        TreeMap.Entry entry = null;
        int n = this.backingMap.size;
        while (--n >= 0) {
            TreeMap.Entry entry2 = new TreeMap.Entry(objectInputStream.readObject());
            entry2.value = this;
            if (entry == null) {
                this.backingMap.root = entry2;
            } else {
                entry2.parent = entry;
                entry.right = entry2;
                this.backingMap.balance(entry2);
            }
            entry = entry2;
        }
    }

    private static final class SubSet
    extends TreeMap.SubMap.SubMapSet
    implements SortedSet {
        SubSet(TreeMap treeMap) {
            super(treeMap, new MapEntry.Type(){

                public Object get(MapEntry mapEntry) {
                    return mapEntry.key;
                }
            });
        }

        SubSet(Object object, TreeMap treeMap) {
            this(treeMap);
            this.hasStart = true;
            this.startKey = object;
        }

        SubSet(Object object, TreeMap treeMap, Object object2) {
            this(treeMap);
            this.hasEnd = true;
            this.hasStart = true;
            this.startKey = object;
            this.endKey = object2;
        }

        SubSet(TreeMap treeMap, Object object) {
            this(treeMap);
            this.hasEnd = true;
            this.endKey = object;
        }

        public boolean add(Object object) {
            this.checkRange(object);
            return this.backingMap.put(object, object) != null;
        }

        public Comparator comparator() {
            return this.backingMap.comparator();
        }

        public boolean contains(Object object) {
            if (this.checkRange(object, this.hasStart, this.hasEnd)) {
                return this.backingMap.containsKey(object);
            }
            return false;
        }

        public Object first() {
            if (!this.hasStart) {
                return this.backingMap.firstKey();
            }
            TreeMap.Entry entry = this.backingMap.findAfter(this.startKey);
            if (entry != null && this.checkRange(entry.key, false, this.hasEnd)) {
                return entry.key;
            }
            throw new NoSuchElementException();
        }

        public SortedSet headSet(Object object) {
            this.checkRange(object);
            if (this.hasStart) {
                return new SubSet(this.startKey, this.backingMap, object);
            }
            return new SubSet(this.backingMap, object);
        }

        public Object last() {
            if (!this.hasEnd) {
                return this.backingMap.lastKey();
            }
            TreeMap.Entry entry = this.backingMap.findBefore(this.endKey);
            if (entry != null && this.checkRange(entry.key, this.hasStart, false)) {
                return entry.key;
            }
            throw new NoSuchElementException();
        }

        public boolean remove(Object object) {
            if (this.checkRange(object, this.hasStart, this.hasEnd)) {
                return this.backingMap.remove(object) != null;
            }
            return false;
        }

        public SortedSet subSet(Object object, Object object2) {
            this.checkRange(object);
            this.checkRange(object2);
            Comparator comparator = this.backingMap.comparator();
            if (comparator == null ? ((Comparable)this.startKey).compareTo(this.endKey) <= 0 : comparator.compare(this.startKey, this.endKey) <= 0) {
                return new SubSet(object, this.backingMap, object2);
            }
            throw new IllegalArgumentException();
        }

        public SortedSet tailSet(Object object) {
            this.checkRange(object);
            if (this.hasEnd) {
                return new SubSet(object, this.backingMap, this.endKey);
            }
            return new SubSet(object, this.backingMap);
        }
    }
}

