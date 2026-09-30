/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.AbstractList;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.RandomAccess;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;

public class Collections {
    public static final List EMPTY_LIST = new EmptyList();
    public static final Set EMPTY_SET = new EmptySet();
    public static final Map EMPTY_MAP = new EmptyMap();

    private Collections() {
    }

    public static int binarySearch(List list, Object object) {
        if (list == null) {
            throw new NullPointerException();
        }
        Comparable comparable = (Comparable)object;
        if (!(list instanceof RandomAccess)) {
            ListIterator listIterator = list.listIterator();
            while (listIterator.hasNext()) {
                int n = comparable.compareTo(listIterator.next());
                if (n > 0) continue;
                if (n == 0) {
                    return listIterator.previousIndex();
                }
                return -listIterator.previousIndex() - 1;
            }
            return -list.size() - 1;
        }
        int n = 0;
        int n2 = list.size();
        int n3 = n2 - 1;
        int n4 = -1;
        while (n <= n3) {
            n2 = n + n3 >> 1;
            n4 = comparable.compareTo(list.get(n2));
            if (n4 > 0) {
                n = n2 + 1;
                continue;
            }
            if (n4 == 0) {
                return n2;
            }
            n3 = n2 - 1;
        }
        return -n2 - (n4 < 0 ? 1 : 2);
    }

    public static int binarySearch(List list, Object object, Comparator comparator) {
        if (comparator == null) {
            return Collections.binarySearch(list, object);
        }
        if (!(list instanceof RandomAccess)) {
            ListIterator listIterator = list.listIterator();
            while (listIterator.hasNext()) {
                int n = comparator.compare(object, listIterator.next());
                if (n > 0) continue;
                if (n == 0) {
                    return listIterator.previousIndex();
                }
                return -listIterator.previousIndex() - 1;
            }
            return -list.size() - 1;
        }
        int n = 0;
        int n2 = list.size();
        int n3 = n2 - 1;
        int n4 = -1;
        while (n <= n3) {
            n2 = n + n3 >> 1;
            n4 = comparator.compare(object, list.get(n2));
            if (n4 > 0) {
                n = n2 + 1;
                continue;
            }
            if (n4 == 0) {
                return n2;
            }
            n3 = n2 - 1;
        }
        return -n2 - (n4 < 0 ? 1 : 2);
    }

    public static void copy(List list, List list2) {
        if (list.size() < list2.size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        Iterator iterator = list2.iterator();
        ListIterator listIterator = list.listIterator();
        while (iterator.hasNext()) {
            try {
                listIterator.next();
            }
            catch (NoSuchElementException noSuchElementException) {
                throw new ArrayIndexOutOfBoundsException();
            }
            listIterator.set(iterator.next());
        }
    }

    public static Enumeration enumeration(Collection collection) {
        return new Enumeration(collection){
            Iterator it;
            {
                this.it = collection.iterator();
            }

            public boolean hasMoreElements() {
                return this.it.hasNext();
            }

            public Object nextElement() {
                return this.it.next();
            }
        };
    }

    public static void fill(List list, Object object) {
        ListIterator listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            listIterator.next();
            listIterator.set(object);
        }
    }

    public static Object max(Collection collection) {
        Iterator iterator = collection.iterator();
        Comparable comparable = (Comparable)iterator.next();
        while (iterator.hasNext()) {
            Object object = iterator.next();
            if (comparable.compareTo(object) >= 0) continue;
            comparable = (Comparable)object;
        }
        return comparable;
    }

    public static Object max(Collection collection, Comparator comparator) {
        Iterator iterator = collection.iterator();
        Object object = iterator.next();
        while (iterator.hasNext()) {
            Object object2 = iterator.next();
            if (comparator.compare(object, object2) >= 0) continue;
            object = object2;
        }
        return object;
    }

    public static Object min(Collection collection) {
        Iterator iterator = collection.iterator();
        Comparable comparable = (Comparable)iterator.next();
        while (iterator.hasNext()) {
            Object object = iterator.next();
            if (comparable.compareTo(object) <= 0) continue;
            comparable = (Comparable)object;
        }
        return comparable;
    }

    public static Object min(Collection collection, Comparator comparator) {
        Iterator iterator = collection.iterator();
        Object object = iterator.next();
        while (iterator.hasNext()) {
            Object object2 = iterator.next();
            if (comparator.compare(object, object2) <= 0) continue;
            object = object2;
        }
        return object;
    }

    public static List nCopies(int n, Object object) {
        return new CopiesList(n, object);
    }

    public static void reverse(List list) {
        int n = list.size();
        ListIterator listIterator = list.listIterator();
        ListIterator listIterator2 = list.listIterator(n);
        int n2 = 0;
        while (n2 < n / 2) {
            Object object = listIterator.next();
            listIterator.set(listIterator2.previous());
            listIterator2.set(object);
            ++n2;
        }
    }

