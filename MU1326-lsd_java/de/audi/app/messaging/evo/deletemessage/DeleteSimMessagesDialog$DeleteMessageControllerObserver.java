/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.evo.deletemessage;

import de.audi.app.messaging.core.deletemessage.IDeleteMessageControllerObserver;
import de.audi.app.messaging.evo.deletemessage.DeleteSimMessagesDialog;
import de.audi.app.messaging.evo.deletemessage.DeleteSimMessagesDialog$1;

final class DeleteSimMessagesDialog$DeleteMessageControllerObserver
implements IDeleteMessageControllerObserver {
    private final /* synthetic */ DeleteSimMessagesDialog this$0;

    private DeleteSimMessagesDialog$DeleteMessageControllerObserver(DeleteSimMessagesDialog deleteSimMessagesDialog) {
        this.this$0 = deleteSimMessagesDialog;
    }

    @Override
    public void indicateDeleteSimMessagesState(int n) {
        DeleteSimMessagesDialog.access$600(this.this$0).log(-2137614336, "[DeleteSimMessagesDialog#indicateDeleteSimMessagesState]");
        DeleteSimMessagesDialog.access$700(this.this$0, n);
    }

    /* synthetic */ DeleteSimMessagesDialog$DeleteMessageControllerObserver(DeleteSimMessagesDialog deleteSimMessagesDialog, DeleteSimMessagesDialog$1 deleteSimMessagesDialog$1) {
        this(deleteSimMessagesDialog);
    }
}

