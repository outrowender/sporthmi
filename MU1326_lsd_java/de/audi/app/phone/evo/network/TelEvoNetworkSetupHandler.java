/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo.network;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.ap.IActionProxyListener;
import de.audi.app.phone.core.network.TelNetworkSetupHandler;
import de.audi.app.phone.evo.network.TelEvoNetworkSetupHandler$TelOptSetupNetMainLeftListener;
import java.util.Map;

public class TelEvoNetworkSetupHandler
extends TelNetworkSetupHandler
implements IActionProxyListener {
    private static final int ENTERED_VIA_TEL;
    private static final int ENTERED_VIA_CM;

    public TelEvoNetworkSetupHandler(ITelApplication iTelApplication) {
        super(iTelApplication);
        this.addSubPhoneComponent(new TelEvoNetworkSetupHandler$TelOptSetupNetMainLeftListener(this, iTelApplication));
    }

    @Override
    public void init() {
        super.init();
        this.getButtonModel(865534976).setButtonListener(this);
        this.getButtonModel(882312192).setButtonListener(this);
        this.getApplication().getActionProxyDispatcher().addActionProxyListener(31, this);
        this.getApplication().getActionProxyDispatcher().addActionProxyListener(32, this);
    }

    @Override
    public void deinit() {
        super.deinit();
        this.getButtonModel(865534976).resetListener();
        this.getButtonModel(882312192).resetListener();
        this.getApplication().getActionProxyDispatcher().removeActionProxyListener(31, this);
        this.getApplication().getActionProxyDispatcher().removeActionProxyListener(32, this);
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        switch (n) {
            case 300851: {
                this.getChoiceModel(899089408).setValue(1);
                this.getButtonModel(n).fireEvent(n3);
                break;
            }
            case 300852: {
                this.getChoiceModel(899089408).setValue(0);
                this.getButtonModel(n).fireEvent(n3);
                break;
            }
            default: {
                super.keyTyped(n, n2, n3);
            }
        }
    }

    @Override
    public void actionProxyCallPerformed(int n, Map map) {
        if (n == 31) {
            this.setUIRegMode();
            this.cancelNetworkSearch();
        } else if (n == 32) {
            this.cancelNetworkRegistration();
        }
    }

    static /* synthetic */ void access$000(TelEvoNetworkSetupHandler telEvoNetworkSetupHandler) {
        telEvoNetworkSetupHandler.cancelNetworkSearch();
    }
}

