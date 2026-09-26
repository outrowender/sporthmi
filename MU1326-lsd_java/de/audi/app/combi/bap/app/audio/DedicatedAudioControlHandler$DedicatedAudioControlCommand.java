/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.app.audio;

import de.audi.app.bap.fw.arrays.ArrayHandler;
import de.audi.app.bap.fw.functiontypes.BAPFunctionPropertyFSG;
import de.audi.app.combi.bap.app.audio.DedicatedAudioControlHandler;
import de.audi.atip.interapp.combi.bap.audio.CombiBAPServiceAudioListener;
import de.audi.atip.interapp.combi.bap.audio.CombiBAPServiceTunerListener;
import de.audi.atip.interapp.combi.bap.audio.data.CombiBAPPresetListEntry;
import de.vw.mib.bap.generated.audiosd.serializer.ActiveSource_Status;
import de.vw.mib.bap.generated.audiosd.serializer.CurrentStation_Handle_Status;
import de.vw.mib.bap.generated.audiosd.serializer.SourceState_Status;

class DedicatedAudioControlHandler$DedicatedAudioControlCommand {
    private int controlType;
    private final int additionalControlInformation;
    private final int listType;
    private final CombiBAPServiceAudioListener audioService;
    private static final String LOGGER_CLASS_NAME;
    private final /* synthetic */ DedicatedAudioControlHandler this$0;

    public DedicatedAudioControlHandler$DedicatedAudioControlCommand(DedicatedAudioControlHandler dedicatedAudioControlHandler, int n, int n2, int n3, CombiBAPServiceAudioListener combiBAPServiceAudioListener) {
        this.this$0 = dedicatedAudioControlHandler;
        this.controlType = n;
        this.additionalControlInformation = n2;
        this.listType = n3;
        this.audioService = combiBAPServiceAudioListener;
    }

    public int getControlType() {
        return this.controlType;
    }

    public void cancel(int n) {
        DedicatedAudioControlHandler.access$000(this.this$0).log(-2137614336, "[%1#process] cancel control with controlType %2", (Object)"DedicatedAudioControlHandler.DedicatedAudioControlCommand", (long)this.controlType);
        switch (this.controlType) {
            case 3: 
            case 4: {
                if (n == 7) break;
                this.cancelSeek();
                break;
            }
            case 5: {
                if (n == 6) break;
                this.cancelStationListUpdate();
                break;
            }
        }
    }

    public void abort() {
        DedicatedAudioControlHandler.access$000(this.this$0).log(-2137614336, "[%1#abort] abort control with controlType %2", (Object)"DedicatedAudioControlHandler.DedicatedAudioControlCommand", (long)this.controlType);
        switch (this.controlType) {
            case 3: 
            case 4: {
                this.cancelSeek();
                break;
            }
            case 5: {
                this.controlType = 6;
                if (this.cancelStationListUpdate()) break;
                DedicatedAudioControlHandler.access$100(this.this$0);
                break;
            }
            default: {
                DedicatedAudioControlHandler.access$100(this.this$0);
            }
        }
    }

    public void execute() {
        switch (this.controlType) {
            case 0: {
                this.selectListEntry();
                break;
            }
            case 1: {
                this.skip(this.additionalControlInformation == 0 ? 1 : this.additionalControlInformation);
                break;
            }
            case 2: {
                this.skip(this.additionalControlInformation == 0 ? -1 : -this.additionalControlInformation);
                break;
            }
            case 3: {
                DedicatedAudioControlHandler.access$000(this.this$0).log(-2137614336, "[%1#process] call 'startSeek(SEEK_FORWARD)' at active audio service", (Object)"DedicatedAudioControlHandler.DedicatedAudioControlCommand");
                this.audioService.startSeek(0);
                DedicatedAudioControlHandler.access$200(this.this$0).restart();
                break;
            }
            case 4: {
                DedicatedAudioControlHandler.access$000(this.this$0).log(-2137614336, "[%1#process] call 'startSeek(SEEK_BACKWARD)' at active audio service", (Object)"DedicatedAudioControlHandler.DedicatedAudioControlCommand");
                this.audioService.startSeek(1);
                DedicatedAudioControlHandler.access$200(this.this$0).restart();
                break;
            }
            case 7: {
                DedicatedAudioControlHandler.access$000(this.this$0).log(-2137614336, "[%1#process] call 'cancelSeek()' at active audio service", (Object)"DedicatedAudioControlHandler.DedicatedAudioControlCommand");
                this.cancelSeek();
                break;
            }
            case 5: {
                this.startStationListUpdate();
                break;
            }
            case 6: {
                if (this.cancelStationListUpdate()) break;
                DedicatedAudioControlHandler.access$300(this.this$0, false);
                break;
            }
            default: {
                DedicatedAudioControlHandler.access$000(this.this$0).log(10000, "[%1#process] invalid controlType: %2", (Object)"DedicatedAudioControlHandler.DedicatedAudioControlCommand", (long)this.controlType);
            }
        }
    }

