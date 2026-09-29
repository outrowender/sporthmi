/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.app.phone;

import de.audi.app.bap.fw.functiontypes.BAPFunctionPropertyFSG;
import de.audi.app.bap.utils.FunctionIDs;
import de.audi.app.combi.bap.AbstractCombiConnector;
import de.audi.app.combi.bap.app.phone.CombiModulePhone;
import de.audi.app.combi.bap.app.phone2.CombiModulePhone2;
import de.vw.mib.bap.generated.telephone.serializer.MobileServiceSupport_Status;
import de.vw.mib.bap.requests.StatusProperty;

public abstract class AbstractAppConnectorPhone
extends AbstractCombiConnector {
    public AbstractAppConnectorPhone(CombiModulePhone combiModulePhone) {
        super(combiModulePhone);
    }

    protected BAPFunctionPropertyFSG getPhone2Property(int n) {
        CombiModulePhone2 combiModulePhone2 = ((CombiModulePhone)this.moduleFsg).getPhone2Module();
        if (combiModulePhone2 == null) {
            this.logChannel.log(10000, "[AbstractAppConnectorPhone#getPhone2Property] phone2 module not present: can't get property with fctID=%1", (long)n);
            return null;
        }
        return combiModulePhone2.getBAPFunctionPropertyFSG(n);
    }

    protected void sendPhone2PropertyStatus(int n, StatusProperty statusProperty) {
        CombiModulePhone2 combiModulePhone2 = ((CombiModulePhone)this.moduleFsg).getPhone2Module();
        if (combiModulePhone2 != null) {
            combiModulePhone2.getBAPFunctionPropertyFSG(n).sendStatusIfChanged(statusProperty);
        } else {
            this.logChannel.log(10000, "[AbstractAppConnectorPhone#sendPhone2PropertyStatus] phone2 module not present: can't update status of fctID=%1", (Object)FunctionIDs.getDescription(41, n));
        }
    }

    protected MobileServiceSupport_Status getMobileServiceSupportStatusCopy() {
        MobileServiceSupport_Status mobileServiceSupport_Status = (MobileServiceSupport_Status)this.moduleFsg.getBAPFunctionPropertyFSG(16).getLastStatus();
        MobileServiceSupport_Status mobileServiceSupport_Status2 = new MobileServiceSupport_Status();
        mobileServiceSupport_Status2.fctList.fctActiveUserSupported = mobileServiceSupport_Status.fctList.fctActiveUserSupported;
        mobileServiceSupport_Status2.fctList.fctRegisterStateSupported = mobileServiceSupport_Status.fctList.fctRegisterStateSupported;
        mobileServiceSupport_Status2.fctList.fctLockStateSupported = mobileServiceSupport_Status.fctList.fctLockStateSupported;
        mobileServiceSupport_Status2.fctList.fctNetworkProviderSupported = mobileServiceSupport_Status.fctList.fctNetworkProviderSupported;
        mobileServiceSupport_Status2.fctList.fctSignalQualitySupported = mobileServiceSupport_Status.fctList.fctSignalQualitySupported;
        mobileServiceSupport_Status2.fctList.fctCallStateSupported = mobileServiceSupport_Status.fctList.fctCallStateSupported;
        mobileServiceSupport_Status2.fctList.fctCallInfoSupported = mobileServiceSupport_Status.fctList.fctCallInfoSupported;
        mobileServiceSupport_Status2.fctList.fctCallDurationSyncSupported = mobileServiceSupport_Status.fctList.fctCallDurationSyncSupported;
        mobileServiceSupport_Status2.fctList.fctDisconnectReasonSupported = mobileServiceSupport_Status.fctList.fctDisconnectReasonSupported;
        mobileServiceSupport_Status2.fctList.fctDialNumberSupported = mobileServiceSupport_Status.fctList.fctDialNumberSupported;
        mobileServiceSupport_Status2.fctList.fctDialServiceSupported = mobileServiceSupport_Status.fctList.fctDialServiceSupported;
        mobileServiceSupport_Status2.fctList.fctConfirmEmergencyCallSupported = mobileServiceSupport_Status.fctList.fctConfirmEmergencyCallSupported;
        mobileServiceSupport_Status2.fctList.fctHangupCallSupported = mobileServiceSupport_Status.fctList.fctHangupCallSupported;
        mobileServiceSupport_Status2.fctList.fctAcceptCallSupported = mobileServiceSupport_Status.fctList.fctAcceptCallSupported;
        mobileServiceSupport_Status2.fctList.fctCallHoldSupported = mobileServiceSupport_Status.fctList.fctCallHoldSupported;
        mobileServiceSupport_Status2.fctList.fctResumeCallSupported = mobileServiceSupport_Status.fctList.fctResumeCallSupported;
        mobileServiceSupport_Status2.fctList.fctHandsFreeOnOffSupported = mobileServiceSupport_Status.fctList.fctHandsFreeOnOffSupported;
        mobileServiceSupport_Status2.fctList.fctMicroMuteOnOffSupported = mobileServiceSupport_Status.fctList.fctMicroMuteOnOffSupported;
        mobileServiceSupport_Status2.fctList.fctMpreleaseActiveCallAcceptWaitingCallSupported = mobileServiceSupport_Status.fctList.fctMpreleaseActiveCallAcceptWaitingCallSupported;
        mobileServiceSupport_Status2.fctList.fctMpswapSupported = mobileServiceSupport_Status.fctList.fctMpswapSupported;
        mobileServiceSupport_Status2.fctList.fctMpcallHoldAcceptWaitingCallSupported = mobileServiceSupport_Status.fctList.fctMpcallHoldAcceptWaitingCallSupported;
        mobileServiceSupport_Status2.fctList.fctMpreleaseAllCallsAcceptWaitingCallSupported = mobileServiceSupport_Status.fctList.fctMpreleaseAllCallsAcceptWaitingCallSupported;
        mobileServiceSupport_Status2.fctList.fctMpsetWaitingCallOnHoldSupported = mobileServiceSupport_Status.fctList.fctMpsetWaitingCallOnHoldSupported;
        mobileServiceSupport_Status2.fctList.fctCcjoinSupported = mobileServiceSupport_Status.fctList.fctCcjoinSupported;
        mobileServiceSupport_Status2.fctList.fctCcsplitSupported = mobileServiceSupport_Status.fctList.fctCcsplitSupported;
        mobileServiceSupport_Status2.fctList.fctKeypadSupported = mobileServiceSupport_Status.fctList.fctKeypadSupported;
        mobileServiceSupport_Status2.fctList.fctMobileBatteryLevelSupported = mobileServiceSupport_Status.fctList.fctMobileBatteryLevelSupported;
        mobileServiceSupport_Status2.fctList.fctDataConnectionIndicationSupported = mobileServiceSupport_Status.fctList.fctDataConnectionIndicationSupported;
        mobileServiceSupport_Status2.fctList.fctMissedCallIndicationSupported = mobileServiceSupport_Status.fctList.fctMissedCallIndicationSupported;
        mobileServiceSupport_Status2.fctList.fctMissedCallsSupported = mobileServiceSupport_Status.fctList.fctMissedCallsSupported;
        mobileServiceSupport_Status2.fctList.fctReceivedCallsSupported = mobileServiceSupport_Status.fctList.fctReceivedCallsSupported;
        mobileServiceSupport_Status2.fctList.fctDialedNumbersSupported = mobileServiceSupport_Status.fctList.fctDialedNumbersSupported;
        mobileServiceSupport_Status2.fctList.fctCombinedNumbersSupported = mobileServiceSupport_Status.fctList.fctCombinedNumbersSupported;
        mobileServiceSupport_Status2.fctList.fctCallStackDeleteAllSupported = mobileServiceSupport_Status.fctList.fctCallStackDeleteAllSupported;
        mobileServiceSupport_Status2.fctList.fctPbStateSupported = mobileServiceSupport_Status.fctList.fctPbStateSupported;
        mobileServiceSupport_Status2.fctList.fctPhonebookSupported = mobileServiceSupport_Status.fctList.fctPhonebookSupported;
        mobileServiceSupport_Status2.fctList.fctPbSpellerSupported = mobileServiceSupport_Status.fctList.fctPbSpellerSupported;
        mobileServiceSupport_Status2.fctList.fctGetNextListPosSupported = mobileServiceSupport_Status.fctList.fctGetNextListPosSupported;
        mobileServiceSupport_Status2.fctList.fctSmsstateSupported = mobileServiceSupport_Status.fctList.fctSmsstateSupported;
        mobileServiceSupport_Status2.fctList.fctRingToneMuteOnOffSupported = mobileServiceSupport_Status.fctList.fctRingToneMuteOnOffSupported;
        mobileServiceSupport_Status2.fctList.fctAutomaticRedialSupported = mobileServiceSupport_Status.fctList.fctAutomaticRedialSupported;
        mobileServiceSupport_Status2.fctList.fctAutomaticRedialExtendedInfoSupported = mobileServiceSupport_Status.fctList.fctAutomaticRedialExtendedInfoSupported;
        mobileServiceSupport_Status2.fctList.fctSupportedServiceNumbersSupported = mobileServiceSupport_Status.fctList.fctSupportedServiceNumbersSupported;
        mobileServiceSupport_Status2.fctList.fctFavoriteListSupported = mobileServiceSupport_Status.fctList.fctFavoriteListSupported;
        return mobileServiceSupport_Status2;
    }

    protected de.vw.mib.bap.generated.telephone2.serializer.MobileServiceSupport_Status getMobileServiceSupport2StatusCopy() {
        de.vw.mib.bap.generated.telephone2.serializer.MobileServiceSupport_Status mobileServiceSupport_Status = new de.vw.mib.bap.generated.telephone2.serializer.MobileServiceSupport_Status();
        CombiModulePhone2 combiModulePhone2 = ((CombiModulePhone)this.moduleFsg).getPhone2Module();
        if (combiModulePhone2 != null) {
            de.vw.mib.bap.generated.telephone2.serializer.MobileServiceSupport_Status mobileServiceSupport_Status2 = (de.vw.mib.bap.generated.telephone2.serializer.MobileServiceSupport_Status)combiModulePhone2.getBAPFunctionPropertyFSG(16).getLastStatus();
            mobileServiceSupport_Status.fctList.fctGetAllSupported = mobileServiceSupport_Status2.fctList.fctGetAllSupported;
            mobileServiceSupport_Status.fctList.fctBapConfigSupported = mobileServiceSupport_Status2.fctList.fctBapConfigSupported;
            mobileServiceSupport_Status.fctList.fctFunctionListSupported = mobileServiceSupport_Status2.fctList.fctFunctionListSupported;
            mobileServiceSupport_Status.fctList.fctHeartbeatSupported = mobileServiceSupport_Status2.fctList.fctHeartbeatSupported;
            mobileServiceSupport_Status.fctList.fctFsg_SetupSupported = mobileServiceSupport_Status2.fctList.fctFsg_SetupSupported;
            mobileServiceSupport_Status.fctList.fctFsg_OperationStateSupported = mobileServiceSupport_Status2.fctList.fctFsg_OperationStateSupported;
            mobileServiceSupport_Status.fctList.fctMobileServiceSupportSupported = mobileServiceSupport_Status2.fctList.fctMobileServiceSupportSupported;
            mobileServiceSupport_Status.fctList.fctRegisterState2Supported = mobileServiceSupport_Status2.fctList.fctRegisterState2Supported;
            mobileServiceSupport_Status.fctList.fctLockState2Supported = mobileServiceSupport_Status2.fctList.fctLockState2Supported;
            mobileServiceSupport_Status.fctList.fctNetworkProvider2Supported = mobileServiceSupport_Status2.fctList.fctNetworkProvider2Supported;
            mobileServiceSupport_Status.fctList.fctSignalQuality2Supported = mobileServiceSupport_Status2.fctList.fctSignalQuality2Supported;
            mobileServiceSupport_Status.fctList.fctDataConnectionIndication2Supported = mobileServiceSupport_Status2.fctList.fctDataConnectionIndication2Supported;
            mobileServiceSupport_Status.fctList.fctEmailStateSupported = mobileServiceSupport_Status2.fctList.fctEmailStateSupported;
            mobileServiceSupport_Status.fctList.fctPhoneModuleStateSupported = mobileServiceSupport_Status2.fctList.fctPhoneModuleStateSupported;
            mobileServiceSupport_Status.fctList.fctConnectionStateSupported = mobileServiceSupport_Status2.fctList.fctConnectionStateSupported;
            mobileServiceSupport_Status.fctList.fctAutomaticCallForwardingSupported = mobileServiceSupport_Status2.fctList.fctAutomaticCallForwardingSupported;
        } else {
            this.logChannel.log(10000, "[AbstractAppConnectorPhone#getMobileServiceSupport2StatusCopy] phone2 module not present: can't get MobileServiceSupport");
        }
        return mobileServiceSupport_Status;
    }
}

