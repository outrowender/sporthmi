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

    @Override
    public void enterPrologue() {
        this.freezeMap();
        int n = this.getCID();
        int n2 = this.getMap().getLastVisibleCID();
        if (MapUtils.isPreviewMapContext(n) != MapUtils.isPreviewMapContext(n2)) {
            this.getLogChannel().log(1078071040, "CtxShownReduced#enterPrologue() - last visible CID = %1, active CID = %2, restore is required.", (long)n2, (long)n);
            this.restore();
        }
    }

    @Override
    public void enterEpilogue() {
        this.showMap(false);
        this.unfreezeMap();
    }

    @Override
    public void enterNavSetup() {
        this.getLogChannel().log(-2137614336, "CtxShownReduced#enterNavSetup()");
    }

    @Override
    public void exitNavSetup() {
        this.getLogChannel().log(-2137614336, "CtxShownReduced#exitNavSetup()");
    }

    @Override
    public void enterMapScreen(int n) {
        this.getLogChannel().log(-2137614336, "CtxShownReduced#enterMapScreen( %1 )", (long)n);
    }

    @Override
    public void exitMapScreen() {
        this.getLogChannel().log(-2137614336, "CtxShownReduced#exitMapScreen()");
    }

    @Override
    public void enter() {
    }

    protected void restore() {
        this.getLogChannel().log(14808325, "CtxShownReduced#restore()");
        this.getMap().backupMapState();
    }

    protected void setHotPoint(int n, int n2) {
        this.getLogChannel().log(-2137614336, "CtxShownReduced#setHotPoint( x = %1, y = %2 )", (long)n, (long)n2);
        this.naviMap.getMVRequest().setHotPoint(new Point(n, n2));
    }

    public void showToolTip(String string, int n, int n2, PosInfo posInfo, String string2, boolean bl, boolean bl2, ResourceLocator resourceLocator) {
        this.getLogChannel().log(-2137614336, "CtxShownReduced#showToolTip( )");
    }

    @Override
    public void showLandmark(float f2) {
        this.getLogChannel().log(-2137614336, "CtxShownReduced#showLandmark( )");
    }

    @Override
    public void setNightDesign(int n) {
        super.setNightDesign(n);
        this.switchMapAccordingToNightDesign();
    }
}

