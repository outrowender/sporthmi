/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.compose;

import de.audi.app.messaging.core.compose.NewMessage;
import de.audi.app.messaging.core.compose.NewMessage$1;
import de.audi.atip.hmi.model.DefaultTextEditorListenerDD;

class NewMessage$MyTextEditorListenerDD
extends DefaultTextEditorListenerDD {
    private final /* synthetic */ NewMessage this$0;

    private NewMessage$MyTextEditorListenerDD(NewMessage newMessage) {
        this.this$0 = newMessage;
    }

    @Override
    public void textChanged(int n, int n2, int n3) {
        if (n == -1349312256) {
            NewMessage.access$600(this.this$0);
        } else if (n == -1198317312) {
            NewMessage.access$700(this.this$0);
        } else {
            NewMessage.access$800(this.this$0).log(10000, "[NewMessage#textChanged] Unexpected modelID = %1", (long)n);
        }
    }

    /* synthetic */ NewMessage$MyTextEditorListenerDD(NewMessage newMessage, NewMessage$1 newMessage$1) {
        this(newMessage);
    }
}

