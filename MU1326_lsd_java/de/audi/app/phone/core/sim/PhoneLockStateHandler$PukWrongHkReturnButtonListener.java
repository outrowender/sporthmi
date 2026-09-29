/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.sim;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.model.TelDefaultButtonListener;
import de.audi.app.phone.core.sim.PhoneLockStateHandler;

class PhoneLockStateHandler$PukWrongHkReturnButtonListener
extends TelDefaultButtonListener {
    private final /* synthetic */ PhoneLockStateHandler this$0;

    public PhoneLockStateHandler$PukWrongHkReturnButtonListener(PhoneLockStateHandler phoneLockStateHandler, ITelApplication iTelApplication) {
        this.this$0 = phoneLockStateHandler;
        super(iTelApplication, -1063844864);
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        this.log.log(1078071040, "[PhoneLockStateHandler.PukWrongHkReturnButtonListener#keyTyped]");
        this.this$0.resetPukConditionChoice();
        PhoneLockStateHandler.access$100(this.this$0);
        this.fireEvent(n3);
    }
}

