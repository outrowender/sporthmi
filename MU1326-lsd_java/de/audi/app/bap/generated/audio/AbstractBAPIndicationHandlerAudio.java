/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.generated.audio;

import de.audi.app.bap.fw.AbstractBAPModuleFSG;
import de.audi.app.bap.fw.functiontypes.BAPFunctionArrayFSG;
import de.audi.app.bap.fw.functiontypes.BAPFunctionMethodFSG;
import de.audi.app.bap.fw.functiontypes.BAPFunctionPropertyFSG;
import de.audi.app.bap.fw.indication.AbstractBAPIndicationHandlerFSG;
import de.audi.atip.log.LogChannel;
import de.vw.mib.bap.datatypes.BAPArray;
import de.vw.mib.bap.generated.audiosd.serializer.ASG_Capabilities_SetGet;
import de.vw.mib.bap.generated.audiosd.serializer.CurrentVolumeExtended_SetGet;
import de.vw.mib.bap.generated.audiosd.serializer.DedicatedAudioControl_StartResult;
import de.vw.mib.bap.generated.audiosd.serializer.GeneralInfoSwitches_SetGet;
import de.vw.mib.bap.generated.audiosd.serializer.GetNextListPos_StartResult;
import de.vw.mib.bap.generated.audiosd.serializer.MediaBrowserControl_StartResult;
import de.vw.mib.bap.generated.audiosd.serializer.MediaFileInfo_StartResult;
import de.vw.mib.bap.generated.audiosd.serializer.Mute_SetGet;
import de.vw.mib.bap.generated.audiosd.serializer.PreferredList_SetGet;
import de.vw.mib.bap.generated.audiosd.serializer.SDS_State_SetGet;
import de.vw.mib.bap.generated.audiosd.serializer.SourceState_SetGet;
import de.vw.mib.bap.generated.audiosd.serializer.SwitchRadioMedia_StartResult;
import de.vw.mib.bap.generated.audiosd.serializer.SwitchSource_StartResult;
import de.vw.mib.bap.requests.AckProperty;
import de.vw.mib.bap.requests.SetGetArray;
import de.vw.mib.bap.requests.SetGetProperty;
import de.vw.mib.bap.requests.StartResultMethod;

