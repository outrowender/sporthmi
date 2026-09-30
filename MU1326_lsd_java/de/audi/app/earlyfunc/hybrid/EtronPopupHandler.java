/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.hybrid;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.common.handler.ButtonModelHandler;
import de.audi.app.car.common.service.CarServiceProvider;
import de.audi.app.earlyfunc.hybrid.EtronComponentEvo;
import de.audi.app.earlyfunc.hybrid.EtronPopupHKTimerController;
import de.audi.atip.hmi.view.IPartialPopupListener;
import de.audi.atip.log.LogChannel;
import java.util.Hashtable;
import org.dsi.ifc.cardrivingcharacteristics.DSICarDrivingCharacteristics;

public class EtronPopupHandler
implements IPartialPopupListener {
    private EtronComponentEvo component;
    private LogChannel logChannel;
    private ICarApplication app;
    private final Object mutex = new Object();
    private EtronPopupHKTimerController popupTimer;
    private boolean isVisible = false;
    private boolean fsgActivation = false;
    private int currentCancelReason = 1;
    private volatile int etronContent = 5;
    private ButtonModelHandler buttonHandler;
    private int currentProfile = -1;
    private static final int terminalID = 0;
    static /* synthetic */ Class class$de$audi$atip$hmi$view$IPartialPopupListener;

    public EtronPopupHandler(ICarApplication iCarApplication, EtronComponentEvo etronComponentEvo, LogChannel logChannel) {
        this.logChannel = logChannel;
        this.app = iCarApplication;
        this.component = etronComponentEvo;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void partialPopupVisible(int n, int n2) {
        this.logChannel.log(1000000, "[EtronPopupHandler#partialPopupVisible] id='%1'", (long)n);
        Object object = this.mutex;
        synchronized (object) {
            if (!this.isVisible) {
                this.component.showCharismaPopup(this.etronContent, this.getActivationReason());
            }
            if (this.isFsgActivation()) {
                this.setFsgActivation(false);
                this.popupTimer.resetActivated();
            } else {
                this.popupTimer.deactivate();
            }
            this.isVisible = true;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void partialPopupHidden(int n, int n2) {
        this.logChannel.log(1000000, "[EtronPopupHandler#partialPopupHidden] id='%1'", (long)n);
        Object object = this.mutex;
        synchronized (object) {
            if (this.isVisible && this.currentProfile == this.etronContent) {
                if (this.logChannel.isInfo()) {
                    this.logChannel.log(1000000, "[EtronPopupHandler#partialPopupHidden]  NOT CALLING DSI.showCharismaPopup(%1, %2) called", 0L, 1L);
                }
                this.removeEtronPopup();
                this.setFsgActivation(false);
                this.popupTimer.deactivate();
            } else if (this.isVisible) {
                this.setFsgActivation(false);
                this.setCurrentCancelReason(0);
                this.isVisible = false;
            } else {
                this.component.showCharismaPopup(0, 1);
            }
        }
    }

    public int[] getPPIDsForCallbacks() {
        return new int[]{this.component.getPopUpID()};
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void partialPopupRemoved(int n, int n2) {
        this.logChannel.log(1000000, "[EtronPopupHandler#partialPopupRemoved] id='%1'", (long)n);
        Object object = this.mutex;
        synchronized (object) {
            if (this.isVisible && this.currentProfile == this.etronContent) {
                this.component.cancelCharismaPopup(this.etronContent, this.getCurrentCancelReason());
                this.setFsgActivation(false);
                this.setCurrentCancelReason(1);
                this.popupTimer.deactivate();
                this.isVisible = false;
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void requestCharismaPopup(int n, boolean bl) {
        if (this.logChannel.isInfo()) {
            this.logChannel.log(1000000, "[EtronPopupHandler#requestCharismaPopup] called with content = %1, fsgActivation=%2", (Object)new Integer(n), (Object)bl);
        }
        Object object = this.mutex;
        synchronized (object) {
            if (n == 0) {
                if (this.isVisible) {
                    this.setCurrentCancelReason(0);
                    if (this.logChannel.isInfo()) {
                        this.logChannel.log(1000000, "[EtronPopupHandler#requestCharismaPopup] removePopup(%1) called", (long)this.component.getPopUpID());
                    }
                    this.app.getFrameworkAccess().getHmiServiceApp().getChoiceModel(2100389).setValue(0);
                }
            } else {
                this.setFsgActivation(bl);
                if (this.logChannel.isInfo()) {
                    this.logChannel.log(1000000, "[EtronPopupHandler#requestCharismaPopup] showPopup(%1)", (long)this.component.getPopUpID());
                }
                this.app.getFrameworkAccess().getHmiServiceApp().getChoiceModel(2100389).setValue(1);
            }
            this.currentProfile = n;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void updateCharismaPopup(int n) {
        this.logChannel.log(1000000, "[EtronPopupHandler]#updateCharismaContent(%1)", (long)n);
        if (5 == n) {
            this.requestCharismaPopup(n, true);
        } else {
            Object object = this.mutex;
            synchronized (object) {
                this.removeEtronPopup();
                this.currentProfile = n;
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void acknowledgePopup(int n) {
        if (this.logChannel.isInfo()) {
            this.logChannel.log(1000000, "[EtronPopupHandler#acknowledgePopup] called with content = %1", (long)n);
        }
        Object object = this.mutex;
        synchronized (object) {
            if (n != 0) {
                this.currentProfile = n;
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void removeEtronPopup() {
        Object object = this.mutex;
        synchronized (object) {
            if (this.logChannel.isInfo()) {
                this.logChannel.log(1000000, "[EtronPopupHandler#removeEtronPopup] Popup is to be removed");
            }
            this.setCurrentCancelReason(1);
        }
        if (this.logChannel.isInfo()) {
            this.logChannel.log(1000000, "[EtronPopupHandler#removeEtronPopup] removeEtronPopup(%1)", (long)this.component.getPopUpID());
        }
        this.app.getFrameworkAccess().getHmiServiceApp().getChoiceModel(2100389).setValue(0);
    }

    public void replacePartialPopin(int n, int n2) {
        this.app.getFrameworkAccess().getHMIService().replacePartialPopup(0, n, n2);
    }

    public void initServiceProvider() {
        CarServiceProvider carServiceProvider = new CarServiceProvider((class$de$audi$atip$hmi$view$IPartialPopupListener == null ? (class$de$audi$atip$hmi$view$IPartialPopupListener = EtronPopupHandler.class$("de.audi.atip.hmi.view.IPartialPopupListener")) : class$de$audi$atip$hmi$view$IPartialPopupListener).getName(), this, new Hashtable(), this.app.getBundleContext(), this.logChannel);
        carServiceProvider.startService();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void setTimer(EtronPopupHKTimerController etronPopupHKTimerController) {
        if (this.logChannel.isInfo()) {
            this.logChannel.log(1000000, "[EtronPopupHandler#setTimer] Timer Controller has been set");
        }
        Object object = this.mutex;
        synchronized (object) {
            this.popupTimer = etronPopupHKTimerController;
        }
    }

    private DSICarDrivingCharacteristics getDSI() {
        return this.component.getDSI();
    }

    private boolean isFsgActivation() {
        return this.fsgActivation;
    }

    private void setFsgActivation(boolean bl) {
        this.fsgActivation = bl;
    }

    private int getActivationReason() {
        return this.isFsgActivation() ? 0 : 1;
    }

    private int getCurrentCancelReason() {
        return this.currentCancelReason;
    }

    private void setCurrentCancelReason(int n) {
        this.currentCancelReason = n;
    }

    private ICarApplication getApplication() {
        return this.app;
    }

    private int getCurrentlyVisiblePopupID() {
        return this.getApplication().getFrameworkAccess().getHmiServiceApp().getCurrentPopup();
    }

    public boolean buttonPopupRequest() {
        if (this.logChannel.isInfo()) {
            this.logChannel.log(1000000, "[EtronPopupHandler#buttonPopupRequest] Popup opened via DDS");
        }
        this.requestCharismaPopup(5, false);
        return true;
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

