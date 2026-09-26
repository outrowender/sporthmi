/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.generated.phone;

import de.audi.app.bap.fw.AbstractBAPModuleFSG;
import de.audi.app.bap.fw.functiontypes.BAPFunctionArrayFSG;
import de.audi.app.bap.fw.functiontypes.BAPFunctionMethodFSG;
import de.audi.app.bap.fw.functiontypes.BAPFunctionPropertyFSG;
import de.audi.app.bap.fw.indication.AbstractBAPIndicationHandlerFSG;
import de.audi.atip.log.LogChannel;
import de.vw.mib.bap.datatypes.BAPArray;
import de.vw.mib.bap.generated.telephone.serializer.AutomaticRedial_SetGet;
import de.vw.mib.bap.generated.telephone.serializer.CCSplit_StartResult;
import de.vw.mib.bap.generated.telephone.serializer.CallStackDeleteAll_StartResult;
import de.vw.mib.bap.generated.telephone.serializer.CombinedNumbers_SetGetArray;
import de.vw.mib.bap.generated.telephone.serializer.ConfirmEmergencyCall_StartResult;
import de.vw.mib.bap.generated.telephone.serializer.DialNumber_StartResult;
import de.vw.mib.bap.generated.telephone.serializer.DialService_StartResult;
import de.vw.mib.bap.generated.telephone.serializer.DialedNumbers_SetGetArray;
import de.vw.mib.bap.generated.telephone.serializer.FavoriteList_SetGetArray;
import de.vw.mib.bap.generated.telephone.serializer.GetNextListPos_StartResult;
import de.vw.mib.bap.generated.telephone.serializer.HandsFreeOnOff_SetGet;
import de.vw.mib.bap.generated.telephone.serializer.HangupCall_StartResult;
import de.vw.mib.bap.generated.telephone.serializer.MicroMuteOnOff_SetGet;
import de.vw.mib.bap.generated.telephone.serializer.MissedCallIndication_SetGet;
import de.vw.mib.bap.generated.telephone.serializer.MissedCalls_SetGetArray;
import de.vw.mib.bap.generated.telephone.serializer.PbSpeller_StartResult;
import de.vw.mib.bap.generated.telephone.serializer.ReceivedCalls_SetGetArray;
import de.vw.mib.bap.generated.telephone.serializer.RingToneMuteOnOff_SetGet;
import de.vw.mib.bap.generated.telephone.serializer.SMSState_SetGet;
import de.vw.mib.bap.requests.AckProperty;
import de.vw.mib.bap.requests.SetGetArray;
import de.vw.mib.bap.requests.SetGetProperty;
import de.vw.mib.bap.requests.StartResultMethod;

