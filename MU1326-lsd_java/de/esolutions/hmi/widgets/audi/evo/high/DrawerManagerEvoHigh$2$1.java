/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high;

import de.audi.atip.hmi.HMIBundle;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.evo.high.DrawerManagerEvoHigh;
import de.esolutions.hmi.widgets.audi.evo.high.DrawerManagerEvoHigh$2;
import de.esolutions.hmi.widgets.audi.evo.widgets.EntertainmentDrawerController;
import java.util.Collection;

class DrawerManagerEvoHigh$2$1
implements Runnable {
    private final /* synthetic */ HMIBundle val$service;
    private final /* synthetic */ DrawerManagerEvoHigh$2 this$1;

    DrawerManagerEvoHigh$2$1(DrawerManagerEvoHigh$2 drawerManagerEvoHigh$2, HMIBundle hMIBundle) {
        this.this$1 = drawerManagerEvoHigh$2;
        this.val$service = hMIBundle;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void run() {
        if (this.val$service != null) {
            Object object;
            EntertainmentDrawerController entertainmentDrawerController = (EntertainmentDrawerController)this.val$service.getEntertainmentDrawer(DrawerManagerEvoHigh$2.access$200((DrawerManagerEvoHigh$2)this.this$1).terminal.getTerminalID());
            if (entertainmentDrawerController != null) {
                object = DrawerManagerEvoHigh.access$000(DrawerManagerEvoHigh$2.access$200(this.this$1));
                synchronized (object) {
                    if (DrawerManagerEvoHigh.access$300(DrawerManagerEvoHigh$2.access$200(this.this$1)) == null) {
                        DrawerManagerEvoHigh.access$302(DrawerManagerEvoHigh$2.access$200(this.this$1), entertainmentDrawerController);
                    } else {
                        IWidgetLogChannel.logDrawer.log(10000, "DrawerManagerEvoHigh#addingService: found two entertainment drawers. Old: %1,  New: %2", (long)DrawerManagerEvoHigh.access$300(DrawerManagerEvoHigh$2.access$200(this.this$1)).getScreenId(), (long)entertainmentDrawerController.getScreenId());
                    }
                }
            }
            if ((object = this.val$service.getEntertainmentDrawerContent(DrawerManagerEvoHigh$2.access$200((DrawerManagerEvoHigh$2)this.this$1).terminal.getTerminalID())) != null) {
                Object object2 = DrawerManagerEvoHigh.access$000(DrawerManagerEvoHigh$2.access$200(this.this$1));
                synchronized (object2) {
                    DrawerManagerEvoHigh$2.access$200((DrawerManagerEvoHigh$2)this.this$1).entertainmentDrawerContent.addAll((Collection)object);
                }
            }
            DrawerManagerEvoHigh.access$400(DrawerManagerEvoHigh$2.access$200(this.this$1));
        }
    }
}

