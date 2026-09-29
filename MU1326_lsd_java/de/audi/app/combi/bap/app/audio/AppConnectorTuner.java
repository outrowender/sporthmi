/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.app.audio;

import de.audi.app.bap.fw.functiontypes.BAPFunctionArrayFSG;
import de.audi.app.bap.fw.functiontypes.BAPFunctionMethodFSG;
import de.audi.app.bap.fw.functiontypes.BAPFunctionPropertyFSG;
import de.audi.app.combi.bap.app.audio.AbstractAppConnectorAudio;
import de.audi.app.combi.bap.app.audio.CombiBAPAudioListStates;
import de.audi.app.combi.bap.app.audio.CombiModuleAudio;
import de.audi.app.combi.bap.app.audio.list.CommonListHandler;
import de.audi.app.combi.bap.app.audio.list.ReceptionListHandler;
import de.audi.app.combi.bap.app.audio.list.SourceListHandler;
import de.audi.atip.interapp.bap.BAPServiceListener;
import de.audi.atip.interapp.combi.bap.audio.CombiBAPServiceTuner;
import de.audi.atip.interapp.combi.bap.audio.CombiBAPServiceTunerListener;
import de.audi.atip.interapp.combi.bap.audio.data.CombiBAPAudioSource;
import de.audi.atip.interapp.combi.bap.audio.data.CombiBAPCommonListEntry;
import de.audi.atip.interapp.combi.bap.audio.data.CombiBAPCurrentStationInfo;
import de.audi.atip.interapp.combi.bap.audio.data.CombiBAPPresetListEntry;
import de.audi.atip.interapp.combi.bap.audio.data.CombiBAPReceptionListEntry;
import de.audi.atip.interapp.combi.bap.audio.data.MuteState;
import de.esolutions.fw.util.commons.Buffer;
import de.vw.mib.bap.generated.audiosd.serializer.ASG_Capabilities_Status;
import de.vw.mib.bap.generated.audiosd.serializer.AnnouncementEscape_Result;
import de.vw.mib.bap.generated.audiosd.serializer.AnnouncementInfo_Status;
import de.vw.mib.bap.generated.audiosd.serializer.FSG_Setup_Status;
import de.vw.mib.bap.generated.audiosd.serializer.Mute_Status;
import de.vw.mib.bap.generated.audiosd.serializer.ReceptionListType_Status;

