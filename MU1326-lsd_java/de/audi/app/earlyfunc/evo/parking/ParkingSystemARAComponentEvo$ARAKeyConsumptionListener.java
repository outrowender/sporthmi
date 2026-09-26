/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.evo.parking;

import de.audi.app.earlyfunc.evo.parking.ParkingSystemARAComponentEvo;
import de.audi.app.earlyfunc.evo.parking.ParkingSystemARAComponentEvo$1;
import de.audi.atip.hmi.view.IPopupKeyConsumptionListener;

final class ParkingSystemARAComponentEvo$ARAKeyConsumptionListener
implements IPopupKeyConsumptionListener {
    private final /* synthetic */ ParkingSystemARAComponentEvo this$0;

    private ParkingSystemARAComponentEvo$ARAKeyConsumptionListener(ParkingSystemARAComponentEvo parkingSystemARAComponentEvo) {
        this.this$0 = parkingSystemARAComponentEvo;
    }

    @Override
    public void hKPressed(boolean bl, int n) {
        if (this.this$0.getLogChannel().isDebug()) {
            this.this$0.getLogChannel().log(-2137614336, "[ARAKeyConsumptionListener#hKPressed] keyCode='%2', consumed='%1', ", bl, (long)n);
        }
        if (bl) {
            if (this.this$0.getLogChannel().isDebug()) {
                this.this$0.getLogChannel().log(-2137614336, "[ARAKeyConsumptionListener#hKPressed] User interaction prohibited = 'true'");
            }
        } else if (this.this$0.getLogChannel().isDebug()) {
            this.this$0.getLogChannel().log(-2137614336, "[ARAKeyConsumptionListener#hKPressed] User interaction prohibited = 'false'");
        }
    }

    /* synthetic */ ParkingSystemARAComponentEvo$ARAKeyConsumptionListener(ParkingSystemARAComponentEvo parkingSystemARAComponentEvo, ParkingSystemARAComponentEvo$1 parkingSystemARAComponentEvo$1) {
        this(parkingSystemARAComponentEvo);
    }
}

