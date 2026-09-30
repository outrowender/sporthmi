/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.app.audio;

import de.audi.app.bap.fw.functionsync.IFunctionSynchronizationHandler;
import de.audi.app.bap.fw.functiontypes.BAPFunctionArrayFSG;
import de.audi.app.bap.fw.functiontypes.BAPFunctionMethodFSG;
import de.audi.app.bap.fw.functiontypes.BAPFunctionPropertyFSG;
import de.audi.app.combi.bap.AbstractCombiConnector;
import de.audi.app.combi.bap.app.audio.BoardBookVideoLogic;
import de.audi.app.combi.bap.app.audio.CombiBAPAudioListStates;
import de.audi.app.combi.bap.app.audio.CombiModuleAudio;
import de.audi.app.combi.bap.app.audio.IAudioApplicationInFocusObserver;
import de.audi.app.combi.bap.app.audio.functionsync.FunctionSynchronizationHandlerAudio;
import de.audi.app.combi.bap.app.audio.list.AbstractSourceListObserver;
import de.audi.app.combi.bap.app.audio.list.MediaBrowserListHandler;
import de.audi.app.combi.bap.app.audio.list.RadioTVPresetListHandler;
import de.audi.app.combi.bap.app.audio.list.ReceptionListHandler;
import de.audi.app.combi.bap.app.audio.list.SourceListHandler;
import de.audi.app.combi.bap.fw.AbstractCombiModule;
import de.audi.app.combi.bap.fw.CombiCodingAccess;
import de.audi.atip.interapp.combi.bap.audio.CombiBAPServiceAudio;
import de.audi.atip.interapp.combi.bap.audio.data.CombiBAPAudioSource;
import de.audi.atip.interapp.combi.bap.audio.data.CombiBAPCurrentStationInfo;
import de.audi.atip.interapp.combi.bap.audio.data.CombiBAPPresetListEntry;
import de.audi.atip.interapp.combi.bap.audio.data.CombiBAPReceptionListEntry;
import de.vw.mib.bap.generated.audiosd.serializer.ActiveSourceName_Status;
import de.vw.mib.bap.generated.audiosd.serializer.ActiveSource_Status;
import de.vw.mib.bap.generated.audiosd.serializer.CurrentStationInfo_Status;
import de.vw.mib.bap.generated.audiosd.serializer.CurrentStation_Handle2_Status;
import de.vw.mib.bap.generated.audiosd.serializer.CurrentStation_Handle_Status;
import de.vw.mib.bap.generated.audiosd.serializer.GetNextListPos_Result;
import de.vw.mib.bap.generated.audiosd.serializer.InfoStates_Status;
import de.vw.mib.bap.generated.audiosd.serializer.OnlineMusic_State_Status;
import de.vw.mib.bap.generated.audiosd.serializer.PlayPosition_Status;
import de.vw.mib.bap.generated.audiosd.serializer.PreferredList_Status;
import de.vw.mib.bap.generated.audiosd.serializer.SourceState_Status;
import de.vw.mib.bap.generated.audiosd.serializer.SwitchRadioMedia_Result;
import de.vw.mib.bap.generated.audiosd.serializer.SwitchSource_Result;
import org.dsi.ifc.global.ResourceLocator;

