/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.evo.settings;

import de.audi.app.messaging.core.commands.ICommandCallback;
import de.audi.app.messaging.evo.settings.SmscNumberController;
import de.audi.tghu.command.Command;

class SmscNumberController$1
implements ICommandCallback {
    private final /* synthetic */ SmscNumberController this$0;

    SmscNumberController$1(SmscNumberController smscNumberController) {
        this.this$0 = smscNumberController;
    }

    @Override
    public void terminating(Command command) {
        SmscNumberController.access$000(this.this$0, command);
    }
}

