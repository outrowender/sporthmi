/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.sim;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.model.TelDefaultButtonListener;
import de.audi.app.phone.core.sim.TelAutomaticPINEntryHandler;

class TelAutomaticPINEntryHandler$TelPinSaveDialogHKBackButtonListener
extends TelDefaultButtonListener {
    private final /* synthetic */ TelAutomaticPINEntryHandler this$0;

    public TelAutomaticPINEntryHandler$TelPinSaveDialogHKBackButtonListener(TelAutomaticPINEntryHandler telAutomaticPINEntryHandler, ITelApplication iTelApplication) {
        this.this$0 = telAutomaticPINEntryHandler;
        super(iTelApplication, "App.Phone.LockState", 446104576);
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        this.log.log(1078071040, "[TelAutomaticPINEntryHandler.TelPinSaveDialogHKBackButtonListener#keyTyped] no modification of automatic PIN entry setting.");
        TelAutomaticPINEntryHandler.access$000(this.this$0);
        this.getButtonModel(446104576).fireEvent(n3);
    }
}

