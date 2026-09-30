/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.nad;

import de.audi.app.phone.core.AbstractPhoneComponent;
import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.dsi.TelDefaultDSIResponseListener;
import de.audi.atip.hmi.model.ButtonListener;

public class TelModulePowerHandler
extends AbstractPhoneComponent
implements ButtonListener {
    public TelModulePowerHandler(ITelApplication iTelApplication) {
        super(iTelApplication, "App.Phone.Main");
    }

    public void init() {
        super.init();
        this.getButtonModel(300306).setButtonListener(this);
        this.getButtonModel(300305).setButtonListener(this);
    }

    public void deinit() {
        super.deinit();
        this.getButtonModel(300306).resetListener();
        this.getButtonModel(300305).resetListener();
    }

    public void keyPressed(int n, int n2, int n3) {
    }

    public void keyReleased(int n, int n2, int n3) {
    }

    public void keyTyped(int n, int n2, int n3) {
        switch (n) {
            case 300306: {
                this.log.log(1000000, "[TelModulePowerHandler#keyTyped] switching on the phone module.");
                this.requestTelModulePower(n, n3, 1);
                break;
            }
            case 300305: {
                this.log.log(1000000, "[TelModulePowerHandler#keyTyped] switching off the phone module.");
                this.requestTelModulePower(n, n3, 0);
                break;
            }
            default: {
                this.log.log(10000000, "[TelModulePowerHandler#keyTyped] no handling for model %1", (long)n);
            }
        }
    }

    private void requestTelModulePower(int n, int n2, int n3) {
        this.getChoiceModel(300901).setStatus(0);
        this.getApplication().getTelephoneDSIAccess().requestTelPower(n3, n2, true, new TelDefaultDSIResponseListener(){

            public void responseTelPower(int n, int n2) {
                TelModulePowerHandler.this.getChoiceModel(300901).setStatus(1);
            }
        });
        this.getButtonModel(n).fireEvent(n2);
    }

    public void keyLongTyped(int n, int n2, int n3) {
    }
}

