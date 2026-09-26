/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.compose;

import de.audi.app.messaging.core.compose.NewMessage;
import de.audi.app.messaging.core.compose.NewMessage$1;
import de.audi.app.messaging.core.dsi.messaging.DsiMessagingEmptyListener;
import org.dsi.ifc.messaging.StatusInformation;

final class NewMessage$MyDsiMessagingListener
extends DsiMessagingEmptyListener {
    private final /* synthetic */ NewMessage this$0;

    private NewMessage$MyDsiMessagingListener(NewMessage newMessage) {
        this.this$0 = newMessage;
    }

    @Override
    public void indicateMessageStatus(StatusInformation statusInformation) {
        NewMessage.access$1100(this.this$0).log(-2137614336, "[NewMessage#indicateMessageStatus]");
        if (statusInformation.getStatus() == 1) {
            String string = statusInformation.getMessageId();
            if (NewMessage.access$1200(this.this$0).equals(string)) {
                NewMessage.access$1300(this.this$0).log(1078071040, "[NewMessage#indicateMessageStatus] The draft this message is backed by has been deleted, clearing cached draft ID.");
                NewMessage.access$1400(this.this$0, "");
            }
        }
    }

    /* synthetic */ NewMessage$MyDsiMessagingListener(NewMessage newMessage, NewMessage$1 newMessage$1) {
        this(newMessage);
    }
}

