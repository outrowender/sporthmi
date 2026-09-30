/*
 * Decompiled with CFR 0.152.
 */
package de.dreisoft.lsd;

import de.dreisoft.lsd.IServiceDelegator;
import java.util.Dictionary;
import org.osgi.framework.ServiceRegistration;

public interface IServiceDelegateConfigurator {
    public void initConfigurator();

    public ServiceRegistration getServiceRegistration(IServiceDelegator var1, String[] var2, Object var3, Dictionary var4);
}

