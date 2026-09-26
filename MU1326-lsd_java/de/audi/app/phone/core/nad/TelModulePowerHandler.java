/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.nad;

import de.audi.app.phone.core.AbstractPhoneComponent;
import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.nad.TelModulePowerHandler$1;
import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;

public class TelModulePowerHandler
extends AbstractPhoneComponent
implements ButtonListener {
    public TelModulePowerHandler(ITelApplication iTelApplication) {
        super(iTelApplication, "App.Phone.Main");
    }

    @Override
    public void init() {
        super.init();
        this.getButtonModel(311755776).setButtonListener(this);
        this.getButtonModel(294978560).setButtonListener(this);
    }

    @Override
    public void deinit() {
        super.deinit();
        this.getButtonModel(311755776).resetListener();
        this.getButtonModel(294978560).resetListener();
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
    }

    @Override
    public void keyReleased(int n, int n2, int n3) {
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        switch (n) {
            case 300306: {
                this.log.log(1078071040, "[TelModulePowerHandler#keyTyped] switching on the phone module.");
                this.requestTelModulePower(n, n3, 1);
                break;
            }
            case 300305: {
                this.log.log(1078071040, "[TelModulePowerHandler#keyTyped] switching off the phone module.");
                this.requestTelModulePower(n, n3, 0);
                break;
            }
            default: {
                this.log.log(-2137614336, "[TelModulePowerHandler#keyTyped] no handling for model %1", (long)n);
            }
        }
    }

    private void requestTelModulePower(int n, int n2, int n3) {
        this.getChoiceModel(1704395776).setStatus(0);
        this.getApplication().getTelephoneDSIAccess().requestTelPower(n3, n2, true, new TelModulePowerHandler$1(this));
        this.getButtonModel(n).fireEvent(n2);
    }

    @Override
    public void keyLongTyped(int n, int n2, int n3) {
    }

    static /* synthetic */ ChoiceModelApp access$000(TelModulePowerHandler telModulePowerHandler, int n) {
        return telModulePowerHandler.getChoiceModel(n);
    }
}

