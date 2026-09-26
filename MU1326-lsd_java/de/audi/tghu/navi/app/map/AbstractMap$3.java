/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map;

import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.map.AbstractMap;
import de.audi.tghu.navi.app.map.IContext;
import de.audi.tghu.navi.app.map.INaviInterface;
import de.audi.tghu.navi.app.map.ISatelliteMapsManager;
import de.audi.tghu.navi.app.map.MapDataContainer;
import de.audi.tghu.navi.app.map.constants.SwitchContextEnum;
import de.audi.tghu.navi.app.map.dsi.MVRequest;
import de.audi.tghu.navi.app.map.event.IEventBroker;
import de.audi.tghu.navi.app.map.gui.ViewFactory;
import de.audi.tghu.navi.app.map.routecalc.IRouteCalculator$IRouteCalcEnv;

class AbstractMap$3
implements IRouteCalculator$IRouteCalcEnv {
    private final /* synthetic */ AbstractMap this$0;

    AbstractMap$3(AbstractMap abstractMap) {
        this.this$0 = abstractMap;
    }

    @Override
    public void switchToContext(int n) {
        this.this$0.switchToContext(n);
    }

    @Override
    public void switchToContext(int n, SwitchContextEnum switchContextEnum) {
        this.this$0.switchToContext(n, switchContextEnum);
    }

    @Override
    public void switchToAShownContext() {
        this.this$0.switchToAShownContext();
    }

    @Override
    public void showRouteBriefing(int n) {
        this.this$0.showRouteBriefing(n);
    }

    @Override
    public void onFiredRGAutoStartTimer() {
        this.getActiveContext().onFiredRGAutoStartTimer();
    }

    @Override
    public void onEvent(int n) {
        this.this$0.onEvent(n);
    }

    @Override
    public ViewFactory getViews() {
        return this.this$0.getViews();
    }

    @Override
    public NavigationEnv getNavigationEnv() {
        return this.this$0.getNavigationEnv();
    }

    @Override
    public INaviInterface getNaviInterface() {
        return this.this$0.getNaviInterface();
    }

    @Override
    public IEventBroker getMapEventDispatcher() {
        return this.this$0.mapMgr.getMapEventDispatcher();
    }

    @Override
    public MapDataContainer getMapDataContainer() {
        return this.this$0.mapDataContainer;
    }

    @Override
    public MVRequest getMVRequest() {
        return this.this$0.mvRequest;
    }

    @Override
    public int getActiveContextIndex() {
        return this.this$0.getActiveContextIndex();
    }

    @Override
    public IContext getActiveContext() {
        return this.this$0.getActiveContext();
    }

    @Override
    public IPreviewMap getPreviewMapHandler() {
        return this.this$0.getMapManager().getPreviewMapHandler();
    }

    @Override
    public int getActiveNaviOrMapContext() {
        return this.getMapDataContainer().activeNaviOrMapContext;
    }

    @Override
    public int getActiveTab() {
        return this.getMapDataContainer().currentNavTab;
    }

    @Override
    public int getLastSelectedRouteIndex() {
        return this.this$0.getMapManager().getRouteManager().getLastSelectedRouteIndex();
    }

    @Override
    public Object getMutexSwitchToContext() {
        return this.this$0.getMutexSwitchToContext();
    }

    @Override
    public boolean isInNavigation() {
        return this.getMapDataContainer().isInNavi;
    }

    @Override
    public ISatelliteMapsManager getSatelliteManager() {
        return this.this$0.getSatellitemapsManager();
    }
}

