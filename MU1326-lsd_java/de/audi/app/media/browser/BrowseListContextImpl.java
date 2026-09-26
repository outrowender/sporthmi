/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.browser;

import de.audi.app.media.browser.AbstractJobBrowseList;
import de.audi.app.media.browser.BrowseListContextImpl$1;
import de.audi.app.media.browser.BrowseListContextImpl$2;
import de.audi.app.media.browser.BrowseListContextImpl$3;
import de.audi.app.media.browser.BrowseListState;
import de.audi.app.media.browser.IBrowseListContext;
import de.audi.app.media.browser.IBrowseListListener;
import de.audi.app.media.browser.JobBrowseListAddSelection;
import de.audi.app.media.browser.JobBrowseListChangeFolder;
import de.audi.app.media.browser.JobBrowseListNone;
import de.audi.app.media.browser.JobBrowseListRequestList;
import de.audi.app.media.browser.JobBrowseListRequestPickList;
import de.audi.app.media.browser.JobBrowseListResetSelection;
import de.audi.app.media.browser.JobBrowseListSetBrowseMode;
import de.audi.app.media.dsi.media.IMediaBrowserStateListener;
import de.audi.app.media.dsi.media.IMediaDSIBrowserController;
import de.audi.app.media.dsi.media.MediaListEntry;
import de.audi.app.media.logger.LogUtil;
import de.audi.app.media.queue.Queue;
import de.audi.app.media.source.ISource;
import de.audi.app.media.source.ISourceController;
import de.audi.app.media.source.ISourceSlot;
import de.audi.app.media.source.ISourceSlotListener;
import de.audi.app.media.source.MediaFlags;
import de.audi.app.media.util.CopyOnWriteArrayList;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.Buffer;
import java.util.Iterator;
import org.dsi.ifc.global.CharacterInfo;

