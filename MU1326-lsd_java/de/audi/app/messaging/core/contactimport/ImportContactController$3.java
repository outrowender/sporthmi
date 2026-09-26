/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.contactimport;

import de.audi.app.messaging.core.commands.ICommandCallback;
import de.audi.app.messaging.core.contactimport.ImportContactController;
import de.audi.tghu.command.Command;

class ImportContactController$3
implements ICommandCallback {
    private final /* synthetic */ ImportContactController this$0;

    ImportContactController$3(ImportContactController importContactController) {
        this.this$0 = importContactController;
    }

    @Override
    public void terminating(Command command) {
        ImportContactController.access$200(this.this$0, command);
    }
}

