/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.core.seat;

import de.audi.app.earlyfunc.core.seat.AbstractSeatPopin;
import de.audi.app.earlyfunc.core.seat.ISeatPopupController;
import de.audi.app.earlyfunc.core.seat.MasterSeatPopinContent;
import de.audi.app.earlyfunc.core.seat.SeatPopinConfigurationHandler;
import de.audi.app.earlyfunc.core.seat.SeatPopinContent;

public class SeatPopup
extends AbstractSeatPopin {
    private final boolean pneumatic;

    public SeatPopup(int n, SeatPopinConfigurationHandler seatPopinConfigurationHandler, ISeatPopupController iSeatPopupController, boolean bl) {
        super(n, seatPopinConfigurationHandler, false, iSeatPopupController);
        this.pneumatic = bl;
    }

    public String getClassName() {
        return this.pneumatic ? "SeatPopup'pneumatic'" : "SeatPopup";
    }

    protected boolean isResponsibleForContent(SeatPopinContent seatPopinContent) {
        return seatPopinContent.isPneumaticSeatContent() == this.pneumatic && !MasterSeatPopinContent.MEMORY.equals(seatPopinContent.getMasterContent(this.isLeft()));
    }

    protected void fillContentModel(SeatPopinContent seatPopinContent) {
        this.getConfig().getSeatPopinModel(this.isLeft()).selectContent(seatPopinContent.getMasterContent(this.isLeft()));
    }

    protected void showPartialPopinAfterSupportedContentUpdate(SeatPopinContent seatPopinContent) {
    }

    protected boolean discardCurrentContentAfterUnsupportedContentRequest(SeatPopinContent seatPopinContent) {
        return false;
    }

    public void updateAvailabilityModels() {
        this.getConfig().setAvailabilityModels(this.isLeft(), this.pneumatic);
    }

    public boolean isLeft() {
        return this.getConfig().isDriverSideLeft(this.pneumatic);
    }
}

