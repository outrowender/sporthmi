/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.evo.presets;

import de.audi.app.media.AbstractMediaTerminalComponent;
import de.audi.app.media.IMediaTerminal;
import de.audi.app.media.content.IContentMedia;
import de.audi.app.media.diagnosis.IDiagnosisCommandProvider;
import de.audi.app.media.dsi.media.MediaListEntry;
import de.audi.app.media.evo.content.data.DataBrowserListRow;
import de.audi.app.media.evo.content.data.DataPlayerPlayViewListRow;
import de.audi.app.media.evo.content.data.favorites.FavoritesListRow;
import de.audi.app.media.evo.content.data.favorites.IFavoriteSelectionListener;
import de.audi.app.media.evo.content.data.favorites.MediaFavorite;
import de.audi.app.media.evo.presets.MediaPreset;
import de.audi.app.media.evo.presets.MediaPresetData;
import de.audi.app.media.evo.presets.MediaPresetHandler$1;
import de.audi.app.media.evo.presets.MediaPresetHandler$2;
import de.audi.app.media.evo.presets.MediaPresetHandler$3;
import de.audi.app.media.evo.utils.MediaEvoUtils;
import de.audi.app.media.i18n.I18NString;
import de.audi.app.media.logger.LogUtil;
import de.audi.app.media.selection.DataSelectionContainer;
import de.audi.app.media.selection.IDataSelectionContext;
import de.audi.app.media.selection.ISelectionListener;
import de.audi.app.media.selection.PresetSelectionJob;
import de.audi.app.media.selection.SelectionBrowser;
import de.audi.app.media.source.ISource;
import de.audi.app.media.source.ISourceResolver;
import de.audi.app.media.source.ISourceSlot;
import de.audi.app.media.source.MediaSourceSlot;
import de.audi.atip.hmi.model.PresetListRow;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.atip.preset.DefinitionRequest;
import de.audi.atip.preset.ExecuteRequest;
import de.audi.atip.preset.IAppPresetDefinitionHandler;
import de.audi.atip.preset.IAppPresetExecutionHandler;
import de.audi.atip.preset.Preset;
import de.audi.atip.util.Util;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Hashtable;
import org.osgi.framework.ServiceRegistration;

