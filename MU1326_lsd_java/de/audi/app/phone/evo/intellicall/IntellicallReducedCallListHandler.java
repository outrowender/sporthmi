/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo.intellicall;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.dsi.ITelDSIMobileEquipmentDeviceState;
import de.audi.app.phone.core.screen.IScreenStateListener;
import de.audi.app.phone.core.state.CallStateStruct;
import de.audi.app.phone.core.state.IGlobalTelephoneStateStruct;
import de.audi.app.phone.evo.intellicall.AbstractIntellicallCallListModelHandler;
import de.audi.atip.hmi.model.list.BaseListModelApp;

public class IntellicallReducedCallListHandler
extends AbstractIntellicallCallListModelHandler {
    private boolean intellicallReducedConnected;
    private final Object mutex = new Object();

    public IntellicallReducedCallListHandler(ITelApplication iTelApplication) {
        super(iTelApplication);
    }

    public void init() {
        super.init();
        this.getApplication().getPopupScreenStateDispatcher().addScreenStateListener(300006, new IScreenStateListener(){

            public void screenVisible(int n) {
            }

            public void screenHidden(int n) {
            }

            /*
             * WARNING - Removed try catching itself - possible behaviour change.
             */
            public void notifyScreenFadedOut(int n) {
                Object object = IntellicallReducedCallListHandler.this.mutex;
                synchronized (object) {
                    ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState;
                    IntellicallReducedCallListHandler.this.intellicallReducedConnected = false;
                    ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState2 = iTelDSIMobileEquipmentDeviceState = IntellicallReducedCallListHandler.this.state == null ? null : IntellicallReducedCallListHandler.this.state.getCallLeadingDevice();
                    if (iTelDSIMobileEquipmentDeviceState != null && iTelDSIMobileEquipmentDeviceState.getCallState() != null) {
                        if (iTelDSIMobileEquipmentDeviceState.getCallState().isIdle() && !IntellicallReducedCallListHandler.this.state.getConnectedGatewayState().isLowPrioritySOSEmergencyCallType()) {
                            IntellicallReducedCallListHandler.this.log.log(1000000, "[IntellicallReducedCallListHandler.init().new IScreenStateListener() {...}#notifyScreenFadedOut] intellicall reduced view faded out - removing all calls from list.");
                            BaseListModelApp baseListModelApp = IntellicallReducedCallListHandler.this.getCallListList().getCopy();
                            baseListModelApp.removeAll();
                            IntellicallReducedCallListHandler.this.getCallListList().update(baseListModelApp);
                            IntellicallReducedCallListHandler.this.getChoiceModel(300830).setValue(0);
                        } else {
                            IntellicallReducedCallListHandler.this.log.log(1000000, "[IntellicallReducedCallListHandler.init().new IScreenStateListener() {...}#notifyScreenFadedOut] intellicall reduced view faded out but call(s) still present, not removing all calls from list.");
                        }
                    }
                }
            }

            /*
             * WARNING - Removed try catching itself - possible behaviour change.
             */
            public void notifyScreenConnected(int n) {
                Object object = IntellicallReducedCallListHandler.this.mutex;
                synchronized (object) {
                    IntellicallReducedCallListHandler.this.intellicallReducedConnected = true;
                }
            }
        });
    }

    public void updateCallList(IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        CallStateStruct callStateStruct;
        super.updateCallList(iGlobalTelephoneStateStruct);
        CallStateStruct callStateStruct2 = callStateStruct = iGlobalTelephoneStateStruct != null && iGlobalTelephoneStateStruct.getCallLeadingDevice() != null ? iGlobalTelephoneStateStruct.getCallLeadingDevice().getCallState() : null;
        if (callStateStruct != null && !callStateStruct.isIdle()) {
            this.getChoiceModel(300830).setValue(1);
        }
    }

    protected BaseListModelApp getCallListList() {
        return this.getBaseListModel(300828);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void updateCallStateIdle(BaseListModelApp baseListModelApp) {
        Object object = this.mutex;
        synchronized (object) {
            if (this.intellicallReducedConnected) {
                this.log.log(1000000, "[IntellicallReducedCallListHandler#updateCallStateIdle] waiting for faded out before removing calls.");
            } else {
                this.log.log(1000000, "[IntellicallReducedCallListHandler#updateCallStateIdle] not in Intellicall reduced, removing calls from list.");
                super.updateCallStateIdle(baseListModelApp);
                this.getChoiceModel(300830).setValue(0);
            }
        }
    }
}

