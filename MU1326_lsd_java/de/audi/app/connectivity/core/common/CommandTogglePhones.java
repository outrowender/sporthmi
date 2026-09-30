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

public final class CommandTogglePhones
extends Command
implements ITelServiceConnectivityListener {
    private PhoneProxy phone;
    static /* synthetic */ Class class$de$audi$app$connectivity$core$common$CommandTogglePhones;

    public static void schedule(CommandListManager commandListManager, LogChannel logChannel, PhoneProxy phoneProxy) {
        CommandList commandList = new CommandList(commandListManager);
        CommandTogglePhones commandTogglePhones = new CommandTogglePhones(logChannel, (class$de$audi$app$connectivity$core$common$CommandTogglePhones == null ? (class$de$audi$app$connectivity$core$common$CommandTogglePhones = CommandTogglePhones.class$("de.audi.app.connectivity.core.common.CommandTogglePhones")) : class$de$audi$app$connectivity$core$common$CommandTogglePhones).getName(), phoneProxy);
        commandList.add(commandTogglePhones);
        commandList.execute(commandTogglePhones.getName());
    }

    private CommandTogglePhones(LogChannel logChannel, String string, PhoneProxy phoneProxy) {
        super(logChannel, string);
        this.phone = phoneProxy;
    }

    public void execute() {
        this.phone.togglePhones(this);
    }

    public void responseTogglePhones(int n) {
        this.logger.log(1000000, "CommandTogglePhones#responseTogglePhones(): result=%1", (long)n);
        this.commandList.commandFinished();
    }

    public void responseSetNadMode(int n) {
        this.logger.log(10000, "CommandTogglePhones#responseSetNadMode(): Unexpected method call");
    }

    public void responseChangePhoneModulePowerState(int n) {
        this.logger.log(10000, "CommandTogglePhones#responseChangePhoneModulePowerState(): Unexpected method call");
    }

    public void responseSetNadRole(int n) {
        this.logger.log(10000, "CommandTogglePhones#responseSetNadRole(): Unexpected method call");
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

