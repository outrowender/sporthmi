/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.aircondition;

import de.audi.app.car.core.aircondition.AbstractAirconNozzleComponent$AbstractSectorDefinition;
import de.audi.app.car.core.aircondition.AbstractAirconNozzleComponent$AbstractSectorDefinition$Sector;

final class AbstractAirconNozzleComponent$2
extends AbstractAirconNozzleComponent$AbstractSectorDefinition {
    AbstractAirconNozzleComponent$2() {
    }

    @Override
    public AbstractAirconNozzleComponent$AbstractSectorDefinition$Sector[] getSectorDefinition() {
        return new AbstractAirconNozzleComponent$AbstractSectorDefinition$Sector[]{new AbstractAirconNozzleComponent$AbstractSectorDefinition$Sector(this, 0, -100, -100, -76), new AbstractAirconNozzleComponent$AbstractSectorDefinition$Sector(this, 1, -50, -75, -26), new AbstractAirconNozzleComponent$AbstractSectorDefinition$Sector(this, 3, 0, -25, 25), new AbstractAirconNozzleComponent$AbstractSectorDefinition$Sector(this, 5, 50, 26, 75), new AbstractAirconNozzleComponent$AbstractSectorDefinition$Sector(this, 6, 100, 76, 100)};
    }
}

