/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.navdb;

import de.audi.app.navi.evo.navdb.OperationManagerSDCardPopupHandler$OKButtonlistener;
import de.audi.app.navi.evo.navdb.OperationManagerSDCardPopupHandler$OperationStatePopupFSM;
import de.audi.atip.hmi.model.ButtonModel;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.IOperationManagerSDCardPopupHandler;
import de.audi.tghu.navi.app.NavigationEnv;

public class OperationManagerSDCardPopupHandler
implements IOperationManagerSDCardPopupHandler {
    private final NavigationEnv env;
    private final OperationManagerSDCardPopupHandler$OperationStatePopupFSM popupFSM;
    private final LogChannel log;
    private final ButtonModel okButton;
    private final OperationManagerSDCardPopupHandler$OKButtonlistener okButtonListener;

    public OperationManagerSDCardPopupHandler(NavigationEnv navigationEnv) {
        this.env = navigationEnv;
        this.popupFSM = new OperationManagerSDCardPopupHandler$OperationStatePopupFSM(this, null);
        this.log = navigationEnv.getLogChannel();
        this.okButton = (ButtonModel)navigationEnv.getButtonModel(0, -1558051328);
        this.okButtonListener = new OperationManagerSDCardPopupHandler$OKButtonlistener(this);
        if (this.okButton != null) {
            this.okButton.setButtonListener(this.okButtonListener);
        }
    }

    private void showSDCardRemovedPopup() {
        this.log.log(-2137614336, "OperationManagerSDCardPopupHandler#showSDCardRemovedPopup()");
        this.env.getFramework().getHMIService().showPartialPopup(0, -283441664);
    }

    private void hideSDCardRemovedPopup() {
        this.log.log(-2137614336, "OperationManagerSDCardPopupHandler#hideSDCardRemovedPopup()");
        this.env.getFramework().getHMIService().removePartialPopup(0, -283441664);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void updateOperationState(int n) {
        OperationManagerSDCardPopupHandler$OperationStatePopupFSM operationManagerSDCardPopupHandler$OperationStatePopupFSM = this.popupFSM;
        synchronized (operationManagerSDCardPopupHandler$OperationStatePopupFSM) {
            this.popupFSM.getCurrentState().updateOperationState(n);
        }
    }

    @Override
    public void cleanup() {
        try {
            this.hideSDCardRemovedPopup();
            if (this.okButton != null) {
                this.okButton.resetListener();
            }
        }
        catch (Exception exception) {
            this.log.log(-2137614336, "Problem in OperationManagerSDCardPopupHandler#cleanup() %1", (Throwable)exception);
        }
    }

    static /* synthetic */ OperationManagerSDCardPopupHandler$OperationStatePopupFSM access$100(OperationManagerSDCardPopupHandler operationManagerSDCardPopupHandler) {
        return operationManagerSDCardPopupHandler.popupFSM;
    }

    static /* synthetic */ LogChannel access$700(OperationManagerSDCardPopupHandler operationManagerSDCardPopupHandler) {
        return operationManagerSDCardPopupHandler.log;
    }

    static /* synthetic */ void access$800(OperationManagerSDCardPopupHandler operationManagerSDCardPopupHandler) {
        operationManagerSDCardPopupHandler.showSDCardRemovedPopup();
    }

    static /* synthetic */ void access$1000(OperationManagerSDCardPopupHandler operationManagerSDCardPopupHandler) {
        operationManagerSDCardPopupHandler.hideSDCardRemovedPopup();
    }
}

