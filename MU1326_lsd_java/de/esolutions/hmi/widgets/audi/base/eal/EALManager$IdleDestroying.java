/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base.eal;

import de.audi.atip.hmi.event.RunnableEvent;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.base.eal.EALManager;
import de.esolutions.hmi.widgets.audi.base.eal.EALManager$1;

class EALManager$IdleDestroying
implements Runnable {
    private final /* synthetic */ EALManager this$0;

    private EALManager$IdleDestroying(EALManager eALManager) {
        this.this$0 = eALManager;
    }

    @Override
    public void run() {
        EALManager.access$302(this.this$0, false);
        long l = System.currentTimeMillis();
        int n = EALManager.access$400(this.this$0).size();
        IWidgetLogChannel.logWidgetPerformance.log(-2137614336, "EALManager.IdleDestroying#run start idle destroying");
        this.this$0.processIdleDestroying();
        if (IWidgetLogChannel.logWidgetPerformance.isDebug()) {
            int n2 = n - EALManager.access$400(this.this$0).size();
            long l2 = System.currentTimeMillis() - l;
            IWidgetLogChannel.logWidgetPerformance.log(-2137614336, "EALManager.IdleDestroying#run finished idle destroying; destroyed %1: took %2", (long)n2, l2);
        }
        if (!EALManager.access$400(this.this$0).isEmpty()) {
            EALManager.access$302(this.this$0, true);
            this.this$0.hmiService.getEventDispatcher().postEvent(new RunnableEvent(true, this), 0);
        }
    }

    /* synthetic */ EALManager$IdleDestroying(EALManager eALManager, EALManager$1 eALManager$1) {
        this(eALManager);
    }
}

