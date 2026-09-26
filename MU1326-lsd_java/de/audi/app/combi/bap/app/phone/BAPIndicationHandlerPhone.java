/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.app.phone;

import de.audi.app.bap.fw.AbstractBAPModuleFSG;
import de.audi.app.bap.fw.arrays.ArrayHandler;
import de.audi.app.bap.fw.arrays.ArrayHeaderBAP;
import de.audi.app.bap.fw.arrays.GetArrayIndication;
import de.audi.app.bap.fw.functiontypes.AbstractBAPFunction;
import de.audi.app.bap.fw.functiontypes.BAPFunctionArrayFSG;
import de.audi.app.bap.fw.functiontypes.BAPFunctionMethodFSG;
import de.audi.app.bap.fw.functiontypes.BAPFunctionPropertyFSG;
import de.audi.app.bap.generated.phone.AbstractBAPIndicationHandlerPhone;
import de.audi.app.bap.utils.FunctionIDs;
import de.audi.app.combi.bap.app.phone.CombiModulePhone;
import de.audi.app.combi.bap.app.phone.list.CombinedNumbersListHandler;
import de.audi.atip.interapp.combi.bap.data.CombiBAPArrayElement;
import de.audi.atip.interapp.combi.bap.phone.CombiBAPServiceAddressBookListener;
import de.audi.atip.interapp.combi.bap.phone.CombiBAPServiceMessagingListener;
import de.audi.atip.interapp.combi.bap.phone.CombiBAPServicePhoneListener;
import de.audi.atip.interapp.combi.bap.phone.data.CombiBAPCallStackEntry;
import de.vw.mib.bap.generated.telephone.serializer.AcceptCall_Result;
import de.vw.mib.bap.generated.telephone.serializer.AutomaticRedial_SetGet;
import de.vw.mib.bap.generated.telephone.serializer.CCJoin_Result;
import de.vw.mib.bap.generated.telephone.serializer.CCSplit_Result;
import de.vw.mib.bap.generated.telephone.serializer.CCSplit_StartResult;
import de.vw.mib.bap.generated.telephone.serializer.CallHold_Result;
import de.vw.mib.bap.generated.telephone.serializer.CallStackDeleteAll_StartResult;
import de.vw.mib.bap.generated.telephone.serializer.CombinedNumbers_GetArray;
import de.vw.mib.bap.generated.telephone.serializer.CombinedNumbers_SetGetArray;
import de.vw.mib.bap.generated.telephone.serializer.ConfirmEmergencyCall_Result;
import de.vw.mib.bap.generated.telephone.serializer.ConfirmEmergencyCall_StartResult;
import de.vw.mib.bap.generated.telephone.serializer.DialNumber_Result;
import de.vw.mib.bap.generated.telephone.serializer.DialNumber_StartResult;
import de.vw.mib.bap.generated.telephone.serializer.DialService_Result;
import de.vw.mib.bap.generated.telephone.serializer.DialService_StartResult;
import de.vw.mib.bap.generated.telephone.serializer.DialedNumbers_GetArray;
import de.vw.mib.bap.generated.telephone.serializer.DialedNumbers_SetGetArray;
import de.vw.mib.bap.generated.telephone.serializer.FavoriteList_GetArray;
import de.vw.mib.bap.generated.telephone.serializer.FavoriteList_SetGetArray;
import de.vw.mib.bap.generated.telephone.serializer.GetNextListPos_Result;
import de.vw.mib.bap.generated.telephone.serializer.GetNextListPos_StartResult;
import de.vw.mib.bap.generated.telephone.serializer.HandsFreeOnOff_SetGet;
import de.vw.mib.bap.generated.telephone.serializer.HangupCall_Result;
import de.vw.mib.bap.generated.telephone.serializer.HangupCall_StartResult;
import de.vw.mib.bap.generated.telephone.serializer.MPCallHoldAcceptWC_Result;
import de.vw.mib.bap.generated.telephone.serializer.MPRelActiveCallAcceptWC_Result;
import de.vw.mib.bap.generated.telephone.serializer.MPRelAllCallsAcceptWC_Result;
import de.vw.mib.bap.generated.telephone.serializer.MPSetWaitingCallOnHold_Result;
import de.vw.mib.bap.generated.telephone.serializer.MPSwap_Result;
import de.vw.mib.bap.generated.telephone.serializer.MicroMuteOnOff_SetGet;
import de.vw.mib.bap.generated.telephone.serializer.MicroMuteOnOff_Status;
import de.vw.mib.bap.generated.telephone.serializer.MissedCallIndication_SetGet;
import de.vw.mib.bap.generated.telephone.serializer.MissedCalls_GetArray;
import de.vw.mib.bap.generated.telephone.serializer.MissedCalls_SetGetArray;
import de.vw.mib.bap.generated.telephone.serializer.PbSpeller_Result;
import de.vw.mib.bap.generated.telephone.serializer.PbSpeller_StartResult;
import de.vw.mib.bap.generated.telephone.serializer.Phonebook_GetArray;
import de.vw.mib.bap.generated.telephone.serializer.ReceivedCalls_GetArray;
import de.vw.mib.bap.generated.telephone.serializer.ReceivedCalls_SetGetArray;
import de.vw.mib.bap.generated.telephone.serializer.ResumeCall_Result;
import de.vw.mib.bap.generated.telephone.serializer.RingToneMuteOnOff_SetGet;
import de.vw.mib.bap.generated.telephone.serializer.SMSState_SetGet;
import de.vw.mib.bap.requests.GetArray;
import de.vw.mib.bap.requests.ResultMethod;

