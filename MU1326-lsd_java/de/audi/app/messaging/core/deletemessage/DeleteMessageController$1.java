/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.deletemessage;

import de.audi.app.messaging.core.deletemessage.DeleteMessageCommand$ResultHandler;
import de.audi.app.messaging.core.deletemessage.DeleteMessageController;

class DeleteMessageController$1
implements DeleteMessageCommand$ResultHandler {
    private final /* synthetic */ DeleteMessageController this$0;

    DeleteMessageController$1(DeleteMessageController deleteMessageController) {
        this.this$0 = deleteMessageController;
    }

    @Override
    public void handleResult(int n) {
        DeleteMessageController.access$000(this.this$0, n);
    }
}

