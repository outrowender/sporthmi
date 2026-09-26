/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.ap;

import de.audi.app.phone.core.PhoneServiceProvider;
import de.audi.app.phone.core.ap.IActionProxyDispatcher;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;
import java.util.Hashtable;
import org.osgi.framework.BundleContext;

public abstract class AbstractPhoneActionProxyImpl {
    private final IActionProxyDispatcher actionProxyDispatcher;
    private final PhoneServiceProvider apServiceProvider;
    private final LogChannel logChannel;

    public AbstractPhoneActionProxyImpl(IFrameworkAccess iFrameworkAccess, BundleContext bundleContext, IActionProxyDispatcher iActionProxyDispatcher) {
        this.actionProxyDispatcher = iActionProxyDispatcher;
        this.logChannel = this.actionProxyDispatcher.getAPLogChannel();
        this.apServiceProvider = new PhoneServiceProvider(null, this, null, bundleContext, this.logChannel);
    }

    public void init() {
        this.getLogChannel().log(-2137614336, "[AbstractPhoneActionProxyImpl#init] called");
        Hashtable hashtable = new Hashtable(1);
        hashtable.put("moduleID", new Integer(this.getActionProxyInterfaceID()));
        this.apServiceProvider.setServiceClazz(this.getActionProxyInterfaceName());
        this.apServiceProvider.setProperties(hashtable);
        this.apServiceProvider.startService();
    }

    public void deinit() {
        this.getLogChannel().log(-2137614336, "[AbstractPhoneActionProxyImpl#deinit] called");
        this.apServiceProvider.stopService();
    }

    public abstract String getActionProxyInterfaceName() {
    }

    public abstract int getActionProxyInterfaceID() {
    }

    public LogChannel getLogChannel() {
        return this.logChannel;
    }

    public IActionProxyDispatcher getActionProxyDispatcher() {
        return this.actionProxyDispatcher;
    }
}

