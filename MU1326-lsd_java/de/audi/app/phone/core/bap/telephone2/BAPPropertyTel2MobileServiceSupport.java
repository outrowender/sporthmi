/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.bap.telephone2;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.bap.telephone2.AbstractTel2EnqueuedBAPPropertyHandler;
import de.audi.app.phone.core.bap.telephone2.TelBAPManagerTel2Utils;
import de.audi.app.phone.core.state.IGlobalTelephoneStateStruct;
import de.audi.atip.interapp.combi.bap.phone.CombiBAPServicePhone2;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.commons.job.DispatcherBase;
import java.util.Arrays;

class BAPPropertyTel2MobileServiceSupport
extends AbstractTel2EnqueuedBAPPropertyHandler {
    private boolean[] supportedServices = new boolean[7];

    private static String getServiceString(int n) {
        switch (n) {
            case 6: {
                return "AutomaticCallForwarding (0x19)";
            }
            case 2: {
                return "LockState2 (0x12)";
            }
            case 0: {
                return "MobileServiceSupport (0x10)";
            }
            case 3: {
                return "NetworkProvider2 (0x13)";
            }
            case 5: {
                return "PhoneModuleState (0x17)";
            }
            case 1: {
                return "RegisterState2 (0x11)";
            }
            case 4: {
                return "SignalQuality2 (0x14)";
            }
        }
        return new StringBuffer().append("UnhandledService(").append(n).append(")").toString();
    }

    private static Buffer getSupportedServiceArrayBuffer(boolean[] blArray) {
        Buffer buffer = new Buffer();
        buffer.append("[");
        if (blArray != null) {
            for (int i2 = 0; i2 < blArray.length; ++i2) {
                buffer.append(BAPPropertyTel2MobileServiceSupport.getServiceString(i2));
                buffer.append("=");
                buffer.append(blArray[i2]);
                if (i2 >= blArray.length - 1) continue;
                buffer.append(", ");
            }
        }
        buffer.append("]");
        return buffer;
    }

    private static boolean isNADAvailable(IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        if (iGlobalTelephoneStateStruct != null && iGlobalTelephoneStateStruct.getNadInstanceState() != null) {
            return iGlobalTelephoneStateStruct.getNadInstanceState().getActivationState() != null && iGlobalTelephoneStateStruct.getNadInstanceState().getPhoneModuleState() != 0;
        }
        return false;
    }

    private static boolean isDataModeCurrentlySupported(IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        return iGlobalTelephoneStateStruct != null && iGlobalTelephoneStateStruct.getNadInstanceState() != null && TelBAPManagerTel2Utils.telModeSupportsData(iGlobalTelephoneStateStruct.getNadInstanceState().getTelMode());
    }

    private static boolean isRegisterStateSupported(IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        return BAPPropertyTel2MobileServiceSupport.isNADAvailable(iGlobalTelephoneStateStruct);
    }

    private static boolean isLockStateSupported(IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        return BAPPropertyTel2MobileServiceSupport.isNADAvailable(iGlobalTelephoneStateStruct);
    }

    private static boolean isNetworkProviderSupported(IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        return BAPPropertyTel2MobileServiceSupport.isNADAvailable(iGlobalTelephoneStateStruct) && BAPPropertyTel2MobileServiceSupport.isDataModeCurrentlySupported(iGlobalTelephoneStateStruct);
    }

    private static boolean isSignalQualitySupported(IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        return BAPPropertyTel2MobileServiceSupport.isNADAvailable(iGlobalTelephoneStateStruct) && BAPPropertyTel2MobileServiceSupport.isDataModeCurrentlySupported(iGlobalTelephoneStateStruct);
    }

    BAPPropertyTel2MobileServiceSupport(ITelApplication iTelApplication, DispatcherBase dispatcherBase) {
        super(iTelApplication, dispatcherBase);
    }

    @Override
    protected boolean doProcessGlobalTelephoneStateUpdate(int n, IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        return iGlobalTelephoneStateStruct != null;
    }

    private boolean checkSupportedServicesChanged(boolean[] blArray) {
        if (!Arrays.equals(this.supportedServices, blArray)) {
            this.supportedServices = blArray;
            return true;
        }
        return false;
    }

    @Override
    protected void updateAsync() {
        CombiBAPServicePhone2 combiBAPServicePhone2 = this.getCombiService();
        IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct = this.getTelephoneState();
        if (combiBAPServicePhone2 == null) {
            this.log.log(-1601830656, "[BAPPropertyTel2MobileServiceSupport#update] CombiBAPServicePhone is null --> NOP!");
            return;
        }
        if (iGlobalTelephoneStateStruct == null) {
            this.log.log(-1601830656, "[BAPPropertyTel2MobileServiceSupport#update] state is null --> NOP!");
            return;
        }
        if (iGlobalTelephoneStateStruct.getNadInstanceState() != null) {
            if (TelBAPManagerTel2Utils.telModeSupportsData(iGlobalTelephoneStateStruct.getNadInstanceState().getTelMode()) || !iGlobalTelephoneStateStruct.getNadInstanceState().isPhoneReady()) {
                boolean[] blArray = new boolean[]{true, BAPPropertyTel2MobileServiceSupport.isRegisterStateSupported(iGlobalTelephoneStateStruct), BAPPropertyTel2MobileServiceSupport.isLockStateSupported(iGlobalTelephoneStateStruct), BAPPropertyTel2MobileServiceSupport.isNetworkProviderSupported(iGlobalTelephoneStateStruct), BAPPropertyTel2MobileServiceSupport.isSignalQualitySupported(iGlobalTelephoneStateStruct), true, true};
                if (this.checkSupportedServicesChanged(blArray)) {
                    this.log.log(1078071040, "[BAPPropertyTel2MobileServiceSupport#update] %1", (Object)BAPPropertyTel2MobileServiceSupport.getSupportedServiceArrayBuffer(this.supportedServices));
                    combiBAPServicePhone2.updateMobileServiceSupport(this.supportedServices);
                }
            } else {
                this.log.log(-1601830656, "[BAPPropertyTel2MobileServiceSupport#update] Invalid TelMode=%1 --> NOP!", (long)iGlobalTelephoneStateStruct.getNadInstanceState().getTelMode());
            }
        } else {
            this.log.log(-1601830656, "[BAPPropertyTel2MobileServiceSupport#update] NAD Instance is null --> NOP!");
        }
    }
}

