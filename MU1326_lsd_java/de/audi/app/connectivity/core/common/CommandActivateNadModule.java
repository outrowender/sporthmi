/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.connectivity.core.common;

import de.audi.app.connectivity.core.IApplication;
import de.audi.app.connectivity.core.common.PhoneProxy;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.atip.phone.ITelServiceConnectivityListener;
import de.audi.tghu.command.Command;
import de.audi.tghu.command.CommandList;

public final class CommandActivateNadModule
extends Command
implements ITelServiceConnectivityListener {
    private final ChoiceModelApp mediator;
    private final PhoneProxy phone;
    static /* synthetic */ Class class$de$audi$app$connectivity$core$common$CommandActivateNadModule;

    public static void schedule(IApplication iApplication, LogChannel logChannel, PhoneProxy phoneProxy) {
        ChoiceModelApp choiceModelApp = iApplication.getFramework().getHmiServiceApp().getChoiceModel(0x262696);
        choiceModelApp.setStatus(0);
        CommandList commandList = new CommandList(iApplication.getCommandListManager());
        CommandActivateNadModule commandActivateNadModule = new CommandActivateNadModule(logChannel, (class$de$audi$app$connectivity$core$common$CommandActivateNadModule == null ? (class$de$audi$app$connectivity$core$common$CommandActivateNadModule = CommandActivateNadModule.class$("de.audi.app.connectivity.core.common.CommandActivateNadModule")) : class$de$audi$app$connectivity$core$common$CommandActivateNadModule).getName(), choiceModelApp, phoneProxy);
        commandList.add(commandActivateNadModule);
        commandList.execute(commandActivateNadModule.getName());
    }

    private CommandActivateNadModule(LogChannel logChannel, String string, ChoiceModelApp choiceModelApp, PhoneProxy phoneProxy) {
        super(logChannel, string);
        this.mediator = choiceModelApp;
        this.phone = phoneProxy;
    }

    public void execute() {
        this.phone.activateNadModule(this);
    }

    public void responseChangePhoneModulePowerState(int n) {
        this.logger.log(1000000, "CommandActivateNadModule#responseChangePhoneModulePowerState(): result=%1", (long)n);
        this.mediator.setStatus(1);
        this.commandList.commandFinished();
    }

    public void responseSetNadMode(int n) {
        this.logger.log(10000, "CommandActivateNadModule#responseSetNadMode(): Unexpected method call");
    }

    public void responseTogglePhones(int n) {
        this.logger.log(10000, "CommandActivateNadModule#responseTogglePhones(): Unexpected method call");
    }

    public void responseSetNadRole(int n) {
        this.logger.log(10000, "CommandActivateNadModule#responseSetNadRole(): Unexpected method call");
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

