/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.base;

import de.audi.tv.app.base.NotificationHandler;
import de.audi.tv.app.base.NotificationHandler$1;
import de.audi.tv.app.dsi.DefaultTVListener;
import org.dsi.ifc.tvtuner.StartUpConfig;

class NotificationHandler$TVListener
extends DefaultTVListener {
    private final /* synthetic */ NotificationHandler this$0;

    private NotificationHandler$TVListener(NotificationHandler notificationHandler) {
        this.this$0 = notificationHandler;
    }

    @Override
    public void updateStartUpMUConfig(StartUpConfig startUpConfig) {
        if (NotificationHandler.access$100(this.this$0)) {
            int[] nArray = NotificationHandler.access$200(this.this$0, startUpConfig);
            NotificationHandler.access$300(this.this$0).log(1078071040, "[NotificationHandler.updateStartUpMUConfig] set full notifications: %1", (Object)nArray);
            NotificationHandler.access$500(this.this$0).setNotification(nArray, NotificationHandler.access$400(this.this$0));
        }
    }

    /* synthetic */ NotificationHandler$TVListener(NotificationHandler notificationHandler, NotificationHandler$1 notificationHandler$1) {
        this(notificationHandler);
    }
}