    private void selectListEntry() {
        switch (this.listType) {
            case 1: {
                this.selectListEntryReceptionList();
                break;
            }
            case 2: {
                this.selectListEntryPresetList();
                break;
            }
            case 3: {
                this.selectListEntryMediaBrowser();
                break;
            }
            case 4: {
                DedicatedAudioControlHandler.access$000(this.this$0).log(10000, "[%1#selectListEntry] TPMemoList not supported yet", (Object)"DedicatedAudioControlHandler.DedicatedAudioControlCommand");
                DedicatedAudioControlHandler.access$300(this.this$0, false);
                break;
            }
            case 0: {
                DedicatedAudioControlHandler.access$300(this.this$0, false);
                break;
            }
            default: {
                DedicatedAudioControlHandler.access$300(this.this$0, true);
            }
        }
    }

    private void selectListEntryReceptionList() {
        if (DedicatedAudioControlHandler.access$400(this.this$0).getAudioApplicationFocusHandler().isTunerInFocus() || DedicatedAudioControlHandler.access$400(this.this$0).getAudioApplicationFocusHandler().isTVInFocus()) {
            CurrentStation_Handle_Status currentStation_Handle_Status = (CurrentStation_Handle_Status)DedicatedAudioControlHandler.access$400(this.this$0).getBAPFunctionPropertyFSG(22).getLastStatus();
            SourceState_Status sourceState_Status = (SourceState_Status)DedicatedAudioControlHandler.access$400(this.this$0).getBAPFunctionPropertyFSG(20).getLastStatus();
            if (currentStation_Handle_Status.fsgHandle != this.additionalControlInformation || sourceState_Status.stateInfo == 6) {
                if (DedicatedAudioControlHandler.access$400(this.this$0).getAudioApplicationFocusHandler().isTunerInFocus()) {
                    DedicatedAudioControlHandler.access$000(this.this$0).log(-2137614336, "[%1#selectListEntryReceptionList] calling tuner service 'selectListEntry(%2)'", (Object)"DedicatedAudioControlHandler.DedicatedAudioControlCommand", (long)this.additionalControlInformation);
                    DedicatedAudioControlHandler.access$400(this.this$0).getTunerServiceListener().selectListEntry(this.additionalControlInformation);
                } else if (DedicatedAudioControlHandler.access$400(this.this$0).getAudioApplicationFocusHandler().isTVInFocus()) {
                    DedicatedAudioControlHandler.access$000(this.this$0).log(-2137614336, "[%1#selectListEntryReceptionList] calling TV service 'selectListEntry(%2)'", (Object)"DedicatedAudioControlHandler.DedicatedAudioControlCommand", (long)this.additionalControlInformation);
                    DedicatedAudioControlHandler.access$400(this.this$0).getTVServiceListener().selectListEntry(this.additionalControlInformation);
                }
            } else {
                DedicatedAudioControlHandler.access$000(this.this$0).log(-2137614336, "[%1#selectListEntryReceptionList] entry with id=%2 is already active", (Object)"DedicatedAudioControlHandler.DedicatedAudioControlCommand", (long)this.additionalControlInformation);
                DedicatedAudioControlHandler.access$500(this.this$0, 0);
            }
        } else {
            DedicatedAudioControlHandler.access$000(this.this$0).log(-2137614336, "[%1#selectListEntryReceptionList] tuner not active", (Object)"DedicatedAudioControlHandler.DedicatedAudioControlCommand");
            DedicatedAudioControlHandler.access$500(this.this$0, 1);
        }
    }

