/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.app.audio;

import de.audi.app.bap.fw.arrays.ArrayHandler;
import de.audi.app.bap.fw.arrays.ArrayHeaderBAP;
import de.audi.app.bap.fw.arrays.GetArrayIndication;
import de.audi.app.bap.fw.functiontypes.AbstractBAPFunction;
import de.audi.app.bap.fw.functiontypes.BAPFunctionArrayFSG;
import de.audi.app.bap.fw.functiontypes.BAPFunctionMethodFSG;
import de.audi.app.bap.fw.functiontypes.BAPFunctionPropertyFSG;
import de.audi.app.bap.generated.audio.AbstractBAPIndicationHandlerAudio;
import de.audi.app.bap.utils.FunctionIDs;
import de.audi.app.combi.bap.app.audio.AudioApplicationInFocusHandler;
import de.audi.app.combi.bap.app.audio.CombiModuleAudio;
import de.audi.app.combi.bap.app.audio.list.MediaBrowserListHandler;
import de.audi.app.combi.bap.app.audio.list.SourceListHandler;
import de.audi.app.combi.bap.fw.arrays.GetArrayIndicationReceptionList;
import de.audi.atip.interapp.combi.bap.audio.CombiBAPServiceAudio;
import de.audi.atip.interapp.combi.bap.audio.CombiBAPServiceAudioListener;
import de.audi.atip.interapp.combi.bap.audio.CombiBAPServiceMediaListener;
import de.audi.atip.interapp.combi.bap.audio.CombiBAPServiceTVListener;
import de.audi.atip.interapp.combi.bap.audio.CombiBAPServiceTerminalModeListener;
import de.audi.atip.interapp.combi.bap.audio.CombiBAPServiceToneListener;
import de.audi.atip.interapp.combi.bap.audio.CombiBAPServiceTunerListener;
import de.audi.atip.interapp.combi.bap.audio.data.CombiBAPAudioSource;
import de.vw.mib.bap.generated.audiosd.serializer.ASG_Capabilities_SetGet;
import de.vw.mib.bap.generated.audiosd.serializer.AnnouncementEscape_Result;
import de.vw.mib.bap.generated.audiosd.serializer.CommonList_GetArray;
import de.vw.mib.bap.generated.audiosd.serializer.CurrentVolumeExtended_SetGet;
import de.vw.mib.bap.generated.audiosd.serializer.DedicatedAudioControl_StartResult;
import de.vw.mib.bap.generated.audiosd.serializer.GeneralInfoSwitches_SetGet;
import de.vw.mib.bap.generated.audiosd.serializer.GetNextListPos_Result;
import de.vw.mib.bap.generated.audiosd.serializer.GetNextListPos_StartResult;
import de.vw.mib.bap.generated.audiosd.serializer.MediaBrowserControl_Result;
import de.vw.mib.bap.generated.audiosd.serializer.MediaBrowserControl_StartResult;
import de.vw.mib.bap.generated.audiosd.serializer.MediaBrowser_GetArray;
import de.vw.mib.bap.generated.audiosd.serializer.MediaFileInfo_Result;
import de.vw.mib.bap.generated.audiosd.serializer.MediaFileInfo_StartResult;
import de.vw.mib.bap.generated.audiosd.serializer.Mute_SetGet;
import de.vw.mib.bap.generated.audiosd.serializer.Mute_Status;
import de.vw.mib.bap.generated.audiosd.serializer.PreferredList_SetGet;
import de.vw.mib.bap.generated.audiosd.serializer.PreferredList_Status;
import de.vw.mib.bap.generated.audiosd.serializer.RadioTV_PresetList_GetArray;
import de.vw.mib.bap.generated.audiosd.serializer.ReceptionList_GetArray;
import de.vw.mib.bap.generated.audiosd.serializer.SDS_State_SetGet;
import de.vw.mib.bap.generated.audiosd.serializer.SDS_State_Status;
import de.vw.mib.bap.generated.audiosd.serializer.SourceList_GetArray;
import de.vw.mib.bap.generated.audiosd.serializer.SourceState_SetGet;
import de.vw.mib.bap.generated.audiosd.serializer.SourceState_Status;
import de.vw.mib.bap.generated.audiosd.serializer.SwitchRadioMedia_Result;
import de.vw.mib.bap.generated.audiosd.serializer.SwitchRadioMedia_StartResult;
import de.vw.mib.bap.generated.audiosd.serializer.SwitchSource_Result;
import de.vw.mib.bap.generated.audiosd.serializer.SwitchSource_StartResult;
import de.vw.mib.bap.generated.audiosd.serializer.TpMemoList_GetArray;
import de.vw.mib.bap.requests.GetArray;
import de.vw.mib.bap.requests.ResultMethod;

