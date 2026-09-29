/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high;

import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.evo.high.DrawerManagerEvoHigh;

class DrawerManagerEvoHigh$1
implements Runnable {
    private final /* synthetic */ DrawerManagerEvoHigh this$0;

    DrawerManagerEvoHigh$1(DrawerManagerEvoHigh drawerManagerEvoHigh) {
        this.this$0 = drawerManagerEvoHigh;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void run() {
        Object object = DrawerManagerEvoHigh.access$000(this.this$0);
        synchronized (object) {
            IWidgetLogChannel.logEntertainmentDrawer.log(-2137614336, "DrawerManagerEvoHigh#onNewContentAvalabilityChangedAsync: called");
            this.this$0.onNewContentAvalabilityChanged();
        }
    }
}

