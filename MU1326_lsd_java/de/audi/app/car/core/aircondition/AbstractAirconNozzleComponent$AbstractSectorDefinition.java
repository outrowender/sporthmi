/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.aircondition;

import de.audi.app.car.core.aircondition.AbstractAirconNozzleComponent$AbstractSectorDefinition$Sector;

public abstract class AbstractAirconNozzleComponent$AbstractSectorDefinition {
    public abstract AbstractAirconNozzleComponent$AbstractSectorDefinition$Sector[] getSectorDefinition() {
    }

    public AbstractAirconNozzleComponent$AbstractSectorDefinition$Sector getSector(int n) {
        AbstractAirconNozzleComponent$AbstractSectorDefinition$Sector[] abstractAirconNozzleComponent$AbstractSectorDefinition$SectorArray = this.getSectorDefinition();
        AbstractAirconNozzleComponent$AbstractSectorDefinition$Sector abstractAirconNozzleComponent$AbstractSectorDefinition$Sector = null;
        for (int i2 = 0; i2 < abstractAirconNozzleComponent$AbstractSectorDefinition$SectorArray.length; ++i2) {
            if (n < abstractAirconNozzleComponent$AbstractSectorDefinition$SectorArray[i2].getLowerBorder() || n > abstractAirconNozzleComponent$AbstractSectorDefinition$SectorArray[i2].getUpperBoarder()) continue;
            abstractAirconNozzleComponent$AbstractSectorDefinition$Sector = new AbstractAirconNozzleComponent$AbstractSectorDefinition$Sector(this, abstractAirconNozzleComponent$AbstractSectorDefinition$SectorArray[i2].getUniqueID(), abstractAirconNozzleComponent$AbstractSectorDefinition$SectorArray[i2].getRepresentative(), abstractAirconNozzleComponent$AbstractSectorDefinition$SectorArray[i2].getLowerBorder(), abstractAirconNozzleComponent$AbstractSectorDefinition$SectorArray[i2].getUpperBoarder());
            break;
        }
        return abstractAirconNozzleComponent$AbstractSectorDefinition$Sector;
    }
}

