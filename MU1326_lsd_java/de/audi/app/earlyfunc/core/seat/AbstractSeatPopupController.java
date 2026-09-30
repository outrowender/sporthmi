/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.core.seat;

import de.audi.app.earlyfunc.core.seat.AbstractSeatPopin;
import de.audi.app.earlyfunc.core.seat.AbstractSeatPopupFactory;
import de.audi.app.earlyfunc.core.seat.ISeatMainController;
import de.audi.app.earlyfunc.core.seat.ISeatPopupController;
import de.audi.app.earlyfunc.core.seat.ISeatPopupHandlerController;
import de.audi.app.earlyfunc.core.seat.PopinAction;
import de.audi.app.earlyfunc.core.seat.SeatPopinContent;
import de.audi.atip.log.LogChannel;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class AbstractSeatPopupController
implements ISeatPopupController {
    private final LogChannel logChannel;
    private final ISeatMainController mainController;
    private ArrayList seatPopups = new ArrayList();
    private boolean seatPopinsCreated = false;
    private boolean pneumaticSeatPopinsCreated = false;
    private final AbstractSeatPopupFactory factory;
    private final ISeatPopupHandlerController popupHandlerController;

    public AbstractSeatPopupController(ISeatMainController iSeatMainController, AbstractSeatPopupFactory abstractSeatPopupFactory) {
        this.logChannel = iSeatMainController.getLogChannel();
        this.mainController = iSeatMainController;
        this.popupHandlerController = abstractSeatPopupFactory.createInstancePopupHandlerController();
        this.factory = abstractSeatPopupFactory;
    }

    public synchronized void createPopups() {
        this.getLogChannel().log(1000000, "[AbstractSeatPopupController#createPopups()] areSeatPopinsCreated: %1, arePneumaticSeatPopinsCreated: %2", this.areSeatPopinsCreated(), this.arePneumaticSeatPopinsCreated());
        if (!this.areSeatPopinsCreated()) {
            this.factory.addSeatPopups(this.getSeatPopups());
            this.setSeatPopinsCreated();
            this.getMainController().processDeferredRequest();
        }
    }

    public synchronized void createPneumaticPopups() {
        this.getLogChannel().log(1000000, "[AbstractSeatPopupController#createPneumaticPopups()] areSeatPopinsCreated: %1, arePneumaticSeatPopinsCreated: %2", this.areSeatPopinsCreated(), this.arePneumaticSeatPopinsCreated());
        if (!this.arePneumaticSeatPopinsCreated()) {
            this.factory.addPneumaticSeatPopups(this.getSeatPopups());
            this.setPneumaticSeatPopinsCreated();
            this.getMainController().processDeferredRequest();
        }
    }

    public synchronized void performActionOnPopins(SeatPopinContent seatPopinContent, PopinAction popinAction, int n) {
        if (this.logChannel.isInfo()) {
            this.logChannel.log(1000000, "[AbstractSeatPopupController#performActionOnPopins] %1: seatPopinContent='%2' , partialPopinID='%3'", (Object)popinAction, (Object)seatPopinContent, (Object)new Integer(n));
        }
        Iterator iterator = this.getSeatPopups().iterator();
        while (iterator.hasNext() && !this.performActionOnPopin((AbstractSeatPopin)iterator.next(), seatPopinContent, popinAction, n)) {
        }
    }

    private boolean performActionOnPopin(AbstractSeatPopin abstractSeatPopin, SeatPopinContent seatPopinContent, PopinAction popinAction, int n) {
        if (PopinAction.POPIN_ACTION_REQUEST.equalsPopinAction(popinAction)) {
            this.logPerformingAction(popinAction, abstractSeatPopin, seatPopinContent);
            abstractSeatPopin.requestPopin(seatPopinContent);
        } else if (PopinAction.POPIN_ACTION_UPDATE.equalsPopinAction(popinAction)) {
            this.logPerformingAction(popinAction, abstractSeatPopin, seatPopinContent);
            abstractSeatPopin.updateContent(seatPopinContent);
        } else if (PopinAction.POPIN_ACTION_NOTIFY_HIDDEN.equalsPopinAction(popinAction)) {
            this.logPerformingAction(popinAction, abstractSeatPopin, n);
            return abstractSeatPopin.processHiddenNotification(n);
        }
        return false;
    }

    private void logPerformingAction(PopinAction popinAction, AbstractSeatPopin abstractSeatPopin, SeatPopinContent seatPopinContent) {
        if (this.logChannel.isInfo()) {
            this.logChannel.log(1000000, "[AbstractSeatPopupController#performActionOnPopin] %1 on %2 with HMI ID '%3': content='%4'", (Object)popinAction, (Object)abstractSeatPopin.getClassName(), (Object)new Integer(abstractSeatPopin.getHmiPopinID()), (Object)seatPopinContent);
        }
    }

    private void logPerformingAction(PopinAction popinAction, AbstractSeatPopin abstractSeatPopin, int n) {
        if (this.logChannel.isInfo()) {
            this.logChannel.log(1000000, "[AbstractSeatPopupController#performActionOnPopin] %1 on %2 with HMI ID '%3': partialPopinID='%4'", (Object)popinAction, (Object)abstractSeatPopin.getClassName(), (Object)new Integer(abstractSeatPopin.getHmiPopinID()), (Object)new Integer(n));
        }
    }

    public void cancelPopup(SeatPopinContent seatPopinContent, AbstractSeatPopin abstractSeatPopin) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1000000, "[AbstractSeatPopupController#cancelPopup] cancelContent='%1', canceledPopup='%2'", (Object)seatPopinContent, (Object)abstractSeatPopin);
        }
        if (seatPopinContent.isPneumaticSeatContent()) {
            this.getMainController().callDSIcancelPopup(seatPopinContent.getDSISeatPneumaticContent(), seatPopinContent.getCancelReason());
        } else {
            this.getMainController().callDSIcancelPopup(seatPopinContent.getDSISeatContent(), seatPopinContent.getCancelReason());
        }
    }

    public void sendShowPopupResponse(SeatPopinContent seatPopinContent, SeatPopinContent seatPopinContent2, AbstractSeatPopin abstractSeatPopin) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1000000, "[AbstractSeatPopupController#showPopup] shownContent='%1', requestedContent='%2' , shownPopup='%3'", (Object)seatPopinContent, (Object)seatPopinContent2, (Object)abstractSeatPopin);
        }
        if (seatPopinContent.isPneumaticSeatContent()) {
            this.getMainController().callDSIshowPopup(seatPopinContent.getDSISeatPneumaticContent());
        } else {
            this.getMainController().callDSIshowPopup(seatPopinContent.getDSISeatContent());
        }
    }

    public void hideSeatPopup(AbstractSeatPopin abstractSeatPopin) {
        this.getPopupHandlerController().hideSeatPopup(abstractSeatPopin);
    }

    public void displaySeatPopup(AbstractSeatPopin abstractSeatPopin) {
        this.getPopupHandlerController().showSeatPopup(abstractSeatPopin);
    }

    public boolean isSeatContentShown(boolean bl) {
        return this.getPopupHandlerController().isSeatContentShown(bl);
    }

    public boolean arePneumaticSeatPopinsCreated() {
        return this.pneumaticSeatPopinsCreated;
    }

    public boolean areSeatPopinsCreated() {
        return this.seatPopinsCreated;
    }

    public LogChannel getLogChannel() {
        return this.logChannel;
    }

    private void setSeatPopinsCreated() {
        this.seatPopinsCreated = true;
    }

    private void setPneumaticSeatPopinsCreated() {
        this.pneumaticSeatPopinsCreated = true;
    }

    public ISeatMainController getMainController() {
        return this.mainController;
    }

    public ArrayList getSeatPopups() {
        return this.seatPopups;
    }

    public ISeatPopupHandlerController getPopupHandlerController() {
        return this.popupHandlerController;
    }

    public AbstractSeatPopupFactory getFactory() {
        return this.factory;
    }
}

