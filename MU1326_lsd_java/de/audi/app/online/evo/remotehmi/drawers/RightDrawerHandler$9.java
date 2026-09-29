/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.online.evo.remotehmi.drawers;

import de.audi.app.online.evo.remotehmi.drawers.RightDrawerHandler;
import de.audi.remotehmi.ui.mib2.grid.IGridCell;
import de.audi.remotehmi.ui.mib2.grid.IGridCellAction;

class RightDrawerHandler$9
implements IGridCellAction {
    private final /* synthetic */ boolean val$enabled;
    private final /* synthetic */ RightDrawerHandler this$0;

    RightDrawerHandler$9(RightDrawerHandler rightDrawerHandler, boolean bl) {
        this.this$0 = rightDrawerHandler;
        this.val$enabled = bl;
    }

    @Override
    public boolean modify(IGridCell iGridCell) {
        int n = iGridCell.getType();
        if (n == 0 || n == 5 || n == 4) {
            iGridCell.setEnabled(this.val$enabled);
            return true;
        }
        return false;
    }
}

