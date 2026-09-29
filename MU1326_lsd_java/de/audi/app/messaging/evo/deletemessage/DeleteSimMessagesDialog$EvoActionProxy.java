/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.evo.deletemessage;

import de.audi.app.messaging.core.guide.IActionProxySubscriber;
import de.audi.app.messaging.evo.deletemessage.DeleteSimMessagesDialog;
import de.audi.app.messaging.evo.deletemessage.DeleteSimMessagesDialog$1;
import de.audi.app.messaging.evo.guide.DefaultEvoActionProxy;

final class DeleteSimMessagesDialog$EvoActionProxy
extends DefaultEvoActionProxy
implements IActionProxySubscriber {
    private final /* synthetic */ DeleteSimMessagesDialog this$0;

    private DeleteSimMessagesDialog$EvoActionProxy(DeleteSimMessagesDialog deleteSimMessagesDialog) {
        this.this$0 = deleteSimMessagesDialog;
    }

    @Override
    public void messagingTransition(int n, int n2) {
        DeleteSimMessagesDialog.access$800(this.this$0).log(-2137614336, "[DeleteSimMessagesDialog#messagingTransition]");
        DeleteSimMessagesDialog.access$900(this.this$0, n2 == 0);
    }

    /* synthetic */ DeleteSimMessagesDialog$EvoActionProxy(DeleteSimMessagesDialog deleteSimMessagesDialog, DeleteSimMessagesDialog$1 deleteSimMessagesDialog$1) {
        this(deleteSimMessagesDialog);
    }
}

