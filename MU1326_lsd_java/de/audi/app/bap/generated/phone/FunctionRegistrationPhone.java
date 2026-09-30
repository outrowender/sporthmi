/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.generated.phone;

import de.audi.app.bap.fw.AbstractBAPModuleFSG;
import de.audi.app.bap.fw.IFunctionRegistrationFSG;
import de.audi.app.bap.fw.functiontypes.BAPFunctionArrayFSG;
import de.audi.app.bap.fw.functiontypes.BAPFunctionMethodFSG;
import de.audi.app.bap.fw.functiontypes.BAPFunctionPropertyFSG;
import de.audi.app.bap.fw.functiontypes.IBAPFunction;
import de.audi.app.bap.utils.FunctionIDs;
import de.audi.app.bap.utils.LSGIDs;
import de.audi.atip.log.LogChannel;
import de.vw.mib.bap.generated.telephone.serializer.AcceptCall_Result;
import de.vw.mib.bap.generated.telephone.serializer.ActiveUser_Status;
import de.vw.mib.bap.generated.telephone.serializer.AutomaticRedialExtendedInfo_Status;
import de.vw.mib.bap.generated.telephone.serializer.AutomaticRedial_SetGet;
import de.vw.mib.bap.generated.telephone.serializer.AutomaticRedial_Status;
import de.vw.mib.bap.generated.telephone.serializer.BAP_Config_Reset;
import de.vw.mib.bap.generated.telephone.serializer.BAP_Config_Status;
import de.vw.mib.bap.generated.telephone.serializer.CCJoin_Result;
import de.vw.mib.bap.generated.telephone.serializer.CCSplit_Result;
import de.vw.mib.bap.generated.telephone.serializer.CCSplit_StartResult;
import de.vw.mib.bap.generated.telephone.serializer.CallDurationSync_Status;
import de.vw.mib.bap.generated.telephone.serializer.CallHold_Result;
import de.vw.mib.bap.generated.telephone.serializer.CallInfo_Status;
import de.vw.mib.bap.generated.telephone.serializer.CallStackDeleteAll_Result;
import de.vw.mib.bap.generated.telephone.serializer.CallStackDeleteAll_StartResult;
import de.vw.mib.bap.generated.telephone.serializer.CallState_Status;
import de.vw.mib.bap.generated.telephone.serializer.CombinedNumbers_ChangedArray;
import de.vw.mib.bap.generated.telephone.serializer.CombinedNumbers_GetArray;
import de.vw.mib.bap.generated.telephone.serializer.CombinedNumbers_SetGetArray;
import de.vw.mib.bap.generated.telephone.serializer.CombinedNumbers_StatusArray;
import de.vw.mib.bap.generated.telephone.serializer.ConfirmEmergencyCall_Result;
import de.vw.mib.bap.generated.telephone.serializer.ConfirmEmergencyCall_StartResult;
import de.vw.mib.bap.generated.telephone.serializer.DataConnectionIndication_Status;
import de.vw.mib.bap.generated.telephone.serializer.DialNumber_Result;
import de.vw.mib.bap.generated.telephone.serializer.DialNumber_StartResult;
import de.vw.mib.bap.generated.telephone.serializer.DialService_Result;
import de.vw.mib.bap.generated.telephone.serializer.DialService_StartResult;
import de.vw.mib.bap.generated.telephone.serializer.DialedNumbers_ChangedArray;
import de.vw.mib.bap.generated.telephone.serializer.DialedNumbers_GetArray;
import de.vw.mib.bap.generated.telephone.serializer.DialedNumbers_SetGetArray;
import de.vw.mib.bap.generated.telephone.serializer.DialedNumbers_StatusArray;
import de.vw.mib.bap.generated.telephone.serializer.DisconnectReason_Status;
import de.vw.mib.bap.generated.telephone.serializer.FSG_OperationState_Status;
import de.vw.mib.bap.generated.telephone.serializer.FSG_Setup_Status;
import de.vw.mib.bap.generated.telephone.serializer.FavoriteList_ChangedArray;
import de.vw.mib.bap.generated.telephone.serializer.FavoriteList_GetArray;
import de.vw.mib.bap.generated.telephone.serializer.FavoriteList_SetGetArray;
import de.vw.mib.bap.generated.telephone.serializer.FavoriteList_StatusArray;
import de.vw.mib.bap.generated.telephone.serializer.FunctionList_Status;
import de.vw.mib.bap.generated.telephone.serializer.GetNextListPos_Result;
import de.vw.mib.bap.generated.telephone.serializer.GetNextListPos_StartResult;
import de.vw.mib.bap.generated.telephone.serializer.HandsFreeOnOff_SetGet;
import de.vw.mib.bap.generated.telephone.serializer.HandsFreeOnOff_Status;
import de.vw.mib.bap.generated.telephone.serializer.HangupCall_Result;
import de.vw.mib.bap.generated.telephone.serializer.HangupCall_StartResult;
import de.vw.mib.bap.generated.telephone.serializer.Keypad_Status;
import de.vw.mib.bap.generated.telephone.serializer.LockState_Status;
import de.vw.mib.bap.generated.telephone.serializer.MPCallHoldAcceptWC_Result;
import de.vw.mib.bap.generated.telephone.serializer.MPRelActiveCallAcceptWC_Result;
import de.vw.mib.bap.generated.telephone.serializer.MPRelAllCallsAcceptWC_Result;
import de.vw.mib.bap.generated.telephone.serializer.MPSetWaitingCallOnHold_Result;
import de.vw.mib.bap.generated.telephone.serializer.MPSwap_Result;
import de.vw.mib.bap.generated.telephone.serializer.MicroMuteOnOff_SetGet;
import de.vw.mib.bap.generated.telephone.serializer.MicroMuteOnOff_Status;
import de.vw.mib.bap.generated.telephone.serializer.MissedCallIndication_SetGet;
import de.vw.mib.bap.generated.telephone.serializer.MissedCallIndication_Status;
import de.vw.mib.bap.generated.telephone.serializer.MissedCalls_ChangedArray;
import de.vw.mib.bap.generated.telephone.serializer.MissedCalls_GetArray;
import de.vw.mib.bap.generated.telephone.serializer.MissedCalls_SetGetArray;
import de.vw.mib.bap.generated.telephone.serializer.MissedCalls_StatusArray;
import de.vw.mib.bap.generated.telephone.serializer.MobileBatteryLevel_Status;
import de.vw.mib.bap.generated.telephone.serializer.MobileServiceSupport_Status;
import de.vw.mib.bap.generated.telephone.serializer.NetworkProvider_Status;
import de.vw.mib.bap.generated.telephone.serializer.PbSpeller_Result;
import de.vw.mib.bap.generated.telephone.serializer.PbSpeller_StartResult;
import de.vw.mib.bap.generated.telephone.serializer.PbState_Status;
import de.vw.mib.bap.generated.telephone.serializer.Phonebook_ChangedArray;
import de.vw.mib.bap.generated.telephone.serializer.Phonebook_GetArray;
import de.vw.mib.bap.generated.telephone.serializer.Phonebook_StatusArray;
import de.vw.mib.bap.generated.telephone.serializer.ReceivedCalls_ChangedArray;
import de.vw.mib.bap.generated.telephone.serializer.ReceivedCalls_GetArray;
import de.vw.mib.bap.generated.telephone.serializer.ReceivedCalls_SetGetArray;
import de.vw.mib.bap.generated.telephone.serializer.ReceivedCalls_StatusArray;
import de.vw.mib.bap.generated.telephone.serializer.RegisterState_Status;
import de.vw.mib.bap.generated.telephone.serializer.ResumeCall_Result;
import de.vw.mib.bap.generated.telephone.serializer.RingToneMuteOnOff_SetGet;
import de.vw.mib.bap.generated.telephone.serializer.RingToneMuteOnOff_Status;
import de.vw.mib.bap.generated.telephone.serializer.SMSState_SetGet;
import de.vw.mib.bap.generated.telephone.serializer.SMSState_Status;
import de.vw.mib.bap.generated.telephone.serializer.SignalQuality_Status;
import de.vw.mib.bap.generated.telephone.serializer.SupportedServiceNumbers_Status;
import de.vw.mib.bap.requests.ChangedArray;
import de.vw.mib.bap.requests.ResultMethod;
import de.vw.mib.bap.requests.StatusAckProperty;
import de.vw.mib.bap.requests.StatusArray;
import de.vw.mib.bap.requests.StatusProperty;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class FunctionRegistrationPhone
implements IFunctionRegistrationFSG {
    private BAPFunctionPropertyFSG bapConfig;
    private BAPFunctionPropertyFSG functionList;
    private BAPFunctionPropertyFSG fsgSetup;
    private BAPFunctionPropertyFSG fsgOperationState;
    private BAPFunctionPropertyFSG mobileServiceSupport;
    private BAPFunctionPropertyFSG activeUser;
    private BAPFunctionPropertyFSG registerState;
    private BAPFunctionPropertyFSG lockState;
    private BAPFunctionPropertyFSG networkProvider;
    private BAPFunctionPropertyFSG signalQuality;
    private BAPFunctionPropertyFSG callState;
    private BAPFunctionPropertyFSG callInfo;
    private BAPFunctionPropertyFSG callDurationSync;
    private BAPFunctionPropertyFSG disconnectReason;
    private BAPFunctionMethodFSG dialNumber;
    private BAPFunctionMethodFSG dialService;
    private BAPFunctionMethodFSG confirmEmergencyCall;
    private BAPFunctionMethodFSG hangupCall;
    private BAPFunctionMethodFSG acceptCall;
    private BAPFunctionMethodFSG callHold;
    private BAPFunctionMethodFSG resumeCall;
    private BAPFunctionPropertyFSG handsFreeOnOff;
    private BAPFunctionPropertyFSG microMuteOnOff;
    private BAPFunctionMethodFSG mpRelActiveCallAcceptWc;
    private BAPFunctionMethodFSG mpSwap;
    private BAPFunctionMethodFSG mpCallHoldAcceptWc;
    private BAPFunctionMethodFSG mpRelAllCallsAcceptWc;
    private BAPFunctionMethodFSG mpSetWaitingCallOnHold;
    private BAPFunctionMethodFSG ccJoin;
    private BAPFunctionMethodFSG ccSplit;
    private BAPFunctionPropertyFSG keypad;
    private BAPFunctionPropertyFSG mobileBatteryLevel;
    private BAPFunctionPropertyFSG dataConnectionIndication;
    private BAPFunctionPropertyFSG missedCallIndication;
    private BAPFunctionArrayFSG missedCalls;
    private BAPFunctionArrayFSG receivedCalls;
    private BAPFunctionArrayFSG dialedNumbers;
    private BAPFunctionArrayFSG combinedNumbers;
    private BAPFunctionMethodFSG callStackDeleteAll;
    private BAPFunctionPropertyFSG pbState;
    private BAPFunctionArrayFSG phonebook;
    private BAPFunctionMethodFSG pbSpeller;
    private BAPFunctionMethodFSG getNextListPos;
    private BAPFunctionPropertyFSG smsState;
    private BAPFunctionPropertyFSG ringToneMuteOnOff;
    private BAPFunctionPropertyFSG automaticRedial;
    private BAPFunctionPropertyFSG automaticRedialExtendedInfo;
    private BAPFunctionPropertyFSG supportedServiceNumbers;
    private BAPFunctionArrayFSG favoriteList;
    private boolean initialized = false;
    private final LogChannel logChannel;
    private final List allProperties = new ArrayList(26);
    private final List allMethods = new ArrayList(17);
    private final List allArrays = new ArrayList(6);

    public FunctionRegistrationPhone(AbstractBAPModuleFSG abstractBAPModuleFSG) {
        this.logChannel = abstractBAPModuleFSG.getLogChannel();
        this.initialize(abstractBAPModuleFSG);
    }

    private void initialize(AbstractBAPModuleFSG abstractBAPModuleFSG) {
        this.logChannel.log(10000000, "[FunctionRegistrationPhone#initialize] start initialization");
        this.initializeProperties(abstractBAPModuleFSG);
        this.initializeMethods(abstractBAPModuleFSG);
        this.initializeArrays(abstractBAPModuleFSG);
        this.initialized = true;
        this.logChannel.log(10000000, "[FunctionRegistrationPhone#initialize] initialization completed");
    }

    private void initializeProperties(AbstractBAPModuleFSG abstractBAPModuleFSG) {
        this.logChannel.log(10000000, "[FunctionRegistrationPhone#initializeProperties] initialize properties");
        this.bapConfig = abstractBAPModuleFSG.createBAPFunctionPropertyFSG(2);
        this.bapConfig.setResetSerializer(new BAP_Config_Reset());
        this.allProperties.add(this.bapConfig);
        this.functionList = abstractBAPModuleFSG.createBAPFunctionPropertyFSG(3);
        this.allProperties.add(this.functionList);
        this.fsgSetup = abstractBAPModuleFSG.createBAPFunctionPropertyFSG(14);
        this.allProperties.add(this.fsgSetup);
        this.fsgOperationState = abstractBAPModuleFSG.createBAPFunctionPropertyFSG(15);
        this.allProperties.add(this.fsgOperationState);
        this.mobileServiceSupport = abstractBAPModuleFSG.createBAPFunctionPropertyFSG(16);
        this.allProperties.add(this.mobileServiceSupport);
        this.activeUser = abstractBAPModuleFSG.createBAPFunctionPropertyFSG(17);
        this.allProperties.add(this.activeUser);
        this.registerState = abstractBAPModuleFSG.createBAPFunctionPropertyFSG(18);
        this.allProperties.add(this.registerState);
        this.lockState = abstractBAPModuleFSG.createBAPFunctionPropertyFSG(19);
        this.allProperties.add(this.lockState);
        this.networkProvider = abstractBAPModuleFSG.createBAPFunctionPropertyFSG(20);
        this.allProperties.add(this.networkProvider);
        this.signalQuality = abstractBAPModuleFSG.createBAPFunctionPropertyFSG(21);
        this.allProperties.add(this.signalQuality);
        this.callState = abstractBAPModuleFSG.createBAPFunctionPropertyFSG(22);
        this.allProperties.add(this.callState);
        this.callInfo = abstractBAPModuleFSG.createBAPFunctionPropertyFSG(23);
        this.allProperties.add(this.callInfo);
        this.callDurationSync = abstractBAPModuleFSG.createBAPFunctionPropertyFSG(24);
        this.allProperties.add(this.callDurationSync);
        this.disconnectReason = abstractBAPModuleFSG.createBAPFunctionPropertyFSG(25);
        this.allProperties.add(this.disconnectReason);
        this.handsFreeOnOff = abstractBAPModuleFSG.createBAPFunctionPropertyFSG(33);
        this.handsFreeOnOff.setSetGetSerializer(new HandsFreeOnOff_SetGet());
        this.allProperties.add(this.handsFreeOnOff);
        this.microMuteOnOff = abstractBAPModuleFSG.createBAPFunctionPropertyFSG(34);
        this.microMuteOnOff.setSetGetSerializer(new MicroMuteOnOff_SetGet());
        this.allProperties.add(this.microMuteOnOff);
        this.keypad = abstractBAPModuleFSG.createBAPFunctionPropertyFSG(42);
        this.allProperties.add(this.keypad);
        this.mobileBatteryLevel = abstractBAPModuleFSG.createBAPFunctionPropertyFSG(43);
        this.allProperties.add(this.mobileBatteryLevel);
        this.dataConnectionIndication = abstractBAPModuleFSG.createBAPFunctionPropertyFSG(44);
        this.allProperties.add(this.dataConnectionIndication);
        this.missedCallIndication = abstractBAPModuleFSG.createBAPFunctionPropertyFSG(45);
        this.missedCallIndication.setSetGetSerializer(new MissedCallIndication_SetGet());
        this.allProperties.add(this.missedCallIndication);
        this.pbState = abstractBAPModuleFSG.createBAPFunctionPropertyFSG(51);
        this.allProperties.add(this.pbState);
        this.smsState = abstractBAPModuleFSG.createBAPFunctionPropertyFSG(55);
        this.smsState.setSetGetSerializer(new SMSState_SetGet());
        this.allProperties.add(this.smsState);
        this.ringToneMuteOnOff = abstractBAPModuleFSG.createBAPFunctionPropertyFSG(56);
        this.ringToneMuteOnOff.setSetGetSerializer(new RingToneMuteOnOff_SetGet());
        this.allProperties.add(this.ringToneMuteOnOff);
        this.automaticRedial = abstractBAPModuleFSG.createBAPFunctionPropertyFSG(57);
        this.automaticRedial.setSetGetSerializer(new AutomaticRedial_SetGet());
        this.allProperties.add(this.automaticRedial);
        this.automaticRedialExtendedInfo = abstractBAPModuleFSG.createBAPFunctionPropertyFSG(58);
        this.allProperties.add(this.automaticRedialExtendedInfo);
        this.supportedServiceNumbers = abstractBAPModuleFSG.createBAPFunctionPropertyFSG(59);
        this.allProperties.add(this.supportedServiceNumbers);
    }

    private void initializeMethods(AbstractBAPModuleFSG abstractBAPModuleFSG) {
        this.logChannel.log(10000000, "[FunctionRegistrationPhone#initializeMethods] initialize methods");
        this.dialNumber = abstractBAPModuleFSG.createBAPFunctionMethodFSG(26);
        this.dialNumber.setStartResultSerializer(new DialNumber_StartResult());
        this.allMethods.add(this.dialNumber);
        this.dialService = abstractBAPModuleFSG.createBAPFunctionMethodFSG(27);
        this.dialService.setStartResultSerializer(new DialService_StartResult());
        this.allMethods.add(this.dialService);
        this.confirmEmergencyCall = abstractBAPModuleFSG.createBAPFunctionMethodFSG(28);
        this.confirmEmergencyCall.setStartResultSerializer(new ConfirmEmergencyCall_StartResult());
        this.allMethods.add(this.confirmEmergencyCall);
        this.hangupCall = abstractBAPModuleFSG.createBAPFunctionMethodFSG(29);
        this.hangupCall.setStartResultSerializer(new HangupCall_StartResult());
        this.allMethods.add(this.hangupCall);
        this.acceptCall = abstractBAPModuleFSG.createBAPFunctionMethodFSG(30);
        this.allMethods.add(this.acceptCall);
        this.callHold = abstractBAPModuleFSG.createBAPFunctionMethodFSG(31);
        this.allMethods.add(this.callHold);
        this.resumeCall = abstractBAPModuleFSG.createBAPFunctionMethodFSG(32);
        this.allMethods.add(this.resumeCall);
        this.mpRelActiveCallAcceptWc = abstractBAPModuleFSG.createBAPFunctionMethodFSG(35);
        this.allMethods.add(this.mpRelActiveCallAcceptWc);
        this.mpSwap = abstractBAPModuleFSG.createBAPFunctionMethodFSG(36);
        this.allMethods.add(this.mpSwap);
        this.mpCallHoldAcceptWc = abstractBAPModuleFSG.createBAPFunctionMethodFSG(37);
        this.allMethods.add(this.mpCallHoldAcceptWc);
        this.mpRelAllCallsAcceptWc = abstractBAPModuleFSG.createBAPFunctionMethodFSG(38);
        this.allMethods.add(this.mpRelAllCallsAcceptWc);
        this.mpSetWaitingCallOnHold = abstractBAPModuleFSG.createBAPFunctionMethodFSG(39);
        this.allMethods.add(this.mpSetWaitingCallOnHold);
        this.ccJoin = abstractBAPModuleFSG.createBAPFunctionMethodFSG(40);
        this.allMethods.add(this.ccJoin);
        this.ccSplit = abstractBAPModuleFSG.createBAPFunctionMethodFSG(41);
        this.ccSplit.setStartResultSerializer(new CCSplit_StartResult());
        this.allMethods.add(this.ccSplit);
        this.callStackDeleteAll = abstractBAPModuleFSG.createBAPFunctionMethodFSG(50);
        this.callStackDeleteAll.setStartResultSerializer(new CallStackDeleteAll_StartResult());
        this.allMethods.add(this.callStackDeleteAll);
        this.pbSpeller = abstractBAPModuleFSG.createBAPFunctionMethodFSG(53);
        this.pbSpeller.setStartResultSerializer(new PbSpeller_StartResult());
        this.allMethods.add(this.pbSpeller);
        this.getNextListPos = abstractBAPModuleFSG.createBAPFunctionMethodFSG(54);
        this.getNextListPos.setStartResultSerializer(new GetNextListPos_StartResult());
        this.allMethods.add(this.getNextListPos);
    }

    private void initializeArrays(AbstractBAPModuleFSG abstractBAPModuleFSG) {
        this.logChannel.log(10000000, "[FunctionRegistrationPhone#initializeArrays] initialize arrays");
        this.missedCalls = abstractBAPModuleFSG.createBAPFunctionArrayFSG(46);
        this.missedCalls.setGetArraySerializer(new MissedCalls_GetArray());
        this.missedCalls.setSetGetArraySerializer(new MissedCalls_SetGetArray());
        this.allArrays.add(this.missedCalls);
        this.receivedCalls = abstractBAPModuleFSG.createBAPFunctionArrayFSG(47);
        this.receivedCalls.setGetArraySerializer(new ReceivedCalls_GetArray());
        this.receivedCalls.setSetGetArraySerializer(new ReceivedCalls_SetGetArray());
        this.allArrays.add(this.receivedCalls);
        this.dialedNumbers = abstractBAPModuleFSG.createBAPFunctionArrayFSG(48);
        this.dialedNumbers.setGetArraySerializer(new DialedNumbers_GetArray());
        this.dialedNumbers.setSetGetArraySerializer(new DialedNumbers_SetGetArray());
        this.allArrays.add(this.dialedNumbers);
        this.combinedNumbers = abstractBAPModuleFSG.createBAPFunctionArrayFSG(49);
        this.combinedNumbers.setGetArraySerializer(new CombinedNumbers_GetArray());
        this.combinedNumbers.setSetGetArraySerializer(new CombinedNumbers_SetGetArray());
        this.allArrays.add(this.combinedNumbers);
        this.phonebook = abstractBAPModuleFSG.createBAPFunctionArrayFSG(52);
        this.phonebook.setGetArraySerializer(new Phonebook_GetArray());
        this.allArrays.add(this.phonebook);
        this.favoriteList = abstractBAPModuleFSG.createBAPFunctionArrayFSG(60);
        this.favoriteList.setGetArraySerializer(new FavoriteList_GetArray());
        this.favoriteList.setSetGetArraySerializer(new FavoriteList_SetGetArray());
        this.allArrays.add(this.favoriteList);
    }

    public BAPFunctionMethodFSG getBAPFunctionMethodFSG(int n) {
        try {
            return (BAPFunctionMethodFSG)this.getBAPFunction(n);
        }
        catch (ClassCastException classCastException) {
            this.logChannel.log(10000, "[FunctionRegistrationPhone#getBAPFunctionMethod] function is not of type 'Method': fctID=%1", (Object)FunctionIDs.getDescription(40, n));
            return null;
        }
    }

    public BAPFunctionPropertyFSG getBAPFunctionPropertyFSG(int n) {
        try {
            return (BAPFunctionPropertyFSG)this.getBAPFunction(n);
        }
        catch (ClassCastException classCastException) {
            this.logChannel.log(10000, "[FunctionRegistrationPhone#getBAPFunctionProperty] function is not of type 'Property': fctID=%1", (Object)FunctionIDs.getDescription(40, n));
            return null;
        }
    }

    public BAPFunctionArrayFSG getBAPFunctionArrayFSG(int n) {
        try {
            return (BAPFunctionArrayFSG)this.getBAPFunction(n);
        }
        catch (ClassCastException classCastException) {
            this.logChannel.log(10000, "[FunctionRegistrationPhone#getBAPFunctionArray] function is not of type 'Array': fctID=%1", (Object)FunctionIDs.getDescription(40, n));
            return null;
        }
    }

    public IBAPFunction getBAPFunction(int n) {
        if (!this.initialized) {
            this.logChannel.log(10000, "[FunctionRegistrationPhone#getBAPFunction] function registration not initialized yet for lsgID=%1", (Object)LSGIDs.getDescription(40), (long)n);
        }
        switch (n) {
            case 2: {
                return this.bapConfig;
            }
            case 3: {
                return this.functionList;
            }
            case 14: {
                return this.fsgSetup;
            }
            case 15: {
                return this.fsgOperationState;
            }
            case 16: {
                return this.mobileServiceSupport;
            }
            case 17: {
                return this.activeUser;
            }
            case 18: {
                return this.registerState;
            }
            case 19: {
                return this.lockState;
            }
            case 20: {
                return this.networkProvider;
            }
            case 21: {
                return this.signalQuality;
            }
            case 22: {
                return this.callState;
            }
            case 23: {
                return this.callInfo;
            }
            case 24: {
                return this.callDurationSync;
            }
            case 25: {
                return this.disconnectReason;
            }
            case 26: {
                return this.dialNumber;
            }
            case 27: {
                return this.dialService;
            }
            case 28: {
                return this.confirmEmergencyCall;
            }
            case 29: {
                return this.hangupCall;
            }
            case 30: {
                return this.acceptCall;
            }
            case 31: {
                return this.callHold;
            }
            case 32: {
                return this.resumeCall;
            }
            case 33: {
                return this.handsFreeOnOff;
            }
            case 34: {
                return this.microMuteOnOff;
            }
            case 35: {
                return this.mpRelActiveCallAcceptWc;
            }
            case 36: {
                return this.mpSwap;
            }
            case 37: {
                return this.mpCallHoldAcceptWc;
            }
            case 38: {
                return this.mpRelAllCallsAcceptWc;
            }
            case 39: {
                return this.mpSetWaitingCallOnHold;
            }
            case 40: {
                return this.ccJoin;
            }
            case 41: {
                return this.ccSplit;
            }
            case 42: {
                return this.keypad;
            }
            case 43: {
                return this.mobileBatteryLevel;
            }
            case 44: {
                return this.dataConnectionIndication;
            }
            case 45: {
                return this.missedCallIndication;
            }
            case 46: {
                return this.missedCalls;
            }
            case 47: {
                return this.receivedCalls;
            }
            case 48: {
                return this.dialedNumbers;
            }
            case 49: {
                return this.combinedNumbers;
            }
            case 50: {
                return this.callStackDeleteAll;
            }
            case 51: {
                return this.pbState;
            }
            case 52: {
                return this.phonebook;
            }
            case 53: {
                return this.pbSpeller;
            }
            case 54: {
                return this.getNextListPos;
            }
            case 55: {
                return this.smsState;
            }
            case 56: {
                return this.ringToneMuteOnOff;
            }
            case 57: {
                return this.automaticRedial;
            }
            case 58: {
                return this.automaticRedialExtendedInfo;
            }
            case 59: {
                return this.supportedServiceNumbers;
            }
            case 60: {
                return this.favoriteList;
            }
        }
        this.logChannel.log(10000, "[FunctionRegistrationPhone#getBAPFunction] function not supported by FSG: lsgID=%1, fctID=%2", (Object)LSGIDs.getDescription(40), (Object)FunctionIDs.getDescription(40, n));
        return null;
    }

    public List getAllProperties() {
        return this.allProperties;
    }

    public List getAllMethods() {
        return this.allMethods;
    }

    public List getAllArrays() {
        return this.allArrays;
    }

    public void resetBAPFunctions() {
        this.logChannel.log(10000000, "[FunctionRegistrationPhone#resetBAPFunctions]");
        Iterator iterator = this.allArrays.iterator();
        while (iterator.hasNext()) {
            ((IBAPFunction)iterator.next()).reset();
        }
        iterator = this.allProperties.iterator();
        while (iterator.hasNext()) {
            ((IBAPFunction)iterator.next()).reset();
        }
        iterator = this.allMethods.iterator();
        while (iterator.hasNext()) {
            ((IBAPFunction)iterator.next()).reset();
        }
    }

    public ResultMethod createResultForMethodFSG(int n) {
        switch (n) {
            case 26: {
                return new DialNumber_Result();
            }
            case 27: {
                return new DialService_Result();
            }
            case 28: {
                return new ConfirmEmergencyCall_Result();
            }
            case 29: {
                return new HangupCall_Result();
            }
            case 30: {
                return new AcceptCall_Result();
            }
            case 31: {
                return new CallHold_Result();
            }
            case 32: {
                return new ResumeCall_Result();
            }
            case 35: {
                return new MPRelActiveCallAcceptWC_Result();
            }
            case 36: {
                return new MPSwap_Result();
            }
            case 37: {
                return new MPCallHoldAcceptWC_Result();
            }
            case 38: {
                return new MPRelAllCallsAcceptWC_Result();
            }
            case 39: {
                return new MPSetWaitingCallOnHold_Result();
            }
            case 40: {
                return new CCJoin_Result();
            }
            case 41: {
                return new CCSplit_Result();
            }
            case 50: {
                return new CallStackDeleteAll_Result();
            }
            case 53: {
                return new PbSpeller_Result();
            }
            case 54: {
                return new GetNextListPos_Result();
            }
        }
        this.logChannel.log(10000, "[FunctionRegistrationPhone#createResultForMethodFSG] function not supported by FSG: lsgID=%1, fctID=%2", (Object)LSGIDs.getDescription(40), (Object)FunctionIDs.getDescription(40, n));
        return null;
    }

    public StatusProperty createStatusForPropertyFSG(int n) {
        switch (n) {
            case 2: {
                return new BAP_Config_Status();
            }
            case 3: {
                return new FunctionList_Status();
            }
            case 14: {
                return new FSG_Setup_Status();
            }
            case 15: {
                return new FSG_OperationState_Status();
            }
            case 16: {
                return new MobileServiceSupport_Status();
            }
            case 17: {
                return new ActiveUser_Status();
            }
            case 18: {
                return new RegisterState_Status();
            }
            case 19: {
                return new LockState_Status();
            }
            case 20: {
                return new NetworkProvider_Status();
            }
            case 21: {
                return new SignalQuality_Status();
            }
            case 22: {
                return new CallState_Status();
            }
            case 23: {
                return new CallInfo_Status();
            }
            case 24: {
                return new CallDurationSync_Status();
            }
            case 25: {
                return new DisconnectReason_Status();
            }
            case 33: {
                return new HandsFreeOnOff_Status();
            }
            case 34: {
                return new MicroMuteOnOff_Status();
            }
            case 42: {
                return new Keypad_Status();
            }
            case 43: {
                return new MobileBatteryLevel_Status();
            }
            case 44: {
                return new DataConnectionIndication_Status();
            }
            case 45: {
                return new MissedCallIndication_Status();
            }
            case 51: {
                return new PbState_Status();
            }
            case 55: {
                return new SMSState_Status();
            }
            case 56: {
                return new RingToneMuteOnOff_Status();
            }
            case 57: {
                return new AutomaticRedial_Status();
            }
            case 58: {
                return new AutomaticRedialExtendedInfo_Status();
            }
            case 59: {
                return new SupportedServiceNumbers_Status();
            }
        }
        this.logChannel.log(10000, "[FunctionRegistrationPhone#createStatusForPropertyFSG] function not supported by FSG: lsgID=%1, fctID=%2", (Object)LSGIDs.getDescription(40), (Object)FunctionIDs.getDescription(40, n));
        return null;
    }

    public StatusAckProperty createStatusAckForPropertyFSG(int n) {
        switch (n) {
            default: 
        }
        this.logChannel.log(10000, "[FunctionRegistrationPhone#createStatusAckForPropertyFSG] function not supported by FSG: lsgID=%1, fctID=%2", (Object)LSGIDs.getDescription(40), (Object)FunctionIDs.getDescription(40, n));
        return null;
    }

    public StatusArray createStatusArrayForArrayFSG(int n) {
        switch (n) {
            case 46: {
                return new MissedCalls_StatusArray();
            }
            case 47: {
                return new ReceivedCalls_StatusArray();
            }
            case 48: {
                return new DialedNumbers_StatusArray();
            }
            case 49: {
                return new CombinedNumbers_StatusArray();
            }
            case 52: {
                return new Phonebook_StatusArray();
            }
            case 60: {
                return new FavoriteList_StatusArray();
            }
        }
        this.logChannel.log(10000, "[FunctionRegistrationPhone#createStatusArrayForArrayFSG] function not supported by FSG: lsgID=%1, fctID=%2", (Object)LSGIDs.getDescription(40), (Object)FunctionIDs.getDescription(40, n));
        return null;
    }

    public ChangedArray createChangedArrayForArrayFSG(int n) {
        switch (n) {
            case 46: {
                return new MissedCalls_ChangedArray();
            }
            case 47: {
                return new ReceivedCalls_ChangedArray();
            }
            case 48: {
                return new DialedNumbers_ChangedArray();
            }
            case 49: {
                return new CombinedNumbers_ChangedArray();
            }
            case 52: {
                return new Phonebook_ChangedArray();
            }
            case 60: {
                return new FavoriteList_ChangedArray();
            }
        }
        this.logChannel.log(10000, "[FunctionRegistrationPhone#createChangedArrayForArrayFSG] function not supported by FSG: lsgID=%1, fctID=%2", (Object)LSGIDs.getDescription(40), (Object)FunctionIDs.getDescription(40, n));
        return null;
    }
}