abstract class AbstractAppConnectorAudio
extends AbstractCombiConnector
implements CombiBAPServiceAudio,
IAudioApplicationInFocusObserver {
    private final CombiBAPAudioSource activeSource = CombiModuleAudio.getDefaultSource();
    private final CombiBAPAudioListStates listStates = new CombiBAPAudioListStates();
    private volatile int sourceListReference;
    private volatile int restorableInfoState = -1;
    private volatile SourceState_Status sourceStateStatus = new SourceState_Status();
    private volatile CurrentStationInfo_Status currentStationInfoStatus = new CurrentStationInfo_Status();
    protected volatile CurrentStation_Handle_Status currentStationHandleStatus = new CurrentStation_Handle_Status();
    private volatile CurrentStation_Handle2_Status currentStationHandle2Status = new CurrentStation_Handle2_Status();
    private volatile InfoStates_Status infoStatesStatus = new InfoStates_Status();
    private volatile PreferredList_Status preferredListStatus = new PreferredList_Status();
    private volatile OnlineMusic_State_Status onlineMusicStateStatus = new OnlineMusic_State_Status();
    private final BoardBookVideoLogic boardBookVideoLogic = new BoardBookVideoLogic(this.logChannel);

    protected AbstractAppConnectorAudio(CombiModuleAudio combiModuleAudio) {
        super(combiModuleAudio);
        combiModuleAudio.getAudioApplicationFocusHandler().addObserver(this);
    }

    public void notifyAudioApplicationInFocusChanged(int n) {
        if (this.isAudioApplicationInFocus()) {
            this.activateSource();
            this.sendSourceChangeRelatedProperties();
        }
    }

    protected abstract int getAudioApplication();

    protected abstract String getAudioApplicationName();

    private int getAudioApplicationInFocus() {
        return ((CombiModuleAudio)this.moduleFsg).getAudioApplicationFocusHandler().getAudioApplicationInFocus();
    }

    protected abstract boolean isAudioApplicationInFocus();

    private void logNotActive(String string) {
        this.logChannel.log(10000000, "[AbstractAppConnectorAudio#%1] %2 not active -> don't send update (active audio application is %3)", (Object)string, (Object)this.getAudioApplicationName(), (Object)((CombiModuleAudio)this.moduleFsg).getAudioApplicationFocusHandler().getAudioApplicationInFocusName());
    }

    protected void updateActiveSource(CombiBAPAudioSource combiBAPAudioSource, CombiBAPAudioListStates combiBAPAudioListStates) {
        this.logChannel.log(1000000, "[AbstractAppConnectorAudio#updateActiveSource] app: %1 source=%2 listStates=%3", (Object)this.getAudioApplicationName(), (Object)combiBAPAudioSource, (Object)combiBAPAudioListStates);
        this.activeSource.setSourceType(combiBAPAudioSource.getSourceType());
        this.activeSource.setSlotNumber(combiBAPAudioSource.getSlotNumber());
        this.activeSource.setPartitionNumber(combiBAPAudioSource.getPartitionNumber());
        this.listStates.setMediaBrowserListAvailable(combiBAPAudioListStates.isMediaBrowserListAvailable());
        this.listStates.setPresetListAvailable(combiBAPAudioListStates.isPresetListAvailable());
        this.listStates.setReceptionListAvailable(combiBAPAudioListStates.isReceptionListAvailable());
        this.listStates.setListState(combiBAPAudioListStates.getListState());
        SourceListHandler sourceListHandler = (SourceListHandler)this.moduleFsg.getBAPFunctionArrayFSG(32).getArrayHandler();
        CombiBAPAudioSource combiBAPAudioSource2 = sourceListHandler.getAudioSource(this.activeSource.getSourceType(), this.activeSource.getSourceId(), false);
        if (combiBAPAudioSource2 == null) {
            this.logChannel.log(100000, "[AbstractAppConnectorAudio#updateActiveSource] updated source not in source list!");
        } else {
            this.logChannel.log(10000000, "[AbstractAppConnectorAudio#updateActiveSource] updated source: %1", (Object)combiBAPAudioSource2);
            this.sourceListReference = combiBAPAudioSource2.getPosID();
            this.activeSource.setName(combiBAPAudioSource2.getName());
        }
        if (!this.isAudioApplicationInFocus()) {
            this.logNotActive("updateActiveSource");
            return;
        }
        if (this.isSourceSet() && this.hasSourceChanged(((CombiModuleAudio)this.moduleFsg).getPreviousActiveSource())) {
            this.activateSource();
            return;
        }
        this.sendActiveSourceProperty();
        this.sendActiveSourceNameProperty();
    }

    private boolean isSourceSet() {
        return this.activeSource.getSourceType() != 0;
    }

    private boolean hasSourceChanged(CombiBAPAudioSource combiBAPAudioSource) {
        return this.activeSource.getSourceType() != combiBAPAudioSource.getSourceType() || this.activeSource.getSlotNumber() != combiBAPAudioSource.getSlotNumber() || this.activeSource.getPartitionNumber() != combiBAPAudioSource.getPartitionNumber();
    }

    private void activateSource() {
        SourceListHandler sourceListHandler = (SourceListHandler)this.moduleFsg.getBAPFunctionArrayFSG(32).getArrayHandler();
        CombiBAPAudioSource combiBAPAudioSource = sourceListHandler.notifySourceChanged(this.activeSource.getSourceType(), this.activeSource.getSourceId(), new AbstractSourceListObserver(){

            public void notifySourceAdded(CombiBAPAudioSource combiBAPAudioSource) {
                AbstractAppConnectorAudio.this.logChannel.log(10000000, "[AbstractAppConnectorAudio#activateSource#notifySourceAdded] %1", (Object)combiBAPAudioSource);
                AbstractAppConnectorAudio.this.activeSource.set(combiBAPAudioSource);
                AbstractAppConnectorAudio.this.sourceListReference = combiBAPAudioSource.getPosID();
                AbstractAppConnectorAudio.this.sendActiveSourceProperty();
                AbstractAppConnectorAudio.this.sendActiveSourceNameProperty();
            }
        });
        this.logChannel.log(10000000, "[AbstractAppConnectorAudio#activateSource] activatedSource: %1", (Object)combiBAPAudioSource);
        CombiBAPAudioSource combiBAPAudioSource2 = ((CombiModuleAudio)this.moduleFsg).getPreviousActiveSource();
        if (this.isFunctionSyncNeeded(combiBAPAudioSource2.getSourceType(), combiBAPAudioSource.getSourceType())) {
            this.logChannel.log(1000000, "[AbstractAppConnectorAudio#activateSource] trigger function sync");
            this.handleSourceChangeFunctionSync(combiBAPAudioSource2.getSourceType(), combiBAPAudioSource.getSourceType());
            this.sendPreferredListProperty();
        }
        combiBAPAudioSource2.set(this.activeSource);
        this.activeSource.set(combiBAPAudioSource);
        this.sourceListReference = combiBAPAudioSource.getPosID();
        this.sendActiveSourceProperty();
        this.sendActiveSourceNameProperty();
    }

    private boolean isFunctionSyncNeeded(int n, int n2) {
        if (n2 == n) {
            this.logChannel.log(10000000, "[AbstractAppConnectorAudio#activateSource] function sync NOT needed");
            return false;
        }
        if (n2 == 0 || n2 == 255) {
            this.logChannel.log(10000000, "[AbstractAppConnectorAudio#activateSource] function sync NOT needed");
            return false;
        }
        if (!(n2 != 21 && n2 != 22 || n != 21 && n != 22)) {
            this.logChannel.log(10000000, "[AbstractAppConnectorAudio#activateSource] function sync NOT needed for BT Player");
            return false;
        }
        return true;
    }

    protected void sendSourceChangeRelatedProperties() {
        this.sendCurrentStationProperties();
        this.sendInfoStatesProperty();
        this.sendSourceStateProperty();
        this.sendPreferredListProperty();
        this.sendPlayPositionNotAvailable();
        if (this.getAudioApplicationInFocus() == 1) {
            this.sendOnlineMusicStateProperty();
        }
    }

    private void sendPlayPositionNotAvailable() {
        PlayPosition_Status playPosition_Status = new PlayPosition_Status();
        playPosition_Status.timePosition = 65535;
        playPosition_Status.totalPlayTime = 65535;
        this.moduleFsg.getBAPFunctionPropertyFSG(52).sendStatus(playPosition_Status);
    }

    private void sendOnlineMusicStateProperty() {
        this.moduleFsg.getBAPFunctionPropertyFSG(49).sendStatusIfChanged(this.onlineMusicStateStatus);
    }

    protected void doUpdateReceptionList(int n, CombiBAPReceptionListEntry[] combiBAPReceptionListEntryArray) {
        BAPFunctionArrayFSG bAPFunctionArrayFSG = this.moduleFsg.getBAPFunctionArrayFSG(23);
        ((ReceptionListHandler)bAPFunctionArrayFSG.getArrayHandler()).updateReceptionList(n, combiBAPReceptionListEntryArray);
    }

    protected void doUpdatePresetList(CombiBAPPresetListEntry[] combiBAPPresetListEntryArray) {
        BAPFunctionArrayFSG bAPFunctionArrayFSG = this.moduleFsg.getBAPFunctionArrayFSG(33);
        ((RadioTVPresetListHandler)bAPFunctionArrayFSG.getArrayHandler()).updateList(combiBAPPresetListEntryArray);
    }

    private void handleSourceChangeFunctionSync(int n, int n2) {
        int n3;
        this.logChannel.log(10000000, "[AbstractAppConnectorAudio#handleSourceChangeFunctionSync] oldSourceType=%1 -> newSourceType=%2", (long)n, (long)n2);
        int n4 = SourceListHandler.getApplicationForSourceType(n2);
        if (n2 == 9 || n2 == 32) {
            n3 = 2;
        } else if (n2 == 12) {
            n3 = 1;
        } else if (n == 19 && n2 == 15 && this.noListsAvailableForActiveSource()) {
            n3 = 8;
        } else if (n2 == 34) {
            n3 = 4;
            this.clearBrowserListIfNoListAvailable();
        } else if (n4 == 1) {
            n3 = 3;
            this.clearBrowserListIfNoListAvailable();
        } else {
            n3 = n4 == 3 ? 7 : 0;
        }
        this.moduleFsg.getFunctionSynchronizationHandler().startSync(n3);
    }

    private void clearBrowserListIfNoListAvailable() {
        if (!this.listStates.isMediaBrowserListAvailable()) {
            MediaBrowserListHandler mediaBrowserListHandler = (MediaBrowserListHandler)this.moduleFsg.getBAPFunctionArrayFSG(36).getArrayHandler();
            mediaBrowserListHandler.clearMediaBrowserList(false);
        }
    }

    private boolean noListsAvailableForActiveSource() {
        boolean bl = false;
        bl = !this.listStates.isMediaBrowserListAvailable() && !this.listStates.isPresetListAvailable() && !this.listStates.isReceptionListAvailable() && this.listStates.getListState() == 0;
        return bl;
    }

    private void sendActiveSourceProperty() {
        this.logChannel.log(10000000, "[AbstractAppConnectorAudio#sendActiveSourceProperty]");
        ActiveSource_Status activeSource_Status = AbstractAppConnectorAudio.activeSourceSerializerFrom(this.activeSource, this.listStates, this.sourceListReference);
        this.moduleFsg.getBAPFunctionPropertyFSG(16).sendStatus(activeSource_Status);
    }

    private static ActiveSource_Status activeSourceSerializerFrom(CombiBAPAudioSource combiBAPAudioSource, CombiBAPAudioListStates combiBAPAudioListStates, int n) {
        ActiveSource_Status activeSource_Status = new ActiveSource_Status();
        activeSource_Status.list_State = combiBAPAudioListStates.getListState();
        activeSource_Status.listAvailable.mediaBrowserListAvailable = combiBAPAudioListStates.isMediaBrowserListAvailable();
        activeSource_Status.listAvailable.presetListAvailable = combiBAPAudioListStates.isPresetListAvailable();
        activeSource_Status.listAvailable.receptionListAvailable = combiBAPAudioListStates.isReceptionListAvailable();
        activeSource_Status.number = combiBAPAudioSource.getNumber();
        activeSource_Status.sourceType = combiBAPAudioSource.getSourceType();
        activeSource_Status.typeOfNumber = combiBAPAudioSource.getTypeOfNumber();
        activeSource_Status.sourceList_Reference = n;
        return activeSource_Status;
    }

    private void sendActiveSourceNameProperty() {
        this.logChannel.log(10000000, "[AbstractAppConnectorAudio#sendActiveSourceNameProperty]");
        ActiveSourceName_Status activeSourceName_Status = new ActiveSourceName_Status();
        activeSourceName_Status.sourceName.setContent(this.activeSource.getName());
        this.moduleFsg.getBAPFunctionPropertyFSG(17).sendStatusIfChanged(activeSourceName_Status);
    }

    public void updateActiveSourceState(int n, int n2) {
        this.logChannel.log(1000000, "[AbstractAppConnectorAudio#updateActiveSourceState] called (stateInfo=%1, stateInfoScope=%2)", (long)n, (long)n2);
        SourceState_Status sourceState_Status = new SourceState_Status();
        sourceState_Status.stateInfo = n;
        sourceState_Status.stateInfo_Scope = n2;
        this.sourceStateStatus = sourceState_Status;
        if (this.isAudioApplicationInFocus()) {
            this.sendSourceStateProperty();
        } else {
            this.logNotActive("updateActiveSourceState");
        }
    }

    private void sendSourceStateProperty() {
        this.moduleFsg.getBAPFunctionPropertyFSG(20).sendStatusIfChanged(this.sourceStateStatus);
    }

    public void updateCurrentStation(CombiBAPCurrentStationInfo combiBAPCurrentStationInfo) {
        this.logChannel.log(1000000, "[AbstractAppConnectorAudio#updateCurrentStation] called (currentStationInfo=%1)", (Object)combiBAPCurrentStationInfo);
        CombiBAPCurrentStationInfo combiBAPCurrentStationInfo2 = combiBAPCurrentStationInfo != null ? combiBAPCurrentStationInfo : new CombiBAPCurrentStationInfo();
        this.updateCurrentStationInfo(combiBAPCurrentStationInfo2);
        this.updateCurrentStationHandle(combiBAPCurrentStationInfo2);
        if (this.isAudioApplicationInFocus()) {
            this.sendCurrentStationProperties();
        } else {
            this.logNotActive("updateCurrentStation");
        }
    }

    protected void updateStationArt(CombiBAPCurrentStationInfo combiBAPCurrentStationInfo) {
        if (this.isAudioApplicationInFocus()) {
            ActiveSource_Status activeSource_Status = (ActiveSource_Status)this.moduleFsg.getBAPFunctionPropertyFSG(16).getLastStatus();
            int n = activeSource_Status.sourceType;
            ((AbstractCombiModule)this.moduleFsg).getPictureManager().responseStationArt(combiBAPCurrentStationInfo.getListRef(), n, new ResourceLocator(combiBAPCurrentStationInfo.getPictureID(), combiBAPCurrentStationInfo.getPictureURL()), true);
        } else {
            this.logNotActive("updateStationArt");
        }
    }

    private void updateCurrentStationInfo(CombiBAPCurrentStationInfo combiBAPCurrentStationInfo) {
        String string = combiBAPCurrentStationInfo.getPrimaryInformation();
        int n = combiBAPCurrentStationInfo.getPrimaryInformationType();
        int n2 = combiBAPCurrentStationInfo.getPrimaryInformationID();
        String string2 = combiBAPCurrentStationInfo.getSecondaryInformation();
        int n3 = combiBAPCurrentStationInfo.getSecondaryInformationType();
        String string3 = combiBAPCurrentStationInfo.getTertiaryInformation();
        int n4 = combiBAPCurrentStationInfo.getTertiaryInformationType();
        String string4 = combiBAPCurrentStationInfo.getQuaternaryInformation();
        int n5 = combiBAPCurrentStationInfo.getQuaternaryInformationType();
        boolean bl = combiBAPCurrentStationInfo.hasAttribute(8);
        boolean bl2 = combiBAPCurrentStationInfo.hasAttribute(4);
        boolean bl3 = combiBAPCurrentStationInfo.hasAttribute(2);
        boolean bl4 = combiBAPCurrentStationInfo.hasAttribute(1);
        boolean bl5 = combiBAPCurrentStationInfo.hasAttribute(16);
        boolean bl6 = combiBAPCurrentStationInfo.hasAttribute(32);
        boolean bl7 = combiBAPCurrentStationInfo.hasAttribute(64);
        boolean bl8 = combiBAPCurrentStationInfo.hasAttribute(128);
        int n6 = combiBAPCurrentStationInfo.getChannelID();
        CurrentStationInfo_Status currentStationInfo_Status = new CurrentStationInfo_Status();
        currentStationInfo_Status.primaryInformation.setContent(string);
        currentStationInfo_Status.pi_Type = n;
        currentStationInfo_Status.pi_Id = n2;
        if (CombiCodingAccess.isReducedAudioInformation()) {
            currentStationInfo_Status.secondaryInformation.setContent("");
            currentStationInfo_Status.tertiaryInformation.setContent("");
            currentStationInfo_Status.quaternaryInformation.setContent("");
        } else {
            currentStationInfo_Status.secondaryInformation.setContent(string2);
            currentStationInfo_Status.si_Type = n3;
            currentStationInfo_Status.tertiaryInformation.setContent(string3);
            currentStationInfo_Status.ti_Type = n4;
            currentStationInfo_Status.quaternaryInformation.setContent(string4);
            currentStationInfo_Status.qi_Type = n5;
        }
        currentStationInfo_Status.stationInfoSwitches.taTpAvailable = bl;
        currentStationInfo_Status.stationInfoSwitches.tmcAvailable = bl2;
        currentStationInfo_Status.stationInfoSwitches.vicsAvailable = bl3;
        currentStationInfo_Status.stationInfoSwitches.ibocHdRadioAvailable = bl4;
        currentStationInfo_Status.stationProperties.dabServiceLinkedToFm = bl5;
        currentStationInfo_Status.stationProperties.ibocLiveTransmissionActive = bl6;
        currentStationInfo_Status.stationProperties.dabServiceDoesNotContainAnyAudioSignal = bl7;
        currentStationInfo_Status.stationProperties.stationLinkedToOnlineRadio = bl8;
        currentStationInfo_Status.channel_Id = n6;
        this.currentStationInfoStatus = currentStationInfo_Status;
    }

    protected void updateCurrentStationHandle(CombiBAPCurrentStationInfo combiBAPCurrentStationInfo) {
        CurrentStation_Handle_Status currentStation_Handle_Status = new CurrentStation_Handle_Status();
        currentStation_Handle_Status.fsgHandle = combiBAPCurrentStationInfo.getListRef();
        currentStation_Handle_Status.fsgHandle_absolutePosition = combiBAPCurrentStationInfo.getListAbsolutePosition();
        currentStation_Handle_Status.presetList_Ref = combiBAPCurrentStationInfo.getPresetListRef();
        currentStation_Handle_Status.presetList_absolutePosition = combiBAPCurrentStationInfo.getPresetListAbsolutePosition();
        currentStation_Handle_Status.dab_EnsembleHandle = 0;
        currentStation_Handle_Status.dab_Ensemble_absolutePosition = 0;
        this.currentStationHandleStatus = currentStation_Handle_Status;
        CurrentStation_Handle2_Status currentStation_Handle2_Status = new CurrentStation_Handle2_Status();
        currentStation_Handle2_Status.commonList_FsgHandle = combiBAPCurrentStationInfo.getCommonListRef();
        currentStation_Handle2_Status.commonList_FsgHandle_absolutePosition = combiBAPCurrentStationInfo.getCommonListAbsolutePosition();
        this.currentStationHandle2Status = currentStation_Handle2_Status;
    }

    private void sendCurrentStationProperties() {
        this.logChannel.log(1000000, "[AbstractAppConnectorAudio#sendCurrentStationProperties] called");
        BAPFunctionPropertyFSG bAPFunctionPropertyFSG = this.moduleFsg.getBAPFunctionPropertyFSG(21);
        CurrentStationInfo_Status currentStationInfo_Status = (CurrentStationInfo_Status)bAPFunctionPropertyFSG.getLastStatus();
        BAPFunctionPropertyFSG bAPFunctionPropertyFSG2 = this.moduleFsg.getBAPFunctionPropertyFSG(22);
        CurrentStation_Handle_Status currentStation_Handle_Status = (CurrentStation_Handle_Status)bAPFunctionPropertyFSG2.getLastStatus();
        BAPFunctionPropertyFSG bAPFunctionPropertyFSG3 = this.moduleFsg.getBAPFunctionPropertyFSG(51);
        boolean bl = !currentStationInfo_Status.equalTo(this.currentStationInfoStatus);
        boolean bl2 = !currentStation_Handle_Status.equalTo(this.currentStationHandleStatus);
        IFunctionSynchronizationHandler iFunctionSynchronizationHandler = this.moduleFsg.getFunctionSynchronizationHandler();
        if (bl && bl2) {
            if (!iFunctionSynchronizationHandler.isSyncPending() && !iFunctionSynchronizationHandler.isSyncActive()) {
                int n = this.getAudioApplication();
                switch (n) {
                    case 0: 
                    case 2: {
                        iFunctionSynchronizationHandler.startSync(5);
                        break;
                    }
                    case 1: 
                    case 3: {
                        iFunctionSynchronizationHandler.startSync(6);
                        break;
                    }
                    default: {
                        this.logChannel.log(10000, "[AbstractAppConnectorAudio#sendCurrentStationProperties] unknown audio app: %1", (long)n);
                        break;
                    }
                }
            }
        } else if (this.getAudioApplicationInFocus() == 0) {
            ((CombiModuleAudio)this.moduleFsg).getDedicatedAudioControlHandler().processLastResult();
        }
        bAPFunctionPropertyFSG.sendStatusIfChanged(this.currentStationInfoStatus);
        bAPFunctionPropertyFSG2.sendStatusIfChanged(this.currentStationHandleStatus);
        bAPFunctionPropertyFSG3.sendStatusIfChanged(this.currentStationHandle2Status);
        if (this.getAudioApplicationInFocus() == 1) {
            this.resendLastPlayPosition();
        }
    }

    private void resendLastPlayPosition() {
        this.moduleFsg.getBAPFunctionPropertyFSG(52).resendLastStatus();
    }

    public void updateActiveInfoState(int n) {
        this.logChannel.log(1000000, "[AbstractAppConnectorAudio#updateActiveInfoState] called (infoState=%1)", (long)n);
        if (AbstractAppConnectorAudio.isSpecialInfoState(this.infoStatesStatus.states)) {
            if (!AbstractAppConnectorAudio.isSpecialInfoState(n)) {
                this.logChannel.log(10000000, "[AbstractAppConnectorAudio#updateActiveInfoState] special value for InfoStates set (%1), don't set new value %2", (long)this.infoStatesStatus.states, (long)n);
                this.restorableInfoState = n;
                return;
            }
        } else {
            this.restorableInfoState = this.infoStatesStatus.states;
        }
        InfoStates_Status infoStates_Status = new InfoStates_Status();
        infoStates_Status.states = n;
        this.infoStatesStatus = infoStates_Status;
        this.boardBookVideoLogic.receivedInfoStateFromApp(n, this.getAudioApplication());
        boolean bl = this.boardBookVideoLogic.isThereAnInfoStateToSend(this.getAudioApplicationInFocus());
        if (bl) {
            this.infoStatesStatus.states = this.boardBookVideoLogic.getInfoStateToSend();
        }
        if (this.isAudioApplicationInFocus() || bl) {
            this.sendInfoStatesProperty();
        } else {
            this.logNotActive("updateActiveInfoState");
        }
    }

    private void sendInfoStatesProperty() {
        this.logChannel.log(10000000, "[AbstractAppConnectorAudio#sendInfoStatesProperty] called");
        BAPFunctionPropertyFSG bAPFunctionPropertyFSG = this.moduleFsg.getBAPFunctionPropertyFSG(30);
        InfoStates_Status infoStates_Status = (InfoStates_Status)bAPFunctionPropertyFSG.getLastStatus();
        int n = infoStates_Status.states;
        FunctionSynchronizationHandlerAudio functionSynchronizationHandlerAudio = (FunctionSynchronizationHandlerAudio)this.moduleFsg.getFunctionSynchronizationHandler();
        int n2 = functionSynchronizationHandlerAudio.getSyncState();
        if (functionSynchronizationHandlerAudio.isSyncTypeTrackOrStationChange() && !functionSynchronizationHandlerAudio.isSyncCancelled() && n2 != 4 && n2 != 0 && n == 9 && this.infoStatesStatus.states == 0) {
            this.logChannel.log(10000000, "[AbstractAppConnectorAudio#sendInfoStatesProperty] InfoStates changed from 'being loaded' to 'no error' - send after function sync");
            functionSynchronizationHandlerAudio.setInfoStatesPending(this.infoStatesStatus);
        } else if (functionSynchronizationHandlerAudio.getInfoStatesPending() != null) {
            this.logChannel.log(10000000, "[AbstractAppConnectorAudio#sendInfoStatesProperty] InfoStates pending - update with new value: %1", (long)this.infoStatesStatus.states);
            functionSynchronizationHandlerAudio.setInfoStatesPending(this.infoStatesStatus);
        } else {
            this.logChannel.log(10000000, "[AbstractAppConnectorAudio#sendInfoStatesProperty] old InfoStates=%1, new InfoStates=%2", (long)n, (long)this.infoStatesStatus.states);
            ((CombiModuleAudio)this.moduleFsg).statusREQInfoStates(this.infoStatesStatus);
        }
    }

    public void switchSourceResult(int n) {
        this.logChannel.log(1000000, "[AbstractAppConnectorAudio#switchSourceResult] called (result=%1)", (long)n);
        BAPFunctionMethodFSG bAPFunctionMethodFSG = this.moduleFsg.getBAPFunctionMethodFSG(34);
        SwitchSource_Result switchSource_Result = (SwitchSource_Result)this.moduleFsg.createResultSerializer(34);
        switchSource_Result.switchSourceResult = n;
        if (bAPFunctionMethodFSG.isResultWaiting()) {
            if (n == 0) {
                this.logChannel.log(1000000, "[AbstractAppConnectorAudio#switchSourceResult] result received; context change will follow -> send result after function synchronization is completed");
            } else {
                this.logChannel.log(1000000, "[AbstractAppConnectorAudio#switchSourceResult] context change failed");
                bAPFunctionMethodFSG.resultREQ(switchSource_Result);
            }
        } else if (!((FunctionSynchronizationHandlerAudio)this.moduleFsg.getFunctionSynchronizationHandler()).isSourceChangeInProgress()) {
            bAPFunctionMethodFSG.resultREQ(switchSource_Result);
        } else {
            this.logChannel.log(1000000, "[AbstractAppConnectorAudio#switchSourceResult] result received, sourceChange in progress -> send result after function synchronization is completed");
            bAPFunctionMethodFSG.setResultWaiting(n);
            if (n == 1) {
                this.moduleFsg.getFunctionSynchronizationHandler().completeSync();
            }
        }
    }

    public void selectListEntryResult(int n) {
        this.logChannel.log(1000000, "[AbstractAppConnectorAudio#selectListEntryResult] called (result=%1)", (long)n);
        ((CombiModuleAudio)this.moduleFsg).getDedicatedAudioControlHandler().processResult(0, n);
    }

    public void skipResult(boolean bl) {
        this.logChannel.log(1000000, "[AbstractAppConnectorAudio#skipResult] called (successful=%1)", bl);
        ((CombiModuleAudio)this.moduleFsg).getDedicatedAudioControlHandler().skipResult(bl);
    }

    public void updateSeekStatus(boolean bl) {
        this.logChannel.log(1000000, "[AbstractAppConnectorAudio#updateSeekStatus] called (seekRunning=%1)", bl);
        ((CombiModuleAudio)this.moduleFsg).getDedicatedAudioControlHandler().updateSeekStatus(bl);
    }

    public void updatePreferredList(int n) {
        this.logChannel.log(1000000, "[AbstractAppConnectorAudio#updatePreferredList] called (preferredList=%1)", (long)n);
        PreferredList_Status preferredList_Status = new PreferredList_Status();
        preferredList_Status.list = n;
        this.preferredListStatus = preferredList_Status;
        if (this.isAudioApplicationInFocus()) {
            this.sendPreferredListProperty();
        } else {
            this.logNotActive("updatePreferredList");
        }
    }

    private void sendPreferredListProperty() {
        this.moduleFsg.getBAPFunctionPropertyFSG(40).sendStatusIfChanged(this.preferredListStatus);
    }

    public void getNextListPosResult(int n, int n2, int n3, int n4) {
        this.logChannel.log(1000000, "[AbstractAppConnectorAudio#getNextListPosResult] called (result=%1, currentEntryID=%2,...)", (long)n, (long)n2);
        this.logChannel.log(1000000, "[AbstractAppConnectorAudio#getNextListPosResult] ..., nextEntryID=%1, absoluteListPos=%2", (long)n3, (long)n4);
        BAPFunctionMethodFSG bAPFunctionMethodFSG = this.moduleFsg.getBAPFunctionMethodFSG(44);
        GetNextListPos_Result getNextListPos_Result = (GetNextListPos_Result)this.moduleFsg.createResultSerializer(44);
        getNextListPos_Result.getNextListPos_Result = n;
        getNextListPos_Result.currentPos = n2;
        getNextListPos_Result.nextPos = n3;
        getNextListPos_Result.absoluteListPos = n4;
        bAPFunctionMethodFSG.resultREQ(getNextListPos_Result);
    }

    public void restoreInfoState(int n) {
        this.logChannel.log(1000000, "[AbstractAppConnectorAudio#restoreInfoState] infoStateToReset=%1, restorableInfoState=%2", (long)n, (long)this.restorableInfoState);
        if (AbstractAppConnectorAudio.isSpecialInfoState(n) && n == this.infoStatesStatus.states) {
            InfoStates_Status infoStates_Status = new InfoStates_Status();
            infoStates_Status.states = this.restorableInfoState == -1 ? 0 : this.restorableInfoState;
            this.infoStatesStatus = infoStates_Status;
            if (this.isAudioApplicationInFocus()) {
                this.sendInfoStatesProperty();
            }
        }
    }

    private static boolean isSpecialInfoState(int n) {
        return n == 26 || n == 30 || n == 31 || n == 32;
    }

    public void activateSourceResult(int n) {
        this.logChannel.log(1000000, "[AbstractAppConnectorAudio#activateSourceResult] result=%1", (long)n);
        if (n == 1) {
            BAPFunctionMethodFSG bAPFunctionMethodFSG = this.moduleFsg.getBAPFunctionMethodFSG(45);
            SwitchRadioMedia_Result switchRadioMedia_Result = (SwitchRadioMedia_Result)this.moduleFsg.createResultSerializer(45);
            switchRadioMedia_Result.switchRadioMediaResult = n;
            bAPFunctionMethodFSG.resultREQ(switchRadioMedia_Result);
        }
    }

    public void updateOnlineMusicState(int n, int n2) {
        this.logChannel.log(1000000, "[AbstractAppConnectorAudio#updateOnlineMusicState] state=%1, bufferLevel=%2", (long)n, (long)n2);
        this.onlineMusicStateStatus = new OnlineMusic_State_Status();
        this.onlineMusicStateStatus.state = n;
        this.onlineMusicStateStatus.bufferLevel = n2;
        this.moduleFsg.getBAPFunctionPropertyFSG(49).sendStatusIfChanged(this.onlineMusicStateStatus);
    }
}

