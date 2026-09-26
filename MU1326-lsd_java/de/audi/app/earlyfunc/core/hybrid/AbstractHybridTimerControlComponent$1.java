/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.core.hybrid;

import de.audi.app.earlyfunc.core.hybrid.AbstractHybridTimerControlComponent;
import de.audi.atip.hmi.model.listener.DefaultChoiceListener;
import org.dsi.ifc.carhybrid.BatteryControlProfileOperation;

class AbstractHybridTimerControlComponent$1
extends DefaultChoiceListener {
    private final /* synthetic */ AbstractHybridTimerControlComponent this$0;

    AbstractHybridTimerControlComponent$1(AbstractHybridTimerControlComponent abstractHybridTimerControlComponent) {
        this.this$0 = abstractHybridTimerControlComponent;
    }

    @Override
    public void itemSelected(int n, int n2, int n3, int n4) {
        this.this$0.getLogChannel().log(-2137614336, "[AbstractHybridTimerControlComponent.DefaultChoiceListener#itemSelected] modelID='%1', itemID='%2'", (long)n, (long)n2);
        boolean bl = 1 == n2;
        switch (n) {
            case 2100653: {
                BatteryControlProfileOperation batteryControlProfileOperation;
                if (bl && AbstractHybridTimerControlComponent.access$12700(this.this$0).isServiceAvailable() && ((batteryControlProfileOperation = AbstractHybridTimerControlComponent.access$12700(this.this$0).getService().getBatteryControlProfileOperation(AbstractHybridTimerControlComponent.access$12800(this.this$0, 0))).isCharge() || !batteryControlProfileOperation.isClimate() || !batteryControlProfileOperation.isClimateWithoutExternalSupply())) {
                    this.this$0.dsiSetBatteryControlTimerFunction(0, 2);
                }
                this.this$0.dsiSetBatteryControlTimerImmediateState(bl ? 1 : 0);
                break;
            }
            default: {
                this.this$0.getLogChannel().log(-1601830656, "[AbstractHybridTimerControlComponent.DefaultChoiceListener#itemSelected] ModelID='%1' not supported.", (long)n);
            }
        }
    }
}

