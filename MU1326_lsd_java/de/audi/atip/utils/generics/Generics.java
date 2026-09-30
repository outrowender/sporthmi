/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.utils.generics;

import de.audi.atip.utils.Preconditions;
import de.audi.atip.utils.collections.CopyOnWriteArrayList;
import de.audi.atip.utils.generics.GCollection;
import de.audi.atip.utils.generics.GCollectionSerializable;
import de.audi.atip.utils.generics.GCollectionSerializableWrapper;
import de.audi.atip.utils.generics.GCollectionWrapper;
import de.audi.atip.utils.generics.GComparator;
import de.audi.atip.utils.generics.GComparatorWrapper;
import de.audi.atip.utils.generics.GCopyOnWriteList;
import de.audi.atip.utils.generics.GCopyOnWriteListWrapper;
import de.audi.atip.utils.generics.GIterator;
import de.audi.atip.utils.generics.GIteratorWrapper;
import de.audi.atip.utils.generics.GList;
import de.audi.atip.utils.generics.GListSerializable;
import de.audi.atip.utils.generics.GListSerializableWrapper;
import de.audi.atip.utils.generics.GListWrapper;
import de.audi.atip.utils.generics.GMap;
import de.audi.atip.utils.generics.GMapSerializable;
import de.audi.atip.utils.generics.GMapSerializableWrapper;
import de.audi.atip.utils.generics.GMapWrapper;
import de.audi.atip.utils.generics.GSet;
import de.audi.atip.utils.generics.GSetSerializable;
import de.audi.atip.utils.generics.GSetSerializableWrapper;
import de.audi.atip.utils.generics.GSetWrapper;
import de.audi.atip.utils.generics.GSortedMap;
import de.audi.atip.utils.generics.GSortedMapSerializable;
import de.audi.atip.utils.generics.GSortedMapSerializableWrapper;
import de.audi.atip.utils.generics.GSortedMapWrapper;
import de.audi.atip.utils.generics.UnmodifiableGList;
import de.audi.atip.utils.generics.UnmodifiableGListSerializable;
import edu.emory.mathcs.backport.java.util.TreeMap;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class Generics {
    public static <T> GCollection<T> emptyCollection() {
        return Generics.emptyList();
    }

    public static <T extends Serializable> GCollectionSerializable<T> emptyCollectionSerializable() {
        return Generics.emptyListSerializable();
    }

    public static <T> GList<T> emptyList() {
        return new GListWrapper(Collections.EMPTY_LIST);
    }

    public static <T extends Serializable> GListSerializable<T> emptyListSerializable() {
        return new GListSerializableWrapper(Collections.EMPTY_LIST);
    }

    public static <T> GSet<T> emptySet() {
        return new GSetWrapper(Collections.EMPTY_SET);
    }

    public static <T extends Serializable> GSetSerializable<T> emptySetSerializable() {
        return new GSetSerializableWrapper(Collections.EMPTY_SET);
    }

    public static <K, V> GMap<K, V> emptyMap() {
        return new GMapWrapper(Collections.EMPTY_MAP);
    }

    public static <K extends Serializable, V extends Serializable> GMapSerializable<K, V> emptyMapSerializable() {
        return new GMapSerializableWrapper(Collections.EMPTY_MAP);
    }

    public static final <T> GCollection<T> wrap(Collection collection) {
        Preconditions.checkNotNull(collection);
        return new GCollectionWrapper(collection);
    }

    public static final <T extends Serializable> GCollectionSerializable<T> wrapToSerializable(Collection collection) {
        Preconditions.checkNotNull(collection);
        return new GCollectionSerializableWrapper(collection);
    }

    public static final <T> GList<T> wrap(List list) {
        Preconditions.checkNotNull(list);
        return new GListWrapper(list);
    }

    public static final <T extends Serializable> GListSerializable<T> wrapToSerializable(List list) {
        Preconditions.checkNotNull(list);
        return new GListSerializableWrapper(list);
    }

    public static final <T> GIterator<T> wrap(Iterator iterator) {
        Preconditions.checkNotNull(iterator);
        return new GIteratorWrapper(iterator);
    }

    public static final <K, V> GMap<K, V> wrap(Map map) {
        Preconditions.checkNotNull(map);
        return new GMapWrapper(map);
    }

    public static final <K extends Serializable, V extends Serializable> GMapSerializable<K, V> wrapToSerializable(Map map) {
        Preconditions.checkNotNull(map);
        return new GMapSerializableWrapper(map);
    }

    public static final <T> GSet<T> wrap(Set set) {
        Preconditions.checkNotNull(set);
        return new GSetWrapper(set);
    }

    public static final <T extends Serializable> GSetSerializable<T> wrapToSerializable(Set set) {
        Preconditions.checkNotNull(set);
        return new GSetSerializableWrapper(set);
    }

    public static final <T> GList<T> newArrayList() {
        return new GListWrapper(new ArrayList(10));
    }

    public static final <T extends Serializable> GListSerializable<T> newArrayListSerializable() {
        return new GListSerializableWrapper(new ArrayList(10));
    }

    public static final <T> GList<T> newArrayList(Collection collection) {
        return new GListWrapper(new ArrayList(collection));
    }

    public static final <T extends Serializable> GListSerializable<T> newArrayListSerializable(Collection collection) {
        return new GListSerializableWrapper(new ArrayList(collection));
    }

    public static final <T> GList<T> newArrayList(GCollection<T> gCollection) {
        return new GListWrapper(new ArrayList(gCollection.getBackingCollection()));
    }

    public static final <T extends Serializable> GListSerializable<T> newArrayListSerializable(GCollection<T> gCollection) {
        return new GListSerializableWrapper(new ArrayList(gCollection.getBackingCollection()));
    }

    public static final <T> GList<T> newArrayListWithCapacity(int n) {
        return new GListWrapper(new ArrayList(n));
    }

    public static final <T extends Serializable> GListSerializable<T> newArrayListWithCapacitySerializable(int n) {
        return new GListSerializableWrapper(new ArrayList(n));
    }

    public static final <T> GList<T> newArrayList(T[] TArray) {
        ArrayList arrayList = new ArrayList(TArray.length);
        for (int i2 = 0; i2 < TArray.length; ++i2) {
            arrayList.add(TArray[i2]);
        }
        return new GListWrapper(arrayList);
    }

    public static final <T extends Serializable> GListSerializable<T> newArrayListSerializable(T[] TArray) {
        ArrayList arrayList = new ArrayList(TArray.length);
        for (int i2 = 0; i2 < TArray.length; ++i2) {
            arrayList.add(TArray[i2]);
        }
        return new GListSerializableWrapper(arrayList);
    }

    public static final <T> GCopyOnWriteList<T> newCopyOnWriteArrayList() {
        return Generics.newCopyOnWriteList();
    }

    public static final <T> GCopyOnWriteList<T> newCopyOnWriteArrayList(Collection collection) {
        return Generics.newCopyOnWriteList(collection);
    }

    public static final <T> GCopyOnWriteList<T> newCopyOnWriteArrayList(GCollection<T> gCollection) {
        return Generics.newCopyOnWriteList(gCollection);
    }

    public static final <T> GCopyOnWriteList<T> newCopyOnWriteArrayListWithCapacity(int n) {
        return Generics.newCopyOnWriteArrayListWithCapacity(n);
    }

    public static final <T> GCopyOnWriteList<T> newCopyOnWriteArrayList(T[] TArray) {
        return Generics.newCopyOnWriteList(TArray);
    }

    public static final <T> GCopyOnWriteList<T> newCopyOnWriteList() {
        return new GCopyOnWriteListWrapper(new CopyOnWriteArrayList());
    }

    public static final <T> GCopyOnWriteList<T> newCopyOnWriteList(Collection collection) {
        return new GCopyOnWriteListWrapper(new CopyOnWriteArrayList(collection));
    }

    public static final <T> GCopyOnWriteList<T> newCopyOnWriteList(GCollection<T> gCollection) {
        return new GCopyOnWriteListWrapper(new CopyOnWriteArrayList(gCollection.getBackingCollection()));
    }

    public static final <T> GCopyOnWriteList<T> newCopyOnWriteListWithCapacity(int n) {
        return new GCopyOnWriteListWrapper(new CopyOnWriteArrayList(n));
    }

    public static final <T> GCopyOnWriteList<T> newCopyOnWriteList(T[] TArray) {
        ArrayList arrayList = new ArrayList(TArray.length);
        for (int i2 = 0; i2 < TArray.length; ++i2) {
            arrayList.add(TArray[i2]);
        }
        return new GCopyOnWriteListWrapper(new CopyOnWriteArrayList(arrayList));
    }

    public static final <K, V> GMap<K, V> newHashMap() {
        return new GMapWrapper(new HashMap());
    }

    public static final <K, V> GSortedMap<K, V> newTreeMap() {
        return new GSortedMapWrapper(new TreeMap());
    }

    public static final <K, V> GSortedMap<K, V> newTreeMap(GComparatorWrapper<? super K> gComparatorWrapper) {
        return new GSortedMapWrapper(gComparatorWrapper);
    }

    public static final <K extends Serializable, V extends Serializable> GMapSerializable<K, V> newHashMapSerializable() {
        return new GMapSerializableWrapper(new HashMap());
    }

    public static final <K extends Serializable, V extends Serializable> GSortedMap<K, V> newTreeMapSerializable() {
        return new GSortedMapSerializableWrapper(new TreeMap());
    }

    public static final <K extends Serializable, V extends Serializable> GSortedMap<K, V> newTreeMapSerializable(GComparatorWrapper<? super K> gComparatorWrapper) {
        return new GSortedMapSerializableWrapper(gComparatorWrapper);
    }

    public static final <K, V> GMap<K, V> newHashMap(Map map) {
        return new GMapWrapper(new HashMap(map));
    }

    public static final <K extends Serializable, V extends Serializable> GMapSerializable<K, V> newHashMapSerializable(Map map) {
        return new GMapSerializableWrapper(new HashMap(map));
    }

    public static final <K, V> GSortedMap<K, V> newTreeMap(Map map) {
        return new GSortedMapWrapper(map);
    }

    public static final <K, V> GSortedMap<K, V> newSortedMap(SortedMap sortedMap) {
        return new GSortedMapWrapper(sortedMap);
    }

    public static final <K, V> GMap<K, V> newHashMap(GMap<K, V> gMap) {
        return new GMapWrapper(new HashMap(gMap.getBackingMap()));
    }

    public static final <K extends Serializable, V extends Serializable> GMapSerializable<K, V> newHashMapSerializable(GMap<K, V> gMap) {
        return new GMapSerializableWrapper(new HashMap(gMap.getBackingMap()));
    }

    public static final <K extends Serializable, V extends Serializable> GSortedMapSerializable<K, V> newTreeMapSerializable(GMap<K, V> gMap) {
        return new GSortedMapSerializableWrapper(gMap.getBackingMap());
    }

    public static final <K, V> GMap<K, V> newHashMapWithCapacity(int n) {
        return new GMapWrapper(new HashMap(n));
    }

    public static final <K, V> GSortedMap<K, V> newTreeMapWithCapacity(int n) {
        return new GSortedMapWrapper(new HashMap(n));
    }

    public static final <K extends Serializable, V extends Serializable> GMapSerializable<K, V> newHashMapWithCapacitySerializable(int n) {
        return new GMapSerializableWrapper(new HashMap(n));
    }

    public static final <K extends Serializable, V extends Serializable> GSortedMapSerializable<K, V> newTreeMapWithCapacitySerializable(int n) {
        return new GSortedMapSerializableWrapper(new HashMap(n));
    }

    public static final <T> GSet<T> newHashSet() {
        return new GSetWrapper(new HashSet());
    }

    public static final <T extends Serializable> GSetSerializable<T> newHashSetSerializable() {
        return new GSetSerializableWrapper(new HashSet());
    }

    public static final <T> GSet<T> newHashSet(Collection collection) {
        return new GSetWrapper(new HashSet(collection));
    }

    public static final <T extends Serializable> GSetSerializable<T> newHashSetSerializable(Collection collection) {
        return new GSetSerializableWrapper(new HashSet(collection));
    }

    public static final <T> GSet<T> newHashSet(GCollection<T> gCollection) {
        return new GSetWrapper(new HashSet(gCollection.getBackingCollection()));
    }

    public static final <T extends Serializable> GSetSerializable<T> newHashSetSerializable(GCollection<T> gCollection) {
        return new GSetSerializableWrapper(new HashSet(gCollection.getBackingCollection()));
    }

    public static final <T> GSet<T> newHashSetWithCapacity(int n) {
        return new GSetWrapper(new HashSet(n));
    }

    public static final <T extends Serializable> GSetSerializable<T> newHashSetWithCapacitySerializable(int n) {
        return new GSetSerializableWrapper(new HashSet(n));
    }

    public static final <T> GSet<T> newHashSet(T[] TArray) {
        return new GSetWrapper(new HashSet(Arrays.asList(TArray)));
    }

    public static final <T extends Serializable> GSetSerializable<T> newHashSetSerializable(T[] TArray) {
        return new GSetSerializableWrapper(new HashSet(Arrays.asList(TArray)));
    }

    public static <T> void sort(GList<T> gList, final GComparator<T> gComparator) {
        Collections.sort((List)gList.getBackingCollection(), new Comparator(){

            public int compare(Object object, Object object2) {
                return gComparator.compare(object, object2);
            }
        });
    }

    public static <T> GList<T> unmodifiableGList(GList<T> gList) {
        Preconditions.checkNotNull(gList);
        return new UnmodifiableGList<T>(gList);
    }

    public static <T extends Serializable> GListSerializable<T> unmodifiableGListSerializable(GListSerializable<T> gListSerializable) {
        Preconditions.checkNotNull(gListSerializable);
        return new UnmodifiableGListSerializable<T>(gListSerializable);
    }
}

