/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.dab;

import de.audi.tuner.app.dab.DABDSIUpManager;
import de.audi.tuner.ifc.IMemoryList;
import de.audi.tuner.ifc.listener.IUpdateListener;
import de.audi.tuner.sds.DefaultUpdateListener;

class DABDSIUpManager$MemoryListener
extends DefaultUpdateListener
implements IUpdateListener {
    private final IMemoryList memory;
    private final /* synthetic */ DABDSIUpManager this$0;

    public DABDSIUpManager$MemoryListener(DABDSIUpManager dABDSIUpManager, IMemoryList iMemoryList) {
        this.this$0 = dABDSIUpManager;
        this.memory = iMemoryList;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void updatedMemoryList() {
        Object object = DABDSIUpManager.access$200(this.this$0);
        synchronized (object) {
            DABDSIUpManager.access$1002(this.this$0, this.memory.getList(new int[]{5}));
            DABDSIUpManager.access$1102(this.this$0, true);
            DABDSIUpManager.access$1200(this.this$0).reNotification(1);
            DABDSIUpManager.access$1200(this.this$0).reNotification(2);
            DABDSIUpManager.access$1200(this.this$0).reNotification(3);
            DABDSIUpManager.access$1200(this.this$0).reNotification(5);
            DABDSIUpManager.access$1200(this.this$0).reNotification(6);
            DABDSIUpManager.access$1200(this.this$0).reNotification(7);
        }
    }
}