public class BrowseListContextImpl
implements IBrowseListContext,
IMediaBrowserStateListener,
ISourceSlotListener {
    private static final String LOGCLASS;
    private final LogChannel logChannel;
    private final IMediaDSIBrowserController dsiMediaBrowser;
    private final CopyOnWriteArrayList registeredBrowseListListeners;
    private final Queue browserQueue;
    private final JobBrowseListNone browseListJobNone;
    private final BrowseListState browseListState;
    private final ISourceSlot activeSlot;
    private final ISourceController sourceController;

    public BrowseListContextImpl(LogChannel logChannel, IMediaDSIBrowserController iMediaDSIBrowserController, ISourceSlot iSourceSlot, ISourceController iSourceController) {
        this.logChannel = logChannel;
        this.dsiMediaBrowser = iMediaDSIBrowserController;
        this.registeredBrowseListListeners = new CopyOnWriteArrayList();
        this.browserQueue = new Queue(this.logChannel, "BrowseListContext");
        this.browseListJobNone = new JobBrowseListNone(this.logChannel, this);
        this.browseListState = new BrowseListState();
        this.activeSlot = iSourceSlot;
        this.sourceController = iSourceController;
    }

    public void init() {
        this.logChannel.log(1078071040, "[%1.init]", (Object)"BrowseListContextImpl");
        this.dsiMediaBrowser.setBrowserStateListener(this);
        this.sourceController.addSourceSlotListener(this.activeSlot.getSource(), this, true);
    }

    public void deinit() {
        this.logChannel.log(1078071040, "[%1.deinit]", (Object)"BrowseListContextImpl");
        this.browserQueue.reset();
        this.dsiMediaBrowser.setBrowserStateListener(null);
        this.sourceController.removeSlotListener(this.activeSlot.getSource(), this);
    }

    @Override
    public ISourceSlot getSlot() {
        return this.activeSlot;
    }

    @Override
    public void slotsChanged(ISource iSource) {
        MediaFlags mediaFlags = iSource.getSlot(this.activeSlot).getFlags();
        boolean bl = mediaFlags.isFilesystemSyncComplete();
        boolean bl2 = mediaFlags.isMetaDataSyncComplete();
        boolean bl3 = mediaFlags.isCoverSyncComplete();
        BrowseListState browseListState = this.getState();
        if (browseListState.isFilesystemAvailable() != bl) {
            this.logChannel.log(-2137614336, "[%1.slotsChanged] Filesystem sync state changed to '%2'", (Object)"BrowseListContextImpl", (Object)String.valueOf(bl));
            browseListState.setFilesystemAvailable(bl);
            this.notifyFilesystemEntryAvailable(bl);
        }
        if (browseListState.isMetadataAvailable() != bl2) {
            this.logChannel.log(-2137614336, "[%1.slotsChanged] Metadata sync state changed to '%2'", (Object)"BrowseListContextImpl", (Object)String.valueOf(bl2));
            browseListState.setMetadataAvailable(bl2);
            this.notifyMetadataEntryAvailable(bl2);
        }
        if (browseListState.isCoverartsAvailable() != bl3) {
            this.logChannel.log(-2137614336, "[%1.slotsChanged] Coverart sync state changed to '%2'", (Object)"BrowseListContextImpl", (Object)String.valueOf(bl3));
            browseListState.setCoverartsAvailable(bl3);
            this.notifyCoverartsAvailable(bl3);
        }
    }

    @Override
    public int getBrowserID() {
        return this.dsiMediaBrowser.getInstanceID();
    }

    @Override
    public void changeFolder(MediaListEntry[] mediaListEntryArray) {
        this.logChannel.log(14808325, "[%1.changeFolder]", (Object)"BrowseListContextImpl");
        this.browserQueue.enqueue(new JobBrowseListChangeFolder(this.logChannel, this.dsiMediaBrowser, this, mediaListEntryArray));
    }

    @Override
    public MediaListEntry[] getBrowseFolder() {
        return this.browseListState.getCurrentBrowseFolder();
    }

    @Override
    public int getListSize() {
        return this.browseListState.getCurrentListSize();
    }

    @Override
    public void requestListByIndex(int n, int n2, int n3) {
        this.logChannel.log(14808325, "[%1.requestListByIndex]", (Object)"BrowseListContextImpl");
        this.browserQueue.enqueue(new JobBrowseListRequestList(this.logChannel, this.dsiMediaBrowser, this, 0L, 0, n, n2, n3));
    }

    @Override
    public void requestListByEntryId(long l, int n, int n2, int n3) {
        this.logChannel.log(14808325, "[%1.requestListByEntryId]", (Object)"BrowseListContextImpl");
        this.browserQueue.enqueue(new JobBrowseListRequestList(this.logChannel, this.dsiMediaBrowser, this, l, n, 0, n2, n3));
    }

    @Override
    public void requestPickList(long[] lArray, int n) {
        this.logChannel.log(14808325, "[%1.requestListPickList]", (Object)"BrowseListContextImpl");
        this.browserQueue.enqueue(new JobBrowseListRequestPickList(this.logChannel, this.dsiMediaBrowser, this, lArray, n));
    }

    @Override
    public void setBrowseMode(int n) {
        if (n == -1) {
            throw new IllegalArgumentException();
        }
        this.logChannel.log(14808325, "[%1.setBrowseMode] '%2'", (Object)"BrowseListContextImpl", (Object)(n == 0 ? "RAW" : "DATABASE"));
        this.browserQueue.enqueue(new JobBrowseListSetBrowseMode(this.logChannel, this.dsiMediaBrowser, this, n));
    }

    @Override
    public int getBrowseMode() {
        return this.browseListState.getCurrentBrowseMode();
    }

    @Override
    public void addSelection(boolean bl, int n, long l, int n2, boolean bl2) {
        this.logChannel.log(14808325, "[%1.addSelection]", (Object)"BrowseListContextImpl");
        this.browserQueue.enqueue(new JobBrowseListAddSelection(this.logChannel, this.dsiMediaBrowser, this, bl, n, l, n2, bl2));
    }

    @Override
    public void resetSelection() {
        this.logChannel.log(14808325, "[%1.resetSelection]", (Object)"BrowseListContextImpl");
        this.browserQueue.executeQueueCommand(new BrowseListContextImpl$1(this));
        this.browserQueue.enqueue(new JobBrowseListResetSelection(this.logChannel, this.dsiMediaBrowser, this));
    }

    @Override
    public void discardListRequest(int n) {
        this.logChannel.log(-2137614336, "[%1.discardListRequest] clientId='%2'", (Object)"BrowseListContextImpl", (long)n);
        this.dsiMediaBrowser.discardListRequest(n);
        this.browserQueue.executeQueueCommand(new BrowseListContextImpl$2(this, n));
    }

    @Override
    public void discardPickListRequest(int n) {
        this.logChannel.log(-2137614336, "[%1.discardPickListRequest] clientId='%2'", (Object)"BrowseListContextImpl", (long)n);
        this.dsiMediaBrowser.discardPickListRequest(n);
    }

    @Override
    public void addBrowseListListener(IBrowseListListener iBrowseListListener, boolean bl) {
        this.logChannel.log(1078071040, "[%1.addBrowseListListener] %2", (Object)"BrowseListContextImpl", (Object)iBrowseListListener);
        this.dsiMediaBrowser.addBrowserListListener(new BrowseListContextImpl$3(this, iBrowseListListener));
        this.registeredBrowseListListeners.add(iBrowseListListener);
        if (bl) {
            iBrowseListListener.notifyMetadataEntryAvailable(this.getState().isMetadataAvailable());
        }
    }

    @Override
    public void removeAllBrowseListListener() {
        this.logChannel.log(-2137614336, "[%1.removeAllBrowseListListener]", (Object)"BrowseListContextImpl");
        this.dsiMediaBrowser.removeAllBrowserListListener();
        this.registeredBrowseListListeners.clear();
    }

    @Override
    public void updateBrowseMode(int n) {
        this.logChannel.log(14808325, "[%1.updateBrowseMode] '%2'", (Object)"BrowseListContextImpl", (long)n);
        this.getRunningJob().updateBrowseMode(n);
    }

    @Override
    public void updateContentFilter(int n) {
        this.logChannel.log(14808325, "[%1.updateContentFilter] '%2'", (Object)"BrowseListContextImpl", (long)n);
        this.getRunningJob().updateContentFilter(n);
    }

    @Override
    public void updateBrowseFolder(MediaListEntry[] mediaListEntryArray) {
        if (this.logChannel.isDebug2()) {
            this.logChannel.log(14808325, "[%1.updateBrowseFolder] '%2'", (Object)"BrowseListContextImpl", (Object)LogUtil.listEntryToStr(mediaListEntryArray));
        }
        this.getRunningJob().updateBrowseFolder(mediaListEntryArray);
    }

    @Override
    public void updateAlphabeticalIndex(CharacterInfo[] characterInfoArray) {
        if (this.logChannel.isDebug2()) {
            this.logChannel.log(14808325, "[%1.updateAlphabeticalIndex] '%2'", (Object)"BrowseListContextImpl");
        }
        this.notifyUpdateAlphabeticalIndex(characterInfoArray);
    }

    @Override
    public void updateListSize(int n, int n2) {
        this.logChannel.log(14808325, "[%1.updateListSize] '%2','%3'", (Object)"BrowseListContextImpl", (long)n, (long)n2);
        this.getRunningJob().updateListSize(n, n2);
    }

    @Override
    public void selectionResult(int n, int n2, boolean bl, long l, long l2, long l3, long l4, long l5) {
        this.logChannel.log(14808325, "[%1.selectionResult]", (Object)"BrowseListContextImpl");
        this.getRunningJob().selectionResult(n, n2, bl, l, l2, l3, l4, l5);
    }

    @Override
    public void errorFolderChange() {
        this.logChannel.log(-2137614336, "[%1.errorFolderChange]", (Object)"BrowseListContextImpl");
        this.getRunningJob().errorFolderChange();
    }

    @Override
    public void errorSelection() {
        this.logChannel.log(-2137614336, "[%1.errorSelection]", (Object)"BrowseListContextImpl");
        this.getRunningJob().errorSelection();
    }

    @Override
    public void errorBrowseMode() {
        this.logChannel.log(-2137614336, "[%1.errorBrowseMode]", (Object)"BrowseListContextImpl");
        this.getRunningJob().errorBrowseMode();
    }

    protected void notifyListUpdated(int n) {
        this.logChannel.log(14808325, "[%1.notifyListUpdated] listsize: %2", (Object)"BrowseListContextImpl", (long)n);
        Iterator iterator = this.registeredBrowseListListeners.iterator();
        while (iterator.hasNext()) {
            IBrowseListListener iBrowseListListener = (IBrowseListListener)iterator.next();
            try {
                iBrowseListListener.listUpdated(n);
            }
            catch (Exception exception) {
                this.logChannel.log(-1601830656, "[%1.notifyListUpdated] %2", (Object)"BrowseListContextImpl", (Throwable)exception);
            }
        }
    }

    protected void notifyBrowseModeChanged(boolean bl, int n) {
        this.logChannel.log(14808325, "[%1.notifyBrowseModeChanged]", (Object)"BrowseListContextImpl");
        Iterator iterator = this.registeredBrowseListListeners.iterator();
        while (iterator.hasNext()) {
            IBrowseListListener iBrowseListListener = (IBrowseListListener)iterator.next();
            try {
                iBrowseListListener.browseModeChanged(bl, n);
            }
            catch (Exception exception) {
                this.logChannel.log(-1601830656, "[%1.notifyBrowseModeChanged] %2", (Object)"BrowseListContextImpl", (Throwable)exception);
            }
        }
    }

    protected void notifyBrowseFolderChanged(boolean bl, MediaListEntry[] mediaListEntryArray, int n) {
        this.logChannel.log(14808325, "[%1.notifyBrowseFolderChanged]", (Object)"BrowseListContextImpl");
        Iterator iterator = this.registeredBrowseListListeners.iterator();
        while (iterator.hasNext()) {
            IBrowseListListener iBrowseListListener = (IBrowseListListener)iterator.next();
            try {
                iBrowseListListener.browseFolderChanged(bl, mediaListEntryArray, n);
            }
            catch (Exception exception) {
                this.logChannel.log(-1601830656, "[%1.notifyBrowseFolderChanged] %2", (Object)"BrowseListContextImpl", (Throwable)exception);
            }
        }
    }

    protected void notifySelectionResult(boolean bl, int n, int n2, boolean bl2, long l, long l2, long l3, long l4, long l5) {
        this.logChannel.log(14808325, "[%1.notifySelectionResult]", (Object)"BrowseListContextImpl");
        Iterator iterator = this.registeredBrowseListListeners.iterator();
        while (iterator.hasNext()) {
            IBrowseListListener iBrowseListListener = (IBrowseListListener)iterator.next();
            try {
                iBrowseListListener.addSelectionResult(bl, n, n2, bl2, l, l2, l3, l4, l5);
            }
            catch (Exception exception) {
                this.logChannel.log(-1601830656, "[%1.notifySelectionResult] %2", (Object)"BrowseListContextImpl", (Throwable)exception);
            }
        }
    }

    protected void notifySelectionReset(boolean bl, int n) {
        this.logChannel.log(14808325, "[%1.notifySelectionReset]", (Object)"BrowseListContextImpl");
        Iterator iterator = this.registeredBrowseListListeners.iterator();
        while (iterator.hasNext()) {
            IBrowseListListener iBrowseListListener = (IBrowseListListener)iterator.next();
            try {
                iBrowseListListener.resetSelectionResult(bl, n);
            }
            catch (Exception exception) {
                this.logChannel.log(-1601830656, "[%1.notifySelectionReset] %2", (Object)"BrowseListContextImpl", (Throwable)exception);
            }
        }
    }

    public void notifyMetadataEntryAvailable(boolean bl) {
        this.logChannel.log(14808325, "[%1.notifyMetadataEntryAvailable]", (Object)"BrowseListContextImpl");
        Iterator iterator = this.registeredBrowseListListeners.iterator();
        while (iterator.hasNext()) {
            IBrowseListListener iBrowseListListener = (IBrowseListListener)iterator.next();
            try {
                iBrowseListListener.notifyMetadataEntryAvailable(bl);
            }
            catch (Exception exception) {
                this.logChannel.log(-1601830656, "[%1.notifyMetadataEntryAvailable] %2", (Object)"BrowseListContextImpl", (Throwable)exception);
            }
        }
    }

    public void notifyCoverartsAvailable(boolean bl) {
        this.logChannel.log(14808325, "[%1.notifyCoverartsAvailable]", (Object)"BrowseListContextImpl");
        Iterator iterator = this.registeredBrowseListListeners.iterator();
        while (iterator.hasNext()) {
            IBrowseListListener iBrowseListListener = (IBrowseListListener)iterator.next();
            try {
                iBrowseListListener.notifyCoverartsAvailable(bl);
            }
            catch (Exception exception) {
                this.logChannel.log(-1601830656, "[%1.notifyCoverartsAvailable] %2", (Object)"BrowseListContextImpl", (Throwable)exception);
            }
        }
    }

    public void notifyFilesystemEntryAvailable(boolean bl) {
        this.logChannel.log(14808325, "[%1.notifyFilesystemEntryAvailable]", (Object)"BrowseListContextImpl");
        Iterator iterator = this.registeredBrowseListListeners.iterator();
        while (iterator.hasNext()) {
            IBrowseListListener iBrowseListListener = (IBrowseListListener)iterator.next();
            try {
                iBrowseListListener.notifyFilesystemEntryAvailable(bl);
            }
            catch (Exception exception) {
                this.logChannel.log(-1601830656, "[%1.notifyFilesystemEntryAvailable] %2", (Object)"BrowseListContextImpl", (Throwable)exception);
            }
        }
    }

    private void notifyUpdateAlphabeticalIndex(CharacterInfo[] characterInfoArray) {
        Iterator iterator = this.registeredBrowseListListeners.iterator();
        while (iterator.hasNext()) {
            IBrowseListListener iBrowseListListener = (IBrowseListListener)iterator.next();
            try {
                iBrowseListListener.notifyUpdateAlphabeticalIndex(characterInfoArray);
            }
            catch (Exception exception) {
                this.logChannel.log(-1601830656, "[%1.notifyUpdateAlphabeticalIndex] %2", (Object)"BrowseListContextImpl", (Throwable)exception);
            }
        }
    }

    private AbstractJobBrowseList getRunningJob() {
        AbstractJobBrowseList abstractJobBrowseList = (AbstractJobBrowseList)this.browserQueue.getRunningJob();
        return abstractJobBrowseList != null ? abstractJobBrowseList : this.browseListJobNone;
    }

    protected BrowseListState getState() {
        return this.browseListState;
    }

    public String toString() {
        Buffer buffer = new Buffer(20);
        buffer.append("BrowseListContextImpl").append("@").append(this.hashCode());
        return buffer.toString();
    }

    static /* synthetic */ LogChannel access$000(BrowseListContextImpl browseListContextImpl) {
        return browseListContextImpl.logChannel;
    }

    static /* synthetic */ AbstractJobBrowseList access$100(BrowseListContextImpl browseListContextImpl) {
        return browseListContextImpl.getRunningJob();
    }
}

