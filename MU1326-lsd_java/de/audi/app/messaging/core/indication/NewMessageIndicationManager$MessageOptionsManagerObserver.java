/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.indication;

import de.audi.app.messaging.core.indication.NewMessageIndicationManager;
import de.audi.app.messaging.core.indication.NewMessageIndicationManager$1;
import de.audi.app.messaging.core.viewmessage.IMessageOptionsManagerObserver$EmptyImplementation;
import org.dsi.ifc.messaging.MessageDetails;

final class NewMessageIndicationManager$MessageOptionsManagerObserver
extends IMessageOptionsManagerObserver$EmptyImplementation {
    private final /* synthetic */ NewMessageIndicationManager this$0;

    private NewMessageIndicationManager$MessageOptionsManagerObserver(NewMessageIndicationManager newMessageIndicationManager) {
        this.this$0 = newMessageIndicationManager;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void messageDetailsChanged() {
        Object object = NewMessageIndicationManager.access$2700(this.this$0).getMessagingHmiLock();
        synchronized (object) {
            NewMessageIndicationManager.access$2800(this.this$0).log(-2137614336, "[NewMessageIndicationManager#messageDetailsChanged]");
            MessageDetails messageDetails = NewMessageIndicationManager.access$2900(this.this$0).getSelectedMessage().getMessageDetails();
            if (messageDetails != null) {
                NewMessageIndicationManager.access$2600(this.this$0, messageDetails.getMessageID());
            }
        }
    }

    /* synthetic */ NewMessageIndicationManager$MessageOptionsManagerObserver(NewMessageIndicationManager newMessageIndicationManager, NewMessageIndicationManager$1 newMessageIndicationManager$1) {
        this(newMessageIndicationManager);
    }
}

