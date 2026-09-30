/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.sdis;

import de.audi.app.media.IMediaTerminal;
import de.audi.app.media.dsi.IDSIControllerStateListener;
import de.audi.app.media.dsi.media.IMediaBrowserListListener;
import de.audi.app.media.dsi.media.IMediaBrowserListener;
import de.audi.app.media.dsi.media.IMediaBrowserStateListener;
import de.audi.app.media.dsi.media.MediaDSIBrowserControllerImpl;
import de.audi.app.media.dsi.media.MediaListEntry;
import de.audi.app.media.sdis.MediaUtilsSDIS;
import de.audi.app.media.source.ISource;
import de.audi.app.media.source.ISourceSlotListener;
import de.audi.app.media.source.MediaCapabilities;
import de.audi.app.media.source.MediaFlags;
import de.audi.atip.agent.IASIProvider;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.comm.asi.hmisync.media.ASIHMISyncMediaBrowserReply;
import de.esolutions.fw.comm.asi.hmisync.media.MediaEntry;
import de.esolutions.fw.comm.asi.hmisync.media.MediaSourceSlot;
import de.esolutions.fw.comm.asi.hmisync.media.impl.ASIHMISyncMediaBrowserAbstractBaseService;
import de.esolutions.fw.comm.asi.hmisync.media.impl.ASIHMISyncMediaBrowserService;
import de.esolutions.fw.comm.core.IService;
import de.esolutions.fw.comm.core.IStub;
import de.esolutions.fw.comm.core.method.MethodException;
import java.util.Hashtable;
import org.dsi.ifc.global.CharacterInfo;
import org.osgi.framework.ServiceRegistration;

