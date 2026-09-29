/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.call;

import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;
import de.audi.tghu.navi.app.call.CommandListCallManager;

class CommandListCallManager$1
implements TimerListener {
    private final /* synthetic */ CommandListCallManager this$0;

    CommandListCallManager$1(CommandListCallManager commandListCallManager) {
        this.this$0 = commandListCallManager;
    }

    @Override
    public void fireTimer(Timer timer) {
        this.this$0.getLogChannel().log(-2137614336, "CommandListCallManager#executionTimerListener#fireTimer");
        if (CommandListCallManager.access$000(this.this$0) != null) {
            CommandListCallManager.access$000(this.this$0).setManager(null);
            this.this$0.removeCall(CommandListCallManager.access$000(this.this$0));
        }
    }

    @Override
    public void cancelTimer(Timer timer) {
        this.this$0.getLogChannel().log(-2137614336, "CommandListCallManager#executionTimerListener#cancelTimer");
    }
}

