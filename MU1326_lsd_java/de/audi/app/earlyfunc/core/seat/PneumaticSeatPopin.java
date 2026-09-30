/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.core.seat;

import de.audi.app.earlyfunc.core.seat.AbstractSeatPopin;
import de.audi.app.earlyfunc.core.seat.ISeatPopupController;
import de.audi.app.earlyfunc.core.seat.MasterSeatPopinContent;
import de.audi.app.earlyfunc.core.seat.SeatPopinConfigurationHandler;
import de.audi.app.earlyfunc.core.seat.SeatPopinContent;

public class PneumaticSeatPopin
extends AbstractSeatPopin {
    public PneumaticSeatPopin(int n, SeatPopinConfigurationHandler seatPopinConfigurationHandler, boolean bl, ISeatPopupController iSeatPopupController) {
        super(n, seatPopinConfigurationHandler, bl, iSeatPopupController);
        this.lastUpdatedContent.setPneumaticSeatContent(true);
        this.currentContent.setPneumaticSeatContent(true);
    }

    protected boolean isResponsibleForContent(SeatPopinContent seatPopinContent) {
        return seatPopinContent.isPneumaticSeatContent() && !MasterSeatPopinContent.MEMORY.equalsMasterSeatPopinContent(seatPopinContent.getMasterContent(this.isLeft()));
    }

    protected void fillContentModel(SeatPopinContent seatPopinContent) {
        this.getConfig().getSeatPopinModel(this.isLeft()).selectContent(seatPopinContent.getMasterContent(this.isLeft()));
    }

    protected void showPartialPopinAfterSupportedContentUpdate(SeatPopinContent seatPopinContent) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1000000, "[%1#showPartialPopinAfterSupportedContentUpdate] SeatContentUpdate takes no effect. A request is necessary to show seat popup: updateContent='%2' ", (Object)this, (Object)seatPopinContent);
        }
    }

    public String getClassName() {
        return "PneumaticSeatPopin";
    }

    public void updateAvailabilityModels() {
        this.getConfig().setAvailabilityModels(this.isLeft(), true);
    }

    protected boolean discardCurrentContentAfterUnsupportedContentRequest(SeatPopinContent seatPopinContent) {
        return !seatPopinContent.isPneumaticSeatContent();
    }
}

