/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.ecall.proxy;

import de.audi.app.ecall.core.AbstractEcallComponent;
import de.audi.app.ecall.core.IEcallApplication;
import de.audi.app.ecall.core.ap.IActionProxyListener;
import java.util.Map;

public class SendTestModeSignalToEcall
extends AbstractEcallComponent
implements IActionProxyListener {
    public SendTestModeSignalToEcall(IEcallApplication iEcallApplication) {
        super(iEcallApplication, "App.Ecall.Main");
    }

    @Override
    public void init() {
        this.getApplication().getActionProxyDispatcher().addActionProxyListener(6, this);
    }

    @Override
    public void deinit() {
        this.getApplication().getActionProxyDispatcher().removeActionProxyListener(6, this);
    }

    @Override
    public void actionProxyCallPerformed(int n, Map map) {
        if (n == 6) {
            this.log.log(1078071040, "SendTestModeSignalToEcall#actionProxyCallPerformed(methodID, parameters) --> Called.");
            this.getEcallBapServiceAdapter().startTestMode();
        }
    }
}

