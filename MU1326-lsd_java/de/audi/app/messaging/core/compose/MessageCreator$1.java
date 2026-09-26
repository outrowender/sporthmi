/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.compose;

import de.audi.app.messaging.core.compose.MessageCreator;
import de.audi.app.messaging.core.viewmessage.SelectedMessage$ISetMessageResultHandler;
import org.dsi.ifc.messaging.MessageDetails;

class MessageCreator$1
implements SelectedMessage$ISetMessageResultHandler {
    private final /* synthetic */ MessageCreator this$0;

    MessageCreator$1(MessageCreator messageCreator) {
        this.this$0 = messageCreator;
    }

    @Override
    public void responseSetMessage(boolean bl, MessageDetails messageDetails) {
        if (bl) {
            MessageCreator.access$200(this.this$0).getNewMessage().prepareEditMessage(messageDetails);
        }
    }
}

