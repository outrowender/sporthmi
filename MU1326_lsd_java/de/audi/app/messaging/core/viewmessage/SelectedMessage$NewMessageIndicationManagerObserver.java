/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.viewmessage;

import de.audi.app.messaging.core.indication.INewMessageIndicationManagerObserver;
import de.audi.app.messaging.core.util.Collections;
import de.audi.app.messaging.core.viewmessage.GetMessageContentsCommand;
import de.audi.app.messaging.core.viewmessage.SelectedMessage;
import de.audi.app.messaging.core.viewmessage.SelectedMessage$1;
import de.audi.app.messaging.core.viewmessage.SelectedMessage$NewMessageIndicationManagerObserver$1;
import java.util.Set;

class SelectedMessage$NewMessageIndicationManagerObserver
implements INewMessageIndicationManagerObserver {
    private final /* synthetic */ SelectedMessage this$0;

    private SelectedMessage$NewMessageIndicationManagerObserver(SelectedMessage selectedMessage) {
        this.this$0 = selectedMessage;
    }

    @Override
    public void indicateIndicationStateChanged(int n) {
        if (n == 0 && this.this$0.getMessageDetails() != null) {
            int n2 = this.this$0.getMessageDetails().getMessagingAccountID();
            Set set = SelectedMessage.access$700(this.this$0).getNewMessageIndicationManager().getNewMessageIDs(n2);
            String string = this.this$0.getMessageDetails().getMessageID();
            if (SelectedMessage.access$800(this.this$0).isDebug()) {
                SelectedMessage.access$900(this.this$0).log(-2137614336, "[SelectedMessage#indicateIndicationStateChanged]: selectedMessageId = %1; newMessageIds = %2", (Object)string, (Object)Collections.toString(set));
            }
            if (set.contains(string) && this.this$0.isInDetailView()) {
                SelectedMessage$NewMessageIndicationManagerObserver$1 selectedMessage$NewMessageIndicationManagerObserver$1 = new SelectedMessage$NewMessageIndicationManagerObserver$1(this);
                new GetMessageContentsCommand(SelectedMessage.access$1200(this.this$0), n2, string, 0, selectedMessage$NewMessageIndicationManagerObserver$1).schedule();
            }
        }
    }

    /* synthetic */ SelectedMessage$NewMessageIndicationManagerObserver(SelectedMessage selectedMessage, SelectedMessage$1 selectedMessage$1) {
        this(selectedMessage);
    }

    static /* synthetic */ SelectedMessage access$1000(SelectedMessage$NewMessageIndicationManagerObserver selectedMessage$NewMessageIndicationManagerObserver) {
        return selectedMessage$NewMessageIndicationManagerObserver.this$0;
    }
}

