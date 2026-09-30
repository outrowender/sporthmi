/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util;

import edu.emory.mathcs.backport.java.util.AbstractQueue;
import edu.emory.mathcs.backport.java.util.AbstractSet;
import edu.emory.mathcs.backport.java.util.Arrays;
import edu.emory.mathcs.backport.java.util.Deque;
import edu.emory.mathcs.backport.java.util.Queue;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;

public class Collections {
    static /* synthetic */ Class class$edu$emory$mathcs$backport$java$util$Collections$CheckedMap$EntryView;

    private Collections() {
    }

    public static void sort(List list) {
        java.util.Collections.sort(list);
    }

    public static void sort(List list, Comparator comparator) {
        java.util.Collections.sort(list, comparator);
    }

    public static int binarySearch(List list, Object object) {
        return java.util.Collections.binarySearch(list, object);
    }

    public static int binarySearch(List list, Object object, Comparator comparator) {
        return java.util.Collections.binarySearch(list, object, comparator);
    }

    public static void reverse(List list) {
        java.util.Collections.reverse(list);
    }

    public static void shuffle(List list) {
        java.util.Collections.shuffle(list);
    }

    public static void shuffle(List list, Random random) {
        java.util.Collections.shuffle(list, random);
    }

    public static void swap(List list, int n, int n2) {
        java.util.Collections.swap(list, n, n);
    }

    public static void fill(List list, Object object) {
        java.util.Collections.fill(list, object);
    }

    public static void copy(List list, List list2) {
        java.util.Collections.copy(list, list2);
    }

    public static Object min(Collection collection) {
        return java.util.Collections.min(collection);
    }

    public static Object min(Collection collection, Comparator comparator) {
        return java.util.Collections.min(collection, comparator);
    }

    public static Object max(Collection collection) {
        return java.util.Collections.max(collection);
    }

    public static Object max(Collection collection, Comparator comparator) {
        return java.util.Collections.max(collection, comparator);
    }

    public static void rotate(List list, int n) {
        java.util.Collections.rotate(list, n);
    }

    public static boolean replaceAll(List list, Object object, Object object2) {
        return java.util.Collections.replaceAll(list, object, object2);
    }

    public static int indexOfSubList(List list, List list2) {
        return java.util.Collections.indexOfSubList(list, list2);
    }

    public static int lastIndexOfSubList(List list, List list2) {
        return java.util.Collections.lastIndexOfSubList(list, list2);
    }

    public static Collection unmodifiableCollection(Collection collection) {
        return java.util.Collections.unmodifiableCollection(collection);
    }

    public static Set unmodifiableSet(Set set) {
        return java.util.Collections.unmodifiableSet(set);
    }

    public static SortedSet unmodifiableSortedSet(SortedSet sortedSet) {
        return java.util.Collections.unmodifiableSortedSet(sortedSet);
    }

    public static List unmodifiableList(List list) {
        return java.util.Collections.unmodifiableList(list);
    }

    public static Map unmodifiableMap(Map map) {
        return java.util.Collections.unmodifiableMap(map);
    }

    public static SortedMap unmodifiableSortedMap(SortedMap sortedMap) {
        return java.util.Collections.unmodifiableSortedMap(sortedMap);
    }

    public static Collection synchronizedCollection(Collection collection) {
        return java.util.Collections.synchronizedCollection(collection);
    }

    public static Set synchronizedSet(Set set) {
        return java.util.Collections.synchronizedSet(set);
    }

    public static SortedSet synchronizedSortedSet(SortedSet sortedSet) {
        return java.util.Collections.synchronizedSortedSet(sortedSet);
    }

    public static List synchronizedList(List list) {
        return java.util.Collections.synchronizedList(list);
    }

    public static Map synchronizedMap(Map map) {
        return java.util.Collections.synchronizedMap(map);
    }

    public static SortedMap synchronizedSortedMap(SortedMap sortedMap) {
        return java.util.Collections.synchronizedSortedMap(sortedMap);
    }

    public static Collection checkedCollection(Collection collection, Class clazz) {
        return new CheckedCollection(collection, clazz);
    }

    public static Set checkedSet(Set set, Class clazz) {
        return new CheckedSet(set, clazz);
    }

