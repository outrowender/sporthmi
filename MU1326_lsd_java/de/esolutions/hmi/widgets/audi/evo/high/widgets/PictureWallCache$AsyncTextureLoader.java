/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.PictureWallCache;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.PictureWallCache$CacheBlock;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.PictureWallCache$CachedTexture;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.PictureWallCache$RequestQueue;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.PictureWallIconRenderer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class PictureWallCache$AsyncTextureLoader
extends Timer {
    private int currentQueueID;
    private int currentQueueBlockNumber;
    List pool;
    List queues;
    List currentQueue;
    List singleRequestQueue;
    private final /* synthetic */ PictureWallCache this$0;

    public PictureWallCache$AsyncTextureLoader(PictureWallCache pictureWallCache, String string, long l, boolean bl, TimerListener timerListener) {
        this.this$0 = pictureWallCache;
        super(string, l, bl, timerListener);
        this.currentQueueID = -1;
        this.currentQueueBlockNumber = -1;
        this.pool = new ArrayList(252);
        this.queues = new ArrayList();
        this.currentQueue = new ArrayList();
        this.singleRequestQueue = new ArrayList();
    }

    public List getCurrentQueue() {
        return this.currentQueue;
    }

    public List getQueues() {
        return this.queues;
    }

    public List getSingleRequestQueue() {
        return this.singleRequestQueue;
    }

    private synchronized String popRequest() {
        this.queueChanged();
        while (this.currentQueue.isEmpty() && this.singleRequestQueue.isEmpty()) {
            if (!this.queues.isEmpty()) {
                this.dequeueHeadOfList();
                continue;
            }
            return null;
        }
        if (!this.singleRequestQueue.isEmpty()) {
            return (String)this.singleRequestQueue.remove(0);
        }
        return (String)this.currentQueue.remove(0);
    }

    public synchronized void pushSingleRequest(String string, int n, PictureWallIconRenderer pictureWallIconRenderer) {
        int n2 = n / 12;
        PictureWallCache$CachedTexture pictureWallCache$CachedTexture = this.putTextureIntoCache(string, n, pictureWallIconRenderer);
        if (pictureWallCache$CachedTexture.data != null) {
            IWidgetLogChannel.pictureWallLogCh.log(-2137614336, "AsyncTextureLoader#pushSingleRequest Texture %1 is already in cache and loaded.", (Object)string);
            return;
        }
        IWidgetLogChannel.pictureWallLogCh.log(-2137614336, "AsyncTextureLoader#pushSingleRequest for displayData = %1", (Object)string);
        this.singleRequestQueue.add(0, string);
        PictureWallCache$CacheBlock pictureWallCache$CacheBlock = (PictureWallCache$CacheBlock)PictureWallCache.access$000(this.this$0).get(new Integer(n2));
        if (pictureWallCache$CacheBlock == null) {
            IWidgetLogChannel.pictureWallLogCh.log(1078071040, "AsyncTextureLoader#pushSingleRequest Block with number = %1 is not in cache.", (long)n2);
            pictureWallCache$CacheBlock = new PictureWallCache$CacheBlock(n2);
            PictureWallCache.access$000(this.this$0).put(pictureWallCache$CacheBlock.blockNumber, pictureWallCache$CacheBlock);
        }
        if (!pictureWallCache$CacheBlock.data.contains(string)) {
            pictureWallCache$CacheBlock.data.add(string);
        } else {
            IWidgetLogChannel.pictureWallLogCh.log(-2137614336, "AsyncTextureLoader#pushSingleRequest displayData = %1 is already contained in the block number %2", (Object)string, (long)n2);
        }
        this.queueChanged();
    }

    private void dequeueHeadOfList() {
        if (!this.currentQueue.isEmpty()) {
            this.pushCurrentQueue();
        }
        PictureWallCache$RequestQueue pictureWallCache$RequestQueue = (PictureWallCache$RequestQueue)this.queues.remove(0);
        this.currentQueue = pictureWallCache$RequestQueue.data;
        this.currentQueueID = pictureWallCache$RequestQueue.id;
        this.currentQueueBlockNumber = pictureWallCache$RequestQueue.blockNumber;
        this.queueChanged();
    }

    public synchronized void cancelAll() {
        this.currentQueue.clear();
        while (!this.queues.isEmpty()) {
            this.queues.remove(0);
        }
        this.queueChanged();
    }

    public synchronized void cancelQueue(int n) {
        if (this.currentQueueID == n) {
            this.currentQueue.clear();
            IWidgetLogChannel.pictureWallLogCh.log(-2137614336, "AsyncTextureLoader#cancelQueue with id = %1", (long)n);
            return;
        }
        int n2 = this.queues.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            PictureWallCache$RequestQueue pictureWallCache$RequestQueue = (PictureWallCache$RequestQueue)this.queues.get(i2);
            if (pictureWallCache$RequestQueue.id != n) continue;
            this.queues.remove(i2);
            IWidgetLogChannel.pictureWallLogCh.log(-2137614336, "AsyncTextureLoader#cancelQueue with id = %1", (long)n);
            break;
        }
        this.queueChanged();
    }

    private void pushCurrentQueue() {
        PictureWallCache$RequestQueue pictureWallCache$RequestQueue = new PictureWallCache$RequestQueue();
        pictureWallCache$RequestQueue.data = this.currentQueue;
        pictureWallCache$RequestQueue.id = this.currentQueueID;
        pictureWallCache$RequestQueue.blockNumber = this.currentQueueBlockNumber;
        this.queues.add(pictureWallCache$RequestQueue);
    }

    public synchronized void pushQueue(List list, List list2, int n, int n2, boolean bl) {
        block7: {
            Object object;
            int n3;
            int n4 = this.queues.size();
            for (n3 = 0; n3 < n4; ++n3) {
                object = (PictureWallCache$RequestQueue)this.queues.get(n3);
                if (((PictureWallCache$RequestQueue)object).id != n) {
                    continue;
                }
                break block7;
            }
            n4 = list.size();
            for (n3 = 0; n3 < n4; ++n3) {
                object = (String)list.get(n3);
                int n5 = (Integer)list2.get(n3);
                this.putTextureIntoCache((String)object, n5, null);
            }
            object = new PictureWallCache$RequestQueue();
            ((PictureWallCache$RequestQueue)object).data = list;
            ((PictureWallCache$RequestQueue)object).id = n;
            ((PictureWallCache$RequestQueue)object).blockNumber = n2;
            if (bl) {
                this.queues.add(0, object);
                if (!this.currentQueue.isEmpty()) {
                    this.dequeueHeadOfList();
                }
            } else {
                this.queues.add(object);
            }
            if (this.currentQueue.isEmpty()) {
                this.dequeueHeadOfList();
            }
        }
        this.queueChanged();
    }

    private PictureWallCache$CachedTexture putTextureIntoCache(String string, int n, PictureWallIconRenderer pictureWallIconRenderer) {
        PictureWallCache$CachedTexture pictureWallCache$CachedTexture = (PictureWallCache$CachedTexture)PictureWallCache.access$100(this.this$0).get(string);
        if (pictureWallCache$CachedTexture == null) {
            pictureWallCache$CachedTexture = this.pool.isEmpty() ? new PictureWallCache$CachedTexture() : (PictureWallCache$CachedTexture)this.pool.remove(0);
            pictureWallCache$CachedTexture.path = string;
            pictureWallCache$CachedTexture.listener = pictureWallIconRenderer;
            pictureWallCache$CachedTexture.data = null;
            pictureWallCache$CachedTexture.modelRow = n;
            PictureWallCache.access$100(this.this$0).put(string, pictureWallCache$CachedTexture);
            this.this$0.sendDbgCacheControllerCallback(5, null);
        } else if (pictureWallIconRenderer != null) {
            pictureWallCache$CachedTexture.listener = pictureWallIconRenderer;
        }
        return pictureWallCache$CachedTexture;
    }

    private void queueChanged() {
        this.this$0.sendDbgCacheControllerCallback(7, null);
    }

    public void sortQueues() {
        this.pushCurrentQueue();
        this.currentQueue = new ArrayList();
        int n = this.queues.size();
        IWidgetLogChannel.pictureWallLogCh.log(-2137614336, "AsyncTextureLoader#sortQueues Number of queues = %1", (long)n);
        System.out.println(n);
        for (int i2 = 0; i2 < n; ++i2) {
            PictureWallCache$RequestQueue pictureWallCache$RequestQueue = (PictureWallCache$RequestQueue)this.queues.get(i2);
            pictureWallCache$RequestQueue.distanceToCurrentBlock = Math.abs(PictureWallCache.access$200(this.this$0) - pictureWallCache$RequestQueue.blockNumber);
        }
        Collections.sort(this.queues);
        this.dequeueHeadOfList();
        this.singleRequestQueue.clear();
    }

    static /* synthetic */ String access$300(PictureWallCache$AsyncTextureLoader pictureWallCache$AsyncTextureLoader) {
        return pictureWallCache$AsyncTextureLoader.popRequest();
    }
}

