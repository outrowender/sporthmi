/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.bap.telephone;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.PhoneServiceProvider;
import de.audi.app.phone.core.bap.AbstractTel1EnqueuedBAPPropertyHandler;
import de.audi.app.phone.core.bap.telephone.IBAPPropertyTelLockStateService;
import de.audi.app.phone.core.dsi.ITelDSIMobileEquipmentDeviceState;
import de.audi.app.phone.core.state.IGlobalTelephoneStateStruct;
import de.audi.atip.interapp.combi.bap.phone.CombiBAPServicePhone;
import de.audi.atip.interapp.phone.IEcallState;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.commons.job.DispatcherBase;

public class BAPPropertyTelLockState
extends AbstractTel1EnqueuedBAPPropertyHandler
implements IBAPPropertyTelLockStateService {
    protected static final int LOCK_STATE_PUK_REQUIRED_ENTER_NEW_PIN;
    private static final int LOCK_STATE_NO_LOCK;
    private static final int LOCK_STATE_REQUIRE_PIN;
    private static final int LOCK_STATE_REQUIRE_PIN2;
    private static final int LOCK_STATE_PIN_BLOCKED_REQUIRE_PUK;
    private static final int LOCK_STATE_PIN2BLOCKED_REQUIRE_PUK2;
    private static final int LOCK_STATE_PUK_BLOCKED;
    private static final int LOCK_STATE_PUK2BLOCKED;
    private static final int LOCK_STATE_SIM_NOT_AVAILABLE_NOT_PLUGGED_IN;
    private static final int LOCK_STATE_PI_NINVALID;
    private static final int LOCK_STATE_SI_MNOT_FUNCTIONAL_NOT_READABLE_OR_NOT_FUNCTIONAL;
    private static final int LOCK_STATE_SI_MNOT_READY_CHECKING_SIM_CARD;
    private static final int LOCK_STATE_REQUIRE_SECURITY_CODE;
    private static final int LOCK_STATE_SECURITY_CODE_BLOCKED;
    private volatile PhoneServiceProvider lockStateServiceProvider;
    private volatile int currentCombiLockState = -1;
    static /* synthetic */ Class class$de$audi$app$phone$core$bap$telephone$IBAPPropertyTelLockStateService;

    protected static int getLockState(int n, int n2, int n3) {
        switch (n) {
            case 9: {
                return 11;
            }
            case 7: {
                return BAPPropertyTelLockState.calculateLockStateOnAttachedNotReady(n3);
            }
            case 0: {
                return 8;
            }
            case 12: {
                return 8;
            }
            case 1: {
                return 8;
            }
            case 4: {
                return 8;
            }
            case 2: 
            case 5: {
                switch (n2) {
                    case 255: {
                        return 9;
                    }
                    case 2: {
                        return 0;
                    }
                    case 3: {
                        return 1;
                    }
                    case 4: {
                        return 2;
                    }
                    case 7: {
                        return 5;
                    }
                    case 5: {
                        return 3;
                    }
                    case 8: {
                        return 6;
                    }
                    case 6: {
                        return 4;
                    }
                    case 10: {
                        return 15;
                    }
                    case 9: {
                        return 14;
                    }
                    case 11: {
                        return 11;
                    }
                }
                return 8;
            }
        }
        return 8;
    }

    private static int calculateLockStateOnAttachedNotReady(int n) {
        int n2 = 12;
        if (n == 0 || n == 2 || n == 1) {
            n2 = 12;
        } else if (n == 3) {
            n2 = 0;
        }
        return n2;
    }

    public BAPPropertyTelLockState(ITelApplication iTelApplication, DispatcherBase dispatcherBase) {
        super(iTelApplication, dispatcherBase);
    }

    @Override
    public void init() {
        super.init();
        this.lockStateServiceProvider = new PhoneServiceProvider((class$de$audi$app$phone$core$bap$telephone$IBAPPropertyTelLockStateService == null ? (class$de$audi$app$phone$core$bap$telephone$IBAPPropertyTelLockStateService = BAPPropertyTelLockState.class$("de.audi.app.phone.core.bap.telephone.IBAPPropertyTelLockStateService")) : class$de$audi$app$phone$core$bap$telephone$IBAPPropertyTelLockStateService).getName(), this, null, this.getApplication().getBundleContext(), this.log);
        this.lockStateServiceProvider.startService();
    }

    @Override
    public void deinit() {
        super.deinit();
        if (this.lockStateServiceProvider != null) {
            this.lockStateServiceProvider.stopService();
            this.lockStateServiceProvider = null;
        }
    }

    @Override
    protected boolean doProcessGlobalTelephoneStateUpdate(int n, IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        return iGlobalTelephoneStateStruct != null && iGlobalTelephoneStateStruct.getCallLeadingDevice() != null;
    }

    @Override
    protected void updateAsync() {
        boolean bl;
        IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct = this.getTelephoneState();
        IEcallState iEcallState = iGlobalTelephoneStateStruct != null ? iGlobalTelephoneStateStruct.getConnectedGatewayState() : null;
        boolean bl2 = bl = iEcallState != null && iEcallState.isLowPrioritySOSEmergencyCallType();
        if (bl) {
            this.getCombiService().updateLockState(0);
            return;
        }
        ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState = this.getCallLeadingDeviceState();
        if (iTelDSIMobileEquipmentDeviceState != null && iTelDSIMobileEquipmentDeviceState.getActivationState() != null && iTelDSIMobileEquipmentDeviceState.getLockState() != null && iTelDSIMobileEquipmentDeviceState.getLockState().getTelLockState() != 1) {
            int n = iTelDSIMobileEquipmentDeviceState.getActivationState().getTelActivationState();
            int n2 = iTelDSIMobileEquipmentDeviceState.getLockState().getTelLockState();
            int n3 = iTelDSIMobileEquipmentDeviceState.getTelMode();
            this.updateCluster(n, n2, n3);
        }
    }

    private void updateCluster(int n, int n2, int n3) {
        CombiBAPServicePhone combiBAPServicePhone = this.getCombiService();
        if (combiBAPServicePhone != null) {
            int n4 = BAPPropertyTelLockState.getLockState(n, n2, n3);
            if (n4 != this.currentCombiLockState) {
                if (this.log.isInfo()) {
                    Buffer buffer = new Buffer();
                    buffer.append("activationState=");
                    buffer.append(n);
                    buffer.append(", lockState=");
                    buffer.append(n2);
                    buffer.append(", telMode=");
                    buffer.append(n3);
                    buffer.append(" --> clusterLockState=");
                    buffer.append(n4);
                    this.log.log(1078071040, "[BAPPropertyTelLockState#updateCluster] %1", (Object)buffer);
                }
                combiBAPServicePhone.updateLockState(n4);
                this.currentCombiLockState = n4;
            }
        } else {
            this.log.log(-1601830656, "[BAPPropertyTelLockState#updateCluster] CombiBAPServicePhone is null --> NOP!");
        }
    }

    @Override
    public void updateLockStatePUKNewPINRequired() {
        this.log.log(1078071040, "[BAPPropertyTelLockState#updateLockStatePUKNewPINRequired]");
        IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct = this.getTelephoneState();
        if (iGlobalTelephoneStateStruct != null && iGlobalTelephoneStateStruct.getActivationState() != null) {
            int n = iGlobalTelephoneStateStruct.getActivationState().getTelActivationState();
            int n2 = iGlobalTelephoneStateStruct.getTelMode();
            this.updateCluster(n, 255, n2);
        } else {
            this.log.log(10000, "BAPPropertyTelLockState#updateLockStatePUKNewPINRequired state or activation state is null");
        }
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