    public static SortedSet checkedSortedSet(SortedSet sortedSet, Class clazz) {
        return new CheckedSortedSet(sortedSet, clazz);
    }

    public static List checkedList(List list, Class clazz) {
        return new CheckedList(list, clazz);
    }

    public static Map checkedMap(Map map, Class clazz, Class clazz2) {
        return new CheckedMap(map, clazz, clazz2);
    }

    public static SortedMap checkedSortedMap(SortedMap sortedMap, Class clazz, Class clazz2) {
        return new CheckedSortedMap(sortedMap, clazz, clazz2);
    }

    public static Set emptySet() {
        return java.util.Collections.EMPTY_SET;
    }

    public static List emptyList() {
        return java.util.Collections.EMPTY_LIST;
    }

    public static Map emptyMap() {
        return java.util.Collections.EMPTY_MAP;
    }

    public static Set singleton(Object object) {
        return java.util.Collections.singleton(object);
    }

    public static List singletonList(Object object) {
        return java.util.Collections.singletonList(object);
    }

    public static Map singletonMap(Object object, Object object2) {
        return java.util.Collections.singletonMap(object, object2);
    }

    public static List nCopies(int n, Object object) {
        return java.util.Collections.nCopies(n, object);
    }

    public static Comparator reverseOrder() {
        return java.util.Collections.reverseOrder();
    }

    public static Comparator reverseOrder(Comparator comparator) {
        return comparator instanceof ReverseComparator ? ((ReverseComparator)comparator).cmp : (comparator == null ? Collections.reverseOrder() : new ReverseComparator(comparator));
    }

    public static Enumeration enumeration(Collection collection) {
        return java.util.Collections.enumeration(collection);
    }

    public static ArrayList list(Enumeration enumeration) {
        return java.util.Collections.list(enumeration);
    }

    public static int frequency(Collection collection, Object object) {
        int n = 0;
        if (object == null) {
            Iterator iterator = collection.iterator();
            while (iterator.hasNext()) {
                if (iterator.next() != null) continue;
                ++n;
            }
        } else {
            Iterator iterator = collection.iterator();
            while (iterator.hasNext()) {
                if (!object.equals(iterator.next())) continue;
                ++n;
            }
        }
        return n;
    }

    public static boolean disjoint(Collection collection, Collection object) {
        Object object2;
        if (collection instanceof Set && (!(object instanceof Set) || collection.size() < object.size())) {
            object2 = collection;
            collection = object;
            object = object2;
        }
        object2 = collection.iterator();
        while (object2.hasNext()) {
            if (!object.contains(object2.next())) continue;
            return false;
        }
        return true;
    }

    public static boolean addAll(Collection collection, Object[] objectArray) {
        boolean bl = false;
        for (int i2 = 0; i2 < objectArray.length; ++i2) {
            bl |= collection.add(objectArray[i2]);
        }
        return bl;
    }

    public static Set newSetFromMap(Map map) {
        return new SetFromMap(map);
    }

