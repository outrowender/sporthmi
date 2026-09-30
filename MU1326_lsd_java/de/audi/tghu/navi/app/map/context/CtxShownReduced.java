/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.context;

import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.map.AbstractMap;
import de.audi.tghu.navi.app.map.Context;
import de.audi.tghu.navi.app.map.IVisibleContext;
import de.audi.tghu.navi.app.map.utils.MapUtils;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.map.Point;
import org.dsi.ifc.map.PosInfo;

public abstract class CtxShownReduced
extends Context
implements IVisibleContext {
    CtxShownReduced(NavigationEnv navigationEnv, AbstractMap abstractMap) {
        super(navigationEnv, abstractMap);
    }

    public void enterPrologue() {
        this.freezeMap();
        int n = this.getCID();
        int n2 = this.getMap().getLastVisibleCID();
        if (MapUtils.isPreviewMapContext(n) != MapUtils.isPreviewMapContext(n2)) {
            this.getLogChannel().log(1000000, "CtxShownReduced#enterPrologue() - last visible CID = %1, active CID = %2, restore is required.", (long)n2, (long)n);
            this.restore();
        }
    }

    public void enterEpilogue() {
        this.showMap(false);
        this.unfreezeMap();
    }

    public void enterNavSetup() {
        this.getLogChannel().log(10000000, "CtxShownReduced#enterNavSetup()");
    }

    public void exitNavSetup() {
        this.getLogChannel().log(10000000, "CtxShownReduced#exitNavSetup()");
    }

    public void enterMapScreen(int n) {
        this.getLogChannel().log(10000000, "CtxShownReduced#enterMapScreen( %1 )", (long)n);
    }

    public void exitMapScreen() {
        this.getLogChannel().log(10000000, "CtxShownReduced#exitMapScreen()");
    }

    public void enter() {
    }

    protected void restore() {
        this.getLogChannel().log(100000000, "CtxShownReduced#restore()");
        this.getMap().backupMapState();
    }

    protected void setHotPoint(int n, int n2) {
        this.getLogChannel().log(10000000, "CtxShownReduced#setHotPoint( x = %1, y = %2 )", (long)n, (long)n2);
        this.naviMap.getMVRequest().setHotPoint(new Point(n, n2));
    }

    public void showToolTip(String string, int n, int n2, PosInfo posInfo, String string2, boolean bl, boolean bl2, ResourceLocator resourceLocator) {
        this.getLogChannel().log(10000000, "CtxShownReduced#showToolTip( )");
    }

    public void showLandmark(float f2) {
        this.getLogChannel().log(10000000, "CtxShownReduced#showLandmark( )");
    }

    public void setNightDesign(int n) {
        super.setNightDesign(n);
        this.switchMapAccordingToNightDesign();
    }
}

