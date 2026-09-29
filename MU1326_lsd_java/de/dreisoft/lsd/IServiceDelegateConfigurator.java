/*
 * Decompiled with CFR 0.152.
 */
package de.dreisoft.lsd;

import de.dreisoft.lsd.IServiceDelegator;
import java.util.Dictionary;
import org.osgi.framework.ServiceRegistration;

public interface IServiceDelegateConfigurator {
    default public void initConfigurator() {
    }

    default public ServiceRegistration getServiceRegistration(IServiceDelegator iServiceDelegator, String[] stringArray, Object object, Dictionary dictionary) {
    }
}

