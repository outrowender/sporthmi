/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.context;

import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.map.AbstractMap;
import de.audi.tghu.navi.app.map.context.CtxOverviewMap;

public class CtxRseRoute
extends CtxOverviewMap {
    public CtxRseRoute(NavigationEnv navigationEnv, AbstractMap abstractMap) {
        super(navigationEnv, abstractMap);
    }

    @Override
    protected int getSetupAutoZoom() {
        return 2;
    }

    @Override
    protected int getMixedListOffset() {
        return 0;
    }

    @Override
    public void initAdditionalInfos() {
        this.shutdownAdditionalInfos();
        this.setVisibleArea();
    }

    @Override
    public void updateZoomEngineState(int n) {
    }

    @Override
    public void updateRecommendedZoom(float f2) {
    }

    @Override
    public void itemSelected(int n, int n2, int n3, int n4) {
        switch (n) {
            case 400447: {
                if (n2 == 1) {
                    this.getLogChannel().log(-2137614336, "CtxRseRoute#itemSelected() - jumping directly to RSE route calc followup");
                    this.naviMap.getGuiInterface().openOrCloseSidebar(0);
                    this.naviMap.getMapInterface().setOptMenuType(1, false, false, false);
                    this.naviMap.getGuiInterface().fireModelEvent(1763444224);
                    break;
                }
            }
            default: {
                super.itemSelected(n, n2, n3, n4);
            }
        }
    }

    @Override
    public void joystick(int n, int n2) {
        if (n2 >= 0) {
            this.naviMap.getGuiInterface().openOrCloseSidebar(1);
            super.joystick(n, n2);
        }
    }

    @Override
    public boolean supportsAdditionalInfo() {
        return false;
    }
}

