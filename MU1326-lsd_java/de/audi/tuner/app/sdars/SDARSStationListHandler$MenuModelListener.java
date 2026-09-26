/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars;

import de.audi.tuner.app.RadioMenuModelListener;
import de.audi.tuner.app.TunerBasics;
import de.audi.tuner.app.sdars.SDARSStationListHandler;
import de.audi.tuner.app.sdars.SDARSStationListHandler$MenuModelListener$ButtonListener;

class SDARSStationListHandler$MenuModelListener
extends RadioMenuModelListener {
    private boolean cursorIsAt000;
    private final /* synthetic */ SDARSStationListHandler this$0;

    public SDARSStationListHandler$MenuModelListener(SDARSStationListHandler sDARSStationListHandler, TunerBasics tunerBasics, int[] nArray) {
        this.this$0 = sDARSStationListHandler;
        super(tunerBasics, nArray);
        this.cursorIsAt000 = false;
        SDARSStationListHandler.access$1400(sDARSStationListHandler).getChoiceModel(-2088304384).setButtonListener(new SDARSStationListHandler$MenuModelListener$ButtonListener(this, null));
    }

    @Override
    public void itemFocused(int n, int n2, long l, int n3) {
        super.itemFocused(n, n2, l, n3);
        if (n2 == -662175488) {
            boolean bl = this.cursorIsAt000 = n == 1;
            if (this.this$0.focusSet) {
                SDARSStationListHandler.access$1400(this.this$0).getMenuModel(-662175488).resetFocusedItem();
                this.this$0.focusSet = false;
            }
        }
        if (n != 2005401856) {
            SDARSStationListHandler.access$1600(this.this$0, -1);
        }
    }

    static /* synthetic */ boolean access$2300(SDARSStationListHandler$MenuModelListener sDARSStationListHandler$MenuModelListener) {
        return sDARSStationListHandler$MenuModelListener.cursorIsAt000;
    }

    static /* synthetic */ SDARSStationListHandler access$2400(SDARSStationListHandler$MenuModelListener sDARSStationListHandler$MenuModelListener) {
        return sDARSStationListHandler$MenuModelListener.this$0;
    }
}