public abstract class AbstractBAPIndicationHandlerAudio
extends AbstractBAPIndicationHandlerFSG {
    public AbstractBAPIndicationHandlerAudio(AbstractBAPModuleFSG abstractBAPModuleFSG, LogChannel logChannel) {
        super(abstractBAPModuleFSG, logChannel);
    }

    @Override
    public void processIndicationStartResult(BAPFunctionMethodFSG bAPFunctionMethodFSG, StartResultMethod startResultMethod) {
        switch (bAPFunctionMethodFSG.getFctID()) {
            case 24: {
                this.processDedicatedAudioControlStartResult(bAPFunctionMethodFSG, (DedicatedAudioControl_StartResult)startResultMethod);
                break;
            }
            case 29: {
                this.processAnnouncementEscapeStartResult(bAPFunctionMethodFSG);
                break;
            }
            case 34: {
                this.processSwitchSourceStartResult(bAPFunctionMethodFSG, (SwitchSource_StartResult)startResultMethod);
                break;
            }
            case 38: {
                this.processMediaBrowserControlStartResult(bAPFunctionMethodFSG, (MediaBrowserControl_StartResult)startResultMethod);
                break;
            }
            case 39: {
                this.processMediaFileInfoStartResult(bAPFunctionMethodFSG, (MediaFileInfo_StartResult)startResultMethod);
                break;
            }
            case 44: {
                this.processGetNextListPosStartResult(bAPFunctionMethodFSG, (GetNextListPos_StartResult)startResultMethod);
                break;
            }
            case 45: {
                this.processSwitchRadioMediaStartResult(bAPFunctionMethodFSG, (SwitchRadioMedia_StartResult)startResultMethod);
                break;
            }
            default: {
                this.logChannel.log(10000, "AbstractBAPIndicationHandlerAudio#processIndicationStartResult not implemented for fctID=%1", (Object)bAPFunctionMethodFSG.getFctIDDescription());
            }
        }
    }

    @Override
    public void processIndicationAbort(BAPFunctionMethodFSG bAPFunctionMethodFSG) {
        switch (bAPFunctionMethodFSG.getFctID()) {
            case 24: {
                this.processDedicatedAudioControlAbort(bAPFunctionMethodFSG);
                break;
            }
            case 29: {
                this.processAnnouncementEscapeAbort(bAPFunctionMethodFSG);
                break;
            }
            case 34: {
                this.processSwitchSourceAbort(bAPFunctionMethodFSG);
                break;
            }
            case 38: {
                this.processMediaBrowserControlAbort(bAPFunctionMethodFSG);
                break;
            }
            case 39: {
                this.processMediaFileInfoAbort(bAPFunctionMethodFSG);
                break;
            }
            case 44: {
                this.processGetNextListPosAbort(bAPFunctionMethodFSG);
                break;
            }
            case 45: {
                this.processSwitchRadioMediaAbort(bAPFunctionMethodFSG);
                break;
            }
            default: {
                this.logChannel.log(10000, "AbstractBAPIndicationHandlerAudio#processIndicationAbort not implemented for fctID=%1", (Object)bAPFunctionMethodFSG.getFctIDDescription());
            }
        }
    }

    @Override
    public void processIndicationSet(BAPFunctionPropertyFSG bAPFunctionPropertyFSG, SetGetProperty setGetProperty) {
        switch (bAPFunctionPropertyFSG.getFctID()) {
            default: 
        }
        this.logChannel.log(10000, "AbstractBAPIndicationHandlerAudio#processIndicationSet not implemented for fctID=%1", (Object)bAPFunctionPropertyFSG.getFctIDDescription());
    }

    @Override
    public void processIndicationSetGet(BAPFunctionPropertyFSG bAPFunctionPropertyFSG, SetGetProperty setGetProperty) {
        switch (bAPFunctionPropertyFSG.getFctID()) {
            case 19: {
                this.processMuteSetGet(bAPFunctionPropertyFSG, (Mute_SetGet)setGetProperty);
                break;
            }
            case 20: {
                this.processSourceStateSetGet(bAPFunctionPropertyFSG, (SourceState_SetGet)setGetProperty);
                break;
            }
            case 25: {
                this.processGeneralInfoSwitchesSetGet(bAPFunctionPropertyFSG, (GeneralInfoSwitches_SetGet)setGetProperty);
                break;
            }
            case 40: {
                this.processPreferredListSetGet(bAPFunctionPropertyFSG, (PreferredList_SetGet)setGetProperty);
                break;
            }
            case 41: {
                this.processSdsStateSetGet(bAPFunctionPropertyFSG, (SDS_State_SetGet)setGetProperty);
                break;
            }
            case 43: {
                this.processAsgCapabilitiesSetGet(bAPFunctionPropertyFSG, (ASG_Capabilities_SetGet)setGetProperty);
                break;
            }
            case 47: {
                this.processCurrentVolumeExtendedSetGet(bAPFunctionPropertyFSG, (CurrentVolumeExtended_SetGet)setGetProperty);
                break;
            }
            default: {
                this.logChannel.log(10000, "AbstractBAPIndicationHandlerAudio#processIndicationSetGet not implemented for fctID=%1", (Object)bAPFunctionPropertyFSG.getFctIDDescription());
            }
        }
    }

    @Override
    public void processIndicationAck(BAPFunctionPropertyFSG bAPFunctionPropertyFSG, AckProperty ackProperty) {
        switch (bAPFunctionPropertyFSG.getFctID()) {
            default: 
        }
        this.logChannel.log(10000, "AbstractBAPIndicationHandlerAudio#processIndicationAck not implemented for fctID=%1", (Object)bAPFunctionPropertyFSG.getFctIDDescription());
    }

    @Override
    public void processIndicationAckArray(BAPFunctionArrayFSG bAPFunctionArrayFSG, BAPArray bAPArray) {
        switch (bAPFunctionArrayFSG.getFctID()) {
            default: 
        }
        this.logChannel.log(10000, "AbstractBAPIndicationHandlerAudio#processIndicationAck not implemented for fctID=%1", (Object)bAPFunctionArrayFSG.getFctIDDescription());
    }

    @Override
    public void processIndicationSetArray(BAPFunctionArrayFSG bAPFunctionArrayFSG, SetGetArray setGetArray) {
        switch (bAPFunctionArrayFSG.getFctID()) {
            default: 
        }
        this.logChannel.log(10000, "AbstractBAPIndicationHandlerAudio#processIndicationSetArray not implemented for fctID=%1", (Object)bAPFunctionArrayFSG.getFctIDDescription());
    }

    @Override
    public void processIndicationSetGetArray(BAPFunctionArrayFSG bAPFunctionArrayFSG, SetGetArray setGetArray) {
        switch (bAPFunctionArrayFSG.getFctID()) {
            default: 
        }
        this.logChannel.log(10000, "AbstractBAPIndicationHandlerAudio#processIndicationSetGetArray not implemented for fctID=%1", (Object)bAPFunctionArrayFSG.getFctIDDescription());
    }

    protected abstract void processMuteSetGet(BAPFunctionPropertyFSG bAPFunctionPropertyFSG, Mute_SetGet mute_SetGet) {
    }

    protected abstract void processSourceStateSetGet(BAPFunctionPropertyFSG bAPFunctionPropertyFSG, SourceState_SetGet sourceState_SetGet) {
    }

    protected abstract void processDedicatedAudioControlAbort(BAPFunctionMethodFSG bAPFunctionMethodFSG) {
    }

    protected abstract void processDedicatedAudioControlStartResult(BAPFunctionMethodFSG bAPFunctionMethodFSG, DedicatedAudioControl_StartResult dedicatedAudioControl_StartResult) {
    }

    protected abstract void processGeneralInfoSwitchesSetGet(BAPFunctionPropertyFSG bAPFunctionPropertyFSG, GeneralInfoSwitches_SetGet generalInfoSwitches_SetGet) {
    }

    protected abstract void processAnnouncementEscapeAbort(BAPFunctionMethodFSG bAPFunctionMethodFSG) {
    }

    protected abstract void processAnnouncementEscapeStartResult(BAPFunctionMethodFSG bAPFunctionMethodFSG) {
    }

    protected abstract void processSwitchSourceAbort(BAPFunctionMethodFSG bAPFunctionMethodFSG) {
    }

    protected abstract void processSwitchSourceStartResult(BAPFunctionMethodFSG bAPFunctionMethodFSG, SwitchSource_StartResult switchSource_StartResult) {
    }

    protected abstract void processMediaBrowserControlAbort(BAPFunctionMethodFSG bAPFunctionMethodFSG) {
    }

    protected abstract void processMediaBrowserControlStartResult(BAPFunctionMethodFSG bAPFunctionMethodFSG, MediaBrowserControl_StartResult mediaBrowserControl_StartResult) {
    }

    protected abstract void processMediaFileInfoAbort(BAPFunctionMethodFSG bAPFunctionMethodFSG) {
    }

    protected abstract void processMediaFileInfoStartResult(BAPFunctionMethodFSG bAPFunctionMethodFSG, MediaFileInfo_StartResult mediaFileInfo_StartResult) {
    }

    protected abstract void processPreferredListSetGet(BAPFunctionPropertyFSG bAPFunctionPropertyFSG, PreferredList_SetGet preferredList_SetGet) {
    }

    protected abstract void processSdsStateSetGet(BAPFunctionPropertyFSG bAPFunctionPropertyFSG, SDS_State_SetGet sDS_State_SetGet) {
    }

    protected abstract void processAsgCapabilitiesSetGet(BAPFunctionPropertyFSG bAPFunctionPropertyFSG, ASG_Capabilities_SetGet aSG_Capabilities_SetGet) {
    }

    protected abstract void processGetNextListPosAbort(BAPFunctionMethodFSG bAPFunctionMethodFSG) {
    }

    protected abstract void processGetNextListPosStartResult(BAPFunctionMethodFSG bAPFunctionMethodFSG, GetNextListPos_StartResult getNextListPos_StartResult) {
    }

    protected abstract void processSwitchRadioMediaAbort(BAPFunctionMethodFSG bAPFunctionMethodFSG) {
    }

    protected abstract void processSwitchRadioMediaStartResult(BAPFunctionMethodFSG bAPFunctionMethodFSG, SwitchRadioMedia_StartResult switchRadioMedia_StartResult) {
    }

    protected abstract void processCurrentVolumeExtendedSetGet(BAPFunctionPropertyFSG bAPFunctionPropertyFSG, CurrentVolumeExtended_SetGet currentVolumeExtended_SetGet) {
    }
}

