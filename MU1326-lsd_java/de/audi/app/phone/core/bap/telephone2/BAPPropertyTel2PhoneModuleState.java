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

public class BAPPropertyTel2PhoneModuleState
extends AbstractTel2EnqueuedBAPPropertyHandler {
    private static int getModuleState(IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        if (iGlobalTelephoneStateStruct != null) {
            int n = iGlobalTelephoneStateStruct.getNadInstanceState() != null && iGlobalTelephoneStateStruct.getNadInstanceState().getActivationState() != null ? iGlobalTelephoneStateStruct.getNadInstanceState().getPhoneModuleState() : 0;
            switch (n) {
                case 0: 
                case 6: {
                    return 0;
                }
                case 5: {
                    return 5;
                }
                case 3: 
                case 4: {
                    return 1;
                }
                case 1: {
                    return 6;
                }
                case 2: {
                    return 2;
                }
                case 8: {
                    return 3;
                }
                case 7: {
                    return 4;
                }
            }
            return 0;
        }
        return 0;
    }

    private static int getModuleSupportedServices(IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        if (iGlobalTelephoneStateStruct != null) {
            switch (iGlobalTelephoneStateStruct.getNadMode()) {
                case 0: {
                    return 0;
                }
                case 1: {
                    return 1;
                }
                case 2: {
                    return 3;
                }
                case 3: {
                    return 2;
                }
            }
            return 0;
        }
        return 0;
    }

    private static int getModuleActiveServices(IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        if (iGlobalTelephoneStateStruct != null) {
            int n = iGlobalTelephoneStateStruct.getNadMode();
            if (n == 1 && iGlobalTelephoneStateStruct.getNadInstanceState() != null) {
                int n2 = iGlobalTelephoneStateStruct.getNadInstanceState().getTelMode();
                if (TelBAPManagerTel2Utils.telModeSupportsData(n2)) {
                    return 1;
                }
            } else {
                if (n == 2) {
                    return 3;
                }
                return 0;
            }
        }
        return 0;
    }

    private static int getSIMState(IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        if (iGlobalTelephoneStateStruct != null) {
            int n = iGlobalTelephoneStateStruct.getNadInstanceState() != null ? iGlobalTelephoneStateStruct.getNadInstanceState().getTelMode() : 4;
            switch (n) {
                case 0: 
                case 1: 
                case 2: {
                    return 2;
                }
                case 3: 
                case 4: {
                    return 1;
                }
            }
            return 0;
        }
        return 0;
    }

    BAPPropertyTel2PhoneModuleState(ITelApplication iTelApplication, DispatcherBase dispatcherBase) {
        super(iTelApplication, dispatcherBase);
    }

    @Override
    protected boolean doProcessGlobalTelephoneStateUpdate(int n, IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        return iGlobalTelephoneStateStruct != null && (n == 0x3000300 || n == 0x3000100 || n == 0x3000200 || n == 0x3000400);
    }

    @Override
    protected void updateAsync() {
        CombiBAPServicePhone2 combiBAPServicePhone2 = this.getCombiService();
        IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct = this.getTelephoneState();
        if (combiBAPServicePhone2 == null) {
            this.log.log(-1601830656, "[BAPPropertyTel2PhoneModuleState#update] CombiBAPServicePhone is null --> NOP!");
            return;
        }
        if (iGlobalTelephoneStateStruct == null) {
            this.log.log(-1601830656, "[BAPPropertyTel2PhoneModuleState#update] state is null --> NOP!");
            return;
        }
        int n = BAPPropertyTel2PhoneModuleState.getModuleState(iGlobalTelephoneStateStruct);
        int n2 = BAPPropertyTel2PhoneModuleState.getModuleSupportedServices(iGlobalTelephoneStateStruct);
        int n3 = BAPPropertyTel2PhoneModuleState.getModuleActiveServices(iGlobalTelephoneStateStruct);
        int n4 = BAPPropertyTel2PhoneModuleState.getSIMState(iGlobalTelephoneStateStruct);
        if (this.log.isInfo()) {
            Buffer buffer = new Buffer();
            buffer.append("moduleState=");
            buffer.append(n);
            buffer.append(", moduleSupportedServices=");
            buffer.append(n2);
            buffer.append(", moduleActiveServices=");
            buffer.append(n3);
            buffer.append(", simState=");
            buffer.append(n4);
            this.log.log(1078071040, "[BAPPropertyTel2PhoneModuleState#update] %1", (Object)buffer);
        }
        combiBAPServicePhone2.updatePhoneModuleState(n, n2, n3, n4);
    }
}

