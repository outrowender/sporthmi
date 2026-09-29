/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.navdb;

import de.audi.app.navi.evo.navdb.OperationManagerSDCardPopupHandler;
import de.audi.app.navi.evo.navdb.OperationManagerSDCardPopupHandler$1;
import de.audi.app.navi.evo.navdb.OperationManagerSDCardPopupHandler$OperationStatePopupFSM;
import de.audi.app.navi.evo.navdb.OperationManagerSDCardPopupHandler$OperationStatePopupFSM$State;

class OperationManagerSDCardPopupHandler$OperationStatePopupFSM$SDCardPopupShown
extends OperationManagerSDCardPopupHandler$OperationStatePopupFSM$State {
    private final /* synthetic */ OperationManagerSDCardPopupHandler$OperationStatePopupFSM this$1;

    private OperationManagerSDCardPopupHandler$OperationStatePopupFSM$SDCardPopupShown(OperationManagerSDCardPopupHandler$OperationStatePopupFSM operationManagerSDCardPopupHandler$OperationStatePopupFSM) {
        this.this$1 = operationManagerSDCardPopupHandler$OperationStatePopupFSM;
        super(operationManagerSDCardPopupHandler$OperationStatePopupFSM, null);
    }

    @Override
    void enter() {
        OperationManagerSDCardPopupHandler.access$700(OperationManagerSDCardPopupHandler$OperationStatePopupFSM.access$600(this.this$1)).log(-2137614336, "OperationManagerSDCardPopupHandler.SDCardPopupShown#enter()");
        OperationManagerSDCardPopupHandler.access$800(OperationManagerSDCardPopupHandler$OperationStatePopupFSM.access$600(this.this$1));
    }

    @Override
    void confirmPopup() {
        OperationManagerSDCardPopupHandler.access$700(OperationManagerSDCardPopupHandler$OperationStatePopupFSM.access$600(this.this$1)).log(-2137614336, "OperationManagerSDCardPopupHandler.SDCardPopupShown#confirmPopup()");
        OperationManagerSDCardPopupHandler$OperationStatePopupFSM.access$900(this.this$1, this.this$1.popupConfirmed);
    }

    @Override
    void updateOperationState(int n) {
        OperationManagerSDCardPopupHandler.access$700(OperationManagerSDCardPopupHandler$OperationStatePopupFSM.access$600(this.this$1)).log(-2137614336, "OperationManagerSDCardPopupHandler.SDCardPopupShown#updateOperationState() operationState: %1", (long)n);
        if (n == 5) {
            OperationManagerSDCardPopupHandler$OperationStatePopupFSM.access$900(this.this$1, this.this$1.popupHidden);
        }
    }

    /* synthetic */ OperationManagerSDCardPopupHandler$OperationStatePopupFSM$SDCardPopupShown(OperationManagerSDCardPopupHandler$OperationStatePopupFSM operationManagerSDCardPopupHandler$OperationStatePopupFSM, OperationManagerSDCardPopupHandler$1 operationManagerSDCardPopupHandler$1) {
        this(operationManagerSDCardPopupHandler$OperationStatePopupFSM);
    }
}

