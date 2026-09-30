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
import de.audi.tghu.navi.app.map.constants.SwitchContextEnum;
import de.audi.tghu.navi.app.map.gui.GUIKombiFPK;
import de.audi.tghu.navi.app.map.handler.selection.MapSelectionHandlerFactory;
import de.audi.tghu.navi.app.map.instances.MapKombi;

public class MapKombiFPK
extends MapKombi {
    public MapKombiFPK(NavigationEnv navigationEnv, MapManager mapManager, MapConfig mapConfig, IconHandler iconHandler, MapInterface mapInterface, INaviInterface iNaviInterface, LocationSerializer locationSerializer, MapSelectionHandlerFactory mapSelectionHandlerFactory) {
        super(navigationEnv, mapManager, mapConfig, iconHandler, mapInterface, iNaviInterface, locationSerializer, mapSelectionHandlerFactory);
        this.initialize();
    }

    protected void initialize() {
        this.setGUIInterface(new GUIKombiFPK(this.env, this));
    }

    public String getName() {
        return "MapKombiFPK";
    }

    public void mapInitialized() {
        super.mapInitialized();
    }

    public void viewSizeChanged(int n) {
        this.getMapLogChannel().log(10000000, "MapKombiFPK#viewSizeChanged() - newViewSize: %1 ", (long)n);
        this.getActiveCtx().viewSizeChanged(n);
    }

    protected void forceSwitchToContext(int n, SwitchContextEnum switchContextEnum) {
        super.forceSwitchToContext(n, switchContextEnum);
    }
}

