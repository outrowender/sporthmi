/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.evo.compose;

import de.audi.app.messaging.evo.compose.MessageLengthPopup;
import de.audi.app.messaging.evo.compose.MessageLengthPopup$1;
import de.audi.atip.hmi.model.DefaultButtonListener;

final class MessageLengthPopup$MyButtonListener
extends DefaultButtonListener {
    private final /* synthetic */ MessageLengthPopup this$0;

    private MessageLengthPopup$MyButtonListener(MessageLengthPopup messageLengthPopup) {
        this.this$0 = messageLengthPopup;
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        if (n == 1620254976 || n == 1603477760) {
            MessageLengthPopup.access$1000(this.this$0, n, n3);
        } else {
            MessageLengthPopup.access$1100(this.this$0).log(10000, "[MessageLengthPopup#keyTyped] Unexpected modelID = %1", (long)n);
        }
    }

    /* synthetic */ MessageLengthPopup$MyButtonListener(MessageLengthPopup messageLengthPopup, MessageLengthPopup$1 messageLengthPopup$1) {
        this(messageLengthPopup);
    }
}

