/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.viewmessage;

import de.audi.app.messaging.core.viewmessage.GetMessageContentsCommand$ResultHandler;
import de.audi.app.messaging.core.viewmessage.SelectedMessage;
import de.audi.app.messaging.core.viewmessage.SelectedMessage$NewMessageIndicationManagerObserver;
import org.dsi.ifc.messaging.MessageDetails;

class SelectedMessage$NewMessageIndicationManagerObserver$1
implements GetMessageContentsCommand$ResultHandler {
    private final /* synthetic */ SelectedMessage$NewMessageIndicationManagerObserver this$1;

    SelectedMessage$NewMessageIndicationManagerObserver$1(SelectedMessage$NewMessageIndicationManagerObserver selectedMessage$NewMessageIndicationManagerObserver) {
        this.this$1 = selectedMessage$NewMessageIndicationManagerObserver;
    }

    @Override
    public void handleResult(boolean bl, MessageDetails messageDetails, int n) {
        SelectedMessage.access$1100(SelectedMessage$NewMessageIndicationManagerObserver.access$1000(this.this$1), bl, messageDetails, n);
    }
}

