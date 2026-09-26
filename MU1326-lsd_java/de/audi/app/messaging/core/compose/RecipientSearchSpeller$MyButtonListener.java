/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.compose;

import de.audi.app.messaging.core.compose.RecipientSearchSpeller;
import de.audi.app.messaging.core.compose.RecipientSearchSpeller$1;
import de.audi.atip.hmi.model.DefaultButtonListener;

class RecipientSearchSpeller$MyButtonListener
extends DefaultButtonListener {
    private final /* synthetic */ RecipientSearchSpeller this$0;

    private RecipientSearchSpeller$MyButtonListener(RecipientSearchSpeller recipientSearchSpeller) {
        this.this$0 = recipientSearchSpeller;
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        if (n == -661511936) {
            RecipientSearchSpeller.access$400(this.this$0, n, n3);
        } else {
            RecipientSearchSpeller.access$500(this.this$0).log(10000, "[RecipientSearchSpeller#keyTyped] Unexpected modelId = %1", (long)n);
        }
    }

    /* synthetic */ RecipientSearchSpeller$MyButtonListener(RecipientSearchSpeller recipientSearchSpeller, RecipientSearchSpeller$1 recipientSearchSpeller$1) {
        this(recipientSearchSpeller);
    }
}

