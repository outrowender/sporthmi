/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.device;

import de.audi.app.terminalmode.IContext;
import de.audi.app.terminalmode.statemachine.IStateHandler;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;

public interface IDeviceVariantsHandling {
    default public CommandList cleanupAfterDeviceDisconnected(IContext iContext, IStateHandler iStateHandler, LogChannel logChannel, String string) {
    }

    default public void setDeviceVariantsHandler(IDeviceVariantsHandling iDeviceVariantsHandling) {
    }
}

