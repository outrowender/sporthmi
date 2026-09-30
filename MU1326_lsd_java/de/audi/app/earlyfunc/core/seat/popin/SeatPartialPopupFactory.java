/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.core.seat.popin;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.earlyfunc.core.seat.AbstractSeatPopinComponent;
import de.audi.app.earlyfunc.core.seat.AbstractSeatPopupFactory;
import de.audi.app.earlyfunc.core.seat.ISeatMainController;
import de.audi.app.earlyfunc.core.seat.ISeatPopupController;
import de.audi.app.earlyfunc.core.seat.ISeatPopupHandler;
import de.audi.app.earlyfunc.core.seat.ISeatPopupHandlerController;
import de.audi.app.earlyfunc.core.seat.MemorySeatPopin;
import de.audi.app.earlyfunc.core.seat.PneumaticSeatPopin;
import de.audi.app.earlyfunc.core.seat.SeatMainController;
import de.audi.app.earlyfunc.core.seat.SeatPopin;
import de.audi.app.earlyfunc.core.seat.popin.SeatPopinController;
import de.audi.app.earlyfunc.core.seat.popin.SeatPopinHandler;
import de.audi.app.earlyfunc.core.seat.popin.SeatPopinHandlerController;
import de.audi.atip.log.LogChannel;
import java.util.List;

public class SeatPartialPopupFactory
extends AbstractSeatPopupFactory {
    private SeatMainController mainController;
    private SeatPopinController popupController;
    private SeatPopinHandlerController popupHandlerController;
    private SeatPopinHandler popupHandler;
    private int frontRightHMIPartialPopinID;
    private int frontLeftHMIPartialPopinID;
    private int frontLeftMemoryHMIPartialPopinID;
    private int frontRightMemoryHMIPartialPopinID;

    public SeatPartialPopupFactory(ICarApplication iCarApplication, LogChannel logChannel, AbstractSeatPopinComponent abstractSeatPopinComponent) {
        super(iCarApplication, logChannel, abstractSeatPopinComponent);
    }

    public void init() {
        this.frontLeftHMIPartialPopinID = this.getComponent().getFrontLeftHMIPartialPopinID();
        this.frontRightHMIPartialPopinID = this.getComponent().getFrontRightHMIPartialPopinID();
        this.frontLeftMemoryHMIPartialPopinID = this.getComponent().getFrontLeftMemoryHMIPartialPopinID();
        this.frontRightMemoryHMIPartialPopinID = this.getComponent().getFrontRightMemoryHMIPartialPopinID();
        this.getLogChannel().log(1000000, "[SeatPartialPopupFactory#init] frontLeftHMIPartialPopinID='%1' , frontRightHMIPartialPopinID='%2' , frontLeftMemoryHMIPartialPopinID='%3' , frontRightMemoryHMIPartialPopinID='%4'", (Object)new Integer(this.frontLeftHMIPartialPopinID), (Object)new Integer(this.frontRightHMIPartialPopinID), (Object)new Integer(this.frontLeftMemoryHMIPartialPopinID), (Object)new Integer(this.frontRightMemoryHMIPartialPopinID));
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
        return new int[]{this.frontLeftHMIPartialPopinID, this.frontRightHMIPartialPopinID, this.frontLeftMemoryHMIPartialPopinID, this.frontRightMemoryHMIPartialPopinID};
    }

    public ISeatMainController createInstanceMainController() {
        if (this.mainController == null) {
            this.mainController = new SeatMainController(this);
        }
        return this.mainController;
    }

    public ISeatPopupController createInstancePopupController() {
        if (this.popupController == null) {
            this.popupController = new SeatPopinController(this.createInstanceMainController(), this);
        }
        return this.popupController;
    }

    public ISeatPopupHandlerController createInstancePopupHandlerController() {
        if (this.popupHandlerController == null) {
            this.popupHandlerController = new SeatPopinHandlerController(this.createInstanceMainController(), this);
        }
        return this.popupHandlerController;
    }

    public ISeatPopupHandler createInstancePopupHandler() {
        if (this.popupHandler == null) {
            this.popupHandler = new SeatPopinHandler(this.createInstancePopupHandlerController(), this);
        }
        return this.popupHandler;
    }

    public void addSeatPopups(List list) {
        this.createSeatPopins(list);
        this.createMemoryPopins(list);
    }

    public void addPneumaticSeatPopups(List list) {
        this.createPneumaticPopins(list);
    }

    private void createMemoryPopins(List list) {
        MemorySeatPopin memorySeatPopin = new MemorySeatPopin(this.frontLeftMemoryHMIPartialPopinID, this.getChoiceModel(2100290), this.createInstanceMainController().getConfigurationHandler(), true, this.createInstancePopupController());
        MemorySeatPopin memorySeatPopin2 = new MemorySeatPopin(this.frontRightMemoryHMIPartialPopinID, this.getChoiceModel(2100291), this.createInstanceMainController().getConfigurationHandler(), false, this.createInstancePopupController());
        list.add(memorySeatPopin);
        list.add(memorySeatPopin2);
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1000000, "[SeatPartialPopupFactory#createMemoryPopins] popins created: leftMemoryPopin='%1', rightMemoryPopin='%2'", (Object)memorySeatPopin, (Object)memorySeatPopin2);
        }
    }

    private void createSeatPopins(List list) {
        SeatPopin seatPopin = new SeatPopin(this.frontLeftHMIPartialPopinID, this.createInstanceMainController().getConfigurationHandler(), true, this.createInstancePopupController());
        seatPopin.updateAvailabilityModels();
        SeatPopin seatPopin2 = new SeatPopin(this.frontRightHMIPartialPopinID, this.createInstanceMainController().getConfigurationHandler(), false, this.createInstancePopupController());
        seatPopin2.updateAvailabilityModels();
        list.add(seatPopin2);
        list.add(seatPopin);
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1000000, "[SeatPartialPopupFactory#createSeatPopins] popins created: leftPopin='%1', rightPopin='%2'", (Object)seatPopin, (Object)seatPopin2);
        }
    }

    private void createPneumaticPopins(List list) {
        PneumaticSeatPopin pneumaticSeatPopin = new PneumaticSeatPopin(this.frontLeftHMIPartialPopinID, this.createInstanceMainController().getConfigurationHandler(), true, this.createInstancePopupController());
        pneumaticSeatPopin.updateAvailabilityModels();
        PneumaticSeatPopin pneumaticSeatPopin2 = new PneumaticSeatPopin(this.frontRightHMIPartialPopinID, this.createInstanceMainController().getConfigurationHandler(), false, this.createInstancePopupController());
        pneumaticSeatPopin2.updateAvailabilityModels();
        list.add(pneumaticSeatPopin2);
        list.add(pneumaticSeatPopin);
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1000000, "[SeatPartialPopupFactory#createPneumaticPopins] popins created: leftPopin='%1', rightPopin='%2'", (Object)pneumaticSeatPopin, (Object)pneumaticSeatPopin2);
        }
    }
}

