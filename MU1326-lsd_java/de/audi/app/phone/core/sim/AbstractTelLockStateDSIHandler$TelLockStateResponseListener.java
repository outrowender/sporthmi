/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.sim;

import de.audi.app.phone.core.dsi.TelDefaultDSIResponseListener;
import de.audi.app.phone.core.sim.AbstractTelLockStateDSIHandler;
import org.dsi.ifc.telephoneng.LockStateStruct;

class AbstractTelLockStateDSIHandler$TelLockStateResponseListener
extends TelDefaultDSIResponseListener {
    static final int UNLOCK_TYPE_PIN;
    static final int UNLOCK_TYPE_PUK;
    private final int unlockType;
    private final /* synthetic */ AbstractTelLockStateDSIHandler this$0;

    public AbstractTelLockStateDSIHandler$TelLockStateResponseListener(AbstractTelLockStateDSIHandler abstractTelLockStateDSIHandler, int n) {
        this.this$0 = abstractTelLockStateDSIHandler;
        this.unlockType = n;
    }

    @Override
    public void responseUnlockSIM(int n, int n2, LockStateStruct lockStateStruct) {
        AbstractTelLockStateDSIHandler.access$000(this.this$0).log(1078071040, "[AbstractTelLockStateDSIHandler.TelLockStateResponseListener#responseUnlockSIM] result=%2, terminalID=%3, lockState=%1", (Object)lockStateStruct, (long)n, (long)n2);
        AbstractTelLockStateDSIHandler.access$102(this.this$0, lockStateStruct);
        switch (n) {
            case 5: {
                AbstractTelLockStateDSIHandler.access$200(this.this$0).log(1078071040, "[AbstractTelLockStateDSIHandler.TelLockStateResponseListener#responseUnlockSIM] RESULT_ERROR_CODE_WRONG");
                this.processWrongCodeEntered(n2, lockStateStruct);
                break;
            }
            case 9: {
                AbstractTelLockStateDSIHandler.access$300(this.this$0).log(1078071040, "[AbstractTelLockStateDSIHandler.TelLockStateResponseListener#responseUnlockSIM] RESULT_ERROR_CODE_INVALID_FORMAT");
                this.processWrongCodeEntered(n2, lockStateStruct);
                break;
            }
            case 0: {
                int n3 = lockStateStruct.getTelLockState();
                if (n3 == 2) {
                    AbstractTelLockStateDSIHandler.access$400(this.this$0, 1);
                    this.this$0.processNoLock(AbstractTelLockStateDSIHandler.access$500(this.this$0));
                    break;
                }
                AbstractTelLockStateDSIHandler.access$600(this.this$0).log(-1601830656, "[AbstractTelLockStateDSIHandler.TelLockStateResponseListener#responseUnlockSIM] RESULT_OK but telLockState=%1", (long)n3);
                break;
            }
            default: {
                AbstractTelLockStateDSIHandler.access$700(this.this$0).log(-1601830656, "[AbstractTelLockStateDSIHandler.TelLockStateResponseListener#responseUnlockSIM] no processing for result %1", (long)n);
            }
        }
        AbstractTelLockStateDSIHandler.access$502(this.this$0, false);
        this.this$0.processManualUnlockInProgress(false);
    }

    protected void processWrongCodeEntered(int n, LockStateStruct lockStateStruct) {
        int n2 = lockStateStruct.getTelLockState();
        int n3 = lockStateStruct.getTelRetryCounter();
        switch (n2) {
            case 3: {
                AbstractTelLockStateDSIHandler.access$400(this.this$0, 4);
                this.this$0.processWrongPINEntered(n3, n);
                break;
            }
            case 5: {
                if (this.unlockType == 0) {
                    AbstractTelLockStateDSIHandler.access$400(this.this$0, 6);
                    this.this$0.processWrongPINEnteredPUKRequired(n3, n);
                    break;
                }
                AbstractTelLockStateDSIHandler.access$400(this.this$0, 7);
                this.this$0.processWrongPUKEntered(n3, n);
                break;
            }
            case 7: {
                AbstractTelLockStateDSIHandler.access$400(this.this$0, 8);
                this.this$0.processPUKBlocked();
                break;
            }
            default: {
                AbstractTelLockStateDSIHandler.access$800(this.this$0).log(-1601830656, "[AbstractTelLockStateDSIHandler.TelLockStateResponseListener#responseUnlockSIM] no handling for current lock state %1", (long)n2);
            }
        }
    }
}

