/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.core.seat;

import de.audi.app.earlyfunc.core.seat.ISeatPopinModelRow;

public class MasterSeatPopinContent
implements ISeatPopinModelRow {
    public static final int CONFIG_TYPE_NONE;
    public static final int CONFIG_TYPE_VISUALIZATION;
    public static final int CONFIG_TYPE_SEAT_MEMORY;
    public static final int CONFIG_TYPE_MASSAGE;
    public static final int ARROW_DIMENSION_NONE;
    public static final int ARROW_DIMENSION_HORIZONTAL;
    public static final int ARROW_DIMENSION_VERTICAL;
    public static final int ARROW_DIMENSION_BOTH;
    private final int seatContentID;
    private final String seatContentName;
    private final long rowID;
    private final int voConfigType;
    private final int arrowDimension;
    public static final MasterSeatPopinContent NONE;
    public static final MasterSeatPopinContent GURTHOEHE;
    public static final MasterSeatPopinContent LEHNENKOPF;
    public static final MasterSeatPopinContent LORDORSE;
    public static final MasterSeatPopinContent SEITENWANGEN;
    public static final MasterSeatPopinContent SITZTIEFE;
    public static final MasterSeatPopinContent MASSAGE;
    public static final MasterSeatPopinContent MEMORY;
    private static final MasterSeatPopinContent[] ALL_SEAT_POPIN_CONTENTS;

    private MasterSeatPopinContent(int n, String string, int n2, long l, int n3) {
        this.seatContentID = n;
        this.seatContentName = string;
        this.voConfigType = n2;
        this.rowID = l;
        this.arrowDimension = n3;
    }

    public boolean equals(Object object) {
        return object instanceof MasterSeatPopinContent && this.equalsMasterSeatPopinContent((MasterSeatPopinContent)object);
    }

    public int hashCode() {
        int n = 1;
        n = 31 * n + this.seatContentID;
        return n;
    }

    public boolean equalsMasterSeatPopinContent(MasterSeatPopinContent masterSeatPopinContent) {
        return this.seatContentID == masterSeatPopinContent.getSeatContentID();
    }

    public int getSeatContentID() {
        return this.seatContentID;
    }

    public String getSeatContentName() {
        return this.seatContentName;
    }

    public int getVoConfigType() {
        return this.voConfigType;
    }

    @Override
    public long getRowID() {
        return this.rowID;
    }

    public boolean hasValidRowID() {
        return this.rowID != -1L;
    }

    public int getArrowDimension() {
        return this.arrowDimension;
    }

    public boolean usesVOConfigType(int n) {
        return this.voConfigType == n;
    }

    public String toString() {
        return this.getSeatContentName();
    }

    public static MasterSeatPopinContent[] getAllSeatPopinContents() {
        return ALL_SEAT_POPIN_CONTENTS;
    }

    public static MasterSeatPopinContent getContentForID(int n) {
        if (n < ALL_SEAT_POPIN_CONTENTS.length && n > 0) {
            return ALL_SEAT_POPIN_CONTENTS[n];
        }
        return NONE;
    }

    static {
        NONE = new MasterSeatPopinContent(0, "NONE", 0, -1L, 0);
        GURTHOEHE = new MasterSeatPopinContent(1, "GURTHOEHE", 1, 1L, 2);
        LEHNENKOPF = new MasterSeatPopinContent(2, "LEHNENKOPF", 1, 0, 1);
        LORDORSE = new MasterSeatPopinContent(3, "LORDOSE", 1, 0, 3);
        SEITENWANGEN = new MasterSeatPopinContent(4, "SEITENWANGEN", 1, 0, 3);
        SITZTIEFE = new MasterSeatPopinContent(5, "SITZTIEFE", 1, 0, 1);
        MASSAGE = new MasterSeatPopinContent(6, "MASSAGE", 3, -1L, 3);
        MEMORY = new MasterSeatPopinContent(7, "MEMORY", 2, -1L, 0);
        ALL_SEAT_POPIN_CONTENTS = new MasterSeatPopinContent[]{NONE, GURTHOEHE, LEHNENKOPF, LORDORSE, SEITENWANGEN, SITZTIEFE, MASSAGE, MEMORY};
    }
}

