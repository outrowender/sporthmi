/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.sim;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.sim.AbstractTelUnlockPresentationHandler;
import de.audi.app.phone.core.sim.AbstractTelUnlockSpellerHandler;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;

class AbstractTelUnlockPresentationHandler$NewPinConfirmationHandler
extends AbstractTelUnlockSpellerHandler {
    private static final int NEW_PIN_CONFIRMATION_NOT_SUCCESSFULL;
    private static final int NEW_PIN_CONFIRMATION_SUCCESSFULL;
    private final ChoiceModelApp pinConfirmationChoice;
    private final /* synthetic */ AbstractTelUnlockPresentationHandler this$0;

    AbstractTelUnlockPresentationHandler$NewPinConfirmationHandler(AbstractTelUnlockPresentationHandler abstractTelUnlockPresentationHandler, ITelApplication iTelApplication, int n, int n2, int n3) {
        this.this$0 = abstractTelUnlockPresentationHandler;
        super(iTelApplication, "NewPinConfirmationHandler", n, n2, 4, 8);
        this.pinConfirmationChoice = this.getChoiceModel(n3);
    }

    @Override
    protected void codeEntered(String string, int n) {
        boolean bl = AbstractTelUnlockPresentationHandler.access$300(this.this$0) != null && AbstractTelUnlockPresentationHandler.access$300(this.this$0).equals(string);
        this.pinConfirmationChoice.setValue(bl ? 0 : 1);
        this.fireEvent(n);
        if (bl) {
            this.log.log(1078071040, "[%1.NewPinConfirmationHandler#codeEntered] code=%2, pin confirmation successfull -> unlock sim with puk %3", (Object)AbstractTelUnlockPresentationHandler.access$000(this.this$0), (Object)string, (Object)AbstractTelUnlockPresentationHandler.access$100(this.this$0));
            this.this$0.unlockSIMWithPUK(AbstractTelUnlockPresentationHandler.access$100(this.this$0), AbstractTelUnlockPresentationHandler.access$300(this.this$0), n);
        } else {
            this.log.log(1078071040, "[%1.NewPinConfirmationHandler#codeEntered] code %2 does not match %3", (Object)AbstractTelUnlockPresentationHandler.access$000(this.this$0), (Object)string, (Object)AbstractTelUnlockPresentationHandler.access$300(this.this$0));
        }
    }
}

