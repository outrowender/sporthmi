/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app;

import de.audi.tghu.navi.app.PicNavNaviInterfaceImpl;
import de.audi.tghu.navi.app.command.NavCommand;

class PicNavNaviInterfaceImpl$2
extends NavCommand {
    private final /* synthetic */ PicNavNaviInterfaceImpl this$0;

    PicNavNaviInterfaceImpl$2(PicNavNaviInterfaceImpl picNavNaviInterfaceImpl, String string) {
        this.this$0 = picNavNaviInterfaceImpl;
        super(string);
    }

    @Override
    public void execute() {
        PicNavNaviInterfaceImpl.access$000(this.this$0).mapUnfrozen();
        this.getCommandList().commandFinished();
    }
}

