/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.online.evo;

import de.audi.app.online.evo.HMIViewGridListener;
import de.audi.remotehmi.ui.mib2.grid.IGrid;
import de.audi.remotehmi.ui.mib2.grid.IGridAction;
import de.audi.remotehmi.ui.mib2.grid.IGridCellAction;

class HMIViewGridListener$9
implements IGridAction {
    private final /* synthetic */ boolean val$enabledMedia;
    private final /* synthetic */ boolean val$enabledInfo;
    private final /* synthetic */ IGridCellAction val$cellEnableAction;
    private final /* synthetic */ IGridCellAction val$cellDisableAction;
    private final /* synthetic */ HMIViewGridListener this$0;

    HMIViewGridListener$9(HMIViewGridListener hMIViewGridListener, boolean bl, boolean bl2, IGridCellAction iGridCellAction, IGridCellAction iGridCellAction2) {
        this.this$0 = hMIViewGridListener;
        this.val$enabledMedia = bl;
        this.val$enabledInfo = bl2;
        this.val$cellEnableAction = iGridCellAction;
        this.val$cellDisableAction = iGridCellAction2;
    }

    @Override
    public boolean modify(IGrid iGrid) {
        boolean bl = iGrid.isMedia() ? this.val$enabledMedia : this.val$enabledInfo;
        HMIViewGridListener.access$2000(this.this$0).log(1078071040, "HMIViewGridListener#updateGridListLocking: grid: %1, media: %2, enabled: %3", (Object)iGrid.getId(), (Object)Boolean.toString(iGrid.isMedia()), (Object)Boolean.toString(bl));
        if (iGrid.isBlocking()) {
            if (!bl) {
                iGrid.setDisplayText(iGrid.getBlockingText());
                HMIViewGridListener.access$2100(this.this$0).log(1078071040, "HMIViewGridListener#updateGridListLocking: grid %1, set blocking text: %2", (Object)iGrid.getId(), (Object)iGrid.getBlockingText());
            } else {
                iGrid.setDisplayText(iGrid.getDefaultInfoText());
                HMIViewGridListener.access$2200(this.this$0).log(1078071040, "HMIViewGridListener#updateGridListLocking: grid %1, set default text: %2", (Object)iGrid.getId(), (Object)iGrid.getBlockingText());
            }
            iGrid.setEnabled(bl);
            int n = iGrid.forEachCell(bl ? this.val$cellEnableAction : this.val$cellDisableAction, -129);
            HMIViewGridListener.access$2300(this.this$0).log(1078071040, "HMIViewGridListener#updateGridListLocking: %1 grid cells modified.", (long)n);
            return true;
        }
        return false;
    }
}

