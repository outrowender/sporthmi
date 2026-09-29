/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars.dsi;

import de.audi.tuner.app.RadioComparators;
import de.audi.tuner.app.sdars.StationInfoExt;
import de.audi.tuner.app.sdars.dsi.SDARSDSIUpManager;
import de.audi.tuner.ifc.IMemoryList;
import de.audi.tuner.ifc.listener.IUpdateListener;
import de.audi.tuner.sds.DefaultUpdateListener;

class SDARSDSIUpManager$MemoryListener
extends DefaultUpdateListener
implements IUpdateListener {
    private final IMemoryList memory;
    private final /* synthetic */ SDARSDSIUpManager this$0;

    public SDARSDSIUpManager$MemoryListener(SDARSDSIUpManager sDARSDSIUpManager, IMemoryList iMemoryList) {
        this.this$0 = sDARSDSIUpManager;
        this.memory = iMemoryList;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void updatedMemoryList() {
        Object object = SDARSDSIUpManager.access$100(this.this$0);
        synchronized (object) {
            SDARSDSIUpManager.access$402(this.this$0, this.memory.getList(new int[]{7}));
            boolean bl = false;
            for (int i2 = 0; i2 < SDARSDSIUpManager.access$400(this.this$0).length; ++i2) {
                StationInfoExt stationInfoExt = SDARSDSIUpManager.access$400(this.this$0)[i2].getSDARSService();
                if (!RadioComparators.equals(SDARSDSIUpManager.access$300(this.this$0), stationInfoExt) || SDARSDSIUpManager.access$300(this.this$0).getPresetPos() != stationInfoExt.getPresetPos()) continue;
                bl = true;
                break;
            }
            if (!bl) {
                SDARSDSIUpManager.access$300(this.this$0).setPresetPos(0);
            }
            SDARSDSIUpManager.access$500(this.this$0).reNotification(8);
            SDARSDSIUpManager.access$500(this.this$0).reNotification(9);
        }
    }
}

