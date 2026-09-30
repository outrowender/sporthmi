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

    public void processIndicationSet(BAPFunctionPropertyFSG bAPFunctionPropertyFSG, SetGetProperty setGetProperty) {
        switch (bAPFunctionPropertyFSG.getFctID()) {
            default: 
        }
        this.logChannel.log(10000, "AbstractBAPIndicationHandlerPhone#processIndicationSet not implemented for fctID=%1", (Object)bAPFunctionPropertyFSG.getFctIDDescription());
    }

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

    public void processIndicationAck(BAPFunctionPropertyFSG bAPFunctionPropertyFSG, AckProperty ackProperty) {
        switch (bAPFunctionPropertyFSG.getFctID()) {
            default: 
        }
        this.logChannel.log(10000, "AbstractBAPIndicationHandlerPhone#processIndicationAck not implemented for fctID=%1", (Object)bAPFunctionPropertyFSG.getFctIDDescription());
    }

    public void processIndicationAckArray(BAPFunctionArrayFSG bAPFunctionArrayFSG, BAPArray bAPArray) {
        switch (bAPFunctionArrayFSG.getFctID()) {
            default: 
        }
        this.logChannel.log(10000, "AbstractBAPIndicationHandlerPhone#processIndicationAck not implemented for fctID=%1", (Object)bAPFunctionArrayFSG.getFctIDDescription());
    }

    public void processIndicationSetArray(BAPFunctionArrayFSG bAPFunctionArrayFSG, SetGetArray setGetArray) {
        switch (bAPFunctionArrayFSG.getFctID()) {
            default: 
        }
        this.logChannel.log(10000, "AbstractBAPIndicationHandlerPhone#processIndicationSetArray not implemented for fctID=%1", (Object)bAPFunctionArrayFSG.getFctIDDescription());
    }

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

    protected abstract void processDialNumberAbort(BAPFunctionMethodFSG var1);

    protected abstract void processDialNumberStartResult(BAPFunctionMethodFSG var1, DialNumber_StartResult var2);

    protected abstract void processDialServiceAbort(BAPFunctionMethodFSG var1);

    protected abstract void processDialServiceStartResult(BAPFunctionMethodFSG var1, DialService_StartResult var2);

    protected abstract void processConfirmEmergencyCallAbort(BAPFunctionMethodFSG var1);

    protected abstract void processConfirmEmergencyCallStartResult(BAPFunctionMethodFSG var1, ConfirmEmergencyCall_StartResult var2);

    protected abstract void processHangupCallAbort(BAPFunctionMethodFSG var1);

    protected abstract void processHangupCallStartResult(BAPFunctionMethodFSG var1, HangupCall_StartResult var2);

    protected abstract void processAcceptCallAbort(BAPFunctionMethodFSG var1);

    protected abstract void processAcceptCallStartResult(BAPFunctionMethodFSG var1);

    protected abstract void processCallHoldAbort(BAPFunctionMethodFSG var1);

    protected abstract void processCallHoldStartResult(BAPFunctionMethodFSG var1);

    protected abstract void processResumeCallAbort(BAPFunctionMethodFSG var1);

    protected abstract void processResumeCallStartResult(BAPFunctionMethodFSG var1);

    protected abstract void processHandsFreeOnOffSetGet(BAPFunctionPropertyFSG var1, HandsFreeOnOff_SetGet var2);

    protected abstract void processMicroMuteOnOffSetGet(BAPFunctionPropertyFSG var1, MicroMuteOnOff_SetGet var2);

    protected abstract void processMpRelActiveCallAcceptWcAbort(BAPFunctionMethodFSG var1);

    protected abstract void processMpRelActiveCallAcceptWcStartResult(BAPFunctionMethodFSG var1);

    protected abstract void processMpSwapAbort(BAPFunctionMethodFSG var1);

    protected abstract void processMpSwapStartResult(BAPFunctionMethodFSG var1);

    protected abstract void processMpCallHoldAcceptWcAbort(BAPFunctionMethodFSG var1);

    protected abstract void processMpCallHoldAcceptWcStartResult(BAPFunctionMethodFSG var1);

    protected abstract void processMpRelAllCallsAcceptWcAbort(BAPFunctionMethodFSG var1);

    protected abstract void processMpRelAllCallsAcceptWcStartResult(BAPFunctionMethodFSG var1);

    protected abstract void processMpSetWaitingCallOnHoldAbort(BAPFunctionMethodFSG var1);

    protected abstract void processMpSetWaitingCallOnHoldStartResult(BAPFunctionMethodFSG var1);

    protected abstract void processCcJoinAbort(BAPFunctionMethodFSG var1);

    protected abstract void processCcJoinStartResult(BAPFunctionMethodFSG var1);

    protected abstract void processCcSplitAbort(BAPFunctionMethodFSG var1);

    protected abstract void processCcSplitStartResult(BAPFunctionMethodFSG var1, CCSplit_StartResult var2);

    protected abstract void processMissedCallIndicationSetGet(BAPFunctionPropertyFSG var1, MissedCallIndication_SetGet var2);

    protected abstract void processMissedCallsSetGetArray(BAPFunctionArrayFSG var1, MissedCalls_SetGetArray var2);

    protected abstract void processReceivedCallsSetGetArray(BAPFunctionArrayFSG var1, ReceivedCalls_SetGetArray var2);

    protected abstract void processDialedNumbersSetGetArray(BAPFunctionArrayFSG var1, DialedNumbers_SetGetArray var2);

    protected abstract void processCombinedNumbersSetGetArray(BAPFunctionArrayFSG var1, CombinedNumbers_SetGetArray var2);

    protected abstract void processCallStackDeleteAllAbort(BAPFunctionMethodFSG var1);

    protected abstract void processCallStackDeleteAllStartResult(BAPFunctionMethodFSG var1, CallStackDeleteAll_StartResult var2);

    protected abstract void processPbSpellerAbort(BAPFunctionMethodFSG var1);

    protected abstract void processPbSpellerStartResult(BAPFunctionMethodFSG var1, PbSpeller_StartResult var2);

    protected abstract void processGetNextListPosAbort(BAPFunctionMethodFSG var1);

    protected abstract void processGetNextListPosStartResult(BAPFunctionMethodFSG var1, GetNextListPos_StartResult var2);

    protected abstract void processSmsStateSetGet(BAPFunctionPropertyFSG var1, SMSState_SetGet var2);

    protected abstract void processRingToneMuteOnOffSetGet(BAPFunctionPropertyFSG var1, RingToneMuteOnOff_SetGet var2);

    protected abstract void processAutomaticRedialSetGet(BAPFunctionPropertyFSG var1, AutomaticRedial_SetGet var2);

    protected abstract void processFavoriteListSetGetArray(BAPFunctionArrayFSG var1, FavoriteList_SetGetArray var2);
}

