/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.compose;

import de.audi.app.messaging.core.compose.SendMessageController;
import de.audi.app.messaging.core.compose.SendMessageController$1;
import de.audi.app.messaging.core.dsi.messaging.DsiMessagingEmptyListener;
import org.dsi.ifc.messaging.AttachmentInformation;
import org.dsi.ifc.messaging.RecipientList;

class SendMessageController$MyDsiMessagingListener
extends DsiMessagingEmptyListener {
    private final /* synthetic */ SendMessageController this$0;

    private SendMessageController$MyDsiMessagingListener(SendMessageController sendMessageController) {
        this.this$0 = sendMessageController;
    }

    @Override
    public final void indicateSendMessage(int[] nArray, int n, int n2, RecipientList recipientList, String string, String string2, AttachmentInformation[] attachmentInformationArray, int n3) {
        SendMessageController.access$700(this.this$0, nArray, n);
    }

    /* synthetic */ SendMessageController$MyDsiMessagingListener(SendMessageController sendMessageController, SendMessageController$1 sendMessageController$1) {
        this(sendMessageController);
    }
}

