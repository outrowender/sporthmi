/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.compose;

import de.audi.app.messaging.core.compose.SendMessageController;
import de.audi.app.messaging.core.compose.SendMessageController$1;
import de.audi.atip.hmi.model.DefaultButtonListener;

class SendMessageController$MyButtonListener
extends DefaultButtonListener {
    private final /* synthetic */ SendMessageController this$0;

    private SendMessageController$MyButtonListener(SendMessageController sendMessageController) {
        this.this$0 = sendMessageController;
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        if (n == -1483595520 || n == -745332480) {
            this.this$0.sendButton(n, n3);
        } else if (n == -812506880) {
            SendMessageController.access$400(this.this$0, n, n3);
        } else if (n == -1332535040 || n == 1083384064) {
            SendMessageController.access$500(this.this$0, n, n3);
        } else {
            SendMessageController.access$600(this.this$0).log(10000, "[SendMessageController#keyTyped] Unexpected modelID = %1", (long)n);
        }
    }

    /* synthetic */ SendMessageController$MyButtonListener(SendMessageController sendMessageController, SendMessageController$1 sendMessageController$1) {
        this(sendMessageController);
    }
}

