/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars;

import de.audi.atip.hmi.model.DefaultButtonListener;
import de.audi.atip.hmi.model.menu.focus.FocusAdvice;
import de.audi.tuner.app.sdars.SDARSStationListHandler;
import de.audi.tuner.app.sdars.SDARSStationListHandler$1;
import de.audi.tuner.app.sdars.SDARSStationListHandler$MenuModelListener;

class SDARSStationListHandler$MenuModelListener$ButtonListener
extends DefaultButtonListener {
    private final /* synthetic */ SDARSStationListHandler$MenuModelListener this$1;

    private SDARSStationListHandler$MenuModelListener$ButtonListener(SDARSStationListHandler$MenuModelListener sDARSStationListHandler$MenuModelListener) {
        this.this$1 = sDARSStationListHandler$MenuModelListener;
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        if (SDARSStationListHandler$MenuModelListener.access$2300(this.this$1)) {
            SDARSStationListHandler.access$1400(SDARSStationListHandler$MenuModelListener.access$2400(this.this$1)).getChoiceModel(n).fireEvent(n3);
        } else {
            SDARSStationListHandler.access$1400(SDARSStationListHandler$MenuModelListener.access$2400(this.this$1)).getMenuModel(-662175488).setFocusedItem(1, FocusAdvice.KEEP_POSITION, 1L);
            SDARSStationListHandler$MenuModelListener.access$2400((SDARSStationListHandler$MenuModelListener)this.this$1).focusSet = true;
        }
    }

    /* synthetic */ SDARSStationListHandler$MenuModelListener$ButtonListener(SDARSStationListHandler$MenuModelListener sDARSStationListHandler$MenuModelListener, SDARSStationListHandler$1 sDARSStationListHandler$1) {
        this(sDARSStationListHandler$MenuModelListener);
    }
}

