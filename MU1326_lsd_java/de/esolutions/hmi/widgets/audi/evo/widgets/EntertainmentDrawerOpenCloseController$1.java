/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.evo.widgets.EntertainmentDrawerOpenCloseController;

class EntertainmentDrawerOpenCloseController$1
implements Runnable {
    private final /* synthetic */ EntertainmentDrawerOpenCloseController this$0;

    EntertainmentDrawerOpenCloseController$1(EntertainmentDrawerOpenCloseController entertainmentDrawerOpenCloseController) {
        this.this$0 = entertainmentDrawerOpenCloseController;
    }

    @Override
    public void run() {
        if (EntertainmentDrawerOpenCloseController.access$000(this.this$0) != null) {
            EntertainmentDrawerOpenCloseController.access$000(this.this$0).processAnimation(200, 32959, 1);
        } else {
            IWidgetLogChannel.logEntertainmentDrawerEvents.log(-2137614336, "EntertainmentDrawerOpenCloseController#setEntertainmentDrawerStateRequest/RunnableEvent: animationManager is null");
        }
    }
}

