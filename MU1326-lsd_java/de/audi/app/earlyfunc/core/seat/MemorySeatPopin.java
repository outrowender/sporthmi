/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.core.seat;

import de.audi.app.earlyfunc.core.seat.AbstractSeatPopin;
import de.audi.app.earlyfunc.core.seat.ISeatPopupController;
import de.audi.app.earlyfunc.core.seat.MasterSeatPopinContent;
import de.audi.app.earlyfunc.core.seat.SeatPopinConfigurationHandler;
import de.audi.app.earlyfunc.core.seat.SeatPopinContent;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;

public class MemorySeatPopin
extends AbstractSeatPopin {
    private final ChoiceModelApp memoryDetailModel;

    public MemorySeatPopin(int n, ChoiceModelApp choiceModelApp, SeatPopinConfigurationHandler seatPopinConfigurationHandler, boolean bl, ISeatPopupController iSeatPopupController) {
        super(n, seatPopinConfigurationHandler, bl, iSeatPopupController);
        this.memoryDetailModel = choiceModelApp;
    }

    @Override
    protected boolean isResponsibleForContent(SeatPopinContent seatPopinContent) {
        return !seatPopinContent.isPneumaticSeatContent() && (MasterSeatPopinContent.NONE.equalsMasterSeatPopinContent(seatPopinContent.getMasterContent(this.isLeft())) || MasterSeatPopinContent.MEMORY.equalsMasterSeatPopinContent(seatPopinContent.getMasterContent(this.isLeft())));
    }

    @Override
    protected void fillContentModel(SeatPopinContent seatPopinContent) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1078071040, "[%1#fillContentModel] set model: modelID='%2', value='%3', memoryDetail='%4'", (Object)this, (Object)new Integer(this.memoryDetailModel.getID()), (Object)new Integer(seatPopinContent.getMemoryDetail(this.isLeft()).getModelValue()), (Object)seatPopinContent.getMemoryDetail(this.isLeft()));
        }
        this.memoryDetailModel.setValue(seatPopinContent.getMemoryDetail(this.isLeft()).getModelValue());
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
        return "MemorySeatPopin";
    }

    @Override
    public void updateAvailabilityModels() {
    }

    @Override
    protected boolean discardCurrentContentAfterUnsupportedContentRequest(SeatPopinContent seatPopinContent) {
        return false;
    }
}

