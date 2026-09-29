/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.map;

import de.audi.app.navi.evo.map.gui.GUIFactoryEvo;
import de.audi.tghu.navi.app.IconHandler;
import de.audi.tghu.navi.app.LocationSerializer;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.map.IMapFactory;
import de.audi.tghu.navi.app.map.INaviInterface;
import de.audi.tghu.navi.app.map.MapConfig;
import de.audi.tghu.navi.app.map.MapInterface;
import de.audi.tghu.navi.app.map.MapManager;
import de.audi.tghu.navi.app.map.handler.selection.MapSelectionHandlerFactory;
import de.audi.tghu.navi.app.map.instances.MapMain;

public class MapFactoryEvo
implements IMapFactory {
    @Override
    public MapMain createMapMain(NavigationEnv navigationEnv, MapManager mapManager, MapConfig mapConfig, IconHandler iconHandler, MapInterface mapInterface, INaviInterface iNaviInterface, LocationSerializer locationSerializer, MapSelectionHandlerFactory mapSelectionHandlerFactory) {
        return new MapMain(navigationEnv, mapManager, mapConfig, iconHandler, mapInterface, iNaviInterface, new GUIFactoryEvo(), locationSerializer, mapSelectionHandlerFactory);
    }
}