    public static Comparator reverseOrder() {
        return new ReverseComparator();
    }

    public static void shuffle(List list) {
        Collections.shuffle(list, new Random());
    }

    public static void shuffle(List list, Random random) {
        if (!(list instanceof RandomAccess)) {
            Object[] objectArray = list.toArray();
            int n = objectArray.length - 1;
            while (n > 0) {
                int n2 = random.nextInt() % (n + 1);
                if (n2 < 0) {
                    n2 = -n2;
                }
                Object object = objectArray[n];
                objectArray[n] = objectArray[n2];
                objectArray[n2] = object;
                --n;
            }
            n = 0;
            ListIterator listIterator = list.listIterator();
            while (listIterator.hasNext()) {
                listIterator.next();
                listIterator.set(objectArray[n++]);
            }
        } else {
            int n = list.size() - 1;
            while (n > 0) {
                int n3 = random.nextInt() % (n + 1);
                if (n3 < 0) {
                    n3 = -n3;
                }
                list.set(n3, list.set(n, list.get(n3)));
                --n;
            }
        }
    }

    public static Set singleton(Object object) {
        return new SingletonSet(object);
    }

    public static List singletonList(Object object) {
        return new SingletonList(object);
    }

    public static Map singletonMap(Object object, Object object2) {
        return new SingletonMap(object, object2);
    }