public class MediaSDISBrowserASIProvider
extends ASIHMISyncMediaBrowserAbstractBaseService
implements IMediaBrowserListener,
IMediaBrowserStateListener,
IASIProvider,
IDSIControllerStateListener,
ISourceSlotListener,
IMediaBrowserListListener {
    private static final String LOGCLASS = "MediaSDISBrowserASIProvider";
    protected static final int CLIENT_ID = 1;
    private final LogChannel logger;
    private final IMediaTerminal terminal;
    private final ASIHMISyncMediaBrowserService asiMediaBrowser;
    private final MediaDSIBrowserControllerImpl dsiBrowserController;
    private final ASIHMISyncMediaBrowserReply nullBrowserReply;
    private volatile ServiceRegistration registerService;
    private volatile ASIHMISyncMediaBrowserReply browserReply;
    private volatile MediaSourceSlot activeSourceSlot;
    private volatile boolean isFilesystemAvailable;
    private volatile boolean isMetadataAvailable;
    static /* synthetic */ Class class$de$audi$atip$agent$IASIProvider;

    public MediaSDISBrowserASIProvider(IMediaTerminal iMediaTerminal, int n) {
        this.terminal = iMediaTerminal;
        this.logger = iMediaTerminal.getFramework().getLogChannel("App.Media.SDIS");
        this.dsiBrowserController = new MediaDSIBrowserControllerImpl(n, iMediaTerminal.getServiceManager(), iMediaTerminal.getFramework(), iMediaTerminal.getDispatcher(), iMediaTerminal.getLogger().dsi());
        this.asiMediaBrowser = new ASIHMISyncMediaBrowserService(n, this);
        this.browserReply = this.nullBrowserReply = new NullASIHMISyncMediaBrowserReply();
        try {
            this.updateASIVersion("2.2.00");
            this.updateRequestIDs(new short[]{3, 4, 5, 12, 13, 14, 0, 1, 2, 6, 7, 11});
            this.updateReplyIDs(new short[]{8, 9, 10, 16, 15, 17, 18, 19, 20, 21, 22, 23});
        }
        catch (MethodException methodException) {
            this.logger.log(10000, "[%1.MediaSDISBrowserASIProvider] - could not register ASI version!", (Object)LOGCLASS, (Throwable)methodException);
        }
    }

    public void init() {
        this.logger.log(1000000, "[%1.init]", (Object)LOGCLASS);
        this.dsiBrowserController.init();
        this.dsiBrowserController.setBrowserListener(this);
        this.dsiBrowserController.setBrowserStateListener(this);
        this.dsiBrowserController.setStateListener(this);
        this.dsiBrowserController.startDSI();
    }

    public void deinit() {
        this.logger.log(1000000, "[%1.deinit]", (Object)LOGCLASS);
        this.dsiBrowserController.deinit();
        if (null != this.registerService) {
            this.terminal.getServiceManager().unregisterService(this.registerService);
            this.registerService = null;
        }
    }

    public void dsiAvailable() {
        this.logger.log(1000000, "[%1.dsiAvailable]", (Object)LOGCLASS);
        this.registerService = this.terminal.getServiceManager().registerService(class$de$audi$atip$agent$IASIProvider == null ? (class$de$audi$atip$agent$IASIProvider = MediaSDISBrowserASIProvider.class$("de.audi.atip.agent.IASIProvider")) : class$de$audi$atip$agent$IASIProvider, this, new Hashtable(0));
    }

    public void dsiUnavailable() {
        this.logger.log(1000000, "[%1.dsiUnavailable]", (Object)LOGCLASS);
        if (null != this.registerService) {
            this.terminal.getServiceManager().unregisterService(this.registerService);
            this.registerService = null;
        }
        this.isFilesystemAvailable = false;
        this.isMetadataAvailable = false;
    }

    public IService getService() {
        return this.asiMediaBrowser;
    }

    public void attachStub(IStub iStub) {
        this.logger.log(1000000, "[%1.attachStub] '%2'", (Object)LOGCLASS, (Object)iStub);
    }

    public void detachStub(IStub iStub) {
        this.logger.log(1000000, "[%1.detachStub] '%2'", (Object)LOGCLASS, (Object)iStub);
    }

    public void activate(MediaSourceSlot mediaSourceSlot, ASIHMISyncMediaBrowserReply aSIHMISyncMediaBrowserReply) throws MethodException {
        this.logger.log(1000000, "[%1.activate]", (Object)LOGCLASS);
        this.setReplyService(aSIHMISyncMediaBrowserReply);
        de.audi.app.media.source.MediaSourceSlot mediaSourceSlot2 = MediaUtilsSDIS.get2DSISourceSlot(mediaSourceSlot, this.terminal.getSourceController());
        this.dsiBrowserController.activate(mediaSourceSlot2);
        this.dsiBrowserController.addBrowserListListener(this);
        this.activeSourceSlot = mediaSourceSlot;
        this.isFilesystemAvailable = false;
        this.isMetadataAvailable = false;
        this.terminal.getSourceController().addSourceSlotListener(mediaSourceSlot2.getSource(), this, true);
    }

    public void deactivate(ASIHMISyncMediaBrowserReply aSIHMISyncMediaBrowserReply) throws MethodException {
        this.logger.log(1000000, "[%1.deactivate]", (Object)LOGCLASS);
        this.setReplyService(aSIHMISyncMediaBrowserReply);
        this.dsiBrowserController.removeAllBrowserListListener();
        this.isFilesystemAvailable = false;
        this.isMetadataAvailable = false;
        this.dsiBrowserController.deactivate();
    }

    public void setBrowseMode(int n, ASIHMISyncMediaBrowserReply aSIHMISyncMediaBrowserReply) throws MethodException {
        this.logger.log(1000000, "[%1.setBrowseMode]", (Object)LOGCLASS);
        this.setReplyService(aSIHMISyncMediaBrowserReply);
        this.dsiBrowserController.setBrowseMode(n);
    }

    public void changeFolder(MediaEntry[] mediaEntryArray, ASIHMISyncMediaBrowserReply aSIHMISyncMediaBrowserReply) throws MethodException {
        this.logger.log(1000000, "[%1.changeFolder]", (Object)LOGCLASS);
        this.setReplyService(aSIHMISyncMediaBrowserReply);
        this.dsiBrowserController.changeFolder(MediaUtilsSDIS.convertASIEntries2MediaEntries(mediaEntryArray));
    }

    public void addSelection(int n, MediaEntry mediaEntry, ASIHMISyncMediaBrowserReply aSIHMISyncMediaBrowserReply) throws MethodException {
        this.logger.log(1000000, "[%1.addSelection]", (Object)LOGCLASS);
        this.setReplyService(aSIHMISyncMediaBrowserReply);
        MediaListEntry mediaListEntry = MediaUtilsSDIS.convertMediaEntry2MediaListEntry(mediaEntry);
        this.dsiBrowserController.addSelection(true, n, mediaListEntry.getEntryID(), mediaListEntry.getContentType(), false);
    }

    public void requestList(int n, long l, int n2, int n3, ASIHMISyncMediaBrowserReply aSIHMISyncMediaBrowserReply) throws MethodException {
        this.logger.log(1000000, "[%1.requestList]", (Object)LOGCLASS);
        this.setReplyService(aSIHMISyncMediaBrowserReply);
        this.dsiBrowserController.requestList(l, n2, n, n3, 1);
    }

    public void browseSourceActivated() {
        this.logger.log(1000000, "[%1.browseSourceActivated]", (Object)LOGCLASS);
        try {
            this.updateActiveSlot(this.activeSourceSlot, true);
        }
        catch (MethodException methodException) {
            this.logger.log(10000, "[%1.browseSourceActivated]", (Object)LOGCLASS, (Throwable)methodException);
        }
    }

    public void browseSourceDeactivated() {
    }

    public void asyncException(int n, String string, int n2) {
        this.logger.log(1000000, "[%1.asyncException]", (Object)LOGCLASS);
    }

    public void updateBrowseFolder(MediaListEntry[] mediaListEntryArray) {
        this.logger.log(1000000, "[%1.updateBrowseFolder]", (Object)LOGCLASS);
        try {
            this.updateBrowseFolder(MediaUtilsSDIS.convert2ASIMediaEntries(mediaListEntryArray), true);
        }
        catch (MethodException methodException) {
            this.logger.log(10000, "[%1.updateBrowseFolder]", (Object)LOGCLASS, (Throwable)methodException);
        }
    }

    public void updateBrowseMode(int n) {
        this.logger.log(1000000, "[%1.updateBrowseMode]", (Object)LOGCLASS);
        this.dsiBrowserController.setContentFilter(7);
        try {
            this.updateBrowseMode(n, true);
        }
        catch (MethodException methodException) {
            this.logger.log(10000, "[%1.updateBrowseMode]", (Object)LOGCLASS, (Throwable)methodException);
        }
    }

    public void updateContentFilter(int n) {
        this.logger.log(1000000, "[%1.updateContentFilter]", (Object)LOGCLASS);
        this.dsiBrowserController.enableRecurseSubdirectories(true);
    }

    public void updateListSize(int n, int n2) {
        this.logger.log(1000000, "[%1.updateListSize]", (Object)LOGCLASS);
        try {
            this.updateListSize(n, true);
        }
        catch (MethodException methodException) {
            this.logger.log(10000, "[%1.updateListSize]", (Object)LOGCLASS, (Throwable)methodException);
        }
    }

    public void selectionResult(int n, int n2, boolean bl, long l, long l2, long l3, long l4, long l5) {
        this.logger.log(1000000, "[%1.selectionResult]", (Object)LOGCLASS);
        try {
            this.browserReply.responseAddSelection(0 == n);
        }
        catch (MethodException methodException) {
            this.logger.log(10000, "[%1.selectionResult]", (Object)LOGCLASS, (Throwable)methodException);
        }
    }

    public void errorFolderChange() {
        this.logger.log(1000000, "[%1.errorFolderChange]", (Object)LOGCLASS);
        try {
            this.browserReply.responseChangeFolder(false);
        }
        catch (MethodException methodException) {
            this.logger.log(10000, "[%1.errorFolderChange]", (Object)LOGCLASS, (Throwable)methodException);
        }
    }

    public void errorBrowseMode() {
        this.logger.log(1000000, "[%1.errorBrowseMode]", (Object)LOGCLASS);
    }

    public void errorSelection() {
        this.logger.log(1000000, "[%1.errorSelection]", (Object)LOGCLASS);
        try {
            this.browserReply.responseAddSelection(false);
        }
        catch (MethodException methodException) {
            this.logger.log(10000, "[%1.errorSelection]", (Object)LOGCLASS, (Throwable)methodException);
        }
    }

    public void slotsChanged(ISource iSource) {
        MediaFlags mediaFlags = iSource.getSlot(this.activeSourceSlot.getSlotIdx()).getFlags();
        MediaCapabilities mediaCapabilities = iSource.getSlot(this.activeSourceSlot.getSlotIdx()).getCapabilities();
        boolean bl = mediaFlags.isFilesystemSyncComplete();
        boolean bl2 = mediaFlags.isMetaDataSyncComplete();
        if (this.isFilesystemAvailable != bl && mediaCapabilities.isRawBrowsing()) {
            this.logger.log(1000000, "[%1.slotsChanged] Filesystem sync state changed to '%2'", (Object)LOGCLASS, (Object)String.valueOf(bl));
            try {
                this.updateRawMode(bl, true);
                this.isFilesystemAvailable = bl;
            }
            catch (MethodException methodException) {
                this.logger.log(10000, "[%1.slotsChanged]", (Object)LOGCLASS, (Throwable)methodException);
            }
        }
        if (this.isMetadataAvailable != bl2 && mediaCapabilities.isContentBrowsing()) {
            this.logger.log(1000000, "[%1.slotsChanged] Metadata sync state changed to '%2'", (Object)LOGCLASS, (Object)String.valueOf(bl2));
            try {
                this.updateDatabaseMode(bl2, true);
                this.isMetadataAvailable = bl2;
            }
            catch (MethodException methodException) {
                this.logger.log(10000, "[%1.slotsChanged]", (Object)LOGCLASS, (Throwable)methodException);
            }
        }
    }

    public int getClientID() {
        return 1;
    }

    public void responseList(MediaListEntry[] mediaListEntryArray, int n) {
        this.logger.log(1000000, "[%1.responseList]", (Object)LOGCLASS);
        try {
            this.browserReply.responseList(true, n, MediaUtilsSDIS.convert2ASIMediaEntries(mediaListEntryArray));
        }
        catch (MethodException methodException) {
            this.logger.log(10000, "[%1.responseList]", (Object)LOGCLASS, (Throwable)methodException);
        }
    }

    public void updateAlphabeticalIndex(CharacterInfo[] characterInfoArray) {
    }

    public void responsePickList(MediaListEntry[] mediaListEntryArray) {
    }

    public void errorListRequestAborted() {
        this.logger.log(1000000, "[%1.errorListRequestAborted]", (Object)LOGCLASS);
        try {
            this.browserReply.responseList(false, -1, new MediaEntry[0]);
        }
        catch (MethodException methodException) {
            this.logger.log(10000, "[%1.errorListRequestAborted]", (Object)LOGCLASS, (Throwable)methodException);
        }
    }

    public void errorPickListRequestAborted() {
    }

    private void setReplyService(ASIHMISyncMediaBrowserReply aSIHMISyncMediaBrowserReply) {
        if (null == aSIHMISyncMediaBrowserReply) {
            this.browserReply = this.nullBrowserReply;
        }
        this.browserReply = aSIHMISyncMediaBrowserReply;
    }

    public void browseSourceInvalidated() {
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    private final class NullASIHMISyncMediaBrowserReply
    implements ASIHMISyncMediaBrowserReply {
        private NullASIHMISyncMediaBrowserReply() {
        }

        public void responseChangeFolder(boolean bl) throws MethodException {
        }

        public void responseAddSelection(boolean bl) throws MethodException {
        }

        public void responseList(boolean bl, int n, MediaEntry[] mediaEntryArray) throws MethodException {
        }

        public void updateASIVersion(String string, boolean bl) throws MethodException {
        }

        public void updateActiveSlot(MediaSourceSlot mediaSourceSlot, boolean bl) throws MethodException {
        }

        public void updateBrowseMode(int n, boolean bl) throws MethodException {
        }

        public void updateDatabaseMode(boolean bl, boolean bl2) throws MethodException {
        }

        public void updateRawMode(boolean bl, boolean bl2) throws MethodException {
        }

        public void updateBrowseFolder(MediaEntry[] mediaEntryArray, boolean bl) throws MethodException {
        }

        public void updateListSize(int n, boolean bl) throws MethodException {
        }

        public void updateRequestIDs(short[] sArray, boolean bl) throws MethodException {
        }

        public void updateReplyIDs(short[] sArray, boolean bl) throws MethodException {
        }
    }
}

