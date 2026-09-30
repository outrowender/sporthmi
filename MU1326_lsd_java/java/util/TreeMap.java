/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.MapEntry;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedMap;

public class TreeMap
extends AbstractMap
implements SortedMap,
Cloneable,
Serializable {
    private static final long serialVersionUID = 919286545866124006L;
    transient int size = 0;
    transient Entry root;
    private Comparator comparator;
    transient int modCount = 0;

    public TreeMap() {
    }

    public TreeMap(Comparator comparator) {
        this.comparator = comparator;
    }

    public TreeMap(Map map) {
        this();
        this.putAll(map);
    }

    public TreeMap(SortedMap sortedMap) {
        this(sortedMap.comparator());
        Iterator iterator = sortedMap.entrySet().iterator();
        if (iterator.hasNext()) {
            Entry entry;
            Map.Entry entry2 = (Map.Entry)iterator.next();
            this.root = entry = new Entry(entry2.getKey(), entry2.getValue());
            this.size = 1;
            while (iterator.hasNext()) {
                entry2 = (Map.Entry)iterator.next();
                Entry entry3 = new Entry(entry2.getKey(), entry2.getValue());
                entry3.parent = entry;
                entry.right = entry3;
                ++this.size;
                this.balance(entry3);
                entry = entry3;
            }
        }
    }

    void balance(Entry entry) {
        entry.color = true;
        while (entry != this.root && entry.parent.color) {
            Entry entry2;
            if (entry.parent == entry.parent.parent.left) {
                entry2 = entry.parent.parent.right;
                if (entry2 != null && entry2.color) {
                    entry.parent.color = false;
                    entry2.color = false;
                    entry.parent.parent.color = true;
                    entry = entry.parent.parent;
                    continue;
                }
                if (entry == entry.parent.right) {
                    entry = entry.parent;
                    this.leftRotate(entry);
                }
                entry.parent.color = false;
                entry.parent.parent.color = true;
                this.rightRotate(entry.parent.parent);
                continue;
            }
            entry2 = entry.parent.parent.left;
            if (entry2 != null && entry2.color) {
                entry.parent.color = false;
                entry2.color = false;
                entry.parent.parent.color = true;
                entry = entry.parent.parent;
                continue;
            }
            if (entry == entry.parent.left) {
                entry = entry.parent;
                this.rightRotate(entry);
            }
            entry.parent.color = false;
            entry.parent.parent.color = true;
            this.leftRotate(entry.parent.parent);
        }
        this.root.color = false;
    }

    public void clear() {
        this.root = null;
        this.size = 0;
        ++this.modCount;
    }

    public Object clone() {
        try {
            TreeMap treeMap = (TreeMap)super.clone();
            if (this.root != null) {
                treeMap.root = this.root.clone(null);
            }
            return treeMap;
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            return null;
        }
    }

    public Comparator comparator() {
        return this.comparator;
    }

    public boolean containsKey(Object object) {
        return this.find(object) != null;
    }

    public boolean containsValue(Object object) {
        if (this.root != null) {
            return this.containsValue(this.root, object);
        }
        return false;
    }

    private boolean containsValue(Entry entry, Object object) {
        if (object == null ? entry.value == null : object.equals(entry.value)) {
            return true;
        }
        if (entry.left != null && this.containsValue(entry.left, object)) {
            return true;
        }
        return entry.right != null && this.containsValue(entry.right, object);
    }

    public Set entrySet() {
        return new AbstractSet(){

            public int size() {
                return TreeMap.this.size;
            }

            public void clear() {
                TreeMap.this.clear();
            }

            public boolean contains(Object object) {
                if (object instanceof Map.Entry) {
                    Map.Entry entry = (Map.Entry)object;
                    Object object2 = TreeMap.this.get(entry.getKey());
                    Object object3 = entry.getValue();
                    return object2 == null ? object3 == null : object2.equals(object3);
                }
                return false;
            }

            public Iterator iterator() {
                return new TreeMapIterator(TreeMap.this, new MapEntry.Type(){

                    public Object get(MapEntry mapEntry) {
                        return mapEntry;
                    }
                });
            }
        };
    }

    private Entry find(Object object) {
        Comparable comparable = null;
        if (this.comparator == null) {
            comparable = (Comparable)object;
        }
        Entry entry = this.root;
        while (entry != null) {
            int n;
            int n2 = n = comparable != null ? comparable.compareTo(entry.key) : this.comparator.compare(object, entry.key);
            if (n == 0) {
                return entry;
            }
            Entry entry2 = entry = n < 0 ? entry.left : entry.right;
        }
        return null;
    }

    Entry findAfter(Object object) {
        Comparable comparable = null;
        if (this.comparator == null) {
            comparable = (Comparable)object;
        }
        Entry entry = this.root;
        Entry entry2 = null;
        while (entry != null) {
            int n;
            int n2 = n = comparable != null ? comparable.compareTo(entry.key) : this.comparator.compare(object, entry.key);
            if (n == 0) {
                return entry;
            }
            if (n < 0) {
                entry2 = entry;
                entry = entry.left;
                continue;
            }
            entry = entry.right;
        }
        return entry2;
    }

    Entry findBefore(Object object) {
        Comparable comparable = null;
        if (this.comparator == null) {
            comparable = (Comparable)object;
        }
        Entry entry = this.root;
        Entry entry2 = null;
        while (entry != null) {
            int n;
            int n2 = n = comparable != null ? comparable.compareTo(entry.key) : this.comparator.compare(object, entry.key);
            if (n <= 0) {
                entry = entry.left;
                continue;
            }
            entry2 = entry;
            entry = entry.right;
        }
        return entry2;
    }

    public Object firstKey() {
        if (this.root != null) {
            return TreeMap.minimum((Entry)this.root).key;
        }
        throw new NoSuchElementException();
    }

    private void fixup(Entry entry) {
        while (entry != this.root && !entry.color) {
            Entry entry2;
            if (entry == entry.parent.left) {
                entry2 = entry.parent.right;
                if (entry2 == null) {
                    entry = entry.parent;
                    continue;
                }
                if (entry2.color) {
                    entry2.color = false;
                    entry.parent.color = true;
                    this.leftRotate(entry.parent);
                    entry2 = entry.parent.right;
                    if (entry2 == null) {
                        entry = entry.parent;
                        continue;
                    }
                }
                if (!(entry2.left != null && entry2.left.color || entry2.right != null && entry2.right.color)) {
                    entry2.color = true;
                    entry = entry.parent;
                    continue;
                }
                if (entry2.right == null || !entry2.right.color) {
                    entry2.left.color = false;
                    entry2.color = true;
                    this.rightRotate(entry2);
                    entry2 = entry.parent.right;
                }
                entry2.color = entry.parent.color;
                entry.parent.color = false;
                entry2.right.color = false;
                this.leftRotate(entry.parent);
                entry = this.root;
                continue;
            }
            entry2 = entry.parent.left;
            if (entry2 == null) {
                entry = entry.parent;
                continue;
            }
            if (entry2.color) {
                entry2.color = false;
                entry.parent.color = true;
                this.rightRotate(entry.parent);
                entry2 = entry.parent.left;
                if (entry2 == null) {
                    entry = entry.parent;
                    continue;
                }
            }
            if (!(entry2.left != null && entry2.left.color || entry2.right != null && entry2.right.color)) {
                entry2.color = true;
                entry = entry.parent;
                continue;
            }
            if (entry2.left == null || !entry2.left.color) {
                entry2.right.color = false;
                entry2.color = true;
                this.leftRotate(entry2);
                entry2 = entry.parent.left;
            }
            entry2.color = entry.parent.color;
            entry.parent.color = false;
            entry2.left.color = false;
            this.rightRotate(entry.parent);
            entry = this.root;
        }
        entry.color = false;
    }

    public Object get(Object object) {
        Entry entry = this.find(object);
        if (entry != null) {
            return entry.value;
        }
        return null;
    }

    public SortedMap headMap(Object object) {
        if (this.comparator == null) {
            ((Comparable)object).compareTo(object);
        } else {
            this.comparator.compare(object, object);
        }
        return new SubMap(this, object);
    }

    public Set keySet() {
        if (this.keySet == null) {
            this.keySet = new AbstractSet(){

                public boolean contains(Object object) {
                    return TreeMap.this.containsKey(object);
                }

                public int size() {
                    return TreeMap.this.size;
                }

                public void clear() {
                    TreeMap.this.clear();
                }

                public Iterator iterator() {
                    return new TreeMapIterator(TreeMap.this, new MapEntry.Type(){

                        public Object get(MapEntry mapEntry) {
                            return mapEntry.key;
                        }
                    });
                }
            };
        }
        return this.keySet;
    }

    public Object lastKey() {
        if (this.root != null) {
            return TreeMap.maximum((Entry)this.root).key;
        }
        throw new NoSuchElementException();
    }

    private void leftRotate(Entry entry) {
        Entry entry2 = entry.right;
        entry.right = entry2.left;
        if (entry2.left != null) {
            entry2.left.parent = entry;
        }
        entry2.parent = entry.parent;
        if (entry.parent == null) {
            this.root = entry2;
        } else if (entry == entry.parent.left) {
            entry.parent.left = entry2;
        } else {
            entry.parent.right = entry2;
        }
        entry2.left = entry;
        entry.parent = entry2;
    }

    static Entry maximum(Entry entry) {
        while (entry.right != null) {
            entry = entry.right;
        }
        return entry;
    }

    static Entry minimum(Entry entry) {
        while (entry.left != null) {
            entry = entry.left;
        }
        return entry;
    }

    static Entry predecessor(Entry entry) {
        if (entry.left != null) {
            return TreeMap.maximum(entry.left);
        }
        Entry entry2 = entry.parent;
        while (entry2 != null && entry == entry2.left) {
            entry = entry2;
            entry2 = entry2.parent;
        }
        return entry2;
    }

    public Object put(Object object, Object object2) {
        Entry entry = this.rbInsert(object);
        Object object3 = entry.value;
        entry.value = object2;
        return object3;
    }

    public void putAll(Map map) {
        super.putAll(map);
    }

    void rbDelete(Entry entry) {
        Entry entry2;
        Entry entry3 = entry.left == null || entry.right == null ? entry : TreeMap.successor(entry);
        Entry entry4 = entry2 = entry3.left != null ? entry3.left : entry3.right;
        if (entry2 != null) {
            entry2.parent = entry3.parent;
        }
        if (entry3.parent == null) {
            this.root = entry2;
        } else if (entry3 == entry3.parent.left) {
            entry3.parent.left = entry2;
        } else {
            entry3.parent.right = entry2;
        }
        ++this.modCount;
        if (entry3 != entry) {
            entry.key = entry3.key;
            entry.value = entry3.value;
        }
        if (!entry3.color && this.root != null) {
            if (entry2 == null) {
                this.fixup(entry3.parent);
            } else {
                this.fixup(entry2);
            }
        }
        --this.size;
    }

    private Entry rbInsert(Object object) {
        int n = 0;
        Comparable comparable = null;
        if (this.comparator == null) {
            comparable = (Comparable)object;
        }
        Entry entry = null;
        Entry entry2 = this.root;
        while (entry2 != null) {
            entry = entry2;
            int n2 = n = comparable != null ? comparable.compareTo(entry2.key) : this.comparator.compare(object, entry2.key);
            if (n == 0) {
                return entry2;
            }
            Entry entry3 = entry2 = n < 0 ? entry2.left : entry2.right;
        }
        ++this.size;
        ++this.modCount;
        Entry entry4 = new Entry(object);
        if (entry == null) {
            this.root = entry4;
            return this.root;
        }
        entry4.parent = entry;
        if (n < 0) {
            entry.left = entry4;
        } else {
            entry.right = entry4;
        }
        this.balance(entry4);
        return entry4;
    }

    public Object remove(Object object) {
        Entry entry = this.find(object);
        if (entry == null) {
            return null;
        }
        Object object2 = entry.value;
        this.rbDelete(entry);
        return object2;
    }

    private void rightRotate(Entry entry) {
        Entry entry2 = entry.left;
        entry.left = entry2.right;
        if (entry2.right != null) {
            entry2.right.parent = entry;
        }
        entry2.parent = entry.parent;
        if (entry.parent == null) {
            this.root = entry2;
        } else if (entry == entry.parent.right) {
            entry.parent.right = entry2;
        } else {
            entry.parent.left = entry2;
        }
        entry2.right = entry;
        entry.parent = entry2;
    }

    public int size() {
        return this.size;
    }

    public SortedMap subMap(Object object, Object object2) {
        if (this.comparator == null ? ((Comparable)object).compareTo(object2) <= 0 : this.comparator.compare(object, object2) <= 0) {
            return new SubMap(object, this, object2);
        }
        throw new IllegalArgumentException();
    }

    static Entry successor(Entry entry) {
        if (entry.right != null) {
            return TreeMap.minimum(entry.right);
        }
        Entry entry2 = entry.parent;
        while (entry2 != null && entry == entry2.right) {
            entry = entry2;
            entry2 = entry2.parent;
        }
        return entry2;
    }

    public SortedMap tailMap(Object object) {
        if (this.comparator == null) {
            ((Comparable)object).compareTo(object);
        } else {
            this.comparator.compare(object, object);
        }
        return new SubMap(object, this);
    }

    public Collection values() {
        if (this.valuesCollection == null) {
            this.valuesCollection = new AbstractCollection(){

                public boolean contains(Object object) {
                    return TreeMap.this.containsValue(object);
                }

                public int size() {
                    return TreeMap.this.size;
                }

                public void clear() {
                    TreeMap.this.clear();
                }

                public Iterator iterator() {
                    return new TreeMapIterator(TreeMap.this, new MapEntry.Type(){

                        public Object get(MapEntry mapEntry) {
                            return mapEntry.value;
                        }
                    });
                }
            };
        }
        return this.valuesCollection;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(this.size);
        if (this.size > 0) {
            Entry entry = TreeMap.minimum(this.root);
            while (entry != null) {
                objectOutputStream.writeObject(entry.key);
                objectOutputStream.writeObject(entry.value);
                entry = TreeMap.successor(entry);
            }
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.size = objectInputStream.readInt();
        Entry entry = null;
        int n = this.size;
        while (--n >= 0) {
            Entry entry2 = new Entry(objectInputStream.readObject());
            entry2.value = objectInputStream.readObject();
            if (entry == null) {
                this.root = entry2;
            } else {
                entry2.parent = entry;
                entry.right = entry2;
                this.balance(entry2);
            }
            entry = entry2;
        }
    }

    static class Entry
    extends MapEntry {
        Entry parent;
        Entry left;
        Entry right;
        boolean color;

        Entry(Object object) {
            super(object);
        }

        Entry(Object object, Object object2) {
            super(object, object2);
        }

        Entry clone(Entry entry) {
            Entry entry2 = (Entry)super.clone();
            entry2.parent = entry;
            if (this.left != null) {
                entry2.left = this.left.clone(entry2);
            }
            if (this.right != null) {
                entry2.right = this.right.clone(entry2);
            }
            return entry2;
        }
    }

    static final class SubMap
    extends AbstractMap
    implements SortedMap {
        private final TreeMap backingMap;
        private boolean hasStart;
        private boolean hasEnd;
        private Object startKey;
        private Object endKey;

        SubMap(Object object, TreeMap treeMap) {
            this.backingMap = treeMap;
            this.hasStart = true;
            this.startKey = object;
        }

        SubMap(Object object, TreeMap treeMap, Object object2) {
            this.backingMap = treeMap;
            this.hasEnd = true;
            this.hasStart = true;
            this.startKey = object;
            this.endKey = object2;
        }

        SubMap(TreeMap treeMap, Object object) {
            this.backingMap = treeMap;
            this.hasEnd = true;
            this.endKey = object;
        }

        private void checkRange(Object object) {
            if (this.backingMap.comparator() == null) {
                Comparable comparable = (Comparable)object;
                if (this.hasStart && comparable.compareTo(this.startKey) < 0) {
                    throw new IllegalArgumentException();
                }
                if (this.hasEnd && comparable.compareTo(this.endKey) >= 0) {
                    throw new IllegalArgumentException();
                }
            } else {
                if (this.hasStart && this.backingMap.comparator().compare(object, this.startKey) < 0) {
                    throw new IllegalArgumentException();
                }
                if (this.hasEnd && this.backingMap.comparator().compare(object, this.endKey) >= 0) {
                    throw new IllegalArgumentException();
                }
            }
        }

        private boolean checkRange(Object object, boolean bl, boolean bl2) {
            if (this.backingMap.comparator() == null) {
                Comparable comparable = (Comparable)object;
                if (bl && comparable.compareTo(this.startKey) < 0) {
                    return false;
                }
                if (bl2 && comparable.compareTo(this.endKey) >= 0) {
                    return false;
                }
            } else {
                if (bl && this.backingMap.comparator().compare(object, this.startKey) < 0) {
                    return false;
                }
                if (bl2 && this.backingMap.comparator().compare(object, this.endKey) >= 0) {
                    return false;
                }
            }
            return true;
        }

        public Comparator comparator() {
            return this.backingMap.comparator();
        }

        public boolean containsKey(Object object) {
            if (this.checkRange(object, this.hasStart, this.hasEnd)) {
                return this.backingMap.containsKey(object);
            }
            return false;
        }

        public Set entrySet() {
            return new SubMapSet(this.hasStart, this.startKey, this.backingMap, this.hasEnd, this.endKey, new MapEntry.Type(){

                public Object get(MapEntry mapEntry) {
                    return mapEntry;
                }
            }){

                public boolean contains(Object object) {
                    if (object instanceof Map.Entry) {
                        Map.Entry entry = (Map.Entry)object;
                        Object object2 = this.get(entry.getKey());
                        Object object3 = entry.getValue();
                        return object2 == null ? object3 == null : object2.equals(object3);
                    }
                    return false;
                }
            };
        }

        public Object firstKey() {
            if (!this.hasStart) {
                return this.backingMap.firstKey();
            }
            Entry entry = this.backingMap.findAfter(this.startKey);
            if (entry != null && this.checkRange(entry.key, false, this.hasEnd)) {
                return entry.key;
            }
            throw new NoSuchElementException();
        }

        public Object get(Object object) {
            if (this.checkRange(object, this.hasStart, this.hasEnd)) {
                return this.backingMap.get(object);
            }
            return null;
        }

        public SortedMap headMap(Object object) {
            this.checkRange(object);
            if (this.hasStart) {
                return new SubMap(this.startKey, this.backingMap, object);
            }
            return new SubMap(this.backingMap, object);
        }

        public boolean isEmpty() {
            if (this.hasStart) {
                Entry entry = this.backingMap.findAfter(this.startKey);
                return entry == null || !this.checkRange(entry.key, false, this.hasEnd);
            }
            return this.backingMap.findBefore(this.endKey) == null;
        }

        public Set keySet() {
            if (this.keySet == null) {
                this.keySet = new SubMapSet(this.hasStart, this.startKey, this.backingMap, this.hasEnd, this.endKey, new MapEntry.Type(){

                    public Object get(MapEntry mapEntry) {
                        return mapEntry.key;
                    }
                }){

                    public boolean contains(Object object) {
                        return this.containsKey(object);
                    }
                };
            }
            return this.keySet;
        }

        public Object lastKey() {
            if (!this.hasEnd) {
                return this.backingMap.lastKey();
            }
            Entry entry = this.backingMap.findBefore(this.endKey);
            if (entry != null && this.checkRange(entry.key, this.hasStart, false)) {
                return entry.key;
            }
            throw new NoSuchElementException();
        }

        public Object put(Object object, Object object2) {
            if (this.checkRange(object, this.hasStart, this.hasEnd)) {
                return this.backingMap.put(object, object2);
            }
            throw new IllegalArgumentException();
        }

        public Object remove(Object object) {
            if (this.checkRange(object, this.hasStart, this.hasEnd)) {
                return this.backingMap.remove(object);
            }
            return null;
        }

        public SortedMap subMap(Object object, Object object2) {
            this.checkRange(object);
            this.checkRange(object2);
            Comparator comparator = this.backingMap.comparator();
            if (comparator == null ? ((Comparable)object).compareTo(object2) <= 0 : comparator.compare(object, object2) <= 0) {
                return new SubMap(object, this.backingMap, object2);
            }
            throw new IllegalArgumentException();
        }

        public SortedMap tailMap(Object object) {
            this.checkRange(object);
            if (this.hasEnd) {
                return new SubMap(object, this.backingMap, this.endKey);
            }
            return new SubMap(object, this.backingMap);
        }

        public Collection values() {
            return new SubMapSet(this.hasStart, this.startKey, this.backingMap, this.hasEnd, this.endKey, new MapEntry.Type(){

                public Object get(MapEntry mapEntry) {
                    return mapEntry.value;
                }
            });
        }

        static class SubMapSet
        extends AbstractSet
        implements Set {
            final TreeMap backingMap;
            boolean hasStart;
            boolean hasEnd;
            Object startKey;
            Object endKey;
            final MapEntry.Type type;

            SubMapSet(TreeMap treeMap, MapEntry.Type type) {
                this.backingMap = treeMap;
                this.type = type;
            }

            SubMapSet(boolean bl, Object object, TreeMap treeMap, boolean bl2, Object object2, MapEntry.Type type) {
                this(treeMap, type);
                this.hasStart = bl;
                this.startKey = object;
                this.hasEnd = bl2;
                this.endKey = object2;
            }

            void checkRange(Object object) {
                if (this.backingMap.comparator() == null) {
                    Comparable comparable = (Comparable)object;
                    if (this.hasStart && comparable.compareTo(this.startKey) < 0) {
                        throw new IllegalArgumentException();
                    }
                    if (this.hasEnd && comparable.compareTo(this.endKey) >= 0) {
                        throw new IllegalArgumentException();
                    }
                } else {
                    if (this.hasStart && this.backingMap.comparator().compare(object, this.startKey) < 0) {
                        throw new IllegalArgumentException();
                    }
                    if (this.hasEnd && this.backingMap.comparator().compare(object, this.endKey) >= 0) {
                        throw new IllegalArgumentException();
                    }
                }
            }

            boolean checkRange(Object object, boolean bl, boolean bl2) {
                if (this.backingMap.comparator() == null) {
                    Comparable comparable = (Comparable)object;
                    if (bl && comparable.compareTo(this.startKey) < 0) {
                        return false;
                    }
                    if (bl2 && comparable.compareTo(this.endKey) >= 0) {
                        return false;
                    }
                } else {
                    if (bl && this.backingMap.comparator().compare(object, this.startKey) < 0) {
                        return false;
                    }
                    if (bl2 && this.backingMap.comparator().compare(object, this.endKey) >= 0) {
                        return false;
                    }
                }
                return true;
            }

            public boolean isEmpty() {
                if (this.hasStart) {
                    Entry entry = this.backingMap.findAfter(this.startKey);
                    return entry == null || !this.checkRange(entry.key, false, this.hasEnd);
                }
                return this.backingMap.findBefore(this.endKey) == null;
            }

            public Iterator iterator() {
                Entry entry;
                if (this.hasStart) {
                    entry = this.backingMap.findAfter(this.startKey);
                    if (entry != null && !this.checkRange(entry.key, false, this.hasEnd)) {
                        entry = null;
                    }
                } else {
                    entry = this.backingMap.findBefore(this.endKey);
                    if (entry != null) {
                        entry = TreeMap.minimum(this.backingMap.root);
                    }
                }
                return new TreeMapIterator(this.backingMap, this.type, entry, this.hasEnd, this.endKey);
            }

            public int size() {
                int n = 0;
                Iterator iterator = this.iterator();
                while (iterator.hasNext()) {
                    ++n;
                    iterator.next();
                }
                return n;
            }
        }
    }

    private static final class TreeMapIterator
    implements Iterator {
        private final TreeMap backingMap;
        private int expectedModCount;
        private final MapEntry.Type type;
        private boolean hasEnd = false;
        private Entry node;
        private Entry lastNode;
        private Object endKey;

        TreeMapIterator(TreeMap treeMap, MapEntry.Type type) {
            this.backingMap = treeMap;
            this.type = type;
            this.expectedModCount = treeMap.modCount;
            if (treeMap.root != null) {
                this.node = TreeMap.minimum(treeMap.root);
            }
        }

        TreeMapIterator(TreeMap treeMap, MapEntry.Type type, Entry entry, boolean bl, Object object) {
            this.backingMap = treeMap;
            this.type = type;
            this.expectedModCount = treeMap.modCount;
            this.node = entry;
            this.hasEnd = bl;
            this.endKey = object;
        }

        public boolean hasNext() {
            return this.node != null;
        }

        public Object next() {
            if (this.expectedModCount == this.backingMap.modCount) {
                if (this.node != null) {
                    this.lastNode = this.node;
                    this.node = TreeMap.successor(this.node);
                    if (this.hasEnd && this.node != null) {
                        Comparator comparator = this.backingMap.comparator();
                        if (comparator == null) {
                            if (((Comparable)this.endKey).compareTo(this.node.key) <= 0) {
                                this.node = null;
                            }
                        } else if (comparator.compare(this.endKey, this.node.key) <= 0) {
                            this.node = null;
                        }
                    }
                    return this.type.get(this.lastNode);
                }
                throw new NoSuchElementException();
            }
            throw new ConcurrentModificationException();
        }

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        public void remove() {
            if (this.expectedModCount != this.backingMap.modCount) throw new ConcurrentModificationException();
            if (this.lastNode == null) throw new IllegalStateException();
            Object object = this.lastNode.key;
            this.backingMap.rbDelete(this.lastNode);
            if (this.lastNode.key != object) {
                this.node = this.lastNode;
            }
            this.lastNode = null;
            ++this.expectedModCount;
        }
    }
}

