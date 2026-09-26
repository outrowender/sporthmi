/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.sim;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.model.TelDefaultButtonListener;
import de.audi.app.phone.core.sim.AbstractTelUnlockPresentationHandler;

class AbstractTelUnlockPresentationHandler$SavePinButtonListener
extends TelDefaultButtonListener {
    private final /* synthetic */ AbstractTelUnlockPresentationHandler this$0;

    public AbstractTelUnlockPresentationHandler$SavePinButtonListener(AbstractTelUnlockPresentationHandler abstractTelUnlockPresentationHandler, ITelApplication iTelApplication, int n) {
        this.this$0 = abstractTelUnlockPresentationHandler;
        super(iTelApplication, "App.Phone.LockState", n);
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        this.log.log(1078071040, "[%1.SavePinButtonListener#keyTyped]", (Object)AbstractTelUnlockPresentationHandler.access$000(this.this$0));
        this.getApplication().getTelephoneDSIAccess().setAutomaticPINEntryActive(true, n3);
        AbstractTelUnlockPresentationHandler.access$500(this.this$0).setValue(0);
        this.fireEvent(n3);
    }
}

