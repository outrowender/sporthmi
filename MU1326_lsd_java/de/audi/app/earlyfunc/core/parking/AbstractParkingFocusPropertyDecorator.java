/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.core.parking;

import de.audi.app.earlyfunc.core.parking.IParkingFocusPropertyConfig;
import de.audi.app.earlyfunc.core.parking.ParkingFocusPropertyCollection;

public abstract class AbstractParkingFocusPropertyDecorator
implements IParkingFocusPropertyConfig {
    private final IParkingFocusPropertyConfig config;

    public AbstractParkingFocusPropertyDecorator(IParkingFocusPropertyConfig iParkingFocusPropertyConfig) {
        this.config = iParkingFocusPropertyConfig;
    }

    private IParkingFocusPropertyConfig getConfig() {
        return this.config;
    }

    public void configureFocusProperties(ParkingFocusPropertyCollection parkingFocusPropertyCollection) {
        if (this.getConfig() != null) {
            this.getConfig().configureFocusProperties(this.prepareFocusProperties(parkingFocusPropertyCollection));
        }
    }

    protected abstract ParkingFocusPropertyCollection prepareFocusProperties(ParkingFocusPropertyCollection var1);
}