public class MediaPresetHandler
extends AbstractMediaTerminalComponent
implements IAppPresetDefinitionHandler,
IDiagnosisCommandProvider,
IAppPresetExecutionHandler,
ISelectionListener {
    private static final int PRESET_ERROR_NONE;
    private static final int PRESET_ERROR_FILE_NOT_FOUND;
    private static final int PRESET_ERROR_DEVICE_NOT_FOUND;
    private static final String LOGCLASS;
    private final LogChannel logger;
    private final IFavoriteSelectionListener favoritesPlayer;
    private final ISourceResolver sourceResolver;
    private volatile ServiceRegistration registerDefinitionService;
    private volatile ServiceRegistration registerExecutionService;
    private volatile MediaPreset preset;
    private volatile ExecuteRequest currentRequest;
    private volatile HashMap diagPresetMap;
    static /* synthetic */ Class class$de$audi$atip$preset$IAppPresetDefinitionHandler;
    static /* synthetic */ Class class$de$audi$atip$preset$IAppPresetExecutionHandler;

    public MediaPresetHandler(IMediaTerminal iMediaTerminal, IFavoriteSelectionListener iFavoriteSelectionListener) {
        super(iMediaTerminal);
        this.logger = iMediaTerminal.getLogger().main();
        this.favoritesPlayer = iFavoriteSelectionListener;
        this.sourceResolver = iMediaTerminal.getSourceResolver();
    }

    public void init() {
        this.logger.log(1078071040, "[%1.init]", (Object)"MediaPresetHandler");
        this.registerDefinitionService = this.getTerminal().getServiceManager().registerService(class$de$audi$atip$preset$IAppPresetDefinitionHandler == null ? (class$de$audi$atip$preset$IAppPresetDefinitionHandler = MediaPresetHandler.class$("de.audi.atip.preset.IAppPresetDefinitionHandler")) : class$de$audi$atip$preset$IAppPresetDefinitionHandler, this, new Hashtable(0));
        this.registerExecutionService = this.getTerminal().getServiceManager().registerService(class$de$audi$atip$preset$IAppPresetExecutionHandler == null ? (class$de$audi$atip$preset$IAppPresetExecutionHandler = MediaPresetHandler.class$("de.audi.atip.preset.IAppPresetExecutionHandler")) : class$de$audi$atip$preset$IAppPresetExecutionHandler, this, new Hashtable(0));
        this.getTerminal().getDiagnosisManager().addCommandProvider(-1, this);
    }

    public void deinit() {
        this.logger.log(1078071040, "[%1.deinit]", (Object)"MediaPresetHandler");
        this.getTerminal().getServiceManager().unregisterService(this.registerDefinitionService);
        this.getTerminal().getServiceManager().unregisterService(this.registerExecutionService);
    }

    public void activate() {
        this.logger.log(1078071040, "[%1.activate]", (Object)"MediaPresetHandler");
    }

    public void deactivate() {
        this.logger.log(1078071040, "[%1.deactivate]", (Object)"MediaPresetHandler");
    }

    @Override
    public int getType() {
        return 1;
    }

    @Override
    public int[] getModelIds() {
        return new int[]{-1727069440, -1072758016, -686882048, -1777401088};
    }

    @Override
    public void requestDefinition(DefinitionRequest definitionRequest) {
        ISourceSlot iSourceSlot = this.getTerminal().getSourceController().getSelectedSlot();
        if (!iSourceSlot.getSource().getSlot(iSourceSlot).getFlags().isMetaDataSyncComplete()) {
            this.logger.log(1078071040, "[%1.requestDefinition] Metadata Sync not complete.", (Object)"MediaPresetHandler");
            definitionRequest.responseDefine(2, null, definitionRequest.getPreview(), 2);
            return;
        }
        MediaPreset mediaPreset = this.getMediaPreset(definitionRequest.getModelId(), definitionRequest.getRowId());
        if (null == mediaPreset || !this.validateMediaPreset(mediaPreset)) {
            this.logger.log(1078071040, "[%1.requestDefinition] Media row null for presets.", (Object)"MediaPresetHandler");
            definitionRequest.responseDefine(2, null, definitionRequest.getPreview(), 2);
            return;
        }
        this.logger.log(1078071040, "[%1.requestDefinition] %2", (Object)"MediaPresetHandler", (Object)mediaPreset.toString());
        PresetListRow presetListRow = new PresetListRow();
        presetListRow.setRecordSet(0);
        presetListRow.setMainLabel(mediaPreset.getName());
        presetListRow.setSubLabel(mediaPreset.getSourcename());
        definitionRequest.responseDefine(0, mediaPreset.getSerializablePreset(), presetListRow, 2);
    }

    private boolean validateMediaPreset(MediaPreset mediaPreset) {
        ISource iSource = mediaPreset.getPresetSlot().getSource();
        switch (iSource.getType()) {
            case 5: 
            case 6: {
                break;
            }
            case 10: {
                if (24 != mediaPreset.getPresetSlot().getMediaType()) break;
                this.logger.log(1078071040, "[%1.validateMediaPreset] Invalid preset iPod", (Object)"MediaPresetHandler");
                return false;
            }
            default: {
                this.logger.log(1078071040, "[%1.validateMediaPreset] Wrong source %2", (Object)"MediaPresetHandler", (long)iSource.getType());
                return false;
            }
        }
        I18NString i18NString = mediaPreset.getFavoriteEntry();
        switch (i18NString.getI18NKey()) {
            case 19: 
            case 20: 
            case 21: 
            case 22: 
            case 23: 
            case 24: 
            case 25: 
            case 26: 
            case 27: 
            case 28: 
            case 29: 
            case 46: 
            case 47: 
            case 48: {
                this.logger.log(1078071040, "[%1.validateMediaPreset] Wrong entry type %2.", (Object)"MediaPresetHandler", (long)i18NString.getI18NKey());
                return false;
            }
        }
        this.logger.log(1078071040, "[%1.validateMediaPreset] Valid.", (Object)"MediaPresetHandler");
        return true;
    }

    @Override
    public void requestExecute(ExecuteRequest executeRequest) {
        this.logger.log(1078071040, "[%1.requestExecute]", (Object)"MediaPresetHandler");
        ChoiceModelApp choiceModelApp = this.getChoiceModel(-1089469696);
        ChoiceModelApp choiceModelApp2 = this.getChoiceModel(873530112);
        choiceModelApp.setValue(0);
        this.currentRequest = executeRequest;
        Serializable serializable = executeRequest.getPreset().getData();
        if (serializable instanceof MediaPresetData) {
            this.preset = MediaPreset.getMediaPresetFromSerializable(this.logger, (MediaPresetData)serializable, this.sourceResolver, this);
            if (null == this.preset) {
                this.logger.log(1078071040, "[%1.requestExecute] Preset is not available.", (Object)"MediaPresetHandler");
                executeRequest.responseExecute(1);
                return;
            }
            if (!this.preset.isPresetSourceActivatable()) {
                this.logger.log(1078071040, "[%1.requestExecute] Source is not activatable.", (Object)"MediaPresetHandler");
                choiceModelApp.setValue(2);
                executeRequest.responseExecute(1);
                return;
            }
            int n = this.preset.getPresetSlot().getIndex();
            ISourceSlot iSourceSlot = this.preset.getPresetSlot().getSource().getSlot(n);
            if (iSourceSlot.getSource().getType() == 6 && iSourceSlot.getError() == 22) {
                this.logger.log(1078071040, "[%1.requestExecute] Jukebox is empty.", (Object)"MediaPresetHandler");
                choiceModelApp.setValue(1);
                executeRequest.responseExecute(1);
                return;
            }
            this.logger.log(1078071040, "[%1.requestExecute] Slot to activate: '%2'", (Object)"MediaPresetHandler", (Object)iSourceSlot);
            if (!iSourceSlot.getFlags().isMetaDataSyncComplete()) {
                this.logger.log(1078071040, "[%1.requestExecute] Source is not ready, metadata still syncing.", (Object)"MediaPresetHandler");
                choiceModelApp.setValue(2);
                executeRequest.responseExecute(1);
                return;
            }
            this.logger.log(1078071040, "[%1.requestExecute] %2 %3", (Object)"MediaPresetHandler", (Object)this.preset.getPresetSlot(), (Object)this.preset.toString());
            MediaSourceSlot mediaSourceSlot = (MediaSourceSlot)this.getTerminal().getSourceController().getSelectedSlot();
            if (null != mediaSourceSlot && 4 == mediaSourceSlot.getSource().getType()) {
                this.logger.log(1078071040, "[%1.requestExecute] Fileplayer is active, no preset support.", (Object)"MediaPresetHandler");
                choiceModelApp.setValue(1);
                executeRequest.responseExecute(1);
                return;
            }
            MediaSourceSlot mediaSourceSlot2 = (MediaSourceSlot)this.preset.getPresetSlot();
            if (!this.getTerminal().getAudioManager().hasFrontAudioFocus()) {
                this.logger.log(1078071040, "[%1.requestExecute] Activate preset switching screen.", (Object)"MediaPresetHandler");
                choiceModelApp2.setStatus(0);
            }
            if (null != mediaSourceSlot && mediaSourceSlot.getSource().getType() == mediaSourceSlot2.getSource().getType() && Util.equals(mediaSourceSlot.getUniqueMediaId(), mediaSourceSlot2.getUniqueMediaId())) {
                this.logger.log(1078071040, "[%1.requestExecute] Source already active.", (Object)"MediaPresetHandler");
                this.triggerPlayPreset();
            } else {
                this.logger.log(1078071040, "[%1.requestExecute] Source not active.", (Object)"MediaPresetHandler");
                this.triggerPresetActivation();
            }
        } else {
            this.logger.log(1078071040, "[%1.requestExecute] Wrong instance type.", (Object)"MediaPresetHandler");
            executeRequest.responseExecute(1);
        }
    }

    private void triggerPresetActivation() {
        this.logger.log(1078071040, "[%1.triggerPresetActivation]", (Object)"MediaPresetHandler");
        MediaListEntry[] mediaListEntryArray = this.preset.getFavoritePath();
        MediaListEntry mediaListEntry = mediaListEntryArray[mediaListEntryArray.length - 1];
        DataSelectionContainer dataSelectionContainer = new DataSelectionContainer(this.preset.getPresetSlot(), this.preset.getBrowseType(), mediaListEntryArray, mediaListEntry, null);
        SelectionBrowser selectionBrowser = this.getTerminal().getSelectionBrowser();
        selectionBrowser.enqueueSelectionJob(new PresetSelectionJob(selectionBrowser, dataSelectionContainer, this.getTerminal().getSourceController(), this.logger, this));
    }

    @Override
    public void notifySelectionChanged(IDataSelectionContext iDataSelectionContext, boolean bl) {
        this.logger.log(1078071040, "[%1.playFavoriteSelectionDone] %2", (Object)"MediaPresetHandler", (Object)(bl ? "OK" : "NOK"));
        this.getTerminal().getAudioManager().requestAudioFocus();
        ChoiceModelApp choiceModelApp = this.getChoiceModel(-1089469696);
        choiceModelApp.setValue(0);
        if (!bl) {
            choiceModelApp.setValue(1);
            this.getChoiceModel(873530112).setStatus(1);
        }
        this.currentRequest.responseExecute(bl ? 0 : 1);
    }

    private void triggerPlayPreset() {
        this.logger.log(1078071040, "[%1.triggerPlayPreset]", (Object)"MediaPresetHandler");
        this.favoritesPlayer.playFavoriteSelection(this.preset, new MediaPresetHandler$1(this));
    }

    private MediaPreset getMediaPreset(int n, int n2) {
        this.logger.log(1078071040, "[%1.getMediaPreset]", (Object)"MediaPresetHandler");
        MediaPreset mediaPreset = null;
        ISourceSlot iSourceSlot = this.getTerminal().getSourceController().getSelectedSlot();
        block0 : switch (n) {
            case 200601: {
                DataBrowserListRow dataBrowserListRow = (DataBrowserListRow)this.getBaseListModel(-1727069440).getRow(n2);
                if (null == dataBrowserListRow) {
                    return null;
                }
                int n3 = this.getChoiceModel(-1274084608).getValue();
                switch (n3) {
                    case 1: 
                    case 3: 
                    case 4: 
                    case 5: 
                    case 6: {
                        mediaPreset = this.createPresetForBrowserList(iSourceSlot, dataBrowserListRow, n3);
                        break block0;
                    }
                    case 7: {
                        mediaPreset = this.createPresetForVideos(iSourceSlot, dataBrowserListRow);
                        break block0;
                    }
                    case 2: {
                        mediaPreset = this.createPresetForTitles(iSourceSlot, dataBrowserListRow);
                        break block0;
                    }
                }
                this.logger.log(10000, "[%1.getMediaPreset] not supported category: '%2'", (Object)"MediaPresetHandler", (Object)LogUtil.getBrowserCategoryString(this.getChoiceModel(-1274084608).getValue()));
                return null;
            }
            case 200640: {
                DataPlayerPlayViewListRow dataPlayerPlayViewListRow = (DataPlayerPlayViewListRow)this.getBaseListModel(-1072758016).getRow(n2);
                if (null == dataPlayerPlayViewListRow) {
                    return null;
                }
                IContentMedia iContentMedia = (IContentMedia)this.getTerminal().getContentManager().getActiveContent();
                if (!dataPlayerPlayViewListRow.isPlaying() && !iContentMedia.getPlayer().supportsExtendedPlayView()) {
                    return null;
                }
                if (dataPlayerPlayViewListRow.isAudio()) {
                    MediaListEntry[] mediaListEntryArray = MediaEvoUtils.createDefaultAlbumpath(dataPlayerPlayViewListRow.getArtist());
                    MediaListEntry mediaListEntry = MediaEvoUtils.createAlbumMediaListEntry(dataPlayerPlayViewListRow.getAlbum(), dataPlayerPlayViewListRow.getArtist());
                    mediaPreset = new MediaPreset(this.logger, iSourceSlot, mediaListEntry, mediaListEntryArray, 1, this);
                    break;
                }
                if (!dataPlayerPlayViewListRow.isVideo()) break;
                mediaPreset = this.createVideoPreset(iSourceSlot);
                break;
            }
            case 200663: {
                long l = this.getBaseListModel(-1072758016).getSelected().getUniqueID();
                DataPlayerPlayViewListRow dataPlayerPlayViewListRow = (DataPlayerPlayViewListRow)this.getBaseListModel(-1072758016).getRowByUniqueID(l);
                if (null == dataPlayerPlayViewListRow || !dataPlayerPlayViewListRow.isVideo()) {
                    return null;
                }
                mediaPreset = this.createVideoPreset(iSourceSlot);
                break;
            }
            case 200598: {
                FavoritesListRow favoritesListRow = (FavoritesListRow)this.getBaseListModel(-1777401088).getRow(n2);
                if (null == favoritesListRow) {
                    return null;
                }
                MediaFavorite mediaFavorite = favoritesListRow.getMediaFavorite();
                mediaPreset = new MediaPreset(this.logger, iSourceSlot, mediaFavorite, this);
                break;
            }
            default: {
                this.logger.log(10000, "[%1.requestDefinition] Model is not supported.", (Object)"MediaPresetHandler");
                return null;
            }
        }
        return mediaPreset;
    }

    private MediaPreset createPresetForTitles(ISourceSlot iSourceSlot, DataBrowserListRow dataBrowserListRow) {
        this.logger.log(1078071040, "[%1.getMediaPreset] database browsing title browser", (Object)"MediaPresetHandler");
        MediaListEntry[] mediaListEntryArray = MediaEvoUtils.createDefaultAlbumpath(dataBrowserListRow.getArtist());
        MediaListEntry mediaListEntry = MediaEvoUtils.createAlbumMediaListEntry(dataBrowserListRow.getAlbum(), dataBrowserListRow.getArtist());
        return new MediaPreset(this.logger, iSourceSlot, mediaListEntry, mediaListEntryArray, 1, this);
    }

    private MediaPreset createPresetForVideos(ISourceSlot iSourceSlot, DataBrowserListRow dataBrowserListRow) {
        MediaListEntry[] mediaListEntryArray = dataBrowserListRow.getFolderStack();
        this.logger.log(1078071040, "[%1.getMediaPreset] database browsing category Videos", (Object)"MediaPresetHandler");
        MediaListEntry[] mediaListEntryArray2 = new MediaListEntry[mediaListEntryArray.length - 1];
        System.arraycopy((Object)mediaListEntryArray, 0, (Object)mediaListEntryArray2, 0, mediaListEntryArray.length - 1);
        return new MediaPreset(this.logger, iSourceSlot, mediaListEntryArray[mediaListEntryArray.length - 1], mediaListEntryArray2, 1, this);
    }

    private MediaPreset createPresetForBrowserList(ISourceSlot iSourceSlot, DataBrowserListRow dataBrowserListRow, int n) {
        int n2;
        this.logger.log(1078071040, "[%1.getMediaPreset] database browsing category: %2", (Object)"MediaPresetHandler", (Object)LogUtil.getBrowserCategoryString(n));
        int n3 = n2 = n == 1 ? 0 : 1;
        if (dataBrowserListRow.isPlayListContent() && n2 == 0) {
            return new MediaPreset(this.logger, iSourceSlot, dataBrowserListRow.getFolderMediaEntry(), dataBrowserListRow.getFolderStack(), 4, this);
        }
        if (dataBrowserListRow.isFolder()) {
            return new MediaPreset(this.logger, iSourceSlot, dataBrowserListRow.getFolderMediaEntry(), dataBrowserListRow.getFolderStack(), n2, this);
        }
        MediaListEntry[] mediaListEntryArray = dataBrowserListRow.getFolderStack();
        MediaListEntry mediaListEntry = mediaListEntryArray[mediaListEntryArray.length - 1];
        MediaListEntry[] mediaListEntryArray2 = new MediaListEntry[mediaListEntryArray.length - 1];
        System.arraycopy((Object)mediaListEntryArray, 0, (Object)mediaListEntryArray2, 0, mediaListEntryArray2.length);
        return new MediaPreset(this.logger, iSourceSlot, mediaListEntry, mediaListEntryArray2, n2, this);
    }

    private MediaPreset createVideoPreset(ISourceSlot iSourceSlot) {
        MediaListEntry[] mediaListEntryArray = MediaEvoUtils.createRootPath();
        MediaListEntry mediaListEntry = MediaEvoUtils.createVideosEntry();
        return new MediaPreset(this.logger, iSourceSlot, mediaListEntry, mediaListEntryArray, 1, this);
    }

    @Override
    public String[] getDiagKeys() {
        return new String[]{"storePreset(id|modelId|rowIndex)", "playPreset(id)"};
    }

    @Override
    public void executeDiagCommand(String string, String[] stringArray) {
        if (this.diagPresetMap == null) {
            this.diagPresetMap = new HashMap();
        }
        if ("storePreset(id|modelId|rowIndex)".equals(string)) {
            this.requestDefinition(new DefinitionRequest(new MediaPresetHandler$2(this, stringArray), 1, Integer.parseInt(stringArray[1]), Integer.parseInt(stringArray[2]), -1, null));
        } else if ("playPreset(id)".equals(string)) {
            this.requestExecute(new ExecuteRequest(new MediaPresetHandler$3(this), new Preset(1, -1, 1, null, (Serializable)this.diagPresetMap.get(stringArray[0]), 2)));
        }
    }

    @Override
    public int getExecutionType() {
        return 2;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static /* synthetic */ LogChannel access$000(MediaPresetHandler mediaPresetHandler) {
        return mediaPresetHandler.logger;
    }

    static /* synthetic */ ExecuteRequest access$100(MediaPresetHandler mediaPresetHandler) {
        return mediaPresetHandler.currentRequest;
    }

    static /* synthetic */ HashMap access$200(MediaPresetHandler mediaPresetHandler) {
        return mediaPresetHandler.diagPresetMap;
    }
}

