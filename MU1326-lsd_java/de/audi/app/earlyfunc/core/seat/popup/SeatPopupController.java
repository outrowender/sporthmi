/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.core.seat.popup;

import de.audi.app.earlyfunc.core.seat.AbstractSeatPopupController;
import de.audi.app.earlyfunc.core.seat.AbstractSeatPopupFactory;
import de.audi.app.earlyfunc.core.seat.ISeatMainController;
import de.audi.app.earlyfunc.core.seat.MemorySeatPopin;
import de.audi.app.earlyfunc.core.seat.SeatPopin;

public class SeatPopupController
extends AbstractSeatPopupController {
    public SeatPopupController(ISeatMainController iSeatMainController, AbstractSeatPopupFactory abstractSeatPopupFactory) {
        super(iSeatMainController, abstractSeatPopupFactory);
    }

    @Override
    public void showPartialPopinAfterUpdate(MemorySeatPopin memorySeatPopin) {
    }

    @Override
    public void showPartialPopinAfterUpdate(SeatPopin seatPopin) {
    }
}

