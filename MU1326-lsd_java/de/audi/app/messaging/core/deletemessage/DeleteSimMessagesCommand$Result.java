/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.deletemessage;

import de.audi.app.messaging.core.deletemessage.DeleteSimMessagesCommand;
import de.audi.app.messaging.core.deletemessage.DeleteSimMessagesCommand$1;

final class DeleteSimMessagesCommand$Result {
    private final int resultCode;
    private final /* synthetic */ DeleteSimMessagesCommand this$0;

    private DeleteSimMessagesCommand$Result(DeleteSimMessagesCommand deleteSimMessagesCommand, int n) {
        this.this$0 = deleteSimMessagesCommand;
        this.resultCode = n;
    }

    public int getResultCode() {
        return this.resultCode;
    }

    /* synthetic */ DeleteSimMessagesCommand$Result(DeleteSimMessagesCommand deleteSimMessagesCommand, int n, DeleteSimMessagesCommand$1 deleteSimMessagesCommand$1) {
        this(deleteSimMessagesCommand, n);
    }
}

