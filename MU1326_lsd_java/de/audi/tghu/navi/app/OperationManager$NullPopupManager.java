/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app;

import de.audi.tghu.navi.app.IOperationManagerSDCardPopupHandler;
import de.audi.tghu.navi.app.OperationManager;
import de.audi.tghu.navi.app.OperationManager$1;

class OperationManager$NullPopupManager
implements IOperationManagerSDCardPopupHandler {
    private final /* synthetic */ OperationManager this$0;

    private OperationManager$NullPopupManager(OperationManager operationManager) {
        this.this$0 = operationManager;
    }

    @Override
    public void updateOperationState(int n) {
        if (OperationManager.access$100(this.this$0).isDebug2()) {
            OperationManager.access$100(this.this$0).log(14808325, "Nothing to do - OperationManager.NullPopupManager#updateOperationState( %1 ) ", (long)n);
        }
    }

    @Override
    public void cleanup() {
    }

    /* synthetic */ OperationManager$NullPopupManager(OperationManager operationManager, OperationManager$1 operationManager$1) {
        this(operationManager);
    }
}

