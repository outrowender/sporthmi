/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.app.phone;

import de.audi.app.bap.IPowerState;
import de.audi.app.bap.dsi.bap.IDSIBAPController;
import de.audi.app.bap.fw.AbstractBAPModuleInitializationManagerFSG;
import de.audi.app.bap.fw.functiontypes.BAPFunctionDataListener;
import de.audi.app.bap.fw.functiontypes.BAPFunctionPropertyFSG;
import de.audi.app.bap.utils.LSGIDs;
import de.audi.app.combi.bap.fw.AbstractCombiModule;
import de.esolutions.fw.util.commons.Buffer;
import de.vw.mib.bap.generated.telephone.serializer.FSG_OperationState_Status;
import edu.emory.mathcs.backport.java.util.concurrent.Callable;
import edu.emory.mathcs.backport.java.util.concurrent.Executors;
import edu.emory.mathcs.backport.java.util.concurrent.ScheduledExecutorService;
import edu.emory.mathcs.backport.java.util.concurrent.TimeUnit;

public class InitializationManagerPhone
extends AbstractBAPModuleInitializationManagerFSG
implements BAPFunctionDataListener {
    private int appStateAddressbook = 0;
    private int appStateMessaging = 0;
    private int appStateConnectivity = 0;
    private static final int CALL_STATE_TO_OP_STATE_TIME_WINDOW_MS = 100;
    private final ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
    protected final BAPFunctionPropertyFSG callStateFunction;

    public InitializationManagerPhone(AbstractCombiModule abstractCombiModule, BAPFunctionPropertyFSG bAPFunctionPropertyFSG, BAPFunctionPropertyFSG bAPFunctionPropertyFSG2, IDSIBAPController iDSIBAPController, IPowerState iPowerState) {
        super(abstractCombiModule, bAPFunctionPropertyFSG, iDSIBAPController, iPowerState);
        this.callStateFunction = bAPFunctionPropertyFSG2;
    }

    protected void updateOperationStateBAP(int n) {
        int n2 = this.getBapStackState() == 0 ? 2 : n;
        this.logChannel.log(1000000, "[InitializationManagerPhone#updateOperationStateBAP] new operation state of LSG=%1 is %2", (Object)LSGIDs.getDescription(this.module.getLSGID()), (Object)InitializationManagerPhone.getOpStateString(n2));
        if (this.setFSGOperationStateValue(n2) || this.fsgOperationStateFunction.isStatusRequestTransmissionPending() || !this.fsgOperationStateFunction.isDataValid()) {
            this.logChannel.log(1000000, "[InitializationManagerPhone#updateOperationStateBAP] callState.transmissionPending=%1", this.callStateFunction.isStatusRequestTransmissionPending());
            if (this.callStateFunction.isStatusRequestTransmissionPending() && n2 == 1) {
                this.logChannel.log(1000000, "[InitializationManagerPhone#updateOperationStateBAP] wait for callState to finish");
                this.callStateFunction.addDataListener(this);
            } else {
                this.fsgOperationStateFunction.resendLastStatus();
            }
        } else {
            this.logChannel.log(10000000, "[InitializationManagerPhone#updateOperationStateBAP] operation state of LSG=%1 is not updated", (Object)LSGIDs.getDescription(this.module.getLSGID()));
        }
    }

    public void appStateChanged(String string, int n) {
        this.logChannel.log(100000000, "[InitializationManagerPhone#appStateChanged] appName=%1, value=%2", (Object)string, (long)n);
        if ("Phone".equals(string)) {
            this.processAppStateChanged(n);
        }
        if ("AddressBook".equals(string) && this.appStateAddressbook != n) {
            this.appStateAddressbook = n;
        }
        if ("Messaging".equals(string) && this.appStateMessaging != n) {
            this.appStateMessaging = n;
        }
        if ("Connectivity".equals(string) && this.appStateConnectivity != n) {
            this.appStateConnectivity = n;
        }
    }

    public String appStatesToString() {
        Buffer buffer = new Buffer();
        buffer.append("appStatePhone = ");
        buffer.append(this.getAppState());
        buffer.append("\nappStateAddressbook = ");
        buffer.append(this.appStateAddressbook);
        buffer.append("\nappStateMessaging = ");
        buffer.append(this.appStateMessaging);
        buffer.append("\nappStateConnectivity = ");
        buffer.append(this.appStateConnectivity);
        buffer.append('\n');
        return buffer.toString();
    }

    public boolean setFSGOperationStateValue(int n) {
        int n2;
        switch (n) {
            case 0: {
                n2 = 0;
                break;
            }
            case 1: {
                n2 = 1;
                break;
            }
            case 2: {
                n2 = 3;
                break;
            }
            case 3: {
                n2 = 15;
                break;
            }
            default: {
                this.logChannel.log(10000, "[InitializationManagerPhone#setFSGOperationStateValue] invalid opState: %1", (long)n);
                return false;
            }
        }
        FSG_OperationState_Status fSG_OperationState_Status = (FSG_OperationState_Status)this.fsgOperationStateFunction.getLastStatus();
        if (fSG_OperationState_Status.op_State != n2) {
            fSG_OperationState_Status.op_State = n2;
            return true;
        }
        return false;
    }

    public boolean isOpStateNormalOperation() {
        FSG_OperationState_Status fSG_OperationState_Status = (FSG_OperationState_Status)this.fsgOperationStateFunction.getLastStatus();
        return fSG_OperationState_Status.op_State == 0;
    }

    public void notifyDataValidChanged(int n, boolean bl) {
        if (n == this.callStateFunction.getFctID()) {
            this.executor.schedule(new Callable(){

                public Object call() {
                    InitializationManagerPhone.this.logChannel.log(1000000, "[InitializationManagerPhone#notifyDataValidChanged] call state transmission not pending; resend op state");
                    InitializationManagerPhone.this.fsgOperationStateFunction.resendLastStatus();
                    return null;
                }
            }, 100L, TimeUnit.MILLISECONDS);
            this.callStateFunction.removeDataListener(this);
        }
    }

    public void notifyDataChanged(int n) {
    }

    public void notifyDataUpdatedNoChange(int n) {
    }
}

