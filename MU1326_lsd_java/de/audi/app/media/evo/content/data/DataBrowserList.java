/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.evo.content.data;

import de.audi.app.media.IMediaTerminal;
import de.audi.app.media.actionproxy.IActionProxyListener;
import de.audi.app.media.browser.IBrowseListContext;
import de.audi.app.media.content.IDataBrowserLastSelectionHandler;
import de.audi.app.media.content.media.AbstractMediaBrowserList;
import de.audi.app.media.content.media.AbstractMediaBrowserListRow;
import de.audi.app.media.content.media.IPlayer;
import de.audi.app.media.content.media.IPlayerSelectionRequest;
import de.audi.app.media.content.media.IPlayerTrackListener;
import de.audi.app.media.content.media.IProgressIndication;
import de.audi.app.media.content.media.ListRequest;
import de.audi.app.media.content.media.MediaDetailInfo;
import de.audi.app.media.content.media.PlayTime;
import de.audi.app.media.content.media.PlayingTrack;
import de.audi.app.media.content.media.ProgressIndicationImpl;
import de.audi.app.media.content.media.utils.MediaUtils;
import de.audi.app.media.dsi.media.MediaListEntry;
import de.audi.app.media.evo.content.IImplicitRepeatHandler;
import de.audi.app.media.evo.content.data.AbstractDataBrowseListJob;
import de.audi.app.media.evo.content.data.DataBrowserListElement;
import de.audi.app.media.evo.content.data.DataBrowserListJobAddSelection;
import de.audi.app.media.evo.content.data.DataBrowserListJobDefault;
import de.audi.app.media.evo.content.data.DataBrowserListJobRepeatFolderSelection;
import de.audi.app.media.evo.content.data.DataBrowserListJobSelectBrowseListPath;
import de.audi.app.media.evo.content.data.DataBrowserListLocator;
import de.audi.app.media.evo.content.data.DataBrowserListRow;
import de.audi.app.media.evo.content.data.DataBrowserListSelectionData;
import de.audi.app.media.evo.content.data.DataPlayer;
import de.audi.app.media.evo.content.data.IDataBrowserList;
import de.audi.app.media.evo.content.data.IDataBrowserListChangeListener;
import de.audi.app.media.evo.content.data.SDSDataBrowserCommandHandler;
import de.audi.app.media.evo.transfer.IEvoTransferController;
import de.audi.app.media.evo.utils.MediaEvoUtils;
import de.audi.app.media.queue.Queue;
import de.audi.app.media.source.ISourceSlot;
import de.audi.app.media.source.MediaCapabilities;
import de.audi.app.media.util.CopyOnWriteArrayList;
import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.hmi.model.HMIResourceLocator;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.model.list.TiledListModelApp;
import de.audi.atip.hmi.model.menu.focus.FocusAdvice;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.LabelModelApp;
import de.audi.atip.hmi.modelaccess.ResourceLocatorModelApp;
import de.esolutions.fw.util.commons.Buffer;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import org.dsi.ifc.global.ResourceLocator;

