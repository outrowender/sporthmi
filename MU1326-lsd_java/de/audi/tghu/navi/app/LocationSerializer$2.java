/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app;

import de.audi.tghu.navi.app.LocationSerializer;
import de.audi.tghu.navi.app.command.NavCommand;
import org.dsi.ifc.global.NavLocation;

class LocationSerializer$2
extends NavCommand {
    private final /* synthetic */ NavLocation val$location;
    private final /* synthetic */ LocationSerializer this$0;

    LocationSerializer$2(LocationSerializer locationSerializer, String string, NavLocation navLocation) {
        this.this$0 = locationSerializer;
        this.val$location = navLocation;
        super(string);
    }

    @Override
    public void execute() {
        this.getDSINavigation().locationToStream(this.val$location);
    }

    @Override
    public void locationToStreamResult(boolean bl, byte[] byArray) {
        if (bl) {
            this.getCommandList().put("ByteStream", byArray);
        }
        this.getCommandList().commandFinished();
    }
}

