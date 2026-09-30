/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.core.seat.popup;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.earlyfunc.core.seat.AbstractSeatPopinComponent;
import de.audi.app.earlyfunc.core.seat.AbstractSeatPopupFactory;
import de.audi.app.earlyfunc.core.seat.ISeatMainController;
import de.audi.app.earlyfunc.core.seat.ISeatPopupController;
import de.audi.app.earlyfunc.core.seat.ISeatPopupHandler;
import de.audi.app.earlyfunc.core.seat.ISeatPopupHandlerController;
import de.audi.app.earlyfunc.core.seat.SeatMainController;
import de.audi.app.earlyfunc.core.seat.SeatPopup;
import de.audi.app.earlyfunc.core.seat.popup.SeatPopupController;
import de.audi.app.earlyfunc.core.seat.popup.SeatPopupHandler;
import de.audi.app.earlyfunc.core.seat.popup.SeatPopupHandlerController;
import de.audi.atip.log.LogChannel;
import java.util.List;

public class SeatPopupFactory
extends AbstractSeatPopupFactory {
    private int hmiPopupID;
    private SeatMainController mainController;
    private SeatPopupController popupController;
    private SeatPopupHandler popupHandler;
    private SeatPopupHandlerController popupHandlerController;

    public SeatPopupFactory(ICarApplication iCarApplication, LogChannel logChannel, AbstractSeatPopinComponent abstractSeatPopinComponent) {
        super(iCarApplication, logChannel, abstractSeatPopinComponent);
    }

    public ISeatMainController createInstanceMainController() {
        if (this.mainController == null) {
            this.mainController = new SeatMainController(this);
        }
        return this.mainController;
    }

    public ISeatPopupController createInstancePopupController() {
        if (this.popupController == null) {
            this.popupController = new SeatPopupController(this.createInstanceMainController(), this);
        }
        return this.popupController;
    }

    public ISeatPopupHandler createInstancePopupHandler() {
        if (this.popupHandler == null) {
            this.popupHandler = new SeatPopupHandler(this.createInstancePopupHandlerController(), this);
        }
        return this.popupHandler;
    }

    public ISeatPopupHandlerController createInstancePopupHandlerController() {
        if (this.popupHandlerController == null) {
            this.popupHandlerController = new SeatPopupHandlerController(this.createInstanceMainController(), this);
        }
        return this.popupHandlerController;
    }

    public void addSeatPopups(List list) {
        SeatPopup seatPopup = new SeatPopup(this.hmiPopupID, this.createInstanceMainController().getConfigurationHandler(), this.createInstancePopupController(), false);
        list.add(seatPopup);
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1000000, "[SeatPopupFactory#addSeatPopups] SeatPopup created: popup='%1'", (Object)seatPopup);
        }
    }

    public void addPneumaticSeatPopups(List list) {
        SeatPopup seatPopup = new SeatPopup(this.hmiPopupID, this.createInstanceMainController().getConfigurationHandler(), this.createInstancePopupController(), true);
        list.add(seatPopup);
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1000000, "[SeatPopupFactory#addPneumaticSeatPopups] SeatPopup created: popup='%1'", (Object)seatPopup);
        }
    }

    public void init() {
        this.hmiPopupID = this.getComponent().getHMISeatPopupID();
        this.getLogChannel().log(1000000, "[SeatPopupFactory#init] hmiPopupID='%1'", (long)this.hmiPopupID);
    }

    public void deinit() {
        this.mainController.deinit();
        this.popupHandler.deinit();
        this.popupHandlerController.deinit();
        this.mainController = null;
        this.popupHandler = null;
        this.popupHandlerController = null;
        this.popupController = null;
    }

    public int[] getPopupIDs() {
        return new int[]{this.hmiPopupID};
    }
}

