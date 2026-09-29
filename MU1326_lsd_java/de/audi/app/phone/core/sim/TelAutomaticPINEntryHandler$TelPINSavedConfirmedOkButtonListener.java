/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.sim;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.model.TelDefaultButtonListener;
import de.audi.app.phone.core.sim.TelAutomaticPINEntryHandler;
import de.audi.app.phone.core.util.TelLoggingUtils;

class TelAutomaticPINEntryHandler$TelPINSavedConfirmedOkButtonListener
extends TelDefaultButtonListener {
    private final /* synthetic */ TelAutomaticPINEntryHandler this$0;

    public TelAutomaticPINEntryHandler$TelPINSavedConfirmedOkButtonListener(TelAutomaticPINEntryHandler telAutomaticPINEntryHandler, ITelApplication iTelApplication) {
        this.this$0 = telAutomaticPINEntryHandler;
        super(iTelApplication, "App.Phone.LockState", -812252160);
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        this.log.log(1078071040, "[TelAutomaticPINEntryHandler.TelPINSavedConfirmedOkButtonListener#keyTyped] %1", (Object)TelLoggingUtils.keyTyped(n, n2, n3));
        this.getButtonModel(n).fireEvent(n3);
    }
}

