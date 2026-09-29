/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.rml;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.rml.RMLSequence;
import de.audi.tghu.navi.app.rml.UpdateCombinedRouteListCommand;

class RMLSequence$4
extends NavCommand {
    private final /* synthetic */ int val$requestId;
    private final /* synthetic */ RMLSequence this$0;

    RMLSequence$4(RMLSequence rMLSequence, int n) {
        this.this$0 = rMLSequence;
        this.val$requestId = n;
    }

    @Override
    public void execute() {
        long l = (Long)this.getCommandList().get(RMLSequence.OPENEDANCHOR);
        this.getCommandList().commandFinishedWithPostCommand(new UpdateCombinedRouteListCommand(this.this$0.modelAccess, this.val$requestId, l, RMLSequence.access$200(this.this$0).getRoute()));
    }
}

