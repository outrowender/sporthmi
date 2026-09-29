/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps;

import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.common.Logger;
import de.audi.app.sdsmanager.syscall.ISystemCall;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.Command;
import de.audi.tghu.command.ICommandList;

public abstract class AbstractSystemCallCommand
extends Command {
    public static final byte ACTION_CONTINUE;
    public static final byte ACTION_ABORT_SILENTLY;
    private final LogChannel lc = Logger.getMainLog();
    protected final SDSHandlerService sdsHandlerService;

    public AbstractSystemCallCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService) {
        super(logChannel, string);
        this.sdsHandlerService = sDSHandlerService;
    }

    public boolean isSDSEndSequenceCommand() {
        return false;
    }

    public boolean isSDSSessionEndCommand() {
        return false;
    }

    public boolean handleKeyTyped(int n, int n2, int n3) {
        return false;
    }

    public byte getActionOnNewSystemCall(ISystemCall iSystemCall) {
        return 0;
    }

    protected void handleSDSLineNumbering() {
    }

    public void sendResult(int n) {
        this.logger.log(-2137614336, "%1#sendResult: eventID=%2", (Object)this.getName(), (long)n);
        this.sdsHandlerService.sendResult(n);
        this.processingFinished();
    }

    public boolean finishWaitingCommandOnDDS() {
        return false;
    }

    public void processingFinished() {
        this.lc.log(-2137614336, "%1#processingFinished: called", (Object)this.getName());
        this.handleSDSLineNumbering();
        ICommandList iCommandList = super.getCommandList();
        if (iCommandList == null) {
            this.lc.log(-1601830656, "%1#processingFinished: No cmdList available!", (Object)this.getName());
            return;
        }
        iCommandList.commandFinished();
    }

    public boolean handleTimeout() {
        this.sendResult(3001);
        return false;
    }
}

