/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.sds;

import de.audi.app.media.sds.SDSController;
import java.util.Iterator;
import java.util.List;

abstract class SDSController$AbstractListenerCallback {
    private final List serviceList;
    private final /* synthetic */ SDSController this$0;

    public SDSController$AbstractListenerCallback(SDSController sDSController, List list) {
        this.this$0 = sDSController;
        this.serviceList = list;
    }

    public abstract void doCall(Object object) {
    }

    public void execute() {
        Iterator iterator = this.serviceList.iterator();
        while (iterator.hasNext()) {
            try {
                this.doCall(iterator.next());
            }
            catch (Exception exception) {
                SDSController.access$3600(this.this$0).sds().log(-1601830656, "[%1.notifyActivateSourceProcessed] %2", (Object)"SDSController", (Throwable)exception);
            }
        }
    }
}

