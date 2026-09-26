/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.aircondition;

import de.audi.app.car.core.aircondition.AbstractAirconNozzleComponent$AbstractSectorDefinition;
import de.audi.app.car.core.aircondition.AbstractAirconNozzleComponent$AbstractSectorDefinition$Sector;

final class AbstractAirconNozzleComponent$1
extends AbstractAirconNozzleComponent$AbstractSectorDefinition {
    AbstractAirconNozzleComponent$1() {
    }

    @Override
    public AbstractAirconNozzleComponent$AbstractSectorDefinition$Sector[] getSectorDefinition() {
        return new AbstractAirconNozzleComponent$AbstractSectorDefinition$Sector[]{new AbstractAirconNozzleComponent$AbstractSectorDefinition$Sector(this, 0, -100, -100, -83), new AbstractAirconNozzleComponent$AbstractSectorDefinition$Sector(this, 1, -66, -82, -50), new AbstractAirconNozzleComponent$AbstractSectorDefinition$Sector(this, 2, -33, -49, -17), new AbstractAirconNozzleComponent$AbstractSectorDefinition$Sector(this, 3, 0, -16, 16), new AbstractAirconNozzleComponent$AbstractSectorDefinition$Sector(this, 4, 33, 17, 49), new AbstractAirconNozzleComponent$AbstractSectorDefinition$Sector(this, 5, 66, 50, 82), new AbstractAirconNozzleComponent$AbstractSectorDefinition$Sector(this, 6, 100, 83, 100)};
    }
}

