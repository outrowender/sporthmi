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
import org.dsi.ifc.map.MapFlag;
import org.dsi.ifc.map.Rect;

public class CtxKombiInit
extends Context {
    private boolean mZoomListResponded = false;
    private boolean mViewVisibleResponded = false;
    private boolean mViewFreezeResponded = false;
    private boolean mMapOrientationResponded = false;
    private boolean mZoomListIndexResponded = false;

    public CtxKombiInit(NavigationEnv navigationEnv, AbstractMap abstractMap) {
        super(navigationEnv, abstractMap);
    }

    @Override
    public void enter() {
        Util.logStartupEvent(this.env.getFramework(), "CtxKombiInit#enter() - start map initialization (set notification for MapReady)");
        Util.logStartupEvent(this.env.getFramework(), new Buffer().append("CtxKombiInit#enter() - Traffic map enabled in setup: ").append(this.getMapRepresentation() == 2));
        MVRequestControl mVRequestControl = this.naviMap.getMainRequestCtl();
        GUIInterface gUIInterface = this.naviMap.getGuiInterface();
        int n = gUIInterface.getMapWidth();
        int n2 = gUIInterface.getMapHeight();
        this.getLogChannel().log(-2137614336, "CtxKombiInit#enter() - set max resolution %1x%2", (long)n, (long)n2);
        mVRequestControl.viewSetScreenViewportMaximum(new Rect(0, 0, n, n2));
        mVRequestControl.setNotification(new int[]{1}, (DSIListener)mVRequestControl.getMVResponseControl());
        if (!this.container.sInitalization) {
            this.getLogChannel().log(1000, "CtxInit#enter() - ERROR - THIS MAP INSTANCE WAS ALREADY INITIATED BEFORE!");
        }
    }

    @Override
    public void updateReady(boolean bl, int n) {
        if (n != this.naviMap.getMainRequestCtl().getID()) {
            return;
        }
        this.getLogChannel().log(-2137614336, "CtxKombiInit#updateReady( %1 )", bl);
        Util.logStartupEvent(this.env.getFramework(), new Buffer().append("[Startup] CtxKombiInit#updateReady( ").append(bl).append(" )"));
        if (bl) {
            this.naviMap.getMainRequestCtl().setMetricSystem(Util.getCurrentMetricsSystem(true));
            this.registerInitialAttributesUpdates();
        }
    }

    private void registerInitialAttributesUpdates() {
        this.naviMap.getMainRequestCtl().setNotification(new int[]{7, 8, 10, 11, 14}, (DSIListener)this.naviMap.getMainRequestCtl().getMVResponseControl());
    }

    private void registerMapAttributeUpdates() {
        this.naviMap.getMainRequestCtl().setNotification(new int[]{3, 4, 52, 6, 9, 13, 12, 15, 16, 18, 21, 22, 23, 24, 25, 26, 27, 28, 30, 31, 45, 36, 38, 37, 39}, (DSIListener)this.naviMap.getMainRequestCtl().getMVResponseControl());
        if (this.naviMap.getMapConfig().hasZoomEngine()) {
            this.naviMap.getMVRequest().getMVRequestZoomEngine().setNotification(new int[]{1, 2, 4, 3}, (DSIListener)this.naviMap.getMVResponseZoomEngine());
        }
    }

    @Override
    public void updateMapOrientation(int n) {
        super.updateMapOrientation(n);
        this.mMapOrientationResponded = true;
        this.checkFinished();
    }

    @Override
    public void updateZoomList(float[] fArray, int n, float[] fArray2) {
        if (fArray == null) {
            this.getLogChannel().log(1000, "CtxKombiInit#updateZoomList(): zoomList = null (map will not work properly)");
        }
        this.mZoomListResponded = true;
        this.checkFinished();
    }

    @Override
    public void updateViewVisible(boolean bl) {
        super.updateViewVisible(bl);
        this.setRequestedVisibility(bl);
        this.mViewVisibleResponded = true;
        this.checkFinished();
    }

    @Override
    public void updateViewFreeze(boolean bl) {
        super.updateViewFreeze(bl);
        this.setRequestedFreeze(bl);
        this.mViewFreezeResponded = true;
        this.checkFinished();
    }

    private void checkFinished() {
        this.getLogChannel().log(-2137614336, new Buffer().append("CtxKombiInit#checkFinished() - ").append(this.mZoomListResponded).append(" ").append(this.mViewVisibleResponded).append(" ").append(this.mViewFreezeResponded).append(" ").append(this.mMapOrientationResponded).append(" ").append(this.mZoomListIndexResponded).append(" ").toString());
        if (this.mZoomListResponded && this.mViewVisibleResponded && this.mViewFreezeResponded && this.mMapOrientationResponded && this.mZoomListIndexResponded) {
            this.getLogChannel().log(-2137614336, "CtxKombiInit#checkFinished()");
            this.registerMapAttributeUpdates();
            this.naviMap.getMainRequestCtl().setOperable(true);
            MapFlag[] mapFlagArray = new MapFlag[]{new MapFlag()};
            IMapRequest iMapRequest = this.naviMap.getMVRequest();
            iMapRequest.setEnableSoftRotation(false);
            iMapRequest.setEnableSoftZoomConditional(false);
            iMapRequest.setEnableSoftZoom(false);
            iMapRequest.setEnableSoftJump(false);
            iMapRequest.setEnableSoftTilt(false);
            iMapRequest.setScrollByCrossHairs(Util.isScrollByCrossHairsEnabled(this.env.getFramework()));
            if (!this.env.getFramework().isFrontMU()) {
                iMapRequest.setEnableRouteCalcMode(Navigation.isRouteCalcMode());
            }
            iMapRequest.setRouteColoringPolicy(1);
            Rect rect = this.naviMap.getGuiInterface().getMapSize();
            iMapRequest.viewSetScreenViewport(rect);
            this.naviMap.switchToContext(2);
        }
    }

    @Override
    public void updateZoomListIndex(int n) {
        super.updateZoomListIndex(n);
        this.mZoomListIndexResponded = true;
        this.checkFinished();
    }
}