public class AppConnectorTuner
extends AbstractAppConnectorAudio
implements CombiBAPServiceTuner {
    private int currentReceptionListType;
    private CombiBAPReceptionListEntry[] currentReceptionList = new CombiBAPReceptionListEntry[0];
    private CombiBAPPresetListEntry[] currentRadioPresetList = new CombiBAPPresetListEntry[0];

    protected AppConnectorTuner(CombiModuleAudio combiModuleAudio) {
        super(combiModuleAudio);
    }

    @Override
    public void setAppServiceListener(BAPServiceListener bAPServiceListener) {
        super.setAppServiceListener(bAPServiceListener);
        if (bAPServiceListener == null && this.moduleFsg.getAppServiceListener("Media") == null) {
            this.moduleFsg.getInitializationManager().notifyAppServiceChanged(false);
        } else {
            this.moduleFsg.getInitializationManager().notifyAppServiceChanged(true);
            this.setASGCapabilities();
        }
    }

    private void setASGCapabilities() {
        BAPFunctionPropertyFSG bAPFunctionPropertyFSG = this.moduleFsg.getBAPFunctionPropertyFSG(43);
        if (bAPFunctionPropertyFSG.isDataValid()) {
            ASG_Capabilities_Status aSG_Capabilities_Status = (ASG_Capabilities_Status)bAPFunctionPropertyFSG.getLastStatus();
            ((CombiBAPServiceTunerListener)this.appServiceListener).setProgramStringLength(aSG_Capabilities_Status.presentationCapabilities.dabLongPs, aSG_Capabilities_Status.presentationCapabilities.sdarsLongPs);
        }
    }

    @Override
    protected int getAudioApplication() {
        return 0;
    }

    @Override
    protected String getAudioApplicationName() {
        return "Tuner";
    }

    @Override
    protected boolean isAudioApplicationInFocus() {
        return ((CombiModuleAudio)this.moduleFsg).getAudioApplicationFocusHandler().isTunerInFocus();
    }

    @Override
    protected void sendSourceChangeRelatedProperties() {
        super.sendSourceChangeRelatedProperties();
        BAPFunctionPropertyFSG bAPFunctionPropertyFSG = this.moduleFsg.getBAPFunctionPropertyFSG(31);
        bAPFunctionPropertyFSG.resendLastStatus();
        this.doUpdateReceptionList(this.currentReceptionListType, this.currentReceptionList);
        this.doUpdatePresetList(this.currentRadioPresetList);
    }

    @Override
    public void updateActiveSource(int n, int n2, int n3, boolean bl, boolean bl2, int n4) {
        CombiBAPAudioSource combiBAPAudioSource = new CombiBAPAudioSource();
        combiBAPAudioSource.setSourceType(n);
        combiBAPAudioSource.setSlotNumber(n2);
        combiBAPAudioSource.setPartitionNumber(n3);
        CombiBAPAudioListStates combiBAPAudioListStates = new CombiBAPAudioListStates();
        combiBAPAudioListStates.setReceptionListAvailable(bl);
        combiBAPAudioListStates.setPresetListAvailable(bl2);
        combiBAPAudioListStates.setListState(n4);
        this.updateActiveSource(combiBAPAudioSource, combiBAPAudioListStates);
    }

    @Override
    public void updateCurrentStation(CombiBAPCurrentStationInfo combiBAPCurrentStationInfo) {
        super.updateCurrentStation(combiBAPCurrentStationInfo);
        super.updateStationArt(combiBAPCurrentStationInfo);
    }

    @Override
    protected void updateCurrentStationHandle(CombiBAPCurrentStationInfo combiBAPCurrentStationInfo) {
        super.updateCurrentStationHandle(combiBAPCurrentStationInfo);
        ReceptionListHandler receptionListHandler = (ReceptionListHandler)this.moduleFsg.getBAPFunctionArrayFSG(23).getArrayHandler();
        CombiBAPReceptionListEntry combiBAPReceptionListEntry = (CombiBAPReceptionListEntry)receptionListHandler.getArrayElement(combiBAPCurrentStationInfo.getListRef());
        if (combiBAPReceptionListEntry != null) {
            this.logChannel.log(-2137614336, "[AppConnectorTuner#updateCurrentStationHandle] list entry=%1", (Object)combiBAPReceptionListEntry);
            this.currentStationHandleStatus.fsgHandle_absolutePosition = combiBAPReceptionListEntry.getAbsPos();
            BAPFunctionPropertyFSG bAPFunctionPropertyFSG = this.moduleFsg.getBAPFunctionPropertyFSG(31);
            ReceptionListType_Status receptionListType_Status = (ReceptionListType_Status)bAPFunctionPropertyFSG.getLastStatus();
            if (receptionListType_Status.type == 3 && combiBAPReceptionListEntry.getDABEnsembleID() > 0) {
                this.currentStationHandleStatus.dab_EnsembleHandle = combiBAPReceptionListEntry.getDABEnsembleID();
                this.currentStationHandleStatus.dab_Ensemble_absolutePosition = combiBAPReceptionListEntry.getDABEnsembleAbsPos();
            }
        } else {
            this.logChannel.log(-1601830656, "[AppConnectorTuner#updateCurrentStationHandle] list entry not found in reception list (posID=%1)", (long)combiBAPCurrentStationInfo.getListRef());
        }
    }

    @Override
    public void updateSourceListTuner(CombiBAPAudioSource[] combiBAPAudioSourceArray) {
        this.logChannel.log(1078071040, "[AppConnectorTuner#updateSourceListTuner] called (complete list)");
        BAPFunctionArrayFSG bAPFunctionArrayFSG = this.moduleFsg.getBAPFunctionArrayFSG(32);
        ((SourceListHandler)bAPFunctionArrayFSG.getArrayHandler()).updateSources(0, combiBAPAudioSourceArray);
    }

    @Override
    public void updateReceptionListAutoUpdateInformation(boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6) {
        Object object;
        if (this.logChannel.isDebug()) {
            object = new Buffer();
            ((Buffer)object).append("autoUpdateFMList=").append(bl);
            ((Buffer)object).append(", autoUpdateAMList=").append(bl2);
            ((Buffer)object).append(", autoUpdateDABList=").append(bl3);
            ((Buffer)object).append(", autoUpdateSDARSList=").append(bl4);
            ((Buffer)object).append(", autoUpdateAMLWList=").append(bl5);
            ((Buffer)object).append(", autoUpdateAMSWList=").append(bl6);
            this.logChannel.log(-2137614336, "[AppConnectorTuner#updateReceptionListAutoUpdateInformation] called (%1)", object);
        }
        object = this.moduleFsg.getBAPFunctionPropertyFSG(14);
        FSG_Setup_Status fSG_Setup_Status = (FSG_Setup_Status)((BAPFunctionPropertyFSG)object).getLastStatus();
        FSG_Setup_Status fSG_Setup_Status2 = new FSG_Setup_Status();
        fSG_Setup_Status2.maxVolume = fSG_Setup_Status.maxVolume;
        fSG_Setup_Status2.supportedVolumeTypes.readMessageVolumeAvailable = fSG_Setup_Status.supportedVolumeTypes.readMessageVolumeAvailable;
        fSG_Setup_Status2.supportedVolumeTypes.carParkingFaderAvailable = fSG_Setup_Status.supportedVolumeTypes.carParkingFaderAvailable;
        fSG_Setup_Status2.supportedVolumeTypes.phoneRingingVolumeAvailable = fSG_Setup_Status.supportedVolumeTypes.phoneRingingVolumeAvailable;
        fSG_Setup_Status2.supportedVolumeTypes.sdsVolumeAvailable = fSG_Setup_Status.supportedVolumeTypes.sdsVolumeAvailable;
        fSG_Setup_Status2.supportedVolumeTypes.phoneVolumeAvailable = fSG_Setup_Status.supportedVolumeTypes.phoneVolumeAvailable;
        fSG_Setup_Status2.supportedVolumeTypes.announcementVolumeAvailable = fSG_Setup_Status.supportedVolumeTypes.announcementVolumeAvailable;
        fSG_Setup_Status2.supportedVolumeTypes.navigationVolumeAvailable = fSG_Setup_Status.supportedVolumeTypes.navigationVolumeAvailable;
        fSG_Setup_Status2.supportedVolumeTypes.entertainmentVolumeAvaiblable = fSG_Setup_Status.supportedVolumeTypes.entertainmentVolumeAvaiblable;
        fSG_Setup_Status2.setup_Extensions.commonListIsAutomaticallyUpdated = fSG_Setup_Status.setup_Extensions.commonListIsAutomaticallyUpdated;
        fSG_Setup_Status2.setup_Extensions.dabServiceSortedList = fSG_Setup_Status.setup_Extensions.dabServiceSortedList;
        fSG_Setup_Status2.receptionList_AutoUpdate.tvDvbReceptionListIsAutomaticallyUpdated = fSG_Setup_Status.receptionList_AutoUpdate.tvDvbReceptionListIsAutomaticallyUpdated;
        fSG_Setup_Status2.receptionList_AutoUpdate.fmReceptionListIsAutomaticallyUpdated = bl;
        fSG_Setup_Status2.receptionList_AutoUpdate.amReceptionListIsAutomaticallyUpdated = bl2;
        fSG_Setup_Status2.receptionList_AutoUpdate.dabReceptionListIsAutomaticallyUpdated = bl3;
        fSG_Setup_Status2.receptionList_AutoUpdate.sdarsReceptionListIsAutomaticallyUpdated = bl4;
        fSG_Setup_Status2.receptionList_AutoUpdate.amLwReceptionListIsAutomaticallyUpdated = bl5;
        fSG_Setup_Status2.receptionList_AutoUpdate.amSwReceptionListIsAutomaticallyUpdated = bl6;
        fSG_Setup_Status2.setup_Extensions.commonListIsAutomaticallyUpdated = bl3;
        ((BAPFunctionPropertyFSG)object).sendStatusIfChanged(fSG_Setup_Status2);
    }

    @Override
    public void updateMuteState(MuteState muteState) {
        this.logChannel.log(1078071040, "[AppConnectorTuner#updateMuteState] muteState: %1", (Object)muteState);
        BAPFunctionPropertyFSG bAPFunctionPropertyFSG = this.moduleFsg.getBAPFunctionPropertyFSG(19);
        Mute_Status mute_Status = (Mute_Status)bAPFunctionPropertyFSG.getLastStatus();
        Mute_Status mute_Status2 = new Mute_Status();
        mute_Status2.muteState.dabMutingLowSignal = muteState.isDabMutingLowSignal();
        mute_Status2.muteState.sdarsMutingLowSignal = muteState.isSdarsMutingLowSignal();
        mute_Status2.muteState.ibocIsNotInSync = muteState.isIbocNotInSync();
        mute_Status2.muteState.ibocMutingLowSignal = muteState.isIbocMutingLowSignal();
        mute_Status2.muteState.dvbTvMutingLowSignal = mute_Status.muteState.dvbTvMutingLowSignal;
        mute_Status2.muteState.mutingDueToActivePhoneCall = mute_Status.muteState.mutingDueToActivePhoneCall;
        mute_Status2.muteState.muting = mute_Status.muteState.muting;
        bAPFunctionPropertyFSG.sendStatusIfChanged(mute_Status2);
    }

    @Override
    public void updateReceptionList(int n, CombiBAPReceptionListEntry[] combiBAPReceptionListEntryArray) {
        int n2;
        this.logChannel.log(1078071040, "[AppConnectorTuner#updateReceptionList] called (listType=%1, listSize=%2)", (long)n, (long)combiBAPReceptionListEntryArray.length);
        this.currentReceptionListType = n2 = n == 0 ? 1 : n;
        this.currentReceptionList = combiBAPReceptionListEntryArray;
        if (this.isAudioApplicationInFocus()) {
            this.doUpdateReceptionList(n2, combiBAPReceptionListEntryArray);
        }
    }

    @Override
    public void startStationListUpdateResult(int n) {
        this.logChannel.log(1078071040, "[AppConnectorTuner#startStationListUpdateResult] called (result=%1)", (long)n);
        if (this.isAudioApplicationInFocus()) {
            ((CombiModuleAudio)this.moduleFsg).getDedicatedAudioControlHandler().processResult(5, n);
        } else {
            this.logChannel.log(-2137614336, "[AppConnectorTuner#startStationListUpdateResult] %1 not active -> ignore update (active audio application is %2)", (Object)this.getAudioApplicationName(), (Object)((CombiModuleAudio)this.moduleFsg).getAudioApplicationFocusHandler().getAudioApplicationInFocusName());
        }
    }

    @Override
    public void cancelStationListUpdateResult(int n) {
        this.logChannel.log(1078071040, "[AppConnectorTuner#cancelStationListUpdateResult] called (result=%1)", (long)n);
        if (this.isAudioApplicationInFocus()) {
            ((CombiModuleAudio)this.moduleFsg).getDedicatedAudioControlHandler().processResult(6, n);
        } else {
            this.logChannel.log(-2137614336, "[AppConnectorTuner#cancelStationListUpdateResult] %1 not active -> ignore update (active audio application is %2)", (Object)this.getAudioApplicationName(), (Object)((CombiModuleAudio)this.moduleFsg).getAudioApplicationFocusHandler().getAudioApplicationInFocusName());
        }
    }

    @Override
    public void updateAnnouncementInfo(int n, String string) {
        this.logChannel.log(1078071040, "[AppConnectorTuner#updateAnnouncementInfo] called (stationName=%1, announcementType=%2)", (Object)string, (long)n);
        AnnouncementInfo_Status announcementInfo_Status = new AnnouncementInfo_Status();
        announcementInfo_Status.announcementType = n;
        announcementInfo_Status.stationName.setContent(string);
        this.moduleFsg.getBAPFunctionPropertyFSG(28).sendStatusIfChanged(announcementInfo_Status);
    }

    @Override
    public void cancelAnnouncementResult(int n) {
        this.logChannel.log(1078071040, "[AppConnectorTuner#cancelAnnouncementResult] called (result=%1)", (long)n);
        BAPFunctionMethodFSG bAPFunctionMethodFSG = this.moduleFsg.getBAPFunctionMethodFSG(29);
        AnnouncementEscape_Result announcementEscape_Result = (AnnouncementEscape_Result)this.moduleFsg.createResultSerializer(29);
        announcementEscape_Result.announcementEscapeResult = n;
        bAPFunctionMethodFSG.resultREQ(announcementEscape_Result);
    }

    @Override
    public void updatePresetList(CombiBAPPresetListEntry[] combiBAPPresetListEntryArray) {
        this.logChannel.log(1078071040, "[AppConnectorTuner#updatePresetList] called (listSize=%1)", (long)combiBAPPresetListEntryArray.length);
        this.currentRadioPresetList = combiBAPPresetListEntryArray;
        if (this.isAudioApplicationInFocus()) {
            this.doUpdatePresetList(combiBAPPresetListEntryArray);
        }
    }

    @Override
    public void updateProgramStringLength(boolean bl, boolean bl2) {
        this.logChannel.log(1078071040, "[AppConnectorTuner#updateProgramStringLength] called (dabLongPS=%1, sdarsLongPS=%2)", bl, bl2);
        BAPFunctionPropertyFSG bAPFunctionPropertyFSG = this.moduleFsg.getBAPFunctionPropertyFSG(43);
        ASG_Capabilities_Status aSG_Capabilities_Status = new ASG_Capabilities_Status();
        aSG_Capabilities_Status.presentationCapabilities.dabLongPs = bl;
        aSG_Capabilities_Status.presentationCapabilities.sdarsLongPs = bl2;
        bAPFunctionPropertyFSG.sendStatus(aSG_Capabilities_Status);
    }

    @Override
    public void updateCommonList(CombiBAPCommonListEntry[] combiBAPCommonListEntryArray) {
        this.logChannel.log(1078071040, "[AppConnectorTuner#updateCommonList] called (listSize=%1)", (long)combiBAPCommonListEntryArray.length);
        BAPFunctionArrayFSG bAPFunctionArrayFSG = this.moduleFsg.getBAPFunctionArrayFSG(50);
        ((CommonListHandler)bAPFunctionArrayFSG.getArrayHandler()).updateList(combiBAPCommonListEntryArray);
    }
}

