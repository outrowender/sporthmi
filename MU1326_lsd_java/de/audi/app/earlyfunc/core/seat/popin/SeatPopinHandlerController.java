/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.core.seat.popin;

import de.audi.app.earlyfunc.core.seat.AbstractSeatPopin;
import de.audi.app.earlyfunc.core.seat.AbstractSeatPopupFactory;
import de.audi.app.earlyfunc.core.seat.ISeatMainController;
import de.audi.app.earlyfunc.core.seat.ISeatPopupController;
import de.audi.app.earlyfunc.core.seat.ISeatPopupHandler;
import de.audi.app.earlyfunc.core.seat.ISeatPopupHandlerController;
import de.audi.app.earlyfunc.core.seat.MasterSeatPopinContent;
import de.audi.app.earlyfunc.core.seat.PopinAction;
import de.audi.app.earlyfunc.core.seat.SeatPopinContent;
import de.audi.atip.log.LogChannel;
import java.util.HashMap;

public class SeatPopinHandlerController
implements ISeatPopupHandlerController {
    private final LogChannel logChannel;
    private ISeatPopupHandler popupHandler;
    private final ISeatMainController mainController;
    private ISeatPopupController popupController;
    private HashMap popinsWaitingForVisibleNotification = new HashMap();
    private HashMap popinsWaitingForHiddenNotification = new HashMap();
    private AbstractSeatPopin shownPopinLeft = null;
    private AbstractSeatPopin shownPopinRight = null;
    private boolean isSeatContentShownLeft = false;
    private boolean isSeatContentShownRight = false;
    private final AbstractSeatPopupFactory factory;

    public SeatPopinHandlerController(ISeatMainController iSeatMainController, AbstractSeatPopupFactory abstractSeatPopupFactory) {
        this.logChannel = iSeatMainController.getLogChannel();
        this.mainController = iSeatMainController;
        this.factory = abstractSeatPopupFactory;
    }

    public void init(int[] nArray) {
        this.popupHandler = this.factory.createInstancePopupHandler();
        this.popupController = this.factory.createInstancePopupController();
        this.popupHandler.init(nArray);
    }

    public void deinit() {
        this.popupHandler.deinit();
    }

    private LogChannel getLogChannel() {
        return this.logChannel;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void notifySeatPopupHidden(int n) {
        ISeatPopupController iSeatPopupController = this.popupController;
        synchronized (iSeatPopupController) {
            this.log("notifySeatPopupHidden", n);
            Integer n2 = new Integer(n);
            if (this.popinsWaitingForHiddenNotification.containsKey(n2)) {
                AbstractSeatPopin abstractSeatPopin = (AbstractSeatPopin)this.popinsWaitingForHiddenNotification.get(n2);
                abstractSeatPopin.processHiddenNotification();
                this.removeFromHiddenMap(n2);
                return;
            }
            if (this.popinsWaitingForVisibleNotification.containsKey(n2)) {
                if (this.mainController.isStandbyPopupVisible()) {
                    this.logChannel.log(1000000, "[SeatPopinHandlerController#notifySeatPopupHidden] Seat Popup won't be removed because it should replace the Standby Popup: popupID='%1'", (long)n);
                    return;
                }
                AbstractSeatPopin abstractSeatPopin = (AbstractSeatPopin)this.popinsWaitingForVisibleNotification.get(n2);
                abstractSeatPopin.processHiddenNotification();
                this.removeFromVisibleMap(n2);
                this.hideSeatPopup(abstractSeatPopin);
                this.removeFromHiddenMap(n2);
            } else {
                this.popupHandler.hideSeatPopup(n);
                this.popupController.performActionOnPopins(new SeatPopinContent(), PopinAction.POPIN_ACTION_NOTIFY_HIDDEN, n);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void notifySeatPopupVisible(int n) {
        ISeatPopupController iSeatPopupController = this.popupController;
        synchronized (iSeatPopupController) {
            this.log("notifySeatPopupVisible", n);
            Integer n2 = new Integer(n);
            if (this.popinsWaitingForVisibleNotification.containsKey(n2)) {
                AbstractSeatPopin abstractSeatPopin = (AbstractSeatPopin)this.popinsWaitingForVisibleNotification.get(n2);
                abstractSeatPopin.processVisibleNotification();
                this.removeFromVisibleMap(n2);
            } else {
                this.getLogChannel().log(100000, "[SeatPopinController#notifyPartialPopinVisible] unexpected visible notification: popupID='%1'", (long)n);
            }
        }
    }

    public void notifySeatPopupRemoved(int n) {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void hideSeatPopup(AbstractSeatPopin abstractSeatPopin) {
        ISeatPopupController iSeatPopupController = this.popupController;
        synchronized (iSeatPopupController) {
            this.log("hideSeatPopup", abstractSeatPopin);
            Integer n = new Integer(abstractSeatPopin.getHmiPopinID());
            if (this.popinsWaitingForHiddenNotification.containsKey(n)) {
                ((AbstractSeatPopin)this.popinsWaitingForHiddenNotification.get(n)).processHiddenNotification();
            } else {
                this.popupHandler.hideSeatPopup(abstractSeatPopin.getHmiPopinID());
            }
            this.addToHiddenMap(n, abstractSeatPopin);
        }
    }

    public void setSeatPopinListenerServiceTracked(boolean bl) {
        this.mainController.setSeatPopinListenerServiceTracked(bl);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void showSeatPopup(AbstractSeatPopin abstractSeatPopin) {
        ISeatPopupController iSeatPopupController = this.popupController;
        synchronized (iSeatPopupController) {
            this.log("showSeatPopup", abstractSeatPopin);
            boolean bl = this.replaceVisibleSeatPopin(abstractSeatPopin);
            if (!bl) {
                Integer n = new Integer(abstractSeatPopin.getHmiPopinID());
                if (this.popinsWaitingForVisibleNotification.containsKey(n)) {
                    ((AbstractSeatPopin)this.popinsWaitingForVisibleNotification.get(n)).processHiddenNotification();
                } else {
                    this.mainController.setSeatControlPowerManagementActive(true);
                    this.popupHandler.showSeatPopup(abstractSeatPopin.getHmiPopinID());
                }
                this.addToVisibleMap(n, abstractSeatPopin);
            }
        }
    }

    private boolean replaceVisibleSeatPopin(AbstractSeatPopin abstractSeatPopin) {
        AbstractSeatPopin abstractSeatPopin2;
        int n = abstractSeatPopin.getHmiPopinID();
        AbstractSeatPopin abstractSeatPopin3 = abstractSeatPopin2 = abstractSeatPopin.isLeft() ? this.shownPopinLeft : this.shownPopinRight;
        if (abstractSeatPopin2 != null && abstractSeatPopin2.getHmiPopinID() == n) {
            abstractSeatPopin2.processHiddenNotification(abstractSeatPopin.getHmiPopinID());
            abstractSeatPopin.processVisibleNotification();
            return true;
        }
        return false;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void removeShownPopup(AbstractSeatPopin abstractSeatPopin) {
        ISeatPopupController iSeatPopupController = this.popupController;
        synchronized (iSeatPopupController) {
            if (abstractSeatPopin.isLeft()) {
                if (this.shownPopinLeft != null && this.shownPopinLeft.getHmiPopinID() == abstractSeatPopin.getHmiPopinID()) {
                    this.shownPopinLeft = null;
                }
            } else if (this.shownPopinRight != null && this.shownPopinRight.getHmiPopinID() == abstractSeatPopin.getHmiPopinID()) {
                this.shownPopinRight = null;
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void setShownPopinContent(SeatPopinContent seatPopinContent, AbstractSeatPopin abstractSeatPopin) {
        ISeatPopupController iSeatPopupController = this.popupController;
        synchronized (iSeatPopupController) {
            boolean bl;
            boolean bl2 = bl = !MasterSeatPopinContent.NONE.equalsMasterSeatPopinContent(seatPopinContent.getMasterContent(abstractSeatPopin.isLeft()));
            if (bl) {
                boolean bl3;
                boolean bl4 = bl3 = !seatPopinContent.isPneumaticSeatContent();
                if (abstractSeatPopin.isLeft()) {
                    if (bl3) {
                        this.setSeatContentShown(true, true);
                    }
                    this.shownPopinLeft = abstractSeatPopin;
                } else {
                    if (bl3) {
                        this.setSeatContentShown(false, true);
                    }
                    this.shownPopinRight = abstractSeatPopin;
                }
            }
        }
    }

    public synchronized boolean isSeatContentShown(boolean bl) {
        return bl ? this.isSeatContentShownLeft : this.isSeatContentShownRight;
    }

    public synchronized void setSeatContentShown(boolean bl, boolean bl2) {
        if (bl) {
            this.isSeatContentShownLeft = bl2;
        } else {
            this.isSeatContentShownRight = bl2;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void replaceSeatPopin(AbstractSeatPopin abstractSeatPopin) {
        ISeatPopupController iSeatPopupController = this.popupController;
        synchronized (iSeatPopupController) {
            this.addToVisibleMap(new Integer(abstractSeatPopin.getHmiPopinID()), abstractSeatPopin);
            this.popupHandler.showSeatPopup(abstractSeatPopin.getHmiPopinID());
        }
    }

    private void log(String string, int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1000000, "[SeatPopinHandlerController#%1] popupID=%2", (Object)string, (long)n);
        }
    }

    private void log(String string, AbstractSeatPopin abstractSeatPopin) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1000000, "[SeatPopinHandlerController#%1] popup=%2", (Object)string, (Object)abstractSeatPopin);
        }
    }

    private void addToHiddenMap(Integer n, AbstractSeatPopin abstractSeatPopin) {
        this.getLogChannel().log(10000000, "add popup  with ID: %1 into popinsWaitingForHiddenNotification map", (Object)n);
        this.popinsWaitingForHiddenNotification.put(n, abstractSeatPopin);
    }

    private void removeFromHiddenMap(Integer n) {
        this.getLogChannel().log(10000000, "remove popup  with ID: %1 from popinsWaitingForHiddenNotification map", (Object)n);
        this.popinsWaitingForHiddenNotification.remove(n);
    }

    private void addToVisibleMap(Integer n, AbstractSeatPopin abstractSeatPopin) {
        this.getLogChannel().log(10000000, "add popup  with ID: %1 into popinsWaitingForVisibleNotification map", (Object)n);
        this.popinsWaitingForVisibleNotification.put(n, abstractSeatPopin);
    }

    private void removeFromVisibleMap(Integer n) {
        this.getLogChannel().log(10000000, "remove popup  with ID: %1 from popinsWaitingForVisibleNotification map", (Object)n);
        this.popinsWaitingForVisibleNotification.remove(n);
    }
}