    private void selectListEntryPresetList() {
        CurrentStation_Handle_Status currentStation_Handle_Status = (CurrentStation_Handle_Status)DedicatedAudioControlHandler.access$400(this.this$0).getBAPFunctionPropertyFSG(22).getLastStatus();
        SourceState_Status sourceState_Status = (SourceState_Status)DedicatedAudioControlHandler.access$400(this.this$0).getBAPFunctionPropertyFSG(20).getLastStatus();
        if (currentStation_Handle_Status.presetList_Ref != this.additionalControlInformation || sourceState_Status.stateInfo == 6) {
            ArrayHandler arrayHandler = DedicatedAudioControlHandler.access$400(this.this$0).getBAPFunctionArrayFSG(33).getArrayHandler();
            CombiBAPPresetListEntry combiBAPPresetListEntry = (CombiBAPPresetListEntry)arrayHandler.getArrayElement(this.additionalControlInformation);
            if (combiBAPPresetListEntry == null) {
                DedicatedAudioControlHandler.access$000(this.this$0).log(-1601830656, "[$#1#selectListEntryPresetList] element with id=%2 not found in preset list", (Object)"DedicatedAudioControlHandler.DedicatedAudioControlCommand", (long)this.additionalControlInformation);
                DedicatedAudioControlHandler.access$500(this.this$0, 1);
            } else if (combiBAPPresetListEntry.getWaveband() == 9 || combiBAPPresetListEntry.getWaveband() == 8) {
                DedicatedAudioControlHandler.access$000(this.this$0).log(-2137614336, "[%1#selectListEntryPresetList] calling 'selectListEntryPresetList(%2)' at media service", (Object)"DedicatedAudioControlHandler.DedicatedAudioControlCommand", (long)this.additionalControlInformation);
                DedicatedAudioControlHandler.access$400(this.this$0).getTVServiceListener().selectListEntryPresetList(this.additionalControlInformation);
            } else if (DedicatedAudioControlHandler.access$400(this.this$0).getAudioApplicationFocusHandler().isTunerInFocus()) {
                DedicatedAudioControlHandler.access$000(this.this$0).log(-2137614336, "[%1#selectListEntryPresetList] calling 'selectListEntryPresetList(%2)' at tuner service", (Object)"DedicatedAudioControlHandler.DedicatedAudioControlCommand", (long)this.additionalControlInformation);
                DedicatedAudioControlHandler.access$000(this.this$0).log(-2137614336, "[%1#selectListEntryPresetList] set result waiting successful", (Object)"DedicatedAudioControlHandler.DedicatedAudioControlCommand", (long)this.additionalControlInformation);
                DedicatedAudioControlHandler.access$600(this.this$0).setResultWaiting(0);
                DedicatedAudioControlHandler.access$400(this.this$0).getTunerServiceListener().selectListEntryPresetList(this.additionalControlInformation);
            } else {
                DedicatedAudioControlHandler.access$000(this.this$0).log(-2137614336, "[%1#selectListEntryPresetList] tuner not active", (Object)"DedicatedAudioControlHandler.DedicatedAudioControlCommand");
                DedicatedAudioControlHandler.access$500(this.this$0, 1);
            }
        } else {
            DedicatedAudioControlHandler.access$000(this.this$0).log(-2137614336, "[%1#selectListEntryPresetList] entry with id=%2 is already active", (Object)"DedicatedAudioControlHandler.DedicatedAudioControlCommand", (long)this.additionalControlInformation);
            DedicatedAudioControlHandler.access$500(this.this$0, 0);
        }
    }

