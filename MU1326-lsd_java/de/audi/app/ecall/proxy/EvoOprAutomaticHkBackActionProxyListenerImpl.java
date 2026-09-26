/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.ecall.proxy;

import de.audi.app.ecall.core.AbstractEcallComponent;
import de.audi.app.ecall.core.IEcallApplication;
import de.audi.app.ecall.core.ap.IActionProxyListener;
import java.util.Map;

public class EvoOprAutomaticHkBackActionProxyListenerImpl
extends AbstractEcallComponent
implements IActionProxyListener {
    public EvoOprAutomaticHkBackActionProxyListenerImpl(IEcallApplication iEcallApplication) {
        super(iEcallApplication, "App.Ecall.Main");
    }

    @Override
    public void init() {
        this.getApplication().getActionProxyDispatcher().addActionProxyListener(1, this);
    }

    @Override
    public void deinit() {
        this.getApplication().getActionProxyDispatcher().removeActionProxyListener(1, this);
    }

    @Override
    public void actionProxyCallPerformed(int n, Map map) {
        if (n == 1) {
            this.log.log(-2137614336, "EvoOprAutomaticHkBackActionProxyListenerImpl#actionProxyCallPerformed(): ");
            this.getEcallBapServiceAdapter().rejectBreakdownCall();
        }
    }
}

