/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.cluster;

import de.audi.tghu.navi.app.cluster.CombiBAPListener;
import de.audi.tghu.navi.app.command.NavCommand;
import org.dsi.ifc.global.NavLocation;

class CombiBAPListener$4
extends NavCommand {
    private final /* synthetic */ CombiBAPListener this$0;

    CombiBAPListener$4(CombiBAPListener combiBAPListener, String string) {
        this.this$0 = combiBAPListener;
        super(string);
    }

    @Override
    public void execute() {
        this.this$0.waitingForStartGuidanceResponse = true;
        this.getCommandList().commandFinishedWithPostSequence(this.navigation.getStartGuidanceDependantSequence().getStartSequence((NavLocation)this.getCommandList().get("STREAMED_LOCATION")));
        this.env.getChoiceModel(4146).setValue(this.env.getChoiceModel(4146).getValue() + 1);
        this.getCommandList().commandFinished();
    }
}

