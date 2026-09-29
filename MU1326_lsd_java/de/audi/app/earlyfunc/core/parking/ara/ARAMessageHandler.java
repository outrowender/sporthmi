/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.core.parking.ara;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.earlyfunc.core.parking.IParkingSystemController;
import de.audi.app.earlyfunc.core.parking.ara.IARAMessageHandler;
import de.audi.atip.log.LogChannel;

public class ARAMessageHandler
implements IARAMessageHandler {
    private final ICarApplication application;
    private final IParkingSystemController controller;
    private final LogChannel logChannel;
    private final int defaultMessagePartialPopupID;
    private final int splitscreenCenteredMessagePartialPopupID;
    private int visiblePartialPopupId = -1;
    private int currentMessageID = 0;

    public ARAMessageHandler(ICarApplication iCarApplication, IParkingSystemController iParkingSystemController, LogChannel logChannel, int n, int n2) {
        this.application = iCarApplication;
        this.controller = iParkingSystemController;
        this.logChannel = logChannel;
        this.defaultMessagePartialPopupID = n;
        this.splitscreenCenteredMessagePartialPopupID = n2;
    }

    @Override
    public void init() {
    }

    @Override
    public void deinit() {
    }

    @Override
    public void showMessage(int n) {
        this.logChannel.log(1078071040, "[ARAMessageHandler#showMessage] id='%1'", (long)n);
        this.currentMessageID = n;
        int n2 = this.getPartialPopupID(n);
        if (-1 != this.visiblePartialPopupId && (n == 0 || this.visiblePartialPopupId != n2)) {
            this.application.getFrameworkAccess().getHmiServiceApp().removePartialPopup(0, this.visiblePartialPopupId);
            this.visiblePartialPopupId = -1;
        }
        if (n != 0) {
            this.application.getFrameworkAccess().getHmiServiceApp().getChoiceModel(-854908928).setValue(n);
        }
        if (n > 0) {
            this.visiblePartialPopupId = n2;
            this.application.getFrameworkAccess().getHmiServiceApp().showPartialPopup(0, n2);
        }
    }

    @Override
    public void updateMessage() {
        this.logChannel.log(1078071040, "[ARAMessageHandler#updateMessage] called.");
        if (0 != this.currentMessageID) {
            this.showMessage(this.currentMessageID);
        }
    }

    private int getPartialPopupID(int n) {
        boolean bl = this.controller.getOPSViewModeHandler().isOpsActive();
        return bl ? this.splitscreenCenteredMessagePartialPopupID : this.defaultMessagePartialPopupID;
    }
}

