/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.sds.g2p;

import de.audi.app.media.AbstractMediaTerminalComponent;
import de.audi.app.media.IMediaTerminal;
import de.audi.app.media.content.IDataBrowserLastSelectionHandler;
import de.audi.app.media.content.media.IPlayer;
import de.audi.app.media.content.media.utils.MediaUtils;
import de.audi.app.media.dsi.media.MediaListEntry;
import de.audi.app.media.sds.ISDSCommandListener;
import de.audi.app.media.sds.g2p.G2PCallbackHandler;
import de.audi.app.media.selection.DataSelectionByCategoryJob;
import de.audi.app.media.selection.DataSelectionContainer;
import de.audi.app.media.selection.IDataSelectionContext;
import de.audi.app.media.selection.IPickListListener;
import de.audi.app.media.selection.ISelectionListener;
import de.audi.app.media.selection.RequestPickListByCategoryJob;
import de.audi.app.media.selection.SelectionBrowser;
import de.audi.app.media.source.ISource;
import de.audi.app.media.source.ISourceSlot;
import de.audi.app.media.source.ISourceSlotListener;
import de.audi.atip.interapp.media.MediaCoverartEntry;
import de.audi.atip.util.Util;
import de.esolutions.fw.util.commons.Buffer;
import java.util.Map;

