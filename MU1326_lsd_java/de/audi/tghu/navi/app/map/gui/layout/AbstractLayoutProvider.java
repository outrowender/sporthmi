/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.gui.layout;

import de.audi.atip.hmi.model.BaseListRow;
import de.audi.atip.hmi.model.IntegerListCell;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.map.MapConsts;
import org.dsi.ifc.map.Point;
import org.dsi.ifc.map.Rect;

public abstract class AbstractLayoutProvider
implements MapConsts {
    protected final NavigationEnv env;

    protected AbstractLayoutProvider(NavigationEnv navigationEnv) {
        this.env = navigationEnv;
    }

    protected int get(int n) {
        int n2 = 0;
        BaseListRow baseListRow = this.getListRow();
        if (baseListRow == null || baseListRow.getColumnCount() < n) {
            return n2;
        }
        IntegerListCell integerListCell = (IntegerListCell)baseListRow.getCell(n);
        n2 = integerListCell == null ? 0 : integerListCell.getValue();
        return n2;
    }

    protected abstract BaseListRow getListRow() {
    }

    public int getScreenWidth() {
        return this.get(0);
    }

    public int getScreenHeight() {
        return this.get(1);
    }

    public Rect getWeatherOverlayTimestampBoundingBox() {
        return new Rect(24, 24, 95, 32);
    }

    protected int getDistanceInfolineBottom() {
        return this.get(8);
    }

    protected int getDistanceLeftDrawerIcon() {
        return this.get(17);
    }

    protected int getDistanceMaptooltipBottom() {
        return this.get(19);
    }

    protected int getDistanceMaptooltipLeft() {
        return this.get(7);
    }

    protected int getDistanceMaptooltipUp() {
        return this.get(6);
    }

    protected int getDistanceReiterlineTop() {
        return this.get(9);
    }

    protected int getDistanceRoutecriteriaboxLeft() {
        return this.get(10);
    }

    protected int getDistanceRoutecriteriaboxTop() {
        return this.get(16);
    }

    protected int getDistanceRouteInfoLeft() {
        return this.get(5);
    }

    protected int getDistanceSidebarArRight() {
        return this.get(4);
    }

    protected int getDistanceRubberbandInfoBarTop() {
        return this.get(28);
    }

    protected int getDistanceSidebarBottom() {
        return this.get(15);
    }

    protected int getDistanceSidebarRight() {
        return this.get(3);
    }

    protected int getDistanceStatusbarBottom() {
        return this.get(2);
    }

    protected int getDistanceTubeLeft() {
        return this.get(11);
    }

    protected int getDistanceTubeLeftKb() {
        return this.get(13);
    }

    protected int getDistanceTubeRight() {
        return this.get(12);
    }

    protected int getDistanceTubeRightKb() {
        return this.get(14);
    }

    public int getMapHeight() {
        int n = this.get(26);
        if (n <= 0) {
            n = this.getScreenHeight();
        }
        return n;
    }

    public int getMapWidth() {
        int n = this.get(27);
        if (n <= 0) {
            n = this.getScreenWidth();
        }
        return n;
    }

    public int getMapOffsetLeft() {
        return this.get(24);
    }

    public int getMapOffsetTop() {
        return this.get(25);
    }

    public Point calculateCarPosition(int n) {
        return new Point();
    }

    public abstract Rect getVisibleArea(int n, boolean bl, boolean bl2) {
    }

    public abstract Rect getVisibleArea(int n, boolean bl, boolean bl2, boolean bl3) {
    }
}