    private void selectListEntryMediaBrowser() {
        if (DedicatedAudioControlHandler.access$400(this.this$0).getAudioApplicationFocusHandler().isMediaInFocus()) {
            CurrentStation_Handle_Status currentStation_Handle_Status = (CurrentStation_Handle_Status)DedicatedAudioControlHandler.access$400(this.this$0).getBAPFunctionPropertyFSG(22).getLastStatus();
            if (currentStation_Handle_Status.fsgHandle != this.additionalControlInformation) {
                DedicatedAudioControlHandler.access$000(this.this$0).log(-2137614336, "[%1#selectListEntryMediaBrowser] calling media service 'selectListEntry(%1)'", (Object)"DedicatedAudioControlHandler.DedicatedAudioControlCommand", (long)this.additionalControlInformation);
                DedicatedAudioControlHandler.access$400(this.this$0).getMediaServiceListener().selectListEntry(this.additionalControlInformation);
            } else {
                DedicatedAudioControlHandler.access$000(this.this$0).log(-2137614336, "[%1#selectListEntryMediaBrowser] entry with id=%2 is already active", (Object)"DedicatedAudioControlHandler.DedicatedAudioControlCommand", (long)this.additionalControlInformation);
                DedicatedAudioControlHandler.access$500(this.this$0, 0);
            }
        } else {
            DedicatedAudioControlHandler.access$000(this.this$0).log(-2137614336, "[%1#selectListEntryMediaBrowser] media not active", (Object)"DedicatedAudioControlHandler.DedicatedAudioControlCommand");
            DedicatedAudioControlHandler.access$500(this.this$0, 1);
        }
    }

    private void skip(int n) {
        BAPFunctionPropertyFSG bAPFunctionPropertyFSG = DedicatedAudioControlHandler.access$400(this.this$0).getBAPFunctionPropertyFSG(16);
        if (((ActiveSource_Status)bAPFunctionPropertyFSG.getLastStatus()).sourceType == 12) {
            DedicatedAudioControlHandler.access$000(this.this$0).log(-2137614336, "[%1#process] call 'skip(%2)' at CombiBAPServiceInfoListener", (Object)"DedicatedAudioControlHandler.DedicatedAudioControlCommand", (long)n);
            DedicatedAudioControlHandler.access$400(this.this$0).getInfoServiceListener().skip(n);
        } else {
            DedicatedAudioControlHandler.access$000(this.this$0).log(-2137614336, "[%1#process] call 'skip(%2)' at active audio service", (Object)"DedicatedAudioControlHandler.DedicatedAudioControlCommand", (long)n);
            this.audioService.skip(n);
        }
    }

    private void cancelSeek() {
        DedicatedAudioControlHandler.access$000(this.this$0).log(-2137614336, "[%1#cancelSeek] call 'cancel seek' at active audio service", (Object)"DedicatedAudioControlHandler.DedicatedAudioControlCommand");
        this.audioService.cancelSeek();
    }

    private void startStationListUpdate() {
        if (this.audioService instanceof CombiBAPServiceTunerListener) {
            DedicatedAudioControlHandler.access$000(this.this$0).log(-2137614336, "[%1#startStationListUpdate] call 'startStationListUpdate' at TunerService", (Object)"DedicatedAudioControlHandler.DedicatedAudioControlCommand");
            ((CombiBAPServiceTunerListener)this.audioService).startStationListUpdate();
        } else {
            DedicatedAudioControlHandler.access$000(this.this$0).log(-1601830656, "[%1#startStationListUpdate] station list update only applicable for tuner", (Object)"DedicatedAudioControlHandler.DedicatedAudioControlCommand");
            DedicatedAudioControlHandler.access$300(this.this$0, false);
        }
    }

    private boolean cancelStationListUpdate() {
        if (this.audioService instanceof CombiBAPServiceTunerListener) {
            DedicatedAudioControlHandler.access$000(this.this$0).log(-2137614336, "[%1#cancelStationListUpdate] call 'cancelStationListUpdate' at TunerService", (Object)"DedicatedAudioControlHandler.DedicatedAudioControlCommand");
            ((CombiBAPServiceTunerListener)this.audioService).cancelStationListUpdate();
            return true;
        }
        DedicatedAudioControlHandler.access$000(this.this$0).log(-1601830656, "[%1#cancelStationListUpdate] cancel station list update only applicable for tuner", (Object)"DedicatedAudioControlHandler.DedicatedAudioControlCommand");
        return false;
    }
}

