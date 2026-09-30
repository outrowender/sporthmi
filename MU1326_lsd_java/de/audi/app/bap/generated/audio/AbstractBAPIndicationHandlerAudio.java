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

    public void processIndicationSet(BAPFunctionPropertyFSG bAPFunctionPropertyFSG, SetGetProperty setGetProperty) {
        switch (bAPFunctionPropertyFSG.getFctID()) {
            default: 
        }
        this.logChannel.log(10000, "AbstractBAPIndicationHandlerAudio#processIndicationSet not implemented for fctID=%1", (Object)bAPFunctionPropertyFSG.getFctIDDescription());
    }

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

    public void processIndicationAck(BAPFunctionPropertyFSG bAPFunctionPropertyFSG, AckProperty ackProperty) {
        switch (bAPFunctionPropertyFSG.getFctID()) {
            default: 
        }
        this.logChannel.log(10000, "AbstractBAPIndicationHandlerAudio#processIndicationAck not implemented for fctID=%1", (Object)bAPFunctionPropertyFSG.getFctIDDescription());
    }

    public void processIndicationAckArray(BAPFunctionArrayFSG bAPFunctionArrayFSG, BAPArray bAPArray) {
        switch (bAPFunctionArrayFSG.getFctID()) {
            default: 
        }
        this.logChannel.log(10000, "AbstractBAPIndicationHandlerAudio#processIndicationAck not implemented for fctID=%1", (Object)bAPFunctionArrayFSG.getFctIDDescription());
    }

    public void processIndicationSetArray(BAPFunctionArrayFSG bAPFunctionArrayFSG, SetGetArray setGetArray) {
        switch (bAPFunctionArrayFSG.getFctID()) {
            default: 
        }
        this.logChannel.log(10000, "AbstractBAPIndicationHandlerAudio#processIndicationSetArray not implemented for fctID=%1", (Object)bAPFunctionArrayFSG.getFctIDDescription());
    }

    public void processIndicationSetGetArray(BAPFunctionArrayFSG bAPFunctionArrayFSG, SetGetArray setGetArray) {
        switch (bAPFunctionArrayFSG.getFctID()) {
            default: 
        }
        this.logChannel.log(10000, "AbstractBAPIndicationHandlerAudio#processIndicationSetGetArray not implemented for fctID=%1", (Object)bAPFunctionArrayFSG.getFctIDDescription());
    }

    protected abstract void processMuteSetGet(BAPFunctionPropertyFSG var1, Mute_SetGet var2);

    protected abstract void processSourceStateSetGet(BAPFunctionPropertyFSG var1, SourceState_SetGet var2);

    protected abstract void processDedicatedAudioControlAbort(BAPFunctionMethodFSG var1);

    protected abstract void processDedicatedAudioControlStartResult(BAPFunctionMethodFSG var1, DedicatedAudioControl_StartResult var2);

    protected abstract void processGeneralInfoSwitchesSetGet(BAPFunctionPropertyFSG var1, GeneralInfoSwitches_SetGet var2);

    protected abstract void processAnnouncementEscapeAbort(BAPFunctionMethodFSG var1);

    protected abstract void processAnnouncementEscapeStartResult(BAPFunctionMethodFSG var1);

    protected abstract void processSwitchSourceAbort(BAPFunctionMethodFSG var1);

    protected abstract void processSwitchSourceStartResult(BAPFunctionMethodFSG var1, SwitchSource_StartResult var2);

    protected abstract void processMediaBrowserControlAbort(BAPFunctionMethodFSG var1);

    protected abstract void processMediaBrowserControlStartResult(BAPFunctionMethodFSG var1, MediaBrowserControl_StartResult var2);

    protected abstract void processMediaFileInfoAbort(BAPFunctionMethodFSG var1);

    protected abstract void processMediaFileInfoStartResult(BAPFunctionMethodFSG var1, MediaFileInfo_StartResult var2);

    protected abstract void processPreferredListSetGet(BAPFunctionPropertyFSG var1, PreferredList_SetGet var2);

    protected abstract void processSdsStateSetGet(BAPFunctionPropertyFSG var1, SDS_State_SetGet var2);

    protected abstract void processAsgCapabilitiesSetGet(BAPFunctionPropertyFSG var1, ASG_Capabilities_SetGet var2);

    protected abstract void processGetNextListPosAbort(BAPFunctionMethodFSG var1);

    protected abstract void processGetNextListPosStartResult(BAPFunctionMethodFSG var1, GetNextListPos_StartResult var2);

    protected abstract void processSwitchRadioMediaAbort(BAPFunctionMethodFSG var1);

    protected abstract void processSwitchRadioMediaStartResult(BAPFunctionMethodFSG var1, SwitchRadioMedia_StartResult var2);

    protected abstract void processCurrentVolumeExtendedSetGet(BAPFunctionPropertyFSG var1, CurrentVolumeExtended_SetGet var2);
}

