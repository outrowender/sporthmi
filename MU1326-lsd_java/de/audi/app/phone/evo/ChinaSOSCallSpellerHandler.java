/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo;

import de.audi.app.phone.core.NumberSpellerHandlerBase;
import de.audi.app.phone.core.state.IGlobalTelephoneStateStruct;
import de.audi.app.phone.evo.ChinaSOSCallSpellerHandler$1;
import de.audi.app.phone.evo.ChinaSOSCallSpellerHandler$ChinaClearNumberSpellerListener;
import de.audi.app.phone.evo.ITelEvoApplication;
import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.hmi.modelaccess.SpellerModelApp;

public class ChinaSOSCallSpellerHandler
extends NumberSpellerHandlerBase
implements ButtonListener {
    private IGlobalTelephoneStateStruct state;

    public ChinaSOSCallSpellerHandler(ITelEvoApplication iTelEvoApplication) {
        super(iTelEvoApplication);
        this.addSubPhoneComponent(new ChinaSOSCallSpellerHandler$ChinaClearNumberSpellerListener(this, iTelEvoApplication));
    }

    @Override
    public void init() {
        super.init();
        this.getApplication().getGlobalTelephoneStateManager().registerListener(this);
        this.getButtonModel(731382784).setButtonListener(this);
        this.getButtonModel(731382784).setStatus(0);
    }

    @Override
    public void deinit() {
        super.deinit();
        this.getApplication().getGlobalTelephoneStateManager().removeListener(this);
        this.getButtonModel(731382784).resetListener();
    }

    @Override
    public void updateGlobalTelephoneStateProperty(int n, IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        this.state = iGlobalTelephoneStateStruct;
    }

    private boolean sosNumberValid(String string) {
        if (string == null || string.length() == 0) {
            return false;
        }
        boolean bl = this.isEmergencyCallSupported(this.state);
        boolean bl2 = this.state != null ? this.state.isEmergencyNumberAvailable() : false;
        boolean bl3 = this.state != null ? this.state.isChinaSOSEmergencyNumber(string) : false;
        this.log.log(1078071040, "[ChinaSOSCallSpellerHandler#isEnteredEmergencyNumberValid] enteredSOSNumber=%1, enteredEmergencyNumberValid=%2", (Object)string, (Object)(bl3 ? "true" : "false"));
        return bl && bl2 && bl3;
    }

    private boolean isEmergencyCallSupported(IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        if (iGlobalTelephoneStateStruct != null && iGlobalTelephoneStateStruct.getActivationState() != null) {
            boolean bl = iGlobalTelephoneStateStruct.getPhoneModuleState() == 2;
            boolean bl2 = (iGlobalTelephoneStateStruct.getActivationState().getTelActivationState() == 5 || iGlobalTelephoneStateStruct.getActivationState().getTelActivationState() == 2) && iGlobalTelephoneStateStruct.getLockState() != null && iGlobalTelephoneStateStruct.getLockState().getTelLockState() == 2;
            return bl || bl2;
        }
        return false;
    }

    @Override
    protected SpellerModelApp getSpellerModel() {
        return this.getSpellerModel(714605568);
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        if ((n == this.getSpellerModel().getID() || n == 731382784) && this.sosNumberValid(this.getSpellerModel().getText())) {
            this.dialSOSNumberInSpeller(n3);
        } else {
            this.getButtonModel(731382784).setStatus(0);
            this.getButtonModel(731382784).fireEvent(n3);
        }
    }

    private void dialSOSNumberInSpeller(int n) {
        SpellerModelApp spellerModelApp = this.getSpellerModel();
        String string = spellerModelApp.getText();
        if (string != null && string.length() > 0) {
            this.log.log(-2137614336, "[ChinaSOSCallSpellerHandler#dialSOSNumberInSpeller] dialing SOS number %1", (Object)string);
            this.getApplication().getTelephoneDSIAccess().dialChinaSOSNumber(string, n, true, new ChinaSOSCallSpellerHandler$1(this));
        } else {
            this.log.log(-2137614336, "[ChinaSOSCallSpellerHandler#dialSOSNumberInSpeller] no number entered --> NOP!");
        }
    }

    @Override
    public void keyLongTyped(int n, int n2, int n3) {
    }

    @Override
    public void textChanged(int n, String string, char c2, int n2) {
        super.textChanged(n, string, c2, n2);
        this.getButtonModel(731382784).setStatus(string != null && string.length() > 0 && string.length() <= 40 ? 1 : 0);
    }

    @Override
    protected void clearSpellerContent() {
        super.clearSpellerContent();
        this.getButtonModel(731382784).setStatus(0);
    }
}

