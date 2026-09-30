/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.core.seat.popin;

import de.audi.app.earlyfunc.core.seat.AbstractSeatPopin;
import de.audi.app.earlyfunc.core.seat.AbstractSeatPopupController;
import de.audi.app.earlyfunc.core.seat.AbstractSeatPopupFactory;
import de.audi.app.earlyfunc.core.seat.ISeatMainController;
import de.audi.app.earlyfunc.core.seat.MasterSeatPopinContent;
import de.audi.app.earlyfunc.core.seat.MemorySeatPopin;
import de.audi.app.earlyfunc.core.seat.SeatPopin;
import de.audi.app.earlyfunc.core.seat.SeatPopinContent;

public class SeatPopinController
extends AbstractSeatPopupController {
    private int popinIDForCancelBlockLeft = -1;
    private int popinIDForCancelBlockRight = -1;
    private SeatPopinContent currentShownContent;

    public SeatPopinController(ISeatMainController iSeatMainController, AbstractSeatPopupFactory abstractSeatPopupFactory) {
        super(iSeatMainController, abstractSeatPopupFactory);
    }

    public void cancelPopup(SeatPopinContent seatPopinContent, AbstractSeatPopin abstractSeatPopin) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1000000, "[SeatPopinController#cancelPopup] cancelContent='%1', canceledPopin", (Object)seatPopinContent, (Object)abstractSeatPopin);
        }
        this.getPopupHandlerController().removeShownPopup(abstractSeatPopin);
        if (seatPopinContent.isPneumaticSeatContent()) {
            this.getMainController().callDSIcancelPopup(seatPopinContent.getDSISeatPneumaticContent(), seatPopinContent.getCancelReason());
        } else if (this.popinIDForCancelBlockLeft != abstractSeatPopin.getHmiPopinID() && this.popinIDForCancelBlockRight != abstractSeatPopin.getHmiPopinID()) {
            this.getPopupHandlerController().setSeatContentShown(abstractSeatPopin.isLeft(), false);
            this.getMainController().callDSIcancelPopup(seatPopinContent.getDSISeatContent(), seatPopinContent.getCancelReason());
        } else {
            this.setPopinIDCancelBlock(abstractSeatPopin.isLeft(), -1);
        }
    }

    private void setPopinIDCancelBlock(boolean bl, int n) {
        if (bl) {
            this.popinIDForCancelBlockLeft = n;
        } else {
            this.popinIDForCancelBlockRight = n;
        }
    }

    public synchronized void sendShowPopupResponse(SeatPopinContent seatPopinContent, SeatPopinContent seatPopinContent2, AbstractSeatPopin abstractSeatPopin) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1000000, "[SeatPopinController#showPopup] shownContent='%1', requestedContent='%2' , shownPopin='%3'", (Object)seatPopinContent, (Object)seatPopinContent2, (Object)abstractSeatPopin);
        }
        this.getPopupHandlerController().setShownPopinContent(seatPopinContent, abstractSeatPopin);
        if (!MasterSeatPopinContent.NONE.equalsMasterSeatPopinContent(seatPopinContent2.getMasterContent(true)) && !MasterSeatPopinContent.NONE.equalsMasterSeatPopinContent(seatPopinContent2.getMasterContent(false))) {
            if (this.currentShownContent == null) {
                this.currentShownContent = seatPopinContent;
                return;
            }
            seatPopinContent.setContent(!abstractSeatPopin.isLeft(), this.currentShownContent.getMasterContent(!abstractSeatPopin.isLeft()), this.currentShownContent.getMemoryDetail(!abstractSeatPopin.isLeft()));
            this.currentShownContent = null;
        }
        super.sendShowPopupResponse(seatPopinContent, seatPopinContent2, abstractSeatPopin);
    }

    public void showPartialPopinAfterUpdate(MemorySeatPopin memorySeatPopin) {
        int n = memorySeatPopin.isLeft() ? this.getFactory().getComponent().getFrontLeftHMIPartialPopinID() : this.getFactory().getComponent().getFrontRightHMIPartialPopinID();
        this.setPopinIDCancelBlock(memorySeatPopin.isLeft(), n);
        this.getPopupHandlerController().replaceSeatPopin(memorySeatPopin);
    }

    public void showPartialPopinAfterUpdate(SeatPopin seatPopin) {
        int n = seatPopin.isLeft() ? this.getFactory().getComponent().getFrontLeftMemoryHMIPartialPopinID() : this.getFactory().getComponent().getFrontRightMemoryHMIPartialPopinID();
        this.setPopinIDCancelBlock(seatPopin.isLeft(), n);
        this.getPopupHandlerController().replaceSeatPopin(seatPopin);
    }
}

