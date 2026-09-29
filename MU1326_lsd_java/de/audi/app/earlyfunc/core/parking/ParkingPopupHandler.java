/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.core.parking;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.common.screenstate.IPopupStateListener;
import de.audi.app.earlyfunc.core.parking.AbstractParkingSystemControllerComponent;
import de.audi.app.earlyfunc.core.parking.IParkingPopupHandler;
import de.audi.app.earlyfunc.core.parking.IParkingSystemController;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.carparkingsystem.DisplayContent;

public class ParkingPopupHandler
implements IPopupStateListener,
IParkingPopupHandler {
    private static final short NO_REQUEST;
    private static final short POPUP_NONE;
    private final ICarApplication application;
    private final IParkingSystemController parkingSystemController;
    private final LogChannel logChannel;
    private volatile int requestedPopup = -2;
    private volatile int currentVisiblePopup = -1;
    private static final short REMOVE_REASON_NONE;
    private static final short REMOVE_REASON_CANCELED_BY_FSG;
    private static final short REMOVE_REASON_CANCELED_BY_ASG;
    private volatile short removeReason = 0;
    private final Object mutex = AbstractParkingSystemControllerComponent.getParkingMutex();

    public ParkingPopupHandler(ICarApplication iCarApplication, IParkingSystemController iParkingSystemController, LogChannel logChannel) {
        this.application = iCarApplication;
        this.parkingSystemController = iParkingSystemController;
        this.logChannel = logChannel;
    }

    @Override
    public void registerPopup(int n) {
        this.application.getScreenStateDispatcher().addPopupStateListener(n, this);
    }

    @Override
    public void unregisterPopup(int n) {
        this.application.getScreenStateDispatcher().removePopupStateListener(n, this);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void showPopup(int n) {
        this.logChannel.log(-2137614336, "[ParkingPopupHandler#showPopup] popupID=%1", (long)n);
        Object object = this.mutex;
        synchronized (object) {
            if (this.currentVisiblePopup == n && this.requestedPopup != -1) {
                this.logChannel.log(-2137614336, "[ParkingPopupHandler#showPopup] popup with id=%1 is already visible", (long)n);
            } else if (this.requestedPopup == n) {
                this.logChannel.log(-2137614336, "[ParkingPopupHandler#showPopup] popup with id=%1 is already requested", (long)n);
            } else {
                this.requestedPopup = n;
                this.logChannel.log(-2137614336, "[ParkingPopupHandler#showPopup] request popup at HMIService");
                this.application.getFrameworkAccess().getHmiServiceApp().showPopup(n);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void removeCurrentPopup(int n) {
        this.logChannel.log(-2137614336, "[ParkingPopupHandler#removeCurrentPopup] cancelReason=%1, currentVisiblePopup=%2, requestedPopup=%3", (long)n, (long)this.currentVisiblePopup, (long)this.requestedPopup);
        Object object = this.mutex;
        synchronized (object) {
            short s;
            short s2 = s = n == 0 ? (short)1 : 2;
            if (this.requestedPopup > -1) {
                this.removePopup(this.requestedPopup, s);
            } else if (this.currentVisiblePopup != -1) {
                this.removePopup(this.currentVisiblePopup, s);
            } else {
                this.logChannel.log(-2137614336, "[ParkingPopupHandler#removeCurrentPopup] no popup visible or requested");
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean isPopupActive() {
        Object object = this.mutex;
        synchronized (object) {
            return this.currentVisiblePopup != -1 || this.requestedPopup > -1;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void removePopup(int n, short s) {
        this.logChannel.log(1078071040, "[ParkingPopupHandler#removePopup] id=%1, reason=%2", (long)n, (long)s);
        Object object = this.mutex;
        synchronized (object) {
            this.removeReason = s;
            this.logChannel.log(-2137614336, "[ParkingPopupHandler#removePopup] remove popup at HMIService");
            this.application.getFrameworkAccess().getHmiServiceApp().removePopup(n);
            this.requestedPopup = -1;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void notifyPopupVisible(int n) {
        this.logChannel.log(1078071040, "[ParkingPopupHandler#notifyPopupVisible] id='%1'", (long)n);
        Object object = this.mutex;
        synchronized (object) {
            this.currentVisiblePopup = n;
            if (n == this.requestedPopup) {
                this.requestedPopup = -2;
            } else {
                this.logChannel.log(10000, "[ParkingPopupHandler#notifyPopupVisible] popup with ID was not requested");
            }
            this.parkingSystemController.notifyPopupVisible(n);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void notifyPopupHidden(int n) {
        this.logChannel.log(1078071040, "[ParkingPopupHandler#notifyPopupHidden] popupID=%1", (long)n);
        boolean bl = false;
        Object object = this.mutex;
        synchronized (object) {
            if (this.requestedPopup == n) {
                if (!this.parkingSystemController.isStandbyPopupVisible() && this.parkingSystemController.notifyPopupHidden(n)) {
                    bl = true;
                    this.requestedPopup = -1;
                    this.removePopup(n, (short)0);
                }
            } else if (this.currentVisiblePopup == n && this.removeReason == 0 && this.parkingSystemController.notifyPopupHidden(n)) {
                this.removePopup(n, (short)2);
            }
        }
        if (bl) {
            this.parkingSystemController.changeDisplayContent(new DisplayContent());
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void notifyPopupRemoved(int n) {
        int n2;
        this.logChannel.log(1078071040, "[ParkingPopupHandler#notifyPopupRemoved] id='%1'", (long)n);
        boolean bl = true;
        Object object = this.mutex;
        synchronized (object) {
            int n3 = n2 = this.removeReason == 1 ? 0 : 1;
            if (n == this.currentVisiblePopup) {
                this.currentVisiblePopup = -1;
                this.removeReason = 0;
                this.logChannel.log(1078071040, "[ParkingPopupHandler#notifyPopupRemoved] currentVisiblePopup='%1'", (long)this.currentVisiblePopup);
            } else if (n == this.requestedPopup) {
                this.requestedPopup = -2;
                this.removeReason = 0;
                this.logChannel.log(1078071040, "[ParkingPopupHandler#notifyPopupRemoved] requestedPopup='%1'", (long)this.requestedPopup);
            } else {
                bl = false;
                this.logChannel.log(1078071040, "[ParkingPopupHandler#notifyPopupRemoved] currentVisiblePopup='%1' requestedPopup='%2'", (long)this.currentVisiblePopup, (long)this.requestedPopup);
            }
        }
        if (bl) {
            this.parkingSystemController.notifyPopupCanceled(n2);
        }
    }
}

