/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.viewmessage;

import de.audi.app.messaging.core.dsi.messaging.DsiMessagingEmptyListener;
import de.audi.app.messaging.core.viewmessage.SelectedMessage;
import de.audi.app.messaging.core.viewmessage.SelectedMessage$1;
import org.dsi.ifc.messaging.MessageDetails;
import org.dsi.ifc.messaging.StatusInformation;

final class SelectedMessage$MyDsiMessagingListener
extends DsiMessagingEmptyListener {
    private final /* synthetic */ SelectedMessage this$0;

    private SelectedMessage$MyDsiMessagingListener(SelectedMessage selectedMessage) {
        this.this$0 = selectedMessage;
    }

    @Override
    public void indicateMessageStatus(StatusInformation statusInformation) {
        MessageDetails messageDetails;
        SelectedMessage.access$1300(this.this$0).log(-2137614336, "[SelectedMessage#indicateMessageStatus]");
        if (statusInformation.getStatus() == 1 && (messageDetails = this.this$0.getMessageDetails()) != null && messageDetails.getMessageID().equals(statusInformation.getMessageId())) {
            SelectedMessage.access$1400(this.this$0).log(1078071040, "[SelectedMessage#indicateMessageStatus] Selected message deleted, message ID: %1", (Object)messageDetails.getMessageID());
            SelectedMessage.access$1500(this.this$0, true);
        }
    }

    /* synthetic */ SelectedMessage$MyDsiMessagingListener(SelectedMessage selectedMessage, SelectedMessage$1 selectedMessage$1) {
        this(selectedMessage);
    }
}

