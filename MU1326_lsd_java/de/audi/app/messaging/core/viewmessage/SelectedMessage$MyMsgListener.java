/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.viewmessage;

import de.audi.app.messaging.core.viewmessage.SelectedMessage;
import de.audi.app.messaging.core.viewmessage.SelectedMessage$1;
import de.audi.atip.msg.MsgListener;

final class SelectedMessage$MyMsgListener
implements MsgListener {
    private final /* synthetic */ SelectedMessage this$0;

    private SelectedMessage$MyMsgListener(SelectedMessage selectedMessage) {
        this.this$0 = selectedMessage;
    }

    @Override
    public void processMsg(int n) {
        if (n == 11) {
            SelectedMessage.access$1800(this.this$0).log(1078071040, "[SelectedMessage#processMsg] message = %1 (UNITS_CHANGED)", (long)n);
            SelectedMessage.access$1900(this.this$0, this.this$0.getMessageListEntry());
        }
    }

    /* synthetic */ SelectedMessage$MyMsgListener(SelectedMessage selectedMessage, SelectedMessage$1 selectedMessage$1) {
        this(selectedMessage);
    }
}

