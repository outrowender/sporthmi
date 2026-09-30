/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.memory;

import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.tghu.navi.app.memory.RouteListData;

public class TourPlanEvoListRow
extends EvoListRow {
    public static final int COLUMN_LAYOUT = 0;
    public static final int COLUMN_NAME = 1;
    public static final int COLUMN_SHORTCUT = 2;
    public static final int COLUMN_CHECKBOX = 3;
    public static final int COLUMN_COUNT = 4;
    public static final int LAYOUT_TOUR = 0;
    public static final int LAYOUT_TRAILS = 1;
    private static long UID = 0L;
    private final RouteListData route;

    TourPlanEvoListRow(RouteListData routeListData) {
        super(UID++, 4);
        this.route = routeListData;
        if (routeListData.segmentId == null) {
            this.setInteger(0, 0);
        } else {
            this.setInteger(0, 1);
        }
        this.setText(1, routeListData.name);
        this.setInteger(3, 0);
    }

    public RouteListData getRoute() {
        return this.route;
    }

    public TourPlanEvoListRow(TourPlanEvoListRow tourPlanEvoListRow) {
        super(tourPlanEvoListRow);
        this.route = tourPlanEvoListRow.route;
    }

    public EvoListRow copy() {
        return new TourPlanEvoListRow(this);
    }

    public boolean isChecked() {
        return this.getInteger(3) == 1;
    }

    public void check() {
        this.setInteger(3, 1);
    }

    public void uncheck() {
        this.setInteger(3, 0);
    }

    public boolean toggleCheckbox() {
        int n = 1 - this.getInteger(3);
        this.setInteger(3, n);
        return n == 1;
    }
}

