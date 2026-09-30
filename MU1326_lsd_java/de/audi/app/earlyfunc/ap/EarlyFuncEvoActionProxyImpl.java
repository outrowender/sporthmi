/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.ap;

import de.audi.app.car.common.ap.AbstractCarActionProxyImpl;
import de.audi.app.car.common.ap.IActionProxyDispatcher;
import de.audi.app.earlyfunc.ap.EarlyFuncEvoActionProxyIDs;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.statemachine.ap.EarlyAppsActionProxy;
import java.util.HashMap;
import org.osgi.framework.BundleContext;

public class EarlyFuncEvoActionProxyImpl
extends AbstractCarActionProxyImpl
implements EarlyAppsActionProxy,
EarlyFuncEvoActionProxyIDs {
    public EarlyFuncEvoActionProxyImpl(IFrameworkAccess iFrameworkAccess, BundleContext bundleContext, IActionProxyDispatcher iActionProxyDispatcher) {
        super(iFrameworkAccess, bundleContext, iActionProxyDispatcher);
    }

    public int getActionProxyInterfaceID() {
        return 3;
    }

    public void volumeLoweredEntertainmnetExited(int n) {
    }

    public void carMenusEnteredEarly(int n, boolean bl) {
        this.getLogChannel().log(1000000, "[EarlyFuncEvoActionProxyImpl#carMenusEnteredEarly] entered='%1'", bl);
        HashMap hashMap = new HashMap(1);
        hashMap.put("ENTERED", bl);
        this.getActionProxyDispatcher().notifyActionProxyCall(1, hashMap);
    }

    public void phevGoodbyeEntered(int n, boolean bl) {
        this.getLogChannel().log(1000000, "[EarlyFuncEvoActionProxyImpl#phevGoodbyeEntered] entered='%1'", bl);
        HashMap hashMap = new HashMap(1);
        hashMap.put("ENTERED", bl);
        this.getActionProxyDispatcher().notifyActionProxyCall(2, hashMap);
    }
}

