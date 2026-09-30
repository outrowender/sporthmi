/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.NumberSpellerHandlerBase;
import de.audi.app.phone.core.ap.AbstractTelActionProxyListener;
import de.audi.app.phone.core.dsi.TelDefaultDSIResponseListener;
import de.audi.app.phone.core.state.IGlobalTelephoneStateStruct;
import de.audi.app.phone.evo.ITelEvoApplication;
import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.hmi.modelaccess.SpellerModelApp;
import java.util.Map;
import org.dsi.ifc.telephoneng.SuppServiceResponseStruct;

public class ChinaSOSCallSpellerHandler
extends NumberSpellerHandlerBase
implements ButtonListener {
    private IGlobalTelephoneStateStruct state;

    public ChinaSOSCallSpellerHandler(ITelEvoApplication iTelEvoApplication) {
        super(iTelEvoApplication);
        this.addSubPhoneComponent(new ChinaClearNumberSpellerListener(iTelEvoApplication));
    }

    public void init() {
        super.init();
        this.getApplication().getGlobalTelephoneStateManager().registerListener(this);
        this.getButtonModel(301099).setButtonListener(this);
        this.getButtonModel(301099).setStatus(0);
    }

    public void deinit() {
        super.deinit();
        this.getApplication().getGlobalTelephoneStateManager().removeListener(this);
        this.getButtonModel(301099).resetListener();
    }

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
        this.log.log(1000000, "[ChinaSOSCallSpellerHandler#isEnteredEmergencyNumberValid] enteredSOSNumber=%1, enteredEmergencyNumberValid=%2", (Object)string, (Object)(bl3 ? "true" : "false"));
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

    protected SpellerModelApp getSpellerModel() {
        return this.getSpellerModel(301098);
    }

    public void keyTyped(int n, int n2, int n3) {
        if ((n == this.getSpellerModel().getID() || n == 301099) && this.sosNumberValid(this.getSpellerModel().getText())) {
            this.dialSOSNumberInSpeller(n3);
        } else {
            this.getButtonModel(301099).setStatus(0);
            this.getButtonModel(301099).fireEvent(n3);
        }
    }

    private void dialSOSNumberInSpeller(int n) {
        SpellerModelApp spellerModelApp = this.getSpellerModel();
        String string = spellerModelApp.getText();
        if (string != null && string.length() > 0) {
            this.log.log(10000000, "[ChinaSOSCallSpellerHandler#dialSOSNumberInSpeller] dialing SOS number %1", (Object)string);
            this.getApplication().getTelephoneDSIAccess().dialChinaSOSNumber(string, n, true, new TelDefaultDSIResponseListener(){

                public void responseDialNumber(int n, int n2, SuppServiceResponseStruct suppServiceResponseStruct, int n3) {
                    if (n2 != 0) {
                        ChinaSOSCallSpellerHandler.this.clearSpellerContent();
                    }
                }
            });
        } else {
            this.log.log(10000000, "[ChinaSOSCallSpellerHandler#dialSOSNumberInSpeller] no number entered --> NOP!");
        }
    }

    public void keyLongTyped(int n, int n2, int n3) {
    }

    public void textChanged(int n, String string, char c2, int n2) {
        super.textChanged(n, string, c2, n2);
        this.getButtonModel(301099).setStatus(string != null && string.length() > 0 && string.length() <= 40 ? 1 : 0);
    }

    protected void clearSpellerContent() {
        super.clearSpellerContent();
        this.getButtonModel(301099).setStatus(0);
    }

    private class ChinaClearNumberSpellerListener
    extends AbstractTelActionProxyListener {
        public ChinaClearNumberSpellerListener(ITelApplication iTelApplication) {
            super(iTelApplication, "App.Phone.Main", 33);
        }

        protected void actionProxyCalled(Map map) {
            ChinaSOSCallSpellerHandler.this.clearSpellerContent();
        }
    }
}

