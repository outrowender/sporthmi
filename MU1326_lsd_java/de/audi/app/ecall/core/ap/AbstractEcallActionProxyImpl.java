/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.ecall.core.ap;

import de.audi.app.ecall.core.ap.IActionProxyDispatcher;
import de.audi.app.ecall.core.osgi.EcallServiceProvider;
import de.audi.atip.log.LogChannel;
import java.util.Hashtable;
import org.osgi.framework.BundleContext;

public abstract class AbstractEcallActionProxyImpl {
    private final IActionProxyDispatcher actionProxyDispatcher;
    private final EcallServiceProvider apServiceProvider;
    private final LogChannel logChannel;

    public AbstractEcallActionProxyImpl(BundleContext bundleContext, IActionProxyDispatcher iActionProxyDispatcher) {
        this.actionProxyDispatcher = iActionProxyDispatcher;
        this.logChannel = this.actionProxyDispatcher.getAPLogChannel();
        this.apServiceProvider = new EcallServiceProvider(null, this, null, bundleContext, this.logChannel);
    }

    public void init() {
        this.getLogChannel().log(10000000, "AbstractEcallActionProxyImpl#init(): called");
        Hashtable hashtable = new Hashtable(1);
        hashtable.put("moduleID", new Integer(this.getActionProxyInterfaceID()));
        this.apServiceProvider.setServiceClazz(this.getActionProxyInterfaceName());
        this.apServiceProvider.setProperties(hashtable);
        this.apServiceProvider.startService();
    }

    public void deinit() {
        this.getLogChannel().log(10000000, "AbstractEcallActionProxyImpl#deinit(): called");
        this.apServiceProvider.stopService();
    }

    public abstract String getActionProxyInterfaceName();

    public abstract int getActionProxyInterfaceID();

    public LogChannel getLogChannel() {
        return this.logChannel;
    }

    public IActionProxyDispatcher getActionProxyDispatcher() {
        return this.actionProxyDispatcher;
    }
}