public class DataBrowserList
extends AbstractMediaBrowserList
implements IPlayerTrackListener,
ButtonListener,
IActionProxyListener,
IDataBrowserList {
    private static final String LOGCLASS = "DataBrowserList";
    private static final int PROGRESS_ICON_BIT_0_LIST_UPDATE = 0;
    private static final int PROGRESS_ICON_BIT_1_STARTUP_BROWSER = 1;
    private static final DataBrowserListLocator EMPTY_BROWSELIST_LOCATOR = new DataBrowserListLocator(0, 0);
    private static final byte BROWSING_STARTUP_STATE_UNDEFINED = -1;
    private static final byte BROWSING_STARTUP_CHANGE_BROWSE_MODE = 1;
    private static final byte BROWSING_STARTUP_BROWSE_MODE_CHANGED = 2;
    private static final byte BROWSING_STARTUP_INIT_FINISHED = 3;
    private static final byte BROWSING_STARTUP_GOTO_ROOT_FOLDER = 4;
    private static final byte BROWSING_STARTUP_WAITFOR_ROOT_FOLDER = 5;
    private static final byte BROWSING_STARTUP_REACHED_ROOT_FOLDER = 6;
    private static final byte BROWSING_STARTUP_REQUEST_ROOT_LIST = 7;
    private static final byte BROWSING_STARTUP_GOTO_IPOD_FOLDER = 8;
    private static final byte BROWSING_STARTUP_GOTO_IPOD_MUSIC_FOLDER = 9;
    private static final byte BROWSING_STARTUP_WAITFOR_IPOD_MUSIC_FOLDER = 10;
    private static final byte BROWSING_STARTUP_REACHED_IPOD_MUSIC_FOLDER = 11;
    private static final byte BROWSING_STARTUP_REQUEST_IPOD_MUSIC_LIST = 12;
    private static final byte BROWSING_STARTUP_GOTO_FOLDER = 13;
    private static final byte BROWSING_STARTUP_WAITFOR_FOLDER = 14;
    private static final byte BROWSING_STARTUP_REACHED_FOLDER = 15;
    private static final byte BROWSING_STARTUP_REQUEST_LIST = 16;
    private static final byte BROWSING_STARTUP_FAILSAFE_EXIT = 17;
    private static final byte BROWSING_STARTUP_FINISHED = 18;
    private static final int ROOT_LEVEL_STACK_LENGTH_SYNCED = 2;
    private static final int ROOT_LEVEL_STACK_LENGTH_PHYSICAL = 1;
    private static final int ROOT_LEVEL_STACK_LENGTH_IPOD_MUSIC = 3;
    private static final int ROOT_LEVEL_STACK_LENGTH_IPOD_VIDEOS = 2;
    private final DataPlayer player;
    private final Object browserStartupMutex = new Object();
    private final ProgressIndicationImpl progessStartupIndicator;
    private final ProgressIndicationImpl progressListUpdateIndicator;
    private final CopyOnWriteArrayList changeListeners;
    private final Queue queue;
    private final SDSDataBrowserCommandHandler sdsCommandHandler;
    private final IDataBrowserLastSelectionHandler lastSelectionHandler;
    private volatile MediaDetailInfo currentDetailInfo;
    private volatile byte browsingStartupState = (byte)-1;
    private volatile MediaListEntry startupEntryVideo = null;
    private volatile MediaListEntry startupEntryArtist = null;
    private volatile MediaListEntry startupEntryAlbums = null;
    private volatile MediaListEntry startupEntryPlayList = null;
    private volatile MediaListEntry startupEntryTitle = null;
    private volatile MediaListEntry startupEntryGenre = null;
    private volatile MediaListEntry startupIPodEntryMusic = null;
    private volatile MediaListEntry startupIPodEntryVideo = null;
    private volatile MediaListEntry startupIPodEntryAudioBooks = null;
    private volatile MediaListEntry startupIPodEntryComposers = null;
    private volatile MediaListEntry startupIPodEntryPodcasts = null;
    private volatile MediaListEntry startupIPodEntryRadios = null;
    private volatile DataBrowserListLocator currentBrowserListPath = EMPTY_BROWSELIST_LOCATOR;
    private volatile int listType = 0;
    private int listLayout = 0;
    private volatile boolean isOnIPOD = false;
    private volatile DataBrowserListSelectionData lastSelectionData;
    private volatile int lastModeSelection;
    private boolean waitScreenFadedOut;
    private final IImplicitRepeatHandler implicitRepeatHandler;
    private volatile boolean metaSyncComplete;
    private volatile boolean filesystemSyncComplete;
    private boolean restoreLastSelectionPossible;
    static /* synthetic */ Class class$de$audi$app$media$evo$content$data$DataBrowserListJobSelectBrowseListPath;

    public DataBrowserList(IMediaTerminal iMediaTerminal, DataPlayer dataPlayer, IImplicitRepeatHandler iImplicitRepeatHandler, IDataBrowserLastSelectionHandler iDataBrowserLastSelectionHandler) {
        super(iMediaTerminal, iMediaTerminal.getLogger().hmi());
        this.changeListeners = new CopyOnWriteArrayList();
        this.queue = new Queue(this.logChannel, "DATABROWSERLIST");
        this.player = dataPlayer;
        ChoiceModelApp choiceModelApp = this.getChoiceModel(200619);
        this.progressListUpdateIndicator = new ProgressIndicationImpl(this.logChannel, choiceModelApp, 0);
        this.progessStartupIndicator = new ProgressIndicationImpl(this.logChannel, choiceModelApp, 1);
        this.sdsCommandHandler = new SDSDataBrowserCommandHandler(iMediaTerminal, this.logger.sds(), this);
        this.implicitRepeatHandler = iImplicitRepeatHandler;
        this.lastSelectionHandler = iDataBrowserLastSelectionHandler;
    }

    public void init() {
        this.logChannel.log(1000000, "[%1.init]", (Object)LOGCLASS);
        super.init();
        TiledListModelApp tiledListModelApp = this.getList();
        tiledListModelApp.setLength(0);
        tiledListModelApp.setListener(this);
        this.getButtonModel(200615).setButtonListener(this);
        this.getButtonModel(200620).setButtonListener(this);
        this.getModelGroup().add(this.getModel(200622));
        this.lastModeSelection = this.lastSelectionHandler.getLastCategorySelection();
        this.logChannel.log(1000000, "[%1.init] lastModeSelection=%2", (Object)LOGCLASS, (long)this.lastModeSelection);
        this.getModelGroup().add(this.getCurrentFolderNameModel());
        this.getModelGroup().add(this.getCurrentFolderNameI18NModel());
        this.getModelGroup().add(this.getCurrentSubfolderNameModel());
        this.getModelGroup().add(this.getCurrentSubfolderNameI18NModel());
        this.getModelGroup().add(this.getFolderDepthModel());
        this.getModelGroup().add(this.getFolderSymbolModel());
        this.getModelGroup().add(this.getChoiceModel(200604));
        if (this.getBrowsingPlaylistModel() != null) {
            this.getModelGroup().add(this.getBrowsingPlaylistModel());
        }
    }

    public void deinit() {
        this.logChannel.log(1000000, "[%1.deinit]", (Object)LOGCLASS);
        this.changeListeners.clear();
        super.deinit();
        TiledListModelApp tiledListModelApp = this.getList();
        tiledListModelApp.setListener(null);
        tiledListModelApp.clearAll();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void activate(IBrowseListContext iBrowseListContext) {
        this.logChannel.log(1000000, "[%1.activate] '%2'", (Object)LOGCLASS, (Object)iBrowseListContext.getSlot());
        super.activate(iBrowseListContext);
        this.isOnIPOD = iBrowseListContext.getSlot().getMediaType() == 24;
        this.getChoiceModel(200823).setValue(0);
        Object object = this.getBrowserListMutex();
        synchronized (object) {
            this.waitScreenFadedOut = false;
        }
        this.getTerminal().addActionProxyListener(new int[]{9, 8, 23, 27, 37, 38}, (IActionProxyListener)this);
        this.getTerminal().getSDSDispatcher().addCommandListener(this.getTerminal().getTerminalID(), this.sdsCommandHandler);
        this.player.addTrackListener(this);
        this.reset();
        this.checkUnsyncedIPodConnected();
        this.setHMIDataBrowserListAvailable(true);
        this.metaSyncComplete = iBrowseListContext.getSlot().getMediaType() == 24 && !iBrowseListContext.getSlot().getCapabilities().isSearch();
        this.filesystemSyncComplete = false;
        this.getButtonModel(200449).setButtonListener(this);
        this.getButtonModel(200461).setButtonListener(this);
        this.getButtonModel(200464).setButtonListener(this);
        this.getButtonModel(200465).setButtonListener(this);
    }

    public void setRestoreLastSelectionPossible(boolean bl) {
        this.logChannel.log(1000000, "[%1.setRestoreLastSelectionPossible] '%2'", (Object)LOGCLASS, (Object)bl);
        this.restoreLastSelectionPossible = bl;
    }

    public void deactivate() {
        this.logChannel.log(1000000, "[%1.deactivate]", (Object)LOGCLASS);
        super.deactivate();
        this.setHMIDataBrowserListAvailable(false);
        this.player.removeTrackListener(this);
        this.getTerminal().getSDSDispatcher().removeCommandListener(this.getTerminal().getTerminalID(), this.sdsCommandHandler);
        this.getTerminal().removeActionProxyListener(this);
        this.getButtonModel(200449).setButtonListener(null);
        this.getButtonModel(200461).setButtonListener(null);
        this.getButtonModel(200464).setButtonListener(null);
        this.getButtonModel(200465).setButtonListener(null);
        this.getChoiceModel(200823).setValue(0);
    }

    private void reset() {
        this.logChannel.log(1000000, "[%1.reset] lastModeSelection=%2", (Object)LOGCLASS, (Object)this.categoryToString(this.lastModeSelection));
        this.browsingStartupState = (byte)-1;
        this.setCurrentBrowserListLocator(EMPTY_BROWSELIST_LOCATOR);
        this.setType(0);
        this.clearList();
        if (0 != this.lastModeSelection) {
            this.getChoiceModel(200616).setValue(this.lastModeSelection);
            this.notifyLastBrowseListCategoryChanged(this.lastModeSelection);
            this.lastModeSelection = 0;
        } else {
            this.setLastSelection(null);
        }
        this.setPlayableFileAvailable(true);
        this.queue.reset();
        this.progressListUpdateIndicator.stopIndication();
        this.progessStartupIndicator.stopIndication();
        this.startupEntryVideo = null;
        this.startupEntryArtist = null;
        this.startupEntryPlayList = null;
        this.startupEntryTitle = null;
        this.startupEntryAlbums = null;
        this.startupEntryGenre = null;
        this.startupIPodEntryVideo = null;
        this.startupIPodEntryMusic = null;
        this.startupIPodEntryAudioBooks = null;
        this.startupIPodEntryComposers = null;
        this.startupIPodEntryPodcasts = null;
    }

    private void checkUnsyncedIPodConnected() {
        this.logChannel.log(1000000, "[%1.checkUnsyncedIPodConnected].", (Object)LOGCLASS);
        MediaCapabilities mediaCapabilities = this.getBrowseListContext().getSlot().getCapabilities();
        if (this.isOnIPOD && !mediaCapabilities.isSearch()) {
            this.logChannel.log(1000000, "[%1.checkUnsyncedIPodConnected] An unsynced iPod is connected via USB -> in case of HK_BACK jump to main wizard.", (Object)LOGCLASS);
            this.getChoiceModel(200616).setValue(0);
        }
    }

    public void addBrowseListChangeListener(IDataBrowserListChangeListener iDataBrowserListChangeListener) {
        this.logChannel.log(1000000, "[%1.addBrowserListChangeListener] '%2'", (Object)LOGCLASS);
        this.changeListeners.addIfAbsent(iDataBrowserListChangeListener);
    }

    public void removeBrowseListChangeListener(IDataBrowserListChangeListener iDataBrowserListChangeListener) {
        this.logChannel.log(1000000, "[%1.removeBrowseListChangeListener] '%2'", (Object)LOGCLASS);
        this.changeListeners.remove(iDataBrowserListChangeListener);
    }

    public boolean isReady() {
        return !this.isOnBrowsingStartup();
    }

    private void notifyBrowseListTypeChanged(int n) {
        this.logChannel.log(10000000, "[%1.notifyBrowseListTypeChanged]", (Object)LOGCLASS);
        Iterator iterator = this.changeListeners.iterator();
        while (iterator.hasNext()) {
            try {
                ((IDataBrowserListChangeListener)iterator.next()).browseListTypeChanged(n);
            }
            catch (Exception exception) {
                this.logChannel.log(100000, "[%1.notifyBrowseListTypeChanged]", (Throwable)exception);
            }
        }
    }

    private void notifyBrowseListLayoutChanged(int n) {
        this.logChannel.log(10000000, "[%1.notifyBrowseListLayoutChanged]", (Object)LOGCLASS);
        Iterator iterator = this.changeListeners.iterator();
        while (iterator.hasNext()) {
            try {
                ((IDataBrowserListChangeListener)iterator.next()).browseListLayoutChanged(n);
            }
            catch (Exception exception) {
                this.logChannel.log(100000, "[%1.notifyBrowseListLayoutChanged]", (Throwable)exception);
            }
        }
    }

    private void notifyBrowseListCategorySelected(int n) {
        this.logChannel.log(10000000, "[%1.notifyBrowseListCategorySelected]", (Object)LOGCLASS);
        Iterator iterator = this.changeListeners.iterator();
        while (iterator.hasNext()) {
            try {
                ((IDataBrowserListChangeListener)iterator.next()).browseListCategorySelected(n);
            }
            catch (Exception exception) {
                this.logChannel.log(100000, "[%1.notifyBrowseListCategoryChanged]", (Throwable)exception);
            }
        }
    }

    private void notifyLastBrowseListCategoryChanged(int n) {
        this.logChannel.log(10000000, "[%1.notifyLastBrowseListCategoryChanged]", (Object)LOGCLASS);
        Iterator iterator = this.changeListeners.iterator();
        while (iterator.hasNext()) {
            try {
                ((IDataBrowserListChangeListener)iterator.next()).lastBrowseListCategoryChanged(n);
            }
            catch (Exception exception) {
                this.logChannel.log(100000, "[%1.notifyLastBrowseListCategoryChanged]", (Throwable)exception);
            }
        }
    }

    protected void updateBrowseFolderData() {
        this.logChannel.log(10000000, "[%1.updateBrowseFolderData]", (Object)LOGCLASS);
        MediaListEntry[] mediaListEntryArray = this.getCurrentBrowsingFolder();
        if (mediaListEntryArray == IBrowseListContext.EMPTY_BROWSE_FOLDER) {
            return;
        }
        MediaListEntry mediaListEntry = mediaListEntryArray[mediaListEntryArray.length - 1];
        this.getCurrentFolderNameModel().setText(mediaListEntry.getTitle().getI18NString());
        this.getCurrentFolderNameI18NModel().setValue(mediaListEntry.getTitle().getI18NKey());
        this.getFolderDepthModel().setValue(mediaListEntryArray.length - this.getRootLevelStackLength() + 1);
        this.getFolderSymbolModel().setValue(this.createListRow(mediaListEntry, 1).getSymbol());
        if (mediaListEntryArray.length > 1) {
            this.getCurrentSubfolderNameModel().setText(mediaListEntryArray[mediaListEntryArray.length - 2].getTitle().getI18NString());
            this.getCurrentSubfolderNameI18NModel().setValue(mediaListEntryArray[mediaListEntryArray.length - 2].getTitle().getI18NKey());
            this.getCurrentSubfolderSymbolModel().setValue(this.createListRow(mediaListEntryArray[mediaListEntryArray.length - 2], 1).getSymbol());
        } else {
            this.getCurrentSubfolderNameModel().setText("");
            this.getCurrentSubfolderNameI18NModel().setValue(0);
        }
        ChoiceModelApp choiceModelApp = this.getBrowsingPlaylistModel();
        if (choiceModelApp != null) {
            choiceModelApp.setValue(mediaListEntry.isPlaylist() ? 1 : 0);
        }
    }

    protected void resetBrowseFolderData() {
        this.getFolderDepthModel().setValue(0);
        this.getFolderSymbolModel().setValue(0);
        this.getCurrentFolderNameModel().setText("");
        this.getCurrentSubfolderNameModel().setText("");
    }

    private void setHMIDataBrowserListAvailable(boolean bl) {
        this.logChannel.log(1000000, "[%2.setHMIDataBrowserListAvailable] '%1'", (Object)(bl ? "AVAILABLE" : "NOT AVAILABLE"), (Object)LOGCLASS);
        this.getChoiceModel(200603).setValue(bl ? 1 : 0);
    }

    private void setType(int n) {
        this.logChannel.log(1000000, "[%1.setListType] '%2'", (Object)LOGCLASS, (Object)DataBrowserList.getListTypeStr(n));
        boolean bl = this.listType != n;
        this.listType = n;
        this.getChoiceModel(200622).setValue(n);
        if (bl) {
            this.notifyBrowseListTypeChanged(this.listType);
        }
    }

    private int getType() {
        return this.listType;
    }

    private static String getListTypeStr(int n) {
        switch (n) {
            case 3: {
                return "LISTTYPE_ALBUMS";
            }
            case 4: {
                return "LISTTYPE_ARTISTS";
            }
            case 9: {
                return "LISTTYPE_AUDIOBOOKS";
            }
            case 8: {
                return "LISTTYPE_COMPOSERS";
            }
            case 5: {
                return "LISTTYPE_GENRES";
            }
            case 1: {
                return "LISTTYPE_PHYSICAL";
            }
            case 6: {
                return "LISTTYPE_PLAYLISTS";
            }
            case 10: {
                return "LISTTYPE_PODCASTS";
            }
            case 2: {
                return "LISTTYPE_TITELS";
            }
            case 7: {
                return "LISTTYPE_VIDEOS";
            }
        }
        return new StringBuffer().append("UNKNOWN (").append(n).append(")").toString();
    }

    private void setLayout(int n) {
        this.logChannel.log(1000000, "[%1.setLayout] '%2'", (Object)LOGCLASS, (Object)DataBrowserList.getLayoutStr(n));
        boolean bl = n != this.listLayout;
        this.listLayout = n;
        if (bl) {
            this.notifyBrowseListLayoutChanged(this.listLayout);
        }
    }

    private static String getLayoutStr(int n) {
        switch (n) {
            case 1: {
                return "1L_FILENAME";
            }
            case 0: {
                return "1L_TILE";
            }
            case 3: {
                return "2L_ALBUM_ARTIST";
            }
            case 2: {
                return "2L_TITLE_ARTIST";
            }
        }
        return new StringBuffer().append("UNKNOWN(").append(n).append(")").toString();
    }

    private int getLayout() {
        return this.listLayout;
    }

    public boolean selectBrowseListPath(DataBrowserListLocator dataBrowserListLocator) {
        this.logChannel.log(1000000, "[%1.selectBrowseListPath] '%2'", (Object)LOGCLASS, (Object)dataBrowserListLocator);
        if (dataBrowserListLocator == null || dataBrowserListLocator.getCategory() == 0) {
            this.logChannel.log(1000000, "[%1.selectBrowseListPath] Category not defined.", (Object)LOGCLASS);
            return false;
        }
        ISourceSlot iSourceSlot = this.getBrowseListContext().getSlot();
        if (iSourceSlot == null) {
            this.logChannel.log(1000000, "[%1.selectBrowseListPath] Not active.", (Object)LOGCLASS);
            this.unblockList();
            return false;
        }
        boolean bl = MediaUtils.isDefaultSyncSource(iSourceSlot.getSource().getType());
        boolean bl2 = iSourceSlot.getSource().getSlot(iSourceSlot).getFlags().isMetaDataSyncComplete();
        switch (dataBrowserListLocator.getCategory()) {
            case 1: {
                if (iSourceSlot.getSource().getType() != 6 && !this.isOnIPOD) break;
                return false;
            }
            case 7: {
                if (bl && bl2 || this.isOnIPOD && this.player.supportsVideoPlayback()) break;
                return false;
            }
            case 2: 
            case 3: 
            case 4: 
            case 5: 
            case 6: {
                if (bl && bl2 || this.isOnIPOD) break;
                return false;
            }
            case 8: 
            case 9: 
            case 10: 
            case 12: {
                if (this.isOnIPOD) break;
                return false;
            }
            default: {
                this.logChannel.log(1000000, "[%1.selectBrowseListPath] Not supported categroy", (Object)LOGCLASS);
                return false;
            }
        }
        this.queue.enqueue(new DataBrowserListJobSelectBrowseListPath(this.logChannel, this, dataBrowserListLocator));
        return true;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void startBrowseListPathSelection(DataBrowserListLocator dataBrowserListLocator) {
        int n;
        this.logChannel.log(1000000, "[%1.startBrowseListPathSelection] '%2'", (Object)LOGCLASS, (Object)dataBrowserListLocator);
        this.resetList();
        this.progessStartupIndicator.startIndication();
        this.setCurrentBrowserListLocator(dataBrowserListLocator);
        int n2 = this.getBrowsingCategory();
        this.notifyBrowseListCategorySelected(n2);
        int n3 = 0;
        if (dataBrowserListLocator.getPathType() == 1 && dataBrowserListLocator.getPath().length > 0) {
            n = dataBrowserListLocator.getPath().length;
            if (dataBrowserListLocator.getFocusElement() != null) {
                --n;
            }
            n3 = n;
        }
        n = this.isOnIPOD ? (n2 == 7 ? 2 : 3) : (n2 == 1 ? 1 : 2);
        this.setRootLevelStackLength(n + n3);
        this.blockList();
        if (null != this.currentBrowserListPath && 2 == this.currentBrowserListPath.getPathType()) {
            Object object = this.getBrowserListMutex();
            synchronized (object) {
                this.waitScreenFadedOut = true;
            }
        }
        this.setStartupState((byte)1);
    }

    private int getBrowseMode(int n) {
        if (n == 0) {
            return -1;
        }
        if (this.isOnIPOD || n == 1) {
            return 0;
        }
        return 1;
    }

    protected int getBrowsingCategory() {
        return this.currentBrowserListPath.getCategory();
    }

    protected void setCurrentBrowserListLocator(DataBrowserListLocator dataBrowserListLocator) {
        this.currentBrowserListPath = dataBrowserListLocator;
        this.getChoiceModel(200604).setValue(this.getBrowsingCategory());
        this.getChoiceModel(200617).setValue(this.currentBrowserListPath.getPathType() == 2 ? 0 : this.currentBrowserListPath.getPathType());
    }

    private DataBrowserListLocator getCurrentBrowserListLocator() {
        return this.currentBrowserListPath;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void setStartupState(byte by) {
        this.browsingStartupState = by;
        switch (this.browsingStartupState) {
            case -1: {
                this.logChannel.log(1000000, "[%1.setStartupState] BROWSING_STARTUP_STATE_UNDEFINED", (Object)LOGCLASS);
                this.clearList();
                this.unblockList();
                this.getRunningJob().browsePathSelectionFinished();
                break;
            }
            case 1: {
                this.logChannel.log(1000000, "[%1.setStartupState] BROWSING_STARTUP_CHANGE_BROWSE_MODE", (Object)LOGCLASS);
                int n = this.getBrowseMode(this.getBrowsingCategory());
                if (n == -1) {
                    this.unblockList();
                    return;
                }
                if (n != this.getBrowseListContext().getBrowseMode()) {
                    this.getBrowseListContext().setBrowseMode(n);
                    return;
                }
                this.logChannel.log(1000000, "[%1.setStartupState] Browse mode already set.", (Object)LOGCLASS);
                this.setStartupState((byte)3);
                break;
            }
            case 2: {
                this.logChannel.log(1000000, "[%1.setStartupState] BROWSING_STARTUP_BROWSE_MODE_CHANGED", (Object)LOGCLASS);
                if (this.getCurrentBrowsingFolder() == IBrowseListContext.EMPTY_BROWSE_FOLDER) {
                    this.logChannel.log(1000000, "[%1.setStartupState] Received no initial browse folder.", (Object)LOGCLASS);
                    this.setStartupState((byte)18);
                    return;
                }
                this.setStartupState((byte)3);
                break;
            }
            case 3: {
                this.logChannel.log(1000000, "[%1.setStartupState] BROWSING_STARTUP_INIT_FINISHED", (Object)LOGCLASS);
                if (this.getCategoryFolderStack(this.currentBrowserListPath) != null) {
                    this.setStartupState((byte)13);
                    return;
                }
                this.setStartupState((byte)4);
                break;
            }
            case 4: {
                this.logChannel.log(1000000, "[%1.setStartupState] BROWSING_STARTUP_GOTO_ROOT_FOLDER", (Object)LOGCLASS);
                MediaListEntry[] mediaListEntryArray = this.getCurrentBrowsingFolder();
                if (mediaListEntryArray.length == 1) {
                    this.setStartupState((byte)6);
                    return;
                }
                Object object = this.browserStartupMutex;
                synchronized (object) {
                    this.changeFolder(new MediaListEntry[]{mediaListEntryArray[0]});
                    this.setStartupState((byte)5);
                    break;
                }
            }
            case 5: {
                this.logChannel.log(1000000, "[%1.setStartupState] BROWSING_STARTUP_WAITFOR_ROOT_FOLDER", (Object)LOGCLASS);
                break;
            }
            case 6: {
                this.logChannel.log(1000000, "[%1.setStartupState] BROWSING_STARTUP_REACHED_ROOT_FOLDER", (Object)LOGCLASS);
                this.setStartupState((byte)7);
                break;
            }
            case 7: {
                this.logChannel.log(1000000, "[%1.setStartupState] BROWSING_STARTUP_REQUEST_ROOT_LIST", (Object)LOGCLASS);
                this.requestListIndexBased(0);
                break;
            }
            case 8: {
                this.logChannel.log(1000000, "[%1.setStartupState] BROWSING_STARTUP_GOTO_IPOD_FOLDER", (Object)LOGCLASS);
                this.setStartupState((byte)9);
                break;
            }
            case 9: {
                this.logChannel.log(1000000, "[%1.setStartupState] BROWSING_STARTUP_GOTO_IPOD_MUSIC_FOLDER", (Object)LOGCLASS);
                if (this.startupIPodEntryMusic == null) {
                    this.logChannel.log(100000, "[%1.setStartupState] IPod music folder not found.", (Object)LOGCLASS);
                    this.setStartupState((byte)17);
                    return;
                }
                Object object = this.browserStartupMutex;
                synchronized (object) {
                    MediaListEntry[] mediaListEntryArray = new MediaListEntry[]{this.getCurrentBrowsingFolder()[0], this.startupIPodEntryMusic};
                    this.changeFolder(mediaListEntryArray);
                    this.setStartupState((byte)10);
                    break;
                }
            }
            case 10: {
                this.logChannel.log(1000000, "[%1.setStartupState] BROWSING_STARTUP_WAITFOR_IPOD_MUSIC_FOLDER", (Object)LOGCLASS);
                break;
            }
            case 11: {
                this.logChannel.log(1000000, "[%1.setStartupState] BROWSING_STARTUP_REACHED_IPOD_MUSIC_FOLDER", (Object)LOGCLASS);
                this.setStartupState((byte)12);
                break;
            }
            case 12: {
                this.logChannel.log(1000000, "[%1.setStartupState] BROWSING_STARTUP_REQUEST_IPOD_MUSIC_LIST", (Object)LOGCLASS);
                this.requestListIndexBased(0);
                break;
            }
            case 13: {
                this.logChannel.log(1000000, "[%1.setStartupState] BROWSING_STARTUP_GOTO_FOLDER", (Object)LOGCLASS);
                MediaListEntry[] mediaListEntryArray = this.getCategoryFolderStack(this.currentBrowserListPath);
                if (mediaListEntryArray == null) {
                    this.logChannel.log(100000, "[%1.setStartupState] No folder stack available.", (Object)LOGCLASS);
                    this.setStartupState((byte)18);
                    return;
                }
                if (MediaUtils.isSameFolder(this.getCurrentBrowsingFolder(), mediaListEntryArray)) {
                    this.setStartupState((byte)15);
                    return;
                }
                Object object = this.browserStartupMutex;
                synchronized (object) {
                    this.changeFolder(mediaListEntryArray);
                    if (2 != this.currentBrowserListPath.getPathType()) {
                        this.setChangeFolderRunning(false);
                    }
                    this.setStartupState((byte)14);
                    break;
                }
            }
            case 14: {
                this.logChannel.log(1000000, "[%1.setStartupState] BROWSING_STARTUP_WAITFOR_FOLDER", (Object)LOGCLASS);
                break;
            }
            case 15: {
                this.logChannel.log(1000000, "[%1.setStartupState] BROWSING_STARTUP_REACHED_FOLDER", (Object)LOGCLASS);
                this.setStartupState((byte)16);
                break;
            }
            case 16: {
                this.logChannel.log(1000000, "[%1.setStartupState] BROWSING_STARTUP_REQUEST_LIST", (Object)LOGCLASS);
                if (this.getListSize() == 0) {
                    this.logChannel.log(10000000, "[%1.setStartupState] List contains no entries.", (Object)LOGCLASS);
                    this.setStartupState((byte)18);
                    return;
                }
                DataBrowserListElement dataBrowserListElement = this.currentBrowserListPath.getFocusElement();
                if (dataBrowserListElement != null) {
                    this.logChannel.log(10000000, "[%1.setStartupState] Arround element to focus.", (Object)LOGCLASS);
                    this.requestListEntryBased(dataBrowserListElement.getEntryID(), dataBrowserListElement.getContentType());
                    break;
                }
                this.setCurrentFocusedRow(null);
                this.requestListIndexBased(0);
                break;
            }
            case 17: {
                this.logChannel.log(1000000, "[%1.setStartupState] BROWSING_STARTUP_FAILSAFE_EXIT", (Object)LOGCLASS);
                this.requestListIndexBased(0);
                break;
            }
            case 18: {
                this.logChannel.log(1000000, "[%1.setStartupState] BROWSING_STARTUP_FINISHED", (Object)LOGCLASS);
                this.unblockList();
                this.getRunningJob().browsePathSelectionFinished();
                if (2 == this.currentBrowserListPath.getPathType()) {
                    this.getChoiceModel(200617).setValue(0);
                }
                this.progessStartupIndicator.stopIndication();
                break;
            }
            default: {
                this.logChannel.log(100000, "[%1.setStartupState] Invalid startup state '%2' reached.", (Object)LOGCLASS, (long)by);
            }
        }
    }

    public boolean isOnBrowsingStartup() {
        return this.browsingStartupState != 18;
    }

    private MediaListEntry[] getCategoryFolderStack(DataBrowserListLocator dataBrowserListLocator) {
        DataBrowserListElement[] dataBrowserListElementArray = dataBrowserListLocator.getPath();
        LinkedList linkedList = new LinkedList();
        MediaListEntry[] mediaListEntryArray = this.getCurrentBrowsingFolder();
        linkedList.add(mediaListEntryArray[0]);
        if (this.isOnIPOD && dataBrowserListLocator.getCategory() != 7) {
            linkedList.add(this.startupIPodEntryMusic);
        }
        switch (dataBrowserListLocator.getCategory()) {
            case 3: {
                linkedList.add(this.startupEntryAlbums);
                break;
            }
            case 5: {
                linkedList.add(this.startupEntryGenre);
                break;
            }
            case 4: {
                linkedList.add(this.startupEntryArtist);
                break;
            }
            case 6: {
                linkedList.add(this.startupEntryPlayList);
                break;
            }
            case 2: {
                linkedList.add(this.startupEntryTitle);
                break;
            }
            case 7: {
                if (this.isOnIPOD) {
                    linkedList.add(this.startupIPodEntryVideo);
                    break;
                }
                linkedList.add(this.startupEntryVideo);
                break;
            }
            case 9: {
                linkedList.add(this.startupIPodEntryAudioBooks);
                break;
            }
            case 10: {
                linkedList.add(this.startupIPodEntryComposers);
                break;
            }
            case 8: {
                linkedList.add(this.startupIPodEntryPodcasts);
                break;
            }
            case 12: {
                linkedList.add(this.startupIPodEntryRadios);
                break;
            }
        }
        for (int i2 = 0; i2 < dataBrowserListElementArray.length; ++i2) {
            if (dataBrowserListElementArray[i2].getType() != 1) continue;
            linkedList.add(new MediaListEntry(dataBrowserListElementArray[i2].getEntryID(), dataBrowserListElementArray[i2].getContentType(), dataBrowserListElementArray[i2].getFilename()));
        }
        MediaListEntry[] mediaListEntryArray2 = new MediaListEntry[linkedList.size()];
        int n = 0;
        Iterator iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            MediaListEntry mediaListEntry = (MediaListEntry)iterator.next();
            if (mediaListEntry == null) {
                return null;
            }
            mediaListEntryArray2[n++] = mediaListEntry;
        }
        return mediaListEntryArray2;
    }

    protected void setLastSelection(DataBrowserListSelectionData dataBrowserListSelectionData) {
        this.logChannel.log(1000000, "[%1.setLastSelection] '%2'", (Object)LOGCLASS, (Object)dataBrowserListSelectionData);
        this.lastSelectionData = dataBrowserListSelectionData;
        int n = this.lastSelectionData == null ? (this.getBrowseListContext().getSlot().getCapabilities().isContentBrowsing() ? 4 : 1) : this.lastSelectionData.getCategory();
        this.logChannel.log(1000000, "[%1.setLastSelection] lastCategory=%2", (Object)LOGCLASS, (Object)this.categoryToString(n));
        this.getChoiceModel(200616).setValue(n);
        this.notifyLastBrowseListCategoryChanged(n);
        this.lastSelectionHandler.setLastCategorySelection(n);
    }

    private DataBrowserListSelectionData getLastSelectionData() {
        return this.lastSelectionData;
    }

    protected void addSelection(int n, MediaListEntry mediaListEntry) {
        this.logChannel.log(1000000, "[%1.addSelection] '%2'", (Object)LOGCLASS, (Object)mediaListEntry);
        this.getBrowseListContext().resetSelection();
        this.getBrowseListContext().addSelection(true, n, mediaListEntry.getEntryID(), mediaListEntry.getContentType(), false);
    }

    protected void playSelection(IPlayerSelectionRequest iPlayerSelectionRequest) {
        this.logChannel.log(1000000, "[%1.playSelection] '%2'", (Object)LOGCLASS, (Object)iPlayerSelectionRequest);
        this.player.setBrowserPlayerSelection(iPlayerSelectionRequest);
    }

    public void triggerLeaveBrowserListAfterSelection() {
        this.logChannel.log(1000000, "[%1.triggerLeaveBrowserListAfterSelection]", (Object)LOGCLASS);
        this.getChoiceModel(200629).setValue(1);
        this.logChannel.log(1000000, "[%1.triggerLeaveBrowserListAfterSelection] value=%2", (Object)LOGCLASS);
    }

    protected ChoiceModelApp getPlayableFilesAvailableModel() {
        return this.getChoiceModel(200618);
    }

    protected ChoiceModelApp getSDSPlayableFilesAvailableModel() {
        return this.getChoiceModel(200888);
    }

    protected AbstractMediaBrowserListRow createListRow(MediaListEntry mediaListEntry, int n) {
        return new DataBrowserListRow(mediaListEntry, n, this.getCurrentBrowsingFolder(), this.getLayout());
    }

    protected final TiledListModelApp getList() {
        return this.getTiledListModel(200601);
    }

    protected final ChoiceModelApp getListStatusChoice() {
        return this.getChoiceModel(200808);
    }

    protected final ChoiceModelApp getTitleSelectedModel() {
        return this.getChoiceModel(200629);
    }

    protected final LabelModelApp getCurrentFolderNameModel() {
        return this.getLabelModel(200607);
    }

    protected final ChoiceModelApp getCurrentFolderNameI18NModel() {
        return this.getChoiceModel(200608);
    }

    protected final LabelModelApp getCurrentSubfolderNameModel() {
        return this.getLabelModel(200609);
    }

    protected final ChoiceModelApp getCurrentSubfolderNameI18NModel() {
        return this.getChoiceModel(200610);
    }

    protected final ChoiceModelApp getFolderDepthModel() {
        return this.getChoiceModel(200614);
    }

    protected final ChoiceModelApp getFolderSymbolModel() {
        return this.getChoiceModel(200612);
    }

    protected ChoiceModelApp getCurrentSubfolderSymbolModel() {
        return this.getChoiceModel(200611);
    }

    protected IProgressIndication getListProgressIndicationHandler() {
        return this.progressListUpdateIndicator;
    }

    protected ChoiceModelApp getBrowsingPlaylistModel() {
        return this.getChoiceModel(200606);
    }

    public void detailInfoChanged(MediaDetailInfo mediaDetailInfo) {
        this.logChannel.log(1000000, "[%1.detailInfoChanged]", (Object)LOGCLASS);
        this.currentDetailInfo = mediaDetailInfo;
    }

    public void trackChanged(boolean bl, boolean bl2, PlayingTrack playingTrack, PlayTime playTime) {
    }

    public void coverArtChanged(ResourceLocator resourceLocator) {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected AbstractMediaBrowserListRow fillList(AbstractMediaBrowserListRow[] abstractMediaBrowserListRowArray, int n) {
        this.logChannel.log(1000000, "[%1.fillList]", (Object)LOGCLASS);
        TiledListModelApp tiledListModelApp = this.getList();
        BaseListModelApp baseListModelApp = tiledListModelApp.getCopy();
        Object object = this.getBrowserListMutex();
        synchronized (object) {
            if (this.getClearListFlag()) {
                baseListModelApp.clearAll();
                tiledListModelApp.getMenu().resetFocusedItem();
                this.setClearListFlag(false);
            }
        }
        object = this.listRequest;
        this.listRequest = NO_WIDGET_REQUEST;
        baseListModelApp.setLength(this.getListSize());
        baseListModelApp.setRows(((ListRequest)object).isValid() ? ((ListRequest)object).getRequestId() : -1, n, abstractMediaBrowserListRowArray);
        tiledListModelApp.update(baseListModelApp);
        return null;
    }

    public void browseModeChanged(boolean bl, int n) {
        this.logChannel.log(1000000, "[%1.browseModeChanged] '%2'", (Object)LOGCLASS, (long)n);
        if (this.isOnBrowsingStartup() && this.browsingStartupState == 1) {
            this.setStartupState((byte)2);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void browseFolderChanged(boolean bl, MediaListEntry[] mediaListEntryArray, int n) {
        if (!bl) {
            this.setListTypeAndLayout(this.getBrowsingCategory(), mediaListEntryArray);
        }
        if (!bl && this.isOnBrowsingStartup()) {
            this.logChannel.log(1000000, "[%1.browseFolderChanged] On startup.", (Object)LOGCLASS);
            this.setPlayableFileAvailable(n != 0);
            this.getList().setLength(n);
            this.updateBrowseFolderData();
            this.setPreviousBrowsingFolder(mediaListEntryArray);
            Object object = this.browserStartupMutex;
            synchronized (object) {
                switch (this.browsingStartupState) {
                    case 5: {
                        this.setStartupState((byte)6);
                        break;
                    }
                    case 14: {
                        this.setStartupState((byte)15);
                        break;
                    }
                    case 10: {
                        this.setStartupState((byte)11);
                        break;
                    }
                }
            }
        } else {
            if (this.isOnBrowsingStartup()) {
                this.setStartupState((byte)17);
            }
            super.browseFolderChanged(bl, mediaListEntryArray, n);
        }
    }

    private void setListTypeAndLayout(int n, MediaListEntry[] mediaListEntryArray) {
        MediaListEntry mediaListEntry = mediaListEntryArray[mediaListEntryArray.length - 1];
        switch (n) {
            case 1: {
                this.setType(1);
                this.setLayout(1);
                break;
            }
            case 3: {
                if (mediaListEntry.getTitle().getI18NKey() == 5) {
                    this.setLayout(2);
                    this.setType(3);
                    break;
                }
                this.setType(2);
                this.setLayout(0);
                break;
            }
            case 4: {
                this.setLayout(0);
                if (mediaListEntry.getTitle().getI18NKey() == 2) {
                    this.setType(4);
                    break;
                }
                if (mediaListEntry.getContentType() == 13) {
                    this.setType(3);
                    break;
                }
                this.setType(2);
                break;
            }
            case 5: {
                this.setLayout(0);
                if (mediaListEntry.getTitle().getI18NKey() == 8) {
                    this.setType(5);
                    break;
                }
                if (mediaListEntry.getContentType() == 16) {
                    this.setType(4);
                    break;
                }
                if (mediaListEntry.getContentType() == 13) {
                    this.setType(3);
                    break;
                }
                this.setType(2);
                break;
            }
            case 10: {
                this.setLayout(0);
                if (mediaListEntry.getTitle().getI18NKey() == 11) {
                    this.setType(8);
                    break;
                }
                this.setType(2);
                break;
            }
            case 9: {
                this.setLayout(0);
                if (mediaListEntry.getTitle().getI18NKey() == 16) {
                    this.setType(9);
                    break;
                }
                this.setType(2);
                break;
            }
            case 6: {
                if (mediaListEntry.getTitle().getI18NKey() == 1) {
                    this.setType(6);
                    this.setLayout(0);
                    break;
                }
                this.setType(2);
                this.setLayout(3);
                break;
            }
            case 8: {
                if (mediaListEntry.getTitle().getI18NKey() == 17) {
                    this.setType(10);
                    this.listLayout = 2;
                    return;
                }
                this.setType(2);
                this.setLayout(0);
                break;
            }
            case 7: {
                this.setType(7);
                this.setLayout(0);
                break;
            }
            case 2: {
                this.setType(2);
                if (this.isOnIPOD && !this.player.supportsExtendedPlayView()) {
                    this.logChannel.log(1000000, "[%1.browseFolderChanged] iPod -> single lined list.", (Object)LOGCLASS);
                    this.setLayout(0);
                    break;
                }
                this.setLayout(3);
                break;
            }
            case 12: {
                this.setType(2);
                this.setLayout(0);
                break;
            }
            default: {
                this.setLayout(0);
                this.setType(0);
            }
        }
    }

    public void listUpdated(int n) {
        if (this.isOnBrowsingStartup()) {
            this.logChannel.log(1000000, "[%1.listUpdated] On startup.", (Object)LOGCLASS);
            this.setPlayableFileAvailable(n != 0);
            return;
        }
        super.listUpdated(n);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void responseList(boolean bl, MediaListEntry[] mediaListEntryArray, int n) {
        if (this.isOnBrowsingStartup() && !bl) {
            this.logChannel.log(1000000, "[%1.responseList] On startup.", (Object)LOGCLASS);
            switch (this.browsingStartupState) {
                case 16: {
                    Object object = this.getBrowserListMutex();
                    synchronized (object) {
                        DataBrowserListElement dataBrowserListElement = this.currentBrowserListPath.getFocusElement();
                        if (dataBrowserListElement != null) {
                            this.setCurrentFocusedRow(this.createListRow(new MediaListEntry(dataBrowserListElement.getEntryID(), dataBrowserListElement.getContentType(), ""), DataBrowserList.getIndexForEntry(n, mediaListEntryArray, dataBrowserListElement.getEntryID(), dataBrowserListElement.getContentType())));
                        } else {
                            this.logChannel.log(10000000, "[%1.responseList] No playing track context.", (Object)LOGCLASS);
                        }
                        if (2 != this.currentBrowserListPath.getPathType()) {
                            this.resetFolderChangeIndication();
                        }
                        super.responseList(bl, mediaListEntryArray, n);
                        this.setStartupState((byte)18);
                        break;
                    }
                }
                case 7: {
                    if (this.isOnIPOD) {
                        this.logChannel.log(10000000, "[%1.responseList] IPod root folder.", (Object)LOGCLASS);
                        block16: for (int i2 = 0; i2 < mediaListEntryArray.length; ++i2) {
                            MediaListEntry mediaListEntry = mediaListEntryArray[i2];
                            switch (mediaListEntry.getTitle().getI18NKey()) {
                                case 12: {
                                    this.logChannel.log(10000000, "[%1.responseList] IPod music folder found.", (Object)LOGCLASS);
                                    this.startupIPodEntryMusic = mediaListEntry;
                                    continue block16;
                                }
                                case 13: {
                                    this.logChannel.log(10000000, "[%1.responseList] IPod video folder found.", (Object)LOGCLASS);
                                    this.startupIPodEntryVideo = mediaListEntry;
                                    continue block16;
                                }
                            }
                        }
                        this.setStartupState((byte)8);
                        return;
                    }
                    this.searchForCategoryFolderEntries(mediaListEntryArray);
                    this.setStartupState((byte)13);
                    break;
                }
                case 12: {
                    this.searchForCategoryFolderEntries(mediaListEntryArray);
                    this.setStartupState((byte)13);
                    break;
                }
                case 17: {
                    Object object = this.getBrowserListMutex();
                    synchronized (object) {
                        super.responseList(bl, mediaListEntryArray, n);
                        this.setStartupState((byte)18);
                        break;
                    }
                }
            }
            return;
        }
        if (this.isOnBrowsingStartup() && bl) {
            this.setStartupState((byte)-1);
        }
        super.responseList(bl, mediaListEntryArray, n);
    }

    private static int getIndexForEntry(int n, MediaListEntry[] mediaListEntryArray, long l, int n2) {
        int n3 = 0;
        while (n3 < mediaListEntryArray.length) {
            if (mediaListEntryArray[n3].getEntryID() == l && mediaListEntryArray[n3].getContentType() == n2) {
                return n;
            }
            ++n3;
            ++n;
        }
        return -1;
    }

    private void searchForCategoryFolderEntries(MediaListEntry[] mediaListEntryArray) {
        block12: for (int i2 = 0; i2 < mediaListEntryArray.length; ++i2) {
            MediaListEntry mediaListEntry = mediaListEntryArray[i2];
            switch (mediaListEntry.getTitle().getI18NKey()) {
                case 2: {
                    this.startupEntryArtist = mediaListEntry;
                    continue block12;
                }
                case 8: {
                    this.startupEntryGenre = mediaListEntry;
                    continue block12;
                }
                case 5: {
                    this.startupEntryAlbums = mediaListEntry;
                    continue block12;
                }
                case 1: {
                    this.startupEntryPlayList = mediaListEntry;
                    continue block12;
                }
                case 33: {
                    this.startupEntryTitle = mediaListEntry;
                    continue block12;
                }
                case 13: {
                    this.startupEntryVideo = mediaListEntry;
                    continue block12;
                }
                case 16: {
                    this.startupIPodEntryAudioBooks = mediaListEntry;
                    continue block12;
                }
                case 11: {
                    this.startupIPodEntryComposers = mediaListEntry;
                    continue block12;
                }
                case 17: {
                    this.startupIPodEntryPodcasts = mediaListEntry;
                    continue block12;
                }
                case 49: {
                    this.startupIPodEntryRadios = mediaListEntry;
                    continue block12;
                }
            }
        }
    }

    public void addSelectionResult(boolean bl, int n, int n2, boolean bl2, long l, long l2, long l3, long l4, long l5) {
        this.logChannel.log(1000000, "[%1.selectionResult] '%2', '%3'", (Object)LOGCLASS, (long)n, (long)n2);
        this.getRunningJob().addSelectionFinished(!bl && n == 0, l4 + l5);
    }

    private AbstractDataBrowseListJob getRunningJob() {
        AbstractDataBrowseListJob abstractDataBrowseListJob = (AbstractDataBrowseListJob)this.queue.getRunningJob();
        if (abstractDataBrowseListJob == null) {
            return new DataBrowserListJobDefault(this.logChannel, this);
        }
        return abstractDataBrowseListJob;
    }

    public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        super.itemSelected(evoListRow, n, n2, n3, n4);
        switch (n) {
            case 200601: {
                this.logChannel.log(1000000, "[%1.itemSelected] DATA_BROWSER_TILED_LIST", (Object)LOGCLASS);
                DataBrowserListRow dataBrowserListRow = (DataBrowserListRow)evoListRow;
                if (!dataBrowserListRow.isEnabled()) {
                    this.logChannel.log(1000000, "[%1.itemSelect] Disabled.", (Object)LOGCLASS, dataBrowserListRow.getEntryID());
                    return;
                }
                if (!dataBrowserListRow.isFile()) {
                    this.getModel(n).fireEvent(n4);
                    return;
                }
                this.selectEntry(new MediaListEntry(dataBrowserListRow.getEntryID(), dataBrowserListRow.getEntryContentType(), ""));
                break;
            }
        }
        this.getModel(n).fireEvent(n4);
    }

    public void itemLongSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    public void itemFocused(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        super.itemFocused(evoListRow, n, n2, n3, n4);
        DataBrowserListRow dataBrowserListRow = (DataBrowserListRow)this.getCurrentFocusedRow();
        if (dataBrowserListRow == null) {
            this.getResourceLocatorModel(200605).setResourceLocator(-1, ResourceLocatorModelApp.UNDEFINED_URI);
            return;
        }
        this.logChannel.log(1000000, "[%1.itemFocused]", (Object)LOGCLASS);
        HMIResourceLocator hMIResourceLocator = dataBrowserListRow.getCoverart();
        this.getResourceLocatorModel(200605).setResourceLocator(hMIResourceLocator.getResourceID(), hMIResourceLocator.getResourceURI());
        this.logChannel.log(1000000, "[%1.itemFocused] resetFocusedItem", (Object)LOGCLASS);
        this.getList().getMenu().resetFocusedItem();
        this.flushList();
    }

    public void keyPressed(int n, int n2, int n3) {
    }

    public void keyReleased(int n, int n2, int n3) {
    }

    public void keyTyped(int n, int n2, int n3) {
        IEvoTransferController iEvoTransferController = MediaEvoUtils.getEvoTransferController(this.getTerminal().getServiceManager());
        boolean bl = this.getBrowsingCategory() == 1;
        switch (n) {
            case 200620: {
                this.logger.hmi().log(1000000, "[%1.keyTyped] DATA_BROWSER_LIST_REPEAT_FOLDER_BUTTON", (Object)LOGCLASS);
                MediaListEntry[] mediaListEntryArray = this.getCurrentBrowsingFolder();
                if (mediaListEntryArray == IBrowseListContext.EMPTY_BROWSE_FOLDER) {
                    return;
                }
                MediaListEntry mediaListEntry = mediaListEntryArray[mediaListEntryArray.length - 1];
                this.blockList();
                this.getModel(n).fireEvent(n3);
                this.queue.enqueue(new DataBrowserListJobRepeatFolderSelection(this.logChannel, this, mediaListEntry, this.getCurrentBrowserListLocator(), this.getType(), this.getBrowseListContext().getBrowserID()));
                break;
            }
            case 200615: {
                this.logger.hmi().log(1000000, "[%1.keyTyped] DATA_BROWSER_LIST_FOLDER_GO_UP_BUTTON", (Object)LOGCLASS);
                this.getModel(200615).fireEvent(n3);
                break;
            }
            case 200461: 
            case 200465: {
                this.logChannel.log(1000000, "[%1.keyTyped] Start transfer folder.", (Object)LOGCLASS);
                if (null == iEvoTransferController) {
                    this.logChannel.log(1000000, "[%1.keyTyped] No EvoTransferController", (Object)LOGCLASS);
                    return;
                }
                iEvoTransferController.startTransfer(false, bl ? 2 : 0, this.getCurrentBrowsingFolder(), -1L, -1);
                this.getList().getMenu().setFocusedItem(this.getList().getID(), FocusAdvice.KEEP_POSITION, this.getCurrentFocusedRow().getUniqueID());
                this.flushList();
                this.getModel(n).fireEvent(n3);
                break;
            }
            case 200449: 
            case 200464: {
                this.logChannel.log(1000000, "[%1.keyTyped] Start transfer file.", (Object)LOGCLASS);
                if (null == iEvoTransferController) {
                    this.logChannel.log(1000000, "[%1.keyTyped] No EvoTransferController", (Object)LOGCLASS);
                    return;
                }
                DataBrowserListRow dataBrowserListRow = (DataBrowserListRow)this.getCurrentFocusedRow();
                if (null == dataBrowserListRow) {
                    this.logChannel.log(1000000, "[%1.keyTyped] No focused row.", (Object)LOGCLASS);
                    return;
                }
                iEvoTransferController.startTransfer(false, bl ? 3 : 1, this.getCurrentBrowsingFolder(), dataBrowserListRow.getEntryID(), dataBrowserListRow.getEntryContentType());
                this.getList().getMenu().setFocusedItem(this.getList().getID(), FocusAdvice.KEEP_POSITION, this.getCurrentFocusedRow().getUniqueID());
                this.flushList();
                this.getModel(n).fireEvent(n3);
                break;
            }
            default: {
                this.logChannel.log(100000, "[%1.keyTyped] Wrong model '%2' typed.", (Object)LOGCLASS, (long)n);
            }
        }
    }

    public void keyLongTyped(int n, int n2, int n3) {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void actionProxyCallPerformed(int n, Map map) {
        switch (n) {
            case 23: {
                DataBrowserListLocator dataBrowserListLocator;
                this.logChannel.log(1000000, "[%1.actionProxyCallPerformed] AP_METHOD_BROWSER_START_BROWSING", (Object)LOGCLASS);
                Integer n2 = (Integer)map.get("BROWSETYPE");
                if (n2 == null) {
                    this.unblockList();
                    return;
                }
                switch (n2) {
                    case 3: {
                        this.logChannel.log(1000000, "[%1.actionProxyCallPerformed] AP_BROWSERTYPE_ALBUM", (Object)LOGCLASS);
                        dataBrowserListLocator = new DataBrowserListLocator(3, 0);
                        break;
                    }
                    case 2: {
                        this.logChannel.log(1000000, "[%1.actionProxyCallPerformed] AP_BROWSERTYPE_TITLE", (Object)LOGCLASS);
                        dataBrowserListLocator = new DataBrowserListLocator(2, 0);
                        break;
                    }
                    case 4: {
                        this.logChannel.log(1000000, "[%1.actionProxyCallPerformed] AP_BROWSERTYPE_ARTIST", (Object)LOGCLASS);
                        dataBrowserListLocator = new DataBrowserListLocator(4, 0);
                        break;
                    }
                    case 1: {
                        this.logChannel.log(1000000, "[%1.actionProxyCallPerformed] AP_BROWSERTYPE_STRUCTURE", (Object)LOGCLASS);
                        dataBrowserListLocator = new DataBrowserListLocator(1, 0);
                        break;
                    }
                    case 9: {
                        this.logChannel.log(1000000, "[%1.actionProxyCallPerformed] AP_BROWSERTYPE_AUDIOBOOKS", (Object)LOGCLASS);
                        dataBrowserListLocator = new DataBrowserListLocator(9, 0);
                        break;
                    }
                    case 10: {
                        this.logChannel.log(1000000, "[%1.actionProxyCallPerformed] AP_BROWSERTYPE_COMPOSERS", (Object)LOGCLASS);
                        dataBrowserListLocator = new DataBrowserListLocator(10, 0);
                        break;
                    }
                    case 5: {
                        this.logChannel.log(1000000, "[%1.actionProxyCallPerformed] AP_BROWSERTYPE_GENRE", (Object)LOGCLASS);
                        dataBrowserListLocator = new DataBrowserListLocator(5, 0);
                        break;
                    }
                    case 6: {
                        this.logChannel.log(1000000, "[%1.actionProxyCallPerformed] AP_BROWSERTYPE_PLAYLISTS", (Object)LOGCLASS);
                        dataBrowserListLocator = new DataBrowserListLocator(6, 0);
                        break;
                    }
                    case 8: {
                        this.logChannel.log(1000000, "[%1.actionProxyCallPerformed] AP_BROWSERTYPE_PODCASTS", (Object)LOGCLASS);
                        dataBrowserListLocator = new DataBrowserListLocator(8, 0);
                        break;
                    }
                    case 7: {
                        this.logChannel.log(1000000, "[%1.actionProxyCallPerformed] AP_BROWSERTYPE_VIDEOS", (Object)LOGCLASS);
                        dataBrowserListLocator = new DataBrowserListLocator(7, 0);
                        break;
                    }
                    case 12: {
                        this.logChannel.log(1000000, "[%1.actionProxyCallPerformed] AP_BROWSERTYPE_RADIO", (Object)LOGCLASS);
                        dataBrowserListLocator = new DataBrowserListLocator(12, 0);
                        break;
                    }
                    default: {
                        this.logChannel.log(1000000, "[%1.actionProxyCallPerformed] Type not supported.", (Object)LOGCLASS);
                        this.unblockList();
                        return;
                    }
                }
                this.selectBrowseListPath(dataBrowserListLocator);
                break;
            }
            case 9: {
                this.logChannel.log(1000000, "[%1.actionProxyCallPerformed] AP_METHOD_CHANGE_TO_PARENT_FOLDER", (Object)LOGCLASS);
                this.changeToParentFolder();
                break;
            }
            case 8: {
                this.logChannel.log(1000000, "[%1.actionProxyCallPerformed] AP_METHOD_CHANGE_TO_ROOT_FOLDER", (Object)LOGCLASS);
                this.changeToRootFolder();
                break;
            }
            case 27: {
                DataBrowserListSelectionData dataBrowserListSelectionData;
                this.logChannel.log(1000000, "[%1.actionProxyCallPerformed] AP_METHOD_BROWSER_RESTORE_SELECTION_PATH restorePossible='%2'", (Object)LOGCLASS, (Object)this.restoreLastSelectionPossible);
                if (!this.restoreLastSelectionPossible) {
                    this.selectBrowseListPath(new DataBrowserListLocator(1, 0));
                    this.getChoiceModel(200628).setValue(1);
                    this.notifyLastBrowseListCategoryChanged(1);
                    break;
                }
                DataBrowserListSelectionData dataBrowserListSelectionData2 = this.getLastSelectionData();
                if (null != dataBrowserListSelectionData2 && this.lastSelectionHandler.getLastCategorySelection() != dataBrowserListSelectionData2.getCategory()) {
                    dataBrowserListSelectionData2 = null;
                }
                if (dataBrowserListSelectionData2 == null) {
                    int n3 = this.lastSelectionHandler.getLastCategorySelection();
                    this.logChannel.log(1000000, "[%1.actionProxyCallPerformed] No last selection available. DefaultCategory: %2", (Object)LOGCLASS, (Object)this.categoryToString(n3));
                    dataBrowserListSelectionData2 = new DataBrowserListSelectionData(n3, 0, DataBrowserList.getDefaultListTypeForCategory(n3));
                }
                if (this.isOnIPOD && this.getTerminal().getConfiguration().isIAP2Supported() && dataBrowserListSelectionData2.getCategory() == 2) {
                    this.logChannel.log(10000, "[%1.actionProxyCallPerformed] AP_METHOD_BROWSER_RESTORE_SELECTION_PATH - Title browser path with iPod on QC. This should never happen. Show Artists instead.", (Object)LOGCLASS);
                    dataBrowserListSelectionData2 = new DataBrowserListSelectionData(4, 0, DataBrowserList.getDefaultListTypeForCategory(4));
                }
                if ((dataBrowserListSelectionData = this.validateLocator(dataBrowserListSelectionData2)) != null) {
                    this.selectBrowseListPath(this.getLocatorForSelection(dataBrowserListSelectionData));
                    this.getChoiceModel(200628).setValue(dataBrowserListSelectionData.getCategory());
                    this.notifyLastBrowseListCategoryChanged(dataBrowserListSelectionData.getCategory());
                    break;
                }
                this.logChannel.log(10000, "[%1.actionProxyCallPerformed] no valid category found!", (Object)LOGCLASS);
                break;
            }
            case 37: {
                Object object = this.getBrowserListMutex();
                synchronized (object) {
                    this.logChannel.log(1000000, "[%1.actionProxyCallPerformed] AP_METHOD_SCREEN_FADED_OUT", (Object)LOGCLASS);
                    if (this.waitScreenFadedOut) {
                        this.logChannel.log(10000000, "[%1.actionProxyCallPerformed] Flush waiting list", (Object)LOGCLASS);
                        this.getModelGroup().flush();
                        this.setChangeFolderRunning(false);
                    }
                    break;
                }
            }
            case 38: {
                Integer n4 = (Integer)map.get("BROWSER_STATE");
                this.logChannel.log(1000000, "[%1.actionProxyCallPerformed] AP_METHOD_SET_BROWSER_ACTIVE '%2'", (Object)LOGCLASS, (Object)n4);
                this.getChoiceModel(200823).setValue(null == n4 ? 0 : n4);
                break;
            }
        }
    }

    private DataBrowserListSelectionData validateLocator(DataBrowserListSelectionData dataBrowserListSelectionData) {
        this.logChannel.log(1000000, "[%1.validateLocator]", (Object)LOGCLASS);
        int n = this.getBrowseListContext().getSlot().getMediaType();
        MediaCapabilities mediaCapabilities = this.getBrowseListContext().getSlot().getCapabilities();
        if (dataBrowserListSelectionData == null) {
            this.logChannel.log(100000000, "[%1.validateLocator] given selection is null, create new one", (Object)LOGCLASS);
            if (mediaCapabilities.isListHandling() && n == 24 || mediaCapabilities.isContentBrowsing()) {
                return new DataBrowserListSelectionData(4, 0, DataBrowserList.getDefaultListTypeForCategory(4));
            }
            if (mediaCapabilities.isRawBrowsing()) {
                return new DataBrowserListSelectionData(1, 0, DataBrowserList.getDefaultListTypeForCategory(1));
            }
            this.logChannel.log(10000, "[%1.validateLocator] no list handling. DataBrowserList must not be active !", (Object)LOGCLASS);
            return null;
        }
        this.logChannel.log(100000000, "[%1.validateLocator] given selection is available", (Object)LOGCLASS);
        HashSet hashSet = new HashSet();
        if (mediaCapabilities.isListHandling() && n == 24 || mediaCapabilities.isContentBrowsing()) {
            hashSet.add(new Integer(3));
            hashSet.add(new Integer(4));
            hashSet.add(new Integer(5));
            hashSet.add(new Integer(2));
        }
        if (mediaCapabilities.isRawBrowsing() && n != 24) {
            hashSet.add(new Integer(1));
        }
        if (mediaCapabilities.isContentBrowsing()) {
            hashSet.add(new Integer(6));
            if (mediaCapabilities.isVideo()) {
                hashSet.add(new Integer(7));
            }
        }
        if (n == 24) {
            hashSet.add(new Integer(10));
            hashSet.add(new Integer(8));
            hashSet.add(new Integer(9));
            if (this.getTerminal().getConfiguration().isIAP2Supported()) {
                hashSet.add(new Integer(12));
            }
        }
        if (hashSet.contains(new Integer(dataBrowserListSelectionData.getCategory()))) {
            this.logChannel.log(100000000, "[%1.validateLocator] given category is supported by active slot", (Object)LOGCLASS);
            if (DataBrowserList.isListTypeOfPathValid(dataBrowserListSelectionData)) {
                this.logChannel.log(100000000, "[%1.validateLocator] listtype matches to category", (Object)LOGCLASS);
                return dataBrowserListSelectionData;
            }
            this.logChannel.log(100000000, "[%1.validateLocator] listtype is not valid for selected category. create new selectionData", (Object)LOGCLASS);
            return new DataBrowserListSelectionData(dataBrowserListSelectionData.getCategory(), 0, DataBrowserList.getDefaultListTypeForCategory(dataBrowserListSelectionData.getCategory()));
        }
        this.logChannel.log(100000000, "[%1.validateLocator] given category is not supported by active slot. create default selection data", (Object)LOGCLASS);
        if (mediaCapabilities.isListHandling() && n == 24 || mediaCapabilities.isContentBrowsing()) {
            return new DataBrowserListSelectionData(4, 0, 3);
        }
        if (mediaCapabilities.isRawBrowsing()) {
            return new DataBrowserListSelectionData(1, 0, 1);
        }
        this.logChannel.log(10000, "[%1.validateLocator] no browsing supported by active slot !", (Object)LOGCLASS);
        return null;
    }

    private static int getDefaultListTypeForCategory(int n) {
        switch (n) {
            case 1: {
                return 1;
            }
            case 2: {
                return 2;
            }
            case 3: 
            case 4: 
            case 5: {
                return 3;
            }
            case 6: {
                return 6;
            }
            case 7: {
                return 7;
            }
            case 8: {
                return 10;
            }
            case 9: {
                return 9;
            }
            case 10: {
                return 8;
            }
            case 11: {
                return 0;
            }
        }
        return 0;
    }

    private static boolean isListTypeOfPathValid(DataBrowserListSelectionData dataBrowserListSelectionData) {
        switch (dataBrowserListSelectionData.getCategory()) {
            case 1: {
                return dataBrowserListSelectionData.getListType() == 1;
            }
            case 2: {
                return dataBrowserListSelectionData.getListType() == 2;
            }
            case 3: {
                return dataBrowserListSelectionData.getListType() == 2 || dataBrowserListSelectionData.getListType() == 3;
            }
            case 4: {
                return dataBrowserListSelectionData.getListType() == 2 || dataBrowserListSelectionData.getListType() == 3 || dataBrowserListSelectionData.getListType() == 4;
            }
            case 5: {
                return dataBrowserListSelectionData.getListType() == 2 || dataBrowserListSelectionData.getListType() == 3 || dataBrowserListSelectionData.getListType() == 4 || dataBrowserListSelectionData.getListType() == 5;
            }
            case 6: {
                return dataBrowserListSelectionData.getListType() == 2 || dataBrowserListSelectionData.getListType() == 6;
            }
            case 7: {
                return dataBrowserListSelectionData.getListType() == 7;
            }
            case 8: {
                return dataBrowserListSelectionData.getListType() == 10;
            }
            case 9: {
                return dataBrowserListSelectionData.getListType() == 9;
            }
            case 10: {
                return dataBrowserListSelectionData.getListType() == 2 || dataBrowserListSelectionData.getListType() == 3 || dataBrowserListSelectionData.getListType() == 8;
            }
        }
        return false;
    }

    private DataBrowserListLocator getLocatorForSelection(DataBrowserListSelectionData dataBrowserListSelectionData) {
        MediaDetailInfo mediaDetailInfo = this.currentDetailInfo;
        if (mediaDetailInfo == null || !mediaDetailInfo.isValid()) {
            this.logChannel.log(1000000, "[%1.getLocatorForSelection] No detail info", (Object)LOGCLASS);
            if (dataBrowserListSelectionData.getPath() == 1) {
                return new DataBrowserListLocator(4, 1);
            }
            return new DataBrowserListLocator(dataBrowserListSelectionData.getCategory(), dataBrowserListSelectionData.getPath());
        }
        if (dataBrowserListSelectionData.getPath() == 1) {
            this.logChannel.log(1000000, "[%1.getLocatorForSelection] PATH_SEARCH", (Object)LOGCLASS);
            if (dataBrowserListSelectionData.getCategory() == 7) {
                this.logChannel.log(1000000, "[%1.getLocatorForSelection] CATEGORY_VIDEOS", (Object)LOGCLASS);
                DataBrowserListLocator dataBrowserListLocator = new DataBrowserListLocator(7, 1);
                if (mediaDetailInfo.isVideo()) {
                    return dataBrowserListLocator.add(DataBrowserListElement.createFocusListElement(mediaDetailInfo.getEntryID(), mediaDetailInfo.getContentType()));
                }
                return dataBrowserListLocator;
            }
            DataBrowserListLocator dataBrowserListLocator = new DataBrowserListLocator(4, 1);
            if (mediaDetailInfo.getArtistID() != 0L && mediaDetailInfo.getAlbumID() != 0L) {
                return dataBrowserListLocator.add(DataBrowserListElement.createDirectoryElement(mediaDetailInfo.getArtistID(), 13)).add(DataBrowserListElement.createDirectoryElement(mediaDetailInfo.getAlbumID(), 14));
            }
            return dataBrowserListLocator;
        }
        DataBrowserListLocator dataBrowserListLocator = new DataBrowserListLocator(dataBrowserListSelectionData.getCategory(), 0);
        switch (dataBrowserListSelectionData.getCategory()) {
            case 4: {
                this.logChannel.log(1000000, "[%1.getLocatorForSelection] CATEGORY_ARTISTS", (Object)LOGCLASS);
                if (dataBrowserListSelectionData.getListType() == 4) {
                    this.logChannel.log(1000000, "[%1.getLocatorPathOfSelection] ARTIST ALL", (Object)LOGCLASS);
                    return dataBrowserListLocator.add(DataBrowserListElement.createFocusListElement(mediaDetailInfo.getArtistID(), 13));
                }
                if (mediaDetailInfo.getArtistID() == 0L || mediaDetailInfo.getAlbumID() == 0L) {
                    this.logChannel.log(1000000, "[%1.getLocatorForSelection] No artistID or albumID", (Object)LOGCLASS);
                    return dataBrowserListLocator;
                }
                return dataBrowserListLocator.add(DataBrowserListElement.createDirectoryElement(mediaDetailInfo.getArtistID(), 13, mediaDetailInfo.getArtist().getOriginalString())).add(DataBrowserListElement.createFocusListElement(mediaDetailInfo.getAlbumID(), 14));
            }
            case 3: {
                this.logChannel.log(1000000, "[%1.getLocatorForSelection] CATEGORY_ALBUMS", (Object)LOGCLASS);
                if (mediaDetailInfo.getAlbumID() == 0L) {
                    this.logChannel.log(1000000, "[%1.getLocatorForSelection] No albumID", (Object)LOGCLASS);
                    return dataBrowserListLocator;
                }
                return dataBrowserListLocator.add(DataBrowserListElement.createFocusListElement(mediaDetailInfo.getAlbumID(), 14));
            }
            case 2: {
                this.logChannel.log(1000000, "[%1.getLocatorForSelection] CATEGORY_TITLES", (Object)LOGCLASS);
                if (mediaDetailInfo.getEntryID() == 0L) {
                    this.logChannel.log(1000000, "[%1.getLocatorForSelection] No entryID", (Object)LOGCLASS);
                    return dataBrowserListLocator;
                }
                return dataBrowserListLocator.add(DataBrowserListElement.createFocusListElement(mediaDetailInfo.getEntryID(), 1));
            }
            case 5: {
                this.logChannel.log(1000000, "[%1.getLocatorForSelection] CATEGORY_GENRES", (Object)LOGCLASS);
                if (mediaDetailInfo.getGenreID() == 0L) {
                    this.logChannel.log(1000000, "[%1.getLocatorForSelection] No genreID", (Object)LOGCLASS);
                    return dataBrowserListLocator;
                }
                if (dataBrowserListSelectionData.getListType() == 5) {
                    this.logChannel.log(1000000, "[%1.getLocatorForSelection] GENRE ALL", (Object)LOGCLASS);
                    return dataBrowserListLocator.add(DataBrowserListElement.createFocusListElement(mediaDetailInfo.getGenreID(), 16));
                }
                dataBrowserListLocator = dataBrowserListLocator.add(DataBrowserListElement.createDirectoryElement(mediaDetailInfo.getGenreID(), 16));
                if (mediaDetailInfo.getArtistID() == 0L) {
                    this.logChannel.log(1000000, "[%1.getLocatorForSelection] No artistID", (Object)LOGCLASS);
                    return dataBrowserListLocator;
                }
                if (dataBrowserListSelectionData.getListType() == 4) {
                    this.logChannel.log(1000000, "[%1.getLocatorForSelection] ARTISTS ALL", (Object)LOGCLASS);
                    return dataBrowserListLocator.add(DataBrowserListElement.createFocusListElement(mediaDetailInfo.getArtistID(), 13));
                }
                if (mediaDetailInfo.getAlbumID() == 0L) {
                    this.logChannel.log(1000000, "[%1.getLocatorForSelection] No albumID", (Object)LOGCLASS);
                    return dataBrowserListLocator;
                }
                return dataBrowserListLocator.add(DataBrowserListElement.createDirectoryElement(mediaDetailInfo.getArtistID(), 13)).add(DataBrowserListElement.createFocusListElement(mediaDetailInfo.getAlbumID(), 14));
            }
            case 7: {
                this.logChannel.log(1000000, "[%1.getLocatorForSelection] CATEGORY_VIDEOS", (Object)LOGCLASS);
                if (!mediaDetailInfo.isVideo()) {
                    this.logChannel.log(1000000, "[%1.getLocatorForSelection] Not a video", (Object)LOGCLASS);
                    return dataBrowserListLocator;
                }
                return dataBrowserListLocator.add(DataBrowserListElement.createFocusListElement(mediaDetailInfo.getEntryID(), 2));
            }
            case 1: {
                this.logChannel.log(1000000, "[%1.getLocatorForSelection] CATEGORY_PHYSICAL", (Object)LOGCLASS);
                MediaListEntry[] mediaListEntryArray = mediaDetailInfo.getPlayingTrack().getPlaybackFolder();
                for (int i2 = 1; i2 < mediaListEntryArray.length; ++i2) {
                    dataBrowserListLocator = dataBrowserListLocator.add(DataBrowserListElement.createDirectoryElement(mediaListEntryArray[i2].getEntryID(), mediaListEntryArray[i2].getContentType(), mediaListEntryArray[i2].getFilename().getOriginalString()));
                }
                return dataBrowserListLocator.add(DataBrowserListElement.createFocusListElement(mediaDetailInfo.getEntryID(), mediaDetailInfo.getContentType()));
            }
        }
        this.logChannel.log(1000000, "[%1.getLocatorForSelection] DEFAULT", (Object)LOGCLASS);
        return dataBrowserListLocator;
    }

    public void selectEntry(MediaListEntry mediaListEntry) {
        this.logChannel.log(1000000, "[%1.selectEntry] '%2'", (Object)LOGCLASS, (Object)mediaListEntry);
        if (mediaListEntry.isFolder()) {
            this.logChannel.log(1000000, "[%1.selectEntry] Folder selected.", (Object)LOGCLASS);
            this.changeToSubFolder(mediaListEntry);
            return;
        }
        this.logChannel.log(1000000, "[%1.selectEntry] File selected ('%2').", (Object)LOGCLASS, mediaListEntry.getEntryID());
        MediaListEntry[] mediaListEntryArray = this.getCurrentBrowsingFolder();
        if (mediaListEntryArray == IBrowseListContext.EMPTY_BROWSE_FOLDER) {
            this.logChannel.log(1000000, "[%1.selectEntry] No browsing folder.", (Object)LOGCLASS);
            return;
        }
        boolean bl = false;
        MediaListEntry mediaListEntry2 = mediaListEntryArray[mediaListEntryArray.length - 1];
        try {
            MediaListEntry mediaListEntry3;
            if (this.implicitRepeatHandler.isImplicitRepeatByCategory(this.getBrowsingCategory())) {
                this.logChannel.log(1000000, "[%1.selectEntry] Only folder for selection.", (Object)LOGCLASS);
                switch (this.getBrowsingCategory()) {
                    case 3: 
                    case 4: 
                    case 5: {
                        mediaListEntry3 = mediaListEntryArray[this.isOnIPOD ? 3 : 2];
                        break;
                    }
                    case 8: 
                    case 10: {
                        mediaListEntry3 = mediaListEntryArray[3];
                        break;
                    }
                    case 9: {
                        mediaListEntry3 = mediaListEntryArray[2];
                        break;
                    }
                    case 7: {
                        if (this.isOnIPOD) {
                            mediaListEntry3 = mediaListEntryArray[2];
                            break;
                        }
                        mediaListEntry3 = mediaListEntryArray[mediaListEntryArray.length - 1];
                        break;
                    }
                    case 12: {
                        mediaListEntry3 = mediaListEntry;
                        bl = true;
                        break;
                    }
                    default: {
                        mediaListEntry3 = mediaListEntryArray[mediaListEntryArray.length - 1];
                        break;
                    }
                }
            } else if (mediaListEntry2.isPlaylist()) {
                this.logChannel.log(1000000, "[%1.selectEntry] Playlist folder.", (Object)LOGCLASS);
                mediaListEntry3 = mediaListEntryArray[mediaListEntryArray.length - 1];
            } else {
                this.logChannel.log(1000000, "[%1.selectEntry] Hole medium for selection.", (Object)LOGCLASS);
                switch (this.getBrowsingCategory()) {
                    case 3: 
                    case 4: 
                    case 5: {
                        mediaListEntry3 = mediaListEntryArray[this.isOnIPOD ? 2 : 1];
                        break;
                    }
                    case 8: 
                    case 9: 
                    case 10: {
                        mediaListEntry3 = mediaListEntryArray[2];
                        break;
                    }
                    case 7: {
                        if (this.isOnIPOD) {
                            mediaListEntry3 = mediaListEntryArray[2];
                            break;
                        }
                        mediaListEntry3 = mediaListEntryArray[mediaListEntryArray.length - 1];
                        break;
                    }
                    case 1: {
                        this.logChannel.log(1000000, "[%1.selectEntry] Root folder.", (Object)LOGCLASS);
                        mediaListEntry3 = mediaListEntryArray[0];
                        break;
                    }
                    default: {
                        mediaListEntry3 = mediaListEntryArray[mediaListEntryArray.length - 1];
                    }
                }
            }
            this.blockList();
            this.queue.enqueue(new DataBrowserListJobAddSelection(this.logChannel, this, mediaListEntry3, bl ? 0L : mediaListEntry.getEntryID(), mediaListEntry.isVideoFile(), this.getCurrentBrowserListLocator(), this.getType(), this.getBrowseListContext().getBrowserID()));
        }
        catch (Exception exception) {
            Buffer buffer = new Buffer(100);
            buffer.append("Browsing category='").append(this.getBrowsingCategory()).append("', folderLength='").append(mediaListEntryArray.length).append("', isIPod='").append(this.isOnIPOD).append("'.");
            this.logChannel.log(100000, "[%1.selectEntry] Exception occurred: %2", (Object)LOGCLASS, (Object)buffer.toString());
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void setChangeFolderRunning(boolean bl) {
        boolean bl2 = this.getCurrentBrowserListLocator().getCategory() == 1;
        this.logChannel.log(1000000, "[%1.setChangeFolderRunning] meta='%2' raw='%3'", (Object)LOGCLASS, (Object)String.valueOf(this.metaSyncComplete), (Object)String.valueOf(this.filesystemSyncComplete));
        this.getChoiceModel(200875).setValue(bl ? 1 : 0);
        if (!(!bl || this.metaSyncComplete || bl2 && this.filesystemSyncComplete)) {
            this.logChannel.log(1000000, "[%1.setChangeFolderRunning] No Waiting for fade out.", (Object)LOGCLASS);
            return;
        }
        Object object = this.getBrowserListMutex();
        synchronized (object) {
            this.waitScreenFadedOut = bl;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void flushList() {
        Object object = this.getBrowserListMutex();
        synchronized (object) {
            this.logChannel.log(1000000, "[%1.flushList]", (Object)LOGCLASS);
            if (!this.waitScreenFadedOut) {
                this.logChannel.log(1000000, "[%1.flushList] call super flushList", (Object)LOGCLASS);
                super.flushList();
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void requestItems(int n, int n2, int n3, int n4, int n5) {
        Object object = this.getBrowserListMutex();
        synchronized (object) {
            if (this.waitScreenFadedOut) {
                this.logChannel.log(1000000, "[%1.requestItems] Waiting for screen fade out.", (Object)LOGCLASS);
                this.getList().setRows(n3, n, new EvoListRow[0]);
                return;
            }
        }
        super.requestItems(n, n2, n3, n4, n5);
    }

    public void notifyMetadataEntryAvailable(boolean bl) {
        super.notifyMetadataEntryAvailable(bl);
        if (this.getBrowseListContext().getSlot().getMediaType() == 24 && !this.getBrowseListContext().getSlot().getCapabilities().isSearch()) {
            return;
        }
        this.metaSyncComplete = bl;
    }

    public void notifyFilesystemEntryAvailable(boolean bl) {
        super.notifyFilesystemEntryAvailable(bl);
        this.filesystemSyncComplete = bl;
    }

    public void notifyCoverartsAvailable(boolean bl) {
        this.logChannel.log(1000000, "[%1.notifyCoverartsAvailable]", (Object)LOGCLASS);
        if (bl && !this.isOnBrowsingStartup()) {
            this.updateListAroundFocus();
        }
    }

    public String toString() {
        Buffer buffer = new Buffer(20);
        buffer.append(LOGCLASS).append("@").append(this.hashCode());
        return buffer.toString();
    }

    public String categoryToString(int n) {
        switch (n) {
            case 1: {
                return "CATEGORY_PHYSICAL";
            }
            case 2: {
                return "CATEGORY_TITLES";
            }
            case 3: {
                return "CATEGORY_ALBUMS";
            }
            case 4: {
                return "CATEGORY_ARTISTS";
            }
            case 5: {
                return "CATEGORY_GENRES";
            }
            case 6: {
                return "CATEGORY_PLAYLISTS";
            }
            case 7: {
                return "CATEGORY_VIDEOS";
            }
            case 8: {
                return "CATEGORY_PODCASTS";
            }
            case 9: {
                return "CATEGORY_AUDIOBOOKS";
            }
            case 10: {
                return "CATEGORY_COMPOSERS";
            }
            case 11: {
                return "CATEGORY_FAVORITES";
            }
            case 12: {
                return "CATEGORY_RADIO";
            }
        }
        return "UNKNOWN";
    }

    public IPlayer getPlayer() {
        return this.player;
    }

    public void playbackFolderChanged(MediaListEntry[] mediaListEntryArray) {
    }

    public void unblockList() {
        if (!this.queue.contains(class$de$audi$app$media$evo$content$data$DataBrowserListJobSelectBrowseListPath == null ? (class$de$audi$app$media$evo$content$data$DataBrowserListJobSelectBrowseListPath = DataBrowserList.class$("de.audi.app.media.evo.content.data.DataBrowserListJobSelectBrowseListPath")) : class$de$audi$app$media$evo$content$data$DataBrowserListJobSelectBrowseListPath)) {
            super.unblockList();
        } else {
            this.logChannel.log(1000000, "[%1.unblockList] filter unblock if SELECT_PATH in queue", (Object)LOGCLASS);
        }
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

