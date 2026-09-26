/*
 * Decompiled with CFR 0.152.
 */
package de.dreisoft.lsd;

import java.util.Dictionary;
import org.osgi.framework.ServiceRegistration;

public interface IServiceDelegator {
    default public ServiceRegistration createServiceRegistration(String string, Object object, Dictionary dictionary) {
    }

    default public ServiceRegistration createServiceRegistration(String[] stringArray, Object object, Dictionary dictionary) {
    }
}

