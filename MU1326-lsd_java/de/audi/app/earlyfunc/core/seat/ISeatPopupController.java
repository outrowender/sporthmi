/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.core.seat;

import de.audi.app.earlyfunc.core.seat.AbstractSeatPopin;
import de.audi.app.earlyfunc.core.seat.MemorySeatPopin;
import de.audi.app.earlyfunc.core.seat.PopinAction;
import de.audi.app.earlyfunc.core.seat.SeatPopin;
import de.audi.app.earlyfunc.core.seat.SeatPopinContent;
import de.audi.atip.log.LogChannel;

public interface ISeatPopupController {
    default public void createPopups() {
    }

    default public void createPneumaticPopups() {
    }

    default public boolean arePneumaticSeatPopinsCreated() {
    }

    default public boolean areSeatPopinsCreated() {
    }

    default public LogChannel getLogChannel() {
    }

    default public void cancelPopup(SeatPopinContent seatPopinContent, AbstractSeatPopin abstractSeatPopin) {
    }

    default public void sendShowPopupResponse(SeatPopinContent seatPopinContent, SeatPopinContent seatPopinContent2, AbstractSeatPopin abstractSeatPopin) {
    }

    default public void showPartialPopinAfterUpdate(MemorySeatPopin memorySeatPopin) {
    }

    default public void showPartialPopinAfterUpdate(SeatPopin seatPopin) {
    }

    default public boolean isSeatContentShown(boolean bl) {
    }

    default public void performActionOnPopins(SeatPopinContent seatPopinContent, PopinAction popinAction, int n) {
    }

    default public void hideSeatPopup(AbstractSeatPopin abstractSeatPopin) {
    }

    default public void displaySeatPopup(AbstractSeatPopin abstractSeatPopin) {
    }
}

