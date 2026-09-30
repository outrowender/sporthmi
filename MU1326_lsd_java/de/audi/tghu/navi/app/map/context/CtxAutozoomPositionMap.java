/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.context;

import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.map.AbstractMap;
import de.audi.tghu.navi.app.map.context.CtxManoeuvrezoomPositionMap;

public class CtxAutozoomPositionMap
extends CtxManoeuvrezoomPositionMap {
    public CtxAutozoomPositionMap(NavigationEnv navigationEnv, AbstractMap abstractMap) {
        super(navigationEnv, abstractMap);
    }

    public void enter() {
        super.enter();
        if (this.setZoomIndexAZ(this.getZoomHandler().getRecommendedZoom())) {
            this.setAutoZoomIcon(true);
            this.setSoftZoom(true);
        }
    }

    public void enterEpilogue() {
        this.showMap(true);
        this.unfreezeMap();
    }

    protected boolean setPendingZoomLevel() {
        this.getLogChannel().log(100000000, "CtxAutozoomPositionMap#setPendingZoomLevel()");
        boolean bl = super.setPendingZoomLevel();
        boolean bl2 = this.setZoomIndexAZ(this.getZoomHandler().getRecommendedZoom());
        return bl || bl2;
    }

    private boolean setZoomIndexAZ(float f2) {
        if (this.getZoomEngineState() == 3) {
            this.getLogChannel().log(100000000, "CtxAutozoomPositionMap#setZoomIndexAZ() - handled by CtxManoeuvrezoomPositionMap, ignored");
            return false;
        }
        if (this.getSetupAutoZoom() != 0 || this.getZoomEngineState() != 2) {
            this.getLogChannel().log(10000000, "CtxAutozoomPositionMap#setZoomIndexAZ() - failed: setting=%1, zoomEngineState=%2", (long)this.getSetupAutoZoom(), (long)this.getZoomEngineState());
            return false;
        }
        if (this.isAutozoomTemporarilyDisabled()) {
            this.getLogChannel().log(10000000, "CtxAutozoomPositionMap#setZoomIndexAZ() - failed: temporarily disabled");
            return false;
        }
        this.container.sForceRestoreUserZoomLevel = false;
        this.getLogChannel().log(10000000, "CtxAutozoomPositionMap#setZoomIndexAZ( %1cm )", (double)f2);
        this.getZoomHandler().setZoomLevel(f2 / 100.0f);
        return true;
    }

    public void updateRecommendedZoom(float f2) {
        super.updateRecommendedZoom(f2);
        if (this.setZoomIndexAZ(f2)) {
            this.setAutoZoomIcon(true);
            this.setSoftZoom(true);
        }
    }
}

