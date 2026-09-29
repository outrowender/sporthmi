/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.combi.bap;

import de.audi.app.media.AbstractMediaTerminalComponent;
import de.audi.app.media.IMediaTerminal;
import de.audi.app.media.combi.bap.CombiBAPController$1;
import de.audi.app.media.combi.bap.CombiBAPController$CombiBapState;
import de.audi.app.media.combi.bap.CombiBAPIdMapper;
import de.audi.app.media.combi.bap.CombiBAPMediaEntry;
import de.audi.app.media.combi.bap.CombiBAPServiceListenerImpl;
import de.audi.app.media.combi.bap.CombiBAPSourceListener;
import de.audi.app.media.combi.bap.CombiBAPTransferStateListener;
import de.audi.app.media.combi.bap.CombiBAPUtils;
import de.audi.app.media.combi.bap.ICombiBAPContentAccessor;
import de.audi.app.media.combi.bap.ICombiBAPContentAdapter;
import de.audi.app.media.combi.bap.NullCombiBAPServiceMedia;
import de.audi.app.media.combi.bap.fileplayer.CombiBAPFilePlayerContentAdapter;
import de.audi.app.media.combi.bap.online.CombiBAPOnlineContentAdapter;
import de.audi.app.media.combi.bap.playview.CombiBAPPlayViewContentAdapter;
import de.audi.app.media.combi.bap.stream.NoDataCombiAdapter;
import de.audi.app.media.content.IContent;
import de.audi.app.media.content.IContentListener;
import de.audi.app.media.content.media.PlayTime;
import de.audi.app.media.content.media.utils.MediaUtils;
import de.audi.app.media.diagnosis.IDiagnosisDataProvider;
import de.audi.app.media.dsi.media.MediaListEntry;
import de.audi.app.media.i18n.I18NString;
import de.audi.app.media.logger.LogUtil;
import de.audi.app.media.osgi.IServiceTracker;
import de.audi.app.media.source.ActiveSourceState;
import de.audi.app.media.source.ISourceSlot;
import de.audi.atip.interapp.bap.data.TimeStamp;
import de.audi.atip.interapp.combi.bap.audio.CombiBAPServiceMedia;
import de.audi.atip.interapp.combi.bap.audio.data.CombiBAPAudioSource;
import de.audi.atip.interapp.combi.bap.audio.data.CombiBAPCurrentStationInfo;
import de.audi.atip.interapp.combi.bap.audio.data.CombiBAPMediaBrowserListEntry;
import de.audi.atip.interapp.combi.bap.audio.data.PlayPosition;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.Buffer;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import org.dsi.ifc.global.ResourceLocator;
import org.osgi.framework.ServiceRegistration;

