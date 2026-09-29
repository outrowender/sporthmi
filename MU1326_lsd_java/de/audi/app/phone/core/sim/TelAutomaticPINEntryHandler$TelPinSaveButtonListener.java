/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.sim;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.model.TelDefaultButtonListener;
import de.audi.app.phone.core.sim.TelAutomaticPINEntryHandler;

class TelAutomaticPINEntryHandler$TelPinSaveButtonListener
extends TelDefaultButtonListener {
    private final /* synthetic */ TelAutomaticPINEntryHandler this$0;

    public TelAutomaticPINEntryHandler$TelPinSaveButtonListener(TelAutomaticPINEntryHandler telAutomaticPINEntryHandler, ITelApplication iTelApplication) {
        this.this$0 = telAutomaticPINEntryHandler;
        super(iTelApplication, "App.Phone.LockState", -1047264256);
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        this.log.log(1078071040, "[TelAutomaticPINEntryHandler.TelPinSaveButtonListener#keyTyped] switching PIN-Save setting to on.");
        this.getApplication().getTelephoneDSIAccess().setAutomaticPINEntryActive(true, n3);
        TelAutomaticPINEntryHandler.access$000(this.this$0);
        this.getButtonModel(n).fireEvent(n3);
    }
}

