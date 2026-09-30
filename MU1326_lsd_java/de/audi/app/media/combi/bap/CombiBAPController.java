/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.combi.bap;

import de.audi.app.media.AbstractMediaTerminalComponent;
import de.audi.app.media.IMediaTerminal;
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
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class CombiBAPController
extends AbstractMediaTerminalComponent
implements ICombiBAPContentAccessor,
IContentListener,
IDiagnosisDataProvider {
    private static final String LOGCLASS = "CombiBAPController";
    private static final int COMBI_ADAPTER_NO_DATA = 1;
    private static final int COMBI_ADAPTER_PLAYVIEW = 2;
    private static final int COMBI_ADAPTER_BROWSEVIEW = 3;
    private static final int COMBI_ADAPTER_ONLINE = 4;
    private static final int COMBI_ADAPTER_FILEPLAYER = 5;
    private static final int DEFAULT_BUFFER_LEVEL = 100;
    private static final int INFO_TYPE_TITLE = 72;
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
    private final CombiBapState combiState = new CombiBapState();
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
        this.combiBAPServiceTracker = this.getTerminal().getServiceManager().createServiceTracker(class$de$audi$atip$interapp$combi$bap$audio$CombiBAPServiceMedia == null ? (class$de$audi$atip$interapp$combi$bap$audio$CombiBAPServiceMedia = CombiBAPController.class$("de.audi.atip.interapp.combi.bap.audio.CombiBAPServiceMedia")) : class$de$audi$atip$interapp$combi$bap$audio$CombiBAPServiceMedia, new ServiceTrackerCustomizer(){

            public void removedService(ServiceReference serviceReference, Object object) {
                CombiBAPController.this.logCombi.log(1000000, "[%1.removedService] BAP service removed", (Object)CombiBAPController.LOGCLASS);
                CombiBAPController.this.getTerminal().getServiceManager().releaseService(serviceReference);
                CombiBAPController.this.combiMediaService = CombiBAPController.this.nullCombiMediaService;
            }

            public Object addingService(ServiceReference serviceReference) {
                CombiBAPController.this.logCombi.log(1000000, "[%1.addingService] Found BAP service", (Object)CombiBAPController.LOGCLASS);
                CombiBAPController.this.combiMediaService = (CombiBAPServiceMedia)CombiBAPController.this.getTerminal().getServiceManager().getService(serviceReference);
                CombiBAPController.this.startOperation();
                return CombiBAPController.this.combiMediaService;
            }

            public void modifiedService(ServiceReference serviceReference, Object object) {
            }
        });
    }

    public void init() {
        this.logCombi.log(1000000, "[%1.init]", (Object)LOGCLASS);
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
        this.logCombi.log(1000000, "[%1.deinit]", (Object)LOGCLASS);
        this.setActiveSourceState(null);
        this.combiState.resetMedia();
        this.transferStateListener.deinit();
        this.combiBAPServiceTracker.close();
        this.combiListenerServiceRegistration.unregister();
    }

    public LogChannel getLogChannel() {
        return this.logCombi;
    }

    public void contentActivated(IContent iContent, ISourceSlot iSourceSlot) {
        this.logCombi.log(1000000, "[%1.contentActivated] '%2' ('%3')", (Object)LOGCLASS, (Object)iContent, (Object)iSourceSlot.getSource());
        this.idMapper.reset(true, true);
        this.currentFolderStack = new MediaListEntry[0];
        ICombiBAPContentAdapter iCombiBAPContentAdapter = this.getContentAdapter(iContent);
        if (iCombiBAPContentAdapter == null) {
            this.logCombi.log(1000000, "[%1.contentActivated] No adapter found", (Object)LOGCLASS);
            return;
        }
        this.adapterStartupFinished = false;
        iCombiBAPContentAdapter.activate(iContent, this);
        this.activeCombiContentAdapter = iCombiBAPContentAdapter;
    }

    public void contentDeactivated(IContent iContent) {
        this.logCombi.log(1000000, "[%1.contentDeactivated]", (Object)LOGCLASS);
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
                this.logCombi.log(1000000, "[%1.getContentAdapter] COMBI_ADAPTER_NO_DATA", (Object)LOGCLASS);
                iCombiBAPContentAdapter = new NoDataCombiAdapter(this.getLogChannel());
                break;
            }
            case 4: {
                this.logCombi.log(1000000, "[%1.getContentAdapter] COMBI_ADAPTER_ONLINE", (Object)LOGCLASS);
                iCombiBAPContentAdapter = new CombiBAPOnlineContentAdapter(this.getLogChannel());
                break;
            }
            case 5: {
                this.logCombi.log(1000000, "[%1.getContentAdapter] COMBI_ADAPTER_FILEPLAYER", (Object)LOGCLASS);
                iCombiBAPContentAdapter = new CombiBAPFilePlayerContentAdapter(this.getLogChannel());
                break;
            }
            case 2: {
                this.logCombi.log(1000000, "[%1.getContentAdapter] COMBI_ADAPTER_PLAYVIEW", (Object)LOGCLASS);
                iCombiBAPContentAdapter = new CombiBAPPlayViewContentAdapter(this.getLogChannel());
                break;
            }
            case 3: {
                this.logCombi.log(10000, "[%1.getContentAdapter] COMBI_ADAPTER_BROWSEVIEW -- Unsupported adapter mode!", (Object)LOGCLASS);
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
            this.logCombi.log(1000000, "[%1.updateActiveSource] '%2',slot='%3'.", (Object)LOGCLASS, (Object)iSourceSlot.getSource(), (long)iSourceSlot.getIndex());
            n3 = CombiBAPUtils.getBAPSourceType(iSourceSlot.getSource(), iSourceSlot);
            n2 = CombiBAPUtils.getBapSourceIndex(iSourceSlot);
            n = MediaUtils.calculatePartitionIndex(iSourceSlot);
            this.logCombi.log(1000000, "[%1.updateActiveSource] newActiveBAPSourceType:'%2', activeBAPSourceType:'%3'.", (Object)LOGCLASS, (long)n3, (long)this.activeBAPSourceType);
            if (CombiBAPUtils.isBluetoothBAPSourceType(n3)) {
                if (CombiBAPUtils.isBluetoothBAPSourceType(this.activeBAPSourceType)) {
                    this.logCombi.log(1000000, "[%1.updateActiveSource] BT Source -> Update newActiveBAPSourceType to '%2'.", (Object)LOGCLASS, (long)this.activeBAPSourceType);
                    n3 = this.activeBAPSourceType;
                } else {
                    this.logCombi.log(1000000, "[%1.updateActiveSource] Last source was not BT. No change.", (Object)LOGCLASS, (long)this.activeBAPSourceType);
                }
            }
        } else {
            this.logCombi.log(1000000, "[%1.updateActiveSource] No source", (Object)LOGCLASS);
            this.activeBAPSourceType = 0;
            this.activeBAPSourceSlotIdx = 0;
            boolean bl = false;
            return;
        }
        this.logCombi.log(10000000, "[%1.updateActiveSource] newType=%2", (Object)LOGCLASS, (long)n3);
        if (this.activeBAPSourceType == n3 && this.activeBAPSourceSlotIdx == n2 && this.activeBAPSourcePartitionIdx == n) {
            this.logCombi.log(1000000, "[%1.updateActiveSource] Already set", (Object)LOGCLASS);
            return;
        }
        this.currentListAvailable = false;
        this.currentListState = 0;
        this.activeBAPSourceType = n3;
        this.activeBAPSourceSlotIdx = n2;
        this.activeBAPSourcePartitionIdx = n;
        if (CombiBAPController.ignoreSourceUpdate(iSourceSlot)) {
            this.logCombi.log(1000000, "[%1.updateActiveSource] TV Source -> no update.", (Object)LOGCLASS);
            return;
        }
        try {
            this.combiState.updateActiveSource(this.activeBAPSourceType, this.activeBAPSourceSlotIdx, this.activeBAPSourcePartitionIdx, this.currentListAvailable, false, this.currentListState);
            this.combiState.updateActiveInfoState(9);
            this.getCombiBAPService().updatePlaybackFolder(false);
            this.combiState.updateCurrentStationInfo(new CombiBAPCurrentStationInfo("", 0, 0));
            this.getCombiBAPService().updatePlayPosition(PlayPosition.builder().setTimePosition(TimeStamp.getInstanceFromSeconds(65535)).setTotalPlayTime(TimeStamp.getInstanceFromSeconds(65535)).setVariableBitRate(false).build());
            this.getCombiBAPService().updateCurrentBrowseFolder(0, null, 0, 0, 0);
        }
        catch (Exception exception) {
            this.logCombi.log(10000, "[%1.updateActiveSource] %2", (Object)LOGCLASS, (Throwable)exception);
        }
    }

    public void updateActiveSourceState(ActiveSourceState activeSourceState) {
        this.logCombi.log(1000000, "[%1.updateActiveSourceState] '%2' %3.", (Object)LOGCLASS, (Object)activeSourceState, (Object)this.currentActiveSourceState);
        ActiveSourceState activeSourceState2 = this.currentActiveSourceState;
        this.setActiveSourceState(activeSourceState);
        if (CombiBAPController.ignoreSourceUpdate(activeSourceState.getSlot())) {
            this.logCombi.log(1000000, "[%1.updateActiveSourceState] current source is tv -> ignore.", (Object)LOGCLASS);
            return;
        }
        int n = CombiBAPUtils.getBAPInfoState(activeSourceState);
        try {
            this.logCombi.log(10000000, "[%1.updateActiveSourceState] combiState='%2'", (Object)LOGCLASS, (long)n);
            if (activeSourceState.getSlot().getSource().getType() == 10) {
                this.logCombi.log(1000000, "[%1.updateActiveSourceState] USB source.", (Object)LOGCLASS);
                if (activeSourceState2 != null && activeSourceState.getState() == activeSourceState2.getState()) {
                    this.logCombi.log(1000000, "[%1.updateActiveSourceState] States are the same", (Object)LOGCLASS);
                } else {
                    this.logCombi.log(1000000, "[%1.updateActiveSourceState] Old state was no media", (Object)LOGCLASS);
                    this.updateUSBSource();
                }
            }
            if (activeSourceState.getSlot().getSource().getType() == 13 && activeSourceState.getState() != 1) {
                this.logCombi.log(1000000, "[%1.updateActiveSourceState] reset online music state to normal operation", (Object)LOGCLASS);
                this.getCombiBAPService().updateOnlineMusicState(1, 100);
            }
            this.combiState.updateActiveInfoState(n);
            if (activeSourceState.getState() != 1) {
                this.updateCurrentPlayingTrack(-1, 0L, 0, 0, I18NString.EMPTY_I18N_STRING, I18NString.EMPTY_I18N_STRING, I18NString.EMPTY_I18N_STRING, I18NString.EMPTY_I18N_STRING, false, 0, null);
            }
            if ((activeSourceState2 == null || activeSourceState.getState() != activeSourceState2.getState()) && activeSourceState.getState() == 4) {
                this.logCombi.log(1000000, "[%1.updateActiveSourceState] Also inform combi about the listsize if active medium was removed.", (Object)LOGCLASS);
                this.combiState.updateListSize(0);
            }
        }
        catch (Exception exception) {
            this.logCombi.log(10000, "[%1.updateActiveSourceState] %2", (Object)LOGCLASS, (Throwable)exception);
        }
    }

    public void setActiveSourceState(ActiveSourceState activeSourceState) {
        this.logCombi.log(1000000, "[%1.setActiveSourceState] '%2' %3.", (Object)LOGCLASS, (Object)activeSourceState, (Object)this.currentActiveSourceState);
        this.currentActiveSourceState = activeSourceState;
        if (null != this.activeCombiContentAdapter && activeSourceState != null) {
            this.activeCombiContentAdapter.updateActiveSlot(activeSourceState.getSlot());
        }
    }

    public void updateUSBSource() {
        if (this.getTerminal().getSourceController().getActivationContext() == null) {
            this.logCombi.log(1000000, "[%1.updateUSBSource] no activation context", (Object)LOGCLASS);
            return;
        }
        ISourceSlot iSourceSlot = this.getTerminal().getSourceController().getActivationContext().getSlot();
        if (iSourceSlot != null && iSourceSlot.getSource().getType() != 10 || iSourceSlot == null) {
            this.logCombi.log(1000000, "[%1.updateUSBSource] USB is not active source", (Object)LOGCLASS);
            return;
        }
        ISourceSlot iSourceSlot2 = iSourceSlot.getSource().isEmpty() ? iSourceSlot.getSource().getSlot(0) : iSourceSlot.getSource().getSlot(iSourceSlot);
        this.logCombi.log(1000000, "[%1.updateUSBSource] new usb slot '%2'", (Object)LOGCLASS, (Object)iSourceSlot2);
        int n = CombiBAPUtils.getBAPSourceType(iSourceSlot.getSource(), iSourceSlot2);
        int n2 = CombiBAPUtils.getBapSourceIndex(iSourceSlot);
        int n3 = MediaUtils.calculatePartitionIndex(iSourceSlot2);
        this.activeBAPSourceType = n;
        this.activeBAPSourceSlotIdx = n2;
        this.activeBAPSourcePartitionIdx = n3;
        this.logCombi.log(1000000, "[%1.updateUSBSource] %2", (Object)LOGCLASS, (long)this.activeBAPSourceType);
        this.combiState.updateActiveSource(this.activeBAPSourceType, this.activeBAPSourceSlotIdx, this.activeBAPSourcePartitionIdx, this.currentListAvailable, false, this.currentListState);
    }

    void updateSourceList(int[] nArray, CombiBAPAudioSource[][] combiBAPAudioSourceArray) {
        this.logCombi.log(1000000, "[%1.updateSourceList]", (Object)LOGCLASS);
        this.combiState.updateSourceList(nArray, combiBAPAudioSourceArray);
    }

    void switchSourceResult(boolean bl) {
        this.logCombi.log(1000000, "[%2.switchSourceResult] '%1'.", bl, (Object)LOGCLASS);
        try {
            this.getCombiBAPService().switchSourceResult(bl ? 0 : 1);
        }
        catch (Exception exception) {
            this.logCombi.log(10000, "[%1.switchSourceResult] %2", (Object)LOGCLASS, (Throwable)exception);
        }
    }

    void skipResult(boolean bl) {
        this.logCombi.log(1000000, "[%2.skipResult] '%1'.", bl, (Object)LOGCLASS);
        try {
            this.getCombiBAPService().skipResult(bl);
        }
        catch (Exception exception) {
            this.logCombi.log(10000, "[%1.skipResult] %2", (Object)LOGCLASS, (Throwable)exception);
        }
    }

    public void updateCurrentPlayingTrack(int n, long l, int n2, int n3, I18NString i18NString, I18NString i18NString2, I18NString i18NString3, I18NString i18NString4, boolean bl, int n4, ResourceLocator resourceLocator) {
        Object object;
        if (this.logCombi.isInfo()) {
            object = new Buffer();
            ((Buffer)object).append("content='").append(n).append("',entryID='").append(l).append("',type='").append(n2).append("',title='").append(i18NString).append("',filename='").append(i18NString2).append("',pos='").append(n4).append("'");
            this.logCombi.log(1000000, "[%1.updateCurrentPlayingTrack] %2", (Object)LOGCLASS, object);
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
            this.logCombi.log(10000, "[%1.updateCurrentPlayingTrack] %2", (Object)LOGCLASS, (Throwable)exception);
        }
    }

    public void updateActiveRepeatScope(int n, boolean bl) {
        int n2;
        this.logCombi.log(1000000, "[%2.updateActiveRepeatScope] scope='%3' (mix='%1')", bl, (Object)LOGCLASS, (Object)String.valueOf(n));
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
            this.logCombi.log(10000, "[%1.skipResult] %2", (Object)LOGCLASS, (Throwable)exception);
        }
    }

    public void updateBrowseFolder(MediaListEntry[] mediaListEntryArray, int n) {
        if (this.logCombi.getCurrentLogThreshold() >= 1000000) {
            this.logCombi.log(1000000, "[%1.updateBrowseFolder] '%2' (pos='%3')", (Object)LOGCLASS, (Object)LogUtil.listEntryToStr(mediaListEntryArray), (long)n);
        }
        try {
            String string;
            int n2;
            int n3;
            this.idMapper.reset(false, this.currentFolderStack.length < mediaListEntryArray.length);
            this.currentFolderStack = mediaListEntryArray;
            int n4 = 0;
            int n5 = 65535;
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
            this.logCombi.log(10000, "[%1.updateBrowseFolder] %2", (Object)LOGCLASS, (Throwable)exception);
        }
    }

    public void updateListSize(int n) {
        this.logCombi.log(1000000, "[%1.updateListSize] '%2'", (Object)LOGCLASS, (long)n);
        this.combiState.updateListSize(n);
    }

    public void trackChangeIsComing() {
        this.logCombi.log(1000000, "[%1.trackChangeIsComing]", (Object)LOGCLASS);
        this.getCombiBAPService().trackChangeIsComing();
    }

    public void contentAdapterStartupFinished() {
        this.adapterStartupFinished = true;
        this.logCombi.log(1000000, "[%1.contentAdapterStartupFinished] '%2'", (Object)LOGCLASS, (Object)this.currentActiveSourceState);
        try {
            if (this.currentActiveSourceState == null || this.currentActiveSourceState.getState() == 1 || this.currentActiveSourceState.getState() == 2) {
                this.logCombi.log(1000000, "[%1.contentAdapterStartupFinished] currentActiveSourceState='%2'", (Object)LOGCLASS, (Object)this.currentActiveSourceState);
                this.combiState.updateActiveInfoState(0);
            }
        }
        catch (Exception exception) {
            this.logCombi.log(10000, "[%1.contentAdapterStartupFinished] %2", (Object)LOGCLASS, (Throwable)exception);
        }
    }

    public void updateActiveFileplayerPlaybackType(int n) {
        this.logCombi.log(1000000, "[%1.updateFilePlayerPlaybackType] '%2'", (Object)LOGCLASS, (long)n);
        try {
            this.combiState.updateActiveInfoState(n == 1 ? 67 : 70);
        }
        catch (Exception exception) {
            this.logCombi.log(10000, "[%1.contentAdapterStartupFinished] %2", (Object)LOGCLASS, (Throwable)exception);
        }
    }

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
        this.logCombi.log(1000000, "[%2.updateListState] '%1', '%3'", (Object)(bl ? "LIST" : "NO LIST"), (Object)LOGCLASS, (Object)string);
        if (this.currentListAvailable == bl && this.currentListState == n2) {
            this.logCombi.log(1000000, "[%1.updateListState] Already set", (Object)LOGCLASS);
            return;
        }
        this.currentListAvailable = bl;
        this.currentListState = n2;
        try {
            this.combiState.updateActiveSource(this.activeBAPSourceType, this.activeBAPSourceSlotIdx, this.activeBAPSourcePartitionIdx, this.currentListAvailable, false, this.currentListState);
        }
        catch (Exception exception) {
            this.logCombi.log(10000, "[%1.updateListState] %2", (Object)LOGCLASS, (Throwable)exception);
        }
    }

    public void gotoCurrentPlayingTrackResult(boolean bl) {
        this.logCombi.log(1000000, "[%2.gotoCurrentPlayingTrackResult] '%1'.", bl, (Object)LOGCLASS);
        try {
            this.getCombiBAPService().goToResult(0, bl ? 0 : 1);
        }
        catch (Exception exception) {
            this.logCombi.log(10000, "[%1.gotoCurrentPlayingTrackResult] %2", (Object)LOGCLASS, (Throwable)exception);
        }
    }

    public void gotoParentFolderResult(boolean bl) {
        this.logCombi.log(1000000, "[%2.gotoParentFolderResult] '%1'.", bl, (Object)LOGCLASS);
        try {
            this.getCombiBAPService().goToResult(2, bl ? 0 : 1);
        }
        catch (Exception exception) {
            this.logCombi.log(10000, "[%1.gotoParentFolderResult] %2", (Object)LOGCLASS, (Throwable)exception);
        }
    }

    public void gotoRootFolderResult(boolean bl) {
        this.logCombi.log(1000000, "[%2.gotoRootFolderResult] '%1'.", bl, (Object)LOGCLASS);
        try {
            this.getCombiBAPService().goToResult(1, bl ? 0 : 1);
        }
        catch (Exception exception) {
            this.logCombi.log(10000, "[%1.gotoRootFolderResult] %2", (Object)LOGCLASS, (Throwable)exception);
        }
    }

    public void gotoSubFolderResult(boolean bl) {
        this.logCombi.log(1000000, "[%2.gotoSubFolderResult] '%1'.", bl, (Object)LOGCLASS);
        try {
            this.getCombiBAPService().goToResult(4, bl ? 0 : 1);
        }
        catch (Exception exception) {
            this.logCombi.log(10000, "[%1.gotoSubFolderResult] %2", (Object)LOGCLASS, (Throwable)exception);
        }
    }

    public void responseList(int n, int n2, int n3, MediaListEntry[] mediaListEntryArray) {
        this.logCombi.log(1000000, "[%1.responseList] transactionID='%2', startIndex='%3'.", (Object)LOGCLASS, (long)n, (long)n3);
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
                this.logCombi.log(1000000, "[%1.responseList] bapEntries[%2] '%3'.", (Object)LOGCLASS, (long)i2, (long)n6);
            }
            this.getCombiBAPService().responseMediaBrowserList(n, combiBAPMediaBrowserListEntryArray);
        }
        catch (Exception exception) {
            this.logCombi.log(10000, "[%1.responseList] %2", (Object)LOGCLASS, (Throwable)exception);
        }
    }

    public void updatePlaybackFolder(boolean bl) {
        this.combiState.updatePlaybackFolder(bl);
    }

    public void updatePlayPosition(PlayTime playTime) {
        if (this.logCombi.isDebug2()) {
            this.logCombi.log(100000000, "[%1.updatePlayPosition] %2", (Object)LOGCLASS, (Object)PlayTime.toTimeString(playTime.getPlayTime(), false));
        }
        this.combiMediaService.updatePlayPosition(PlayPosition.builder().setTimePosition(TimeStamp.getInstanceFromSeconds(playTime.getPlayTime())).setTotalPlayTime(TimeStamp.getInstanceFromSeconds(playTime.getTotalTimeOfTrack())).build());
    }

    public void getNextListPosResult(boolean bl, CombiBAPMediaEntry combiBAPMediaEntry, CombiBAPMediaEntry combiBAPMediaEntry2, int n) {
        this.logCombi.log(1000000, "[%1.getNexListPosResult] '%2', requested='%3',next='%4'", (Object)LOGCLASS, (Object)String.valueOf(bl), (Object)combiBAPMediaEntry, (Object)combiBAPMediaEntry2);
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
            this.logCombi.log(10000, "[%1.getNexListPosResult] %2", (Object)LOGCLASS, (Throwable)exception);
        }
    }

    public void selectListEntryResult(boolean bl) {
        this.logCombi.log(1000000, "[%2.selectListEntryResult] '%1.", bl, (Object)LOGCLASS);
        try {
            this.getCombiBAPService().selectListEntryResult(bl ? 0 : 1);
        }
        catch (Exception exception) {
            this.logCombi.log(10000, "[%1.selectListEntryResult] %2", (Object)LOGCLASS, (Throwable)exception);
        }
    }

    public void updateSeekState(boolean bl) {
        this.logCombi.log(1000000, "[%1.updateSeekState] '%2'", (Object)LOGCLASS, (Object)(bl ? "SEEKING" : "NOT SEEKING"));
        try {
            this.getCombiBAPService().updateSeekStatus(bl);
        }
        catch (Exception exception) {
            this.logCombi.log(10000, "[%1.updateSeekState] %2", (Object)LOGCLASS, (Throwable)exception);
        }
    }

    public void updateActivateSourceResult(boolean bl) {
        this.logCombi.log(1000000, "[%1.updateActivateSourceResult] '%2'", (Object)LOGCLASS, (Object)(bl ? "OK" : "NOK"));
        try {
            this.getCombiBAPService().activateSourceResult(bl ? 0 : 1);
        }
        catch (Exception exception) {
            this.logCombi.log(10000, "[%1.updateSeekState] %2", (Object)LOGCLASS, (Throwable)exception);
        }
    }

    public void updateImportState(ISourceSlot iSourceSlot, boolean bl, int n) {
        if (this.logCombi.isInfo()) {
            this.logCombi.log(1000000, "[%1.updateImportState] '%2','%3','%4'", (Object)LOGCLASS, (Object)iSourceSlot, (Object)bl, (Object)new Integer(n));
        }
        CombiBAPAudioSource combiBAPAudioSource = iSourceSlot != null ? CombiBAPUtils.getBAPSource(iSourceSlot.getSource(), iSourceSlot) : new CombiBAPAudioSource(255, 0, 255, "");
        try {
            this.getCombiBAPService().updateMediaImportState(combiBAPAudioSource.getSourceType(), combiBAPAudioSource.getInstanceId(), bl, n);
        }
        catch (Exception exception) {
            this.logCombi.log(10000, "[%1.updateImportState] %2", (Object)LOGCLASS, (Throwable)exception);
        }
    }

    boolean isStartupFinished() {
        return this.adapterStartupFinished;
    }

    public void changeActiveSourceMediaType(int n) {
        int n2;
        this.logCombi.log(1000000, "[%1.changeActiveSourceMediaType] '%2'", (Object)LOGCLASS, (long)n);
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
            this.logCombi.log(1000000, "[%1.changeActiveSourceMediaType] Already set", (Object)LOGCLASS);
            return;
        }
        this.activeBAPSourceType = n2;
        try {
            this.combiState.updateActiveSource(this.activeBAPSourceType, this.activeBAPSourceSlotIdx, this.activeBAPSourcePartitionIdx, this.currentListAvailable, false, this.currentListState);
        }
        catch (Exception exception) {
            this.logCombi.log(10000, "[%1.changeActiveSourceMediaType] %2", (Object)LOGCLASS, (Throwable)exception);
        }
    }

    public void updatePreferredList(int n) {
        this.getCombiBAPService().updatePreferredList(1);
    }

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
        this.logCombi.log(1000000, "[%1.updateOnlineMusicState bapMusicState='%2', pBufferLevel='%3' ]", (Object)LOGCLASS, (Object)new Integer(n4), (Object)new Integer(n3));
        this.getCombiBAPService().updateOnlineMusicState(n4, 255);
    }

    private static boolean ignoreSourceUpdate(ISourceSlot iSourceSlot) {
        return iSourceSlot.getSource().getType() == 7 || iSourceSlot.getSource().getType() == 8;
    }

    public String toString() {
        Buffer buffer = new Buffer(20);
        buffer.append(LOGCLASS).append("@").append(this.hashCode());
        return buffer.toString();
    }

    public String getDiagKey() {
        return LOGCLASS;
    }

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

    class CombiBapState {
        private static final String LOGCLASS = "CombiBapState";
        private volatile int sourceType = -1;
        private volatile int slotNumber = -1;
        private volatile int partitionNumber = -1;
        private volatile int infoState = -1;
        private volatile CombiBAPAudioSource[][] audioSources = new CombiBAPAudioSource[0][0];
        private volatile CombiBAPCurrentStationInfo station = new CombiBAPCurrentStationInfo("", 0, 0);
        private volatile boolean listAvailable = false;
        private volatile int listState = 4;
        private volatile int listSize = 0;
        private volatile boolean isPlaybackFolder = false;

        CombiBapState() {
        }

        void updateActiveSource(int n, int n2, int n3, boolean bl, boolean bl2, int n4) {
            this.sourceType = n;
            this.slotNumber = n2;
            this.partitionNumber = n3;
            this.listAvailable = bl;
            this.listState = n4;
            CombiBAPController.this.logCombi.log(100000000, "[%1.updateActiveSource] sourceType=%2", (Object)LOGCLASS, (Object)this.getSourceTypeString(this.sourceType));
            CombiBAPController.this.getCombiBAPService().updateActiveSource(n, this.slotNumber, this.partitionNumber, bl, bl2, n4);
            if (n == 15 || n == 19) {
                this.updateActiveInfoState(this.infoState);
                this.updateCurrentStationInfo(this.station);
            }
        }

        void updateActiveInfoState(int n) {
            this.infoState = n;
            CombiBAPController.this.logCombi.log(100000000, "[%1.updateActiveInfoState] infoStatee=%2", (Object)LOGCLASS, (Object)CombiBAPUtils.getInfoStateString(this.infoState));
            CombiBAPController.this.getCombiBAPService().updateActiveInfoState(this.infoState);
        }

        void updateCurrentStationInfo(CombiBAPCurrentStationInfo combiBAPCurrentStationInfo) {
            CombiBAPController.this.logCombi.log(100000000, "[%1.updateCurrentStationInfo]", (Object)LOGCLASS);
            this.station = combiBAPCurrentStationInfo;
            CombiBAPController.this.getCombiBAPService().updateCurrentStation(combiBAPCurrentStationInfo);
        }

        void updateSourceList(int[] nArray, CombiBAPAudioSource[][] combiBAPAudioSourceArray) {
            CombiBAPController.this.logCombi.log(1000000, "[%1.updateSourceList]", (Object)LOGCLASS);
            this.audioSources = combiBAPAudioSourceArray;
            try {
                int n;
                for (n = 0; n < combiBAPAudioSourceArray.length; ++n) {
                    int n2 = nArray[n];
                    for (int i2 = 0; i2 < combiBAPAudioSourceArray[n].length; ++i2) {
                        Buffer buffer = new Buffer(200);
                        buffer.append(this.getSourceTypeString(n2));
                        CombiBAPAudioSource combiBAPAudioSource = combiBAPAudioSourceArray[n][i2];
                        buffer.append("(").append(this.getMediaTypeString(combiBAPAudioSource.getMediaType()));
                        buffer.append(",").append(combiBAPAudioSource.getName());
                        buffer.append(",").append(combiBAPAudioSource.getSlotNumber());
                        buffer.append(",").append(combiBAPAudioSource.getPartitionNumber()).append(")");
                        CombiBAPController.this.logCombi.log(1000000, "[%1.updateSourceList] %2", (Object)LOGCLASS, (Object)buffer);
                    }
                }
                for (n = 0; n < nArray.length; ++n) {
                    if (nArray[n] != 11 || combiBAPAudioSourceArray[n].length != 1) continue;
                    CombiBAPController.this.logCombi.log(1000000, "[%1.updateSourceList] setSlotNumber(-1) for SD-Card.", (Object)LOGCLASS);
                    combiBAPAudioSourceArray[n][0].setSlotNumber(-1);
                }
                CombiBAPController.this.getCombiBAPService().updateSourceListMedia(nArray, this.audioSources);
            }
            catch (Exception exception) {
                CombiBAPController.this.logCombi.log(10000, "[%1.updateSourceList] ", (Object)LOGCLASS, (Throwable)exception);
            }
        }

        public void resetMedia() {
            CombiBAPController.this.logCombi.log(1000000, "[%1.resetMedia]", (Object)LOGCLASS);
            this.updateActiveSource(0, 0, 0, false, false, 0);
            this.updateActiveInfoState(9);
            this.updateCurrentStationInfo(new CombiBAPCurrentStationInfo("", 0, 0));
        }

        void updateListSize(int n) {
            this.listSize = n;
            try {
                CombiBAPController.this.getCombiBAPService().updateBrowserListSize(this.listSize);
            }
            catch (Exception exception) {
                CombiBAPController.this.logCombi.log(10000, "[%1.updateListSize] %2", (Object)LOGCLASS, (Throwable)exception);
            }
        }

        void updatePlaybackFolder(boolean bl) {
            CombiBAPController.this.logCombi.log(1000000, "[%2.updatePlaybackFolder] '%1'", this.isPlaybackFolder, (Object)LOGCLASS);
            this.isPlaybackFolder = bl;
            try {
                CombiBAPController.this.getCombiBAPService().updatePlaybackFolder(this.isPlaybackFolder);
            }
            catch (Exception exception) {
                CombiBAPController.this.logCombi.log(10000, "[%1.updatePlaybackFolder] %2", (Object)LOGCLASS, (Throwable)exception);
            }
        }

        public String toString() {
            Buffer buffer = new Buffer(200);
            buffer.append("sourceType=").append(this.getSourceTypeString(this.sourceType));
            buffer.append("(").append(this.sourceType).append(")");
            buffer.append(" ,slotNumber=").append(this.slotNumber);
            buffer.append(" ,partitionNumber=").append(this.partitionNumber).append("\n");
            buffer.append("infoState=").append(CombiBAPUtils.getInfoStateString(this.infoState));
            buffer.append("(").append(this.infoState).append(")\n");
            buffer.append("station: ");
            if (this.station == null) {
                buffer.append("noStation");
            } else {
                buffer.append("'").append(this.station.getPrimaryInformation()).append("'\n");
            }
            buffer.append(" ,listAvailable=").append(this.listAvailable).append("\n");
            buffer.append(" ,listState=").append(this.getListStateString()).append("\n");
            buffer.append(" ,listSize=").append(this.listSize).append("\n");
            buffer.append(" ,isPlaybackFolder=").append(this.isPlaybackFolder).append("\n");
            buffer.append("SourceList: ").append(this.audioSources.length).append("\n");
            for (int i2 = 0; i2 < this.audioSources.length; ++i2) {
                for (int i3 = 0; i3 < this.audioSources[i2].length; ++i3) {
                    buffer.append(this.audioSources[i2][i3]).append("\n");
                }
            }
            return buffer.toString();
        }

        String getSourceTypeString(int n) {
            String string;
            switch (n) {
                case 13: {
                    string = "SOURCE_TYPE_AUX_IN_AUDIO";
                    break;
                }
                case 9: {
                    string = "SOURCE_TYPE_AUX_IN_AUDIO";
                    break;
                }
                case 21: {
                    string = "SOURCE_TYPE_BLUETOOTH_CONNECTION_BT_STREAM";
                    break;
                }
                case 22: {
                    string = "SOURCE_TYPE_BLUETOOTH_CONNECTION_REMOTE_CONTROL_PROTOCOL";
                    break;
                }
                case 7: {
                    string = "SOURCE_TYPE_CD_CHANGER";
                    break;
                }
                case 6: {
                    string = "SOURCE_TYPE_CD";
                    break;
                }
                case 18: {
                    string = "SOURCE_TYPE_DVD_CHANGER";
                    break;
                }
                case 8: {
                    string = "SOURCE_TYPE_DVD";
                    break;
                }
                case 20: {
                    string = "SOURCE_TYPE_JUKEBOX";
                    break;
                }
                case 11: {
                    string = "SOURCE_TYPE_SD";
                    break;
                }
                case 19: {
                    string = "SOURCE_TYPE_USB";
                    break;
                }
                case 27: {
                    string = "SOURCE_TYPE_WLAN_CONNECTION_MASS_STORAGE";
                    break;
                }
                case 34: {
                    string = "SOURCE_TYPE_ONLINE_MASS_STORAGE_DF4_1";
                    break;
                }
                case 15: {
                    string = "SOURCE_TYPE_PORTABLE_DEVICE_MDI_AMI";
                    break;
                }
                default: {
                    string = "SOURCE_TYPE_NO_SOURCE";
                }
            }
            return string;
        }

        String getListStateString() {
            String string;
            switch (this.listState) {
                case 0: {
                    string = "LIST_STATE_UNKNOW";
                    break;
                }
                case 1: {
                    string = "LIST_STATE_LOADING";
                    break;
                }
                case 3: {
                    string = "LIST_STATE_COMPLETELY_LOADED";
                    break;
                }
                case 2: {
                    string = "LIST_STATE_INCOMPLETE_LOADED";
                    break;
                }
                default: {
                    string = "Unknown list State";
                }
            }
            return string;
        }

        String getMediaTypeString(int n) {
            String string;
            switch (n) {
                case 0: {
                    string = "MEDIA_TYPE_MEDIA_TYPE_NOT_AVAIALBLE_NOT_APPLICABLE";
                    break;
                }
                case 1: {
                    string = "MEDIA_TYPE_CD_AUDIO";
                    break;
                }
                case 2: {
                    string = "MEDIA_TYPE_DVD_AUDIO";
                    break;
                }
                case 3: {
                    string = "MEDIA_TYPE_DVD_VIDEO";
                    break;
                }
                case 4: {
                    string = "MEDIA_TYPE_CD_VIDEO";
                    break;
                }
                case 5: {
                    string = "MEDIA_TYPE_CD_ROM";
                    break;
                }
                case 6: {
                    string = "MEDIA_TYPE_DVD_ROM";
                    break;
                }
                case 7: {
                    string = "MEDIA_TYPE_FILE_SYSTEM";
                    break;
                }
                case 8: {
                    string = "MEDIA_TYPE_RAW";
                    break;
                }
                case 9: {
                    string = "MEDIA_TYPE_RCP_REMOTE_CONTROL_PROTOCOL";
                    break;
                }
                case 10: {
                    string = "MEDIA_TYPE_AUDIO_BROADCASTING_RADIO";
                    break;
                }
                case 11: {
                    string = "MEDIA_TYPE_VIDEO_BROADCASTING_TV_DVB";
                    break;
                }
                case 12: {
                    string = "MEDIA_TYPE_I_POD";
                    break;
                }
                case 13: {
                    string = "MEDIA_TYPE_BLUE_RAY";
                    break;
                }
                case 255: {
                    string = "MEDIA_TYPE_UNKNOWN_MEDIA_TYPE";
                    break;
                }
                default: {
                    string = "UNKNOWN";
                }
            }
            return string;
        }
    }
}