public class CombiBAPController
extends AbstractMediaTerminalComponent
implements ICombiBAPContentAccessor,
IContentListener,
IDiagnosisDataProvider {
    private static final String LOGCLASS;
    private static final int COMBI_ADAPTER_NO_DATA;
    private static final int COMBI_ADAPTER_PLAYVIEW;
    private static final int COMBI_ADAPTER_BROWSEVIEW;
    private static final int COMBI_ADAPTER_ONLINE;
    private static final int COMBI_ADAPTER_FILEPLAYER;
    private static final int DEFAULT_BUFFER_LEVEL;
    private static final int INFO_TYPE_TITLE;
    private final CombiBAPServiceListenerImpl combiServiceListener;
    private final CombiBAPSourceListener combiSourceListener;
    private final CombiBAPIdMapper idMapper;
    private final IServiceTracker combiBAPServiceTracker;
    private final NullCombiBAPServiceMedia nullCombiMediaService;
    final LogChannel logCombi;
    private final Map contentAdapter;
    private final CombiBAPTransferStateListener transferStateListener;
    private volatile CombiBAPServiceMedia combiMediaService;
    private volatile int activeBAPSourceType;
    private volatile int activeBAPSourceSlotIdx;
    private volatile int activeBAPSourcePartitionIdx;
    private volatile ICombiBAPContentAdapter activeCombiContentAdapter;
    private volatile ServiceRegistration combiListenerServiceRegistration;
    private volatile boolean currentListAvailable;
    private volatile int currentListState;
    private volatile MediaListEntry[] currentFolderStack;
    private volatile ActiveSourceState currentActiveSourceState;
    private final CombiBAPController$CombiBapState combiState = new CombiBAPController$CombiBapState(this);
    private volatile boolean adapterStartupFinished;
    static /* synthetic */ Class class$de$audi$atip$interapp$combi$bap$audio$CombiBAPServiceMedia;
    static /* synthetic */ Class class$de$audi$atip$interapp$combi$bap$audio$CombiBAPServiceMediaListener;

    public CombiBAPController(IMediaTerminal iMediaTerminal) {
        super(iMediaTerminal);
        this.contentAdapter = new HashMap();
        this.logCombi = iMediaTerminal.getFramework().getLogChannel("App.Media.Combi");
        this.nullCombiMediaService = new NullCombiBAPServiceMedia(this.logCombi);
        this.combiMediaService = this.nullCombiMediaService;
        this.combiServiceListener = new CombiBAPServiceListenerImpl(iMediaTerminal, this);
        this.combiSourceListener = new CombiBAPSourceListener(this);
        this.idMapper = new CombiBAPIdMapper(this.logCombi);
        this.transferStateListener = new CombiBAPTransferStateListener(this.logCombi, this.getTerminal().getServiceManager(), this);
        this.combiBAPServiceTracker = this.getTerminal().getServiceManager().createServiceTracker(class$de$audi$atip$interapp$combi$bap$audio$CombiBAPServiceMedia == null ? (class$de$audi$atip$interapp$combi$bap$audio$CombiBAPServiceMedia = CombiBAPController.class$("de.audi.atip.interapp.combi.bap.audio.CombiBAPServiceMedia")) : class$de$audi$atip$interapp$combi$bap$audio$CombiBAPServiceMedia, new CombiBAPController$1(this));
    }

    public void init() {
        this.logCombi.log(1078071040, "[%1.init]", (Object)"CombiBAPController");
        this.getTerminal().getDiagnosisManager().addDataProvider(this.getTerminal().getTerminalID(), this.idMapper);
        this.getTerminal().getDiagnosisManager().addDataProvider(this.getTerminal().getTerminalID(), this);
        this.combiBAPServiceTracker.open();
        this.combiListenerServiceRegistration = this.getTerminal().getServiceManager().registerService(class$de$audi$atip$interapp$combi$bap$audio$CombiBAPServiceMediaListener == null ? (class$de$audi$atip$interapp$combi$bap$audio$CombiBAPServiceMediaListener = CombiBAPController.class$("de.audi.atip.interapp.combi.bap.audio.CombiBAPServiceMediaListener")) : class$de$audi$atip$interapp$combi$bap$audio$CombiBAPServiceMediaListener, this.combiServiceListener, new Hashtable(0));
        this.adapterStartupFinished = false;
    }

    private void startOperation() {
        this.getTerminal().getSourceController().addActiveSourceListenerAndNotifyState(this.combiSourceListener);
        this.getTerminal().getSourceController().addSlotListener(this.combiSourceListener);
        this.getTerminal().getContentManager().addContentListener(this);
        this.setActiveSourceState(null);
        this.transferStateListener.init();
    }

    public void deinit() {
        this.logCombi.log(1078071040, "[%1.deinit]", (Object)"CombiBAPController");
        this.setActiveSourceState(null);
        this.combiState.resetMedia();
        this.transferStateListener.deinit();
        this.combiBAPServiceTracker.close();
        this.combiListenerServiceRegistration.unregister();
    }

    public LogChannel getLogChannel() {
        return this.logCombi;
    }

    @Override
    public void contentActivated(IContent iContent, ISourceSlot iSourceSlot) {
        this.logCombi.log(1078071040, "[%1.contentActivated] '%2' ('%3')", (Object)"CombiBAPController", (Object)iContent, (Object)iSourceSlot.getSource());
        this.idMapper.reset(true, true);
        this.currentFolderStack = new MediaListEntry[0];
        ICombiBAPContentAdapter iCombiBAPContentAdapter = this.getContentAdapter(iContent);
        if (iCombiBAPContentAdapter == null) {
            this.logCombi.log(1078071040, "[%1.contentActivated] No adapter found", (Object)"CombiBAPController");
            return;
        }
        this.adapterStartupFinished = false;
        iCombiBAPContentAdapter.activate(iContent, this);
        this.activeCombiContentAdapter = iCombiBAPContentAdapter;
    }

    @Override
    public void contentDeactivated(IContent iContent) {
        this.logCombi.log(1078071040, "[%1.contentDeactivated]", (Object)"CombiBAPController");
        ICombiBAPContentAdapter iCombiBAPContentAdapter = this.activeCombiContentAdapter;
        if (iCombiBAPContentAdapter == null) {
            return;
        }
        if (this.currentActiveSourceState != null) {
            this.activeBAPSourceType = CombiBAPUtils.getBAPSourceType(this.currentActiveSourceState.getSlot().getSource(), this.currentActiveSourceState.getSlot());
        }
        this.activeCombiContentAdapter = null;
        this.setActiveSourceState(null);
        iCombiBAPContentAdapter.deactivate();
    }

    @Override
    public void contentActivationFinished(IContent iContent) {
    }

    private ICombiBAPContentAdapter getContentAdapter(IContent iContent) {
        int n;
        switch (iContent.getContentType()) {
            case 5: {
                n = 1;
                break;
            }
            case 7: {
                n = 5;
                break;
            }
            case 8: {
                n = 4;
                break;
            }
            case 0: 
            case 1: 
            case 2: {
                n = 2;
                break;
            }
            default: {
                return null;
            }
        }
        ICombiBAPContentAdapter iCombiBAPContentAdapter = (ICombiBAPContentAdapter)this.contentAdapter.get(new Integer(n));
        if (iCombiBAPContentAdapter != null) {
            return iCombiBAPContentAdapter;
        }
        switch (n) {
            case 1: {
                this.logCombi.log(1078071040, "[%1.getContentAdapter] COMBI_ADAPTER_NO_DATA", (Object)"CombiBAPController");
                iCombiBAPContentAdapter = new NoDataCombiAdapter(this.getLogChannel());
                break;
            }
            case 4: {
                this.logCombi.log(1078071040, "[%1.getContentAdapter] COMBI_ADAPTER_ONLINE", (Object)"CombiBAPController");
                iCombiBAPContentAdapter = new CombiBAPOnlineContentAdapter(this.getLogChannel());
                break;
            }
            case 5: {
                this.logCombi.log(1078071040, "[%1.getContentAdapter] COMBI_ADAPTER_FILEPLAYER", (Object)"CombiBAPController");
                iCombiBAPContentAdapter = new CombiBAPFilePlayerContentAdapter(this.getLogChannel());
                break;
            }
            case 2: {
                this.logCombi.log(1078071040, "[%1.getContentAdapter] COMBI_ADAPTER_PLAYVIEW", (Object)"CombiBAPController");
                iCombiBAPContentAdapter = new CombiBAPPlayViewContentAdapter(this.getLogChannel());
                break;
            }
            case 3: {
                this.logCombi.log(10000, "[%1.getContentAdapter] COMBI_ADAPTER_BROWSEVIEW -- Unsupported adapter mode!", (Object)"CombiBAPController");
                break;
            }
            default: {
                return null;
            }
        }
        iCombiBAPContentAdapter.init();
        this.contentAdapter.put(new Integer(n), iCombiBAPContentAdapter);
        return iCombiBAPContentAdapter;
    }

    protected ICombiBAPContentAdapter getActiveCombiContentAdapter() {
        return this.activeCombiContentAdapter;
    }

    protected CombiBAPIdMapper getIdMapper() {
        return this.idMapper;
    }

    protected CombiBAPServiceMedia getCombiBAPService() {
        return this.combiMediaService;
    }

    public void updateActiveSource(ISourceSlot iSourceSlot) {
        int n;
        int n2;
        int n3;
        if (iSourceSlot != null) {
            this.logCombi.log(1078071040, "[%1.updateActiveSource] '%2',slot='%3'.", (Object)"CombiBAPController", (Object)iSourceSlot.getSource(), (long)iSourceSlot.getIndex());
            n3 = CombiBAPUtils.getBAPSourceType(iSourceSlot.getSource(), iSourceSlot);
            n2 = CombiBAPUtils.getBapSourceIndex(iSourceSlot);
            n = MediaUtils.calculatePartitionIndex(iSourceSlot);
            this.logCombi.log(1078071040, "[%1.updateActiveSource] newActiveBAPSourceType:'%2', activeBAPSourceType:'%3'.", (Object)"CombiBAPController", (long)n3, (long)this.activeBAPSourceType);
            if (CombiBAPUtils.isBluetoothBAPSourceType(n3)) {
                if (CombiBAPUtils.isBluetoothBAPSourceType(this.activeBAPSourceType)) {
                    this.logCombi.log(1078071040, "[%1.updateActiveSource] BT Source -> Update newActiveBAPSourceType to '%2'.", (Object)"CombiBAPController", (long)this.activeBAPSourceType);
                    n3 = this.activeBAPSourceType;
                } else {
                    this.logCombi.log(1078071040, "[%1.updateActiveSource] Last source was not BT. No change.", (Object)"CombiBAPController", (long)this.activeBAPSourceType);
                }
            }
        } else {
            this.logCombi.log(1078071040, "[%1.updateActiveSource] No source", (Object)"CombiBAPController");
            this.activeBAPSourceType = 0;
            this.activeBAPSourceSlotIdx = 0;
            boolean bl = false;
            return;
        }
        this.logCombi.log(-2137614336, "[%1.updateActiveSource] newType=%2", (Object)"CombiBAPController", (long)n3);
        if (this.activeBAPSourceType == n3 && this.activeBAPSourceSlotIdx == n2 && this.activeBAPSourcePartitionIdx == n) {
            this.logCombi.log(1078071040, "[%1.updateActiveSource] Already set", (Object)"CombiBAPController");
            return;
        }
        this.currentListAvailable = false;
        this.currentListState = 0;
        this.activeBAPSourceType = n3;
        this.activeBAPSourceSlotIdx = n2;
        this.activeBAPSourcePartitionIdx = n;
        if (CombiBAPController.ignoreSourceUpdate(iSourceSlot)) {
            this.logCombi.log(1078071040, "[%1.updateActiveSource] TV Source -> no update.", (Object)"CombiBAPController");
            return;
        }
        try {
            this.combiState.updateActiveSource(this.activeBAPSourceType, this.activeBAPSourceSlotIdx, this.activeBAPSourcePartitionIdx, this.currentListAvailable, false, this.currentListState);
            this.combiState.updateActiveInfoState(9);
            this.getCombiBAPService().updatePlaybackFolder(false);
            this.combiState.updateCurrentStationInfo(new CombiBAPCurrentStationInfo("", 0, 0));
            this.getCombiBAPService().updatePlayPosition(PlayPosition.builder().setTimePosition(TimeStamp.getInstanceFromSeconds(-65536)).setTotalPlayTime(TimeStamp.getInstanceFromSeconds(-65536)).setVariableBitRate(false).build());
            this.getCombiBAPService().updateCurrentBrowseFolder(0, null, 0, 0, 0);
        }
        catch (Exception exception) {
            this.logCombi.log(10000, "[%1.updateActiveSource] %2", (Object)"CombiBAPController", (Throwable)exception);
        }
    }

    public void updateActiveSourceState(ActiveSourceState activeSourceState) {
        this.logCombi.log(1078071040, "[%1.updateActiveSourceState] '%2' %3.", (Object)"CombiBAPController", (Object)activeSourceState, (Object)this.currentActiveSourceState);
        ActiveSourceState activeSourceState2 = this.currentActiveSourceState;
        this.setActiveSourceState(activeSourceState);
        if (CombiBAPController.ignoreSourceUpdate(activeSourceState.getSlot())) {
            this.logCombi.log(1078071040, "[%1.updateActiveSourceState] current source is tv -> ignore.", (Object)"CombiBAPController");
            return;
        }
        int n = CombiBAPUtils.getBAPInfoState(activeSourceState);
        try {
            this.logCombi.log(-2137614336, "[%1.updateActiveSourceState] combiState='%2'", (Object)"CombiBAPController", (long)n);
            if (activeSourceState.getSlot().getSource().getType() == 10) {
                this.logCombi.log(1078071040, "[%1.updateActiveSourceState] USB source.", (Object)"CombiBAPController");
                if (activeSourceState2 != null && activeSourceState.getState() == activeSourceState2.getState()) {
                    this.logCombi.log(1078071040, "[%1.updateActiveSourceState] States are the same", (Object)"CombiBAPController");
                } else {
                    this.logCombi.log(1078071040, "[%1.updateActiveSourceState] Old state was no media", (Object)"CombiBAPController");
                    this.updateUSBSource();
                }
            }
            if (activeSourceState.getSlot().getSource().getType() == 13 && activeSourceState.getState() != 1) {
                this.logCombi.log(1078071040, "[%1.updateActiveSourceState] reset online music state to normal operation", (Object)"CombiBAPController");
                this.getCombiBAPService().updateOnlineMusicState(1, 100);
            }
            this.combiState.updateActiveInfoState(n);
            if (activeSourceState.getState() != 1) {
                this.updateCurrentPlayingTrack(-1, 0L, 0, 0, I18NString.EMPTY_I18N_STRING, I18NString.EMPTY_I18N_STRING, I18NString.EMPTY_I18N_STRING, I18NString.EMPTY_I18N_STRING, false, 0, null);
            }
            if ((activeSourceState2 == null || activeSourceState.getState() != activeSourceState2.getState()) && activeSourceState.getState() == 4) {
                this.logCombi.log(1078071040, "[%1.updateActiveSourceState] Also inform combi about the listsize if active medium was removed.", (Object)"CombiBAPController");
                this.combiState.updateListSize(0);
            }
        }
        catch (Exception exception) {
            this.logCombi.log(10000, "[%1.updateActiveSourceState] %2", (Object)"CombiBAPController", (Throwable)exception);
        }
    }

    public void setActiveSourceState(ActiveSourceState activeSourceState) {
        this.logCombi.log(1078071040, "[%1.setActiveSourceState] '%2' %3.", (Object)"CombiBAPController", (Object)activeSourceState, (Object)this.currentActiveSourceState);
        this.currentActiveSourceState = activeSourceState;
        if (null != this.activeCombiContentAdapter && activeSourceState != null) {
            this.activeCombiContentAdapter.updateActiveSlot(activeSourceState.getSlot());
        }
    }

    public void updateUSBSource() {
        if (this.getTerminal().getSourceController().getActivationContext() == null) {
            this.logCombi.log(1078071040, "[%1.updateUSBSource] no activation context", (Object)"CombiBAPController");
            return;
        }
        ISourceSlot iSourceSlot = this.getTerminal().getSourceController().getActivationContext().getSlot();
        if (iSourceSlot != null && iSourceSlot.getSource().getType() != 10 || iSourceSlot == null) {
            this.logCombi.log(1078071040, "[%1.updateUSBSource] USB is not active source", (Object)"CombiBAPController");
            return;
        }
        ISourceSlot iSourceSlot2 = iSourceSlot.getSource().isEmpty() ? iSourceSlot.getSource().getSlot(0) : iSourceSlot.getSource().getSlot(iSourceSlot);
        this.logCombi.log(1078071040, "[%1.updateUSBSource] new usb slot '%2'", (Object)"CombiBAPController", (Object)iSourceSlot2);
        int n = CombiBAPUtils.getBAPSourceType(iSourceSlot.getSource(), iSourceSlot2);
        int n2 = CombiBAPUtils.getBapSourceIndex(iSourceSlot);
        int n3 = MediaUtils.calculatePartitionIndex(iSourceSlot2);
        this.activeBAPSourceType = n;
        this.activeBAPSourceSlotIdx = n2;
        this.activeBAPSourcePartitionIdx = n3;
        this.logCombi.log(1078071040, "[%1.updateUSBSource] %2", (Object)"CombiBAPController", (long)this.activeBAPSourceType);
        this.combiState.updateActiveSource(this.activeBAPSourceType, this.activeBAPSourceSlotIdx, this.activeBAPSourcePartitionIdx, this.currentListAvailable, false, this.currentListState);
    }

    void updateSourceList(int[] nArray, CombiBAPAudioSource[][] combiBAPAudioSourceArray) {
        this.logCombi.log(1078071040, "[%1.updateSourceList]", (Object)"CombiBAPController");
        this.combiState.updateSourceList(nArray, combiBAPAudioSourceArray);
    }

    void switchSourceResult(boolean bl) {
        this.logCombi.log(1078071040, "[%2.switchSourceResult] '%1'.", bl, (Object)"CombiBAPController");
        try {
            this.getCombiBAPService().switchSourceResult(bl ? 0 : 1);
        }
        catch (Exception exception) {
            this.logCombi.log(10000, "[%1.switchSourceResult] %2", (Object)"CombiBAPController", (Throwable)exception);
        }
    }

    void skipResult(boolean bl) {
        this.logCombi.log(1078071040, "[%2.skipResult] '%1'.", bl, (Object)"CombiBAPController");
        try {
            this.getCombiBAPService().skipResult(bl);
        }
        catch (Exception exception) {
            this.logCombi.log(10000, "[%1.skipResult] %2", (Object)"CombiBAPController", (Throwable)exception);
        }
    }

    @Override
    public void updateCurrentPlayingTrack(int n, long l, int n2, int n3, I18NString i18NString, I18NString i18NString2, I18NString i18NString3, I18NString i18NString4, boolean bl, int n4, ResourceLocator resourceLocator) {
        Object object;
        if (this.logCombi.isInfo()) {
            object = new Buffer();
            ((Buffer)object).append("content='").append(n).append("',entryID='").append(l).append("',type='").append(n2).append("',title='").append(i18NString).append("',filename='").append(i18NString2).append("',pos='").append(n4).append("'");
            this.logCombi.log(1078071040, "[%1.updateCurrentPlayingTrack] %2", (Object)"CombiBAPController", object);
        }
        try {
            int n5 = this.idMapper.getCombiIDForPlayingTrack(new CombiBAPMediaEntry(l, n2, n3, null));
            switch (n) {
                case 1: {
                    int n6;
                    int n7;
                    String string = i18NString.isEmpty() ? i18NString2.getI18NString() : i18NString.getI18NString();
                    switch (n2) {
                        case 1: {
                            if (!(i18NString.isEmpty() || i18NString.getI18NKey() != 40 && i18NString.getI18NKey() != 42)) {
                                string = "";
                                n7 = 8;
                                try {
                                    n6 = Integer.parseInt(i18NString.getI18NString());
                                }
                                catch (Exception exception) {
                                    n6 = 0;
                                }
                                break;
                            }
                            n7 = 6;
                            n6 = 0;
                            break;
                        }
                        case 2: {
                            n7 = 7;
                            n6 = 0;
                            break;
                        }
                        default: {
                            n7 = 0;
                            n6 = 0;
                        }
                    }
                    object = new CombiBAPCurrentStationInfo(string, n7, n6);
                    if (i18NString3 != null) {
                        if (i18NString3.isInternationalized()) {
                            ((CombiBAPCurrentStationInfo)object).setSecondaryInformation(i18NString3.getI18NString(), 0);
                        } else {
                            ((CombiBAPCurrentStationInfo)object).setSecondaryInformation(i18NString3.getI18NString(), 73);
                        }
                    }
                    if (i18NString4 == null) break;
                    if (i18NString4.isInternationalized()) {
                        ((CombiBAPCurrentStationInfo)object).setTertiaryInformation(i18NString4.getI18NString(), 0);
                        break;
                    }
                    ((CombiBAPCurrentStationInfo)object).setTertiaryInformation(i18NString4.getI18NString(), 74);
                    break;
                }
                case 0: {
                    if (i18NString.isInternationalized()) {
                        int n8;
                        try {
                            n8 = Integer.parseInt(i18NString.getI18NString());
                        }
                        catch (Exception exception) {
                            n8 = 0;
                        }
                        object = new CombiBAPCurrentStationInfo("", 8, n8);
                    } else {
                        object = new CombiBAPCurrentStationInfo(i18NString.getI18NString(), 72, 0);
                    }
                    if (i18NString3 != null) {
                        if (i18NString3.isInternationalized()) {
                            ((CombiBAPCurrentStationInfo)object).setSecondaryInformation(i18NString3.getI18NString(), 0);
                        } else {
                            ((CombiBAPCurrentStationInfo)object).setSecondaryInformation(i18NString3.getI18NString(), 73);
                        }
                    }
                    if (i18NString4 == null) break;
                    if (i18NString4.isInternationalized()) {
                        ((CombiBAPCurrentStationInfo)object).setTertiaryInformation(i18NString4.getI18NString(), 0);
                        break;
                    }
                    ((CombiBAPCurrentStationInfo)object).setTertiaryInformation(i18NString4.getI18NString(), 74);
                    break;
                }
                case 2: {
                    int n9 = 0;
                    try {
                        n9 = Integer.parseInt(i18NString.getI18NString());
                    }
                    catch (Exception exception) {
                        n9 = 0;
                    }
                    object = new CombiBAPCurrentStationInfo("", 65, n9);
                    break;
                }
                case 8: {
                    object = new CombiBAPCurrentStationInfo(i18NString.getI18NString(), 6, 0);
                    if (i18NString3 != null) {
                        ((CombiBAPCurrentStationInfo)object).setSecondaryInformation(i18NString3.getI18NString(), 73);
                    }
                    if (i18NString4 == null) break;
                    ((CombiBAPCurrentStationInfo)object).setTertiaryInformation(i18NString4.getI18NString(), 74);
                    break;
                }
                default: {
                    object = new CombiBAPCurrentStationInfo("", 0, 0);
                }
            }
            if (bl) {
                ((CombiBAPCurrentStationInfo)object).setListAbsolutePosition(n4);
            } else {
                ((CombiBAPCurrentStationInfo)object).setListAbsolutePosition(0);
            }
            ((CombiBAPCurrentStationInfo)object).setListRef(n5);
            if (resourceLocator != null) {
                if (resourceLocator.isIntResource()) {
                    ((CombiBAPCurrentStationInfo)object).setPictureID(resourceLocator.getId());
                } else {
                    ((CombiBAPCurrentStationInfo)object).setPictureURL(resourceLocator.getUrl());
                }
            } else {
                ((CombiBAPCurrentStationInfo)object).setPicture(-1, null);
            }
            this.combiState.updateCurrentStationInfo((CombiBAPCurrentStationInfo)object);
        }
        catch (Exception exception) {
            this.logCombi.log(10000, "[%1.updateCurrentPlayingTrack] %2", (Object)"CombiBAPController", (Throwable)exception);
        }
    }

    @Override
    public void updateActiveRepeatScope(int n, boolean bl) {
        int n2;
        this.logCombi.log(1078071040, "[%2.updateActiveRepeatScope] scope='%3' (mix='%1')", bl, (Object)"CombiBAPController", (Object)String.valueOf(n));
        switch (n) {
            case 1: {
                n2 = 3;
                break;
            }
            case 0: {
                n2 = 2;
                break;
            }
            case 4: {
                n2 = 4;
                break;
            }
            case 2: {
                n2 = 5;
                break;
            }
            case 3: {
                n2 = 1;
                break;
            }
            default: {
                n2 = 0;
            }
        }
        int n3 = bl ? 2 : 3;
        try {
            this.getCombiBAPService().updateActiveSourceState(n3, n2);
        }
        catch (Exception exception) {
            this.logCombi.log(10000, "[%1.skipResult] %2", (Object)"CombiBAPController", (Throwable)exception);
        }
    }

    @Override
    public void updateBrowseFolder(MediaListEntry[] mediaListEntryArray, int n) {
        if (this.logCombi.getCurrentLogThreshold() >= 1078071040) {
            this.logCombi.log(1078071040, "[%1.updateBrowseFolder] '%2' (pos='%3')", (Object)"CombiBAPController", (Object)LogUtil.listEntryToStr(mediaListEntryArray), (long)n);
        }
        try {
            String string;
            int n2;
            int n3;
            this.idMapper.reset(false, this.currentFolderStack.length < mediaListEntryArray.length);
            this.currentFolderStack = mediaListEntryArray;
            int n4 = 0;
            int n5 = -65536;
            if (mediaListEntryArray.length == 1) {
                n3 = 0;
                n2 = 0;
                string = null;
            } else {
                MediaListEntry mediaListEntry = mediaListEntryArray[mediaListEntryArray.length - 1];
                n3 = CombiBAPUtils.getBAPFolderTypeOfMediaEntry(mediaListEntry);
                n2 = mediaListEntryArray.length - 1;
                string = mediaListEntry.getTitle().getI18NString();
                n4 = this.idMapper.getCombiIDForBrowseFolder(new CombiBAPMediaEntry(mediaListEntry.getEntryID(), mediaListEntry.getContentType(), mediaListEntry.getEntryFlags(), mediaListEntry));
                n5 = n > 0 ? n : n5;
            }
            this.getCombiBAPService().updateCurrentBrowseFolder(n3, string, n2, n4, n5);
        }
        catch (Exception exception) {
            this.logCombi.log(10000, "[%1.updateBrowseFolder] %2", (Object)"CombiBAPController", (Throwable)exception);
        }
    }

    @Override
    public void updateListSize(int n) {
        this.logCombi.log(1078071040, "[%1.updateListSize] '%2'", (Object)"CombiBAPController", (long)n);
        this.combiState.updateListSize(n);
    }

    @Override
    public void trackChangeIsComing() {
        this.logCombi.log(1078071040, "[%1.trackChangeIsComing]", (Object)"CombiBAPController");
        this.getCombiBAPService().trackChangeIsComing();
    }

    @Override
    public void contentAdapterStartupFinished() {
        this.adapterStartupFinished = true;
        this.logCombi.log(1078071040, "[%1.contentAdapterStartupFinished] '%2'", (Object)"CombiBAPController", (Object)this.currentActiveSourceState);
        try {
            if (this.currentActiveSourceState == null || this.currentActiveSourceState.getState() == 1 || this.currentActiveSourceState.getState() == 2) {
                this.logCombi.log(1078071040, "[%1.contentAdapterStartupFinished] currentActiveSourceState='%2'", (Object)"CombiBAPController", (Object)this.currentActiveSourceState);
                this.combiState.updateActiveInfoState(0);
            }
        }
        catch (Exception exception) {
            this.logCombi.log(10000, "[%1.contentAdapterStartupFinished] %2", (Object)"CombiBAPController", (Throwable)exception);
        }
    }

    @Override
    public void updateActiveFileplayerPlaybackType(int n) {
        this.logCombi.log(1078071040, "[%1.updateFilePlayerPlaybackType] '%2'", (Object)"CombiBAPController", (long)n);
        try {
            this.combiState.updateActiveInfoState(n == 1 ? 67 : 70);
        }
        catch (Exception exception) {
            this.logCombi.log(10000, "[%1.contentAdapterStartupFinished] %2", (Object)"CombiBAPController", (Throwable)exception);
        }
    }

    @Override
    public void updateListState(boolean bl, int n) {
        String string;
        int n2;
        switch (n) {
            case 1: {
                n2 = 3;
                string = "LOADED";
                break;
            }
            case 2: {
                n2 = 2;
                string = "INCOMPLETE LOADED";
                break;
            }
            case 3: {
                n2 = 1;
                string = "LOADING";
                break;
            }
            default: {
                n2 = 0;
                string = "UNKNOW";
            }
        }
        this.logCombi.log(1078071040, "[%2.updateListState] '%1', '%3'", (Object)(bl ? "LIST" : "NO LIST"), (Object)"CombiBAPController", (Object)string);
        if (this.currentListAvailable == bl && this.currentListState == n2) {
            this.logCombi.log(1078071040, "[%1.updateListState] Already set", (Object)"CombiBAPController");
            return;
        }
        this.currentListAvailable = bl;
        this.currentListState = n2;
        try {
            this.combiState.updateActiveSource(this.activeBAPSourceType, this.activeBAPSourceSlotIdx, this.activeBAPSourcePartitionIdx, this.currentListAvailable, false, this.currentListState);
        }
        catch (Exception exception) {
            this.logCombi.log(10000, "[%1.updateListState] %2", (Object)"CombiBAPController", (Throwable)exception);
        }
    }

    @Override
    public void gotoCurrentPlayingTrackResult(boolean bl) {
        this.logCombi.log(1078071040, "[%2.gotoCurrentPlayingTrackResult] '%1'.", bl, (Object)"CombiBAPController");
        try {
            this.getCombiBAPService().goToResult(0, bl ? 0 : 1);
        }
        catch (Exception exception) {
            this.logCombi.log(10000, "[%1.gotoCurrentPlayingTrackResult] %2", (Object)"CombiBAPController", (Throwable)exception);
        }
    }

    @Override
    public void gotoParentFolderResult(boolean bl) {
        this.logCombi.log(1078071040, "[%2.gotoParentFolderResult] '%1'.", bl, (Object)"CombiBAPController");
        try {
            this.getCombiBAPService().goToResult(2, bl ? 0 : 1);
        }
        catch (Exception exception) {
            this.logCombi.log(10000, "[%1.gotoParentFolderResult] %2", (Object)"CombiBAPController", (Throwable)exception);
        }
    }

    @Override
    public void gotoRootFolderResult(boolean bl) {
        this.logCombi.log(1078071040, "[%2.gotoRootFolderResult] '%1'.", bl, (Object)"CombiBAPController");
        try {
            this.getCombiBAPService().goToResult(1, bl ? 0 : 1);
        }
        catch (Exception exception) {
            this.logCombi.log(10000, "[%1.gotoRootFolderResult] %2", (Object)"CombiBAPController", (Throwable)exception);
        }
    }

    @Override
    public void gotoSubFolderResult(boolean bl) {
        this.logCombi.log(1078071040, "[%2.gotoSubFolderResult] '%1'.", bl, (Object)"CombiBAPController");
        try {
            this.getCombiBAPService().goToResult(4, bl ? 0 : 1);
        }
        catch (Exception exception) {
            this.logCombi.log(10000, "[%1.gotoSubFolderResult] %2", (Object)"CombiBAPController", (Throwable)exception);
        }
    }

    @Override
    public void responseList(int n, int n2, int n3, MediaListEntry[] mediaListEntryArray) {
        this.logCombi.log(1078071040, "[%1.responseList] transactionID='%2', startIndex='%3'.", (Object)"CombiBAPController", (long)n, (long)n3);
        CombiBAPMediaBrowserListEntry[] combiBAPMediaBrowserListEntryArray = new CombiBAPMediaBrowserListEntry[mediaListEntryArray.length];
        try {
            boolean bl = this.getTerminal().getFramework().getSysApp().getDiagnosisCOD().isDashboardTextReplacementActivated();
            for (int i2 = 0; i2 < mediaListEntryArray.length; ++i2) {
                String string;
                int n4;
                MediaListEntry mediaListEntry = mediaListEntryArray[i2];
                int n5 = this.idMapper.getCombiID(new CombiBAPMediaEntry(mediaListEntry.getEntryID(), mediaListEntry.getContentType(), mediaListEntry.getEntryFlags(), mediaListEntry));
                int n6 = CombiBAPUtils.getFileStateOfMediaEntry(mediaListEntry);
                switch (n2) {
                    case 0: {
                        if (mediaListEntry.getTitle().isInternationalized()) {
                            n4 = 8;
                            string = mediaListEntry.getTitle().getI18NString();
                            break;
                        }
                        if (bl && CombiBAPUtils.containsInvalidCharacter(mediaListEntry.getTitle().getI18NString())) {
                            n4 = 8;
                            string = String.valueOf(n3 + i2 + 1);
                            break;
                        }
                        n4 = 9;
                        string = mediaListEntry.getTitle().getI18NString();
                        break;
                    }
                    case 2: {
                        n4 = 65;
                        string = mediaListEntry.getTitle().getI18NString();
                        break;
                    }
                    case 1: {
                        n4 = CombiBAPUtils.getBAPFileTypeOfMediaEntry(mediaListEntry);
                        if (mediaListEntry.getTitle().isInternationalized()) {
                            string = mediaListEntry.getTitle().getI18NString();
                            break;
                        }
                        if (bl && CombiBAPUtils.containsInvalidCharacter(mediaListEntry.getTitle().getI18NString())) {
                            string = String.valueOf(n3 + i2 + 1);
                            break;
                        }
                        string = mediaListEntry.getTitle().getI18NString();
                        break;
                    }
                    default: {
                        n4 = 0;
                        string = mediaListEntry.getTitle().getI18NString();
                    }
                }
                combiBAPMediaBrowserListEntryArray[i2] = new CombiBAPMediaBrowserListEntry(n5, n4, string, n6);
                this.logCombi.log(1078071040, "[%1.responseList] bapEntries[%2] '%3'.", (Object)"CombiBAPController", (long)i2, (long)n6);
            }
            this.getCombiBAPService().responseMediaBrowserList(n, combiBAPMediaBrowserListEntryArray);
        }
        catch (Exception exception) {
            this.logCombi.log(10000, "[%1.responseList] %2", (Object)"CombiBAPController", (Throwable)exception);
        }
    }

    @Override
    public void updatePlaybackFolder(boolean bl) {
        this.combiState.updatePlaybackFolder(bl);
    }

    @Override
    public void updatePlayPosition(PlayTime playTime) {
        if (this.logCombi.isDebug2()) {
            this.logCombi.log(14808325, "[%1.updatePlayPosition] %2", (Object)"CombiBAPController", (Object)PlayTime.toTimeString(playTime.getPlayTime(), false));
        }
        this.combiMediaService.updatePlayPosition(PlayPosition.builder().setTimePosition(TimeStamp.getInstanceFromSeconds(playTime.getPlayTime())).setTotalPlayTime(TimeStamp.getInstanceFromSeconds(playTime.getTotalTimeOfTrack())).build());
    }

    @Override
    public void getNextListPosResult(boolean bl, CombiBAPMediaEntry combiBAPMediaEntry, CombiBAPMediaEntry combiBAPMediaEntry2, int n) {
        this.logCombi.log(1078071040, "[%1.getNexListPosResult] '%2', requested='%3',next='%4'", (Object)"CombiBAPController", (Object)String.valueOf(bl), (Object)combiBAPMediaEntry, (Object)combiBAPMediaEntry2);
        try {
            int n2 = this.idMapper.getCombiID(combiBAPMediaEntry);
            if (!bl) {
                this.getCombiBAPService().getNextListPosResult(1, n2, -1, -1);
            } else {
                int n3 = this.idMapper.getCombiID(combiBAPMediaEntry2);
                this.getCombiBAPService().getNextListPosResult(0, n2, n3, n);
            }
        }
        catch (Exception exception) {
            this.logCombi.log(10000, "[%1.getNexListPosResult] %2", (Object)"CombiBAPController", (Throwable)exception);
        }
    }

    @Override
    public void selectListEntryResult(boolean bl) {
        this.logCombi.log(1078071040, "[%2.selectListEntryResult] '%1.", bl, (Object)"CombiBAPController");
        try {
            this.getCombiBAPService().selectListEntryResult(bl ? 0 : 1);
        }
        catch (Exception exception) {
            this.logCombi.log(10000, "[%1.selectListEntryResult] %2", (Object)"CombiBAPController", (Throwable)exception);
        }
    }

    @Override
    public void updateSeekState(boolean bl) {
        this.logCombi.log(1078071040, "[%1.updateSeekState] '%2'", (Object)"CombiBAPController", (Object)(bl ? "SEEKING" : "NOT SEEKING"));
        try {
            this.getCombiBAPService().updateSeekStatus(bl);
        }
        catch (Exception exception) {
            this.logCombi.log(10000, "[%1.updateSeekState] %2", (Object)"CombiBAPController", (Throwable)exception);
        }
    }

    public void updateActivateSourceResult(boolean bl) {
        this.logCombi.log(1078071040, "[%1.updateActivateSourceResult] '%2'", (Object)"CombiBAPController", (Object)(bl ? "OK" : "NOK"));
        try {
            this.getCombiBAPService().activateSourceResult(bl ? 0 : 1);
        }
        catch (Exception exception) {
            this.logCombi.log(10000, "[%1.updateSeekState] %2", (Object)"CombiBAPController", (Throwable)exception);
        }
    }

    public void updateImportState(ISourceSlot iSourceSlot, boolean bl, int n) {
        if (this.logCombi.isInfo()) {
            this.logCombi.log(1078071040, "[%1.updateImportState] '%2','%3','%4'", (Object)"CombiBAPController", (Object)iSourceSlot, (Object)bl, (Object)new Integer(n));
        }
        CombiBAPAudioSource combiBAPAudioSource = iSourceSlot != null ? CombiBAPUtils.getBAPSource(iSourceSlot.getSource(), iSourceSlot) : new CombiBAPAudioSource(255, 0, 255, "");
        try {
            this.getCombiBAPService().updateMediaImportState(combiBAPAudioSource.getSourceType(), combiBAPAudioSource.getInstanceId(), bl, n);
        }
        catch (Exception exception) {
            this.logCombi.log(10000, "[%1.updateImportState] %2", (Object)"CombiBAPController", (Throwable)exception);
        }
    }

    boolean isStartupFinished() {
        return this.adapterStartupFinished;
    }

    @Override
    public void changeActiveSourceMediaType(int n) {
        int n2;
        this.logCombi.log(1078071040, "[%1.changeActiveSourceMediaType] '%2'", (Object)"CombiBAPController", (long)n);
        switch (n) {
            case 19: {
                n2 = 21;
                break;
            }
            case 13: {
                n2 = 22;
                break;
            }
            default: {
                return;
            }
        }
        if (this.activeBAPSourceType == n2) {
            this.logCombi.log(1078071040, "[%1.changeActiveSourceMediaType] Already set", (Object)"CombiBAPController");
            return;
        }
        this.activeBAPSourceType = n2;
        try {
            this.combiState.updateActiveSource(this.activeBAPSourceType, this.activeBAPSourceSlotIdx, this.activeBAPSourcePartitionIdx, this.currentListAvailable, false, this.currentListState);
        }
        catch (Exception exception) {
            this.logCombi.log(10000, "[%1.changeActiveSourceMediaType] %2", (Object)"CombiBAPController", (Throwable)exception);
        }
    }

    public void updatePreferredList(int n) {
        this.getCombiBAPService().updatePreferredList(1);
    }

    @Override
    public void updateOnlineMusicState(int n, int n2, int n3) {
        int n4;
        switch (n) {
            case 0: 
            case 4: 
            case 11: {
                n4 = 4;
                break;
            }
            default: {
                n4 = 1;
            }
        }
        this.logCombi.log(1078071040, "[%1.updateOnlineMusicState bapMusicState='%2', pBufferLevel='%3' ]", (Object)"CombiBAPController", (Object)new Integer(n4), (Object)new Integer(n3));
        this.getCombiBAPService().updateOnlineMusicState(n4, 255);
    }

    private static boolean ignoreSourceUpdate(ISourceSlot iSourceSlot) {
        return iSourceSlot.getSource().getType() == 7 || iSourceSlot.getSource().getType() == 8;
    }

    public String toString() {
        Buffer buffer = new Buffer(20);
        buffer.append("CombiBAPController").append("@").append(this.hashCode());
        return buffer.toString();
    }

    @Override
    public String getDiagKey() {
        return "CombiBAPController";
    }

    @Override
    public String getDiagValue() {
        return this.combiState.toString();
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static /* synthetic */ CombiBAPServiceMedia access$002(CombiBAPController combiBAPController, CombiBAPServiceMedia combiBAPServiceMedia) {
        combiBAPController.combiMediaService = combiBAPServiceMedia;
        return combiBAPController.combiMediaService;
    }

    static /* synthetic */ NullCombiBAPServiceMedia access$100(CombiBAPController combiBAPController) {
        return combiBAPController.nullCombiMediaService;
    }

    static /* synthetic */ void access$200(CombiBAPController combiBAPController) {
        combiBAPController.startOperation();
    }

    static /* synthetic */ CombiBAPServiceMedia access$000(CombiBAPController combiBAPController) {
        return combiBAPController.combiMediaService;
    }
}

