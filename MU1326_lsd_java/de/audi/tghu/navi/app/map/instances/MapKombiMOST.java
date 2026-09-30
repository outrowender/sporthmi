/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.instances;

import de.audi.tghu.navi.app.IconHandler;
import de.audi.tghu.navi.app.LocationSerializer;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.map.INaviInterface;
import de.audi.tghu.navi.app.map.MapConfig;
import de.audi.tghu.navi.app.map.MapInterface;
import de.audi.tghu.navi.app.map.MapManager;
import de.audi.tghu.navi.app.map.gui.GUIKombiMOST;
import de.audi.tghu.navi.app.map.handler.selection.MapSelectionHandlerFactory;
import de.audi.tghu.navi.app.map.instances.MapKombi;

public class MapKombiMOST
extends MapKombi {
    public MapKombiMOST(NavigationEnv navigationEnv, MapManager mapManager, MapConfig mapConfig, IconHandler iconHandler, MapInterface mapInterface, INaviInterface iNaviInterface, LocationSerializer locationSerializer, MapSelectionHandlerFactory mapSelectionHandlerFactory) {
        super(navigationEnv, mapManager, mapConfig, iconHandler, mapInterface, iNaviInterface, locationSerializer, mapSelectionHandlerFactory);
        this.setGUIInterface(new GUIKombiMOST(navigationEnv, this));
    }

    public String getName() {
        return "MapKombiMOST";
    }
}

