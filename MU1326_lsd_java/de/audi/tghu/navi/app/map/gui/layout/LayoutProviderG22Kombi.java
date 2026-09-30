/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.gui.layout;

import de.audi.atip.hmi.model.BaseListRow;
import de.audi.atip.hmi.modelaccess.ListModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.map.gui.layout.AbstractLayoutProvider;
import org.dsi.ifc.map.Rect;

public class LayoutProviderG22Kombi
extends AbstractLayoutProvider {
    private LogChannel logger;
    private BaseListRow mScreenLayout;
    private int kombiType = 3;

    public LayoutProviderG22Kombi(NavigationEnv navigationEnv, int n) {
        super(navigationEnv);
        ListModelApp listModelApp = navigationEnv.getListModel(176);
        this.mScreenLayout = listModelApp != null && listModelApp.getLength() > 1 ? listModelApp.getRow(1) : null;
        this.kombiType = n;
        this.logger = navigationEnv.getLogChannel("App.Map.GUI.Kombi");
    }

    private LogChannel getLogger() {
        return this.logger;
    }

    protected BaseListRow getListRow() {
        return this.mScreenLayout;
    }

    public Rect getVisibleArea(int n, boolean bl, boolean bl2, boolean bl3) {
        Rect rect = new Rect();
        int n2 = this.getScreenWidth();
        int n3 = this.getScreenHeight();
        int n4 = bl3 ? this.getDistanceTubeLeftKb() : this.getDistanceTubeLeft();
        int n5 = bl3 ? this.getDistanceTubeRightKb() : this.getDistanceTubeRight();
        int n6 = this.getDistanceInfolineBottom();
        int n7 = this.getDistanceReiterlineTop();
        rect.kordX = n4 - this.getMapOffsetLeft();
        rect.kordY = n7 - this.getMapOffsetTop();
        rect.diffX = n2 - n4 - n5;
        rect.diffY = n3 - n7 - n6;
        if (this.env.getFramework().isPorscheHigh()) {
            rect.diffX = 408;
            rect.diffY = 448;
        } else if (this.env.getFramework().isBentley()) {
            rect.diffX = 800;
            rect.diffY = 298;
        }
        this.getLogger().log(10000000, "LayoutProviderG22Kombi#getVisibleArea() - contextId = %2 -> %1", (Object)rect, (long)n);
        return rect;
    }

    public Rect getVisibleArea(int n, boolean bl, boolean bl2) {
        return this.getVisibleArea(n, bl, bl2, true);
    }
}

