/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.wlan.core.reset;

import de.audi.app.wlan.core.AbstractWlanCommand;
import de.audi.app.wlan.core.IWlanApplication;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.networking.DSIWLAN;

final class CommandFactoryReset
extends AbstractWlanCommand {
    static /* synthetic */ Class class$de$audi$app$wlan$core$reset$CommandFactoryReset;

    static void schedule(IWlanApplication iWlanApplication, DSIWLAN dSIWLAN) {
        CommandFactoryReset commandFactoryReset = new CommandFactoryReset(iWlanApplication.getLogChannel(), dSIWLAN);
        AbstractWlanCommand.schedule(iWlanApplication.getCommandListManager(), commandFactoryReset);
    }

    private CommandFactoryReset(LogChannel logChannel, DSIWLAN dSIWLAN) {
        super(logChannel, dSIWLAN, (class$de$audi$app$wlan$core$reset$CommandFactoryReset == null ? (class$de$audi$app$wlan$core$reset$CommandFactoryReset = CommandFactoryReset.class$("de.audi.app.wlan.core.reset.CommandFactoryReset")) : class$de$audi$app$wlan$core$reset$CommandFactoryReset).getName());
    }

    @Override
    public void execute() {
        this.dsiWlan.factoryReset();
    }

    @Override
    public void responseFactoryReset(int n) {
        this.commandList.commandFinished();
        if (n != 0) {
            this.logger.log(10000, "[CommandFactoryReset#responseFactoryReset]: Result=%1", (long)n);
        }
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

