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
    private static final long COMMAND_TIMEOUT;
    private static final int LOG_CMDS_COUNT;
    private static int executedFirstCmds;
    protected static final int CMD_UNDEF;
    public static final int CMD_AUDIO;
    public static final int CMD_AMFM;
    public static final int CMD_DAB;
    private static final int CMD_AMFM_AUDIO;
    private static final int CMD_DAB_AUDIO;
    public static final int CMD_ALL_BAND;
    public static final int CMD_SDARS;
    public static final int CMD_SDARS_AUDIO;
    public static final int CMD_UNIFIED;
    private static final int CMD_UNIFIED_AUDIO;
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
            this.framework.getStartupMgr().logStartupEvent(new StringBuffer().append("[RADIO] [EXECUTE] ").append(this.toString()).toString());
        }
    }

    protected final void logFinishFirstCmd() {
        if (executedFirstCmds < 20) {
            this.framework.getStartupMgr().logStartupEvent(new StringBuffer().append("[RADIO] [FINISH]  ").append(this.toString()).toString());
            ++executedFirstCmds;
        }
    }

    protected void commandFinished() {
        this.logger.log(-2137614336, "[AbractRadioCommand.commandFinished] '%1'", (Object)this);
        this.commandList.commandFinished();
    }

    @Override
    public long getTimeout() {
        return 0;
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

    static {
        executedFirstCmds = 0;
    }
}

