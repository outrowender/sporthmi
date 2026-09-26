/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base.eal;

import de.audi.atip.hmi.view.IImageLoader;
import de.audi.atip.log.LogChannel;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.base.LRUCache;
import de.esolutions.hmi.widgets.audi.base.eal.LRUCacheEAL$Item;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class LRUCacheEAL
implements LRUCache {
    Map myHashMap = new HashMap();
    LRUCacheEAL$Item listStart = new LRUCacheEAL$Item();
    LRUCacheEAL$Item listEnd = new LRUCacheEAL$Item();
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

    void removeItem(LRUCacheEAL$Item lRUCacheEAL$Item) {
        lRUCacheEAL$Item.previous.next = lRUCacheEAL$Item.next;
        lRUCacheEAL$Item.next.previous = lRUCacheEAL$Item.previous;
        if (COLLECT_BIN_STATS) {
            // empty if block
        }
        try {
            logHybridCalls.log(-2137614336, "LRUCacheImpl#removeItem before destroyDrawable call");
            this.imageLoader.destroyImage(lRUCacheEAL$Item.value);
            logHybridCalls.log(-2137614336, "LRUCacheImpl#removeItem after destroyDrawable call");
        }
        catch (RuntimeException runtimeException) {
            logHybridCalls.log(1000, "LRUCacheImpl#removeItem couldn't destroy bitmap with id: %1, reason was: %2", (Object)lRUCacheEAL$Item.key, (Object)runtimeException.getMessage());
        }
    }

    void insertHead(LRUCacheEAL$Item lRUCacheEAL$Item) {
        lRUCacheEAL$Item.previous = this.listStart;
        lRUCacheEAL$Item.next = this.listStart.next;
        this.listStart.next.previous = lRUCacheEAL$Item;
        this.listStart.next = lRUCacheEAL$Item;
    }

    void moveToHead(LRUCacheEAL$Item lRUCacheEAL$Item) {
        lRUCacheEAL$Item.previous.next = lRUCacheEAL$Item.next;
        lRUCacheEAL$Item.next.previous = lRUCacheEAL$Item.previous;
        lRUCacheEAL$Item.previous = this.listStart;
        lRUCacheEAL$Item.next = this.listStart.next;
        this.listStart.next.previous = lRUCacheEAL$Item;
        this.listStart.next = lRUCacheEAL$Item;
    }

    @Override
    public Object get(Comparable comparable, int n, int n2) {
        LRUCacheEAL$Item lRUCacheEAL$Item = (LRUCacheEAL$Item)this.myHashMap.get(comparable);
        if (lRUCacheEAL$Item == null) {
            return null;
        }
        if (lRUCacheEAL$Item != this.listStart.next) {
            this.moveToHead(lRUCacheEAL$Item);
        }
        this.updateScreenList(comparable, n, n2, lRUCacheEAL$Item);
        return lRUCacheEAL$Item.value;
    }

    @Override
    public Object[] elements() {
        int n = 0;
        LRUCacheEAL$Item lRUCacheEAL$Item = this.listStart.next;
        while (lRUCacheEAL$Item != null && !lRUCacheEAL$Item.equals(this.listEnd)) {
            ++n;
            lRUCacheEAL$Item = lRUCacheEAL$Item.next;
        }
        if (elements == null || n > elements.length) {
            elements = new Object[n];
        }
        n = 0;
        lRUCacheEAL$Item = this.listStart.next;
        while (lRUCacheEAL$Item != null && !lRUCacheEAL$Item.equals(this.listEnd)) {
            LRUCacheEAL.elements[n] = lRUCacheEAL$Item.value;
            ++n;
            lRUCacheEAL$Item = lRUCacheEAL$Item.next;
        }
        Object[] objectArray = new Object[n];
        System.arraycopy((Object)elements, 0, (Object)objectArray, 0, n);
        return objectArray;
    }

    @Override
    public void clear() {
        while (!this.myHashMap.isEmpty()) {
            LRUCacheEAL$Item lRUCacheEAL$Item = this.listEnd.previous;
            this.myHashMap.remove(lRUCacheEAL$Item.key);
            this.storageSize -= lRUCacheEAL$Item.size;
            this.removeItem(lRUCacheEAL$Item);
        }
        for (int i2 = 0; i2 < this.requestedItemsPerTerminal.length; ++i2) {
            Map map = this.requestedItemsPerTerminal[i2];
            if (map == null) continue;
            map.clear();
        }
    }

    @Override
    public void put(Comparable comparable, Object object, int n, int n2, int n3, int n4, int n5) {
        LRUCacheEAL$Item lRUCacheEAL$Item;
        logLRUCache.log(-2137614336, "LRUCacheImpl#put next bitmap with ID: %1", (Object)comparable);
        if (COLLECT_BIN_STATS) {
            // empty if block
        }
        if ((lRUCacheEAL$Item = (LRUCacheEAL$Item)this.myHashMap.get(comparable)) != null) {
            lRUCacheEAL$Item.value = object;
            lRUCacheEAL$Item.size = n;
            this.moveToHead(lRUCacheEAL$Item);
            this.updateScreenList(comparable, n4, n5, lRUCacheEAL$Item);
            return;
        }
        lRUCacheEAL$Item = this.listEnd.previous;
        while (this.storageSize + (long)n > (long)this.maxSize && lRUCacheEAL$Item != null && !lRUCacheEAL$Item.equals(this.listStart)) {
            LRUCacheEAL$Item lRUCacheEAL$Item2 = lRUCacheEAL$Item.previous;
            if (lRUCacheEAL$Item.referenceCounter == 0) {
                this.removeItemAndAdjustSize(lRUCacheEAL$Item);
            } else if (lRUCacheEAL$Item.referenceCounter == 1 && this.isItemReferencedFromSameScreenInSameTerminal(lRUCacheEAL$Item.key, n4, n5)) {
                this.removeReferenceFromSameTerminal(lRUCacheEAL$Item.key, n4, n5);
                if (lRUCacheEAL$Item.referenceCounter == 0) {
                    this.removeItemAndAdjustSize(lRUCacheEAL$Item);
                } else {
                    logLRUCache.log(-2137614336, "LRUCacheImpl#put can't remove item after decreasing reference: %1 because refCounter is: %2", (Object)lRUCacheEAL$Item.key, (long)lRUCacheEAL$Item.referenceCounter);
                }
            } else {
                logLRUCache.log(-2137614336, "LRUCacheImpl#put can't remove item: %1 because refCounter is: %2", (Object)lRUCacheEAL$Item.key, (long)lRUCacheEAL$Item.referenceCounter);
            }
            lRUCacheEAL$Item = lRUCacheEAL$Item2;
        }
        LRUCacheEAL$Item lRUCacheEAL$Item3 = new LRUCacheEAL$Item(comparable, object, n);
        this.insertHead(lRUCacheEAL$Item3);
        this.myHashMap.put(comparable, lRUCacheEAL$Item3);
        this.updateScreenList(comparable, n4, n5, lRUCacheEAL$Item3);
        this.storageSize += (long)n;
    }

    private void removeItemAndAdjustSize(LRUCacheEAL$Item lRUCacheEAL$Item) {
        logLRUCache.log(-2137614336, "LRUCacheImpl#put before remove current storage size is: %2, trying to remove: %1", (Object)lRUCacheEAL$Item.key, this.storageSize);
        this.storageSize -= lRUCacheEAL$Item.size;
        this.myHashMap.remove(lRUCacheEAL$Item.key);
        this.removeItem(lRUCacheEAL$Item);
        logLRUCache.log(-2137614336, "LRUCacheImpl#put after remove current storage size is: %2, trying to remove: %1", (Object)lRUCacheEAL$Item.key, this.storageSize);
    }

    private void updateScreenList(Comparable comparable, int n, int n2, LRUCacheEAL$Item lRUCacheEAL$Item) {
        HashMap hashMap = (HashMap)this.requestedItemsPerTerminal[n2].get(new Integer(n));
        if (hashMap == null) {
            hashMap = new HashMap();
            this.requestedItemsPerTerminal[n2].put(new Integer(n), hashMap);
        }
        if (hashMap.get(comparable) == null) {
            hashMap.put(comparable, lRUCacheEAL$Item);
            ++lRUCacheEAL$Item.referenceCounter;
        }
    }

    private boolean isItemReferencedFromSameScreenInSameTerminal(Comparable comparable, int n, int n2) {
        HashMap hashMap = (HashMap)this.requestedItemsPerTerminal[n2].get(new Integer(n));
        return hashMap != null && hashMap.get(comparable) != null;
    }

    private void removeReferenceFromSameTerminal(Comparable comparable, int n, int n2) {
        logLRUCache.log(-2137614336, "LRUCacheImpl#removeReferenceFromSameTerminal for screeen: %2 and id: %1", (Object)comparable, (long)n);
        HashMap hashMap = (HashMap)this.requestedItemsPerTerminal[n2].get(new Integer(n));
        LRUCacheEAL$Item lRUCacheEAL$Item = (LRUCacheEAL$Item)hashMap.get(comparable);
        if (lRUCacheEAL$Item != null) {
            --lRUCacheEAL$Item.referenceCounter;
            if (lRUCacheEAL$Item.referenceCounter < 0) {
                logLRUCache.log(-2137614336, "LRUCacheImpl#removeReferenceFromSameTerminal problem with refcounter for screeen: %2 and id: %1", (Object)lRUCacheEAL$Item.key, (long)n);
            }
            hashMap.remove(comparable);
        }
    }

    @Override
    public int size() {
        return this.myHashMap.size();
    }

    @Override
    public void decrementRefCounters(int n, int n2) {
        Integer n3 = new Integer(n);
        HashMap hashMap = (HashMap)this.requestedItemsPerTerminal[n2].get(n3);
        if (hashMap != null) {
            Collection collection = hashMap.values();
            Iterator iterator = collection.iterator();
            while (iterator.hasNext()) {
                LRUCacheEAL$Item lRUCacheEAL$Item = (LRUCacheEAL$Item)iterator.next();
                --lRUCacheEAL$Item.referenceCounter;
                if (lRUCacheEAL$Item.referenceCounter >= 0) continue;
                logLRUCache.log(-2137614336, "LRUCacheImpl#decrementRefCounters problem with refcounter for screeen: %2 and id: %1", (Object)lRUCacheEAL$Item.key, (long)n);
            }
            this.requestedItemsPerTerminal[n2].remove(n3);
        }
    }

    public LRUCacheEAL$Item[] getItems() {
        int n = 0;
        LRUCacheEAL$Item lRUCacheEAL$Item = this.listStart.next;
        while (lRUCacheEAL$Item != null && !lRUCacheEAL$Item.equals(this.listEnd)) {
            ++n;
            lRUCacheEAL$Item = lRUCacheEAL$Item.next;
        }
        if (n == 0) {
            return null;
        }
        if (elements == null || n != elements.length) {
            elements = new LRUCacheEAL$Item[n];
        }
        n = 0;
        lRUCacheEAL$Item = this.listStart.next;
        while (lRUCacheEAL$Item != null && !lRUCacheEAL$Item.equals(this.listEnd)) {
            LRUCacheEAL.elements[n] = lRUCacheEAL$Item;
            ++n;
            lRUCacheEAL$Item = lRUCacheEAL$Item.next;
        }
        LRUCacheEAL$Item[] lRUCacheEAL$ItemArray = new LRUCacheEAL$Item[n];
        System.arraycopy((Object)elements, 0, (Object)lRUCacheEAL$ItemArray, 0, n);
        return lRUCacheEAL$ItemArray;
    }

    @Override
    public long getStorageSize() {
        return this.storageSize;
    }

    static {
        logBinSizes = IWidgetLogChannel.binSizeLogChannel;
        logLRUCache = IWidgetLogChannel.lRULogChannel;
        COLLECT_BIN_STATS = System.getProperty("collectBinStats") != null;
    }
}

