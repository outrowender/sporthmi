/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.cluster;

import de.audi.tghu.navi.app.cluster.CombiBAPListener;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.command.StreamToLocationCommand;

class CombiBAPListener$3
extends NavCommand {
    private final /* synthetic */ CombiBAPListener this$0;

    CombiBAPListener$3(CombiBAPListener combiBAPListener, String string) {
        this.this$0 = combiBAPListener;
        super(string);
    }

    @Override
    public void execute() {
        this.getCommandList().commandFinishedWithPostCommand(new StreamToLocationCommand((byte[])this.getCommandList().get("LOCATION_STREAM")));
    }
}

