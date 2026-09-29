/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.compose;

import de.audi.app.messaging.core.compose.MessageCreator;
import de.audi.app.messaging.core.viewmessage.SelectedMessage$ISetMessageResultHandler;
import org.dsi.ifc.messaging.MessageDetails;

class MessageCreator$3
implements SelectedMessage$ISetMessageResultHandler {
    private final /* synthetic */ MessageCreator this$0;

    MessageCreator$3(MessageCreator messageCreator) {
        this.this$0 = messageCreator;
    }

    @Override
    public void responseSetMessage(boolean bl, MessageDetails messageDetails) {
        if (bl) {
            MessageCreator.access$400(this.this$0).getNewMessage().prepareForwardMessage(messageDetails);
        }
    }
}

