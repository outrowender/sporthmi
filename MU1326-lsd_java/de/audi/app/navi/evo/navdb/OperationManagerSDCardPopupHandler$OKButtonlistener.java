/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.navdb;

import de.audi.app.navi.evo.navdb.OperationManagerSDCardPopupHandler;
import de.audi.app.navi.evo.navdb.OperationManagerSDCardPopupHandler$OperationStatePopupFSM;
import de.audi.atip.hmi.model.ButtonListener;

class OperationManagerSDCardPopupHandler$OKButtonlistener
implements ButtonListener {
    private final /* synthetic */ OperationManagerSDCardPopupHandler this$0;

    OperationManagerSDCardPopupHandler$OKButtonlistener(OperationManagerSDCardPopupHandler operationManagerSDCardPopupHandler) {
        this.this$0 = operationManagerSDCardPopupHandler;
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
    }

    @Override
    public void keyReleased(int n, int n2, int n3) {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void keyTyped(int n, int n2, int n3) {
        if (-1558051328 == n && n3 == 0) {
            OperationManagerSDCardPopupHandler$OperationStatePopupFSM operationManagerSDCardPopupHandler$OperationStatePopupFSM = OperationManagerSDCardPopupHandler.access$100(this.this$0);
            synchronized (operationManagerSDCardPopupHandler$OperationStatePopupFSM) {
                OperationManagerSDCardPopupHandler.access$100(this.this$0).getCurrentState().confirmPopup();
            }
        }
    }

    @Override
    public void keyLongTyped(int n, int n2, int n3) {
    }
}

