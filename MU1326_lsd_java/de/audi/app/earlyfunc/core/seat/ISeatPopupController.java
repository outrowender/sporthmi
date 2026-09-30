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
    public void createPopups();

    public void createPneumaticPopups();

    public boolean arePneumaticSeatPopinsCreated();

    public boolean areSeatPopinsCreated();

    public LogChannel getLogChannel();

    public void cancelPopup(SeatPopinContent var1, AbstractSeatPopin var2);

    public void sendShowPopupResponse(SeatPopinContent var1, SeatPopinContent var2, AbstractSeatPopin var3);

    public void showPartialPopinAfterUpdate(MemorySeatPopin var1);

    public void showPartialPopinAfterUpdate(SeatPopin var1);

    public boolean isSeatContentShown(boolean var1);

    public void performActionOnPopins(SeatPopinContent var1, PopinAction var2, int var3);

    public void hideSeatPopup(AbstractSeatPopin var1);

    public void displaySeatPopup(AbstractSeatPopin var1);
}

