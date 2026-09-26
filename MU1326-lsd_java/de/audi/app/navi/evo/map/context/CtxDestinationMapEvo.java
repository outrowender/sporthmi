/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.map.context;

import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.map.AbstractMap;
import de.audi.tghu.navi.app.map.GUIInterface;
import de.audi.tghu.navi.app.map.context.CtxDestinationMap;
import de.audi.tghu.navi.app.map.dsi.IMapRequest;

public class CtxDestinationMapEvo
extends CtxDestinationMap {
    public CtxDestinationMapEvo(NavigationEnv navigationEnv, AbstractMap abstractMap) {
        super(navigationEnv, abstractMap);
    }

    @Override
    public void enter() {
        super.enter();
        GUIInterface gUIInterface = this.naviMap.getGuiInterface();
        gUIInterface.switchToNormalSidebar();
        IMapRequest iMapRequest = this.naviMap.getMVRequest();
        iMapRequest.setViewType(0);
        iMapRequest.setMode(9);
        gUIInterface.enableOrientation(false);
        iMapRequest.setRotation((short)0);
        this.initAdditionalInfos();
        AbstractMap abstractMap = this.naviMap;
        if (abstractMap.getOldActiveContextIndex() != 12) {
            this.getZoomHandler().setZoomLevel(this.getDefaultZoomLevel());
        }
        int n = this.getSetupAutoZoom();
        if (!(this.container.sManoeuvreZoomDisabledWithReturn || this.getZoomEngineState() != 3 || n != 1 && n != 0)) {
            abstractMap.setSwitchBackToContext(11);
            abstractMap.switchToContext(8);
        }
    }
}

