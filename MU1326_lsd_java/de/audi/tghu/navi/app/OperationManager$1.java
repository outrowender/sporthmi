/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app;

import de.audi.tghu.navi.app.OperationManager;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.util.Util;

class OperationManager$1
extends NavCommand {
    private final /* synthetic */ OperationManager this$0;

    OperationManager$1(OperationManager operationManager, String string) {
        this.this$0 = operationManager;
        super(string);
    }

    @Override
    public void execute() {
        OperationManager.access$100(this.this$0).log(-2137614336, "SignalRecovered#execute() - recovery finished!");
        Util.logStartupEvent(this.env.getFramework(), "SignalRecovered#execute() - recovery finished!");
        OperationManager.access$202(this.this$0, false);
        this.this$0.setNavigationMainInitialized(true);
        this.getCommandList().commandFinished();
    }
}

