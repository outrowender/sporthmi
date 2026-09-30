/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.browser;

import de.audi.app.media.browser.AbstractJobBrowseList;
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
import de.audi.app.media.dsi.media.IMediaBrowserListListener;
import de.audi.app.media.dsi.media.IMediaBrowserStateListener;
import de.audi.app.media.dsi.media.IMediaDSIBrowserController;
import de.audi.app.media.dsi.media.MediaListEntry;
import de.audi.app.media.logger.LogUtil;
import de.audi.app.media.queue.IQueueCommand;
import de.audi.app.media.queue.IQueueJob;
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
import java.util.List;
import org.dsi.ifc.global.CharacterInfo;

public class BrowseListContextImpl
implements IBrowseListContext,
IMediaBrowserStateListener,
ISourceSlotListener {
    private static final String LOGCLASS = "BrowseListContextImpl";
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
        this.logChannel.log(1000000, "[%1.init]", (Object)LOGCLASS);
        this.dsiMediaBrowser.setBrowserStateListener(this);
        this.sourceController.addSourceSlotListener(this.activeSlot.getSource(), this, true);
    }

    public void deinit() {
        this.logChannel.log(1000000, "[%1.deinit]", (Object)LOGCLASS);
        this.browserQueue.reset();
        this.dsiMediaBrowser.setBrowserStateListener(null);
        this.sourceController.removeSlotListener(this.activeSlot.getSource(), this);
    }

    public ISourceSlot getSlot() {
        return this.activeSlot;
    }

    public void slotsChanged(ISource iSource) {
        MediaFlags mediaFlags = iSource.getSlot(this.activeSlot).getFlags();
        boolean bl = mediaFlags.isFilesystemSyncComplete();
        boolean bl2 = mediaFlags.isMetaDataSyncComplete();
        boolean bl3 = mediaFlags.isCoverSyncComplete();
        BrowseListState browseListState = this.getState();
        if (browseListState.isFilesystemAvailable() != bl) {
            this.logChannel.log(10000000, "[%1.slotsChanged] Filesystem sync state changed to '%2'", (Object)LOGCLASS, (Object)String.valueOf(bl));
            browseListState.setFilesystemAvailable(bl);
            this.notifyFilesystemEntryAvailable(bl);
        }
        if (browseListState.isMetadataAvailable() != bl2) {
            this.logChannel.log(10000000, "[%1.slotsChanged] Metadata sync state changed to '%2'", (Object)LOGCLASS, (Object)String.valueOf(bl2));
            browseListState.setMetadataAvailable(bl2);
            this.notifyMetadataEntryAvailable(bl2);
        }
        if (browseListState.isCoverartsAvailable() != bl3) {
            this.logChannel.log(10000000, "[%1.slotsChanged] Coverart sync state changed to '%2'", (Object)LOGCLASS, (Object)String.valueOf(bl3));
            browseListState.setCoverartsAvailable(bl3);
            this.notifyCoverartsAvailable(bl3);
        }
    }

    public int getBrowserID() {
        return this.dsiMediaBrowser.getInstanceID();
    }

    public void changeFolder(MediaListEntry[] mediaListEntryArray) {
        this.logChannel.log(100000000, "[%1.changeFolder]", (Object)LOGCLASS);
        this.browserQueue.enqueue(new JobBrowseListChangeFolder(this.logChannel, this.dsiMediaBrowser, this, mediaListEntryArray));
    }

    public MediaListEntry[] getBrowseFolder() {
        return this.browseListState.getCurrentBrowseFolder();
    }

    public int getListSize() {
        return this.browseListState.getCurrentListSize();
    }

    public void requestListByIndex(int n, int n2, int n3) {
        this.logChannel.log(100000000, "[%1.requestListByIndex]", (Object)LOGCLASS);
        this.browserQueue.enqueue(new JobBrowseListRequestList(this.logChannel, this.dsiMediaBrowser, this, 0L, 0, n, n2, n3));
    }

    public void requestListByEntryId(long l, int n, int n2, int n3) {
        this.logChannel.log(100000000, "[%1.requestListByEntryId]", (Object)LOGCLASS);
        this.browserQueue.enqueue(new JobBrowseListRequestList(this.logChannel, this.dsiMediaBrowser, this, l, n, 0, n2, n3));
    }

    public void requestPickList(long[] lArray, int n) {
        this.logChannel.log(100000000, "[%1.requestListPickList]", (Object)LOGCLASS);
        this.browserQueue.enqueue(new JobBrowseListRequestPickList(this.logChannel, this.dsiMediaBrowser, this, lArray, n));
    }

    public void setBrowseMode(int n) {
        if (n == -1) {
            throw new IllegalArgumentException();
        }
        this.logChannel.log(100000000, "[%1.setBrowseMode] '%2'", (Object)LOGCLASS, (Object)(n == 0 ? "RAW" : "DATABASE"));
        this.browserQueue.enqueue(new JobBrowseListSetBrowseMode(this.logChannel, this.dsiMediaBrowser, this, n));
    }

    public int getBrowseMode() {
        return this.browseListState.getCurrentBrowseMode();
    }

    public void addSelection(boolean bl, int n, long l, int n2, boolean bl2) {
        this.logChannel.log(100000000, "[%1.addSelection]", (Object)LOGCLASS);
        this.browserQueue.enqueue(new JobBrowseListAddSelection(this.logChannel, this.dsiMediaBrowser, this, bl, n, l, n2, bl2));
    }

    public void resetSelection() {
        this.logChannel.log(100000000, "[%1.resetSelection]", (Object)LOGCLASS);
        this.browserQueue.executeQueueCommand(new IQueueCommand(){

            public void execute(IQueueJob iQueueJob, List list) {
                Iterator iterator = list.iterator();
                while (iterator.hasNext()) {
                    AbstractJobBrowseList abstractJobBrowseList = (AbstractJobBrowseList)iterator.next();
                    if (abstractJobBrowseList.getType() != 4) continue;
                    BrowseListContextImpl.this.logChannel.log(10000000, "[%1.resetSelection] Remove AddSelection ('%2').", (Object)BrowseListContextImpl.LOGCLASS, (Object)abstractJobBrowseList);
                    iterator.remove();
                }
            }
        });
        this.browserQueue.enqueue(new JobBrowseListResetSelection(this.logChannel, this.dsiMediaBrowser, this));
    }

    public void discardListRequest(final int n) {
        this.logChannel.log(10000000, "[%1.discardListRequest] clientId='%2'", (Object)LOGCLASS, (long)n);
        this.dsiMediaBrowser.discardListRequest(n);
        this.browserQueue.executeQueueCommand(new IQueueCommand(){

            public void execute(IQueueJob iQueueJob, List list) {
                AbstractJobBrowseList abstractJobBrowseList;
                Iterator iterator = list.iterator();
                while (iterator.hasNext()) {
                    JobBrowseListRequestList jobBrowseListRequestList;
                    abstractJobBrowseList = (AbstractJobBrowseList)iterator.next();
                    if (!(abstractJobBrowseList instanceof JobBrowseListRequestList) || (jobBrowseListRequestList = (JobBrowseListRequestList)abstractJobBrowseList).getClientId() != n) continue;
                    BrowseListContextImpl.this.logChannel.log(10000000, "[%1.discardListRequest] Remove ListRequest ('%2').", (Object)BrowseListContextImpl.LOGCLASS, (Object)abstractJobBrowseList);
                    list.remove(jobBrowseListRequestList);
                    iterator = list.iterator();
                }
                if (iQueueJob instanceof JobBrowseListRequestList && ((JobBrowseListRequestList)(abstractJobBrowseList = (JobBrowseListRequestList)iQueueJob)).getClientId() == n) {
                    ((JobBrowseListRequestList)abstractJobBrowseList).abort(true);
                }
            }
        });
    }

    public void discardPickListRequest(int n) {
        this.logChannel.log(10000000, "[%1.discardPickListRequest] clientId='%2'", (Object)LOGCLASS, (long)n);
        this.dsiMediaBrowser.discardPickListRequest(n);
    }

    public void addBrowseListListener(final IBrowseListListener iBrowseListListener, boolean bl) {
        this.logChannel.log(1000000, "[%1.addBrowseListListener] %2", (Object)LOGCLASS, (Object)iBrowseListListener);
        this.dsiMediaBrowser.addBrowserListListener(new IMediaBrowserListListener(){

            public void responseList(MediaListEntry[] mediaListEntryArray, int n) {
                BrowseListContextImpl.this.getRunningJob().responseList(false, mediaListEntryArray, n);
                iBrowseListListener.responseList(false, mediaListEntryArray, n);
            }

            public int getClientID() {
                return iBrowseListListener.getClientId();
            }

            public void errorListRequestAborted() {
                BrowseListContextImpl.this.getRunningJob().responseList(true, null, -1);
                iBrowseListListener.responseList(true, null, -1);
            }

            public void responsePickList(MediaListEntry[] mediaListEntryArray) {
                BrowseListContextImpl.this.getRunningJob().responsePickList(false, mediaListEntryArray);
                iBrowseListListener.responsePickList(false, mediaListEntryArray);
            }

            public void errorPickListRequestAborted() {
                BrowseListContextImpl.this.getRunningJob().responsePickList(true, null);
                iBrowseListListener.responsePickList(true, null);
            }
        });
        this.registeredBrowseListListeners.add(iBrowseListListener);
        if (bl) {
            iBrowseListListener.notifyMetadataEntryAvailable(this.getState().isMetadataAvailable());
        }
    }

    public void removeAllBrowseListListener() {
        this.logChannel.log(10000000, "[%1.removeAllBrowseListListener]", (Object)LOGCLASS);
        this.dsiMediaBrowser.removeAllBrowserListListener();
        this.registeredBrowseListListeners.clear();
    }

    public void updateBrowseMode(int n) {
        this.logChannel.log(100000000, "[%1.updateBrowseMode] '%2'", (Object)LOGCLASS, (long)n);
        this.getRunningJob().updateBrowseMode(n);
    }

    public void updateContentFilter(int n) {
        this.logChannel.log(100000000, "[%1.updateContentFilter] '%2'", (Object)LOGCLASS, (long)n);
        this.getRunningJob().updateContentFilter(n);
    }

    public void updateBrowseFolder(MediaListEntry[] mediaListEntryArray) {
        if (this.logChannel.isDebug2()) {
            this.logChannel.log(100000000, "[%1.updateBrowseFolder] '%2'", (Object)LOGCLASS, (Object)LogUtil.listEntryToStr(mediaListEntryArray));
        }
        this.getRunningJob().updateBrowseFolder(mediaListEntryArray);
    }

    public void updateAlphabeticalIndex(CharacterInfo[] characterInfoArray) {
        if (this.logChannel.isDebug2()) {
            this.logChannel.log(100000000, "[%1.updateAlphabeticalIndex] '%2'", (Object)LOGCLASS);
        }
        this.notifyUpdateAlphabeticalIndex(characterInfoArray);
    }

    public void updateListSize(int n, int n2) {
        this.logChannel.log(100000000, "[%1.updateListSize] '%2','%3'", (Object)LOGCLASS, (long)n, (long)n2);
        this.getRunningJob().updateListSize(n, n2);
    }

    public void selectionResult(int n, int n2, boolean bl, long l, long l2, long l3, long l4, long l5) {
        this.logChannel.log(100000000, "[%1.selectionResult]", (Object)LOGCLASS);
        this.getRunningJob().selectionResult(n, n2, bl, l, l2, l3, l4, l5);
    }

    public void errorFolderChange() {
        this.logChannel.log(10000000, "[%1.errorFolderChange]", (Object)LOGCLASS);
        this.getRunningJob().errorFolderChange();
    }

    public void errorSelection() {
        this.logChannel.log(10000000, "[%1.errorSelection]", (Object)LOGCLASS);
        this.getRunningJob().errorSelection();
    }

    public void errorBrowseMode() {
        this.logChannel.log(10000000, "[%1.errorBrowseMode]", (Object)LOGCLASS);
        this.getRunningJob().errorBrowseMode();
    }

    protected void notifyListUpdated(int n) {
        this.logChannel.log(100000000, "[%1.notifyListUpdated] listsize: %2", (Object)LOGCLASS, (long)n);
        Iterator iterator = this.registeredBrowseListListeners.iterator();
        while (iterator.hasNext()) {
            IBrowseListListener iBrowseListListener = (IBrowseListListener)iterator.next();
            try {
                iBrowseListListener.listUpdated(n);
            }
            catch (Exception exception) {
                this.logChannel.log(100000, "[%1.notifyListUpdated] %2", (Object)LOGCLASS, (Throwable)exception);
            }
        }
    }

    protected void notifyBrowseModeChanged(boolean bl, int n) {
        this.logChannel.log(100000000, "[%1.notifyBrowseModeChanged]", (Object)LOGCLASS);
        Iterator iterator = this.registeredBrowseListListeners.iterator();
        while (iterator.hasNext()) {
            IBrowseListListener iBrowseListListener = (IBrowseListListener)iterator.next();
            try {
                iBrowseListListener.browseModeChanged(bl, n);
            }
            catch (Exception exception) {
                this.logChannel.log(100000, "[%1.notifyBrowseModeChanged] %2", (Object)LOGCLASS, (Throwable)exception);
            }
        }
    }

    protected void notifyBrowseFolderChanged(boolean bl, MediaListEntry[] mediaListEntryArray, int n) {
        this.logChannel.log(100000000, "[%1.notifyBrowseFolderChanged]", (Object)LOGCLASS);
        Iterator iterator = this.registeredBrowseListListeners.iterator();
        while (iterator.hasNext()) {
            IBrowseListListener iBrowseListListener = (IBrowseListListener)iterator.next();
            try {
                iBrowseListListener.browseFolderChanged(bl, mediaListEntryArray, n);
            }
            catch (Exception exception) {
                this.logChannel.log(100000, "[%1.notifyBrowseFolderChanged] %2", (Object)LOGCLASS, (Throwable)exception);
            }
        }
    }

    protected void notifySelectionResult(boolean bl, int n, int n2, boolean bl2, long l, long l2, long l3, long l4, long l5) {
        this.logChannel.log(100000000, "[%1.notifySelectionResult]", (Object)LOGCLASS);
        Iterator iterator = this.registeredBrowseListListeners.iterator();
        while (iterator.hasNext()) {
            IBrowseListListener iBrowseListListener = (IBrowseListListener)iterator.next();
            try {
                iBrowseListListener.addSelectionResult(bl, n, n2, bl2, l, l2, l3, l4, l5);
            }
            catch (Exception exception) {
                this.logChannel.log(100000, "[%1.notifySelectionResult] %2", (Object)LOGCLASS, (Throwable)exception);
            }
        }
    }

    protected void notifySelectionReset(boolean bl, int n) {
        this.logChannel.log(100000000, "[%1.notifySelectionReset]", (Object)LOGCLASS);
        Iterator iterator = this.registeredBrowseListListeners.iterator();
        while (iterator.hasNext()) {
            IBrowseListListener iBrowseListListener = (IBrowseListListener)iterator.next();
            try {
                iBrowseListListener.resetSelectionResult(bl, n);
            }
            catch (Exception exception) {
                this.logChannel.log(100000, "[%1.notifySelectionReset] %2", (Object)LOGCLASS, (Throwable)exception);
            }
        }
    }

    public void notifyMetadataEntryAvailable(boolean bl) {
        this.logChannel.log(100000000, "[%1.notifyMetadataEntryAvailable]", (Object)LOGCLASS);
        Iterator iterator = this.registeredBrowseListListeners.iterator();
        while (iterator.hasNext()) {
            IBrowseListListener iBrowseListListener = (IBrowseListListener)iterator.next();
            try {
                iBrowseListListener.notifyMetadataEntryAvailable(bl);
            }
            catch (Exception exception) {
                this.logChannel.log(100000, "[%1.notifyMetadataEntryAvailable] %2", (Object)LOGCLASS, (Throwable)exception);
            }
        }
    }

    public void notifyCoverartsAvailable(boolean bl) {
        this.logChannel.log(100000000, "[%1.notifyCoverartsAvailable]", (Object)LOGCLASS);
        Iterator iterator = this.registeredBrowseListListeners.iterator();
        while (iterator.hasNext()) {
            IBrowseListListener iBrowseListListener = (IBrowseListListener)iterator.next();
            try {
                iBrowseListListener.notifyCoverartsAvailable(bl);
            }
            catch (Exception exception) {
                this.logChannel.log(100000, "[%1.notifyCoverartsAvailable] %2", (Object)LOGCLASS, (Throwable)exception);
            }
        }
    }

    public void notifyFilesystemEntryAvailable(boolean bl) {
        this.logChannel.log(100000000, "[%1.notifyFilesystemEntryAvailable]", (Object)LOGCLASS);
        Iterator iterator = this.registeredBrowseListListeners.iterator();
        while (iterator.hasNext()) {
            IBrowseListListener iBrowseListListener = (IBrowseListListener)iterator.next();
            try {
                iBrowseListListener.notifyFilesystemEntryAvailable(bl);
            }
            catch (Exception exception) {
                this.logChannel.log(100000, "[%1.notifyFilesystemEntryAvailable] %2", (Object)LOGCLASS, (Throwable)exception);
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
                this.logChannel.log(100000, "[%1.notifyUpdateAlphabeticalIndex] %2", (Object)LOGCLASS, (Throwable)exception);
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
        buffer.append(LOGCLASS).append("@").append(this.hashCode());
        return buffer.toString();
    }
}

