/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app;

import de.audi.tghu.navi.app.LocationSerializer;
import de.audi.tghu.navi.app.command.NavCommand;
import org.dsi.ifc.global.NavLocation;

class LocationSerializer$1
extends NavCommand {
    private final /* synthetic */ byte[] val$stream;
    private final /* synthetic */ LocationSerializer this$0;

    LocationSerializer$1(LocationSerializer locationSerializer, String string, byte[] byArray) {
        this.this$0 = locationSerializer;
        this.val$stream = byArray;
        super(string);
    }

    @Override
    public void execute() {
        this.getDSINavigation().streamToLocation(this.val$stream);
    }

    @Override
    public void streamToLocationResult(boolean bl, NavLocation navLocation) {
        if (bl) {
            this.getCommandList().put("NavLocation", navLocation);
        }
        this.getCommandList().commandFinished();
    }
}

