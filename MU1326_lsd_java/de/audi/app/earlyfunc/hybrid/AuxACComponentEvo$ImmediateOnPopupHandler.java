/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.hybrid;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.common.service.CarServiceProvider;
import de.audi.app.earlyfunc.hybrid.AuxACComponentEvo;
import de.audi.atip.hmi.view.IPartialPopupListener;
import de.audi.atip.log.LogChannel;

class AuxACComponentEvo$ImmediateOnPopupHandler
implements IPartialPopupListener {
    public static final int POPUP_INVALID;
    private int popupID = -1;
    private CarServiceProvider partialPopupServiceProvider;
    private final ICarApplication application;
    private final LogChannel logChannel;
    private volatile boolean popupVisible = false;
    private final Object mutex = new Object();
    private final /* synthetic */ AuxACComponentEvo this$0;

    public AuxACComponentEvo$ImmediateOnPopupHandler(AuxACComponentEvo auxACComponentEvo, ICarApplication iCarApplication, LogChannel logChannel, int n) {
        this.this$0 = auxACComponentEvo;
        this.application = iCarApplication;
        this.logChannel = logChannel;
        this.popupID = n;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void showPopup() {
        if (this.popupID == -1) {
            this.logChannel.log(10000, "[ImmediateOnPopupHandler#showPopup] No popup defined for config=%1", (long)AuxACComponentEvo.access$000(this.this$0));
        } else {
            Object object = this.mutex;
            synchronized (object) {
                if (!this.popupVisible) {
                    this.application.getFrameworkAccess().getHMIService().showPartialPopup(0, this.popupID);
                    this.logChannel.log(1078071040, "[ImmediateOnPopupHandler#showPopup] Requesting popup at HMI Service");
                } else {
                    this.logChannel.log(1078071040, "[ImmediateOnPopupHandler#showPopup] Cannot request popup - already visible");
                }
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void removePopup() {
        Object object = this.mutex;
        synchronized (object) {
            if (this.popupVisible) {
                this.application.getFrameworkAccess().getHMIService().removePartialPopup(0, this.popupID);
                this.logChannel.log(1078071040, "[ImmediateOnPopupHandler#removePopup] Removing popup from HMI Service");
            } else {
                this.logChannel.log(1078071040, "[ImmediateOnPopupHandler#removePopup] Cannot remove popup - not visible");
            }
        }
    }

    public void initServiceProvider() {
        this.partialPopupServiceProvider = new CarServiceProvider((AuxACComponentEvo.class$de$audi$atip$hmi$view$IPartialPopupListener == null ? (AuxACComponentEvo.class$de$audi$atip$hmi$view$IPartialPopupListener = AuxACComponentEvo.class$("de.audi.atip.hmi.view.IPartialPopupListener")) : AuxACComponentEvo.class$de$audi$atip$hmi$view$IPartialPopupListener).getName(), this, null, this.application.getBundleContext(), this.logChannel);
        this.partialPopupServiceProvider.startService();
        this.logChannel.log(1078071040, "[ParkingPartialPopupHandler#initServiceProvider] Service provider initialized");
    }

    public void deinitServiceProvider() {
        this.partialPopupServiceProvider.stopService();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void partialPopupVisible(int n, int n2) {
        this.logChannel.log(1078071040, "[ImmediateOnPopupHandler#partialPopupVisible] partialPopupID = %1", (long)n);
        Object object = this.mutex;
        synchronized (object) {
            this.popupVisible = true;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void partialPopupHidden(int n, int n2) {
        this.logChannel.log(1078071040, "[ImmediateOnPopupHandler#partialPopupHidden] partialPopupID = %1", (long)n);
        Object object = this.mutex;
        synchronized (object) {
            if (this.popupVisible) {
                this.popupVisible = false;
                this.application.getFrameworkAccess().getHMIService().removePartialPopup(0, n);
            }
        }
    }

    @Override
    public void partialPopupRemoved(int n, int n2) {
        this.logChannel.log(1078071040, "[ImmediateOnPopupHandler#partialPopupRemoved] partialPopupID = %1", (long)n);
    }

    @Override
    public int[] getPPIDsForCallbacks() {
        return new int[]{this.popupID};
    }

    @Override
    public void partialPopupListenerRegistered(int n, int n2, boolean bl) {
    }

    @Override
    public void informAboutPPCoordinates(int n, int n2, int n3, int n4, int n5, int n6) {
    }
}

