/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.statemachine.commands;

import de.audi.app.terminalmode.IContext;
import de.audi.app.terminalmode.dsi.IAppState;
import de.audi.app.terminalmode.dsi.IResource;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.Command;

public abstract class AbstractCommand
extends Command {
    public static final int COMMAND_TIMEOUT_10_SECONDS = 10000;
    protected final IContext context;

    public AbstractCommand(LogChannel logChannel, String string, IContext iContext) {
        super(logChannel, string);
        this.context = iContext;
    }

    public boolean updateStates(IAppState[] iAppStateArray, IResource[] iResourceArray, long l) {
        return false;
    }

    public boolean updateAudioFocus(boolean bl) {
        return false;
    }

    public long getTimeout() {
        return 10000L;
    }
}

