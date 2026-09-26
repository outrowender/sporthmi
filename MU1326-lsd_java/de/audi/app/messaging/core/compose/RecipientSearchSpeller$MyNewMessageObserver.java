/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.compose;

import de.audi.app.messaging.core.compose.INewMessageObserver$DefaultNewMessageObserver;
import de.audi.app.messaging.core.compose.RecipientSearchSpeller;
import de.audi.app.messaging.core.compose.RecipientSearchSpeller$1;

class RecipientSearchSpeller$MyNewMessageObserver
extends INewMessageObserver$DefaultNewMessageObserver {
    private final /* synthetic */ RecipientSearchSpeller this$0;

    private RecipientSearchSpeller$MyNewMessageObserver(RecipientSearchSpeller recipientSearchSpeller) {
        this.this$0 = recipientSearchSpeller;
    }

    @Override
    public void messageCleared() {
        this.this$0.clear();
    }

    /* synthetic */ RecipientSearchSpeller$MyNewMessageObserver(RecipientSearchSpeller recipientSearchSpeller, RecipientSearchSpeller$1 recipientSearchSpeller$1) {
        this(recipientSearchSpeller);
    }
}

