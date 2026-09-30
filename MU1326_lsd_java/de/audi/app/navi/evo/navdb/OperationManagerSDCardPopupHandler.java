/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.navdb;

import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.hmi.model.ButtonModel;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.IOperationManagerSDCardPopupHandler;
import de.audi.tghu.navi.app.NavigationEnv;

public class OperationManagerSDCardPopupHandler
implements IOperationManagerSDCardPopupHandler {
    private final NavigationEnv env;
    private final OperationStatePopupFSM popupFSM;
    private final LogChannel log;
    private final ButtonModel okButton;
    private final OKButtonlistener okButtonListener;

    public OperationManagerSDCardPopupHandler(NavigationEnv navigationEnv) {
        this.env = navigationEnv;
        this.popupFSM = new OperationStatePopupFSM();
        this.log = navigationEnv.getLogChannel();
        this.okButton = (ButtonModel)navigationEnv.getButtonModel(0, 402083);
        this.okButtonListener = new OKButtonlistener();
        if (this.okButton != null) {
            this.okButton.setButtonListener(this.okButtonListener);
        }
    }

    private void showSDCardRemovedPopup() {
        this.log.log(10000000, "OperationManagerSDCardPopupHandler#showSDCardRemovedPopup()");
        this.env.getFramework().getHMIService().showPartialPopup(0, 400367);
    }

    private void hideSDCardRemovedPopup() {
        this.log.log(10000000, "OperationManagerSDCardPopupHandler#hideSDCardRemovedPopup()");
        this.env.getFramework().getHMIService().removePartialPopup(0, 400367);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void updateOperationState(int n) {
        OperationStatePopupFSM operationStatePopupFSM = this.popupFSM;
        synchronized (operationStatePopupFSM) {
            this.popupFSM.getCurrentState().updateOperationState(n);
        }
    }

    public void cleanup() {
        try {
            this.hideSDCardRemovedPopup();
            if (this.okButton != null) {
                this.okButton.resetListener();
            }
        }
        catch (Exception exception) {
            this.log.log(10000000, "Problem in OperationManagerSDCardPopupHandler#cleanup() %1", (Throwable)exception);
        }
    }

    class OKButtonlistener
    implements ButtonListener {
        OKButtonlistener() {
        }

        public void keyPressed(int n, int n2, int n3) {
        }

        public void keyReleased(int n, int n2, int n3) {
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void keyTyped(int n, int n2, int n3) {
            if (402083 == n && n3 == 0) {
                OperationStatePopupFSM operationStatePopupFSM = OperationManagerSDCardPopupHandler.this.popupFSM;
                synchronized (operationStatePopupFSM) {
                    OperationManagerSDCardPopupHandler.this.popupFSM.getCurrentState().confirmPopup();
                }
            }
        }

        public void keyLongTyped(int n, int n2, int n3) {
        }
    }

    private class OperationStatePopupFSM {
        SDCardPopupConfirmed popupConfirmed = new SDCardPopupConfirmed();
        SDCardPopupShown popupShown = new SDCardPopupShown();
        SDCardPopupHidden popupHidden = new SDCardPopupHidden();
        State currentState = this.popupHidden;

        private OperationStatePopupFSM() {
        }

        public State getCurrentState() {
            return this.currentState;
        }

        private void changeState(State state) {
            if (state == this.currentState) {
                return;
            }
            this.currentState.exit();
            this.currentState = state;
            this.currentState.enter();
        }

        private class State {
            private State() {
            }

            void enter() {
            }

            void exit() {
            }

            void updateOperationState(int n) {
            }

            void confirmPopup() {
            }
        }

        private class SDCardPopupShown
        extends State {
            private SDCardPopupShown() {
            }

            void enter() {
                OperationManagerSDCardPopupHandler.this.log.log(10000000, "OperationManagerSDCardPopupHandler.SDCardPopupShown#enter()");
                OperationManagerSDCardPopupHandler.this.showSDCardRemovedPopup();
            }

            void confirmPopup() {
                OperationManagerSDCardPopupHandler.this.log.log(10000000, "OperationManagerSDCardPopupHandler.SDCardPopupShown#confirmPopup()");
                OperationStatePopupFSM.this.changeState(OperationStatePopupFSM.this.popupConfirmed);
            }

            void updateOperationState(int n) {
                OperationManagerSDCardPopupHandler.this.log.log(10000000, "OperationManagerSDCardPopupHandler.SDCardPopupShown#updateOperationState() operationState: %1", (long)n);
                if (n == 5) {
                    OperationStatePopupFSM.this.changeState(OperationStatePopupFSM.this.popupHidden);
                }
            }
        }

        private class SDCardPopupHidden
        extends State {
            private SDCardPopupHidden() {
            }

            void enter() {
                OperationManagerSDCardPopupHandler.this.log.log(10000000, "OperationManagerSDCardPopupHandler.SDCardPopupHidden#enter()");
                OperationManagerSDCardPopupHandler.this.hideSDCardRemovedPopup();
            }

            void updateOperationState(int n) {
                OperationManagerSDCardPopupHandler.this.log.log(10000000, "OperationManagerSDCardPopupHandler.SDCardPopupHidden#updateOperationState() operationState: %1", (long)n);
                if (n == 3) {
                    OperationStatePopupFSM.this.changeState(OperationStatePopupFSM.this.popupShown);
                }
            }
        }

        private class SDCardPopupConfirmed
        extends State {
            private SDCardPopupConfirmed() {
            }

            void enter() {
                OperationManagerSDCardPopupHandler.this.log.log(10000000, "OperationManagerSDCardPopupHandler.SDCardPopupConfirmed#enter()");
                OperationManagerSDCardPopupHandler.this.hideSDCardRemovedPopup();
            }
        }
    }
}