public class DataG2PController
extends AbstractMediaTerminalComponent
implements ISDSCommandListener,
ISourceSlotListener,
ISelectionListener,
IPickListListener {
    private static final String LOGCLASS;
    private static final MediaCoverartEntry[] NO_COVERARTS;
    protected static final int STARTUP_STATE_UNDEFINED;
    protected static final int STARTUP_STATE_WAITFOR_SYNC_ACTIVESLOT;
    protected static final int STARTUP_STATE_SYNC_ACTIVESLOT_COMPLETE;
    protected static final int STARTUP_FINISHED;
    private final IPlayer player;
    private final G2PCallbackHandler g2pCallbackHandler;
    private final SelectionBrowser selectionBrowser;
    private ISourceSlot activeSlot;
    public static final Integer SDS_RET_SUCCESS;
    public static final Integer SDS_RET_FAILED;
    private static final String SDS_COMMAND_KEY;
    final IDataBrowserLastSelectionHandler lastSelectionHandler;

    public DataG2PController(IMediaTerminal iMediaTerminal, IPlayer iPlayer, IDataBrowserLastSelectionHandler iDataBrowserLastSelectionHandler) {
        super(iMediaTerminal);
        this.player = iPlayer;
        this.g2pCallbackHandler = new G2PCallbackHandler(iMediaTerminal, this.logger.sds());
        this.lastSelectionHandler = iDataBrowserLastSelectionHandler;
        this.selectionBrowser = iMediaTerminal.getSelectionBrowser();
    }

    public void init() {
        this.logger.sds().log(1078071040, "[%1.init]", (Object)"DataG2PController");
        this.g2pCallbackHandler.init();
    }

    public void deinit() {
        this.logger.sds().log(1078071040, "[%1.deinit]", (Object)"DataG2PController");
        this.g2pCallbackHandler.deinit();
    }

    public void activate(ISourceSlot iSourceSlot) {
        this.logger.sds().log(1078071040, "[%1.activate]", (Object)"DataG2PController");
        if (!MediaUtils.isDefaultSyncSource(iSourceSlot.getSource().getType())) {
            this.logger.sds().log(1078071040, "[%1.activate] No sync source. Ignore.", (Object)"DataG2PController");
            return;
        }
        this.activeSlot = iSourceSlot;
        this.setStartupState(1);
    }

    public void deactivate() {
        this.logger.sds().log(1078071040, "[%1.resetController] Reset.", (Object)"DataG2PController");
        if (this.activeSlot == null) {
            this.logger.sds().log(1078071040, "[%1.resetController] already resetted. Ignore.", (Object)"DataG2PController");
            return;
        }
        this.getTerminal().getSDSDispatcher().removeCommandListener(this.getTerminal().getTerminalID(), this);
        this.activeSlot.getSource().removeSlotListener(this);
        this.activeSlot = null;
    }

    protected void setStartupState(int n) {
        switch (n) {
            case 0: {
                this.logger.sds().log(1078071040, "[%1.setStartupState] STARTUP_STATE_UNDEFINED.", (Object)"DataG2PController");
                break;
            }
            case 1: {
                this.logger.sds().log(1078071040, "[%1.setStartupState] STARTUP_STATE_WAITFOR_SYNC_ACTIVESLOT.", (Object)"DataG2PController");
                this.activeSlot.getSource().addSlotListener(this, true);
                break;
            }
            case 2: {
                this.logger.sds().log(1078071040, "[%1.setStartupState] STARTUP_STATE_SYNC_ACTIVESLOT_COMPLETE.", (Object)"DataG2PController");
                this.setStartupState(3);
                break;
            }
            case 3: {
                this.logger.sds().log(1078071040, "[%1.setStartupState] STARTUP_FINISHED.", (Object)"DataG2PController");
                this.getTerminal().getSDSDispatcher().addCommandListener(this.getTerminal().getTerminalID(), this);
                break;
            }
            default: {
                this.logger.sds().log(1078071040, "[%1.setStartupState] Wrong state '%2'.", (Object)"DataG2PController", (long)n);
            }
        }
    }

    @Override
    public int[] getCommandIDs() {
        return new int[]{10001, 10002, 10003, 10005, 10006, 10007, 10008, 10004, 10009};
    }

    @Override
    public Object performCommand(int n, Map map) {
        switch (n) {
            case 10001: {
                this.logger.sds().log(1078071040, "[%1.performCommand] SDS_COMMAND_DATA_G2P_PLAY_TITLE", (Object)"DataG2PController");
                Long l = (Long)map.get("TITLEID");
                if (l == null) {
                    return SDS_RET_FAILED;
                }
                MediaListEntry mediaListEntry = new MediaListEntry(l, 1, "");
                DataSelectionContainer dataSelectionContainer = new DataSelectionContainer(this.activeSlot, mediaListEntry, 2, new MediaListEntry[0]);
                dataSelectionContainer.addParameter("SDS_COMMAND_KEY", new Integer(10001));
                DataSelectionByCategoryJob dataSelectionByCategoryJob = new DataSelectionByCategoryJob(this.logger.sds(), this.selectionBrowser, dataSelectionContainer, this.player);
                this.selectionBrowser.addSelectionListener(this);
                this.selectionBrowser.enqueueSelectionJob(dataSelectionByCategoryJob);
                break;
            }
            case 10002: {
                this.logger.sds().log(1078071040, "[%1.performCommand] SDS_COMMAND_DATA_G2P_PLAY_ALBUM", (Object)"DataG2PController");
                Long l = (Long)map.get("ALBUMID");
                if (l == null) {
                    return SDS_RET_FAILED;
                }
                MediaListEntry[] mediaListEntryArray = new MediaListEntry[]{new MediaListEntry(l, 14, "")};
                DataSelectionContainer dataSelectionContainer = new DataSelectionContainer(this.activeSlot, null, 3, mediaListEntryArray);
                dataSelectionContainer.addParameter("SDS_COMMAND_KEY", new Integer(10002));
                DataSelectionByCategoryJob dataSelectionByCategoryJob = new DataSelectionByCategoryJob(this.logger.sds(), this.selectionBrowser, dataSelectionContainer, this.player);
                this.selectionBrowser.addSelectionListener(this);
                this.selectionBrowser.enqueueSelectionJob(dataSelectionByCategoryJob);
                break;
            }
            case 10003: {
                this.logger.sds().log(1078071040, "[%1.performAction] SDS_COMMAND_DATA_G2P_PLAY_ARTIST", (Object)"DataG2PController");
                Long l = (Long)map.get("ARTISTID");
                if (l == null) {
                    return SDS_RET_FAILED;
                }
                MediaListEntry[] mediaListEntryArray = new MediaListEntry[]{new MediaListEntry(l, 13, "")};
                DataSelectionContainer dataSelectionContainer = new DataSelectionContainer(this.activeSlot, null, 4, mediaListEntryArray);
                dataSelectionContainer.addParameter("SDS_COMMAND_KEY", new Integer(10003));
                DataSelectionByCategoryJob dataSelectionByCategoryJob = new DataSelectionByCategoryJob(this.logger.sds(), this.selectionBrowser, dataSelectionContainer, this.player);
                this.selectionBrowser.addSelectionListener(this);
                this.selectionBrowser.enqueueSelectionJob(dataSelectionByCategoryJob);
                break;
            }
            case 10005: {
                this.logger.sds().log(1078071040, "[%1.performAction] SDS_COMMAND_DATA_G2P_PLAY_GENRE", (Object)"DataG2PController");
                Long l = (Long)map.get("GENREID");
                if (l == null) {
                    return SDS_RET_FAILED;
                }
                MediaListEntry[] mediaListEntryArray = new MediaListEntry[]{new MediaListEntry(l, 16, "")};
                DataSelectionContainer dataSelectionContainer = new DataSelectionContainer(this.activeSlot, null, 5, mediaListEntryArray);
                dataSelectionContainer.addParameter("SDS_COMMAND_KEY", new Integer(10005));
                DataSelectionByCategoryJob dataSelectionByCategoryJob = new DataSelectionByCategoryJob(this.logger.sds(), this.selectionBrowser, dataSelectionContainer, this.player);
                this.selectionBrowser.addSelectionListener(this);
                this.selectionBrowser.enqueueSelectionJob(dataSelectionByCategoryJob);
                break;
            }
            case 10006: {
                this.logger.sds().log(1078071040, "[%1.performCommand] SDS_COMMAND_DATA_G2P_PLAY_TITLE_OF_ALBUM", (Object)"DataG2PController");
                Long l = (Long)map.get("ALBUMID");
                Long l2 = (Long)map.get("TITLEID");
                if (l == null || l2 == null) {
                    return SDS_RET_FAILED;
                }
                MediaListEntry[] mediaListEntryArray = new MediaListEntry[]{new MediaListEntry(l, 14, "")};
                MediaListEntry mediaListEntry = new MediaListEntry(l2, 1, "");
                DataSelectionContainer dataSelectionContainer = new DataSelectionContainer(this.activeSlot, mediaListEntry, 3, mediaListEntryArray);
                dataSelectionContainer.addParameter("SDS_COMMAND_KEY", new Integer(10006));
                DataSelectionByCategoryJob dataSelectionByCategoryJob = new DataSelectionByCategoryJob(this.logger.sds(), this.selectionBrowser, dataSelectionContainer, this.player);
                this.selectionBrowser.addSelectionListener(this);
                this.selectionBrowser.enqueueSelectionJob(dataSelectionByCategoryJob);
                break;
            }
            case 10007: {
                this.logger.sds().log(1078071040, "[%1.performAction] SDS_COMMAND_DATA_G2P_PLAY_TITLE_OF_ARTIST", (Object)"DataG2PController");
                Long l = (Long)map.get("ARTISTID");
                Long l3 = (Long)map.get("TITLEID");
                if (l == null || l3 == null) {
                    return SDS_RET_FAILED;
                }
                MediaListEntry[] mediaListEntryArray = new MediaListEntry[]{new MediaListEntry(l, 13, "")};
                MediaListEntry mediaListEntry = new MediaListEntry(l3, 1, "");
                DataSelectionContainer dataSelectionContainer = new DataSelectionContainer(this.activeSlot, mediaListEntry, 4, mediaListEntryArray);
                dataSelectionContainer.addParameter("SDS_COMMAND_KEY", new Integer(10007));
                DataSelectionByCategoryJob dataSelectionByCategoryJob = new DataSelectionByCategoryJob(this.logger.sds(), this.selectionBrowser, dataSelectionContainer, this.player);
                this.selectionBrowser.addSelectionListener(this);
                this.selectionBrowser.enqueueSelectionJob(dataSelectionByCategoryJob);
                break;
            }
            case 10008: {
                this.logger.sds().log(1078071040, "[%1.performAction] SDS_COMMAND_DATA_G2P_PLAY_ALBUM_OF_ARTIST", (Object)"DataG2PController");
                Long l = (Long)map.get("ARTISTID");
                Long l4 = (Long)map.get("ALBUMID");
                if (l == null || l4 == null) {
                    return SDS_RET_FAILED;
                }
                MediaListEntry[] mediaListEntryArray = new MediaListEntry[]{new MediaListEntry(l, 13, ""), new MediaListEntry(l4, 14, "")};
                DataSelectionContainer dataSelectionContainer = new DataSelectionContainer(this.activeSlot, null, 4, mediaListEntryArray);
                dataSelectionContainer.addParameter("SDS_COMMAND_KEY", new Integer(10008));
                DataSelectionByCategoryJob dataSelectionByCategoryJob = new DataSelectionByCategoryJob(this.logger.sds(), this.selectionBrowser, dataSelectionContainer, this.player);
                this.selectionBrowser.addSelectionListener(this);
                this.selectionBrowser.enqueueSelectionJob(dataSelectionByCategoryJob);
                break;
            }
            case 10004: {
                this.logger.sds().log(1078071040, "[%1.performAction] SDS_COMMAND_DATA_G2P_REQUEST_COVERART", (Object)"DataG2PController");
                Integer n2 = (Integer)map.get("LISTMODE");
                Object[] objectArray = (Object[])map.get("ENTRYIDS");
                if (null == n2 || null == objectArray) {
                    return SDS_RET_FAILED;
                }
                int n3 = DataG2PController.getBrowserCategory(n2);
                if (n3 == 0) {
                    this.logger.sds().log(1078071040, "[%1.performAction] SDS_COMMAND_DATA_G2P_REQUEST_COVERART unknown picklist category='%2'", (Object)"DataG2PController", (Object)n2);
                    return SDS_RET_FAILED;
                }
                if (24 == this.activeSlot.getMediaType()) {
                    this.responsePicklist(new MediaListEntry[0], true);
                    return SDS_RET_SUCCESS;
                }
                long[] lArray = new long[objectArray.length];
                for (int i2 = 0; i2 < objectArray.length; ++i2) {
                    lArray[i2] = (Long)objectArray[i2];
                }
                DataSelectionContainer dataSelectionContainer = new DataSelectionContainer(this.activeSlot, null, n3, new MediaListEntry[0]);
                dataSelectionContainer.addParameter("KEY_PICKLIST_LISTENER", this);
                dataSelectionContainer.addParameter("KEY_PICKLIST_ENTRIES", lArray);
                RequestPickListByCategoryJob requestPickListByCategoryJob = new RequestPickListByCategoryJob(this.logger.sds(), this.selectionBrowser, dataSelectionContainer, this.player);
                this.selectionBrowser.enqueueSelectionJob(requestPickListByCategoryJob);
                break;
            }
            case 10009: {
                this.logger.sds().log(1078071040, "[%1.performCommand] SDS_PLAY_ALL_TRACKS", (Object)"DataG2PController");
                if (24 != this.activeSlot.getMediaType() || !this.getTerminal().getConfiguration().isIAP2Supported()) {
                    this.logger.sds().log(-1601830656, "[%1.performCommand] SDS_PLAY_ALL_TRACKS - FAILED. The command is only supported for iPod with iAP2 support.", (Object)"DataG2PController");
                    return SDS_RET_FAILED;
                }
                MediaListEntry mediaListEntry = new MediaListEntry(0L, 1, "");
                DataSelectionContainer dataSelectionContainer = new DataSelectionContainer(this.getTerminal().getSourceController().getSelectedSlot(), mediaListEntry, 2, new MediaListEntry[0]);
                dataSelectionContainer.addParameter("SDS_COMMAND_KEY", new Integer(10009));
                SelectionBrowser selectionBrowser = this.getTerminal().getSelectionBrowser();
                selectionBrowser.addSelectionListener(this);
                DataSelectionByCategoryJob dataSelectionByCategoryJob = new DataSelectionByCategoryJob(this.logger.main(), selectionBrowser, dataSelectionContainer, this.player);
                dataSelectionByCategoryJob.useSelectionRangeIndex = false;
                selectionBrowser.enqueueSelectionJob(dataSelectionByCategoryJob);
                break;
            }
        }
        return SDS_RET_SUCCESS;
    }

    @Override
    public void slotsChanged(ISource iSource) {
        if (this.activeSlot == null) {
            return;
        }
        if (this.activeSlot.getSource().getType() != iSource.getType()) {
            this.logger.sds().log(-1601830656, "[%1.slotsChanged] sourcetype of active slot is not the same of source.", (Object)"DataG2PController");
            return;
        }
        if (iSource.getSlot(this.activeSlot).getFlags().isMetaDataSyncComplete()) {
            this.logger.sds().log(1078071040, "[%1.slotsChanged] Meta data sync complete.", (Object)"DataG2PController");
            iSource.removeSlotListener(this);
            if (iSource.getSlot(this.activeSlot).getCapabilities().isContentBrowsing()) {
                this.logger.sds().log(1078071040, "[%1.slotsChanged] Content Browsing possible", (Object)"DataG2PController");
                this.setStartupState(2);
            } else {
                this.logger.sds().log(1078071040, "[%1.slotsChanged] Content Browsing not possible. Stop Startup", (Object)"DataG2PController");
                this.activeSlot = null;
                this.setStartupState(0);
            }
        } else {
            this.logger.sds().log(1078071040, "[%1.slotsChanged] Meta data sync not complete.", (Object)"DataG2PController");
        }
    }

    public String toString() {
        Buffer buffer = new Buffer(20);
        buffer.append("DataG2PController").append("@").append(this.hashCode());
        return buffer.toString();
    }

    @Override
    public void notifySelectionChanged(IDataSelectionContext iDataSelectionContext, boolean bl) {
        boolean bl2;
        this.selectionBrowser.removeSelectionListener(this);
        Integer n = (Integer)iDataSelectionContext.getParameter("SDS_COMMAND_KEY", null);
        byte by = bl ? (byte)0 : 1;
        boolean bl3 = bl2 = !this.getTerminal().getConfiguration().isIAP2Supported() || this.getTerminal().getSourceController().getActivationContext().getSlot().getMediaType() != 24 || iDataSelectionContext.getBrowserCategory() != 2;
        if (bl && bl2) {
            this.lastSelectionHandler.setLastCategorySelection(iDataSelectionContext.getBrowserCategory());
        }
        if (bl && !bl2) {
            this.lastSelectionHandler.setSelectedCategory(2);
        }
        switch (n) {
            case 10001: {
                this.g2pCallbackHandler.g2pPlayTitleResult(by);
                break;
            }
            case 10002: {
                this.g2pCallbackHandler.g2pPlayAlbumResult(by);
                break;
            }
            case 10003: {
                this.g2pCallbackHandler.g2pPlayArtistResult(by);
                break;
            }
            case 10005: {
                this.g2pCallbackHandler.g2pPlayGenreResult(by);
                break;
            }
            case 10006: {
                this.g2pCallbackHandler.g2pPlayTitleOfAlbumResult(by);
                break;
            }
            case 10007: {
                this.g2pCallbackHandler.g2pPlayTitleOfArtistResult(by);
                break;
            }
            case 10008: {
                this.g2pCallbackHandler.g2pPlayAlbumOfArtistResult(by);
                break;
            }
            case 10009: {
                this.g2pCallbackHandler.playAllTracksResult(by);
                break;
            }
            default: {
                this.logger.sds().log(1078071040, "[%1.notifySelectionChanged] unknwown Command.", (Object)"DataG2PController");
            }
        }
    }

    @Override
    public void responsePicklist(MediaListEntry[] mediaListEntryArray, boolean bl) {
        if (!bl || mediaListEntryArray.length == 0) {
            this.g2pCallbackHandler.responseG2PRequestCoverarts((byte)1, NO_COVERARTS);
        } else {
            MediaCoverartEntry[] mediaCoverartEntryArray = new MediaCoverartEntry[mediaListEntryArray.length];
            for (int i2 = 0; i2 < mediaListEntryArray.length; ++i2) {
                mediaCoverartEntryArray[i2] = new MediaCoverartEntry(mediaListEntryArray[i2].getEntryID(), mediaListEntryArray[i2].getCovertArt());
            }
            this.logger.sds().log(1078071040, "[%1.responsePicklist] successful.", (Object)"DataG2PController");
            this.g2pCallbackHandler.responseG2PRequestCoverarts((byte)0, mediaCoverartEntryArray);
        }
    }

    private static int getBrowserCategory(int n) {
        int n2;
        switch (n) {
            case 4: {
                n2 = 5;
                break;
            }
            case 1: {
                n2 = 3;
                break;
            }
            case 2: {
                n2 = 4;
                break;
            }
            case 3: {
                n2 = 2;
                break;
            }
            default: {
                n2 = 0;
            }
        }
        return n2;
    }

    static {
        NO_COVERARTS = new MediaCoverartEntry[0];
        SDS_RET_SUCCESS = Util.createInteger(0);
        SDS_RET_FAILED = Util.createInteger(-1);
    }
}

