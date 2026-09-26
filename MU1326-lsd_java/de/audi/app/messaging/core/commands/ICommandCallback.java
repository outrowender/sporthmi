/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.commands;

import de.audi.tghu.command.Command;

public interface ICommandCallback {
    default public void terminating(Command command) {
    }
}

