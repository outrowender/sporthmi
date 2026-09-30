/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.countryinfo;

import de.audi.atip.hmi.model.HMIResourceLocator;
import de.audi.atip.hmi.model.IconCell;
import de.audi.atip.hmi.model.IntegerListCell;
import de.audi.atip.hmi.model.ListCell;
import de.audi.atip.hmi.model.ListRow;
import de.audi.atip.hmi.model.TextListCell;
import de.audi.tghu.navi.app.IconHandler;
import org.dsi.ifc.trafficregulation.RoadClassSpeedInfo;

public class RoadClassSpeedInfoRow
extends ListRow {
    public static final int CELL_0_ROAD_CLASS_ICON = 0;
    public static final int CELL_1_ROAD_SIGN_ICON = 1;
    public static final int CELL_2_ROAD_CLASS_TEXT = 2;
    public static final int CELL_3_RECOMMENDED_SPEED = 3;
    public static final int CELL_6_SELECTABLE = 6;
    public static final int ROW_NUMBER_OF_CELLS = 7;
    public static final int SPEED_UNIT_METRIC = 0;
    public static final int SPEED_UNIT_IMPERIAL = 1;
    public static final int ROAD_CLASS_INNERCITY = 0;
    public static final int ROAD_CLASS_OUTERCITY = 1;
    public static final int ROAD_CLASS_RURAL = 2;
    public static final int ROAD_CLASS_MOTORWAY = 3;
    public static final int RECOMMENDED_SPEED_ON = 0;
    public static final int RECOMMENDED_SPEED_OFF = 1;

    public RoadClassSpeedInfoRow(IconHandler iconHandler, RoadClassSpeedInfo roadClassSpeedInfo) {
        super(new ListCell[7]);
        if (roadClassSpeedInfo != null) {
            int n = roadClassSpeedInfo.getVariant();
            this.cells[0] = RoadClassSpeedInfoRow.resolveRoadClassIcon(iconHandler, roadClassSpeedInfo.getRoadClassIconReference(), n);
            this.cells[1] = RoadClassSpeedInfoRow.resolveRoadSignIcon(iconHandler, roadClassSpeedInfo.getRoadSignIconReference(), n);
            this.cells[2] = new IntegerListCell(RoadClassSpeedInfoRow.convertRoadClass(roadClassSpeedInfo.getRoadClassType()));
            this.cells[3] = new IntegerListCell(RoadClassSpeedInfoRow.convertRecommendedSpeed(roadClassSpeedInfo.getRoadClassType()));
            this.cells[6] = new IntegerListCell(0);
        }
    }

    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        boolean bl = true;
        try {
            if (this.getRoadClassIconId() != ((RoadClassSpeedInfoRow)object).getRoadClassIconId()) {
                bl = false;
            }
            if (this.getRoadSignIconId() != ((RoadClassSpeedInfoRow)object).getRoadSignIconId()) {
                bl = false;
            }
            if (this.getRoadClassTextIndex() != ((RoadClassSpeedInfoRow)object).getRoadClassTextIndex()) {
                bl = false;
            }
            if (this.getRecommendedSpeedIndex() != ((RoadClassSpeedInfoRow)object).getRecommendedSpeedIndex()) {
                bl = false;
            }
        }
        catch (ClassCastException classCastException) {
            bl = false;
        }
        return bl;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public int getRoadClassIconId() {
        return this.getIntFromIntegerListCell(0);
    }

    public int getRoadSignIconId() {
        return this.getIntFromIntegerListCell(1);
    }

    public int getRoadClassTextIndex() {
        return this.getIntFromIntegerListCell(2);
    }

    public int getRecommendedSpeedIndex() {
        return this.getIntFromIntegerListCell(3);
    }

    private static int convertSpeedUnit(int n) {
        int n2;
        switch (n) {
            case 0: {
                n2 = 0;
                break;
            }
            case 1: {
                n2 = 1;
                break;
            }
            default: {
                n2 = 0;
            }
        }
        return n2;
    }

    public static int convertRoadClass(int n) {
        int n2;
        switch (n) {
            case 2: 
            case 34: 
            case 66: {
                n2 = 0;
                break;
            }
            case 3: 
            case 35: 
            case 67: {
                n2 = 1;
                break;
            }
            case 0: 
            case 32: 
            case 64: {
                n2 = 2;
                break;
            }
            case 1: 
            case 33: 
            case 65: {
                n2 = 3;
                break;
            }
            default: {
                n2 = 0;
            }
        }
        return n2;
    }

    public static int convertRecommendedSpeed(int n) {
        int n2;
        switch (n) {
            case 0: 
            case 1: 
            case 2: 
            case 3: 
            case 32: 
            case 33: 
            case 34: 
            case 35: {
                n2 = 1;
                break;
            }
            case 64: 
            case 65: 
            case 66: 
            case 67: {
                n2 = 0;
                break;
            }
            default: {
                n2 = 1;
            }
        }
        return n2;
    }

    private static IconCell resolveRoadClassIcon(IconHandler iconHandler, int n, int n2) {
        int n3 = iconHandler.resolveRoadClassIconResourceID(n, n2);
        if (n3 != -1) {
            return new IconCell(new HMIResourceLocator(n3));
        }
        return new IconCell(new HMIResourceLocator(-1));
    }

    private static IconCell resolveRoadSignIcon(IconHandler iconHandler, int n, int n2) {
        int n3 = iconHandler.resolveTrafficRegulationIconResourceID(n, n2, 0);
        if (n3 != -1) {
            return new IconCell(new HMIResourceLocator(n3));
        }
        return new IconCell(new HMIResourceLocator(-1));
    }

    private String getTextFromTextListCell(int n) {
        String string;
        try {
            TextListCell textListCell = (TextListCell)this.getCell(n);
            string = textListCell.getText();
        }
        catch (ClassCastException classCastException) {
            string = null;
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            string = null;
        }
        return string;
    }

    private int getIntFromIntegerListCell(int n) {
        int n2;
        try {
            IntegerListCell integerListCell = (IntegerListCell)this.getCell(n);
            n2 = integerListCell.getValue();
        }
        catch (ClassCastException classCastException) {
            n2 = -1;
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            n2 = -1;
        }
        return n2;
    }
}

