/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.operatorcall.data;

import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.interapp.NaviService;
import de.audi.atip.log.LogChannel;
import de.audi.atip.metrics.Distance;
import de.audi.tghu.online.app.Online;
import de.audi.tghu.online.app.operatorcall.data.AbstractHistoryCallData;
import de.audi.tghu.online.app.operatorcall.handler.NavigationHandler;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.online.OperatorCallResult;

public class PoiResultListRow
extends EvoListRow {
    public static final int MODE_RELATIVE_AIR_DISTANCE = 1;
    public static final int MODE_REAL_ROAD_DISTANCE = 2;
    protected static final int COLUMN_ID = 0;
    protected static final int COLUMN_POI_NAME = 1;
    protected static final int COLUMN_DIRECTION_ARROW = 2;
    protected static final int COLUMN_DISTANCE = 3;
    protected static long idCounter = 1L;
    protected final LogChannel logChannel = Online.getInstance().getOperatorCallLogChannel();
    protected OperatorCallResult result = null;
    protected NavigationHandler naviHandler;
    protected AbstractHistoryCallData historyCallData;

    public PoiResultListRow(OperatorCallResult operatorCallResult, NavigationHandler navigationHandler, AbstractHistoryCallData abstractHistoryCallData) {
        super(idCounter, 5);
        this.naviHandler = navigationHandler;
        ++idCounter;
        this.result = operatorCallResult;
        this.historyCallData = abstractHistoryCallData;
        this.computeDistanceAndUpdateData(1);
    }

    public void createPropertyListCell() {
    }

    public PoiResultListRow(PoiResultListRow poiResultListRow) {
        super(poiResultListRow);
        this.naviHandler = poiResultListRow.naviHandler;
        this.result = poiResultListRow.result;
        this.historyCallData = poiResultListRow.historyCallData;
    }

    public void computeDistanceAndUpdateData(int n) {
        int n2;
        int n3;
        NavLocationWgs84 navLocationWgs84 = this.result.getLocation();
        int n4 = navLocationWgs84.getLatitude();
        int n5 = navLocationWgs84.getLongitude();
        NaviService naviService = this.naviHandler.getNaviService();
        if (naviService == null) {
            this.logChannel.log(100000, "PoiResultListRow#computeNaviStuffAndUpdate: naviService is null. Cannot update Information in the list.");
            return;
        }
        switch (n) {
            case 2: {
                n3 = naviService.computeRelativeAirDistance(n5, n4);
                n2 = naviService.computeRelativeDirection(n5, n4);
                break;
            }
            default: {
                n3 = naviService.computeRelativeAirDistance(n5, n4);
                n2 = naviService.computeRelativeDirection(n5, n4);
            }
        }
        this.logChannel.log(10000000, "PoiResultListRow#computeNaviStuffAndUpdate: distance = %1", (long)n3);
        this.logChannel.log(10000000, "PoiResultListRow#computeNaviStuffAndUpdate: directionArrow = %1", (long)n2);
        this.updateInformation(n3, n2);
    }

    protected void updateInformation(int n, int n2) {
        this.setLong(0, this.getUniqueID());
        this.setText(1, this.result.getName());
        this.setInteger(2, n2);
        this.setMetrics(3, new Distance(n, 5));
        this.createPropertyListCell();
    }

    public int getCategory() {
        return -1;
    }

    protected String getDistanceAsString(int n) {
        Buffer buffer = new Buffer();
        if (n < 1000) {
            buffer.append(n);
            buffer.append(" m");
        } else {
            buffer.append(n / 1000);
            buffer.append(",");
            buffer.append(n % 1000 / 100);
            buffer.append(" km");
        }
        return buffer.toString();
    }

    public int getDirectionArrow() {
        return this.getInteger(2);
    }

    public String getDistance() {
        return this.getMetrics(3).toString();
    }

    public EvoListRow copy() {
        this.logChannel.log(10000000, "PoiResultListRow#copy: called!");
        return new PoiResultListRow(this);
    }

    public String getName() {
        return this.result.getName();
    }

    public NavLocationWgs84 getLocation() {
        return this.result.getLocation();
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("\nName = ");
        buffer.append(this.getName());
        buffer.append("\nLatitude = ");
        buffer.append(this.getLocation().getLatitude());
        buffer.append("\nLongitude = ");
        buffer.append(this.getLocation().getLongitude());
        buffer.append("\nArrow = ");
        buffer.append(this.getDirectionArrow());
        buffer.append("\n");
        buffer.append(this.getDistance());
        buffer.append("\nCategory = ");
        int n = this.getCategory();
        buffer.append(n);
        buffer.append("\n");
        return buffer.toString();
    }

    public int getHistoryCallIndex() {
        return this.historyCallData.getCallIndexForGUI();
    }

    public OperatorCallResult getOperatorCallResult() {
        return this.result;
    }
}

