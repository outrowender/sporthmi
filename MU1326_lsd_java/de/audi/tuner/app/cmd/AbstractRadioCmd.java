/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.cmd;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.Command;
import de.esolutions.fw.util.commons.Buffer;

public abstract class AbstractRadioCmd
extends Command {
    private static final long COMMAND_TIMEOUT = 20000L;
    private static final int LOG_CMDS_COUNT = 20;
    private static int executedFirstCmds = 0;
    protected static final int CMD_UNDEF = -1;
    public static final int CMD_AUDIO = 0;
    public static final int CMD_AMFM = 1;
    public static final int CMD_DAB = 2;
    private static final int CMD_AMFM_AUDIO = 3;
    private static final int CMD_DAB_AUDIO = 4;
    public static final int CMD_ALL_BAND = 5;
    public static final int CMD_SDARS = 6;
    public static final int CMD_SDARS_AUDIO = 7;
    public static final int CMD_UNIFIED = 8;
    private static final int CMD_UNIFIED_AUDIO = 9;
    private final int cmdType;
    private final IFrameworkAccess framework;

    protected AbstractRadioCmd(IFrameworkAccess iFrameworkAccess, LogChannel logChannel, int n) {
        super(logChannel);
        this.framework = iFrameworkAccess;
        this.cmdType = n;
    }

    protected final void setName(Buffer buffer) {
        super.setName(buffer.toString());
    }

    protected final void logExecuteFirstCmd() {
        if (executedFirstCmds < 20) {
            this.framework.getStartupMgr().logStartupEvent("[RADIO] [EXECUTE] " + this.toString());
        }
    }

    protected final void logFinishFirstCmd() {
        if (executedFirstCmds < 20) {
            this.framework.getStartupMgr().logStartupEvent("[RADIO] [FINISH]  " + this.toString());
            ++executedFirstCmds;
        }
    }

    protected void commandFinished() {
        this.logger.log(10000000, "[AbractRadioCommand.commandFinished] '%1'", (Object)this);
        this.commandList.commandFinished();
    }

    public long getTimeout() {
        return 20000L;
    }

    public boolean isAudioCmd() {
        return this.cmdType == 0 || this.cmdType == 3 || this.cmdType == 4;
    }

    public boolean isAMFMCmd() {
        return this.cmdType == 1 || this.cmdType == 3;
    }

    public boolean isDABCmd() {
        return this.cmdType == 2 || this.cmdType == 4;
    }

    public boolean isSDARSCmd() {
        return this.cmdType == 6;
    }

    public boolean isUnifiedCmd() {
        return this.cmdType == 8 || this.cmdType == 9;
    }

    public boolean isAllBandCmd() {
        return this.cmdType == 5;
    }
}

