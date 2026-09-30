/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.app.audio;

import de.audi.app.bap.fw.functiontypes.BAPFunctionPropertyFSG;
import de.audi.app.combi.bap.AbstractCombiConnector;
import de.audi.app.combi.bap.app.audio.CombiModuleAudio;
import de.audi.atip.interapp.combi.bap.audio.CombiBAPServiceTone;
import de.esolutions.fw.util.commons.Buffer;
import de.vw.mib.bap.generated.audiosd.serializer.CurrentVolumeExtended_Status;
import de.vw.mib.bap.generated.audiosd.serializer.FSG_Setup_Status;
import de.vw.mib.bap.generated.audiosd.serializer.Mute_Status;

public class AppConnectorTone
extends AbstractCombiConnector
implements CombiBAPServiceTone {
    protected AppConnectorTone(CombiModuleAudio combiModuleAudio) {
        super(combiModuleAudio);
    }

    public void updateMuteState(boolean bl, boolean bl2) {
        this.logChannel.log(1000000, "[AppConnectorTone#updateMuteState] called (muted=%1, mutedDueToActivePhoneCall=%2)", bl, bl2);
        BAPFunctionPropertyFSG bAPFunctionPropertyFSG = this.moduleFsg.getBAPFunctionPropertyFSG(19);
        Mute_Status mute_Status = (Mute_Status)bAPFunctionPropertyFSG.getLastStatus();
        Mute_Status mute_Status2 = new Mute_Status();
        mute_Status2.muteState.muting = bl;
        mute_Status2.muteState.mutingDueToActivePhoneCall = bl2;
        mute_Status2.muteState.onlineRadioMutingLowSignal = mute_Status.muteState.onlineRadioMutingLowSignal;
        mute_Status2.muteState.ibocMutingLowSignal = mute_Status.muteState.ibocMutingLowSignal;
        mute_Status2.muteState.ibocIsNotInSync = mute_Status.muteState.ibocIsNotInSync;
        mute_Status2.muteState.sdarsMutingLowSignal = mute_Status.muteState.sdarsMutingLowSignal;
        mute_Status2.muteState.dvbTvMutingLowSignal = mute_Status.muteState.dvbTvMutingLowSignal;
        mute_Status2.muteState.dabMutingLowSignal = mute_Status.muteState.dabMutingLowSignal;
        bAPFunctionPropertyFSG.sendStatusIfChanged(mute_Status2);
    }

    public void updateVolumeProperties(byte by, boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6, boolean bl7, boolean bl8) {
        Object object;
        if (this.logChannel.isDebug()) {
            object = new Buffer();
            ((Buffer)object).append("maxVolume=").append(by);
            ((Buffer)object).append(", entertainmentVolumeAvailable=").append(bl);
            ((Buffer)object).append(", navigationVolumeAvailable=").append(bl2);
            ((Buffer)object).append(", announcementVolumeAvailable=").append(bl3);
            ((Buffer)object).append(", phoneVolumeAvailable=").append(bl4);
            ((Buffer)object).append(", sdsVolumeAvailable=").append(bl5);
            ((Buffer)object).append(", phoneRingingVolumeAvailable=").append(bl6);
            ((Buffer)object).append(", carParkingFaderAvailable=").append(bl7);
            ((Buffer)object).append(", readMessageVolumeAvailable=").append(bl8);
            this.logChannel.log(10000000, "[AppConnectorTone#updateVolumeProperties] called (%1)", object);
        }
        object = this.moduleFsg.getBAPFunctionPropertyFSG(14);
        FSG_Setup_Status fSG_Setup_Status = (FSG_Setup_Status)((BAPFunctionPropertyFSG)object).getLastStatus();
        FSG_Setup_Status fSG_Setup_Status2 = new FSG_Setup_Status();
        fSG_Setup_Status2.maxVolume = by;
        fSG_Setup_Status2.supportedVolumeTypes.entertainmentVolumeAvaiblable = bl;
        fSG_Setup_Status2.supportedVolumeTypes.navigationVolumeAvailable = bl2;
        fSG_Setup_Status2.supportedVolumeTypes.announcementVolumeAvailable = bl3;
        fSG_Setup_Status2.supportedVolumeTypes.phoneVolumeAvailable = bl4;
        fSG_Setup_Status2.supportedVolumeTypes.sdsVolumeAvailable = bl5;
        fSG_Setup_Status2.supportedVolumeTypes.phoneRingingVolumeAvailable = bl6;
        fSG_Setup_Status2.supportedVolumeTypes.carParkingFaderAvailable = bl7;
        fSG_Setup_Status2.supportedVolumeTypes.readMessageVolumeAvailable = bl8;
        fSG_Setup_Status2.receptionList_AutoUpdate.onlineRadioReceptionListIsAutomaticallyUpdated = fSG_Setup_Status.receptionList_AutoUpdate.onlineRadioReceptionListIsAutomaticallyUpdated;
        fSG_Setup_Status2.receptionList_AutoUpdate.tvDvbReceptionListIsAutomaticallyUpdated = fSG_Setup_Status.receptionList_AutoUpdate.tvDvbReceptionListIsAutomaticallyUpdated;
        fSG_Setup_Status2.receptionList_AutoUpdate.amSwReceptionListIsAutomaticallyUpdated = fSG_Setup_Status.receptionList_AutoUpdate.amSwReceptionListIsAutomaticallyUpdated;
        fSG_Setup_Status2.receptionList_AutoUpdate.amLwReceptionListIsAutomaticallyUpdated = fSG_Setup_Status.receptionList_AutoUpdate.amLwReceptionListIsAutomaticallyUpdated;
        fSG_Setup_Status2.receptionList_AutoUpdate.sdarsReceptionListIsAutomaticallyUpdated = fSG_Setup_Status.receptionList_AutoUpdate.sdarsReceptionListIsAutomaticallyUpdated;
        fSG_Setup_Status2.receptionList_AutoUpdate.dabReceptionListIsAutomaticallyUpdated = fSG_Setup_Status.receptionList_AutoUpdate.dabReceptionListIsAutomaticallyUpdated;
        fSG_Setup_Status2.receptionList_AutoUpdate.amReceptionListIsAutomaticallyUpdated = fSG_Setup_Status.receptionList_AutoUpdate.amReceptionListIsAutomaticallyUpdated;
        fSG_Setup_Status2.receptionList_AutoUpdate.fmReceptionListIsAutomaticallyUpdated = fSG_Setup_Status.receptionList_AutoUpdate.fmReceptionListIsAutomaticallyUpdated;
        fSG_Setup_Status2.setup_Extensions.commonListIsAutomaticallyUpdated = fSG_Setup_Status.setup_Extensions.commonListIsAutomaticallyUpdated;
        fSG_Setup_Status2.setup_Extensions.dabServiceSortedList = fSG_Setup_Status.setup_Extensions.dabServiceSortedList;
        ((BAPFunctionPropertyFSG)object).sendStatusIfChanged(fSG_Setup_Status2);
    }

    public void updateVolume(int n, int n2, int n3, boolean bl) {
        this.updateVolume(n, n2, n3, bl, false);
    }

    public void updateVolume(int n, int n2, int n3, boolean bl, boolean bl2) {
        this.logChannel.log(1000000, "[AppConnectorTone#updateVolume] called (currentVolume=%1, maxVolume=%2, volumeType=%3, ...", (long)n, (long)n2, (long)n3);
        this.logChannel.log(1000000, "[AppConnectorTone#updateVolume] ..., showVolumePopup=%1, volumeLockActive=%2)", bl, bl2);
        CurrentVolumeExtended_Status currentVolumeExtended_Status = new CurrentVolumeExtended_Status();
        currentVolumeExtended_Status.genericVolume = n;
        currentVolumeExtended_Status.maxVolume = n2;
        currentVolumeExtended_Status.changingVolumeType = bl ? n3 : 0;
        currentVolumeExtended_Status.volumeState.volumeIsNotLocked = !bl2;
        this.moduleFsg.getBAPFunctionPropertyFSG(47).sendStatusIfChanged(currentVolumeExtended_Status);
    }
}

