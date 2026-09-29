/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.navdb;

import de.audi.app.navi.evo.navdb.OperationManagerSDCardPopupHandler;
import de.audi.app.navi.evo.navdb.OperationManagerSDCardPopupHandler$1;
import de.audi.app.navi.evo.navdb.OperationManagerSDCardPopupHandler$OperationStatePopupFSM;
import de.audi.app.navi.evo.navdb.OperationManagerSDCardPopupHandler$OperationStatePopupFSM$State;

class OperationManagerSDCardPopupHandler$OperationStatePopupFSM$SDCardPopupConfirmed
extends OperationManagerSDCardPopupHandler$OperationStatePopupFSM$State {
    private final /* synthetic */ OperationManagerSDCardPopupHandler$OperationStatePopupFSM this$1;

    private OperationManagerSDCardPopupHandler$OperationStatePopupFSM$SDCardPopupConfirmed(OperationManagerSDCardPopupHandler$OperationStatePopupFSM operationManagerSDCardPopupHandler$OperationStatePopupFSM) {
        this.this$1 = operationManagerSDCardPopupHandler$OperationStatePopupFSM;
        super(operationManagerSDCardPopupHandler$OperationStatePopupFSM, null);
    }

    @Override
    void enter() {
        OperationManagerSDCardPopupHandler.access$700(OperationManagerSDCardPopupHandler$OperationStatePopupFSM.access$600(this.this$1)).log(-2137614336, "OperationManagerSDCardPopupHandler.SDCardPopupConfirmed#enter()");
        OperationManagerSDCardPopupHandler.access$1000(OperationManagerSDCardPopupHandler$OperationStatePopupFSM.access$600(this.this$1));
    }

    /* synthetic */ OperationManagerSDCardPopupHandler$OperationStatePopupFSM$SDCardPopupConfirmed(OperationManagerSDCardPopupHandler$OperationStatePopupFSM operationManagerSDCardPopupHandler$OperationStatePopupFSM, OperationManagerSDCardPopupHandler$1 operationManagerSDCardPopupHandler$1) {
        this(operationManagerSDCardPopupHandler$OperationStatePopupFSM);
    }
}

