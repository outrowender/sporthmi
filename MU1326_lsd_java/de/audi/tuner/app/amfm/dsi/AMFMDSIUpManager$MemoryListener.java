/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.amfm.dsi;

import de.audi.tuner.app.RadioComparators;
import de.audi.tuner.app.TunerObjectContainer;
import de.audi.tuner.app.amfm.AMFMStation;
import de.audi.tuner.app.amfm.dsi.AMFMDSIUpManager;
import de.audi.tuner.ifc.IMemoryList;
import de.audi.tuner.ifc.listener.IUpdateListener;
import de.audi.tuner.sds.DefaultUpdateListener;

class AMFMDSIUpManager$MemoryListener
extends DefaultUpdateListener
implements IUpdateListener {
    private final IMemoryList memory;
    private final /* synthetic */ AMFMDSIUpManager this$0;

    public AMFMDSIUpManager$MemoryListener(AMFMDSIUpManager aMFMDSIUpManager, IMemoryList iMemoryList) {
        this.this$0 = aMFMDSIUpManager;
        this.memory = iMemoryList;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void updatedMemoryList() {
        TunerObjectContainer[] tunerObjectContainerArray = this.memory.getList(new int[]{1, 4});
        Object object = AMFMDSIUpManager.access$200(this.this$0);
        synchronized (object) {
            AMFMDSIUpManager.access$1502(this.this$0, tunerObjectContainerArray);
            boolean bl = false;
            for (int i2 = 0; i2 < AMFMDSIUpManager.access$1500(this.this$0).length; ++i2) {
                AMFMStation aMFMStation = AMFMDSIUpManager.access$1500(this.this$0)[i2].getAMFMService();
                if (!RadioComparators.equals(AMFMDSIUpManager.access$400(this.this$0), aMFMStation) || AMFMDSIUpManager.access$400(this.this$0).getPresetPos() != aMFMStation.getPresetPos()) continue;
                bl = true;
                break;
            }
            if (!bl) {
                AMFMDSIUpManager.access$400(this.this$0).setPresetPos(0);
            }
            AMFMDSIUpManager.access$1602(this.this$0, true);
            AMFMDSIUpManager.access$1300(this.this$0).reNotification(1);
            AMFMDSIUpManager.access$1300(this.this$0).reNotification(20);
            AMFMDSIUpManager.access$1300(this.this$0).reNotification(2);
            AMFMDSIUpManager.access$1300(this.this$0).reNotification(3);
        }
    }
}

