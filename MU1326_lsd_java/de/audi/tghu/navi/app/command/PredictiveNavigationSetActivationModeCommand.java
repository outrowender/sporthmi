/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.command;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.predictivenav.IPredictiveNavController;

public class PredictiveNavigationSetActivationModeCommand
extends NavCommand {
    private int operationMode;
    static /* synthetic */ Class class$de$audi$tghu$navi$app$predictivenav$IPredictiveNavController;

    public PredictiveNavigationSetActivationModeCommand(int n) {
        super("PredictiveNavigationSetActivationModeCommand");
        this.operationMode = n;
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "PredictiveNavigationSetActivationModeCommand#execute( %1 )", (long)this.operationMode);
        if (this.env.hasService(class$de$audi$tghu$navi$app$predictivenav$IPredictiveNavController == null ? (class$de$audi$tghu$navi$app$predictivenav$IPredictiveNavController = PredictiveNavigationSetActivationModeCommand.class$("de.audi.tghu.navi.app.predictivenav.IPredictiveNavController")) : class$de$audi$tghu$navi$app$predictivenav$IPredictiveNavController)) {
            ((IPredictiveNavController)this.env.getService(class$de$audi$tghu$navi$app$predictivenav$IPredictiveNavController == null ? (class$de$audi$tghu$navi$app$predictivenav$IPredictiveNavController = PredictiveNavigationSetActivationModeCommand.class$("de.audi.tghu.navi.app.predictivenav.IPredictiveNavController")) : class$de$audi$tghu$navi$app$predictivenav$IPredictiveNavController)).setActivationMode(this.operationMode);
        }
        this.getCommandList().commandFinished();
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