    public static Queue asLifoQueue(Deque deque) {
        return new AsLifoQueue(deque);
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

    private static class CheckedMap
    implements Map,
    Serializable {
        final Map map;
        final Class keyType;
        final Class valueType;
        transient Set entrySet;
        private transient Object[] emptyKeyArray;
        private transient Object[] emptyValueArray;

        CheckedMap(Map map, Class clazz, Class clazz2) {
            if (map == null || clazz == null || clazz2 == null) {
                throw new NullPointerException();
            }
            this.map = map;
            this.keyType = clazz;
            this.valueType = clazz2;
        }

        private void typeCheckKey(Object object) {
            if (!this.keyType.isInstance(object)) {
                throw new ClassCastException(new StringBuffer().append("Attempted to use a key of type ").append(object.getClass().getName()).append(" with a map with keys of type ").append(this.keyType.getName()).toString());
            }
        }

        private void typeCheckValue(Object object) {
            if (!this.valueType.isInstance(object)) {
                throw new ClassCastException(new StringBuffer().append("Attempted to use a value of type ").append(object.getClass().getName()).append(" with a map with values of type ").append(this.valueType.getName()).toString());
            }
        }

        public int hashCode() {
            return ((Object)this.map).hashCode();
        }

        public boolean equals(Object object) {
            return object == this || ((Object)this.map).equals(object);
        }

        public int size() {
            return this.map.size();
        }

        public void clear() {
            this.map.clear();
        }

        public boolean isEmpty() {
            return this.map.isEmpty();
        }

        public boolean containsKey(Object object) {
            return this.map.containsKey(object);
        }

        public boolean containsValue(Object object) {
            return this.map.containsValue(object);
        }

        public Collection values() {
            return this.map.values();
        }

        public Set keySet() {
            return this.map.keySet();
        }

        public void putAll(Map map) {
            Object[] objectArray;
            Object[] objectArray2;
            if (this.emptyKeyArray == null) {
                this.emptyKeyArray = (Object[])Array.newInstance(this.keyType, 0);
            }
            if (this.emptyValueArray == null) {
                this.emptyValueArray = (Object[])Array.newInstance(this.valueType, 0);
            }
            try {
                objectArray2 = map.keySet().toArray(this.emptyKeyArray);
            }
            catch (ArrayStoreException arrayStoreException) {
                throw new ClassCastException(new StringBuffer().append("Attempted to use an invalid key type  with a map with keys of type ").append(this.keyType.getName()).toString());
            }
            try {
                objectArray = map.keySet().toArray(this.emptyKeyArray);
            }
            catch (ArrayStoreException arrayStoreException) {
                throw new ClassCastException(new StringBuffer().append("Attempted to use an invalid value type  with a map with values of type ").append(this.valueType.getName()).toString());
            }
            if (objectArray2.length != objectArray.length) {
                throw new ConcurrentModificationException();
            }
            for (int i2 = 0; i2 < objectArray2.length; ++i2) {
                this.map.put(objectArray2[i2], objectArray[i2]);
            }
        }

        public Set entrySet() {
            if (this.entrySet == null) {
                this.entrySet = new EntrySetView(this.map.entrySet());
            }
            return this.entrySet;
        }

        public Object get(Object object) {
            return this.map.get(object);
        }

        public Object remove(Object object) {
            return this.map.remove(object);
        }

        public Object put(Object object, Object object2) {
            this.typeCheckKey(object);
            this.typeCheckValue(object2);
            return this.map.put(object, object2);
        }

        private class EntryView
        implements Map.Entry,
        Serializable {
            final Map.Entry entry;

            EntryView(Map.Entry entry) {
                this.entry = entry;
            }

            public Object getKey() {
                return this.entry.getKey();
            }

            public Object getValue() {
                return this.entry.getValue();
            }

            public int hashCode() {
                return ((Object)this.entry).hashCode();
            }

            public boolean equals(Object object) {
                if (object == this) {
                    return true;
                }
                if (!(object instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry)object;
                return Collections.eq(this.getKey(), entry.getKey()) && Collections.eq(this.getValue(), entry.getValue());
            }

            public Object setValue(Object object) {
                CheckedMap.this.typeCheckValue(object);
                return this.entry.setValue(object);
            }
        }

        private class EntrySetView
        extends AbstractSet
        implements Set {
            final Set entrySet;

            EntrySetView(Set set) {
                this.entrySet = set;
            }

            public int size() {
                return this.entrySet.size();
            }

            public boolean isEmpty() {
                return this.entrySet.isEmpty();
            }

            public boolean remove(Object object) {
                return this.entrySet.remove(object);
            }

            public void clear() {
                this.entrySet.clear();
            }

            public boolean contains(Object object) {
                if (!(object instanceof Map.Entry)) {
                    return false;
                }
                return this.entrySet.contains(new EntryView((Map.Entry)object));
            }

            public Iterator iterator() {
                final Iterator iterator = this.entrySet.iterator();
                return new Iterator(){

                    public boolean hasNext() {
                        return iterator.hasNext();
                    }

                    public Object next() {
                        return new EntryView((Map.Entry)iterator.next());
                    }

                    public void remove() {
                        iterator.remove();
                    }
                };
            }

            public Object[] toArray() {
                Object[] objectArray = this.entrySet.toArray();
                if (objectArray.getClass().getComponentType().isAssignableFrom(class$edu$emory$mathcs$backport$java$util$Collections$CheckedMap$EntryView == null ? (class$edu$emory$mathcs$backport$java$util$Collections$CheckedMap$EntryView = Collections.class$("edu.emory.mathcs.backport.java.util.Collections$CheckedMap$EntryView")) : class$edu$emory$mathcs$backport$java$util$Collections$CheckedMap$EntryView)) {
                    for (int i2 = 0; i2 < objectArray.length; ++i2) {
                        objectArray[i2] = new EntryView((Map.Entry)objectArray[i2]);
                    }
                    return objectArray;
                }
                Object[] objectArray2 = new Object[objectArray.length];
                for (int i3 = 0; i3 < objectArray.length; ++i3) {
                    objectArray2[i3] = new EntryView((Map.Entry)objectArray[i3]);
                }
                return objectArray2;
            }

            public Object[] toArray(Object[] objectArray) {
                Object[] objectArray2 = objectArray.length == 0 ? objectArray : (Object[])Array.newInstance(objectArray.getClass().getComponentType(), objectArray.length);
                objectArray2 = this.entrySet.toArray(objectArray2);
                for (int i2 = 0; i2 < objectArray2.length; ++i2) {
                    objectArray2[i2] = new EntryView((Map.Entry)objectArray2[i2]);
                }
                if (objectArray2.length > objectArray.length) {
                    objectArray = objectArray2;
                } else {
                    System.arraycopy((Object)objectArray2, 0, (Object)objectArray, 0, objectArray2.length);
                    if (objectArray2.length < objectArray.length) {
                        objectArray[objectArray2.length] = null;
                    }
                }
                return objectArray;
            }
        }
    }

    private static class CheckedSet
    extends CheckedCollection
    implements Set,
    Serializable {
        CheckedSet(Set set, Class clazz) {
            super(set, clazz);
        }

        public int hashCode() {
            return ((Object)this.coll).hashCode();
        }

        public boolean equals(Object object) {
            return object == this || ((Object)this.coll).equals(object);
        }
    }

    private static class SetFromMap
    extends AbstractSet
    implements Serializable {
        private static final Object PRESENT = Boolean.TRUE;
        final Map map;
        transient Set keySet;

        SetFromMap(Map map) {
            this.map = map;
            this.keySet = map.keySet();
        }

        public int hashCode() {
            return ((Object)this.keySet).hashCode();
        }

        public int size() {
            return this.map.size();
        }

        public void clear() {
            this.map.clear();
        }

        public boolean isEmpty() {
            return this.map.isEmpty();
        }

        public boolean add(Object object) {
            return this.map.put(object, PRESENT) == null;
        }

        public boolean contains(Object object) {
            return this.map.containsKey(object);
        }

        public boolean equals(Object object) {
            return object == this || ((Object)this.keySet).equals(object);
        }

        public boolean remove(Object object) {
            return this.map.remove(object) == PRESENT;
        }

        public boolean removeAll(Collection collection) {
            return this.keySet.removeAll(collection);
        }

        public boolean retainAll(Collection collection) {
            return this.keySet.retainAll(collection);
        }

        public Iterator iterator() {
            return this.keySet.iterator();
        }

        public Object[] toArray() {
            return this.keySet.toArray();
        }

        public Object[] toArray(Object[] objectArray) {
            return this.keySet.toArray(objectArray);
        }

        public boolean addAll(Collection collection) {
            boolean bl = false;
            Iterator iterator = collection.iterator();
            while (iterator.hasNext()) {
                bl |= this.map.put(iterator.next(), PRESENT) == null;
            }
            return bl;
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            objectInputStream.defaultReadObject();
            this.keySet = this.map.keySet();
        }
    }

    private static class AsLifoQueue
    extends AbstractQueue
    implements Queue,
    Serializable {
        final Deque deque;

        AsLifoQueue(Deque deque) {
            this.deque = deque;
        }

        public boolean add(Object object) {
            return this.deque.offerFirst(object);
        }

        public boolean offer(Object object) {
            return this.deque.offerFirst(object);
        }

        public Object remove() {
            return this.deque.removeFirst();
        }

        public Object poll() {
            return this.deque.pollFirst();
        }

        public Object element() {
            return this.deque.getFirst();
        }

        public Object peek() {
            return this.deque.peekFirst();
        }

        public int size() {
            return this.deque.size();
        }

        public void clear() {
            this.deque.clear();
        }

        public boolean isEmpty() {
            return this.deque.isEmpty();
        }

        public Object[] toArray() {
            return this.deque.toArray();
        }

        public Object[] toArray(Object[] objectArray) {
            return this.deque.toArray(objectArray);
        }

        public boolean contains(Object object) {
            return this.deque.contains(object);
        }

        public boolean remove(Object object) {
            return this.deque.remove(object);
        }

        public Iterator iterator() {
            return this.deque.iterator();
        }

        public String toString() {
            return this.deque.toString();
        }

        public boolean containsAll(Collection collection) {
            return this.deque.containsAll(collection);
        }

        public boolean removeAll(Collection collection) {
            return this.deque.removeAll(collection);
        }

        public boolean retainAll(Collection collection) {
            return this.deque.retainAll(collection);
        }
    }

    private static class CheckedList
    extends CheckedCollection
    implements List,
    Serializable {
        final List list;

        CheckedList(List list, Class clazz) {
            super(list, clazz);
            this.list = list;
        }

        public Object get(int n) {
            return this.list.get(n);
        }

        public Object remove(int n) {
            return this.list.remove(n);
        }

        public int indexOf(Object object) {
            return this.list.indexOf(object);
        }

        public int lastIndexOf(Object object) {
            return this.list.lastIndexOf(object);
        }

        public int hashCode() {
            return ((Object)this.list).hashCode();
        }

        public boolean equals(Object object) {
            return object == this || ((Object)this.list).equals(object);
        }

        public Object set(int n, Object object) {
            this.typeCheck(object);
            return this.list.set(n, object);
        }

        public void add(int n, Object object) {
            this.typeCheck(object);
            this.list.add(n, object);
        }

        public boolean addAll(int n, Collection collection) {
            Object[] objectArray;
            try {
                objectArray = collection.toArray(this.getEmptyArr());
            }
            catch (ArrayStoreException arrayStoreException) {
                throw new ClassCastException("Attempted to insert an element of invalid type  to a list of type " + this.type.getName());
            }
            return this.list.addAll(n, Arrays.asList(objectArray));
        }

        public List subList(int n, int n2) {
            return new CheckedList(this.list.subList(n, n2), this.type);
        }

        public ListIterator listIterator() {
            return new ListItr(this.list.listIterator());
        }

        public ListIterator listIterator(int n) {
            return new ListItr(this.list.listIterator(n));
        }

        private class ListItr
        implements ListIterator {
            final ListIterator itr;

            ListItr(ListIterator listIterator) {
                this.itr = listIterator;
            }

            public boolean hasNext() {
                return this.itr.hasNext();
            }

            public boolean hasPrevious() {
                return this.itr.hasPrevious();
            }

            public int nextIndex() {
                return this.itr.nextIndex();
            }

            public int previousIndex() {
                return this.itr.previousIndex();
            }

            public Object next() {
                return this.itr.next();
            }

            public Object previous() {
                return this.itr.previous();
            }

            public void remove() {
                this.itr.remove();
            }

            public void set(Object object) {
                CheckedList.this.typeCheck(object);
                this.itr.set(object);
            }

            public void add(Object object) {
                CheckedList.this.typeCheck(object);
                this.itr.add(object);
            }
        }
    }

    private static class CheckedSortedMap
    extends CheckedMap
    implements SortedMap,
    Serializable {
        final SortedMap map;

        CheckedSortedMap(SortedMap sortedMap, Class clazz, Class clazz2) {
            super(sortedMap, clazz, clazz2);
            this.map = sortedMap;
        }

        public Comparator comparator() {
            return this.map.comparator();
        }

        public Object firstKey() {
            return this.map.firstKey();
        }

        public Object lastKey() {
            return this.map.lastKey();
        }

        public SortedMap subMap(Object object, Object object2) {
            return new CheckedSortedMap(this.map.subMap(object, object2), this.keyType, this.valueType);
        }

        public SortedMap headMap(Object object) {
            return new CheckedSortedMap(this.map.headMap(object), this.keyType, this.valueType);
        }

        public SortedMap tailMap(Object object) {
            return new CheckedSortedMap(this.map.tailMap(object), this.keyType, this.valueType);
        }
    }

    private static class CheckedSortedSet
    extends CheckedSet
    implements SortedSet,
    Serializable {
        final SortedSet set;

        CheckedSortedSet(SortedSet sortedSet, Class clazz) {
            super(sortedSet, clazz);
            this.set = sortedSet;
        }

        public Object first() {
            return this.set.first();
        }

        public Object last() {
            return this.set.last();
        }

        public Comparator comparator() {
            return this.set.comparator();
        }

        public SortedSet headSet(Object object) {
            return new CheckedSortedSet(this.set.headSet(object), this.type);
        }

        public SortedSet tailSet(Object object) {
            return new CheckedSortedSet(this.set.tailSet(object), this.type);
        }

        public SortedSet subSet(Object object, Object object2) {
            return new CheckedSortedSet(this.set.subSet(object, object2), this.type);
        }
    }

    private static class CheckedCollection
    implements Collection,
    Serializable {
        final Collection coll;
        final Class type;
        transient Object[] emptyArr;

        CheckedCollection(Collection collection, Class clazz) {
            if (collection == null || clazz == null) {
                throw new NullPointerException();
            }
            this.coll = collection;
            this.type = clazz;
        }

        void typeCheck(Object object) {
            if (!this.type.isInstance(object)) {
                throw new ClassCastException("Attempted to insert an element of type " + object.getClass().getName() + " to a collection of type " + this.type.getName());
            }
        }

        public int size() {
            return this.coll.size();
        }

        public void clear() {
            this.coll.clear();
        }

        public boolean isEmpty() {
            return this.coll.isEmpty();
        }

        public Object[] toArray() {
            return this.coll.toArray();
        }

        public Object[] toArray(Object[] objectArray) {
            return this.coll.toArray(objectArray);
        }

        public boolean contains(Object object) {
            return this.coll.contains(object);
        }

        public boolean remove(Object object) {
            return this.coll.remove(object);
        }

        public boolean containsAll(Collection collection) {
            return this.coll.containsAll(collection);
        }

        public boolean removeAll(Collection collection) {
            return this.coll.removeAll(collection);
        }

        public boolean retainAll(Collection collection) {
            return this.coll.retainAll(collection);
        }

        public String toString() {
            return this.coll.toString();
        }

        public boolean add(Object object) {
            this.typeCheck(object);
            return this.coll.add(object);
        }

        public boolean addAll(Collection collection) {
            Object[] objectArray;
            try {
                objectArray = collection.toArray(this.getEmptyArr());
            }
            catch (ArrayStoreException arrayStoreException) {
                throw new ClassCastException("Attempted to insert an element of invalid type  to a collection of type " + this.type.getName());
            }
            return this.coll.addAll(Arrays.asList(objectArray));
        }

        public Iterator iterator() {
            return new Itr(this.coll.iterator());
        }

        protected Object[] getEmptyArr() {
            if (this.emptyArr == null) {
                this.emptyArr = (Object[])Array.newInstance(this.type, 0);
            }
            return this.emptyArr;
        }

        class Itr
        implements Iterator {
            final Iterator itr;

            Itr(Iterator iterator) {
                this.itr = iterator;
            }

            public boolean hasNext() {
                return this.itr.hasNext();
            }

            public Object next() {
                return this.itr.next();
            }

            public void remove() {
                this.itr.remove();
            }
        }
    }

    private static class ReverseComparator
    implements Comparator,
    Serializable {
        final Comparator cmp;

        ReverseComparator(Comparator comparator) {
            this.cmp = comparator;
        }

        public int compare(Object object, Object object2) {
            return this.cmp.compare(object2, object);
        }

        public boolean equals(Object object) {
            return object == this || object instanceof ReverseComparator && ((Object)this.cmp).equals(((ReverseComparator)object).cmp);
        }

        public int hashCode() {
            return this.cmp.hashCode() ^ 0x10000000;
        }
    }
}

