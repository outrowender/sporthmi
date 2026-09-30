/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo.network;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.ap.AbstractTelActionProxyListener;
import de.audi.app.phone.core.ap.IActionProxyListener;
import de.audi.app.phone.core.network.TelNetworkSetupHandler;
import java.util.Map;

public class TelEvoNetworkSetupHandler
extends TelNetworkSetupHandler
implements IActionProxyListener {
    private static final int ENTERED_VIA_TEL = 0;
    private static final int ENTERED_VIA_CM = 1;

    public TelEvoNetworkSetupHandler(ITelApplication iTelApplication) {
        super(iTelApplication);
        this.addSubPhoneComponent(new TelOptSetupNetMainLeftListener(iTelApplication));
    }

    public void init() {
        super.init();
        this.getButtonModel(300851).setButtonListener(this);
        this.getButtonModel(300852).setButtonListener(this);
        this.getApplication().getActionProxyDispatcher().addActionProxyListener(31, this);
        this.getApplication().getActionProxyDispatcher().addActionProxyListener(32, this);
    }

    public void deinit() {
        super.deinit();
        this.getButtonModel(300851).resetListener();
        this.getButtonModel(300852).resetListener();
        this.getApplication().getActionProxyDispatcher().removeActionProxyListener(31, this);
        this.getApplication().getActionProxyDispatcher().removeActionProxyListener(32, this);
    }

    public void keyTyped(int n, int n2, int n3) {
        switch (n) {
            case 300851: {
                this.getChoiceModel(300853).setValue(1);
                this.getButtonModel(n).fireEvent(n3);
                break;
            }
            case 300852: {
                this.getChoiceModel(300853).setValue(0);
                this.getButtonModel(n).fireEvent(n3);
                break;
            }
            default: {
                super.keyTyped(n, n2, n3);
            }
        }
    }

    public void actionProxyCallPerformed(int n, Map map) {
        if (n == 31) {
            this.setUIRegMode();
            this.cancelNetworkSearch();
        } else if (n == 32) {
            this.cancelNetworkRegistration();
        }
    }

    private class TelOptSetupNetMainLeftListener
    extends AbstractTelActionProxyListener {
        public TelOptSetupNetMainLeftListener(ITelApplication iTelApplication) {
            super(iTelApplication, "App.Phone.Main", 35);
        }

        protected void actionProxyCalled(Map map) {
            this.log.log(1000000, "[TelEvoNetworkSetupHandler.TelOptSetupNetMainLeftListener#actionProxyCalled]");
            TelEvoNetworkSetupHandler.this.cancelNetworkSearch();
        }
    }
}

