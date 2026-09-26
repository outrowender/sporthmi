/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.hierarchiclist.via;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.hierarchiclist.via.ViaModelListener;

class ViaModelListener$1
extends NavCommand {
    private final /* synthetic */ ViaModelListener this$0;

    ViaModelListener$1(ViaModelListener viaModelListener, String string) {
        this.this$0 = viaModelListener;
        super(string);
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "StartViaPointsQuery#execute()");
        ViaModelListener.access$000(this.this$0);
        this.getCommandList().commandFinished();
    }
}

