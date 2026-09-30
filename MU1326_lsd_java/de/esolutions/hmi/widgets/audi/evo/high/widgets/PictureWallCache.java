/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.audi.atip.hmi.event.ATIPEventListener;
import de.audi.atip.hmi.event.AsyncBitmapEvent;
import de.audi.atip.hmi.event.EventDispatcher;
import de.audi.atip.hmi.event.ModelUpdateEvent;
import de.audi.atip.hmi.event.TimerSyncer;
import de.audi.atip.hmi.model.HMIResourceLocator;
import de.audi.atip.hmi.model.list.BaseListModel;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.model.list.GuiListRow;
import de.audi.atip.hmi.model.list.TiledListModelGUI;
import de.audi.atip.hmi.model.update.ModelUpdateData;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.base.InitializationContext;
import de.esolutions.hmi.widgets.audi.base.eal.HMITerminalEAL;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedTexture;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.base.widgets.IRenderer;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.IPictureWallCallbackReceiver;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.PictureWallIconRenderer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PictureWallCache
extends AbstractWidgetController
implements TimerListener {
    private static final int PIC_BOX_COLUMN_BITMAP_RESOURCE = 2;
    private static final int MAX_RECURSION_DEPTH = 20;
    private static final int IMAGE_LOAD_TRIGGER = 100;
    public static final int NUMBER_OF_BLOCKS = 21;
    public static final int BLOCK_SIZE = 12;
    private static int request = 0;
    private HashMap cache;
    private HashMap cache1;
    private HashMap textureCache;
    private int currentBlockNumber = 0;
    private boolean allLoaded = false;
    private AsyncTextureLoader asyncTextureLoader;
    private EventDispatcher dispatcher;
    private IPictureWallCallbackReceiver dbgCache;

    public void cancelTimer(Timer timer) {
    }

    public void connected(InitializationContext initializationContext) {
        super.connected(initializationContext);
        this.dispatcher = AbstractWidget.hmiService.getEventDispatcher();
        this.setup();
        this.asyncTextureLoader.start();
        this.initializeTextureCache();
    }

    public boolean containsTexture(String string) {
        return this.textureCache.containsKey(string);
    }

    private void destroyTexture(CachedTexture cachedTexture) {
        if (cachedTexture.data != null) {
            pictureWallLogCh.log(10000000, "PictureWallCache#destroyTexture path = %1", (Object)cachedTexture.path);
            ((HMITerminalEAL)((Object)this.terminal)).getEALManager().destroy(cachedTexture.data);
        }
    }

    public void disconnecting() {
        super.disconnecting();
        this.currentBlockNumber = 0;
        this.asyncTextureLoader.cancelAll();
        this.recycleTextureCache();
        this.cache.clear();
        this.cache1.clear();
        this.asyncTextureLoader.cancel();
    }

    public void fireTimer(Timer timer) {
        this.fireTimer(timer, 0);
    }

    private void fireTimer(Timer timer, int n) {
        if (n > 20) {
            return;
        }
        String string = this.asyncTextureLoader.popRequest();
        if (string != null) {
            this.allLoaded = false;
            pictureWallLogCh.log(10000000, "PictureWallCache#fireTimer %1, recursionDepth = %2", (Object)string, (long)n);
            CachedTexture cachedTexture = this.getTexture(string);
            if (cachedTexture != null) {
                if (cachedTexture.data == null) {
                    HMIResourceLocator hMIResourceLocator = new HMIResourceLocator(string);
                    AsyncBitmapEvent asyncBitmapEvent = new AsyncBitmapEvent((ATIPEventListener)AbstractWidget.hmiService.getRootWindow(0), hMIResourceLocator);
                    this.dispatcher.postEvent(asyncBitmapEvent);
                    pictureWallLogCh.log(10000000, "PictureWallCache#fireTimer size of cache = %1, size of pool = %2, model rows = %3", (long)this.textureCache.size(), (long)this.asyncTextureLoader.pool.size(), (long)this.getNumberOfModelRows());
                    pictureWallLogCh.log(10000000, "PictureWallCache#fireTimer number of queues = %1, number of single requests = %2", (long)this.asyncTextureLoader.queues.size(), (long)this.asyncTextureLoader.singleRequestQueue.size());
                } else {
                    pictureWallLogCh.log(10000000, "PictureWallCache#fireTimer %1 is already loaded.", (Object)string);
                    this.fireTimer(timer, n + 1);
                }
            } else {
                pictureWallLogCh.log(10000000, "PictureWallCache#fireTimer Texture %1 is not in cache anymore.", (Object)string);
                this.fireTimer(timer, n + 1);
            }
        } else {
            if (!this.allLoaded) {
                pictureWallLogCh.log(10000000, "PictureWallCache#fireTimer All requested textures have been loaded.");
            }
            this.allLoaded = true;
        }
    }

    public HMIResourceLocator getDataHMIResourceLocator(int n) {
        if (0 > n || n >= this.getNumberOfModelRows()) {
            return null;
        }
        HMIResourceLocator hMIResourceLocator = null;
        if (!(this.model instanceof TiledListModelGUI)) {
            return null;
        }
        TiledListModelGUI tiledListModelGUI = (TiledListModelGUI)this.model;
        GuiListRow guiListRow = tiledListModelGUI.getGuiRow(n);
        if (guiListRow != null) {
            Object object = guiListRow.getCell(2);
            hMIResourceLocator = (HMIResourceLocator)object;
        } else {
            pictureWallLogCh.log(10000000, "PictureWallCache#getDataHMIResourceLocator Model row %1 is not available.", (long)n);
        }
        return hMIResourceLocator;
    }

    public int getNumberOfModelRows() {
        if (this.model instanceof TiledListModelGUI) {
            int n = ((TiledListModelGUI)this.model).getLength();
            this.sendDbgCacheControllerCallback(0, new Object[]{new Integer(n)});
            return n;
        }
        pictureWallLogCh.log(10000000, "PictureWallCache#getNumberOfModelRows A model is not set.");
        return 0;
    }

    public IRenderer getRenderer() {
        return null;
    }

    public CachedTexture getTexture(String string) {
        return (CachedTexture)this.textureCache.get(string);
    }

    private void initializeTextureCache() {
        pictureWallLogCh.log(10000000, "PictureWallCache#initializeTextureCache");
        if (this.textureCache == null) {
            this.textureCache = new HashMap(252);
            this.sendDbgCacheControllerCallback(4, new Object[]{this.textureCache});
        }
        if (this.cache == null) {
            this.cache = new HashMap(21);
            this.cache1 = new HashMap(21);
            this.sendDbgCacheControllerCallback(2, new Object[]{this.cache});
        }
        int n = 10;
        for (int i2 = 0; i2 <= n; ++i2) {
            CacheBlock cacheBlock = new CacheBlock(i2);
            this.requestBlock(cacheBlock);
        }
    }

    public void processModelUpdateEvent(ModelUpdateEvent modelUpdateEvent) {
        pictureWallLogCh.log(10000000, "PictureWallCache#processModelUpdateEvent");
        if (modelUpdateEvent.getUpdateType() == 8) {
            ModelUpdateData modelUpdateData = modelUpdateEvent.getClientData3();
            Object object = modelUpdateData.get(ModelUpdateData.Key.REQUESTID);
            Object object2 = modelUpdateData.get(ModelUpdateData.Key.INDEX);
            if (object != null && object2 != null) {
                int n = (Integer)object;
                int n2 = (Integer)object2;
                if (n != -1) {
                    pictureWallLogCh.log(10000000, "PictureWallCache#processModelUpdateEvent Received callback for request id = %1", (long)n);
                    this.requestedBlockLoaded(n, n2);
                }
            }
        }
    }

    private void recycleTextureCache() {
        Set set = this.textureCache.entrySet();
        Iterator iterator = set.iterator();
        pictureWallLogCh.log(10000000, "PictureWallCache#recycleTextureCache Recycle %1 elements in cache", (long)set.size());
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry)iterator.next();
            CachedTexture cachedTexture = (CachedTexture)entry.getValue();
            this.destroyTexture(cachedTexture);
        }
        this.textureCache.clear();
        this.sendDbgCacheControllerCallback(5, null);
    }

    private void requestBlock(CacheBlock cacheBlock) {
        int n = cacheBlock.blockNumber;
        CacheBlock cacheBlock2 = (CacheBlock)this.cache.get(cacheBlock.blockNumber);
        if (cacheBlock2 != null) {
            if (cacheBlock2.requestID.equals(CacheBlock.NO_VALUE)) {
                pictureWallLogCh.log(10000000, "PictureWallCache#requestBlock Block with number = %1 already in cache, but not requested.", (long)n);
                cacheBlock = cacheBlock2;
            } else {
                pictureWallLogCh.log(10000000, "PictureWallCache#requestBlock Block with number = %1 already in cache.", (long)n);
            }
        }
        int n2 = n * 12;
        int n3 = this.getNumberOfModelRows();
        if (n3 == 0) {
            pictureWallLogCh.log(10000, "PictureWallCache#requestBlock Requsting block %1 failed! The model is empty.", (long)n);
            return;
        }
        if (0 <= n2 && n2 < n3) {
            TiledListModelGUI tiledListModelGUI = (TiledListModelGUI)this.model;
            cacheBlock.requestID = new Integer(request);
            this.cache.put(cacheBlock.blockNumber, cacheBlock);
            this.cache1.put(cacheBlock.requestID, cacheBlock);
            ++request;
            if (framework.isTarget()) {
                tiledListModelGUI.requestItems(cacheBlock.requestID, n2, 12, this.terminal.getTerminalID());
            } else {
                BaseListModel baseListModel = (BaseListModel)this.model;
                EvoListRow[] evoListRowArray = new EvoListRow[12];
                for (int i2 = 0; i2 < evoListRowArray.length; ++i2) {
                    evoListRowArray[i2] = baseListModel.getRow(n2 + i2);
                }
                baseListModel.setRows(cacheBlock.requestID, n2, evoListRowArray);
            }
            this.sendDbgCacheControllerCallback(3, null);
            pictureWallLogCh.log(10000000, "PictureWallCache#requestBlock number = %1, with requestID = %2", (long)n, (long)cacheBlock.requestID.intValue());
        } else {
            pictureWallLogCh.log(10000000, "PictureWallCache#requestBlock Block with first row = %1 is out of range [0, %2).", (long)n2, (long)n3);
        }
    }

    public void requestTexture(String string, int n, PictureWallIconRenderer pictureWallIconRenderer) {
        this.asyncTextureLoader.pushSingleRequest(string, n, pictureWallIconRenderer);
    }

    private void requestedBlockLoaded(int n, int n2) {
        pictureWallLogCh.log(10000000, "PictureWallCache#requestedBlockLoaded requestID = %1, firstRowToLoad = %2", (long)n, (long)n2);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        CacheBlock cacheBlock = (CacheBlock)this.cache1.get(new Integer(n));
        if (cacheBlock == null) {
            pictureWallLogCh.log(10000, "PictureWallCache#requestedBlockLoaded Block with requestID = %1 is not in Cache!", (long)n);
            return;
        }
        cacheBlock.loaded = true;
        for (int i2 = 0; i2 < 12; ++i2) {
            int n3 = n2 + i2;
            HMIResourceLocator hMIResourceLocator = this.getDataHMIResourceLocator(n3);
            if (hMIResourceLocator == null || !hMIResourceLocator.containsResourceURI()) continue;
            String string = hMIResourceLocator.getResourceURI();
            cacheBlock.data.add(string);
            arrayList.add(string);
            arrayList2.add(new Integer(n3));
        }
        this.asyncTextureLoader.pushQueue(arrayList, arrayList2, n, cacheBlock.blockNumber, true);
        this.sendDbgCacheControllerCallback(3, null);
    }

    public CachedTexture retrieveCachedTexture(String string) {
        return (CachedTexture)this.textureCache.get(string);
    }

    public void sendDbgCacheControllerCallback(int n, Object[] objectArray) {
        if (this.dbgCache != null) {
            this.dbgCache.receivePictureViewerCallback(n, objectArray);
        }
    }

    public void setDebugVisualizer(IPictureWallCallbackReceiver iPictureWallCallbackReceiver) {
        this.dbgCache = iPictureWallCallbackReceiver;
    }

    private void setup() {
        this.asyncTextureLoader = new AsyncTextureLoader("AsyncTextureLoader", 100L, false, new TimerSyncer(this));
        this.sendDbgCacheControllerCallback(6, new Object[]{this.asyncTextureLoader});
    }

    public void sortQueues() {
        this.asyncTextureLoader.sortQueues();
    }

    private void unrequestBlock(CacheBlock cacheBlock) {
        Object object;
        pictureWallLogCh.log(10000000, "PictureWallCache#unrequestBlock Unrequesting %1 elements.", (long)cacheBlock.data.size());
        while (!cacheBlock.data.isEmpty()) {
            String string = (String)cacheBlock.data.remove(0);
            if (string == null) continue;
            object = (CachedTexture)this.textureCache.remove(string);
            if (object != null) {
                this.destroyTexture((CachedTexture)object);
                this.asyncTextureLoader.pool.add(object);
            }
            pictureWallLogCh.log(10000000, "PictureWallCache#unrequestBlock Removed %1 from cache.", (Object)string);
        }
        int n = cacheBlock.blockNumber;
        object = (TiledListModelGUI)this.model;
        object.unrequestItems(n * 12, 12, this.terminal.getTerminalID());
        pictureWallLogCh.log(10000000, "PictureWallCache#unrequestBlock Block number = %1, number of textures in cache = %2", (long)n, (long)this.textureCache.size());
        this.sendDbgCacheControllerCallback(5, null);
    }

    public void updateTextureCache(int n) {
        int n2 = n;
        int n3 = n2 * 4 / 12;
        if (n3 != this.currentBlockNumber) {
            if (Math.abs(n3 - this.currentBlockNumber) > 1) {
                pictureWallLogCh.log(10000, "PictureWallCache#updateTextureCache A whole block of the texture cache has been passed in one step. It's currently not supported.");
            } else {
                int n4;
                int n5;
                int n6 = 10;
                if (n3 > this.currentBlockNumber) {
                    n5 = this.currentBlockNumber - n6;
                    n4 = n3 + n6;
                } else {
                    n5 = this.currentBlockNumber + n6;
                    n4 = n3 - n6;
                }
                CacheBlock cacheBlock = (CacheBlock)this.cache.remove(new Integer(n5));
                if (cacheBlock == null) {
                    cacheBlock = new CacheBlock(n4);
                } else {
                    if (!cacheBlock.requestID.equals(CacheBlock.NO_VALUE)) {
                        this.cache1.remove(cacheBlock.requestID);
                    } else {
                        pictureWallLogCh.log(1000000, "PictureWallCache#updateTextureCache Block number %1 removed with no request ID.", (long)n5);
                    }
                    this.asyncTextureLoader.cancelQueue(cacheBlock.requestID);
                    this.unrequestBlock(cacheBlock);
                    cacheBlock.blockNumber = new Integer(n4);
                    cacheBlock.requestID = null;
                }
                this.requestBlock(cacheBlock);
                pictureWallLogCh.log(10000000, "PictureWallCache#updateTextureCache Leaving block %1, entering block %2.", (long)this.currentBlockNumber, (long)n3);
                this.currentBlockNumber = n3;
                this.sendDbgCacheControllerCallback(3, null);
            }
        }
    }

    public static class CacheBlock {
        static final Integer NO_VALUE = new Integer(-1);
        Integer blockNumber;
        List data;
        Integer requestID = NO_VALUE;
        boolean loaded = false;

        public CacheBlock(int n) {
            this.data = new ArrayList(12);
            this.blockNumber = new Integer(n);
        }

        public Integer getBlockNumber() {
            return this.blockNumber;
        }

        public boolean isLoaded() {
            return this.loaded;
        }
    }

    public static class RequestQueue
    implements Comparable {
        List data;
        int id;
        int blockNumber;
        int distanceToCurrentBlock;

        public int compareTo(Object object) {
            if (object instanceof RequestQueue) {
                return this.distanceToCurrentBlock - ((RequestQueue)object).distanceToCurrentBlock;
            }
            throw new UnsupportedOperationException();
        }

        public List getData() {
            return this.data;
        }
    }

    public static class CachedTexture {
        public static final int STATE_LOADED = 0;
        public static final int STATE_ENQUEUED = 1;
        public static final int STATE_ENQUEUED_AND_LOADED = 2;
        public static final int STATE_IN_CACHE = 3;
        String path;
        IWrappedTexture data;
        boolean loadingError = false;
        PictureWallIconRenderer listener;
        int modelRow;
        public int state;

        public IWrappedTexture getData() {
            return this.data;
        }

        public int getModelRow() {
            return this.modelRow;
        }
    }

    public final class AsyncTextureLoader
    extends Timer {
        private int currentQueueID;
        private int currentQueueBlockNumber;
        List pool;
        List queues;
        List currentQueue;
        List singleRequestQueue;

        public AsyncTextureLoader(String string, long l, boolean bl, TimerListener timerListener) {
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
            CachedTexture cachedTexture = this.putTextureIntoCache(string, n, pictureWallIconRenderer);
            if (cachedTexture.data != null) {
                IWidgetLogChannel.pictureWallLogCh.log(10000000, "AsyncTextureLoader#pushSingleRequest Texture %1 is already in cache and loaded.", (Object)string);
                return;
            }
            IWidgetLogChannel.pictureWallLogCh.log(10000000, "AsyncTextureLoader#pushSingleRequest for displayData = %1", (Object)string);
            this.singleRequestQueue.add(0, string);
            CacheBlock cacheBlock = (CacheBlock)PictureWallCache.this.cache.get(new Integer(n2));
            if (cacheBlock == null) {
                IWidgetLogChannel.pictureWallLogCh.log(1000000, "AsyncTextureLoader#pushSingleRequest Block with number = %1 is not in cache.", (long)n2);
                cacheBlock = new CacheBlock(n2);
                PictureWallCache.this.cache.put(cacheBlock.blockNumber, cacheBlock);
            }
            if (!cacheBlock.data.contains(string)) {
                cacheBlock.data.add(string);
            } else {
                IWidgetLogChannel.pictureWallLogCh.log(10000000, "AsyncTextureLoader#pushSingleRequest displayData = %1 is already contained in the block number %2", (Object)string, (long)n2);
            }
            this.queueChanged();
        }

        private void dequeueHeadOfList() {
            if (!this.currentQueue.isEmpty()) {
                this.pushCurrentQueue();
            }
            RequestQueue requestQueue = (RequestQueue)this.queues.remove(0);
            this.currentQueue = requestQueue.data;
            this.currentQueueID = requestQueue.id;
            this.currentQueueBlockNumber = requestQueue.blockNumber;
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
                IWidgetLogChannel.pictureWallLogCh.log(10000000, "AsyncTextureLoader#cancelQueue with id = %1", (long)n);
                return;
            }
            int n2 = this.queues.size();
            for (int i2 = 0; i2 < n2; ++i2) {
                RequestQueue requestQueue = (RequestQueue)this.queues.get(i2);
                if (requestQueue.id != n) continue;
                this.queues.remove(i2);
                IWidgetLogChannel.pictureWallLogCh.log(10000000, "AsyncTextureLoader#cancelQueue with id = %1", (long)n);
                break;
            }
            this.queueChanged();
        }

        private void pushCurrentQueue() {
            RequestQueue requestQueue = new RequestQueue();
            requestQueue.data = this.currentQueue;
            requestQueue.id = this.currentQueueID;
            requestQueue.blockNumber = this.currentQueueBlockNumber;
            this.queues.add(requestQueue);
        }

        public synchronized void pushQueue(List list, List list2, int n, int n2, boolean bl) {
            block7: {
                Object object;
                int n3;
                int n4 = this.queues.size();
                for (n3 = 0; n3 < n4; ++n3) {
                    object = (RequestQueue)this.queues.get(n3);
                    if (((RequestQueue)object).id != n) {
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
                object = new RequestQueue();
                ((RequestQueue)object).data = list;
                ((RequestQueue)object).id = n;
                ((RequestQueue)object).blockNumber = n2;
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

        private CachedTexture putTextureIntoCache(String string, int n, PictureWallIconRenderer pictureWallIconRenderer) {
            CachedTexture cachedTexture = (CachedTexture)PictureWallCache.this.textureCache.get(string);
            if (cachedTexture == null) {
                cachedTexture = this.pool.isEmpty() ? new CachedTexture() : (CachedTexture)this.pool.remove(0);
                cachedTexture.path = string;
                cachedTexture.listener = pictureWallIconRenderer;
                cachedTexture.data = null;
                cachedTexture.modelRow = n;
                PictureWallCache.this.textureCache.put(string, cachedTexture);
                PictureWallCache.this.sendDbgCacheControllerCallback(5, null);
            } else if (pictureWallIconRenderer != null) {
                cachedTexture.listener = pictureWallIconRenderer;
            }
            return cachedTexture;
        }

        private void queueChanged() {
            PictureWallCache.this.sendDbgCacheControllerCallback(7, null);
        }

        public void sortQueues() {
            this.pushCurrentQueue();
            this.currentQueue = new ArrayList();
            int n = this.queues.size();
            IWidgetLogChannel.pictureWallLogCh.log(10000000, "AsyncTextureLoader#sortQueues Number of queues = %1", (long)n);
            System.out.println(n);
            for (int i2 = 0; i2 < n; ++i2) {
                RequestQueue requestQueue = (RequestQueue)this.queues.get(i2);
                requestQueue.distanceToCurrentBlock = Math.abs(PictureWallCache.this.currentBlockNumber - requestQueue.blockNumber);
            }
            Collections.sort(this.queues);
            this.dequeueHeadOfList();
            this.singleRequestQueue.clear();
        }
    }
}

