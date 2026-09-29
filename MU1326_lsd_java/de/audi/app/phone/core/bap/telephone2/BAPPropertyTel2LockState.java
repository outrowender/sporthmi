/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.bap.telephone2;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.PhoneServiceProvider;
import de.audi.app.phone.core.bap.telephone2.AbstractTel2EnqueuedBAPPropertyHandler;
import de.audi.app.phone.core.bap.telephone2.IBAPPropertyTel2LockStateService;
import de.audi.app.phone.core.bap.telephone2.TelBAPManagerTel2Utils;
import de.audi.app.phone.core.state.IGlobalTelephoneStateStruct;
import de.audi.atip.interapp.combi.bap.phone.CombiBAPServicePhone2;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.commons.job.DispatcherBase;

class BAPPropertyTel2LockState
extends AbstractTel2EnqueuedBAPPropertyHandler
implements IBAPPropertyTel2LockStateService {
    protected static final int LOCK_STATE_PUK_REQUIRED_ENTER_NEW_PIN;
    private static final int LOCK_STATE_NO_LOCK;
    private static final int LOCK_STATE_REQUIRE_PIN;
    private static final int LOCK_STATE_REQUIRE_PIN2;
    private static final int LOCK_STATE_PIN_BLOCKED_REQUIRE_PUK;
    private static final int LOCK_STATE_PIN2BLOCKED_REQUIRE_PUK2;
    private static final int LOCK_STATE_PUK_BLOCKED;
    private static final int LOCK_STATE_PUK2BLOCKED;
    private static final int LOCK_STATE_KEYPAD_BLOCKED;
    private static final int LOCK_STATE_SIM_NOT_AVAILABLE_NOT_PLUGGED_IN;
    private static final int LOCK_STATE_PI_NINVALID;
    private static final int LOCK_STATE_PIN2INVALID;
    private static final int LOCK_STATE_SI_MNOT_FUNCTIONAL_NOT_READABLE_OR_NOT_FUNCTIONAL;
    private static final int LOCK_STATE_SI_MNOT_READY_CHECKING_SIM_CARD;
    private static final int LOCK_STATE_REQUIRE_LOCK_CODE_CDMA_TDMA;
    private static final int LOCK_STATE_REQUIRE_SECURITY_CODE;
    private static final int LOCK_STATE_SECURITY_CODE_BLOCKED;
    private volatile PhoneServiceProvider lockStateServiceProvider;
    private volatile int clusterLockState = -1;
    static /* synthetic */ Class class$de$audi$app$phone$core$bap$telephone2$IBAPPropertyTel2LockStateService;

    protected static int getLockState(int n, int n2, int n3) {
        if (!TelBAPManagerTel2Utils.telModeSupportsData(n3)) {
            return 8;
        }
        int n4 = 8;
        switch (n) {
            case 9: {
                n4 = 11;
                break;
            }
            case 7: {
                n4 = 12;
                break;
            }
            case 0: {
                n4 = 8;
                break;
            }
            case 12: {
                n4 = 8;
                break;
            }
            case 1: {
                n4 = 8;
                break;
            }
            case 4: {
                n4 = 8;
                break;
            }
            case 2: 
            case 5: {
                n4 = BAPPropertyTel2LockState.computeLockState(n2);
                break;
            }
            default: {
                n4 = 8;
            }
        }
        return n4;
    }

    private static int computeLockState(int n) {
        switch (n) {
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

    private static boolean isPhoneReady(int n, int n2) {
        return (n == 5 || n == 2) && n2 == 2;
    }

    BAPPropertyTel2LockState(ITelApplication iTelApplication, DispatcherBase dispatcherBase) {
        super(iTelApplication, dispatcherBase);
    }

    @Override
    public void init() {
        super.init();
        this.lockStateServiceProvider = new PhoneServiceProvider((class$de$audi$app$phone$core$bap$telephone2$IBAPPropertyTel2LockStateService == null ? (class$de$audi$app$phone$core$bap$telephone2$IBAPPropertyTel2LockStateService = BAPPropertyTel2LockState.class$("de.audi.app.phone.core.bap.telephone2.IBAPPropertyTel2LockStateService")) : class$de$audi$app$phone$core$bap$telephone2$IBAPPropertyTel2LockStateService).getName(), this, null, this.getApplication().getBundleContext(), this.log);
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
        return iGlobalTelephoneStateStruct != null;
    }

    private void updateCluster(int n, int n2, int n3) {
        CombiBAPServicePhone2 combiBAPServicePhone2 = this.getCombiService();
        boolean bl = BAPPropertyTel2LockState.isPhoneReady(n, n2);
        if (combiBAPServicePhone2 != null) {
            int n4 = BAPPropertyTel2LockState.getLockState(n, n2, n3);
            if (this.clusterLockState != n4) {
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
                    this.log.log(1078071040, "[BAPPropertyTel2LockState#updateCluster] %1", (Object)buffer);
                }
                if (TelBAPManagerTel2Utils.telModeSupportsData(n3) || !bl) {
                    combiBAPServicePhone2.updateLockState(n4);
                    this.clusterLockState = n4;
                }
            }
        } else {
            this.log.log(-1601830656, "[BAPPropertyTel2LockState#updateCluster] CombiBAPServicePhone2 is null --> NOP!");
        }
    }

    @Override
    public void updateLockStatePUKNewPINRequired() {
        this.log.log(1078071040, "[BAPPropertyTel2LockState#updateLockStatePUKNewPINRequired]");
        IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct = this.getTelephoneState();
        if (iGlobalTelephoneStateStruct != null && iGlobalTelephoneStateStruct.getNadInstanceState() != null) {
            if (iGlobalTelephoneStateStruct.getNadInstanceState().getActivationState() != null) {
                int n = iGlobalTelephoneStateStruct.getNadInstanceState().getActivationState().getTelActivationState();
                int n2 = iGlobalTelephoneStateStruct.getNadInstanceState().getTelMode();
                this.updateCluster(n, 255, n2);
            }
        } else {
            this.log.log(-1601830656, "[BAPPropertyTel2LockState#updateLockStatePUKNewPINRequired] state is null --> NOP!");
        }
    }

    @Override
    protected void updateAsync() {
        IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct = this.getTelephoneState();
        if (iGlobalTelephoneStateStruct != null && iGlobalTelephoneStateStruct.getNadInstanceState() != null) {
            if (iGlobalTelephoneStateStruct.getNadInstanceState().getActivationState() != null && iGlobalTelephoneStateStruct.getNadInstanceState().getLockState() != null && iGlobalTelephoneStateStruct.getNadInstanceState().getLockState().getTelLockState() != 1) {
                int n = iGlobalTelephoneStateStruct.getNadInstanceState().getActivationState().getTelActivationState();
                int n2 = iGlobalTelephoneStateStruct.getNadInstanceState().getLockState().getTelLockState();
                int n3 = iGlobalTelephoneStateStruct.getNadInstanceState().getTelMode();
                this.updateCluster(n, n2, n3);
            }
        } else {
            this.log.log(10000, "AbstractTel2EnqueuedBAPPropertyHandler#updateAsync telState or NAD instance state is null");
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

