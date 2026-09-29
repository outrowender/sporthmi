/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.navdb;

import de.audi.app.navi.evo.navdb.OperationManagerSDCardPopupHandler;
import de.audi.app.navi.evo.navdb.OperationManagerSDCardPopupHandler$1;
import de.audi.app.navi.evo.navdb.OperationManagerSDCardPopupHandler$OperationStatePopupFSM$SDCardPopupConfirmed;
import de.audi.app.navi.evo.navdb.OperationManagerSDCardPopupHandler$OperationStatePopupFSM$SDCardPopupHidden;
import de.audi.app.navi.evo.navdb.OperationManagerSDCardPopupHandler$OperationStatePopupFSM$SDCardPopupShown;
import de.audi.app.navi.evo.navdb.OperationManagerSDCardPopupHandler$OperationStatePopupFSM$State;

class OperationManagerSDCardPopupHandler$OperationStatePopupFSM {
    OperationManagerSDCardPopupHandler$OperationStatePopupFSM$SDCardPopupConfirmed popupConfirmed = new OperationManagerSDCardPopupHandler$OperationStatePopupFSM$SDCardPopupConfirmed(this, null);
    OperationManagerSDCardPopupHandler$OperationStatePopupFSM$SDCardPopupShown popupShown = new OperationManagerSDCardPopupHandler$OperationStatePopupFSM$SDCardPopupShown(this, null);
    OperationManagerSDCardPopupHandler$OperationStatePopupFSM$SDCardPopupHidden popupHidden = new OperationManagerSDCardPopupHandler$OperationStatePopupFSM$SDCardPopupHidden(this, null);
    OperationManagerSDCardPopupHandler$OperationStatePopupFSM$State currentState = this.popupHidden;
    private final /* synthetic */ OperationManagerSDCardPopupHandler this$0;

    private OperationManagerSDCardPopupHandler$OperationStatePopupFSM(OperationManagerSDCardPopupHandler operationManagerSDCardPopupHandler) {
        this.this$0 = operationManagerSDCardPopupHandler;
    }

    public OperationManagerSDCardPopupHandler$OperationStatePopupFSM$State getCurrentState() {
        return this.currentState;
    }

    private void changeState(OperationManagerSDCardPopupHandler$OperationStatePopupFSM$State operationManagerSDCardPopupHandler$OperationStatePopupFSM$State) {
        if (operationManagerSDCardPopupHandler$OperationStatePopupFSM$State == this.currentState) {
            return;
        }
        this.currentState.exit();
        this.currentState = operationManagerSDCardPopupHandler$OperationStatePopupFSM$State;
        this.currentState.enter();
    }

    /* synthetic */ OperationManagerSDCardPopupHandler$OperationStatePopupFSM(OperationManagerSDCardPopupHandler operationManagerSDCardPopupHandler, OperationManagerSDCardPopupHandler$1 operationManagerSDCardPopupHandler$1) {
        this(operationManagerSDCardPopupHandler);
    }

    static /* synthetic */ OperationManagerSDCardPopupHandler access$600(OperationManagerSDCardPopupHandler$OperationStatePopupFSM operationManagerSDCardPopupHandler$OperationStatePopupFSM) {
        return operationManagerSDCardPopupHandler$OperationStatePopupFSM.this$0;
    }

    static /* synthetic */ void access$900(OperationManagerSDCardPopupHandler$OperationStatePopupFSM operationManagerSDCardPopupHandler$OperationStatePopupFSM, OperationManagerSDCardPopupHandler$OperationStatePopupFSM$State operationManagerSDCardPopupHandler$OperationStatePopupFSM$State) {
        operationManagerSDCardPopupHandler$OperationStatePopupFSM.changeState(operationManagerSDCardPopupHandler$OperationStatePopupFSM$State);
    }
}

