/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base.eal;

import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedTexture;
import de.esolutions.hmi.widgets.audi.base.eal.LRUTextureCache$1;
import java.util.Iterator;
import java.util.LinkedList;

class LRUTextureCache$CacheEntry {
    private final IWrappedTexture texture;
    private LinkedList referencedObjects = new LinkedList();
    private boolean deleted;

    private LRUTextureCache$CacheEntry(IWrappedTexture iWrappedTexture) {
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
                IWidgetLogChannel.logChannel3DEngineCache.log(-2137614336, "LRUTextureCache#CacheEntry#decrementReferences decrementing reference counter of %1 to %2", (Object)this.texture, (long)this.referencedObjects.size());
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
            IWidgetLogChannel.logChannel3DEngineCache.log(-2137614336, "LRUTextureCache#CacheEntry#incrementReferences incrementing reference counter of %1 to %2", (Object)this.texture, (long)this.referencedObjects.size());
        }
        return this.texture;
    }

    public IWrappedTexture getTexture() {
        return this.texture;
    }

    static /* synthetic */ IWrappedTexture access$000(LRUTextureCache$CacheEntry lRUTextureCache$CacheEntry, Object object) {
        return lRUTextureCache$CacheEntry.incrementReferences(object);
    }

    static /* synthetic */ int access$100(LRUTextureCache$CacheEntry lRUTextureCache$CacheEntry) {
        return lRUTextureCache$CacheEntry.getRefcount();
    }

    /* synthetic */ LRUTextureCache$CacheEntry(IWrappedTexture iWrappedTexture, LRUTextureCache$1 lRUTextureCache$1) {
        this(iWrappedTexture);
    }

    static /* synthetic */ boolean access$300(LRUTextureCache$CacheEntry lRUTextureCache$CacheEntry, Object object) {
        return lRUTextureCache$CacheEntry.decrementReferences(object);
    }

    static /* synthetic */ boolean access$400(LRUTextureCache$CacheEntry lRUTextureCache$CacheEntry) {
        return lRUTextureCache$CacheEntry.isDeferredCacheDelete();
    }

    static /* synthetic */ LinkedList access$500(LRUTextureCache$CacheEntry lRUTextureCache$CacheEntry) {
        return lRUTextureCache$CacheEntry.referencedObjects;
    }

    static /* synthetic */ boolean access$602(LRUTextureCache$CacheEntry lRUTextureCache$CacheEntry, boolean bl) {
        lRUTextureCache$CacheEntry.deleted = bl;
        return lRUTextureCache$CacheEntry.deleted;
    }
}

