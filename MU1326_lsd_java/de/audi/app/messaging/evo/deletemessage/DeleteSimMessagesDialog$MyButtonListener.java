/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.evo.deletemessage;

import de.audi.app.messaging.evo.deletemessage.DeleteSimMessagesDialog;
import de.audi.app.messaging.evo.deletemessage.DeleteSimMessagesDialog$1;
import de.audi.atip.hmi.model.DefaultButtonListener;

final class DeleteSimMessagesDialog$MyButtonListener
extends DefaultButtonListener {
    private final /* synthetic */ DeleteSimMessagesDialog this$0;

    private DeleteSimMessagesDialog$MyButtonListener(DeleteSimMessagesDialog deleteSimMessagesDialog) {
        this.this$0 = deleteSimMessagesDialog;
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        if (n == 1502814464) {
            DeleteSimMessagesDialog.access$300(this.this$0, n, n3);
        } else if (n == 1486037248) {
            DeleteSimMessagesDialog.access$400(this.this$0, n, n3);
        } else {
            DeleteSimMessagesDialog.access$500(this.this$0).log(10000, "[DeleteSimMessagesDialog#keyTyped] Unexpected modelID = %1", (long)n);
        }
    }

    /* synthetic */ DeleteSimMessagesDialog$MyButtonListener(DeleteSimMessagesDialog deleteSimMessagesDialog, DeleteSimMessagesDialog$1 deleteSimMessagesDialog$1) {
        this(deleteSimMessagesDialog);
    }
}

