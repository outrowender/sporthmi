/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.audi.app.terminalmode.statemachine.TMState
 */
package de.audi.app.terminalmode.smartphone.androidauto2;

import de.audi.app.terminalmode.smartphone.androidauto2.AndroidAuto2Subsystem;
import de.audi.app.terminalmode.statemachine.IRequestor;
import de.audi.app.terminalmode.statemachine.IStateChangeAction$AbstractStateChangeActionHook;
import de.audi.app.terminalmode.statemachine.TMState;
import de.audi.app.terminalmode.statemachine.commands.RequestModeChange;
import de.audi.tghu.command.CommandList;

class AndroidAuto2Subsystem$15
extends IStateChangeAction$AbstractStateChangeActionHook {
    private final /* synthetic */ AndroidAuto2Subsystem this$0;

    AndroidAuto2Subsystem$15(AndroidAuto2Subsystem androidAuto2Subsystem) {
        this.this$0 = androidAuto2Subsystem;
    }

    @Override
    public void execute(CommandList commandList, TMState tMState, IRequestor iRequestor, long l) {
        AndroidAuto2Subsystem.access$100(this.this$0).log(1078071040, "[%1.changeState] Navi: Mainunit -> Nobody", (Object)AndroidAuto2Subsystem.access$000());
        if (IRequestor.MAINUNIT == iRequestor) {
            commandList.add(new RequestModeChange(AndroidAuto2Subsystem.access$200(this.this$0), tMState, l, AndroidAuto2Subsystem.access$400(this.this$0)));
        }
    }
}

