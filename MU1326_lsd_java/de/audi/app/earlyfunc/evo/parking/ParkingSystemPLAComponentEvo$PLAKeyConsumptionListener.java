/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.evo.parking;

import de.audi.app.earlyfunc.evo.parking.ParkingSystemPLAComponentEvo;
import de.audi.atip.hmi.event.KeyEvent;
import de.audi.atip.hmi.view.IPopupKeyConsumptionListener;

final class ParkingSystemPLAComponentEvo$PLAKeyConsumptionListener
implements IPopupKeyConsumptionListener {
    private final boolean prohibited;
    private final /* synthetic */ ParkingSystemPLAComponentEvo this$0;

    public ParkingSystemPLAComponentEvo$PLAKeyConsumptionListener(ParkingSystemPLAComponentEvo parkingSystemPLAComponentEvo, boolean bl) {
        this.this$0 = parkingSystemPLAComponentEvo;
        this.prohibited = bl;
    }

    @Override
    public void hKPressed(boolean bl, int n) {
        if (this.this$0.getLogChannel().isDebug()) {
            this.this$0.getLogChannel().log(-2137614336, "[PLAKeyConsumptionListener#hKPressed] keyCode='%2', consumed='%1', ", bl, (long)n);
        }
        if (bl) {
            if (this.prohibited) {
                if (this.this$0.getLogChannel().isDebug()) {
                    this.this$0.getLogChannel().log(-2137614336, "[PLAKeyConsumptionListener#hKPressed] User interaction prohibited = 'true'");
                }
            } else {
                boolean bl2;
                if (this.this$0.getLogChannel().isDebug()) {
                    this.this$0.getLogChannel().log(-2137614336, "[PLAKeyConsumptionListener#hKPressed] User interaction prohibited = 'false'");
                }
                if (!(bl2 = KeyEvent.isAppChangeHardkey(n))) {
                    switch (n) {
                        case 15: {
                            bl2 = true;
                            break;
                        }
                    }
                }
                if (bl2) {
                    this.this$0.canceledByHMI();
                }
            }
        }
    }
}

