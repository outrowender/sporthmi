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

public class InfoDetailsRow
extends TMCAbstractListRow {
    private static long uniqueIdCounter = 0L;
    private final int layout;
    public static final int LAYOUT_TITLE;
    public static final int LAYOUT_AREA_FULL;
    public static final int LAYOUT_AREA_LIGHT;
    public static final int LAYOUT_EVENT;
    public static final int LAYOUT_DIRECTION_WITH_ARROW;
    public static final int LAYOUT_DIRECTION_WITH_IN;
    public static final int MAX_NUMBER_OF_CELLS;
    public static final int CELL_LAYOUT;
    public static final int CELL_ROAD_ICON;
    public static final int CELL_ROAD_LOCATION1;
    public static final int CELL_ROAD_LOCATION2;
    public static final int CELL_LOCATION_DIRECTION_ARROW;
    public static final int CELL_SUB_LOCATION1;
    public static final int CELL_SUB_LOCATION2;
    public static final int CELL_EVENT_ICON;
    public static final int CELL_EVENT_TEXT;
    public static final int CELL_DISTANCE_ARROW;
    public static final int CELL_EVENT_DISTANCE;
    public static final int CELL_CURSOR_FOCUS;
    public static final int CELL_PROPERTY;
    public static final int CELL_CAR2X;
    private static final int DIRECTION_ARROW_NONE;
    private static final int DIRECTION_ARROW_RIGHT;
    private static final int DIRECTION_ARROW_LEFT;
    private static final int DIRECTION_ARROW_BIDIRECTIONAL;
    public static final int WITHOUT_CAR2X_ICON;
    public static final int WITH_CAR2X_ICON;

    public InfoDetailsRow(TmcListElement tmcListElement, int n, IconCell iconCell, String string, int n2, IconCell iconCell2, Distance distance, int n3, int n4, InfoEnv infoEnv) {
        super(uniqueIdCounter++, 14);
        this.message = tmcListElement;
        this.layout = n;
        this.setCar2x(0);
        switch (n) {
            case 0: {
                this.createTitleRow(this.message.getMessage(), iconCell, n2, infoEnv);
                break;
            }
            case 1: {
                this.createAreaFullRow(tmcListElement, infoEnv);
                break;
            }
            case 2: {
                this.createAreaLightRow(this.message);
                break;
            }
            case 3: {
                this.createEventRow(this.message, iconCell2, n3);
                break;
            }
            case 4: {
                this.createDirectionWithArrow(n4, distance);
                break;
            }
            case 5: {
                this.createDirectionWithIn(distance);
                break;
            }
        }
        this.setInteger(11, 0);
        PropertyListCell propertyListCell = new PropertyListCell(-1868343730, new int[0]);
        this.setPropertyCell(propertyListCell);
    }

    @Override
    public void updateRrdCarToEvent(int n) {
        long l = (long)n - this.getTmcListElement().getMessage().distanceToEvent;
        Distance distance = new Distance(l, 5);
        this.setDistance(distance);
    }

    @Override
    public void updateDistanceAndDireciton(int n, int n2, int n3) {
        if (this.layout != 4 && this.layout != 5) {
            return;
        }
        if (this.layout == 5) {
            this.updateRrdCarToEvent(n);
        } else {
            this.setDistanceArrow(n2);
            Distance distance = new Distance(n3, 5);
            this.setDistance(distance);
        }
    }

    private final void createDirectionWithIn(Distance distance) {
        this.setLayout(5);
        this.setDistance(distance);
    }

    private final void createDirectionWithArrow(int n, Distance distance) {
        this.setLayout(4);
        this.setDistanceArrow(n);
        this.setDistance(distance);
    }

    private final void createEventRow(TmcListElement tmcListElement, IconCell iconCell, int n) {
        this.setLayout(3);
        this.setEventIcon(iconCell);
        this.setEventText(tmcListElement.message.getEventText()[n]);
    }

    private final void createAreaLightRow(TmcListElement tmcListElement) {
        this.setLayout(2);
        String string = "";
        string = tmcListElement.message.endLocation == null || tmcListElement.message.endLocation.length() == 0 ? tmcListElement.message.startLocation : tmcListElement.message.endLocation;
        this.setStartLocation(string);
        if (tmcListElement.getMessage().isArea) {
            this.setCar2x(tmcListElement.getMessage().getMessageSource() == 5 ? 1 : 0);
        }
    }

    private final void createAreaFullRow(TmcListElement tmcListElement, InfoEnv infoEnv) {
        int n = infoEnv.getFramework().getLanguageMgr().getCurrentLanguage("LANG_COMPONENT_HMI").getLanguageIndex();
        this.setLayout(1);
        if (infoEnv.getFramework().isCn() && n == 14) {
            this.setStartLocation(new StringBuffer().append(tmcListElement.getMessage().startLocation).append(" ").append(infoEnv.getTranslatedText(0)).toString());
            this.setEndLocation(new StringBuffer().append(tmcListElement.getMessage().endLocation).append(" ").append(infoEnv.getTranslatedText(1)).toString());
        } else {
            this.setStartLocation(new StringBuffer().append(infoEnv.getTranslatedText(1)).append(" ").append(tmcListElement.getMessage().startLocation).toString());
            this.setEndLocation(new StringBuffer().append(infoEnv.getTranslatedText(0)).append(" ").append(tmcListElement.getMessage().endLocation).toString());
        }
        if (tmcListElement.getMessage().isArea) {
            this.setCar2x(tmcListElement.getMessage().getMessageSource() == 5 ? 1 : 0);
        }
    }

    private void createTitleRow(TmcMessage tmcMessage, IconCell iconCell, int n, InfoEnv infoEnv) {
        this.setLayout(0);
        this.setRoadIcon(iconCell);
        this.setCar2x(tmcMessage.getMessageSource() == 5 ? 1 : 0);
        if (infoEnv.getFramework().isNar()) {
            this.setNarDirectionData(tmcMessage.isBidirectional, tmcMessage.urbanFlag, tmcMessage.directionOfRoad1, tmcMessage.directionOfRoad2, iconCell, tmcMessage.roadName);
        } else {
            this.setStandardDirectionData(tmcMessage.isBidirectional, tmcMessage.urbanFlag, tmcMessage.directionOfRoad1, tmcMessage.directionOfRoad2, iconCell, tmcMessage.roadName);
            this.setArrowIcon(n);
        }
    }

    private void setNarDirectionData(boolean bl, boolean bl2, String string, String string2, IconCell iconCell, String string3) {
        if ((iconCell == null || bl2) && !TMCHelper.isEmpty(string3)) {
            Buffer buffer = new Buffer(string3);
            if (!TMCHelper.isEmpty(string2)) {
                buffer.append(", ");
                buffer.append(string2);
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

    public InfoDetailsRow(InfoDetailsRow infoDetailsRow) {
        super(infoDetailsRow);
        this.layout = infoDetailsRow.layout;
    }

    @Override
    public EvoListRow copy() {
        return new InfoDetailsRow(this);
    }

    private void setLayout(int n) {
        this.setInteger(0, n);
    }

    private void setRoadIcon(IconCell iconCell) {
        this.setIconCell(1, iconCell);
    }

    private void setDirection1(String string) {
        this.setText(2, string);
    }

    private void setCar2x(int n) {
        this.setInteger(13, n);
    }

    private void setArrowIcon(int n) {
        if (n == 1) {
            this.setInteger(4, 3);
        } else if (n == 0) {
            this.setInteger(4, 1);
        } else {
            this.setInteger(4, 0);
        }
    }

    private void setDirection2(String string) {
        this.setText(3, string);
    }

    private void setStartLocation(String string) {
        this.setText(5, string);
    }

    private void setEndLocation(String string) {
        this.setText(6, string);
    }

    private void setEventIcon(IconCell iconCell) {
        this.setIconCell(7, iconCell);
    }

    private void setEventText(String string) {
        this.setText(8, string);
    }

    private void setDistanceArrow(int n) {
        this.setInteger(9, n);
    }

    private void setDistance(Distance distance) {
        this.setMetrics(10, distance);
    }

    public final void setPropertyCell(PropertyListCell propertyListCell) {
        this.setPropertyCell(12, propertyListCell);
    }

    @Override
    public boolean equals(Object object) {
        return false;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean isLayoutOnRoute() {
        return this.layout == 5;
    }
}

