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

    protected int getSetupAutoZoom() {
        return 2;
    }

    protected int getMixedListOffset() {
        return 0;
    }

    public void initAdditionalInfos() {
        this.shutdownAdditionalInfos();
        this.setVisibleArea();
    }

    public void updateZoomEngineState(int n) {
    }

    public void updateRecommendedZoom(float f2) {
    }

    public void itemSelected(int n, int n2, int n3, int n4) {
        switch (n) {
            case 400447: {
                if (n2 == 1) {
                    this.getLogChannel().log(10000000, "CtxRseRoute#itemSelected() - jumping directly to RSE route calc followup");
                    this.naviMap.getGuiInterface().openOrCloseSidebar(0);
                    this.naviMap.getMapInterface().setOptMenuType(1, false, false, false);
                    this.naviMap.getGuiInterface().fireModelEvent(400489);
                    break;
                }
            }
            default: {
                super.itemSelected(n, n2, n3, n4);
            }
        }
    }

    public void joystick(int n, int n2) {
        if (n2 >= 0) {
            this.naviMap.getGuiInterface().openOrCloseSidebar(1);
            super.joystick(n, n2);
        }
    }

    public boolean supportsAdditionalInfo() {
        return false;
    }
}

