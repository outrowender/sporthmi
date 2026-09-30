/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util;

import edu.emory.mathcs.backport.java.util.AbstractMap;
import edu.emory.mathcs.backport.java.util.Collections;
import edu.emory.mathcs.backport.java.util.NavigableMap;
import edu.emory.mathcs.backport.java.util.NavigableSet;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractSet;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;

public class TreeMap
extends AbstractMap
implements NavigableMap,
Serializable {
    private static final long serialVersionUID = 919286545866124006L;
    private final Comparator comparator;
    private transient Entry root;
    private transient int size = 0;
    private transient int modCount = 0;
    private transient EntrySet entrySet;
    private transient KeySet navigableKeySet;
    private transient NavigableMap descendingMap;
    private transient Comparator reverseComparator;

    public TreeMap() {
        this.comparator = null;
    }

    public TreeMap(Comparator comparator) {
        this.comparator = comparator;
    }

    public TreeMap(SortedMap sortedMap) {
        this.comparator = sortedMap.comparator();
        this.buildFromSorted(sortedMap.entrySet().iterator(), sortedMap.size());
    }

    public TreeMap(Map map) {
        this.comparator = null;
        this.putAll(map);
    }

    public int size() {
        return this.size;
    }

    public void clear() {
        this.root = null;
        this.size = 0;
        ++this.modCount;
    }

    public Object clone() {
        TreeMap treeMap;
        try {
            treeMap = (TreeMap)super.clone();
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            throw new InternalError();
        }
        treeMap.root = null;
        treeMap.size = 0;
        treeMap.modCount = 0;
        if (!this.isEmpty()) {
            treeMap.buildFromSorted(this.entrySet().iterator(), this.size);
        }
        return treeMap;
    }

    public Object put(Object object, Object object2) {
        if (this.root == null) {
            this.root = new Entry(object, object2);
            ++this.size;
            ++this.modCount;
            return null;
        }
        Entry entry = this.root;
        while (true) {
            int n;
            if ((n = TreeMap.compare(object, entry.getKey(), this.comparator)) == 0) {
                return entry.setValue(object2);
            }
            if (n <= 0) {
                if (entry.left != null) {
                    entry = entry.left;
                    continue;
                }
                ++this.size;
                ++this.modCount;
                Entry entry2 = new Entry(object, object2);
                entry2.parent = entry;
                entry.left = entry2;
                this.fixAfterInsertion(entry2);
                return null;
            }
            if (entry.right == null) break;
            entry = entry.right;
        }
        ++this.size;
        ++this.modCount;
        Entry entry3 = new Entry(object, object2);
        entry3.parent = entry;
        entry.right = entry3;
        this.fixAfterInsertion(entry3);
        return null;
    }

    public Object get(Object object) {
        Entry entry = this.getEntry(object);
        return entry == null ? null : entry.getValue();
    }

    public boolean containsKey(Object object) {
        return this.getEntry(object) != null;
    }

    public Set entrySet() {
        if (this.entrySet == null) {
            this.entrySet = new EntrySet();
        }
        return this.entrySet;
    }

    private static Entry successor(Entry entry) {
        if (entry.right != null) {
            entry = entry.right;
            while (entry.left != null) {
                entry = entry.left;
            }
            return entry;
        }
        Entry entry2 = entry.parent;
        while (entry2 != null && entry == entry2.right) {
            entry = entry2;
            entry2 = entry2.parent;
        }
        return entry2;
    }

    private static Entry predecessor(Entry entry) {
        if (entry.left != null) {
            entry = entry.left;
            while (entry.right != null) {
                entry = entry.right;
            }
            return entry;
        }
        Entry entry2 = entry.parent;
        while (entry2 != null && entry == entry2.left) {
            entry = entry2;
            entry2 = entry2.parent;
        }
        return entry2;
    }

    private Entry getEntry(Object object) {
        Entry entry = this.root;
        if (this.comparator != null) {
            while (true) {
                if (entry == null) {
                    return null;
                }
                int n = this.comparator.compare(object, entry.key);
                if (n == 0) {
                    return entry;
                }
                entry = n < 0 ? entry.left : entry.right;
            }
        }
        Comparable comparable = (Comparable)object;
        while (entry != null) {
            int n = comparable.compareTo(entry.key);
            if (n == 0) {
                return entry;
            }
            entry = n < 0 ? entry.left : entry.right;
        }
        return null;
    }

    private Entry getHigherEntry(Object object) {
        Entry entry = this.root;
        if (entry == null) {
            return null;
        }
        while (true) {
            int n;
            if ((n = TreeMap.compare(object, entry.key, this.comparator)) < 0) {
                if (entry.left != null) {
                    entry = entry.left;
                    continue;
                }
                return entry;
            }
            if (entry.right == null) break;
            entry = entry.right;
        }
        Entry entry2 = entry.parent;
        while (entry2 != null && entry == entry2.right) {
            entry = entry2;
            entry2 = entry2.parent;
        }
        return entry2;
    }

    private Entry getFirstEntry() {
        Entry entry = this.root;
        if (entry == null) {
            return null;
        }
        while (entry.left != null) {
            entry = entry.left;
        }
        return entry;
    }

    private Entry getLastEntry() {
        Entry entry = this.root;
        if (entry == null) {
            return null;
        }
        while (entry.right != null) {
            entry = entry.right;
        }
        return entry;
    }

    private Entry getCeilingEntry(Object object) {
        Entry entry;
        block5: {
            entry = this.root;
            if (entry == null) {
                return null;
            }
            while (true) {
                int n;
                if ((n = TreeMap.compare(object, entry.key, this.comparator)) < 0) {
                    if (entry.left != null) {
                        entry = entry.left;
                        continue;
                    }
                    return entry;
                }
                if (n <= 0) break block5;
                if (entry.right == null) break;
                entry = entry.right;
            }
            Entry entry2 = entry.parent;
            while (entry2 != null && entry == entry2.right) {
                entry = entry2;
                entry2 = entry2.parent;
            }
            return entry2;
        }
        return entry;
    }

    private Entry getLowerEntry(Object object) {
        Entry entry = this.root;
        if (entry == null) {
            return null;
        }
        while (true) {
            int n;
            if ((n = TreeMap.compare(object, entry.key, this.comparator)) > 0) {
                if (entry.right != null) {
                    entry = entry.right;
                    continue;
                }
                return entry;
            }
            if (entry.left == null) break;
            entry = entry.left;
        }
        Entry entry2 = entry.parent;
        while (entry2 != null && entry == entry2.left) {
            entry = entry2;
            entry2 = entry2.parent;
        }
        return entry2;
    }

    private Entry getFloorEntry(Object object) {
        Entry entry;
        block5: {
            entry = this.root;
            if (entry == null) {
                return null;
            }
            while (true) {
                int n;
                if ((n = TreeMap.compare(object, entry.key, this.comparator)) > 0) {
                    if (entry.right != null) {
                        entry = entry.right;
                        continue;
                    }
                    return entry;
                }
                if (n >= 0) break block5;
                if (entry.left == null) break;
                entry = entry.left;
            }
            Entry entry2 = entry.parent;
            while (entry2 != null && entry == entry2.left) {
                entry = entry2;
                entry2 = entry2.parent;
            }
            return entry2;
        }
        return entry;
    }

    void buildFromSorted(Iterator iterator, int n) {
        ++this.modCount;
        this.size = n;
        int n2 = 0;
        int n3 = 1;
        while (n3 - 1 < n) {
            ++n2;
            n3 <<= 1;
        }
        this.root = TreeMap.createFromSorted(iterator, n, 0, n2);
    }

    private static Entry createFromSorted(Iterator iterator, int n, int n2, int n3) {
        ++n2;
        if (n == 0) {
            return null;
        }
        int n4 = n - 1 >> 1;
        int n5 = n - 1 - n4;
        Entry entry = TreeMap.createFromSorted(iterator, n4, n2, n3);
        Map.Entry entry2 = (Map.Entry)iterator.next();
        Entry entry3 = TreeMap.createFromSorted(iterator, n5, n2, n3);
        Entry entry4 = new Entry(entry2.getKey(), entry2.getValue());
        if (entry != null) {
            entry4.left = entry;
            entry.parent = entry4;
        }
        if (entry3 != null) {
            entry4.right = entry3;
            entry3.parent = entry4;
        }
        if (n2 == n3) {
            entry4.color = false;
        }
        return entry4;
    }

    private void delete(Entry entry) {
        Entry entry2;
        if (entry.left == null && entry.right == null && entry.parent == null) {
            this.root = null;
            this.size = 0;
            ++this.modCount;
            return;
        }
        if (entry.left != null && entry.right != null) {
            entry2 = TreeMap.successor(entry);
            entry.key = entry2.key;
            entry.element = entry2.element;
            entry = entry2;
        }
        if (entry.left == null && entry.right == null) {
            if (entry.color) {
                this.fixAfterDeletion(entry);
            }
            if (entry.parent != null) {
                if (entry == entry.parent.left) {
                    entry.parent.left = null;
                } else if (entry == entry.parent.right) {
                    entry.parent.right = null;
                }
                entry.parent = null;
            }
        } else {
            entry2 = entry.left;
            if (entry2 == null) {
                entry2 = entry.right;
            }
            entry2.parent = entry.parent;
            if (entry.parent == null) {
                this.root = entry2;
            } else if (entry == entry.parent.left) {
                entry.parent.left = entry2;
            } else {
                entry.parent.right = entry2;
            }
            entry.left = null;
            entry.right = null;
            entry.parent = null;
            if (entry.color) {
                this.fixAfterDeletion(entry2);
            }
        }
        --this.size;
        ++this.modCount;
    }

    static boolean colorOf(Entry entry) {
        return entry == null ? true : entry.color;
    }

    static Entry parentOf(Entry entry) {
        return entry == null ? null : entry.parent;
    }

    private static void setColor(Entry entry, boolean bl) {
        if (entry != null) {
            entry.color = bl;
        }
    }

    private static Entry leftOf(Entry entry) {
        return entry == null ? null : entry.left;
    }

    private static Entry rightOf(Entry entry) {
        return entry == null ? null : entry.right;
    }

    private final void rotateLeft(Entry entry) {
        Entry entry2 = entry.right;
        entry.right = entry2.left;
        if (entry2.left != null) {
            entry2.left.parent = entry;
        }
        entry2.parent = entry.parent;
        if (entry.parent == null) {
            this.root = entry2;
        } else if (entry.parent.left == entry) {
            entry.parent.left = entry2;
        } else {
            entry.parent.right = entry2;
        }
        entry2.left = entry;
        entry.parent = entry2;
    }

    private final void rotateRight(Entry entry) {
        Entry entry2 = entry.left;
        entry.left = entry2.right;
        if (entry2.right != null) {
            entry2.right.parent = entry;
        }
        entry2.parent = entry.parent;
        if (entry.parent == null) {
            this.root = entry2;
        } else if (entry.parent.right == entry) {
            entry.parent.right = entry2;
        } else {
            entry.parent.left = entry2;
        }
        entry2.right = entry;
        entry.parent = entry2;
    }

    private final void fixAfterInsertion(Entry entry) {
        entry.color = false;
        Entry entry2 = entry;
        while (entry2 != null && entry2 != this.root && !entry2.parent.color) {
            Entry entry3;
            if (TreeMap.parentOf(entry2) == TreeMap.leftOf(TreeMap.parentOf(TreeMap.parentOf(entry2)))) {
                entry3 = TreeMap.rightOf(TreeMap.parentOf(TreeMap.parentOf(entry2)));
                if (!TreeMap.colorOf(entry3)) {
                    TreeMap.setColor(TreeMap.parentOf(entry2), true);
                    TreeMap.setColor(entry3, true);
                    TreeMap.setColor(TreeMap.parentOf(TreeMap.parentOf(entry2)), false);
                    entry2 = TreeMap.parentOf(TreeMap.parentOf(entry2));
                    continue;
                }
                if (entry2 == TreeMap.rightOf(TreeMap.parentOf(entry2))) {
                    entry2 = TreeMap.parentOf(entry2);
                    this.rotateLeft(entry2);
                }
                TreeMap.setColor(TreeMap.parentOf(entry2), true);
                TreeMap.setColor(TreeMap.parentOf(TreeMap.parentOf(entry2)), false);
                if (TreeMap.parentOf(TreeMap.parentOf(entry2)) == null) continue;
                this.rotateRight(TreeMap.parentOf(TreeMap.parentOf(entry2)));
                continue;
            }
            entry3 = TreeMap.leftOf(TreeMap.parentOf(TreeMap.parentOf(entry2)));
            if (!TreeMap.colorOf(entry3)) {
                TreeMap.setColor(TreeMap.parentOf(entry2), true);
                TreeMap.setColor(entry3, true);
                TreeMap.setColor(TreeMap.parentOf(TreeMap.parentOf(entry2)), false);
                entry2 = TreeMap.parentOf(TreeMap.parentOf(entry2));
                continue;
            }
            if (entry2 == TreeMap.leftOf(TreeMap.parentOf(entry2))) {
                entry2 = TreeMap.parentOf(entry2);
                this.rotateRight(entry2);
            }
            TreeMap.setColor(TreeMap.parentOf(entry2), true);
            TreeMap.setColor(TreeMap.parentOf(TreeMap.parentOf(entry2)), false);
            if (TreeMap.parentOf(TreeMap.parentOf(entry2)) == null) continue;
            this.rotateLeft(TreeMap.parentOf(TreeMap.parentOf(entry2)));
        }
        this.root.color = true;
    }

    private final Entry fixAfterDeletion(Entry entry) {
        Entry entry2 = entry;
        while (entry2 != this.root && TreeMap.colorOf(entry2)) {
            Entry entry3;
            if (entry2 == TreeMap.leftOf(TreeMap.parentOf(entry2))) {
                entry3 = TreeMap.rightOf(TreeMap.parentOf(entry2));
                if (!TreeMap.colorOf(entry3)) {
                    TreeMap.setColor(entry3, true);
                    TreeMap.setColor(TreeMap.parentOf(entry2), false);
                    this.rotateLeft(TreeMap.parentOf(entry2));
                    entry3 = TreeMap.rightOf(TreeMap.parentOf(entry2));
                }
                if (TreeMap.colorOf(TreeMap.leftOf(entry3)) && TreeMap.colorOf(TreeMap.rightOf(entry3))) {
                    TreeMap.setColor(entry3, false);
                    entry2 = TreeMap.parentOf(entry2);
                    continue;
                }
                if (TreeMap.colorOf(TreeMap.rightOf(entry3))) {
                    TreeMap.setColor(TreeMap.leftOf(entry3), true);
                    TreeMap.setColor(entry3, false);
                    this.rotateRight(entry3);
                    entry3 = TreeMap.rightOf(TreeMap.parentOf(entry2));
                }
                TreeMap.setColor(entry3, TreeMap.colorOf(TreeMap.parentOf(entry2)));
                TreeMap.setColor(TreeMap.parentOf(entry2), true);
                TreeMap.setColor(TreeMap.rightOf(entry3), true);
                this.rotateLeft(TreeMap.parentOf(entry2));
                entry2 = this.root;
                continue;
            }
            entry3 = TreeMap.leftOf(TreeMap.parentOf(entry2));
            if (!TreeMap.colorOf(entry3)) {
                TreeMap.setColor(entry3, true);
                TreeMap.setColor(TreeMap.parentOf(entry2), false);
                this.rotateRight(TreeMap.parentOf(entry2));
                entry3 = TreeMap.leftOf(TreeMap.parentOf(entry2));
            }
            if (TreeMap.colorOf(TreeMap.rightOf(entry3)) && TreeMap.colorOf(TreeMap.leftOf(entry3))) {
                TreeMap.setColor(entry3, false);
                entry2 = TreeMap.parentOf(entry2);
                continue;
            }
            if (TreeMap.colorOf(TreeMap.leftOf(entry3))) {
                TreeMap.setColor(TreeMap.rightOf(entry3), true);
                TreeMap.setColor(entry3, false);
                this.rotateLeft(entry3);
                entry3 = TreeMap.leftOf(TreeMap.parentOf(entry2));
            }
            TreeMap.setColor(entry3, TreeMap.colorOf(TreeMap.parentOf(entry2)));
            TreeMap.setColor(TreeMap.parentOf(entry2), true);
            TreeMap.setColor(TreeMap.leftOf(entry3), true);
            this.rotateRight(TreeMap.parentOf(entry2));
            entry2 = this.root;
        }
        TreeMap.setColor(entry2, true);
        return this.root;
    }

    private Entry getMatchingEntry(Object object) {
        if (!(object instanceof Map.Entry)) {
            return null;
        }
        Map.Entry entry = (Map.Entry)object;
        Entry entry2 = this.getEntry(entry.getKey());
        return entry2 != null && TreeMap.eq(entry2.getValue(), entry.getValue()) ? entry2 : null;
    }

    private static boolean eq(Object object, Object object2) {
        return object == null ? object2 == null : object.equals(object2);
    }

    private static int compare(Object object, Object object2, Comparator comparator) {
        return comparator == null ? ((Comparable)object).compareTo(object2) : comparator.compare(object, object2);
    }

    public Map.Entry lowerEntry(Object object) {
        Entry entry = this.getLowerEntry(object);
        return entry == null ? null : new AbstractMap.SimpleImmutableEntry(entry);
    }

    public Object lowerKey(Object object) {
        Entry entry = this.getLowerEntry(object);
        return entry == null ? null : entry.getKey();
    }

    public Map.Entry floorEntry(Object object) {
        Entry entry = this.getFloorEntry(object);
        return entry == null ? null : new AbstractMap.SimpleImmutableEntry(entry);
    }

    public Object floorKey(Object object) {
        Entry entry = this.getFloorEntry(object);
        return entry == null ? null : entry.key;
    }

    public Map.Entry ceilingEntry(Object object) {
        Entry entry = this.getCeilingEntry(object);
        return entry == null ? null : new AbstractMap.SimpleImmutableEntry(entry);
    }

    public Object ceilingKey(Object object) {
        Entry entry = this.getCeilingEntry(object);
        return entry == null ? null : entry.key;
    }

    public Map.Entry higherEntry(Object object) {
        Entry entry = this.getHigherEntry(object);
        return entry == null ? null : new AbstractMap.SimpleImmutableEntry(entry);
    }

    public Object higherKey(Object object) {
        Entry entry = this.getHigherEntry(object);
        return entry == null ? null : entry.key;
    }

    public Map.Entry firstEntry() {
        Entry entry = this.getFirstEntry();
        return entry == null ? null : new AbstractMap.SimpleImmutableEntry(entry);
    }

    public Map.Entry lastEntry() {
        Entry entry = this.getLastEntry();
        return entry == null ? null : new AbstractMap.SimpleImmutableEntry(entry);
    }

    public Map.Entry pollFirstEntry() {
        Entry entry = this.getFirstEntry();
        if (entry == null) {
            return null;
        }
        AbstractMap.SimpleImmutableEntry simpleImmutableEntry = new AbstractMap.SimpleImmutableEntry(entry);
        this.delete(entry);
        return simpleImmutableEntry;
    }

    public Map.Entry pollLastEntry() {
        Entry entry = this.getLastEntry();
        if (entry == null) {
            return null;
        }
        AbstractMap.SimpleImmutableEntry simpleImmutableEntry = new AbstractMap.SimpleImmutableEntry(entry);
        this.delete(entry);
        return simpleImmutableEntry;
    }

    public NavigableMap descendingMap() {
        NavigableMap navigableMap = this.descendingMap;
        if (navigableMap == null) {
            this.descendingMap = navigableMap = new DescendingSubMap(true, null, true, true, null, true);
        }
        return navigableMap;
    }

    public NavigableSet descendingKeySet() {
        return this.descendingMap().navigableKeySet();
    }

    public SortedMap subMap(Object object, Object object2) {
        return this.subMap(object, true, object2, false);
    }

    public SortedMap headMap(Object object) {
        return this.headMap(object, false);
    }

    public SortedMap tailMap(Object object) {
        return this.tailMap(object, true);
    }

    public NavigableMap subMap(Object object, boolean bl, Object object2, boolean bl2) {
        return new AscendingSubMap(false, object, bl, false, object2, bl2);
    }

    public NavigableMap headMap(Object object, boolean bl) {
        return new AscendingSubMap(true, null, true, false, object, bl);
    }

    public NavigableMap tailMap(Object object, boolean bl) {
        return new AscendingSubMap(false, object, bl, true, null, true);
    }

    public Comparator comparator() {
        return this.comparator;
    }

    final Comparator reverseComparator() {
        if (this.reverseComparator == null) {
            this.reverseComparator = Collections.reverseOrder(this.comparator);
        }
        return this.reverseComparator;
    }

    public Object firstKey() {
        Entry entry = this.getFirstEntry();
        if (entry == null) {
            throw new NoSuchElementException();
        }
        return entry.key;
    }

    public Object lastKey() {
        Entry entry = this.getLastEntry();
        if (entry == null) {
            throw new NoSuchElementException();
        }
        return entry.key;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public boolean containsValue(Object object) {
        if (this.root == null) {
            return false;
        }
        return object == null ? TreeMap.containsNull(this.root) : TreeMap.containsValue(this.root, object);
    }

    private static boolean containsNull(Entry entry) {
        if (entry.element == null) {
            return true;
        }
        if (entry.left != null && TreeMap.containsNull(entry.left)) {
            return true;
        }
        return entry.right != null && TreeMap.containsNull(entry.right);
    }

    private static boolean containsValue(Entry entry, Object object) {
        if (object.equals(entry.element)) {
            return true;
        }
        if (entry.left != null && TreeMap.containsValue(entry.left, object)) {
            return true;
        }
        return entry.right != null && TreeMap.containsValue(entry.right, object);
    }

    public Object remove(Object object) {
        Entry entry = this.getEntry(object);
        if (entry == null) {
            return null;
        }
        Object object2 = entry.getValue();
        this.delete(entry);
        return object2;
    }

    public void putAll(Map map) {
        SortedMap sortedMap;
        if (map instanceof SortedMap && TreeMap.eq(this.comparator, (sortedMap = (SortedMap)map).comparator())) {
            this.buildFromSorted(sortedMap.entrySet().iterator(), map.size());
            return;
        }
        super.putAll(map);
    }

    public Set keySet() {
        return this.navigableKeySet();
    }

    public NavigableSet navigableKeySet() {
        if (this.navigableKeySet == null) {
            this.navigableKeySet = new AscendingKeySet();
        }
        return this.navigableKeySet;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(this.size);
        Entry entry = this.getFirstEntry();
        while (entry != null) {
            objectOutputStream.writeObject(entry.key);
            objectOutputStream.writeObject(entry.element);
            entry = TreeMap.successor(entry);
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        int n = objectInputStream.readInt();
        try {
            this.buildFromSorted(new IOIterator(objectInputStream, n), n);
        }
        catch (IteratorIOException iteratorIOException) {
            throw iteratorIOException.getException();
        }
        catch (IteratorNoClassException iteratorNoClassException) {
            throw iteratorNoClassException.getException();
        }
    }

    public static class Entry
    implements Map.Entry,
    Cloneable,
    Serializable {
        private static final boolean RED = false;
        private static final boolean BLACK = true;
        private Object key;
        private Object element;
        private boolean color;
        private Entry left;
        private Entry right;
        private Entry parent;

        public Entry(Object object, Object object2) {
            this.key = object;
            this.element = object2;
            this.color = true;
        }

        protected Object clone() throws CloneNotSupportedException {
            Entry entry = new Entry(this.key, this.element);
            entry.color = this.color;
            return entry;
        }

        public final Object getKey() {
            return this.key;
        }

        public final Object getValue() {
            return this.element;
        }

        public final Object setValue(Object object) {
            Object object2 = this.element;
            this.element = object;
            return object2;
        }

        public boolean equals(Object object) {
            if (!(object instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry)object;
            return TreeMap.eq(this.key, entry.getKey()) && TreeMap.eq(this.element, entry.getValue());
        }

        public int hashCode() {
            return (this.key == null ? 0 : this.key.hashCode()) ^ (this.element == null ? 0 : this.element.hashCode());
        }

        public String toString() {
            return new StringBuffer().append(this.key).append("=").append(this.element).toString();
        }
    }

    abstract class KeySet
    extends AbstractSet
    implements NavigableSet {
        KeySet() {
        }

        public int size() {
            return TreeMap.this.size();
        }

        public boolean isEmpty() {
            return TreeMap.this.isEmpty();
        }

        public void clear() {
            TreeMap.this.clear();
        }

        public boolean contains(Object object) {
            return TreeMap.this.getEntry(object) != null;
        }

        public boolean remove(Object object) {
            Entry entry = TreeMap.this.getEntry(object);
            if (entry == null) {
                return false;
            }
            TreeMap.this.delete(entry);
            return true;
        }

        public SortedSet subSet(Object object, Object object2) {
            return this.subSet(object, true, object2, false);
        }

        public SortedSet headSet(Object object) {
            return this.headSet(object, false);
        }

        public SortedSet tailSet(Object object) {
            return this.tailSet(object, true);
        }
    }

    private class SubMap
    extends AbstractMap
    implements Serializable,
    NavigableMap {
        private static final long serialVersionUID = -6520786458950516097L;
        final Object fromKey = null;
        final Object toKey = null;

        SubMap() {
        }

        private Object readResolve() {
            return new AscendingSubMap(this.fromKey == null, this.fromKey, true, this.toKey == null, this.toKey, false);
        }

        public Map.Entry lowerEntry(Object object) {
            throw new Error();
        }

        public Object lowerKey(Object object) {
            throw new Error();
        }

        public Map.Entry floorEntry(Object object) {
            throw new Error();
        }

        public Object floorKey(Object object) {
            throw new Error();
        }

        public Map.Entry ceilingEntry(Object object) {
            throw new Error();
        }

        public Object ceilingKey(Object object) {
            throw new Error();
        }

        public Map.Entry higherEntry(Object object) {
            throw new Error();
        }

        public Object higherKey(Object object) {
            throw new Error();
        }

        public Map.Entry firstEntry() {
            throw new Error();
        }

        public Map.Entry lastEntry() {
            throw new Error();
        }

        public Map.Entry pollFirstEntry() {
            throw new Error();
        }

        public Map.Entry pollLastEntry() {
            throw new Error();
        }

        public NavigableMap descendingMap() {
            throw new Error();
        }

        public NavigableSet navigableKeySet() {
            throw new Error();
        }

        public NavigableSet descendingKeySet() {
            throw new Error();
        }

        public Set entrySet() {
            throw new Error();
        }

        public NavigableMap subMap(Object object, boolean bl, Object object2, boolean bl2) {
            throw new Error();
        }

        public NavigableMap headMap(Object object, boolean bl) {
            throw new Error();
        }

        public NavigableMap tailMap(Object object, boolean bl) {
            throw new Error();
        }

        public SortedMap subMap(Object object, Object object2) {
            throw new Error();
        }

        public SortedMap headMap(Object object) {
            throw new Error();
        }

        public SortedMap tailMap(Object object) {
            throw new Error();
        }

        public Comparator comparator() {
            throw new Error();
        }

        public Object firstKey() {
            throw new Error();
        }

        public Object lastKey() {
            throw new Error();
        }
    }

    class EntrySet
    extends AbstractSet {
        EntrySet() {
        }

        public int size() {
            return TreeMap.this.size();
        }

        public boolean isEmpty() {
            return TreeMap.this.isEmpty();
        }

        public void clear() {
            TreeMap.this.clear();
        }

        public Iterator iterator() {
            return new EntryIterator(TreeMap.this.getFirstEntry());
        }

        public boolean contains(Object object) {
            return TreeMap.this.getMatchingEntry(object) != null;
        }

        public boolean remove(Object object) {
            Entry entry = TreeMap.this.getMatchingEntry(object);
            if (entry == null) {
                return false;
            }
            TreeMap.this.delete(entry);
            return true;
        }
    }

    class ValueSet
    extends AbstractSet {
        ValueSet() {
        }

        public int size() {
            return TreeMap.this.size();
        }

        public boolean isEmpty() {
            return TreeMap.this.isEmpty();
        }

        public void clear() {
            TreeMap.this.clear();
        }

        public boolean contains(Object object) {
            Entry entry = TreeMap.this.getFirstEntry();
            while (entry != null) {
                if (TreeMap.eq(object, entry.element)) {
                    return true;
                }
                entry = TreeMap.successor(entry);
            }
            return false;
        }

        public Iterator iterator() {
            return new ValueIterator(TreeMap.this.getFirstEntry());
        }

        public boolean remove(Object object) {
            Entry entry = TreeMap.this.getFirstEntry();
            while (entry != null) {
                if (TreeMap.eq(object, entry.element)) {
                    TreeMap.this.delete(entry);
                    return true;
                }
                entry = TreeMap.successor(entry);
            }
            return false;
        }
    }

    static class IOIterator
    implements Iterator {
        final ObjectInputStream ois;
        int remaining;

        IOIterator(ObjectInputStream objectInputStream, int n) {
            this.ois = objectInputStream;
            this.remaining = n;
        }

        public boolean hasNext() {
            return this.remaining > 0;
        }

        public Object next() {
            if (this.remaining <= 0) {
                throw new NoSuchElementException();
            }
            --this.remaining;
            try {
                return new AbstractMap.SimpleImmutableEntry(this.ois.readObject(), this.ois.readObject());
            }
            catch (IOException iOException) {
                throw new IteratorIOException(iOException);
            }
            catch (ClassNotFoundException classNotFoundException) {
                throw new IteratorNoClassException(classNotFoundException);
            }
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    class KeyIterator
    extends BaseEntryIterator
    implements Iterator {
        KeyIterator(Entry entry) {
            super(entry);
        }

        public Object next() {
            return this.nextEntry().key;
        }
    }

    class EntryIterator
    extends BaseEntryIterator
    implements Iterator {
        EntryIterator(Entry entry) {
            super(entry);
        }

        public Object next() {
            return this.nextEntry();
        }
    }

    class ValueIterator
    extends BaseEntryIterator
    implements Iterator {
        ValueIterator(Entry entry) {
            super(entry);
        }

        public Object next() {
            return this.nextEntry().element;
        }
    }

    class AscendingKeySet
    extends KeySet {
        AscendingKeySet() {
        }

        public Iterator iterator() {
            return new KeyIterator(TreeMap.this.getFirstEntry());
        }

        public Iterator descendingIterator() {
            return new DescendingKeyIterator(TreeMap.this.getFirstEntry());
        }

        public Object lower(Object object) {
            return TreeMap.this.lowerKey(object);
        }

        public Object floor(Object object) {
            return TreeMap.this.floorKey(object);
        }

        public Object ceiling(Object object) {
            return TreeMap.this.ceilingKey(object);
        }

        public Object higher(Object object) {
            return TreeMap.this.higherKey(object);
        }

        public Object first() {
            return TreeMap.this.firstKey();
        }

        public Object last() {
            return TreeMap.this.lastKey();
        }

        public Comparator comparator() {
            return TreeMap.this.comparator();
        }

        public Object pollFirst() {
            Map.Entry entry = TreeMap.this.pollFirstEntry();
            return entry == null ? null : entry.getKey();
        }

        public Object pollLast() {
            Map.Entry entry = TreeMap.this.pollLastEntry();
            return entry == null ? null : entry.getKey();
        }

        public NavigableSet subSet(Object object, boolean bl, Object object2, boolean bl2) {
            return (NavigableSet)TreeMap.this.subMap(object, bl, object2, bl2).keySet();
        }

        public NavigableSet headSet(Object object, boolean bl) {
            return (NavigableSet)TreeMap.this.headMap(object, bl).keySet();
        }

        public NavigableSet tailSet(Object object, boolean bl) {
            return (NavigableSet)TreeMap.this.tailMap(object, bl).keySet();
        }

        public NavigableSet descendingSet() {
            return (NavigableSet)TreeMap.this.descendingMap().keySet();
        }
    }

    class AscendingSubMap
    extends NavigableSubMap {
        AscendingSubMap(boolean bl, Object object, boolean bl2, boolean bl3, Object object2, boolean bl4) {
            super(bl, object, bl2, bl3, object2, bl4);
        }

        public Comparator comparator() {
            return TreeMap.this.comparator;
        }

        protected Entry first() {
            return this.absLowest();
        }

        protected Entry last() {
            return this.absHighest();
        }

        protected Entry lower(Object object) {
            return this.absLower(object);
        }

        protected Entry floor(Object object) {
            return this.absFloor(object);
        }

        protected Entry ceiling(Object object) {
            return this.absCeiling(object);
        }

        protected Entry higher(Object object) {
            return this.absHigher(object);
        }

        protected Entry uncheckedHigher(Entry entry) {
            return TreeMap.successor(entry);
        }

        public NavigableMap subMap(Object object, boolean bl, Object object2, boolean bl2) {
            if (!this.inRange(object, bl)) {
                throw new IllegalArgumentException("fromKey out of range");
            }
            if (!this.inRange(object2, bl2)) {
                throw new IllegalArgumentException("toKey out of range");
            }
            return new AscendingSubMap(false, object, bl, false, object2, bl2);
        }

        public NavigableMap headMap(Object object, boolean bl) {
            if (!this.inRange(object, bl)) {
                throw new IllegalArgumentException("toKey out of range");
            }
            return new AscendingSubMap(this.fromStart, this.fromKey, this.fromInclusive, false, object, bl);
        }

        public NavigableMap tailMap(Object object, boolean bl) {
            if (!this.inRange(object, bl)) {
                throw new IllegalArgumentException("fromKey out of range");
            }
            return new AscendingSubMap(false, object, bl, this.toEnd, this.toKey, this.toInclusive);
        }

        public NavigableMap descendingMap() {
            if (this.descendingMap == null) {
                this.descendingMap = new DescendingSubMap(this.fromStart, this.fromKey, this.fromInclusive, this.toEnd, this.toKey, this.toInclusive);
            }
            return this.descendingMap;
        }
    }

    private abstract class NavigableSubMap
    extends AbstractMap
    implements NavigableMap,
    Serializable {
        private static final long serialVersionUID = -6520786458950516097L;
        final Object fromKey;
        final Object toKey;
        final boolean fromStart;
        final boolean toEnd;
        final boolean fromInclusive;
        final boolean toInclusive;
        transient int cachedSize = -1;
        transient int cacheVersion;
        transient SubEntrySet entrySet;
        transient NavigableMap descendingMap;
        transient NavigableSet navigableKeySet;

        NavigableSubMap(boolean bl, Object object, boolean bl2, boolean bl3, Object object2, boolean bl4) {
            if (!bl && !bl3) {
                if (TreeMap.compare(object, object2, TreeMap.this.comparator) > 0) {
                    throw new IllegalArgumentException("fromKey > toKey");
                }
            } else {
                if (!bl) {
                    TreeMap.compare(object, object, TreeMap.this.comparator);
                }
                if (!bl3) {
                    TreeMap.compare(object2, object2, TreeMap.this.comparator);
                }
            }
            this.fromStart = bl;
            this.toEnd = bl3;
            this.fromKey = object;
            this.toKey = object2;
            this.fromInclusive = bl2;
            this.toInclusive = bl4;
        }

        final Entry checkLoRange(Entry entry) {
            return entry == null || this.absTooLow(entry.key) ? null : entry;
        }

        final Entry checkHiRange(Entry entry) {
            return entry == null || this.absTooHigh(entry.key) ? null : entry;
        }

        final boolean inRange(Object object) {
            return !this.absTooLow(object) && !this.absTooHigh(object);
        }

        final boolean inRangeExclusive(Object object) {
            return !(!this.fromStart && TreeMap.compare(object, this.fromKey, TreeMap.this.comparator) < 0 || !this.toEnd && TreeMap.compare(this.toKey, object, TreeMap.this.comparator) < 0);
        }

        final boolean inRange(Object object, boolean bl) {
            return bl ? this.inRange(object) : this.inRangeExclusive(object);
        }

        private boolean absTooHigh(Object object) {
            if (this.toEnd) {
                return false;
            }
            int n = TreeMap.compare(object, this.toKey, TreeMap.this.comparator);
            return n > 0 || n == 0 && !this.toInclusive;
        }

        private boolean absTooLow(Object object) {
            if (this.fromStart) {
                return false;
            }
            int n = TreeMap.compare(object, this.fromKey, TreeMap.this.comparator);
            return n < 0 || n == 0 && !this.fromInclusive;
        }

        protected abstract Entry first();

        protected abstract Entry last();

        protected abstract Entry lower(Object var1);

        protected abstract Entry floor(Object var1);

        protected abstract Entry ceiling(Object var1);

        protected abstract Entry higher(Object var1);

        protected abstract Entry uncheckedHigher(Entry var1);

        final Entry absLowest() {
            return this.checkHiRange(this.fromStart ? TreeMap.this.getFirstEntry() : (this.fromInclusive ? TreeMap.this.getCeilingEntry(this.fromKey) : TreeMap.this.getHigherEntry(this.fromKey)));
        }

        final Entry absHighest() {
            return this.checkLoRange(this.toEnd ? TreeMap.this.getLastEntry() : (this.toInclusive ? TreeMap.this.getFloorEntry(this.toKey) : TreeMap.this.getLowerEntry(this.toKey)));
        }

        final Entry absLower(Object object) {
            return this.absTooHigh(object) ? this.absHighest() : this.checkLoRange(TreeMap.this.getLowerEntry(object));
        }

        final Entry absFloor(Object object) {
            return this.absTooHigh(object) ? this.absHighest() : this.checkLoRange(TreeMap.this.getFloorEntry(object));
        }

        final Entry absCeiling(Object object) {
            return this.absTooLow(object) ? this.absLowest() : this.checkHiRange(TreeMap.this.getCeilingEntry(object));
        }

        final Entry absHigher(Object object) {
            return this.absTooLow(object) ? this.absLowest() : this.checkHiRange(TreeMap.this.getHigherEntry(object));
        }

        public Map.Entry firstEntry() {
            Entry entry = this.first();
            return entry == null ? null : new AbstractMap.SimpleImmutableEntry(entry);
        }

        public Object firstKey() {
            Entry entry = this.first();
            if (entry == null) {
                throw new NoSuchElementException();
            }
            return entry.key;
        }

        public Map.Entry lastEntry() {
            Entry entry = this.last();
            return entry == null ? null : new AbstractMap.SimpleImmutableEntry(entry);
        }

        public Object lastKey() {
            Entry entry = this.last();
            if (entry == null) {
                throw new NoSuchElementException();
            }
            return entry.key;
        }

        public Map.Entry pollFirstEntry() {
            Entry entry = this.first();
            if (entry == null) {
                return null;
            }
            AbstractMap.SimpleImmutableEntry simpleImmutableEntry = new AbstractMap.SimpleImmutableEntry(entry);
            TreeMap.this.delete(entry);
            return simpleImmutableEntry;
        }

        public Map.Entry pollLastEntry() {
            Entry entry = this.last();
            if (entry == null) {
                return null;
            }
            AbstractMap.SimpleImmutableEntry simpleImmutableEntry = new AbstractMap.SimpleImmutableEntry(entry);
            TreeMap.this.delete(entry);
            return simpleImmutableEntry;
        }

        public Map.Entry lowerEntry(Object object) {
            Entry entry = this.lower(object);
            return entry == null ? null : new AbstractMap.SimpleImmutableEntry(entry);
        }

        public Object lowerKey(Object object) {
            Entry entry = this.lower(object);
            return entry == null ? null : entry.key;
        }

        public Map.Entry floorEntry(Object object) {
            Entry entry = this.floor(object);
            return entry == null ? null : new AbstractMap.SimpleImmutableEntry(entry);
        }

        public Object floorKey(Object object) {
            Entry entry = this.floor(object);
            return entry == null ? null : entry.key;
        }

        public Map.Entry ceilingEntry(Object object) {
            Entry entry = this.ceiling(object);
            return entry == null ? null : new AbstractMap.SimpleImmutableEntry(entry);
        }

        public Object ceilingKey(Object object) {
            Entry entry = this.ceiling(object);
            return entry == null ? null : entry.key;
        }

        public Map.Entry higherEntry(Object object) {
            Entry entry = this.higher(object);
            return entry == null ? null : new AbstractMap.SimpleImmutableEntry(entry);
        }

        public Object higherKey(Object object) {
            Entry entry = this.higher(object);
            return entry == null ? null : entry.key;
        }

        public NavigableSet descendingKeySet() {
            return this.descendingMap().navigableKeySet();
        }

        public SortedMap subMap(Object object, Object object2) {
            return this.subMap(object, true, object2, false);
        }

        public SortedMap headMap(Object object) {
            return this.headMap(object, false);
        }

        public SortedMap tailMap(Object object) {
            return this.tailMap(object, true);
        }

        public int size() {
            if (this.cachedSize < 0 || this.cacheVersion != TreeMap.this.modCount) {
                this.cachedSize = this.recalculateSize();
                this.cacheVersion = TreeMap.this.modCount;
            }
            return this.cachedSize;
        }

        private int recalculateSize() {
            Entry entry = this.absHighest();
            Object object = entry != null ? entry.key : null;
            int n = 0;
            Entry entry2 = this.absLowest();
            while (entry2 != null) {
                ++n;
                entry2 = entry2.key == object ? null : TreeMap.successor(entry2);
            }
            return n;
        }

        public boolean isEmpty() {
            return this.absLowest() == null;
        }

        public boolean containsKey(Object object) {
            return this.inRange(object) && TreeMap.this.containsKey(object);
        }

        public Object get(Object object) {
            if (!this.inRange(object)) {
                return null;
            }
            return TreeMap.this.get(object);
        }

        public Object put(Object object, Object object2) {
            if (!this.inRange(object)) {
                throw new IllegalArgumentException("Key out of range");
            }
            return TreeMap.this.put(object, object2);
        }

        public Object remove(Object object) {
            if (!this.inRange(object)) {
                return null;
            }
            return TreeMap.this.remove(object);
        }

        public Set entrySet() {
            if (this.entrySet == null) {
                this.entrySet = new SubEntrySet();
            }
            return this.entrySet;
        }

        public Set keySet() {
            return this.navigableKeySet();
        }

        public NavigableSet navigableKeySet() {
            if (this.navigableKeySet == null) {
                this.navigableKeySet = new SubKeySet();
            }
            return this.navigableKeySet;
        }

        private Entry getMatchingSubEntry(Object object) {
            if (!(object instanceof Map.Entry)) {
                return null;
            }
            Map.Entry entry = (Map.Entry)object;
            Object object2 = entry.getKey();
            if (!this.inRange(object2)) {
                return null;
            }
            Entry entry2 = TreeMap.this.getEntry(object2);
            return entry2 != null && TreeMap.eq(entry2.getValue(), entry.getValue()) ? entry2 : null;
        }

        class SubKeySet
        extends AbstractSet
        implements NavigableSet {
            SubKeySet() {
            }

            public int size() {
                return NavigableSubMap.this.size();
            }

            public boolean isEmpty() {
                return NavigableSubMap.this.isEmpty();
            }

            public void clear() {
                NavigableSubMap.this.clear();
            }

            public boolean contains(Object object) {
                return TreeMap.this.getEntry(object) != null;
            }

            public boolean remove(Object object) {
                if (!NavigableSubMap.this.inRange(object)) {
                    return false;
                }
                Entry entry = TreeMap.this.getEntry(object);
                if (entry == null) {
                    return false;
                }
                TreeMap.this.delete(entry);
                return true;
            }

            public SortedSet subSet(Object object, Object object2) {
                return this.subSet(object, true, object2, false);
            }

            public SortedSet headSet(Object object) {
                return this.headSet(object, false);
            }

            public SortedSet tailSet(Object object) {
                return this.tailSet(object, true);
            }

            public Iterator iterator() {
                return new SubKeyIterator(NavigableSubMap.this.entrySet().iterator());
            }

            public Iterator descendingIterator() {
                return new SubKeyIterator(NavigableSubMap.this.descendingMap().entrySet().iterator());
            }

            public Object lower(Object object) {
                return NavigableSubMap.this.lowerKey(object);
            }

            public Object floor(Object object) {
                return NavigableSubMap.this.floorKey(object);
            }

            public Object ceiling(Object object) {
                return NavigableSubMap.this.ceilingKey(object);
            }

            public Object higher(Object object) {
                return NavigableSubMap.this.higherKey(object);
            }

            public Object first() {
                return NavigableSubMap.this.firstKey();
            }

            public Object last() {
                return NavigableSubMap.this.lastKey();
            }

            public Comparator comparator() {
                return NavigableSubMap.this.comparator();
            }

            public Object pollFirst() {
                Map.Entry entry = NavigableSubMap.this.pollFirstEntry();
                return entry == null ? null : entry.getKey();
            }

            public Object pollLast() {
                Map.Entry entry = NavigableSubMap.this.pollLastEntry();
                return entry == null ? null : entry.getKey();
            }

            public NavigableSet subSet(Object object, boolean bl, Object object2, boolean bl2) {
                return (NavigableSet)NavigableSubMap.this.subMap(object, bl, object2, bl2).keySet();
            }

            public NavigableSet headSet(Object object, boolean bl) {
                return (NavigableSet)NavigableSubMap.this.headMap(object, bl).keySet();
            }

            public NavigableSet tailSet(Object object, boolean bl) {
                return (NavigableSet)NavigableSubMap.this.tailMap(object, bl).keySet();
            }

            public NavigableSet descendingSet() {
                return (NavigableSet)NavigableSubMap.this.descendingMap().keySet();
            }
        }

        class SubEntrySet
        extends AbstractSet {
            SubEntrySet() {
            }

            public int size() {
                return NavigableSubMap.this.size();
            }

            public boolean isEmpty() {
                return NavigableSubMap.this.isEmpty();
            }

            public boolean contains(Object object) {
                return NavigableSubMap.this.getMatchingSubEntry(object) != null;
            }

            public boolean remove(Object object) {
                Entry entry = NavigableSubMap.this.getMatchingSubEntry(object);
                if (entry == null) {
                    return false;
                }
                TreeMap.this.delete(entry);
                return true;
            }

            public Iterator iterator() {
                return new SubEntryIterator();
            }
        }

        class SubKeyIterator
        implements Iterator {
            final Iterator itr;

            SubKeyIterator(Iterator iterator) {
                this.itr = iterator;
            }

            public boolean hasNext() {
                return this.itr.hasNext();
            }

            public Object next() {
                return ((Map.Entry)this.itr.next()).getKey();
            }

            public void remove() {
                this.itr.remove();
            }
        }

        class SubEntryIterator
        extends BaseEntryIterator
        implements Iterator {
            final Object terminalKey;

            SubEntryIterator() {
                super(NavigableSubMap.this.first());
                Entry entry = NavigableSubMap.this.last();
                this.terminalKey = entry == null ? null : entry.key;
            }

            public boolean hasNext() {
                return this.cursor != null;
            }

            public Object next() {
                Entry entry = this.cursor;
                if (entry == null) {
                    throw new NoSuchElementException();
                }
                if (this.expectedModCount != TreeMap.this.modCount) {
                    throw new ConcurrentModificationException();
                }
                this.cursor = entry.key == this.terminalKey ? null : NavigableSubMap.this.uncheckedHigher(entry);
                this.lastRet = entry;
                return entry;
            }
        }
    }

    class DescendingKeySet
    extends KeySet {
        DescendingKeySet() {
        }

        public Iterator iterator() {
            return new DescendingKeyIterator(TreeMap.this.getLastEntry());
        }

        public Iterator descendingIterator() {
            return new KeyIterator(TreeMap.this.getFirstEntry());
        }

        public Object lower(Object object) {
            return TreeMap.this.higherKey(object);
        }

        public Object floor(Object object) {
            return TreeMap.this.ceilingKey(object);
        }

        public Object ceiling(Object object) {
            return TreeMap.this.floorKey(object);
        }

        public Object higher(Object object) {
            return TreeMap.this.lowerKey(object);
        }

        public Object first() {
            return TreeMap.this.lastKey();
        }

        public Object last() {
            return TreeMap.this.firstKey();
        }

        public Comparator comparator() {
            return TreeMap.this.descendingMap().comparator();
        }

        public Object pollFirst() {
            Map.Entry entry = TreeMap.this.pollLastEntry();
            return entry == null ? null : entry.getKey();
        }

        public Object pollLast() {
            Map.Entry entry = TreeMap.this.pollFirstEntry();
            return entry == null ? null : entry.getKey();
        }

        public NavigableSet subSet(Object object, boolean bl, Object object2, boolean bl2) {
            return (NavigableSet)TreeMap.this.descendingMap().subMap(object, bl, object2, bl2).keySet();
        }

        public NavigableSet headSet(Object object, boolean bl) {
            return (NavigableSet)TreeMap.this.descendingMap().headMap(object, bl).keySet();
        }

        public NavigableSet tailSet(Object object, boolean bl) {
            return (NavigableSet)TreeMap.this.descendingMap().tailMap(object, bl).keySet();
        }

        public NavigableSet descendingSet() {
            return (NavigableSet)TreeMap.this.keySet();
        }
    }

    class DescendingSubMap
    extends NavigableSubMap {
        DescendingSubMap(boolean bl, Object object, boolean bl2, boolean bl3, Object object2, boolean bl4) {
            super(bl, object, bl2, bl3, object2, bl4);
        }

        public Comparator comparator() {
            return TreeMap.this.reverseComparator();
        }

        protected Entry first() {
            return this.absHighest();
        }

        protected Entry last() {
            return this.absLowest();
        }

        protected Entry lower(Object object) {
            return this.absHigher(object);
        }

        protected Entry floor(Object object) {
            return this.absCeiling(object);
        }

        protected Entry ceiling(Object object) {
            return this.absFloor(object);
        }

        protected Entry higher(Object object) {
            return this.absLower(object);
        }

        protected Entry uncheckedHigher(Entry entry) {
            return TreeMap.predecessor(entry);
        }

        public NavigableMap subMap(Object object, boolean bl, Object object2, boolean bl2) {
            if (!this.inRange(object, bl)) {
                throw new IllegalArgumentException("fromKey out of range");
            }
            if (!this.inRange(object2, bl2)) {
                throw new IllegalArgumentException("toKey out of range");
            }
            return new DescendingSubMap(false, object2, bl2, false, object, bl);
        }

        public NavigableMap headMap(Object object, boolean bl) {
            if (!this.inRange(object, bl)) {
                throw new IllegalArgumentException("toKey out of range");
            }
            return new DescendingSubMap(false, object, bl, this.toEnd, this.toKey, this.toInclusive);
        }

        public NavigableMap tailMap(Object object, boolean bl) {
            if (!this.inRange(object, bl)) {
                throw new IllegalArgumentException("fromKey out of range");
            }
            return new DescendingSubMap(this.fromStart, this.fromKey, this.fromInclusive, false, object, bl);
        }

        public NavigableMap descendingMap() {
            if (this.descendingMap == null) {
                this.descendingMap = new AscendingSubMap(this.fromStart, this.fromKey, this.fromInclusive, this.toEnd, this.toKey, this.toInclusive);
            }
            return this.descendingMap;
        }
    }

    private class BaseEntryIterator {
        Entry cursor;
        Entry lastRet;
        int expectedModCount;

        BaseEntryIterator(Entry entry) {
            this.cursor = entry;
            this.expectedModCount = TreeMap.this.modCount;
        }

        public boolean hasNext() {
            return this.cursor != null;
        }

        Entry nextEntry() {
            Entry entry = this.cursor;
            if (entry == null) {
                throw new NoSuchElementException();
            }
            if (this.expectedModCount != TreeMap.this.modCount) {
                throw new ConcurrentModificationException();
            }
            this.cursor = TreeMap.successor(entry);
            this.lastRet = entry;
            return entry;
        }

        Entry prevEntry() {
            Entry entry = this.cursor;
            if (entry == null) {
                throw new NoSuchElementException();
            }
            if (this.expectedModCount != TreeMap.this.modCount) {
                throw new ConcurrentModificationException();
            }
            this.cursor = TreeMap.predecessor(entry);
            this.lastRet = entry;
            return entry;
        }

        public void remove() {
            if (this.lastRet == null) {
                throw new IllegalStateException();
            }
            if (this.expectedModCount != TreeMap.this.modCount) {
                throw new ConcurrentModificationException();
            }
            if (this.lastRet.left != null && this.lastRet.right != null && this.cursor != null) {
                this.cursor = this.lastRet;
            }
            TreeMap.this.delete(this.lastRet);
            this.lastRet = null;
            ++this.expectedModCount;
        }
    }

    class DescendingEntrySet
    extends EntrySet {
        DescendingEntrySet() {
        }

        public Iterator iterator() {
            return new DescendingEntryIterator(TreeMap.this.getLastEntry());
        }
    }

    static class IteratorIOException
    extends RuntimeException {
        IteratorIOException(IOException iOException) {
            super(iOException);
        }

        IOException getException() {
            return (IOException)this.getCause();
        }
    }

    class DescendingKeyIterator
    extends BaseEntryIterator
    implements Iterator {
        DescendingKeyIterator(Entry entry) {
            super(entry);
        }

        public Object next() {
            return this.prevEntry().key;
        }
    }

    class DescendingEntryIterator
    extends BaseEntryIterator
    implements Iterator {
        DescendingEntryIterator(Entry entry) {
            super(entry);
        }

        public Object next() {
            return this.prevEntry();
        }
    }

    class DescendingValueIterator
    extends BaseEntryIterator
    implements Iterator {
        DescendingValueIterator(Entry entry) {
            super(entry);
        }

        public Object next() {
            return this.prevEntry().element;
        }
    }

    static class IteratorNoClassException
    extends RuntimeException {
        IteratorNoClassException(ClassNotFoundException classNotFoundException) {
            super(classNotFoundException);
        }

        ClassNotFoundException getException() {
            return (ClassNotFoundException)this.getCause();
        }
    }
}

