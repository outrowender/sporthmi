/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.selection;

import de.audi.app.media.IMediaTerminal;
import de.audi.app.media.browser.AbstractMediaBrowser;
import de.audi.app.media.browser.IBrowseListContext;
import de.audi.app.media.browser.IBrowseListListener;
import de.audi.app.media.browser.NullBrowseListContextImpl;
import de.audi.app.media.dsi.media.MediaListEntry;
import de.audi.app.media.logger.LogUtil;
import de.audi.app.media.queue.IQueueExecutionContext;
import de.audi.app.media.queue.Queue;
import de.audi.app.media.selection.IDataSelectionContext;
import de.audi.app.media.selection.IDataSelectionJob;
import de.audi.app.media.selection.ISelectionListener;
import de.audi.app.media.source.ISourceSlot;
import de.audi.app.media.util.CopyOnWriteArrayList;
import de.audi.atip.log.LogChannel;
import java.util.Iterator;
import org.dsi.ifc.global.CharacterInfo;

public class SelectionBrowser
extends AbstractMediaBrowser
implements IBrowseListListener {
    public static final String LOGCLASS = "SelectionBrowser";
    private final Queue selectionQueue;
    private final IDataSelectionJob nullSelectionJob;
    private static final NullBrowseListContextImpl NULL_BROWSE_LIST_CONTEXT = new NullBrowseListContextImpl();
    private IBrowseListContext browseContext;
    private final CopyOnWriteArrayList selectionListeners;

    public SelectionBrowser(IMediaTerminal iMediaTerminal) {
        super(iMediaTerminal.getLogger().hmi(), iMediaTerminal.getLogger().dsi(), iMediaTerminal.getServiceManager(), iMediaTerminal.getFramework(), iMediaTerminal.getDispatcher(), 1, iMediaTerminal.getSourceController());
        this.selectionQueue = new Queue(iMediaTerminal.getLogger().hmi(), "SelectionQueue");
        iMediaTerminal.getDiagnosisManager().addDataProvider(iMediaTerminal.getTerminalID(), this.selectionQueue);
        this.selectionListeners = new CopyOnWriteArrayList();
        this.browseContext = NULL_BROWSE_LIST_CONTEXT;
        this.nullSelectionJob = new NullDataSelectionJob(iMediaTerminal.getLogger().hmi());
    }

    public void deinit() {
        super.deinit();
        this.removeAllSelectionListeners();
    }

    protected void browserActivated(IBrowseListContext iBrowseListContext) {
        this.logger.log(1000000, "[%1.browserActivated]", (Object)LOGCLASS);
        this.browseContext = iBrowseListContext;
        this.browseContext.addBrowseListListener(this, false);
        this.getRunningJob().browserActivated();
    }

    protected void browserDeactivated(ISourceSlot iSourceSlot, boolean bl) {
        this.logger.log(1000000, "[%1.browserDeactivated]", (Object)LOGCLASS);
        this.getRunningJob().browserDeactivated(bl);
        if (bl) {
            this.selectionQueue.abort();
        }
        this.browseContext = NULL_BROWSE_LIST_CONTEXT;
    }

    public void browseModeChanged(boolean bl, int n) {
        this.logger.log(1000000, "[%1.browseModeChanged] error: '%2', browseMode: '%3'", (Object)LOGCLASS, (Object)String.valueOf(bl), (long)n);
        this.getRunningJob().browseModeChanged(bl, n);
    }

    public void browseFolderChanged(boolean bl, MediaListEntry[] mediaListEntryArray, int n) {
        this.logger.log(1000000, "[%1.browseFolderChanged] error: '%2', folder: '%3'", (Object)LOGCLASS, (Object)String.valueOf(bl), (Object)LogUtil.listEntryToStr(mediaListEntryArray));
        this.getRunningJob().browseFolderChanged(bl, mediaListEntryArray, n);
    }

    public void listUpdated(int n) {
    }

    public int getClientId() {
        return 0;
    }

    public int getListSize() {
        return this.browseContext.getListSize();
    }

    public void responseList(boolean bl, MediaListEntry[] mediaListEntryArray, int n) {
        this.logger.log(1000000, "[%1.responseList]", (Object)LOGCLASS);
        this.getRunningJob().responseList(bl, mediaListEntryArray, n);
    }

    public void responsePickList(boolean bl, MediaListEntry[] mediaListEntryArray) {
        this.getRunningJob().responsePicklist(bl, mediaListEntryArray);
    }

    public void addSelectionResult(boolean bl, int n, int n2, boolean bl2, long l, long l2, long l3, long l4, long l5) {
        this.logger.log(1000000, "[%1.addSelectionResult]", (Object)LOGCLASS);
        this.getRunningJob().addSelectionResult(bl, n, n2, bl2, l, l2, l3, l4, l5);
    }

    public void resetSelectionResult(boolean bl, int n) {
    }

    public void notifyMetadataEntryAvailable(boolean bl) {
    }

    public void notifyFilesystemEntryAvailable(boolean bl) {
    }

    public void notifyCoverartsAvailable(boolean bl) {
    }

    public void notifyUpdateAlphabeticalIndex(CharacterInfo[] characterInfoArray) {
    }

    public void responseSetSelection(boolean bl, IDataSelectionContext iDataSelectionContext) {
        this.logger.log(1000000, "[%1.responseSetSelection] success: %2", (Object)LOGCLASS, (Object)String.valueOf(bl));
        this.propagateSelectionChange(iDataSelectionContext, bl);
    }

    private void propagateSelectionChange(IDataSelectionContext iDataSelectionContext, boolean bl) {
        this.logger.log(1000000, "[%1.propagateSelectionChange] %2", (Object)LOGCLASS, (Object)iDataSelectionContext);
        Iterator iterator = this.selectionListeners.iterator();
        while (iterator.hasNext()) {
            ISelectionListener iSelectionListener = (ISelectionListener)iterator.next();
            iSelectionListener.notifySelectionChanged(iDataSelectionContext, bl);
        }
    }

    public void resetSelection() {
        this.browseContext.resetSelection();
    }

    public void requestListIndexBased(int n, int n2) {
        this.browseContext.requestListByIndex(n, n2, this.getClientId());
    }

    public void addSelection(boolean bl, int n, long l, int n2, boolean bl2) {
        this.browseContext.addSelection(bl, n, l, n2, bl2);
    }

    public void setBrowseMode(int n) {
        if (this.browseContext.getBrowseMode() != n) {
            this.browseContext.setBrowseMode(n);
        } else {
            this.browseModeChanged(false, n);
        }
    }

    public void changeFolder(MediaListEntry[] mediaListEntryArray) {
        this.browseContext.changeFolder(mediaListEntryArray);
    }

    public void requestPickList(long[] lArray) {
        this.browseContext.requestPickList(lArray, this.getClientId());
    }

    public int getBrowserID() {
        return this.browseContext.getBrowserID();
    }

    public MediaListEntry[] getCurrentFolder() {
        return this.browseContext.getBrowseFolder();
    }

    public void reset() {
        this.selectionQueue.abort();
    }

    public void removeQueuedJobs() {
        this.selectionQueue.removeQueuedJobs();
    }

    private IDataSelectionJob getRunningJob() {
        return null != this.selectionQueue.getRunningJob() ? (IDataSelectionJob)this.selectionQueue.getRunningJob() : this.nullSelectionJob;
    }

    public void enqueueSelectionJob(IDataSelectionJob iDataSelectionJob) {
        this.selectionQueue.enqueue(iDataSelectionJob);
    }

    public void addSelectionListener(ISelectionListener iSelectionListener) {
        this.selectionListeners.add(iSelectionListener);
    }

    public void removeSelectionListener(ISelectionListener iSelectionListener) {
        this.selectionListeners.remove(iSelectionListener);
    }

    private void removeAllSelectionListeners() {
        this.selectionListeners.clear();
    }

    private static class NullDataSelectionJob
    implements IDataSelectionJob {
        private static final String LOGCLASS = "NullDataSelectionJob";
        private final LogChannel logChannel;

        public NullDataSelectionJob(LogChannel logChannel) {
            this.logChannel = logChannel;
        }

        public void browserActivated() {
            this.logChannel.log(100000, "[%1.browserActivated]", (Object)LOGCLASS);
        }

        public void browserDeactivated(boolean bl) {
            this.logChannel.log(100000, "[%1.browserDeactivated]", (Object)LOGCLASS);
        }

        public void browseModeChanged(boolean bl, int n) {
            this.logChannel.log(100000, "[%1.browseModeChanged]", (Object)LOGCLASS);
        }

        public void browseFolderChanged(boolean bl, MediaListEntry[] mediaListEntryArray, int n) {
            this.logChannel.log(100000, "[%1.browseFolderChanged]", (Object)LOGCLASS);
        }

        public void responseList(boolean bl, MediaListEntry[] mediaListEntryArray, int n) {
            this.logChannel.log(100000, "[%1.responseList]", (Object)LOGCLASS);
        }

        public void responsePicklist(boolean bl, MediaListEntry[] mediaListEntryArray) {
            this.logChannel.log(100000, "[%1.responsePicklist]", (Object)LOGCLASS);
        }

        public void addSelectionResult(boolean bl, int n, int n2, boolean bl2, long l, long l2, long l3, long l4, long l5) {
            this.logChannel.log(100000, "[%1.addSelectionResult]", (Object)LOGCLASS);
        }

        public int getType() {
            this.logChannel.log(100000, "[%1.getType]", (Object)LOGCLASS);
            return 0;
        }

        public String getName() {
            this.logChannel.log(100000, "[%1.getName]", (Object)LOGCLASS);
            return LOGCLASS;
        }

        public void start(IQueueExecutionContext iQueueExecutionContext) {
            this.logChannel.log(100000, "[%1.start]", (Object)LOGCLASS);
        }

        public void abort(boolean bl) {
            this.logChannel.log(100000, "[%1.abort]", (Object)LOGCLASS);
        }
    }
}

