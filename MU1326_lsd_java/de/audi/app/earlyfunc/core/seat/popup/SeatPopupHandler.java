/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.core.seat.popup;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.common.screenstate.IPopupStateListener;
import de.audi.app.earlyfunc.core.seat.AbstractSeatPopupFactory;
import de.audi.app.earlyfunc.core.seat.ISeatPopupHandler;
import de.audi.app.earlyfunc.core.seat.ISeatPopupHandlerController;
import de.audi.atip.log.LogChannel;

public class SeatPopupHandler
implements ISeatPopupHandler,
IPopupStateListener {
    private final ICarApplication application;
    private ISeatPopupHandlerController seatPopupHandlerController;
    private final LogChannel logChannel;
    private int[] popupIDsForCallbacks;

    public SeatPopupHandler(ISeatPopupHandlerController iSeatPopupHandlerController, AbstractSeatPopupFactory abstractSeatPopupFactory) {
        this.application = abstractSeatPopupFactory.getApplication();
        this.logChannel = abstractSeatPopupFactory.getLogChannel();
        this.seatPopupHandlerController = iSeatPopupHandlerController;
    }

    @Override
    public void hideSeatPopup(int n) {
        this.logPopupStateChange("hideSeatPopup]", n);
        this.application.getFrameworkAccess().getHmiServiceApp().removePopup(n);
    }

    @Override
    public void showSeatPopup(int n) {
        this.logPopupStateChange("showSeatPopup]", n);
        this.application.getFrameworkAccess().getHmiServiceApp().showPopup(n);
    }

    @Override
    public void init(int[] nArray) {
        if (nArray != null) {
            this.popupIDsForCallbacks = nArray;
            for (int i2 = 0; i2 < nArray.length; ++i2) {
                this.logPopupStateChange("init] register as PopupStateListener:", nArray[i2]);
                this.application.getScreenStateDispatcher().addPopupStateListener(nArray[i2], this);
            }
        }
    }

    @Override
    public void deinit() {
        if (this.popupIDsForCallbacks != null) {
            for (int i2 = 0; i2 < this.popupIDsForCallbacks.length; ++i2) {
                this.logPopupStateChange("deinit] remove registration as PopupStateListener:", this.popupIDsForCallbacks[i2]);
                this.application.getScreenStateDispatcher().removePopupStateListener(this.popupIDsForCallbacks[i2], this);
            }
        }
    }

    @Override
    public void notifyPopupVisible(int n) {
        this.logPopupStateChange("notifyPopupVisible]", n);
        this.seatPopupHandlerController.notifySeatPopupVisible(n);
    }

    @Override
    public void notifyPopupHidden(int n) {
        this.logPopupStateChange("notifyPopupHidden]", n);
        this.seatPopupHandlerController.notifySeatPopupHidden(n);
    }

    @Override
    public void notifyPopupRemoved(int n) {
        this.logPopupStateChange("notifyPopupRemoved]", n);
        this.seatPopupHandlerController.notifySeatPopupRemoved(n);
    }

    private void logPopupStateChange(String string, int n) {
        if (this.logChannel.isInfo()) {
            this.logChannel.log(1078071040, "[SeatPopupHandler#%1 popupID=%2", (Object)string, (long)n);
        }
    }
}

