/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.messagingservice;

import de.audi.app.messaging.core.addressbook.GetEntryCommand$ResultHandler;
import de.audi.app.messaging.core.messagingservice.MessagingService;
import org.dsi.ifc.organizer.AdbEntry;

class MessagingService$1
implements GetEntryCommand$ResultHandler {
    private final /* synthetic */ int val$dataIndex;
    private final /* synthetic */ int val$msgType;
    private final /* synthetic */ MessagingService this$0;

    MessagingService$1(MessagingService messagingService, int n, int n2) {
        this.this$0 = messagingService;
        this.val$dataIndex = n;
        this.val$msgType = n2;
    }

    @Override
    public void handleResult(int n, AdbEntry adbEntry) {
        this.this$0.handleCommandResult(n, adbEntry, this.val$dataIndex, this.val$msgType);
    }
}

