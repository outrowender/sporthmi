/*
 * Decompiled with CFR 0.152.
 */
package de.dreisoft.lsd;

import java.util.Dictionary;
import org.osgi.framework.ServiceRegistration;

public interface IServiceDelegator {
    public ServiceRegistration createServiceRegistration(String var1, Object var2, Dictionary var3);

    public ServiceRegistration createServiceRegistration(String[] var1, Object var2, Dictionary var3);
}

