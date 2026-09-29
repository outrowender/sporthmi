/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.deletemessage;

import de.audi.app.messaging.core.commands.ICommandCallback;
import de.audi.app.messaging.core.deletemessage.DeleteMessageController;
import de.audi.tghu.command.Command;

class DeleteMessageController$2
implements ICommandCallback {
    private final /* synthetic */ DeleteMessageController this$0;

    DeleteMessageController$2(DeleteMessageController deleteMessageController) {
        this.this$0 = deleteMessageController;
    }

    @Override
    public void terminating(Command command) {
        DeleteMessageController.access$100(this.this$0, command);
    }
}

