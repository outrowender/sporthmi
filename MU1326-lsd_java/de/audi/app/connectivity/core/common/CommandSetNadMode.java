/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.connectivity.core.common;

import de.audi.app.connectivity.core.common.PhoneProxy;
import de.audi.atip.log.LogChannel;
import de.audi.atip.phone.ITelServiceConnectivityListener;
import de.audi.tghu.command.Command;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.CommandListManager;

public final class CommandSetNadMode
extends Command
implements ITelServiceConnectivityListener {
    private PhoneProxy phone;
    private boolean upgrade;
    static /* synthetic */ Class class$de$audi$app$connectivity$core$common$CommandSetNadMode;

    public static void schedule(CommandListManager commandListManager, LogChannel logChannel, PhoneProxy phoneProxy, boolean bl) {
        CommandList commandList = new CommandList(commandListManager);
        CommandSetNadMode commandSetNadMode = new CommandSetNadMode(logChannel, (class$de$audi$app$connectivity$core$common$CommandSetNadMode == null ? (class$de$audi$app$connectivity$core$common$CommandSetNadMode = CommandSetNadMode.class$("de.audi.app.connectivity.core.common.CommandSetNadMode")) : class$de$audi$app$connectivity$core$common$CommandSetNadMode).getName(), phoneProxy, bl);
        commandList.add(commandSetNadMode);
        commandList.execute(commandSetNadMode.getName());
    }

    private CommandSetNadMode(LogChannel logChannel, String string, PhoneProxy phoneProxy, boolean bl) {
        super(logChannel, string);
        this.phone = phoneProxy;
        this.upgrade = bl;
    }

    @Override
    public void execute() {
        this.phone.setNadMode(this, this.upgrade);
    }

    @Override
    public void responseSetNadMode(int n) {
        this.commandList.commandFinished();
    }

    @Override
    public void responseChangePhoneModulePowerState(int n) {
        this.logger.log(10000, "CommandSetNadMode#responseChangePhoneModulePowerState(): Unexpected method call");
    }

    @Override
    public void responseTogglePhones(int n) {
        this.logger.log(10000, "CommandSetNadMode#responseTogglePhones(): Unexpected method call");
    }

    @Override
    public void responseSetNadRole(int n) {
        this.logger.log(10000, "CommandSetNadMode#responseSetNadRole(): Unexpected method call");
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

