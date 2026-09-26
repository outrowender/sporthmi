/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.aircondition;

import de.audi.app.car.core.aircondition.AbstractAirconNozzleComponent$AbstractSectorDefinition;
import de.audi.app.car.core.aircondition.AbstractAirconNozzleComponent$AbstractSectorDefinition$Sector;

final class AbstractAirconNozzleComponent$3
extends AbstractAirconNozzleComponent$AbstractSectorDefinition {
    AbstractAirconNozzleComponent$3() {
    }

    @Override
    public AbstractAirconNozzleComponent$AbstractSectorDefinition$Sector[] getSectorDefinition() {
        return new AbstractAirconNozzleComponent$AbstractSectorDefinition$Sector[]{new AbstractAirconNozzleComponent$AbstractSectorDefinition$Sector(this, 0, 0, 0, 12), new AbstractAirconNozzleComponent$AbstractSectorDefinition$Sector(this, 1, 25, 13, 37), new AbstractAirconNozzleComponent$AbstractSectorDefinition$Sector(this, 2, 50, 38, 62), new AbstractAirconNozzleComponent$AbstractSectorDefinition$Sector(this, 3, 75, 63, 87), new AbstractAirconNozzleComponent$AbstractSectorDefinition$Sector(this, 4, 100, 88, 100)};
    }
}

