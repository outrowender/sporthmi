/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import java.util.AbstractCollection;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.MapEntry;
import java.util.NoSuchElementException;
import java.util.Set;

public class LinkedHashMap
extends HashMap {
    private static final long serialVersionUID = 3801124242820219131L;
    private final boolean accessOrder;
    private transient LinkedHashMapEntry head;
    private transient LinkedHashMapEntry tail;

    public LinkedHashMap() {
        this.accessOrder = false;
        this.head = null;
    }

    public LinkedHashMap(int n) {
        super(n);
        this.accessOrder = false;
        this.head = null;
    }

    public LinkedHashMap(int n, float f2) {
        super(n, f2);
        this.accessOrder = false;
        this.head = null;
        this.tail = null;
    }

    public LinkedHashMap(int n, float f2, boolean bl) {
        super(n, f2);
        this.accessOrder = bl;
        this.head = null;
        this.tail = null;
    }

    public LinkedHashMap(Map map) {
        this.accessOrder = false;
        this.head = null;
        this.tail = null;
        this.putAll(map);
    }

    HashMap.Entry[] newElementArray(int n) {
        return new LinkedHashMapEntry[n];
    }

    public Object get(Object object) {
        LinkedHashMapEntry linkedHashMapEntry = (LinkedHashMapEntry)this.getEntry(object);
        if (linkedHashMapEntry == null) {
            return null;
        }
        if (this.accessOrder && this.tail != linkedHashMapEntry) {
            LinkedHashMapEntry linkedHashMapEntry2 = linkedHashMapEntry.chainBackward;
            LinkedHashMapEntry linkedHashMapEntry3 = linkedHashMapEntry.chainForward;
            linkedHashMapEntry3.chainBackward = linkedHashMapEntry2;
            if (linkedHashMapEntry2 != null) {
                linkedHashMapEntry2.chainForward = linkedHashMapEntry3;
            } else {
                this.head = linkedHashMapEntry3;
            }
            linkedHashMapEntry.chainForward = null;
            linkedHashMapEntry.chainBackward = this.tail;
            this.tail.chainForward = linkedHashMapEntry;
            this.tail = linkedHashMapEntry;
        }
        return linkedHashMapEntry.value;
    }

    HashMap.Entry createEntry(Object object, int n, Object object2) {
        LinkedHashMapEntry linkedHashMapEntry = new LinkedHashMapEntry(object, object2);
        linkedHashMapEntry.next = this.elementData[n];
        this.elementData[n] = linkedHashMapEntry;
        this.linkEntry(linkedHashMapEntry);
        return linkedHashMapEntry;
    }

    public Object put(Object object, Object object2) {
        int n = this.getModuloHash(object);
        LinkedHashMapEntry linkedHashMapEntry = (LinkedHashMapEntry)this.findEntry(object, n);
        if (linkedHashMapEntry == null) {
            ++this.modCount;
            if (++this.elementCount > this.threshold) {
                this.rehash();
                n = object == null ? 0 : (object.hashCode() & Integer.MAX_VALUE) % this.elementData.length;
            }
            linkedHashMapEntry = (LinkedHashMapEntry)this.createEntry(object, n, null);
        } else {
            this.linkEntry(linkedHashMapEntry);
        }
        Object object3 = linkedHashMapEntry.value;
        linkedHashMapEntry.value = object2;
        if (this.removeEldestEntry(this.head)) {
            this.remove(this.head.key);
        }
        return object3;
    }

    void linkEntry(LinkedHashMapEntry linkedHashMapEntry) {
        if (this.tail == linkedHashMapEntry) {
            return;
        }
        if (this.head == null) {
            this.head = this.tail = linkedHashMapEntry;
            return;
        }
        LinkedHashMapEntry linkedHashMapEntry2 = linkedHashMapEntry.chainBackward;
        LinkedHashMapEntry linkedHashMapEntry3 = linkedHashMapEntry.chainForward;
        if (linkedHashMapEntry2 == null) {
            if (linkedHashMapEntry3 != null) {
                if (this.accessOrder) {
                    this.head = linkedHashMapEntry3;
                    linkedHashMapEntry3.chainBackward = null;
                    linkedHashMapEntry.chainBackward = this.tail;
                    linkedHashMapEntry.chainForward = null;
                    this.tail.chainForward = linkedHashMapEntry;
                    this.tail = linkedHashMapEntry;
                }
            } else {
                linkedHashMapEntry.chainBackward = this.tail;
                linkedHashMapEntry.chainForward = null;
                this.tail.chainForward = linkedHashMapEntry;
                this.tail = linkedHashMapEntry;
            }
            return;
        }
        if (linkedHashMapEntry3 == null) {
            return;
        }
        if (this.accessOrder) {
            linkedHashMapEntry2.chainForward = linkedHashMapEntry3;
            linkedHashMapEntry3.chainBackward = linkedHashMapEntry2;
            linkedHashMapEntry.chainForward = null;
            linkedHashMapEntry.chainBackward = this.tail;
            this.tail.chainForward = linkedHashMapEntry;
            this.tail = linkedHashMapEntry;
        }
    }

    public void putAll(Map map) {
        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            MapEntry mapEntry = (MapEntry)iterator.next();
            this.put(mapEntry.getKey(), mapEntry.getValue());
        }
    }

    public Set entrySet() {
        return new LinkedHashMapEntrySet(this);
    }

    public Set keySet() {
        if (this.keySet == null) {
            this.keySet = new AbstractSet(){

                public boolean contains(Object object) {
                    return LinkedHashMap.this.containsKey(object);
                }

                public int size() {
                    return LinkedHashMap.this.size();
                }

                public void clear() {
                    LinkedHashMap.this.clear();
                }

                public boolean remove(Object object) {
                    if (LinkedHashMap.this.containsKey(object)) {
                        LinkedHashMap.this.remove(object);
                        return true;
                    }
                    return false;
                }

                public Iterator iterator() {
                    return new LinkedHashIterator(new MapEntry.Type(){

                        public Object get(MapEntry mapEntry) {
                            return mapEntry.key;
                        }
                    }, LinkedHashMap.this);
                }
            };
        }
        return this.keySet;
    }

    public Collection values() {
        if (this.valuesCollection == null) {
            this.valuesCollection = new AbstractCollection(){

                public boolean contains(Object object) {
                    return LinkedHashMap.this.containsValue(object);
                }

                public int size() {
                    return LinkedHashMap.this.size();
                }

                public void clear() {
                    LinkedHashMap.this.clear();
                }

                public Iterator iterator() {
                    return new LinkedHashIterator(new MapEntry.Type(){

                        public Object get(MapEntry mapEntry) {
                            return mapEntry.value;
                        }
                    }, LinkedHashMap.this);
                }
            };
        }
        return this.valuesCollection;
    }

    public Object remove(Object object) {
        LinkedHashMapEntry linkedHashMapEntry = (LinkedHashMapEntry)this.removeEntry(object);
        if (linkedHashMapEntry == null) {
            return null;
        }
        LinkedHashMapEntry linkedHashMapEntry2 = linkedHashMapEntry.chainBackward;
        LinkedHashMapEntry linkedHashMapEntry3 = linkedHashMapEntry.chainForward;
        if (linkedHashMapEntry2 != null) {
            linkedHashMapEntry2.chainForward = linkedHashMapEntry3;
        } else {
            this.head = linkedHashMapEntry3;
        }
        if (linkedHashMapEntry3 != null) {
            linkedHashMapEntry3.chainBackward = linkedHashMapEntry2;
        } else {
            this.tail = linkedHashMapEntry2;
        }
        return linkedHashMapEntry.value;
    }

    protected boolean removeEldestEntry(Map.Entry entry) {
        return false;
    }

    public void clear() {
        super.clear();
        this.tail = null;
        this.head = null;
    }

    public Object clone() {
        LinkedHashMap linkedHashMap = (LinkedHashMap)super.clone();
        linkedHashMap.clear();
        Iterator iterator = this.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry)iterator.next();
            linkedHashMap.put(entry.getKey(), entry.getValue());
        }
        return linkedHashMap;
    }

    static /* synthetic */ void access$1(LinkedHashMap linkedHashMap, LinkedHashMapEntry linkedHashMapEntry) {
        linkedHashMap.tail = linkedHashMapEntry;
    }

    static /* synthetic */ void access$2(LinkedHashMap linkedHashMap, LinkedHashMapEntry linkedHashMapEntry) {
        linkedHashMap.head = linkedHashMapEntry;
    }

    static final class LinkedHashIterator
    extends HashMap.HashMapIterator {
        LinkedHashIterator(MapEntry.Type type, LinkedHashMap linkedHashMap) {
            super(type, linkedHashMap);
            this.entry = linkedHashMap.head;
        }

        public boolean hasNext() {
            return this.entry != null;
        }

        public Object next() {
            this.checkConcurrentMod();
            if (!this.hasNext()) {
                throw new NoSuchElementException();
            }
            Object object = this.type.get(this.entry);
            this.lastEntry = this.entry;
            this.entry = ((LinkedHashMapEntry)this.entry).chainForward;
            this.canRemove = true;
            return object;
        }

        /*
         * Unable to fully structure code
         */
        public void remove() {
            block8: {
                this.checkConcurrentMod();
                if (!this.canRemove) {
                    throw new IllegalStateException();
                }
                this.canRemove = false;
                ++this.associatedMap.modCount;
                var1_1 = this.associatedMap.getModuloHash(this.lastEntry.key);
                var2_2 = (LinkedHashMapEntry)this.associatedMap.elementData[var1_1];
                if (var2_2 != this.lastEntry) ** GOTO lbl13
                this.associatedMap.elementData[var1_1] = this.lastEntry.next;
                break block8;
                while (var2_2.next != this.lastEntry) {
                    var2_2 = (LinkedHashMapEntry)var2_2.next;
lbl13:
                    // 2 sources

                    if (var2_2.next != null) continue;
                }
                var2_2.next = this.lastEntry.next;
            }
            var3_3 = (LinkedHashMapEntry)this.lastEntry;
            var4_4 = var3_3.chainBackward;
            var5_5 = var3_3.chainForward;
            var6_6 = (LinkedHashMap)this.associatedMap;
            if (var4_4 != null) {
                var4_4.chainForward = var5_5;
                if (var5_5 != null) {
                    var5_5.chainBackward = var4_4;
                } else {
                    LinkedHashMap.access$1(var6_6, var4_4);
                }
            } else {
                LinkedHashMap.access$2(var6_6, var5_5);
                if (var5_5 != null) {
                    var5_5.chainBackward = null;
                } else {
                    LinkedHashMap.access$1(var6_6, null);
                }
            }
            --this.associatedMap.elementCount;
            ++this.expectedModCount;
        }
    }

    static final class LinkedHashMapEntry
    extends HashMap.Entry {
        LinkedHashMapEntry chainForward = null;
        LinkedHashMapEntry chainBackward = null;

        LinkedHashMapEntry(Object object, Object object2) {
            super(object, object2);
        }

        public Object clone() {
            LinkedHashMapEntry linkedHashMapEntry = (LinkedHashMapEntry)super.clone();
            linkedHashMapEntry.chainBackward = this.chainBackward;
            linkedHashMapEntry.chainForward = this.chainForward;
            LinkedHashMapEntry linkedHashMapEntry2 = (LinkedHashMapEntry)linkedHashMapEntry.next;
            if (linkedHashMapEntry2 != null) {
                linkedHashMapEntry.next = (LinkedHashMapEntry)linkedHashMapEntry2.clone();
            }
            return linkedHashMapEntry;
        }
    }

    static final class LinkedHashMapEntrySet
    extends HashMap.HashMapEntrySet {
        public LinkedHashMapEntrySet(LinkedHashMap linkedHashMap) {
            super(linkedHashMap);
        }

        public Iterator iterator() {
            return new LinkedHashIterator(new MapEntry.Type(){

                public Object get(MapEntry mapEntry) {
                    return mapEntry;
                }
            }, (LinkedHashMap)this.hashMap());
        }
    }
}

