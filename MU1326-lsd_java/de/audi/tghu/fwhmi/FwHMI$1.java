/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.fwhmi;

import de.audi.tghu.fwhmi.FwHMI;

class FwHMI$1
implements Runnable {
    private final /* synthetic */ int[] val$slots;
    private final /* synthetic */ int val$terminal;
    private final /* synthetic */ FwHMI this$0;

    FwHMI$1(FwHMI fwHMI, int[] nArray, int n) {
        this.this$0 = fwHMI;
        this.val$slots = nArray;
        this.val$terminal = n;
    }

    @Override
    public void run() {
        for (int i2 = 0; i2 < this.val$slots.length; ++i2) {
            this.this$0.getPartialPopupManager(this.val$terminal).hideAllPopupsAndRepaintScreen(this.val$slots[i2]);
        }
    }

    public String toString() {
        return new StringBuffer().append("RemovePartialPopupFromSlotsRunnable: terminal: ").append(this.val$terminal).toString();
    }
}

