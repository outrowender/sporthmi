/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.messagingservice;

import de.audi.app.messaging.core.messagingservice.MessagingService;
import de.audi.atip.interapp.ADBHMIAppServiceListener;
import de.audi.tghu.command.CommandResponse;
import org.dsi.ifc.base.DSIListener;

class MessagingService$4
extends CommandResponse {
    private final /* synthetic */ int val$result;
    private final /* synthetic */ MessagingService this$0;

    MessagingService$4(MessagingService messagingService, int n) {
        this.this$0 = messagingService;
        this.val$result = n;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ADBHMIAppServiceListener aDBHMIAppServiceListener = (ADBHMIAppServiceListener)((Object)dSIListener);
        aDBHMIAppServiceListener.responseInsertEntry(this.val$result);
    }
}

