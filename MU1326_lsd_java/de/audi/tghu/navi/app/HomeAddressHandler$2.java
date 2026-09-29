/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app;

import de.audi.tghu.navi.app.HomeAddressHandler;
import de.audi.tghu.navi.app.command.NavCommand;
import org.dsi.ifc.global.NavLocation;

class HomeAddressHandler$2
extends NavCommand {
    private final /* synthetic */ HomeAddressHandler this$0;

    HomeAddressHandler$2(HomeAddressHandler homeAddressHandler, String string) {
        this.this$0 = homeAddressHandler;
        super(string);
    }

    @Override
    public void execute() {
        NavLocation navLocation = (NavLocation)this.getCommandList().get("STREAMED_LOCATION");
        if (navLocation != null && navLocation.isPositionValid()) {
            this.this$0.currentHomeAddress = navLocation;
            this.this$0.updateHomeAddressAvailable();
        }
        HomeAddressHandler.access$102(this.this$0, true);
        this.getCommandList().commandFinished();
    }
}

