/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base.eal;

import de.audi.atip.log.LogChannel;
import de.audi.atip.util.Util;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.base.eal.EALManager;
import de.esolutions.hmi.widgets.audi.base.eal.ITextureCache;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedTexture;
import de.esolutions.hmi.widgets.audi.base.eal.LRUTextureCache$CacheEntry;
import de.esolutions.hmi.widgets.audi.base.eal.TextureDescription;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map$Entry;
import java.util.Set;

public class LRUTextureCache
implements ITextureCache,
IWidgetLogChannel {
    private final Buffer buffer = new Buffer();
    private final EALManager ealManager;
    private final int cacheId;
    private final Map texDescrCounter = new HashMap();
    private final Map texDescrRawImgSize = new HashMap();
    private final LinkedList list = new LinkedList();
    private int rawImgRamUsage = 0;
    private final int freeLevel;
    private final int errorLevel;
    private final Map descriptionMap = new HashMap();
    private boolean levelsAreInByte;
    private final boolean deferredCacheDeleteActive;

    public LRUTextureCache(EALManager eALManager, int n, int n2, int n3) {
        this(eALManager, n, n2, n3, false);
    }

    public LRUTextureCache(EALManager eALManager, int n, int n2, int n3, boolean bl) {
        this(eALManager, n, n2, n3, bl, false);
    }

    public LRUTextureCache(EALManager eALManager, int n, int n2, int n3, boolean bl, boolean bl2) {
        logChannel3DEngineCache.log(1078071040, "LRUTextureCache constructing cache %1, (%2, %3)", (long)n, (long)n2, (long)n3);
        this.ealManager = eALManager;
        this.cacheId = n;
        this.levelsAreInByte = bl;
        this.freeLevel = n2;
        this.errorLevel = n3;
        this.deferredCacheDeleteActive = bl2;
    }

    @Override
    public IWrappedTexture getTexture(TextureDescription textureDescription, Object object) {
        Object object2 = LRUTextureCache.getKey(textureDescription);
        LRUTextureCache$CacheEntry lRUTextureCache$CacheEntry = (LRUTextureCache$CacheEntry)this.texDescrCounter.get(object2);
        if (lRUTextureCache$CacheEntry == null) {
            logChannel3DEngineCache.log(-2137614336, "LRUTextureCache#getTexture cache miss for %1 in cache %2", (Object)textureDescription, (long)this.cacheId);
            this.freeBufferIfNeeded();
            return this.createCacheEntry(textureDescription, object);
        }
        this.list.remove(lRUTextureCache$CacheEntry);
        this.list.addFirst(lRUTextureCache$CacheEntry);
        return LRUTextureCache$CacheEntry.access$000(lRUTextureCache$CacheEntry, object);
    }

    @Override
    public IWrappedTexture getCachedTexture(TextureDescription textureDescription, Object object) {
        Object object2 = LRUTextureCache.getKey(textureDescription);
        LRUTextureCache$CacheEntry lRUTextureCache$CacheEntry = (LRUTextureCache$CacheEntry)this.texDescrCounter.get(object2);
        if (lRUTextureCache$CacheEntry == null) {
            return null;
        }
        return LRUTextureCache$CacheEntry.access$000(lRUTextureCache$CacheEntry, object);
    }

    @Override
    public boolean isTextureCached(TextureDescription textureDescription) {
        Object object = LRUTextureCache.getKey(textureDescription);
        LRUTextureCache$CacheEntry lRUTextureCache$CacheEntry = (LRUTextureCache$CacheEntry)this.texDescrCounter.get(object);
        return lRUTextureCache$CacheEntry != null;
    }

    private static Object getKey(TextureDescription textureDescription) {
        return textureDescription.getCacheKey();
    }

    private void freeBufferIfNeeded() {
        if (this.rawImgRamUsage < this.freeLevel) {
            logChannel3DEngineCache.log(14808325, "LRUTextureCache#freeBufferIfNeeded current ramUsage: %1", (long)this.rawImgRamUsage);
            return;
        }
        logChannel3DEngineCache.log(-2137614336, "LRUTextureCache#freeBufferIfNeeded ramUsage: %1", (long)this.rawImgRamUsage);
        while (this.rawImgRamUsage >= this.freeLevel) {
            LRUTextureCache$CacheEntry lRUTextureCache$CacheEntry = this.getNextFreeEntry();
            if (lRUTextureCache$CacheEntry == null) {
                int n = this.rawImgRamUsage >= this.errorLevel ? 10000 : -1601830656;
                logChannel3DEngineCache.log(n, "LRUTextureCache#freeBufferIfNeeded items in cache %2 need %1 Bytes RAM", (long)this.rawImgRamUsage, (long)this.cacheId);
                return;
            }
            this.freeCacheEntry(lRUTextureCache$CacheEntry);
        }
    }

    private void freeCacheEntry(LRUTextureCache$CacheEntry lRUTextureCache$CacheEntry) {
        IWrappedTexture iWrappedTexture = lRUTextureCache$CacheEntry.getTexture();
        this.ealManager.destroy(iWrappedTexture);
        Object object = iWrappedTexture.getDescription().getCacheKey();
        this.texDescrCounter.remove(object);
        int n = (Integer)this.texDescrRawImgSize.get(object);
        this.rawImgRamUsage -= n;
        this.texDescrRawImgSize.remove(object);
        this.descriptionMap.remove(object);
        this.list.remove(lRUTextureCache$CacheEntry);
        if (logChannel3DEngineCacheSize.isInfo()) {
            this.buffer.clear();
            this.buffer.append("LRUTextureCache#freeCacheEntry added texture for key ");
            this.buffer.append(object);
            this.buffer.append(", size=");
            this.buffer.append(n);
            this.buffer.append(", cacheId=");
            this.buffer.append(this.getCacheId());
            this.buffer.append(", cacheEntries=");
            this.buffer.append(this.list.size());
            this.buffer.append(", cacheSize=");
            this.buffer.append(this.rawImgRamUsage);
            logChannel3DEngineCacheSize.log(1078071040, this.buffer.toString());
        }
    }

    public int clearBufferIfPossible() {
        int n = this.rawImgRamUsage;
        int n2 = 0;
        LRUTextureCache$CacheEntry lRUTextureCache$CacheEntry = this.getNextFreeEntry();
        while (lRUTextureCache$CacheEntry != null) {
            IWrappedTexture iWrappedTexture = lRUTextureCache$CacheEntry.getTexture();
            this.ealManager.destroy(iWrappedTexture);
            Object object = iWrappedTexture.getDescription().getCacheKey();
            this.texDescrCounter.remove(object);
            this.rawImgRamUsage -= ((Integer)this.texDescrRawImgSize.get(object)).intValue();
            this.texDescrRawImgSize.remove(object);
            this.descriptionMap.remove(object);
            this.list.remove(lRUTextureCache$CacheEntry);
            lRUTextureCache$CacheEntry = this.getNextFreeEntry();
            ++n2;
        }
        int n3 = n - this.rawImgRamUsage;
        if (logChannel3DEngineCacheSize.isInfo()) {
            this.buffer.clear();
            this.buffer.append("LRUTextureCache#clearBufferIfPossible cleared ");
            this.buffer.append(n2);
            this.buffer.append(" entries, clearedRam=");
            this.buffer.append(n3);
            this.buffer.append(", cacheId=");
            this.buffer.append(this.getCacheId());
            this.buffer.append(", cacheEntries=");
            this.buffer.append(this.list.size());
            this.buffer.append(", cacheSize=");
            this.buffer.append(this.rawImgRamUsage);
            logChannel3DEngineCacheSize.log(1078071040, this.buffer.toString());
        }
        if (this.deferredCacheDeleteActive) {
            this.markAsDeleted();
        }
        int n4 = -2137614336;
        if (this.rawImgRamUsage >= this.freeLevel) {
            n4 = this.rawImgRamUsage >= this.errorLevel ? 10000 : -1601830656;
        }
        logChannel3DEngineCache.log(n4, "LRUTextureCache#clearBufferIfPossible initialRamUsed: %1, clearedRAMSpace: %2, remainingRAMUsed: %3", (long)n, (long)(n - this.rawImgRamUsage), (long)this.rawImgRamUsage);
        return n3;
    }

    private LRUTextureCache$CacheEntry getNextFreeEntry() {
        ListIterator listIterator = this.list.listIterator(this.list.size());
        while (listIterator.hasPrevious()) {
            LRUTextureCache$CacheEntry lRUTextureCache$CacheEntry = (LRUTextureCache$CacheEntry)listIterator.previous();
            if (LRUTextureCache$CacheEntry.access$100(lRUTextureCache$CacheEntry) > 0) continue;
            return lRUTextureCache$CacheEntry;
        }
        return null;
    }

    public int getCountOfFreeRefrences() {
        ListIterator listIterator = this.list.listIterator(this.list.size());
        int n = 0;
        while (listIterator.hasPrevious()) {
            LRUTextureCache$CacheEntry lRUTextureCache$CacheEntry = (LRUTextureCache$CacheEntry)listIterator.previous();
            if (LRUTextureCache$CacheEntry.access$100(lRUTextureCache$CacheEntry) > 0) continue;
            ++n;
        }
        return n;
    }

    private IWrappedTexture createCacheEntry(TextureDescription textureDescription, Object object) {
        IWrappedTexture iWrappedTexture = textureDescription.createTexture();
        if (iWrappedTexture == null) {
            return null;
        }
        LRUTextureCache$CacheEntry lRUTextureCache$CacheEntry = new LRUTextureCache$CacheEntry(iWrappedTexture, null);
        Object object2 = textureDescription.getCacheKey();
        this.texDescrCounter.put(object2, lRUTextureCache$CacheEntry);
        int n = this.levelsAreInByte ? iWrappedTexture.getRawImageSize() : 1;
        this.texDescrRawImgSize.put(object2, Util.createInteger(n));
        this.rawImgRamUsage += n;
        this.descriptionMap.put(object2, textureDescription);
        this.list.addFirst(lRUTextureCache$CacheEntry);
        if (logChannel3DEngineCacheSize.isInfo()) {
            this.buffer.clear();
            this.buffer.append("LRUTextureCache#createCacheEntry added texture for key ");
            this.buffer.append(object2);
            this.buffer.append(", size=");
            this.buffer.append(n);
            this.buffer.append(", cacheId=");
            this.buffer.append(this.getCacheId());
            this.buffer.append(", cacheEntries=");
            this.buffer.append(this.list.size());
            this.buffer.append(", cacheSize=");
            this.buffer.append(this.rawImgRamUsage);
            logChannel3DEngineCacheSize.log(1078071040, this.buffer.toString());
        }
        return LRUTextureCache$CacheEntry.access$000(lRUTextureCache$CacheEntry, object);
    }

    @Override
    public boolean release(IWrappedTexture iWrappedTexture, Object object) {
        Object object2 = LRUTextureCache.getKey(iWrappedTexture.getDescription());
        LRUTextureCache$CacheEntry lRUTextureCache$CacheEntry = (LRUTextureCache$CacheEntry)this.texDescrCounter.get(object2);
        if (lRUTextureCache$CacheEntry == null) {
            logChannel3DEngineCache.log(10000, "LRUTextureCache#release could not find cacheEntry for %1", (Object)iWrappedTexture);
            return false;
        }
        this.list.remove(lRUTextureCache$CacheEntry);
        this.list.addFirst(lRUTextureCache$CacheEntry);
        boolean bl = LRUTextureCache$CacheEntry.access$300(lRUTextureCache$CacheEntry, object);
        if (LRUTextureCache$CacheEntry.access$400(lRUTextureCache$CacheEntry)) {
            this.freeCacheEntry(lRUTextureCache$CacheEntry);
        }
        this.freeBufferIfNeeded();
        return bl;
    }

    @Override
    public void destroyAll() {
        Set set = this.texDescrCounter.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Map$Entry map$Entry = (Map$Entry)iterator.next();
            LRUTextureCache$CacheEntry lRUTextureCache$CacheEntry = (LRUTextureCache$CacheEntry)map$Entry.getValue();
            if (lRUTextureCache$CacheEntry == null) continue;
            this.ealManager.destroy(lRUTextureCache$CacheEntry.getTexture());
        }
        this.texDescrCounter.clear();
        this.texDescrRawImgSize.clear();
        logChannel3DEngineCacheSize.log(1078071040, "LRUTextureCache#destroyAll cleared %1 entries, cacheId=%2, size=%3", (long)this.list.size(), (long)this.getCacheId(), (long)this.rawImgRamUsage);
        this.list.clear();
        this.descriptionMap.clear();
        this.rawImgRamUsage = 0;
    }

    public int getRefCount(TextureDescription textureDescription) {
        Object object = LRUTextureCache.getKey(textureDescription);
        LRUTextureCache$CacheEntry lRUTextureCache$CacheEntry = (LRUTextureCache$CacheEntry)this.texDescrCounter.get(object);
        if (lRUTextureCache$CacheEntry == null) {
            logChannel3DEngineCache.log(-2137614336, "LRUTextureCache#getRefCount could not find cacheEntry for %1", (Object)textureDescription);
            return -1;
        }
        return LRUTextureCache$CacheEntry.access$500(lRUTextureCache$CacheEntry).size();
    }

    public int getCacheSize() {
        return this.texDescrCounter.size();
    }

    public int getCachedBytes() {
        return this.rawImgRamUsage;
    }

    @Override
    public void dump() {
        this.dump(logChannel3DEngineCache);
    }

    @Override
    public void dump(LogChannel logChannel) {
        Object object;
        logChannel.log(1078071040, "LRUTextureCache#dump Cache %1, size=%2", (long)this.cacheId, (long)this.rawImgRamUsage);
        logChannel.log(1078071040, "LRUTextureCache#dump warnLevel=%1, errorLevel=%2", (long)this.freeLevel, (long)this.errorLevel);
        for (int i2 = 0; i2 < this.list.size(); ++i2) {
            object = (LRUTextureCache$CacheEntry)this.list.get(i2);
            logChannel.log(1078071040, "LRUTextureCache#dump CacheEntry: %2, CacheKey: %1, references=%3", ((LRUTextureCache$CacheEntry)object).getTexture().getDescription().getCacheKey(), (Object)((LRUTextureCache$CacheEntry)object).getTexture(), (long)LRUTextureCache$CacheEntry.access$100((LRUTextureCache$CacheEntry)object));
        }
        Set set = this.descriptionMap.entrySet();
        logChannel.log(1078071040, "LRUTextureCache#dump Size of description-map: %1", (long)set.size());
        object = set.iterator();
        while (object.hasNext()) {
            Map$Entry map$Entry = (Map$Entry)object.next();
            logChannel.log(1078071040, "LRUTextureCache#dump Description-Entry: %1", map$Entry.getKey());
        }
    }

    @Override
    public int getCacheId() {
        return this.cacheId;
    }

    @Override
    public TextureDescription getTextureDescriptionByKey(Object object) {
        Object object2 = this.descriptionMap.get(object);
        if (object2 != null) {
            return (TextureDescription)object2;
        }
        return null;
    }

    private void markAsDeleted() {
        ListIterator listIterator = this.list.listIterator(this.list.size());
        while (listIterator.hasPrevious()) {
            LRUTextureCache$CacheEntry lRUTextureCache$CacheEntry = (LRUTextureCache$CacheEntry)listIterator.previous();
            LRUTextureCache$CacheEntry.access$602(lRUTextureCache$CacheEntry, true);
        }
        logChannel3DEngineCache.log(1078071040, "LRUTextureCache#markAsDeleted Cache %1, %2 entries marked for deferred cache delete.", (long)this.cacheId, (long)this.list.size());
    }
}

