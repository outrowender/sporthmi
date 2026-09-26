/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.core.parking;

import de.audi.app.earlyfunc.core.parking.AbstractParkingSystemControllerComponent;
import de.audi.app.earlyfunc.core.parking.AbstractParkingSystemControllerComponent$1;
import de.audi.atip.hmi.model.DefaultButtonListener;

class AbstractParkingSystemControllerComponent$JokerKeyButtonListener
extends DefaultButtonListener {
    private final /* synthetic */ AbstractParkingSystemControllerComponent this$0;

    private AbstractParkingSystemControllerComponent$JokerKeyButtonListener(AbstractParkingSystemControllerComponent abstractParkingSystemControllerComponent) {
        this.this$0 = abstractParkingSystemControllerComponent;
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
        switch (n) {
            case 600977: {
                AbstractParkingSystemControllerComponent.access$1400(this.this$0, "keyPressed", n, n2, true);
                break;
            }
            default: {
                AbstractParkingSystemControllerComponent.access$1500(this.this$0, "keyPressed", n, n2, false);
            }
        }
    }

    @Override
    public void keyReleased(int n, int n2, int n3) {
        if (-1859450624 == n) {
            int n4 = AbstractParkingSystemControllerComponent.access$1600(this.this$0, 395).getValue();
            switch (n4) {
                case 60: {
                    this.this$0.parkingSoftkeyPressed();
                    break;
                }
                default: {
                    AbstractParkingSystemControllerComponent.access$1700(this.this$0, "keyReleased", n, n2, false);
                    break;
                }
            }
        } else {
            AbstractParkingSystemControllerComponent.access$1800(this.this$0, "keyReleased", n, n2, false);
        }
    }

    /* synthetic */ AbstractParkingSystemControllerComponent$JokerKeyButtonListener(AbstractParkingSystemControllerComponent abstractParkingSystemControllerComponent, AbstractParkingSystemControllerComponent$1 abstractParkingSystemControllerComponent$1) {
        this(abstractParkingSystemControllerComponent);
    }
}

