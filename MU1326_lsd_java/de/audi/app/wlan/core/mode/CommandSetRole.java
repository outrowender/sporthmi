/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.wlan.core.mode;

import de.audi.app.wlan.core.AbstractWlanCommand;
import de.audi.app.wlan.core.IWlanApplication;
import de.audi.atip.hmi.modelaccess.HMIModelApp;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.networking.DSIWLAN;

public final class CommandSetRole
extends AbstractWlanCommand {
    private final HMIModelApp monitor;
    private final int role;
    static /* synthetic */ Class class$de$audi$app$wlan$core$mode$CommandSetRole;

    public static void schedule(IWlanApplication iWlanApplication, DSIWLAN dSIWLAN, HMIModelApp hMIModelApp, int n) {
        CommandSetRole commandSetRole = new CommandSetRole(iWlanApplication.getLogChannel(), dSIWLAN, hMIModelApp, n);
        AbstractWlanCommand.schedule(iWlanApplication.getCommandListManager(), commandSetRole);
    }

    private CommandSetRole(LogChannel logChannel, DSIWLAN dSIWLAN, HMIModelApp hMIModelApp, int n) {
        super(logChannel, dSIWLAN, (class$de$audi$app$wlan$core$mode$CommandSetRole == null ? (class$de$audi$app$wlan$core$mode$CommandSetRole = CommandSetRole.class$("de.audi.app.wlan.core.mode.CommandSetRole")) : class$de$audi$app$wlan$core$mode$CommandSetRole).getName());
        this.monitor = hMIModelApp;
        this.role = n;
        this.setMonitorStatus(0);
    }

    private void setMonitorStatus(int n) {
        if (this.monitor != null) {
            this.monitor.setStatus(n);
        }
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "CommandSetRole#execute(): role: %1", (long)this.role);
        this.dsiWlan.setRole(this.role);
    }

    @Override
    public void responseSetRole(int n) {
        this.logger.log(1078071040, "CommandSetRole#responseSetRole(): result ok: %1", n == 0);
        this.setMonitorStatus(1);
        this.commandList.commandFinished();
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

