/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.common.ap;

import de.audi.app.car.common.ap.IActionProxyDispatcher;
import de.audi.app.car.common.service.CarServiceProvider;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;
import java.util.Hashtable;
import org.osgi.framework.BundleContext;

public abstract class AbstractCarActionProxyImpl {
    private final IActionProxyDispatcher actionProxyDispatcher;
    private final CarServiceProvider apServiceProvider;
    private final LogChannel logChannel;
    static /* synthetic */ Class class$de$audi$atip$statemachine$ActionProxy;

    public AbstractCarActionProxyImpl(IFrameworkAccess iFrameworkAccess, BundleContext bundleContext, IActionProxyDispatcher iActionProxyDispatcher) {
        this.actionProxyDispatcher = iActionProxyDispatcher;
        this.logChannel = this.actionProxyDispatcher.getAPLogChannel();
        this.apServiceProvider = new CarServiceProvider(null, this, null, bundleContext, this.logChannel);
        this.apServiceProvider.setServiceClazz((class$de$audi$atip$statemachine$ActionProxy == null ? (class$de$audi$atip$statemachine$ActionProxy = AbstractCarActionProxyImpl.class$("de.audi.atip.statemachine.ActionProxy")) : class$de$audi$atip$statemachine$ActionProxy).getName());
    }

    public void init() {
        this.getLogChannel().log(1078071040, "[AbstractCARActionProxyImpl#init] called");
        Hashtable hashtable = new Hashtable(1);
        hashtable.put("moduleID", new Integer(this.getActionProxyInterfaceID()));
        this.apServiceProvider.setProperties(hashtable);
        this.apServiceProvider.startService();
    }

    public void deinit() {
        this.getLogChannel().log(1078071040, "[AbstractCARActionProxyImpl#deinit] called");
        this.apServiceProvider.stopService();
    }

    public abstract int getActionProxyInterfaceID() {
    }

    public LogChannel getLogChannel() {
        return this.logChannel;
    }

    public IActionProxyDispatcher getActionProxyDispatcher() {
        return this.actionProxyDispatcher;
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

