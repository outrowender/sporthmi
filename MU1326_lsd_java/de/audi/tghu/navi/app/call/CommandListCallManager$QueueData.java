/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.call;

import de.audi.tghu.navi.app.call.CommandListCallManager;
import de.audi.tghu.navi.app.call.INavCall;

class CommandListCallManager$QueueData {
    final INavCall call;
    final String invocationSource;
    private final /* synthetic */ CommandListCallManager this$0;

    CommandListCallManager$QueueData(CommandListCallManager commandListCallManager, INavCall iNavCall, String string) {
        this.this$0 = commandListCallManager;
        this.call = iNavCall;
        this.invocationSource = string;
    }
}

