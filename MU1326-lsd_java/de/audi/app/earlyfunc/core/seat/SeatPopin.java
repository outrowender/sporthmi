/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.core.seat;

import de.audi.app.earlyfunc.core.seat.AbstractSeatPopin;
import de.audi.app.earlyfunc.core.seat.ISeatPopupController;
import de.audi.app.earlyfunc.core.seat.MasterSeatPopinContent;
import de.audi.app.earlyfunc.core.seat.SeatPopinConfigurationHandler;
import de.audi.app.earlyfunc.core.seat.SeatPopinContent;

public class SeatPopin
extends AbstractSeatPopin {
    public SeatPopin(int n, SeatPopinConfigurationHandler seatPopinConfigurationHandler, boolean bl, ISeatPopupController iSeatPopupController) {
        super(n, seatPopinConfigurationHandler, bl, iSeatPopupController);
    }

    @Override
    protected boolean isResponsibleForContent(SeatPopinContent seatPopinContent) {
        return !MasterSeatPopinContent.MEMORY.equalsMasterSeatPopinContent(seatPopinContent.getMasterContent(this.isLeft())) && !seatPopinContent.isPneumaticSeatContent();
    }

    @Override
    protected void fillContentModel(SeatPopinContent seatPopinContent) {
        this.getConfig().getSeatPopinModel(this.isLeft()).selectContent(seatPopinContent.getMasterContent(this.isLeft()));
    }

    @Override
    protected void showPartialPopinAfterSupportedContentUpdate(SeatPopinContent seatPopinContent) {
        if (this.getPopinController().isSeatContentShown(this.isLeft())) {
            this.copyContent(seatPopinContent, this.lastUpdatedContent);
            this.getPopinController().showPartialPopinAfterUpdate(this);
        } else if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1078071040, "[%1#showPartialPopinAfterSupportedContentUpdate] SeatContentUpdate takes no effect. A request is necessary to show seat popup: updateContent='%2' ", (Object)this, (Object)seatPopinContent);
        }
    }

    @Override
    public String getClassName() {
        return "SeatPopin";
    }

    @Override
    public void updateAvailabilityModels() {
        this.getConfig().setAvailabilityModels(this.isLeft(), false);
    }

    @Override
    protected boolean discardCurrentContentAfterUnsupportedContentRequest(SeatPopinContent seatPopinContent) {
        return seatPopinContent.isPneumaticSeatContent();
    }
}

