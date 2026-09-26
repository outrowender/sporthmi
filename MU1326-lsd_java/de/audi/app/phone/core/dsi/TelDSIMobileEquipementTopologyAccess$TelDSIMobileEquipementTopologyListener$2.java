/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.dsi;

import de.audi.app.phone.core.dsi.TelDSIMobileEquipementTopologyAccess;
import de.audi.app.phone.core.dsi.TelDSIMobileEquipementTopologyAccess$TelDSIMobileEquipementTopologyListener;
import de.audi.app.phone.core.dsi.Topology;
import de.audi.app.phone.core.event.AbstractTelDSIUpdateEvent;

class TelDSIMobileEquipementTopologyAccess$TelDSIMobileEquipementTopologyListener$2
extends AbstractTelDSIUpdateEvent {
    private final /* synthetic */ int[] val$slots;
    private final /* synthetic */ TelDSIMobileEquipementTopologyAccess$TelDSIMobileEquipementTopologyListener this$1;

    TelDSIMobileEquipementTopologyAccess$TelDSIMobileEquipementTopologyListener$2(TelDSIMobileEquipementTopologyAccess$TelDSIMobileEquipementTopologyListener telDSIMobileEquipementTopologyAccess$TelDSIMobileEquipementTopologyListener, String string, int[] nArray) {
        this.this$1 = telDSIMobileEquipementTopologyAccess$TelDSIMobileEquipementTopologyListener;
        this.val$slots = nArray;
        super(string);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void run() {
        Object object = TelDSIMobileEquipementTopologyAccess.access$700(TelDSIMobileEquipementTopologyAccess$TelDSIMobileEquipementTopologyListener.access$500(this.this$1));
        synchronized (object) {
            TelDSIMobileEquipementTopologyAccess.access$1002(TelDSIMobileEquipementTopologyAccess$TelDSIMobileEquipementTopologyListener.access$500(this.this$1), new Topology(TelDSIMobileEquipementTopologyAccess.access$1200(TelDSIMobileEquipementTopologyAccess$TelDSIMobileEquipementTopologyListener.access$500(this.this$1)), TelDSIMobileEquipementTopologyAccess.access$1300(TelDSIMobileEquipementTopologyAccess$TelDSIMobileEquipementTopologyListener.access$500(this.this$1)), this.val$slots));
            TelDSIMobileEquipementTopologyAccess.access$1000(TelDSIMobileEquipementTopologyAccess$TelDSIMobileEquipementTopologyListener.access$500(this.this$1)).setInstanceUsage(TelDSIMobileEquipementTopologyAccess.access$900(TelDSIMobileEquipementTopologyAccess$TelDSIMobileEquipementTopologyListener.access$500(this.this$1)));
            TelDSIMobileEquipementTopologyAccess.access$1400(TelDSIMobileEquipementTopologyAccess$TelDSIMobileEquipementTopologyListener.access$500(this.this$1)).log(1078071040, "[TelDSIMobileEquipementTopologyAccess.TelDSIMobileEquipementTopologyAccess(...).new DSIMobileEquipmentTopologyListener() {...}#updateTopology] %1", (Object)TelDSIMobileEquipementTopologyAccess.access$1000(TelDSIMobileEquipementTopologyAccess$TelDSIMobileEquipementTopologyListener.access$500(this.this$1)));
            if (this.val$slots != null && this.val$slots.length > 0) {
                if (TelDSIMobileEquipementTopologyAccess.access$1000(TelDSIMobileEquipementTopologyAccess$TelDSIMobileEquipementTopologyListener.access$500(this.this$1)).isInitState()) {
                    TelDSIMobileEquipementTopologyAccess.access$1500(TelDSIMobileEquipementTopologyAccess$TelDSIMobileEquipementTopologyListener.access$500(this.this$1)).log(1078071040, "[TelDSIMobileEquipementTopologyAccess.TelDSIMobileEquipementTopologyAccess(...).new DSIMobileEquipmentTopologyListener() {...}#updateTopology] INIT_STATE --> showing wait screen");
                } else {
                    TelDSIMobileEquipementTopologyAccess.access$1600(TelDSIMobileEquipementTopologyAccess$TelDSIMobileEquipementTopologyListener.access$500(this.this$1));
                }
            } else {
                TelDSIMobileEquipementTopologyAccess.access$1700(TelDSIMobileEquipementTopologyAccess$TelDSIMobileEquipementTopologyListener.access$500(this.this$1)).log(-1601830656, "[TelDSIMobileEquipementTopologyAccess.TelDSIMobileEquipementTopologyListener.updateTopology(...).new Runnable() {...}#run] invalid slot data --> NOP!");
            }
            TelDSIMobileEquipementTopologyAccess.access$1800(TelDSIMobileEquipementTopologyAccess$TelDSIMobileEquipementTopologyListener.access$500(this.this$1)).getGlobalTelephoneStateManager().updateTopology(TelDSIMobileEquipementTopologyAccess.access$1000(TelDSIMobileEquipementTopologyAccess$TelDSIMobileEquipementTopologyListener.access$500(this.this$1)));
        }
    }
}

