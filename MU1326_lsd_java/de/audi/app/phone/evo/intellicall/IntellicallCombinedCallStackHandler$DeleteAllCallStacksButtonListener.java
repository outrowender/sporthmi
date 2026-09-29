/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo.intellicall;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.model.TelDefaultButtonListener;
import de.audi.app.phone.evo.intellicall.IntellicallCombinedCallStackHandler;

class IntellicallCombinedCallStackHandler$DeleteAllCallStacksButtonListener
extends TelDefaultButtonListener {
    private final /* synthetic */ IntellicallCombinedCallStackHandler this$0;

    public IntellicallCombinedCallStackHandler$DeleteAllCallStacksButtonListener(IntellicallCombinedCallStackHandler intellicallCombinedCallStackHandler, ITelApplication iTelApplication) {
        this.this$0 = intellicallCombinedCallStackHandler;
        super(iTelApplication, -1214905344);
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        this.log.log(1078071040, "[IntellicallCombinedCallStackHandler.DeleteAllCallStacksButtonListener#keyTyped] deleting all call stacks.");
        this.getApplication().getTelephoneDSIAccess().deleteAllCallStacks(3, n3);
        this.fireEvent(n3);
    }
}

