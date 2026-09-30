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

public final class CommandSetNadRole
extends Command
implements ITelServiceConnectivityListener {
    private PhoneProxy phone;
    private int role;
    static /* synthetic */ Class class$de$audi$app$connectivity$core$common$CommandSetNadRole;

    public static void schedule(CommandListManager commandListManager, LogChannel logChannel, PhoneProxy phoneProxy, int n) {
        CommandList commandList = new CommandList(commandListManager);
        CommandSetNadRole commandSetNadRole = new CommandSetNadRole(logChannel, (class$de$audi$app$connectivity$core$common$CommandSetNadRole == null ? (class$de$audi$app$connectivity$core$common$CommandSetNadRole = CommandSetNadRole.class$("de.audi.app.connectivity.core.common.CommandSetNadRole")) : class$de$audi$app$connectivity$core$common$CommandSetNadRole).getName(), phoneProxy, n);
        commandList.add(commandSetNadRole);
        commandList.execute(commandSetNadRole.getName());
    }

    private CommandSetNadRole(LogChannel logChannel, String string, PhoneProxy phoneProxy, int n) {
        super(logChannel, string);
        this.phone = phoneProxy;
        this.role = n;
    }

    public void execute() {
        this.phone.setNadRole(this, this.role);
    }

    public void responseSetNadRole(int n) {
        this.commandList.commandFinished();
    }

    public void responseSetNadMode(int n) {
        this.logger.log(10000, "CommandSetNadRole#responseSetNadMode(): Unexpected method call");
    }

    public void responseChangePhoneModulePowerState(int n) {
        this.logger.log(10000, "CommandSetNadRole#responseChangePhoneModulePowerState(): Unexpected method call");
    }

    public void responseTogglePhones(int n) {
        this.logger.log(10000, "CommandSetNadRole#responseTogglePhones(): Unexpected method call");
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

