/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.compose;

import de.audi.app.messaging.core.compose.MessageCreator;
import de.audi.app.messaging.core.viewmessage.SelectedMessage$ISetMessageResultHandler;
import org.dsi.ifc.messaging.MessageDetails;

class MessageCreator$2
implements SelectedMessage$ISetMessageResultHandler {
    private final /* synthetic */ boolean val$replyAll;
    private final /* synthetic */ MessageCreator this$0;

    MessageCreator$2(MessageCreator messageCreator, boolean bl) {
        this.this$0 = messageCreator;
        this.val$replyAll = bl;
    }

    @Override
    public void responseSetMessage(boolean bl, MessageDetails messageDetails) {
        if (bl) {
            MessageCreator.access$300(this.this$0).getNewMessage().prepareReplyToMessage(messageDetails, this.val$replyAll);
        }
    }
}

