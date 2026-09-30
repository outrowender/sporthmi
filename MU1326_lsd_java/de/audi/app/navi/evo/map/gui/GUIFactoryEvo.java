/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.map.gui;

import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.map.AbstractMap;
import de.audi.tghu.navi.app.map.GUIInterface;
import de.audi.tghu.navi.app.map.IGUIFactory;
import de.audi.tghu.navi.app.map.MapManager;
import de.audi.tghu.navi.app.map.gui.GUIEventDispatcher;
import de.audi.tghu.navi.app.map.gui.GUIMain;
import de.audi.tghu.navi.app.map.gui.MapPartialPopupEvoHandler;

public class GUIFactoryEvo
implements IGUIFactory {
    public GUIEventDispatcher createGUIEventDispatcher(NavigationEnv navigationEnv, MapManager mapManager) {
        return new GUIEventDispatcher(navigationEnv, mapManager);
    }

    public GUIInterface createGUIMain(NavigationEnv navigationEnv, AbstractMap abstractMap) {
        return new GUIMain(navigationEnv, abstractMap, new MapPartialPopupEvoHandler(navigationEnv));
    }
}

