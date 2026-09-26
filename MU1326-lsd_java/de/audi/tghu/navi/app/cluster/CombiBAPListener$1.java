/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.cluster;

import de.audi.tghu.navi.app.cluster.CombiBAPListener;
import de.audi.tghu.navi.app.command.NavCommand;

class CombiBAPListener$1
extends NavCommand {
    private final /* synthetic */ CombiBAPListener this$0;

    CombiBAPListener$1(CombiBAPListener combiBAPListener, String string) {
        this.this$0 = combiBAPListener;
        super(string);
    }

    @Override
    public void execute() {
        if (!this.navigation.getHomeAddressHandler().isHomeAddressAvailable()) {
            this.this$0.routeGuidanceActDeactResult(8);
        } else {
            this.this$0.waitingForStartGuidanceResponse = true;
        }
        this.navigation.getHomeAddressHandler().onHomeButtonPressed(0);
        this.env.getChoiceModel(4179).setValue(this.env.getChoiceModel(4179).getValue() + 1);
        this.getCommandList().commandFinished();
    }
}

