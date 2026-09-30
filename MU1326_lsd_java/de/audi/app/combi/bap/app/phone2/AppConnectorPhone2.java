/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.app.phone2;

import de.audi.app.combi.bap.AbstractCombiConnector;
import de.audi.app.combi.bap.app.phone2.CombiModulePhone2;
import de.audi.atip.interapp.bap.BAPServiceListener;
import de.audi.atip.interapp.combi.bap.phone.CombiBAPServicePhone2;
import de.vw.mib.bap.generated.telephone2.serializer.AutomaticCallForwarding_Status;
import de.vw.mib.bap.generated.telephone2.serializer.LockState2_Status;
import de.vw.mib.bap.generated.telephone2.serializer.MobileServiceSupport_Status;
import de.vw.mib.bap.generated.telephone2.serializer.NetworkProvider2_Status;
import de.vw.mib.bap.generated.telephone2.serializer.PhoneModuleState_Status;
import de.vw.mib.bap.generated.telephone2.serializer.RegisterState2_Status;
import de.vw.mib.bap.generated.telephone2.serializer.SignalQuality2_Status;

public class AppConnectorPhone2
extends AbstractCombiConnector
implements CombiBAPServicePhone2 {
    protected AppConnectorPhone2(CombiModulePhone2 combiModulePhone2) {
        super(combiModulePhone2);
    }

    public void setAppServiceListener(BAPServiceListener bAPServiceListener) {
        super.setAppServiceListener(bAPServiceListener);
        this.moduleFsg.getInitializationManager().notifyAppServiceChanged(bAPServiceListener != null);
    }

    public void updateMobileServiceSupport(boolean[] blArray) {
        this.logChannel.log(10000000, "[AppConnectorPhone2#updateMobileServiceSupport] called");
        MobileServiceSupport_Status mobileServiceSupport_Status = (MobileServiceSupport_Status)this.moduleFsg.getBAPFunctionPropertyFSG(16).getLastStatus();
        if (blArray.length < 7) {
            this.logChannel.log(10000, "[AppConnectorPhone2#updateMobileServiceSupport] fctList array too short (length=%1)", (long)blArray.length);
            return;
        }
        MobileServiceSupport_Status mobileServiceSupport_Status2 = new MobileServiceSupport_Status();
        mobileServiceSupport_Status2.fctList.fctGetAllSupported = this.moduleFsg.getFunctionList().isFunctionSupported(1);
        mobileServiceSupport_Status2.fctList.fctBapConfigSupported = this.moduleFsg.getFunctionList().isFunctionSupported(2);
        mobileServiceSupport_Status2.fctList.fctFunctionListSupported = this.moduleFsg.getFunctionList().isFunctionSupported(3);
        mobileServiceSupport_Status2.fctList.fctHeartbeatSupported = this.moduleFsg.getFunctionList().isFunctionSupported(4);
        mobileServiceSupport_Status2.fctList.fctFsg_SetupSupported = this.moduleFsg.getFunctionList().isFunctionSupported(14);
        mobileServiceSupport_Status2.fctList.fctFsg_OperationStateSupported = this.moduleFsg.getFunctionList().isFunctionSupported(15);
        mobileServiceSupport_Status2.fctList.fctMobileServiceSupportSupported = blArray[0] && this.moduleFsg.getFunctionList().isFunctionSupported(16);
        mobileServiceSupport_Status2.fctList.fctRegisterState2Supported = blArray[1] && this.moduleFsg.getFunctionList().isFunctionSupported(17);
        mobileServiceSupport_Status2.fctList.fctLockState2Supported = blArray[2] && this.moduleFsg.getFunctionList().isFunctionSupported(18);
        mobileServiceSupport_Status2.fctList.fctNetworkProvider2Supported = blArray[3] && this.moduleFsg.getFunctionList().isFunctionSupported(19);
        mobileServiceSupport_Status2.fctList.fctSignalQuality2Supported = blArray[4] && this.moduleFsg.getFunctionList().isFunctionSupported(20);
        mobileServiceSupport_Status2.fctList.fctDataConnectionIndication2Supported = mobileServiceSupport_Status.fctList.fctDataConnectionIndication2Supported;
        mobileServiceSupport_Status2.fctList.fctEmailStateSupported = mobileServiceSupport_Status.fctList.fctEmailStateSupported;
        mobileServiceSupport_Status2.fctList.fctPhoneModuleStateSupported = blArray[5] && this.moduleFsg.getFunctionList().isFunctionSupported(23);
        mobileServiceSupport_Status2.fctList.fctConnectionStateSupported = mobileServiceSupport_Status.fctList.fctConnectionStateSupported;
        mobileServiceSupport_Status2.fctList.fctAutomaticCallForwardingSupported = blArray[6] && this.moduleFsg.getFunctionList().isFunctionSupported(25);
        this.logChannel.log(1000000, "[AppConnectorPhone2#updateMobileServiceSupport] %1", (Object)mobileServiceSupport_Status2);
        this.sendPropertyStatus(16, mobileServiceSupport_Status2);
    }

    public void updateRegisterState(int n, int n2, int n3) {
        this.logChannel.log(1000000, "[AppConnectorPhone2#updateRegisterState] registerState=%1, networkType=%2, packetDataNetworkType=%3", (long)n, (long)n2, (long)n3);
        RegisterState2_Status registerState2_Status = new RegisterState2_Status();
        registerState2_Status.registerState = n;
        registerState2_Status.networkType = n2;
        registerState2_Status.packetDataNetworkType = n3;
        this.sendPropertyStatus(17, registerState2_Status);
    }

    public void updateLockState(int n) {
        this.logChannel.log(1000000, "[AppConnectorPhone2#updateLockState] lockState=%1", (long)n);
        LockState2_Status lockState2_Status = new LockState2_Status();
        lockState2_Status.lockState = n;
        this.sendPropertyStatus(18, lockState2_Status);
    }

    public void updateNetworkProvider(int n, String string, int n2, String string2) {
        this.logChannel.log(1000000, "[AppConnectorPhone2#updateNetworkProvider] networkProviderState=%2, networkProviderName=%1, ...", (Object)string, (long)n);
        this.logChannel.log(1000000, "[AppConnectorPhone2#updateNetworkProvider] serviceProviderState=%2, serviceProviderName=%1, ...", (Object)string2, (long)n2);
        NetworkProvider2_Status networkProvider2_Status = new NetworkProvider2_Status();
        networkProvider2_Status.networkProviderState = n;
        networkProvider2_Status.networkProviderName.setContent(string);
        networkProvider2_Status.serviceProviderState = n2;
        networkProvider2_Status.serviceProviderName.setContent(string2);
        this.sendPropertyStatus(19, networkProvider2_Status);
    }

    public void updateSignalQuality(int n) {
        this.logChannel.log(1000000, "[AppConnectorPhone2#updateSignalQuality] quality=%1", (long)n);
        SignalQuality2_Status signalQuality2_Status = new SignalQuality2_Status();
        signalQuality2_Status.quality = n;
        this.sendPropertyStatus(20, signalQuality2_Status);
    }

    public void updatePhoneModuleState(int n, int n2, int n3, int n4) {
        this.logChannel.log(1000000, "[AppConnectorPhone2#updatePhoneModuleState] moduleState=%1, simState=%2, ...", (long)n, (long)n4);
        this.logChannel.log(1000000, "[AppConnectorPhone2#updatePhoneModuleState] moduleSupportedServices=%1, moduleActiveServices=%2, ...", (long)n2, (long)n3);
        PhoneModuleState_Status phoneModuleState_Status = new PhoneModuleState_Status();
        phoneModuleState_Status.moduleState = n;
        phoneModuleState_Status.moduleSupportedServices = n2;
        phoneModuleState_Status.moduleActiveServices = n3;
        phoneModuleState_Status.simstate = n4;
        this.sendPropertyStatus(23, phoneModuleState_Status);
    }

    public void updateAutomaticCallForwarding(int n) {
        this.logChannel.log(1000000, "[AppConnectorPhone2#updateAutomaticCallForwarding] divertState=%1", (long)n);
        AutomaticCallForwarding_Status automaticCallForwarding_Status = new AutomaticCallForwarding_Status();
        automaticCallForwarding_Status.divertState.forwardingStateValid = n > 0;
        automaticCallForwarding_Status.divertState.forwardingIfBusy = this.hasAttribute(n, 1);
        automaticCallForwarding_Status.divertState.forwardingIfNotAnswered = this.hasAttribute(n, 2);
        automaticCallForwarding_Status.divertState.forwardingIfOutOfReach = this.hasAttribute(n, 4);
        automaticCallForwarding_Status.divertState.forwardingIfNotAvailable = this.hasAttribute(n, 8);
        automaticCallForwarding_Status.divertState.forwardingAllVoiceCalls = this.hasAttribute(n, 16);
        automaticCallForwarding_Status.divertState.forwardingAllFaxCalls = this.hasAttribute(n, 32);
        automaticCallForwarding_Status.divertState.fowardingAllDataCalls = this.hasAttribute(n, 64);
        this.sendPropertyStatus(25, automaticCallForwarding_Status);
    }
}

