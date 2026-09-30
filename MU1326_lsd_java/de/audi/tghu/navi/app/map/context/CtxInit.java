/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.context;

import de.audi.tghu.navi.app.Navigation;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.map.AbstractMap;
import de.audi.tghu.navi.app.map.Context;
import de.audi.tghu.navi.app.map.GUIInterface;
import de.audi.tghu.navi.app.map.dsi.IMapRequest;
import de.audi.tghu.navi.app.map.dsi.MVRequestControl;
import de.audi.tghu.navi.app.util.Util;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.map.Rect;

public class CtxInit
extends Context {
    private boolean mZoomListResponded = false;
    private boolean mZoomListIndexResponded = false;
    private boolean mViewVisibleResponded = false;
    private boolean mViewFreezeResponded = false;
    private boolean mMapOrientationResponded = false;

    public CtxInit(NavigationEnv navigationEnv, AbstractMap abstractMap) {
        super(navigationEnv, abstractMap);
    }

    public void enter() {
        Util.logStartupEvent(this.env.getFramework(), "CtxInit#enter() - start map initialization (set notification for MapReady)");
        Util.logStartupEvent(this.env.getFramework(), new Buffer().append("CtxInit#enter() - Traffic map enabled in setup: ").append(this.getMapRepresentation() == 2));
        MVRequestControl mVRequestControl = this.naviMap.getMainRequestCtl();
        GUIInterface gUIInterface = this.naviMap.getGuiInterface();
        int n = gUIInterface.getMapWidth();
        int n2 = gUIInterface.getMapHeight();
        this.getLogChannel().log(10000000, "CtxInit#enter() - Set max resolution %1x%2", (long)n, (long)n2);
        mVRequestControl.viewSetScreenViewportMaximum(new Rect(0, 0, n, n2));
        mVRequestControl.setNotification(new int[]{1}, (DSIListener)mVRequestControl.getMVResponseControl());
        if (!this.container.sInitalization) {
            this.getLogChannel().log(1000, "CtxInit#enter() - ERROR - THIS MAP INSTANCE WAS ALREADY INITIATED BEFORE!");
        }
    }

    private void registerInitialAttributeUpdates() {
        this.naviMap.getMainRequestCtl().setNotification(new int[]{7, 8, 10, 11, 14}, (DSIListener)this.naviMap.getMainRequestCtl().getMVResponseControl());
    }

    public void updateReady(boolean bl, int n) {
        if (n != this.naviMap.getMapConfig().getMapInstanceId()) {
            return;
        }
        if (n == 0) {
            this.naviMap.getNaviInterface().mapReady(bl);
        }
        this.getLogChannel().log(10000000, "CtxInit#updateReady( %1 )", bl);
        Util.logStartupEvent(this.env.getFramework(), new Buffer().append("[Startup] CtxInit#updateReady( ").append(bl).append(" )"));
        if (bl) {
            this.naviMap.getMainRequestCtl().setMetricSystem(Util.getCurrentMetricsSystem(true));
            this.naviMap.getNaviInterface().setOperationTaskCompleted(5);
            this.registerInitialAttributeUpdates();
            this.naviMap.getMVRequest().getMVRequestManeuverView().disableManeuverViewGeneration(Util.isClusterKDKAvailable(this.env.getFramework()));
        }
    }

    private void registerForMapAttributeUpdates() {
        this.naviMap.getMainRequestCtl().setNotification(new int[]{3, 4, 52, 6, 43, 9, 12, 13, 15, 16, 18, 21, 22, 23, 24, 25, 26, 27, 28, 30, 31, 44, 34, 45, 36, 38, 37, 39}, (DSIListener)this.naviMap.getMainRequestCtl().getMVResponseControl());
        this.naviMap.getMVRequest().getMVRequestZoomEngine().setNotification(new int[]{1, 2, 4, 3}, (DSIListener)this.naviMap.getMVResponseZoomEngine());
        if (Util.useDSIUpdateBapManeuverInformation()) {
            this.naviMap.getMVRequest().getMVRequestManeuverView().setNotification(new int[]{2, 1}, (DSIListener)this.naviMap.getMVResponseManeuverView());
        } else {
            this.naviMap.getMVRequest().getMVRequestManeuverView().setNotification(new int[]{2, 3, 1}, (DSIListener)this.naviMap.getMVResponseManeuverView());
        }
    }

    public void updateMapOrientation(int n) {
        super.updateMapOrientation(n);
        this.mMapOrientationResponded = true;
        this.checkFinished();
    }

    public void updateZoomList(float[] fArray, int n, float[] fArray2) {
        super.updateZoomList(fArray, n, fArray2);
        if (fArray == null) {
            this.getLogChannel().log(1000, "CtxInit#updateZoomList(): zoomList = null (map will not work properly)");
        }
        this.mZoomListResponded = true;
        this.checkFinished();
    }

    public void updateZoomListIndex(int n) {
        super.updateZoomListIndex(n);
        this.mZoomListIndexResponded = true;
        this.checkFinished();
    }

    public void updateViewVisible(boolean bl) {
        super.updateViewVisible(bl);
        this.setRequestedVisibility(bl);
        this.mViewVisibleResponded = true;
        this.checkFinished();
    }

    public void updateViewFreeze(boolean bl) {
        super.updateViewFreeze(bl);
        this.setRequestedFreeze(bl);
        this.switchDisplayContext(0);
        this.mViewFreezeResponded = true;
        this.checkFinished();
    }

    private void checkFinished() {
        this.getLogChannel().log(10000000, new Buffer().append("CtxInit#checkFinished() - ").append(this.mZoomListResponded).append(" ").append(this.mViewVisibleResponded).append(" ").append(this.mViewFreezeResponded).append(" ").append(this.mMapOrientationResponded).append(" ").append(this.mZoomListIndexResponded).append(" ").toString());
        if (this.mZoomListResponded && this.mViewVisibleResponded && this.mViewFreezeResponded && this.mMapOrientationResponded && this.mZoomListIndexResponded) {
            this.getLogChannel().log(10000000, "CtxInit#checkFinished()");
            this.registerForMapAttributeUpdates();
            this.naviMap.getMainRequestCtl().setOperable(true);
            IMapRequest iMapRequest = this.naviMap.getMVRequest();
            iMapRequest.setEnableSoftRotation(false);
            iMapRequest.setEnableSoftZoomConditional(false);
            iMapRequest.setEnableSoftZoom(false);
            iMapRequest.setEnableSoftJump(false);
            iMapRequest.setEnableSoftTilt(false);
            iMapRequest.setScrollByCrossHairs(Util.isScrollByCrossHairsEnabled(this.env.getFramework()));
            this.naviMap.getMapInterface().refreshMetricSystem();
            if (!this.env.getFramework().isFrontMU()) {
                iMapRequest.setEnableRouteCalcMode(Navigation.isRouteCalcMode());
            }
            iMapRequest.setRouteColoringPolicy(1);
            Rect rect = this.naviMap.getGuiInterface().getMapSize();
            iMapRequest.viewSetScreenViewport(rect);
            this.naviMap.switchToContext(2);
        }
    }

    public void exitMapScreen() {
        this.getLogChannel().log(10000000, "CtxInit#exitMapScreen(): ignoring");
    }
}