    public static void sort(List list) {
        Object[] objectArray = list.toArray();
        Arrays.sort(objectArray);
        int n = 0;
        ListIterator listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            listIterator.next();
            listIterator.set(objectArray[n++]);
        }
    }

    public static void sort(List list, Comparator comparator) {
        Object[] objectArray = list.toArray();
        Arrays.sort(objectArray, comparator);
        int n = 0;
        ListIterator listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            listIterator.next();
            listIterator.set(objectArray[n++]);
        }
    }

    public static void swap(List list, int n, int n2) {
        if (list == null) {
            throw new NullPointerException();
        }
        if (n == n2) {
            return;
        }
        list.set(n2, list.set(n, list.get(n2)));
    }

    public static boolean replaceAll(List list, Object object, Object object2) {
        int n;
        boolean bl = false;
        while ((n = list.indexOf(object)) > -1) {
            bl = true;
            list.set(n, object2);
        }
        return bl;
    }

    public static void rotate(List list, int n) {
        int n2 = list.size();
        if (n2 == 0) {
            return;
        }
        n = n > 0 ? (n %= n2) : n2 - n % n2 * -1;
        if (n == 0 || n == n2) {
            return;
        }
        if (list instanceof RandomAccess) {
            Object object = list.get(0);
            int n3 = 0;
            int n4 = 0;
            int n5 = 0;
            while (n5 < n2) {
                n3 = (n3 + n) % n2;
                object = list.set(n3, object);
                if (n3 == n4) {
                    n3 = ++n4;
                    object = list.get(n4);
                }
                ++n5;
            }
        } else {
            int n6 = (n2 - n) % n2;
            List list2 = list.subList(0, n6);
            List list3 = list.subList(n6, n2);
            Collections.reverse(list2);
            Collections.reverse(list3);
            Collections.reverse(list);
        }
    }

    /*
     * Unable to fully structure code
     */
    public static int indexOfSubList(List var0, List var1_1) {
        var2_2 = var0.size();
        var3_3 = var1_1.size();
        if (var3_3 > var2_2) {
            return -1;
        }
        if (var3_3 == 0) {
            return 0;
        }
        var4_4 = var1_1.get(0);
        var5_5 = var0.indexOf(var4_4);
        if (var5_5 != -1) ** GOTO lbl25
        return -1;
lbl-1000:
        // 1 sources

        {
            var6_6 = var0.listIterator(var5_5);
            if (var4_4 == null ? var6_6.next() == null : var4_4.equals(var6_6.next()) != false) {
                var7_7 = var1_1.listIterator(1);
                var8_8 = false;
                while (var7_7.hasNext()) {
                    var9_9 = var7_7.next();
                    if (!var6_6.hasNext()) {
                        return -1;
                    }
                    if (!(var9_9 == null ? var6_6.next() != null : var9_9.equals(var6_6.next()) == false)) continue;
                    var8_8 = true;
                    break;
                }
                if (!var8_8) {
                    return var5_5;
                }
            }
            ++var5_5;
lbl25:
            // 2 sources

            ** while (var5_5 < var2_2 && var2_2 - var5_5 >= var3_3)
        }
lbl26:
        // 1 sources

        return -1;
    }

    public static int lastIndexOfSubList(List list, List list2) {
        int n;
        int n2 = list2.size();
        if (n2 > (n = list.size())) {
            return -1;
        }
        if (n2 == 0) {
            return n;
        }
        Object object = list2.get(n2 - 1);
        int n3 = list.lastIndexOf(object);
        while (n3 > -1 && n3 + 1 >= n2) {
            ListIterator listIterator = list.listIterator(n3 + 1);
            if (object == null ? listIterator.previous() == null : object.equals(listIterator.previous())) {
                ListIterator listIterator2 = list2.listIterator(n2 - 1);
                boolean bl = false;
                while (listIterator2.hasPrevious()) {
                    Object object2 = listIterator2.previous();
                    if (!listIterator.hasPrevious()) {
                        return -1;
                    }
                    if (!(object2 == null ? listIterator.previous() != null : !object2.equals(listIterator.previous()))) continue;
                    bl = true;
                    break;
                }
                if (!bl) {
                    return listIterator.nextIndex();
                }
            }
            --n3;
        }
        return -1;
    }

    public static ArrayList list(Enumeration enumeration) {
        ArrayList arrayList = new ArrayList();
        while (enumeration.hasMoreElements()) {
            arrayList.add(enumeration.nextElement());
        }
        return arrayList;
    }

    public static Collection synchronizedCollection(Collection collection) {
        if (collection == null) {
            throw new NullPointerException();
        }
        return new SynchronizedCollection(collection);
    }

    public static List synchronizedList(List list) {
        if (list == null) {
            throw new NullPointerException();
        }
        if (list instanceof RandomAccess) {
            return new SynchronizedRandomAccessList(list);
        }
        return new SynchronizedList(list);
    }

    public static Map synchronizedMap(Map map) {
        if (map == null) {
            throw new NullPointerException();
        }
        return new SynchronizedMap(map);
    }

    public static Set synchronizedSet(Set set) {
        if (set == null) {
            throw new NullPointerException();
        }
        return new SynchronizedSet(set);
    }

    public static SortedMap synchronizedSortedMap(SortedMap sortedMap) {
        if (sortedMap == null) {
            throw new NullPointerException();
        }
        return new SynchronizedSortedMap(sortedMap);
    }

    public static SortedSet synchronizedSortedSet(SortedSet sortedSet) {
        if (sortedSet == null) {
            throw new NullPointerException();
        }
        return new SynchronizedSortedSet(sortedSet);
    }

    public static Collection unmodifiableCollection(Collection collection) {
        if (collection == null) {
            throw new NullPointerException();
        }
        return new UnmodifiableCollection(collection);
    }

    public static List unmodifiableList(List list) {
        if (list == null) {
            throw new NullPointerException();
        }
        if (list instanceof RandomAccess) {
            return new UnmodifiableRandomAccessList(list);
        }
        return new UnmodifiableList(list);
    }

    public static Map unmodifiableMap(Map map) {
        if (map == null) {
            throw new NullPointerException();
        }
        return new UnmodifiableMap(map);
    }

    public static Set unmodifiableSet(Set set) {
        if (set == null) {
            throw new NullPointerException();
        }
        return new UnmodifiableSet(set);
    }

    public static SortedMap unmodifiableSortedMap(SortedMap sortedMap) {
        if (sortedMap == null) {
            throw new NullPointerException();
        }
        return new UnmodifiableSortedMap(sortedMap);
    }

    public static SortedSet unmodifiableSortedSet(SortedSet sortedSet) {
        if (sortedSet == null) {
            throw new NullPointerException();
        }
        return new UnmodifiableSortedSet(sortedSet);
    }

    private static final class EmptyMap
    extends AbstractMap
    implements Serializable {
        private static final long serialVersionUID = 6428348081105594320L;

        EmptyMap() {
        }

        public boolean containsKey(Object object) {
            return false;
        }

        public boolean containsValue(Object object) {
            return false;
        }

        public Set entrySet() {
            return EMPTY_SET;
        }

        public Object get(Object object) {
            return null;
        }

        public Set keySet() {
            return EMPTY_SET;
        }

        public Collection values() {
            return EMPTY_LIST;
        }
    }

    private static final class EmptySet
    extends AbstractSet
    implements Serializable {
        private static final long serialVersionUID = 1582296315990362920L;

        EmptySet() {
        }

        public boolean contains(Object object) {
            return false;
        }

        public int size() {
            return 0;
        }

        public Iterator iterator() {
            return new Iterator(){

                public boolean hasNext() {
                    return false;
                }

                public Object next() {
                    throw new NoSuchElementException();
                }

                public void remove() {
                    throw new UnsupportedOperationException();
                }
            };
        }
    }

    private static final class EmptyList
    extends AbstractList
    implements Serializable {
        private static final long serialVersionUID = 8842843931221139166L;

        EmptyList() {
        }

        public boolean contains(Object object) {
            return false;
        }

        public int size() {
            return 0;
        }

        public Object get(int n) {
            throw new IndexOutOfBoundsException();
        }
    }

    private static final class CopiesList
    extends AbstractList
    implements Serializable {
        private static final long serialVersionUID = 2739099268398711800L;
        private final int n;
        private final Object element;

        CopiesList(int n, Object object) {
            if (n < 0) {
                throw new IllegalArgumentException();
            }
            this.n = n;
            this.element = object;
        }

        public boolean contains(Object object) {
            return this.element == null ? object == null : this.element.equals(object);
        }

        public int size() {
            return this.n;
        }

        public Object get(int n) {
            if (n >= 0 && n < this.n) {
                return this.element;
            }
            throw new IndexOutOfBoundsException();
        }
    }

    private static final class SingletonMap
    extends AbstractMap
    implements Serializable {
        private static final long serialVersionUID = -6979724477215052911L;
        final Object k;
        final Object v;

        SingletonMap(Object object, Object object2) {
            this.k = object;
            this.v = object2;
        }

        public boolean containsKey(Object object) {
            return this.k == null ? object == null : this.k.equals(object);
        }

        public boolean containsValue(Object object) {
            return this.v == null ? object == null : this.v.equals(object);
        }

        public Object get(Object object) {
            if (this.containsKey(object)) {
                return this.v;
            }
            return null;
        }

        public int size() {
            return 1;
        }

        public Set entrySet() {
            return new AbstractSet(){

                public boolean contains(Object object) {
                    if (object instanceof Map.Entry) {
                        Map.Entry entry = (Map.Entry)object;
                        return this.containsKey(entry.getKey()) && this.containsValue(entry.getValue());
                    }
                    return false;
                }

                public int size() {
                    return 1;
                }

                public Iterator iterator() {
                    return new Iterator(){
                        boolean hasNext = true;

                        public boolean hasNext() {
                            return this.hasNext;
                        }

                        public Object next() {
                            if (this.hasNext) {
                                this.hasNext = false;
                                return new Map.Entry(){

                                    public boolean equals(Object object) {
                                        return this.contains(object);
                                    }

                                    public Object getKey() {
                                        return k;
                                    }

                                    public Object getValue() {
                                        return v;
                                    }

                                    public int hashCode() {
                                        return (k == null ? 0 : k.hashCode()) ^ (v == null ? 0 : v.hashCode());
                                    }

                                    public Object setValue(Object object) {
                                        throw new UnsupportedOperationException();
                                    }
                                };
                            }
                            throw new NoSuchElementException();
                        }

                        public void remove() {
                            throw new UnsupportedOperationException();
                        }
                    };
                }
            };
        }
    }

    private static final class SingletonSet
    extends AbstractSet
    implements Serializable {
        private static final long serialVersionUID = 3193687207550431679L;
        final Object element;

        SingletonSet(Object object) {
            this.element = object;
        }

        public boolean contains(Object object) {
            return this.element == null ? object == null : this.element.equals(object);
        }

        public int size() {
            return 1;
        }

        public Iterator iterator() {
            return new Iterator(){
                boolean hasNext = true;

                public boolean hasNext() {
                    return this.hasNext;
                }

                public Object next() {
                    if (this.hasNext) {
                        this.hasNext = false;
                        return element;
                    }
                    throw new NoSuchElementException();
                }

                public void remove() {
                    throw new UnsupportedOperationException();
                }
            };
        }
    }

    private static final class SingletonList
    extends AbstractList
    implements Serializable {
        private static final long serialVersionUID = 3093736618740652951L;
        final Object element;

        SingletonList(Object object) {
            this.element = object;
        }

        public boolean contains(Object object) {
            return this.element == null ? object == null : this.element.equals(object);
        }

        public Object get(int n) {
            if (n == 0) {
                return this.element;
            }
            throw new IndexOutOfBoundsException();
        }

        public int size() {
            return 1;
        }
    }

    static class SynchronizedMap
    implements Map,
    Serializable {
        private static final long serialVersionUID = 1978198479659022715L;
        private final Map m;
        final Object mutex;

        SynchronizedMap(Map map) {
            this.m = map;
            this.mutex = this;
        }

        SynchronizedMap(Map map, Object object) {
            this.m = map;
            this.mutex = object;
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void clear() {
            Object object = this.mutex;
            synchronized (object) {
                this.m.clear();
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public boolean containsKey(Object object) {
            Object object2 = this.mutex;
            synchronized (object2) {
                return this.m.containsKey(object);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public boolean containsValue(Object object) {
            Object object2 = this.mutex;
            synchronized (object2) {
                return this.m.containsValue(object);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public Set entrySet() {
            Object object = this.mutex;
            synchronized (object) {
                return new SynchronizedSet(this.m.entrySet(), this.mutex);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public boolean equals(Object object) {
            Object object2 = this.mutex;
            synchronized (object2) {
                return this.m.equals(object);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public Object get(Object object) {
            Object object2 = this.mutex;
            synchronized (object2) {
                return this.m.get(object);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public int hashCode() {
            Object object = this.mutex;
            synchronized (object) {
                return this.m.hashCode();
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public boolean isEmpty() {
            Object object = this.mutex;
            synchronized (object) {
                return this.m.isEmpty();
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public Set keySet() {
            Object object = this.mutex;
            synchronized (object) {
                return new SynchronizedSet(this.m.keySet(), this.mutex);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public Object put(Object object, Object object2) {
            Object object3 = this.mutex;
            synchronized (object3) {
                return this.m.put(object, object2);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void putAll(Map map) {
            Object object = this.mutex;
            synchronized (object) {
                this.m.putAll(map);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public Object remove(Object object) {
            Object object2 = this.mutex;
            synchronized (object2) {
                return this.m.remove(object);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public int size() {
            Object object = this.mutex;
            synchronized (object) {
                return this.m.size();
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public Collection values() {
            Object object = this.mutex;
            synchronized (object) {
                return new SynchronizedCollection(this.m.values(), this.mutex);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public String toString() {
            Object object = this.mutex;
            synchronized (object) {
                return this.m.toString();
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            Object object = this.mutex;
            synchronized (object) {
                objectOutputStream.defaultWriteObject();
            }
        }
    }

    static class SynchronizedSet
    extends SynchronizedCollection
    implements Set {
        private static final long serialVersionUID = 487447009682186044L;

        SynchronizedSet(Set set) {
            super(set);
        }

        SynchronizedSet(Set set, Object object) {
            super(set, object);
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public boolean equals(Object object) {
            Object object2 = this.mutex;
            synchronized (object2) {
                return this.c.equals(object);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public int hashCode() {
            Object object = this.mutex;
            synchronized (object) {
                return this.c.hashCode();
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            Object object = this.mutex;
            synchronized (object) {
                objectOutputStream.defaultWriteObject();
            }
        }
    }

    private static class UnmodifiableMap
    implements Map,
    Serializable {
        private static final long serialVersionUID = -1034234728574286014L;
        private final Map m;

        UnmodifiableMap(Map map) {
            this.m = map;
        }

        public void clear() {
            throw new UnsupportedOperationException();
        }

        public boolean containsKey(Object object) {
            return this.m.containsKey(object);
        }

        public boolean containsValue(Object object) {
            return this.m.containsValue(object);
        }

        public Set entrySet() {
            return new UnmodifiableEntrySet(this.m.entrySet());
        }

        public boolean equals(Object object) {
            return this.m.equals(object);
        }

        public Object get(Object object) {
            return this.m.get(object);
        }

        public int hashCode() {
            return this.m.hashCode();
        }

        public boolean isEmpty() {
            return this.m.isEmpty();
        }

        public Set keySet() {
            return new UnmodifiableSet(this.m.keySet());
        }

        public Object put(Object object, Object object2) {
            throw new UnsupportedOperationException();
        }

        public void putAll(Map map) {
            throw new UnsupportedOperationException();
        }

        public Object remove(Object object) {
            throw new UnsupportedOperationException();
        }

        public int size() {
            return this.m.size();
        }

        public Collection values() {
            return new UnmodifiableCollection(this.m.values());
        }

        private static class UnmodifiableEntrySet
        extends UnmodifiableSet {
            private static final long serialVersionUID = 7854390611657943733L;

            UnmodifiableEntrySet(Set set) {
                super(set);
            }

            public Iterator iterator() {
                return new Iterator(){
                    Iterator iterator;
                    {
                        this.iterator = unmodifiableEntrySet.c.iterator();
                    }

                    public boolean hasNext() {
                        return this.iterator.hasNext();
                    }

                    public Object next() {
                        return new UnmodifiableMapEntry((Map.Entry)this.iterator.next());
                    }

                    public void remove() {
                        throw new UnsupportedOperationException();
                    }
                };
            }

            public Object[] toArray() {
                int n = this.c.size();
                Object[] objectArray = new Object[n];
                Iterator iterator = this.iterator();
                int n2 = n;
                while (--n2 >= 0) {
                    objectArray[n2] = iterator.next();
                }
                return objectArray;
            }

            public Object[] toArray(Object[] objectArray) {
                int n = this.c.size();
                int n2 = 0;
                Iterator iterator = this.iterator();
                if (n > objectArray.length) {
                    objectArray = (Object[])Array.newInstance(objectArray.getClass().getComponentType(), n);
                }
                while (n2 < n) {
                    objectArray[n2++] = iterator.next();
                }
                if (n2 < objectArray.length) {
                    objectArray[n2] = null;
                }
                return objectArray;
            }

            private static class UnmodifiableMapEntry
            implements Map.Entry {
                Map.Entry mapEntry;

                UnmodifiableMapEntry(Map.Entry entry) {
                    this.mapEntry = entry;
                }

                public boolean equals(Object object) {
                    return this.mapEntry.equals(object);
                }

                public Object getKey() {
                    return this.mapEntry.getKey();
                }

                public Object getValue() {
                    return this.mapEntry.getValue();
                }

                public int hashCode() {
                    return this.mapEntry.hashCode();
                }

                public Object setValue(Object object) {
                    throw new UnsupportedOperationException();
                }

                public String toString() {
                    return this.mapEntry.toString();
                }
            }
        }
    }

    private static class UnmodifiableSet
    extends UnmodifiableCollection
    implements Set {
        private static final long serialVersionUID = -9215047833775013803L;

        UnmodifiableSet(Set set) {
            super(set);
        }

        public boolean equals(Object object) {
            return this.c.equals(object);
        }

        public int hashCode() {
            return this.c.hashCode();
        }
    }

    static class SynchronizedList
    extends SynchronizedCollection
    implements List {
        private static final long serialVersionUID = -7754090372962971524L;
        final List list;

        SynchronizedList(List list) {
            super(list);
            this.list = list;
        }

        SynchronizedList(List list, Object object) {
            super(list, object);
            this.list = list;
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void add(int n, Object object) {
            Object object2 = this.mutex;
            synchronized (object2) {
                this.list.add(n, object);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public boolean addAll(int n, Collection collection) {
            Object object = this.mutex;
            synchronized (object) {
                return this.list.addAll(n, collection);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public boolean equals(Object object) {
            Object object2 = this.mutex;
            synchronized (object2) {
                return this.list.equals(object);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public Object get(int n) {
            Object object = this.mutex;
            synchronized (object) {
                return this.list.get(n);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public int hashCode() {
            Object object = this.mutex;
            synchronized (object) {
                return this.list.hashCode();
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public int indexOf(Object object) {
            Object object2 = this.mutex;
            synchronized (object2) {
                return this.list.indexOf(object);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public int lastIndexOf(Object object) {
            Object object2 = this.mutex;
            synchronized (object2) {
                return this.list.lastIndexOf(object);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public ListIterator listIterator() {
            Object object = this.mutex;
            synchronized (object) {
                return this.list.listIterator();
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public ListIterator listIterator(int n) {
            Object object = this.mutex;
            synchronized (object) {
                return this.list.listIterator(n);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public Object remove(int n) {
            Object object = this.mutex;
            synchronized (object) {
                return this.list.remove(n);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public Object set(int n, Object object) {
            Object object2 = this.mutex;
            synchronized (object2) {
                return this.list.set(n, object);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public List subList(int n, int n2) {
            Object object = this.mutex;
            synchronized (object) {
                return new SynchronizedList(this.list.subList(n, n2), this.mutex);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            Object object = this.mutex;
            synchronized (object) {
                objectOutputStream.defaultWriteObject();
            }
        }

        private Object readResolve() {
            if (this.list instanceof RandomAccess) {
                return new SynchronizedRandomAccessList(this.list, this.mutex);
            }
            return this;
        }
    }

    private static class UnmodifiableList
    extends UnmodifiableCollection
    implements List {
        private static final long serialVersionUID = -283967356065247728L;
        final List list;

        UnmodifiableList(List list) {
            super(list);
            this.list = list;
        }

        public void add(int n, Object object) {
            throw new UnsupportedOperationException();
        }

        public boolean addAll(int n, Collection collection) {
            throw new UnsupportedOperationException();
        }

        public boolean equals(Object object) {
            return this.list.equals(object);
        }

        public Object get(int n) {
            return this.list.get(n);
        }

        public int hashCode() {
            return this.list.hashCode();
        }

        public int indexOf(Object object) {
            return this.list.indexOf(object);
        }

        public int lastIndexOf(Object object) {
            return this.list.lastIndexOf(object);
        }

        public ListIterator listIterator() {
            return this.listIterator(0);
        }

        public ListIterator listIterator(int n) {
            return new ListIterator(n){
                ListIterator iterator;
                {
                    this.iterator = unmodifiableList.list.listIterator(n);
                }

                public void add(Object object) {
                    throw new UnsupportedOperationException();
                }

                public boolean hasNext() {
                    return this.iterator.hasNext();
                }

                public boolean hasPrevious() {
                    return this.iterator.hasPrevious();
                }

                public Object next() {
                    return this.iterator.next();
                }

                public int nextIndex() {
                    return this.iterator.nextIndex();
                }

                public Object previous() {
                    return this.iterator.previous();
                }

                public int previousIndex() {
                    return this.iterator.previousIndex();
                }

                public void remove() {
                    throw new UnsupportedOperationException();
                }

                public void set(Object object) {
                    throw new UnsupportedOperationException();
                }
            };
        }

        public Object remove(int n) {
            throw new UnsupportedOperationException();
        }

        public Object set(int n, Object object) {
            throw new UnsupportedOperationException();
        }

        public List subList(int n, int n2) {
            return new UnmodifiableList(this.list.subList(n, n2));
        }

        private Object readResolve() {
            if (this.list instanceof RandomAccess) {
                return new UnmodifiableRandomAccessList(this.list);
            }
            return this;
        }
    }

    private static class ReverseComparator
    implements Comparator,
    Serializable {
        private static final long serialVersionUID = 7207038068494060240L;

        ReverseComparator() {
        }

        public int compare(Object object, Object object2) {
            return -((Comparable)object).compareTo(object2);
        }
    }

    static class SynchronizedSortedMap
    extends SynchronizedMap
    implements SortedMap {
        private static final long serialVersionUID = -8798146769416483793L;
        private final SortedMap sm;

        SynchronizedSortedMap(SortedMap sortedMap) {
            super(sortedMap);
            this.sm = sortedMap;
        }

        SynchronizedSortedMap(SortedMap sortedMap, Object object) {
            super(sortedMap, object);
            this.sm = sortedMap;
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public Comparator comparator() {
            Object object = this.mutex;
            synchronized (object) {
                return this.sm.comparator();
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public Object firstKey() {
            Object object = this.mutex;
            synchronized (object) {
                return this.sm.firstKey();
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public SortedMap headMap(Object object) {
            Object object2 = this.mutex;
            synchronized (object2) {
                return new SynchronizedSortedMap(this.sm.headMap(object), this.mutex);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public Object lastKey() {
            Object object = this.mutex;
            synchronized (object) {
                return this.sm.lastKey();
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public SortedMap subMap(Object object, Object object2) {
            Object object3 = this.mutex;
            synchronized (object3) {
                return new SynchronizedSortedMap(this.sm.subMap(object, object2), this.mutex);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public SortedMap tailMap(Object object) {
            Object object2 = this.mutex;
            synchronized (object2) {
                return new SynchronizedSortedMap(this.sm.tailMap(object), this.mutex);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            Object object = this.mutex;
            synchronized (object) {
                objectOutputStream.defaultWriteObject();
            }
        }
    }

    static class SynchronizedSortedSet
    extends SynchronizedSet
    implements SortedSet {
        private static final long serialVersionUID = 8695801310862127406L;
        private final SortedSet ss;

        SynchronizedSortedSet(SortedSet sortedSet) {
            super(sortedSet);
            this.ss = sortedSet;
        }

        SynchronizedSortedSet(SortedSet sortedSet, Object object) {
            super(sortedSet, object);
            this.ss = sortedSet;
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public Comparator comparator() {
            Object object = this.mutex;
            synchronized (object) {
                return this.ss.comparator();
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public Object first() {
            Object object = this.mutex;
            synchronized (object) {
                return this.ss.first();
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public SortedSet headSet(Object object) {
            Object object2 = this.mutex;
            synchronized (object2) {
                return new SynchronizedSortedSet(this.ss.headSet(object), this.mutex);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public Object last() {
            Object object = this.mutex;
            synchronized (object) {
                return this.ss.last();
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public SortedSet subSet(Object object, Object object2) {
            Object object3 = this.mutex;
            synchronized (object3) {
                return new SynchronizedSortedSet(this.ss.subSet(object, object2), this.mutex);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public SortedSet tailSet(Object object) {
            Object object2 = this.mutex;
            synchronized (object2) {
                return new SynchronizedSortedSet(this.ss.tailSet(object), this.mutex);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            Object object = this.mutex;
            synchronized (object) {
                objectOutputStream.defaultWriteObject();
            }
        }
    }

    private static class UnmodifiableSortedMap
    extends UnmodifiableMap
    implements SortedMap {
        private static final long serialVersionUID = -8806743815996713206L;
        private final SortedMap sm;

        UnmodifiableSortedMap(SortedMap sortedMap) {
            super(sortedMap);
            this.sm = sortedMap;
        }

        public Comparator comparator() {
            return this.sm.comparator();
        }

        public Object firstKey() {
            return this.sm.firstKey();
        }

        public SortedMap headMap(Object object) {
            return new UnmodifiableSortedMap(this.sm.headMap(object));
        }

        public Object lastKey() {
            return this.sm.lastKey();
        }

        public SortedMap subMap(Object object, Object object2) {
            return new UnmodifiableSortedMap(this.sm.subMap(object, object2));
        }

        public SortedMap tailMap(Object object) {
            return new UnmodifiableSortedMap(this.sm.tailMap(object));
        }
    }

    private static class UnmodifiableSortedSet
    extends UnmodifiableSet
    implements SortedSet {
        private static final long serialVersionUID = -4929149591599911165L;
        private final SortedSet ss;

        UnmodifiableSortedSet(SortedSet sortedSet) {
            super(sortedSet);
            this.ss = sortedSet;
        }

        public Comparator comparator() {
            return this.ss.comparator();
        }

        public Object first() {
            return this.ss.first();
        }

        public SortedSet headSet(Object object) {
            return new UnmodifiableSortedSet(this.ss.headSet(object));
        }

        public Object last() {
            return this.ss.last();
        }

        public SortedSet subSet(Object object, Object object2) {
            return new UnmodifiableSortedSet(this.ss.subSet(object, object2));
        }

        public SortedSet tailSet(Object object) {
            return new UnmodifiableSortedSet(this.ss.tailSet(object));
        }
    }

    static class SynchronizedCollection
    implements Collection,
    Serializable {
        private static final long serialVersionUID = 3053995032091335093L;
        final Collection c;
        final Object mutex;

        SynchronizedCollection(Collection collection) {
            this.c = collection;
            this.mutex = this;
        }

        SynchronizedCollection(Collection collection, Object object) {
            this.c = collection;
            this.mutex = object;
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public boolean add(Object object) {
            Object object2 = this.mutex;
            synchronized (object2) {
                return this.c.add(object);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public boolean addAll(Collection collection) {
            Object object = this.mutex;
            synchronized (object) {
                return this.c.addAll(collection);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void clear() {
            Object object = this.mutex;
            synchronized (object) {
                this.c.clear();
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public boolean contains(Object object) {
            Object object2 = this.mutex;
            synchronized (object2) {
                return this.c.contains(object);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public boolean containsAll(Collection collection) {
            Object object = this.mutex;
            synchronized (object) {
                return this.c.containsAll(collection);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public boolean isEmpty() {
            Object object = this.mutex;
            synchronized (object) {
                return this.c.isEmpty();
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public Iterator iterator() {
            Object object = this.mutex;
            synchronized (object) {
                return this.c.iterator();
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public boolean remove(Object object) {
            Object object2 = this.mutex;
            synchronized (object2) {
                return this.c.remove(object);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public boolean removeAll(Collection collection) {
            Object object = this.mutex;
            synchronized (object) {
                return this.c.removeAll(collection);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public boolean retainAll(Collection collection) {
            Object object = this.mutex;
            synchronized (object) {
                return this.c.retainAll(collection);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public int size() {
            Object object = this.mutex;
            synchronized (object) {
                return this.c.size();
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public Object[] toArray() {
            Object object = this.mutex;
            synchronized (object) {
                return this.c.toArray();
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public String toString() {
            Object object = this.mutex;
            synchronized (object) {
                return this.c.toString();
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public Object[] toArray(Object[] objectArray) {
            Object object = this.mutex;
            synchronized (object) {
                return this.c.toArray(objectArray);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            Object object = this.mutex;
            synchronized (object) {
                objectOutputStream.defaultWriteObject();
            }
        }
    }

    private static class UnmodifiableCollection
    implements Collection,
    Serializable {
        private static final long serialVersionUID = 1820017752578914078L;
        final Collection c;

        UnmodifiableCollection(Collection collection) {
            this.c = collection;
        }

        public boolean add(Object object) {
            throw new UnsupportedOperationException();
        }

        public boolean addAll(Collection collection) {
            throw new UnsupportedOperationException();
        }

        public void clear() {
            throw new UnsupportedOperationException();
        }

        public boolean contains(Object object) {
            return this.c.contains(object);
        }

        public boolean containsAll(Collection collection) {
            return this.c.containsAll(collection);
        }

        public boolean isEmpty() {
            return this.c.isEmpty();
        }

        public Iterator iterator() {
            return new Iterator(){
                Iterator iterator;
                {
                    this.iterator = unmodifiableCollection.c.iterator();
                }

                public boolean hasNext() {
                    return this.iterator.hasNext();
                }

                public Object next() {
                    return this.iterator.next();
                }

                public void remove() {
                    throw new UnsupportedOperationException();
                }
            };
        }

        public boolean remove(Object object) {
            throw new UnsupportedOperationException();
        }

        public boolean removeAll(Collection collection) {
            throw new UnsupportedOperationException();
        }

        public boolean retainAll(Collection collection) {
            throw new UnsupportedOperationException();
        }

        public int size() {
            return this.c.size();
        }

        public Object[] toArray() {
            return this.c.toArray();
        }

        public Object[] toArray(Object[] objectArray) {
            return this.c.toArray(objectArray);
        }
    }

    static class SynchronizedRandomAccessList
    extends SynchronizedList
    implements RandomAccess {
        private static final long serialVersionUID = 1530674583602358482L;

        SynchronizedRandomAccessList(List list) {
            super(list);
        }

        SynchronizedRandomAccessList(List list, Object object) {
            super(list, object);
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public List subList(int n, int n2) {
            Object object = this.mutex;
            synchronized (object) {
                return new SynchronizedRandomAccessList(this.list.subList(n, n2), this.mutex);
            }
        }

        private Object writeReplace() {
            return new SynchronizedList(this.list);
        }
    }

    private static class UnmodifiableRandomAccessList
    extends UnmodifiableList
    implements RandomAccess {
        private static final long serialVersionUID = -2542308836966382001L;

        UnmodifiableRandomAccessList(List list) {
            super(list);
        }

        public List subList(int n, int n2) {
            return new UnmodifiableRandomAccessList(this.list.subList(n, n2));
        }

        private Object writeReplace() {
            return new UnmodifiableList(this.list);
        }
    }
}

