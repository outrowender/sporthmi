/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.core.seat;

import de.audi.app.earlyfunc.core.seat.AbstractSeatPopin;
import de.audi.app.earlyfunc.core.seat.SeatPopinContent;

public interface ISeatPopupHandlerController {
    default public void init(int[] nArray) {
    }

    default public void deinit() {
    }

    default public void notifySeatPopupHidden(int n) {
    }

    default public void notifySeatPopupVisible(int n) {
    }

    default public void notifySeatPopupRemoved(int n) {
    }

    default public void hideSeatPopup(AbstractSeatPopin abstractSeatPopin) {
    }

    default public void showSeatPopup(AbstractSeatPopin abstractSeatPopin) {
    }

    default public void setSeatPopinListenerServiceTracked(boolean bl) {
    }

    default public void removeShownPopup(AbstractSeatPopin abstractSeatPopin) {
    }

    default public void setShownPopinContent(SeatPopinContent seatPopinContent, AbstractSeatPopin abstractSeatPopin) {
    }

    default public void setSeatContentShown(boolean bl, boolean bl2) {
    }

    default public boolean isSeatContentShown(boolean bl) {
    }

    default public void replaceSeatPopin(AbstractSeatPopin abstractSeatPopin) {
    }
}

