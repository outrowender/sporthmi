/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.core.seat.popin;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.common.service.CarServiceProvider;
import de.audi.app.earlyfunc.core.seat.AbstractSeatPopupFactory;
import de.audi.app.earlyfunc.core.seat.ISeatPopupHandler;
import de.audi.app.earlyfunc.core.seat.ISeatPopupHandlerController;
import de.audi.atip.hmi.view.IPartialPopupListener;
import de.audi.atip.log.LogChannel;

public class SeatPopinHandler
implements IPartialPopupListener,
ISeatPopupHandler {
    private final ICarApplication application;
    private CarServiceProvider partialPopinServiceProvider;
    private static final int terminalID = 0;
    private ISeatPopupHandlerController seatPopupHandlerController;
    private final LogChannel logChannel;
    private int[] popinIDsForCallbacks;
    static /* synthetic */ Class class$de$audi$atip$hmi$view$IPartialPopupListener;

    public SeatPopinHandler(ISeatPopupHandlerController iSeatPopupHandlerController, AbstractSeatPopupFactory abstractSeatPopupFactory) {
        this.application = abstractSeatPopupFactory.getApplication();
        this.logChannel = abstractSeatPopupFactory.getLogChannel();
        this.seatPopupHandlerController = iSeatPopupHandlerController;
    }

    public void init(int[] nArray) {
        this.initServiceProvider(nArray);
    }

    public void deinit() {
        this.deinitServiceProvider();
    }

    public void showSeatPopup(int n) {
        this.showPartialPopin(n);
    }

    public void hideSeatPopup(int n) {
        this.hidePartialPopin(n);
    }

    private void showPartialPopin(int n) {
        this.logPartialPopinStateChange("showPartialPopin", n);
        this.application.getFrameworkAccess().getHmiServiceApp().showPartialPopup(0, n);
    }

    private void hidePartialPopin(int n) {
        this.logPartialPopinStateChange("hidePartialPopin", n);
        this.application.getFrameworkAccess().getHmiServiceApp().removePartialPopup(0, n);
    }

    public void replacePartialPopin(int n, int n2) {
        this.logPartialPopinStateChange("replacePartialPopin", n);
        this.application.getFrameworkAccess().getHMIService().replacePartialPopup(0, n, n2);
    }

    public void hideAllSeatPartialPopins() {
        for (int i2 = 0; i2 < this.popinIDsForCallbacks.length; ++i2) {
            this.hideSeatPopup(this.popinIDsForCallbacks[i2]);
        }
    }

    public void partialPopupVisible(int n, int n2) {
        this.logPartialPopinStateChange("partialPopupVisible", n);
        this.seatPopupHandlerController.notifySeatPopupVisible(n);
    }

    public void partialPopupHidden(int n, int n2) {
        this.logPartialPopinStateChange("partialPopupHidden", n);
        this.seatPopupHandlerController.notifySeatPopupHidden(n);
    }

    public int[] getPPIDsForCallbacks() {
        this.seatPopupHandlerController.setSeatPopinListenerServiceTracked(true);
        if (this.popinIDsForCallbacks == null) {
            return new int[0];
        }
        this.logChannel.log(1000000, "[SeatPopinHandler#getPPIDsForCallbacks] popinID1='%1' , popinID2='%2' , popinID3='%3' , popinID4='%4'", (Object)new Integer(this.popinIDsForCallbacks[0]), (Object)new Integer(this.popinIDsForCallbacks[1]), (Object)new Integer(this.popinIDsForCallbacks[2]), (Object)new Integer(this.popinIDsForCallbacks[3]));
        return this.popinIDsForCallbacks;
    }

    private void initServiceProvider(int[] nArray) {
        this.logChannel.log(1000000, "[SeatPopinHandler#initServiceProvider] popinID1='%1' , popinID2='%2' , popinID3='%3' , popinID4='%4'", (Object)new Integer(nArray[0]), (Object)new Integer(nArray[1]), (Object)new Integer(nArray[2]), (Object)new Integer(nArray[3]));
        this.popinIDsForCallbacks = nArray;
        this.partialPopinServiceProvider = new CarServiceProvider((class$de$audi$atip$hmi$view$IPartialPopupListener == null ? (class$de$audi$atip$hmi$view$IPartialPopupListener = SeatPopinHandler.class$("de.audi.atip.hmi.view.IPartialPopupListener")) : class$de$audi$atip$hmi$view$IPartialPopupListener).getName(), this, null, this.application.getBundleContext(), this.logChannel);
        this.logChannel.log(1000000, "[SeatPopinHandler#initServiceProvider] start IPartialPopupListener Service");
        this.partialPopinServiceProvider.startService();
    }

    private void deinitServiceProvider() {
        this.partialPopinServiceProvider.stopService();
    }

    private void logPartialPopinStateChange(String string, int n) {
        if (this.logChannel.isInfo()) {
            this.logChannel.log(1000000, "[SeatPopinHandler#%1] partialPopinID=%2, terminalID=%3", (Object)string, (long)n, 0L);
        }
    }

    public void partialPopupRemoved(int n, int n2) {
        this.logPartialPopinStateChange("partialPopupRemoved", n);
    }

    public void partialPopupListenerRegistered(int n, int n2, boolean bl) {
    }

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

