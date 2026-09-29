/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.evo.parking;

import de.audi.app.earlyfunc.core.parking.AbstractParkingFocusPropertyDecorator;
import de.audi.app.earlyfunc.core.parking.IParkingFocusPropertyConfig;
import de.audi.app.earlyfunc.core.parking.ParkingFocusPropertyCollection;
import de.audi.app.earlyfunc.evo.parking.ParkingSystemARAComponentEvo;

class ParkingSystemARAComponentEvo$1
extends AbstractParkingFocusPropertyDecorator {
    private final /* synthetic */ ParkingSystemARAComponentEvo this$0;

    ParkingSystemARAComponentEvo$1(ParkingSystemARAComponentEvo parkingSystemARAComponentEvo, IParkingFocusPropertyConfig iParkingFocusPropertyConfig) {
        this.this$0 = parkingSystemARAComponentEvo;
        super(iParkingFocusPropertyConfig);
    }

    @Override
    protected ParkingFocusPropertyCollection prepareFocusProperties(ParkingFocusPropertyCollection parkingFocusPropertyCollection) {
        if (this.this$0.isAraActive()) {
            this.this$0.getLogChannel().log(-2137614336, "[AbstractParkingFocusPropertyDecorator] ARA FocusPropertyDecorator adds property FOCUS_EARLY_APPS_A_R_A_AKTIV('%1').", (long)0);
            parkingFocusPropertyCollection.addFocusProperty(-750377612);
        }
        return parkingFocusPropertyCollection;
    }
}

