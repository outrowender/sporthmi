/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.mib.swdiagnosis.phone.IPhoneDiagComponent
 */
package de.audi.app.phone.core.sim;

import de.audi.app.phone.core.AbstractPhoneComponent;
import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.dsi.TelDefaultDSIResponseListener;
import de.audi.app.phone.core.state.IGlobalTelephoneStateStruct;
import de.mib.swdiagnosis.phone.IPhoneDiagComponent;
import org.dsi.ifc.telephoneng.LockStateStruct;

public abstract class AbstractTelLockStateDSIHandler
extends AbstractPhoneComponent {
    static final int STATE_UNKNOWN = 0;
    static final int STATE_NO_LOCK = 1;
    static final int STATE_UNLOCK_IN_PROGRESS = 2;
    static final int STATE_PIN_REQUIRED = 3;
    static final int STATE_PIN_REQUIRED_WRONG_PIN_ENTERED = 4;
    static final int STATE_PUK_REQUIRED = 5;
    static final int STATE_PUK_REQUIRED_WRONG_PIN_ENTERED_PUK_REQUIRED = 6;
    static final int STATE_PUK_REQUIRED_WRONG_PUK_ENTERED = 7;
    static final int STATE_PUK_BLOCKED = 8;
    static final int STATE_SIM_NOT_FUNC = 9;
    private volatile LockStateStruct lockStateStruct;
    private volatile boolean manualUnlockInProgress;
    private volatile int internalLockState = 0;
    private volatile IGlobalTelephoneStateStruct telephoneState;

    protected static String getStateName(int n) {
        switch (n) {
            case 0: {
                return "STATE_UNKNOWN";
            }
            case 1: {
                return "STATE_NO_LOCK";
            }
            case 2: {
                return "STATE_UNLOCK_IN_PROGRESS";
            }
            case 3: {
                return "STATE_PIN_REQUIRED";
            }
            case 4: {
                return "STATE_PIN_REQUIRED_WRONG_PIN_ENTERED";
            }
            case 5: {
                return "STATE_PUK_REQUIRED";
            }
            case 6: {
                return "STATE_PUK_REQUIRED_WRONG_PIN_ENTERED_PUK_REQUIRED";
            }
            case 7: {
                return "STATE_PUK_REQUIRED_WRONG_PUK_ENTERED";
            }
            case 8: {
                return "STATE_PUK_BLOCKED";
            }
            case 9: {
                return "STATE_SIM_NOT_FUNC";
            }
        }
        return new StringBuffer().append("Unknown state ").append(n).toString();
    }

    public AbstractTelLockStateDSIHandler(ITelApplication iTelApplication) {
        super(iTelApplication, "App.Phone.LockState");
    }

    public void init() {
        super.init();
        this.getApplication().getGlobalTelephoneStateManager().registerListener(this);
        this.getApplication().addDiagnosisComponent(new LockStateDiag());
    }

    public void deinit() {
        super.deinit();
        this.getApplication().getGlobalTelephoneStateManager().removeListener(this);
    }

    public void updateGlobalTelephoneStateProperty(int n, IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        this.telephoneState = iGlobalTelephoneStateStruct;
        if (this.processLockStateUpdate(n, iGlobalTelephoneStateStruct)) {
            LockStateStruct lockStateStruct = this.getLockStateStruct(iGlobalTelephoneStateStruct);
            if (lockStateStruct != null) {
                if (this.hasChanged(lockStateStruct)) {
                    this.updateLockState(lockStateStruct);
                } else {
                    this.log.log(1000000, "[AbstractTelLockStateDSIHandler#updateGlobalTelephoneStateProperty] lock state has not changed, ignoring update %1", (Object)lockStateStruct);
                }
            } else {
                this.log.log(100000, "[AbstractTelLockStateDSIHandler#updateGlobalTelephoneStateProperty] lock state is null --> NOP!");
            }
        }
    }

    private boolean hasChanged(LockStateStruct lockStateStruct) {
        if (this.lockStateStruct == null) {
            return true;
        }
        if (lockStateStruct == null) {
            return false;
        }
        return this.lockStateStruct.getTelLockState() != lockStateStruct.getTelLockState() || this.lockStateStruct.getTelRetryCounter() != lockStateStruct.getTelRetryCounter();
    }

    protected IGlobalTelephoneStateStruct getTelephoneState() {
        return this.telephoneState;
    }

    private void setInternalLockState(int n) {
        this.log.log(1000000, "[AbstractTelLockStateDSIHandler#setInternalLockState] state=%1", (Object)AbstractTelLockStateDSIHandler.getStateName(n));
        this.internalLockState = n;
    }

    int getInternalLockState() {
        return this.internalLockState;
    }

    protected void updateLockState(LockStateStruct lockStateStruct) {
        this.lockStateStruct = lockStateStruct;
        int n = lockStateStruct.getTelLockState();
        switch (n) {
            case 0: {
                this.setInternalLockState(0);
                this.processLockStateUnknown();
                break;
            }
            case 2: {
                if (this.manualUnlockInProgress) {
                    this.log.log(1000000, "[AbstractTelLockStateDSIHandler#updateLockState] LOCKSTATE_NO_LOCK but manual unlock in progress, waiting for result");
                    break;
                }
                this.setInternalLockState(1);
                this.processNoLock(false);
                break;
            }
            case 3: {
                if (this.manualUnlockInProgress) {
                    this.log.log(1000000, "[AbstractTelLockStateDSIHandler#updateLockState] LOCKSTATE_PIN_REQUIRED but manual unlock in progress, waiting for result");
                    break;
                }
                this.setInternalLockState(3);
                this.processPINRequired(lockStateStruct.getTelRetryCounter());
                break;
            }
            case 5: {
                if (this.manualUnlockInProgress) {
                    this.log.log(1000000, "[AbstractTelLockStateDSIHandler#updateLockState] LOCKSTATE_PUK_REQUIRED but manual unlock in progress, waiting for result");
                    break;
                }
                this.setInternalLockState(5);
                this.processPUKRequired(lockStateStruct.getTelRetryCounter());
                break;
            }
            case 7: {
                if (this.manualUnlockInProgress) {
                    this.log.log(1000000, "[AbstractTelLockStateDSIHandler#updateLockState] LOCKSTATE_PUK_BLOCKED, but manual unlock in progress, waiting for result");
                    break;
                }
                this.setInternalLockState(8);
                this.processPUKBlocked();
                break;
            }
            case 11: {
                this.setInternalLockState(9);
                this.processSIMNotFunctioning();
                break;
            }
            case 1: {
                this.log.log(10000000, "[AbstractTelLockStateDSIHandler#updateLockState] LOCKSTATE_UNLOCK_INPR");
                break;
            }
            default: {
                this.log.log(1000000, "PhoneLockStateHandler#updateLockState: Unhandled lockState %1 ", (long)n);
                this.setInternalLockState(0);
                this.processUnhandledLockState(n);
            }
        }
    }

    protected abstract boolean processLockStateUpdate(int var1, IGlobalTelephoneStateStruct var2);

    protected abstract LockStateStruct getLockStateStruct(IGlobalTelephoneStateStruct var1);

    protected abstract void processWrongPINEntered(int var1, int var2);

    protected abstract void processWrongPINEnteredPUKRequired(int var1, int var2);

    protected abstract void processWrongPUKEntered(int var1, int var2);

    protected abstract void processSIMNotFunctioning();

    protected abstract void processPUKBlocked();

    protected abstract void processManualUnlockInProgress(boolean var1);

    protected abstract void processLockStateUnknown();

    protected abstract void processNoLock(boolean var1);

    protected abstract void processPINRequired(int var1);

    protected abstract void processPUKRequired(int var1);

    protected abstract void processUnhandledLockState(int var1);

    protected final void unlockSIMwithPIN(String string, int n) {
        this.log.log(1000000, "[AbstractTelLockStateDSIHandler#unlockSIMwithPIN] pin=%1", (Object)string);
        this.manualUnlockInProgress = true;
        this.processManualUnlockInProgress(true);
        this.getApplication().getTelephoneDSIAccess().unlockSIMWithPIN(string, n, true, new TelLockStateResponseListener(0));
    }

    protected final void unlockSIMWithPUK(String string, String string2, int n) {
        this.log.log(1000000, "[AbstractTelLockStateDSIHandler#unlockSIMWithPUK] pukCode=%1, newPinCode=%2, terminalID=%3", (Object)string, (Object)string2, (long)n);
        this.manualUnlockInProgress = true;
        this.processManualUnlockInProgress(true);
        this.getApplication().getTelephoneDSIAccess().unlockSIMWithPUK(string, string2, n, true, new TelLockStateResponseListener(1));
    }

    public class LockStateDiag
    implements IPhoneDiagComponent {
        public void cmdUnlockSIMWithPIN(String string) {
            AbstractTelLockStateDSIHandler.this.unlockSIMwithPIN(string, 0);
        }

        public void cmdUnlockSIMWithPUK(String string, String string2) {
            AbstractTelLockStateDSIHandler.this.unlockSIMWithPUK(string, string2, 0);
        }
    }

    private class TelLockStateResponseListener
    extends TelDefaultDSIResponseListener {
        static final int UNLOCK_TYPE_PIN = 0;
        static final int UNLOCK_TYPE_PUK = 1;
        private final int unlockType;

        public TelLockStateResponseListener(int n) {
            this.unlockType = n;
        }

        public void responseUnlockSIM(int n, int n2, LockStateStruct lockStateStruct) {
            AbstractTelLockStateDSIHandler.this.log.log(1000000, "[AbstractTelLockStateDSIHandler.TelLockStateResponseListener#responseUnlockSIM] result=%2, terminalID=%3, lockState=%1", (Object)lockStateStruct, (long)n, (long)n2);
            AbstractTelLockStateDSIHandler.this.lockStateStruct = lockStateStruct;
            switch (n) {
                case 5: {
                    AbstractTelLockStateDSIHandler.this.log.log(1000000, "[AbstractTelLockStateDSIHandler.TelLockStateResponseListener#responseUnlockSIM] RESULT_ERROR_CODE_WRONG");
                    this.processWrongCodeEntered(n2, lockStateStruct);
                    break;
                }
                case 9: {
                    AbstractTelLockStateDSIHandler.this.log.log(1000000, "[AbstractTelLockStateDSIHandler.TelLockStateResponseListener#responseUnlockSIM] RESULT_ERROR_CODE_INVALID_FORMAT");
                    this.processWrongCodeEntered(n2, lockStateStruct);
                    break;
                }
                case 0: {
                    int n3 = lockStateStruct.getTelLockState();
                    if (n3 == 2) {
                        AbstractTelLockStateDSIHandler.this.setInternalLockState(1);
                        AbstractTelLockStateDSIHandler.this.processNoLock(AbstractTelLockStateDSIHandler.this.manualUnlockInProgress);
                        break;
                    }
                    AbstractTelLockStateDSIHandler.this.log.log(100000, "[AbstractTelLockStateDSIHandler.TelLockStateResponseListener#responseUnlockSIM] RESULT_OK but telLockState=%1", (long)n3);
                    break;
                }
                default: {
                    AbstractTelLockStateDSIHandler.this.log.log(100000, "[AbstractTelLockStateDSIHandler.TelLockStateResponseListener#responseUnlockSIM] no processing for result %1", (long)n);
                }
            }
            AbstractTelLockStateDSIHandler.this.manualUnlockInProgress = false;
            AbstractTelLockStateDSIHandler.this.processManualUnlockInProgress(false);
        }

        protected void processWrongCodeEntered(int n, LockStateStruct lockStateStruct) {
            int n2 = lockStateStruct.getTelLockState();
            int n3 = lockStateStruct.getTelRetryCounter();
            switch (n2) {
                case 3: {
                    AbstractTelLockStateDSIHandler.this.setInternalLockState(4);
                    AbstractTelLockStateDSIHandler.this.processWrongPINEntered(n3, n);
                    break;
                }
                case 5: {
                    if (this.unlockType == 0) {
                        AbstractTelLockStateDSIHandler.this.setInternalLockState(6);
                        AbstractTelLockStateDSIHandler.this.processWrongPINEnteredPUKRequired(n3, n);
                        break;
                    }
                    AbstractTelLockStateDSIHandler.this.setInternalLockState(7);
                    AbstractTelLockStateDSIHandler.this.processWrongPUKEntered(n3, n);
                    break;
                }
                case 7: {
                    AbstractTelLockStateDSIHandler.this.setInternalLockState(8);
                    AbstractTelLockStateDSIHandler.this.processPUKBlocked();
                    break;
                }
                default: {
                    AbstractTelLockStateDSIHandler.this.log.log(100000, "[AbstractTelLockStateDSIHandler.TelLockStateResponseListener#responseUnlockSIM] no handling for current lock state %1", (long)n2);
                }
            }
        }
    }
}

