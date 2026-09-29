/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.dsi;

import de.audi.app.phone.core.dsi.TelDSIMobileEquipementTopologyAccess;
import de.audi.app.phone.core.dsi.TelDSIMobileEquipementTopologyAccess$TelDSIMobileEquipementTopologyListener;
import de.audi.app.phone.core.event.AbstractTelDSIUpdateEvent;
import de.esolutions.fw.util.commons.Converter;

class TelDSIMobileEquipementTopologyAccess$TelDSIMobileEquipementTopologyListener$1
extends AbstractTelDSIUpdateEvent {
    private final /* synthetic */ int[] val$usage;
    private final /* synthetic */ TelDSIMobileEquipementTopologyAccess$TelDSIMobileEquipementTopologyListener this$1;

    TelDSIMobileEquipementTopologyAccess$TelDSIMobileEquipementTopologyListener$1(TelDSIMobileEquipementTopologyAccess$TelDSIMobileEquipementTopologyListener telDSIMobileEquipementTopologyAccess$TelDSIMobileEquipementTopologyListener, String string, int[] nArray) {
        this.this$1 = telDSIMobileEquipementTopologyAccess$TelDSIMobileEquipementTopologyListener;
        this.val$usage = nArray;
        super(string);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void run() {
        TelDSIMobileEquipementTopologyAccess.access$600(TelDSIMobileEquipementTopologyAccess$TelDSIMobileEquipementTopologyListener.access$500(this.this$1)).log(1078071040, "[TelDSIMobileEquipementTopologyAccess.TelDSIMobileEquipementTopologyListener#updateUsage] usage=%1", (Object)Converter.intArrayToString(this.val$usage));
        Object object = TelDSIMobileEquipementTopologyAccess.access$700(TelDSIMobileEquipementTopologyAccess$TelDSIMobileEquipementTopologyListener.access$500(this.this$1));
        synchronized (object) {
            if (this.val$usage != null) {
                for (int i2 = 0; i2 < this.val$usage.length; ++i2) {
                    TelDSIMobileEquipementTopologyAccess.access$800(TelDSIMobileEquipementTopologyAccess$TelDSIMobileEquipementTopologyListener.access$500(this.this$1))[i2].setIsNadInstance(this.val$usage[i2] == 0);
                }
            }
            TelDSIMobileEquipementTopologyAccess.access$902(TelDSIMobileEquipementTopologyAccess$TelDSIMobileEquipementTopologyListener.access$500(this.this$1), this.val$usage);
            if (TelDSIMobileEquipementTopologyAccess.access$1000(TelDSIMobileEquipementTopologyAccess$TelDSIMobileEquipementTopologyListener.access$500(this.this$1)) != null) {
                TelDSIMobileEquipementTopologyAccess.access$1000(TelDSIMobileEquipementTopologyAccess$TelDSIMobileEquipementTopologyListener.access$500(this.this$1)).setInstanceUsage(this.val$usage);
            }
        }
    }
}

