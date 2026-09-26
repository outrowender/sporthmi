/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.cluster;

import de.audi.tghu.navi.app.cluster.CombiBAPListener;
import de.audi.tghu.navi.app.command.NavCommand;

class CombiBAPListener$6
extends NavCommand {
    private final /* synthetic */ CombiBAPListener this$0;

    CombiBAPListener$6(CombiBAPListener combiBAPListener, String string) {
        this.this$0 = combiBAPListener;
        super(string);
    }

    @Override
    public void execute() {
        this.this$0.routeGuidanceActDeactResult(0);
        this.getCommandList().commandFinished();
    }
}

