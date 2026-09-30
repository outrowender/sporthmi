/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.device;

import de.audi.app.terminalmode.IContext;
import de.audi.app.terminalmode.statemachine.IStateHandler;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;

public interface IDeviceVariantsHandling {
    public CommandList cleanupAfterDeviceDisconnected(IContext var1, IStateHandler var2, LogChannel var3, String var4);

    public void setDeviceVariantsHandler(IDeviceVariantsHandling var1);
}

