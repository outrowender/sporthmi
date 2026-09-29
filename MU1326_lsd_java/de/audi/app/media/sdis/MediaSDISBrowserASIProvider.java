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
import de.audi.app.media.sdis.MediaSDISBrowserASIProvider$NullASIHMISyncMediaBrowserReply;
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
    private static final String LOGCLASS;
    protected static final int CLIENT_ID;
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
        this.browserReply = this.nullBrowserReply = new MediaSDISBrowserASIProvider$NullASIHMISyncMediaBrowserReply(this, null);
        try {
            this.updateASIVersion("2.2.00");
            this.updateRequestIDs(new short[]{3, 4, 5, 12, 13, 14, 0, 1, 2, 6, 7, 11});
            this.updateReplyIDs(new short[]{8, 9, 10, 16, 15, 17, 18, 19, 20, 21, 22, 23});
        }
        catch (MethodException methodException) {
            this.logger.log(10000, "[%1.MediaSDISBrowserASIProvider] - could not register ASI version!", (Object)"MediaSDISBrowserASIProvider", (Throwable)methodException);
        }
    }

    public void init() {
        this.logger.log(1078071040, "[%1.init]", (Object)"MediaSDISBrowserASIProvider");
        this.dsiBrowserController.init();
        this.dsiBrowserController.setBrowserListener(this);
        this.dsiBrowserController.setBrowserStateListener(this);
        this.dsiBrowserController.setStateListener(this);
        this.dsiBrowserController.startDSI();
    }

    public void deinit() {
        this.logger.log(1078071040, "[%1.deinit]", (Object)"MediaSDISBrowserASIProvider");
        this.dsiBrowserController.deinit();
        if (null != this.registerService) {
            this.terminal.getServiceManager().unregisterService(this.registerService);
            this.registerService = null;
        }
    }

    @Override
    public void dsiAvailable() {
        this.logger.log(1078071040, "[%1.dsiAvailable]", (Object)"MediaSDISBrowserASIProvider");
        this.registerService = this.terminal.getServiceManager().registerService(class$de$audi$atip$agent$IASIProvider == null ? (class$de$audi$atip$agent$IASIProvider = MediaSDISBrowserASIProvider.class$("de.audi.atip.agent.IASIProvider")) : class$de$audi$atip$agent$IASIProvider, this, new Hashtable(0));
    }

    @Override
    public void dsiUnavailable() {
        this.logger.log(1078071040, "[%1.dsiUnavailable]", (Object)"MediaSDISBrowserASIProvider");
        if (null != this.registerService) {
            this.terminal.getServiceManager().unregisterService(this.registerService);
            this.registerService = null;
        }
        this.isFilesystemAvailable = false;
        this.isMetadataAvailable = false;
    }

    @Override
    public IService getService() {
        return this.asiMediaBrowser;
    }

    @Override
    public void attachStub(IStub iStub) {
        this.logger.log(1078071040, "[%1.attachStub] '%2'", (Object)"MediaSDISBrowserASIProvider", (Object)iStub);
    }

    @Override
    public void detachStub(IStub iStub) {
        this.logger.log(1078071040, "[%1.detachStub] '%2'", (Object)"MediaSDISBrowserASIProvider", (Object)iStub);
    }

    @Override
    public void activate(MediaSourceSlot mediaSourceSlot, ASIHMISyncMediaBrowserReply aSIHMISyncMediaBrowserReply) {
        this.logger.log(1078071040, "[%1.activate]", (Object)"MediaSDISBrowserASIProvider");
        this.setReplyService(aSIHMISyncMediaBrowserReply);
        de.audi.app.media.source.MediaSourceSlot mediaSourceSlot2 = MediaUtilsSDIS.get2DSISourceSlot(mediaSourceSlot, this.terminal.getSourceController());
        this.dsiBrowserController.activate(mediaSourceSlot2);
        this.dsiBrowserController.addBrowserListListener(this);
        this.activeSourceSlot = mediaSourceSlot;
        this.isFilesystemAvailable = false;
        this.isMetadataAvailable = false;
        this.terminal.getSourceController().addSourceSlotListener(mediaSourceSlot2.getSource(), this, true);
    }

    @Override
    public void deactivate(ASIHMISyncMediaBrowserReply aSIHMISyncMediaBrowserReply) {
        this.logger.log(1078071040, "[%1.deactivate]", (Object)"MediaSDISBrowserASIProvider");
        this.setReplyService(aSIHMISyncMediaBrowserReply);
        this.dsiBrowserController.removeAllBrowserListListener();
        this.isFilesystemAvailable = false;
        this.isMetadataAvailable = false;
        this.dsiBrowserController.deactivate();
    }

    @Override
    public void setBrowseMode(int n, ASIHMISyncMediaBrowserReply aSIHMISyncMediaBrowserReply) {
        this.logger.log(1078071040, "[%1.setBrowseMode]", (Object)"MediaSDISBrowserASIProvider");
        this.setReplyService(aSIHMISyncMediaBrowserReply);
        this.dsiBrowserController.setBrowseMode(n);
    }

    @Override
    public void changeFolder(MediaEntry[] mediaEntryArray, ASIHMISyncMediaBrowserReply aSIHMISyncMediaBrowserReply) {
        this.logger.log(1078071040, "[%1.changeFolder]", (Object)"MediaSDISBrowserASIProvider");
        this.setReplyService(aSIHMISyncMediaBrowserReply);
        this.dsiBrowserController.changeFolder(MediaUtilsSDIS.convertASIEntries2MediaEntries(mediaEntryArray));
    }

    @Override
    public void addSelection(int n, MediaEntry mediaEntry, ASIHMISyncMediaBrowserReply aSIHMISyncMediaBrowserReply) {
        this.logger.log(1078071040, "[%1.addSelection]", (Object)"MediaSDISBrowserASIProvider");
        this.setReplyService(aSIHMISyncMediaBrowserReply);
        MediaListEntry mediaListEntry = MediaUtilsSDIS.convertMediaEntry2MediaListEntry(mediaEntry);
        this.dsiBrowserController.addSelection(true, n, mediaListEntry.getEntryID(), mediaListEntry.getContentType(), false);
    }

    @Override
    public void requestList(int n, long l, int n2, int n3, ASIHMISyncMediaBrowserReply aSIHMISyncMediaBrowserReply) {
        this.logger.log(1078071040, "[%1.requestList]", (Object)"MediaSDISBrowserASIProvider");
        this.setReplyService(aSIHMISyncMediaBrowserReply);
        this.dsiBrowserController.requestList(l, n2, n, n3, 1);
    }

    @Override
    public void browseSourceActivated() {
        this.logger.log(1078071040, "[%1.browseSourceActivated]", (Object)"MediaSDISBrowserASIProvider");
        try {
            this.updateActiveSlot(this.activeSourceSlot, true);
        }
        catch (MethodException methodException) {
            this.logger.log(10000, "[%1.browseSourceActivated]", (Object)"MediaSDISBrowserASIProvider", (Throwable)methodException);
        }
    }

    @Override
    public void browseSourceDeactivated() {
    }

    @Override
    public void asyncException(int n, String string, int n2) {
        this.logger.log(1078071040, "[%1.asyncException]", (Object)"MediaSDISBrowserASIProvider");
    }

    @Override
    public void updateBrowseFolder(MediaListEntry[] mediaListEntryArray) {
        this.logger.log(1078071040, "[%1.updateBrowseFolder]", (Object)"MediaSDISBrowserASIProvider");
        try {
            this.updateBrowseFolder(MediaUtilsSDIS.convert2ASIMediaEntries(mediaListEntryArray), true);
        }
        catch (MethodException methodException) {
            this.logger.log(10000, "[%1.updateBrowseFolder]", (Object)"MediaSDISBrowserASIProvider", (Throwable)methodException);
        }
    }

    @Override
    public void updateBrowseMode(int n) {
        this.logger.log(1078071040, "[%1.updateBrowseMode]", (Object)"MediaSDISBrowserASIProvider");
        this.dsiBrowserController.setContentFilter(7);
        try {
            this.updateBrowseMode(n, true);
        }
        catch (MethodException methodException) {
            this.logger.log(10000, "[%1.updateBrowseMode]", (Object)"MediaSDISBrowserASIProvider", (Throwable)methodException);
        }
    }

    @Override
    public void updateContentFilter(int n) {
        this.logger.log(1078071040, "[%1.updateContentFilter]", (Object)"MediaSDISBrowserASIProvider");
        this.dsiBrowserController.enableRecurseSubdirectories(true);
    }

    @Override
    public void updateListSize(int n, int n2) {
        this.logger.log(1078071040, "[%1.updateListSize]", (Object)"MediaSDISBrowserASIProvider");
        try {
            this.updateListSize(n, true);
        }
        catch (MethodException methodException) {
            this.logger.log(10000, "[%1.updateListSize]", (Object)"MediaSDISBrowserASIProvider", (Throwable)methodException);
        }
    }

    @Override
    public void selectionResult(int n, int n2, boolean bl, long l, long l2, long l3, long l4, long l5) {
        this.logger.log(1078071040, "[%1.selectionResult]", (Object)"MediaSDISBrowserASIProvider");
        try {
            this.browserReply.responseAddSelection(0 == n);
        }
        catch (MethodException methodException) {
            this.logger.log(10000, "[%1.selectionResult]", (Object)"MediaSDISBrowserASIProvider", (Throwable)methodException);
        }
    }

    @Override
    public void errorFolderChange() {
        this.logger.log(1078071040, "[%1.errorFolderChange]", (Object)"MediaSDISBrowserASIProvider");
        try {
            this.browserReply.responseChangeFolder(false);
        }
        catch (MethodException methodException) {
            this.logger.log(10000, "[%1.errorFolderChange]", (Object)"MediaSDISBrowserASIProvider", (Throwable)methodException);
        }
    }

    @Override
    public void errorBrowseMode() {
        this.logger.log(1078071040, "[%1.errorBrowseMode]", (Object)"MediaSDISBrowserASIProvider");
    }

    @Override
    public void errorSelection() {
        this.logger.log(1078071040, "[%1.errorSelection]", (Object)"MediaSDISBrowserASIProvider");
        try {
            this.browserReply.responseAddSelection(false);
        }
        catch (MethodException methodException) {
            this.logger.log(10000, "[%1.errorSelection]", (Object)"MediaSDISBrowserASIProvider", (Throwable)methodException);
        }
    }

    @Override
    public void slotsChanged(ISource iSource) {
        MediaFlags mediaFlags = iSource.getSlot(this.activeSourceSlot.getSlotIdx()).getFlags();
        MediaCapabilities mediaCapabilities = iSource.getSlot(this.activeSourceSlot.getSlotIdx()).getCapabilities();
        boolean bl = mediaFlags.isFilesystemSyncComplete();
        boolean bl2 = mediaFlags.isMetaDataSyncComplete();
        if (this.isFilesystemAvailable != bl && mediaCapabilities.isRawBrowsing()) {
            this.logger.log(1078071040, "[%1.slotsChanged] Filesystem sync state changed to '%2'", (Object)"MediaSDISBrowserASIProvider", (Object)String.valueOf(bl));
            try {
                this.updateRawMode(bl, true);
                this.isFilesystemAvailable = bl;
            }
            catch (MethodException methodException) {
                this.logger.log(10000, "[%1.slotsChanged]", (Object)"MediaSDISBrowserASIProvider", (Throwable)methodException);
            }
        }
        if (this.isMetadataAvailable != bl2 && mediaCapabilities.isContentBrowsing()) {
            this.logger.log(1078071040, "[%1.slotsChanged] Metadata sync state changed to '%2'", (Object)"MediaSDISBrowserASIProvider", (Object)String.valueOf(bl2));
            try {
                this.updateDatabaseMode(bl2, true);
                this.isMetadataAvailable = bl2;
            }
            catch (MethodException methodException) {
                this.logger.log(10000, "[%1.slotsChanged]", (Object)"MediaSDISBrowserASIProvider", (Throwable)methodException);
            }
        }
    }

    @Override
    public int getClientID() {
        return 1;
    }

    @Override
    public void responseList(MediaListEntry[] mediaListEntryArray, int n) {
        this.logger.log(1078071040, "[%1.responseList]", (Object)"MediaSDISBrowserASIProvider");
        try {
            this.browserReply.responseList(true, n, MediaUtilsSDIS.convert2ASIMediaEntries(mediaListEntryArray));
        }
        catch (MethodException methodException) {
            this.logger.log(10000, "[%1.responseList]", (Object)"MediaSDISBrowserASIProvider", (Throwable)methodException);
        }
    }

    @Override
    public void updateAlphabeticalIndex(CharacterInfo[] characterInfoArray) {
    }

    @Override
    public void responsePickList(MediaListEntry[] mediaListEntryArray) {
    }

    @Override
    public void errorListRequestAborted() {
        this.logger.log(1078071040, "[%1.errorListRequestAborted]", (Object)"MediaSDISBrowserASIProvider");
        try {
            this.browserReply.responseList(false, -1, new MediaEntry[0]);
        }
        catch (MethodException methodException) {
            this.logger.log(10000, "[%1.errorListRequestAborted]", (Object)"MediaSDISBrowserASIProvider", (Throwable)methodException);
        }
    }

    @Override
    public void errorPickListRequestAborted() {
    }

    private void setReplyService(ASIHMISyncMediaBrowserReply aSIHMISyncMediaBrowserReply) {
        if (null == aSIHMISyncMediaBrowserReply) {
            this.browserReply = this.nullBrowserReply;
        }
        this.browserReply = aSIHMISyncMediaBrowserReply;
    }

    @Override
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
}

