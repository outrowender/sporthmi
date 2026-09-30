/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.core.seat;

import de.audi.app.earlyfunc.core.seat.AbstractSeatPopin;
import de.audi.app.earlyfunc.core.seat.SeatPopinContent;

public interface ISeatPopupHandlerController {
    public void init(int[] var1);

    public void deinit();

    public void notifySeatPopupHidden(int var1);

    public void notifySeatPopupVisible(int var1);

    public void notifySeatPopupRemoved(int var1);

    public void hideSeatPopup(AbstractSeatPopin var1);

    public void showSeatPopup(AbstractSeatPopin var1);

    public void setSeatPopinListenerServiceTracked(boolean var1);

    public void removeShownPopup(AbstractSeatPopin var1);

    public void setShownPopinContent(SeatPopinContent var1, AbstractSeatPopin var2);

    public void setSeatContentShown(boolean var1, boolean var2);

    public boolean isSeatContentShown(boolean var1);

    public void replaceSeatPopin(AbstractSeatPopin var1);
}

