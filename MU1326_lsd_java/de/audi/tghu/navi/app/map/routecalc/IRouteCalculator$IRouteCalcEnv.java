/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.routecalc;

import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.map.IContext;
import de.audi.tghu.navi.app.map.INaviInterface;
import de.audi.tghu.navi.app.map.ISatelliteMapsManager;
import de.audi.tghu.navi.app.map.MapDataContainer;
import de.audi.tghu.navi.app.map.constants.SwitchContextEnum;
import de.audi.tghu.navi.app.map.dsi.MVRequest;
import de.audi.tghu.navi.app.map.event.IEventBroker;
import de.audi.tghu.navi.app.map.gui.ViewFactory;

public interface IRouteCalculator$IRouteCalcEnv {
    default public void onEvent(int n) {
    }

    default public void onFiredRGAutoStartTimer() {
    }

    default public void switchToAShownContext() {
    }

    default public ViewFactory getViews() {
    }

    default public NavigationEnv getNavigationEnv() {
    }

    default public INaviInterface getNaviInterface() {
    }

    default public int getActiveContextIndex() {
    }

    default public IContext getActiveContext() {
    }

    default public Object getMutexSwitchToContext() {
    }

    default public void switchToContext(int n) {
    }

    default public void switchToContext(int n, SwitchContextEnum switchContextEnum) {
    }

    default public MapDataContainer getMapDataContainer() {
    }

    default public void showRouteBriefing(int n) {
    }

    default public IEventBroker getMapEventDispatcher() {
    }

    default public MVRequest getMVRequest() {
    }

    default public IPreviewMap getPreviewMapHandler() {
    }

    default public int getActiveNaviOrMapContext() {
    }

    default public int getActiveTab() {
    }

    default public int getLastSelectedRouteIndex() {
    }

    default public boolean isInNavigation() {
    }

    default public ISatelliteMapsManager getSatelliteManager() {
    }
}

