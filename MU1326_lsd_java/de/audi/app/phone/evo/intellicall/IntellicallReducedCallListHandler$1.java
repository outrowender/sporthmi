/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo.intellicall;

import de.audi.app.phone.core.dsi.ITelDSIMobileEquipmentDeviceState;
import de.audi.app.phone.core.screen.IScreenStateListener;
import de.audi.app.phone.evo.intellicall.IntellicallReducedCallListHandler;
import de.audi.atip.hmi.model.list.BaseListModelApp;

class IntellicallReducedCallListHandler$1
implements IScreenStateListener {
    private final /* synthetic */ IntellicallReducedCallListHandler this$0;

    IntellicallReducedCallListHandler$1(IntellicallReducedCallListHandler intellicallReducedCallListHandler) {
        this.this$0 = intellicallReducedCallListHandler;
    }

    @Override
    public void screenVisible(int n) {
    }

    @Override
    public void screenHidden(int n) {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void notifyScreenFadedOut(int n) {
        Object object = IntellicallReducedCallListHandler.access$000(this.this$0);
        synchronized (object) {
            ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState;
            IntellicallReducedCallListHandler.access$102(this.this$0, false);
            ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState2 = iTelDSIMobileEquipmentDeviceState = IntellicallReducedCallListHandler.access$200(this.this$0) == null ? null : IntellicallReducedCallListHandler.access$300(this.this$0).getCallLeadingDevice();
            if (iTelDSIMobileEquipmentDeviceState != null && iTelDSIMobileEquipmentDeviceState.getCallState() != null) {
                if (iTelDSIMobileEquipmentDeviceState.getCallState().isIdle() && !IntellicallReducedCallListHandler.access$400(this.this$0).getConnectedGatewayState().isLowPrioritySOSEmergencyCallType()) {
                    IntellicallReducedCallListHandler.access$500(this.this$0).log(1078071040, "[IntellicallReducedCallListHandler.init().new IScreenStateListener() {...}#notifyScreenFadedOut] intellicall reduced view faded out - removing all calls from list.");
                    BaseListModelApp baseListModelApp = this.this$0.getCallListList().getCopy();
                    baseListModelApp.removeAll();
                    this.this$0.getCallListList().update(baseListModelApp);
                    IntellicallReducedCallListHandler.access$600(this.this$0, 513213440).setValue(0);
                } else {
                    IntellicallReducedCallListHandler.access$700(this.this$0).log(1078071040, "[IntellicallReducedCallListHandler.init().new IScreenStateListener() {...}#notifyScreenFadedOut] intellicall reduced view faded out but call(s) still present, not removing all calls from list.");
                }
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void notifyScreenConnected(int n) {
        Object object = IntellicallReducedCallListHandler.access$000(this.this$0);
        synchronized (object) {
            IntellicallReducedCallListHandler.access$102(this.this$0, true);
        }
    }
}

