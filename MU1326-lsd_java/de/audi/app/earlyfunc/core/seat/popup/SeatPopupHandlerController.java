/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.core.seat.popup;

import de.audi.app.earlyfunc.core.seat.AbstractSeatPopin;
import de.audi.app.earlyfunc.core.seat.AbstractSeatPopupFactory;
import de.audi.app.earlyfunc.core.seat.ISeatMainController;
import de.audi.app.earlyfunc.core.seat.ISeatPopupController;
import de.audi.app.earlyfunc.core.seat.ISeatPopupHandler;
import de.audi.app.earlyfunc.core.seat.ISeatPopupHandlerController;
import de.audi.app.earlyfunc.core.seat.PopinAction;
import de.audi.app.earlyfunc.core.seat.SeatPopinContent;
import de.audi.atip.log.LogChannel;

public class SeatPopupHandlerController
implements ISeatPopupHandlerController {
    private final LogChannel logChannel;
    private ISeatPopupHandler popupHandler;
    private ISeatPopupController popupController;
    private ISeatMainController mainController;
    private final AbstractSeatPopupFactory factory;
    private AbstractSeatPopin visibleNotificationReceiver;
    private AbstractSeatPopin removedNotificationReceiver;

    public SeatPopupHandlerController(ISeatMainController iSeatMainController, AbstractSeatPopupFactory abstractSeatPopupFactory) {
        this.logChannel = iSeatMainController.getLogChannel();
        this.factory = abstractSeatPopupFactory;
    }

    @Override
    public void init(int[] nArray) {
        this.mainController = this.factory.createInstanceMainController();
        this.popupHandler = this.factory.createInstancePopupHandler();
        this.popupController = this.factory.createInstancePopupController();
        this.mainController.setSeatPopinListenerServiceTracked(true);
        this.popupHandler.init(nArray);
    }

    @Override
    public void deinit() {
        this.popupHandler.deinit();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void notifySeatPopupHidden(int n) {
        this.log("notifySeatPopupHidden", n);
        ISeatPopupController iSeatPopupController = this.popupController;
        synchronized (iSeatPopupController) {
            if (this.getVisibleNotificationReceiver() != null) {
                if (this.mainController.isStandbyPopupVisible()) {
                    this.logChannel.log(1078071040, "[SeatPopupHandlerController#notifySeatPopupHidden] Seat Popup won't be removed because it should replace the Standby Popup!");
                    return;
                }
                this.setRemovedNotificationReceiver(this.getVisibleNotificationReceiver());
                this.setVisibleNotificationReceiver(null);
            }
            this.popupHandler.hideSeatPopup(n);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void notifySeatPopupVisible(int n) {
        ISeatPopupController iSeatPopupController = this.popupController;
        synchronized (iSeatPopupController) {
            this.log("notifySeatPopupVisible", n);
            if (this.getVisibleNotificationReceiver() != null) {
                this.getVisibleNotificationReceiver().processVisibleNotification();
                this.setVisibleNotificationReceiver(null);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void notifySeatPopupRemoved(int n) {
        ISeatPopupController iSeatPopupController = this.popupController;
        synchronized (iSeatPopupController) {
            this.log("notifySeatPopupRemoved", n);
            if (this.getRemovedNotificationReceiver() != null) {
                this.getRemovedNotificationReceiver().processHiddenNotification();
                this.setRemovedNotificationReceiver(null);
            } else {
                this.popupController.performActionOnPopins(new SeatPopinContent(), PopinAction.POPIN_ACTION_NOTIFY_HIDDEN, n);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void hideSeatPopup(AbstractSeatPopin abstractSeatPopin) {
        ISeatPopupController iSeatPopupController = this.popupController;
        synchronized (iSeatPopupController) {
            if (abstractSeatPopin != null) {
                this.log("hideSeatPopup", abstractSeatPopin);
                this.popupHandler.hideSeatPopup(abstractSeatPopin.getHmiPopinID());
                this.setRemovedNotificationReceiver(abstractSeatPopin);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void showSeatPopup(AbstractSeatPopin abstractSeatPopin) {
        ISeatPopupController iSeatPopupController = this.popupController;
        synchronized (iSeatPopupController) {
            this.log("showSeatPopup", abstractSeatPopin);
            this.mainController.setSeatControlPowerManagementActive(true);
            this.popupHandler.showSeatPopup(abstractSeatPopin.getHmiPopinID());
            this.setVisibleNotificationReceiver(abstractSeatPopin);
        }
    }

    @Override
    public void setSeatPopinListenerServiceTracked(boolean bl) {
    }

    @Override
    public void removeShownPopup(AbstractSeatPopin abstractSeatPopin) {
    }

    @Override
    public void setShownPopinContent(SeatPopinContent seatPopinContent, AbstractSeatPopin abstractSeatPopin) {
    }

    @Override
    public void setSeatContentShown(boolean bl, boolean bl2) {
    }

    @Override
    public boolean isSeatContentShown(boolean bl) {
        return false;
    }

    @Override
    public void replaceSeatPopin(AbstractSeatPopin abstractSeatPopin) {
    }

    private LogChannel getLogChannel() {
        return this.logChannel;
    }

    private AbstractSeatPopin getVisibleNotificationReceiver() {
        return this.visibleNotificationReceiver;
    }

    private void setVisibleNotificationReceiver(AbstractSeatPopin abstractSeatPopin) {
        this.visibleNotificationReceiver = abstractSeatPopin;
    }

    private AbstractSeatPopin getRemovedNotificationReceiver() {
        return this.removedNotificationReceiver;
    }

    private void setRemovedNotificationReceiver(AbstractSeatPopin abstractSeatPopin) {
        this.removedNotificationReceiver = abstractSeatPopin;
    }

    private void log(String string, int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1078071040, "[SeatPopupHandlerController#%1] popupID=%2", (Object)string, (long)n);
        }
    }

    private void log(String string, AbstractSeatPopin abstractSeatPopin) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1078071040, "[SeatPopupHandlerController#%1] popup=%2", (Object)string, (Object)abstractSeatPopin);
        }
    }
}

