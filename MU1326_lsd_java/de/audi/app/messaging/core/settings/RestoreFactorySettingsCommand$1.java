/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.settings;

import de.audi.app.messaging.core.application.AbstractMsgApplication;
import de.audi.app.messaging.core.commands.AbstractMessagingCommand;
import de.audi.app.messaging.core.settings.RestoreFactorySettingsCommand;

class RestoreFactorySettingsCommand$1
extends AbstractMessagingCommand {
    private final /* synthetic */ RestoreFactorySettingsCommand this$0;

    RestoreFactorySettingsCommand$1(RestoreFactorySettingsCommand restoreFactorySettingsCommand, AbstractMsgApplication abstractMsgApplication) {
        this.this$0 = restoreFactorySettingsCommand;
        super(abstractMsgApplication);
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "[RestoreFactorySettingsErrorCommand#execute]");
        RestoreFactorySettingsCommand.access$000(this.this$0, 1);
    }
}

