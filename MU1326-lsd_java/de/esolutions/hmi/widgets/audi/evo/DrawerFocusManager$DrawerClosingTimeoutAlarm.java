/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo;

import de.esolutions.hmi.widgets.audi.evo.DrawerFocusManager;
import de.esolutions.hmi.widgets.audi.evo.DrawerFocusManager$1;

class DrawerFocusManager$DrawerClosingTimeoutAlarm
implements Runnable {
    private final /* synthetic */ DrawerFocusManager this$0;

    private DrawerFocusManager$DrawerClosingTimeoutAlarm(DrawerFocusManager drawerFocusManager) {
        this.this$0 = drawerFocusManager;
    }

    @Override
    public void run() {
        if (DrawerFocusManager.access$200(this.this$0) != null && DrawerFocusManager.access$200(this.this$0).isLocked()) {
            DrawerFocusManager.access$300().log(1078071040, "DrawerFocusManager#DrawerClosingTimeoutAlarm restarting watchdog because screen is locked, screen=%1", (Object)DrawerFocusManager.access$200(this.this$0));
            DrawerFocusManager.access$400(this.this$0);
        } else {
            DrawerFocusManager.access$300().log(10000, "DrawerFocusManager#DrawerClosingTimeoutAlarm closing drawers");
            this.this$0.requestDrawerState(16);
        }
    }

    /* synthetic */ DrawerFocusManager$DrawerClosingTimeoutAlarm(DrawerFocusManager drawerFocusManager, DrawerFocusManager$1 drawerFocusManager$1) {
        this(drawerFocusManager);
    }
}