public class BAPIndicationHandlerAudio
extends AbstractBAPIndicationHandlerAudio {
    private static final int SOURCE_UNKNOWN = -1;

    protected BAPIndicationHandlerAudio(CombiModuleAudio combiModuleAudio) {
        super(combiModuleAudio, combiModuleAudio.getLogChannel());
    }

    public CombiBAPServiceTunerListener getTunerServiceListener() {
        return this.module().getTunerServiceListener();
    }

    public CombiBAPServiceMediaListener getMediaServiceListener() {
        return this.module().getMediaServiceListener();
    }

    public CombiBAPServiceTVListener getTVServiceListener() {
        return this.module().getTVServiceListener();
    }

    public CombiBAPServiceTerminalModeListener getTerminalModeServiceListener() {
        return this.module().getTerminalModeServiceListener();
    }

    public GetArrayIndication evaluateGetArrayIndication(int n, GetArray getArray) {
        GetArrayIndication getArrayIndication = null;
        switch (n) {
            case 23: {
                ReceptionList_GetArray receptionList_GetArray = (ReceptionList_GetArray)getArray;
                BAPFunctionArrayFSG bAPFunctionArrayFSG = this.module().getBAPFunctionArrayFSG(n);
                getArrayIndication = new GetArrayIndicationReceptionList(bAPFunctionArrayFSG, receptionList_GetArray.asg_Id, receptionList_GetArray.taid, new ArrayHeaderBAP(receptionList_GetArray.getArrayHeader()), receptionList_GetArray.elementType, receptionList_GetArray.parent_Id);
                break;
            }
            case 27: {
                TpMemoList_GetArray tpMemoList_GetArray = (TpMemoList_GetArray)getArray;
                getArrayIndication = new GetArrayIndication(tpMemoList_GetArray.asg_Id, tpMemoList_GetArray.taid, new ArrayHeaderBAP(tpMemoList_GetArray.getArrayHeader()));
                break;
            }
            case 32: {
                SourceList_GetArray sourceList_GetArray = (SourceList_GetArray)getArray;
                getArrayIndication = new GetArrayIndication(sourceList_GetArray.asg_Id, sourceList_GetArray.taid, new ArrayHeaderBAP(sourceList_GetArray.getArrayHeader()));
                break;
            }
            case 33: {
                RadioTV_PresetList_GetArray radioTV_PresetList_GetArray = (RadioTV_PresetList_GetArray)getArray;
                getArrayIndication = new GetArrayIndication(radioTV_PresetList_GetArray.asg_Id, radioTV_PresetList_GetArray.taid, new ArrayHeaderBAP(radioTV_PresetList_GetArray.getArrayHeader()));
                break;
            }
            case 36: {
                MediaBrowser_GetArray mediaBrowser_GetArray = (MediaBrowser_GetArray)getArray;
                getArrayIndication = new GetArrayIndication(mediaBrowser_GetArray.asg_Id, mediaBrowser_GetArray.taid, new ArrayHeaderBAP(mediaBrowser_GetArray.getArrayHeader()));
                break;
            }
            case 50: {
                CommonList_GetArray commonList_GetArray = (CommonList_GetArray)getArray;
                getArrayIndication = new GetArrayIndication(commonList_GetArray.asg_Id, commonList_GetArray.taid, new ArrayHeaderBAP(commonList_GetArray.getArrayHeader()));
                break;
            }
            default: {
                this.logChannel.log(10000, "[BAPIndicationHandlerAudio#evaluateGetArrayIndication] function is not an array or not supported yet (%1)", (Object)FunctionIDs.getDescription(this.lsgID, n));
            }
        }
        return getArrayIndication;
    }

    private CombiBAPServiceAudio getActiveAudioService() {
        AudioApplicationInFocusHandler audioApplicationInFocusHandler = this.module().getAudioApplicationFocusHandler();
        if (audioApplicationInFocusHandler.isTunerInFocus()) {
            return this.module().getTunerService();
        }
        if (audioApplicationInFocusHandler.isMediaInFocus()) {
            return this.module().getMediaService();
        }
        if (audioApplicationInFocusHandler.isTVInFocus()) {
            return this.module().getTVService();
        }
        this.logChannel.log(10000, "[BAPIndicationHandlerAudio#getActiveAudioService] audio service not available");
        return null;
    }

    private CombiBAPServiceAudioListener getActiveAudioServiceListener() {
        AudioApplicationInFocusHandler audioApplicationInFocusHandler = this.module().getAudioApplicationFocusHandler();
        if (audioApplicationInFocusHandler.isTunerInFocus()) {
            return this.getTunerServiceListener();
        }
        if (audioApplicationInFocusHandler.isMediaInFocus()) {
            return this.getMediaServiceListener();
        }
        if (audioApplicationInFocusHandler.isTVInFocus()) {
            return this.getTVServiceListener();
        }
        if (audioApplicationInFocusHandler.isTerminalModeInFocus()) {
            return this.getTerminalModeServiceListener();
        }
        this.logChannel.log(10000, "[BAPIndicationHandlerAudio#getActiveAudioServiceListener] audio service listener not available");
        return null;
    }

    protected void processAnnouncementEscapeAbort(BAPFunctionMethodFSG bAPFunctionMethodFSG) {
        this.logChannel.log(10000000, "[BAPIndicationHandlerAudio#processAnnouncementEscapeAbort] Method can't be aborted: %1", (Object)bAPFunctionMethodFSG.getFctIDDescription());
        AnnouncementEscape_Result announcementEscape_Result = (AnnouncementEscape_Result)((CombiModuleAudio)this.module).createResultSerializer(29);
        announcementEscape_Result.announcementEscapeResult = 3;
        bAPFunctionMethodFSG.resultAbortNotSuccessfulREQ(announcementEscape_Result);
    }

    protected void processAnnouncementEscapeStartResult(BAPFunctionMethodFSG bAPFunctionMethodFSG) {
        this.logChannel.log(10000000, "[BAPIndicationHandlerAudio#processAnnouncementEscapeStartResult] calling tuner service 'cancelAnnouncement'");
        if (this.getTunerServiceListener() != null) {
            this.getTunerServiceListener().cancelAnnouncement();
        } else {
            AnnouncementEscape_Result announcementEscape_Result = (AnnouncementEscape_Result)((CombiModuleAudio)this.module).createResultSerializer(29);
            announcementEscape_Result.announcementEscapeResult = 1;
            bAPFunctionMethodFSG.resultREQ(announcementEscape_Result);
        }
    }

    protected void processAsgCapabilitiesSetGet(BAPFunctionPropertyFSG bAPFunctionPropertyFSG, ASG_Capabilities_SetGet aSG_Capabilities_SetGet) {
        this.logChannel.log(10000000, "[BAPIndicationHandlerAudio#processAsgCapabilitiesSetGet] called (dabLongPs=%1, sdarsLongPs=%2)", aSG_Capabilities_SetGet.presentationCapabilities.dabLongPs, aSG_Capabilities_SetGet.presentationCapabilities.sdarsLongPs);
        boolean bl = aSG_Capabilities_SetGet.presentationCapabilities.dabLongPs;
        boolean bl2 = aSG_Capabilities_SetGet.presentationCapabilities.sdarsLongPs;
        if (this.getTunerServiceListener() != null) {
            this.logChannel.log(10000000, "[BAPIndicationHandlerAudio#processAsgCapabilitiesSetGet] call tunerService 'setProgramStringLength(%1, %2)'", bl, bl2);
            this.getTunerServiceListener().setProgramStringLength(bl, bl2);
        } else {
            this.logChannel.log(10000000, "[BAPIndicationHandlerAudio#processAsgCapabilitiesSetGet] tunerService not available");
            this.module().getTunerService().updateProgramStringLength(bl, bl2);
        }
    }

    protected void processDedicatedAudioControlAbort(BAPFunctionMethodFSG bAPFunctionMethodFSG) {
        this.module().getDedicatedAudioControlHandler().processAbort();
    }

    protected void processDedicatedAudioControlStartResult(BAPFunctionMethodFSG bAPFunctionMethodFSG, DedicatedAudioControl_StartResult dedicatedAudioControl_StartResult) {
        if (BAPIndicationHandlerAudio.reservedValueUsed(dedicatedAudioControl_StartResult)) {
            this.logChannel.log(10000, "[BAPIndicationHandlerAudio#processDedicatedAudioControlStartResult] Reserved Value Used. serializer: %1", (Object)dedicatedAudioControl_StartResult);
            this.sendAppErrorOutOfRange(bAPFunctionMethodFSG);
            return;
        }
        this.module().getDedicatedAudioControlHandler().process(dedicatedAudioControl_StartResult.controlType, dedicatedAudioControl_StartResult.additionalControlInformation, dedicatedAudioControl_StartResult.listType, this.getActiveAudioServiceListener());
    }

    private static boolean reservedValueUsed(DedicatedAudioControl_StartResult dedicatedAudioControl_StartResult) {
        if (dedicatedAudioControl_StartResult.controlType >= 8 && dedicatedAudioControl_StartResult.controlType <= 255) {
            return true;
        }
        return dedicatedAudioControl_StartResult.listType >= 6 && dedicatedAudioControl_StartResult.listType <= 255;
    }

    protected void processGeneralInfoSwitchesSetGet(BAPFunctionPropertyFSG bAPFunctionPropertyFSG, GeneralInfoSwitches_SetGet generalInfoSwitches_SetGet) {
        bAPFunctionPropertyFSG.functionNotSupported();
    }

    protected void processGetNextListPosAbort(BAPFunctionMethodFSG bAPFunctionMethodFSG) {
        this.logChannel.log(10000000, "[BAPIndicationHandlerAudio#processGetNextListPosAbort] Method can't be aborted: %1", (Object)bAPFunctionMethodFSG.getFctIDDescription());
        GetNextListPos_Result getNextListPos_Result = (GetNextListPos_Result)((CombiModuleAudio)this.module).createResultSerializer(44);
        getNextListPos_Result.getNextListPos_Result = 3;
        bAPFunctionMethodFSG.resultAbortNotSuccessfulREQ(getNextListPos_Result);
    }

    protected void processGetNextListPosStartResult(BAPFunctionMethodFSG bAPFunctionMethodFSG, GetNextListPos_StartResult getNextListPos_StartResult) {
        Object object;
        int n;
        this.logChannel.log(10000000, "[BAPIndicationHandlerAudio#processGetNextListPosStartResult] called for listType %1", (long)getNextListPos_StartResult.listType);
        if (BAPIndicationHandlerAudio.reservedValueUsed(getNextListPos_StartResult)) {
            this.logChannel.log(10000, "[BAPIndicationHandlerAudio#processGetNextListPosStartResult] Reserved Value Used. serializer: %1", (Object)getNextListPos_StartResult);
            this.sendAppErrorOutOfRange(bAPFunctionMethodFSG);
            return;
        }
        boolean bl = false;
        switch (getNextListPos_StartResult.listType) {
            case 0: {
                n = 23;
                break;
            }
            case 1: {
                n = 27;
                break;
            }
            case 2: {
                n = 32;
                break;
            }
            case 3: {
                n = 33;
                break;
            }
            case 4: {
                n = 36;
                break;
            }
            case 5: {
                n = 50;
                break;
            }
            default: {
                n = -1;
                this.logChannel.log(10000, "[BAPIndicationHandlerAudio#processGetNextListPosStartResult] invalid listType: %1", (long)getNextListPos_StartResult.listType);
                bl = true;
            }
        }
        if (n != -1) {
            object = this.module().getBAPFunctionArrayFSG(n);
            if (object != null) {
                ArrayHandler arrayHandler = ((BAPFunctionArrayFSG)object).getArrayHandler();
                if (arrayHandler != null) {
                    arrayHandler.getNextListPos(getNextListPos_StartResult.currentPos, (short)getNextListPos_StartResult.offset);
                } else {
                    this.logChannel.log(10000, "[BAPIndicationHandlerAudio#processGetNextListPosStartResult] no arrayHandler found for listType=%1", (long)getNextListPos_StartResult.listType);
                    bl = true;
                }
            } else {
                this.logChannel.log(10000, "[BAPIndicationHandlerAudio#processGetNextListPosStartResult] function for listType=%1 not found", (long)getNextListPos_StartResult.listType);
                bl = true;
            }
        } else {
            this.logChannel.log(10000, "[BAPIndicationHandlerAudio#processGetNextListPosStartResult] invalid listType=%1 not found", (long)getNextListPos_StartResult.listType);
            bl = true;
        }
        if (bl) {
            object = (GetNextListPos_Result)((CombiModuleAudio)this.module).createResultSerializer(44);
            ((GetNextListPos_Result)object).getNextListPos_Result = 1;
            ((GetNextListPos_Result)object).currentPos = getNextListPos_StartResult.currentPos;
            ((GetNextListPos_Result)object).nextPos = 65535;
            ((GetNextListPos_Result)object).absoluteListPos = 65535;
            bAPFunctionMethodFSG.resultREQ((ResultMethod)object);
        }
    }

    private static boolean reservedValueUsed(GetNextListPos_StartResult getNextListPos_StartResult) {
        return getNextListPos_StartResult.listType >= 6 && getNextListPos_StartResult.listType <= 255;
    }

    protected void processMediaBrowserControlAbort(BAPFunctionMethodFSG bAPFunctionMethodFSG) {
        this.logChannel.log(10000000, "[BAPIndicationHandlerAudio#processMediaBrowserControlAbort] Method can't be aborted: %1", (Object)bAPFunctionMethodFSG.getFctIDDescription());
        MediaBrowserControl_Result mediaBrowserControl_Result = (MediaBrowserControl_Result)((CombiModuleAudio)this.module).createResultSerializer(38);
        mediaBrowserControl_Result.browserControlResult = 3;
        bAPFunctionMethodFSG.resultAbortNotSuccessfulREQ(mediaBrowserControl_Result);
    }

    protected void processMediaBrowserControlStartResult(BAPFunctionMethodFSG bAPFunctionMethodFSG, MediaBrowserControl_StartResult mediaBrowserControl_StartResult) {
        if (BAPIndicationHandlerAudio.reservedValueUsed(mediaBrowserControl_StartResult)) {
            this.logChannel.log(10000, "[BAPIndicationHandlerAudio#processMediaBrowserControlStartResult] Reserved Value Used. serializer: %1", (Object)mediaBrowserControl_StartResult);
            this.sendAppErrorOutOfRange(bAPFunctionMethodFSG);
            return;
        }
        CombiBAPServiceAudioListener combiBAPServiceAudioListener = this.getActiveAudioServiceListener();
        if (combiBAPServiceAudioListener != null && combiBAPServiceAudioListener.equals(this.getMediaServiceListener())) {
            if (mediaBrowserControl_StartResult.control == 3) {
                this.logChannel.log(100000, "[BAPIndicationHandlerAudio#processMediaBrowserControlStartResult] control 'go to source' not supported");
                MediaBrowserControl_Result mediaBrowserControl_Result = (MediaBrowserControl_Result)((CombiModuleAudio)this.module).createResultSerializer(38);
                mediaBrowserControl_Result.browserControlResult = 1;
                bAPFunctionMethodFSG.resultREQ(mediaBrowserControl_Result);
            } else {
                BAPFunctionArrayFSG bAPFunctionArrayFSG = this.module().getBAPFunctionArrayFSG(36);
                MediaBrowserListHandler mediaBrowserListHandler = (MediaBrowserListHandler)bAPFunctionArrayFSG.getArrayHandler();
                if (mediaBrowserControl_StartResult.control == 0 && mediaBrowserListHandler.isPlaybackFolder()) {
                    this.logChannel.log(10000000, "[BAPIndicationHandlerAudio#processMediaBrowserControlStartResult] playback folder is already the current browsed folder -> don't start function sync");
                } else {
                    this.logChannel.log(100000, "[BAPIndicationHandlerAudio#processMediaBrowserControlStartResult] playback folder change not supported -> don't start function sync");
                }
                this.logChannel.log(10000000, "[BAPIndicationHandlerAudio#processMediaBrowserControlStartResult] calling goTo(%1)", (long)mediaBrowserControl_StartResult.control);
                this.getMediaServiceListener().goTo(mediaBrowserControl_StartResult.control, mediaBrowserControl_StartResult.reference);
            }
        } else {
            this.logChannel.log(10000, "[BAPIndicationHandlerAudio#processMediaBrowserControlStartResult] media not active, current audio service is %1", (Object)combiBAPServiceAudioListener);
            MediaBrowserControl_Result mediaBrowserControl_Result = (MediaBrowserControl_Result)((CombiModuleAudio)this.module).createResultSerializer(38);
            mediaBrowserControl_Result.browserControlResult = 1;
            bAPFunctionMethodFSG.resultREQ(mediaBrowserControl_Result);
        }
    }

    private static boolean reservedValueUsed(MediaBrowserControl_StartResult mediaBrowserControl_StartResult) {
        return mediaBrowserControl_StartResult.control >= 5 && mediaBrowserControl_StartResult.control <= 255;
    }

    protected void processMediaFileInfoAbort(BAPFunctionMethodFSG bAPFunctionMethodFSG) {
        this.logChannel.log(10000000, "[BAPIndicationHandlerAudio#processMediaFileInfoAbort] Method can't be aborted: %1", (Object)bAPFunctionMethodFSG.getFctIDDescription());
        MediaFileInfo_Result mediaFileInfo_Result = (MediaFileInfo_Result)((CombiModuleAudio)this.module).createResultSerializer(39);
        mediaFileInfo_Result.mediaFileInfoResult = 3;
        bAPFunctionMethodFSG.resultAbortNotSuccessfulREQ(mediaFileInfo_Result);
    }

    protected void processMediaFileInfoStartResult(BAPFunctionMethodFSG bAPFunctionMethodFSG, MediaFileInfo_StartResult mediaFileInfo_StartResult) {
        bAPFunctionMethodFSG.functionNotSupported();
    }

    protected void processSdsStateSetGet(BAPFunctionPropertyFSG bAPFunctionPropertyFSG, SDS_State_SetGet sDS_State_SetGet) {
        if (this.module().getFunctionList().isFunctionSupported(bAPFunctionPropertyFSG.getFctID())) {
            this.logChannel.log(10000000, "[BAPIndicationHandlerAudio#processSdsStateSetGet] SetGet not supported, just reply status message");
            SDS_State_Status sDS_State_Status = (SDS_State_Status)bAPFunctionPropertyFSG.getLastStatus();
            this.module().getSDSService().updateSDSState(sDS_State_Status.state);
            if (this.module().getExternalKeyListener() != null) {
                if (sDS_State_SetGet.state == 3) {
                    this.logChannel.log(10000000, "[BAPIndicationHandlerAudio#processSdsStateSetGet] send key event");
                    this.module().getExternalKeyListener().supplyExternalKey(100, 50, 1, 1);
                    this.module().getExternalKeyListener().supplyExternalKey(100, 50, 0, 1);
                }
            } else {
                this.logChannel.log(10000000, "[BAPIndicationHandlerAudio#processSdsStateSetGet] externalKeyListener is null");
            }
        } else {
            this.logChannel.log(10000000, "[BAPIndicationHandlerAudio#processSdsStateSetGet] SDSState not supported");
            bAPFunctionPropertyFSG.functionNotSupported();
        }
    }

    protected void processPreferredListSetGet(BAPFunctionPropertyFSG bAPFunctionPropertyFSG, PreferredList_SetGet preferredList_SetGet) {
        if (BAPIndicationHandlerAudio.reservedValueUsed(preferredList_SetGet)) {
            this.logChannel.log(10000, "[BAPIndicationHandlerAudio#processPreferredListSetGet] Reserved Value Used. serializer: %1", (Object)preferredList_SetGet);
            this.sendAppErrorOutOfRange(bAPFunctionPropertyFSG);
            return;
        }
        CombiBAPServiceAudioListener combiBAPServiceAudioListener = this.getActiveAudioServiceListener();
        if (combiBAPServiceAudioListener != null) {
            this.logChannel.log(10000000, "[BAPIndicationHandlerAudio#processPreferredListSetGet] calling 'setPreferredList' at active audio service");
            combiBAPServiceAudioListener.setPreferredList(preferredList_SetGet.list);
        } else {
            this.logChannel.log(10000, "[BAPIndicationHandlerAudio#processPreferredListSetGet] audio service listener unavailable");
            PreferredList_Status preferredList_Status = new PreferredList_Status();
            preferredList_Status.list = preferredList_SetGet.list;
            bAPFunctionPropertyFSG.sendStatus(preferredList_Status);
        }
    }

    private static boolean reservedValueUsed(PreferredList_SetGet preferredList_SetGet) {
        return preferredList_SetGet.list >= 4 && preferredList_SetGet.list <= 255;
    }

    protected void processMuteSetGet(BAPFunctionPropertyFSG bAPFunctionPropertyFSG, Mute_SetGet mute_SetGet) {
        CombiBAPServiceToneListener combiBAPServiceToneListener = this.module().getToneServiceListener();
        if (combiBAPServiceToneListener != null) {
            Mute_Status mute_Status = (Mute_Status)bAPFunctionPropertyFSG.getLastStatus();
            if (mute_Status.muteState.muting == mute_SetGet.muteState.muting) {
                bAPFunctionPropertyFSG.resendLastStatus();
            } else {
                this.logChannel.log(10000000, "[BAPIndicationHandlerAudio#processMuteSetGet] calling toneService->setMuteState(muting=%1)", mute_SetGet.muteState.muting);
                combiBAPServiceToneListener.setMuteState(mute_SetGet.muteState.muting);
            }
        } else {
            this.logChannel.log(10000, "[BAPIndicationHandlerAudio#processMuteSetGet] toneService not available");
            bAPFunctionPropertyFSG.functionNotSupported();
        }
    }

    protected void processSourceStateSetGet(BAPFunctionPropertyFSG bAPFunctionPropertyFSG, SourceState_SetGet sourceState_SetGet) {
        if (BAPIndicationHandlerAudio.reservedValueUsed(sourceState_SetGet)) {
            this.logChannel.log(10000, "[BAPIndicationHandlerAudio#processSourceStateSetGet] Reserved Value Used. serializer: %1", (Object)sourceState_SetGet);
            this.sendAppErrorOutOfRange(bAPFunctionPropertyFSG);
            return;
        }
        CombiBAPServiceAudioListener combiBAPServiceAudioListener = this.getActiveAudioServiceListener();
        if (combiBAPServiceAudioListener != null) {
            SourceState_Status sourceState_Status = (SourceState_Status)bAPFunctionPropertyFSG.getLastStatus();
            if (sourceState_Status.stateInfo == sourceState_SetGet.stateInfo && sourceState_Status.stateInfo_Scope == sourceState_SetGet.stateInfo_Scope) {
                bAPFunctionPropertyFSG.resendLastStatus();
            } else {
                this.logChannel.log(10000000, "[BAPIndicationHandlerAudio#processSourceStateSetGet] calling 'setActiveSourceState' at active audio service");
                combiBAPServiceAudioListener.setActiveSourceState(sourceState_SetGet.stateInfo, sourceState_SetGet.stateInfo_Scope);
            }
        } else {
            this.logChannel.log(10000, "[BAPIndicationHandlerAudio#processSourceStateSetGet] audio service listener unavailable");
            bAPFunctionPropertyFSG.functionNotSupported();
        }
    }

    private static boolean reservedValueUsed(SourceState_SetGet sourceState_SetGet) {
        if (sourceState_SetGet.stateInfo >= 8 && sourceState_SetGet.stateInfo <= 255) {
            return true;
        }
        return sourceState_SetGet.stateInfo_Scope >= 9 && sourceState_SetGet.stateInfo_Scope <= 255;
    }

    protected void processSwitchRadioMediaAbort(BAPFunctionMethodFSG bAPFunctionMethodFSG) {
        this.logChannel.log(10000000, "[BAPIndicationHandlerAudio#processSwitchRadioMediaAbort] Method can't be aborted: %1", (Object)bAPFunctionMethodFSG.getFctIDDescription());
        SwitchRadioMedia_Result switchRadioMedia_Result = (SwitchRadioMedia_Result)((CombiModuleAudio)this.module).createResultSerializer(45);
        switchRadioMedia_Result.switchRadioMediaResult = 3;
        bAPFunctionMethodFSG.resultAbortNotSuccessfulREQ(switchRadioMedia_Result);
    }

    protected void processSwitchRadioMediaStartResult(BAPFunctionMethodFSG bAPFunctionMethodFSG, SwitchRadioMedia_StartResult switchRadioMedia_StartResult) {
        if (BAPIndicationHandlerAudio.reservedValueUsed(switchRadioMedia_StartResult)) {
            this.logChannel.log(10000, "[BAPIndicationHandlerAudio#processSwitchRadioMediaStartResult] Reserved Value Used. serializer: %1", (Object)switchRadioMedia_StartResult);
            this.sendAppErrorOutOfRange(bAPFunctionMethodFSG);
            return;
        }
        int n = this.module().getAudioApplicationFocusHandler().getAudioApplicationInFocus();
        this.logChannel.log(10000000, "[BAPIndicationHandlerAudio#processSwitchRadioMediaStartResult] source=%1 activeAudioApplication=%2", (long)switchRadioMedia_StartResult.source, (long)n);
        if (this.audioSourceForApp(n) == switchRadioMedia_StartResult.source) {
            this.reportActivateSourceResult(0);
            return;
        }
        switch (n) {
            case 0: {
                this.logChannel.log(10000000, "[BAPIndicationHandlerAudio#processSwitchRadioMediaStartResult] going from radio (tuner) to media.");
                this.switchToSource(this.getMediaServiceListener(), switchRadioMedia_StartResult.source);
                break;
            }
            case 1: {
                this.logChannel.log(10000000, "[BAPIndicationHandlerAudio#processSwitchRadioMediaStartResult] going from media to radio.");
                this.switchToSource(this.getTunerServiceListener(), switchRadioMedia_StartResult.source);
                break;
            }
            case 2: {
                this.logChannel.log(10000000, "[BAPIndicationHandlerAudio#processSwitchRadioMediaStartResult] going from media (tv) to radio.");
                this.switchToSource(this.getTunerServiceListener(), switchRadioMedia_StartResult.source);
                break;
            }
            case 3: {
                this.logChannel.log(10000000, "[BAPIndicationHandlerAudio#processSwitchRadioMediaStartResult] going from media (terminal mode) to radio.");
                this.switchToSource(this.getTunerServiceListener(), switchRadioMedia_StartResult.source);
                break;
            }
            default: {
                this.logChannel.log(10000, "[BAPIndicationHandlerAudio#processSwitchRadioMediaStartResult] Current audio app not known!");
                this.reportActivateSourceResult(1);
            }
        }
    }

    private static boolean reservedValueUsed(SwitchRadioMedia_StartResult switchRadioMedia_StartResult) {
        return switchRadioMedia_StartResult.source >= 4 && switchRadioMedia_StartResult.source <= 255;
    }

    private int audioSourceForApp(int n) {
        switch (n) {
            case 0: {
                return 0;
            }
            case 1: 
            case 2: 
            case 3: {
                return 1;
            }
        }
        this.logChannel.log(10000, "[BAPIndicationHandlerAudio#audioSourceForApp] audioApp not valid.");
        return -1;
    }

    private void switchToSource(CombiBAPServiceAudioListener combiBAPServiceAudioListener, int n) {
        if (combiBAPServiceAudioListener == null) {
            this.logChannel.log(100000, "[BAPIndicationHandlerAudio#switchToSource] Can't switch to source. audioServiceListener is null.");
            this.reportActivateSourceResult(1);
            return;
        }
        combiBAPServiceAudioListener.activateSource(n);
    }

    private void reportActivateSourceResult(int n) {
        CombiBAPServiceAudio combiBAPServiceAudio = this.getActiveAudioService();
        if (combiBAPServiceAudio == null) {
            this.logChannel.log(10000, "[BAPIndicationHandlerAudio#reportActivateSourceResult] Audio service not available.");
            return;
        }
        combiBAPServiceAudio.activateSourceResult(n);
    }

    protected void processSwitchSourceAbort(BAPFunctionMethodFSG bAPFunctionMethodFSG) {
        this.logChannel.log(10000000, "[BAPIndicationHandlerAudio#processSwitchSourceAbort] Method can't be aborted: %1", (Object)bAPFunctionMethodFSG.getFctIDDescription());
        SwitchSource_Result switchSource_Result = (SwitchSource_Result)((CombiModuleAudio)this.module).createResultSerializer(34);
        switchSource_Result.switchSourceResult = 3;
        bAPFunctionMethodFSG.resultAbortNotSuccessfulREQ(switchSource_Result);
    }

    protected void processSwitchSourceStartResult(BAPFunctionMethodFSG bAPFunctionMethodFSG, SwitchSource_StartResult switchSource_StartResult) {
        int n = switchSource_StartResult.sourceList_Reference;
        BAPFunctionArrayFSG bAPFunctionArrayFSG = this.module().getBAPFunctionArrayFSG(32);
        ArrayHandler arrayHandler = bAPFunctionArrayFSG.getArrayHandler();
        CombiBAPAudioSource combiBAPAudioSource = (CombiBAPAudioSource)arrayHandler.getArrayElement(n);
        if (combiBAPAudioSource == null) {
            this.logChannel.log(10000, "[BAPIndicationHandlerAudio#processSwitchSourceStartResult] source not in sourceList (ref=%1)", (long)n);
            this.module().getTunerService().switchSourceResult(1);
        } else {
            int n2 = combiBAPAudioSource.getSourceType();
            int n3 = combiBAPAudioSource.getSlotNumber();
            int n4 = combiBAPAudioSource.getPartitionNumber();
            int n5 = SourceListHandler.getApplicationForSourceType(n2);
            if (n5 != this.module().getAudioApplicationFocusHandler().getAudioApplicationInFocus()) {
                this.logChannel.log(10000000, "[BAPIndicationHandlerAudio#processSwitchSourceStartResult] trying context change from app=%1 to app=%2", (long)this.module().getAudioApplicationFocusHandler().getAudioApplicationInFocus(), (long)n5);
                BAPFunctionMethodFSG bAPFunctionMethodFSG2 = this.module().getBAPFunctionMethodFSG(34);
                bAPFunctionMethodFSG2.setResultWaiting(0);
            }
            switch (n5) {
                case 0: {
                    this.logChannel.log(10000000, "[BAPIndicationHandlerAudio#processSwitchSourceStartResult] calling 'switchSource' at Tuner service (sourceType=%1, slotNumber=%2, partitionNumber=%3)", (long)n2, (long)n3, (long)n4);
                    this.getTunerServiceListener().switchSource(n2, n3, n4);
                    break;
                }
                case 1: {
                    this.logChannel.log(10000000, "[BAPIndicationHandlerAudio#processSwitchSourceStartResult] calling 'switchSource' at Media service (sourceType=%1, slotNumber=%2, partitionNumber=%3)", (long)n2, (long)n3, (long)n4);
                    this.getMediaServiceListener().switchSource(n2, n3, n4);
                    break;
                }
                case 2: {
                    this.logChannel.log(10000000, "[BAPIndicationHandlerAudio#processSwitchSourceStartResult] calling 'switchSource' at TV service (sourceType=%1, slotNumber=%2, partitionNumber=%3): %1", (long)n2, (long)n3, (long)n4);
                    this.getTVServiceListener().switchSource(n2, n3, n4);
                    break;
                }
                case 3: {
                    this.logChannel.log(10000000, "[BAPIndicationHandlerAudio#processSwitchSourceStartResult] calling 'switchSource' at TerminalMode service (sourceType=%1, slotNumber=%2, partitionNumber=%3): %1", (long)n2, (long)n3, (long)n4);
                    this.getTerminalModeServiceListener().switchSource(n2, n3, n4);
                    break;
                }
                default: {
                    this.logChannel.log(10000, "[BAPIndicationHandlerAudio#processSwitchSourceStartResult] invalid sourceType (%1)", (long)n2);
                    this.module().getTunerService().switchSourceResult(1);
                }
            }
        }
    }

    protected void processCurrentVolumeExtendedSetGet(BAPFunctionPropertyFSG bAPFunctionPropertyFSG, CurrentVolumeExtended_SetGet currentVolumeExtended_SetGet) {
        this.logChannel.log(1000000, "[BAPIndicationHandlerAudio#processCurrentVolumeExtendedSetGet] changingVolumeType: %1, genericVolume: %2", (long)currentVolumeExtended_SetGet.changingVolumeType, (long)currentVolumeExtended_SetGet.genericVolume);
        this.module().getToneServiceListener().setVolume(currentVolumeExtended_SetGet.changingVolumeType, currentVolumeExtended_SetGet.genericVolume);
    }

    private void sendAppErrorOutOfRange(AbstractBAPFunction abstractBAPFunction) {
        this.module.getRequestHandler().requestErrorCode(this.module.getLSGID(), abstractBAPFunction.getFctID(), 65);
        abstractBAPFunction.reset();
    }

    private CombiModuleAudio module() {
        return (CombiModuleAudio)this.module;
    }
}

