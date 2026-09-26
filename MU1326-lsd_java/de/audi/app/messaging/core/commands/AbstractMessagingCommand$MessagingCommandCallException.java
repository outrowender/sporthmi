/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.commands;

import de.audi.app.messaging.core.commands.AbstractMessagingCommand;

class AbstractMessagingCommand$MessagingCommandCallException
extends RuntimeException {
    private static final long serialVersionUID;
    private final /* synthetic */ AbstractMessagingCommand this$0;

    public AbstractMessagingCommand$MessagingCommandCallException(AbstractMessagingCommand abstractMessagingCommand, String string) {
        this.this$0 = abstractMessagingCommand;
        super(string);
    }
}

