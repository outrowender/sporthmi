/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.ecall.core.bap;

import de.audi.app.ecall.core.bap.BAPServiceEcallListenerClusterHandler;
import de.audi.app.ecall.core.state.IEcallStateStruct;
import de.audi.app.ecall.core.state.IGlobalEcallStateListener;
import java.util.LinkedList;

class BAPServiceEcallListenerClusterHandler$ListenerUpdater
implements Runnable {
    private final int attribute;
    private final IEcallStateStruct update;
    private final /* synthetic */ BAPServiceEcallListenerClusterHandler this$0;

    public BAPServiceEcallListenerClusterHandler$ListenerUpdater(BAPServiceEcallListenerClusterHandler bAPServiceEcallListenerClusterHandler, int n, IEcallStateStruct iEcallStateStruct) {
        this.this$0 = bAPServiceEcallListenerClusterHandler;
        this.attribute = n;
        this.update = iEcallStateStruct;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void run() {
        LinkedList linkedList;
        BAPServiceEcallListenerClusterHandler.access$100(this.this$0).log(14808325, "BAPServiceEcallListenerClusterHandler.ListenerUpdater#run(): start update %1", (Object)BAPServiceEcallListenerClusterHandler.access$000(this.attribute));
        Object object = BAPServiceEcallListenerClusterHandler.access$200(this.this$0);
        synchronized (object) {
            linkedList = (LinkedList)BAPServiceEcallListenerClusterHandler.access$200(this.this$0).clone();
        }
        object = linkedList.iterator();
        while (object.hasNext()) {
            ((IGlobalEcallStateListener)object.next()).updateGlobalEcallStateProperty(this.attribute, this.update);
        }
        BAPServiceEcallListenerClusterHandler.access$100(this.this$0).log(14808325, "BAPServiceEcallListenerClusterHandler.ListenerUpdater#run(): finished update %1", (Object)BAPServiceEcallListenerClusterHandler.access$000(this.attribute));
    }
}

