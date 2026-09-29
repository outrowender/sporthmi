/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.poi.online;

import de.audi.atip.hmi.model.HMIResourceLocator;
import de.audi.atip.hmi.model.IconCell;
import de.audi.atip.hmi.model.IntegerListCell;
import de.audi.atip.hmi.model.ListCell;
import de.audi.atip.hmi.model.ListRow;
import de.audi.atip.hmi.model.MetricsListCell;
import de.audi.atip.hmi.model.ObjectListCell;
import de.audi.atip.hmi.model.PropertyListCell;
import de.audi.atip.hmi.model.TextListCell;
import de.audi.atip.log.LogChannel;
import de.audi.atip.metrics.Distance;
import de.audi.tghu.navi.app.IconHandler;
import de.audi.tghu.navi.app.guidance.IVehicle;
import de.audi.tghu.navi.app.poi.online.PoiOnlineSearchArea;
import de.audi.tghu.navi.app.slidinglist.poi.TooltipDataProvider;
import de.audi.tghu.navi.app.util.Util;
import de.esolutions.fw.util.commons.Buffer;
import java.util.Arrays;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.PosPosition;
import org.dsi.ifc.online.PoiOnlineSearchValuelistElement;

public class PoiOnlineListRow
extends ListRow
implements TooltipDataProvider {
    public static final int COLUMN_NAME;
    private static final int COLUMN_DIRECTION;
    private static final int COLUMN_FORMATTED_DISTANCE;
    private static final int COLUMN_ICON;
    private static final int COLUMN_DISTANCE;
    public static final int COLUMN_ENTRY;
    private static final int COLUMN_FLAG_RRD;
    private static final int COLUMN_GOOGLE_RATING;
    private static final int COLUMN_INFO_TEXT;
    private static final int COLUMN_ADDRESS;
    public static final int COLUMN_PHONE;
    private static final int COLUMN_RECORD_SELECTED;
    public static final int COLUMN_RIGHT_CONTEXT;
    private static final int MAX_COLUMN;
    private static final int LLD_NAME;
    private static final int LLD_DISTANCE;
    private static final int LLD_DIRECTION_DISTANCE;
    private final LogChannel log;

    public PoiOnlineListRow(LogChannel logChannel, PoiOnlineSearchArea poiOnlineSearchArea, IVehicle iVehicle, PoiOnlineSearchValuelistElement poiOnlineSearchValuelistElement, int n, IconHandler iconHandler, NavLocation navLocation, boolean bl) {
        int[] nArray;
        this.log = logChannel;
        int n2 = 0;
        PosPosition posPosition = null;
        int n3 = 0;
        int n4 = 0;
        int n5 = 0;
        int n6 = iconHandler.resolveTargetIcon(n);
        if (poiOnlineSearchArea.useRRD()) {
            posPosition = iVehicle.getPosition();
            n2 = iVehicle.getHeading(posPosition);
            n3 = Util.computeAbsoluteDirection(posPosition, poiOnlineSearchValuelistElement.longitude, poiOnlineSearchValuelistElement.latitude);
            n4 = Util.convertRotatingDirection(n3, n2);
            n5 = Util.computeAirDistance(posPosition.longitude, posPosition.latitude, poiOnlineSearchValuelistElement.longitude, poiOnlineSearchValuelistElement.latitude);
        } else if (poiOnlineSearchArea != null && poiOnlineSearchArea.getNavLocation() != null) {
            n3 = Util.computeAbsoluteDirection(poiOnlineSearchArea.getNavLocation().getLongitude(), poiOnlineSearchArea.getNavLocation().getLatitude(), poiOnlineSearchValuelistElement.longitude, poiOnlineSearchValuelistElement.latitude);
            n4 = Util.convertRotatingDirection(n3, n2);
            n5 = Util.computeAirDistance(poiOnlineSearchArea.getNavLocation().longitude, poiOnlineSearchArea.getNavLocation().latitude, poiOnlineSearchValuelistElement.longitude, poiOnlineSearchValuelistElement.latitude);
        } else {
            logChannel.log(-1601830656, "OnlineListRow#OnlineListRow() - no valid geo position");
        }
        boolean bl2 = poiOnlineSearchValuelistElement.phone != null && poiOnlineSearchValuelistElement.phone.length() > 0;
        ListCell[] listCellArray = new ListCell[14];
        listCellArray[0] = new TextListCell(poiOnlineSearchValuelistElement.name);
        listCellArray[1] = IntegerListCell.create(n4);
        listCellArray[2] = new MetricsListCell(new Distance(n5, 5));
        listCellArray[3] = IntegerListCell.create(0);
        listCellArray[4] = new IconCell(new HMIResourceLocator(n6));
        listCellArray[5] = new MetricsListCell(new Distance(n5, 5));
        listCellArray[6] = new ObjectListCell(poiOnlineSearchValuelistElement);
        listCellArray[7] = IntegerListCell.create(0);
        listCellArray[8] = IntegerListCell.create(3);
        listCellArray[9] = new TextListCell(poiOnlineSearchValuelistElement.description);
        listCellArray[10] = new TextListCell(PoiOnlineListRow.getCustomAddress(poiOnlineSearchValuelistElement));
        listCellArray[11] = new TextListCell(poiOnlineSearchValuelistElement.phone);
        listCellArray[12] = new IntegerListCell(0, 1);
        if (bl2) {
            int[] nArray2 = new int[1];
            nArray = nArray2;
            nArray2[0] = -2040561860;
        } else {
            nArray = new int[]{};
        }
        listCellArray[13] = new PropertyListCell(-1331490722, nArray);
        ListCell[] listCellArray2 = listCellArray;
        this.setCells(listCellArray2);
    }

    public PoiOnlineListRow(LogChannel logChannel, ListCell[] listCellArray) {
        this.log = logChannel;
        this.setCells(this.cells);
    }

    public PoiOnlineListRow(LogChannel logChannel) {
        this.log = logChannel;
        this.cells = null;
    }

    @Override
    public String toString() {
        return new StringBuffer().append("OnlineListRow [log=").append(this.log).append(", cells=").append(this.cells != null ? Arrays.asList(this.cells) : null).append("]").toString();
    }

    @Override
    public boolean equals(Object object) {
        boolean bl = false;
        if (object instanceof PoiOnlineListRow) {
            bl = this == object;
        }
        return bl;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String getPOIName() {
        TextListCell textListCell = (TextListCell)this.getCell(0);
        return textListCell.getText();
    }

    public String getInfoText() {
        TextListCell textListCell = (TextListCell)this.getCell(9);
        return textListCell.getText();
    }

    public String getAddress() {
        TextListCell textListCell = (TextListCell)this.getCell(10);
        return textListCell.getText();
    }

    public PoiOnlineSearchValuelistElement getEntry() {
        ObjectListCell objectListCell = (ObjectListCell)this.getCell(6);
        return (PoiOnlineSearchValuelistElement)objectListCell.getValue();
    }

    public static int getMaxColumns() {
        return 14;
    }

    @Override
    public int getDirection() {
        IntegerListCell integerListCell = (IntegerListCell)this.getCell(1);
        int n = integerListCell.getValue();
        if (this.isMarkedAsRRD()) {
            n -= 8;
        }
        return n;
    }

    @Override
    public int getDistance() {
        MetricsListCell metricsListCell = (MetricsListCell)this.getCell(5);
        return (int)((Distance)metricsListCell.getMetrics()).getValue();
    }

    public int getGoogleRating() {
        IntegerListCell integerListCell = (IntegerListCell)this.getCell(8);
        return integerListCell.getValue();
    }

    public boolean isPhoneNoAvailable() {
        TextListCell textListCell = (TextListCell)this.getCell(11);
        return textListCell != null && !textListCell.getText().equals("");
    }

    @Override
    public int getLatitude() {
        return this.getEntry().latitude;
    }

    @Override
    public int getLongitude() {
        return this.getEntry().longitude;
    }

    @Override
    public boolean isMarkedAsRRD() {
        IntegerListCell integerListCell = (IntegerListCell)this.getCell(7);
        int n = integerListCell.getValue();
        return n != 0;
    }

    public void setFlagRRD(boolean bl) {
        IntegerListCell integerListCell = (IntegerListCell)this.getCell(7);
        integerListCell = IntegerListCell.create(bl ? 1 : 0);
        this.setCell(7, integerListCell);
    }

    @Override
    public void setRRDDistance(int n) {
        this.setDistance(n);
        this.reformatDistance();
        if (!this.isMarkedAsRRD()) {
            int n2 = this.getDirection();
            this.setFlagRRD(true);
            this.setDirection(n2);
        }
    }

    @Override
    public void setAirDistance(int n) {
        this.setDistance(n);
        this.reformatDistance();
        if (this.isMarkedAsRRD()) {
            int n2 = this.getDirection();
            this.setFlagRRD(false);
            this.setDirection(n2);
        }
    }

    private void setDistance(int n) {
        this.setCell(5, new MetricsListCell(new Distance(n, 5)));
        this.setCell(2, new MetricsListCell(new Distance(n, 5)));
    }

    private void setRecordSelected(int n) {
        IntegerListCell integerListCell = (IntegerListCell)this.getCell(12);
        integerListCell.setValue(n);
    }

    private void setRightDrawerContext(int n) {
        IntegerListCell integerListCell = (IntegerListCell)this.getCell(13);
        integerListCell.setValue(n);
    }

    @Override
    public void reformatDistance() {
    }

    @Override
    public void setDirection(int n) {
        IntegerListCell integerListCell = (IntegerListCell)this.getCell(1);
        integerListCell = IntegerListCell.create(this.isMarkedAsRRD() ? n + 8 : n);
        this.setCell(1, integerListCell);
    }

    @Override
    public int getIcon() {
        IconCell iconCell = (IconCell)this.getCell(4);
        return iconCell.getResourceLocator().getResourceID();
    }

    @Override
    public boolean isToRefine() {
        return false;
    }

    @Override
    public String getAdditionalInfo() {
        String string = null;
        PoiOnlineSearchValuelistElement poiOnlineSearchValuelistElement = this.getEntry();
        if (poiOnlineSearchValuelistElement != null) {
            Buffer buffer = new Buffer();
            if (Util.isHURegionNAR()) {
                PoiOnlineListRow.appendEntry(buffer, null, poiOnlineSearchValuelistElement.street);
                PoiOnlineListRow.appendEntry(buffer, ", ", poiOnlineSearchValuelistElement.city);
                PoiOnlineListRow.appendEntry(buffer, " ", poiOnlineSearchValuelistElement.postal);
            } else {
                PoiOnlineListRow.appendEntry(buffer, null, poiOnlineSearchValuelistElement.postal);
                PoiOnlineListRow.appendEntry(buffer, " ", poiOnlineSearchValuelistElement.city);
                PoiOnlineListRow.appendEntry(buffer, ", ", poiOnlineSearchValuelistElement.street);
            }
            string = buffer.toString();
        }
        return string;
    }

    public static String getCustomAddress(PoiOnlineSearchValuelistElement poiOnlineSearchValuelistElement) {
        String string = null;
        if (poiOnlineSearchValuelistElement != null) {
            Buffer buffer = new Buffer();
            PoiOnlineListRow.appendEntry(buffer, null, poiOnlineSearchValuelistElement.street);
            PoiOnlineListRow.appendEntry(buffer, ", ", poiOnlineSearchValuelistElement.city);
            if (Util.isHURegionNAR()) {
                PoiOnlineListRow.appendEntry(buffer, ", ", poiOnlineSearchValuelistElement.region);
                PoiOnlineListRow.appendEntry(buffer, " ", poiOnlineSearchValuelistElement.postal);
            }
            string = buffer.toString();
        }
        return string;
    }

    private static void appendEntry(Buffer buffer, String string, String string2) {
        if (buffer == null || Util.isEmpty(string2)) {
            return;
        }
        if (buffer.length() > 0 && string != null) {
            buffer.append(string);
        }
        buffer.append(string2);
    }

    @Override
    public void updateDirection(PosPosition posPosition) {
        int n = Util.computeAbsoluteDirection(posPosition, this.getLongitude(), this.getLatitude());
        int n2 = Util.convertRotatingDirection(n, posPosition.directionAngle);
        this.setDirection(n2);
    }

    @Override
    public void updateAirDistance(PosPosition posPosition) {
        if (!this.isMarkedAsRRD()) {
            int n = Util.computeAirDistance(posPosition.getLongitude(), posPosition.getLatitude(), this.getLongitude(), this.getLatitude());
            this.setAirDistance(n);
        }
    }

    public static String getPostalAddress(PoiOnlineSearchValuelistElement poiOnlineSearchValuelistElement, boolean bl) {
        Buffer buffer = new Buffer();
        buffer.append(PoiOnlineListRow.isEmpty(poiOnlineSearchValuelistElement.street) ? "" : new StringBuffer().append(poiOnlineSearchValuelistElement.street).append(", ").toString());
        if (bl) {
            if (!PoiOnlineListRow.isEmpty(poiOnlineSearchValuelistElement.city)) {
                buffer.append(poiOnlineSearchValuelistElement.city);
                if (!PoiOnlineListRow.isEmpty(poiOnlineSearchValuelistElement.region) || !PoiOnlineListRow.isEmpty(poiOnlineSearchValuelistElement.postal)) {
                    buffer.append(", ");
                }
            }
            if (!PoiOnlineListRow.isEmpty(poiOnlineSearchValuelistElement.region)) {
                buffer.append(poiOnlineSearchValuelistElement.region);
                buffer.append(' ');
            }
            if (!PoiOnlineListRow.isEmpty(poiOnlineSearchValuelistElement.postal)) {
                buffer.append(poiOnlineSearchValuelistElement.postal);
            }
        } else {
            if (!PoiOnlineListRow.isEmpty(poiOnlineSearchValuelistElement.postal)) {
                buffer.append(poiOnlineSearchValuelistElement.postal);
                buffer.append(' ');
            }
            if (!PoiOnlineListRow.isEmpty(poiOnlineSearchValuelistElement.city)) {
                buffer.append(poiOnlineSearchValuelistElement.city);
            }
        }
        return buffer.toString();
    }

    public static boolean isEmpty(String string) {
        if (string == null) {
            return true;
        }
        for (int i2 = 0; i2 < string.length(); ++i2) {
            if (Character.isWhitespace(string.charAt(i2))) continue;
            return false;
        }
        return true;
    }
}

