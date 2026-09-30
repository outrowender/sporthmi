/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base.eal;

import de.audi.atip.hmi.view.IImageLoader;
import de.audi.atip.log.LogChannel;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.base.LRUCache;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class LRUCacheEAL
implements LRUCache {
    Map myHashMap = new HashMap();
    Item listStart = new Item();
    Item listEnd = new Item();
    int maxSize;
    long storageSize;
    static LogChannel logHybridCalls;
    static LogChannel logBinSizes;
    static LogChannel logLRUCache;
    private Map[] requestedItemsPerTerminal = new HashMap[8];
    private static final boolean COLLECT_BIN_STATS;
    private final IImageLoader imageLoader;
    static Object[] elements;

    public LRUCacheEAL(int n, IImageLoader iImageLoader) {
        this.imageLoader = iImageLoader;
        this.maxSize = n;
        this.listStart.next = this.listEnd;
        this.listEnd.previous = this.listStart;
        logHybridCalls = AbstractWidget.framework.getLogChannel("Ext.HybridHWGCalls");
        if (AbstractWidget.framework.isFrontMU()) {
            this.requestedItemsPerTerminal[0] = new HashMap();
            this.requestedItemsPerTerminal[1] = new HashMap();
            this.requestedItemsPerTerminal[2] = new HashMap();
        } else {
            this.requestedItemsPerTerminal[0] = new HashMap();
            this.requestedItemsPerTerminal[1] = new HashMap();
            this.requestedItemsPerTerminal[2] = new HashMap();
            this.requestedItemsPerTerminal[3] = new HashMap();
            this.requestedItemsPerTerminal[4] = new HashMap();
            this.requestedItemsPerTerminal[5] = new HashMap();
        }
    }

    void removeItem(Item item) {
        item.previous.next = item.next;
        item.next.previous = item.previous;
        if (COLLECT_BIN_STATS) {
            // empty if block
        }
        try {
            logHybridCalls.log(10000000, "LRUCacheImpl#removeItem before destroyDrawable call");
            this.imageLoader.destroyImage(item.value);
            logHybridCalls.log(10000000, "LRUCacheImpl#removeItem after destroyDrawable call");
        }
        catch (RuntimeException runtimeException) {
            logHybridCalls.log(1000, "LRUCacheImpl#removeItem couldn't destroy bitmap with id: %1, reason was: %2", (Object)item.key, (Object)runtimeException.getMessage());
        }
    }

    void insertHead(Item item) {
        item.previous = this.listStart;
        item.next = this.listStart.next;
        this.listStart.next.previous = item;
        this.listStart.next = item;
    }

    void moveToHead(Item item) {
        item.previous.next = item.next;
        item.next.previous = item.previous;
        item.previous = this.listStart;
        item.next = this.listStart.next;
        this.listStart.next.previous = item;
        this.listStart.next = item;
    }

    public Object get(Comparable comparable, int n, int n2) {
        Item item = (Item)this.myHashMap.get(comparable);
        if (item == null) {
            return null;
        }
        if (item != this.listStart.next) {
            this.moveToHead(item);
        }
        this.updateScreenList(comparable, n, n2, item);
        return item.value;
    }

    public Object[] elements() {
        int n = 0;
        Item item = this.listStart.next;
        while (item != null && !item.equals(this.listEnd)) {
            ++n;
            item = item.next;
        }
        if (elements == null || n > elements.length) {
            elements = new Object[n];
        }
        n = 0;
        item = this.listStart.next;
        while (item != null && !item.equals(this.listEnd)) {
            LRUCacheEAL.elements[n] = item.value;
            ++n;
            item = item.next;
        }
        Object[] objectArray = new Object[n];
        System.arraycopy((Object)elements, 0, (Object)objectArray, 0, n);
        return objectArray;
    }

    public void clear() {
        while (!this.myHashMap.isEmpty()) {
            Item item = this.listEnd.previous;
            this.myHashMap.remove(item.key);
            this.storageSize -= item.size;
            this.removeItem(item);
        }
        for (int i2 = 0; i2 < this.requestedItemsPerTerminal.length; ++i2) {
            Map map = this.requestedItemsPerTerminal[i2];
            if (map == null) continue;
            map.clear();
        }
    }

    public void put(Comparable comparable, Object object, int n, int n2, int n3, int n4, int n5) {
        Item item;
        logLRUCache.log(10000000, "LRUCacheImpl#put next bitmap with ID: %1", (Object)comparable);
        if (COLLECT_BIN_STATS) {
            // empty if block
        }
        if ((item = (Item)this.myHashMap.get(comparable)) != null) {
            item.value = object;
            item.size = n;
            this.moveToHead(item);
            this.updateScreenList(comparable, n4, n5, item);
            return;
        }
        item = this.listEnd.previous;
        while (this.storageSize + (long)n > (long)this.maxSize && item != null && !item.equals(this.listStart)) {
            Item item2 = item.previous;
            if (item.referenceCounter == 0) {
                this.removeItemAndAdjustSize(item);
            } else if (item.referenceCounter == 1 && this.isItemReferencedFromSameScreenInSameTerminal(item.key, n4, n5)) {
                this.removeReferenceFromSameTerminal(item.key, n4, n5);
                if (item.referenceCounter == 0) {
                    this.removeItemAndAdjustSize(item);
                } else {
                    logLRUCache.log(10000000, "LRUCacheImpl#put can't remove item after decreasing reference: %1 because refCounter is: %2", (Object)item.key, (long)item.referenceCounter);
                }
            } else {
                logLRUCache.log(10000000, "LRUCacheImpl#put can't remove item: %1 because refCounter is: %2", (Object)item.key, (long)item.referenceCounter);
            }
            item = item2;
        }
        Item item3 = new Item(comparable, object, n);
        this.insertHead(item3);
        this.myHashMap.put(comparable, item3);
        this.updateScreenList(comparable, n4, n5, item3);
        this.storageSize += (long)n;
    }

    private void removeItemAndAdjustSize(Item item) {
        logLRUCache.log(10000000, "LRUCacheImpl#put before remove current storage size is: %2, trying to remove: %1", (Object)item.key, this.storageSize);
        this.storageSize -= item.size;
        this.myHashMap.remove(item.key);
        this.removeItem(item);
        logLRUCache.log(10000000, "LRUCacheImpl#put after remove current storage size is: %2, trying to remove: %1", (Object)item.key, this.storageSize);
    }

    private void updateScreenList(Comparable comparable, int n, int n2, Item item) {
        HashMap hashMap = (HashMap)this.requestedItemsPerTerminal[n2].get(new Integer(n));
        if (hashMap == null) {
            hashMap = new HashMap();
            this.requestedItemsPerTerminal[n2].put(new Integer(n), hashMap);
        }
        if (hashMap.get(comparable) == null) {
            hashMap.put(comparable, item);
            ++item.referenceCounter;
        }
    }

    private boolean isItemReferencedFromSameScreenInSameTerminal(Comparable comparable, int n, int n2) {
        HashMap hashMap = (HashMap)this.requestedItemsPerTerminal[n2].get(new Integer(n));
        return hashMap != null && hashMap.get(comparable) != null;
    }

    private void removeReferenceFromSameTerminal(Comparable comparable, int n, int n2) {
        logLRUCache.log(10000000, "LRUCacheImpl#removeReferenceFromSameTerminal for screeen: %2 and id: %1", (Object)comparable, (long)n);
        HashMap hashMap = (HashMap)this.requestedItemsPerTerminal[n2].get(new Integer(n));
        Item item = (Item)hashMap.get(comparable);
        if (item != null) {
            --item.referenceCounter;
            if (item.referenceCounter < 0) {
                logLRUCache.log(10000000, "LRUCacheImpl#removeReferenceFromSameTerminal problem with refcounter for screeen: %2 and id: %1", (Object)item.key, (long)n);
            }
            hashMap.remove(comparable);
        }
    }

    public int size() {
        return this.myHashMap.size();
    }

    public void decrementRefCounters(int n, int n2) {
        Integer n3 = new Integer(n);
        HashMap hashMap = (HashMap)this.requestedItemsPerTerminal[n2].get(n3);
        if (hashMap != null) {
            Collection collection = hashMap.values();
            Iterator iterator = collection.iterator();
            while (iterator.hasNext()) {
                Item item = (Item)iterator.next();
                --item.referenceCounter;
                if (item.referenceCounter >= 0) continue;
                logLRUCache.log(10000000, "LRUCacheImpl#decrementRefCounters problem with refcounter for screeen: %2 and id: %1", (Object)item.key, (long)n);
            }
            this.requestedItemsPerTerminal[n2].remove(n3);
        }
    }

    public Item[] getItems() {
        int n = 0;
        Item item = this.listStart.next;
        while (item != null && !item.equals(this.listEnd)) {
            ++n;
            item = item.next;
        }
        if (n == 0) {
            return null;
        }
        if (elements == null || n != elements.length) {
            elements = new Item[n];
        }
        n = 0;
        item = this.listStart.next;
        while (item != null && !item.equals(this.listEnd)) {
            LRUCacheEAL.elements[n] = item;
            ++n;
            item = item.next;
        }
        Item[] itemArray = new Item[n];
        System.arraycopy((Object)elements, 0, (Object)itemArray, 0, n);
        return itemArray;
    }

    public long getStorageSize() {
        return this.storageSize;
    }

    static {
        logBinSizes = IWidgetLogChannel.binSizeLogChannel;
        logLRUCache = IWidgetLogChannel.lRULogChannel;
        COLLECT_BIN_STATS = System.getProperty("collectBinStats") != null;
    }

    static class Item {
        public Comparable key;
        public Object value;
        public long size;
        public Item previous;
        public Item next;
        public int referenceCounter;

        public Item(Comparable comparable, Object object, long l) {
            this.key = comparable;
            this.value = object;
            this.size = l;
        }

        public Item() {
        }
    }
}

