/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.bap.telephone;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.bap.AbstractTel1EnqueuedBAPPropertyHandler;
import de.audi.app.phone.core.state.IGlobalTelephoneStateStruct;
import de.audi.atip.interapp.combi.bap.phone.CombiBAPServicePhone;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.commons.job.DispatcherBase;
import org.dsi.ifc.telephoneng.ActivationStateStruct;

public class BAPPropertyTelSupportedServiceNumbers
extends AbstractTel1EnqueuedBAPPropertyHandler {
    public BAPPropertyTelSupportedServiceNumbers(ITelApplication iTelApplication, DispatcherBase dispatcherBase) {
        super(iTelApplication, dispatcherBase);
    }

    protected boolean doProcessGlobalTelephoneStateUpdate(int n, IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        return iGlobalTelephoneStateStruct != null && (n == 262155 || n == 262145 || n == 65552 || n == 65551 || n == 65539);
    }

    protected void updateAsync() {
        CombiBAPServicePhone combiBAPServicePhone = this.getCombiService();
        IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct = this.getTelephoneState();
        if (combiBAPServicePhone != null) {
            if (iGlobalTelephoneStateStruct != null) {
                boolean bl;
                boolean bl2 = iGlobalTelephoneStateStruct.isMailboxNumberAvailable();
                boolean bl3 = iGlobalTelephoneStateStruct.isInfoCallSupported();
                boolean bl4 = iGlobalTelephoneStateStruct.isBreakdownCallSupported();
                boolean bl5 = bl = this.isEmergencyCallSupported(iGlobalTelephoneStateStruct) && iGlobalTelephoneStateStruct.isEmergencyNumberAvailable();
                if (this.log.isInfo()) {
                    Buffer buffer = new Buffer();
                    buffer.append("voiceMailboxSupported=");
                    buffer.append(bl2);
                    buffer.append(", infoCallSupported=");
                    buffer.append(bl3);
                    buffer.append(", serviceCallSupported=");
                    buffer.append(bl4);
                    buffer.append(", emergencyCallSupported=");
                    buffer.append(bl);
                    this.log.log(1000000, "[BAPPropertyTelSupportedServiceNumbers#update] %1", (Object)buffer);
                }
                combiBAPServicePhone.updateSupportedServiceNumbers(bl2, bl3, bl4, bl);
            } else {
                this.log.log(100000, "[BAPPropertyTelSupportedServiceNumbers#update] state is null --> NOP!");
            }
        } else {
            this.log.log(100000, "[BAPPropertyTelSupportedServiceNumbers#update] CombiBAPServicePhone is null --> NOP!");
        }
    }

    protected boolean isEmergencyCallSupported(IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        if (iGlobalTelephoneStateStruct != null) {
            ActivationStateStruct activationStateStruct = iGlobalTelephoneStateStruct.getActivationState();
            if (activationStateStruct != null) {
                boolean bl;
                boolean bl2 = iGlobalTelephoneStateStruct.getPhoneModuleState() == 2;
                boolean bl3 = bl = (activationStateStruct.getTelActivationState() == 5 || activationStateStruct.getTelActivationState() == 2) && iGlobalTelephoneStateStruct.getLockState() != null && iGlobalTelephoneStateStruct.getLockState().getTelLockState() == 2;
                if (bl2) {
                    return true;
                }
                if (bl) {
                    return true;
                }
            }
        } else {
            this.log.log(10000, "BAPPropertyTelSupportedServiceNumbers#isEmergencyCallSupported state is null");
        }
        return false;
    }
}

