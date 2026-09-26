/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.app.hmiswitcher.manager.engineering;

import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;
import de.audi.tghu.swdl.app.hmiswitcher.manager.engineering.AbstractEngineeringSelectionManager;

class AbstractEngineeringSelectionManager$1
implements TimerListener {
    private final /* synthetic */ AbstractEngineeringSelectionManager this$0;

    AbstractEngineeringSelectionManager$1(AbstractEngineeringSelectionManager abstractEngineeringSelectionManager) {
        this.this$0 = abstractEngineeringSelectionManager;
    }

    @Override
    public void fireTimer(Timer timer) {
        try {
            AbstractEngineeringSelectionManager.access$100(this.this$0).getRestartVersionComparisonButton().fireEvent(AbstractEngineeringSelectionManager.access$000(this.this$0).getTerminalId());
            this.this$0.rebootAfterUpload();
            this.this$0.removeSwdlDataDir();
        }
        catch (Exception exception) {
            AbstractEngineeringSelectionManager.access$200(this.this$0).log(10000, "[AbstractEngineeringSelectionManager]versionUploadDone: unexpected timer exception", (Throwable)exception);
        }
    }

    @Override
    public void cancelTimer(Timer timer) {
    }
}

