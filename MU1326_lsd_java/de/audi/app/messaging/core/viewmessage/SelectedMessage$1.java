/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.viewmessage;

import de.audi.app.messaging.core.viewmessage.GetMessageContentsCommand$ResultHandler;
import de.audi.app.messaging.core.viewmessage.SelectedMessage;
import de.audi.app.messaging.core.viewmessage.SelectedMessage$ISetMessageResultHandler;
import org.dsi.ifc.messaging.MessageDetails;
import org.dsi.ifc.messaging.MessageListEntry;

class SelectedMessage$1
implements GetMessageContentsCommand$ResultHandler {
    private final /* synthetic */ MessageListEntry val$requestedMessageListEntry;
    private final /* synthetic */ SelectedMessage$ISetMessageResultHandler val$setMessageResultHandler;
    private final /* synthetic */ SelectedMessage this$0;

    SelectedMessage$1(SelectedMessage selectedMessage, MessageListEntry messageListEntry, SelectedMessage$ISetMessageResultHandler selectedMessage$ISetMessageResultHandler) {
        this.this$0 = selectedMessage;
        this.val$requestedMessageListEntry = messageListEntry;
        this.val$setMessageResultHandler = selectedMessage$ISetMessageResultHandler;
    }

    @Override
    public void handleResult(boolean bl, MessageDetails messageDetails, int n) {
        SelectedMessage.access$500(this.this$0, this.val$requestedMessageListEntry, bl, messageDetails, n, this.val$setMessageResultHandler);
    }
}

