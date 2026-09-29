/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.core.parking;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.common.service.CarServiceProvider;
import de.audi.app.earlyfunc.core.parking.AbstractParkingSystemControllerComponent;
import de.audi.app.earlyfunc.core.parking.IParkingPopupHandler;
import de.audi.app.earlyfunc.core.parking.IParkingSystemController;
import de.audi.atip.hmi.view.IPartialPopupListener;
import de.audi.atip.log.LogChannel;
import java.util.ArrayList;
import java.util.List;

public class ParkingPartialPopupHandler
implements IParkingPopupHandler,
IPartialPopupListener {
    private CarServiceProvider partialPopupServiceProvider;
    private final ICarApplication application;
    private final LogChannel logChannel;
    private final IParkingSystemController parkingSystemController;
    private List registeredPopupIDs;
    private volatile int visiblePPID;
    private volatile int removeReason = 1;
    private final Object mutex = AbstractParkingSystemControllerComponent.getParkingMutex();
    static /* synthetic */ Class class$de$audi$atip$hmi$view$IPartialPopupListener;

    public ParkingPartialPopupHandler(ICarApplication iCarApplication, IParkingSystemController iParkingSystemController, LogChannel logChannel) {
        this.application = iCarApplication;
        this.parkingSystemController = iParkingSystemController;
        this.logChannel = logChannel;
        this.registeredPopupIDs = new ArrayList();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void registerPopup(int n) {
        Object object = this.mutex;
        synchronized (object) {
            if (!this.registeredPopupIDs.contains(new Integer(n))) {
                this.registeredPopupIDs.add(new Integer(n));
                this.partialPopupServiceProvider.stopService();
                this.partialPopupServiceProvider.startService();
                this.logChannel.log(1078071040, "[ParkingPartialPopupHandler#registerPopup] StartStop finished on the ServiceProvider");
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void unregisterPopup(int n) {
        Object object = this.mutex;
        synchronized (object) {
            this.registeredPopupIDs.remove(new Integer(n));
            this.partialPopupServiceProvider.stopService();
            this.partialPopupServiceProvider.startService();
            this.logChannel.log(1078071040, "[ParkingPartialPopupHandler#unregisterPopup] StartStop finished on the ServiceProvider");
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void showPopup(int n) {
        Object object = this.mutex;
        synchronized (object) {
            if (this.registeredPopupIDs.contains(new Integer(n))) {
                if (this.visiblePPID == n) {
                    this.logChannel.log(1078071040, "[ParkingPartialPopupHandler#showPopup] popupID=%1 already visible", (long)n);
                } else {
                    this.logChannel.log(1078071040, "[ParkingPartialPopupHandler#showPopup] popupID=%1", (long)n);
                    this.application.getFrameworkAccess().getHMIService().showPartialPopup(0, n);
                }
            } else {
                this.logChannel.log(10000, "[ParkingPartialPopupHandler#showPopup] popup with ID=%1 not registered", (long)n);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void removeCurrentPopup(int n) {
        Object object = this.mutex;
        synchronized (object) {
            if (this.isPopupActive()) {
                this.logChannel.log(-2137614336, "[ParkingPartialPopupHandler#removeCurrentPopup] cancelReason=%1", (long)n);
                this.removeReason = n;
                this.hidePartialPopup(this.visiblePPID);
            } else {
                this.logChannel.log(-2137614336, "[ParkingPartialPopupHandler#removeCurrentPopup] no popup active");
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void hidePartialPopup(int n) {
        Object object = this.mutex;
        synchronized (object) {
            this.logChannel.log(1078071040, "[ParkingPartialPopupHandler#hidePartialPopup] popupID=%1", (long)n);
            this.visiblePPID = -1;
            this.application.getFrameworkAccess().getHMIService().removePartialPopup(0, n);
        }
    }

    public void initServiceProvider() {
        this.partialPopupServiceProvider = new CarServiceProvider((class$de$audi$atip$hmi$view$IPartialPopupListener == null ? (class$de$audi$atip$hmi$view$IPartialPopupListener = ParkingPartialPopupHandler.class$("de.audi.atip.hmi.view.IPartialPopupListener")) : class$de$audi$atip$hmi$view$IPartialPopupListener).getName(), this, null, this.application.getBundleContext(), this.logChannel);
        this.partialPopupServiceProvider.startService();
        this.logChannel.log(1078071040, "[ParkingPartialPopupHandler#initServiceProvider] Service provider initialized");
    }

    public void deinitServiceProvider() {
        this.partialPopupServiceProvider.stopService();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void hidePartialPopup(int n, boolean bl) {
        Object object = this.mutex;
        synchronized (object) {
            this.logChannel.log(1078071040, "[ParkingPartialPopupHandler#hidePartialPopup] popupID=%1 , cancelAfterHidden=%2", (Object)new Integer(n), (Object)bl);
            if (!bl) {
                this.visiblePPID = -1;
            }
            this.application.getFrameworkAccess().getHMIService().removePartialPopup(0, n);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean isPopupActive() {
        Object object = this.mutex;
        synchronized (object) {
            return this.visiblePPID > 0;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void partialPopupVisible(int n, int n2) {
        Object object = this.mutex;
        synchronized (object) {
            this.logChannel.log(1078071040, "[ParkingPartialPopupHandler#partialPopupVisible] partialPopupID=%1, terminalID=%2", (long)n, (long)n2);
            this.visiblePPID = n;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void partialPopupHidden(int n, int n2) {
        boolean bl = false;
        Object object = this.mutex;
        synchronized (object) {
            this.logChannel.log(1078071040, "[ParkingPartialPopupHandler#partialPopupHidden] partialPopupID=%1, terminalID=%2", (long)n, (long)n2);
            if (this.isPopupActive()) {
                this.visiblePPID = -1;
                this.removeReason = 1;
                bl = true;
            }
        }
        if (bl) {
            this.parkingSystemController.notifyPartialPopupCanceled(this.removeReason);
        }
    }

    @Override
    public int[] getPPIDsForCallbacks() {
        int[] nArray = new int[this.registeredPopupIDs.size()];
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            nArray[i2] = (Integer)this.registeredPopupIDs.get(i2);
        }
        return nArray;
    }

    @Override
    public void partialPopupRemoved(int n, int n2) {
    }

    @Override
    public void partialPopupListenerRegistered(int n, int n2, boolean bl) {
        this.logChannel.log(1078071040, "[ParkingPartialPopupHandler#partialPopupRegistered] partialPopupID=%1, terminalID=%2, visible=%3", (long)n, (long)n2, bl);
        if (bl) {
            this.partialPopupVisible(n, n2);
        } else {
            this.partialPopupHidden(n, n2);
        }
    }

    @Override
    public void informAboutPPCoordinates(int n, int n2, int n3, int n4, int n5, int n6) {
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

