/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map;

import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.map.MapManager;
import de.audi.tghu.navi.app.map.context.VirtualSetupHandler;
import de.audi.tghu.navi.app.map.handler.ISetupHandler;
import de.audi.tghu.navi.app.map.settings.MapOptionValidator;

class MapManager$1
extends VirtualSetupHandler {
    private final /* synthetic */ MapManager this$0;

    MapManager$1(MapManager mapManager, NavigationEnv navigationEnv, ISetupHandler iSetupHandler, MapOptionValidator mapOptionValidator) {
        this.this$0 = mapManager;
        super(navigationEnv, iSetupHandler, mapOptionValidator);
    }

    @Override
    public int getMapRepresentation() {
        return 0;
    }
}

