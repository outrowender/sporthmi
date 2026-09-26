/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.evo.parking;

import de.audi.app.earlyfunc.core.parking.AbstractParkingFocusPropertyDecorator;
import de.audi.app.earlyfunc.core.parking.IParkingFocusPropertyConfig;
import de.audi.app.earlyfunc.core.parking.ParkingFocusPropertyCollection;
import de.audi.app.earlyfunc.evo.parking.ParkingSystemVPSComponentEvo;

class ParkingSystemVPSComponentEvo$1
extends AbstractParkingFocusPropertyDecorator {
    private final /* synthetic */ ParkingSystemVPSComponentEvo this$0;

    ParkingSystemVPSComponentEvo$1(ParkingSystemVPSComponentEvo parkingSystemVPSComponentEvo, IParkingFocusPropertyConfig iParkingFocusPropertyConfig) {
        this.this$0 = parkingSystemVPSComponentEvo;
        super(iParkingFocusPropertyConfig);
    }

    @Override
    protected ParkingFocusPropertyCollection prepareFocusProperties(ParkingFocusPropertyCollection parkingFocusPropertyCollection) {
        if (this.this$0.getCurrentVPSView() == 1) {
            this.this$0.getLogChannel().log(-2137614336, "[AbstractParkingFocusPropertyDecorator] VPS FocusPropertyDecorator adds property FOCUS_EARLY_APPS_REARVIEW_IN_ANZEIGE('%1').", -221000551L);
            parkingFocusPropertyCollection.addFocusProperty(-1714629646);
        } else if (this.this$0.getCurrentVPSView() == 4) {
            this.this$0.getLogChannel().log(-2137614336, "[AbstractParkingFocusPropertyDecorator] VPS FocusPropertyDecorator adds property FOCUS_EARLY_APPS_DRAUFSICHT_IN_ANZEIGE('%1').", -831752975L);
            parkingFocusPropertyCollection.addFocusProperty(-244028210);
        }
        return parkingFocusPropertyCollection;
    }
}

