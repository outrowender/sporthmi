/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.ecall.proxy;

import de.audi.app.ecall.core.ap.AbstractEcallActionProxyImpl;
import de.audi.app.ecall.core.ap.IActionProxyDispatcher;
import de.audi.atip.statemachine.ap.EcallActionProxy;
import org.osgi.framework.BundleContext;

public class EcallActionProxyImpl
extends AbstractEcallActionProxyImpl
implements EcallActionProxy {
    static /* synthetic */ Class class$de$audi$atip$statemachine$ActionProxy;

    public EcallActionProxyImpl(BundleContext bundleContext, IActionProxyDispatcher iActionProxyDispatcher) {
        super(bundleContext, iActionProxyDispatcher);
    }

    public String getActionProxyInterfaceName() {
        return (class$de$audi$atip$statemachine$ActionProxy == null ? (class$de$audi$atip$statemachine$ActionProxy = EcallActionProxyImpl.class$("de.audi.atip.statemachine.ActionProxy")) : class$de$audi$atip$statemachine$ActionProxy).getName();
    }

    public int getActionProxyInterfaceID() {
        return 30;
    }

    public void ecallAppEntered(int n) {
        this.getLogChannel().log(1000000, "EcallActionProxyImpl#ecallAppEntered(): terminalID=%1", (long)n);
    }

    public void ecallAppLeft(int n) {
        this.getLogChannel().log(1000000, "EcallActionProxyImpl#ecallAppLeft(): terminalID=%1", (long)n);
    }

    public void hkBackForOprPopupAutomatic(int n) {
        this.getLogChannel().log(1000000, "EcallActionProxyImpl#hkBackForOprPopupAutomatic(): terminalID=%1", (long)n);
        this.getActionProxyDispatcher().notifyActionProxyCall(1);
    }

    public void sysInitPhoneEntered(int n) {
        this.getLogChannel().log(1000000, "EcallActionProxyImpl#sysInitPhoneEntered(): terminalID=%1", (long)n);
        this.getActionProxyDispatcher().notifyActionProxyCall(2);
    }

    public void sysInitPhoneLeft(int n) {
        this.getLogChannel().log(1000000, "EcallActionProxyImpl#sysInitPhoneLeft(): terminalID=%1", (long)n);
        this.getActionProxyDispatcher().notifyActionProxyCall(3);
    }

    public void sysInitConnectEntered(int n) {
        this.getLogChannel().log(1000000, "EcallActionProxyImpl#sysInitConnectEntered(): terminalID=%1", (long)n);
        this.getActionProxyDispatcher().notifyActionProxyCall(4);
    }

    public void sysInitConnectLeft(int n) {
        this.getLogChannel().log(1000000, "EcallActionProxyImpl#sysInitConnectLeft(): terminalID=%1", (long)n);
        this.getActionProxyDispatcher().notifyActionProxyCall(5);
    }

    public void btnPerformTest(int n) {
        this.getLogChannel().log(1000000, "EcallActionProxyImpl#btnPerformTest(): terminalID=%1", (long)n);
        this.getActionProxyDispatcher().notifyActionProxyCall(6);
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

