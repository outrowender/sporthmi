/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.context;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.map.AbstractMap;
import de.audi.tghu.navi.app.map.IsViewSizeDepended;
import de.audi.tghu.navi.app.map.context.CtxManoeuvrezoomPositionMap$ZoomDisableTimer;
import de.audi.tghu.navi.app.map.context.CtxPositionMap;
import de.audi.tghu.navi.app.util.Util;

public class CtxManoeuvrezoomPositionMap
extends CtxPositionMap
implements IsViewSizeDepended {
    public CtxManoeuvrezoomPositionMap(NavigationEnv navigationEnv, AbstractMap abstractMap) {
        super(navigationEnv, abstractMap);
        if (this.container.sZoomDisableTimer == null) {
            this.container.sZoomDisableTimer = new CtxManoeuvrezoomPositionMap$ZoomDisableTimer(this);
        }
    }

    @Override
    public synchronized void cleanup() {
        super.cleanup();
        CtxManoeuvrezoomPositionMap$ZoomDisableTimer.access$500(this.getZoomDisableTimer());
    }

    private CtxManoeuvrezoomPositionMap$ZoomDisableTimer getZoomDisableTimer() {
        return (CtxManoeuvrezoomPositionMap$ZoomDisableTimer)this.container.sZoomDisableTimer;
    }

    @Override
    public void enter() {
        super.enter();
        this.getLogChannel().log(14808325, "CtxManoeuvrezoomPositionMap#enter()");
        if (this.isManoeuvreZoomRunning() && !this.isManoeverzoomTemporarilyDiabled() && !this.container.sForceRestoreUserZoomLevel) {
            this.getLogChannel().log(14808325, "CtxManoeuvrezoomPositionMap#enter(), activateManoeuvreZoom()");
            this.activateManoeuvreZoom();
        } else {
            this.getLogChannel().log(14808325, "CtxManoeuvrezoomPositionMap#enter(), restoreState()");
            this.saveOrientation();
            this.restoreState();
            this.switchBackToPreviousMapIfNecessary();
        }
    }

    @Override
    public void enterEpilogue() {
        if (this.naviMap.getActiveContextIndex() != 7) {
            this.showMap(true);
            this.unfreezeMap();
        }
    }

    @Override
    public void exit() {
        super.exit();
        int n = this.naviMap.getActiveContextIndex();
        if (n == 12 || n == 11 || n == 10) {
            if (n == 11) {
                this.restoreOrientation();
                this.getLogChannel().log(14808325, "CtxManoeuvrezoomPositionMap#exit(), restoreOrientation()");
            }
            this.getLogChannel().log(-2137614336, "CtxManoeuvrezoomPositionMap#exit(), do-nothing()");
        } else {
            this.getLogChannel().log(14808325, "CtxManoeuvrezoomPositionMap#exit(), restoreState()");
            if (!Util.isHURegionAsia()) {
                this.restoreState();
            }
            this.initOrientationAndHotPoint();
        }
        CtxManoeuvrezoomPositionMap$ZoomDisableTimer.access$500(this.getZoomDisableTimer());
        if (n != 7 && n != 8) {
            this.setSoftZoom(false);
            if (n != 10) {
                this.setAutoZoomIcon(false);
            }
        }
    }

    @Override
    protected void sdsChangedZoom() {
        super.sdsChangedZoom();
        CtxManoeuvrezoomPositionMap$ZoomDisableTimer.access$600(this.getZoomDisableTimer());
        this.setAutoZoomIcon(false);
    }

    @Override
    public void sdsChangedMapType() {
        this.getLogChannel().log(1078071040, "CtxManoeuvrezoomPositionMap#sdsChangedMapType");
        if (this.isManoeverzoomTemporarilyDiabled() || this.getZoomEngineState() != 3) {
            super.sdsChangedMapType();
        }
    }

    @Override
    public void onChangedOrientation(int n) {
        super.onChangedOrientation(n);
        this.saveOrientation();
    }

    @Override
    public void activateOrientationAccordingToSetup() {
        if (this.isManoeverzoomTemporarilyDiabled() || this.getZoomEngineState() != 3) {
            super.activateOrientationAccordingToSetup();
        }
    }

    @Override
    public void increment(int n, int n2) {
        this.doIncrement(n, n2);
        if (n == 1545340416) {
            CtxManoeuvrezoomPositionMap$ZoomDisableTimer.access$600(this.getZoomDisableTimer());
            this.setAutoZoomIcon(false);
        }
    }

    protected void doIncrement(int n, int n2) {
        super.increment(n, n2);
    }

    @Override
    public void incrementGesture(int n) {
        this.doIncrementGesture(n);
        this.getLogChannel().log(-2137614336, "CtxManoeuvrezoomPositionMap#incrementGesture() - restart auto zoom disable timer");
        CtxManoeuvrezoomPositionMap$ZoomDisableTimer.access$600(this.getZoomDisableTimer());
        this.setAutoZoomIcon(false);
    }

    protected void doIncrementGesture(int n) {
        super.incrementGesture(n);
    }

    @Override
    public void keyPressed(int n, int n2) {
        super.keyPressed(n, n2);
        if (n == 1545340416 && (n2 == 31 || n2 == 32)) {
            this.getLogChannel().log(-2137614336, "CtxManoeuvrezoomPositionMap#keyPressed( %1, %2 ) - restart DisableTimer", (long)n, (long)n2);
            CtxManoeuvrezoomPositionMap$ZoomDisableTimer.access$600(this.getZoomDisableTimer());
        }
    }

    protected boolean setPendingZoomLevel() {
        this.getLogChannel().log(14808325, "CtxManoeuvrezoomPositionMap#setPendingZoomLevel()");
        if (Util.isHURegionAsia()) {
            this.getLogChannel().log(-2137614336, "CtxManoeuvrezoomPositionMap#setPendingZoomLevel() - ignoring pending zoom level");
            return false;
        }
        return this.setZoomLevelMZ(this.getZoomHandler().getRecommendedZoom());
    }

    protected boolean setZoomLevelMZ(float f2) {
        float f3 = this.container.fUserZoomLevel * 51266;
        if (this.getSetupAutoZoom() == 0) {
            this.getLogChannel().log(14808325, "CtxManoeuvrezoomPositionMap#setZoomIndexMZ(): autozoom is active");
            f3 = -32897;
        }
        int n = this.getSetupMapType();
        if (f3 < 0.0f || n == 3 || n == 0) {
            this.getLogChannel().log(14808325, "CtxManoeuvrezoomPositionMap#setZoomIndexMZ(): came from map type: %1", (long)n);
            f3 = -32897;
        }
        if (f2 < 0.0f || this.getZoomHandler().getRecommendedZoom() < 0.0f) {
            this.getLogChannel().log(-2137614336, "CtxManoeuvrezoomPositionMap#setZoomIndexMZ(): ignoring (user/auto zoom (%1 cm), recommended zoom (%2 cm))", (Object)Float.toString(f3), (Object)Float.toString(f2));
            return false;
        }
        if (this.getZoomEngineState() != 3) {
            this.getLogChannel().log(14808325, "CtxManoeuvrezoomPositionMap#setZoomIndexMZ() - failed: zoomEngineState=%1", (long)this.getZoomEngineState());
            return false;
        }
        if (this.isAutozoomTemporarilyDisabled() || this.isManoeverzoomTemporarilyDiabled()) {
            this.getLogChannel().log(-2137614336, "CtxManoeuvrezoomPositionMap#setZoomIndexMZ() - failed: disabled, isAutozoomTemporarilyDisabled: %1, sManoeuvreZoomDisabledWithReturn: %2 ", this.isAutozoomTemporarilyDisabled(), this.isManoeverzoomTemporarilyDiabled());
            return false;
        }
        if (f2 >= f3) {
            this.getLogChannel().log(-2137614336, "CtxManoeuvrezoomPositionMap#setZoomIndexMZ(): adjusting recommended zoom to user/auto zoom - (%2 cm) --> (%1 cm))", (Object)Float.toString(f3), (Object)Float.toString(f2));
            f2 = f3;
        }
        this.container.sForceRestoreUserZoomLevel = false;
        this.getLogChannel().log(-2137614336, "CtxManoeuvrezoomPositionMap#setZoomIndexMZ( %1cm )", (double)f2);
        this.getZoomHandler().setZoomLevel(f2 / 51266);
        return true;
    }

    protected boolean isManoeverzoomTemporarilyDiabled() {
        return this.container.sManoeuvreZoomDisabledWithReturn;
    }

    @Override
    public void updateZoomEngineState(int n) {
        super.updateZoomEngineState(n);
        this.getLogChannel().log(1078071040, "CtxManoeuvrezoomPositionMap#updateZoomEngineState(): zoom engine state = %1", (long)n);
        switch (n) {
            case 3: {
                this.container.sManoeuvreZoomDisabledWithReturn = false;
                if (this.isAutozoomTemporarilyDisabled()) {
                    this.container.sZoomTimerActivateMZ = true;
                    this.container.sZoomTimerDeactivateMZ = false;
                    break;
                }
                this.activateManoeuvreZoom();
                break;
            }
            default: {
                if (this.isAutozoomTemporarilyDisabled()) {
                    this.container.sZoomTimerActivateMZ = false;
                    this.container.sZoomTimerDeactivateMZ = true;
                    break;
                }
                this.getLogChannel().log(14808325, "CtxManoeuvrezoomPositionMap#updateZoomEngineState");
                if (this.switchBackToPreviousMapIfNecessary()) break;
                if (n != 2 || this.getSetupAutoZoom() != 0) {
                    this.setAutoZoomIcon(false);
                    this.setSoftZoom(false);
                }
                if (n == 0 || n == 1) {
                    this.restoreState(true);
                    break;
                }
                if (n != 2) break;
                if ((int)((double)this.getZoomHandler().getRecommendedZoom() + 0.5) > 0) {
                    this.restoreState(false);
                    break;
                }
                this.getLogChannel().log(14808325, "CtxManoeuvrezoomPositionMap#updateZoomEngineState() - Only restoring orientation.");
                this.restoreOrientation();
            }
        }
    }

    @Override
    public void updateRecommendedZoom(float f2) {
        super.updateRecommendedZoom(f2);
        if (this.setZoomLevelMZ(f2)) {
            this.setAutoZoomIcon(true);
            this.setSoftZoom(true);
        }
    }

    @Override
    public void automaticOrientateMap() {
        if (this.isManoeverzoomTemporarilyDiabled() || this.getZoomEngineState() != 3 || Util.isHURegionAsia()) {
            super.automaticOrientateMap();
        } else {
            boolean bl = this.calculateHardOrientation();
            this.centerHotPointAndOrientateMap(bl);
        }
    }

    protected void saveOrientation() {
        this.container.sSavedOrientationWhileManoeuvre = this.getSetupOrientation();
        this.getLogChannel().log(1078071040, "CtxManoeuvrezoomPositionMap#saveOrientation(): saving orientation = %1", (long)this.container.sSavedOrientationWhileManoeuvre);
    }

    protected void restoreZoomLevel(boolean bl) {
        int n = 32959;
        if (this.getSetupAutoZoom() == 0 && !Util.isHURegionAsia() && this.getRGActive() && this.getMap().getZoomEngineState() != 0 && this.getMap().getZoomEngineState() != 1) {
            n = (int)this.getZoomHandler().getRecommendedZoom();
            this.getLogChannel().log(-2137614336, "CtxManoeuvrezoomPositionMap#restoreZoomLevel(): recommendedZoom = %1 cm", (double)n);
        }
        if (Util.isHURegionAsia() && this.getSetupAutoZoom() == 1 && !bl) {
            if (this.isManoeuvreZoomRunning() && !this.isManoeverzoomTemporarilyDiabled() && !this.container.sForceRestoreUserZoomLevel) {
                n = (int)this.getZoomHandler().getRecommendedZoom();
                this.getLogChannel().log(-2137614336, "CtxManoeuvrezoomPositionMap#restoreZoomLevel(): getRecommendedZoom = %1 cm", (double)n);
            } else {
                long l = this.getZoomHandler().getSetZoomLevelTime();
                long l2 = this.getZoomHandler().getUpdateZoomListIndexTime();
                if (l2 > l) {
                    n = (int)(this.container.fUserZoomLevel * 51266);
                    this.getLogChannel().log(-2137614336, "CtxManoeuvrezoomPositionMap#restoreZoomLevel(): lastUserZoomLevel = %1 cm", (double)n);
                }
            }
        }
        if (n < 0.0f) {
            n = (int)(this.container.fUserZoomLevel * 51266);
            this.getLogChannel().log(-2137614336, "CtxManoeuvrezoomPositionMap#restoreZoomLevel(): fUserZoomLevel = %1 cm", (double)n);
        }
        this.getZoomHandler().setZoomLevel(n / 51266);
    }

    private void restoreOrientation() {
        if (this.container.sSavedOrientationWhileManoeuvre >= 0) {
            this.getLogChannel().log(1078071040, "CtxManoeuvrezoomPositionMap#restoreOrientation(): restoring orientation = %1", (long)this.container.sSavedOrientationWhileManoeuvre);
            this.getSetup().setOrientation(this.container.sSavedOrientationWhileManoeuvre, false);
            this.activateOrientationAccordingToSetup();
            this.initOrientationAndHotPoint();
        }
    }

    protected void restoreState() {
        this.restoreState(false);
    }

    protected void restoreState(boolean bl) {
        if (this.naviMap.getLastVisibleCID() != 7) {
            this.restoreZoomLevel(bl);
        }
        this.container.sForceRestoreUserZoomLevel = false;
        this.restoreOrientation();
    }

    protected void activateManoeuvreZoom() {
        this.saveOrientation();
        if (this.setZoomLevelMZ(this.getZoomHandler().getRecommendedZoom())) {
            this.setSoftZoom(true);
        }
        this.setAutoZoomIcon(true);
        if (!Util.isHURegionAsia()) {
            this.naviMap.getMVRequest().setOrientation(0);
        }
    }

    protected boolean switchBackToPreviousMapIfNecessary() {
        boolean bl = false;
        int n = this.naviMap.getSetup().getMapType(true);
        this.getLogChannel().log(1078071040, "CtxManoeuvrezoomPositionMap#switchBackToPreviousMapIfNecessary - MapType = %1", (long)n);
        if (n == 1 || n == 2) {
            this.getLogChannel().log(-2137614336, "CtxManoeuvrezoomPositionMap#switchBackToPreviousMapIfNecessary: 2D/3D-Karte");
            this.getMap().setSwitchBackToContext(0);
        }
        int n2 = this.getMap().getSwitchBackToContext();
        switch (n2) {
            case 10: {
                this.getLogChannel().log(-2137614336, "CtxManoeuvrezoomPositionMap#switchBackToPreviousMapIfNecessary: SwitchbackToOverviewMap = true");
                if (!this.getRouteActiveOrRangeMapReady()) break;
                this.getLogChannel().log(-2137614336, "CtxManoeuvrezoomPositionMap#switchBackToPreviousMapIfNecessary: SwitchbackToOverviewMap = true und RG = true");
                bl = true;
                break;
            }
            case 11: {
                bl = true;
                break;
            }
            default: {
                bl = false;
            }
        }
        this.getMap().setSwitchBackToContext(0);
        if (bl) {
            this.getMap().switchToContext(n2);
        }
        return bl;
    }

    protected boolean isAutozoomTemporarilyDisabled() {
        return this.container.sAutozoomTemporarilyDisabled;
    }

    protected void setAutozoomTemporarilyDisabled(boolean bl) {
        this.getLogChannel().log(14808325, "CtxManoeuvrezoomPositionMap#setAutozoomTemporarilyDisabled(%1) - was: %2", bl, this.container.sAutozoomTemporarilyDisabled);
        this.container.sAutozoomTemporarilyDisabled = bl;
    }

    protected void setAutoZoomIcon(boolean bl) {
        int n;
        int n2 = 2;
        if (bl && ((n = this.getSetupAutoZoom()) == 0 || n == 1)) {
            n2 = 3;
        }
        this.getLogChannel().log(-2137614336, "CtxManoeuvrezoomPositionMap#setAutoZoomIcon( %1, %2 )", bl, (long)n2);
        this.naviMap.getGuiInterface().setSideBarRotaryIcon(n2);
    }

    protected void setSoftZoom(boolean bl) {
        this.getLogChannel().log(14808325, "CtxManoeuvrezoomPositionMap#setSoftZoom( %1 )", bl);
        int n = this.getSetupAutoZoom();
        this.naviMap.getMVRequest().setEnableSoftZoomConditional(bl &= n == 0 || n == 1);
    }

    protected boolean isManoeuvreZoomRunning() {
        return this.getZoomEngineState() == 3;
    }

    @Override
    protected void onHKBackClicked() {
        if (this.isManoeuvreZoomRunning() && !this.isManoeverzoomTemporarilyDiabled()) {
            this.getLogChannel().log(1078071040, "CtxManoeuvrezoomPositionMap#onHKBackClicked( ) - disable maneuver zoom");
            this.container.sManoeuvreZoomDisabledWithReturn = true;
            this.setSoftZoom(false);
            this.restoreState();
            this.setAutoZoomIcon(false);
            this.switchBackToPreviousMapIfNecessary();
        } else {
            super.onHKBackClicked();
        }
    }

    static /* synthetic */ LogChannel access$000(CtxManoeuvrezoomPositionMap ctxManoeuvrezoomPositionMap) {
        return ctxManoeuvrezoomPositionMap.getLogChannel();
    }

    static /* synthetic */ LogChannel access$100(CtxManoeuvrezoomPositionMap ctxManoeuvrezoomPositionMap) {
        return ctxManoeuvrezoomPositionMap.getLogChannel();
    }

    static /* synthetic */ LogChannel access$200(CtxManoeuvrezoomPositionMap ctxManoeuvrezoomPositionMap) {
        return ctxManoeuvrezoomPositionMap.getLogChannel();
    }

    static /* synthetic */ LogChannel access$300(CtxManoeuvrezoomPositionMap ctxManoeuvrezoomPositionMap) {
        return ctxManoeuvrezoomPositionMap.getLogChannel();
    }

    static /* synthetic */ LogChannel access$400(CtxManoeuvrezoomPositionMap ctxManoeuvrezoomPositionMap) {
        return ctxManoeuvrezoomPositionMap.getLogChannel();
    }
}

