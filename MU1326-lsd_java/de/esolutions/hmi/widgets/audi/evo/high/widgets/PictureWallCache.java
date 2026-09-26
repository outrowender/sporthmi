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
import de.audi.atip.hmi.model.update.ModelUpdateData$Key;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.InitializationContext;
import de.esolutions.hmi.widgets.audi.base.eal.HMITerminalEAL;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.base.widgets.IRenderer;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.IPictureWallCallbackReceiver;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.PictureWallCache$AsyncTextureLoader;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.PictureWallCache$CacheBlock;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.PictureWallCache$CachedTexture;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.PictureWallIconRenderer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map$Entry;
import java.util.Set;

public class PictureWallCache
extends AbstractWidgetController
implements TimerListener {
    private static final int PIC_BOX_COLUMN_BITMAP_RESOURCE;
    private static final int MAX_RECURSION_DEPTH;
    private static final int IMAGE_LOAD_TRIGGER;
    public static final int NUMBER_OF_BLOCKS;
    public static final int BLOCK_SIZE;
    private static int request;
    private HashMap cache;
    private HashMap cache1;
    private HashMap textureCache;
    private int currentBlockNumber = 0;
    private boolean allLoaded = false;
    private PictureWallCache$AsyncTextureLoader asyncTextureLoader;
    private EventDispatcher dispatcher;
    private IPictureWallCallbackReceiver dbgCache;

    @Override
    public void cancelTimer(Timer timer) {
    }

    @Override
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

    private void destroyTexture(PictureWallCache$CachedTexture pictureWallCache$CachedTexture) {
        if (pictureWallCache$CachedTexture.data != null) {
            pictureWallLogCh.log(-2137614336, "PictureWallCache#destroyTexture path = %1", (Object)pictureWallCache$CachedTexture.path);
            ((HMITerminalEAL)((Object)this.terminal)).getEALManager().destroy(pictureWallCache$CachedTexture.data);
        }
    }

    @Override
    public void disconnecting() {
        super.disconnecting();
        this.currentBlockNumber = 0;
        this.asyncTextureLoader.cancelAll();
        this.recycleTextureCache();
        this.cache.clear();
        this.cache1.clear();
        this.asyncTextureLoader.cancel();
    }

    @Override
    public void fireTimer(Timer timer) {
        this.fireTimer(timer, 0);
    }

    private void fireTimer(Timer timer, int n) {
        if (n > 20) {
            return;
        }
        String string = PictureWallCache$AsyncTextureLoader.access$300(this.asyncTextureLoader);
        if (string != null) {
            this.allLoaded = false;
            pictureWallLogCh.log(-2137614336, "PictureWallCache#fireTimer %1, recursionDepth = %2", (Object)string, (long)n);
            PictureWallCache$CachedTexture pictureWallCache$CachedTexture = this.getTexture(string);
            if (pictureWallCache$CachedTexture != null) {
                if (pictureWallCache$CachedTexture.data == null) {
                    HMIResourceLocator hMIResourceLocator = new HMIResourceLocator(string);
                    AsyncBitmapEvent asyncBitmapEvent = new AsyncBitmapEvent((ATIPEventListener)AbstractWidget.hmiService.getRootWindow(0), hMIResourceLocator);
                    this.dispatcher.postEvent(asyncBitmapEvent);
                    pictureWallLogCh.log(-2137614336, "PictureWallCache#fireTimer size of cache = %1, size of pool = %2, model rows = %3", (long)this.textureCache.size(), (long)this.asyncTextureLoader.pool.size(), (long)this.getNumberOfModelRows());
                    pictureWallLogCh.log(-2137614336, "PictureWallCache#fireTimer number of queues = %1, number of single requests = %2", (long)this.asyncTextureLoader.queues.size(), (long)this.asyncTextureLoader.singleRequestQueue.size());
                } else {
                    pictureWallLogCh.log(-2137614336, "PictureWallCache#fireTimer %1 is already loaded.", (Object)string);
                    this.fireTimer(timer, n + 1);
                }
            } else {
                pictureWallLogCh.log(-2137614336, "PictureWallCache#fireTimer Texture %1 is not in cache anymore.", (Object)string);
                this.fireTimer(timer, n + 1);
            }
        } else {
            if (!this.allLoaded) {
                pictureWallLogCh.log(-2137614336, "PictureWallCache#fireTimer All requested textures have been loaded.");
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
            pictureWallLogCh.log(-2137614336, "PictureWallCache#getDataHMIResourceLocator Model row %1 is not available.", (long)n);
        }
        return hMIResourceLocator;
    }

    public int getNumberOfModelRows() {
        if (this.model instanceof TiledListModelGUI) {
            int n = ((TiledListModelGUI)this.model).getLength();
            this.sendDbgCacheControllerCallback(0, new Object[]{new Integer(n)});
            return n;
        }
        pictureWallLogCh.log(-2137614336, "PictureWallCache#getNumberOfModelRows A model is not set.");
        return 0;
    }

    @Override
    public IRenderer getRenderer() {
        return null;
    }

    public PictureWallCache$CachedTexture getTexture(String string) {
        return (PictureWallCache$CachedTexture)this.textureCache.get(string);
    }

    private void initializeTextureCache() {
        pictureWallLogCh.log(-2137614336, "PictureWallCache#initializeTextureCache");
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
            PictureWallCache$CacheBlock pictureWallCache$CacheBlock = new PictureWallCache$CacheBlock(i2);
            this.requestBlock(pictureWallCache$CacheBlock);
        }
    }

    @Override
    public void processModelUpdateEvent(ModelUpdateEvent modelUpdateEvent) {
        pictureWallLogCh.log(-2137614336, "PictureWallCache#processModelUpdateEvent");
        if (modelUpdateEvent.getUpdateType() == 8) {
            ModelUpdateData modelUpdateData = modelUpdateEvent.getClientData3();
            Object object = modelUpdateData.get(ModelUpdateData$Key.REQUESTID);
            Object object2 = modelUpdateData.get(ModelUpdateData$Key.INDEX);
            if (object != null && object2 != null) {
                int n = (Integer)object;
                int n2 = (Integer)object2;
                if (n != -1) {
                    pictureWallLogCh.log(-2137614336, "PictureWallCache#processModelUpdateEvent Received callback for request id = %1", (long)n);
                    this.requestedBlockLoaded(n, n2);
                }
            }
        }
    }

    private void recycleTextureCache() {
        Set set = this.textureCache.entrySet();
        Iterator iterator = set.iterator();
        pictureWallLogCh.log(-2137614336, "PictureWallCache#recycleTextureCache Recycle %1 elements in cache", (long)set.size());
        while (iterator.hasNext()) {
            Map$Entry map$Entry = (Map$Entry)iterator.next();
            PictureWallCache$CachedTexture pictureWallCache$CachedTexture = (PictureWallCache$CachedTexture)map$Entry.getValue();
            this.destroyTexture(pictureWallCache$CachedTexture);
        }
        this.textureCache.clear();
        this.sendDbgCacheControllerCallback(5, null);
    }

    private void requestBlock(PictureWallCache$CacheBlock pictureWallCache$CacheBlock) {
        int n = pictureWallCache$CacheBlock.blockNumber;
        PictureWallCache$CacheBlock pictureWallCache$CacheBlock2 = (PictureWallCache$CacheBlock)this.cache.get(pictureWallCache$CacheBlock.blockNumber);
        if (pictureWallCache$CacheBlock2 != null) {
            if (pictureWallCache$CacheBlock2.requestID.equals(PictureWallCache$CacheBlock.NO_VALUE)) {
                pictureWallLogCh.log(-2137614336, "PictureWallCache#requestBlock Block with number = %1 already in cache, but not requested.", (long)n);
                pictureWallCache$CacheBlock = pictureWallCache$CacheBlock2;
            } else {
                pictureWallLogCh.log(-2137614336, "PictureWallCache#requestBlock Block with number = %1 already in cache.", (long)n);
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
            pictureWallCache$CacheBlock.requestID = new Integer(request);
            this.cache.put(pictureWallCache$CacheBlock.blockNumber, pictureWallCache$CacheBlock);
            this.cache1.put(pictureWallCache$CacheBlock.requestID, pictureWallCache$CacheBlock);
            ++request;
            if (framework.isTarget()) {
                tiledListModelGUI.requestItems(pictureWallCache$CacheBlock.requestID, n2, 12, this.terminal.getTerminalID());
            } else {
                BaseListModel baseListModel = (BaseListModel)this.model;
                EvoListRow[] evoListRowArray = new EvoListRow[12];
                for (int i2 = 0; i2 < evoListRowArray.length; ++i2) {
                    evoListRowArray[i2] = baseListModel.getRow(n2 + i2);
                }
                baseListModel.setRows(pictureWallCache$CacheBlock.requestID, n2, evoListRowArray);
            }
            this.sendDbgCacheControllerCallback(3, null);
            pictureWallLogCh.log(-2137614336, "PictureWallCache#requestBlock number = %1, with requestID = %2", (long)n, (long)pictureWallCache$CacheBlock.requestID.intValue());
        } else {
            pictureWallLogCh.log(-2137614336, "PictureWallCache#requestBlock Block with first row = %1 is out of range [0, %2).", (long)n2, (long)n3);
        }
    }

    public void requestTexture(String string, int n, PictureWallIconRenderer pictureWallIconRenderer) {
        this.asyncTextureLoader.pushSingleRequest(string, n, pictureWallIconRenderer);
    }

    private void requestedBlockLoaded(int n, int n2) {
        pictureWallLogCh.log(-2137614336, "PictureWallCache#requestedBlockLoaded requestID = %1, firstRowToLoad = %2", (long)n, (long)n2);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        PictureWallCache$CacheBlock pictureWallCache$CacheBlock = (PictureWallCache$CacheBlock)this.cache1.get(new Integer(n));
        if (pictureWallCache$CacheBlock == null) {
            pictureWallLogCh.log(10000, "PictureWallCache#requestedBlockLoaded Block with requestID = %1 is not in Cache!", (long)n);
            return;
        }
        pictureWallCache$CacheBlock.loaded = true;
        for (int i2 = 0; i2 < 12; ++i2) {
            int n3 = n2 + i2;
            HMIResourceLocator hMIResourceLocator = this.getDataHMIResourceLocator(n3);
            if (hMIResourceLocator == null || !hMIResourceLocator.containsResourceURI()) continue;
            String string = hMIResourceLocator.getResourceURI();
            pictureWallCache$CacheBlock.data.add(string);
            arrayList.add(string);
            arrayList2.add(new Integer(n3));
        }
        this.asyncTextureLoader.pushQueue(arrayList, arrayList2, n, pictureWallCache$CacheBlock.blockNumber, true);
        this.sendDbgCacheControllerCallback(3, null);
    }

    public PictureWallCache$CachedTexture retrieveCachedTexture(String string) {
        return (PictureWallCache$CachedTexture)this.textureCache.get(string);
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
        this.asyncTextureLoader = new PictureWallCache$AsyncTextureLoader(this, "AsyncTextureLoader", 0, false, new TimerSyncer(this));
        this.sendDbgCacheControllerCallback(6, new Object[]{this.asyncTextureLoader});
    }

    public void sortQueues() {
        this.asyncTextureLoader.sortQueues();
    }

    private void unrequestBlock(PictureWallCache$CacheBlock pictureWallCache$CacheBlock) {
        Object object;
        pictureWallLogCh.log(-2137614336, "PictureWallCache#unrequestBlock Unrequesting %1 elements.", (long)pictureWallCache$CacheBlock.data.size());
        while (!pictureWallCache$CacheBlock.data.isEmpty()) {
            String string = (String)pictureWallCache$CacheBlock.data.remove(0);
            if (string == null) continue;
            object = (PictureWallCache$CachedTexture)this.textureCache.remove(string);
            if (object != null) {
                this.destroyTexture((PictureWallCache$CachedTexture)object);
                this.asyncTextureLoader.pool.add(object);
            }
            pictureWallLogCh.log(-2137614336, "PictureWallCache#unrequestBlock Removed %1 from cache.", (Object)string);
        }
        int n = pictureWallCache$CacheBlock.blockNumber;
        object = (TiledListModelGUI)this.model;
        object.unrequestItems(n * 12, 12, this.terminal.getTerminalID());
        pictureWallLogCh.log(-2137614336, "PictureWallCache#unrequestBlock Block number = %1, number of textures in cache = %2", (long)n, (long)this.textureCache.size());
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
                PictureWallCache$CacheBlock pictureWallCache$CacheBlock = (PictureWallCache$CacheBlock)this.cache.remove(new Integer(n5));
                if (pictureWallCache$CacheBlock == null) {
                    pictureWallCache$CacheBlock = new PictureWallCache$CacheBlock(n4);
                } else {
                    if (!pictureWallCache$CacheBlock.requestID.equals(PictureWallCache$CacheBlock.NO_VALUE)) {
                        this.cache1.remove(pictureWallCache$CacheBlock.requestID);
                    } else {
                        pictureWallLogCh.log(1078071040, "PictureWallCache#updateTextureCache Block number %1 removed with no request ID.", (long)n5);
                    }
                    this.asyncTextureLoader.cancelQueue(pictureWallCache$CacheBlock.requestID);
                    this.unrequestBlock(pictureWallCache$CacheBlock);
                    pictureWallCache$CacheBlock.blockNumber = new Integer(n4);
                    pictureWallCache$CacheBlock.requestID = null;
                }
                this.requestBlock(pictureWallCache$CacheBlock);
                pictureWallLogCh.log(-2137614336, "PictureWallCache#updateTextureCache Leaving block %1, entering block %2.", (long)this.currentBlockNumber, (long)n3);
                this.currentBlockNumber = n3;
                this.sendDbgCacheControllerCallback(3, null);
            }
        }
    }

    static /* synthetic */ HashMap access$000(PictureWallCache pictureWallCache) {
        return pictureWallCache.cache;
    }

    static /* synthetic */ HashMap access$100(PictureWallCache pictureWallCache) {
        return pictureWallCache.textureCache;
    }

    static /* synthetic */ int access$200(PictureWallCache pictureWallCache) {
        return pictureWallCache.currentBlockNumber;
    }

    static {
        request = 0;
    }
}

