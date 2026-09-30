/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.fw.functiontypes;

import de.audi.app.bap.fw.AbstractBAPModule;
import de.audi.app.bap.fw.functiontypes.AbstractBAPFunction;
import de.audi.app.bap.fw.indication.IAcknowledgeTimeoutListener;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractBAPFunctionWithAck
extends AbstractBAPFunction {
    private final List acknowledgeTimeoutListeners = new ArrayList(1);

    protected AbstractBAPFunctionWithAck(AbstractBAPModule abstractBAPModule, int n) {
        super(abstractBAPModule, n);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void addAcknowledgeTimeoutListener(IAcknowledgeTimeoutListener iAcknowledgeTimeoutListener) {
        List list = this.acknowledgeTimeoutListeners;
        synchronized (list) {
            if (!this.acknowledgeTimeoutListeners.contains(iAcknowledgeTimeoutListener)) {
                this.acknowledgeTimeoutListeners.add(iAcknowledgeTimeoutListener);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void removeAcknowledgeTimeoutListener(IAcknowledgeTimeoutListener iAcknowledgeTimeoutListener) {
        List list = this.acknowledgeTimeoutListeners;
        synchronized (list) {
            this.acknowledgeTimeoutListeners.remove(iAcknowledgeTimeoutListener);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void notifyListenersAcknowledgeTimeout() {
        ArrayList arrayList;
        Object object = this.acknowledgeTimeoutListeners;
        synchronized (object) {
            if (this.acknowledgeTimeoutListeners.isEmpty()) {
                return;
            }
            arrayList = new ArrayList(this.acknowledgeTimeoutListeners);
        }
        this.logChannel.log(100000000, "[AbstractBAPFunctionWithAck#notifyListenersAcknowledgeTimeout] inform listeners (lsgID=%1, fctID=%2)", (Object)this.lsgIDDesc, (Object)this.fctIDDesc);
        object = arrayList.iterator();
        while (object.hasNext()) {
            ((IAcknowledgeTimeoutListener)object.next()).processAcknowledgeTimeout(this.fctID);
        }
    }
}

