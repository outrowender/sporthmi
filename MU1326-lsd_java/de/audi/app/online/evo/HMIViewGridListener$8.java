/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.online.evo;

import de.audi.app.online.evo.HMIViewGridListener;
import de.audi.remotehmi.ui.mib2.grid.IGridCell;
import de.audi.remotehmi.ui.mib2.grid.IGridCellAction;

class HMIViewGridListener$8
implements IGridCellAction {
    private final /* synthetic */ HMIViewGridListener this$0;

    HMIViewGridListener$8(HMIViewGridListener hMIViewGridListener) {
        this.this$0 = hMIViewGridListener;
    }

    @Override
    public boolean modify(IGridCell iGridCell) {
        int n = iGridCell.getType();
        if (n == 0 || n == 5 || n == 4) {
            iGridCell.setEnabled(true);
            return true;
        }
        return false;
    }
}

