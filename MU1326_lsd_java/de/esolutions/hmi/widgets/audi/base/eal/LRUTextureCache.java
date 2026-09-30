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
import de.esolutions.hmi.widgets.audi.base.eal.TextureDescription;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Map;
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
        logChannel3DEngineCache.log(1000000, "LRUTextureCache constructing cache %1, (%2, %3)", (long)n, (long)n2, (long)n3);
        this.ealManager = eALManager;
        this.cacheId = n;
        this.levelsAreInByte = bl;
        this.freeLevel = n2;
        this.errorLevel = n3;
        this.deferredCacheDeleteActive = bl2;
    }

    public IWrappedTexture getTexture(TextureDescription textureDescription, Object object) {
        Object object2 = LRUTextureCache.getKey(textureDescription);
        CacheEntry cacheEntry = (CacheEntry)this.texDescrCounter.get(object2);
        if (cacheEntry == null) {
            logChannel3DEngineCache.log(10000000, "LRUTextureCache#getTexture cache miss for %1 in cache %2", (Object)textureDescription, (long)this.cacheId);
            this.freeBufferIfNeeded();
            return this.createCacheEntry(textureDescription, object);
        }
        this.list.remove(cacheEntry);
        this.list.addFirst(cacheEntry);
        return cacheEntry.incrementReferences(object);
    }

    public IWrappedTexture getCachedTexture(TextureDescription textureDescription, Object object) {
        Object object2 = LRUTextureCache.getKey(textureDescription);
        CacheEntry cacheEntry = (CacheEntry)this.texDescrCounter.get(object2);
        if (cacheEntry == null) {
            return null;
        }
        return cacheEntry.incrementReferences(object);
    }

    public boolean isTextureCached(TextureDescription textureDescription) {
        Object object = LRUTextureCache.getKey(textureDescription);
        CacheEntry cacheEntry = (CacheEntry)this.texDescrCounter.get(object);
        return cacheEntry != null;
    }

    private static Object getKey(TextureDescription textureDescription) {
        return textureDescription.getCacheKey();
    }

    private void freeBufferIfNeeded() {
        if (this.rawImgRamUsage < this.freeLevel) {
            logChannel3DEngineCache.log(100000000, "LRUTextureCache#freeBufferIfNeeded current ramUsage: %1", (long)this.rawImgRamUsage);
            return;
        }
        logChannel3DEngineCache.log(10000000, "LRUTextureCache#freeBufferIfNeeded ramUsage: %1", (long)this.rawImgRamUsage);
        while (this.rawImgRamUsage >= this.freeLevel) {
            CacheEntry cacheEntry = this.getNextFreeEntry();
            if (cacheEntry == null) {
                int n = this.rawImgRamUsage >= this.errorLevel ? 10000 : 100000;
                logChannel3DEngineCache.log(n, "LRUTextureCache#freeBufferIfNeeded items in cache %2 need %1 Bytes RAM", (long)this.rawImgRamUsage, (long)this.cacheId);
                return;
            }
            this.freeCacheEntry(cacheEntry);
        }
    }

    private void freeCacheEntry(CacheEntry cacheEntry) {
        IWrappedTexture iWrappedTexture = cacheEntry.getTexture();
        this.ealManager.destroy(iWrappedTexture);
        Object object = iWrappedTexture.getDescription().getCacheKey();
        this.texDescrCounter.remove(object);
        int n = (Integer)this.texDescrRawImgSize.get(object);
        this.rawImgRamUsage -= n;
        this.texDescrRawImgSize.remove(object);
        this.descriptionMap.remove(object);
        this.list.remove(cacheEntry);
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
            logChannel3DEngineCacheSize.log(1000000, this.buffer.toString());
        }
    }

    public int clearBufferIfPossible() {
        int n = this.rawImgRamUsage;
        int n2 = 0;
        CacheEntry cacheEntry = this.getNextFreeEntry();
        while (cacheEntry != null) {
            IWrappedTexture iWrappedTexture = cacheEntry.getTexture();
            this.ealManager.destroy(iWrappedTexture);
            Object object = iWrappedTexture.getDescription().getCacheKey();
            this.texDescrCounter.remove(object);
            this.rawImgRamUsage -= ((Integer)this.texDescrRawImgSize.get(object)).intValue();
            this.texDescrRawImgSize.remove(object);
            this.descriptionMap.remove(object);
            this.list.remove(cacheEntry);
            cacheEntry = this.getNextFreeEntry();
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
            logChannel3DEngineCacheSize.log(1000000, this.buffer.toString());
        }
        if (this.deferredCacheDeleteActive) {
            this.markAsDeleted();
        }
        int n4 = 10000000;
        if (this.rawImgRamUsage >= this.freeLevel) {
            n4 = this.rawImgRamUsage >= this.errorLevel ? 10000 : 100000;
        }
        logChannel3DEngineCache.log(n4, "LRUTextureCache#clearBufferIfPossible initialRamUsed: %1, clearedRAMSpace: %2, remainingRAMUsed: %3", (long)n, (long)(n - this.rawImgRamUsage), (long)this.rawImgRamUsage);
        return n3;
    }

    private CacheEntry getNextFreeEntry() {
        ListIterator listIterator = this.list.listIterator(this.list.size());
        while (listIterator.hasPrevious()) {
            CacheEntry cacheEntry = (CacheEntry)listIterator.previous();
            if (cacheEntry.getRefcount() > 0) continue;
            return cacheEntry;
        }
        return null;
    }

    public int getCountOfFreeRefrences() {
        ListIterator listIterator = this.list.listIterator(this.list.size());
        int n = 0;
        while (listIterator.hasPrevious()) {
            CacheEntry cacheEntry = (CacheEntry)listIterator.previous();
            if (cacheEntry.getRefcount() > 0) continue;
            ++n;
        }
        return n;
    }

    private IWrappedTexture createCacheEntry(TextureDescription textureDescription, Object object) {
        IWrappedTexture iWrappedTexture = textureDescription.createTexture();
        if (iWrappedTexture == null) {
            return null;
        }
        CacheEntry cacheEntry = new CacheEntry(iWrappedTexture);
        Object object2 = textureDescription.getCacheKey();
        this.texDescrCounter.put(object2, cacheEntry);
        int n = this.levelsAreInByte ? iWrappedTexture.getRawImageSize() : 1;
        this.texDescrRawImgSize.put(object2, Util.createInteger(n));
        this.rawImgRamUsage += n;
        this.descriptionMap.put(object2, textureDescription);
        this.list.addFirst(cacheEntry);
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
            logChannel3DEngineCacheSize.log(1000000, this.buffer.toString());
        }
        return cacheEntry.incrementReferences(object);
    }

    public boolean release(IWrappedTexture iWrappedTexture, Object object) {
        Object object2 = LRUTextureCache.getKey(iWrappedTexture.getDescription());
        CacheEntry cacheEntry = (CacheEntry)this.texDescrCounter.get(object2);
        if (cacheEntry == null) {
            logChannel3DEngineCache.log(10000, "LRUTextureCache#release could not find cacheEntry for %1", (Object)iWrappedTexture);
            return false;
        }
        this.list.remove(cacheEntry);
        this.list.addFirst(cacheEntry);
        boolean bl = cacheEntry.decrementReferences(object);
        if (cacheEntry.isDeferredCacheDelete()) {
            this.freeCacheEntry(cacheEntry);
        }
        this.freeBufferIfNeeded();
        return bl;
    }

    public void destroyAll() {
        Set set = this.texDescrCounter.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry)iterator.next();
            CacheEntry cacheEntry = (CacheEntry)entry.getValue();
            if (cacheEntry == null) continue;
            this.ealManager.destroy(cacheEntry.getTexture());
        }
        this.texDescrCounter.clear();
        this.texDescrRawImgSize.clear();
        logChannel3DEngineCacheSize.log(1000000, "LRUTextureCache#destroyAll cleared %1 entries, cacheId=%2, size=%3", (long)this.list.size(), (long)this.getCacheId(), (long)this.rawImgRamUsage);
        this.list.clear();
        this.descriptionMap.clear();
        this.rawImgRamUsage = 0;
    }

    public int getRefCount(TextureDescription textureDescription) {
        Object object = LRUTextureCache.getKey(textureDescription);
        CacheEntry cacheEntry = (CacheEntry)this.texDescrCounter.get(object);
        if (cacheEntry == null) {
            logChannel3DEngineCache.log(10000000, "LRUTextureCache#getRefCount could not find cacheEntry for %1", (Object)textureDescription);
            return -1;
        }
        return cacheEntry.referencedObjects.size();
    }

    public int getCacheSize() {
        return this.texDescrCounter.size();
    }

    public int getCachedBytes() {
        return this.rawImgRamUsage;
    }

    public void dump() {
        this.dump(logChannel3DEngineCache);
    }

    public void dump(LogChannel logChannel) {
        Object object;
        logChannel.log(1000000, "LRUTextureCache#dump Cache %1, size=%2", (long)this.cacheId, (long)this.rawImgRamUsage);
        logChannel.log(1000000, "LRUTextureCache#dump warnLevel=%1, errorLevel=%2", (long)this.freeLevel, (long)this.errorLevel);
        for (int i2 = 0; i2 < this.list.size(); ++i2) {
            object = (CacheEntry)this.list.get(i2);
            logChannel.log(1000000, "LRUTextureCache#dump CacheEntry: %2, CacheKey: %1, references=%3", ((CacheEntry)object).getTexture().getDescription().getCacheKey(), (Object)((CacheEntry)object).getTexture(), (long)((CacheEntry)object).getRefcount());
        }
        Set set = this.descriptionMap.entrySet();
        logChannel.log(1000000, "LRUTextureCache#dump Size of description-map: %1", (long)set.size());
        object = set.iterator();
        while (object.hasNext()) {
            Map.Entry entry = (Map.Entry)object.next();
            logChannel.log(1000000, "LRUTextureCache#dump Description-Entry: %1", entry.getKey());
        }
    }

    public int getCacheId() {
        return this.cacheId;
    }

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
            CacheEntry cacheEntry = (CacheEntry)listIterator.previous();
            cacheEntry.deleted = true;
        }
        logChannel3DEngineCache.log(1000000, "LRUTextureCache#markAsDeleted Cache %1, %2 entries marked for deferred cache delete.", (long)this.cacheId, (long)this.list.size());
    }

    private static class CacheEntry {
        private final IWrappedTexture texture;
        private LinkedList referencedObjects = new LinkedList();
        private boolean deleted;

        private CacheEntry(IWrappedTexture iWrappedTexture) {
            this.texture = iWrappedTexture;
        }

        private int getRefcount() {
            return this.referencedObjects.size();
        }

        private boolean decrementReferences(Object object) {
            if (this.referencedObjects.size() <= 0) {
                IWidgetLogChannel.logChannel3DEngineCache.log(10000, "LRUTextureCache#CacheEntry#decrementReferences no references, reference=%1", object);
                IWidgetLogChannel.logChannel3DEngineCache.log(10000, "LRUTextureCache#CacheEntry#decrementReferences no references, texture=%1", (Object)this.texture);
                return false;
            }
            if (!this.isPermanent()) {
                int n = this.referencedObjects.size();
                Iterator iterator = this.referencedObjects.iterator();
                while (iterator.hasNext()) {
                    Object object2 = iterator.next();
                    if (!object2.equals(object)) continue;
                    iterator.remove();
                    IWidgetLogChannel.logChannel3DEngineCache.log(10000000, "LRUTextureCache#CacheEntry#decrementReferences decrementing reference counter of %1 to %2", (Object)this.texture, (long)this.referencedObjects.size());
                    break;
                }
                if (n == this.referencedObjects.size()) {
                    IWidgetLogChannel.logChannel3DEngineCache.log(10000, "LRUTextureCache#CacheEntry#decrementReferences decrementing failed. No existing Reference for %1", object);
                    IWidgetLogChannel.logChannel3DEngineCache.log(10000, "LRUTextureCache#CacheEntry#decrementReferences remaining reference counts: %1", (long)this.referencedObjects.size());
                    return false;
                }
            }
            return true;
        }

        private boolean isDeferredCacheDelete() {
            return this.deleted && this.referencedObjects.size() <= 0;
        }

        private boolean isPermanent() {
            return !this.referencedObjects.isEmpty() && this.equals(this.referencedObjects.getFirst());
        }

        private IWrappedTexture incrementReferences(Object object) {
            if (this.referencedObjects.size() > 50) {
                IWidgetLogChannel.logChannel3DEngineCache.log(10000, "LRUTextureCache#CacheEntry#incrementReferences buffer full. %1 is marked as stored permanently in RAM. Object cause: %2", (Object)this.texture, object);
                this.referencedObjects.clear();
                this.referencedObjects.add(this);
            } else if (!this.isPermanent()) {
                this.referencedObjects.add(object);
                IWidgetLogChannel.logChannel3DEngineCache.log(10000000, "LRUTextureCache#CacheEntry#incrementReferences incrementing reference counter of %1 to %2", (Object)this.texture, (long)this.referencedObjects.size());
            }
            return this.texture;
        }

        public IWrappedTexture getTexture() {
            return this.texture;
        }
    }
}

