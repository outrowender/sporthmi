/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.map.context;

import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.map.AbstractMap;
import de.audi.tghu.navi.app.map.GUIInterface;
import de.audi.tghu.navi.app.map.context.CtxCrosshairEnterInMap;
import de.audi.tghu.navi.app.map.dsi.IMapRequest;
import de.audi.tghu.navi.app.util.Util;

public class CtxCrosshairEnterInMapEvo
extends CtxCrosshairEnterInMap {
    public CtxCrosshairEnterInMapEvo(NavigationEnv navigationEnv, AbstractMap abstractMap) {
        super(navigationEnv, abstractMap);
    }

    @Override
    public void enter() {
        IMapRequest iMapRequest = this.naviMap.getMVRequest();
        GUIInterface gUIInterface = this.naviMap.getGuiInterface();
        if (Util.isHMIScrollHairsEnabled(this.env.getFramework()) || Util.isLockFeatureNavMapviewScrollEnabled(this.env)) {
            iMapRequest.setMode(2);
        } else {
            iMapRequest.setMode(3);
        }
        super.enter();
        gUIInterface.setMapScrollSidebarPressed(890963456, false);
        if (Util.isHMIScrollHairsEnabled(this.env.getFramework())) {
            gUIInterface.showCrosshairs(this.hotPointX, this.hotPointY);
        }
        this.updateCrosshairsColor();
        iMapRequest.setRotation((short)0);
        iMapRequest.setViewType(0);
        this.enableDisableOrientation();
        gUIInterface.switchToNormalSidebar();
        this.setToolTipDelay(0);
        if (!Util.isLockFeatureNavMapviewScrollEnabled(this.env) || Util.isHMIScrollHairsEnabled(this.env.getFramework())) {
            gUIInterface.setTopBarVisible(true);
        }
        this.updateCrossHairsBoundingBox();
    }

    @Override
    protected int determineSetup3DCityModelMode() {
        if (!Util.isHURegionAsia()) {
            return 0;
        }
        return super.determineSetup3DCityModelMode();
    }

    @Override
    public void exit() {
        super.exit();
        this.naviMap.getGuiInterface().hideCrosshairs();
    }
}