public abstract class AbstractBAPIndicationHandlerPhone
extends AbstractBAPIndicationHandlerFSG {
    public AbstractBAPIndicationHandlerPhone(AbstractBAPModuleFSG abstractBAPModuleFSG, LogChannel logChannel) {
        super(abstractBAPModuleFSG, logChannel);
    }

    @Override
    public void processIndicationStartResult(BAPFunctionMethodFSG bAPFunctionMethodFSG, StartResultMethod startResultMethod) {
        switch (bAPFunctionMethodFSG.getFctID()) {
            case 26: {
                this.processDialNumberStartResult(bAPFunctionMethodFSG, (DialNumber_StartResult)startResultMethod);
                break;
            }
            case 27: {
                this.processDialServiceStartResult(bAPFunctionMethodFSG, (DialService_StartResult)startResultMethod);
                break;
            }
            case 28: {
                this.processConfirmEmergencyCallStartResult(bAPFunctionMethodFSG, (ConfirmEmergencyCall_StartResult)startResultMethod);
                break;
            }
            case 29: {
                this.processHangupCallStartResult(bAPFunctionMethodFSG, (HangupCall_StartResult)startResultMethod);
                break;
            }
            case 30: {
                this.processAcceptCallStartResult(bAPFunctionMethodFSG);
                break;
            }
            case 31: {
                this.processCallHoldStartResult(bAPFunctionMethodFSG);
                break;
            }
            case 32: {
                this.processResumeCallStartResult(bAPFunctionMethodFSG);
                break;
            }
            case 35: {
                this.processMpRelActiveCallAcceptWcStartResult(bAPFunctionMethodFSG);
                break;
            }
            case 36: {
                this.processMpSwapStartResult(bAPFunctionMethodFSG);
                break;
            }
            case 37: {
                this.processMpCallHoldAcceptWcStartResult(bAPFunctionMethodFSG);
                break;
            }
            case 38: {
                this.processMpRelAllCallsAcceptWcStartResult(bAPFunctionMethodFSG);
                break;
            }
            case 39: {
                this.processMpSetWaitingCallOnHoldStartResult(bAPFunctionMethodFSG);
                break;
            }
            case 40: {
                this.processCcJoinStartResult(bAPFunctionMethodFSG);
                break;
            }
            case 41: {
                this.processCcSplitStartResult(bAPFunctionMethodFSG, (CCSplit_StartResult)startResultMethod);
                break;
            }
            case 50: {
                this.processCallStackDeleteAllStartResult(bAPFunctionMethodFSG, (CallStackDeleteAll_StartResult)startResultMethod);
                break;
            }
            case 53: {
                this.processPbSpellerStartResult(bAPFunctionMethodFSG, (PbSpeller_StartResult)startResultMethod);
                break;
            }
            case 54: {
                this.processGetNextListPosStartResult(bAPFunctionMethodFSG, (GetNextListPos_StartResult)startResultMethod);
                break;
            }
            default: {
                this.logChannel.log(10000, "AbstractBAPIndicationHandlerPhone#processIndicationStartResult not implemented for fctID=%1", (Object)bAPFunctionMethodFSG.getFctIDDescription());
            }
        }
    }

    @Override
    public void processIndicationAbort(BAPFunctionMethodFSG bAPFunctionMethodFSG) {
        switch (bAPFunctionMethodFSG.getFctID()) {
            case 26: {
                this.processDialNumberAbort(bAPFunctionMethodFSG);
                break;
            }
            case 27: {
                this.processDialServiceAbort(bAPFunctionMethodFSG);
                break;
            }
            case 28: {
                this.processConfirmEmergencyCallAbort(bAPFunctionMethodFSG);
                break;
            }
            case 29: {
                this.processHangupCallAbort(bAPFunctionMethodFSG);
                break;
            }
            case 30: {
                this.processAcceptCallAbort(bAPFunctionMethodFSG);
                break;
            }
            case 31: {
                this.processCallHoldAbort(bAPFunctionMethodFSG);
                break;
            }
            case 32: {
                this.processResumeCallAbort(bAPFunctionMethodFSG);
                break;
            }
            case 35: {
                this.processMpRelActiveCallAcceptWcAbort(bAPFunctionMethodFSG);
                break;
            }
            case 36: {
                this.processMpSwapAbort(bAPFunctionMethodFSG);
                break;
            }
            case 37: {
                this.processMpCallHoldAcceptWcAbort(bAPFunctionMethodFSG);
                break;
            }
            case 38: {
                this.processMpRelAllCallsAcceptWcAbort(bAPFunctionMethodFSG);
                break;
            }
            case 39: {
                this.processMpSetWaitingCallOnHoldAbort(bAPFunctionMethodFSG);
                break;
            }
            case 40: {
                this.processCcJoinAbort(bAPFunctionMethodFSG);
                break;
            }
            case 41: {
                this.processCcSplitAbort(bAPFunctionMethodFSG);
                break;
            }
            case 50: {
                this.processCallStackDeleteAllAbort(bAPFunctionMethodFSG);
                break;
            }
            case 53: {
                this.processPbSpellerAbort(bAPFunctionMethodFSG);
                break;
            }
            case 54: {
                this.processGetNextListPosAbort(bAPFunctionMethodFSG);
                break;
            }
            default: {
                this.logChannel.log(10000, "AbstractBAPIndicationHandlerPhone#processIndicationAbort not implemented for fctID=%1", (Object)bAPFunctionMethodFSG.getFctIDDescription());
            }
        }
    }

    @Override
    public void processIndicationSet(BAPFunctionPropertyFSG bAPFunctionPropertyFSG, SetGetProperty setGetProperty) {
        switch (bAPFunctionPropertyFSG.getFctID()) {
            default: 
        }
        this.logChannel.log(10000, "AbstractBAPIndicationHandlerPhone#processIndicationSet not implemented for fctID=%1", (Object)bAPFunctionPropertyFSG.getFctIDDescription());
    }

    @Override
    public void processIndicationSetGet(BAPFunctionPropertyFSG bAPFunctionPropertyFSG, SetGetProperty setGetProperty) {
        switch (bAPFunctionPropertyFSG.getFctID()) {
            case 33: {
                this.processHandsFreeOnOffSetGet(bAPFunctionPropertyFSG, (HandsFreeOnOff_SetGet)setGetProperty);
                break;
            }
            case 34: {
                this.processMicroMuteOnOffSetGet(bAPFunctionPropertyFSG, (MicroMuteOnOff_SetGet)setGetProperty);
                break;
            }
            case 45: {
                this.processMissedCallIndicationSetGet(bAPFunctionPropertyFSG, (MissedCallIndication_SetGet)setGetProperty);
                break;
            }
            case 55: {
                this.processSmsStateSetGet(bAPFunctionPropertyFSG, (SMSState_SetGet)setGetProperty);
                break;
            }
            case 56: {
                this.processRingToneMuteOnOffSetGet(bAPFunctionPropertyFSG, (RingToneMuteOnOff_SetGet)setGetProperty);
                break;
            }
            case 57: {
                this.processAutomaticRedialSetGet(bAPFunctionPropertyFSG, (AutomaticRedial_SetGet)setGetProperty);
                break;
            }
            default: {
                this.logChannel.log(10000, "AbstractBAPIndicationHandlerPhone#processIndicationSetGet not implemented for fctID=%1", (Object)bAPFunctionPropertyFSG.getFctIDDescription());
            }
        }
    }

    @Override
    public void processIndicationAck(BAPFunctionPropertyFSG bAPFunctionPropertyFSG, AckProperty ackProperty) {
        switch (bAPFunctionPropertyFSG.getFctID()) {
            default: 
        }
        this.logChannel.log(10000, "AbstractBAPIndicationHandlerPhone#processIndicationAck not implemented for fctID=%1", (Object)bAPFunctionPropertyFSG.getFctIDDescription());
    }

    @Override
    public void processIndicationAckArray(BAPFunctionArrayFSG bAPFunctionArrayFSG, BAPArray bAPArray) {
        switch (bAPFunctionArrayFSG.getFctID()) {
            default: 
        }
        this.logChannel.log(10000, "AbstractBAPIndicationHandlerPhone#processIndicationAck not implemented for fctID=%1", (Object)bAPFunctionArrayFSG.getFctIDDescription());
    }

    @Override
    public void processIndicationSetArray(BAPFunctionArrayFSG bAPFunctionArrayFSG, SetGetArray setGetArray) {
        switch (bAPFunctionArrayFSG.getFctID()) {
            default: 
        }
        this.logChannel.log(10000, "AbstractBAPIndicationHandlerPhone#processIndicationSetArray not implemented for fctID=%1", (Object)bAPFunctionArrayFSG.getFctIDDescription());
    }

    @Override
    public void processIndicationSetGetArray(BAPFunctionArrayFSG bAPFunctionArrayFSG, SetGetArray setGetArray) {
        switch (bAPFunctionArrayFSG.getFctID()) {
            case 46: {
                this.processMissedCallsSetGetArray(bAPFunctionArrayFSG, (MissedCalls_SetGetArray)setGetArray);
                break;
            }
            case 47: {
                this.processReceivedCallsSetGetArray(bAPFunctionArrayFSG, (ReceivedCalls_SetGetArray)setGetArray);
                break;
            }
            case 48: {
                this.processDialedNumbersSetGetArray(bAPFunctionArrayFSG, (DialedNumbers_SetGetArray)setGetArray);
                break;
            }
            case 49: {
                this.processCombinedNumbersSetGetArray(bAPFunctionArrayFSG, (CombinedNumbers_SetGetArray)setGetArray);
                break;
            }
            case 60: {
                this.processFavoriteListSetGetArray(bAPFunctionArrayFSG, (FavoriteList_SetGetArray)setGetArray);
                break;
            }
            default: {
                this.logChannel.log(10000, "AbstractBAPIndicationHandlerPhone#processIndicationSetGetArray not implemented for fctID=%1", (Object)bAPFunctionArrayFSG.getFctIDDescription());
            }
        }
    }

    protected abstract void processDialNumberAbort(BAPFunctionMethodFSG bAPFunctionMethodFSG) {
    }

    protected abstract void processDialNumberStartResult(BAPFunctionMethodFSG bAPFunctionMethodFSG, DialNumber_StartResult dialNumber_StartResult) {
    }

    protected abstract void processDialServiceAbort(BAPFunctionMethodFSG bAPFunctionMethodFSG) {
    }

    protected abstract void processDialServiceStartResult(BAPFunctionMethodFSG bAPFunctionMethodFSG, DialService_StartResult dialService_StartResult) {
    }

    protected abstract void processConfirmEmergencyCallAbort(BAPFunctionMethodFSG bAPFunctionMethodFSG) {
    }

    protected abstract void processConfirmEmergencyCallStartResult(BAPFunctionMethodFSG bAPFunctionMethodFSG, ConfirmEmergencyCall_StartResult confirmEmergencyCall_StartResult) {
    }

    protected abstract void processHangupCallAbort(BAPFunctionMethodFSG bAPFunctionMethodFSG) {
    }

    protected abstract void processHangupCallStartResult(BAPFunctionMethodFSG bAPFunctionMethodFSG, HangupCall_StartResult hangupCall_StartResult) {
    }

    protected abstract void processAcceptCallAbort(BAPFunctionMethodFSG bAPFunctionMethodFSG) {
    }

    protected abstract void processAcceptCallStartResult(BAPFunctionMethodFSG bAPFunctionMethodFSG) {
    }

    protected abstract void processCallHoldAbort(BAPFunctionMethodFSG bAPFunctionMethodFSG) {
    }

    protected abstract void processCallHoldStartResult(BAPFunctionMethodFSG bAPFunctionMethodFSG) {
    }

    protected abstract void processResumeCallAbort(BAPFunctionMethodFSG bAPFunctionMethodFSG) {
    }

    protected abstract void processResumeCallStartResult(BAPFunctionMethodFSG bAPFunctionMethodFSG) {
    }

    protected abstract void processHandsFreeOnOffSetGet(BAPFunctionPropertyFSG bAPFunctionPropertyFSG, HandsFreeOnOff_SetGet handsFreeOnOff_SetGet) {
    }

    protected abstract void processMicroMuteOnOffSetGet(BAPFunctionPropertyFSG bAPFunctionPropertyFSG, MicroMuteOnOff_SetGet microMuteOnOff_SetGet) {
    }

    protected abstract void processMpRelActiveCallAcceptWcAbort(BAPFunctionMethodFSG bAPFunctionMethodFSG) {
    }

    protected abstract void processMpRelActiveCallAcceptWcStartResult(BAPFunctionMethodFSG bAPFunctionMethodFSG) {
    }

    protected abstract void processMpSwapAbort(BAPFunctionMethodFSG bAPFunctionMethodFSG) {
    }

    protected abstract void processMpSwapStartResult(BAPFunctionMethodFSG bAPFunctionMethodFSG) {
    }

    protected abstract void processMpCallHoldAcceptWcAbort(BAPFunctionMethodFSG bAPFunctionMethodFSG) {
    }

    protected abstract void processMpCallHoldAcceptWcStartResult(BAPFunctionMethodFSG bAPFunctionMethodFSG) {
    }

    protected abstract void processMpRelAllCallsAcceptWcAbort(BAPFunctionMethodFSG bAPFunctionMethodFSG) {
    }

    protected abstract void processMpRelAllCallsAcceptWcStartResult(BAPFunctionMethodFSG bAPFunctionMethodFSG) {
    }

    protected abstract void processMpSetWaitingCallOnHoldAbort(BAPFunctionMethodFSG bAPFunctionMethodFSG) {
    }

    protected abstract void processMpSetWaitingCallOnHoldStartResult(BAPFunctionMethodFSG bAPFunctionMethodFSG) {
    }

    protected abstract void processCcJoinAbort(BAPFunctionMethodFSG bAPFunctionMethodFSG) {
    }

    protected abstract void processCcJoinStartResult(BAPFunctionMethodFSG bAPFunctionMethodFSG) {
    }

    protected abstract void processCcSplitAbort(BAPFunctionMethodFSG bAPFunctionMethodFSG) {
    }

    protected abstract void processCcSplitStartResult(BAPFunctionMethodFSG bAPFunctionMethodFSG, CCSplit_StartResult cCSplit_StartResult) {
    }

    protected abstract void processMissedCallIndicationSetGet(BAPFunctionPropertyFSG bAPFunctionPropertyFSG, MissedCallIndication_SetGet missedCallIndication_SetGet) {
    }

    protected abstract void processMissedCallsSetGetArray(BAPFunctionArrayFSG bAPFunctionArrayFSG, MissedCalls_SetGetArray missedCalls_SetGetArray) {
    }

    protected abstract void processReceivedCallsSetGetArray(BAPFunctionArrayFSG bAPFunctionArrayFSG, ReceivedCalls_SetGetArray receivedCalls_SetGetArray) {
    }

    protected abstract void processDialedNumbersSetGetArray(BAPFunctionArrayFSG bAPFunctionArrayFSG, DialedNumbers_SetGetArray dialedNumbers_SetGetArray) {
    }

    protected abstract void processCombinedNumbersSetGetArray(BAPFunctionArrayFSG bAPFunctionArrayFSG, CombinedNumbers_SetGetArray combinedNumbers_SetGetArray) {
    }

    protected abstract void processCallStackDeleteAllAbort(BAPFunctionMethodFSG bAPFunctionMethodFSG) {
    }

    protected abstract void processCallStackDeleteAllStartResult(BAPFunctionMethodFSG bAPFunctionMethodFSG, CallStackDeleteAll_StartResult callStackDeleteAll_StartResult) {
    }

    protected abstract void processPbSpellerAbort(BAPFunctionMethodFSG bAPFunctionMethodFSG) {
    }

    protected abstract void processPbSpellerStartResult(BAPFunctionMethodFSG bAPFunctionMethodFSG, PbSpeller_StartResult pbSpeller_StartResult) {
    }

    protected abstract void processGetNextListPosAbort(BAPFunctionMethodFSG bAPFunctionMethodFSG) {
    }

    protected abstract void processGetNextListPosStartResult(BAPFunctionMethodFSG bAPFunctionMethodFSG, GetNextListPos_StartResult getNextListPos_StartResult) {
    }

    protected abstract void processSmsStateSetGet(BAPFunctionPropertyFSG bAPFunctionPropertyFSG, SMSState_SetGet sMSState_SetGet) {
    }

    protected abstract void processRingToneMuteOnOffSetGet(BAPFunctionPropertyFSG bAPFunctionPropertyFSG, RingToneMuteOnOff_SetGet ringToneMuteOnOff_SetGet) {
    }

    protected abstract void processAutomaticRedialSetGet(BAPFunctionPropertyFSG bAPFunctionPropertyFSG, AutomaticRedial_SetGet automaticRedial_SetGet) {
    }

    protected abstract void processFavoriteListSetGetArray(BAPFunctionArrayFSG bAPFunctionArrayFSG, FavoriteList_SetGetArray favoriteList_SetGetArray) {
    }
}

