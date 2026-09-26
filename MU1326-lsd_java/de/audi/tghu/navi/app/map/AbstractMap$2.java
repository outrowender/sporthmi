/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map;

import de.audi.tghu.navi.app.map.AbstractMap;
import de.audi.tghu.navi.app.map.GUIInterface;
import de.audi.tghu.navi.app.map.INaviInterface;
import de.audi.tghu.navi.app.map.handler.IRouteInfo$IRouteInfoHandlerEnv;

class AbstractMap$2
implements IRouteInfo$IRouteInfoHandlerEnv {
    private final /* synthetic */ AbstractMap this$0;

    AbstractMap$2(AbstractMap abstractMap) {
        this.this$0 = abstractMap;
    }

    @Override
    public void updateDestDistance(int n) {
        this.this$0.getActiveContext().updateDestDistance(n);
    }

    @Override
    public boolean showETAandDistanceToNextStopover() {
        return this.this$0.showETAandDistanceToNextStopover();
    }

    @Override
    public boolean isInMap() {
        return this.this$0.getMapDataContainer().isInMap;
    }

    @Override
    public boolean isRouteInfoEnabled() {
        return this.this$0.getSetup().isRouteInfoEnabled();
    }

    @Override
    public boolean supportsAdditionalInfo() {
        return this.this$0.getActiveContext().supportsAdditionalInfo();
    }

    @Override
    public boolean isRouteInfoAllowedToFadeIn() {
        return this.this$0.getRouteInfoContextHandler().isRouteInfoAllowedToFadeIn();
    }

    @Override
    public void automaticOrientateMap() {
        this.this$0.getActiveContext().automaticOrientateMap();
    }

    @Override
    public INaviInterface getNaviInterface() {
        return this.this$0.naviInterface;
    }

    @Override
    public GUIInterface getGuiInterface() {
        return this.this$0.getGuiInterface();
    }
}

