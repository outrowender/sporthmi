/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app;

import de.audi.tghu.navi.app.HomeAddressHandler;
import de.audi.tghu.navi.app.command.NavCommand;

class HomeAddressHandler$5
extends NavCommand {
    private final /* synthetic */ HomeAddressHandler this$0;

    HomeAddressHandler$5(HomeAddressHandler homeAddressHandler, String string) {
        this.this$0 = homeAddressHandler;
        super(string);
    }

    @Override
    public void execute() {
        this.this$0.mapInterface.getPreviewMap().setPreviewAreaAroundCCP(12);
        this.getCommandList().commandFinished();
    }
}

