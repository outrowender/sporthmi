/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.common.charisma;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.common.charisma.CharismaPopupButtonListenerBusiness;
import de.audi.app.car.common.charisma.CharismaPopupHKTimerController;
import de.audi.app.car.common.comp.AbstractBaseCharismaComponent;
import de.audi.app.car.common.handler.ButtonModelHandler;
import de.audi.app.car.common.handler.DefaultButtonModelHandler;
import de.audi.app.car.common.screenstate.IPopupStateListener;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.cardrivingcharacteristics.DSICarDrivingCharacteristics;

public class CharismaPopupHandler
implements IPopupStateListener {
    private LogChannel logChannel;
    private ICarApplication app;
    private AbstractBaseCharismaComponent component;
    private ButtonModelHandler buttonHandler;
    private int currentCancelReason = 1;
    private CharismaPopupHKTimerController popupTimer;
    private boolean fsgActivation = false;
    private volatile boolean isVisible = false;
    private volatile int currentProfile = -1;
    private final Object mutex = new Object();
    private int buttonModelId;

    public CharismaPopupHandler(ICarApplication iCarApplication, AbstractBaseCharismaComponent abstractBaseCharismaComponent, LogChannel logChannel, int n) {
        this.logChannel = logChannel;
        this.app = iCarApplication;
        this.component = abstractBaseCharismaComponent;
        this.buttonModelId = n;
    }

    public void init() {
        if (this.component.getPopUpID() != -1) {
            this.buttonHandler = new DefaultButtonModelHandler(this.app.getFrameworkAccess().getHmiServiceApp().getButtonModel(this.buttonModelId), this.logChannel);
            this.app.getScreenStateDispatcher().addPopupStateListener(this.component.getPopUpID(), this);
        }
    }

    public void deinit() {
        if (this.component.getPopUpID() != -1) {
            this.app.getScreenStateDispatcher().removePopupStateListener(this.component.getPopUpID(), this);
            this.buttonHandler.deinitModel();
            this.setCurrentProfile(0);
        }
    }

    public void initBusiness() {
        if (this.buttonHandler != null) {
            CharismaPopupButtonListenerBusiness charismaPopupButtonListenerBusiness = new CharismaPopupButtonListenerBusiness(this, this.getDSI(), this.logChannel);
            this.buttonHandler.setBusiness(charismaPopupButtonListenerBusiness);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void notifyPopupVisible(int n) {
        this.logChannel.log(1078071040, "[CharismaPopupHandler#notifyPopupVisible] id='%1'", (long)n);
        Object object = this.mutex;
        synchronized (object) {
            if (!this.isVisible) {
                this.component.showCharismaPopup(this.currentProfile, this.getActivationReason());
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
    @Override
    public void notifyPopupHidden(int n) {
        this.logChannel.log(1078071040, "[CharismaPopupHandler#notifyPopupHidden] id='%1'", (long)n);
        Object object = this.mutex;
        synchronized (object) {
            if (!this.isVisible && this.component.hasToWakeMUFromStandby() && this.isStandbyPopupVisible()) {
                this.logChannel.log(1078071040, "[CharismaPopupHandler#notifyPopupHidden] Charisma Popup won't be removed because it should replace the Standby Popup: standbyPopupID='%1'", (long)this.getStandbyPopupID());
                return;
            }
            this.removePopup();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void notifyPopupRemoved(int n) {
        this.logChannel.log(1078071040, "[CharismaPopupHandler#notifyPopupRemoved] id='%1'", (long)n);
        Object object = this.mutex;
        synchronized (object) {
            if (this.currentProfile != 5) {
                if (this.isVisible) {
                    this.component.cancelCharismaPopup(this.currentProfile, this.getCurrentCancelReason());
                    this.setFsgActivation(false);
                    this.setCurrentCancelReason(1);
                    this.popupTimer.deactivate();
                    this.isVisible = false;
                } else {
                    this.component.showCharismaPopup(0, 1);
                }
            } else {
                this.logChannel.log(1078071040, "[CharismaPopupHandler#notifyPopupRemoved] Resetting Handler settings after content change!");
                if (this.isVisible) {
                    this.setFsgActivation(false);
                    this.setCurrentCancelReason(0);
                    this.isVisible = false;
                }
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void requestCharismaPopup(int n, boolean bl) {
        if (this.logChannel.isInfo()) {
            this.logChannel.log(1078071040, "[CharismaPopupHandler#requestCharismaPopup] called with content = %1, fsgActivation=%2", (Object)new Integer(n), (Object)bl);
        }
        this.setCurrentProfile(n);
        Object object = this.mutex;
        synchronized (object) {
            if (n == 0) {
                if (this.isVisible) {
                    this.setCurrentCancelReason(0);
                    if (this.logChannel.isInfo()) {
                        this.logChannel.log(1078071040, "[CharismaPopupHandler#requestCharismaPopup] removePopup(%1) called", (long)this.component.getPopUpID());
                    }
                    this.app.getFrameworkAccess().getHmiServiceApp().removePopup(this.component.getPopUpID());
                }
            } else if (!this.component.isDriveSelectScreenVisible()) {
                this.setFsgActivation(bl);
                this.component.setDriveSelectPowerManagementActive(true);
                if (this.logChannel.isInfo()) {
                    this.logChannel.log(1078071040, "[CharismaPopupHandler#requestCharismaPopup] showPopup(%1)", (long)this.component.getPopUpID());
                }
                this.app.getFrameworkAccess().getHmiServiceApp().showPopup(this.component.getPopUpID());
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void acknowledgePopup(int n) {
        if (this.logChannel.isInfo()) {
            this.logChannel.log(1078071040, "[CharismaPopupHandler#acknowledgePopup] called with content = %1", (long)n);
        }
        Object object = this.mutex;
        synchronized (object) {
            if (this.component.isDriveSelectScreenVisible() && !this.isVisible && this.currentProfile == 5 && n == 0) {
                this.component.showCharismaPopup(1, 1);
                this.logChannel.log(1078071040, "acknowledgeCharismaPopup: Resetting show after acknowledge none");
            } else if (n == 0) {
                if (this.logChannel.isInfo()) {
                    this.logChannel.log(1078071040, "[CharismaPopupHandler#acknowledgePopup] NOT calling DSI.cancelCharismaPopup(%1, %2 ) ", (long)this.currentProfile, 0L);
                }
                this.component.setDriveSelectPowerManagementActive(false);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void setCurrentProfile(int n) {
        Object object = this.mutex;
        synchronized (object) {
            if (n != 0) {
                if (this.logChannel.isInfo()) {
                    this.logChannel.log(1078071040, "[CharismaPopupHandler#setCurrentProfile] current profile set to %1", (long)n);
                }
                this.currentProfile = n;
            }
        }
    }

    public void checkCurrentContent(int n) {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void removePopup() {
        Object object = this.mutex;
        synchronized (object) {
            if (this.logChannel.isInfo()) {
                this.logChannel.log(1078071040, "[CharismaPopupHandler#removePopup] Popup is to be removed");
            }
            this.setCurrentCancelReason(1);
        }
        if (this.logChannel.isInfo()) {
            this.logChannel.log(1078071040, "[CharismaPopupHandler#removePopup] removePopup(%1)", (long)this.component.getPopUpID());
        }
        this.app.getFrameworkAccess().getHmiServiceApp().removePopup(this.component.getPopUpID());
    }

    public boolean buttonPopupRequest() {
        if (this.logChannel.isInfo()) {
            this.logChannel.log(1078071040, "[CharismaPopupHandler#buttonPopupRequest] Popup opened via DDS");
        }
        this.requestCharismaPopup(1, false);
        return true;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void setTimer(CharismaPopupHKTimerController charismaPopupHKTimerController) {
        if (this.logChannel.isInfo()) {
            this.logChannel.log(1078071040, "[CharismaPopupHandler#setTimer] Timer Controller has been set");
        }
        Object object = this.mutex;
        synchronized (object) {
            this.popupTimer = charismaPopupHKTimerController;
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

    public boolean isStandbyPopupVisible() {
        return this.getStandbyPopupID() != -1 && this.getCurrentlyVisiblePopupID() == this.getStandbyPopupID();
    }

    private ICarApplication getApplication() {
        return this.app;
    }

    private int getStandbyPopupID() {
        return this.component.getStandbyPopupID();
    }

    private int getCurrentlyVisiblePopupID() {
        return this.getApplication().getFrameworkAccess().getHmiServiceApp().getCurrentPopup();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void updateCharismaContent(int n) {
        boolean bl = false;
        if (n == 5) {
            Object object = this.mutex;
            synchronized (object) {
                if (this.isVisible) {
                    this.logChannel.log(1078071040, "[CharismaPopupHandler#updateCharismaContent] -> removePopup)(%1)", (long)this.component.getPopUpID());
                    bl = true;
                    this.app.getFrameworkAccess().getHmiServiceApp().removePopup(this.component.getPopUpID());
                } else {
                    this.logChannel.log(1078071040, "[CharismaPopupHandler#updateCharismaContent] Nothing to do");
                }
            }
        }
        if (n == 2 || n == 1) {
            Object object = this.mutex;
            synchronized (object) {
                if (!this.component.isDriveSelectScreenVisible() && this.currentProfile != -1) {
                    this.logChannel.log(1078071040, "[CharismaPopupHandler#updateCharismaContent] -> showPopup)(%1)", (long)this.component.getPopUpID());
                    bl = true;
                    this.requestCharismaPopup(n, true);
                } else {
                    this.logChannel.log(1078071040, "[CharismaPopupHandler#updateCharismaContent] Charisma already visible - nothing to do!");
                }
            }
        }
        if (bl) {
            this.setCurrentProfile(n);
        }
    }
}

