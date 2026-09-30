/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.app.audio;

import de.audi.app.bap.fw.functiontypes.BAPFunctionArrayFSG;
import de.audi.app.bap.fw.functiontypes.BAPFunctionPropertyFSG;
import de.audi.app.combi.bap.app.audio.AbstractAppConnectorAudio;
import de.audi.app.combi.bap.app.audio.CombiBAPAudioListStates;
import de.audi.app.combi.bap.app.audio.CombiModuleAudio;
import de.audi.app.combi.bap.app.audio.list.SourceListHandler;
import de.audi.atip.interapp.combi.bap.audio.CombiBAPServiceTV;
import de.audi.atip.interapp.combi.bap.audio.data.CombiBAPAudioSource;
import de.audi.atip.interapp.combi.bap.audio.data.CombiBAPCurrentStationInfo;
import de.audi.atip.interapp.combi.bap.audio.data.CombiBAPPresetListEntry;
import de.audi.atip.interapp.combi.bap.audio.data.CombiBAPReceptionListEntry;
import de.vw.mib.bap.generated.audiosd.serializer.FSG_Setup_Status;
import de.vw.mib.bap.generated.audiosd.serializer.Mute_Status;

public class AppConnectorTV
extends AbstractAppConnectorAudio
implements CombiBAPServiceTV {
    private CombiBAPReceptionListEntry[] currentTVStationList = new CombiBAPReceptionListEntry[0];
    private CombiBAPPresetListEntry[] currentTVPresetList = new CombiBAPPresetListEntry[0];

    protected AppConnectorTV(CombiModuleAudio combiModuleAudio) {
        super(combiModuleAudio);
    }

    protected int getAudioApplication() {
        return 2;
    }

    protected String getAudioApplicationName() {
        return "TV";
    }

    protected boolean isAudioApplicationInFocus() {
        return ((CombiModuleAudio)this.moduleFsg).getAudioApplicationFocusHandler().isTVInFocus();
    }

    protected void sendSourceChangeRelatedProperties() {
        super.sendSourceChangeRelatedProperties();
        BAPFunctionPropertyFSG bAPFunctionPropertyFSG = this.moduleFsg.getBAPFunctionPropertyFSG(31);
        bAPFunctionPropertyFSG.resendLastStatus();
        this.doUpdateReceptionList(6, this.currentTVStationList);
        this.doUpdatePresetList(this.currentTVPresetList);
    }

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

    public void updateCurrentStation(CombiBAPCurrentStationInfo combiBAPCurrentStationInfo) {
        super.updateCurrentStation(combiBAPCurrentStationInfo);
        super.updateStationArt(combiBAPCurrentStationInfo);
    }

    public void updateSourceListTv(CombiBAPAudioSource[] combiBAPAudioSourceArray) {
        this.logChannel.log(1000000, "[AppConnectorTV#updateSourceListTv] called (complete list)");
        BAPFunctionArrayFSG bAPFunctionArrayFSG = this.moduleFsg.getBAPFunctionArrayFSG(32);
        ((SourceListHandler)bAPFunctionArrayFSG.getArrayHandler()).updateSources(2, combiBAPAudioSourceArray);
    }

    public void updateStationListAutoUpdateInformation(boolean bl) {
        this.logChannel.log(1000000, "[AppConnectorTV#updateReceptionListAutoUpdateInformation] autoUpdateTVDVBLis=%1", bl);
        BAPFunctionPropertyFSG bAPFunctionPropertyFSG = this.moduleFsg.getBAPFunctionPropertyFSG(14);
        FSG_Setup_Status fSG_Setup_Status = (FSG_Setup_Status)bAPFunctionPropertyFSG.getLastStatus();
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
        fSG_Setup_Status2.receptionList_AutoUpdate.fmReceptionListIsAutomaticallyUpdated = fSG_Setup_Status.receptionList_AutoUpdate.fmReceptionListIsAutomaticallyUpdated;
        fSG_Setup_Status2.receptionList_AutoUpdate.amReceptionListIsAutomaticallyUpdated = fSG_Setup_Status.receptionList_AutoUpdate.amReceptionListIsAutomaticallyUpdated;
        fSG_Setup_Status2.receptionList_AutoUpdate.dabReceptionListIsAutomaticallyUpdated = fSG_Setup_Status.receptionList_AutoUpdate.dabReceptionListIsAutomaticallyUpdated;
        fSG_Setup_Status2.receptionList_AutoUpdate.sdarsReceptionListIsAutomaticallyUpdated = fSG_Setup_Status.receptionList_AutoUpdate.sdarsReceptionListIsAutomaticallyUpdated;
        fSG_Setup_Status2.receptionList_AutoUpdate.amLwReceptionListIsAutomaticallyUpdated = fSG_Setup_Status.receptionList_AutoUpdate.amLwReceptionListIsAutomaticallyUpdated;
        fSG_Setup_Status2.receptionList_AutoUpdate.amSwReceptionListIsAutomaticallyUpdated = fSG_Setup_Status.receptionList_AutoUpdate.amSwReceptionListIsAutomaticallyUpdated;
        fSG_Setup_Status2.receptionList_AutoUpdate.tvDvbReceptionListIsAutomaticallyUpdated = bl;
        bAPFunctionPropertyFSG.sendStatusIfChanged(fSG_Setup_Status2);
    }

    public void updateTVStationList(CombiBAPReceptionListEntry[] combiBAPReceptionListEntryArray) {
        this.logChannel.log(1000000, "[AppConnectorTV#updateTVStationList] called (listSize=%1)", (long)combiBAPReceptionListEntryArray.length);
        this.currentTVStationList = combiBAPReceptionListEntryArray;
        if (this.isAudioApplicationInFocus()) {
            this.doUpdateReceptionList(6, combiBAPReceptionListEntryArray);
        }
    }

    public void updateTVPresetList(CombiBAPPresetListEntry[] combiBAPPresetListEntryArray) {
        this.logChannel.log(1000000, "[AppConnectorTV#updatePresetList] called (listSize=%1)", (long)combiBAPPresetListEntryArray.length);
        this.currentTVPresetList = combiBAPPresetListEntryArray;
        if (this.isAudioApplicationInFocus()) {
            this.doUpdatePresetList(combiBAPPresetListEntryArray);
        }
    }

    public void updateMuteState(boolean bl) {
        this.logChannel.log(1000000, "[AppConnectorTV#updateMuteState] called (dvbMuting=%1)", bl);
        BAPFunctionPropertyFSG bAPFunctionPropertyFSG = this.moduleFsg.getBAPFunctionPropertyFSG(19);
        Mute_Status mute_Status = (Mute_Status)bAPFunctionPropertyFSG.getLastStatus();
        Mute_Status mute_Status2 = new Mute_Status();
        mute_Status2.muteState.dvbTvMutingLowSignal = bl;
        mute_Status2.muteState.onlineRadioMutingLowSignal = mute_Status.muteState.onlineRadioMutingLowSignal;
        mute_Status2.muteState.ibocMutingLowSignal = mute_Status.muteState.ibocMutingLowSignal;
        mute_Status2.muteState.mutingDueToActivePhoneCall = mute_Status.muteState.mutingDueToActivePhoneCall;
        mute_Status2.muteState.ibocIsNotInSync = mute_Status.muteState.ibocIsNotInSync;
        mute_Status2.muteState.sdarsMutingLowSignal = mute_Status.muteState.sdarsMutingLowSignal;
        mute_Status2.muteState.dabMutingLowSignal = mute_Status.muteState.dabMutingLowSignal;
        mute_Status2.muteState.muting = mute_Status.muteState.muting;
        bAPFunctionPropertyFSG.sendStatusIfChanged(mute_Status2);
    }
}

