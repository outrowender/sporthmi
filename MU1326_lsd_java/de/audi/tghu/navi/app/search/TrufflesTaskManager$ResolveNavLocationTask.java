/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.search;

import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.metrics.Distance;
import de.audi.atip.search.util.SearchResultListRow;
import de.audi.tghu.navi.app.search.IntelliDestDistanceRow;
import de.audi.tghu.navi.app.search.TrufflesTaskManager;
import de.audi.tghu.navi.app.search.TrufflesTaskManager$1;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.PosPosition;

class TrufflesTaskManager$ResolveNavLocationTask
implements Runnable {
    private final EvoListRow row;
    private final /* synthetic */ TrufflesTaskManager this$0;

    private TrufflesTaskManager$ResolveNavLocationTask(TrufflesTaskManager trufflesTaskManager, EvoListRow evoListRow) {
        this.this$0 = trufflesTaskManager;
        this.row = evoListRow;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void run() {
        NavLocation navLocation;
        if (TrufflesTaskManager.access$200(this.this$0).isDebug2()) {
            TrufflesTaskManager.access$200(this.this$0).log(14808325, "ResolveNavLocationTask#run %1", (Object)this.row);
        }
        if (null == (navLocation = TrufflesTaskManager.access$300(this.this$0).extractNavLocationFromRow(this.row)) || !navLocation.isPositionValid()) {
            return;
        }
        PosPosition posPosition = TrufflesTaskManager.access$400(this.this$0).getPosition();
        int n = ((SearchResultListRow)this.row).getSearchResult().listPosition;
        IntelliDestDistanceRow intelliDestDistanceRow = (IntelliDestDistanceRow)((Object)this.row);
        intelliDestDistanceRow.setLatitude(navLocation.latitude);
        intelliDestDistanceRow.setLongitude(navLocation.longitude);
        intelliDestDistanceRow.setHasGeoCoordinates(true);
        int n2 = Util.computeAbsoluteDirection(posPosition, intelliDestDistanceRow.getLongitude(), intelliDestDistanceRow.getLatitude());
        int n3 = Util.convertRotatingDirection(n2, posPosition.directionAngle);
        intelliDestDistanceRow.setArrowColumn(n3);
        int n4 = Util.computeAirDistance(posPosition.getLongitude(), posPosition.getLatitude(), intelliDestDistanceRow.getLongitude(), intelliDestDistanceRow.getLatitude());
        intelliDestDistanceRow.setDistanceColumn(new Distance(n4, 5));
        intelliDestDistanceRow.setLayoutWithDirection();
        Object object = TrufflesTaskManager.access$500(this.this$0);
        synchronized (object) {
            EvoListRow evoListRow = TrufflesTaskManager.access$600(this.this$0).getRow(n);
            if (evoListRow != null && evoListRow.equals(this.row)) {
                TrufflesTaskManager.access$600(this.this$0).setRow(n, this.row);
            }
        }
    }

    /* synthetic */ TrufflesTaskManager$ResolveNavLocationTask(TrufflesTaskManager trufflesTaskManager, EvoListRow evoListRow, TrufflesTaskManager$1 trufflesTaskManager$1) {
        this(trufflesTaskManager, evoListRow);
    }
}

