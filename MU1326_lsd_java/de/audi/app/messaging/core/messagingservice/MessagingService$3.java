/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.messagingservice;

import de.audi.app.messaging.core.messagingservice.MessagingService;
import de.audi.atip.interapp.ADBHMIAppServiceListener;
import de.audi.tghu.command.CommandResponse;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.organizer.AdbEntry;

class MessagingService$3
extends CommandResponse {
    private final /* synthetic */ int val$success;
    private final /* synthetic */ AdbEntry[] val$entries;
    private final /* synthetic */ MessagingService this$0;

    MessagingService$3(MessagingService messagingService, int n, AdbEntry[] adbEntryArray) {
        this.this$0 = messagingService;
        this.val$success = n;
        this.val$entries = adbEntryArray;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ADBHMIAppServiceListener aDBHMIAppServiceListener = (ADBHMIAppServiceListener)((Object)dSIListener);
        aDBHMIAppServiceListener.responseParseVCards(this.val$success, this.val$entries);
    }
}

