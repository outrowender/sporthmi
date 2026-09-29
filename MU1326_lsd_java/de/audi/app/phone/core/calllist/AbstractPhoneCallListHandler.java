/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.calllist;

import de.audi.app.phone.core.AbstractPhoneComponent;
import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.calllist.ITelCallList;
import de.audi.app.phone.core.state.IGlobalTelephoneStateStruct;

public abstract class AbstractPhoneCallListHandler
extends AbstractPhoneComponent
implements ITelCallList {
    protected volatile IGlobalTelephoneStateStruct state;
    protected final Object stateMutex = new Object();

    public AbstractPhoneCallListHandler(ITelApplication iTelApplication, String string) {
        super(iTelApplication, string);
    }

    @Override
    public void init() {
        this.getApplication().getGlobalTelephoneStateManager().registerListener(this);
        super.init();
    }

    @Override
    public void deinit() {
        this.getApplication().getGlobalTelephoneStateManager().removeListener(this);
        super.deinit();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void updateGlobalTelephoneStateProperty(int n, IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        Object object = this.stateMutex;
        synchronized (object) {
            if (iGlobalTelephoneStateStruct == null) {
                this.log.log(10000, "AbstractPhoneCallListHandler#updateGlobalTelephoneStateProperty stateStruct is null");
                return;
            }
            this.state = iGlobalTelephoneStateStruct;
            if (iGlobalTelephoneStateStruct.getConnectedGatewayState().isCustomerCallNotAllowed() && !iGlobalTelephoneStateStruct.getConnectedGatewayState().isLowPrioritySOSEmergencyCallType()) {
                this.log.log(-2137614336, "AbstractPhoneCallListHandler#updateGlobalTelephoneStateProperty(): ecall is active");
                return;
            }
            switch (n) {
                case 65543: 
                case 131079: 
                case 196615: {
                    this.updateCallDurationList(iGlobalTelephoneStateStruct);
                    break;
                }
                case 65544: 
                case 131080: 
                case 196616: 
                case 262156: {
                    this.updateCallList(iGlobalTelephoneStateStruct);
                    break;
                }
                case 65553: 
                case 131089: 
                case 196625: {
                    this.updateMicMuteState(iGlobalTelephoneStateStruct);
                    break;
                }
                case 65550: 
                case 131086: 
                case 196622: {
                    this.updateHandsfreeModeState(iGlobalTelephoneStateStruct);
                    break;
                }
                default: {
                    this.log.log(-2137614336, "[AbstractPhoneCallListHandler#updateGlobalTelephoneStateProperty] no handling for key %1", (long)n);
                }
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected IGlobalTelephoneStateStruct getCurrentState() {
        Object object = this.stateMutex;
        synchronized (object) {
            return this.state;
        }
    }

    public abstract void updateCallDurationList(IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
    }

    public abstract void updateCallList(IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
    }

    public abstract void updateMicMuteState(IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
    }

    public abstract void updateHandsfreeModeState(IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
    }
}

