/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.sim;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.model.TelDefaultChoiceListener;
import de.audi.app.phone.core.sim.TelAutomaticPINEntryHandler;
import de.audi.app.phone.core.util.TelLoggingUtils;

class TelAutomaticPINEntryHandler$TelAutoPinChoiceListener
extends TelDefaultChoiceListener {
    private final /* synthetic */ TelAutomaticPINEntryHandler this$0;

    public TelAutomaticPINEntryHandler$TelAutoPinChoiceListener(TelAutomaticPINEntryHandler telAutomaticPINEntryHandler, ITelApplication iTelApplication) {
        this.this$0 = telAutomaticPINEntryHandler;
        super(iTelApplication, "App.Phone.LockState", -778763264);
    }

    @Override
    public void itemSelected(int n, int n2, int n3, int n4) {
        this.log.log(1078071040, "[TelAutomaticPINEntryHandler.TelAutoPinChoiceListener#itemSelected] %1", (Object)TelLoggingUtils.itemSelectedChoice(n, n2, n3, n4));
        switch (n2) {
            case 0: {
                this.getApplication().getTelephoneDSIAccess().setAutomaticPINEntryActive(false, n4);
                break;
            }
            case 1: {
                this.getApplication().getTelephoneDSIAccess().setAutomaticPINEntryActive(true, n4);
                break;
            }
            default: {
                this.log.log(10000, "TelAutomaticPINEntryHandler.TelAutoPinChoiceListener#itemSelected: Unhandled itemID %1! ", (long)n2);
            }
        }
    }
}

