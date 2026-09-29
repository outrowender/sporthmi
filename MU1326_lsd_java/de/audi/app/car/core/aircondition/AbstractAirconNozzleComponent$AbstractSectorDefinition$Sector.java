/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.aircondition;

import de.audi.app.car.core.aircondition.AbstractAirconNozzleComponent$AbstractSectorDefinition;

public class AbstractAirconNozzleComponent$AbstractSectorDefinition$Sector {
    public static final int INVALID_SECTOR;
    private static final int LOWER_BORDER_INDEX;
    private static final int UPPER_BORDER_INDEX;
    private final int uniqueID;
    private final int representative;
    private final int[] range;
    private final /* synthetic */ AbstractAirconNozzleComponent$AbstractSectorDefinition this$0;

    public AbstractAirconNozzleComponent$AbstractSectorDefinition$Sector(AbstractAirconNozzleComponent$AbstractSectorDefinition abstractAirconNozzleComponent$AbstractSectorDefinition, int n, int n2, int n3, int n4) {
        this.this$0 = abstractAirconNozzleComponent$AbstractSectorDefinition;
        this.uniqueID = n;
        this.representative = n2;
        this.range = new int[]{n3, n4};
    }

    public int getUniqueID() {
        return this.uniqueID;
    }

    public int getRepresentative() {
        return this.representative;
    }

    public int getLowerBorder() {
        return this.range[0];
    }

    public int getUpperBoarder() {
        return this.range[1];
    }
}

