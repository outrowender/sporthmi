/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.compose;

import de.audi.app.messaging.core.compose.MessageCreator;
import de.audi.app.messaging.core.compose.MessageCreator$1;
import de.audi.atip.hmi.model.DefaultButtonListener;

class MessageCreator$MyButtonListener
extends DefaultButtonListener {
    private final /* synthetic */ MessageCreator this$0;

    private MessageCreator$MyButtonListener(MessageCreator messageCreator) {
        this.this$0 = messageCreator;
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        if (n == -1231871744 || n == 1033052416) {
            MessageCreator.access$500(this.this$0, n, n3);
        } else if (n == 1670521088 || n == 1167270144) {
            MessageCreator.access$600(this.this$0, n, n3);
        } else if (n == -1416421120 || n == 1184047360) {
            MessageCreator.access$700(this.this$0, n, n3);
        } else if (n == -1164762880) {
            MessageCreator.access$800(this.this$0, n, n3);
        } else if (n == -1315757824 || n == 1217601792) {
            MessageCreator.access$900(this.this$0, n, n3);
        } else if (n == -1298980608 || n == 1150492928) {
            MessageCreator.access$1000(this.this$0, n, n3);
        } else {
            MessageCreator.access$1100(this.this$0).log(10000, "[MessageCreator#keyTyped] Unexpected modelID = %1", (long)n);
        }
    }

    /* synthetic */ MessageCreator$MyButtonListener(MessageCreator messageCreator, MessageCreator$1 messageCreator$1) {
        this(messageCreator);
    }
}

