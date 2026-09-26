/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.info.tmc;

import de.audi.atip.hmi.model.IconCell;
import de.audi.atip.hmi.model.PropertyListCell;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.metrics.Distance;
import de.audi.tghu.info.app.InfoEnv;
import de.audi.tghu.info.app.tmc.TMCAbstractListRow;
import de.audi.tghu.info.app.tmc.TMCHelper;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.tmc.TmcListElement;
import org.dsi.ifc.tmc.TmcMessage;

public class InfoListRow
extends TMCAbstractListRow {
    public static final int MAX_NUMBER_OF_CELLS;
    public static final int COLUMN_LAYOUT;
    public static final int COLUMN_ROAD_ICON;
    public static final int COLUMN_LOCATION_1;
    public static final int COLUMN_ARROW_ICON;
    public static final int COLUMN_LOCATION_2;
    public static final int COLUMN_EVENT_ICON_1;
    public static final int COLUMN_EVENT_ICON_2;
    public static final int COLUMN_EVENT_TEXT;
    public static final int COLUMN_DISTANCE_ARROW;
    public static final int COLUMN_DISTANCE_TEXT;
    public static final int COLUMN_HORIZONTAL_LINE;
    public static final int COLUMN_PROPERTIES;
    public static final int COLUMN_PARENT_NODE_STATE;
    public static final int COLUMN_CAR2X;
    public static final int PARENT_NODE_CLOSED;
    public static final int PARENT_NODE_OPEN;
    private static final int TMC_LAYOUT_WITH_ARROW;
    private static final int TMC_LAYOUT_WITH_IN;
    private static final int TMC_LAYOUT_NO_DISTANCE;
    private static final int TMC_LAYOUT_PARENT_NODE;
    private static final int DIRECTION_ARROW_NONE;
    private static final int DIRECTION_ARROW_RIGHT;
    private static final int DIRECTION_ARROW_LEFT;
    private static final int DIRECTION_ARROW_BIDIRECTIONAL;
    public static final int WITHOUT_CAR2X_ICON;
    public static final int WITH_CAR2X_ICON;

    public InfoListRow(TmcListElement tmcListElement, IconCell iconCell, String string, int n, String string2, IconCell iconCell2, String string3, int n2, int n3, InfoEnv infoEnv) {
        super(tmcListElement.uID, 14);
        this.message = tmcListElement;
        TmcMessage tmcMessage = this.message.getMessage();
        if (!tmcMessage.hasGeoPos) {
            this.setLayOut(2);
        } else if (tmcMessage.routeRelevance == 0) {
            this.setLayOut(1);
        } else {
            this.setLayOut(0);
        }
        if (tmcListElement.parentID == -1L) {
            this.setRoadIcon(iconCell);
        }
        if (infoEnv.getFramework().isNar()) {
            this.setNarDirectionData(tmcMessage.isBidirectional, tmcMessage.urbanFlag, string, string2, iconCell, tmcMessage.roadName);
        } else {
            this.setStandardDirectionData(tmcMessage.isBidirectional, tmcMessage.urbanFlag, string, string2, iconCell, tmcMessage.roadName);
            this.setArrowIcon(n);
        }
        this.setEventIcon1(iconCell2);
        this.setEventIcon2(iconCell2);
        this.setEventText(string3);
        this.setDirectionArrow(n2);
        this.setSeparatorLine(0);
        this.setCar2x(tmcMessage.getMessageSource() == 5 ? 1 : 0);
        Distance distance = new Distance(n3, 5);
        this.setDistance(distance);
        PropertyListCell propertyListCell = new PropertyListCell(-1868343730, new int[0]);
        this.setPropertyCell(propertyListCell);
    }

    private void setNarDirectionData(boolean bl, boolean bl2, String string, String string2, IconCell iconCell, String string3) {
        if ((iconCell == null || bl2) && !TMCHelper.isEmpty(string3)) {
            Buffer buffer = new Buffer(string3);
            if (!TMCHelper.isEmpty(string)) {
                buffer.append(", ");
                buffer.append(string);
            }
            this.setDirection1(buffer.toString());
        } else {
            this.setDirection1(string2);
        }
        if (bl) {
            this.setArrowIcon(1);
            this.setDirection2(string);
        } else {
            this.setArrowIcon(-1);
            this.setDirection2("");
        }
    }

    private void setStandardDirectionData(boolean bl, boolean bl2, String string, String string2, IconCell iconCell, String string3) {
        if ((iconCell == null || bl2) && !TMCHelper.isEmpty(string3)) {
            Buffer buffer = new Buffer(string3);
            if (!TMCHelper.isEmpty(string)) {
                buffer.append(", ");
                buffer.append(string);
            }
            this.setDirection1(buffer.toString());
        } else {
            this.setDirection1(string);
        }
        this.setDirection2(string2);
    }

    public InfoListRow(TmcListElement tmcListElement, IconCell iconCell, String string, String string2, long l) {
        super(tmcListElement.uID, 14);
        this.message = tmcListElement;
        this.setLayOut(3);
        this.setRoadIcon(iconCell);
        this.setDirection1(string);
        this.setEventText(string2);
        this.setSeparatorLine(0);
        if (this.message.getUID() == l) {
            this.setParentNodeState(1);
        } else {
            this.setParentNodeState(0);
        }
        PropertyListCell propertyListCell = new PropertyListCell(-1868343730, new int[0]);
        this.setPropertyCell(propertyListCell);
        this.setCar2x(0);
    }

    public InfoListRow(InfoListRow infoListRow) {
        super(infoListRow);
    }

    @Override
    public EvoListRow copy() {
        return new InfoListRow(this);
    }

    @Override
    public boolean isLayoutOnRoute() {
        return this.getInteger(0) == 1;
    }

    @Override
    public void updateRrdCarToEvent(int n) {
        long l = (long)n - this.getTmcListElement().getMessage().distanceToEvent;
        if (l < 0L) {
            this.setLayOut(2);
        } else {
            Distance distance = new Distance(l, 5);
            this.setDistance(distance);
        }
    }

    @Override
    public void updateDistanceAndDireciton(int n, int n2, int n3) {
        if (this.getTmcListElement().getMessage().routeRelevance == 0) {
            this.updateRrdCarToEvent(n);
        } else {
            this.setDirectionArrow(n2);
            Distance distance = new Distance(n3, 5);
            this.setDistance(distance);
        }
    }

    public final void setLayOut(int n) {
        this.setInteger(0, n);
    }

    public final void setRoadIcon(IconCell iconCell) {
        this.setIconCell(1, iconCell);
    }

    public final void setDirection1(String string) {
        this.setText(2, string);
    }

    public final void setCar2x(int n) {
        this.setInteger(13, n);
    }

    public final void setArrowIcon(int n) {
        if (n == 1) {
            this.setInteger(3, 3);
        } else if (n == 0) {
            this.setInteger(3, 1);
        } else {
            this.setInteger(3, 0);
        }
    }

    public final void setDirection2(String string) {
        this.setText(4, string);
    }

    public final void setEventIcon1(IconCell iconCell) {
        this.setIconCell(5, iconCell);
    }

    public final void setEventIcon2(IconCell iconCell) {
        this.setIconCell(6, iconCell);
    }

    public final void setEventText(String string) {
        this.setText(7, string);
    }

    public final void setDirectionArrow(int n) {
        this.setInteger(8, n);
    }

    public final void setDistance(Distance distance) {
        this.setMetrics(9, distance);
    }

    public final void setPropertyCell(PropertyListCell propertyListCell) {
        this.setPropertyCell(11, propertyListCell);
    }

    public final void setParentNodeState(int n) {
        this.setInteger(12, n);
    }

    public final void setSeparatorLine(int n) {
        this.setInteger(10, n);
    }
}

