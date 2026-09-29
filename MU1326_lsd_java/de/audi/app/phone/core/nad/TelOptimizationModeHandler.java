/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.nad;

import de.audi.app.phone.core.AbstractPhoneComponent;
import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.state.IGlobalTelephoneStateStruct;
import de.audi.atip.hmi.model.ButtonListener;

public class TelOptimizationModeHandler
extends AbstractPhoneComponent
implements ButtonListener {
    private static final int OPTIMIZATIONMODE_INVALID;
    private static final int OPTIMIZATIONMODE_AUTO;
    private static final int OPTIMIZATIONMODE_TELEPHONE;
    private static final int OPTIMIZATIONMODE_DATA;
    private int optimizationMode;

    public TelOptimizationModeHandler(ITelApplication iTelApplication) {
        super(iTelApplication, "App.Phone.Main");
    }

    @Override
    public void init() {
        super.init();
        this.getButtonModel(1603601408).setButtonListener(this);
        this.getButtonModel(1620378624).setButtonListener(this);
        this.getButtonModel(1637155840).setButtonListener(this);
        this.getApplication().getGlobalTelephoneStateManager().registerListener(this);
    }

    @Override
    public void deinit() {
        super.deinit();
        this.getButtonModel(1603601408).resetListener();
        this.getButtonModel(1620378624).resetListener();
        this.getButtonModel(1637155840).resetListener();
        this.getApplication().getGlobalTelephoneStateManager().removeListener(this);
    }

    @Override
    public void updateGlobalTelephoneStateProperty(int n, IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        super.updateGlobalTelephoneStateProperty(n, iGlobalTelephoneStateStruct);
        if (n == 0x1E000100) {
            this.updateTelephoneOptimizationMode(iGlobalTelephoneStateStruct.getOptimizationMode());
        }
    }

    public void updateTelephoneOptimizationMode(int n) {
        this.log.log(-1601830656, "TelOptimizationModeHandler#updateTelephoneOptimizationMode: optimizationMode=%1", (long)n);
        this.optimizationMode = n;
        int n2 = 0;
        switch (n) {
            case 1: {
                n2 = 1;
                break;
            }
            case 3: {
                n2 = 3;
                break;
            }
            case 0: {
                n2 = 0;
                break;
            }
            case 2: {
                n2 = 2;
                break;
            }
            default: {
                this.log.log(-1601830656, "TelOptimizationModeHandler#updateTelephoneOptimizationMode: No handling for optimization mode %1", (long)n);
            }
        }
        this.getChoiceModel(1586824192).setValue(n2);
        this.getChoiceModel(1402274816).setStatus(1);
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
    }

    @Override
    public void keyReleased(int n, int n2, int n3) {
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        this.log.log(1078071040, "[TelOptimizationModeHandler#keyTyped] model=%1, key=%2, terminal=%3", (long)n, (long)n2, (long)n3);
        int n4 = 0;
        switch (n) {
            case 300383: {
                this.setTelephoneOptimizationMode(1, n3);
                n4 = 1;
                break;
            }
            case 300384: {
                this.setTelephoneOptimizationMode(3, n3);
                n4 = 3;
                break;
            }
            case 300385: {
                this.setTelephoneOptimizationMode(2, n3);
                n4 = 2;
                break;
            }
            default: {
                this.log.log(10000, "TelOptimizationModeHandler#keyTyped: unhandled model ID %1 ", (long)n);
            }
        }
        this.getChoiceModel(1586824192).setValue(n4);
        this.getButtonModel(n).fireEvent(n3);
    }

    @Override
    public void keyLongTyped(int n, int n2, int n3) {
    }

    private void setTelephoneOptimizationMode(int n, int n2) {
        this.log.log(-2137614336, "[TelOptimizationModeHandler#setTelephoneOptimizationMode] Called, optimizationmode: %1", (long)n);
        if (this.optimizationMode != n) {
            this.getChoiceModel(1402274816).setStatus(0);
            this.getApplication().getTelephoneDSIAccess().requestSetOptimizationMode(n, n2);
        } else {
            this.log.log(-2137614336, "[TelOptimizationModeHandler#setTelephoneOptimizationMode] %1 is already active. Not requesting to set it via DSI.", (long)n);
        }
    }
}

