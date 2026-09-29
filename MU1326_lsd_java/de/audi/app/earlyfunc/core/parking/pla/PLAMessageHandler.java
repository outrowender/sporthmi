/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.core.parking.pla;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.earlyfunc.core.parking.IParkingSystemController;
import de.audi.app.earlyfunc.core.parking.pla.AbstractParkingSystemPLAComponent;
import de.audi.app.earlyfunc.core.parking.pla.IPLAMessageHandler;
import de.audi.atip.log.LogChannel;

public class PLAMessageHandler
implements IPLAMessageHandler {
    private static final int[] SINGLE_LINE_MESSAGES = new int[]{18, 33, 34, 35};
    private final ICarApplication application;
    private final AbstractParkingSystemPLAComponent plaComponent;
    private final IParkingSystemController controller;
    private final LogChannel logChannel;
    private final int defaultMessagePartialPopupID;
    private final int splitscreenCenteredMessagePartialPopupID;
    private final int singleLineMessagePartialPopupID;
    private final int opsStandaloneLeftMessagePartialPopupID;
    private final int opsStandaloneRightMessagePartialPopupID;
    private final int startParkOutMessagePartialPopupID;
    private int visiblePartialPopupId = -1;
    private int currentMessageID = 0;
    private int plaOpsStandaloneState = 0;

    public PLAMessageHandler(ICarApplication iCarApplication, IParkingSystemController iParkingSystemController, AbstractParkingSystemPLAComponent abstractParkingSystemPLAComponent, LogChannel logChannel, int n, int n2, int n3, int n4, int n5, int n6) {
        this.application = iCarApplication;
        this.controller = iParkingSystemController;
        this.plaComponent = abstractParkingSystemPLAComponent;
        this.logChannel = logChannel;
        this.defaultMessagePartialPopupID = n;
        this.splitscreenCenteredMessagePartialPopupID = n2;
        this.singleLineMessagePartialPopupID = n3;
        this.opsStandaloneLeftMessagePartialPopupID = n4;
        this.opsStandaloneRightMessagePartialPopupID = n5;
        this.startParkOutMessagePartialPopupID = n6;
    }

    @Override
    public void init() {
    }

    @Override
    public void deinit() {
    }

    @Override
    public void showMessage(int n) {
        if (this.isMessageSupported(n)) {
            this.logChannel.log(1078071040, "[PLAMessageHandler#showMessage] messageID='%1'", (long)n);
            this.currentMessageID = n;
            int n2 = this.getPartialPopupID(n);
            if (-1 != this.visiblePartialPopupId && (n == 0 || this.visiblePartialPopupId != n2)) {
                this.application.getFrameworkAccess().getHmiServiceApp().removePartialPopup(0, this.visiblePartialPopupId);
                this.visiblePartialPopupId = -1;
            }
            if (n != 0) {
                this.application.getFrameworkAccess().getHmiServiceApp().getChoiceModel(-469032960).setValue(n);
            }
            if (n > 0) {
                this.visiblePartialPopupId = n2;
                this.application.getFrameworkAccess().getHmiServiceApp().showPartialPopup(0, n2);
            }
        } else {
            this.logChannel.log(1078071040, "[PLAMessageHandler#showMessage] messageID='%1' rejected - not supported", (long)n);
            if (-1 != this.visiblePartialPopupId) {
                this.application.getFrameworkAccess().getHmiServiceApp().removePartialPopup(0, this.visiblePartialPopupId);
                this.visiblePartialPopupId = -1;
            }
        }
    }

    @Override
    public void updateMessage() {
        this.logChannel.log(1078071040, "[PLAMessageHandler#updateMessage] called.");
        if (0 != this.currentMessageID) {
            this.showMessage(this.currentMessageID);
        }
    }

    @Override
    public void setPlaOpsStandaloneState(int n) {
        this.plaOpsStandaloneState = n;
    }

    private int getPartialPopupID(int n) {
        int n2;
        boolean bl = this.controller.getOPSViewModeHandler().isOpsActive();
        if (16 == n) {
            n2 = this.startParkOutMessagePartialPopupID;
        } else {
            switch (this.plaComponent.getCurrentPlaMode()) {
                case 1: 
                case 2: 
                case 3: 
                case 6: {
                    n2 = this.isSingleLineMessage(n) ? this.singleLineMessagePartialPopupID : this.defaultMessagePartialPopupID;
                    break;
                }
                case 4: 
                case 5: {
                    if (1 == this.plaOpsStandaloneState) {
                        n2 = this.isSingleLineMessage(n) ? this.singleLineMessagePartialPopupID : this.opsStandaloneLeftMessagePartialPopupID;
                        break;
                    }
                    if (2 == this.plaOpsStandaloneState) {
                        n2 = this.isSingleLineMessage(n) ? this.singleLineMessagePartialPopupID : this.opsStandaloneRightMessagePartialPopupID;
                        break;
                    }
                    n2 = this.isSingleLineMessage(n) ? this.singleLineMessagePartialPopupID : (bl ? this.splitscreenCenteredMessagePartialPopupID : this.defaultMessagePartialPopupID);
                    break;
                }
                default: {
                    n2 = this.isSingleLineMessage(n) ? this.singleLineMessagePartialPopupID : (bl ? this.splitscreenCenteredMessagePartialPopupID : this.defaultMessagePartialPopupID);
                }
            }
        }
        return n2;
    }

    private boolean isSingleLineMessage(int n) {
        for (int i2 = 0; i2 < SINGLE_LINE_MESSAGES.length; ++i2) {
            if (n != SINGLE_LINE_MESSAGES[i2]) continue;
            return true;
        }
        return false;
    }

    private boolean isMessageSupported(int n) {
        return n <= 40;
    }
}