public class BAPIndicationHandlerPhone
extends AbstractBAPIndicationHandlerPhone {
    protected BAPIndicationHandlerPhone(CombiModulePhone combiModulePhone) {
        super(combiModulePhone, combiModulePhone.getLogChannel());
    }

    private CombiBAPServicePhoneListener getPhoneService() {
        return ((CombiModulePhone)this.module).getPhoneServiceListener();
    }

    private CombiBAPServiceAddressBookListener getAddressbookService() {
        return ((CombiModulePhone)this.module).getAddressbookServiceListener();
    }

    private CombiBAPServiceMessagingListener getMessagingService() {
        return ((CombiModulePhone)this.module).getMessagingServiceListener();
    }

    @Override
    public GetArrayIndication evaluateGetArrayIndication(int n, GetArray getArray) {
        GetArrayIndication getArrayIndication = null;
        switch (n) {
            case 46: {
                MissedCalls_GetArray missedCalls_GetArray = (MissedCalls_GetArray)getArray;
                getArrayIndication = new GetArrayIndication(missedCalls_GetArray.asg_Id, missedCalls_GetArray.taid, new ArrayHeaderBAP(missedCalls_GetArray.getArrayHeader()));
                break;
            }
            case 47: {
                ReceivedCalls_GetArray receivedCalls_GetArray = (ReceivedCalls_GetArray)getArray;
                getArrayIndication = new GetArrayIndication(receivedCalls_GetArray.asg_Id, receivedCalls_GetArray.taid, new ArrayHeaderBAP(receivedCalls_GetArray.getArrayHeader()));
                break;
            }
            case 48: {
                DialedNumbers_GetArray dialedNumbers_GetArray = (DialedNumbers_GetArray)getArray;
                getArrayIndication = new GetArrayIndication(dialedNumbers_GetArray.asg_Id, dialedNumbers_GetArray.taid, new ArrayHeaderBAP(dialedNumbers_GetArray.getArrayHeader()));
                break;
            }
            case 49: {
                CombinedNumbers_GetArray combinedNumbers_GetArray = (CombinedNumbers_GetArray)getArray;
                getArrayIndication = new GetArrayIndication(combinedNumbers_GetArray.asg_Id, combinedNumbers_GetArray.taid, new ArrayHeaderBAP(combinedNumbers_GetArray.getArrayHeader()));
                break;
            }
            case 52: {
                Phonebook_GetArray phonebook_GetArray = (Phonebook_GetArray)getArray;
                getArrayIndication = new GetArrayIndication(phonebook_GetArray.asg_Id, phonebook_GetArray.taid, new ArrayHeaderBAP(phonebook_GetArray.getArrayHeader()));
                break;
            }
            case 60: {
                FavoriteList_GetArray favoriteList_GetArray = (FavoriteList_GetArray)getArray;
                getArrayIndication = new GetArrayIndication(favoriteList_GetArray.asg_Id, favoriteList_GetArray.taid, new ArrayHeaderBAP(favoriteList_GetArray.getArrayHeader()));
                break;
            }
            default: {
                this.logChannel.log(10000, "[BAPIndicationHandlerPhone#evaluateGetArrayIndication] function is not an array or not supported yet (%1)", (Object)FunctionIDs.getDescription(this.lsgID, n));
            }
        }
        return getArrayIndication;
    }

    @Override
    protected void processDialNumberAbort(BAPFunctionMethodFSG bAPFunctionMethodFSG) {
        this.logChannel.log(-2137614336, "[BAPIndicationHandlerPhone#processDialNumberAbort] Method can't be aborted: %1", (Object)bAPFunctionMethodFSG.getFctIDDescription());
        DialNumber_Result dialNumber_Result = (DialNumber_Result)((CombiModulePhone)this.module).createResultSerializer(26);
        dialNumber_Result.dialNumber_Result = 3;
        bAPFunctionMethodFSG.resultAbortNotSuccessfulREQ(dialNumber_Result);
    }

    @Override
    protected void processDialNumberStartResult(BAPFunctionMethodFSG bAPFunctionMethodFSG, DialNumber_StartResult dialNumber_StartResult) {
        String string = dialNumber_StartResult.telNumber.toString();
        String string2 = dialNumber_StartResult.name.toString();
        this.logChannel.log(-2137614336, "[BAPIndicationHandlerPhone#processDialNumberStartResult] number=%1, name=%2", (Object)string, (Object)string2);
        boolean bl = false;
        CombiBAPCallStackEntry combiBAPCallStackEntry = null;
        ArrayHandler arrayHandler = ((CombiModulePhone)this.module).getBAPFunctionArrayFSG(49).getArrayHandler();
        CombiBAPArrayElement[] combiBAPArrayElementArray = ((CombinedNumbersListHandler)arrayHandler).getManagedList();
        for (int i2 = 0; i2 < combiBAPArrayElementArray.length; ++i2) {
            CombiBAPCallStackEntry combiBAPCallStackEntry2 = (CombiBAPCallStackEntry)combiBAPArrayElementArray[i2];
            if (combiBAPCallStackEntry2 == null || !string.equals(combiBAPCallStackEntry2.getTelNumber()) || !string2.equals(combiBAPCallStackEntry2.getPbName())) continue;
            bl = true;
            combiBAPCallStackEntry = combiBAPCallStackEntry2;
            break;
        }
        if (bl) {
            this.getPhoneService().dialNumberFromAdbEntry(string, string2, combiBAPCallStackEntry);
        } else {
            this.getPhoneService().dialNumber(string, string2);
        }
    }

    @Override
    protected void processDialServiceAbort(BAPFunctionMethodFSG bAPFunctionMethodFSG) {
        this.logChannel.log(-2137614336, "[BAPIndicationHandlerPhone#processDialServiceAbort] Method can't be aborted: %1", (Object)bAPFunctionMethodFSG.getFctIDDescription());
        DialService_Result dialService_Result = (DialService_Result)((CombiModulePhone)this.module).createResultSerializer(27);
        dialService_Result.dialService_Result = 3;
        bAPFunctionMethodFSG.resultAbortNotSuccessfulREQ(dialService_Result);
    }

    @Override
    protected void processDialServiceStartResult(BAPFunctionMethodFSG bAPFunctionMethodFSG, DialService_StartResult dialService_StartResult) {
        this.logChannel.log(-2137614336, "[BAPIndicationHandlerPhone#processDialServiceStartResult] call phone service 'dialService( serviceType=%1 )'", (long)dialService_StartResult.serviceType);
        if (BAPIndicationHandlerPhone.reservedValueUsed(dialService_StartResult)) {
            this.logChannel.log(10000, "[BAPIndicationHandlerPhone#processDialServiceStartResult] Reserved Value Used. serializer: %1", (Object)dialService_StartResult);
            this.sendAppErrorOutOfRange(bAPFunctionMethodFSG);
            return;
        }
        this.getPhoneService().dialService(dialService_StartResult.serviceType);
    }

    @Override
    protected void processConfirmEmergencyCallAbort(BAPFunctionMethodFSG bAPFunctionMethodFSG) {
        this.logChannel.log(-2137614336, "[BAPIndicationHandlerPhone#processConfirmErmergencyCallAbort] Method can't be aborted: %1", (Object)bAPFunctionMethodFSG.getFctIDDescription());
        ConfirmEmergencyCall_Result confirmEmergencyCall_Result = (ConfirmEmergencyCall_Result)((CombiModulePhone)this.module).createResultSerializer(28);
        confirmEmergencyCall_Result.confirmErmergencyCall_Result = 3;
        bAPFunctionMethodFSG.resultAbortNotSuccessfulREQ(confirmEmergencyCall_Result);
    }

    @Override
    protected void processConfirmEmergencyCallStartResult(BAPFunctionMethodFSG bAPFunctionMethodFSG, ConfirmEmergencyCall_StartResult confirmEmergencyCall_StartResult) {
        if (BAPIndicationHandlerPhone.reservedValueUsed(confirmEmergencyCall_StartResult)) {
            this.logChannel.log(10000, "[BAPIndicationHandlerPhone#processConfirmEmergencyCallStartResult] Reserved Value Used. serializer: %1", (Object)confirmEmergencyCall_StartResult);
            this.sendAppErrorOutOfRange(bAPFunctionMethodFSG);
            return;
        }
        boolean bl = confirmEmergencyCall_StartResult.control == 0;
        this.logChannel.log(-2137614336, "[BAPIndicationHandlerPhone#processConfirmEmergencyCallStartResult] call phone service 'confirmEmergencyCall( %1 )'", bl);
        this.getPhoneService().confirmEmergencyCall(bl);
    }

    @Override
    protected void processHangupCallAbort(BAPFunctionMethodFSG bAPFunctionMethodFSG) {
        this.logChannel.log(-2137614336, "[BAPIndicationHandlerPhone#processHangupCallAbort] Method can't be aborted: %1", (Object)bAPFunctionMethodFSG.getFctIDDescription());
        HangupCall_Result hangupCall_Result = (HangupCall_Result)((CombiModulePhone)this.module).createResultSerializer(29);
        hangupCall_Result.hangupCall_Result = 3;
        bAPFunctionMethodFSG.resultAbortNotSuccessfulREQ(hangupCall_Result);
    }

    @Override
    protected void processHangupCallStartResult(BAPFunctionMethodFSG bAPFunctionMethodFSG, HangupCall_StartResult hangupCall_StartResult) {
        this.logChannel.log(-2137614336, "[BAPIndicationHandlerPhone#processHangupCallStartResult] call phone service 'hangupCall( callID=%1 )'", (long)hangupCall_StartResult.callId);
        if (BAPIndicationHandlerPhone.reservedValueUsed(hangupCall_StartResult)) {
            this.logChannel.log(10000, "[BAPIndicationHandlerPhone#processHangupCallStartResult] Reserved Value Used. serializer: %1", (Object)hangupCall_StartResult);
            this.sendAppErrorOutOfRange(bAPFunctionMethodFSG);
            return;
        }
        this.getPhoneService().hangupCall(hangupCall_StartResult.callId);
    }

    @Override
    protected void processAcceptCallAbort(BAPFunctionMethodFSG bAPFunctionMethodFSG) {
        this.logChannel.log(-2137614336, "[BAPIndicationHandlerPhone#processAcceptCallAbort] Method can't be aborted: %1", (Object)bAPFunctionMethodFSG.getFctIDDescription());
        AcceptCall_Result acceptCall_Result = new AcceptCall_Result();
        acceptCall_Result.acceptCall_Result = 3;
        bAPFunctionMethodFSG.resultAbortNotSuccessfulREQ(acceptCall_Result);
    }

    @Override
    protected void processAcceptCallStartResult(BAPFunctionMethodFSG bAPFunctionMethodFSG) {
        this.logChannel.log(-2137614336, "[BAPIndicationHandlerPhone#processAcceptCallStartResult] call phone service 'acceptCall'");
        this.getPhoneService().acceptCall();
    }

    @Override
    protected void processCallHoldAbort(BAPFunctionMethodFSG bAPFunctionMethodFSG) {
        this.logChannel.log(-2137614336, "[BAPIndicationHandlerPhone#processCallHoldAbort] Method can't be aborted: %1", (Object)bAPFunctionMethodFSG.getFctIDDescription());
        CallHold_Result callHold_Result = (CallHold_Result)((CombiModulePhone)this.module).createResultSerializer(31);
        callHold_Result.callHold_Result = 3;
        bAPFunctionMethodFSG.resultAbortNotSuccessfulREQ(callHold_Result);
    }

    @Override
    protected void processCallHoldStartResult(BAPFunctionMethodFSG bAPFunctionMethodFSG) {
        this.logChannel.log(-2137614336, "[BAPIndicationHandlerPhone#processCallHoldStartResult] call phone service 'callHold'");
        this.getPhoneService().callHold();
    }

    @Override
    protected void processResumeCallAbort(BAPFunctionMethodFSG bAPFunctionMethodFSG) {
        this.logChannel.log(-2137614336, "[BAPIndicationHandlerPhone#processResumeCallAbort] Method can't be aborted: %1", (Object)bAPFunctionMethodFSG.getFctIDDescription());
        ResumeCall_Result resumeCall_Result = (ResumeCall_Result)((CombiModulePhone)this.module).createResultSerializer(32);
        resumeCall_Result.resumeCall_Result = 3;
        bAPFunctionMethodFSG.resultAbortNotSuccessfulREQ(resumeCall_Result);
    }

    @Override
    protected void processResumeCallStartResult(BAPFunctionMethodFSG bAPFunctionMethodFSG) {
        this.logChannel.log(-2137614336, "[BAPIndicationHandlerPhone#processResumeCallStartResult] call phone service 'resumeCall'");
        this.getPhoneService().resumeCall();
    }

    @Override
    protected void processHandsFreeOnOffSetGet(BAPFunctionPropertyFSG bAPFunctionPropertyFSG, HandsFreeOnOff_SetGet handsFreeOnOff_SetGet) {
        bAPFunctionPropertyFSG.functionNotSupported();
    }

    @Override
    protected void processMicroMuteOnOffSetGet(BAPFunctionPropertyFSG bAPFunctionPropertyFSG, MicroMuteOnOff_SetGet microMuteOnOff_SetGet) {
        MicroMuteOnOff_Status microMuteOnOff_Status = (MicroMuteOnOff_Status)bAPFunctionPropertyFSG.getLastStatus();
        if (microMuteOnOff_SetGet.microMuteOnOff.on == microMuteOnOff_Status.microMuteOnOff.on) {
            this.logChannel.log(-2137614336, "[BAPIndicationHandlerPhone#processMicroMuteOnOffSetGet] micMuteStatus (on=%1) is already set", microMuteOnOff_SetGet.microMuteOnOff.on);
            bAPFunctionPropertyFSG.resendLastStatus();
        } else {
            this.logChannel.log(-2137614336, "[BAPIndicationHandlerPhone#processMicroMuteOnOffSetGet] call phone service 'setMicMuteState( on=%1 )'", microMuteOnOff_SetGet.microMuteOnOff.on);
            this.getPhoneService().setMicMuteState(microMuteOnOff_SetGet.microMuteOnOff.on);
        }
    }

    @Override
    protected void processMpRelActiveCallAcceptWcAbort(BAPFunctionMethodFSG bAPFunctionMethodFSG) {
        this.logChannel.log(-2137614336, "[BAPIndicationHandlerPhone#processMpRelActiveCallAcceptWcAbort] Method can't be aborted: %1", (Object)bAPFunctionMethodFSG.getFctIDDescription());
        MPRelActiveCallAcceptWC_Result mPRelActiveCallAcceptWC_Result = (MPRelActiveCallAcceptWC_Result)((CombiModulePhone)this.module).createResultSerializer(35);
        mPRelActiveCallAcceptWC_Result.mpracawc_Result = 3;
        bAPFunctionMethodFSG.resultAbortNotSuccessfulREQ(mPRelActiveCallAcceptWC_Result);
    }

    @Override
    protected void processMpRelActiveCallAcceptWcStartResult(BAPFunctionMethodFSG bAPFunctionMethodFSG) {
        this.logChannel.log(-2137614336, "[BAPIndicationHandlerPhone#processMpRelActiveCallAcceptWcStartResult] call phone service 'releaseActiveCallAcceptWaitingCall'");
        this.getPhoneService().releaseActiveCallAcceptWaitingCall();
    }

    @Override
    protected void processMpSwapAbort(BAPFunctionMethodFSG bAPFunctionMethodFSG) {
        this.logChannel.log(-2137614336, "[BAPIndicationHandlerPhone#processMpswapAbort] Method can't be aborted: %1", (Object)bAPFunctionMethodFSG.getFctIDDescription());
        MPSwap_Result mPSwap_Result = (MPSwap_Result)((CombiModulePhone)this.module).createResultSerializer(36);
        mPSwap_Result.mpswap_Result = 3;
        bAPFunctionMethodFSG.resultAbortNotSuccessfulREQ(mPSwap_Result);
    }

    @Override
    protected void processMpSwapStartResult(BAPFunctionMethodFSG bAPFunctionMethodFSG) {
        this.logChannel.log(-2137614336, "[BAPIndicationHandlerPhone#processMpswapStartResult] call phone service 'swapCalls'");
        this.getPhoneService().swapCalls();
    }

    @Override
    protected void processMpCallHoldAcceptWcAbort(BAPFunctionMethodFSG bAPFunctionMethodFSG) {
        this.logChannel.log(-2137614336, "[BAPIndicationHandlerPhone#processMpCallHoldAcceptWcAbort] Method can't be aborted: %1", (Object)bAPFunctionMethodFSG.getFctIDDescription());
        MPCallHoldAcceptWC_Result mPCallHoldAcceptWC_Result = (MPCallHoldAcceptWC_Result)((CombiModulePhone)this.module).createResultSerializer(37);
        mPCallHoldAcceptWC_Result.mpchawc_Result = 3;
        bAPFunctionMethodFSG.resultAbortNotSuccessfulREQ(mPCallHoldAcceptWC_Result);
    }

    @Override
    protected void processMpCallHoldAcceptWcStartResult(BAPFunctionMethodFSG bAPFunctionMethodFSG) {
        this.logChannel.log(-2137614336, "[BAPIndicationHandlerPhone#processMpCallHoldAcceptWcStartResult] call phone service 'callHoldAcceptWaitingCall'");
        this.getPhoneService().callHoldAcceptWaitingCall();
    }

    @Override
    protected void processMpRelAllCallsAcceptWcAbort(BAPFunctionMethodFSG bAPFunctionMethodFSG) {
        this.logChannel.log(-2137614336, "[BAPIndicationHandlerPhone#processMpRelAllCallsAcceptWcAbort] Method can't be aborted: %1", (Object)bAPFunctionMethodFSG.getFctIDDescription());
        MPRelAllCallsAcceptWC_Result mPRelAllCallsAcceptWC_Result = (MPRelAllCallsAcceptWC_Result)((CombiModulePhone)this.module).createResultSerializer(38);
        mPRelAllCallsAcceptWC_Result.mpracawc_Result = 3;
        bAPFunctionMethodFSG.resultAbortNotSuccessfulREQ(mPRelAllCallsAcceptWC_Result);
    }

    @Override
    protected void processMpRelAllCallsAcceptWcStartResult(BAPFunctionMethodFSG bAPFunctionMethodFSG) {
        this.logChannel.log(-2137614336, "[BAPIndicationHandlerPhone#processMpRelAllCallsAcceptWcStartResult] call phone service 'releaseAllCallsAcceptWaitingCall'");
        this.getPhoneService().releaseAllCallsAcceptWaitingCall();
    }

    @Override
    protected void processMpSetWaitingCallOnHoldAbort(BAPFunctionMethodFSG bAPFunctionMethodFSG) {
        this.logChannel.log(-2137614336, "[BAPIndicationHandlerPhone#processMpsetWaitingCallOnHoldAbort] Method can't be aborted: %1", (Object)bAPFunctionMethodFSG.getFctIDDescription());
        MPSetWaitingCallOnHold_Result mPSetWaitingCallOnHold_Result = (MPSetWaitingCallOnHold_Result)((CombiModulePhone)this.module).createResultSerializer(39);
        mPSetWaitingCallOnHold_Result.mpswcoh_Result = 3;
        bAPFunctionMethodFSG.resultAbortNotSuccessfulREQ(mPSetWaitingCallOnHold_Result);
    }

    @Override
    protected void processMpSetWaitingCallOnHoldStartResult(BAPFunctionMethodFSG bAPFunctionMethodFSG) {
        this.logChannel.log(-2137614336, "[BAPIndicationHandlerPhone#processMpsetWaitingCallOnHoldStartResult] call phone service 'setWaitingCallOnHold'");
        this.getPhoneService().setWaitingCallOnHold();
    }

    @Override
    protected void processCcJoinAbort(BAPFunctionMethodFSG bAPFunctionMethodFSG) {
        this.logChannel.log(-2137614336, "[BAPIndicationHandlerPhone#processCcjoinAbort] Method can't be aborted: %1", (Object)bAPFunctionMethodFSG.getFctIDDescription());
        CCJoin_Result cCJoin_Result = (CCJoin_Result)((CombiModulePhone)this.module).createResultSerializer(40);
        cCJoin_Result.ccjoin_Result = 3;
        bAPFunctionMethodFSG.resultAbortNotSuccessfulREQ(cCJoin_Result);
    }

    @Override
    protected void processCcJoinStartResult(BAPFunctionMethodFSG bAPFunctionMethodFSG) {
        this.logChannel.log(-2137614336, "[BAPIndicationHandlerPhone#processCcjoinStartResult] call phone service 'joinCalls'");
        this.getPhoneService().joinCalls();
    }

    @Override
    protected void processCcSplitAbort(BAPFunctionMethodFSG bAPFunctionMethodFSG) {
        this.logChannel.log(-2137614336, "[BAPIndicationHandlerPhone#processCcSplitAbort] Method can't be aborted: %1", (Object)bAPFunctionMethodFSG.getFctIDDescription());
        CCSplit_Result cCSplit_Result = (CCSplit_Result)((CombiModulePhone)this.module).createResultSerializer(41);
        cCSplit_Result.ccsplit_Result = 3;
        bAPFunctionMethodFSG.resultAbortNotSuccessfulREQ(cCSplit_Result);
    }

    @Override
    protected void processCcSplitStartResult(BAPFunctionMethodFSG bAPFunctionMethodFSG, CCSplit_StartResult cCSplit_StartResult) {
        if (BAPIndicationHandlerPhone.reservedValueUsed(cCSplit_StartResult)) {
            this.logChannel.log(10000, "[BAPIndicationHandlerPhone#processCcSplitStartResult] Reserved Value Used. serializer: %1", (Object)cCSplit_StartResult);
            this.sendAppErrorOutOfRange(bAPFunctionMethodFSG);
            return;
        }
        this.logChannel.log(-2137614336, "[BAPIndicationHandlerPhone#processCcSplitStartResult] serializer.callId: %1", (long)cCSplit_StartResult.callId);
        this.getPhoneService().splitCall(cCSplit_StartResult.callId);
    }

    @Override
    protected void processMissedCallIndicationSetGet(BAPFunctionPropertyFSG bAPFunctionPropertyFSG, MissedCallIndication_SetGet missedCallIndication_SetGet) {
        this.logChannel.log(-2137614336, "[BAPIndicationHandlerPhone#processMissedCallIndicationSetGet]  call phone service 'resetMissedCallsIndicator'");
        this.getPhoneService().resetMissedCallsIndicator();
    }

    @Override
    protected void processMissedCallsSetGetArray(BAPFunctionArrayFSG bAPFunctionArrayFSG, MissedCalls_SetGetArray missedCalls_SetGetArray) {
        bAPFunctionArrayFSG.functionNotSupported();
    }

    @Override
    protected void processReceivedCallsSetGetArray(BAPFunctionArrayFSG bAPFunctionArrayFSG, ReceivedCalls_SetGetArray receivedCalls_SetGetArray) {
        bAPFunctionArrayFSG.functionNotSupported();
    }

    @Override
    protected void processDialedNumbersSetGetArray(BAPFunctionArrayFSG bAPFunctionArrayFSG, DialedNumbers_SetGetArray dialedNumbers_SetGetArray) {
        bAPFunctionArrayFSG.functionNotSupported();
    }

    @Override
    protected void processCombinedNumbersSetGetArray(BAPFunctionArrayFSG bAPFunctionArrayFSG, CombinedNumbers_SetGetArray combinedNumbers_SetGetArray) {
        this.logChannel.log(10000, "[BAPIndicationHandlerPhone#processCombinedNumbersSetGetArray] called, not implemented yet");
    }

    @Override
    protected void processCallStackDeleteAllAbort(BAPFunctionMethodFSG bAPFunctionMethodFSG) {
        bAPFunctionMethodFSG.functionNotSupported();
    }

    @Override
    protected void processCallStackDeleteAllStartResult(BAPFunctionMethodFSG bAPFunctionMethodFSG, CallStackDeleteAll_StartResult callStackDeleteAll_StartResult) {
        bAPFunctionMethodFSG.functionNotSupported();
    }

    @Override
    protected void processPbSpellerAbort(BAPFunctionMethodFSG bAPFunctionMethodFSG) {
        this.logChannel.log(-2137614336, "[BAPIndicationHandlerPhone#processPbSpellerAbort] Method can't be aborted: %1", (Object)bAPFunctionMethodFSG.getFctIDDescription());
        PbSpeller_Result pbSpeller_Result = (PbSpeller_Result)((CombiModulePhone)this.module).createResultSerializer(53);
        pbSpeller_Result.pbSpeller_Result = 3;
        bAPFunctionMethodFSG.resultAbortNotSuccessfulREQ(pbSpeller_Result);
    }

    @Override
    protected void processPbSpellerStartResult(BAPFunctionMethodFSG bAPFunctionMethodFSG, PbSpeller_StartResult pbSpeller_StartResult) {
        if (BAPIndicationHandlerPhone.reservedValueUsed(pbSpeller_StartResult)) {
            this.logChannel.log(10000, "[BAPIndicationHandlerPhone#processPbSpellerStartResult] Reserved Value Used. serializer: %1", (Object)pbSpeller_StartResult);
            this.sendAppErrorOutOfRange(bAPFunctionMethodFSG);
            return;
        }
        int n = pbSpeller_StartResult.mode;
        String string = pbSpeller_StartResult.searchString.toString();
        this.logChannel.log(-2137614336, "[BAPIndicationHandlerPhone#processPbSpellerStartResult] call addressbook service 'pbSpeller( mode=%2, searchString=%1 )'", (Object)string, (long)n);
        this.getAddressbookService().pbSpeller(n, string);
    }

    @Override
    protected void processGetNextListPosAbort(BAPFunctionMethodFSG bAPFunctionMethodFSG) {
        this.logChannel.log(-2137614336, "[BAPIndicationHandlerPhone#processGetNextListPosAbort] Method can't be aborted: %1", (Object)bAPFunctionMethodFSG.getFctIDDescription());
        GetNextListPos_Result getNextListPos_Result = (GetNextListPos_Result)((CombiModulePhone)this.module).createResultSerializer(54);
        getNextListPos_Result.getNextListPos_Result = 3;
        bAPFunctionMethodFSG.resultAbortNotSuccessfulREQ(getNextListPos_Result);
    }

    @Override
    protected void processGetNextListPosStartResult(BAPFunctionMethodFSG bAPFunctionMethodFSG, GetNextListPos_StartResult getNextListPos_StartResult) {
        Object object;
        this.logChannel.log(-2137614336, "[BAPIndicationHandlerPhone#processGetNextListPosStartResult] called for listType %1", (long)getNextListPos_StartResult.listType);
        if (BAPIndicationHandlerPhone.reservedValueUsed(getNextListPos_StartResult)) {
            this.logChannel.log(10000, "[BAPIndicationHandlerPhone#processGetNextListPosStartResult] Reserved Value Used. serializer: %1", (Object)getNextListPos_StartResult);
            this.sendAppErrorOutOfRange(bAPFunctionMethodFSG);
            return;
        }
        int n = -1;
        boolean bl = false;
        switch (getNextListPos_StartResult.listType) {
            case 0: {
                n = 52;
                break;
            }
            case 1: {
                n = 49;
                break;
            }
            case 2: {
                n = 60;
                break;
            }
            default: {
                n = -1;
                this.logChannel.log(10000, "[BAPIndicationHandlerPhone#processGetNextListPosStartResult] invalid listType: %1", (long)getNextListPos_StartResult.listType);
                bl = true;
            }
        }
        if (n != -1) {
            object = ((AbstractBAPModuleFSG)this.module).getBAPFunctionArrayFSG(n);
            if (object != null) {
                ArrayHandler arrayHandler = ((BAPFunctionArrayFSG)object).getArrayHandler();
                if (arrayHandler != null) {
                    arrayHandler.getNextListPos(getNextListPos_StartResult.currentPos, (short)getNextListPos_StartResult.offset);
                } else {
                    this.logChannel.log(10000, "[BAPIndicationHandlerPhone#processGetNextListPosStartResult] not arrayHandler found for listType=%1", (long)getNextListPos_StartResult.listType);
                    bl = true;
                }
            } else {
                this.logChannel.log(10000, "[BAPIndicationHandlerPhone#processGetNextListPosStartResult] function for listType=%1 not found", (long)getNextListPos_StartResult.listType);
                bl = true;
            }
        } else {
            this.logChannel.log(10000, "[BAPIndicationHandlerPhone#processGetNextListPosStartResult] invalid listType=%1", (long)getNextListPos_StartResult.listType);
            bl = true;
        }
        if (bl) {
            object = (GetNextListPos_Result)((CombiModulePhone)this.module).createResultSerializer(54);
            ((GetNextListPos_Result)object).getNextListPos_Result = 1;
            ((GetNextListPos_Result)object).currentPos = getNextListPos_StartResult.currentPos;
            ((GetNextListPos_Result)object).nextPos = -65536;
            ((GetNextListPos_Result)object).absoluteListPos = -65536;
            bAPFunctionMethodFSG.resultREQ((ResultMethod)object);
        }
    }

    @Override
    protected void processSmsStateSetGet(BAPFunctionPropertyFSG bAPFunctionPropertyFSG, SMSState_SetGet sMSState_SetGet) {
        this.logChannel.log(-2137614336, "[BAPIndicationHandlerPhone#processSmsStateSetGet] call phone service 'setSMSState( numberOfNewSMS=%1 )'", (long)sMSState_SetGet.numberOfNewSms);
        this.getMessagingService().setSMSState(sMSState_SetGet.numberOfNewSms);
    }

    @Override
    protected void processRingToneMuteOnOffSetGet(BAPFunctionPropertyFSG bAPFunctionPropertyFSG, RingToneMuteOnOff_SetGet ringToneMuteOnOff_SetGet) {
        this.logChannel.log(-2137614336, "[BAPIndicationHandlerPhone#processRingToneMuteOnOffSetGet] call phone service 'setRingToneMuteState( ringToneMuted=%1 )'", ringToneMuteOnOff_SetGet.ringToneMuteOnOff.on);
        this.getPhoneService().setRingToneMuteState(ringToneMuteOnOff_SetGet.ringToneMuteOnOff.on);
    }

    @Override
    protected void processAutomaticRedialSetGet(BAPFunctionPropertyFSG bAPFunctionPropertyFSG, AutomaticRedial_SetGet automaticRedial_SetGet) {
        boolean bl = automaticRedial_SetGet.automaticRedialState.automaticRedialActive;
        this.logChannel.log(-2137614336, "[BAPIndicationHandlerPhone#processAutomaticRedialSetGet] call phone service 'setAutomaticRedialActive( %1 )'", bl);
        this.getPhoneService().setAutomaticRedialActive(bl);
    }

    @Override
    protected void processFavoriteListSetGetArray(BAPFunctionArrayFSG bAPFunctionArrayFSG, FavoriteList_SetGetArray favoriteList_SetGetArray) {
    }

    private static boolean reservedValueUsed(CCSplit_StartResult cCSplit_StartResult) {
        return cCSplit_StartResult.callId >= 7 && cCSplit_StartResult.callId <= 255;
    }

    private static boolean reservedValueUsed(PbSpeller_StartResult pbSpeller_StartResult) {
        return pbSpeller_StartResult.mode >= 3 && pbSpeller_StartResult.mode <= 255;
    }

    private static boolean reservedValueUsed(ConfirmEmergencyCall_StartResult confirmEmergencyCall_StartResult) {
        return confirmEmergencyCall_StartResult.control >= 2 && confirmEmergencyCall_StartResult.control <= 255;
    }

    private static boolean reservedValueUsed(DialService_StartResult dialService_StartResult) {
        return dialService_StartResult.serviceType >= 4 && dialService_StartResult.serviceType <= 255;
    }

    private static boolean reservedValueUsed(GetNextListPos_StartResult getNextListPos_StartResult) {
        return getNextListPos_StartResult.listType >= 3 && getNextListPos_StartResult.listType <= 255;
    }

    private static boolean reservedValueUsed(HangupCall_StartResult hangupCall_StartResult) {
        return hangupCall_StartResult.callId >= 7 && hangupCall_StartResult.callId <= 251;
    }

    private void sendAppErrorOutOfRange(AbstractBAPFunction abstractBAPFunction) {
        this.module.getRequestHandler().requestErrorCode(this.module.getLSGID(), abstractBAPFunction.getFctID(), 65);
        abstractBAPFunction.reset();
    }
}

