/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.context;

import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.map.AbstractMap;
import de.audi.tghu.navi.app.map.Context;
import de.audi.tghu.navi.app.map.GUIInterface;
import de.audi.tghu.navi.app.map.dsi.MVRequestControl;
import de.audi.tghu.navi.app.util.Util;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.map.Rect;

public class CtxMinorMapInit
extends Context {
    private boolean mZoomListResponded = false;
    private boolean mViewVisibleResponded = false;
    private boolean mViewFreezeResponded = false;

    public CtxMinorMapInit(NavigationEnv navigationEnv, AbstractMap abstractMap) {
        super(navigationEnv, abstractMap);
    }

    public void enter() {
        MVRequestControl mVRequestControl = this.naviMap.getMainRequestCtl();
        GUIInterface gUIInterface = this.naviMap.getGuiInterface();
        int n = gUIInterface.getMapWidth();
        int n2 = gUIInterface.getMapHeight();
        this.getLogChannel().log(10000000, "CtxMinorMapInit#enter() - Set max resolution %1x%2", (long)n, (long)n2);
        mVRequestControl.viewSetScreenViewportMaximum(new Rect(0, 0, n, n2));
        mVRequestControl.setNotification(new int[]{1}, (DSIListener)this.naviMap.getMainRequestCtl().getMVResponseControl());
    }

    public void updateReady(boolean bl, int n) {
        this.getLogChannel().log(10000000, "CtxMinorMapInit#updateReady( %1 )", bl);
        Util.logStartupEvent(this.env.getFramework(), new Buffer().append("[Startup] CtxMinorMapInit#updateReady( ").append(bl).append(" )"));
        if (bl) {
            this.mZoomListResponded = false;
            this.mViewVisibleResponded = false;
            this.mViewFreezeResponded = false;
            MVRequestControl mVRequestControl = this.naviMap.getMainRequestCtl();
            mVRequestControl.setMetricSystem(Util.getCurrentMetricsSystem(true));
            mVRequestControl.setNotification(new int[]{3, 4, 6, 43, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 18, 21, 22, 23, 24, 25, 26, 27, 28, 30, 31, 38, 37, 39}, (DSIListener)mVRequestControl.getMVResponseControl());
        }
    }

    public void updateZoomList(float[] fArray, int n, float[] fArray2) {
        if (fArray != null) {
            if (this.getLogChannel().isDebug()) {
                this.getLogChannel().log(10000000, "CtxMinorMapInit#updateZoomList( MaxValue = %1 )", (Object)Float.toString(fArray[fArray.length - 1]));
            }
        } else {
            this.getLogChannel().log(1000, "CtxMinorMapInit#updateZoomList(): zoomList = null (map will not work properly)");
        }
        this.mZoomListResponded = true;
        this.checkFinished();
    }

    public void updateViewVisible(boolean bl) {
        this.getLogChannel().log(10000000, "CtxMinorMapInit#updateViewVisible( %1 )", bl);
        this.mViewVisibleResponded = true;
        this.checkFinished();
    }

    public void updateViewFreeze(boolean bl) {
        this.getLogChannel().log(10000000, "CtxMinorMapInit#updateViewFreeze( %1 )", bl);
        this.mViewFreezeResponded = true;
        this.checkFinished();
    }

    private void checkFinished() {
        if (this.mZoomListResponded && this.mViewVisibleResponded && this.mViewFreezeResponded) {
            this.naviMap.getMainRequestCtl().setOperable(true);
        }
    }

    public void exitMapScreen() {
        this.getLogChannel().log(10000000, "CtxMinorMapInit#exitMapScreen(): ignoring");
    }

    public void itemSelected(int n, int n2) {
        this.getLogChannel().log(10000000, "CtxMinorMapInit#itemSelected(%1, %2) - unexpected call", (long)n, (long)n2);
    }
}

