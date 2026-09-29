/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.command;

import de.audi.tghu.navi.app.map.command.MapCommand;
import org.dsi.ifc.global.NavLocationWgs84;

public class MapIsDetailedMapMaterialAvailable
extends MapCommand {
    protected final NavLocationWgs84 position;
    protected boolean detailedMapMaterialAvailable;

    public MapIsDetailedMapMaterialAvailable(NavLocationWgs84 navLocationWgs84) {
        this.position = navLocationWgs84;
    }

    @Override
    public void execute() {
        this.getMap().getMVRequest().isDetailedMapMaterialAvailable(this.position);
    }

    @Override
    public void isDetailedMapMaterialAvailable(NavLocationWgs84 navLocationWgs84, boolean bl) {
        this.detailedMapMaterialAvailable = bl;
        this.getCommandList().commandFinished();
    }

    public boolean isDetailedMapMaterialAvailable() {
        return this.detailedMapMaterialAvailable;
    }
}

