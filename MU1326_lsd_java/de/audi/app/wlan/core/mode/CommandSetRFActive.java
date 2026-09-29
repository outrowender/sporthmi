/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.wlan.core.mode;

import de.audi.app.wlan.core.AbstractWlanCommand;
import de.audi.app.wlan.core.IWlanApplication;
import de.audi.app.wlan.core.mode.CommandSetRFActive$ErrorCommand;
import de.audi.atip.hmi.modelaccess.HMIModelApp;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.networking.DSIWLAN;

final class CommandSetRFActive
extends AbstractWlanCommand {
    private final HMIModelApp monitor;
    private final boolean active;
    private CommandSetRFActive$ErrorCommand errorCommand;
    static /* synthetic */ Class class$de$audi$app$wlan$core$mode$CommandSetRFActive;

    static void schedule(IWlanApplication iWlanApplication, DSIWLAN dSIWLAN, HMIModelApp hMIModelApp, boolean bl) {
        CommandSetRFActive commandSetRFActive = new CommandSetRFActive(iWlanApplication.getLogChannel(), dSIWLAN, hMIModelApp, bl);
        AbstractWlanCommand.schedule(iWlanApplication.getCommandListManager(), commandSetRFActive, commandSetRFActive.getErrorCommand());
    }

    private CommandSetRFActive(LogChannel logChannel, DSIWLAN dSIWLAN, HMIModelApp hMIModelApp, boolean bl) {
        super(logChannel, dSIWLAN, (class$de$audi$app$wlan$core$mode$CommandSetRFActive == null ? (class$de$audi$app$wlan$core$mode$CommandSetRFActive = CommandSetRFActive.class$("de.audi.app.wlan.core.mode.CommandSetRFActive")) : class$de$audi$app$wlan$core$mode$CommandSetRFActive).getName());
        this.monitor = hMIModelApp;
        this.active = bl;
        this.errorCommand = new CommandSetRFActive$ErrorCommand(this, logChannel);
        this.setMonitorStatus(0);
    }

    private void setMonitorStatus(int n) {
        if (this.monitor != null) {
            this.monitor.setStatus(n);
        }
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "CommandSetRFActive#execute(): active: %1", this.active);
        this.dsiWlan.setRFActive(this.active);
    }

    @Override
    public void responseSetRFActive(int n) {
        this.logger.log(1078071040, "CommandSetRFActive#responseSetRFActive(): result ok: %1", n == 0);
        this.setMonitorStatus(1);
        this.commandList.commandFinished();
    }

    public CommandSetRFActive$ErrorCommand getErrorCommand() {
        return this.errorCommand;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static /* synthetic */ void access$000(CommandSetRFActive commandSetRFActive, int n) {
        commandSetRFActive.setMonitorStatus(n);
    }
}

