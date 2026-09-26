/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.messagingservice;

import de.audi.app.messaging.core.addressbook.GetEntryCommand$ResultHandler;
import de.audi.app.messaging.core.messagingservice.MessagingService;
import org.dsi.ifc.organizer.AdbEntry;

class MessagingService$2
implements GetEntryCommand$ResultHandler {
    private final /* synthetic */ int val$msgType;
    private final /* synthetic */ String val$vCardPath;
    private final /* synthetic */ MessagingService this$0;

    MessagingService$2(MessagingService messagingService, int n, String string) {
        this.this$0 = messagingService;
        this.val$msgType = n;
        this.val$vCardPath = string;
    }

    @Override
    public void handleResult(int n, AdbEntry adbEntry) {
        this.this$0.handleAttachResultVCardCommand(n, adbEntry, this.val$msgType, this.val$vCardPath);
    }
}

