/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.core.parking;

import de.audi.app.earlyfunc.core.parking.AbstractParkingSystemControllerComponent;
import de.audi.app.earlyfunc.core.parking.AbstractParkingSystemControllerComponent$1;
import de.audi.app.earlyfunc.core.parking.AbstractParkingSystemControllerComponent$JokerKeyButtonListener;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.msg.MsgListener;

class AbstractParkingSystemControllerComponent$LocalMsgListener
implements MsgListener {
    private final /* synthetic */ AbstractParkingSystemControllerComponent this$0;

    private AbstractParkingSystemControllerComponent$LocalMsgListener(AbstractParkingSystemControllerComponent abstractParkingSystemControllerComponent) {
        this.this$0 = abstractParkingSystemControllerComponent;
    }

    @Override
    public void processMsg(int n) {
        ButtonModelApp buttonModelApp;
        if (2 == n && this.this$0.getLogChannel().isInfo()) {
            this.this$0.getLogChannel().log(1078071040, "[AbstractParkingSystemControllerComponent.ParkingSystemMsgListener#processMsg] STARTUP_SHOWFIRSTSCREEN");
        }
        if (79 == n && 60 == AbstractParkingSystemControllerComponent.access$1100(this.this$0, 395).getValue() && null != (buttonModelApp = AbstractParkingSystemControllerComponent.access$1200(this.this$0, -1859450624))) {
            buttonModelApp.setButtonListener(new AbstractParkingSystemControllerComponent$JokerKeyButtonListener(this.this$0, null));
        }
    }

    /* synthetic */ AbstractParkingSystemControllerComponent$LocalMsgListener(AbstractParkingSystemControllerComponent abstractParkingSystemControllerComponent, AbstractParkingSystemControllerComponent$1 abstractParkingSystemControllerComponent$1) {
        this(abstractParkingSystemControllerComponent);
    }
}

